package com.aplav.anish.pendown.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anish on 22-01-2017.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static SQLiteDatabase databaseInstance = null;

    public static void initInstance(Context context) {
        if (databaseInstance == null)
            databaseInstance = new DatabaseHandler(context).getDatabase();
    }

    public static SQLiteDatabase getInstance(Context context) {
        if (databaseInstance == null)
            databaseInstance = new DatabaseHandler(context).getDatabase();

        return databaseInstance;
    }




    private SQLiteDatabase getDatabase() {
        return this.getWritableDatabase();
    }
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "StoryData";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS allstory( date TEXT PRIMARY KEY, givenstory TEXT, writtenstory TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS allstory");
        // Create tables again
        onCreate(sqLiteDatabase);
    }
}
