package com.squareup.kotlinpoet;

import com.squareup.kotlinpoet.OriginatingElementsHolder;
import java.util.List;
import javax.lang.model.element.Element;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0002\u0010\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"buildOriginatingElements", "Lcom/squareup/kotlinpoet/OriginatingElements;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder$Builder;", "(Lcom/squareup/kotlinpoet/OriginatingElementsHolder$Builder;)Ljava/util/List;", "", "Ljavax/lang/model/element/Element;", "(Ljava/util/List;)Ljava/util/List;", "kotlinpoet"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class OriginatingElementsHolderKt {
    public static final List<? extends Element> buildOriginatingElements(OriginatingElementsHolder.Builder<?> builder) {
        builder.getClass();
        return OriginatingElements.m945constructorimpl(UtilKt.toImmutableList(builder.getOriginatingElements()));
    }

    public static final List<? extends Element> buildOriginatingElements(List<? extends Element> list) {
        list.getClass();
        return OriginatingElements.m945constructorimpl(UtilKt.toImmutableList(list));
    }
}
