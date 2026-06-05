package com.squareup.kotlinpoet;

import com.squareup.kotlinpoet.Annotatable$Builder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\bf\u0018\u0000*\u0010\b\u0000\u0010\u0002 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"com/squareup/kotlinpoet/Annotatable$Builder", "Lcom/squareup/kotlinpoet/Annotatable$Builder;", "T", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotationSpec", "addAnnotation", "(Lcom/squareup/kotlinpoet/AnnotationSpec;)Lcom/squareup/kotlinpoet/Annotatable$Builder;", "", "annotationSpecs", "addAnnotations", "(Ljava/lang/Iterable;)Lcom/squareup/kotlinpoet/Annotatable$Builder;", "", "getAnnotations", "()Ljava/util/List;", "annotations", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Annotatable$Builder<T extends Annotatable$Builder<? extends T>> {
    /* JADX WARN: Multi-variable type inference failed */
    default T addAnnotation(AnnotationSpec annotationSpec) {
        annotationSpec.getClass();
        getAnnotations().add(annotationSpec);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    default T addAnnotations(Iterable<AnnotationSpec> annotationSpecs) {
        annotationSpecs.getClass();
        Iterator<AnnotationSpec> it = annotationSpecs.iterator();
        while (it.hasNext()) {
            addAnnotation(it.next());
        }
        return this;
    }

    List<AnnotationSpec> getAnnotations();
}
