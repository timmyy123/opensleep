package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzk;
import com.google.android.gms.internal.serialization.zzzl;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class ValidationResult extends zzzg<ValidationResult, Builder> implements zzaar {
    private static final ValidationResult DEFAULT_INSTANCE;
    public static final int EXPRESSION_ID_FIELD_NUMBER = 5;
    public static final int ISSUE_FIELD_NUMBER = 2;
    public static final int ISSUE_TYPE_FIELD_NUMBER = 4;
    public static final int NODE_ID_FIELD_NUMBER = 3;
    private static volatile zzaay<ValidationResult> PARSER = null;
    public static final int SEVERITY_FIELD_NUMBER = 1;
    private int bitField0_;
    private ValidationIssue issue_;
    private int severity_;
    private String issueType_ = "";
    private String nodeId_ = "";
    private String expressionId_ = "";

    public enum Severity implements zzzk {
        SEVERITY_UNKNOWN(0),
        ERROR(1),
        WARNING(2),
        UNRECOGNIZED(-1);

        private static final zzzl<Severity> internalValueMap = new zzzl<Severity>() { // from class: com.google.home.platform.traits.ValidationResult.Severity.1
            @Override // com.google.android.gms.internal.serialization.zzzl
            public Severity findValueByNumber(int i) {
                return Severity.forNumber(i);
            }
        };
        private final int value;

        Severity(int i) {
            this.value = i;
        }

        public static Severity forNumber(int i) {
            if (i == 0) {
                return SEVERITY_UNKNOWN;
            }
            if (i == 1) {
                return ERROR;
            }
            if (i != 2) {
                return null;
            }
            return WARNING;
        }

        @Override // com.google.android.gms.internal.serialization.zzzk
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
            return 0;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(getNumber());
        }
    }

    static {
        ValidationResult validationResult = new ValidationResult();
        DEFAULT_INSTANCE = validationResult;
        zzzg.registerDefaultInstance(ValidationResult.class, validationResult);
    }

    private ValidationResult() {
    }

    public static ValidationResult parseFrom(byte[] bArr) {
        return (ValidationResult) zzzg.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003ለ\u0001\u0004Ȉ\u0005ለ\u0002", new Object[]{"bitField0_", "severity_", "issue_", "nodeId_", "issueType_", "expressionId_"});
        }
        if (iOrdinal == 3) {
            return new ValidationResult();
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
        zzaay<ValidationResult> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ValidationResult.class) {
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

    public String getExpressionId() {
        return this.expressionId_;
    }

    public ValidationIssue getIssue() {
        ValidationIssue validationIssue = this.issue_;
        return validationIssue == null ? ValidationIssue.getDefaultInstance() : validationIssue;
    }

    public String getIssueType() {
        return this.issueType_;
    }

    public String getNodeId() {
        return this.nodeId_;
    }

    public Severity getSeverity() {
        Severity severityForNumber = Severity.forNumber(this.severity_);
        return severityForNumber == null ? Severity.UNRECOGNIZED : severityForNumber;
    }

    public static final class Builder extends zzyy<ValidationResult, Builder> implements zzaar {
        private Builder() {
            super(ValidationResult.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
