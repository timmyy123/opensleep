package com.samsung.android.sdk.healthdata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.healthdata.IHealth;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;
import com.samsung.android.sdk.internal.healthdata.IpcUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes4.dex */
public class HealthDataStore {
    private static String b = "com.sec.android.app.shealth";
    private static String g = null;
    private static long h = 0;
    private static long j = 60000;
    private final ConnectionListener c;
    private IHealth d;
    private final Context e;
    private final b f = new b(this);
    private Boolean i = null;
    private long k = j;
    HealthResultHolder<HealthResultHolder.BaseResult> a = null;
    private final ServiceConnection l = new ServiceConnection() { // from class: com.samsung.android.sdk.healthdata.HealthDataStore.2
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Bundle connectionResult2;
            int i;
            Log.d("HealthDataStore", "Service for HealthDataStore is connected");
            HealthDataStore.this.d = IHealth.Stub.asInterface(iBinder);
            Bundle bundle = new Bundle();
            bundle.putString("packageName", HealthDataStore.this.e.getPackageName());
            bundle.putInt("clientVersion", 1003001);
            if (HealthDataStore.this.e instanceof Activity) {
                bundle.putInt("userPasswordInputMode", 0);
            } else {
                bundle.putInt("userPasswordInputMode", 1);
            }
            try {
                int iB = HealthDataStore.this.b();
                HealthDataStore healthDataStore = HealthDataStore.this;
                connectionResult2 = iB >= 4600000 ? healthDataStore.d.getConnectionResult2(bundle) : healthDataStore.d.getConnectionResult(HealthDataStore.this.e.getPackageName(), 1003001);
            } catch (RemoteException unused) {
                if (HealthDataStore.this.c != null) {
                    HealthDataStore.this.c.onConnectionFailed(new HealthConnectionErrorResult(0, false));
                    HealthDataStore.this.a = null;
                }
                connectionResult2 = null;
            }
            if (connectionResult2 != null) {
                i = connectionResult2.getInt("result", 0);
                String unused2 = HealthDataStore.g = connectionResult2.getString("socketKey");
                long unused3 = HealthDataStore.h = connectionResult2.getLong("myUserId", 0L);
            } else {
                i = 0;
            }
            if (i == -3) {
                Log.d("HealthDataStore", "User password popup is required");
                Message message = new Message();
                message.what = i;
                message.setData(connectionResult2);
                HealthDataStore.this.f.sendMessageDelayed(message, 2L);
            } else if (i != -2) {
                if (i == -1) {
                    if (HealthDataStore.this.c != null) {
                        HealthDataStore.this.c.onConnected();
                        HealthDataStore.this.a = null;
                        return;
                    }
                    return;
                }
                Log.d("HealthDataStore", "HealthConnectionErrorResult code : " + i);
                HealthDataStore.this.disconnectService();
                HealthDataStore.this.f.sendEmptyMessageDelayed(i, 2L);
                return;
            }
            try {
                HealthDataStore healthDataStore2 = HealthDataStore.this;
                HealthDataStore.a(healthDataStore2, healthDataStore2.k);
            } catch (RemoteException unused4) {
                if (HealthDataStore.this.c != null) {
                    HealthDataStore.this.c.onConnectionFailed(new HealthConnectionErrorResult(0, false));
                    HealthDataStore.this.a = null;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            Log.d("HealthDataStore", "Service for HealthDataStore is disconnected");
            HealthDataStore.this.d = null;
            if (HealthDataStore.this.c != null) {
                HealthDataStore.this.c.onDisconnected();
                HealthDataStore.this.a = null;
            }
        }
    };

    public interface ConnectionListener {
        void onConnected();

        void onConnectionFailed(HealthConnectionErrorResult healthConnectionErrorResult);

        void onDisconnected();
    }

    public static class b extends Handler {
        private final WeakReference<HealthDataStore> a;

        public b(HealthDataStore healthDataStore) {
            this.a = new WeakReference<>(healthDataStore);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            HealthDataStore healthDataStore = this.a.get();
            if (healthDataStore == null) {
                return;
            }
            int i = message.what;
            if (i != -3) {
                if (i == 5) {
                    HealthResultHolder<HealthResultHolder.BaseResult> healthResultHolder = healthDataStore.a;
                    if (healthResultHolder == null) {
                        return;
                    }
                    healthResultHolder.cancel();
                    healthDataStore.a = null;
                    Log.i("HealthDataStore", "Init ResultHolder is canceled by time out");
                }
                HealthDataStore.a(healthDataStore, message.what);
                return;
            }
            String string = message.getData().getString("pincode_activity_pkg");
            String string2 = message.getData().getString("pincode_activity_class");
            Intent intent = new Intent();
            intent.addFlags(4194304);
            intent.putExtra("type", 1);
            intent.setComponent(new ComponentName(string, string2));
            Log.i("HealthDataStore", "Pop up PinCode activity pkg = " + string + ", classname = " + string2);
            try {
                if (!(healthDataStore.e instanceof Activity)) {
                    intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                }
                healthDataStore.e.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Log.i("HealthDataStore", "Only this app cannot access with this " + e.getMessage());
            }
        }
    }

    public HealthDataStore(Context context, ConnectionListener connectionListener) {
        this.e = context;
        this.c = connectionListener;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || !"dev".equalsIgnoreCase(bundle.getString("com.samsung.android.health.platform_type"))) {
                return;
            }
            b = "com.samsung.android.sdkapp.health";
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
        }
    }

    private static boolean a(URL url) throws Throwable {
        XmlPullParser xmlPullParserNewPullParser;
        InputStream inputStreamOpenStream;
        InputStream inputStream = null;
        try {
            xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            inputStreamOpenStream = url.openStream();
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            xmlPullParserNewPullParser.setInput(inputStreamOpenStream, null);
            String text = "";
            boolean z = false;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 2) {
                    String name = xmlPullParserNewPullParser.getName();
                    if ("appId".equals(name)) {
                        if (xmlPullParserNewPullParser.next() == 4) {
                            xmlPullParserNewPullParser.getText();
                        }
                    } else if ("resultCode".equals(name)) {
                        if (xmlPullParserNewPullParser.next() == 4) {
                            text = xmlPullParserNewPullParser.getText();
                        }
                    } else if ("resultMsg".equals(name)) {
                        if (xmlPullParserNewPullParser.next() == 4) {
                            xmlPullParserNewPullParser.getText();
                        }
                    } else if ("version".equals(name)) {
                        if (xmlPullParserNewPullParser.next() == 4) {
                            xmlPullParserNewPullParser.getText();
                        }
                    } else if ("versionCode".equals(name) && xmlPullParserNewPullParser.next() == 4) {
                        String.format("%010d", Integer.valueOf(Integer.parseInt(xmlPullParserNewPullParser.getText())));
                    }
                }
                if (eventType == 3 && xmlPullParserNewPullParser.getName().equals("appInfo")) {
                    z = "2".equals(text) || AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(text);
                }
            }
            if (inputStreamOpenStream != null) {
                try {
                    inputStreamOpenStream.close();
                } catch (IOException unused2) {
                }
            }
            return z;
        } catch (Exception unused3) {
            inputStream = inputStreamOpenStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        PackageManager packageManager = this.e.getPackageManager();
        if (packageManager == null) {
            return -1;
        }
        try {
            return packageManager.getPackageInfo("com.sec.android.app.shealth", 128).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() throws Throwable {
        StringBuilder sbM;
        TelephonyManager telephonyManager;
        String strF;
        TelephonyManager telephonyManager2;
        String simOperator;
        if (this.e == null) {
            return false;
        }
        Boolean bool = this.i;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strSubstring = Build.MODEL;
        if (strSubstring.startsWith("OMAP_SS")) {
            strSubstring = d();
        }
        if (strSubstring.startsWith("SAMSUNG-")) {
            strSubstring = strSubstring.substring(8);
        }
        StringBuilder sbM2 = Fragment$$ExternalSyntheticOutline1.m("http://hub.samsungapps.com/product/appCheck.as?appInfo=com.sec.android.app.shealth@0&deviceId=".concat(strSubstring), "&mnc=");
        Context context = this.e;
        String strSubstring2 = "";
        sbM2.append((context == null || (telephonyManager2 = (TelephonyManager) context.getSystemService("phone")) == null || (simOperator = telephonyManager2.getSimOperator()) == null || simOperator.length() == 0) ? "" : simOperator.substring(3));
        StringBuilder sbM3 = Fragment$$ExternalSyntheticOutline1.m(sbM2.toString(), "&csc=");
        sbM3.append((!e() || (strF = f()) == null || strF.equalsIgnoreCase("FAIL")) ? "" : strF.substring(0, 3));
        StringBuilder sbM4 = Fragment$$ExternalSyntheticOutline1.m(sbM3.toString(), "&openApi=");
        sbM4.append(String.valueOf(Build.VERSION.SDK_INT));
        String string = sbM4.toString();
        if (new File("mnt/sdcard/pd.test").exists()) {
            sbM = FileInsert$$ExternalSyntheticOutline0.m(string.concat("&pd=1"));
            strSubstring2 = "&mcc=000";
        } else {
            sbM = Fragment$$ExternalSyntheticOutline1.m(string.concat("&pd="), "&mcc=");
            Context context2 = this.e;
            if (context2 != null && (telephonyManager = (TelephonyManager) context2.getSystemService("phone")) != null) {
                String simOperator2 = telephonyManager.getSimOperator();
                if (telephonyManager.getPhoneType() != 0) {
                    String simOperator3 = telephonyManager.getSimOperator();
                    if (simOperator3 != null && simOperator3.length() != 0) {
                        strSubstring2 = simOperator3.substring(0, 3);
                    }
                } else if (simOperator2 != null && simOperator2.length() != 0) {
                    strSubstring2 = simOperator2.substring(0, 3);
                }
            }
        }
        sbM.append(strSubstring2);
        String string2 = sbM.toString();
        Log.d("HealthDataStore", "Server URL : ".concat(string2));
        try {
            boolean zA = a(new URL(string2));
            this.i = Boolean.valueOf(zA);
            return zA;
        } catch (MalformedURLException unused) {
            this.i = Boolean.FALSE;
            return false;
        }
    }

    private static String d() throws IOException {
        File file = new File("/system/version");
        String str = "";
        if (file.isFile()) {
            byte[] bArr = new byte[128];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    int i = fileInputStream.read(bArr);
                    if (i > 0) {
                        str = new String(bArr, 0, i);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
                fileInputStream.close();
            } catch (FileNotFoundException | IOException unused3) {
            }
        }
        return str;
    }

    private static boolean e() {
        try {
            return new File("/system/csc/sales_code.dat").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private static String f() throws Throwable {
        FileInputStream fileInputStream;
        File file = new File("/system/csc/sales_code.dat");
        String str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        if (file.isFile()) {
            byte[] bArr = new byte[20];
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str = fileInputStream.read(bArr) > 0 ? new String(bArr) : "FAIL";
                } catch (IOException unused) {
                    if (fileInputStream != null) {
                    }
                    return str;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                fileInputStream.close();
            } catch (IOException unused4) {
            }
        }
        return str;
    }

    public static IHealth getInterface(HealthDataStore healthDataStore) {
        if (healthDataStore == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("HealthDataStore is null");
            return null;
        }
        IHealth iHealth = healthDataStore.d;
        if (iHealth != null) {
            return iHealth;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Health data service is not connected");
        return null;
    }

    public static long getMyUserId() {
        return h;
    }

    public static String getPlatformPackageName() {
        return b;
    }

    public static String getSocketKey() {
        return g;
    }

    public void connectService(long j2) {
        if (this.e == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Context is not specified(null)");
            return;
        }
        if (!HealthDataService.a) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("HealthDataService is not initialized correctly");
            return;
        }
        if (!"com.samsung.android.sdkapp.health".equals(b)) {
            try {
                PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(b, 64);
                if (!b.equals(this.e.getPackageName())) {
                    try {
                        if (!a(packageInfo.signatures)) {
                            this.f.sendEmptyMessageDelayed(8, 2L);
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("HealthDataStore", e.toString());
                        this.f.sendEmptyMessageDelayed(8, 2L);
                        return;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.f.sendEmptyMessageDelayed(2, 2L);
                return;
            } catch (Exception e2) {
                throw new IllegalStateException("Context is not valid. " + e2.toString());
            }
        }
        Intent intent = new Intent("com.samsung.android.sdk.healthdata.IHealthDataStore");
        intent.setPackage(b);
        try {
            if (this.e.bindService(intent, this.l, 65)) {
                this.k = j2;
                return;
            }
            try {
                PackageInfo packageInfo2 = this.e.getPackageManager().getPackageInfo(b, 128);
                if (packageInfo2.versionCode < 4000000) {
                    this.f.sendEmptyMessageDelayed(4, 2L);
                    return;
                }
                boolean z = packageInfo2.applicationInfo.enabled;
                b bVar = this.f;
                if (z) {
                    bVar.sendEmptyMessageDelayed(1, 2L);
                } else {
                    bVar.sendEmptyMessageDelayed(6, 2L);
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                this.f.sendEmptyMessageDelayed(2, 2L);
            } catch (Exception e3) {
                throw new IllegalStateException("Context is not valid. " + e3.toString());
            }
        } catch (Exception e4) {
            throw new IllegalStateException("Context is not valid. " + e4.toString());
        }
    }

    public void disconnectService() {
        Context context = this.e;
        if (context != null) {
            try {
                context.unbindService(this.l);
            } catch (IllegalArgumentException | NullPointerException unused) {
                Log.e("HealthDataStore", "disconnectService: Context instance is invalid");
            }
        }
    }

    public class a extends AsyncTask<Void, Void, Boolean> {
        private final int a;

        private a(int i) {
            this.a = i;
        }

        @Override // android.os.AsyncTask
        public final /* synthetic */ Boolean doInBackground(Void[] voidArr) {
            return Boolean.valueOf(HealthDataStore.this.c());
        }

        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Boolean bool) {
            Boolean bool2 = bool;
            if (HealthDataStore.this.c != null) {
                HealthConnectionErrorResult healthConnectionErrorResult = new HealthConnectionErrorResult(this.a, bool2 == null ? false : bool2.booleanValue());
                healthConnectionErrorResult.setPackageManager(HealthDataStore.this.e.getPackageManager());
                HealthDataStore.this.c.onConnectionFailed(healthConnectionErrorResult);
            }
        }

        public /* synthetic */ a(HealthDataStore healthDataStore, int i, byte b) {
            this(i);
        }
    }

    private static boolean a(Signature[] signatureArr) {
        Signature signature = new Signature("308204d4308203bca003020102020900e5eff0a8f66d92b3300d06092a864886f70d01010505003081a2310b3009060355040613024b52311430120603550408130b536f757468204b6f726561311330110603550407130a5375776f6e2043697479311c301a060355040a131353616d73756e6720436f72706f726174696f6e310c300a060355040b1303444d43311530130603550403130c53616d73756e6720436572743125302306092a864886f70d0109011616616e64726f69642e6f734073616d73756e672e636f6d301e170d3131303632323132323531335a170d3338313130373132323531335a3081a2310b3009060355040613024b52311430120603550408130b536f757468204b6f726561311330110603550407130a5375776f6e2043697479311c301a060355040a131353616d73756e6720436f72706f726174696f6e310c300a060355040b1303444d43311530130603550403130c53616d73756e6720436572743125302306092a864886f70d0109011616616e64726f69642e6f734073616d73756e672e636f6d30820120300d06092a864886f70d01010105000382010d00308201080282010100e9f1edb42423201dce62e68f2159ed8ea766b43a43d348754841b72e9678ce6b03d06d31532d88f2ef2d5ba39a028de0857983cd321f5b7786c2d3699df4c0b40c8d856f147c5dc54b9d1d671d1a51b5c5364da36fc5b0fe825afb513ec7a2db862c48a6046c43c3b71a1e275155f6c30aed2a68326ac327f60160d427cf55b617230907a84edbff21cc256c628a16f15d55d49138cdf2606504e1591196ed0bdc25b7cc4f67b33fb29ec4dbb13dbe6f3467a0871a49e620067755e6f095c3bd84f8b7d1e66a8c6d1e5150f7fa9d95475dc7061a321aaf9c686b09be23ccc59b35011c6823ffd5874d8fa2a1e5d276ee5aa381187e26112c7d5562703b36210b020103a382010b30820107301d0603551d0e041604145b115b23db35655f9f77f78756961006eebe3a9e3081d70603551d230481cf3081cc80145b115b23db35655f9f77f78756961006eebe3a9ea181a8a481a53081a2310b3009060355040613024b52311430120603550408130b536f757468204b6f726561311330110603550407130a5375776f6e2043697479311c301a060355040a131353616d73756e6720436f72706f726174696f6e310c300a060355040b1303444d43311530130603550403130c53616d73756e6720436572743125302306092a864886f70d0109011616616e64726f69642e6f734073616d73756e672e636f6d820900e5eff0a8f66d92b3300c0603551d13040530030101ff300d06092a864886f70d0101050500038201010039c91877eb09c2c84445443673c77a1219c5c02e6552fa2fbad0d736bc5ab6ebaf0375e520fe9799403ecb71659b23afda1475a34ef4b2e1ffcba8d7ff385c21cb6482540bce3837e6234fd4f7dd576d7fcfe9cfa925509f772c494e1569fe44e6fcd4122e483c2caa2c639566dbcfe85ed7818d5431e73154ad453289fb56b607643919cf534fbeefbdc2009c7fcb5f9b1fa97490462363fa4bedc5e0b9d157e448e6d0e7cfa31f1a2faa9378d03c8d1163d3803bc69bf24ec77ce7d559abcaf8d345494abf0e3276f0ebd2aa08e4f4f6f5aaea4bc523d8cc8e2c9200ba551dd3d4e15d5921303ca9333f42f992ddb70c2958e776c12d7e3b7bd74222eb5c7a");
        Signature signature2 = new Signature("308201e53082014ea00302010202044f54468b300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3132303330353034353232375a170d3432303232363034353232375a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d00308189028181008a53be36d02befe1d152724281630bd1c42eff0edf5fdca8eb944f536ab3f54dca9b22cfb421b37706a4ad259101815723202b359250cf6c59905032798273462bfa3f9f1881f7475ee5b25849edefac81085815f42383a44cb2be1bfd5c1f049ef42f5818f35fe0b1131c769cee347d558395a5fa87c3d425b2b9c819cf91870203010001300d06092a864886f70d0101050500038181000512992268a01e0941481931f3f9b6647fbe25ee0bc9648f35d56c55f8cfa6c935fb3d435125fd60ef566769ac7e64fe2823409461ca7a04570c43baaab3fb877bf3a6a8dd9ef7e69944f65b0e5e36f2ac2bf085fdeda063898855ea2ce84c60655d824844fe1659a77c12604c3fb84d41df6f1a7705a1b9962ac2fdc9933122");
        Signature signature3 = new Signature("308204a830820390a003020102020900936eacbe07f201df300d06092a864886f70d0101050500308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d301e170d3038303232393031333334365a170d3335303731373031333334365a308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d30820120300d06092a864886f70d01010105000382010d00308201080282010100d6931904dec60b24b1edc762e0d9d8253e3ecd6ceb1de2ff068ca8e8bca8cd6bd3786ea70aa76ce60ebb0f993559ffd93e77a943e7e83d4b64b8e4fea2d3e656f1e267a81bbfb230b578c20443be4c7218b846f5211586f038a14e89c2be387f8ebecf8fcac3da1ee330c9ea93d0a7c3dc4af350220d50080732e0809717ee6a053359e6a694ec2cb3f284a0a466c87a94d83b31093a67372e2f6412c06e6d42f15818dffe0381cc0cd444da6cddc3b82458194801b32564134fbfde98c9287748dbf5676a540d8154c8bbca07b9e247553311c46b9af76fdeeccc8e69e7c8a2d08e782620943f99727d3c04fe72991d99df9bae38a0b2177fa31d5b6afee91f020103a381fc3081f9301d0603551d0e04160414485900563d272c46ae118605a47419ac09ca8c113081c90603551d230481c13081be8014485900563d272c46ae118605a47419ac09ca8c11a1819aa48197308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d820900936eacbe07f201df300c0603551d13040530030101ff300d06092a864886f70d010105050003820101007aaf968ceb50c441055118d0daabaf015b8a765a27a715a2c2b44f221415ffdace03095abfa42df70708726c2069e5c36eddae0400be29452c084bc27eb6a17eac9dbe182c204eb15311f455d824b656dbe4dc2240912d7586fe88951d01a8feb5ae5a4260535df83431052422468c36e22c2a5ef994d61dd7306ae4c9f6951ba3c12f1d1914ddc61f1a62da2df827f603fea5603b2c540dbd7c019c36bab29a4271c117df523cdbc5f3817a49e0efa60cbd7f74177e7a4f193d43f4220772666e4c4d83e1bd5a86087cf34f2dec21e245ca6c2bb016e683638050d2c430eea7c26a1c49d3760a58ab7f1a82cc938b4831384324bd0401fa12163a50570e684d");
        Signature signature4 = new Signature("308204a830820390a003020102020900b3998086d056cffa300d06092a864886f70d0101040500308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d301e170d3038303431353232343035305a170d3335303930313232343035305a308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d30820120300d06092a864886f70d01010105000382010d003082010802820101009c780592ac0d5d381cdeaa65ecc8a6006e36480c6d7207b12011be50863aabe2b55d009adf7146d6f2202280c7cd4d7bdb26243b8a806c26b34b137523a49268224904dc01493e7c0acf1a05c874f69b037b60309d9074d24280e16bad2a8734361951eaf72a482d09b204b1875e12ac98c1aa773d6800b9eafde56d58bed8e8da16f9a360099c37a834a6dfedb7b6b44a049e07a269fccf2c5496f2cf36d64df90a3b8d8f34a3baab4cf53371ab27719b3ba58754ad0c53fc14e1db45d51e234fbbe93c9ba4edf9ce54261350ec535607bf69a2ff4aa07db5f7ea200d09a6c1b49e21402f89ed1190893aab5a9180f152e82f85a45753cf5fc19071c5eec827020103a381fc3081f9301d0603551d0e041604144fe4a0b3dd9cba29f71d7287c4e7c38f2086c2993081c90603551d230481c13081be80144fe4a0b3dd9cba29f71d7287c4e7c38f2086c299a1819aa48197308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d820900b3998086d056cffa300c0603551d13040530030101ff300d06092a864886f70d01010405000382010100572551b8d93a1f73de0f6d469f86dad6701400293c88a0cd7cd778b73dafcc197fab76e6212e56c1c761cfc42fd733de52c50ae08814cefc0a3b5a1a4346054d829f1d82b42b2048bf88b5d14929ef85f60edd12d72d55657e22e3e85d04c831d613d19938bb8982247fa321256ba12d1d6a8f92ea1db1c373317ba0c037f0d1aff645aef224979fba6e7a14bc025c71b98138cef3ddfc059617cf24845cf7b40d6382f7275ed738495ab6e5931b9421765c491b72fb68e080dbdb58c2029d347c8b328ce43ef6a8b15533edfbe989bd6a48dd4b202eda94c6ab8dd5b8399203daae2ed446232e4fe9bd961394c6300e5138e3cfd285e6e4e483538cb8b1b357");
        Signature signature5 = new Signature("308204d4308203bca003020102020900d20995a79c0daad6300d06092a864886f70d01010505003081a2310b3009060355040613024b52311430120603550408130b536f757468204b6f726561311330110603550407130a5375776f6e2043697479311c301a060355040a131353616d73756e6720436f72706f726174696f6e310c300a060355040b1303444d43311530130603550403130c53616d73756e6720436572743125302306092a864886f70d0109011616616e64726f69642e6f734073616d73756e672e636f6d301e170d3131303632323132323531325a170d3338313130373132323531325a3081a2310b3009060355040613024b52311430120603550408130b536f757468204b6f726561311330110603550407130a5375776f6e2043697479311c301a060355040a131353616d73756e6720436f72706f726174696f6e310c300a060355040b1303444d43311530130603550403130c53616d73756e6720436572743125302306092a864886f70d0109011616616e64726f69642e6f734073616d73756e672e636f6d30820120300d06092a864886f70d01010105000382010d00308201080282010100c986384a3e1f2fb206670e78ef232215c0d26f45a22728db99a44da11c35ac33a71fe071c4a2d6825a9b4c88b333ed96f3c5e6c666d60f3ee94c490885abcf8dc660f707aabc77ead3e2d0d8aee8108c15cd260f2e85042c28d2f292daa3c6da0c7bf2391db7841aade8fdf0c9d0defcf77124e6d2de0a9e0d2da746c3670e4ffcdc85b701bb4744861b96ff7311da3603c5a10336e55ffa34b4353eedc85f51015e1518c67e309e39f87639ff178107f109cd18411a6077f26964b6e63f8a70b9619db04306a323c1a1d23af867e19f14f570ffe573d0e3a0c2b30632aaec3173380994be1e341e3a90bd2e4b615481f46db39ea83816448ec35feb1735c1f3020103a382010b30820107301d0603551d0e04160414932c3af70b627a0c7610b5a0e7427d6cfaea3f1e3081d70603551d230481cf3081cc8014932c3af70b627a0c7610b5a0e7427d6cfaea3f1ea181a8a481a53081a2310b3009060355040613024b52311430120603550408130b536f757468204b6f726561311330110603550407130a5375776f6e2043697479311c301a060355040a131353616d73756e6720436f72706f726174696f6e310c300a060355040b1303444d43311530130603550403130c53616d73756e6720436572743125302306092a864886f70d0109011616616e64726f69642e6f734073616d73756e672e636f6d820900d20995a79c0daad6300c0603551d13040530030101ff300d06092a864886f70d01010505000382010100329601fe40e036a4a86cc5d49dd8c1b5415998e72637538b0d430369ac51530f63aace8c019a1a66616a2f1bb2c5fabd6f313261f380e3471623f053d9e3c53f5fd6d1965d7b000e4dc244c1b27e2fe9a323ff077f52c4675e86247aa801187137e30c9bbf01c567a4299db4bf0b25b7d7107a7b81ee102f72ff47950164e26752e114c42f8b9d2a42e7308897ec640ea1924ed13abbe9d120912b62f4926493a86db94c0b46f44c6161d58c2f648164890c512dfb28d42c855bf470dbee2dab6960cad04e81f71525ded46cdd0f359f99c460db9f007d96ce83b4b218ac2d82c48f12608d469733f05a3375594669ccbf8a495544d6c5701e9369c08c810158");
        Signature[] signatureArr2 = {signature, signature5, signature2, signature3, signature4};
        Signature[] signatureArr3 = {signature, signature5};
        String str = Build.TYPE;
        if (str.equalsIgnoreCase("eng") || str.equalsIgnoreCase("userdebug")) {
            Log.d("HealthDataStore", " SIGNATURES_ENG ");
        } else {
            signatureArr2 = signatureArr3;
        }
        for (Signature signature6 : signatureArr) {
            for (Signature signature7 : signatureArr2) {
                if (signature7.equals(signature6)) {
                    Log.d("HealthDataStore", " signature matched ");
                    return true;
                }
            }
        }
        if (signatureArr.length > 0) {
            for (Signature signature8 : signatureArr) {
                int length = signature8.toCharsString().length();
                Log.d("HealthDataStore", " signature : ".concat(signature8.toCharsString().substring(length - 5, length)));
            }
        } else {
            Log.d("HealthDataStore", " no signatures");
        }
        return false;
    }

    public final Context a() {
        return this.e;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static /* synthetic */ HealthResultHolder a(HealthDataStore healthDataStore, long j2) {
        IHealth iHealth = healthDataStore.d;
        Log.d("HealthDataStore", "Waiting for initialization of Health framework ...");
        HealthResultHolder<HealthResultHolder.BaseResult> healthResultHolder = healthDataStore.a;
        if (healthResultHolder != null) {
            healthResultHolder.cancel();
        }
        HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
        HealthResultHolder<HealthResultHolder.BaseResult> asyncResultHolder = IpcUtil.getAsyncResultHolder(forwardAsync, Looper.myLooper());
        iHealth.waitForInit2(healthDataStore.e.getPackageName(), forwardAsync, j2);
        healthDataStore.a = asyncResultHolder;
        asyncResultHolder.setResultListener(new HealthResultHolder.ResultListener<HealthResultHolder.BaseResult>() { // from class: com.samsung.android.sdk.healthdata.HealthDataStore.1
            @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.ResultListener
            public final void onResult(HealthResultHolder.BaseResult baseResult) {
                int status = baseResult.getStatus();
                HealthDataStore healthDataStore2 = HealthDataStore.this;
                if (status != 1) {
                    healthDataStore2.f.sendEmptyMessage(7);
                } else if (healthDataStore2.c != null) {
                    HealthDataStore.this.c.onConnected();
                    HealthDataStore.this.a = null;
                }
            }
        });
        Message message = new Message();
        message.what = 5;
        healthDataStore.f.sendMessageDelayed(message, j2);
        return healthDataStore.a;
    }

    public static /* synthetic */ void a(HealthDataStore healthDataStore, int i) {
        Context context;
        if (healthDataStore.c != null) {
            Log.d("HealthDataStore", "Trying to connect with Health Service fails (error code: " + i + ")");
            byte b2 = 0;
            if ((i == 2 || i == 4) && (context = healthDataStore.e) != null && context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
                Log.d("HealthDataStore", "Check SupportedDevice");
                new a(healthDataStore, i, b2).execute(new Void[0]);
                return;
            }
            HealthConnectionErrorResult healthConnectionErrorResult = new HealthConnectionErrorResult(i, false);
            if (i == 2 || i == 4 || i == 6) {
                healthConnectionErrorResult.setPackageManager(healthDataStore.e.getPackageManager());
            }
            healthDataStore.c.onConnectionFailed(healthConnectionErrorResult);
        }
    }

    public void connectService() {
        connectService(j);
    }
}
