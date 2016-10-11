package example.thuya.com.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.thuya.com.finalproject.SQLitePart.DBOpenHelper;

import static example.thuya.com.finalproject.SQLitePart.LoginProvider.CONTENT_URI;

public class LoginActivity extends Activity {

    private Button b_Login;
    private Button b_LinkToRegister;
    private EditText inputUserName;
    private EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUserName = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);
        b_Login = (Button) findViewById(R.id.btnLogin);
        b_LinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        b_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = inputUserName.getText().toString();
                String password = inputPassword.getText().toString();

                //If name and password are correct, then play game
                if (isExistedUser("name=? and password=?",new String[] { name, password })){
                    Toast.makeText(getApplicationContext(), "Enjoy Game!",Toast.LENGTH_LONG).show();

                   Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }else {
                    Toast.makeText(getApplicationContext(), "Invalid user or password!",Toast.LENGTH_LONG).show();
                }

            }
        });

        b_LinkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


    public boolean isExistedUser( String selection, String[] selectionArgs ){
        //Cursor findEntry = database.query(DBOpenHelper.TABLE_USERS, DBOpenHelper.ALL_COLUMNS, "name=? and password=?", new String[] { name, password }, null, null, null);
        Cursor findEntry = getContentResolver().query(CONTENT_URI, DBOpenHelper.ALL_COLUMNS, selection, selectionArgs, null);

        return  findEntry.getCount()>0;
    }



}
