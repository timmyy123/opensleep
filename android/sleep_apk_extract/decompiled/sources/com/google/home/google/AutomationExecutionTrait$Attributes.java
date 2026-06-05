package com.google.home.google;

import com.google.home.platform.traits.automation.AutomationExecutionTrait;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"com/google/home/google/AutomationExecutionTrait$Attributes", "", "", "getRunning", "()Ljava/lang/Boolean;", "running", "Companion", "home.platform.traits.automation_automation_execution_trait_kmp_library-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AutomationExecutionTrait$Attributes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/AutomationExecutionTrait$Attributes$Companion;", "Lcom/google/home/google/Parser;", "Lcom/google/home/google/AutomationExecutionTrait$Attributes;", "<init>", "()V", "", "byteArray", "parseFrom", "([B)Lcom/google/home/google/AutomationExecutionTrait$Attributes;", "home.platform.traits.automation_automation_execution_trait_kmp_library-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements Parser<AutomationExecutionTrait$Attributes> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.home.google.Parser
        public AutomationExecutionTrait$Attributes parseFrom(byte[] byteArray) {
            byteArray.getClass();
            AutomationExecutionTrait from = AutomationExecutionTrait.parseFrom(byteArray);
            from.getClass();
            final Boolean boolValueOf = Boolean.valueOf(from.getRunning());
            return new AutomationExecutionTrait$Attributes(boolValueOf) { // from class: com.google.home.google.AutomationExecutionTrait$AttributesImpl
                private final Boolean running;

                {
                    this.running = boolValueOf;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof AutomationExecutionTrait$AttributesImpl) && Intrinsics.areEqual(this.running, ((AutomationExecutionTrait$AttributesImpl) other).running);
                }

                @Override // com.google.home.google.AutomationExecutionTrait$Attributes
                public Boolean getRunning() {
                    return this.running;
                }

                public int hashCode() {
                    Boolean bool = this.running;
                    if (bool == null) {
                        return 0;
                    }
                    return bool.hashCode();
                }

                public String toString() {
                    return zzf.zza(this.running, "AttributesImpl(running=", (byte) 24, ")");
                }
            };
        }
    }

    Boolean getRunning();
}
