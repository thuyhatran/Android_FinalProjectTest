package example.thuya.com.finalproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.thuya.com.finalproject.SQLitePart.DBOpenHelper;
import example.thuya.com.finalproject.SQLitePart.LoginProvider;

import static example.thuya.com.finalproject.SQLitePart.DBOpenHelper.TABLE_USERS;
import static example.thuya.com.finalproject.SQLitePart.LoginProvider.CONTENT_URI;


public class RegisterActivity extends AppCompatActivity {


    private Button b_Register;
    private EditText regUserName;
    private EditText regEmail;
    private EditText regPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regUserName = (EditText) findViewById(R.id.username);
        regEmail = (EditText) findViewById(R.id.email);
        regPassword = (EditText) findViewById(R.id.password);
        b_Register = (Button) findViewById(R.id.btnRegister);

        b_Register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String name = regUserName.getText().toString();
                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();

               // if (isExistedUser("name=? and password=?",new String[] { name, password })){
                if (isExistedUser("name=? ",new String[] { name })){
                    Toast.makeText(getApplicationContext(), "User already existed",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "New User Added. Enjoy game!",Toast.LENGTH_LONG).show();
                    //Create a new user
                    addUser(name, email, password);

                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    //finish();

                }

            }
        });

    }

    public void addUser(String name, String email, String password) {

        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.USER_NAME,name);
        values.put(DBOpenHelper.USER_EMAIL,email);
        values.put(DBOpenHelper.USER_PASS,password);

        Uri userUri = getContentResolver().insert(CONTENT_URI,values);
        Log.d("RegisterActivity","Insert User" + userUri.getEncodedQuery());

    }


    public boolean isExistedUser( String selection, String[] selectionArgs ){
        //Cursor findEntry = database.query(DBOpenHelper.TABLE_USERS, DBOpenHelper.ALL_COLUMNS, "name=? and password=?", new String[] { name, password }, null, null, null);
        Cursor findEntry = getContentResolver().query(CONTENT_URI, DBOpenHelper.ALL_COLUMNS, selection, selectionArgs, null);

        return  findEntry.getCount()>0;
    }





}
