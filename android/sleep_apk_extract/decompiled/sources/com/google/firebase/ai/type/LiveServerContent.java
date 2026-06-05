package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.Transcription;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B?\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerContent;", "Lcom/google/firebase/ai/type/LiveServerMessage;", "content", "Lcom/google/firebase/ai/type/Content;", "interrupted", "", "turnComplete", "generationComplete", "inputTranscription", "Lcom/google/firebase/ai/type/Transcription;", "outputTranscription", "<init>", "(Lcom/google/firebase/ai/type/Content;ZZZLcom/google/firebase/ai/type/Transcription;Lcom/google/firebase/ai/type/Transcription;)V", "getContent", "()Lcom/google/firebase/ai/type/Content;", "getInterrupted", "()Z", "getTurnComplete", "getGenerationComplete", "getInputTranscription", "()Lcom/google/firebase/ai/type/Transcription;", "getOutputTranscription", "Internal", "InternalWrapper", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveServerContent implements LiveServerMessage {
    private final Content content;
    private final boolean generationComplete;
    private final Transcription inputTranscription;
    private final boolean interrupted;
    private final Transcription outputTranscription;
    private final boolean turnComplete;

    public LiveServerContent(Content content, boolean z, boolean z2, boolean z3, Transcription transcription, Transcription transcription2) {
        this.content = content;
        this.interrupted = z;
        this.turnComplete = z2;
        this.generationComplete = z3;
        this.inputTranscription = transcription;
        this.outputTranscription = transcription2;
    }

    public final Content getContent() {
        return this.content;
    }

    public final boolean getGenerationComplete() {
        return this.generationComplete;
    }

    public final Transcription getInputTranscription() {
        return this.inputTranscription;
    }

    public final boolean getInterrupted() {
        return this.interrupted;
    }

    public final Transcription getOutputTranscription() {
        return this.outputTranscription;
    }

    public final boolean getTurnComplete() {
        return this.turnComplete;
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/google/firebase/ai/type/LiveServerContent$InternalWrapper;", "Lcom/google/firebase/ai/type/InternalLiveServerMessage;", "serverContent", "Lcom/google/firebase/ai/type/LiveServerContent$Internal;", "<init>", "(Lcom/google/firebase/ai/type/LiveServerContent$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/LiveServerContent$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getServerContent", "()Lcom/google/firebase/ai/type/LiveServerContent$Internal;", "toPublic", "Lcom/google/firebase/ai/type/LiveServerContent;", "component1", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InternalWrapper implements InternalLiveServerMessage {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Internal serverContent;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerContent$InternalWrapper$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveServerContent$InternalWrapper;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<InternalWrapper> serializer() {
                return LiveServerContent$InternalWrapper$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ InternalWrapper(int i, Internal internal, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, LiveServerContent$InternalWrapper$$serializer.INSTANCE.getDescriptor());
            }
            this.serverContent = internal;
        }

        public static /* synthetic */ InternalWrapper copy$default(InternalWrapper internalWrapper, Internal internal, int i, Object obj) {
            if ((i & 1) != 0) {
                internal = internalWrapper.serverContent;
            }
            return internalWrapper.copy(internal);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Internal getServerContent() {
            return this.serverContent;
        }

        public final InternalWrapper copy(Internal serverContent) {
            serverContent.getClass();
            return new InternalWrapper(serverContent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InternalWrapper) && Intrinsics.areEqual(this.serverContent, ((InternalWrapper) other).serverContent);
        }

        public final Internal getServerContent() {
            return this.serverContent;
        }

        public int hashCode() {
            return this.serverContent.hashCode();
        }

        @Override // com.google.firebase.ai.type.InternalLiveServerMessage
        public LiveServerContent toPublic() {
            Content.Internal modelTurn = this.serverContent.getModelTurn();
            Content public$com_google_firebase_ai_logic_firebase_ai = modelTurn != null ? modelTurn.toPublic$com_google_firebase_ai_logic_firebase_ai() : null;
            Boolean interrupted = this.serverContent.getInterrupted();
            boolean zBooleanValue = interrupted != null ? interrupted.booleanValue() : false;
            Boolean turnComplete = this.serverContent.getTurnComplete();
            boolean zBooleanValue2 = turnComplete != null ? turnComplete.booleanValue() : false;
            Boolean generationComplete = this.serverContent.getGenerationComplete();
            boolean zBooleanValue3 = generationComplete != null ? generationComplete.booleanValue() : false;
            Transcription.Internal inputTranscription = this.serverContent.getInputTranscription();
            Transcription transcription = inputTranscription != null ? inputTranscription.toPublic() : null;
            Transcription.Internal outputTranscription = this.serverContent.getOutputTranscription();
            return new LiveServerContent(public$com_google_firebase_ai_logic_firebase_ai, zBooleanValue, zBooleanValue2, zBooleanValue3, transcription, outputTranscription != null ? outputTranscription.toPublic() : null);
        }

        public String toString() {
            return "InternalWrapper(serverContent=" + this.serverContent + ')';
        }

        public InternalWrapper(Internal internal) {
            internal.getClass();
            this.serverContent = internal;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 22\u00020\u0001:\u000212BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000eHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u00063"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerContent$Internal;", "", "modelTurn", "Lcom/google/firebase/ai/type/Content$Internal;", "interrupted", "", "turnComplete", "generationComplete", "inputTranscription", "Lcom/google/firebase/ai/type/Transcription$Internal;", "outputTranscription", "<init>", "(Lcom/google/firebase/ai/type/Content$Internal;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/Transcription$Internal;Lcom/google/firebase/ai/type/Transcription$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/Content$Internal;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/Transcription$Internal;Lcom/google/firebase/ai/type/Transcription$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModelTurn", "()Lcom/google/firebase/ai/type/Content$Internal;", "getInterrupted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTurnComplete", "getGenerationComplete", "getInputTranscription", "()Lcom/google/firebase/ai/type/Transcription$Internal;", "getOutputTranscription", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/google/firebase/ai/type/Content$Internal;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/Transcription$Internal;Lcom/google/firebase/ai/type/Transcription$Internal;)Lcom/google/firebase/ai/type/LiveServerContent$Internal;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean generationComplete;
        private final Transcription.Internal inputTranscription;
        private final Boolean interrupted;
        private final Content.Internal modelTurn;
        private final Transcription.Internal outputTranscription;
        private final Boolean turnComplete;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerContent$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveServerContent$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return LiveServerContent$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, Content.Internal internal, Boolean bool, Boolean bool2, Boolean bool3, Transcription.Internal internal2, Transcription.Internal internal3, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i, 63, LiveServerContent$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.modelTurn = internal;
            this.interrupted = bool;
            this.turnComplete = bool2;
            this.generationComplete = bool3;
            this.inputTranscription = internal2;
            this.outputTranscription = internal3;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, Content.Internal internal2, Boolean bool, Boolean bool2, Boolean bool3, Transcription.Internal internal3, Transcription.Internal internal4, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.modelTurn;
            }
            if ((i & 2) != 0) {
                bool = internal.interrupted;
            }
            if ((i & 4) != 0) {
                bool2 = internal.turnComplete;
            }
            if ((i & 8) != 0) {
                bool3 = internal.generationComplete;
            }
            if ((i & 16) != 0) {
                internal3 = internal.inputTranscription;
            }
            if ((i & 32) != 0) {
                internal4 = internal.outputTranscription;
            }
            Transcription.Internal internal5 = internal3;
            Transcription.Internal internal6 = internal4;
            return internal.copy(internal2, bool, bool2, bool3, internal5, internal6);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, Content$Internal$$serializer.INSTANCE, self.modelTurn);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 1, booleanSerializer, self.interrupted);
            output.encodeNullableSerializableElement(serialDesc, 2, booleanSerializer, self.turnComplete);
            output.encodeNullableSerializableElement(serialDesc, 3, booleanSerializer, self.generationComplete);
            Transcription$Internal$$serializer transcription$Internal$$serializer = Transcription$Internal$$serializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 4, transcription$Internal$$serializer, self.inputTranscription);
            output.encodeNullableSerializableElement(serialDesc, 5, transcription$Internal$$serializer, self.outputTranscription);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Content.Internal getModelTurn() {
            return this.modelTurn;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getInterrupted() {
            return this.interrupted;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getTurnComplete() {
            return this.turnComplete;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getGenerationComplete() {
            return this.generationComplete;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Transcription.Internal getInputTranscription() {
            return this.inputTranscription;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Transcription.Internal getOutputTranscription() {
            return this.outputTranscription;
        }

        public final Internal copy(Content.Internal modelTurn, Boolean interrupted, Boolean turnComplete, Boolean generationComplete, Transcription.Internal inputTranscription, Transcription.Internal outputTranscription) {
            return new Internal(modelTurn, interrupted, turnComplete, generationComplete, inputTranscription, outputTranscription);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.modelTurn, internal.modelTurn) && Intrinsics.areEqual(this.interrupted, internal.interrupted) && Intrinsics.areEqual(this.turnComplete, internal.turnComplete) && Intrinsics.areEqual(this.generationComplete, internal.generationComplete) && Intrinsics.areEqual(this.inputTranscription, internal.inputTranscription) && Intrinsics.areEqual(this.outputTranscription, internal.outputTranscription);
        }

        public final Boolean getGenerationComplete() {
            return this.generationComplete;
        }

        public final Transcription.Internal getInputTranscription() {
            return this.inputTranscription;
        }

        public final Boolean getInterrupted() {
            return this.interrupted;
        }

        public final Content.Internal getModelTurn() {
            return this.modelTurn;
        }

        public final Transcription.Internal getOutputTranscription() {
            return this.outputTranscription;
        }

        public final Boolean getTurnComplete() {
            return this.turnComplete;
        }

        public int hashCode() {
            Content.Internal internal = this.modelTurn;
            int iHashCode = (internal == null ? 0 : internal.hashCode()) * 31;
            Boolean bool = this.interrupted;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.turnComplete;
            int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.generationComplete;
            int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Transcription.Internal internal2 = this.inputTranscription;
            int iHashCode5 = (iHashCode4 + (internal2 == null ? 0 : internal2.hashCode())) * 31;
            Transcription.Internal internal3 = this.outputTranscription;
            return iHashCode5 + (internal3 != null ? internal3.hashCode() : 0);
        }

        public String toString() {
            return "Internal(modelTurn=" + this.modelTurn + ", interrupted=" + this.interrupted + ", turnComplete=" + this.turnComplete + ", generationComplete=" + this.generationComplete + ", inputTranscription=" + this.inputTranscription + ", outputTranscription=" + this.outputTranscription + ')';
        }

        public Internal(Content.Internal internal, Boolean bool, Boolean bool2, Boolean bool3, Transcription.Internal internal2, Transcription.Internal internal3) {
            this.modelTurn = internal;
            this.interrupted = bool;
            this.turnComplete = bool2;
            this.generationComplete = bool3;
            this.inputTranscription = internal2;
            this.outputTranscription = internal3;
        }
    }
}
