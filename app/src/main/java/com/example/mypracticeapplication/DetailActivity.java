package com.example.mypracticeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //设置返回Button
        Button backbt = findViewById(R.id.Back);

        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //set EditText userInput
        EditText userInput = findViewById(R.id.Input);

        //set button of Get KG
        Button kgbt = findViewById(R.id.button_kg);

        //声明一个Spinner
        Spinner spinner_input = (Spinner) findViewById(R.id.spinner_inputUnit);
        Spinner spinner_output = (Spinner) findViewById(R.id.spinner_outputUnit);


        //set button listener
        kgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputValue = userInput.getText().toString();
                String getUnit = spinner_input.getSelectedItem().toString();
                String toUnit = spinner_output.getSelectedItem().toString();
                Intent intent = new Intent(DetailActivity.this, LengthResult.class);
                intent.putExtra("inputValue", inputValue);
                intent.putExtra("getUnit", getUnit);
                intent.putExtra("toUnit", toUnit);
                startActivity(intent);
            }
        });



    }
}