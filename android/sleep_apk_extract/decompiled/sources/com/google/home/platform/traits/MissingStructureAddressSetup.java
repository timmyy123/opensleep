package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class MissingStructureAddressSetup extends zzzg<MissingStructureAddressSetup, Builder> implements zzaar {
    private static final MissingStructureAddressSetup DEFAULT_INSTANCE;
    private static volatile zzaay<MissingStructureAddressSetup> PARSER;

    static {
        MissingStructureAddressSetup missingStructureAddressSetup = new MissingStructureAddressSetup();
        DEFAULT_INSTANCE = missingStructureAddressSetup;
        zzzg.registerDefaultInstance(MissingStructureAddressSetup.class, missingStructureAddressSetup);
    }

    private MissingStructureAddressSetup() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        byte[] bArr = null;
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0000", null);
        }
        if (iOrdinal == 3) {
            return new MissingStructureAddressSetup();
        }
        if (iOrdinal == 4) {
            return new Builder(bArr);
        }
        if (iOrdinal == 5) {
            return DEFAULT_INSTANCE;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay<MissingStructureAddressSetup> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (MissingStructureAddressSetup.class) {
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

    public static final class Builder extends zzyy<MissingStructureAddressSetup, Builder> implements zzaar {
        private Builder() {
            super(MissingStructureAddressSetup.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
