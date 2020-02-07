package com.example.workspace.tracking;

import android.util.Log;

import javax.inject.Inject;

public class Tracker {
    @Inject
    public Tracker(){}

    public void track() {
        Log.d("DAGGER", this.toString());
    }
}
