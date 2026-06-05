package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/firebase/ai/type/ImagenControlReference;", "Lcom/google/firebase/ai/type/ImagenReferenceImage;", "type", "Lcom/google/firebase/ai/type/ImagenControlType;", "image", "Lcom/google/firebase/ai/type/ImagenInlineImage;", "referenceId", "", "enableComputation", "", "superpixelRegionSize", "superpixelRuler", "<init>", "(Lcom/google/firebase/ai/type/ImagenControlType;Lcom/google/firebase/ai/type/ImagenInlineImage;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenControlReference extends ImagenReferenceImage {
    public /* synthetic */ ImagenControlReference(ImagenControlType imagenControlType, ImagenInlineImage imagenInlineImage, Integer num, Boolean bool, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imagenControlType, (i & 2) != 0 ? null : imagenInlineImage, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagenControlReference(ImagenControlType imagenControlType, ImagenInlineImage imagenInlineImage, Integer num, Boolean bool, Integer num2, Integer num3) {
        super(null, null, null, new ImagenControlConfig(imagenControlType, bool, num2, num3), imagenInlineImage, num, 7, null);
        imagenControlType.getClass();
    }
}
