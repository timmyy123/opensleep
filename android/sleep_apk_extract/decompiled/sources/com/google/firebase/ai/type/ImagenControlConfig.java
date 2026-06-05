package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/ai/type/ImagenControlConfig;", "", "controlType", "Lcom/google/firebase/ai/type/ImagenControlType;", "enableComputation", "", "superpixelRegionSize", "", "superpixelRuler", "<init>", "(Lcom/google/firebase/ai/type/ImagenControlType;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getControlType$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ImagenControlType;", "getEnableComputation$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSuperpixelRegionSize$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSuperpixelRuler$com_google_firebase_ai_logic_firebase_ai", "toInternal", "Lcom/google/firebase/ai/type/ImagenControlConfig$Internal;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenControlConfig {
    private final ImagenControlType controlType;
    private final Boolean enableComputation;
    private final Integer superpixelRegionSize;
    private final Integer superpixelRuler;

    public /* synthetic */ ImagenControlConfig(ImagenControlType imagenControlType, Boolean bool, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imagenControlType, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
    }

    /* JADX INFO: renamed from: getControlType$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ImagenControlType getControlType() {
        return this.controlType;
    }

    /* JADX INFO: renamed from: getEnableComputation$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Boolean getEnableComputation() {
        return this.enableComputation;
    }

    /* JADX INFO: renamed from: getSuperpixelRegionSize$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Integer getSuperpixelRegionSize() {
        return this.superpixelRegionSize;
    }

    /* JADX INFO: renamed from: getSuperpixelRuler$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Integer getSuperpixelRuler() {
        return this.superpixelRuler;
    }

    public final Internal toInternal() {
        return new Internal(this.controlType.getValue(), this.enableComputation, this.superpixelRegionSize, this.superpixelRuler);
    }

    public ImagenControlConfig(ImagenControlType imagenControlType, Boolean bool, Integer num, Integer num2) {
        imagenControlType.getClass();
        this.controlType = imagenControlType;
        this.enableComputation = bool;
        this.superpixelRegionSize = num;
        this.superpixelRuler = num2;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 !2\u00020\u0001:\u0002 !B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006\""}, d2 = {"Lcom/google/firebase/ai/type/ImagenControlConfig$Internal;", "", "controlType", "", "enableControlImageComputation", "", "superpixelRegionSize", "", "superpixelRuler", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getControlType", "()Ljava/lang/String;", "getEnableControlImageComputation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSuperpixelRegionSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSuperpixelRuler", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String controlType;
        private final Boolean enableControlImageComputation;
        private final Integer superpixelRegionSize;
        private final Integer superpixelRuler;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ImagenControlConfig$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ImagenControlConfig$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return ImagenControlConfig$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, String str, Boolean bool, Integer num, Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, ImagenControlConfig$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.controlType = str;
            this.enableControlImageComputation = bool;
            this.superpixelRegionSize = num;
            this.superpixelRuler = num2;
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.controlType);
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.enableControlImageComputation);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 2, intSerializer, self.superpixelRegionSize);
            output.encodeNullableSerializableElement(serialDesc, 3, intSerializer, self.superpixelRuler);
        }

        public final String getControlType() {
            return this.controlType;
        }

        public final Boolean getEnableControlImageComputation() {
            return this.enableControlImageComputation;
        }

        public final Integer getSuperpixelRegionSize() {
            return this.superpixelRegionSize;
        }

        public final Integer getSuperpixelRuler() {
            return this.superpixelRuler;
        }

        public Internal(String str, Boolean bool, Integer num, Integer num2) {
            this.controlType = str;
            this.enableControlImageComputation = bool;
            this.superpixelRegionSize = num;
            this.superpixelRuler = num2;
        }
    }
}
