package com.urbandroid.sleep.trial.eu.locators;

import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes4.dex */
public class TelephonyLocator implements ILocator {
    private String getCountry(TelephonyManager telephonyManager) throws Exception {
        String countryFromSim = getCountryFromSim(telephonyManager);
        if (isValid(countryFromSim)) {
            return countryFromSim;
        }
        String countryFromNetwork = getCountryFromNetwork(telephonyManager);
        if (isValid(countryFromNetwork)) {
            return countryFromNetwork;
        }
        throw new Exception("No country code found");
    }

    private String getCountryFromNetwork(TelephonyManager telephonyManager) {
        if (telephonyManager.getPhoneType() == 2) {
            return null;
        }
        return telephonyManager.getNetworkCountryIso();
    }

    private String getCountryFromSim(TelephonyManager telephonyManager) {
        return telephonyManager.getSimCountryIso();
    }

    private boolean isValid(String str) {
        return str != null && str.length() == 2;
    }

    @Override // com.urbandroid.sleep.trial.eu.locators.ILocator
    public String getCountry(Context context) {
        try {
            return getCountry((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return null;
        }
    }
}
