package kotlin.reflect.jvm.internal.impl.km.internal;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmConstantValue;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmContract;
import kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.km.KmEffect;
import kotlin.reflect.jvm.internal.impl.km.KmEffectExpression;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmLambda;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmTypeProjection;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.KmVersion;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ReadersKt {

    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[ProtoBuf$TypeParameter.Variance.values().length];
            try {
                iArr[ProtoBuf$TypeParameter.Variance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$TypeParameter.Variance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$TypeParameter.Variance.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ProtoBuf$Type.Argument.Projection.values().length];
            try {
                iArr2[ProtoBuf$Type.Argument.Projection.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProtoBuf$Type.Argument.Projection.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProtoBuf$Type.Argument.Projection.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ProtoBuf$Type.Argument.Projection.STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ProtoBuf$VersionRequirement.VersionKind.values().length];
            try {
                iArr3[ProtoBuf$VersionRequirement.VersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ProtoBuf$VersionRequirement.VersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ProtoBuf$VersionRequirement.VersionKind.API_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[DeprecationLevel.values().length];
            try {
                iArr4[DeprecationLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[DeprecationLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[DeprecationLevel.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[ProtoBuf$Effect.EffectType.values().length];
            try {
                iArr5[ProtoBuf$Effect.EffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[ProtoBuf$Effect.EffectType.CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[ProtoBuf$Effect.EffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[ProtoBuf$Effect.InvocationKind.values().length];
            try {
                iArr6[ProtoBuf$Effect.InvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr6[ProtoBuf$Effect.InvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr6[ProtoBuf$Effect.InvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[ProtoBuf$Expression.ConstantValue.values().length];
            try {
                iArr7[ProtoBuf$Expression.ConstantValue.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr7[ProtoBuf$Expression.ConstantValue.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr7[ProtoBuf$Expression.ConstantValue.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            $EnumSwitchMapping$6 = iArr7;
        }
    }

    public static final int getDefaultPropertyAccessorFlags(int i) {
        Boolean bool = Flags.HAS_ANNOTATIONS.get(i);
        bool.getClass();
        return Flags.getAccessorFlags(bool.booleanValue(), Flags.VISIBILITY.get(i), Flags.MODALITY.get(i), false, false, false);
    }

    public static final int getPropertyGetterFlags(ProtoBuf$Property protoBuf$Property) {
        protoBuf$Property.getClass();
        return protoBuf$Property.hasGetterFlags() ? protoBuf$Property.getGetterFlags() : getDefaultPropertyAccessorFlags(protoBuf$Property.getFlags());
    }

    public static final int getPropertySetterFlags(ProtoBuf$Property protoBuf$Property) {
        protoBuf$Property.getClass();
        return protoBuf$Property.hasSetterFlags() ? protoBuf$Property.getSetterFlags() : getDefaultPropertyAccessorFlags(protoBuf$Property.getFlags());
    }

    private static final int getTypeFlags(ProtoBuf$Type protoBuf$Type) {
        boolean nullable = protoBuf$Type.getNullable();
        return (nullable ? 1 : 0) + (protoBuf$Type.getFlags() << 1);
    }

    private static final int getTypeParameterFlags(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
        return protoBuf$TypeParameter.getReified() ? 1 : 0;
    }

    private static final KmValueParameter legacyCtxReceiverToParameter(KmType kmType) {
        KmValueParameter kmValueParameter = new KmValueParameter(0, "_");
        kmValueParameter.setType(kmType);
        return kmValueParameter;
    }

    private static final ProtoBuf$Type loadInlineClassUnderlyingType(ProtoBuf$Class protoBuf$Class, ReadContext readContext) {
        ProtoBuf$Type protoBuf$TypeInlineClassUnderlyingType = ProtoTypeTableUtilKt.inlineClassUnderlyingType(protoBuf$Class, readContext.getTypes());
        if (protoBuf$TypeInlineClassUnderlyingType != null) {
            return protoBuf$TypeInlineClassUnderlyingType;
        }
        if (!protoBuf$Class.hasInlineClassUnderlyingPropertyName()) {
            return null;
        }
        List<ProtoBuf$Property> propertyList = protoBuf$Class.getPropertyList();
        propertyList.getClass();
        Iterator<T> it = propertyList.iterator();
        boolean z = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
            } else {
                Object next = it.next();
                ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) next;
                protoBuf$Property.getClass();
                if (ProtoTypeTableUtilKt.receiverType(protoBuf$Property, readContext.getTypes()) == null && Intrinsics.areEqual(readContext.get(protoBuf$Property.getName()), readContext.get(protoBuf$Class.getInlineClassUnderlyingPropertyName()))) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj = next;
                }
            }
        }
        obj = null;
        ProtoBuf$Property protoBuf$Property2 = (ProtoBuf$Property) obj;
        if (protoBuf$Property2 != null) {
            return ProtoTypeTableUtilKt.returnType(protoBuf$Property2, readContext.getTypes());
        }
        return null;
    }

    private static final KmVersionRequirement readVersionRequirement(int i, ReadContext readContext) {
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind;
        KmVersionRequirementLevel kmVersionRequirementLevel;
        VersionRequirement.Version version;
        KmVersionRequirement kmVersionRequirement = new KmVersionRequirement();
        VersionRequirement versionRequirementCreate = VersionRequirement.Companion.create(i, readContext.getStrings(), readContext.getVersionRequirements$kotlin_metadata());
        if (versionRequirementCreate == null && !readContext.getIgnoreUnknownVersionRequirements$kotlin_metadata()) {
            throw new InconsistentKotlinMetadataException("No VersionRequirement with the given id in the table", null, 2, null);
        }
        ProtoBuf$VersionRequirement.VersionKind kind = versionRequirementCreate != null ? versionRequirementCreate.getKind() : null;
        int i2 = kind == null ? -1 : WhenMappings.$EnumSwitchMapping$2[kind.ordinal()];
        if (i2 == -1) {
            kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.UNKNOWN;
        } else if (i2 == 1) {
            kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.LANGUAGE_VERSION;
        } else if (i2 == 2) {
            kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.COMPILER_VERSION;
        } else {
            if (i2 != 3) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.API_VERSION;
        }
        DeprecationLevel level = versionRequirementCreate != null ? versionRequirementCreate.getLevel() : null;
        int i3 = level == null ? -1 : WhenMappings.$EnumSwitchMapping$3[level.ordinal()];
        if (i3 == -1) {
            kmVersionRequirementLevel = KmVersionRequirementLevel.HIDDEN;
        } else if (i3 == 1) {
            kmVersionRequirementLevel = KmVersionRequirementLevel.WARNING;
        } else if (i3 != 2) {
            if (i3 != 3) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            kmVersionRequirementLevel = KmVersionRequirementLevel.HIDDEN;
        } else {
            kmVersionRequirementLevel = KmVersionRequirementLevel.ERROR;
        }
        kmVersionRequirement.setKind(kmVersionRequirementVersionKind);
        kmVersionRequirement.setLevel(kmVersionRequirementLevel);
        kmVersionRequirement.setErrorCode(versionRequirementCreate != null ? versionRequirementCreate.getErrorCode() : null);
        kmVersionRequirement.setMessage(versionRequirementCreate != null ? versionRequirementCreate.getMessage() : null);
        if (versionRequirementCreate == null || (version = versionRequirementCreate.getVersion()) == null) {
            version = VersionRequirement.Version.INFINITY;
        }
        kmVersionRequirement.setVersion(new KmVersion(version.component1(), version.component2(), version.component3()));
        return kmVersionRequirement;
    }

    public static final KmClass toKmClass(ProtoBuf$Class protoBuf$Class, NameResolver nameResolver, boolean z, List<? extends Object> list) {
        protoBuf$Class.getClass();
        nameResolver.getClass();
        list.getClass();
        KmClass kmClass = new KmClass();
        ProtoBuf$TypeTable typeTable = protoBuf$Class.getTypeTable();
        typeTable.getClass();
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf$VersionRequirementTable versionRequirementTable = protoBuf$Class.getVersionRequirementTable();
        versionRequirementTable.getClass();
        ReadContext readContext = new ReadContext(nameResolver, typeTable2, companion.create(versionRequirementTable), z, null, list, 16, null);
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Class.getTypeParameterList();
        typeParameterList.getClass();
        ReadContext readContextWithTypeParameters$kotlin_metadata = readContext.withTypeParameters$kotlin_metadata(typeParameterList);
        kmClass.setFlags$kotlin_metadata(protoBuf$Class.getFlags());
        kmClass.setName(readContextWithTypeParameters$kotlin_metadata.className$kotlin_metadata(protoBuf$Class.getFqName()));
        List<ProtoBuf$TypeParameter> typeParameterList2 = protoBuf$Class.getTypeParameterList();
        typeParameterList2.getClass();
        List<KmTypeParameter> typeParameters = kmClass.getTypeParameters();
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : typeParameterList2) {
            protoBuf$TypeParameter.getClass();
            typeParameters.add(toKmTypeParameter(protoBuf$TypeParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        List<ProtoBuf$Type> listSupertypes = ProtoTypeTableUtilKt.supertypes(protoBuf$Class, readContextWithTypeParameters$kotlin_metadata.getTypes());
        List<KmType> supertypes = kmClass.getSupertypes();
        Iterator<T> it = listSupertypes.iterator();
        while (it.hasNext()) {
            supertypes.add(toKmType((ProtoBuf$Type) it.next(), readContextWithTypeParameters$kotlin_metadata));
        }
        List<ProtoBuf$Constructor> constructorList = protoBuf$Class.getConstructorList();
        constructorList.getClass();
        List<KmConstructor> constructors = kmClass.getConstructors();
        for (ProtoBuf$Constructor protoBuf$Constructor : constructorList) {
            protoBuf$Constructor.getClass();
            constructors.add(toKmConstructor(protoBuf$Constructor, readContextWithTypeParameters$kotlin_metadata));
        }
        List<ProtoBuf$Function> functionList = protoBuf$Class.getFunctionList();
        functionList.getClass();
        List<ProtoBuf$Property> propertyList = protoBuf$Class.getPropertyList();
        propertyList.getClass();
        List<ProtoBuf$TypeAlias> typeAliasList = protoBuf$Class.getTypeAliasList();
        typeAliasList.getClass();
        visitDeclarations(kmClass, functionList, propertyList, typeAliasList, readContextWithTypeParameters$kotlin_metadata);
        if (protoBuf$Class.hasCompanionObjectName()) {
            kmClass.setCompanionObject(readContextWithTypeParameters$kotlin_metadata.get(protoBuf$Class.getCompanionObjectName()));
        }
        List<Integer> nestedClassNameList = protoBuf$Class.getNestedClassNameList();
        nestedClassNameList.getClass();
        List<String> nestedClasses = kmClass.getNestedClasses();
        for (Integer num : nestedClassNameList) {
            num.getClass();
            nestedClasses.add(readContextWithTypeParameters$kotlin_metadata.get(num.intValue()));
        }
        Iterator<ProtoBuf$EnumEntry> it2 = protoBuf$Class.getEnumEntryList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                List<Integer> sealedSubclassFqNameList = protoBuf$Class.getSealedSubclassFqNameList();
                sealedSubclassFqNameList.getClass();
                List<String> sealedSubclasses = kmClass.getSealedSubclasses();
                for (Integer num2 : sealedSubclassFqNameList) {
                    num2.getClass();
                    sealedSubclasses.add(readContextWithTypeParameters$kotlin_metadata.className$kotlin_metadata(num2.intValue()));
                }
                if (protoBuf$Class.hasInlineClassUnderlyingPropertyName()) {
                    kmClass.setInlineClassUnderlyingPropertyName(readContextWithTypeParameters$kotlin_metadata.get(protoBuf$Class.getInlineClassUnderlyingPropertyName()));
                }
                ProtoBuf$Type protoBuf$TypeLoadInlineClassUnderlyingType = loadInlineClassUnderlyingType(protoBuf$Class, readContextWithTypeParameters$kotlin_metadata);
                kmClass.setInlineClassUnderlyingType(protoBuf$TypeLoadInlineClassUnderlyingType != null ? toKmType(protoBuf$TypeLoadInlineClassUnderlyingType, readContextWithTypeParameters$kotlin_metadata) : null);
                List<ProtoBuf$Type> listContextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(protoBuf$Class, readContextWithTypeParameters$kotlin_metadata.getTypes());
                List<KmType> contextReceiverTypes = kmClass.getContextReceiverTypes();
                Iterator<T> it3 = listContextReceiverTypes.iterator();
                while (it3.hasNext()) {
                    contextReceiverTypes.add(toKmType((ProtoBuf$Type) it3.next(), readContextWithTypeParameters$kotlin_metadata));
                }
                List<Integer> versionRequirementList = protoBuf$Class.getVersionRequirementList();
                versionRequirementList.getClass();
                List<KmVersionRequirement> versionRequirements = kmClass.getVersionRequirements();
                for (Integer num3 : versionRequirementList) {
                    num3.getClass();
                    versionRequirements.add(readVersionRequirement(num3.intValue(), readContextWithTypeParameters$kotlin_metadata));
                }
                List<ProtoBuf$CompilerPluginData> compilerPluginDataList = protoBuf$Class.getCompilerPluginDataList();
                compilerPluginDataList.getClass();
                Map<String, byte[]> compilerPluginMetadata = kmClass.getCompilerPluginMetadata();
                for (ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData : compilerPluginDataList) {
                    compilerPluginMetadata.put(readContextWithTypeParameters$kotlin_metadata.get(protoBuf$CompilerPluginData.getPluginId()), protoBuf$CompilerPluginData.getData().toByteArray());
                }
                Iterator<T> it4 = readContextWithTypeParameters$kotlin_metadata.getExtensions$kotlin_metadata().iterator();
                while (it4.hasNext()) {
                    ((MetadataExtensions) it4.next()).readClassExtensions(kmClass, protoBuf$Class, readContextWithTypeParameters$kotlin_metadata);
                }
                return kmClass;
            }
            ProtoBuf$EnumEntry next = it2.next();
            if (!next.hasName()) {
                throw new InconsistentKotlinMetadataException("No name for EnumEntry", null, 2, null);
            }
            kmClass.getEnumEntries().add(readContextWithTypeParameters$kotlin_metadata.get(next.getName()));
            kmClass.getKmEnumEntries().add(toKmEnumEntry(next, readContextWithTypeParameters$kotlin_metadata));
        }
    }

    public static /* synthetic */ KmClass toKmClass$default(ProtoBuf$Class protoBuf$Class, NameResolver nameResolver, boolean z, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return toKmClass(protoBuf$Class, nameResolver, z, list);
    }

    private static final KmConstructor toKmConstructor(ProtoBuf$Constructor protoBuf$Constructor, ReadContext readContext) {
        KmConstructor kmConstructor = new KmConstructor(protoBuf$Constructor.getFlags());
        List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Constructor.getValueParameterList();
        valueParameterList.getClass();
        List<KmValueParameter> valueParameters = kmConstructor.getValueParameters();
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter : valueParameterList) {
            protoBuf$ValueParameter.getClass();
            valueParameters.add(toKmValueParameter(protoBuf$ValueParameter, readContext));
        }
        List<Integer> versionRequirementList = protoBuf$Constructor.getVersionRequirementList();
        versionRequirementList.getClass();
        List<KmVersionRequirement> versionRequirements = kmConstructor.getVersionRequirements();
        for (Integer num : versionRequirementList) {
            num.getClass();
            versionRequirements.add(readVersionRequirement(num.intValue(), readContext));
        }
        List<ProtoBuf$CompilerPluginData> compilerPluginDataList = protoBuf$Constructor.getCompilerPluginDataList();
        compilerPluginDataList.getClass();
        Map<String, byte[]> compilerPluginMetadata = kmConstructor.getCompilerPluginMetadata();
        for (ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData : compilerPluginDataList) {
            compilerPluginMetadata.put(readContext.get(protoBuf$CompilerPluginData.getPluginId()), protoBuf$CompilerPluginData.getData().toByteArray());
        }
        Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((MetadataExtensions) it.next()).readConstructorExtensions(kmConstructor, protoBuf$Constructor, readContext);
        }
        return kmConstructor;
    }

    private static final KmContract toKmContract(ProtoBuf$Contract protoBuf$Contract, ReadContext readContext) {
        KmEffectType kmEffectType;
        KmContract kmContract = new KmContract();
        for (ProtoBuf$Effect protoBuf$Effect : protoBuf$Contract.getEffectList()) {
            if (protoBuf$Effect.hasEffectType()) {
                ProtoBuf$Effect.EffectType effectType = protoBuf$Effect.getEffectType();
                KmEffectInvocationKind kmEffectInvocationKind = null;
                if (effectType == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Required value was null.");
                    return null;
                }
                int i = WhenMappings.$EnumSwitchMapping$4[effectType.ordinal()];
                if (i == 1) {
                    kmEffectType = KmEffectType.RETURNS_CONSTANT;
                } else if (i == 2) {
                    kmEffectType = KmEffectType.CALLS;
                } else {
                    if (i != 3) {
                        Home$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                    kmEffectType = KmEffectType.RETURNS_NOT_NULL;
                }
                if (protoBuf$Effect.hasKind()) {
                    ProtoBuf$Effect.InvocationKind kind = protoBuf$Effect.getKind();
                    if (kind == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2("Required value was null.");
                        return null;
                    }
                    int i2 = WhenMappings.$EnumSwitchMapping$5[kind.ordinal()];
                    if (i2 == 1) {
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_MOST_ONCE;
                    } else if (i2 == 2) {
                        kmEffectInvocationKind = KmEffectInvocationKind.EXACTLY_ONCE;
                    } else {
                        if (i2 != 3) {
                            Home$$ExternalSyntheticBUOutline0.m();
                            return null;
                        }
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_LEAST_ONCE;
                    }
                }
                kmContract.getEffects().add(toKmEffect(protoBuf$Effect, kmEffectType, kmEffectInvocationKind, readContext));
            }
        }
        return kmContract;
    }

    private static final KmEffect toKmEffect(ProtoBuf$Effect protoBuf$Effect, KmEffectType kmEffectType, KmEffectInvocationKind kmEffectInvocationKind, ReadContext readContext) {
        KmEffect kmEffect = new KmEffect(kmEffectType, kmEffectInvocationKind);
        List<ProtoBuf$Expression> effectConstructorArgumentList = protoBuf$Effect.getEffectConstructorArgumentList();
        effectConstructorArgumentList.getClass();
        List<KmEffectExpression> constructorArguments = kmEffect.getConstructorArguments();
        for (ProtoBuf$Expression protoBuf$Expression : effectConstructorArgumentList) {
            protoBuf$Expression.getClass();
            constructorArguments.add(toKmEffectExpression(protoBuf$Expression, readContext));
        }
        if (protoBuf$Effect.hasConclusionOfConditionalEffect()) {
            ProtoBuf$Expression conclusionOfConditionalEffect = protoBuf$Effect.getConclusionOfConditionalEffect();
            conclusionOfConditionalEffect.getClass();
            kmEffect.setConclusion(toKmEffectExpression(conclusionOfConditionalEffect, readContext));
        }
        return kmEffect;
    }

    private static final KmEffectExpression toKmEffectExpression(ProtoBuf$Expression protoBuf$Expression, ReadContext readContext) {
        Boolean bool;
        KmEffectExpression kmEffectExpression = new KmEffectExpression();
        kmEffectExpression.setFlags$kotlin_metadata(protoBuf$Expression.getFlags());
        kmEffectExpression.setParameterIndex(protoBuf$Expression.hasValueParameterReference() ? Integer.valueOf(protoBuf$Expression.getValueParameterReference()) : null);
        if (protoBuf$Expression.hasConstantValue()) {
            ProtoBuf$Expression.ConstantValue constantValue = protoBuf$Expression.getConstantValue();
            if (constantValue == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Required value was null.");
                return null;
            }
            int i = WhenMappings.$EnumSwitchMapping$6[constantValue.ordinal()];
            if (i == 1) {
                bool = Boolean.TRUE;
            } else if (i == 2) {
                bool = Boolean.FALSE;
            } else {
                if (i != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                bool = null;
            }
            kmEffectExpression.setConstantValue(new KmConstantValue(bool));
        }
        ProtoBuf$Type protoBuf$TypeIsInstanceType = ProtoTypeTableUtilKt.isInstanceType(protoBuf$Expression, readContext.getTypes());
        kmEffectExpression.setInstanceType(protoBuf$TypeIsInstanceType != null ? toKmType(protoBuf$TypeIsInstanceType, readContext) : null);
        List<ProtoBuf$Expression> andArgumentList = protoBuf$Expression.getAndArgumentList();
        andArgumentList.getClass();
        List<KmEffectExpression> andArguments = kmEffectExpression.getAndArguments();
        for (ProtoBuf$Expression protoBuf$Expression2 : andArgumentList) {
            protoBuf$Expression2.getClass();
            andArguments.add(toKmEffectExpression(protoBuf$Expression2, readContext));
        }
        List<ProtoBuf$Expression> orArgumentList = protoBuf$Expression.getOrArgumentList();
        orArgumentList.getClass();
        List<KmEffectExpression> orArguments = kmEffectExpression.getOrArguments();
        for (ProtoBuf$Expression protoBuf$Expression3 : orArgumentList) {
            protoBuf$Expression3.getClass();
            orArguments.add(toKmEffectExpression(protoBuf$Expression3, readContext));
        }
        return kmEffectExpression;
    }

    private static final KmEnumEntry toKmEnumEntry(ProtoBuf$EnumEntry protoBuf$EnumEntry, ReadContext readContext) {
        KmEnumEntry kmEnumEntry = new KmEnumEntry(readContext.get(protoBuf$EnumEntry.getName()));
        Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((MetadataExtensions) it.next()).readEnumEntryExtensions(kmEnumEntry, protoBuf$EnumEntry, readContext);
        }
        return kmEnumEntry;
    }

    private static final KmFunction toKmFunction(ProtoBuf$Function protoBuf$Function, ReadContext readContext) {
        KmFunction kmFunction = new KmFunction(protoBuf$Function.getFlags(), readContext.get(protoBuf$Function.getName()));
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Function.getTypeParameterList();
        typeParameterList.getClass();
        ReadContext readContextWithTypeParameters$kotlin_metadata = readContext.withTypeParameters$kotlin_metadata(typeParameterList);
        List<ProtoBuf$TypeParameter> typeParameterList2 = protoBuf$Function.getTypeParameterList();
        typeParameterList2.getClass();
        List<KmTypeParameter> typeParameters = kmFunction.getTypeParameters();
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : typeParameterList2) {
            protoBuf$TypeParameter.getClass();
            typeParameters.add(toKmTypeParameter(protoBuf$TypeParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        ProtoBuf$Type protoBuf$TypeReceiverType = ProtoTypeTableUtilKt.receiverType(protoBuf$Function, readContextWithTypeParameters$kotlin_metadata.getTypes());
        kmFunction.setReceiverParameterType(protoBuf$TypeReceiverType != null ? toKmType(protoBuf$TypeReceiverType, readContextWithTypeParameters$kotlin_metadata) : null);
        List<ProtoBuf$ValueParameter> contextParameterList = protoBuf$Function.getContextParameterList();
        contextParameterList.getClass();
        List<KmValueParameter> contextParameters = kmFunction.getContextParameters();
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter : contextParameterList) {
            protoBuf$ValueParameter.getClass();
            contextParameters.add(toKmValueParameter(protoBuf$ValueParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        if (protoBuf$Function.getContextParameterList().isEmpty()) {
            List<ProtoBuf$Type> contextReceiverTypeList = protoBuf$Function.getContextReceiverTypeList();
            contextReceiverTypeList.getClass();
            if (!contextReceiverTypeList.isEmpty()) {
                List<ProtoBuf$Type> listContextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(protoBuf$Function, readContextWithTypeParameters$kotlin_metadata.getTypes());
                List<KmValueParameter> contextParameters2 = kmFunction.getContextParameters();
                Iterator<T> it = listContextReceiverTypes.iterator();
                while (it.hasNext()) {
                    contextParameters2.add(legacyCtxReceiverToParameter(toKmType((ProtoBuf$Type) it.next(), readContextWithTypeParameters$kotlin_metadata)));
                }
            }
        }
        List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Function.getValueParameterList();
        valueParameterList.getClass();
        List<KmValueParameter> valueParameters = kmFunction.getValueParameters();
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter2 : valueParameterList) {
            protoBuf$ValueParameter2.getClass();
            valueParameters.add(toKmValueParameter(protoBuf$ValueParameter2, readContextWithTypeParameters$kotlin_metadata));
        }
        kmFunction.setReturnType(toKmType(ProtoTypeTableUtilKt.returnType(protoBuf$Function, readContextWithTypeParameters$kotlin_metadata.getTypes()), readContextWithTypeParameters$kotlin_metadata));
        if (protoBuf$Function.hasContract()) {
            ProtoBuf$Contract contract = protoBuf$Function.getContract();
            contract.getClass();
            kmFunction.setContract(toKmContract(contract, readContextWithTypeParameters$kotlin_metadata));
        }
        List<Integer> versionRequirementList = protoBuf$Function.getVersionRequirementList();
        versionRequirementList.getClass();
        List<KmVersionRequirement> versionRequirements = kmFunction.getVersionRequirements();
        for (Integer num : versionRequirementList) {
            num.getClass();
            versionRequirements.add(readVersionRequirement(num.intValue(), readContextWithTypeParameters$kotlin_metadata));
        }
        List<ProtoBuf$CompilerPluginData> compilerPluginDataList = protoBuf$Function.getCompilerPluginDataList();
        compilerPluginDataList.getClass();
        Map<String, byte[]> compilerPluginMetadata = kmFunction.getCompilerPluginMetadata();
        for (ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData : compilerPluginDataList) {
            compilerPluginMetadata.put(readContextWithTypeParameters$kotlin_metadata.get(protoBuf$CompilerPluginData.getPluginId()), protoBuf$CompilerPluginData.getData().toByteArray());
        }
        Iterator<T> it2 = readContextWithTypeParameters$kotlin_metadata.getExtensions$kotlin_metadata().iterator();
        while (it2.hasNext()) {
            ((MetadataExtensions) it2.next()).readFunctionExtensions(kmFunction, protoBuf$Function, readContextWithTypeParameters$kotlin_metadata);
        }
        return kmFunction;
    }

    public static final KmLambda toKmLambda(ProtoBuf$Function protoBuf$Function, NameResolver nameResolver, boolean z) {
        protoBuf$Function.getClass();
        nameResolver.getClass();
        KmLambda kmLambda = new KmLambda();
        ProtoBuf$TypeTable typeTable = protoBuf$Function.getTypeTable();
        typeTable.getClass();
        kmLambda.setFunction(toKmFunction(protoBuf$Function, new ReadContext(nameResolver, new TypeTable(typeTable), VersionRequirementTable.Companion.getEMPTY(), z, null, null, 48, null)));
        return kmLambda;
    }

    public static final KmPackage toKmPackage(ProtoBuf$Package protoBuf$Package, NameResolver nameResolver, boolean z, List<? extends Object> list) {
        protoBuf$Package.getClass();
        nameResolver.getClass();
        list.getClass();
        KmPackage kmPackage = new KmPackage();
        ProtoBuf$TypeTable typeTable = protoBuf$Package.getTypeTable();
        typeTable.getClass();
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf$VersionRequirementTable versionRequirementTable = protoBuf$Package.getVersionRequirementTable();
        versionRequirementTable.getClass();
        ReadContext readContext = new ReadContext(nameResolver, typeTable2, companion.create(versionRequirementTable), z, null, list, 16, null);
        List<ProtoBuf$Function> functionList = protoBuf$Package.getFunctionList();
        functionList.getClass();
        List<ProtoBuf$Property> propertyList = protoBuf$Package.getPropertyList();
        propertyList.getClass();
        List<ProtoBuf$TypeAlias> typeAliasList = protoBuf$Package.getTypeAliasList();
        typeAliasList.getClass();
        visitDeclarations(kmPackage, functionList, propertyList, typeAliasList, readContext);
        Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((MetadataExtensions) it.next()).readPackageExtensions(kmPackage, protoBuf$Package, readContext);
        }
        return kmPackage;
    }

    public static /* synthetic */ KmPackage toKmPackage$default(ProtoBuf$Package protoBuf$Package, NameResolver nameResolver, boolean z, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return toKmPackage(protoBuf$Package, nameResolver, z, list);
    }

    public static final KmProperty toKmProperty(ProtoBuf$Property protoBuf$Property, ReadContext readContext) {
        protoBuf$Property.getClass();
        readContext.getClass();
        KmProperty kmProperty = new KmProperty(protoBuf$Property.getFlags(), readContext.get(protoBuf$Property.getName()), getPropertyGetterFlags(protoBuf$Property), getPropertySetterFlags(protoBuf$Property));
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Property.getTypeParameterList();
        typeParameterList.getClass();
        ReadContext readContextWithTypeParameters$kotlin_metadata = readContext.withTypeParameters$kotlin_metadata(typeParameterList);
        List<ProtoBuf$TypeParameter> typeParameterList2 = protoBuf$Property.getTypeParameterList();
        typeParameterList2.getClass();
        List<KmTypeParameter> typeParameters = kmProperty.getTypeParameters();
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : typeParameterList2) {
            protoBuf$TypeParameter.getClass();
            typeParameters.add(toKmTypeParameter(protoBuf$TypeParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        ProtoBuf$Type protoBuf$TypeReceiverType = ProtoTypeTableUtilKt.receiverType(protoBuf$Property, readContextWithTypeParameters$kotlin_metadata.getTypes());
        kmProperty.setReceiverParameterType(protoBuf$TypeReceiverType != null ? toKmType(protoBuf$TypeReceiverType, readContextWithTypeParameters$kotlin_metadata) : null);
        List<ProtoBuf$ValueParameter> contextParameterList = protoBuf$Property.getContextParameterList();
        contextParameterList.getClass();
        List<KmValueParameter> contextParameters = kmProperty.getContextParameters();
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter : contextParameterList) {
            protoBuf$ValueParameter.getClass();
            contextParameters.add(toKmValueParameter(protoBuf$ValueParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        if (protoBuf$Property.getContextParameterList().isEmpty()) {
            List<ProtoBuf$Type> contextReceiverTypeList = protoBuf$Property.getContextReceiverTypeList();
            contextReceiverTypeList.getClass();
            if (!contextReceiverTypeList.isEmpty()) {
                List<ProtoBuf$Type> listContextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(protoBuf$Property, readContextWithTypeParameters$kotlin_metadata.getTypes());
                List<KmValueParameter> contextParameters2 = kmProperty.getContextParameters();
                Iterator<T> it = listContextReceiverTypes.iterator();
                while (it.hasNext()) {
                    contextParameters2.add(legacyCtxReceiverToParameter(toKmType((ProtoBuf$Type) it.next(), readContextWithTypeParameters$kotlin_metadata)));
                }
            }
        }
        if (protoBuf$Property.hasSetterValueParameter()) {
            ProtoBuf$ValueParameter setterValueParameter = protoBuf$Property.getSetterValueParameter();
            setterValueParameter.getClass();
            kmProperty.setSetterParameter(toKmValueParameter(setterValueParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        kmProperty.setReturnType(toKmType(ProtoTypeTableUtilKt.returnType(protoBuf$Property, readContextWithTypeParameters$kotlin_metadata.getTypes()), readContextWithTypeParameters$kotlin_metadata));
        List<Integer> versionRequirementList = protoBuf$Property.getVersionRequirementList();
        versionRequirementList.getClass();
        List<KmVersionRequirement> versionRequirements = kmProperty.getVersionRequirements();
        for (Integer num : versionRequirementList) {
            num.getClass();
            versionRequirements.add(readVersionRequirement(num.intValue(), readContextWithTypeParameters$kotlin_metadata));
        }
        List<ProtoBuf$CompilerPluginData> compilerPluginDataList = protoBuf$Property.getCompilerPluginDataList();
        compilerPluginDataList.getClass();
        Map<String, byte[]> compilerPluginMetadata = kmProperty.getCompilerPluginMetadata();
        for (ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData : compilerPluginDataList) {
            compilerPluginMetadata.put(readContextWithTypeParameters$kotlin_metadata.get(protoBuf$CompilerPluginData.getPluginId()), protoBuf$CompilerPluginData.getData().toByteArray());
        }
        Iterator<T> it2 = readContextWithTypeParameters$kotlin_metadata.getExtensions$kotlin_metadata().iterator();
        while (it2.hasNext()) {
            ((MetadataExtensions) it2.next()).readPropertyExtensions(kmProperty, protoBuf$Property, readContextWithTypeParameters$kotlin_metadata);
        }
        return kmProperty;
    }

    private static final KmType toKmType(ProtoBuf$Type protoBuf$Type, ReadContext readContext) {
        KmClassifier typeParameter;
        KmType kmType;
        KmVariance kmVariance;
        KmType kmType2 = new KmType(getTypeFlags(protoBuf$Type));
        KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = null;
        kmFlexibleTypeUpperBound = null;
        if (protoBuf$Type.hasClassName()) {
            typeParameter = new KmClassifier.Class(readContext.className$kotlin_metadata(protoBuf$Type.getClassName()));
        } else if (protoBuf$Type.hasTypeAliasName()) {
            typeParameter = new KmClassifier.TypeAlias(readContext.className$kotlin_metadata(protoBuf$Type.getTypeAliasName()));
        } else if (protoBuf$Type.hasTypeParameter()) {
            typeParameter = new KmClassifier.TypeParameter(protoBuf$Type.getTypeParameter());
        } else {
            if (!protoBuf$Type.hasTypeParameterName()) {
                throw new InconsistentKotlinMetadataException("No classifier (class, type alias or type parameter) recorded for Type", null, 2, null);
            }
            Integer typeParameterId$kotlin_metadata = readContext.getTypeParameterId$kotlin_metadata(protoBuf$Type.getTypeParameterName());
            if (typeParameterId$kotlin_metadata == null) {
                throw new InconsistentKotlinMetadataException("No type parameter id for " + readContext.get(protoBuf$Type.getTypeParameterName()), null, 2, null);
            }
            typeParameter = new KmClassifier.TypeParameter(typeParameterId$kotlin_metadata.intValue());
        }
        kmType2.setClassifier(typeParameter);
        for (ProtoBuf$Type.Argument argument : protoBuf$Type.getArgumentList()) {
            ProtoBuf$Type.Argument.Projection projection = argument.getProjection();
            if (projection == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Required value was null.");
                return null;
            }
            int i = WhenMappings.$EnumSwitchMapping$1[projection.ordinal()];
            if (i == 1) {
                kmVariance = KmVariance.IN;
            } else if (i == 2) {
                kmVariance = KmVariance.OUT;
            } else if (i == 3) {
                kmVariance = KmVariance.INVARIANT;
            } else {
                if (i != 4) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                kmVariance = null;
            }
            if (kmVariance != null) {
                ProtoBuf$Type protoBuf$TypeType = ProtoTypeTableUtilKt.type(argument, readContext.getTypes());
                if (protoBuf$TypeType == null) {
                    throw new InconsistentKotlinMetadataException("No type argument for non-STAR projection in Type", null, 2, null);
                }
                kmType2.getArguments().add(new KmTypeProjection(kmVariance, toKmType(protoBuf$TypeType, readContext)));
            } else {
                kmType2.getArguments().add(KmTypeProjection.STAR);
            }
        }
        ProtoBuf$Type protoBuf$TypeAbbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(protoBuf$Type, readContext.getTypes());
        kmType2.setAbbreviatedType(protoBuf$TypeAbbreviatedType != null ? toKmType(protoBuf$TypeAbbreviatedType, readContext) : null);
        ProtoBuf$Type protoBuf$TypeOuterType = ProtoTypeTableUtilKt.outerType(protoBuf$Type, readContext.getTypes());
        kmType2.setOuterType(protoBuf$TypeOuterType != null ? toKmType(protoBuf$TypeOuterType, readContext) : null);
        ProtoBuf$Type protoBuf$TypeFlexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(protoBuf$Type, readContext.getTypes());
        if (protoBuf$TypeFlexibleUpperBound != null && (kmType = toKmType(protoBuf$TypeFlexibleUpperBound, readContext)) != null) {
            kmFlexibleTypeUpperBound = new KmFlexibleTypeUpperBound(kmType, protoBuf$Type.hasFlexibleTypeCapabilitiesId() ? readContext.get(protoBuf$Type.getFlexibleTypeCapabilitiesId()) : null);
        }
        kmType2.setFlexibleTypeUpperBound(kmFlexibleTypeUpperBound);
        Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((MetadataExtensions) it.next()).readTypeExtensions(kmType2, protoBuf$Type, readContext);
        }
        return kmType2;
    }

    private static final KmTypeAlias toKmTypeAlias(ProtoBuf$TypeAlias protoBuf$TypeAlias, ReadContext readContext) {
        KmTypeAlias kmTypeAlias = new KmTypeAlias(protoBuf$TypeAlias.getFlags(), readContext.get(protoBuf$TypeAlias.getName()));
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$TypeAlias.getTypeParameterList();
        typeParameterList.getClass();
        ReadContext readContextWithTypeParameters$kotlin_metadata = readContext.withTypeParameters$kotlin_metadata(typeParameterList);
        List<ProtoBuf$TypeParameter> typeParameterList2 = protoBuf$TypeAlias.getTypeParameterList();
        typeParameterList2.getClass();
        List<KmTypeParameter> typeParameters = kmTypeAlias.getTypeParameters();
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : typeParameterList2) {
            protoBuf$TypeParameter.getClass();
            typeParameters.add(toKmTypeParameter(protoBuf$TypeParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        kmTypeAlias.setUnderlyingType(toKmType(ProtoTypeTableUtilKt.underlyingType(protoBuf$TypeAlias, readContextWithTypeParameters$kotlin_metadata.getTypes()), readContextWithTypeParameters$kotlin_metadata));
        kmTypeAlias.setExpandedType(toKmType(ProtoTypeTableUtilKt.expandedType(protoBuf$TypeAlias, readContextWithTypeParameters$kotlin_metadata.getTypes()), readContextWithTypeParameters$kotlin_metadata));
        List<ProtoBuf$Annotation> annotationList = protoBuf$TypeAlias.getAnnotationList();
        annotationList.getClass();
        List<KmAnnotation> annotations = kmTypeAlias.getAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation : annotationList) {
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContextWithTypeParameters$kotlin_metadata.getStrings()));
        }
        List<Integer> versionRequirementList = protoBuf$TypeAlias.getVersionRequirementList();
        versionRequirementList.getClass();
        List<KmVersionRequirement> versionRequirements = kmTypeAlias.getVersionRequirements();
        for (Integer num : versionRequirementList) {
            num.getClass();
            versionRequirements.add(readVersionRequirement(num.intValue(), readContextWithTypeParameters$kotlin_metadata));
        }
        List<ProtoBuf$CompilerPluginData> compilerPluginDataList = protoBuf$TypeAlias.getCompilerPluginDataList();
        compilerPluginDataList.getClass();
        Map<String, byte[]> compilerPluginMetadata = kmTypeAlias.getCompilerPluginMetadata();
        for (ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData : compilerPluginDataList) {
            compilerPluginMetadata.put(readContextWithTypeParameters$kotlin_metadata.get(protoBuf$CompilerPluginData.getPluginId()), protoBuf$CompilerPluginData.getData().toByteArray());
        }
        Iterator<T> it = readContextWithTypeParameters$kotlin_metadata.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((MetadataExtensions) it.next()).readTypeAliasExtensions(kmTypeAlias, protoBuf$TypeAlias, readContextWithTypeParameters$kotlin_metadata);
        }
        return kmTypeAlias;
    }

    private static final KmTypeParameter toKmTypeParameter(ProtoBuf$TypeParameter protoBuf$TypeParameter, ReadContext readContext) {
        KmVariance kmVariance;
        ProtoBuf$TypeParameter.Variance variance = protoBuf$TypeParameter.getVariance();
        if (variance == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Required value was null.");
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            kmVariance = KmVariance.IN;
        } else if (i == 2) {
            kmVariance = KmVariance.OUT;
        } else {
            if (i != 3) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            kmVariance = KmVariance.INVARIANT;
        }
        KmTypeParameter kmTypeParameter = new KmTypeParameter(getTypeParameterFlags(protoBuf$TypeParameter), readContext.get(protoBuf$TypeParameter.getName()), protoBuf$TypeParameter.getId(), kmVariance);
        List<ProtoBuf$Type> listUpperBounds = ProtoTypeTableUtilKt.upperBounds(protoBuf$TypeParameter, readContext.getTypes());
        List<KmType> upperBounds = kmTypeParameter.getUpperBounds();
        Iterator<T> it = listUpperBounds.iterator();
        while (it.hasNext()) {
            upperBounds.add(toKmType((ProtoBuf$Type) it.next(), readContext));
        }
        Iterator<T> it2 = readContext.getExtensions$kotlin_metadata().iterator();
        while (it2.hasNext()) {
            ((MetadataExtensions) it2.next()).readTypeParameterExtensions(kmTypeParameter, protoBuf$TypeParameter, readContext);
        }
        return kmTypeParameter;
    }

    private static final KmValueParameter toKmValueParameter(ProtoBuf$ValueParameter protoBuf$ValueParameter, ReadContext readContext) {
        KmValueParameter kmValueParameter = new KmValueParameter(protoBuf$ValueParameter.getFlags(), readContext.get(protoBuf$ValueParameter.getName()));
        kmValueParameter.setType(toKmType(ProtoTypeTableUtilKt.type(protoBuf$ValueParameter, readContext.getTypes()), readContext));
        ProtoBuf$Type protoBuf$TypeVarargElementType = ProtoTypeTableUtilKt.varargElementType(protoBuf$ValueParameter, readContext.getTypes());
        kmValueParameter.setVarargElementType(protoBuf$TypeVarargElementType != null ? toKmType(protoBuf$TypeVarargElementType, readContext) : null);
        if (protoBuf$ValueParameter.hasAnnotationParameterDefaultValue()) {
            ProtoBuf$Annotation.Argument.Value annotationParameterDefaultValue = protoBuf$ValueParameter.getAnnotationParameterDefaultValue();
            annotationParameterDefaultValue.getClass();
            kmValueParameter.setAnnotationParameterDefaultValue(ReadUtilsKt.readAnnotationArgument(annotationParameterDefaultValue, readContext.getStrings()));
        }
        Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((MetadataExtensions) it.next()).readValueParameterExtensions(kmValueParameter, protoBuf$ValueParameter, readContext);
        }
        return kmValueParameter;
    }

    private static final void visitDeclarations(KmDeclarationContainer kmDeclarationContainer, List<ProtoBuf$Function> list, List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3, ReadContext readContext) {
        List<KmFunction> functions = kmDeclarationContainer.getFunctions();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            functions.add(toKmFunction((ProtoBuf$Function) it.next(), readContext));
        }
        List<KmProperty> properties = kmDeclarationContainer.getProperties();
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            properties.add(toKmProperty((ProtoBuf$Property) it2.next(), readContext));
        }
        List<KmTypeAlias> typeAliases = kmDeclarationContainer.getTypeAliases();
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            typeAliases.add(toKmTypeAlias((ProtoBuf$TypeAlias) it3.next(), readContext));
        }
    }
}
