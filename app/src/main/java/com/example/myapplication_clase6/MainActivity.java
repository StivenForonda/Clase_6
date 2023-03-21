package com.example.myapplication_clase6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button saveButton;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name_edit_text);
        saveButton = findViewById(R.id.save_button);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveName();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        String name = sharedPreferences.getString("name", "");
        nameEditText.setText(name);
    }


    private void saveName() {
        String name = nameEditText.getText().toString().trim();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.apply();
    }
}