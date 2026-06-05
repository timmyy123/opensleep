package com.google.firebase.ai.common;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.ImagenEditingConfig;
import com.google.firebase.ai.type.ImagenEditingConfig$Internal$$serializer;
import com.google.firebase.ai.type.ImagenImageFormat;
import com.google.firebase.ai.type.ImagenImageFormat$Internal$$serializer;
import com.google.firebase.ai.type.ImagenReferenceImage;
import com.google.firebase.ai.type.ImagenReferenceImage$Internal$$serializer;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0005$%&'(B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J#\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lcom/google/firebase/ai/common/GenerateImageRequest;", "Lcom/google/firebase/ai/common/Request;", "instances", "", "Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenPrompt;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters;", "<init>", "(Ljava/util/List;Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInstances", "()Ljava/util/List;", "getParameters", "()Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "ImagenPrompt", "ImagenParameters", "ReferenceType", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final /* data */ class GenerateImageRequest implements Request {
    private final List<ImagenPrompt> instances;
    private final ImagenParameters parameters;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(GenerateImageRequest$ImagenPrompt$$serializer.INSTANCE), null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/common/GenerateImageRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/common/GenerateImageRequest;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<GenerateImageRequest> serializer() {
            return GenerateImageRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0081\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/common/GenerateImageRequest$ReferenceType;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "RAW", "MASK", "CONTROL", "STYLE", "SUBJECT", "MASKED_SUBJECT", "PRODUCT", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final class ReferenceType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ReferenceType[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;

        @SerialName("REFERENCE_TYPE_UNSPECIFIED")
        public static final ReferenceType UNSPECIFIED = new ReferenceType("UNSPECIFIED", 0);

        @SerialName("REFERENCE_TYPE_RAW")
        public static final ReferenceType RAW = new ReferenceType("RAW", 1);

        @SerialName("REFERENCE_TYPE_MASK")
        public static final ReferenceType MASK = new ReferenceType("MASK", 2);

        @SerialName("REFERENCE_TYPE_CONTROL")
        public static final ReferenceType CONTROL = new ReferenceType("CONTROL", 3);

        @SerialName("REFERENCE_TYPE_STYLE")
        public static final ReferenceType STYLE = new ReferenceType("STYLE", 4);

        @SerialName("REFERENCE_TYPE_SUBJECT")
        public static final ReferenceType SUBJECT = new ReferenceType("SUBJECT", 5);

        @SerialName("REFERENCE_TYPE_MASKED_SUBJECT")
        public static final ReferenceType MASKED_SUBJECT = new ReferenceType("MASKED_SUBJECT", 6);

        @SerialName("REFERENCE_TYPE_PRODUCT")
        public static final ReferenceType PRODUCT = new ReferenceType("PRODUCT", 7);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/common/GenerateImageRequest$ReferenceType$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/common/GenerateImageRequest$ReferenceType;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) ReferenceType.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<ReferenceType> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ReferenceType[] $values() {
            return new ReferenceType[]{UNSPECIFIED, RAW, MASK, CONTROL, STYLE, SUBJECT, MASKED_SUBJECT, PRODUCT};
        }

        static {
            ReferenceType[] referenceTypeArr$values = $values();
            $VALUES = referenceTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(referenceTypeArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Tool$$ExternalSyntheticLambda0(12));
        }

        private ReferenceType(String str, int i) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createAnnotatedEnumSerializer("com.google.firebase.ai.common.GenerateImageRequest.ReferenceType", values(), new String[]{"REFERENCE_TYPE_UNSPECIFIED", "REFERENCE_TYPE_RAW", "REFERENCE_TYPE_MASK", "REFERENCE_TYPE_CONTROL", "REFERENCE_TYPE_STYLE", "REFERENCE_TYPE_SUBJECT", "REFERENCE_TYPE_MASKED_SUBJECT", "REFERENCE_TYPE_PRODUCT"}, new Annotation[][]{null, null, null, null, null, null, null, null}, null);
        }

        public static EnumEntries<ReferenceType> getEntries() {
            return $ENTRIES;
        }

        public static ReferenceType valueOf(String str) {
            return (ReferenceType) Enum.valueOf(ReferenceType.class, str);
        }

        public static ReferenceType[] values() {
            return (ReferenceType[]) $VALUES.clone();
        }
    }

    public /* synthetic */ GenerateImageRequest(int i, List list, ImagenParameters imagenParameters, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, GenerateImageRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.instances = list;
        this.parameters = imagenParameters;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GenerateImageRequest copy$default(GenerateImageRequest generateImageRequest, List list, ImagenParameters imagenParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            list = generateImageRequest.instances;
        }
        if ((i & 2) != 0) {
            imagenParameters = generateImageRequest.parameters;
        }
        return generateImageRequest.copy(list, imagenParameters);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(GenerateImageRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.instances);
        output.encodeSerializableElement(serialDesc, 1, GenerateImageRequest$ImagenParameters$$serializer.INSTANCE, self.parameters);
    }

    public final List<ImagenPrompt> component1() {
        return this.instances;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImagenParameters getParameters() {
        return this.parameters;
    }

    public final GenerateImageRequest copy(List<ImagenPrompt> instances, ImagenParameters parameters) {
        instances.getClass();
        parameters.getClass();
        return new GenerateImageRequest(instances, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerateImageRequest)) {
            return false;
        }
        GenerateImageRequest generateImageRequest = (GenerateImageRequest) other;
        return Intrinsics.areEqual(this.instances, generateImageRequest.instances) && Intrinsics.areEqual(this.parameters, generateImageRequest.parameters);
    }

    public final List<ImagenPrompt> getInstances() {
        return this.instances;
    }

    public final ImagenParameters getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return this.parameters.hashCode() + (this.instances.hashCode() * 31);
    }

    public String toString() {
        return "GenerateImageRequest(instances=" + this.instances + ", parameters=" + this.parameters + ')';
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenPrompt;", "", "prompt", "", "referenceImages", "", "Lcom/google/firebase/ai/type/ImagenReferenceImage$Internal;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPrompt", "()Ljava/lang/String;", "getReferenceImages", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ImagenPrompt {
        private final String prompt;
        private final List<ImagenReferenceImage.Internal> referenceImages;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(ImagenReferenceImage$Internal$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenPrompt$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenPrompt;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ImagenPrompt> serializer() {
                return GenerateImageRequest$ImagenPrompt$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ImagenPrompt(int i, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, GenerateImageRequest$ImagenPrompt$$serializer.INSTANCE.getDescriptor());
            }
            this.prompt = str;
            this.referenceImages = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ImagenPrompt copy$default(ImagenPrompt imagenPrompt, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imagenPrompt.prompt;
            }
            if ((i & 2) != 0) {
                list = imagenPrompt.referenceImages;
            }
            return imagenPrompt.copy(str, list);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(ImagenPrompt self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.prompt);
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.referenceImages);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPrompt() {
            return this.prompt;
        }

        public final List<ImagenReferenceImage.Internal> component2() {
            return this.referenceImages;
        }

        public final ImagenPrompt copy(String prompt, List<ImagenReferenceImage.Internal> referenceImages) {
            return new ImagenPrompt(prompt, referenceImages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImagenPrompt)) {
                return false;
            }
            ImagenPrompt imagenPrompt = (ImagenPrompt) other;
            return Intrinsics.areEqual(this.prompt, imagenPrompt.prompt) && Intrinsics.areEqual(this.referenceImages, imagenPrompt.referenceImages);
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final List<ImagenReferenceImage.Internal> getReferenceImages() {
            return this.referenceImages;
        }

        public int hashCode() {
            String str = this.prompt;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            List<ImagenReferenceImage.Internal> list = this.referenceImages;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ImagenPrompt(prompt=");
            sb.append(this.prompt);
            sb.append(", referenceImages=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.referenceImages, ')');
        }

        public ImagenPrompt(String str, List<ImagenReferenceImage.Internal> list) {
            this.prompt = str;
            this.referenceImages = list;
        }
    }

    public GenerateImageRequest(List<ImagenPrompt> list, ImagenParameters imagenParameters) {
        list.getClass();
        imagenParameters.getClass();
        this.instances = list;
        this.parameters = imagenParameters;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 G2\u00020\u0001:\u0002FGBy\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014B\u008d\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0098\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\bHÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006H"}, d2 = {"Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters;", "", "sampleCount", "", "includeRaiReason", "", "includeSafetyAttributes", "storageUri", "", "negativePrompt", "aspectRatio", "safetySetting", "personGeneration", "addWatermark", "imageOutputOptions", "Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;", "editMode", "editConfig", "Lcom/google/firebase/ai/type/ImagenEditingConfig$Internal;", "<init>", "(IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;Ljava/lang/String;Lcom/google/firebase/ai/type/ImagenEditingConfig$Internal;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;Ljava/lang/String;Lcom/google/firebase/ai/type/ImagenEditingConfig$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSampleCount", "()I", "getIncludeRaiReason", "()Z", "getIncludeSafetyAttributes", "getStorageUri", "()Ljava/lang/String;", "getNegativePrompt", "getAspectRatio", "getSafetySetting", "getPersonGeneration", "getAddWatermark", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageOutputOptions", "()Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;", "getEditMode", "getEditConfig", "()Lcom/google/firebase/ai/type/ImagenEditingConfig$Internal;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;Ljava/lang/String;Lcom/google/firebase/ai/type/ImagenEditingConfig$Internal;)Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ImagenParameters {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean addWatermark;
        private final String aspectRatio;
        private final ImagenEditingConfig.Internal editConfig;
        private final String editMode;
        private final ImagenImageFormat.Internal imageOutputOptions;
        private final boolean includeRaiReason;
        private final boolean includeSafetyAttributes;
        private final String negativePrompt;
        private final String personGeneration;
        private final String safetySetting;
        private final int sampleCount;
        private final String storageUri;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ImagenParameters> serializer() {
                return GenerateImageRequest$ImagenParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ImagenParameters(int i, int i2, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, Boolean bool, ImagenImageFormat.Internal internal, String str6, ImagenEditingConfig.Internal internal2, SerializationConstructorMarker serializationConstructorMarker) {
            if (4095 != (i & 4095)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4095, GenerateImageRequest$ImagenParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.sampleCount = i2;
            this.includeRaiReason = z;
            this.includeSafetyAttributes = z2;
            this.storageUri = str;
            this.negativePrompt = str2;
            this.aspectRatio = str3;
            this.safetySetting = str4;
            this.personGeneration = str5;
            this.addWatermark = bool;
            this.imageOutputOptions = internal;
            this.editMode = str6;
            this.editConfig = internal2;
        }

        public static /* synthetic */ ImagenParameters copy$default(ImagenParameters imagenParameters, int i, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, Boolean bool, ImagenImageFormat.Internal internal, String str6, ImagenEditingConfig.Internal internal2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = imagenParameters.sampleCount;
            }
            if ((i2 & 2) != 0) {
                z = imagenParameters.includeRaiReason;
            }
            if ((i2 & 4) != 0) {
                z2 = imagenParameters.includeSafetyAttributes;
            }
            if ((i2 & 8) != 0) {
                str = imagenParameters.storageUri;
            }
            if ((i2 & 16) != 0) {
                str2 = imagenParameters.negativePrompt;
            }
            if ((i2 & 32) != 0) {
                str3 = imagenParameters.aspectRatio;
            }
            if ((i2 & 64) != 0) {
                str4 = imagenParameters.safetySetting;
            }
            if ((i2 & 128) != 0) {
                str5 = imagenParameters.personGeneration;
            }
            if ((i2 & 256) != 0) {
                bool = imagenParameters.addWatermark;
            }
            if ((i2 & 512) != 0) {
                internal = imagenParameters.imageOutputOptions;
            }
            if ((i2 & 1024) != 0) {
                str6 = imagenParameters.editMode;
            }
            if ((i2 & 2048) != 0) {
                internal2 = imagenParameters.editConfig;
            }
            String str7 = str6;
            ImagenEditingConfig.Internal internal3 = internal2;
            Boolean bool2 = bool;
            ImagenImageFormat.Internal internal4 = internal;
            String str8 = str4;
            String str9 = str5;
            String str10 = str2;
            String str11 = str3;
            return imagenParameters.copy(i, z, z2, str, str10, str11, str8, str9, bool2, internal4, str7, internal3);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(ImagenParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.sampleCount);
            output.encodeBooleanElement(serialDesc, 1, self.includeRaiReason);
            output.encodeBooleanElement(serialDesc, 2, self.includeSafetyAttributes);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.storageUri);
            output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.negativePrompt);
            output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.aspectRatio);
            output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.safetySetting);
            output.encodeNullableSerializableElement(serialDesc, 7, stringSerializer, self.personGeneration);
            output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.addWatermark);
            output.encodeNullableSerializableElement(serialDesc, 9, ImagenImageFormat$Internal$$serializer.INSTANCE, self.imageOutputOptions);
            output.encodeNullableSerializableElement(serialDesc, 10, stringSerializer, self.editMode);
            output.encodeNullableSerializableElement(serialDesc, 11, ImagenEditingConfig$Internal$$serializer.INSTANCE, self.editConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSampleCount() {
            return this.sampleCount;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final ImagenImageFormat.Internal getImageOutputOptions() {
            return this.imageOutputOptions;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getEditMode() {
            return this.editMode;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final ImagenEditingConfig.Internal getEditConfig() {
            return this.editConfig;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIncludeRaiReason() {
            return this.includeRaiReason;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIncludeSafetyAttributes() {
            return this.includeSafetyAttributes;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getStorageUri() {
            return this.storageUri;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getNegativePrompt() {
            return this.negativePrompt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getAspectRatio() {
            return this.aspectRatio;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getSafetySetting() {
            return this.safetySetting;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getPersonGeneration() {
            return this.personGeneration;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getAddWatermark() {
            return this.addWatermark;
        }

        public final ImagenParameters copy(int sampleCount, boolean includeRaiReason, boolean includeSafetyAttributes, String storageUri, String negativePrompt, String aspectRatio, String safetySetting, String personGeneration, Boolean addWatermark, ImagenImageFormat.Internal imageOutputOptions, String editMode, ImagenEditingConfig.Internal editConfig) {
            return new ImagenParameters(sampleCount, includeRaiReason, includeSafetyAttributes, storageUri, negativePrompt, aspectRatio, safetySetting, personGeneration, addWatermark, imageOutputOptions, editMode, editConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImagenParameters)) {
                return false;
            }
            ImagenParameters imagenParameters = (ImagenParameters) other;
            return this.sampleCount == imagenParameters.sampleCount && this.includeRaiReason == imagenParameters.includeRaiReason && this.includeSafetyAttributes == imagenParameters.includeSafetyAttributes && Intrinsics.areEqual(this.storageUri, imagenParameters.storageUri) && Intrinsics.areEqual(this.negativePrompt, imagenParameters.negativePrompt) && Intrinsics.areEqual(this.aspectRatio, imagenParameters.aspectRatio) && Intrinsics.areEqual(this.safetySetting, imagenParameters.safetySetting) && Intrinsics.areEqual(this.personGeneration, imagenParameters.personGeneration) && Intrinsics.areEqual(this.addWatermark, imagenParameters.addWatermark) && Intrinsics.areEqual(this.imageOutputOptions, imagenParameters.imageOutputOptions) && Intrinsics.areEqual(this.editMode, imagenParameters.editMode) && Intrinsics.areEqual(this.editConfig, imagenParameters.editConfig);
        }

        public final Boolean getAddWatermark() {
            return this.addWatermark;
        }

        public final String getAspectRatio() {
            return this.aspectRatio;
        }

        public final ImagenEditingConfig.Internal getEditConfig() {
            return this.editConfig;
        }

        public final String getEditMode() {
            return this.editMode;
        }

        public final ImagenImageFormat.Internal getImageOutputOptions() {
            return this.imageOutputOptions;
        }

        public final boolean getIncludeRaiReason() {
            return this.includeRaiReason;
        }

        public final boolean getIncludeSafetyAttributes() {
            return this.includeSafetyAttributes;
        }

        public final String getNegativePrompt() {
            return this.negativePrompt;
        }

        public final String getPersonGeneration() {
            return this.personGeneration;
        }

        public final String getSafetySetting() {
            return this.safetySetting;
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final String getStorageUri() {
            return this.storageUri;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.includeSafetyAttributes, FileInsert$$ExternalSyntheticOutline0.m(this.includeRaiReason, Integer.hashCode(this.sampleCount) * 31, 31), 31);
            String str = this.storageUri;
            int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.negativePrompt;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.aspectRatio;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.safetySetting;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.personGeneration;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Boolean bool = this.addWatermark;
            int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            ImagenImageFormat.Internal internal = this.imageOutputOptions;
            int iHashCode7 = (iHashCode6 + (internal == null ? 0 : internal.hashCode())) * 31;
            String str6 = this.editMode;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            ImagenEditingConfig.Internal internal2 = this.editConfig;
            return iHashCode8 + (internal2 != null ? internal2.hashCode() : 0);
        }

        public String toString() {
            return "ImagenParameters(sampleCount=" + this.sampleCount + ", includeRaiReason=" + this.includeRaiReason + ", includeSafetyAttributes=" + this.includeSafetyAttributes + ", storageUri=" + this.storageUri + ", negativePrompt=" + this.negativePrompt + ", aspectRatio=" + this.aspectRatio + ", safetySetting=" + this.safetySetting + ", personGeneration=" + this.personGeneration + ", addWatermark=" + this.addWatermark + ", imageOutputOptions=" + this.imageOutputOptions + ", editMode=" + this.editMode + ", editConfig=" + this.editConfig + ')';
        }

        public ImagenParameters(int i, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, Boolean bool, ImagenImageFormat.Internal internal, String str6, ImagenEditingConfig.Internal internal2) {
            this.sampleCount = i;
            this.includeRaiReason = z;
            this.includeSafetyAttributes = z2;
            this.storageUri = str;
            this.negativePrompt = str2;
            this.aspectRatio = str3;
            this.safetySetting = str4;
            this.personGeneration = str5;
            this.addWatermark = bool;
            this.imageOutputOptions = internal;
            this.editMode = str6;
            this.editConfig = internal2;
        }
    }
}
