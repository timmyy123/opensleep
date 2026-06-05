package com.squareup.kotlinpoet;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.squareup.kotlinpoet.TypeName;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 BY\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e¨\u0006!"}, d2 = {"Lcom/squareup/kotlinpoet/WildcardTypeName;", "Lcom/squareup/kotlinpoet/TypeName;", "", "outTypes", "inTypes", "", "nullable", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "", "Lkotlin/reflect/KClass;", "", "tags", "<init>", "(Ljava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/util/Map;)V", "copy", "(ZLjava/util/List;Ljava/util/Map;)Lcom/squareup/kotlinpoet/WildcardTypeName;", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;)Lcom/squareup/kotlinpoet/CodeWriter;", "emit", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/List;", "getOutTypes", "()Ljava/util/List;", "getInTypes", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WildcardTypeName extends TypeName {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<TypeName> inTypes;
    private final List<TypeName> outTypes;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/squareup/kotlinpoet/WildcardTypeName$Companion;", "", "<init>", "()V", "Lcom/squareup/kotlinpoet/TypeName;", "outType", "Lcom/squareup/kotlinpoet/WildcardTypeName;", "producerOf", "(Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/WildcardTypeName;", "Ljava/lang/reflect/WildcardType;", "wildcardName", "", "Ljava/lang/reflect/Type;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "map", "get$kotlinpoet", "(Ljava/lang/reflect/WildcardType;Ljava/util/Map;)Lcom/squareup/kotlinpoet/TypeName;", "get", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TypeName get$kotlinpoet(WildcardType wildcardName, Map<Type, TypeVariableName> map) {
            wildcardName.getClass();
            map.getClass();
            Type[] upperBounds = wildcardName.getUpperBounds();
            upperBounds.getClass();
            ArrayList arrayList = new ArrayList(upperBounds.length);
            for (Type type : upperBounds) {
                TypeName.Companion companion = TypeName.INSTANCE;
                type.getClass();
                arrayList.add(companion.get$kotlinpoet(type, map));
            }
            Type[] lowerBounds = wildcardName.getLowerBounds();
            lowerBounds.getClass();
            ArrayList arrayList2 = new ArrayList(lowerBounds.length);
            for (Type type2 : lowerBounds) {
                TypeName.Companion companion2 = TypeName.INSTANCE;
                type2.getClass();
                arrayList2.add(companion2.get$kotlinpoet(type2, map));
            }
            return new WildcardTypeName(arrayList, arrayList2, false, null, null, 28, null);
        }

        public final WildcardTypeName producerOf(TypeName outType) {
            outType.getClass();
            return new WildcardTypeName(CollectionsKt.listOf(outType), CollectionsKt.emptyList(), false, null, null, 28, null);
        }

        private Companion() {
        }
    }

    private WildcardTypeName(List<? extends TypeName> list, List<? extends TypeName> list2, boolean z, List<AnnotationSpec> list3, Map<KClass<?>, ? extends Object> map) {
        super(z, list3, TagMap.INSTANCE.m952invokeBEeaP9Q(map), null);
        List<TypeName> immutableList = UtilKt.toImmutableList(list);
        this.outTypes = immutableList;
        this.inTypes = UtilKt.toImmutableList(list2);
        if (immutableList.size() == 1) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$4("unexpected out types: ", list);
        throw null;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public WildcardTypeName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        annotations.getClass();
        tags.getClass();
        return new WildcardTypeName(this.outTypes, this.inTypes, nullable, annotations, tags);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) {
        out.getClass();
        return this.inTypes.size() == 1 ? out.emitCode("in %T", this.inTypes.get(0)) : Intrinsics.areEqual(this.outTypes, TypeNames.STAR.outTypes) ? CodeWriter.emit$default(out, "*", false, 2, null) : out.emitCode("out %T", this.outTypes.get(0));
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(WildcardTypeName.class, other != null ? other.getClass() : null) || !super.equals(other)) {
            return false;
        }
        other.getClass();
        WildcardTypeName wildcardTypeName = (WildcardTypeName) other;
        return Intrinsics.areEqual(this.outTypes, wildcardTypeName.outTypes) && Intrinsics.areEqual(this.inTypes, wildcardTypeName.inTypes);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public int hashCode() {
        return this.inTypes.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) this.outTypes, super.hashCode() * 31, 31);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    public /* synthetic */ WildcardTypeName(List list, List list2, boolean z, List list3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? CollectionsKt.emptyList() : list3, (i & 16) != 0 ? MapsKt.emptyMap() : map);
    }
}
