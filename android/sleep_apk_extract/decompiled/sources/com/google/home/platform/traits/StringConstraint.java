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
public final class StringConstraint extends zzzg<StringConstraint, Builder> implements zzaar {
    private static final StringConstraint DEFAULT_INSTANCE;
    public static final int DISALLOWED_VALUES_CASE_SENSITIVE_FIELD_NUMBER = 5;
    public static final int DISALLOWED_VALUES_FIELD_NUMBER = 3;
    public static final int MAX_LENGTH_FIELD_NUMBER = 1;
    public static final int MIN_LENGTH_FIELD_NUMBER = 2;
    private static volatile zzaay<StringConstraint> PARSER = null;
    public static final int REGEX_FIELD_NUMBER = 4;
    private int bitField0_;
    private boolean disallowedValuesCaseSensitive_;
    private int maxLength_;
    private int minLength_;
    private zzzs<String> disallowedValues_ = zzzg.emptyProtobufList();
    private String regex_ = "";

    static {
        StringConstraint stringConstraint = new StringConstraint();
        DEFAULT_INSTANCE = stringConstraint;
        zzzg.registerDefaultInstance(StringConstraint.class, stringConstraint);
    }

    private StringConstraint() {
    }

    public static StringConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003Ț\u0004ለ\u0002\u0005\u0007", new Object[]{"bitField0_", "maxLength_", "minLength_", "disallowedValues_", "regex_", "disallowedValuesCaseSensitive_"});
        }
        if (iOrdinal == 3) {
            return new StringConstraint();
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
        zzaay<StringConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (StringConstraint.class) {
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

    public boolean getDisallowedValuesCaseSensitive() {
        return this.disallowedValuesCaseSensitive_;
    }

    public List<String> getDisallowedValuesList() {
        return this.disallowedValues_;
    }

    public int getMaxLength() {
        return this.maxLength_;
    }

    public int getMinLength() {
        return this.minLength_;
    }

    public String getRegex() {
        return this.regex_;
    }

    public boolean hasMaxLength() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMinLength() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRegex() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends zzyy<StringConstraint, Builder> implements zzaar {
        private Builder() {
            super(StringConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
