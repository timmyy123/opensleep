package com.urbandroid.sleep.service.health;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public enum HealthDataSourceProvider implements DataSourceProvider {
    GOOGLE("com.google.android.apps.fitness"),
    SLEEP("com.urbandroid.sleep"),
    RUNTASTIC("com.runtastic.android.sleepbetter.lite"),
    WITHINGS("com.withings.wiscale2"),
    FITBIT("com.fitbit.FitbitMobile"),
    JAWBONE("com.jawbone.up"),
    PLEXFIT("com.bidusoft.plexfit"),
    SAMSUNG("com.samsung.shealth"),
    SAMSUNG_APP("com.sec.android.app.shealth"),
    HEALTH_SYNC("nl.appyhapps.healthsync"),
    SLEEPBOT("com.lslk.sleepbot"),
    HEALTH_CONNECT("com.google.android.apps.healthdata");

    private final String packageName;

    HealthDataSourceProvider(String str) {
        this.packageName = str;
    }

    public static DataSourceProvider find(final String str) {
        int i;
        int iIndexOf;
        for (HealthDataSourceProvider healthDataSourceProvider : values()) {
            if (healthDataSourceProvider.getPackageName().equals(str)) {
                return healthDataSourceProvider;
            }
        }
        final AtomicReference atomicReference = new AtomicReference(str);
        int iIndexOf2 = str.indexOf(46);
        if (iIndexOf2 != -1 && (iIndexOf = str.indexOf(46, (i = iIndexOf2 + 1))) != -1) {
            atomicReference.set(str.substring(i, iIndexOf));
        }
        return new DataSourceProvider() { // from class: com.urbandroid.sleep.service.health.HealthDataSourceProvider.1
            @Override // com.urbandroid.sleep.service.health.DataSourceProvider
            public String getPackageName() {
                return str;
            }

            public String toString() {
                return "Unknown: " + str;
            }
        };
    }

    @Override // com.urbandroid.sleep.service.health.DataSourceProvider
    public String getPackageName() {
        return this.packageName;
    }
}
