package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/ai/type/ImagenRawMask;", "Lcom/google/firebase/ai/type/ImagenMaskReference;", "mask", "Lcom/google/firebase/ai/type/ImagenInlineImage;", "dilation", "", "<init>", "(Lcom/google/firebase/ai/type/ImagenInlineImage;Ljava/lang/Double;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenRawMask extends ImagenMaskReference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagenRawMask(ImagenInlineImage imagenInlineImage, Double d) {
        super(new ImagenMaskConfig(ImagenMaskMode.INSTANCE.getUSER_PROVIDED(), d, null, 4, null), imagenInlineImage);
        imagenInlineImage.getClass();
    }

    public /* synthetic */ ImagenRawMask(ImagenInlineImage imagenInlineImage, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imagenInlineImage, (i & 2) != 0 ? null : d);
    }
}
