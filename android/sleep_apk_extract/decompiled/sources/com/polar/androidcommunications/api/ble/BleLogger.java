package com.polar.androidcommunications.api.ble;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0002\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/polar/androidcommunications/api/ble/BleLogger;", "", "()V", "bleLoggerInterface", "Lcom/polar/androidcommunications/api/ble/BleLogger$BleLoggerInterface;", "mutex", "BleLoggerInterface", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BleLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BleLogger instance = new BleLogger();
    private BleLoggerInterface bleLoggerInterface;
    private final Object mutex = new Object();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/polar/androidcommunications/api/ble/BleLogger$BleLoggerInterface;", "", "", "tag", SDKConstants.PARAM_DEBUG_MESSAGE, "", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "e", "w", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BleLoggerInterface {
        void d(String tag, String msg);

        void e(String tag, String msg);

        void w(String tag, String msg);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/polar/androidcommunications/api/ble/BleLogger$Companion;", "", "<init>", "()V", "", "a", "", "byteArrayToHex", "([B)Ljava/lang/String;", "Lcom/polar/androidcommunications/api/ble/BleLogger$BleLoggerInterface;", "loggerInterface", "", "setLoggerInterface", "(Lcom/polar/androidcommunications/api/ble/BleLogger$BleLoggerInterface;)V", "tag", SDKConstants.PARAM_DEBUG_MESSAGE, "data", "d_hex", "(Ljava/lang/String;Ljava/lang/String;[B)V", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "e", "w", "Lcom/polar/androidcommunications/api/ble/BleLogger;", "instance", "Lcom/polar/androidcommunications/api/ble/BleLogger;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String byteArrayToHex(byte[] a) {
            a.getClass();
            StringBuilder sb = new StringBuilder(a.length * 2);
            for (byte b : a) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                sb.append(String.format("%02X ", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1)));
            }
            return sb.toString();
        }

        public final void d(String tag, String msg) {
            tag.getClass();
            msg.getClass();
            synchronized (BleLogger.instance.mutex) {
                BleLoggerInterface bleLoggerInterface = BleLogger.instance.bleLoggerInterface;
                if (bleLoggerInterface != null) {
                    bleLoggerInterface.d(tag, msg);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final void d_hex(String tag, String msg, byte[] data2) {
            tag.getClass();
            msg.getClass();
            data2.getClass();
            synchronized (BleLogger.instance.mutex) {
                BleLoggerInterface bleLoggerInterface = BleLogger.instance.bleLoggerInterface;
                if (bleLoggerInterface != null) {
                    bleLoggerInterface.d(tag, msg + " HEX: " + BleLogger.INSTANCE.byteArrayToHex(data2));
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final void e(String tag, String msg) {
            tag.getClass();
            msg.getClass();
            synchronized (BleLogger.instance.mutex) {
                BleLoggerInterface bleLoggerInterface = BleLogger.instance.bleLoggerInterface;
                if (bleLoggerInterface != null) {
                    bleLoggerInterface.e(tag, msg);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final void setLoggerInterface(BleLoggerInterface loggerInterface) {
            synchronized (BleLogger.instance.mutex) {
                BleLogger.instance.bleLoggerInterface = loggerInterface;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void w(String tag, String msg) {
            tag.getClass();
            msg.getClass();
            synchronized (BleLogger.instance.mutex) {
                BleLoggerInterface bleLoggerInterface = BleLogger.instance.bleLoggerInterface;
                if (bleLoggerInterface != null) {
                    bleLoggerInterface.w(tag, msg);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        private Companion() {
        }
    }

    public static final void d(String str, String str2) {
        INSTANCE.d(str, str2);
    }

    public static final void e(String str, String str2) {
        INSTANCE.e(str, str2);
    }

    public static final void w(String str, String str2) {
        INSTANCE.w(str, str2);
    }
}
