package com.google.home.matter.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\bf\u0018\u0000 \u000b*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001\u000bJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00018\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/google/home/matter/serialization/FieldAdapter;", "RAW", "", "RUNTIME", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "toRaw", SDKConstants.PARAM_VALUE, "(Ljava/lang/Object;)Ljava/lang/Object;", "toRuntime", "Companion", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FieldAdapter<RAW, RUNTIME> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/google/home/matter/serialization/FieldAdapter$Companion;", "", "<init>", "()V", "ULONG_UBYTE", "Lcom/google/home/matter/serialization/FunctionAdapter;", "Lkotlin/ULong;", "Lkotlin/UByte;", "getULONG_UBYTE", "()Lcom/google/home/matter/serialization/FunctionAdapter;", "ULONG_UINT", "Lkotlin/UInt;", "getULONG_UINT", "ULONG_USHORT", "Lkotlin/UShort;", "getULONG_USHORT", "LONG_BYTE", "", "", "getLONG_BYTE", "LONG_INT", "", "getLONG_INT", "LONG_SHORT", "", "getLONG_SHORT", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final FunctionAdapter<ULong, UByte> ULONG_UBYTE = new FunctionAdapter<>(FieldAdapter$Companion$ULONG_UBYTE$1.INSTANCE, FieldAdapter$Companion$ULONG_UBYTE$2.INSTANCE);
        private static final FunctionAdapter<ULong, UInt> ULONG_UINT = new FunctionAdapter<>(FieldAdapter$Companion$ULONG_UINT$1.INSTANCE, FieldAdapter$Companion$ULONG_UINT$2.INSTANCE);
        private static final FunctionAdapter<ULong, UShort> ULONG_USHORT = new FunctionAdapter<>(FieldAdapter$Companion$ULONG_USHORT$1.INSTANCE, FieldAdapter$Companion$ULONG_USHORT$2.INSTANCE);
        private static final FunctionAdapter<Long, Byte> LONG_BYTE = new FunctionAdapter<>(FieldAdapter$Companion$LONG_BYTE$1.INSTANCE, FieldAdapter$Companion$LONG_BYTE$2.INSTANCE);
        private static final FunctionAdapter<Long, Integer> LONG_INT = new FunctionAdapter<>(FieldAdapter$Companion$LONG_INT$1.INSTANCE, FieldAdapter$Companion$LONG_INT$2.INSTANCE);
        private static final FunctionAdapter<Long, Short> LONG_SHORT = new FunctionAdapter<>(FieldAdapter$Companion$LONG_SHORT$1.INSTANCE, FieldAdapter$Companion$LONG_SHORT$2.INSTANCE);

        private Companion() {
        }

        public final FunctionAdapter<Long, Byte> getLONG_BYTE() {
            return LONG_BYTE;
        }

        public final FunctionAdapter<Long, Integer> getLONG_INT() {
            return LONG_INT;
        }

        public final FunctionAdapter<Long, Short> getLONG_SHORT() {
            return LONG_SHORT;
        }

        public final FunctionAdapter<ULong, UByte> getULONG_UBYTE() {
            return ULONG_UBYTE;
        }

        public final FunctionAdapter<ULong, UInt> getULONG_UINT() {
            return ULONG_UINT;
        }

        public final FunctionAdapter<ULong, UShort> getULONG_USHORT() {
            return ULONG_USHORT;
        }
    }

    default RUNTIME getDefaultValue() {
        return null;
    }

    RAW toRaw(RUNTIME value);

    RUNTIME toRuntime(RAW value);
}
