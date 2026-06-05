package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.common.GenerateImageRequest;
import com.google.firebase.ai.type.ImagenControlConfig;
import com.google.firebase.ai.type.ImagenInlineImage;
import com.google.firebase.ai.type.ImagenMaskConfig;
import com.google.firebase.ai.type.ImagenStyleConfig;
import com.google.firebase.ai.type.ImagenSubjectConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001:\u0001!BQ\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0000¢\u0006\u0002\b R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/google/firebase/ai/type/ImagenReferenceImage;", "", "maskConfig", "Lcom/google/firebase/ai/type/ImagenMaskConfig;", "subjectConfig", "Lcom/google/firebase/ai/type/ImagenSubjectConfig;", "styleConfig", "Lcom/google/firebase/ai/type/ImagenStyleConfig;", "controlConfig", "Lcom/google/firebase/ai/type/ImagenControlConfig;", "image", "Lcom/google/firebase/ai/type/ImagenInlineImage;", "referenceId", "", "<init>", "(Lcom/google/firebase/ai/type/ImagenMaskConfig;Lcom/google/firebase/ai/type/ImagenSubjectConfig;Lcom/google/firebase/ai/type/ImagenStyleConfig;Lcom/google/firebase/ai/type/ImagenControlConfig;Lcom/google/firebase/ai/type/ImagenInlineImage;Ljava/lang/Integer;)V", "getMaskConfig$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ImagenMaskConfig;", "getSubjectConfig$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ImagenSubjectConfig;", "getStyleConfig$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ImagenStyleConfig;", "getControlConfig$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ImagenControlConfig;", "getImage", "()Lcom/google/firebase/ai/type/ImagenInlineImage;", "getReferenceId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toInternal", "Lcom/google/firebase/ai/type/ImagenReferenceImage$Internal;", "optionalReferenceId", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ImagenReferenceImage {
    private final ImagenControlConfig controlConfig;
    private final ImagenInlineImage image;
    private final ImagenMaskConfig maskConfig;
    private final Integer referenceId;
    private final ImagenStyleConfig styleConfig;
    private final ImagenSubjectConfig subjectConfig;

    public /* synthetic */ ImagenReferenceImage(ImagenMaskConfig imagenMaskConfig, ImagenSubjectConfig imagenSubjectConfig, ImagenStyleConfig imagenStyleConfig, ImagenControlConfig imagenControlConfig, ImagenInlineImage imagenInlineImage, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imagenMaskConfig, (i & 2) != 0 ? null : imagenSubjectConfig, (i & 4) != 0 ? null : imagenStyleConfig, (i & 8) != 0 ? null : imagenControlConfig, (i & 16) != 0 ? null : imagenInlineImage, (i & 32) != 0 ? null : num);
    }

    /* JADX INFO: renamed from: getControlConfig$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ImagenControlConfig getControlConfig() {
        return this.controlConfig;
    }

    public final ImagenInlineImage getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: getMaskConfig$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ImagenMaskConfig getMaskConfig() {
        return this.maskConfig;
    }

    public final Integer getReferenceId() {
        return this.referenceId;
    }

    /* JADX INFO: renamed from: getStyleConfig$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ImagenStyleConfig getStyleConfig() {
        return this.styleConfig;
    }

    /* JADX INFO: renamed from: getSubjectConfig$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ImagenSubjectConfig getSubjectConfig() {
        return this.subjectConfig;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai(int optionalReferenceId) {
        GenerateImageRequest.ReferenceType referenceType;
        if (this instanceof ImagenRawImage) {
            referenceType = GenerateImageRequest.ReferenceType.RAW;
        } else if (this instanceof ImagenMaskReference) {
            referenceType = GenerateImageRequest.ReferenceType.MASK;
        } else if (this instanceof ImagenSubjectReference) {
            referenceType = GenerateImageRequest.ReferenceType.SUBJECT;
        } else if (this instanceof ImagenStyleReference) {
            referenceType = GenerateImageRequest.ReferenceType.STYLE;
        } else {
            if (!(this instanceof ImagenControlReference)) {
                Utf8$$ExternalSyntheticBUOutline0.m$3(getClass().getSimpleName().concat(" is not a known subtype of ImagenReferenceImage"));
                return null;
            }
            referenceType = GenerateImageRequest.ReferenceType.CONTROL;
        }
        GenerateImageRequest.ReferenceType referenceType2 = referenceType;
        ImagenInlineImage imagenInlineImage = this.image;
        ImagenInlineImage.Internal internal$com_google_firebase_ai_logic_firebase_ai = imagenInlineImage != null ? imagenInlineImage.toInternal$com_google_firebase_ai_logic_firebase_ai() : null;
        Integer num = this.referenceId;
        if (num != null) {
            optionalReferenceId = num.intValue();
        }
        int i = optionalReferenceId;
        ImagenSubjectConfig imagenSubjectConfig = this.subjectConfig;
        ImagenSubjectConfig.Internal internal$com_google_firebase_ai_logic_firebase_ai2 = imagenSubjectConfig != null ? imagenSubjectConfig.toInternal$com_google_firebase_ai_logic_firebase_ai() : null;
        ImagenMaskConfig imagenMaskConfig = this.maskConfig;
        ImagenMaskConfig.Internal internal$com_google_firebase_ai_logic_firebase_ai3 = imagenMaskConfig != null ? imagenMaskConfig.toInternal$com_google_firebase_ai_logic_firebase_ai() : null;
        ImagenStyleConfig imagenStyleConfig = this.styleConfig;
        ImagenStyleConfig.Internal internal = imagenStyleConfig != null ? imagenStyleConfig.toInternal() : null;
        ImagenControlConfig imagenControlConfig = this.controlConfig;
        return new Internal(referenceType2, internal$com_google_firebase_ai_logic_firebase_ai, i, internal$com_google_firebase_ai_logic_firebase_ai2, internal$com_google_firebase_ai_logic_firebase_ai3, internal, imagenControlConfig != null ? imagenControlConfig.toInternal() : null);
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ;2\u00020\u0001:\u0002:;BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011B_\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003JY\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0007HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006<"}, d2 = {"Lcom/google/firebase/ai/type/ImagenReferenceImage$Internal;", "", "referenceType", "Lcom/google/firebase/ai/common/GenerateImageRequest$ReferenceType;", "referenceImage", "Lcom/google/firebase/ai/type/ImagenInlineImage$Internal;", "referenceId", "", "subjectImageConfig", "Lcom/google/firebase/ai/type/ImagenSubjectConfig$Internal;", "maskImageConfig", "Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal;", "styleImageConfig", "Lcom/google/firebase/ai/type/ImagenStyleConfig$Internal;", "controlConfig", "Lcom/google/firebase/ai/type/ImagenControlConfig$Internal;", "<init>", "(Lcom/google/firebase/ai/common/GenerateImageRequest$ReferenceType;Lcom/google/firebase/ai/type/ImagenInlineImage$Internal;ILcom/google/firebase/ai/type/ImagenSubjectConfig$Internal;Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal;Lcom/google/firebase/ai/type/ImagenStyleConfig$Internal;Lcom/google/firebase/ai/type/ImagenControlConfig$Internal;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/common/GenerateImageRequest$ReferenceType;Lcom/google/firebase/ai/type/ImagenInlineImage$Internal;ILcom/google/firebase/ai/type/ImagenSubjectConfig$Internal;Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal;Lcom/google/firebase/ai/type/ImagenStyleConfig$Internal;Lcom/google/firebase/ai/type/ImagenControlConfig$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReferenceType", "()Lcom/google/firebase/ai/common/GenerateImageRequest$ReferenceType;", "getReferenceImage", "()Lcom/google/firebase/ai/type/ImagenInlineImage$Internal;", "getReferenceId", "()I", "getSubjectImageConfig", "()Lcom/google/firebase/ai/type/ImagenSubjectConfig$Internal;", "getMaskImageConfig", "()Lcom/google/firebase/ai/type/ImagenMaskConfig$Internal;", "getStyleImageConfig", "()Lcom/google/firebase/ai/type/ImagenStyleConfig$Internal;", "getControlConfig", "()Lcom/google/firebase/ai/type/ImagenControlConfig$Internal;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final ImagenControlConfig.Internal controlConfig;
        private final ImagenMaskConfig.Internal maskImageConfig;
        private final int referenceId;
        private final ImagenInlineImage.Internal referenceImage;
        private final GenerateImageRequest.ReferenceType referenceType;
        private final ImagenStyleConfig.Internal styleImageConfig;
        private final ImagenSubjectConfig.Internal subjectImageConfig;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {GenerateImageRequest.ReferenceType.INSTANCE.serializer(), null, null, null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ImagenReferenceImage$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ImagenReferenceImage$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return ImagenReferenceImage$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, GenerateImageRequest.ReferenceType referenceType, ImagenInlineImage.Internal internal, int i2, ImagenSubjectConfig.Internal internal2, ImagenMaskConfig.Internal internal3, ImagenStyleConfig.Internal internal4, ImagenControlConfig.Internal internal5, SerializationConstructorMarker serializationConstructorMarker) {
            if (127 != (i & 127)) {
                PluginExceptionsKt.throwMissingFieldException(i, 127, ImagenReferenceImage$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.referenceType = referenceType;
            this.referenceImage = internal;
            this.referenceId = i2;
            this.subjectImageConfig = internal2;
            this.maskImageConfig = internal3;
            this.styleImageConfig = internal4;
            this.controlConfig = internal5;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, GenerateImageRequest.ReferenceType referenceType, ImagenInlineImage.Internal internal2, int i, ImagenSubjectConfig.Internal internal3, ImagenMaskConfig.Internal internal4, ImagenStyleConfig.Internal internal5, ImagenControlConfig.Internal internal6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                referenceType = internal.referenceType;
            }
            if ((i2 & 2) != 0) {
                internal2 = internal.referenceImage;
            }
            if ((i2 & 4) != 0) {
                i = internal.referenceId;
            }
            if ((i2 & 8) != 0) {
                internal3 = internal.subjectImageConfig;
            }
            if ((i2 & 16) != 0) {
                internal4 = internal.maskImageConfig;
            }
            if ((i2 & 32) != 0) {
                internal5 = internal.styleImageConfig;
            }
            if ((i2 & 64) != 0) {
                internal6 = internal.controlConfig;
            }
            ImagenStyleConfig.Internal internal7 = internal5;
            ImagenControlConfig.Internal internal8 = internal6;
            ImagenMaskConfig.Internal internal9 = internal4;
            int i3 = i;
            return internal.copy(referenceType, internal2, i3, internal3, internal9, internal7, internal8);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.referenceType);
            output.encodeNullableSerializableElement(serialDesc, 1, ImagenInlineImage$Internal$$serializer.INSTANCE, self.referenceImage);
            output.encodeIntElement(serialDesc, 2, self.referenceId);
            output.encodeNullableSerializableElement(serialDesc, 3, ImagenSubjectConfig$Internal$$serializer.INSTANCE, self.subjectImageConfig);
            output.encodeNullableSerializableElement(serialDesc, 4, ImagenMaskConfig$Internal$$serializer.INSTANCE, self.maskImageConfig);
            output.encodeNullableSerializableElement(serialDesc, 5, ImagenStyleConfig$Internal$$serializer.INSTANCE, self.styleImageConfig);
            output.encodeNullableSerializableElement(serialDesc, 6, ImagenControlConfig$Internal$$serializer.INSTANCE, self.controlConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GenerateImageRequest.ReferenceType getReferenceType() {
            return this.referenceType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ImagenInlineImage.Internal getReferenceImage() {
            return this.referenceImage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getReferenceId() {
            return this.referenceId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ImagenSubjectConfig.Internal getSubjectImageConfig() {
            return this.subjectImageConfig;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ImagenMaskConfig.Internal getMaskImageConfig() {
            return this.maskImageConfig;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ImagenStyleConfig.Internal getStyleImageConfig() {
            return this.styleImageConfig;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final ImagenControlConfig.Internal getControlConfig() {
            return this.controlConfig;
        }

        public final Internal copy(GenerateImageRequest.ReferenceType referenceType, ImagenInlineImage.Internal referenceImage, int referenceId, ImagenSubjectConfig.Internal subjectImageConfig, ImagenMaskConfig.Internal maskImageConfig, ImagenStyleConfig.Internal styleImageConfig, ImagenControlConfig.Internal controlConfig) {
            referenceType.getClass();
            return new Internal(referenceType, referenceImage, referenceId, subjectImageConfig, maskImageConfig, styleImageConfig, controlConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return this.referenceType == internal.referenceType && Intrinsics.areEqual(this.referenceImage, internal.referenceImage) && this.referenceId == internal.referenceId && Intrinsics.areEqual(this.subjectImageConfig, internal.subjectImageConfig) && Intrinsics.areEqual(this.maskImageConfig, internal.maskImageConfig) && Intrinsics.areEqual(this.styleImageConfig, internal.styleImageConfig) && Intrinsics.areEqual(this.controlConfig, internal.controlConfig);
        }

        public final ImagenControlConfig.Internal getControlConfig() {
            return this.controlConfig;
        }

        public final ImagenMaskConfig.Internal getMaskImageConfig() {
            return this.maskImageConfig;
        }

        public final int getReferenceId() {
            return this.referenceId;
        }

        public final ImagenInlineImage.Internal getReferenceImage() {
            return this.referenceImage;
        }

        public final GenerateImageRequest.ReferenceType getReferenceType() {
            return this.referenceType;
        }

        public final ImagenStyleConfig.Internal getStyleImageConfig() {
            return this.styleImageConfig;
        }

        public final ImagenSubjectConfig.Internal getSubjectImageConfig() {
            return this.subjectImageConfig;
        }

        public int hashCode() {
            int iHashCode = this.referenceType.hashCode() * 31;
            ImagenInlineImage.Internal internal = this.referenceImage;
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.referenceId, (iHashCode + (internal == null ? 0 : internal.hashCode())) * 31, 31);
            ImagenSubjectConfig.Internal internal2 = this.subjectImageConfig;
            int iHashCode2 = (iM + (internal2 == null ? 0 : internal2.hashCode())) * 31;
            ImagenMaskConfig.Internal internal3 = this.maskImageConfig;
            int iHashCode3 = (iHashCode2 + (internal3 == null ? 0 : internal3.hashCode())) * 31;
            ImagenStyleConfig.Internal internal4 = this.styleImageConfig;
            int iHashCode4 = (iHashCode3 + (internal4 == null ? 0 : internal4.hashCode())) * 31;
            ImagenControlConfig.Internal internal5 = this.controlConfig;
            return iHashCode4 + (internal5 != null ? internal5.hashCode() : 0);
        }

        public String toString() {
            return "Internal(referenceType=" + this.referenceType + ", referenceImage=" + this.referenceImage + ", referenceId=" + this.referenceId + ", subjectImageConfig=" + this.subjectImageConfig + ", maskImageConfig=" + this.maskImageConfig + ", styleImageConfig=" + this.styleImageConfig + ", controlConfig=" + this.controlConfig + ')';
        }

        public Internal(GenerateImageRequest.ReferenceType referenceType, ImagenInlineImage.Internal internal, int i, ImagenSubjectConfig.Internal internal2, ImagenMaskConfig.Internal internal3, ImagenStyleConfig.Internal internal4, ImagenControlConfig.Internal internal5) {
            referenceType.getClass();
            this.referenceType = referenceType;
            this.referenceImage = internal;
            this.referenceId = i;
            this.subjectImageConfig = internal2;
            this.maskImageConfig = internal3;
            this.styleImageConfig = internal4;
            this.controlConfig = internal5;
        }
    }

    public ImagenReferenceImage(ImagenMaskConfig imagenMaskConfig, ImagenSubjectConfig imagenSubjectConfig, ImagenStyleConfig imagenStyleConfig, ImagenControlConfig imagenControlConfig, ImagenInlineImage imagenInlineImage, Integer num) {
        this.maskConfig = imagenMaskConfig;
        this.subjectConfig = imagenSubjectConfig;
        this.styleConfig = imagenStyleConfig;
        this.controlConfig = imagenControlConfig;
        this.image = imagenInlineImage;
        this.referenceId = num;
    }

    public ImagenReferenceImage() {
        this(null, null, null, null, null, null, 63, null);
    }
}
