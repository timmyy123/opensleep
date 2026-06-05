package com.urbandroid.sleep.addon.taskerplugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.urbandroid.sleep.addon.taskerplugin.receiver.FireReceiver;
import com.urbandroid.sleep.addon.taskerplugin.receiver.QueryReceiver;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TaskerPlugin {
    private static int[] lastRandomsSeen;
    private static int randomInsertPointer;
    private static SecureRandom sr;

    public static class Event {
        public static int addPassThroughMessageID(Intent intent) {
            Bundle bundleRetrieveOrCreatePassThroughBundle = retrieveOrCreatePassThroughBundle(intent);
            int positiveNonRepeatingRandomInteger = TaskerPlugin.getPositiveNonRepeatingRandomInteger();
            bundleRetrieveOrCreatePassThroughBundle.putInt("net.dinglisch.android.tasker.MESSAGE_ID", positiveNonRepeatingRandomInteger);
            return positiveNonRepeatingRandomInteger;
        }

        private static Bundle retrieveOrCreatePassThroughBundle(Intent intent) {
            if (intent.hasExtra("net.dinglisch.android.tasker.extras.PASS_THROUGH_DATA")) {
                return intent.getBundleExtra("net.dinglisch.android.tasker.extras.PASS_THROUGH_DATA");
            }
            Bundle bundle = new Bundle();
            intent.putExtra("net.dinglisch.android.tasker.extras.PASS_THROUGH_DATA", bundle);
            return bundle;
        }

        public static Bundle retrievePassThroughData(Intent intent) {
            return (Bundle) TaskerPlugin.m1226$$Nest$smgetExtraValueSafe(intent);
        }

        public static int retrievePassThroughMessageID(Intent intent) {
            Integer num;
            Bundle bundleRetrievePassThroughData = retrievePassThroughData(intent);
            if (bundleRetrievePassThroughData == null || (num = (Integer) TaskerPlugin.m1225$$Nest$smgetBundleValueSafe(bundleRetrievePassThroughData)) == null) {
                return -1;
            }
            return num.intValue();
        }
    }

    public static class Setting {
        public static boolean hostSupportsVariableReturn(Bundle bundle) {
            return TaskerPlugin.m1227$$Nest$smhostSupports(bundle);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smgetBundleValueSafe, reason: not valid java name */
    public static /* bridge */ /* synthetic */ Object m1225$$Nest$smgetBundleValueSafe(Bundle bundle) {
        return getBundleValueSafe(bundle, "net.dinglisch.android.tasker.MESSAGE_ID", Integer.class, "retrievePassThroughMessageID");
    }

    /* JADX INFO: renamed from: -$$Nest$smgetExtraValueSafe, reason: not valid java name */
    public static /* bridge */ /* synthetic */ Object m1226$$Nest$smgetExtraValueSafe(Intent intent) {
        return getExtraValueSafe(intent, "net.dinglisch.android.tasker.extras.PASS_THROUGH_DATA", Bundle.class, "retrievePassThroughData");
    }

    /* JADX INFO: renamed from: -$$Nest$smhostSupports, reason: not valid java name */
    public static /* bridge */ /* synthetic */ boolean m1227$$Nest$smhostSupports(Bundle bundle) {
        return hostSupports(bundle, 2);
    }

    public static void addVariableBundle(Bundle bundle, Bundle bundle2) {
        bundle.putBundle("net.dinglisch.android.tasker.extras.VARIABLES", bundle2);
    }

    public static void enable(Context context, boolean z) {
        QueryReceiver.setEnabled(context, z);
        FireReceiver.setEnabled(context, z);
    }

    private static Object getBundleValueSafe(Bundle bundle, String str, Class<?> cls, String str2) {
        if (bundle == null || !bundle.containsKey(str)) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj == null) {
            Log.w("TaskerPlugin", str2 + ": " + str + ": null value");
            return null;
        }
        if (obj.getClass() == cls) {
            return obj;
        }
        Log.w("TaskerPlugin", str2 + ": " + str + ": expected " + cls.getClass().getName() + ", got " + obj.getClass().getName());
        return null;
    }

    private static Object getExtraValueSafe(Intent intent, String str, Class<?> cls, String str2) {
        if (intent.hasExtra(str)) {
            return getBundleValueSafe(intent.getExtras(), str, cls, str2);
        }
        return null;
    }

    public static int getPositiveNonRepeatingRandomInteger() {
        int iNextInt;
        if (sr == null) {
            sr = new SecureRandom();
            lastRandomsSeen = new int[100];
            int i = 0;
            while (true) {
                int[] iArr = lastRandomsSeen;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = -1;
                i++;
            }
        }
        do {
            iNextInt = sr.nextInt(Integer.MAX_VALUE);
            int[] iArr2 = lastRandomsSeen;
            int length = iArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (iArr2[i2] == iNextInt) {
                    iNextInt = -1;
                    break;
                }
                i2++;
            }
        } while (iNextInt == -1);
        int[] iArr3 = lastRandomsSeen;
        int i3 = randomInsertPointer;
        iArr3[i3] = iNextInt;
        randomInsertPointer = (i3 + 1) % iArr3.length;
        return iNextInt;
    }

    private static boolean hostSupports(Bundle bundle, int i) {
        Integer num = (Integer) getBundleValueSafe(bundle, "net.dinglisch.android.tasker.extras.HOST_CAPABILITIES", Integer.class, "hostSupports");
        return num != null && (num.intValue() & i) > 0;
    }
}
