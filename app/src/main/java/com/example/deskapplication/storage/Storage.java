package com.example.deskapplication.storage;

import android.content.SharedPreferences;

public class Storage {
    private SharedPreferences preferences;
    public Storage(SharedPreferences pref) {
        this.preferences = pref;
    }

    public double getDeskStatistic(String desk) {
        int totalSpaces = preferences.getInt("totalSpacesDesk" + desk, 0);
        int numberOfReservations = preferences.getInt("reservedTimesDesk" + desk, 0);
        return ((double)numberOfReservations/totalSpaces) ;
    }
}
