package example.thuya.com.finalproject.SQLitePart;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import static example.thuya.com.finalproject.SQLitePart.DBOpenHelper.ALL_COLUMNS;
import static example.thuya.com.finalproject.SQLitePart.DBOpenHelper.TABLE_USERS;

/**
 * Created by thuyha on 10/10/2016.
 */

public class LoginProvider  extends ContentProvider {

    private static final String AUTHORITY = "example.thuya.com.finalproject.SQLitePart.LoginProvider";
    private static final String BASE_PATH = "users";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    // Constant to identify the requested operation
    private static final int USERS = 1;
    private static final int USER_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static{
        uriMatcher.addURI(AUTHORITY , BASE_PATH, USERS);
        uriMatcher.addURI(AUTHORITY , BASE_PATH + "/#", USER_ID);
    }

    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        DBOpenHelper helper = new DBOpenHelper(getContext());
        database= helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return database.query(TABLE_USERS,DBOpenHelper.ALL_COLUMNS,
                selection,selectionArgs,null,null,sortOrder);
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long id = database.insert(TABLE_USERS, null, contentValues);
        return Uri.parse(BASE_PATH + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        return database.delete(TABLE_USERS,selection, selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        return database.update(TABLE_USERS,contentValues,selection,selectionArgs );
    }




}
