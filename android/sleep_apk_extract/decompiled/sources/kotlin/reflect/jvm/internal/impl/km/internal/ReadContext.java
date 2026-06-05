package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;

/* JADX INFO: loaded from: classes5.dex */
public final class ReadContext {
    private final List<Object> contextExtensions;
    private final List<MetadataExtensions> extensions;
    private final boolean ignoreUnknownVersionRequirements;
    private final ReadContext parent;
    private final NameResolver strings;
    private final Map<Integer, Integer> typeParameterNameToId;
    private final TypeTable types;
    private final VersionRequirementTable versionRequirements;

    public ReadContext(NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, boolean z, ReadContext readContext, List<? extends Object> list) {
        nameResolver.getClass();
        typeTable.getClass();
        versionRequirementTable.getClass();
        list.getClass();
        this.strings = nameResolver;
        this.types = typeTable;
        this.versionRequirements = versionRequirementTable;
        this.ignoreUnknownVersionRequirements = z;
        this.parent = readContext;
        this.contextExtensions = list;
        this.typeParameterNameToId = new LinkedHashMap();
        this.extensions = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
    }

    public final String className$kotlin_metadata(int i) {
        return ReadUtilsKt.getClassName(this.strings, i);
    }

    public final String get(int i) {
        return this.strings.getString(i);
    }

    public final List<MetadataExtensions> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final boolean getIgnoreUnknownVersionRequirements$kotlin_metadata() {
        return this.ignoreUnknownVersionRequirements;
    }

    public final NameResolver getStrings() {
        return this.strings;
    }

    public final Integer getTypeParameterId$kotlin_metadata(int i) {
        Integer num = this.typeParameterNameToId.get(Integer.valueOf(i));
        if (num != null) {
            return num;
        }
        ReadContext readContext = this.parent;
        if (readContext != null) {
            return readContext.getTypeParameterId$kotlin_metadata(i);
        }
        return null;
    }

    public final TypeTable getTypes() {
        return this.types;
    }

    public final VersionRequirementTable getVersionRequirements$kotlin_metadata() {
        return this.versionRequirements;
    }

    public final ReadContext withTypeParameters$kotlin_metadata(List<ProtoBuf$TypeParameter> list) {
        list.getClass();
        ReadContext readContext = new ReadContext(this.strings, this.types, this.versionRequirements, this.ignoreUnknownVersionRequirements, this, this.contextExtensions);
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : list) {
            readContext.typeParameterNameToId.put(Integer.valueOf(protoBuf$TypeParameter.getName()), Integer.valueOf(protoBuf$TypeParameter.getId()));
        }
        return readContext;
    }

    public /* synthetic */ ReadContext(NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, boolean z, ReadContext readContext, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nameResolver, typeTable, versionRequirementTable, z, (i & 16) != 0 ? null : readContext, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }
}
