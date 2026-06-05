package com.urbandroid.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.facebook.internal.AnalyticsEvents;
import com.urbandroid.common.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Environment {
    private static volatile Integer apiLevel;
    private static volatile String cachedImei;
    private static volatile String cpuAbi;
    private static final X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static volatile Boolean isDebugCertificate = null;
    private static Map<String, Boolean> writeableCache = new HashMap();

    private static boolean canCreateFile(File file) {
        try {
            File file2 = new File(file, "directory-writable-test");
            try {
                file2.createNewFile();
                return file2.delete();
            } catch (IOException unused) {
                Logger.logInfo("Cannot create file at: " + file);
                return false;
            }
        } catch (Exception unused2) {
            return false;
        }
    }

    public static int getAPILevel() {
        int i;
        if (apiLevel == null) {
            try {
                i = Build.VERSION.class.getField("SDK_INT").getInt(null);
            } catch (IllegalAccessException unused) {
                i = Integer.parseInt(Build.VERSION.SDK);
            } catch (IllegalArgumentException unused2) {
                i = Integer.parseInt(Build.VERSION.SDK);
            } catch (NoSuchFieldException unused3) {
                i = Integer.parseInt(Build.VERSION.SDK);
            } catch (SecurityException unused4) {
                i = Integer.parseInt(Build.VERSION.SDK);
            }
            apiLevel = Integer.valueOf(i);
        }
        return apiLevel.intValue();
    }

    public static String getCountryCode(Context context) {
        String countryCodeFromSim;
        String country = TimeZoneCountryMap.getCountry(TimeZone.getDefault().getID());
        if (country == null) {
            country = getCountryCodeFromSim(context);
        } else if ((country.equals("DE") || country.equals("NL")) && (countryCodeFromSim = getCountryCodeFromSim(context)) != null && (countryCodeFromSim.equals("DE") || countryCodeFromSim.equals("NL"))) {
            country = countryCodeFromSim;
        }
        return country == null ? Locale.getDefault().getCountry() : country;
    }

    private static String getCountryCodeFromSim(Context context) {
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        return simCountryIso != null ? simCountryIso.toUpperCase() : simCountryIso;
    }

    public static String getCpuAbi() {
        if (cpuAbi == null) {
            try {
                cpuAbi = Build.CPU_ABI.toLowerCase();
            } catch (Throwable unused) {
                cpuAbi = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
        }
        if (cpuAbi == null) {
            cpuAbi = "NULL";
        }
        return cpuAbi;
    }

    public static String getCurrentProcessName(Context context) {
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String getDocumentsFolder() {
        try {
            return (String) android.os.Environment.class.getField("DIRECTORY_DOCUMENTS").get(null);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
            return "Documents";
        }
    }

    public static File getExternalPublicWriteableStorage() {
        File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
        return (!isKitKatOrGreater() || isWritable(externalStorageDirectory)) ? externalStorageDirectory : android.os.Environment.getExternalStoragePublicDirectory(getDocumentsFolder());
    }

    public static String getImei(Context context) {
        if (cachedImei == null) {
            try {
                cachedImei = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Throwable unused) {
                return null;
            }
        }
        return cachedImei;
    }

    public static String getManufacturer() {
        try {
            return (String) Build.class.getField("MANUFACTURER").get(null);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
            return "UNK";
        }
    }

    public static boolean isGingerOrGreater() {
        return getAPILevel() > 8;
    }

    public static boolean isHoneycombOrGreater() {
        return getAPILevel() > 10;
    }

    public static boolean isIcsOrGreater() {
        return getAPILevel() >= 14;
    }

    public static boolean isJellyBean43OrGreater() {
        return getAPILevel() > 17;
    }

    public static boolean isJellyBeanWithAirplaneRootHack() {
        return getAPILevel() == 16 || getAPILevel() == 17;
    }

    public static boolean isKitKatOrGreater() {
        return getAPILevel() >= 19;
    }

    public static boolean isLollipopOrGreater() {
        return getAPILevel() >= 21;
    }

    public static boolean isMOrGreater() {
        return getAPILevel() >= 23;
    }

    public static boolean isNOrGreater() {
        return getAPILevel() >= 24;
    }

    public static boolean isNewJellyBeanOrGreater() {
        return getAPILevel() > 16;
    }

    public static Boolean isScreenOn(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        try {
            return (Boolean) powerManager.getClass().getMethod("isScreenOn", null).invoke(powerManager, null);
        } catch (Exception e) {
            Logger.logInfo("Cannot fetch screen state", e);
            return null;
        }
    }

    public static synchronized boolean isWritable(File file) {
        if (writeableCache.containsKey(file.getAbsolutePath())) {
            return writeableCache.get(file.getAbsolutePath()).booleanValue();
        }
        boolean z = file.exists() && file.canRead() && file.canWrite() && canCreateFile(file);
        writeableCache.put(file.getAbsolutePath(), Boolean.valueOf(z));
        return z;
    }
}
