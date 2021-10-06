package com.example.mypracticeapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LengthResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_result);

        //get the intent extra from DetailActivity
        String inputValue = getIntent().getStringExtra("inputValue");
        String getUnit = getIntent().getStringExtra("getUnit");
        String toUnit = getIntent().getStringExtra("toUnit");

        //define TextView by id
        TextView originalEntry = findViewById(R.id.original_entry);
        TextView desiredNumberAndConvertUnit = findViewById(R.id.results);

        //define button and set listener
        Button backMain = findViewById(R.id.back_main);
        Button backDetail = findViewById(R.id.back_detail);

        backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainBack = new Intent(LengthResult.this, MainActivity.class);
                startActivity(mainBack);
            }
        });
        backDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailBack = new Intent(LengthResult.this, DetailActivity.class);
                startActivity(detailBack);
            }
        });

        //calculate and convert
        double resultToShow = calculate(inputValue, getUnit, toUnit);
        //set result value to TextView
        setFinalResult(inputValue, getUnit, toUnit, originalEntry, desiredNumberAndConvertUnit, resultToShow);
    }

    private void setFinalResult(String inputValue, String getUnit, String toUnit, TextView originalEntry, TextView desiredNumberAndConvertUnit, double resultToShow) {
        String originalEntryToString = "you entered: " + inputValue + getUnit;
        String desiredThingsToString = "equals to: " + resultToShow + toUnit;

        if (resultToShow >= 0) {
            originalEntry.setText(originalEntryToString);
            desiredNumberAndConvertUnit.setText(desiredThingsToString);
        } else {
            originalEntry.setText(R.string.wrongWarning);
            desiredNumberAndConvertUnit.setText(R.string.wrongWarning);
        }
    }

    private double calculate(String inputValue, @NonNull String getUnit, String toUnit) {
        //计算过程（返回结果）
        double inputValueInDouble = Double.parseDouble(inputValue);
        double kgValue;
        switch (getUnit) {
            case "mg":
                kgValue = inputValueInDouble / 1000000;
                break;
            case "G":
                kgValue = inputValueInDouble / 1000;
                break;
            case "KG":
                kgValue = inputValueInDouble;
                break;
            case "T":
                kgValue = inputValueInDouble * 1000;
                break;
            default:
                kgValue = -1;
        }
        switch (toUnit) {
            case "mg":
                return kgValue * 1000000;
            case "G":
                return kgValue * 1000;
            case "KG":
                return kgValue;
            case "T":
                return kgValue / 1000;
            default:
                return -1;
        }
    }


}