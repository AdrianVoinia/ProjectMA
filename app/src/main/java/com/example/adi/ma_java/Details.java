package com.example.adi.ma_java;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String genre = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_TWO);
        System.out.println(name);
        System.out.println(genre);

        // Capture the layout's TextView and set the string as its text
        final EditText nameText = (EditText) findViewById(R.id.movieName);
        nameText.setText(name);

        final EditText genreText = (EditText) findViewById(R.id.movieGenre);
        genreText.setText(genre);

        final Button button = (Button) findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent output = new Intent();
                output.putExtra("Name", nameText.getText().toString());
                output.putExtra("Genre", genreText.getText().toString());
                setResult(RESULT_OK, output);
                finish();
            }
        });
    }
}
