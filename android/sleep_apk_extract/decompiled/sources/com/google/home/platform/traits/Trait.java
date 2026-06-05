package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzza;
import com.google.android.gms.internal.serialization.zzzc;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes3.dex */
public final class Trait extends zzzc<Trait, Builder> implements zzaar {
    private static final Trait DEFAULT_INSTANCE;
    private static volatile zzaay<Trait> PARSER;
    private byte memoizedIsInitialized = 2;

    static {
        Trait trait = new Trait();
        DEFAULT_INSTANCE = trait;
        zzzg.registerDefaultInstance(Trait.class, trait);
    }

    private Trait() {
    }

    public static Trait getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        byte[] bArr = null;
        switch (zzzfVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.memoizedIsInitialized);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.memoizedIsInitialized = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0000", null);
            case NEW_MUTABLE_INSTANCE:
                return new Trait();
            case NEW_BUILDER:
                return new Builder(bArr);
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                zzaay<Trait> zzaayVar = PARSER;
                if (zzaayVar != null) {
                    return zzaayVar;
                }
                synchronized (Trait.class) {
                    try {
                        zzyzVar = PARSER;
                        if (zzyzVar == null) {
                            zzyzVar = new zzyz(DEFAULT_INSTANCE);
                            PARSER = zzyzVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return zzyzVar;
            default:
                throw null;
        }
    }

    public static final class Builder extends zzza<Trait, Builder> implements zzaar {
        private Builder() {
            super(Trait.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
