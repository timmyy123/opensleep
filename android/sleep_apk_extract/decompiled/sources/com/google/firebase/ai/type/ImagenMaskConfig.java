package com.google.firebase.ai.type;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/google/firebase/ai/type/ImagenMaskConfig;", "", "maskType", "Lcom/google/firebase/ai/type/ImagenMaskMode;", "dilation", "", "classes", "", "", "<init>", "(Lcom/google/firebase/ai/type/ImagenMaskMode;Ljava/lang/Double;Ljava/util/List;)V", "getMaskType$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ImagenMaskMode;", "getDilation$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getClasses$com_google_firebase_ai_logic_firebase_ai", "()Ljava/util/List;", "toInternal", "Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenMaskConfig {
    private final List<Integer> classes;
    private final Double dilation;
    private final ImagenMaskMode maskType;

    public /* synthetic */ ImagenMaskConfig(ImagenMaskMode imagenMaskMode, Double d, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imagenMaskMode, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : list);
    }

    public final List<Integer> getClasses$com_google_firebase_ai_logic_firebase_ai() {
        return this.classes;
    }

    /* JADX INFO: renamed from: getDilation$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Double getDilation() {
        return this.dilation;
    }

    /* JADX INFO: renamed from: getMaskType$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ImagenMaskMode getMaskType() {
        return this.maskType;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        return new Internal(this.maskType.getValue(), this.dilation, this.classes);
    }

    public ImagenMaskConfig(ImagenMaskMode imagenMaskMode, Double d, List<Integer> list) {
        imagenMaskMode.getClass();
        this.maskType = imagenMaskMode;
        this.dilation = d;
        this.classes = list;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 )2\u00020\u0001:\u0002()B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J6\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal;", "", "maskMode", "", "dilation", "", "maskClasses", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Double;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMaskMode", "()Ljava/lang/String;", "getDilation", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaskClasses", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;)Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final Double dilation;
        private final List<Integer> maskClasses;
        private final String maskMode;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(IntSerializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return ImagenMaskConfig$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, String str, Double d, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, ImagenMaskConfig$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.maskMode = str;
            this.dilation = d;
            this.maskClasses = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, String str, Double d, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internal.maskMode;
            }
            if ((i & 2) != 0) {
                d = internal.dilation;
            }
            if ((i & 4) != 0) {
                list = internal.maskClasses;
            }
            return internal.copy(str, d, list);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.maskMode);
            output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.dilation);
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.maskClasses);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMaskMode() {
            return this.maskMode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Double getDilation() {
            return this.dilation;
        }

        public final List<Integer> component3() {
            return this.maskClasses;
        }

        public final Internal copy(String maskMode, Double dilation, List<Integer> maskClasses) {
            maskMode.getClass();
            return new Internal(maskMode, dilation, maskClasses);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.maskMode, internal.maskMode) && Intrinsics.areEqual(this.dilation, internal.dilation) && Intrinsics.areEqual(this.maskClasses, internal.maskClasses);
        }

        public final Double getDilation() {
            return this.dilation;
        }

        public final List<Integer> getMaskClasses() {
            return this.maskClasses;
        }

        public final String getMaskMode() {
            return this.maskMode;
        }

        public int hashCode() {
            int iHashCode = this.maskMode.hashCode() * 31;
            Double d = this.dilation;
            int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
            List<Integer> list = this.maskClasses;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(maskMode=");
            sb.append(this.maskMode);
            sb.append(", dilation=");
            sb.append(this.dilation);
            sb.append(", maskClasses=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.maskClasses, ')');
        }

        public Internal(String str, Double d, List<Integer> list) {
            str.getClass();
            this.maskMode = str;
            this.dilation = d;
            this.maskClasses = list;
        }
    }
}
