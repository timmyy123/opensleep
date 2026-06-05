package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.metadata.AppFunctionAllOfTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionArrayTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionBooleanTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionBytesTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDeprecationMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDoubleTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionFloatTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionIntTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionLongTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionObjectTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionOneOfTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionParcelableTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionReferenceTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionResponseMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionSchemaMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionStringTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionUnitTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.CompileTimeAppFunctionMetadata;
import androidx.appfunctions.compiler.processors.AppFunctionInventoryProcessor;
import com.squareup.kotlinpoet.ClassName;
import com.squareup.kotlinpoet.ClassNames;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.PropertySpec;
import com.squareup.kotlinpoet.TypeName;
import com.squareup.kotlinpoet.TypeSpec;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\u0002J,\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0002J\u001e\u0010 \u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\tH\u0002J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u0003H\u0002J \u0010%\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0013H\u0002J\u0014\u0010'\u001a\u00020(*\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010)\u001a\u00020**\u00020\u0013H\u0002J \u0010+\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H\u0002J \u0010.\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H\u0002J \u00101\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002J \u00104\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0002J&\u00107\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0002J,\u00109\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J&\u0010;\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0002J \u0010=\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0013H\u0002J\u0018\u0010?\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020AH\u0002J\u001e\u0010B\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001a\u0010C\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u001a\u0010F\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0010\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u0010H\u0002J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010L\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010M\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010N\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010O\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0010\u0010R\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0010\u0010S\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionInventoryCodeBuilder;", "", "inventoryClassBuilder", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "<init>", "(Lcom/squareup/kotlinpoet/TypeSpec$Builder;)V", "addFunctionMetadataProperties", "", "appFunctionMetadataList", "", "Landroidx/appfunctions/compiler/core/metadata/CompileTimeAppFunctionMetadata;", "addPropertyForAppFunctionMetadata", "functionMetadataObjectClassBuilder", "functionMetadata", "addPropertyForComponentsDataTypes", "propertyName", "", "dataTypes", "", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "addPropertyForResponseMetadata", "appFunctionResponseMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadata;", "addPropertyForParcelableTypeMetadata", "parcelableTypeMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionParcelableTypeMetadata;", "addPropertyForOneOfTypeMetadata", "oneOfTypeMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionOneOfTypeMetadata;", "addPropertyForMatchOneOfList", "matchOneOfListPropertyName", IntrospectionHelper.AppFunctionOneOfTypeAnnotation.PROPERTY_MATCH_ONE_OF, "addPropertiesForParameterMetadataList", "parameterMetadataList", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionParameterMetadata;", "addPropertiesForParameterMetadata", "parameterMetadata", "addPropertyForPrimitiveTypeMetadata", "primitiveTypeMetadata", "toPrimitiveMetadataPropertySpec", "Lcom/squareup/kotlinpoet/PropertySpec;", "toMetadataClassName", "Lcom/squareup/kotlinpoet/ClassName;", "addPropertyForArrayTypeMetadata", "arrayTypeMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionArrayTypeMetadata;", "addPropertyForReferenceTypeMetadata", "referenceTypeMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionReferenceTypeMetadata;", "addPropertyForObjectTypeMetadata", "objectTypeMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionObjectTypeMetadata;", "addPropertyForAllOfTypeMetadata", "allOfTypeMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionAllOfTypeMetadata;", "addPropertyForListOfRequiredObjectProperties", "requiredProperties", "addPropertyForObjectPropertiesMap", "propertiesMap", "addPropertyForMatchAllList", "matchAllList", "addPropertyForDataTypeToMatch", "dataTypeToMatch", "addComponentsMetadataProperty", AppFunctionInventoryProcessor.INVENTORY_COMPONENTS_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/compiler/core/metadata/AppFunctionComponentsMetadata;", "addFunctionIdToMetadataMapProperty", "addSchemaMetadataPropertyForFunction", "schemaMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionSchemaMetadata;", "addDeprecationMetadataPropertyForFunction", "deprecationMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadata;", "getFunctionMetadataObjectClassName", AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG, "getPrimitiveTypeMetadataPropertyNameForParameter", "getArrayTypeMetadataPropertyNameForParameter", "getObjectTypeMetadataPropertyNameForParameter", "getReferenceTypeMetadataPropertyNameForParameter", "getParcelableTypeMetadataPropertyNameForParameter", "getObjectTypeMetadataPropertyNameForComponent", "componentName", "getAllOfTypeMetadataPropertyNameForComponent", "getOneOfTypeMetadataPropertyNameForComponent", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionInventoryCodeBuilder {
    private final TypeSpec.Builder inventoryClassBuilder;

    public AppFunctionInventoryCodeBuilder(TypeSpec.Builder builder) {
        builder.getClass();
        this.inventoryClassBuilder = builder;
    }

    private final void addComponentsMetadataProperty(TypeSpec.Builder inventoryClassBuilder, AppFunctionComponentsMetadata componentsMetadata) throws ProcessingException {
        addPropertyForComponentsDataTypes("componentsMetadataDataTypesMap", inventoryClassBuilder, componentsMetadata.getDataTypes());
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(AppFunctionInventoryProcessor.INVENTORY_COMPONENTS_METADATA_PROPERTY_NAME, introspectionHelper.getAPP_FUNCTION_COMPONENTS_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.OVERRIDE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    dataTypes = %L\n)", introspectionHelper.getAPP_FUNCTION_COMPONENTS_METADATA_CLASS(), "componentsMetadataDataTypesMap");
        Unit unit = Unit.INSTANCE;
        inventoryClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addDeprecationMetadataPropertyForFunction(TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionDeprecationMetadata deprecationMetadata) {
        if (deprecationMetadata == null) {
            return;
        }
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(AppFunctionInventoryProcessor.DEPRECATION_METADATA_PROPERTY_NAME, TypeName.copy$default(introspectionHelper.getAPP_FUNCTION_DEPRECATION_METADATA_CLASS(), true, null, 2, null), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(message= %S)", introspectionHelper.getAPP_FUNCTION_DEPRECATION_METADATA_CLASS(), deprecationMetadata.getMessage());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addFunctionIdToMetadataMapProperty(TypeSpec.Builder inventoryClassBuilder, List<CompileTimeAppFunctionMetadata> appFunctionMetadataList) {
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(AppFunctionInventoryProcessor.FUNCTION_ID_TO_METADATA_MAP_PROPERTY_NAME, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(Map.class)), ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(String.class)), IntrospectionHelper.INSTANCE.getAPP_FUNCTION_METADATA_CLASS()), new KModifier[0]).addModifiers(KModifier.OVERRIDE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("mapOf(", new Object[0]);
        builder.indent();
        for (CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata : appFunctionMetadataList) {
            builder.addStatement("%S to %L.%L,", compileTimeAppFunctionMetadata.getId(), getFunctionMetadataObjectClassName(compileTimeAppFunctionMetadata.getId()), AppFunctionInventoryProcessor.APP_FUNCTION_METADATA_PROPERTY_NAME);
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
        Unit unit = Unit.INSTANCE;
        inventoryClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertiesForParameterMetadata(AppFunctionParameterMetadata parameterMetadata, TypeSpec.Builder functionMetadataObjectClassBuilder) throws ProcessingException {
        String primitiveTypeMetadataPropertyNameForParameter;
        String upperCase = parameterMetadata.getName().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        String str = upperCase + "_PARAMETER_METADATA";
        AppFunctionDataTypeMetadata dataType = parameterMetadata.getDataType();
        if ((dataType instanceof AppFunctionIntTypeMetadata) || (dataType instanceof AppFunctionLongTypeMetadata) || (dataType instanceof AppFunctionStringTypeMetadata) || (dataType instanceof AppFunctionBooleanTypeMetadata) || (dataType instanceof AppFunctionBytesTypeMetadata) || (dataType instanceof AppFunctionDoubleTypeMetadata) || (dataType instanceof AppFunctionFloatTypeMetadata) || (dataType instanceof AppFunctionUnitTypeMetadata)) {
            primitiveTypeMetadataPropertyNameForParameter = getPrimitiveTypeMetadataPropertyNameForParameter(parameterMetadata);
            addPropertyForPrimitiveTypeMetadata(primitiveTypeMetadataPropertyNameForParameter, functionMetadataObjectClassBuilder, dataType);
        } else if (dataType instanceof AppFunctionArrayTypeMetadata) {
            primitiveTypeMetadataPropertyNameForParameter = getArrayTypeMetadataPropertyNameForParameter(parameterMetadata);
            addPropertyForArrayTypeMetadata(primitiveTypeMetadataPropertyNameForParameter, functionMetadataObjectClassBuilder, (AppFunctionArrayTypeMetadata) dataType);
        } else if (dataType instanceof AppFunctionObjectTypeMetadata) {
            primitiveTypeMetadataPropertyNameForParameter = getObjectTypeMetadataPropertyNameForParameter(parameterMetadata);
            addPropertyForObjectTypeMetadata(primitiveTypeMetadataPropertyNameForParameter, functionMetadataObjectClassBuilder, (AppFunctionObjectTypeMetadata) dataType);
        } else if (dataType instanceof AppFunctionReferenceTypeMetadata) {
            primitiveTypeMetadataPropertyNameForParameter = getReferenceTypeMetadataPropertyNameForParameter(parameterMetadata);
            addPropertyForReferenceTypeMetadata(primitiveTypeMetadataPropertyNameForParameter, functionMetadataObjectClassBuilder, (AppFunctionReferenceTypeMetadata) dataType);
        } else if (!(dataType instanceof AppFunctionParcelableTypeMetadata)) {
            AppFunctionInventoryCodeBuilder$$ExternalSyntheticBUOutline0.m("Unable to build parameter metadata for unknown datatype: ", dataType);
            return;
        } else {
            primitiveTypeMetadataPropertyNameForParameter = getParcelableTypeMetadataPropertyNameForParameter(parameterMetadata);
            addPropertyForParcelableTypeMetadata(primitiveTypeMetadataPropertyNameForParameter, functionMetadataObjectClassBuilder, (AppFunctionParcelableTypeMetadata) dataType);
        }
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(str, introspectionHelper.getAPP_FUNCTION_PARAMETER_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    name = %S,\n    isRequired = %L,\n    dataType = %L,\n    description = %S,\n)", introspectionHelper.getAPP_FUNCTION_PARAMETER_METADATA_CLASS(), parameterMetadata.getName(), Boolean.valueOf(parameterMetadata.isRequired()), primitiveTypeMetadataPropertyNameForParameter, parameterMetadata.getDescription());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertiesForParameterMetadataList(TypeSpec.Builder functionMetadataObjectClassBuilder, List<AppFunctionParameterMetadata> parameterMetadataList) throws ProcessingException {
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(AppFunctionInventoryProcessor.PARAMETER_METADATA_LIST_PROPERTY_NAME, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(List.class)), IntrospectionHelper.INSTANCE.getAPP_FUNCTION_PARAMETER_METADATA_CLASS()), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("listOf(", new Object[0]);
        builder.indent();
        for (AppFunctionParameterMetadata appFunctionParameterMetadata : parameterMetadataList) {
            addPropertiesForParameterMetadata(appFunctionParameterMetadata, functionMetadataObjectClassBuilder);
            String upperCase = appFunctionParameterMetadata.getName().toUpperCase(Locale.ROOT);
            upperCase.getClass();
            builder.addStatement("%L,", upperCase + "_PARAMETER_METADATA");
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForAllOfTypeMetadata(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionAllOfTypeMetadata allOfTypeMetadata) throws ProcessingException {
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(propertyName, "_MATCH_ALL_LIST");
        addPropertyForMatchAllList(strM$1, functionMetadataObjectClassBuilder, allOfTypeMetadata.getMatchAll());
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(propertyName, introspectionHelper.getAPP_FUNCTION_ALL_OF_TYPE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    matchAll = %L,\n    qualifiedName = %S,\n    isNullable = %L,\n    description = %S\n)", introspectionHelper.getAPP_FUNCTION_ALL_OF_TYPE_METADATA_CLASS(), strM$1, allOfTypeMetadata.getQualifiedName(), Boolean.valueOf(allOfTypeMetadata.isNullable()), allOfTypeMetadata.getDescription());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForAppFunctionMetadata(TypeSpec.Builder functionMetadataObjectClassBuilder, CompileTimeAppFunctionMetadata functionMetadata) {
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(AppFunctionInventoryProcessor.APP_FUNCTION_METADATA_PROPERTY_NAME, introspectionHelper.getAPP_FUNCTION_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PUBLIC);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.indent();
        builder.add("%T(\n", introspectionHelper.getAPP_FUNCTION_METADATA_CLASS());
        builder.indent();
        builder.add("id = %S,\n", functionMetadata.getId());
        builder.add("isEnabledByDefault = %L,\n", Boolean.valueOf(functionMetadata.isEnabledByDefault()));
        builder.add("schema =  %L,\n", AppFunctionInventoryProcessor.SCHEMA_METADATA_PROPERTY_NAME);
        builder.add("parameters = %L,\n", AppFunctionInventoryProcessor.PARAMETER_METADATA_LIST_PROPERTY_NAME);
        builder.add("response = %L,\n", AppFunctionInventoryProcessor.RESPONSE_METADATA_PROPERTY_NAME);
        if (functionMetadata.getDeprecation() != null) {
            builder.add("deprecation = %L,\n", AppFunctionInventoryProcessor.DEPRECATION_METADATA_PROPERTY_NAME);
        }
        builder.unindent();
        builder.unindent();
        builder.add(")", new Object[0]);
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForArrayTypeMetadata(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionArrayTypeMetadata arrayTypeMetadata) throws ProcessingException {
        String strM$1;
        AppFunctionDataTypeMetadata itemType = arrayTypeMetadata.getItemType();
        if ((itemType instanceof AppFunctionIntTypeMetadata) || (itemType instanceof AppFunctionLongTypeMetadata) || (itemType instanceof AppFunctionStringTypeMetadata) || (itemType instanceof AppFunctionBooleanTypeMetadata) || (itemType instanceof AppFunctionBytesTypeMetadata) || (itemType instanceof AppFunctionDoubleTypeMetadata) || (itemType instanceof AppFunctionFloatTypeMetadata) || (itemType instanceof AppFunctionUnitTypeMetadata)) {
            strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(propertyName, "_PRIMITIVE_ITEM_TYPE");
            addPropertyForPrimitiveTypeMetadata(strM$1, functionMetadataObjectClassBuilder, itemType);
        } else if (itemType instanceof AppFunctionObjectTypeMetadata) {
            strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(propertyName, "_OBJECT_ITEM_TYPE");
            addPropertyForObjectTypeMetadata(strM$1, functionMetadataObjectClassBuilder, (AppFunctionObjectTypeMetadata) itemType);
        } else if (itemType instanceof AppFunctionReferenceTypeMetadata) {
            strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(propertyName, "_REFERENCE_ITEM_TYPE");
            addPropertyForReferenceTypeMetadata(strM$1, functionMetadataObjectClassBuilder, (AppFunctionReferenceTypeMetadata) itemType);
        } else if (!(itemType instanceof AppFunctionParcelableTypeMetadata)) {
            AppFunctionInventoryCodeBuilder$$ExternalSyntheticBUOutline0.m("Unable to build parameter item type metadata for unknown itemType: ", itemType);
            return;
        } else {
            strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(propertyName, "_PARCELABLE_ITEM_TYPE");
            addPropertyForParcelableTypeMetadata(strM$1, functionMetadataObjectClassBuilder, (AppFunctionParcelableTypeMetadata) itemType);
        }
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(propertyName, introspectionHelper.getAPP_FUNCTION_ARRAY_TYPE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    itemType = %L,\n    isNullable = %L,\n    description = %S\n)", introspectionHelper.getAPP_FUNCTION_ARRAY_TYPE_METADATA_CLASS(), strM$1, Boolean.valueOf(arrayTypeMetadata.isNullable()), arrayTypeMetadata.getDescription());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForComponentsDataTypes(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, Map<String, ? extends AppFunctionDataTypeMetadata> dataTypes) throws ProcessingException {
        String oneOfTypeMetadataPropertyNameForComponent;
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(propertyName, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(Map.class)), ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(String.class)), IntrospectionHelper.INSTANCE.getAPP_FUNCTION_DATA_TYPE_METADATA()), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("mapOf(", new Object[0]);
        builder.indent();
        for (Map.Entry entry : CollectionsKt.sortedWith(dataTypes.entrySet(), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionInventoryCodeBuilder$addPropertyForComponentsDataTypes$lambda$0$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Map.Entry) t).getKey(), (String) ((Map.Entry) t2).getKey());
            }
        })) {
            String str = (String) entry.getKey();
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = (AppFunctionDataTypeMetadata) entry.getValue();
            if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
                oneOfTypeMetadataPropertyNameForComponent = getObjectTypeMetadataPropertyNameForComponent(str);
                addPropertyForObjectTypeMetadata(oneOfTypeMetadataPropertyNameForComponent, functionMetadataObjectClassBuilder, (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata);
            } else if (appFunctionDataTypeMetadata instanceof AppFunctionAllOfTypeMetadata) {
                oneOfTypeMetadataPropertyNameForComponent = getAllOfTypeMetadataPropertyNameForComponent(str);
                addPropertyForAllOfTypeMetadata(oneOfTypeMetadataPropertyNameForComponent, functionMetadataObjectClassBuilder, (AppFunctionAllOfTypeMetadata) appFunctionDataTypeMetadata);
            } else if (!(appFunctionDataTypeMetadata instanceof AppFunctionOneOfTypeMetadata)) {
                AppFunctionInventoryCodeBuilder$$ExternalSyntheticBUOutline0.m("Component types contains unsupported datatype: ", appFunctionDataTypeMetadata);
                return;
            } else {
                oneOfTypeMetadataPropertyNameForComponent = getOneOfTypeMetadataPropertyNameForComponent(str);
                addPropertyForOneOfTypeMetadata(oneOfTypeMetadataPropertyNameForComponent, functionMetadataObjectClassBuilder, (AppFunctionOneOfTypeMetadata) appFunctionDataTypeMetadata);
            }
            builder.addStatement("%S to %L,", str, oneOfTypeMetadataPropertyNameForComponent);
        }
        builder.addStatement(")", new Object[0]);
        builder.unindent();
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForDataTypeToMatch(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionDataTypeMetadata dataTypeToMatch) throws ProcessingException {
        if (dataTypeToMatch instanceof AppFunctionReferenceTypeMetadata) {
            addPropertyForReferenceTypeMetadata(propertyName, functionMetadataObjectClassBuilder, (AppFunctionReferenceTypeMetadata) dataTypeToMatch);
        } else if (dataTypeToMatch instanceof AppFunctionObjectTypeMetadata) {
            addPropertyForObjectTypeMetadata(propertyName, functionMetadataObjectClassBuilder, (AppFunctionObjectTypeMetadata) dataTypeToMatch);
        } else {
            AppFunctionInventoryCodeBuilder$$ExternalSyntheticBUOutline0.m("Invalid datatype metadata to match in allOf type. Only object and reference types are supported: ", dataTypeToMatch);
        }
    }

    private final void addPropertyForListOfRequiredObjectProperties(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, List<String> requiredProperties) {
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(propertyName, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(List.class)), ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(String.class))), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("listOf(", new Object[0]);
        builder.indent();
        Iterator<String> it = requiredProperties.iterator();
        while (it.hasNext()) {
            builder.addStatement("%S,", it.next());
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForMatchAllList(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, List<? extends AppFunctionDataTypeMetadata> matchAllList) throws ProcessingException {
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(propertyName, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(List.class)), IntrospectionHelper.INSTANCE.getAPP_FUNCTION_DATA_TYPE_METADATA()), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("listOf(", new Object[0]);
        builder.indent();
        Iterator<T> it = matchAllList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            String str = propertyName + "_ITEM_" + i;
            addPropertyForDataTypeToMatch(str, functionMetadataObjectClassBuilder, (AppFunctionDataTypeMetadata) it.next());
            builder.addStatement("%L,", str);
            i = i2;
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForMatchOneOfList(String matchOneOfListPropertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, List<? extends AppFunctionDataTypeMetadata> matchOneOf) throws ProcessingException {
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(matchOneOfListPropertyName, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(List.class)), IntrospectionHelper.INSTANCE.getAPP_FUNCTION_DATA_TYPE_METADATA()), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("listOf(", new Object[0]);
        builder.indent();
        Iterator<T> it = matchOneOf.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            String str = matchOneOfListPropertyName + "_ITEM_" + i;
            addPropertyForDataTypeToMatch(str, functionMetadataObjectClassBuilder, (AppFunctionDataTypeMetadata) it.next());
            builder.addStatement("%L,", str);
            i = i2;
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForObjectPropertiesMap(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, Map<String, ? extends AppFunctionDataTypeMetadata> propertiesMap) throws ProcessingException {
        PropertySpec.Builder builderAddModifiers = PropertySpec.INSTANCE.builder(propertyName, ParameterizedTypeName.INSTANCE.get(ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(Map.class)), ClassNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(String.class)), IntrospectionHelper.INSTANCE.getAPP_FUNCTION_DATA_TYPE_METADATA()), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("mapOf(", new Object[0]);
        builder.indent();
        for (Map.Entry entry : CollectionsKt.sortedWith(propertiesMap.entrySet(), new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionInventoryCodeBuilder$addPropertyForObjectPropertiesMap$lambda$0$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Map.Entry) t).getKey(), (String) ((Map.Entry) t2).getKey());
            }
        })) {
            String str = (String) entry.getKey();
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = (AppFunctionDataTypeMetadata) entry.getValue();
            String upperCase = str.toUpperCase(Locale.ROOT);
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(upperCase, propertyName, "_", upperCase);
            if ((appFunctionDataTypeMetadata instanceof AppFunctionIntTypeMetadata) || (appFunctionDataTypeMetadata instanceof AppFunctionLongTypeMetadata) || (appFunctionDataTypeMetadata instanceof AppFunctionStringTypeMetadata) || (appFunctionDataTypeMetadata instanceof AppFunctionBooleanTypeMetadata) || (appFunctionDataTypeMetadata instanceof AppFunctionBytesTypeMetadata) || (appFunctionDataTypeMetadata instanceof AppFunctionDoubleTypeMetadata) || (appFunctionDataTypeMetadata instanceof AppFunctionFloatTypeMetadata) || (appFunctionDataTypeMetadata instanceof AppFunctionUnitTypeMetadata)) {
                addPropertyForPrimitiveTypeMetadata(strM$1, functionMetadataObjectClassBuilder, appFunctionDataTypeMetadata);
            } else if (appFunctionDataTypeMetadata instanceof AppFunctionArrayTypeMetadata) {
                addPropertyForArrayTypeMetadata(strM$1, functionMetadataObjectClassBuilder, (AppFunctionArrayTypeMetadata) appFunctionDataTypeMetadata);
            } else if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
                addPropertyForObjectTypeMetadata(strM$1, functionMetadataObjectClassBuilder, (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata);
            } else if (appFunctionDataTypeMetadata instanceof AppFunctionReferenceTypeMetadata) {
                addPropertyForReferenceTypeMetadata(strM$1, functionMetadataObjectClassBuilder, (AppFunctionReferenceTypeMetadata) appFunctionDataTypeMetadata);
            } else {
                if (!(appFunctionDataTypeMetadata instanceof AppFunctionParcelableTypeMetadata)) {
                    AppFunctionInventoryCodeBuilder$$ExternalSyntheticBUOutline0.m("Unable to build metadata for unknown object property datatype: ", appFunctionDataTypeMetadata);
                    return;
                }
                addPropertyForParcelableTypeMetadata(strM$1, functionMetadataObjectClassBuilder, (AppFunctionParcelableTypeMetadata) appFunctionDataTypeMetadata);
            }
            builder.addStatement("%S to %L,", str, strM$1);
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForObjectTypeMetadata(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionObjectTypeMetadata objectTypeMetadata) throws ProcessingException {
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(propertyName, "_PROPERTIES_MAP");
        addPropertyForObjectPropertiesMap(strM$1, functionMetadataObjectClassBuilder, objectTypeMetadata.getProperties());
        String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(propertyName, "_REQUIRED_PROPERTIES_LIST");
        addPropertyForListOfRequiredObjectProperties(strM$12, functionMetadataObjectClassBuilder, objectTypeMetadata.getRequired());
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(propertyName, introspectionHelper.getAPP_FUNCTION_OBJECT_TYPE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    properties = %L,\n    required = %L,\n    qualifiedName = %S,\n    isNullable = %L,\n    description = %S\n)", introspectionHelper.getAPP_FUNCTION_OBJECT_TYPE_METADATA_CLASS(), strM$1, strM$12, objectTypeMetadata.getQualifiedName(), Boolean.valueOf(objectTypeMetadata.isNullable()), objectTypeMetadata.getDescription());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForOneOfTypeMetadata(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionOneOfTypeMetadata oneOfTypeMetadata) throws ProcessingException {
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(propertyName, "_MATCH_ONE_OF_LIST");
        addPropertyForMatchOneOfList(strM$1, functionMetadataObjectClassBuilder, oneOfTypeMetadata.getMatchOneOf());
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(propertyName, introspectionHelper.getAPP_FUNCTION_ONE_OF_TYPE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    matchOneOf = %L,\n    qualifiedName = %S,\n    isNullable = %L,\n    description = %S\n)", introspectionHelper.getAPP_FUNCTION_ONE_OF_TYPE_METADATA_CLASS(), strM$1, oneOfTypeMetadata.getQualifiedName(), Boolean.valueOf(oneOfTypeMetadata.isNullable()), oneOfTypeMetadata.getDescription());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForParcelableTypeMetadata(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionParcelableTypeMetadata parcelableTypeMetadata) {
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(propertyName, introspectionHelper.getAPP_FUNCTION_PARCELABLE_TYPE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    qualifiedName = %S,\n    isNullable = %L,\n    description = %S\n)", introspectionHelper.getAPP_FUNCTION_PARCELABLE_TYPE_METADATA_CLASS(), parcelableTypeMetadata.getQualifiedName(), Boolean.valueOf(parcelableTypeMetadata.isNullable()), parcelableTypeMetadata.getDescription());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForPrimitiveTypeMetadata(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionDataTypeMetadata primitiveTypeMetadata) {
        functionMetadataObjectClassBuilder.addProperty(toPrimitiveMetadataPropertySpec(primitiveTypeMetadata, propertyName));
    }

    private final void addPropertyForReferenceTypeMetadata(String propertyName, TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionReferenceTypeMetadata referenceTypeMetadata) {
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(propertyName, introspectionHelper.getAPP_FUNCTION_REFERENCE_TYPE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    referenceDataType = %S,\n    isNullable = %L,\n    description = %S\n)", introspectionHelper.getAPP_FUNCTION_REFERENCE_TYPE_METADATA_CLASS(), referenceTypeMetadata.getReferenceDataType(), Boolean.valueOf(referenceTypeMetadata.isNullable()), referenceTypeMetadata.getDescription());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addPropertyForResponseMetadata(TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionResponseMetadata appFunctionResponseMetadata) throws ProcessingException {
        String str;
        AppFunctionDataTypeMetadata valueType = appFunctionResponseMetadata.getValueType();
        if ((valueType instanceof AppFunctionIntTypeMetadata) || (valueType instanceof AppFunctionLongTypeMetadata) || (valueType instanceof AppFunctionStringTypeMetadata) || (valueType instanceof AppFunctionBooleanTypeMetadata) || (valueType instanceof AppFunctionBytesTypeMetadata) || (valueType instanceof AppFunctionDoubleTypeMetadata) || (valueType instanceof AppFunctionFloatTypeMetadata) || (valueType instanceof AppFunctionUnitTypeMetadata)) {
            str = "PRIMITIVE_RESPONSE_VALUE_TYPE";
            addPropertyForPrimitiveTypeMetadata("PRIMITIVE_RESPONSE_VALUE_TYPE", functionMetadataObjectClassBuilder, valueType);
        } else if (valueType instanceof AppFunctionArrayTypeMetadata) {
            str = "ARRAY_RESPONSE_VALUE_TYPE";
            addPropertyForArrayTypeMetadata("ARRAY_RESPONSE_VALUE_TYPE", functionMetadataObjectClassBuilder, (AppFunctionArrayTypeMetadata) valueType);
        } else if (valueType instanceof AppFunctionObjectTypeMetadata) {
            str = "OBJECT_RESPONSE_VALUE_TYPE";
            addPropertyForObjectTypeMetadata("OBJECT_RESPONSE_VALUE_TYPE", functionMetadataObjectClassBuilder, (AppFunctionObjectTypeMetadata) valueType);
        } else if (valueType instanceof AppFunctionReferenceTypeMetadata) {
            str = "REFERENCE_RESPONSE_VALUE_TYPE";
            addPropertyForReferenceTypeMetadata("REFERENCE_RESPONSE_VALUE_TYPE", functionMetadataObjectClassBuilder, (AppFunctionReferenceTypeMetadata) valueType);
        } else if (valueType instanceof AppFunctionOneOfTypeMetadata) {
            str = "ONE_OF_RESPONSE_VALUE_TYPE";
            addPropertyForOneOfTypeMetadata("ONE_OF_RESPONSE_VALUE_TYPE", functionMetadataObjectClassBuilder, (AppFunctionOneOfTypeMetadata) valueType);
        } else if (!(valueType instanceof AppFunctionParcelableTypeMetadata)) {
            AppFunctionInventoryCodeBuilder$$ExternalSyntheticBUOutline0.m("Unable to build parameter metadata for unknown datatype: ", valueType);
            return;
        } else {
            str = "PARCELABLE_RESPONSE_VALUE_TYPE";
            addPropertyForParcelableTypeMetadata("PARCELABLE_RESPONSE_VALUE_TYPE", functionMetadataObjectClassBuilder, (AppFunctionParcelableTypeMetadata) valueType);
        }
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(AppFunctionInventoryProcessor.RESPONSE_METADATA_PROPERTY_NAME, introspectionHelper.getAPP_FUNCTION_RESPONSE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("%T(\n    valueType = %L,\n    description = %S\n)", introspectionHelper.getAPP_FUNCTION_RESPONSE_METADATA_CLASS(), str, appFunctionResponseMetadata.getDescription());
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final void addSchemaMetadataPropertyForFunction(TypeSpec.Builder functionMetadataObjectClassBuilder, AppFunctionSchemaMetadata schemaMetadata) {
        PropertySpec.Companion companion = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers = companion.builder(AppFunctionInventoryProcessor.SCHEMA_METADATA_PROPERTY_NAME, TypeName.copy$default(introspectionHelper.getAPP_FUNCTION_SCHEMA_METADATA_CLASS(), true, null, 2, null), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        if (schemaMetadata == null) {
            builder.addStatement("%L", null);
        } else {
            builder.addStatement("%T(category= %S, name=%S, version=%L)", introspectionHelper.getAPP_FUNCTION_SCHEMA_METADATA_CLASS(), schemaMetadata.getCategory(), schemaMetadata.getName(), Long.valueOf(schemaMetadata.getVersion()));
        }
        Unit unit = Unit.INSTANCE;
        functionMetadataObjectClassBuilder.addProperty(builderAddModifiers.initializer(builder.build()).build());
    }

    private final String getAllOfTypeMetadataPropertyNameForComponent(String componentName) {
        String upperCase = componentName.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return FileInsert$$ExternalSyntheticOutline0.m$1(new Regex("[.<>$]").replace(upperCase, "_"), "_ALL_OF_DATA_TYPE");
    }

    private final String getArrayTypeMetadataPropertyNameForParameter(AppFunctionParameterMetadata parameterMetadata) {
        String upperCase = parameterMetadata.getName().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return "PARAMETER_METADATA_" + upperCase + "_ARRAY_DATA_TYPE";
    }

    private final String getFunctionMetadataObjectClassName(String functionId) {
        return FileInsert$$ExternalSyntheticOutline0.m$1(CollectionsKt.joinToString$default(StringsKt.split$default(new Regex("[^A-Za-z0-9]").replace(functionId, "_"), new String[]{"_"}, 0, 6), "", null, null, new StringUtilsKt$$ExternalSyntheticLambda0(6), 30), "MetadataObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getFunctionMetadataObjectClassName$lambda$0(String str) {
        str.getClass();
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strValueOf = String.valueOf(str.charAt(0));
        strValueOf.getClass();
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        sb.append((Object) upperCase);
        sb.append(str.substring(1));
        return sb.toString();
    }

    private final String getObjectTypeMetadataPropertyNameForComponent(String componentName) {
        String upperCase = componentName.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return FileInsert$$ExternalSyntheticOutline0.m$1(StringsKt.replace$default(new Regex("[.<>$]").replace(upperCase, "_"), "?", "_NULLABLE"), "_OBJECT_DATA_TYPE");
    }

    private final String getObjectTypeMetadataPropertyNameForParameter(AppFunctionParameterMetadata parameterMetadata) {
        String upperCase = parameterMetadata.getName().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return "PARAMETER_METADATA_" + upperCase + "_OBJECT_DATA_TYPE";
    }

    private final String getOneOfTypeMetadataPropertyNameForComponent(String componentName) {
        String upperCase = componentName.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return FileInsert$$ExternalSyntheticOutline0.m$1(new Regex("[.<>$]").replace(upperCase, "_"), "_ONE_OF_DATA_TYPE");
    }

    private final String getParcelableTypeMetadataPropertyNameForParameter(AppFunctionParameterMetadata parameterMetadata) {
        String upperCase = parameterMetadata.getName().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return "PARAMETER_METADATA_" + upperCase + "_PARCELABLE_DATA_TYPE";
    }

    private final String getPrimitiveTypeMetadataPropertyNameForParameter(AppFunctionParameterMetadata parameterMetadata) {
        String upperCase = parameterMetadata.getName().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return "PARAMETER_METADATA_" + upperCase + "_PRIMITIVE_DATA_TYPE";
    }

    private final String getReferenceTypeMetadataPropertyNameForParameter(AppFunctionParameterMetadata parameterMetadata) {
        String upperCase = parameterMetadata.getName().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return "PARAMETER_METADATA_" + upperCase + "_REFERENCE_DATA_TYPE";
    }

    private final ClassName toMetadataClassName(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata) {
        if (appFunctionDataTypeMetadata instanceof AppFunctionIntTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_INT_TYPE_METADATA_CLASS();
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionBooleanTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_BOOLEAN_TYPE_METADATA_CLASS();
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionBytesTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_BYTES_TYPE_METADATA_CLASS();
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionDoubleTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_DOUBLE_TYPE_METADATA_CLASS();
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionFloatTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_FLOAT_TYPE_METADATA_CLASS();
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionLongTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_LONG_TYPE_METADATA_CLASS();
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionStringTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_STRING_TYPE_METADATA_CLASS();
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionUnitTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_UNIT_TYPE_METADATA_CLASS();
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionParcelableTypeMetadata) {
            return IntrospectionHelper.INSTANCE.getAPP_FUNCTION_PARCELABLE_TYPE_METADATA_CLASS();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Unsupported or non-primitive type in AppFunctionDataTypeMetadata: ", Reflection.getOrCreateKotlinClass(appFunctionDataTypeMetadata.getClass()).getSimpleName()));
        return null;
    }

    private final PropertySpec toPrimitiveMetadataPropertySpec(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str) {
        if (appFunctionDataTypeMetadata instanceof AppFunctionIntTypeMetadata) {
            PropertySpec.Companion companion = PropertySpec.INSTANCE;
            IntrospectionHelper introspectionHelper = IntrospectionHelper.INSTANCE;
            PropertySpec.Builder builderAddModifiers = companion.builder(str, introspectionHelper.getAPP_FUNCTION_INT_TYPE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
            CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
            ClassName app_function_int_type_metadata_class = introspectionHelper.getAPP_FUNCTION_INT_TYPE_METADATA_CLASS();
            AppFunctionIntTypeMetadata appFunctionIntTypeMetadata = (AppFunctionIntTypeMetadata) appFunctionDataTypeMetadata;
            Boolean boolValueOf = Boolean.valueOf(appFunctionIntTypeMetadata.isNullable());
            String description = appFunctionIntTypeMetadata.getDescription();
            Set<Integer> enumValues = appFunctionIntTypeMetadata.getEnumValues();
            builder.addStatement("%T(\n    isNullable = %L,\n    description = %S,\n    enumValues = %L,\n)", app_function_int_type_metadata_class, boolValueOf, description, enumValues != null ? CollectionsKt.joinToString$default(enumValues, null, "setOf(", ")", null, 57) : null);
            return builderAddModifiers.initializer(builder.build()).build();
        }
        if (!(appFunctionDataTypeMetadata instanceof AppFunctionStringTypeMetadata)) {
            PropertySpec.Builder builderAddModifiers2 = PropertySpec.INSTANCE.builder(str, toMetadataClassName(appFunctionDataTypeMetadata), new KModifier[0]).addModifiers(KModifier.PRIVATE);
            CodeBlock.Builder builder2 = CodeBlock.INSTANCE.builder();
            builder2.addStatement("%T(\n    isNullable = %L,\n    description = %S\n)", toMetadataClassName(appFunctionDataTypeMetadata), Boolean.valueOf(appFunctionDataTypeMetadata.isNullable()), appFunctionDataTypeMetadata.getDescription());
            return builderAddModifiers2.initializer(builder2.build()).build();
        }
        PropertySpec.Companion companion2 = PropertySpec.INSTANCE;
        IntrospectionHelper introspectionHelper2 = IntrospectionHelper.INSTANCE;
        PropertySpec.Builder builderAddModifiers3 = companion2.builder(str, introspectionHelper2.getAPP_FUNCTION_STRING_TYPE_METADATA_CLASS(), new KModifier[0]).addModifiers(KModifier.PRIVATE);
        CodeBlock.Builder builder3 = CodeBlock.INSTANCE.builder();
        ClassName app_function_string_type_metadata_class = introspectionHelper2.getAPP_FUNCTION_STRING_TYPE_METADATA_CLASS();
        AppFunctionStringTypeMetadata appFunctionStringTypeMetadata = (AppFunctionStringTypeMetadata) appFunctionDataTypeMetadata;
        Boolean boolValueOf2 = Boolean.valueOf(appFunctionStringTypeMetadata.isNullable());
        String description2 = appFunctionStringTypeMetadata.getDescription();
        Set<String> enumValues2 = appFunctionStringTypeMetadata.getEnumValues();
        builder3.addStatement("%T(\n    isNullable = %L,\n    description = %S,\n    enumValues = %L,\n)", app_function_string_type_metadata_class, boolValueOf2, description2, enumValues2 != null ? CollectionsKt.joinToString$default(enumValues2, null, "setOf(", ")", new StringUtilsKt$$ExternalSyntheticLambda0(5), 25) : null);
        return builderAddModifiers3.initializer(builder3.build()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toPrimitiveMetadataPropertySpec$lambda$1$0(String str) {
        str.getClass();
        return "\"" + str + "\"";
    }

    public final void addFunctionMetadataProperties(List<CompileTimeAppFunctionMetadata> appFunctionMetadataList) throws ProcessingException {
        appFunctionMetadataList.getClass();
        for (CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata : appFunctionMetadataList) {
            TypeSpec.Builder builderAddModifiers = TypeSpec.INSTANCE.objectBuilder(getFunctionMetadataObjectClassName(compileTimeAppFunctionMetadata.getId())).addModifiers(KModifier.PRIVATE);
            addSchemaMetadataPropertyForFunction(builderAddModifiers, compileTimeAppFunctionMetadata.getSchema());
            addPropertiesForParameterMetadataList(builderAddModifiers, compileTimeAppFunctionMetadata.getParameters());
            addPropertyForResponseMetadata(builderAddModifiers, compileTimeAppFunctionMetadata.getResponse());
            addDeprecationMetadataPropertyForFunction(builderAddModifiers, compileTimeAppFunctionMetadata.getDeprecation());
            addPropertyForAppFunctionMetadata(builderAddModifiers, compileTimeAppFunctionMetadata);
            this.inventoryClassBuilder.addType(builderAddModifiers.build());
        }
        addFunctionIdToMetadataMapProperty(this.inventoryClassBuilder, appFunctionMetadataList);
        TypeSpec.Builder builder = this.inventoryClassBuilder;
        List<CompileTimeAppFunctionMetadata> list = appFunctionMetadataList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((CompileTimeAppFunctionMetadata) it.next()).getComponents().getDataTypes());
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            Utf8$$ExternalSyntheticBUOutline0.m("Empty collection can't be reduced.");
            return;
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            next = MapsKt.plus((Map) next, (Map) it2.next());
        }
        addComponentsMetadataProperty(builder, new AppFunctionComponentsMetadata((Map) next));
    }
}
