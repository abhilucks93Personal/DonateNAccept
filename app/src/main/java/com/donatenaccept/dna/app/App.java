package com.donatenaccept.dna.app;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.donatenaccept.dna.citiesAutoComplete.managers.ContentManager;
import com.donatenaccept.dna.citiesAutoComplete.rest.RestClientManager;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;


@ReportsCrashes(mailTo = "abhilucks93@gmail.com", customReportContent = {
        ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME,
        ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL,
        ReportField.CUSTOM_DATA, ReportField.STACK_TRACE},
        mode = ReportingInteractionMode.SILENT)

public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
        RestClientManager.init(getApplicationContext());
        ContentManager.init(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}