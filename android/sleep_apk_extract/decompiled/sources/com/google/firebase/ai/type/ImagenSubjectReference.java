package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/firebase/ai/type/ImagenSubjectReference;", "Lcom/google/firebase/ai/type/ImagenReferenceImage;", "image", "Lcom/google/firebase/ai/type/ImagenInlineImage;", "referenceId", "", "description", "", "subjectType", "Lcom/google/firebase/ai/type/ImagenSubjectReferenceType;", "<init>", "(Lcom/google/firebase/ai/type/ImagenInlineImage;Ljava/lang/Integer;Ljava/lang/String;Lcom/google/firebase/ai/type/ImagenSubjectReferenceType;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenSubjectReference extends ImagenReferenceImage {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagenSubjectReference(ImagenInlineImage imagenInlineImage, Integer num, String str, ImagenSubjectReferenceType imagenSubjectReferenceType) {
        super(null, new ImagenSubjectConfig(str, imagenSubjectReferenceType), null, null, imagenInlineImage, num, 13, null);
        imagenInlineImage.getClass();
    }

    public /* synthetic */ ImagenSubjectReference(ImagenInlineImage imagenInlineImage, Integer num, String str, ImagenSubjectReferenceType imagenSubjectReferenceType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imagenInlineImage, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : imagenSubjectReferenceType);
    }
}
