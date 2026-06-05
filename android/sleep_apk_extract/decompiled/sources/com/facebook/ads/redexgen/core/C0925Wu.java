package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.home.platform.traits.ValidationIssue;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0925Wu {
    public static byte[] A00;
    public static String[] A01 = {"WbJlBxxP9hhDyVkliYvNWFvleez5wFba", "Us5Q3ca4sjVLZknlXhQB6hWi1VD5Erza", "gJqO8U9bMVlcsLp5HSGrl2qXu5TMOPYV", "P57OBps6tL2979s4xCAUfWnFOcUQoKvX", "CjMQtwUDrO8ZQ06PzRRzPVuypWFQdtNK", "DynPiig1xYxCb14sB97Y7RAQimyT6aIC", "zcq0zXyldopis2WSYxgyl16P5Uge3oHA", "fUMP1AC"};
    public static final Package A02;
    public static final String A03;
    public static final String A04;
    public static final String A05;
    public static final Set<C1421gi> A06;
    public static final AtomicReference<X3> A07;
    public static final AtomicReference<X5> A08;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{89, 54, 51, 57, 32, 40, 54, 51, 40, 56, 53, 61, 40, 62, 51, 40, 60, 50, 46, 57, 86, 83, 89, 64, 72, 88, 69, 94, 80, 94, 89, 86, 91, 72, 82, 79, 67, 69, 86, 68, 21, 122, 127, 117, 108, 100, 104, 122, 109, 126, 127, 100, 104, 111, 122, 111, 126, 100, 127, 122, 111, 122, 75, 121, 110, 125, 124, 56, 107, 108, 121, 108, 125, 56, 122, 109, 118, 124, 116, 125, 56, 113, 107, 56, 125, 117, 104, 108, 97, 57, 23, 21, 2, 41, 3, 2, 31, 26, 26, 21, 36, 24, 23, 18, 30, 21, 15, 36, 15, 20, 16, 30, 21, 100, 104, 106, 41, 97, 102, 100, 98, 101, 104, 104, 108, 41, 102, 99, 116, 41, 110, 105, 115, 98, 117, 105, 102, 107, 41, 110, 119, 100, 41, 70, 114, 99, 110, 98, 105, 100, 98, 73, 98, 115, 112, 104, 117, 108, 85, 98, 106, 104, 115, 98, 70, 100, 115, 110, 113, 110, 115, 126, 109, 100, 107, 97, 105, 96, 80, 119, 108, 67, 106, 119, 87, 96, 118, 112, 105, 113, 15, 8, 29, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 8, 61, 31, 8, 21, 10, 21, 8, 5, 3, 4, 17, 2, 4, 49, 19, 4, 25, 6, 25, 4, 9, 54, 31, 2, 34, 21, 3, 5, 28, 4};
    }

    static {
        A08();
        A02 = C0925Wu.class.getPackage();
        A04 = A02 + A07(40, 22, 116);
        A03 = A02 + A07(0, 19, 56);
        A05 = A02 + A07(19, 21, 88);
        A06 = Collections.newSetFromMap(new WeakHashMap());
        A07 = new AtomicReference<>();
        A08 = new AtomicReference<>();
    }

    public static int A00(C1421gi c1421gi, Intent intent) throws C0923Ws {
        Intent intentA01 = A01(intent);
        int usedContext = 0;
        try {
            Activity activityA00 = ActivityUtils.A00();
            if (activityA00 == null) {
                activityA00 = c1421gi.A0E();
                usedContext = 1;
            }
            if (activityA00 != null) {
                activityA00.startActivity(intentA01);
                return usedContext;
            }
            intentA01.addFlags(ClientDefaults.MAX_MSG_SIZE);
            c1421gi.startActivity(intentA01);
            return 2;
        } catch (ActivityNotFoundException e) {
            throw new C0923Ws(e);
        }
    }

    public static Intent A01(Intent intent) {
        Intent intentCloneFilter = intent.cloneFilter();
        intentCloneFilter.setFlags(intent.getFlags());
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(intent.getExtras());
        intentCloneFilter.putExtra(A05, parcelObtain.marshall());
        parcelObtain.recycle();
        return intentCloneFilter;
    }

    public static Intent A02(Intent intent, ClassLoader classLoader) {
        Intent intentCloneFilter = intent.cloneFilter();
        intentCloneFilter.setFlags(intent.getFlags());
        Bundle audienceNetworkActivityBundle = new Bundle();
        Parcel parcelObtain = Parcel.obtain();
        byte[] byteArrayExtra = intent.getByteArrayExtra(A05);
        if (byteArrayExtra != null) {
            parcelObtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            parcelObtain.setDataPosition(0);
            audienceNetworkActivityBundle = parcelObtain.readBundle(classLoader);
            parcelObtain.recycle();
        }
        intentCloneFilter.putExtras(audienceNetworkActivityBundle);
        return intentCloneFilter;
    }

    public static Bundle A03(Bundle bundle, ClassLoader classLoader) {
        Parcel parcelObtain = Parcel.obtain();
        byte[] byteArray = bundle.getByteArray(A04);
        if (byteArray != null) {
            parcelObtain.unmarshall(byteArray, 0, byteArray.length);
            parcelObtain.setDataPosition(0);
            Bundle bundle2 = parcelObtain.readBundle(classLoader);
            if (A01[2].charAt(4) != '8') {
                throw new RuntimeException();
            }
            A01[7] = "Zue8yRDoBrDWRSev";
            parcelObtain.recycle();
            return bundle2;
        }
        throw new IllegalStateException(A07(62, 28, 87));
    }

    public static C1421gi A04(Intent intent) {
        String stringExtra = intent.getStringExtra(A03);
        if (stringExtra != null) {
            for (C1421gi c1421gi : A06) {
                String adId = c1421gi.A0F().getId();
                if (stringExtra.equals(adId)) {
                    return c1421gi;
                }
            }
            return null;
        }
        return null;
    }

    public static AdActivityIntent A05(C1421gi c1421gi) {
        AdActivityIntent adActivityIntent = new AdActivityIntent(c1421gi.getApplicationContext(), A06());
        adActivityIntent.putExtra(A03, c1421gi.A0F().getId());
        A06.add(c1421gi);
        return adActivityIntent;
    }

    public static Class A06() {
        if (ProcessUtils.isRemoteRenderingProcess()) {
            try {
                return Class.forName(A07(113, 59, 72));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return AudienceNetworkActivity.class;
    }

    public static void A09(Activity activity, Intent intent) throws C0923Ws {
        try {
            activity.startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            throw new C0923Ws(e);
        }
    }

    public static void A0A(Bundle bundle, Bundle bundle2) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle2);
        bundle.putByteArray(A04, parcelObtain.marshall());
        parcelObtain.recycle();
    }

    public static void A0B(C1421gi c1421gi, AdActivityIntent adActivityIntent) throws C0923Ws {
        Context launchContext;
        Context applicationContext = c1421gi.getApplicationContext();
        if (C0871Up.A2d(c1421gi) && (launchContext = c1421gi.A0E()) != null) {
            applicationContext = launchContext;
            if ((adActivityIntent.getFlags() & ClientDefaults.MAX_MSG_SIZE) == 268435456) {
                adActivityIntent.setFlags(adActivityIntent.getFlags() ^ ClientDefaults.MAX_MSG_SIZE);
            }
        }
        try {
            if (ProcessUtils.isRemoteRenderingProcess()) {
                if (!A0I(c1421gi, adActivityIntent)) {
                    c1421gi.A0F().AIC();
                    return;
                }
                return;
            }
            applicationContext.startActivity(A01(adActivityIntent));
        } catch (ActivityNotFoundException e) {
            throw new C0923Ws(e);
        }
    }

    public static boolean A0C(Intent intent, Set<String> set) {
        Uri intentUri = intent.getData();
        if (intentUri == null) {
            return false;
        }
        String string = intentUri.toString();
        Iterator<String> it = set.iterator();
        do {
            boolean zHasNext = it.hasNext();
            if (A01[5].charAt(30) != 'I') {
                throw new RuntimeException();
            }
            A01[2] = "hOpA8yyYIRQLuX6WeWELRCriZfzSUGqk";
            if (!zHasNext) {
                return false;
            }
        } while (!string.startsWith(it.next()));
        return true;
    }

    public static boolean A0D(C1421gi c1421gi, Intent intent) throws C0923Ws {
        A07.get();
        return A0F(c1421gi, intent, null);
    }

    public static boolean A0E(C1421gi c1421gi, Intent intent) throws C0923Ws {
        A07.get();
        if (0 != 0) {
            Activity activityA0E = c1421gi.A0E();
            if (A01[7].length() == 30) {
                throw new RuntimeException();
            }
            A01[7] = "PLLjYBDqb811z0Dn6rlZ87lQdZ7C";
            if (activityA0E != null) {
                c1421gi.A0C();
                try {
                    c1421gi.A0E();
                    throw new NullPointerException(A07(ValidationIssue.UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER, 22, 63));
                } catch (ActivityNotFoundException e) {
                    throw new C0923Ws(e);
                } catch (Exception e2) {
                    c1421gi.A08().ABC(A07(90, 8, 57), AbstractC0833Td.A07, new C0834Te(e2));
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean A0F(C1421gi c1421gi, Intent intent, X3 x3) throws C0923Ws {
        if (A0C(intent, C0871Up.A0Z(c1421gi))) {
            return false;
        }
        Context context = c1421gi;
        if (A01[1].charAt(5) != 'g') {
            A01[2] = "mGLT8eS8inmCxtBfGXr0XCfYNSNKmj30";
            Context startContext = c1421gi.A0E();
            if (startContext != null) {
                context = startContext;
            } else {
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            }
            if (x3 != null && !A0C(intent, C0871Up.A0b(c1421gi))) {
                c1421gi.A0C();
                try {
                    throw new NullPointerException(A07(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 13, 51));
                } catch (ActivityNotFoundException e) {
                    throw new C0923Ws(e);
                } catch (Exception e2) {
                    c1421gi.A08().ABC(A07(90, 8, 57), AbstractC0833Td.A08, new C0834Te(e2));
                    return false;
                }
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e3) {
                throw new C0923Ws(e3);
            }
        }
        throw new RuntimeException();
    }

    public static boolean A0G(C1421gi c1421gi, Uri uri, String str) throws ActivityNotFoundException {
        A08.get();
        return A0H(c1421gi, uri, str, null);
    }

    public static boolean A0H(C1421gi c1421gi, Uri uri, String str, X5 x5) throws ActivityNotFoundException {
        if (x5 == null || c1421gi.A0E() == null) {
            return false;
        }
        new Bundle().putString(A07(98, 15, 52), str);
        uri.toString();
        c1421gi.A0E();
        throw new NullPointerException(A07(172, 18, 74));
    }

    public static boolean A0I(C1421gi c1421gi, AdActivityIntent adActivityIntent) throws C0923Ws {
        Intent intentA01 = A01(adActivityIntent);
        try {
            Activity currentActivity = ActivityUtils.A00();
            if (currentActivity == null) {
                currentActivity = c1421gi.A0E();
            }
            if (currentActivity == null) {
                return false;
            }
            currentActivity.startActivityForResult(intentA01, 0);
            return true;
        } catch (ActivityNotFoundException e) {
            throw new C0923Ws(e);
        }
    }
}
