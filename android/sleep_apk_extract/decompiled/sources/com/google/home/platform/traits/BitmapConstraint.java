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
public final class BitmapConstraint extends zzzg<BitmapConstraint, Builder> implements zzaar {
    public static final int COMBINED_BITS_FIELD_NUMBER = 1;
    private static final BitmapConstraint DEFAULT_INSTANCE;
    private static volatile zzaay<BitmapConstraint> PARSER = null;
    public static final int TYPE_ID_FIELD_NUMBER = 2;
    private zzzs<CombinedBitsDescriptor> combinedBits_ = zzzg.emptyProtobufList();
    private String typeId_ = "";

    static {
        BitmapConstraint bitmapConstraint = new BitmapConstraint();
        DEFAULT_INSTANCE = bitmapConstraint;
        zzzg.registerDefaultInstance(BitmapConstraint.class, bitmapConstraint);
    }

    private BitmapConstraint() {
    }

    public static BitmapConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"combinedBits_", CombinedBitsDescriptor.class, "typeId_"});
        }
        if (iOrdinal == 3) {
            return new BitmapConstraint();
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
        zzaay<BitmapConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (BitmapConstraint.class) {
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

    public List<CombinedBitsDescriptor> getCombinedBitsList() {
        return this.combinedBits_;
    }

    public static final class Builder extends zzyy<BitmapConstraint, Builder> implements zzaar {
        private Builder() {
            super(BitmapConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
