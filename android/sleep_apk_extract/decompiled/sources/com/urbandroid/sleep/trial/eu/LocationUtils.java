package com.urbandroid.sleep.trial.eu;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.work.ListenableFutureKt$$ExternalSyntheticLambda0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.trial.eu.locators.ApiLocator;
import com.urbandroid.sleep.trial.eu.locators.ILocator;
import com.urbandroid.sleep.trial.eu.locators.LocationLocator;
import com.urbandroid.sleep.trial.eu.locators.TelephonyLocator;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LocationUtils {
    private static final List<ILocator> LOCATORS = Arrays.asList(new TelephonyLocator(), new LocationLocator(), new ApiLocator());

    public interface CountryCallback {
    }

    public static String resolveCountry(Context context) {
        String country = null;
        for (ILocator iLocator : LOCATORS) {
            try {
                country = iLocator.getCountry(context);
            } catch (Exception e) {
                Logger.logSevere(e);
                Logger.logInfo("Country not detected using ".concat(iLocator.getClass().getSimpleName()));
            }
            if (!TextUtils.isEmpty(country)) {
                String lowerCase = country.toLowerCase();
                Logger.logInfo("Country detected using " + iLocator.getClass().getSimpleName() + ": " + lowerCase);
                return lowerCase;
            }
        }
        Logger.logInfo("Country not detected.");
        return country;
    }

    public static void updateCountryAsync(final Context context) {
        final Settings settings = new Settings(context);
        if (settings.isTimeToUpdateCountry()) {
            new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.trial.eu.LocationUtils.1
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    String strResolveCountry = LocationUtils.resolveCountry(context);
                    if (strResolveCountry == null) {
                        return null;
                    }
                    settings.setCountry(strResolveCountry);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void updateCountryAsyncCallback(final Context context, final CountryCallback countryCallback) {
        final Settings settings = new Settings(context);
        if (settings.getCountryNull() == null) {
            new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.trial.eu.LocationUtils.2
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    String strResolveCountry = LocationUtils.resolveCountry(context);
                    if (strResolveCountry == null) {
                        return null;
                    }
                    settings.setCountry(strResolveCountry);
                    ((ListenableFutureKt$$ExternalSyntheticLambda0) countryCallback).onCountryResolved(strResolveCountry);
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            ((ListenableFutureKt$$ExternalSyntheticLambda0) countryCallback).onCountryResolved(settings.getCountry());
        }
    }
}
