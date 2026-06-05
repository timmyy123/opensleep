package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u000b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\n\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/home/matter/serialization/WireType;", "T", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "WireTypeUInt", "WireTypeInt", "WireTypeBool", "WireTypeFloat", "WireTypeDouble", "WireTypeBytes", "WireTypeString", "WireTypeNull", "WireTypeStruct", "WireTypeUnknown", "Lcom/google/home/matter/serialization/WireType$WireTypeBool;", "Lcom/google/home/matter/serialization/WireType$WireTypeBytes;", "Lcom/google/home/matter/serialization/WireType$WireTypeDouble;", "Lcom/google/home/matter/serialization/WireType$WireTypeFloat;", "Lcom/google/home/matter/serialization/WireType$WireTypeInt;", "Lcom/google/home/matter/serialization/WireType$WireTypeNull;", "Lcom/google/home/matter/serialization/WireType$WireTypeString;", "Lcom/google/home/matter/serialization/WireType$WireTypeStruct;", "Lcom/google/home/matter/serialization/WireType$WireTypeUInt;", "Lcom/google/home/matter/serialization/WireType$WireTypeUnknown;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class WireType<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/WireType$Companion;", "", "<init>", "()V", "valueOf", "Lcom/google/home/matter/serialization/WireType;", "name", "", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final WireType<? extends Object> valueOf(String name) {
            name.getClass();
            switch (name.hashCode()) {
                case -1838656495:
                    if (name.equals("STRING")) {
                        return WireTypeString.INSTANCE;
                    }
                    break;
                case -1838645291:
                    if (name.equals("STRUCT")) {
                        return WireTypeStruct.INSTANCE;
                    }
                    break;
                case 63:
                    if (name.equals("?")) {
                        return WireTypeUnknown.INSTANCE;
                    }
                    break;
                case 72655:
                    if (name.equals("INT")) {
                        return WireTypeInt.INSTANCE;
                    }
                    break;
                case 2044650:
                    if (name.equals("BOOL")) {
                        return WireTypeBool.INSTANCE;
                    }
                    break;
                case 2407815:
                    if (name.equals("NULL")) {
                        return WireTypeNull.INSTANCE;
                    }
                    break;
                case 2604890:
                    if (name.equals("UINT")) {
                        return WireTypeUInt.INSTANCE;
                    }
                    break;
                case 63686731:
                    if (name.equals("BYTES")) {
                        return WireTypeBytes.INSTANCE;
                    }
                    break;
                case 66988604:
                    if (name.equals("FLOAT")) {
                        return WireTypeFloat.INSTANCE;
                    }
                    break;
                case 2022338513:
                    if (name.equals("DOUBLE")) {
                        return WireTypeDouble.INSTANCE;
                    }
                    break;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("No such WireType : ".concat(name));
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeBool;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeBool extends WireType<Boolean> {
        public static final WireTypeBool INSTANCE = new WireTypeBool();

        private WireTypeBool() {
            super("BOOL", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeBytes;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeBytes extends WireType<byte[]> {
        public static final WireTypeBytes INSTANCE = new WireTypeBytes();

        private WireTypeBytes() {
            super("BYTES", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeDouble;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeDouble extends WireType<Double> {
        public static final WireTypeDouble INSTANCE = new WireTypeDouble();

        private WireTypeDouble() {
            super("DOUBLE", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeFloat;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeFloat extends WireType<Float> {
        public static final WireTypeFloat INSTANCE = new WireTypeFloat();

        private WireTypeFloat() {
            super("FLOAT", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeInt;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeInt extends WireType<Long> {
        public static final WireTypeInt INSTANCE = new WireTypeInt();

        private WireTypeInt() {
            super("INT", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeNull;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeNull extends WireType<Object> {
        public static final WireTypeNull INSTANCE = new WireTypeNull();

        private WireTypeNull() {
            super("NULL", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeString;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeString extends WireType<String> {
        public static final WireTypeString INSTANCE = new WireTypeString();

        private WireTypeString() {
            super("STRING", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeStruct;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeStruct extends WireType<Object> {
        public static final WireTypeStruct INSTANCE = new WireTypeStruct();

        private WireTypeStruct() {
            super("STRUCT", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeUInt;", "Lcom/google/home/matter/serialization/WireType;", "Lkotlin/ULong;", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeUInt extends WireType<ULong> {
        public static final WireTypeUInt INSTANCE = new WireTypeUInt();

        private WireTypeUInt() {
            super("UINT", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/matter/serialization/WireType$WireTypeUnknown;", "Lcom/google/home/matter/serialization/WireType;", "", "<init>", "()V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WireTypeUnknown extends WireType<Object> {
        public static final WireTypeUnknown INSTANCE = new WireTypeUnknown();

        private WireTypeUnknown() {
            super("?", null);
        }
    }

    private WireType(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ WireType(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
