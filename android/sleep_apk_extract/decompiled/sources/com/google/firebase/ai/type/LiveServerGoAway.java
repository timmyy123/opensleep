package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerGoAway;", "Lcom/google/firebase/ai/type/LiveServerMessage;", "timeLeft", "Lkotlin/time/Duration;", "<init>", "(Lkotlin/time/Duration;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTimeLeft-FghU774", "()Lkotlin/time/Duration;", "Internal", "InternalWrapper", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveServerGoAway implements LiveServerMessage {
    private final Duration timeLeft;

    private LiveServerGoAway(Duration duration) {
        this.timeLeft = duration;
    }

    /* JADX INFO: renamed from: getTimeLeft-FghU774, reason: not valid java name and from getter */
    public final Duration getTimeLeft() {
        return this.timeLeft;
    }

    public /* synthetic */ LiveServerGoAway(Duration duration, DefaultConstructorMarker defaultConstructorMarker) {
        this(duration);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerGoAway$Internal;", "", "timeLeft", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTimeLeft", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String timeLeft;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerGoAway$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveServerGoAway$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return LiveServerGoAway$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.timeLeft = null;
            } else {
                this.timeLeft = str;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internal.timeLeft;
            }
            return internal.copy(str);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.timeLeft == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.timeLeft);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTimeLeft() {
            return this.timeLeft;
        }

        public final Internal copy(String timeLeft) {
            return new Internal(timeLeft);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Internal) && Intrinsics.areEqual(this.timeLeft, ((Internal) other).timeLeft);
        }

        public final String getTimeLeft() {
            return this.timeLeft;
        }

        public int hashCode() {
            String str = this.timeLeft;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Internal(timeLeft="), this.timeLeft, ')');
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Internal() {
            this((String) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public Internal(String str) {
            this.timeLeft = str;
        }

        public /* synthetic */ Internal(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/google/firebase/ai/type/LiveServerGoAway$InternalWrapper;", "Lcom/google/firebase/ai/type/InternalLiveServerMessage;", "goAway", "Lcom/google/firebase/ai/type/LiveServerGoAway$Internal;", "<init>", "(Lcom/google/firebase/ai/type/LiveServerGoAway$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/LiveServerGoAway$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGoAway", "()Lcom/google/firebase/ai/type/LiveServerGoAway$Internal;", "toPublic", "Lcom/google/firebase/ai/type/LiveServerGoAway;", "component1", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InternalWrapper implements InternalLiveServerMessage {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Internal goAway;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerGoAway$InternalWrapper$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveServerGoAway$InternalWrapper;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<InternalWrapper> serializer() {
                return LiveServerGoAway$InternalWrapper$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ InternalWrapper(int i, Internal internal, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, LiveServerGoAway$InternalWrapper$$serializer.INSTANCE.getDescriptor());
            }
            this.goAway = internal;
        }

        public static /* synthetic */ InternalWrapper copy$default(InternalWrapper internalWrapper, Internal internal, int i, Object obj) {
            if ((i & 1) != 0) {
                internal = internalWrapper.goAway;
            }
            return internalWrapper.copy(internal);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Internal getGoAway() {
            return this.goAway;
        }

        public final InternalWrapper copy(Internal goAway) {
            goAway.getClass();
            return new InternalWrapper(goAway);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InternalWrapper) && Intrinsics.areEqual(this.goAway, ((InternalWrapper) other).goAway);
        }

        public final Internal getGoAway() {
            return this.goAway;
        }

        public int hashCode() {
            return this.goAway.hashCode();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
        @Override // com.google.firebase.ai.type.InternalLiveServerMessage
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public LiveServerGoAway toPublic() {
            Duration durationM2527boximpl;
            String strDropLast;
            Double doubleOrNull;
            String timeLeft = this.goAway.getTimeLeft();
            DefaultConstructorMarker defaultConstructorMarker = null;
            String string = timeLeft != null ? StringsKt.trim(timeLeft).toString() : null;
            if (string == null) {
                durationM2527boximpl = null;
            } else {
                if (!StringsKt__StringsJVMKt.endsWith$default(string, "s", false, 2, null)) {
                    string = null;
                }
                if (string != null && (strDropLast = StringsKt___StringsKt.dropLast(string, 1)) != null && (doubleOrNull = StringsKt.toDoubleOrNull(strDropLast)) != null) {
                    Duration.Companion companion = Duration.INSTANCE;
                    durationM2527boximpl = Duration.m2527boximpl(DurationKt.toDuration(doubleOrNull.doubleValue(), DurationUnit.SECONDS));
                }
            }
            return new LiveServerGoAway(durationM2527boximpl, defaultConstructorMarker);
        }

        public String toString() {
            return "InternalWrapper(goAway=" + this.goAway + ')';
        }

        public InternalWrapper(Internal internal) {
            internal.getClass();
            this.goAway = internal;
        }
    }
}
