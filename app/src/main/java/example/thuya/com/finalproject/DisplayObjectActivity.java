package example.thuya.com.finalproject;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import example.thuya.com.finalproject.Fragments.AllObjectsFragment;
import example.thuya.com.finalproject.Fragments.PickUpObjectsFragment;

public class DisplayObjectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_object);

        Intent intent = getIntent();
        String clickedButton = intent.getStringExtra(MainActivity.ClickedButtonFromMain);

        Toast.makeText(getApplicationContext(),clickedButton,Toast.LENGTH_SHORT).show();

        if (clickedButton.equals("AllObjects")){

            getFragmentManager().beginTransaction()
                    .add(R.id.list_container, new AllObjectsFragment())
                    //.addToBackStack("f1")
                    .commit();

        }else{

            getFragmentManager().beginTransaction()
                    .add(R.id.list_container, new PickUpObjectsFragment())
                    //.addToBackStack("f2")
                    .commit();

        }



    }
}
