package com.urbandroid.sleep.trial.eu.locators;

import android.content.Context;
import com.urbandroid.common.util.InputStreamUtil;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ApiLocator implements ILocator {
    private String getCountry() throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://ip-api.com/json").openConnection();
            try {
                String string = new JSONObject(InputStreamUtil.read(httpURLConnection.getInputStream())).getString("countryCode");
                httpURLConnection.disconnect();
                return string;
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    @Override // com.urbandroid.sleep.trial.eu.locators.ILocator
    public String getCountry(Context context) {
        try {
            return getCountry();
        } catch (Exception unused) {
            return null;
        }
    }
}
