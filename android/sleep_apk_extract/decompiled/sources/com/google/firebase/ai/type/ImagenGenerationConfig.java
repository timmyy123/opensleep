package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bBC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationConfig;", "", "negativePrompt", "", "numberOfImages", "", "aspectRatio", "Lcom/google/firebase/ai/type/ImagenAspectRatio;", "imageFormat", "Lcom/google/firebase/ai/type/ImagenImageFormat;", "addWatermark", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/google/firebase/ai/type/ImagenAspectRatio;Lcom/google/firebase/ai/type/ImagenImageFormat;Ljava/lang/Boolean;)V", "getNegativePrompt", "()Ljava/lang/String;", "getNumberOfImages", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAspectRatio", "()Lcom/google/firebase/ai/type/ImagenAspectRatio;", "getImageFormat", "()Lcom/google/firebase/ai/type/ImagenImageFormat;", "getAddWatermark", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "Builder", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenGenerationConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean addWatermark;
    private final ImagenAspectRatio aspectRatio;
    private final ImagenImageFormat imageFormat;
    private final String negativePrompt;
    private final Integer numberOfImages;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationConfig$Builder;", "", "<init>", "()V", "negativePrompt", "", "numberOfImages", "", "Ljava/lang/Integer;", "aspectRatio", "Lcom/google/firebase/ai/type/ImagenAspectRatio;", "imageFormat", "Lcom/google/firebase/ai/type/ImagenImageFormat;", "addWatermark", "", "Ljava/lang/Boolean;", "setNegativePrompt", "setNumberOfImages", "setAspectRatio", "setImageFormat", "setAddWatermark", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/firebase/ai/type/ImagenGenerationConfig;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public Boolean addWatermark;
        public ImagenAspectRatio aspectRatio;
        public ImagenImageFormat imageFormat;
        public String negativePrompt;
        public Integer numberOfImages = 1;

        public final ImagenGenerationConfig build() {
            return new ImagenGenerationConfig(this.negativePrompt, this.numberOfImages, this.aspectRatio, this.imageFormat, this.addWatermark);
        }

        public final Builder setAddWatermark(boolean addWatermark) {
            this.addWatermark = Boolean.valueOf(addWatermark);
            return this;
        }

        public final Builder setAspectRatio(ImagenAspectRatio aspectRatio) {
            aspectRatio.getClass();
            this.aspectRatio = aspectRatio;
            return this;
        }

        public final Builder setImageFormat(ImagenImageFormat imageFormat) {
            imageFormat.getClass();
            this.imageFormat = imageFormat;
            return this;
        }

        public final Builder setNegativePrompt(String negativePrompt) {
            negativePrompt.getClass();
            this.negativePrompt = negativePrompt;
            return this;
        }

        public final Builder setNumberOfImages(int numberOfImages) {
            this.numberOfImages = Integer.valueOf(numberOfImages);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGenerationConfig$Companion;", "", "<init>", "()V", "builder", "Lcom/google/firebase/ai/type/ImagenGenerationConfig$Builder;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder() {
            return new Builder();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImagenGenerationConfig(String str, Integer num, ImagenAspectRatio imagenAspectRatio, ImagenImageFormat imagenImageFormat, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 1 : num, (i & 4) != 0 ? null : imagenAspectRatio, (i & 8) != 0 ? null : imagenImageFormat, (i & 16) != 0 ? null : bool);
    }

    public final Boolean getAddWatermark() {
        return this.addWatermark;
    }

    public final ImagenAspectRatio getAspectRatio() {
        return this.aspectRatio;
    }

    public final ImagenImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public final String getNegativePrompt() {
        return this.negativePrompt;
    }

    public final Integer getNumberOfImages() {
        return this.numberOfImages;
    }

    public ImagenGenerationConfig(String str, Integer num, ImagenAspectRatio imagenAspectRatio, ImagenImageFormat imagenImageFormat, Boolean bool) {
        this.negativePrompt = str;
        this.numberOfImages = num;
        this.aspectRatio = imagenAspectRatio;
        this.imageFormat = imagenImageFormat;
        this.addWatermark = bool;
    }

    public ImagenGenerationConfig() {
        this(null, null, null, null, null, 31, null);
    }
}
