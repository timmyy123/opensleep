package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.AppFunctionCompiler;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.processors.AppFunctionSerializableFactoryCodeBuilderHelper;
import com.google.devtools.ksp.symbol.Modifier;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.TypeSpec;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/appfunctions/compiler/core/OneOfAppFunctionSerializableFactoryCodeBuilder;", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "oneOfClass", "Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable;", "<init>", "(Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable;)V", "generateFromAppFunctionDataMethodBody", "Lcom/squareup/kotlinpoet/CodeBlock;", "addFactoryInitStatement", "", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "serializable", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "generateToAppFunctionDataMethodBody", "buildAppFunctionSerializableFactoryClass", "Lcom/squareup/kotlinpoet/FileSpec;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OneOfAppFunctionSerializableFactoryCodeBuilder implements AppFunctionSerializableType.FactoryCodeBuilder {
    private final AnnotatedOneOfAppFunctionSerializable oneOfClass;

    public OneOfAppFunctionSerializableFactoryCodeBuilder(AnnotatedOneOfAppFunctionSerializable annotatedOneOfAppFunctionSerializable) {
        annotatedOneOfAppFunctionSerializable.getClass();
        this.oneOfClass = annotatedOneOfAppFunctionSerializable;
    }

    private final void addFactoryInitStatement(CodeBlock.Builder builder, AppFunctionSerializableType appFunctionSerializableType) {
        builder.addStatement("val %L = %T()", appFunctionSerializableType.getFactoryVariableName(), appFunctionSerializableType.getFactoryClassName());
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType.FactoryCodeBuilder
    public FileSpec buildAppFunctionSerializableFactoryClass() {
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.INSTANCE.get(IntrospectionHelper.AppFunctionSerializableFactoryClass.INSTANCE.getCLASS_NAME(), CollectionsKt.listOf(this.oneOfClass.getAppFunctionSerializableTypeClassDeclaration().getTypeName()));
        String simpleName = this.oneOfClass.getFactoryClassName().getSimpleName();
        FileSpec.Builder builder = FileSpec.INSTANCE.builder(this.oneOfClass.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName().getPackageName(), simpleName);
        TypeSpec.Builder builderAddSuperinterface$default = TypeSpec.Builder.addSuperinterface$default(TypeSpec.INSTANCE.classBuilder(simpleName).addAnnotation(IntrospectionHelper.INSTANCE.getRESTRICT_API_TO_33_ANNOTATION()).addAnnotation(AppFunctionCompiler.INSTANCE.getGENERATED_ANNOTATION$appfunctions_compiler()), parameterizedTypeName, null, 2, null);
        if (this.oneOfClass.getAppFunctionSerializableTypeClassDeclaration().getModifiers().contains(Modifier.INTERNAL)) {
            builderAddSuperinterface$default.addModifiers(KModifier.INTERNAL);
        }
        AppFunctionSerializableFactoryCodeBuilderHelper.Companion companion = AppFunctionSerializableFactoryCodeBuilderHelper.INSTANCE;
        return builder.addType(builderAddSuperinterface$default.addFunction(companion.buildFromAppFunctionDataFunction(generateFromAppFunctionDataMethodBody(), this.oneOfClass.getAppFunctionSerializableTypeClassDeclaration().getTypeName())).addFunction(companion.buildToAppFunctionDataFunction(generateToAppFunctionDataMethodBody(), this.oneOfClass.getAppFunctionSerializableTypeClassDeclaration().getTypeName())).build()).build();
    }

    public final CodeBlock generateFromAppFunctionDataMethodBody() {
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.beginControlFlow("return when(%L.%L)", "appFunctionData", IntrospectionHelper.AppFunctionDataClass.INSTANCE.getAPP_FUNCTION_DATA_QUALIFIED_NAME_PROPERTY());
        for (AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable : this.oneOfClass.getOneOfSerializables()) {
            builder.beginControlFlow("%T::class.java.name -> ", annotatedAppFunctionSerializable.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName());
            addFactoryInitStatement(builder, annotatedAppFunctionSerializable);
            builder.addNamed("%factory_variable_name:L.%from_app_function_data_method:L(%app_function_data_variable:L)", MapsKt.mapOf(TuplesKt.to("factory_variable_name", annotatedAppFunctionSerializable.getFactoryVariableName()), TuplesKt.to("from_app_function_data_method", IntrospectionHelper.AppFunctionSerializableFactoryClass.FromAppFunctionDataMethod.METHOD_NAME), TuplesKt.to("app_function_data_variable", "appFunctionData")));
            builder.endControlFlow();
        }
        builder.addStatement("else -> throw %T(%P)", Reflection.getOrCreateKotlinClass(IllegalArgumentException.class), "Unknown qualifiedName: ${appFunctionData.qualifiedName}");
        builder.endControlFlow();
        return builder.build();
    }

    public final CodeBlock generateToAppFunctionDataMethodBody() {
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.beginControlFlow("return when(%L)", IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME);
        for (AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable : this.oneOfClass.getOneOfSerializables()) {
            builder.beginControlFlow("is %T -> ", annotatedAppFunctionSerializable.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName());
            addFactoryInitStatement(builder, annotatedAppFunctionSerializable);
            builder.addNamed("%factory_variable_name:L.%to_app_function_data_method:L(%serializable_variable_name:L)", MapsKt.mapOf(TuplesKt.to("factory_variable_name", annotatedAppFunctionSerializable.getFactoryVariableName()), TuplesKt.to("to_app_function_data_method", IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.METHOD_NAME), TuplesKt.to("serializable_variable_name", IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME)));
            builder.endControlFlow();
        }
        if (!this.oneOfClass.supportsExhaustiveWhen()) {
            builder.addStatement("else -> throw %T(%P)", Reflection.getOrCreateKotlinClass(IllegalArgumentException.class), "Unknown class type for OneOfType: ${appFunctionSerializable::class.java}");
        }
        builder.endControlFlow();
        return builder.build();
    }
}
