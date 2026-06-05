package io.rebble.pebblekit2.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\t\u0005\u0006\u0007\b\t\n\u000b\f\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "", "<init>", "()V", "Companion", "Bytes", "Text", "Int8", "UInt8", "Int16", "UInt16", "Int32", "UInt32", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Bytes;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Int16;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Int32;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Int8;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Text;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$UInt16;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$UInt32;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$UInt8;", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PebbleDictionaryItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Bytes;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "", SDKConstants.PARAM_VALUE, "<init>", "([B)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "[B", "getValue", "()[B", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Bytes extends PebbleDictionaryItem {
        private final byte[] value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bytes(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.value = bArr;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Bytes) && Arrays.equals(getValue(), ((Bytes) other).getValue());
        }

        public byte[] getValue() {
            return this.value;
        }

        public int hashCode() {
            return Arrays.hashCode(getValue());
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("Bytes(value=", Arrays.toString(this.value), ")");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Companion;", "", "<init>", "()V", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Int16;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "", SDKConstants.PARAM_VALUE, "<init>", "(S)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "S", "getValue", "()Ljava/lang/Short;", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Int16 extends PebbleDictionaryItem {
        private final short value;

        public Int16(short s) {
            super(null);
            this.value = s;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Int16) && this.value == ((Int16) other).value;
        }

        public Short getValue() {
            return Short.valueOf(this.value);
        }

        public int hashCode() {
            return Short.hashCode(this.value);
        }

        public String toString() {
            return Fragment$$ExternalSyntheticOutline1.m((int) this.value, "Int16(value=", ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Int32;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "", SDKConstants.PARAM_VALUE, "<init>", "(I)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getValue", "()Ljava/lang/Integer;", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Int32 extends PebbleDictionaryItem {
        private final int value;

        public Int32(int i) {
            super(null);
            this.value = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Int32) && this.value == ((Int32) other).value;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        public String toString() {
            return Fragment$$ExternalSyntheticOutline1.m(this.value, "Int32(value=", ")");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Int8;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "", SDKConstants.PARAM_VALUE, "<init>", "(B)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "B", "getValue", "()Ljava/lang/Byte;", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Int8 extends PebbleDictionaryItem {
        private final byte value;

        public Int8(byte b) {
            super(null);
            this.value = b;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Int8) && this.value == ((Int8) other).value;
        }

        public Byte getValue() {
            return Byte.valueOf(this.value);
        }

        public int hashCode() {
            return Byte.hashCode(this.value);
        }

        public String toString() {
            return Fragment$$ExternalSyntheticOutline1.m((int) this.value, "Int8(value=", ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Text;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "", SDKConstants.PARAM_VALUE, "<init>", "(Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValue", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Text extends PebbleDictionaryItem {
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(String str) {
            super(null);
            str.getClass();
            this.value = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Text) && Intrinsics.areEqual(this.value, ((Text) other).value);
        }

        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("Text(value=", this.value, ")");
        }
    }

    public /* synthetic */ PebbleDictionaryItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PebbleDictionaryItem() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$UInt16;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "Lkotlin/UShort;", SDKConstants.PARAM_VALUE, "<init>", "(SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "S", "getValue-Mh2AYeg", "()S", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class UInt16 extends PebbleDictionaryItem {
        private final short value;

        private UInt16(short s) {
            super(null);
            this.value = s;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UInt16) && this.value == ((UInt16) other).value;
        }

        /* JADX INFO: renamed from: getValue-Mh2AYeg, reason: not valid java name and from getter */
        public short getValue() {
            return this.value;
        }

        public int hashCode() {
            return UShort.m2435hashCodeimpl(this.value);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("UInt16(value=", UShort.m2436toStringimpl(this.value), ")");
        }

        public /* synthetic */ UInt16(short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(s);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$UInt32;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "Lkotlin/UInt;", SDKConstants.PARAM_VALUE, "<init>", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getValue-pVg5ArA", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class UInt32 extends PebbleDictionaryItem {
        private final int value;

        private UInt32(int i) {
            super(null);
            this.value = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UInt32) && this.value == ((UInt32) other).value;
        }

        /* JADX INFO: renamed from: getValue-pVg5ArA, reason: not valid java name and from getter */
        public int getValue() {
            return this.value;
        }

        public int hashCode() {
            return UInt.m2391hashCodeimpl(this.value);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("UInt32(value=", UInt.m2392toStringimpl(this.value), ")");
        }

        public /* synthetic */ UInt32(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$UInt8;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "", SDKConstants.PARAM_VALUE, "<init>", "(I)V", "Lkotlin/UByte;", "(BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "B", "getValue-w2LRezQ", "()B", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class UInt8 extends PebbleDictionaryItem {
        private final byte value;

        public UInt8(int i) {
            this(UByte.m2367constructorimpl((byte) i), null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UInt8) && this.value == ((UInt8) other).value;
        }

        /* JADX INFO: renamed from: getValue-w2LRezQ, reason: not valid java name and from getter */
        public byte getValue() {
            return this.value;
        }

        public int hashCode() {
            return UByte.m2369hashCodeimpl(this.value);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("UInt8(value=", UByte.m2370toStringimpl(this.value), ")");
        }

        private UInt8(byte b) {
            super(null);
            this.value = b;
        }

        public /* synthetic */ UInt8(byte b, DefaultConstructorMarker defaultConstructorMarker) {
            this(b);
        }
    }
}
