package com.google.home.platform.traits.automation;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzace;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzze;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.home.platform.traits.Trait;

/* JADX INFO: loaded from: classes4.dex */
public final class AutomationExecutionTrait extends zzzg<AutomationExecutionTrait, Builder> implements zzaar {
    private static final AutomationExecutionTrait DEFAULT_INSTANCE;
    private static volatile zzaay<AutomationExecutionTrait> PARSER = null;
    public static final int RUNNING_FIELD_NUMBER = 1;
    public static final int TRAIT_EXT_FIELD_NUMBER = 39;
    public static final zzze<Trait, AutomationExecutionTrait> traitExt;
    private boolean running_;

    static {
        AutomationExecutionTrait automationExecutionTrait = new AutomationExecutionTrait();
        DEFAULT_INSTANCE = automationExecutionTrait;
        zzzg.registerDefaultInstance(AutomationExecutionTrait.class, automationExecutionTrait);
        traitExt = zzzg.newSingularGeneratedExtension(Trait.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 39, zzace.zzk, AutomationExecutionTrait.class);
    }

    private AutomationExecutionTrait() {
    }

    public static AutomationExecutionTrait getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static AutomationExecutionTrait parseFrom(byte[] bArr) {
        return (AutomationExecutionTrait) zzzg.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"running_"});
        }
        if (iOrdinal == 3) {
            return new AutomationExecutionTrait();
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
        zzaay<AutomationExecutionTrait> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (AutomationExecutionTrait.class) {
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

    public boolean getRunning() {
        return this.running_;
    }

    public static final class Builder extends zzyy<AutomationExecutionTrait, Builder> implements zzaar {
        private Builder() {
            super(AutomationExecutionTrait.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
