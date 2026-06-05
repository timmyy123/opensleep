package com.google.firebase.ai.type;

import android.util.Base64;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\r\u000e\u000fB!\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationResponse;", "T", "", "images", "", "filteredReason", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getImages", "()Ljava/util/List;", "getFilteredReason", "()Ljava/lang/String;", "Internal", "ImagenImageResponse", "ImagenSafetyAttributes", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenGenerationResponse<T> {
    private final String filteredReason;
    private final List<T> images;

    /* JADX WARN: Multi-variable type inference failed */
    public ImagenGenerationResponse(List<? extends T> list, String str) {
        list.getClass();
        this.images = list;
        this.filteredReason = str;
    }

    public final String getFilteredReason() {
        return this.filteredReason;
    }

    public final List<T> getImages() {
        return this.images;
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0000¢\u0006\u0002\b\u0011J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fH\u0000¢\u0006\u0002\b\u0014J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationResponse$Internal;", "", "predictions", "", "Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenImageResponse;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPredictions", "()Ljava/util/List;", "toPublicGCS", "Lcom/google/firebase/ai/type/ImagenGenerationResponse;", "Lcom/google/firebase/ai/type/ImagenGCSImage;", "toPublicGCS$com_google_firebase_ai_logic_firebase_ai", "toPublicInline", "Lcom/google/firebase/ai/type/ImagenInlineImage;", "toPublicInline$com_google_firebase_ai_logic_firebase_ai", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final List<ImagenImageResponse> predictions;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ImagenGenerationResponse$ImagenImageResponse$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationResponse$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ImagenGenerationResponse$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return ImagenGenerationResponse$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ImagenGenerationResponse$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.predictions = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = internal.predictions;
            }
            return internal.copy(list);
        }

        public final List<ImagenImageResponse> component1() {
            return this.predictions;
        }

        public final Internal copy(List<ImagenImageResponse> predictions) {
            predictions.getClass();
            return new Internal(predictions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Internal) && Intrinsics.areEqual(this.predictions, ((Internal) other).predictions);
        }

        public final List<ImagenImageResponse> getPredictions() {
            return this.predictions;
        }

        public int hashCode() {
            return this.predictions.hashCode();
        }

        public final ImagenGenerationResponse<ImagenGCSImage> toPublicGCS$com_google_firebase_ai_logic_firebase_ai() {
            List<ImagenImageResponse> list = this.predictions;
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (((ImagenImageResponse) t).getMimeType() != null) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ImagenImageResponse) it.next()).toPublicGCS$com_google_firebase_ai_logic_firebase_ai());
            }
            return new ImagenGenerationResponse<>(arrayList2, null);
        }

        public final ImagenGenerationResponse<ImagenInlineImage> toPublicInline$com_google_firebase_ai_logic_firebase_ai() {
            String raiFilteredReason;
            List<ImagenImageResponse> list = this.predictions;
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (((ImagenImageResponse) t).getMimeType() != null) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ImagenImageResponse) it.next()).toPublicInline$com_google_firebase_ai_logic_firebase_ai());
            }
            Iterator<T> it2 = this.predictions.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    raiFilteredReason = null;
                    break;
                }
                raiFilteredReason = ((ImagenImageResponse) it2.next()).getRaiFilteredReason();
                if (raiFilteredReason != null) {
                    break;
                }
            }
            return new ImagenGenerationResponse<>(arrayList2, raiFilteredReason);
        }

        public String toString() {
            return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder("Internal(predictions="), (List) this.predictions, ')');
        }

        public Internal(List<ImagenImageResponse> list) {
            list.getClass();
            this.predictions = list;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0019\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\b\u0013J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006&"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenSafetyAttributes;", "", "categories", "", "", "scores", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCategories", "()Ljava/util/List;", "getScores", "toPublic", "", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ImagenSafetyAttributes {
        private final List<String> categories;
        private final List<Double> scores;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(DoubleSerializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenSafetyAttributes$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenSafetyAttributes;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ImagenSafetyAttributes> serializer() {
                return ImagenGenerationResponse$ImagenSafetyAttributes$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ImagenSafetyAttributes(int i, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.categories = null;
            } else {
                this.categories = list;
            }
            if ((i & 2) == 0) {
                this.scores = null;
            } else {
                this.scores = list2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ImagenSafetyAttributes copy$default(ImagenSafetyAttributes imagenSafetyAttributes, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = imagenSafetyAttributes.categories;
            }
            if ((i & 2) != 0) {
                list2 = imagenSafetyAttributes.scores;
            }
            return imagenSafetyAttributes.copy(list, list2);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(ImagenSafetyAttributes self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.categories != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.categories);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.scores == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.scores);
        }

        public final List<String> component1() {
            return this.categories;
        }

        public final List<Double> component2() {
            return this.scores;
        }

        public final ImagenSafetyAttributes copy(List<String> categories, List<Double> scores) {
            return new ImagenSafetyAttributes(categories, scores);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImagenSafetyAttributes)) {
                return false;
            }
            ImagenSafetyAttributes imagenSafetyAttributes = (ImagenSafetyAttributes) other;
            return Intrinsics.areEqual(this.categories, imagenSafetyAttributes.categories) && Intrinsics.areEqual(this.scores, imagenSafetyAttributes.scores);
        }

        public final List<String> getCategories() {
            return this.categories;
        }

        public final List<Double> getScores() {
            return this.scores;
        }

        public int hashCode() {
            List<String> list = this.categories;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            List<Double> list2 = this.scores;
            return iHashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public final Map<String, Double> toPublic$com_google_firebase_ai_logic_firebase_ai() {
            List<Double> list;
            List<String> list2 = this.categories;
            return (list2 == null || (list = this.scores) == null) ? MapsKt.emptyMap() : MapsKt.toMap(CollectionsKt.zip(list2, list));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ImagenSafetyAttributes(categories=");
            sb.append(this.categories);
            sb.append(", scores=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.scores, ')');
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ImagenSafetyAttributes() {
            this((List) null, (List) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public ImagenSafetyAttributes(List<String> list, List<Double> list2) {
            this.categories = list;
            this.scores = list2;
        }

        public /* synthetic */ ImagenSafetyAttributes(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 12\u00020\u0001:\u000201BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00062"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenImageResponse;", "", "bytesBase64Encoded", "", "gcsUri", "mimeType", "raiFilteredReason", "safetyAttributes", "Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenSafetyAttributes;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenSafetyAttributes;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenSafetyAttributes;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBytesBase64Encoded", "()Ljava/lang/String;", "getGcsUri", "getMimeType", "getRaiFilteredReason", "getSafetyAttributes", "()Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenSafetyAttributes;", "toPublicInline", "Lcom/google/firebase/ai/type/ImagenInlineImage;", "toPublicInline$com_google_firebase_ai_logic_firebase_ai", "toPublicGCS", "Lcom/google/firebase/ai/type/ImagenGCSImage;", "toPublicGCS$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ImagenImageResponse {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String bytesBase64Encoded;
        private final String gcsUri;
        private final String mimeType;
        private final String raiFilteredReason;
        private final ImagenSafetyAttributes safetyAttributes;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenImageResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenImageResponse;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ImagenImageResponse> serializer() {
                return ImagenGenerationResponse$ImagenImageResponse$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ImagenImageResponse(int i, String str, String str2, String str3, String str4, ImagenSafetyAttributes imagenSafetyAttributes, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.bytesBase64Encoded = null;
            } else {
                this.bytesBase64Encoded = str;
            }
            if ((i & 2) == 0) {
                this.gcsUri = null;
            } else {
                this.gcsUri = str2;
            }
            if ((i & 4) == 0) {
                this.mimeType = null;
            } else {
                this.mimeType = str3;
            }
            if ((i & 8) == 0) {
                this.raiFilteredReason = null;
            } else {
                this.raiFilteredReason = str4;
            }
            if ((i & 16) == 0) {
                this.safetyAttributes = null;
            } else {
                this.safetyAttributes = imagenSafetyAttributes;
            }
        }

        public static /* synthetic */ ImagenImageResponse copy$default(ImagenImageResponse imagenImageResponse, String str, String str2, String str3, String str4, ImagenSafetyAttributes imagenSafetyAttributes, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imagenImageResponse.bytesBase64Encoded;
            }
            if ((i & 2) != 0) {
                str2 = imagenImageResponse.gcsUri;
            }
            if ((i & 4) != 0) {
                str3 = imagenImageResponse.mimeType;
            }
            if ((i & 8) != 0) {
                str4 = imagenImageResponse.raiFilteredReason;
            }
            if ((i & 16) != 0) {
                imagenSafetyAttributes = imagenImageResponse.safetyAttributes;
            }
            ImagenSafetyAttributes imagenSafetyAttributes2 = imagenSafetyAttributes;
            String str5 = str3;
            return imagenImageResponse.copy(str, str2, str5, str4, imagenSafetyAttributes2);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(ImagenImageResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bytesBase64Encoded != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.bytesBase64Encoded);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gcsUri != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.gcsUri);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.mimeType != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.mimeType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.raiFilteredReason != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.raiFilteredReason);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.safetyAttributes == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 4, ImagenGenerationResponse$ImagenSafetyAttributes$$serializer.INSTANCE, self.safetyAttributes);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBytesBase64Encoded() {
            return this.bytesBase64Encoded;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGcsUri() {
            return this.gcsUri;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getRaiFilteredReason() {
            return this.raiFilteredReason;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ImagenSafetyAttributes getSafetyAttributes() {
            return this.safetyAttributes;
        }

        public final ImagenImageResponse copy(String bytesBase64Encoded, String gcsUri, String mimeType, String raiFilteredReason, ImagenSafetyAttributes safetyAttributes) {
            return new ImagenImageResponse(bytesBase64Encoded, gcsUri, mimeType, raiFilteredReason, safetyAttributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImagenImageResponse)) {
                return false;
            }
            ImagenImageResponse imagenImageResponse = (ImagenImageResponse) other;
            return Intrinsics.areEqual(this.bytesBase64Encoded, imagenImageResponse.bytesBase64Encoded) && Intrinsics.areEqual(this.gcsUri, imagenImageResponse.gcsUri) && Intrinsics.areEqual(this.mimeType, imagenImageResponse.mimeType) && Intrinsics.areEqual(this.raiFilteredReason, imagenImageResponse.raiFilteredReason) && Intrinsics.areEqual(this.safetyAttributes, imagenImageResponse.safetyAttributes);
        }

        public final String getBytesBase64Encoded() {
            return this.bytesBase64Encoded;
        }

        public final String getGcsUri() {
            return this.gcsUri;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final String getRaiFilteredReason() {
            return this.raiFilteredReason;
        }

        public final ImagenSafetyAttributes getSafetyAttributes() {
            return this.safetyAttributes;
        }

        public int hashCode() {
            String str = this.bytesBase64Encoded;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.gcsUri;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.mimeType;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.raiFilteredReason;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            ImagenSafetyAttributes imagenSafetyAttributes = this.safetyAttributes;
            return iHashCode4 + (imagenSafetyAttributes != null ? imagenSafetyAttributes.hashCode() : 0);
        }

        public final ImagenGCSImage toPublicGCS$com_google_firebase_ai_logic_firebase_ai() {
            String str = this.gcsUri;
            str.getClass();
            String str2 = this.mimeType;
            str2.getClass();
            return new ImagenGCSImage(str, str2);
        }

        public final ImagenInlineImage toPublicInline$com_google_firebase_ai_logic_firebase_ai() {
            String str = this.bytesBase64Encoded;
            str.getClass();
            byte[] bArrDecode = Base64.decode(str, 2);
            bArrDecode.getClass();
            String str2 = this.mimeType;
            str2.getClass();
            return new ImagenInlineImage(bArrDecode, str2);
        }

        public String toString() {
            return "ImagenImageResponse(bytesBase64Encoded=" + this.bytesBase64Encoded + ", gcsUri=" + this.gcsUri + ", mimeType=" + this.mimeType + ", raiFilteredReason=" + this.raiFilteredReason + ", safetyAttributes=" + this.safetyAttributes + ')';
        }

        public ImagenImageResponse() {
            this((String) null, (String) null, (String) null, (String) null, (ImagenSafetyAttributes) null, 31, (DefaultConstructorMarker) null);
        }

        public ImagenImageResponse(String str, String str2, String str3, String str4, ImagenSafetyAttributes imagenSafetyAttributes) {
            this.bytesBase64Encoded = str;
            this.gcsUri = str2;
            this.mimeType = str3;
            this.raiFilteredReason = str4;
            this.safetyAttributes = imagenSafetyAttributes;
        }

        public /* synthetic */ ImagenImageResponse(String str, String str2, String str3, String str4, ImagenSafetyAttributes imagenSafetyAttributes, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : imagenSafetyAttributes);
        }
    }
}
