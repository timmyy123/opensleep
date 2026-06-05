package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* JADX INFO: loaded from: classes5.dex */
public final class KmProperty {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(KmProperty.class, "_hasSetter", "get_hasSetter()Z", 0), new MutablePropertyReference1Impl(KmProperty.class, "_hasGetter", "get_hasGetter()Z", 0)};
    private final BooleanFlagDelegate _hasGetter$delegate;
    private final BooleanFlagDelegate _hasSetter$delegate;
    private final List<KmAnnotation> annotations;
    private final List<KmAnnotation> backingFieldAnnotations;
    private final Map<String, byte[]> compilerPluginMetadata;
    private final List<KmValueParameter> contextParameters;
    private final List<KmType> contextReceiverTypes;
    private final List<KmAnnotation> delegateFieldAnnotations;
    private final List<KmAnnotation> extensionReceiverParameterAnnotations;
    private final List<KmPropertyExtension> extensions;
    private int flags;
    private final KmPropertyAccessorAttributes getter;
    private String name;
    private KmType receiverParameterType;
    public KmType returnType;
    private KmPropertyAccessorAttributes setter;
    private KmValueParameter setterParameter;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmVersionRequirement> versionRequirements;

    public KmProperty(int i, String str, int i2, int i3) {
        str.getClass();
        this.flags = i;
        this.name = str;
        Flags.BooleanFlagField booleanFlagField = Flags.HAS_SETTER;
        booleanFlagField.getClass();
        this._hasSetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField));
        Flags.BooleanFlagField booleanFlagField2 = Flags.HAS_GETTER;
        booleanFlagField2.getClass();
        this._hasGetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField2));
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = new KmPropertyAccessorAttributes(i2);
        set_hasGetter(true);
        this.getter = kmPropertyAccessorAttributes;
        this.setter = get_hasSetter() ? new KmPropertyAccessorAttributes(i3) : null;
        this.typeParameters = new ArrayList(0);
        this.extensionReceiverParameterAnnotations = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.contextParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        this.compilerPluginMetadata = new LinkedHashMap(0);
        this.annotations = new ArrayList(0);
        this.backingFieldAnnotations = new ArrayList(0);
        this.delegateFieldAnnotations = new ArrayList(0);
        List<MetadataExtensions> iNSTANCES$kotlin_metadata = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((MetadataExtensions) it.next()).createPropertyExtension());
        }
        this.extensions = arrayList;
    }

    private final boolean get_hasSetter() {
        return this._hasSetter$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void set_hasGetter(boolean z) {
        this._hasGetter$delegate.setValue(this, $$delegatedProperties[1], z);
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmAnnotation> getBackingFieldAnnotations() {
        return this.backingFieldAnnotations;
    }

    public final Map<String, byte[]> getCompilerPluginMetadata() {
        return this.compilerPluginMetadata;
    }

    public final List<KmValueParameter> getContextParameters() {
        return this.contextParameters;
    }

    public final List<KmAnnotation> getDelegateFieldAnnotations() {
        return this.delegateFieldAnnotations;
    }

    public final List<KmAnnotation> getExtensionReceiverParameterAnnotations() {
        return this.extensionReceiverParameterAnnotations;
    }

    public final List<KmPropertyExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final KmPropertyAccessorAttributes getGetter() {
        return this.getter;
    }

    public final String getName() {
        return this.name;
    }

    public final KmType getReceiverParameterType() {
        return this.receiverParameterType;
    }

    public final KmType getReturnType() {
        KmType kmType = this.returnType;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("returnType");
        return null;
    }

    public final KmPropertyAccessorAttributes getSetter() {
        return this.setter;
    }

    public final KmValueParameter getSetterParameter() {
        return this.setterParameter;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final void setReceiverParameterType(KmType kmType) {
        this.receiverParameterType = kmType;
    }

    public final void setReturnType(KmType kmType) {
        kmType.getClass();
        this.returnType = kmType;
    }

    public final void setSetterParameter(KmValueParameter kmValueParameter) {
        this.setterParameter = kmValueParameter;
    }
}
