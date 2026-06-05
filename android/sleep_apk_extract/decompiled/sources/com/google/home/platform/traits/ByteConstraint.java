package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class ByteConstraint extends zzzg<ByteConstraint, Builder> implements zzaar {
    private static final ByteConstraint DEFAULT_INSTANCE;
    public static final int MAX_LENGTH_FIELD_NUMBER = 2;
    public static final int MIN_LENGTH_FIELD_NUMBER = 1;
    private static volatile zzaay<ByteConstraint> PARSER;
    private int bitField0_;
    private int maxLength_;
    private int minLength_;

    static {
        ByteConstraint byteConstraint = new ByteConstraint();
        DEFAULT_INSTANCE = byteConstraint;
        zzzg.registerDefaultInstance(ByteConstraint.class, byteConstraint);
    }

    private ByteConstraint() {
    }

    public static ByteConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001", new Object[]{"bitField0_", "minLength_", "maxLength_"});
        }
        if (iOrdinal == 3) {
            return new ByteConstraint();
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
        zzaay<ByteConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ByteConstraint.class) {
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

    public int getMaxLength() {
        return this.maxLength_;
    }

    public int getMinLength() {
        return this.minLength_;
    }

    public boolean hasMaxLength() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMinLength() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends zzyy<ByteConstraint, Builder> implements zzaar {
        private Builder() {
            super(ByteConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
