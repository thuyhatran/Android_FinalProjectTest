package example.thuya.com.finalproject.SQLitePart;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static example.thuya.com.finalproject.SQLitePart.LoginProvider.CONTENT_URI;

/**
 * Created by thuyha on 09/10/2016.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    //Constants for db name and version
    private static final String DATABASE_NAME = "login.db";
    private static final int DATABASE_VERSION = 1;

    //Constants for identifying table and columns
    public static final String TABLE_USERS = "users";
    public static final String USER_ID = "_id";
    public static final String USER_NAME = "name";
    public static final String USER_PASS = "password";
    public static final String USER_EMAIL = "email";

    public static final String[] ALL_COLUMNS ={USER_ID, USER_NAME, USER_PASS,USER_EMAIL};

    //SQL to create table
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    USER_NAME + " TEXT, " +
                    USER_PASS + " TEXT, " +
                    USER_EMAIL + " TEXT " +
                    ")";

    public DBOpenHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(sqLiteDatabase);

    }



}
