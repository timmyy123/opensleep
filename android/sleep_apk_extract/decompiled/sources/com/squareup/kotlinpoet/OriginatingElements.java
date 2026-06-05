package com.squareup.kotlinpoet;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import javax.lang.model.element.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0002¨\u0006\u0017"}, d2 = {"Lcom/squareup/kotlinpoet/OriginatingElements;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "originatingElements", "", "Ljavax/lang/model/element/Element;", "constructor-impl", "(Ljava/util/List;)Ljava/util/List;", "getOriginatingElements", "()Ljava/util/List;", "equals", "", "other", "", "equals-impl", "(Ljava/util/List;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/util/List;)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(Ljava/util/List;)Ljava/lang/String;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OriginatingElements implements OriginatingElementsHolder {
    private final List<Element> originatingElements;

    private /* synthetic */ OriginatingElements(List list) {
        this.originatingElements = list;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OriginatingElements m944boximpl(List list) {
        return new OriginatingElements(list);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static List<? extends Element> m945constructorimpl(List<? extends Element> list) {
        list.getClass();
        return list;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m946equalsimpl(List<? extends Element> list, Object obj) {
        return (obj instanceof OriginatingElements) && Intrinsics.areEqual(list, ((OriginatingElements) obj).getOriginatingElements());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m947hashCodeimpl(List<? extends Element> list) {
        return list.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m948toStringimpl(List<? extends Element> list) {
        return "OriginatingElements(originatingElements=" + list + ')';
    }

    public boolean equals(Object obj) {
        return m946equalsimpl(this.originatingElements, obj);
    }

    @Override // com.squareup.kotlinpoet.OriginatingElementsHolder
    public List<Element> getOriginatingElements() {
        return this.originatingElements;
    }

    public int hashCode() {
        return m947hashCodeimpl(this.originatingElements);
    }

    public String toString() {
        return m948toStringimpl(this.originatingElements);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ List getOriginatingElements() {
        return this.originatingElements;
    }
}
