package com.aplav.anish.pendown.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.aplav.anish.pendown.Database.DatabaseHandler;
import com.aplav.anish.pendown.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WritingActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText writtenText;
    TextView givenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd MMM YY");
        String formattedDate = df.format(c.getTime());
        getSupportActionBar().setTitle(formattedDate);
        database = DatabaseHandler.getInstance(this);
        writtenText = (EditText) findViewById(R.id.write_text);
        givenText = (TextView) findViewById(R.id.given_text);
        Cursor cursor = database.rawQuery("Select * from allstory where date ='" + formattedDate + "'", null);
        if (!(cursor.moveToFirst()) || cursor.getCount() == 0) {
            //cursor is empty
        } else {

            while (cursor.moveToNext()) {
                givenText.setText(cursor.getString(1));
            }
        }
    }
}

