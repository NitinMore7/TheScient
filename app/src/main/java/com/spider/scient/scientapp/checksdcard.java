package com.spider.scient.scientapp;

import android.os.Environment;

public class checksdcard {
    public boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }
}
