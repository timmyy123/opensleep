package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MapValue extends zzzg<MapValue, Builder> implements zzaar {
    private static final MapValue DEFAULT_INSTANCE;
    public static final int ENTRIES_FIELD_NUMBER = 1;
    private static volatile zzaay<MapValue> PARSER;
    private zzzs<Entry> entries_ = zzzg.emptyProtobufList();

    static {
        MapValue mapValue = new MapValue();
        DEFAULT_INSTANCE = mapValue;
        zzzg.registerDefaultInstance(MapValue.class, mapValue);
    }

    private MapValue() {
    }

    public static MapValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"entries_", Entry.class});
        }
        if (iOrdinal == 3) {
            return new MapValue();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new Builder(bArr);
        }
        if (iOrdinal == 5) {
            return DEFAULT_INSTANCE;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay<MapValue> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (MapValue.class) {
            try {
                zzyzVar = PARSER;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(DEFAULT_INSTANCE);
                    PARSER = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public List<Entry> getEntriesList() {
        return this.entries_;
    }

    public static final class Entry extends zzzg<Entry, Builder> implements zzaar {
        private static final Entry DEFAULT_INSTANCE;
        public static final int KEY_FIELD_NUMBER = 1;
        private static volatile zzaay<Entry> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private Value key_;
        private Value value_;

        static {
            Entry entry = new Entry();
            DEFAULT_INSTANCE = entry;
            zzzg.registerDefaultInstance(Entry.class, entry);
        }

        private Entry() {
        }

        @Override // com.google.android.gms.internal.serialization.zzzg
        public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
            zzaay zzyzVar;
            int iOrdinal = zzzfVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "key_", "value_"});
            }
            if (iOrdinal == 3) {
                return new Entry();
            }
            byte[] bArr = null;
            if (iOrdinal == 4) {
                return new Builder(bArr);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzaay<Entry> zzaayVar = PARSER;
            if (zzaayVar != null) {
                return zzaayVar;
            }
            synchronized (Entry.class) {
                try {
                    zzyzVar = PARSER;
                    if (zzyzVar == null) {
                        zzyzVar = new zzyz(DEFAULT_INSTANCE);
                        PARSER = zzyzVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzyzVar;
        }

        public Value getKey() {
            Value value = this.key_;
            return value == null ? Value.getDefaultInstance() : value;
        }

        public Value getValue() {
            Value value = this.value_;
            return value == null ? Value.getDefaultInstance() : value;
        }

        public static final class Builder extends zzyy<Entry, Builder> implements zzaar {
            private Builder() {
                super(Entry.DEFAULT_INSTANCE);
            }

            public /* synthetic */ Builder(byte[] bArr) {
                this();
            }
        }
    }

    public static final class Builder extends zzyy<MapValue, Builder> implements zzaar {
        private Builder() {
            super(MapValue.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
