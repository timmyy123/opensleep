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
public final class StringAllowListConstraint extends zzzg<StringAllowListConstraint, Builder> implements zzaar {
    public static final int CASE_SENSITIVE_FIELD_NUMBER = 2;
    private static final StringAllowListConstraint DEFAULT_INSTANCE;
    private static volatile zzaay<StringAllowListConstraint> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean caseSensitive_;
    private zzzs<String> values_ = zzzg.emptyProtobufList();

    static {
        StringAllowListConstraint stringAllowListConstraint = new StringAllowListConstraint();
        DEFAULT_INSTANCE = stringAllowListConstraint;
        zzzg.registerDefaultInstance(StringAllowListConstraint.class, stringAllowListConstraint);
    }

    private StringAllowListConstraint() {
    }

    public static StringAllowListConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002\u0007", new Object[]{"values_", "caseSensitive_"});
        }
        if (iOrdinal == 3) {
            return new StringAllowListConstraint();
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
        zzaay<StringAllowListConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (StringAllowListConstraint.class) {
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

    public boolean getCaseSensitive() {
        return this.caseSensitive_;
    }

    public List<String> getValuesList() {
        return this.values_;
    }

    public static final class Builder extends zzyy<StringAllowListConstraint, Builder> implements zzaar {
        private Builder() {
            super(StringAllowListConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
