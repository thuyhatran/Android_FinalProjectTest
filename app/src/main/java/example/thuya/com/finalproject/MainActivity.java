package example.thuya.com.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    final public static String ClickedButtonFromMain ="AllObjects";
    private Button b_PickUpObject, b_ListPickUpObjects, b_ListAllObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_PickUpObject = (Button) findViewById(R.id.btt_main_pickup);

        b_ListPickUpObjects = (Button) findViewById(R.id.btt_pickedup_objects);

        b_ListAllObjects = (Button) findViewById(R.id.btt_all_objects);

        b_PickUpObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        b_ListAllObjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DisplayObjectActivity.class);
                intent.putExtra(ClickedButtonFromMain,"AllObjects");
                startActivity(intent);
            }
        });

        b_ListPickUpObjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DisplayObjectActivity.class);
               intent.putExtra(ClickedButtonFromMain,"PickUpObjects");
                startActivity(intent);
            }
        });


    }
}
