package com.getpebble.android.kit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.getpebble.android.kit.Constants;
import com.getpebble.android.kit.util.PebbleDictionary;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.UUID;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class PebbleKit {
    private static final int ICON_MAX_DIMENSIONS = 25;
    private static final int NAME_MAX_LENGTH = 32;

    /* JADX INFO: renamed from: com.getpebble.android.kit.PebbleKit$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$getpebble$android$kit$Constants$PebbleDataType;

        static {
            int[] iArr = new int[Constants.PebbleDataType.values().length];
            $SwitchMap$com$getpebble$android$kit$Constants$PebbleDataType = iArr;
            try {
                iArr[Constants.PebbleDataType.BYTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$getpebble$android$kit$Constants$PebbleDataType[Constants.PebbleDataType.UINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$getpebble$android$kit$Constants$PebbleDataType[Constants.PebbleDataType.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class FirmwareVersionInfo {
        private final int major;
        private final int minor;
        private final int point;
        private final String tag;

        public FirmwareVersionInfo(int i, int i2, int i3, String str) {
            this.major = i;
            this.minor = i2;
            this.point = i3;
            this.tag = str;
        }

        public final int getMajor() {
            return this.major;
        }

        public final int getMinor() {
            return this.minor;
        }

        public final int getPoint() {
            return this.point;
        }

        public final String getTag() {
            return this.tag;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class PebbleAckReceiver extends BroadcastReceiver {
        private final UUID subscribedUuid;

        public PebbleAckReceiver(UUID uuid) {
            this.subscribedUuid = uuid;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            receiveAck(context, intent.getIntExtra(Constants.TRANSACTION_ID, -1));
        }

        public abstract void receiveAck(Context context, int i);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class PebbleDataReceiver extends BroadcastReceiver {
        private final UUID subscribedUuid;

        public PebbleDataReceiver(UUID uuid) {
            this.subscribedUuid = uuid;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.subscribedUuid.equals((UUID) intent.getSerializableExtra("uuid"))) {
                int intExtra = intent.getIntExtra(Constants.TRANSACTION_ID, -1);
                String stringExtra = intent.getStringExtra(Constants.MSG_DATA);
                if (stringExtra == null || stringExtra.isEmpty()) {
                    return;
                }
                try {
                    receiveData(context, intExtra, PebbleDictionary.fromJson(stringExtra));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public abstract void receiveData(Context context, int i, PebbleDictionary pebbleDictionary);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class PebbleNackReceiver extends BroadcastReceiver {
        private final UUID subscribedUuid;

        public PebbleNackReceiver(UUID uuid) {
            this.subscribedUuid = uuid;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            receiveNack(context, intent.getIntExtra(Constants.TRANSACTION_ID, -1));
        }

        public abstract void receiveNack(Context context, int i);
    }

    private PebbleKit() {
    }

    public static boolean areAppMessagesSupported(Context context) throws Throwable {
        Cursor cursorQueryProvider;
        try {
            cursorQueryProvider = queryProvider(context);
            if (cursorQueryProvider != null) {
                try {
                    if (cursorQueryProvider.moveToNext()) {
                        boolean z = cursorQueryProvider.getInt(1) == 1;
                        cursorQueryProvider.close();
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQueryProvider != null) {
                        cursorQueryProvider.close();
                    }
                    throw th;
                }
            }
            if (cursorQueryProvider != null) {
                cursorQueryProvider.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursorQueryProvider = null;
        }
    }

    public static void closeAppOnPebble(Context context, UUID uuid) {
        if (uuid == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("uuid cannot be null");
            return;
        }
        Intent intent = new Intent(Constants.INTENT_APP_STOP);
        intent.putExtra("uuid", uuid);
        context.sendBroadcast(intent);
    }

    public static void customizeWatchApp(Context context, Constants.PebbleAppType pebbleAppType, String str, Bitmap bitmap) {
        if (pebbleAppType == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("app type cannot be null");
            return;
        }
        if (str.length() > 32) {
            Home$$ExternalSyntheticBUOutline0.m("app name exceeds maximum length (%d)", new Object[]{32});
            return;
        }
        if (bitmap.getHeight() > 25 || bitmap.getWidth() > 25) {
            Home$$ExternalSyntheticBUOutline0.m("app icon exceeds maximum dimensions (25px x 25px); got (%dpx x %dpx)", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            return;
        }
        Intent intent = new Intent(Constants.INTENT_APP_CUSTOMIZE);
        intent.putExtra(Constants.CUST_APP_TYPE, pebbleAppType.ord);
        intent.putExtra("name", str);
        intent.putExtra(Constants.CUST_ICON, bitmap);
        context.sendBroadcast(intent);
    }

    public static FirmwareVersionInfo getWatchFWVersion(Context context) {
        Throwable th;
        Cursor cursorQueryProvider;
        try {
            cursorQueryProvider = queryProvider(context);
            if (cursorQueryProvider != null) {
                try {
                    if (cursorQueryProvider.moveToNext()) {
                        FirmwareVersionInfo firmwareVersionInfo = new FirmwareVersionInfo(cursorQueryProvider.getInt(3), cursorQueryProvider.getInt(4), cursorQueryProvider.getInt(5), cursorQueryProvider.getString(6));
                        cursorQueryProvider.close();
                        return firmwareVersionInfo;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQueryProvider != null) {
                        cursorQueryProvider.close();
                    }
                    throw th;
                }
            }
            if (cursorQueryProvider != null) {
                cursorQueryProvider.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursorQueryProvider = null;
        }
    }

    public static boolean isDataLoggingSupported(Context context) throws Throwable {
        Cursor cursorQueryProvider;
        try {
            cursorQueryProvider = queryProvider(context);
            if (cursorQueryProvider != null) {
                try {
                    if (cursorQueryProvider.moveToNext()) {
                        boolean z = cursorQueryProvider.getInt(2) == 1;
                        cursorQueryProvider.close();
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQueryProvider != null) {
                        cursorQueryProvider.close();
                    }
                    throw th;
                }
            }
            if (cursorQueryProvider != null) {
                cursorQueryProvider.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursorQueryProvider = null;
        }
    }

    public static boolean isWatchConnected(Context context) throws Throwable {
        Cursor cursorQueryProvider;
        try {
            cursorQueryProvider = queryProvider(context);
            if (cursorQueryProvider != null) {
                try {
                    if (cursorQueryProvider.moveToNext()) {
                        boolean z = cursorQueryProvider.getInt(0) == 1;
                        cursorQueryProvider.close();
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQueryProvider != null) {
                        cursorQueryProvider.close();
                    }
                    throw th;
                }
            }
            if (cursorQueryProvider != null) {
                cursorQueryProvider.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursorQueryProvider = null;
        }
    }

    private static Cursor queryProvider(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Constants.URI_CONTENT_BASALT, null, null, null, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 1) {
                cursorQuery.moveToPrevious();
                return cursorQuery;
            }
            cursorQuery.close();
        }
        return context.getContentResolver().query(Constants.URI_CONTENT_PRIMARY, null, null, null, null);
    }

    private static BroadcastReceiver registerBroadcastReceiverInternal(Context context, String str, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return null;
        }
        IntentFilter intentFilter = new IntentFilter(str);
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, 2);
            return broadcastReceiver;
        }
        context.registerReceiver(broadcastReceiver, intentFilter);
        return broadcastReceiver;
    }

    public static BroadcastReceiver registerDataLogReceiver(Context context, PebbleDataLogReceiver pebbleDataLogReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.INTENT_DL_RECEIVE_DATA);
        intentFilter.addAction(Constants.INTENT_DL_FINISH_SESSION);
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(pebbleDataLogReceiver, intentFilter, 2);
            return pebbleDataLogReceiver;
        }
        context.registerReceiver(pebbleDataLogReceiver, intentFilter);
        return pebbleDataLogReceiver;
    }

    public static BroadcastReceiver registerPebbleConnectedReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        return registerBroadcastReceiverInternal(context, Constants.INTENT_PEBBLE_CONNECTED, broadcastReceiver);
    }

    public static BroadcastReceiver registerPebbleDisconnectedReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        return registerBroadcastReceiverInternal(context, Constants.INTENT_PEBBLE_DISCONNECTED, broadcastReceiver);
    }

    public static BroadcastReceiver registerReceivedAckHandler(Context context, PebbleAckReceiver pebbleAckReceiver) {
        return registerBroadcastReceiverInternal(context, Constants.INTENT_APP_RECEIVE_ACK, pebbleAckReceiver);
    }

    public static BroadcastReceiver registerReceivedDataHandler(Context context, PebbleDataReceiver pebbleDataReceiver) {
        return registerBroadcastReceiverInternal(context, Constants.INTENT_APP_RECEIVE, pebbleDataReceiver);
    }

    public static BroadcastReceiver registerReceivedNackHandler(Context context, PebbleNackReceiver pebbleNackReceiver) {
        return registerBroadcastReceiverInternal(context, Constants.INTENT_APP_RECEIVE_NACK, pebbleNackReceiver);
    }

    public static void requestDataLogsForApp(Context context, UUID uuid) {
        Intent intent = new Intent(Constants.INTENT_DL_REQUEST_DATA);
        intent.putExtra("uuid", uuid);
        context.sendBroadcast(intent);
    }

    public static void sendAckToPebble(Context context, int i) {
        if ((i & Color.YELLOW) != 0) {
            Home$$ExternalSyntheticBUOutline0.m("transaction id must be between (0, 255); got '%d'", new Object[]{Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent(Constants.INTENT_APP_ACK);
        intent.putExtra(Constants.TRANSACTION_ID, i);
        context.sendBroadcast(intent);
    }

    public static void sendDataToPebble(Context context, UUID uuid, PebbleDictionary pebbleDictionary) {
        sendDataToPebbleWithTransactionId(context, uuid, pebbleDictionary, -1);
    }

    public static void sendDataToPebbleWithTransactionId(Context context, UUID uuid, PebbleDictionary pebbleDictionary, int i) {
        if (uuid == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("uuid cannot be null");
            return;
        }
        if (pebbleDictionary == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("data cannot be null");
            return;
        }
        if (pebbleDictionary.size() == 0) {
            return;
        }
        Intent intent = new Intent(Constants.INTENT_APP_SEND);
        intent.putExtra("uuid", uuid);
        intent.putExtra(Constants.TRANSACTION_ID, i);
        intent.putExtra(Constants.MSG_DATA, pebbleDictionary.toJsonString());
        context.sendBroadcast(intent);
    }

    public static void sendNackToPebble(Context context, int i) {
        if ((i & Color.YELLOW) != 0) {
            Home$$ExternalSyntheticBUOutline0.m("transaction id must be between (0, 255); got '%d'", new Object[]{Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent(Constants.INTENT_APP_NACK);
        intent.putExtra(Constants.TRANSACTION_ID, i);
        context.sendBroadcast(intent);
    }

    public static void startAppOnPebble(Context context, UUID uuid) {
        if (uuid == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("uuid cannot be null");
            return;
        }
        Intent intent = new Intent(Constants.INTENT_APP_START);
        intent.putExtra("uuid", uuid);
        context.sendBroadcast(intent);
    }

    public static abstract class PebbleDataLogReceiver extends BroadcastReceiver {
        private int lastDataId;
        private final UUID subscribedUuid;

        public PebbleDataLogReceiver(UUID uuid) {
            this.subscribedUuid = uuid;
        }

        private void handleFinishSessionIntent(Context context, Intent intent, UUID uuid, Long l, Long l2) {
            onFinishSession(context, uuid, l, l2);
        }

        private void handleReceiveDataIntent(Context context, Intent intent, UUID uuid, Long l, Long l2) {
            UUID uuid2;
            int intExtra = intent.getIntExtra(Constants.PBL_DATA_ID, -1);
            if (intExtra < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(intExtra, "DataID: ", " LastDataID: ");
            sbM65m.append(this.lastDataId);
            Log.i("pebble", sbM65m.toString());
            if (intExtra == this.lastDataId) {
                return;
            }
            Constants.PebbleDataType pebbleDataTypeFromByte = Constants.PebbleDataType.fromByte(intent.getByteExtra(Constants.PBL_DATA_TYPE, Constants.PebbleDataType.INVALID.ord));
            if (pebbleDataTypeFromByte == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
            int i = AnonymousClass1.$SwitchMap$com$getpebble$android$kit$Constants$PebbleDataType[pebbleDataTypeFromByte.ordinal()];
            if (i == 1) {
                uuid2 = uuid;
                byte[] bArrDecode = Base64.decode(intent.getStringExtra(Constants.PBL_DATA_OBJECT), 2);
                if (bArrDecode == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3();
                    return;
                }
                receiveData(context, uuid2, l, l2, bArrDecode);
            } else if (i == 2) {
                uuid2 = uuid;
                Long l3 = (Long) intent.getSerializableExtra(Constants.PBL_DATA_OBJECT);
                if (l3 == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3();
                    return;
                }
                receiveData(context, uuid2, l, l2, l3);
            } else {
                if (i != 3) {
                    throw new IllegalArgumentException("Invalid type:" + pebbleDataTypeFromByte.toString());
                }
                Integer num = (Integer) intent.getSerializableExtra(Constants.PBL_DATA_OBJECT);
                if (num == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3();
                    return;
                } else {
                    uuid2 = uuid;
                    receiveData(context, uuid2, l, l2, num.intValue());
                }
            }
            this.lastDataId = intExtra;
            Intent intent2 = new Intent(Constants.INTENT_DL_ACK_DATA);
            intent2.putExtra(Constants.DATA_LOG_UUID, uuid2);
            intent2.putExtra(Constants.PBL_DATA_ID, intExtra);
            context.sendBroadcast(intent2);
        }

        public void onFinishSession(Context context, UUID uuid, Long l, Long l2) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.subscribedUuid.equals((UUID) intent.getSerializableExtra("uuid"))) {
                try {
                    UUID uuid = (UUID) intent.getSerializableExtra(Constants.DATA_LOG_UUID);
                    if (uuid == null) {
                        throw new IllegalArgumentException();
                    }
                    Long l = (Long) intent.getSerializableExtra(Constants.DATA_LOG_TIMESTAMP);
                    if (l == null) {
                        throw new IllegalArgumentException();
                    }
                    Long l2 = (Long) intent.getSerializableExtra(Constants.DATA_LOG_TAG);
                    if (l2 == null) {
                        throw new IllegalArgumentException();
                    }
                    if (intent.getAction() == Constants.INTENT_DL_RECEIVE_DATA) {
                        handleReceiveDataIntent(context, intent, uuid, l, l2);
                    } else if (intent.getAction() == Constants.INTENT_DL_FINISH_SESSION) {
                        handleFinishSessionIntent(context, intent, uuid, l, l2);
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }

        public void receiveData(Context context, UUID uuid, Long l, Long l2, Long l3) {
            throw new UnsupportedOperationException("UnsignedInteger handler not implemented");
        }

        public void receiveData(Context context, UUID uuid, Long l, Long l2, byte[] bArr) {
            throw new UnsupportedOperationException("Byte array handler not implemented");
        }

        public void receiveData(Context context, UUID uuid, Long l, Long l2, int i) {
            throw new UnsupportedOperationException("int handler not implemented");
        }
    }
}
