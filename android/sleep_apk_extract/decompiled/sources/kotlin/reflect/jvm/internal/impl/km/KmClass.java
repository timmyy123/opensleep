package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* JADX INFO: loaded from: classes5.dex */
public final class KmClass implements KmDeclarationContainer {
    private String companionObject;
    private final List<KmClassExtension> extensions;
    private int flags;
    private String inlineClassUnderlyingPropertyName;
    private KmType inlineClassUnderlyingType;
    public String name;
    private final List<KmTypeParameter> typeParameters = new ArrayList(0);
    private final List<KmType> supertypes = new ArrayList(1);
    private final List<KmFunction> functions = new ArrayList();
    private final List<KmProperty> properties = new ArrayList();
    private final List<KmTypeAlias> typeAliases = new ArrayList(0);
    private final List<KmConstructor> constructors = new ArrayList(1);
    private final List<String> nestedClasses = new ArrayList(0);
    private final List<String> enumEntries = new ArrayList(0);
    private final List<KmEnumEntry> kmEnumEntries = new ArrayList(0);
    private final List<String> sealedSubclasses = new ArrayList(0);
    private final List<KmAnnotation> annotations = new ArrayList(0);
    private final List<KmType> contextReceiverTypes = new ArrayList(0);
    private final List<KmVersionRequirement> versionRequirements = new ArrayList(0);
    private final Map<String, byte[]> compilerPluginMetadata = new LinkedHashMap(0);

    public KmClass() {
        List<MetadataExtensions> iNSTANCES$kotlin_metadata = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((MetadataExtensions) it.next()).createClassExtension());
        }
        this.extensions = arrayList;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final Map<String, byte[]> getCompilerPluginMetadata() {
        return this.compilerPluginMetadata;
    }

    public final List<KmConstructor> getConstructors() {
        return this.constructors;
    }

    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final List<String> getEnumEntries() {
        return this.enumEntries;
    }

    public final List<KmClassExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmFunction> getFunctions() {
        return this.functions;
    }

    public final String getInlineClassUnderlyingPropertyName() {
        return this.inlineClassUnderlyingPropertyName;
    }

    public final KmType getInlineClassUnderlyingType() {
        return this.inlineClassUnderlyingType;
    }

    public final List<KmEnumEntry> getKmEnumEntries() {
        return this.kmEnumEntries;
    }

    public final String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final List<String> getNestedClasses() {
        return this.nestedClasses;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmProperty> getProperties() {
        return this.properties;
    }

    public final List<String> getSealedSubclasses() {
        return this.sealedSubclasses;
    }

    public final List<KmType> getSupertypes() {
        return this.supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setCompanionObject(String str) {
        this.companionObject = str;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final void setInlineClassUnderlyingPropertyName(String str) {
        this.inlineClassUnderlyingPropertyName = str;
    }

    public final void setInlineClassUnderlyingType(KmType kmType) {
        this.inlineClassUnderlyingType = kmType;
    }

    public final void setName(String str) {
        str.getClass();
        this.name = str;
    }
}
