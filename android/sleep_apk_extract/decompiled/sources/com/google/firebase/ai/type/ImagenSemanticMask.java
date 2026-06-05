package com.google.firebase.ai.type;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/ImagenSemanticMask;", "Lcom/google/firebase/ai/type/ImagenMaskReference;", "classes", "", "", "dilation", "", "<init>", "(Ljava/util/List;Ljava/lang/Double;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenSemanticMask extends ImagenMaskReference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImagenSemanticMask(List<Integer> list, Double d) {
        super(new ImagenMaskConfig(ImagenMaskMode.INSTANCE.getSEMANTIC(), d, list), null, 2, 0 == true ? 1 : 0);
        list.getClass();
    }

    public /* synthetic */ ImagenSemanticMask(List list, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : d);
    }
}
