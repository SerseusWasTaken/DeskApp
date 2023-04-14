package com.example.deskapplication.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.deskapplication.MainActivity;
import com.example.deskapplication.MainMenuActivity;
import com.example.deskapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Button mainMenuButton = findViewById(R.id.backToMainMenuButton);
        mainMenuButton.setOnClickListener(view -> finish());

        BarChart barchart = findViewById(R.id.barChart_view);
        showBarChart(barchart);

        Context context = getApplicationContext();
        SharedPreferences pref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("chartTitle","Statistiken");
        editor.putInt("totalSpacesMonthDesk1", 60);
        editor.putInt("reservedTimesMonthDesk1", 24);

        editor.apply();
    }

    void showBarChart(BarChart barchart) {
        ArrayList<Double> valueList = new ArrayList<Double>();
        ArrayList<BarEntry> entries = new ArrayList<>();
        String title = "Title";
        for (int i = 0; i < 6; i++) {
            valueList.add(i * 100.1);
        }
        for (int i = 0; i < valueList.size(); i++) {
            BarEntry barEntry = new BarEntry(i, valueList.get(i).floatValue());
            entries.add(barEntry);
        }
        BarDataSet dataSet = new BarDataSet(entries, title);
        BarData data = new BarData(dataSet);
        barchart.setData(data);
        barchart.invalidate();
    }
}