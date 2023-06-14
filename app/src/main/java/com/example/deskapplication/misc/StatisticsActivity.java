package com.example.deskapplication.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import com.example.deskapplication.R;
import com.example.deskapplication.io.JSONWebTask;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
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

        BarChart barchart = findViewById(R.id.deskLoadBarChart);
        BarChart barChartRoom = findViewById(R.id.roomLoadBarChart);
        BarChart barChartFavouriteDesk = findViewById(R.id.favouriteDeskBarChart);

        Context context = getApplicationContext();
        SharedPreferences pref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);


        if (pref.getBoolean("dataIsSet", false)) {
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("dataIsSet", true);
            editor.putInt("totalLoadDesk1", 60);
            editor.putInt("totalLoadDesk2", 25);
            editor.putInt("totalLoadDesk3", 80);
            editor.putInt("favouriteDesk", 1);
            editor.apply();
        }
        showDeskLoadStatistic(barchart, pref);
        showRoomLoadStatistic(barChartRoom, pref);
        showFavouriteDeskStatistic(barChartFavouriteDesk, pref);
    }

    void showDeskLoadStatistic(BarChart barChart, SharedPreferences preferences) {
        Description desc = new Description();
        desc.setEnabled(false);
        barChart.setDescription(desc);
        barChart.animateY(1000);

        YAxis axisLeft = barChart.getAxisLeft();
        YAxis axisRight = barChart.getAxisRight();
        axisRight.setAxisMaximum(100f);
        axisLeft.setAxisMaximum(100f);
        axisRight.setAxisMinimum(0f);
        axisLeft.setAxisMinimum(0f);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawAxisLine(false);

        ArrayList<Double> valueList = new ArrayList<Double>();
        ArrayList<BarEntry> entries = new ArrayList<>();
        String title = "Auslastung der Desks";
        valueList.add((double) preferences.getInt("totalLoadDesk1", 0));
        valueList.add((double) preferences.getInt("totalLoadDesk2", 0));
        valueList.add((double) preferences.getInt("totalLoadDesk3", 0));
        for (int i = 0; i < valueList.size(); i++) {
            BarEntry barEntry = new BarEntry(i, valueList.get(i).floatValue());
            entries.add(barEntry);
        }
        BarDataSet dataSet = new BarDataSet(entries, title);
        dataSet.setColor(Color.parseColor("#154c79"));
        dataSet.setDrawValues(false);
        BarData data = new BarData(dataSet);
        barChart.setData(data);

        barChart.invalidate();
    }

    void showRoomLoadStatistic(BarChart barChart, SharedPreferences preferences) {
        Description desc = new Description();
        desc.setEnabled(false);
        barChart.setDescription(desc);
        barChart.animateY(1000);

        YAxis axisLeft = barChart.getAxisLeft();
        YAxis axisRight = barChart.getAxisRight();
        axisRight.setAxisMaximum(100f);
        axisLeft.setAxisMaximum(100f);
        axisRight.setAxisMinimum(0f);
        axisLeft.setAxisMinimum(0f);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawAxisLine(false);

        ArrayList<Double> valueList = new ArrayList<Double>();
        ArrayList<BarEntry> entries = new ArrayList<>();
        String title = "Auslastung des gesamten Raumes";
        valueList.add((double) preferences.getInt("totalLoadDesk1", 0));
        valueList.add((double) preferences.getInt("totalLoadDesk2", 0));
        valueList.add((double) preferences.getInt("totalLoadDesk3", 0));
        Double averageDeskLoad = valueList.stream().mapToDouble(Double::doubleValue).sum() / valueList.size();
        BarEntry barEntry = new BarEntry(0, averageDeskLoad.floatValue());
        entries.add(barEntry);

        BarDataSet dataSet = new BarDataSet(entries, title);
        dataSet.setColor(Color.parseColor("#154c79"));
        dataSet.setDrawValues(false);
        BarData data = new BarData(dataSet);
        barChart.setData(data);

        barChart.invalidate();
    }

    void showFavouriteDeskStatistic(BarChart barChart, SharedPreferences preferences) {
        JSONWebTask task = new JSONWebTask(barChart, "1");
        task.execute();
    }


}