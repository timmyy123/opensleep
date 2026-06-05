package com.urbandroid.sleep.trial.eu.locators;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import com.urbandroid.common.logging.Logger;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationLocator implements ILocator {
    private String getCountry(Context context, LocationManager locationManager) throws IOException {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(0);
        criteria.setPowerRequirement(0);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(false);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (bestProvider == null) {
            return null;
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
        if (lastKnownLocation == null) {
            Logger.logWarning("getLastKnownLocation is null");
            return null;
        }
        List<Address> fromLocation = new Geocoder(context).getFromLocation(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), 1);
        if (fromLocation.isEmpty()) {
            return null;
        }
        return fromLocation.get(0).getCountryCode();
    }

    @Override // com.urbandroid.sleep.trial.eu.locators.ILocator
    public String getCountry(Context context) {
        try {
            return getCountry(context, (LocationManager) context.getSystemService("location"));
        } catch (Exception e) {
            Logger.logWarning("Failed to get location from location locator.", e);
            return null;
        }
    }
}
