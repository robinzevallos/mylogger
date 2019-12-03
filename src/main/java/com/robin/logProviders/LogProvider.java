package com.robin.logProviders;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogProvider {

    protected String GetDataTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return formatter.format(new Date());
    }
}