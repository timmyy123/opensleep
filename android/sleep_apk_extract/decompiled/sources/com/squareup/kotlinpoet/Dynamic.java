package com.squareup.kotlinpoet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/squareup/kotlinpoet/Dynamic;", "Lcom/squareup/kotlinpoet/TypeName;", "<init>", "()V", "copy", "", "nullable", "", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "tags", "", "Lkotlin/reflect/KClass;", "", "emit", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Dynamic extends TypeName {
    public static final Dynamic INSTANCE = new Dynamic();

    private Dynamic() {
        super(false, CollectionsKt.emptyList(), TagMap.INSTANCE.m952invokeBEeaP9Q(MapsKt.emptyMap()), null);
    }

    /* JADX INFO: renamed from: copy, reason: collision with other method in class */
    public Void m941copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        annotations.getClass();
        tags.getClass();
        throw new UnsupportedOperationException("dynamic doesn't support copying");
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) throws IOException {
        out.getClass();
        CodeWriter.emit$default(out, "dynamic", false, 2, null);
        return out;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return (TypeName) m941copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }
}
