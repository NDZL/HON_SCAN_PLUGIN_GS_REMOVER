package com.ndzl.honplugin.gsremover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Set;


public class DataEditing extends BroadcastReceiver {

    public String prefix;

    public DataEditing() {
        prefix="HEX={d2500}";
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String ScanResult = intent.getStringExtra("data");//Read the scan result from the Intent
        Bundle bundle = new Bundle();

        final String GROUP_SEPARATOR = Character.toString( (char)29 ) ;

        String plainPrintableScanResult = ScanResult
                .replace(GROUP_SEPARATOR, "")
                .replace(".", "")
                .replace(",", "");

        bundle.putString("data", plainPrintableScanResult);

        setResultExtras(bundle);
    }

}
