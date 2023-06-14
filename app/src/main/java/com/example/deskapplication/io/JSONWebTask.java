package com.example.deskapplication.io;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.deskapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class JSONWebTask extends AsyncTask<String, String, String> {
    @SuppressLint("StaticFieldLeak")
    BarChart barChart;
    String userId;

    public JSONWebTask(BarChart barChart, String userId) {
        super();
        this.barChart = barChart;
        this.userId = userId; // wird für die mock API nicht benötigt, nur für demo Zwecke hier
    }

    @Override
    protected String doInBackground(String... params) {
        String favouriteDesk = "";
        try {
            // Create URL
            URL endpoint = new URL("https://mocki.io/v1/b453fe04-7b3c-4f55-bb93-3442634e5c92");

            // Create connection
            URLConnection myConnection = endpoint.openConnection();
            myConnection.setRequestProperty("Accept", "application/json");
            InputStream responseBody = myConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(responseBody, "UTF-8");
            JsonReader jsonReader = new JsonReader(inputStreamReader);

            jsonReader.beginObject(); // Start processing the JSON object
            while (jsonReader.hasNext()) { // Loop through all keys
                String key = jsonReader.nextName(); // Fetch the next key
                if (key.equals("loadOfFavouriteDesk")) { // Check if desired key
                    favouriteDesk = jsonReader.nextString();

                    break;
                }
            }

        } catch (Exception ignored) {
            ignored.printStackTrace();

        }

        return favouriteDesk;
    }

    @Override
    protected void onPostExecute(String s) {
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

        ArrayList<BarEntry> entries = new ArrayList<>();
        String title = "Auslastung der Lieblingsräume";
        BarEntry barEntry = new BarEntry(0, Float.parseFloat(s));
        entries.add(barEntry);

        BarDataSet dataSet = new BarDataSet(entries, title);
        dataSet.setColor(Color.parseColor("#154c79"));
        dataSet.setDrawValues(false);
        BarData data = new BarData(dataSet);
        barChart.setData(data);

        barChart.invalidate();
    }
}
