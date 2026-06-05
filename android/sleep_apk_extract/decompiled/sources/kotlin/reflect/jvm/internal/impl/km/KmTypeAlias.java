package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* JADX INFO: loaded from: classes5.dex */
public final class KmTypeAlias {
    private final List<KmAnnotation> annotations;
    private final Map<String, byte[]> compilerPluginMetadata;
    public KmType expandedType;
    private final List<KmTypeAliasExtension> extensions;
    private int flags;
    private String name;
    private final List<KmTypeParameter> typeParameters;
    public KmType underlyingType;
    private final List<KmVersionRequirement> versionRequirements;

    public KmTypeAlias(int i, String str) {
        str.getClass();
        this.flags = i;
        this.name = str;
        this.typeParameters = new ArrayList(0);
        this.annotations = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        this.compilerPluginMetadata = new LinkedHashMap(0);
        List<MetadataExtensions> iNSTANCES$kotlin_metadata = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            ((MetadataExtensions) it.next()).createTypeAliasExtension();
        }
        this.extensions = arrayList;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final Map<String, byte[]> getCompilerPluginMetadata() {
        return this.compilerPluginMetadata;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setExpandedType(KmType kmType) {
        kmType.getClass();
        this.expandedType = kmType;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final void setUnderlyingType(KmType kmType) {
        kmType.getClass();
        this.underlyingType = kmType;
    }
}
