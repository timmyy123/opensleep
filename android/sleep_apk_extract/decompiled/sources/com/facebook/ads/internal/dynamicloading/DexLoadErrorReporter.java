package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import oauth.signpost.OAuth;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DexLoadErrorReporter {
    private static final String LOGGING_URL = "https://www.facebook.com/adnw_logging/";
    public static final double SAMPLING = 0.1d;
    private static final AtomicBoolean sAlreadyReported = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    public static void addEnvFields(Context context, JSONObject jSONObject, String str) throws JSONException, PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        jSONObject.put("APPBUILD", context.getPackageManager().getPackageInfo(packageName, 0).versionCode);
        jSONObject.put("APPNAME", context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(packageName, 0)));
        jSONObject.put("APPVERS", context.getPackageManager().getPackageInfo(packageName, 0).versionName);
        jSONObject.put("OSVERS", Build.VERSION.RELEASE);
        jSONObject.put("SDK", "android");
        jSONObject.put("SESSION_ID", str);
        jSONObject.put("MODEL", Build.MODEL);
        jSONObject.put("BUNDLE", packageName);
        jSONObject.put("SDK_VERSION", BuildConfigApi.getVersionName(context));
        jSONObject.put("OS", "Android");
    }

    public static void reportDexLoadingIssue(final Context context, final String str, double d) {
        AtomicBoolean atomicBoolean = sAlreadyReported;
        if (atomicBoolean.get() || Math.random() >= d) {
            return;
        }
        atomicBoolean.set(true);
        new Thread() { // from class: com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.1
            /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(3:74|3|(7:92|4|5|82|6|90|7))|(12:78|8|9|(4:11|88|12|95)(1:94)|16|76|39|(2:84|41)|(2:72|46)|(1:96)|26|52)|17|86|18|19|68|22|26|52|(1:(0))) */
            /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|74|3|(7:92|4|5|82|6|90|7)|(12:78|8|9|(4:11|88|12|95)(1:94)|16|76|39|(2:84|41)|(2:72|46)|(1:96)|26|52)|17|86|18|19|68|22|26|52|(1:(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0143, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0144, code lost:
            
                r2 = "Can't close connection.";
                r3 = com.facebook.ads.AudienceNetworkAds.TAG;
                android.util.Log.e(r3, r2, r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x014f, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0150, code lost:
            
                android.util.Log.e(r3, r2, r0);
             */
            /* JADX WARN: Removed duplicated region for block: B:72:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:84:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str2;
                String str3;
                DataOutputStream dataOutputStream;
                HttpURLConnection httpURLConnection;
                InputStream inputStream;
                String string;
                DataOutputStream dataOutputStream2;
                byte[] bArr;
                ByteArrayOutputStream byteArrayOutputStream;
                InputStream inputStream2;
                super.run();
                try {
                    httpURLConnection = (HttpURLConnection) new URL(DexLoadErrorReporter.LOGGING_URL).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                        httpURLConnection.setRequestProperty("Accept", "application/json");
                        httpURLConnection.setRequestProperty("Accept-Charset", OAuth.ENCODING);
                        httpURLConnection.setRequestProperty("user-agent", "[FBAN/AudienceNetworkForAndroid;FBSN/Android]");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.connect();
                        String string2 = UUID.randomUUID().toString();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("attempt", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        DexLoadErrorReporter.addEnvFields(context, jSONObject, string2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("subtype", "generic");
                        jSONObject2.put("subtype_code", "1320");
                        jSONObject2.put("caught_exception", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        jSONObject2.put("stacktrace", str);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("id", UUID.randomUUID().toString());
                        jSONObject3.put("type", "debug");
                        StringBuilder sb = new StringBuilder("");
                        try {
                            sb.append(System.currentTimeMillis() / 1000);
                            jSONObject3.put("session_time", sb.toString());
                            jSONObject3.put("time", "" + (System.currentTimeMillis() / 1000));
                            jSONObject3.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, string2);
                            jSONObject3.put("data", jSONObject2);
                            jSONObject3.put("attempt", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            DexLoadErrorReporter.addEnvFields(context, jSONObject2, string2);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(jSONObject3);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("data", jSONObject);
                            jSONObject4.put("events", jSONArray);
                            string = jSONObject4.toString();
                            dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                        } catch (Throwable th) {
                            th = th;
                            str2 = "Can't close connection.";
                            str3 = AudienceNetworkAds.TAG;
                            dataOutputStream = null;
                            inputStream = null;
                            try {
                                Log.e(str3, "Can't send error.", th);
                                if (dataOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection == null) {
                                }
                                httpURLConnection.disconnect();
                            } finally {
                            }
                        }
                        try {
                            dataOutputStream2.writeBytes("payload=" + URLEncoder.encode(string, OAuth.ENCODING));
                            dataOutputStream2.flush();
                            bArr = new byte[16384];
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream2 = httpURLConnection.getInputStream();
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = "Can't close connection.";
                            str3 = AudienceNetworkAds.TAG;
                            dataOutputStream = dataOutputStream2;
                            inputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = "Can't close connection.";
                        str3 = AudienceNetworkAds.TAG;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str2 = "Can't close connection.";
                    str3 = AudienceNetworkAds.TAG;
                    dataOutputStream = null;
                    httpURLConnection = null;
                }
                while (true) {
                    try {
                        int i = inputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        try {
                            byteArrayOutputStream.write(bArr, 0, i);
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = inputStream2;
                            str2 = "Can't close connection.";
                            str3 = AudienceNetworkAds.TAG;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str2 = "Can't close connection.";
                        str3 = AudienceNetworkAds.TAG;
                        inputStream = inputStream2;
                    }
                    dataOutputStream = dataOutputStream2;
                    Log.e(str3, "Can't send error.", th);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e) {
                            Log.e(str3, str2, e);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            Log.e(str3, str2, e2);
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
                byteArrayOutputStream.flush();
                dataOutputStream2.close();
                String str4 = "Can't close connection.";
                String str5 = AudienceNetworkAds.TAG;
                inputStream2.close();
                httpURLConnection.disconnect();
            }
        }.start();
    }
}
