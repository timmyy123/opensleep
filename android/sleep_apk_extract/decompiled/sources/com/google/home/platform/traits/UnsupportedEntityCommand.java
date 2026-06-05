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
public final class UnsupportedEntityCommand extends zzzg<UnsupportedEntityCommand, Builder> implements zzaar {
    public static final int COMMAND_ID_FIELD_NUMBER = 1;
    private static final UnsupportedEntityCommand DEFAULT_INSTANCE;
    public static final int ENTITY_OBJECT_ID_FIELD_NUMBER = 5;
    public static final int ENTITY_TYPE_FIELD_NUMBER = 6;
    private static volatile zzaay<UnsupportedEntityCommand> PARSER = null;
    public static final int UNSUPPORTED_REASONS_FIELD_NUMBER = 4;
    private String commandId_ = "";
    private zzzs<UnsupportedCandidateReason> unsupportedReasons_ = zzzg.emptyProtobufList();
    private String entityObjectId_ = "";
    private String entityType_ = "";

    static {
        UnsupportedEntityCommand unsupportedEntityCommand = new UnsupportedEntityCommand();
        DEFAULT_INSTANCE = unsupportedEntityCommand;
        zzzg.registerDefaultInstance(UnsupportedEntityCommand.class, unsupportedEntityCommand);
    }

    private UnsupportedEntityCommand() {
    }

    public static UnsupportedEntityCommand getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0004\u0000\u0000\u0001\u0006\u0004\u0000\u0001\u0000\u0001Ȉ\u0004\u001b\u0005Ȉ\u0006Ȉ", new Object[]{"commandId_", "unsupportedReasons_", UnsupportedCandidateReason.class, "entityObjectId_", "entityType_"});
        }
        if (iOrdinal == 3) {
            return new UnsupportedEntityCommand();
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
        zzaay<UnsupportedEntityCommand> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedEntityCommand.class) {
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

    public String getCommandId() {
        return this.commandId_;
    }

    public String getEntityObjectId() {
        return this.entityObjectId_;
    }

    public String getEntityType() {
        return this.entityType_;
    }

    public List<UnsupportedCandidateReason> getUnsupportedReasonsList() {
        return this.unsupportedReasons_;
    }

    public static final class Builder extends zzyy<UnsupportedEntityCommand, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedEntityCommand.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
