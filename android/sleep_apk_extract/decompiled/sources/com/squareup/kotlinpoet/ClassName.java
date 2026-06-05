package com.squareup.kotlinpoet;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 62\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u00016BK\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000fB%\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0011\"\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0013J=\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0010¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u001fH\u0016¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010-R\u0017\u0010/\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b/\u0010-\u001a\u0004\b0\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b1\u0010\u001aR\u0011\u00103\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b2\u0010\u001aR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/squareup/kotlinpoet/ClassName;", "Lcom/squareup/kotlinpoet/TypeName;", "", "", "", "names", "", "nullable", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "", "Lkotlin/reflect/KClass;", "", "tags", "<init>", "(Ljava/util/List;ZLjava/util/List;Ljava/util/Map;)V", "packageName", "", "simpleNames", "(Ljava/lang/String;[Ljava/lang/String;)V", "copy", "(ZLjava/util/List;Ljava/util/Map;)Lcom/squareup/kotlinpoet/ClassName;", "enclosingClassName", "()Lcom/squareup/kotlinpoet/ClassName;", "topLevelClassName", "reflectionName", "()Ljava/lang/String;", "name", "nestedClass", "(Ljava/lang/String;)Lcom/squareup/kotlinpoet/ClassName;", "other", "", "compareTo", "(Lcom/squareup/kotlinpoet/ClassName;)I", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;)Lcom/squareup/kotlinpoet/CodeWriter;", "emit", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/util/List;", "comparableNames", "Ljava/lang/String;", "comparableAnnotations", "canonicalName", "getCanonicalName", "getPackageName", "getSimpleName", "simpleName", "getSimpleNames", "()Ljava/util/List;", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClassName extends TypeName implements Comparable<ClassName> {
    private static final Comparator<ClassName> COMPARATOR;
    private final String canonicalName;
    private final String comparableAnnotations;
    private final String comparableNames;
    private final List<String> names;

    static {
        final Comparator comparator = new Comparator() { // from class: com.squareup.kotlinpoet.ClassName$special$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ClassName) t).comparableNames, ((ClassName) t2).comparableNames);
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: com.squareup.kotlinpoet.ClassName$special$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Boolean.valueOf(((ClassName) t).getIsNullable()), Boolean.valueOf(((ClassName) t2).getIsNullable()));
            }
        };
        COMPARATOR = new Comparator() { // from class: com.squareup.kotlinpoet.ClassName$special$$inlined$thenBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator2.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ClassName) t).comparableAnnotations, ((ClassName) t2).comparableAnnotations);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassName(List<String> list, boolean z, List<AnnotationSpec> list2, Map<KClass<?>, ? extends Object> map) {
        super(z, list2, TagMap.INSTANCE.m952invokeBEeaP9Q(map), null);
        list.getClass();
        list2.getClass();
        map.getClass();
        this.names = UtilKt.toImmutableList(list);
        List<String> list3 = list;
        this.comparableNames = CollectionsKt.joinToString$default(list3, null, null, null, null, 63);
        this.comparableAnnotations = CollectionsKt.joinToString$default(list2, null, null, null, null, 63);
        this.canonicalName = list.get(0).length() == 0 ? CollectionsKt.joinToString$default(list.subList(1, list.size()), ".", null, null, null, 62) : CollectionsKt.joinToString$default(list3, ".", null, null, null, 62);
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassName other) {
        other.getClass();
        return COMPARATOR.compare(this, other);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public ClassName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        annotations.getClass();
        tags.getClass();
        return new ClassName(this.names, nullable, annotations, tags);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) {
        out.getClass();
        return CodeWriter.emit$default(out, UtilKt.escapeSegmentsIfNecessary$default(out.lookupName(this), (char) 0, 1, null), false, 2, null);
    }

    public final ClassName enclosingClassName() {
        if (this.names.size() == 2) {
            return null;
        }
        return new ClassName(this.names.subList(0, r9.size() - 1), false, null, null, 14, null);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(ClassName.class, other != null ? other.getClass() : null) || !super.equals(other)) {
            return false;
        }
        other.getClass();
        return Intrinsics.areEqual(this.names, ((ClassName) other).names);
    }

    public final String getCanonicalName() {
        return this.canonicalName;
    }

    public final String getPackageName() {
        return this.names.get(0);
    }

    public final String getSimpleName() {
        return (String) FileInsert$$ExternalSyntheticOutline0.m(this.names, 1);
    }

    public final List<String> getSimpleNames() {
        List<String> list = this.names;
        return list.subList(1, list.size());
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public int hashCode() {
        return this.names.hashCode() + (super.hashCode() * 31);
    }

    public final ClassName nestedClass(String name) {
        name.getClass();
        return new ClassName(CollectionsKt.plus((Collection<? extends String>) this.names, name), false, null, null, 14, null);
    }

    public final String reflectionName() {
        if (this.names.size() == 2) {
            if (getPackageName().length() == 0) {
                return this.names.get(1);
            }
            return getPackageName() + '.' + this.names.get(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(topLevelClassName().canonicalName);
        for (String str : getSimpleNames().subList(1, getSimpleNames().size())) {
            sb.append('$');
            sb.append(str);
        }
        return sb.toString();
    }

    public final ClassName topLevelClassName() {
        return new ClassName(this.names.subList(0, 2), false, null, null, 14, null);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    public /* synthetic */ ClassName(List list, boolean z, List list2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    public ClassName(String str, String... strArr) {
        str.getClass();
        strArr.getClass();
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(str);
        spreadBuilder.addSpread(strArr);
        this(CollectionsKt.listOf(spreadBuilder.toArray(new String[spreadBuilder.size()])), false, null, null, 14, null);
        if (!(strArr.length == 0)) {
            for (String str2 : strArr) {
                if (str2.length() == 0) {
                    String string = Arrays.toString(strArr);
                    string.getClass();
                    Utf8$$ExternalSyntheticBUOutline0.m$4("simpleNames must not contain empty items: ", string);
                    throw null;
                }
            }
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("simpleNames must not be empty");
        throw null;
    }
}
