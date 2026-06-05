package com.google.home.automation;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/automation/MissingPresenceSensingSetup;", "Lcom/google/home/automation/UnsupportedCandidateReason;", "Lcom/google/home/automation/MissingPresenceSensingSetup$SetupType;", "type", "<init>", "(Lcom/google/home/automation/MissingPresenceSensingSetup$SetupType;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/MissingPresenceSensingSetup$SetupType;", "getType", "()Lcom/google/home/automation/MissingPresenceSensingSetup$SetupType;", "SetupType", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MissingPresenceSensingSetup implements UnsupportedCandidateReason {
    private final SetupType type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/home/automation/MissingPresenceSensingSetup$SetupType;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "STRUCTURE_PRESENCE", "USER_PRESENCE", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetupType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SetupType[] $VALUES;
        public static final SetupType UNSPECIFIED = new SetupType("UNSPECIFIED", 0);
        public static final SetupType STRUCTURE_PRESENCE = new SetupType("STRUCTURE_PRESENCE", 1);
        public static final SetupType USER_PRESENCE = new SetupType("USER_PRESENCE", 2);

        private static final /* synthetic */ SetupType[] $values() {
            return new SetupType[]{UNSPECIFIED, STRUCTURE_PRESENCE, USER_PRESENCE};
        }

        static {
            SetupType[] setupTypeArr$values = $values();
            $VALUES = setupTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(setupTypeArr$values);
        }

        private SetupType(String str, int i) {
        }

        public static SetupType valueOf(String str) {
            return (SetupType) Enum.valueOf(SetupType.class, str);
        }

        public static SetupType[] values() {
            return (SetupType[]) $VALUES.clone();
        }
    }

    public MissingPresenceSensingSetup(SetupType setupType) {
        setupType.getClass();
        this.type = setupType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MissingPresenceSensingSetup) && this.type == ((MissingPresenceSensingSetup) other).type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return zzb.zza(this.type, "MissingPresenceSensingSetup(type=", (byte) 34);
    }
}
