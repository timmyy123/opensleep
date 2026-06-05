package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\u0005¨\u0006&"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse;", "", "", "data", "<init>", "([B)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "responseCode", "B", InAppPurchaseConstants.METHOD_GET_RESPONSE_CODE, "()B", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandClientToService;", "opCode", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandClientToService;", "getOpCode", "()Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandClientToService;", "measurementType", "getMeasurementType", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse$PmdControlPointResponseCode;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse$PmdControlPointResponseCode;", "getStatus", "()Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse$PmdControlPointResponseCode;", "", "more", "Z", "getMore", "()Z", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "[B", "getParameters", "()[B", "setParameters", "Companion", "PmdControlPointResponseCode", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdControlPointResponse {
    private final byte measurementType;
    private final boolean more;
    private final PmdControlPointCommandClientToService opCode;
    private byte[] parameters;
    private final byte responseCode;
    private final PmdControlPointResponseCode status;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse$PmdControlPointResponseCode;", "", "", "numVal", "<init>", "(Ljava/lang/String;II)V", "I", "getNumVal", "()I", "SUCCESS", "ERROR_INVALID_OP_CODE", "ERROR_INVALID_MEASUREMENT_TYPE", "ERROR_NOT_SUPPORTED", "ERROR_INVALID_LENGTH", "ERROR_INVALID_PARAMETER", "ERROR_ALREADY_IN_STATE", "ERROR_INVALID_RESOLUTION", "ERROR_INVALID_SAMPLE_RATE", "ERROR_INVALID_RANGE", "ERROR_INVALID_MTU", "ERROR_INVALID_NUMBER_OF_CHANNELS", "ERROR_INVALID_STATE", "ERROR_DEVICE_IN_CHARGER", "ERROR_DISK_FULL", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PmdControlPointResponseCode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PmdControlPointResponseCode[] $VALUES;
        private final int numVal;
        public static final PmdControlPointResponseCode SUCCESS = new PmdControlPointResponseCode("SUCCESS", 0, 0);
        public static final PmdControlPointResponseCode ERROR_INVALID_OP_CODE = new PmdControlPointResponseCode("ERROR_INVALID_OP_CODE", 1, 1);
        public static final PmdControlPointResponseCode ERROR_INVALID_MEASUREMENT_TYPE = new PmdControlPointResponseCode("ERROR_INVALID_MEASUREMENT_TYPE", 2, 2);
        public static final PmdControlPointResponseCode ERROR_NOT_SUPPORTED = new PmdControlPointResponseCode("ERROR_NOT_SUPPORTED", 3, 3);
        public static final PmdControlPointResponseCode ERROR_INVALID_LENGTH = new PmdControlPointResponseCode("ERROR_INVALID_LENGTH", 4, 4);
        public static final PmdControlPointResponseCode ERROR_INVALID_PARAMETER = new PmdControlPointResponseCode("ERROR_INVALID_PARAMETER", 5, 5);
        public static final PmdControlPointResponseCode ERROR_ALREADY_IN_STATE = new PmdControlPointResponseCode("ERROR_ALREADY_IN_STATE", 6, 6);
        public static final PmdControlPointResponseCode ERROR_INVALID_RESOLUTION = new PmdControlPointResponseCode("ERROR_INVALID_RESOLUTION", 7, 7);
        public static final PmdControlPointResponseCode ERROR_INVALID_SAMPLE_RATE = new PmdControlPointResponseCode("ERROR_INVALID_SAMPLE_RATE", 8, 8);
        public static final PmdControlPointResponseCode ERROR_INVALID_RANGE = new PmdControlPointResponseCode("ERROR_INVALID_RANGE", 9, 9);
        public static final PmdControlPointResponseCode ERROR_INVALID_MTU = new PmdControlPointResponseCode("ERROR_INVALID_MTU", 10, 10);
        public static final PmdControlPointResponseCode ERROR_INVALID_NUMBER_OF_CHANNELS = new PmdControlPointResponseCode("ERROR_INVALID_NUMBER_OF_CHANNELS", 11, 11);
        public static final PmdControlPointResponseCode ERROR_INVALID_STATE = new PmdControlPointResponseCode("ERROR_INVALID_STATE", 12, 12);
        public static final PmdControlPointResponseCode ERROR_DEVICE_IN_CHARGER = new PmdControlPointResponseCode("ERROR_DEVICE_IN_CHARGER", 13, 13);
        public static final PmdControlPointResponseCode ERROR_DISK_FULL = new PmdControlPointResponseCode("ERROR_DISK_FULL", 14, 14);

        private static final /* synthetic */ PmdControlPointResponseCode[] $values() {
            return new PmdControlPointResponseCode[]{SUCCESS, ERROR_INVALID_OP_CODE, ERROR_INVALID_MEASUREMENT_TYPE, ERROR_NOT_SUPPORTED, ERROR_INVALID_LENGTH, ERROR_INVALID_PARAMETER, ERROR_ALREADY_IN_STATE, ERROR_INVALID_RESOLUTION, ERROR_INVALID_SAMPLE_RATE, ERROR_INVALID_RANGE, ERROR_INVALID_MTU, ERROR_INVALID_NUMBER_OF_CHANNELS, ERROR_INVALID_STATE, ERROR_DEVICE_IN_CHARGER, ERROR_DISK_FULL};
        }

        static {
            PmdControlPointResponseCode[] pmdControlPointResponseCodeArr$values = $values();
            $VALUES = pmdControlPointResponseCodeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pmdControlPointResponseCodeArr$values);
        }

        private PmdControlPointResponseCode(String str, int i, int i2) {
            this.numVal = i2;
        }

        public static PmdControlPointResponseCode valueOf(String str) {
            return (PmdControlPointResponseCode) Enum.valueOf(PmdControlPointResponseCode.class, str);
        }

        public static PmdControlPointResponseCode[] values() {
            return (PmdControlPointResponseCode[]) $VALUES.clone();
        }
    }

    public PmdControlPointResponse(byte[] bArr) {
        bArr.getClass();
        boolean z = false;
        this.responseCode = bArr[0];
        this.opCode = PmdControlPointCommandClientToService.values()[bArr[1]];
        this.measurementType = bArr[2];
        PmdControlPointResponseCode pmdControlPointResponseCode = PmdControlPointResponseCode.values()[bArr[3]];
        this.status = pmdControlPointResponseCode;
        byte[] bArrCopyOfRange = new byte[0];
        if (pmdControlPointResponseCode == PmdControlPointResponseCode.SUCCESS) {
            if (bArr.length > 4 && bArr[4] != 0) {
                z = true;
            }
            this.more = z;
            if (bArr.length > 5) {
                bArrCopyOfRange = ArraysKt.copyOfRange(bArr, 5, bArr.length);
            }
        } else {
            this.more = false;
        }
        this.parameters = bArrCopyOfRange;
    }

    public final boolean getMore() {
        return this.more;
    }

    public final byte[] getParameters() {
        return this.parameters;
    }

    public final PmdControlPointResponseCode getStatus() {
        return this.status;
    }

    public final void setParameters(byte[] bArr) {
        bArr.getClass();
        this.parameters = bArr;
    }

    public String toString() {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(this.responseCode)}, 1));
        PmdControlPointCommandClientToService pmdControlPointCommandClientToService = this.opCode;
        byte b = this.measurementType;
        return "\nresponseCode: " + str + "\nopCode: " + pmdControlPointCommandClientToService + "\nmeasurementType: " + ((int) b) + "\nstatus: " + this.status + "\nmore: " + this.more + "\nparameters: " + ArraysKt___ArraysKt.joinToString$default(this.parameters, (CharSequence) " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdControlPointResponse.toString.1
            public final CharSequence invoke(byte b2) {
                return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b2) {
                return invoke(b2.byteValue());
            }
        }, 30, (Object) null);
    }
}
