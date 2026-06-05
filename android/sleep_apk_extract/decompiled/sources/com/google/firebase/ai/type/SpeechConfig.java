package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.Voice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/google/firebase/ai/type/SpeechConfig;", "", "voice", "Lcom/google/firebase/ai/type/Voice;", "<init>", "(Lcom/google/firebase/ai/type/Voice;)V", "getVoice", "()Lcom/google/firebase/ai/type/Voice;", "toInternal", "Lcom/google/firebase/ai/type/SpeechConfig$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpeechConfig {
    private final Voice voice;

    public SpeechConfig(Voice voice) {
        voice.getClass();
        this.voice = voice;
    }

    public final Voice getVoice() {
        return this.voice;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        return new Internal(new Internal.VoiceConfigInternal(this.voice.toInternal$com_google_firebase_ai_logic_firebase_ai()));
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 !2\u00020\u0001:\u0003\u001f !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/google/firebase/ai/type/SpeechConfig$Internal;", "", "voiceConfig", "Lcom/google/firebase/ai/type/SpeechConfig$Internal$VoiceConfigInternal;", "<init>", "(Lcom/google/firebase/ai/type/SpeechConfig$Internal$VoiceConfigInternal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/SpeechConfig$Internal$VoiceConfigInternal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVoiceConfig$annotations", "()V", "getVoiceConfig", "()Lcom/google/firebase/ai/type/SpeechConfig$Internal$VoiceConfigInternal;", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "VoiceConfigInternal", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final VoiceConfigInternal voiceConfig;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/SpeechConfig$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/SpeechConfig$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return SpeechConfig$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, VoiceConfigInternal voiceConfigInternal, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, SpeechConfig$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.voiceConfig = voiceConfigInternal;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, VoiceConfigInternal voiceConfigInternal, int i, Object obj) {
            if ((i & 1) != 0) {
                voiceConfigInternal = internal.voiceConfig;
            }
            return internal.copy(voiceConfigInternal);
        }

        @SerialName("voice_config")
        public static /* synthetic */ void getVoiceConfig$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VoiceConfigInternal getVoiceConfig() {
            return this.voiceConfig;
        }

        public final Internal copy(VoiceConfigInternal voiceConfig) {
            voiceConfig.getClass();
            return new Internal(voiceConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Internal) && Intrinsics.areEqual(this.voiceConfig, ((Internal) other).voiceConfig);
        }

        public final VoiceConfigInternal getVoiceConfig() {
            return this.voiceConfig;
        }

        public int hashCode() {
            return this.voiceConfig.hashCode();
        }

        public String toString() {
            return "Internal(voiceConfig=" + this.voiceConfig + ')';
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/google/firebase/ai/type/SpeechConfig$Internal$VoiceConfigInternal;", "", "prebuiltVoiceConfig", "Lcom/google/firebase/ai/type/Voice$Internal;", "<init>", "(Lcom/google/firebase/ai/type/Voice$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/Voice$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPrebuiltVoiceConfig$annotations", "()V", "getPrebuiltVoiceConfig", "()Lcom/google/firebase/ai/type/Voice$Internal;", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final /* data */ class VoiceConfigInternal {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final Voice.Internal prebuiltVoiceConfig;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/SpeechConfig$Internal$VoiceConfigInternal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/SpeechConfig$Internal$VoiceConfigInternal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<VoiceConfigInternal> serializer() {
                    return SpeechConfig$Internal$VoiceConfigInternal$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ VoiceConfigInternal(int i, Voice.Internal internal, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, SpeechConfig$Internal$VoiceConfigInternal$$serializer.INSTANCE.getDescriptor());
                }
                this.prebuiltVoiceConfig = internal;
            }

            public static /* synthetic */ VoiceConfigInternal copy$default(VoiceConfigInternal voiceConfigInternal, Voice.Internal internal, int i, Object obj) {
                if ((i & 1) != 0) {
                    internal = voiceConfigInternal.prebuiltVoiceConfig;
                }
                return voiceConfigInternal.copy(internal);
            }

            @SerialName("prebuilt_voice_config")
            public static /* synthetic */ void getPrebuiltVoiceConfig$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Voice.Internal getPrebuiltVoiceConfig() {
                return this.prebuiltVoiceConfig;
            }

            public final VoiceConfigInternal copy(Voice.Internal prebuiltVoiceConfig) {
                prebuiltVoiceConfig.getClass();
                return new VoiceConfigInternal(prebuiltVoiceConfig);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof VoiceConfigInternal) && Intrinsics.areEqual(this.prebuiltVoiceConfig, ((VoiceConfigInternal) other).prebuiltVoiceConfig);
            }

            public final Voice.Internal getPrebuiltVoiceConfig() {
                return this.prebuiltVoiceConfig;
            }

            public int hashCode() {
                return this.prebuiltVoiceConfig.hashCode();
            }

            public String toString() {
                return "VoiceConfigInternal(prebuiltVoiceConfig=" + this.prebuiltVoiceConfig + ')';
            }

            public VoiceConfigInternal(Voice.Internal internal) {
                internal.getClass();
                this.prebuiltVoiceConfig = internal;
            }
        }

        public Internal(VoiceConfigInternal voiceConfigInternal) {
            voiceConfigInternal.getClass();
            this.voiceConfig = voiceConfigInternal;
        }
    }
}
