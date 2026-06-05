package androidx.appfunctions.compiler.processors;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializable;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AnnotatedParameterizedAppFunctionSerializable;
import androidx.appfunctions.compiler.core.AppFunctionPropertyDeclaration;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import androidx.appfunctions.compiler.core.AppFunctionTypeReference;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.KspUtilsKt;
import androidx.appfunctions.compiler.core.ProcessingException;
import androidx.work.Data$$ExternalSyntheticLambda0;
import com.google.devtools.ksp.symbol.KSTypeParameter;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.squareup.kotlinpoet.ClassName;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.FunSpec;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.ParameterSpec;
import com.squareup.kotlinpoet.TypeName;
import com.squareup.kotlinpoet.TypeSpec;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 J2\u00020\u0001:\u0001JB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\rH\u0002J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010\u001f\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010\"\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010#\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010$\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J,\u0010&\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J*\u0010(\u001a\u00020\u0016*\u00020\u00162\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010.\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010/\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001cH\u0002J\u001c\u00101\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001cH\u0002J\u001c\u00102\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J\u001c\u00103\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J$\u00104\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J$\u00105\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001cH\u0002J\u0010\u00106\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u00107\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u00108\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J\u001c\u0010:\u001a\u00020;*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=H\u0002J\u0014\u0010>\u001a\u00020;*\u00020\u00162\u0006\u00100\u001a\u00020\u001cH\u0002J\u001c\u0010>\u001a\u00020;*\u00020\u00162\u0006\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0002J$\u0010>\u001a\u00020;*\u00020\u00162\u0006\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010%\u001a\u00020*H\u0002J\f\u0010B\u001a\u00020\u0011*\u00020\u001cH\u0002J\f\u0010C\u001a\u00020\u0011*\u00020\u0011H\u0002J\u0010\u0010D\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010F\u001a\u00020G2\u0006\u00100\u001a\u00020!H\u0002J\f\u0010H\u001a\u00020\u0011*\u00020\u001cH\u0002J\f\u0010I\u001a\u00020\u0011*\u00020\u001cH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u00109\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionSerializableFactoryCodeBuilderHelper;", "", "annotatedClass", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "<init>", "(Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;)V", "getAnnotatedClass", "()Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "getResolvedAnnotatedSerializableProxies", "()Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "buildFromAppFunctionDataMethodBody", "Lcom/squareup/kotlinpoet/CodeBlock;", "buildFromAppFunctionDataMethodBodyForProxy", "appendFromAppFunctionDataMethodBodyCommon", "getterResultName", "", "buildToAppFunctionDataMethodBody", "buildToAppFunctionDataMethodBodyForProxy", "appendToAppFunctionDataMethodBodyCommon", "appendGenericGetterStatement", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "paramName", "paramTypeParameter", "Lcom/google/devtools/ksp/symbol/KSTypeParameter;", "appendGetterStatement", "paramType", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "isRequired", "", "appendPrimitiveGetterStatement", "afType", "Landroidx/appfunctions/compiler/core/AppFunctionTypeReference;", "appendParcelableGetterStatement", "appendParcelableListGetterStatement", "appendSerializableGetterStatement", "factoryName", "appendSerializableListGetterStatement", "parametrizedItemType", "appendGetterResultConstructorCallStatement", "originalClassName", "Lcom/squareup/kotlinpoet/ClassName;", "properties", "", "Landroidx/appfunctions/compiler/core/AppFunctionPropertyDeclaration;", "appendGenericSetterStatement", "appendNullableSetterStatement", "typeReference", "appendSetterStatement", "appendPrimitiveSetterStatement", "appendParcelableSetterStatement", "appendSerializableSetterStatement", "appendSerializableListSetterStatement", "getAppFunctionDataGetterName", "getGetterDefaultValueStatement", "getAppFunctionDataSetterName", "factoryInitStatements", "addParameterizedFactoryInitStatement", "", "annotatedSerializable", "Landroidx/appfunctions/compiler/core/AnnotatedParameterizedAppFunctionSerializable;", "appendTypeParameterInstanceCreation", "typeParameterClassName", "typeName", "Lcom/squareup/kotlinpoet/TypeName;", "getTypeShortName", "lowerFirstChar", "getResultParamName", "getSerializableParamName", "getAnnotatedSerializable", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;", "getFactoryVariableName", "getVariableName", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSerializableFactoryCodeBuilderHelper {
    public static final String APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME = "appFunctionDataWithSpec";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AppFunctionSerializableType annotatedClass;
    private final CodeBlock factoryInitStatements;
    private final AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionSerializableFactoryCodeBuilderHelper$Companion;", "", "<init>", "()V", "APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME", "", "setGenericPrimaryConstructor", "", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "typeParameters", "", "Lcom/google/devtools/ksp/symbol/KSTypeParameter;", "buildFromAppFunctionDataFunction", "Lcom/squareup/kotlinpoet/FunSpec;", "functionBody", "Lcom/squareup/kotlinpoet/CodeBlock;", "returnType", "Lcom/squareup/kotlinpoet/TypeName;", "buildToAppFunctionDataFunction", "parameterType", "getTypeParameterPropertyName", "typeParameter", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FunSpec buildFromAppFunctionDataFunction(CodeBlock functionBody, TypeName returnType) {
            functionBody.getClass();
            returnType.getClass();
            return FunSpec.Builder.returns$default(FunSpec.INSTANCE.builder(IntrospectionHelper.AppFunctionSerializableFactoryClass.FromAppFunctionDataMethod.METHOD_NAME).addModifiers(KModifier.OVERRIDE).addParameter(ParameterSpec.INSTANCE.builder("appFunctionData", IntrospectionHelper.AppFunctionDataClass.INSTANCE.getCLASS_NAME(), new KModifier[0]).build()).addCode(functionBody), returnType, null, 2, null).build();
        }

        public final FunSpec buildToAppFunctionDataFunction(CodeBlock functionBody, TypeName parameterType) {
            functionBody.getClass();
            parameterType.getClass();
            return FunSpec.Builder.returns$default(FunSpec.INSTANCE.builder(IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.METHOD_NAME).addModifiers(KModifier.OVERRIDE).addParameter(ParameterSpec.INSTANCE.builder(IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME, parameterType, new KModifier[0]).build()).addCode(functionBody), IntrospectionHelper.AppFunctionDataClass.INSTANCE.getCLASS_NAME(), null, 2, null).build();
        }

        public final String getTypeParameterPropertyName(KSTypeParameter typeParameter) {
            typeParameter.getClass();
            typeParameter.getName();
            throw null;
        }

        public final void setGenericPrimaryConstructor(TypeSpec.Builder builder, List<? extends KSTypeParameter> list) {
            builder.getClass();
            list.getClass();
            FunSpec.Builder builderConstructorBuilder = FunSpec.INSTANCE.constructorBuilder();
            Iterator<? extends KSTypeParameter> it = list.iterator();
            if (it.hasNext()) {
                throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
            }
            builder.primaryConstructor(builderConstructorBuilder.build());
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.values().length];
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PRIMITIVE_SINGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PRIMITIVE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PRIMITIVE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PARCELABLE_SINGULAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PARCELABLE_LIST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_SINGULAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_LIST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_PROXY_SINGULAR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_PROXY_LIST.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AppFunctionSerializableFactoryCodeBuilderHelper(AppFunctionSerializableType appFunctionSerializableType, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) throws ProcessingException {
        appFunctionSerializableType.getClass();
        resolvedAnnotatedSerializableProxies.getClass();
        this.annotatedClass = appFunctionSerializableType;
        this.resolvedAnnotatedSerializableProxies = resolvedAnnotatedSerializableProxies;
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<AppFunctionTypeReference> it = appFunctionSerializableType.getSerializablePropertyTypeReferences().iterator();
        while (it.hasNext()) {
            AnnotatedAppFunctionSerializable annotatedSerializable = getAnnotatedSerializable(it.next());
            mapCreateMapBuilder.put(annotatedSerializable.getFactoryVariableName(), annotatedSerializable);
        }
        Iterator<AppFunctionTypeReference> it2 = this.annotatedClass.getSerializableProxyPropertyTypeReferences().iterator();
        while (it2.hasNext()) {
            AnnotatedAppFunctionSerializableProxy serializableProxyForTypeReference = this.resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(it2.next());
            mapCreateMapBuilder.put(serializableProxyForTypeReference.getFactoryVariableName(), serializableProxyForTypeReference);
        }
        for (Map.Entry entry : MapsKt.build(mapCreateMapBuilder).entrySet()) {
            String str = (String) entry.getKey();
            AppFunctionSerializableType appFunctionSerializableType2 = (AppFunctionSerializableType) entry.getValue();
            if (appFunctionSerializableType2 instanceof AnnotatedAppFunctionSerializableProxy) {
                builder.addStatement("val %L = %T()", str, ((AnnotatedAppFunctionSerializableProxy) appFunctionSerializableType2).getFactoryClassName());
            } else if (appFunctionSerializableType2 instanceof AnnotatedParameterizedAppFunctionSerializable) {
                addParameterizedFactoryInitStatement(builder, str, (AnnotatedParameterizedAppFunctionSerializable) appFunctionSerializableType2);
                Unit unit = Unit.INSTANCE;
            } else {
                builder.addStatement("val %L = %T()", str, appFunctionSerializableType2.getFactoryClassName());
            }
        }
        builder.add("\n", new Object[0]);
        this.factoryInitStatements = builder.build();
    }

    private final void addParameterizedFactoryInitStatement(CodeBlock.Builder builder, String str, AnnotatedParameterizedAppFunctionSerializable annotatedParameterizedAppFunctionSerializable) throws ProcessingException {
        builder.add("val %L = %T", str, annotatedParameterizedAppFunctionSerializable.getFactoryClassName());
        builder.add("<", new Object[0]);
        Iterator<T> it = annotatedParameterizedAppFunctionSerializable.getTypeParameterMap().values().iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return;
            }
            builder.add("%T", KspUtilsKt.toTypeName((KSTypeReference) null));
            if (i != annotatedParameterizedAppFunctionSerializable.getTypeParameterMap().size() - 1) {
                builder.add(",", new Object[0]);
            }
            i = i2;
        }
        builder.addStatement(">(", new Object[0]);
        builder.indent();
        Iterator<T> it2 = annotatedParameterizedAppFunctionSerializable.getTypeParameterMap().values().iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            int i4 = i3 + 1;
            if (it2.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return;
            }
            appendTypeParameterInstanceCreation(builder, null);
            if (i3 != annotatedParameterizedAppFunctionSerializable.getTypeParameterMap().size() - 1) {
                builder.add(",", new Object[0]);
            }
            i3 = i4;
        }
        builder.unindent();
        builder.addStatement(")", new Object[0]);
    }

    private final CodeBlock appendFromAppFunctionDataMethodBodyCommon(String getterResultName) {
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("val %L = %N(appFunctionData = %L, qualifiedName = %S)", APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME, IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataWithSpec.METHOD_NAME, "appFunctionData", this.annotatedClass.getJvmQualifiedName());
        builder.add(this.factoryInitStatements);
        Iterator it = AppFunctionSerializableType.getProperties$default(this.annotatedClass, null, 1, null).iterator();
        if (!it.hasNext()) {
            appendGetterResultConstructorCallStatement(builder, this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName(), AppFunctionSerializableType.getProperties$default(this.annotatedClass, null, 1, null), getterResultName);
            builder.add("\n", new Object[0]);
            return builder.build();
        }
        AppFunctionPropertyDeclaration appFunctionPropertyDeclaration = (AppFunctionPropertyDeclaration) it.next();
        appFunctionPropertyDeclaration.getName();
        appFunctionPropertyDeclaration.getType();
        appFunctionPropertyDeclaration.isRequired();
        throw null;
    }

    private final CodeBlock.Builder appendGenericGetterStatement(CodeBlock.Builder builder, String str, KSTypeParameter kSTypeParameter) {
        builder.addNamed("val %param_name:L = %type_parameter_property_name:L.getFromAppFunctionData(%app_function_data_param_name:L,\"%param_name:L\")\n", MapsKt.mapOf(TuplesKt.to("param_name", str), TuplesKt.to("app_function_data_param_name", APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME), TuplesKt.to("type_parameter_property_name", INSTANCE.getTypeParameterPropertyName(kSTypeParameter))));
        return builder;
    }

    private final CodeBlock.Builder appendGenericSetterStatement(CodeBlock.Builder builder, String str, KSTypeParameter kSTypeParameter) {
        builder.addNamed("%type_parameter_property_name:L.setValueInAppFunctionData(builder, \"%param_name:L\", %param_name:L)\n", MapsKt.mapOf(TuplesKt.to("param_name", str), TuplesKt.to("type_parameter_property_name", INSTANCE.getTypeParameterPropertyName(kSTypeParameter))));
        return builder;
    }

    private final CodeBlock.Builder appendGetterResultConstructorCallStatement(CodeBlock.Builder builder, ClassName className, List<AppFunctionPropertyDeclaration> list, String str) {
        builder.addNamed("\nval %getter_result_name:L = %original_class_name:T(%params_list:L)", MapsKt.mapOf(TuplesKt.to("original_class_name", className), TuplesKt.to("params_list", CollectionsKt.joinToString$default(list, ", ", null, null, new Data$$ExternalSyntheticLambda0(2), 30)), TuplesKt.to("getter_result_name", str)));
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence appendGetterResultConstructorCallStatement$lambda$0(AppFunctionPropertyDeclaration appFunctionPropertyDeclaration) {
        appFunctionPropertyDeclaration.getClass();
        return appFunctionPropertyDeclaration.getName();
    }

    private final CodeBlock.Builder appendGetterStatement(CodeBlock.Builder builder, String str, KSTypeReference kSTypeReference, boolean z) throws ProcessingException {
        AppFunctionTypeReference appFunctionTypeReference = new AppFunctionTypeReference(kSTypeReference);
        switch (WhenMappings.$EnumSwitchMapping$0[appFunctionTypeReference.getTypeCategory().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return appendPrimitiveGetterStatement(builder, str, appFunctionTypeReference, z);
            case 4:
                return appendParcelableGetterStatement(builder, str, appFunctionTypeReference, z);
            case 5:
                return appendParcelableListGetterStatement(builder, str, appFunctionTypeReference, z);
            case 6:
                return appendSerializableGetterStatement(builder, str, getAnnotatedSerializable(appFunctionTypeReference).getFactoryVariableName(), appFunctionTypeReference);
            case 7:
                appFunctionTypeReference.getItemTypeReference();
                return appendSerializableListGetterStatement(builder, str, appFunctionTypeReference, null, z);
            case 8:
                return appendSerializableGetterStatement(builder, str, this.resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(appFunctionTypeReference).getFactoryVariableName(), appFunctionTypeReference);
            case 9:
                this.resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(appFunctionTypeReference).getSerializableReferenceType();
                return appendSerializableListGetterStatement(builder, str, appFunctionTypeReference, null, z);
            default:
                String str2 = "Unsupported type for @AppFunctionSerializable: " + appFunctionTypeReference.getTypeCategory();
                appFunctionTypeReference.getSelfTypeReference();
                throw new ProcessingException(str2, null, null, 4, null);
        }
    }

    private final CodeBlock.Builder appendNullableSetterStatement(CodeBlock.Builder builder, String str, KSTypeReference kSTypeReference) {
        return appendSetterStatement(builder.addNamed("if (%param_name:L != null) {\n", MapsKt.mapOf(TuplesKt.to("param_name", str))).indent(), str, kSTypeReference).unindent().addStatement("}", new Object[0]);
    }

    private final CodeBlock.Builder appendParcelableGetterStatement(CodeBlock.Builder builder, String str, AppFunctionTypeReference appFunctionTypeReference, boolean z) {
        Pair pair = TuplesKt.to("param_name", str);
        Pair pair2 = TuplesKt.to("app_function_data_param_name", APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME);
        Pair pair3 = TuplesKt.to("getter_name", getAppFunctionDataGetterName(appFunctionTypeReference));
        appFunctionTypeReference.getSelfTypeReference();
        Map<String, ?> mapMapOf = MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("param_type", KspUtilsKt.ignoreNullable(KspUtilsKt.toTypeName((KSTypeReference) null))));
        if (appFunctionTypeReference.isNullable() || !z) {
            builder.addNamed("val %param_name:L = %app_function_data_param_name:L.%getter_name:L(\"%param_name:L\", %param_type:T::class.java)\n", mapMapOf);
            return builder;
        }
        builder.addNamed("val %param_name:L = checkNotNull(%app_function_data_param_name:L.%getter_name:L(\"%param_name:L\", %param_type:T::class.java))\n", mapMapOf);
        return builder;
    }

    private final CodeBlock.Builder appendParcelableListGetterStatement(CodeBlock.Builder builder, String str, AppFunctionTypeReference appFunctionTypeReference, boolean z) {
        Pair pair = TuplesKt.to("param_name", str);
        Pair pair2 = TuplesKt.to("app_function_data_param_name", APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME);
        Pair pair3 = TuplesKt.to("getter_name", getAppFunctionDataGetterName(appFunctionTypeReference));
        appFunctionTypeReference.getItemTypeReference();
        Map<String, ?> mapMapOf = MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("item_type", KspUtilsKt.ignoreNullable(KspUtilsKt.toTypeName((KSTypeReference) null))), TuplesKt.to("default_value_postfix", getGetterDefaultValueStatement(appFunctionTypeReference, z)));
        if (appFunctionTypeReference.isNullable() || !z) {
            builder.addNamed("val %param_name:L = %app_function_data_param_name:L.%getter_name:L(\"%param_name:L\", %item_type:T::class.java)%default_value_postfix:L\n", mapMapOf);
            return builder;
        }
        builder.addNamed("val %param_name:L = checkNotNull(%app_function_data_param_name:L.%getter_name:L(\"%param_name:L\", %item_type:T::class.java))\n", mapMapOf);
        return builder;
    }

    private final CodeBlock.Builder appendParcelableSetterStatement(CodeBlock.Builder builder, String str, AppFunctionTypeReference appFunctionTypeReference) {
        builder.addNamed("builder.%setter_name:L(\"%param_name:L\", %param_name:L)\n", MapsKt.mapOf(TuplesKt.to("param_name", str), TuplesKt.to("setter_name", getAppFunctionDataSetterName(appFunctionTypeReference))));
        return builder;
    }

    private final CodeBlock.Builder appendPrimitiveGetterStatement(CodeBlock.Builder builder, String str, AppFunctionTypeReference appFunctionTypeReference, boolean z) {
        Map<String, ?> mapMapOf = MapsKt.mapOf(TuplesKt.to("param_name", str), TuplesKt.to("app_function_data_param_name", APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME), TuplesKt.to("getter_name", getAppFunctionDataGetterName(appFunctionTypeReference)), TuplesKt.to("default_value_postfix", getGetterDefaultValueStatement(appFunctionTypeReference, z)));
        if (appFunctionTypeReference.isNullable() || !z) {
            builder.addNamed("val %param_name:L = %app_function_data_param_name:L.%getter_name:L(\"%param_name:L\")%default_value_postfix:L\n", mapMapOf);
            return builder;
        }
        builder.addNamed("val %param_name:L = checkNotNull(%app_function_data_param_name:L.%getter_name:L(\"%param_name:L\"))\n", mapMapOf);
        return builder;
    }

    private final CodeBlock.Builder appendPrimitiveSetterStatement(CodeBlock.Builder builder, String str, AppFunctionTypeReference appFunctionTypeReference) {
        builder.addNamed("builder.%setter_name:L(\"%param_name:L\", %param_name:L)\n", MapsKt.mapOf(TuplesKt.to("param_name", str), TuplesKt.to("setter_name", getAppFunctionDataSetterName(appFunctionTypeReference))));
        return builder;
    }

    private final CodeBlock.Builder appendSerializableGetterStatement(CodeBlock.Builder builder, String str, String str2, AppFunctionTypeReference appFunctionTypeReference) {
        Pair pair = TuplesKt.to("param_name", str);
        appFunctionTypeReference.getSelfTypeReference();
        Map<String, ?> mapMapOf = MapsKt.mapOf(pair, TuplesKt.to("param_type", KspUtilsKt.toTypeName((KSTypeReference) null)), TuplesKt.to("factory_name", str2), TuplesKt.to("app_function_data_param_name", APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME), TuplesKt.to("getter_name", getAppFunctionDataGetterName(appFunctionTypeReference)), TuplesKt.to("from_app_function_data_method_name", IntrospectionHelper.AppFunctionSerializableFactoryClass.FromAppFunctionDataMethod.METHOD_NAME), TuplesKt.to("serializable_data_val_name", str + "Data"));
        if (appFunctionTypeReference.isNullable()) {
            builder.addNamed("val %serializable_data_val_name:L = %app_function_data_param_name:L.%getter_name:L(%param_name:S)\n", mapMapOf);
            return builder.addNamed("var %param_name:L: %param_type:T = null\n", mapMapOf).addNamed("if (%serializable_data_val_name:L != null) {\n", mapMapOf).indent().addNamed("%param_name:L = %factory_name:L.%from_app_function_data_method_name:L(%serializable_data_val_name:L)\n", mapMapOf).unindent().addStatement("}", new Object[0]);
        }
        builder.addNamed("val %serializable_data_val_name:L = checkNotNull(%app_function_data_param_name:L.%getter_name:L(%param_name:S))\n", mapMapOf);
        builder.addNamed("val %param_name:L = %factory_name:L.%from_app_function_data_method_name:L(%serializable_data_val_name:L)\n", mapMapOf);
        return builder;
    }

    private final CodeBlock.Builder appendSerializableListGetterStatement(CodeBlock.Builder builder, String str, AppFunctionTypeReference appFunctionTypeReference, KSTypeReference kSTypeReference, boolean z) {
        String factoryVariableName = getFactoryVariableName(kSTypeReference);
        Map<String, ?> mapMapOf = MapsKt.mapOf(TuplesKt.to("param_name", str), TuplesKt.to("temp_list_name", str + "Data"), TuplesKt.to("app_function_data_param_name", APP_FUNCTION_DATA_WITH_SPEC_VARIABLE_NAME), TuplesKt.to("factory_instance_name", factoryVariableName), TuplesKt.to("getter_name", getAppFunctionDataGetterName(appFunctionTypeReference)), TuplesKt.to("default_value_postfix", getGetterDefaultValueStatement(appFunctionTypeReference, z)), TuplesKt.to("null_safe_op", appFunctionTypeReference.isNullable() ? "?" : ""));
        if (appFunctionTypeReference.isNullable() || !z) {
            builder.addNamed("val %temp_list_name:L = %app_function_data_param_name:L.%getter_name:L(\"%param_name:L\")%default_value_postfix:L\n", mapMapOf);
        } else {
            builder.addNamed("val %temp_list_name:L = checkNotNull(%app_function_data_param_name:L.%getter_name:L(\"%param_name:L\"))\n", mapMapOf);
        }
        builder.addNamed("val %param_name:L = %temp_list_name:L%null_safe_op:L.map { data ->\n", mapMapOf).indent().addNamed("%factory_instance_name:L.fromAppFunctionData(data)\n", mapMapOf).unindent().addStatement("}", new Object[0]);
        return builder;
    }

    private final CodeBlock.Builder appendSerializableListSetterStatement(CodeBlock.Builder builder, String str, AppFunctionTypeReference appFunctionTypeReference, KSTypeReference kSTypeReference) {
        Map<String, ?> mapMapOf = MapsKt.mapOf(TuplesKt.to("param_name", str), TuplesKt.to("factory_name", getFactoryVariableName(kSTypeReference)), TuplesKt.to("setter_name", getAppFunctionDataSetterName(appFunctionTypeReference)), TuplesKt.to("lambda_param_name", getVariableName(kSTypeReference)));
        builder.addNamed("builder.%setter_name:L(\"%param_name:L\", %param_name:L.map{ %lambda_param_name:L ->\n", mapMapOf).indent().addNamed("%factory_name:L.toAppFunctionData(%lambda_param_name:L)\n", mapMapOf).unindent().addStatement("})", new Object[0]);
        return builder;
    }

    private final CodeBlock.Builder appendSerializableSetterStatement(CodeBlock.Builder builder, String str, String str2, AppFunctionTypeReference appFunctionTypeReference) {
        builder.addNamed("builder.%setter_name:L(\"%param_name:L\", %factory_name:L.toAppFunctionData(%param_name:L))\n", MapsKt.mapOf(TuplesKt.to("param_name", str), TuplesKt.to("factory_name", str2), TuplesKt.to("setter_name", getAppFunctionDataSetterName(appFunctionTypeReference))));
        return builder;
    }

    private final CodeBlock.Builder appendSetterStatement(CodeBlock.Builder builder, String str, KSTypeReference kSTypeReference) throws ProcessingException {
        AppFunctionTypeReference appFunctionTypeReference = new AppFunctionTypeReference(kSTypeReference);
        switch (WhenMappings.$EnumSwitchMapping$0[appFunctionTypeReference.getTypeCategory().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return appendPrimitiveSetterStatement(builder, str, appFunctionTypeReference);
            case 4:
            case 5:
                return appendParcelableSetterStatement(builder, str, appFunctionTypeReference);
            case 6:
                return appendSerializableSetterStatement(builder, str, getAnnotatedSerializable(appFunctionTypeReference).getFactoryVariableName(), appFunctionTypeReference);
            case 7:
                appFunctionTypeReference.getItemTypeReference();
                return appendSerializableListSetterStatement(builder, str, appFunctionTypeReference, null);
            case 8:
                return appendSerializableSetterStatement(builder, str, this.resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(appFunctionTypeReference).getFactoryVariableName(), appFunctionTypeReference);
            case 9:
                this.resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(appFunctionTypeReference).getSerializableReferenceType();
                return appendSerializableListSetterStatement(builder, str, appFunctionTypeReference, null);
            default:
                String str2 = "Unsupported type for @AppFunctionSerializable: " + appFunctionTypeReference.getTypeCategory();
                appFunctionTypeReference.getSelfTypeReference();
                throw new ProcessingException(str2, null, null, 4, null);
        }
    }

    private final CodeBlock appendToAppFunctionDataMethodBodyCommon() {
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.add(this.factoryInitStatements);
        builder.addStatement("val builder = %N(%S)", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.METHOD_NAME, this.annotatedClass.getJvmQualifiedName());
        Iterator it = AppFunctionSerializableType.getProperties$default(this.annotatedClass, null, 1, null).iterator();
        if (!it.hasNext()) {
            builder.add("\nreturn builder.build()", new Object[0]);
            return builder.build();
        }
        AppFunctionPropertyDeclaration appFunctionPropertyDeclaration = (AppFunctionPropertyDeclaration) it.next();
        builder.addNamed("val %param_name:L = %annotated_class_instance:L.%param_name:L\n", MapsKt.mapOf(TuplesKt.to("param_name", appFunctionPropertyDeclaration.getName()), TuplesKt.to("annotated_class_instance", getSerializableParamName(this.annotatedClass))));
        appFunctionPropertyDeclaration.getType();
        throw null;
    }

    private final void appendTypeParameterInstanceCreation(CodeBlock.Builder builder, KSTypeReference kSTypeReference) throws ProcessingException {
        AppFunctionTypeReference appFunctionTypeReference = new AppFunctionTypeReference(kSTypeReference);
        switch (WhenMappings.$EnumSwitchMapping$0[appFunctionTypeReference.getTypeCategory().ordinal()]) {
            case 1:
                ClassName class_name = IntrospectionHelper.AppFunctionSerializableFactoryClass.TypeParameterClass.PrimitiveTypeParameterClass.INSTANCE.getCLASS_NAME();
                appFunctionTypeReference.getSelfTypeReference();
                appendTypeParameterInstanceCreation(builder, class_name, KspUtilsKt.toTypeName((KSTypeReference) null));
                return;
            case 2:
                ClassName class_name2 = IntrospectionHelper.AppFunctionSerializableFactoryClass.TypeParameterClass.PrimitiveTypeParameterClass.INSTANCE.getCLASS_NAME();
                appFunctionTypeReference.getSelfTypeReference();
                appendTypeParameterInstanceCreation(builder, class_name2, KspUtilsKt.toTypeName((KSTypeReference) null));
                return;
            case 3:
                ClassName class_name3 = IntrospectionHelper.AppFunctionSerializableFactoryClass.TypeParameterClass.PrimitiveListTypeParameter.INSTANCE.getCLASS_NAME();
                appFunctionTypeReference.getItemTypeReference();
                appendTypeParameterInstanceCreation(builder, class_name3, KspUtilsKt.toTypeName((KSTypeReference) null));
                return;
            case 4:
            case 5:
            default:
                String str = "Unsupported type to use with a parameterized AppFunctionSerializable: " + appFunctionTypeReference.getTypeCategory();
                appFunctionTypeReference.getSelfTypeReference();
                throw new ProcessingException(str, null, null, 4, null);
            case 6:
                ClassName class_name4 = IntrospectionHelper.AppFunctionSerializableFactoryClass.TypeParameterClass.SerializableTypeParameter.INSTANCE.getCLASS_NAME();
                appFunctionTypeReference.getSelfTypeReference();
                appendTypeParameterInstanceCreation(builder, class_name4, KspUtilsKt.toTypeName((KSTypeReference) null), getAnnotatedSerializable(appFunctionTypeReference).getFactoryClassName());
                return;
            case 7:
                ClassName class_name5 = IntrospectionHelper.AppFunctionSerializableFactoryClass.TypeParameterClass.SerializableListTypeParameter.INSTANCE.getCLASS_NAME();
                appFunctionTypeReference.getItemTypeReference();
                appendTypeParameterInstanceCreation(builder, class_name5, KspUtilsKt.toTypeName((KSTypeReference) null), getAnnotatedSerializable(appFunctionTypeReference).getFactoryClassName());
                return;
            case 8:
                AnnotatedAppFunctionSerializableProxy serializableProxyForTypeReference = this.resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(appFunctionTypeReference);
                ClassName class_name6 = IntrospectionHelper.AppFunctionSerializableFactoryClass.TypeParameterClass.SerializableTypeParameter.INSTANCE.getCLASS_NAME();
                appFunctionTypeReference.getSelfTypeReference();
                appendTypeParameterInstanceCreation(builder, class_name6, KspUtilsKt.toTypeName((KSTypeReference) null), serializableProxyForTypeReference.getFactoryClassName());
                return;
            case 9:
                AnnotatedAppFunctionSerializableProxy serializableProxyForTypeReference2 = this.resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(appFunctionTypeReference);
                ClassName class_name7 = IntrospectionHelper.AppFunctionSerializableFactoryClass.TypeParameterClass.SerializableListTypeParameter.INSTANCE.getCLASS_NAME();
                appFunctionTypeReference.getItemTypeReference();
                appendTypeParameterInstanceCreation(builder, class_name7, KspUtilsKt.toTypeName((KSTypeReference) null), serializableProxyForTypeReference2.getFactoryClassName());
                return;
        }
    }

    private final AnnotatedAppFunctionSerializable getAnnotatedSerializable(AppFunctionTypeReference typeReference) {
        typeReference.getSelfOrItemTypeReference();
        throw null;
    }

    private final String getAppFunctionDataGetterName(AppFunctionTypeReference afType) throws ProcessingException {
        afType.getSelfOrItemTypeReference();
        String typeShortName = getTypeShortName(null);
        switch (WhenMappings.$EnumSwitchMapping$0[afType.getTypeCategory().ordinal()]) {
            case 1:
                return FileInsert$$ExternalSyntheticOutline0.m("get", typeShortName, "OrNull");
            case 2:
                return FileInsert$$ExternalSyntheticOutline0.m("get", typeShortName);
            case 3:
                return FileInsert$$ExternalSyntheticOutline0.m("get", typeShortName, "List");
            case 4:
                return "getParcelable";
            case 5:
                return "getParcelableList";
            case 6:
            case 8:
                return "getAppFunctionData";
            case 7:
            case 9:
                return "getAppFunctionDataList";
            default:
                String str = "Unsupported type for @AppFunctionSerializable: " + afType.getTypeCategory();
                afType.getSelfTypeReference();
                throw new ProcessingException(str, null, null, 4, null);
        }
    }

    private final String getAppFunctionDataSetterName(AppFunctionTypeReference afType) throws ProcessingException {
        switch (WhenMappings.$EnumSwitchMapping$0[afType.getTypeCategory().ordinal()]) {
            case 1:
            case 2:
                afType.getSelfOrItemTypeReference();
                return FileInsert$$ExternalSyntheticOutline0.m("set", getTypeShortName(null));
            case 3:
                afType.getSelfOrItemTypeReference();
                return FileInsert$$ExternalSyntheticOutline0.m("set", getTypeShortName(null), "List");
            case 4:
                return "setParcelable";
            case 5:
                return "setParcelableList";
            case 6:
            case 8:
                return "setAppFunctionData";
            case 7:
            case 9:
                return "setAppFunctionDataList";
            default:
                String str = "Unsupported type for @AppFunctionSerializable: " + afType.getTypeCategory();
                afType.getSelfTypeReference();
                throw new ProcessingException(str, null, null, 4, null);
        }
    }

    private final String getFactoryVariableName(KSTypeReference kSTypeReference) {
        return FileInsert$$ExternalSyntheticOutline0.m$1(getVariableName(kSTypeReference), "Factory");
    }

    private final String getGetterDefaultValueStatement(AppFunctionTypeReference afType, boolean isRequired) throws ProcessingException {
        switch (WhenMappings.$EnumSwitchMapping$0[afType.getTypeCategory().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
                return (isRequired || afType.isNullable()) ? "" : FileInsert$$ExternalSyntheticOutline0.m(" ?: ", afType.getTypeDefaultValueAsString());
            case 4:
            case 6:
            case 8:
                return "";
            default:
                String str = "Unsupported type for @AppFunctionSerializable: " + afType.getTypeCategory();
                afType.getSelfTypeReference();
                throw new ProcessingException(str, null, null, 4, null);
        }
    }

    private final String getResultParamName(AppFunctionSerializableType annotatedClass) {
        return FileInsert$$ExternalSyntheticOutline0.m("result", annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName().getSimpleName());
    }

    private final String getSerializableParamName(AppFunctionSerializableType annotatedClass) {
        String simpleName = annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName().getSimpleName();
        if (simpleName.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(simpleName.charAt(0));
            strValueOf.getClass();
            String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            sb.append((Object) lowerCase);
            sb.append(simpleName.substring(1));
            simpleName = sb.toString();
        }
        return FileInsert$$ExternalSyntheticOutline0.m$1(simpleName, "_appFunctionSerializable");
    }

    private final String getTypeShortName(KSTypeReference kSTypeReference) {
        KspUtilsKt.ensureQualifiedTypeName(kSTypeReference);
        throw null;
    }

    private final String getVariableName(KSTypeReference kSTypeReference) {
        kSTypeReference.resolve();
        throw null;
    }

    private final String lowerFirstChar(String str) {
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strValueOf = String.valueOf(str.charAt(0));
        strValueOf.getClass();
        String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        sb.append((Object) lowerCase);
        sb.append(str.substring(1));
        return sb.toString();
    }

    public final CodeBlock buildFromAppFunctionDataMethodBody() {
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        String resultParamName = getResultParamName(this.annotatedClass);
        builder.add(appendFromAppFunctionDataMethodBodyCommon(resultParamName));
        builder.addStatement("return %L", resultParamName);
        return builder.build();
    }

    public final CodeBlock buildFromAppFunctionDataMethodBodyForProxy() throws ProcessingException {
        if (!(this.annotatedClass instanceof AnnotatedAppFunctionSerializableProxy)) {
            throw new ProcessingException("Attempting to generate proxy getter for non proxy serializable.", this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getAttributeNode(), null, 4, null);
        }
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        String resultParamName = getResultParamName(this.annotatedClass);
        builder.add(appendFromAppFunctionDataMethodBodyCommon(resultParamName));
        builder.addStatement("return %L.%L()", resultParamName, ((AnnotatedAppFunctionSerializableProxy) this.annotatedClass).getToTargetClassMethodName());
        return builder.build();
    }

    public final CodeBlock buildToAppFunctionDataMethodBody() {
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("val %L = %L", getSerializableParamName(this.annotatedClass), IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME);
        builder.add(appendToAppFunctionDataMethodBodyCommon());
        return builder.build();
    }

    public final CodeBlock buildToAppFunctionDataMethodBodyForProxy() throws ProcessingException {
        if (!(this.annotatedClass instanceof AnnotatedAppFunctionSerializableProxy)) {
            throw new ProcessingException("Attempting to generate proxy setter for non proxy serializable.", this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getAttributeNode(), null, 4, null);
        }
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("val %L = %T.%L(%L)", getSerializableParamName(this.annotatedClass), this.annotatedClass.getAppFunctionSerializableTypeClassDeclaration().getOriginalClassName(), ((AnnotatedAppFunctionSerializableProxy) this.annotatedClass).getFromTargetClassMethodName(), IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME);
        builder.add(appendToAppFunctionDataMethodBodyCommon());
        return builder.build();
    }

    public final AppFunctionSerializableType getAnnotatedClass() {
        return this.annotatedClass;
    }

    public final AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies getResolvedAnnotatedSerializableProxies() {
        return this.resolvedAnnotatedSerializableProxies;
    }

    private final void appendTypeParameterInstanceCreation(CodeBlock.Builder builder, ClassName className, TypeName typeName) {
        if (typeName.getIsNullable()) {
            builder.add("@Suppress(\"UNCHECKED_CAST\") ", new Object[0]);
            builder.add("%1T(%2T::class.java as Class<%3T>)", className, KspUtilsKt.ignoreNullable(typeName), typeName);
        } else {
            builder.add("%1T(%2T::class.java)", className, typeName);
        }
    }

    private final void appendTypeParameterInstanceCreation(CodeBlock.Builder builder, ClassName className, TypeName typeName, ClassName className2) {
        if (typeName.getIsNullable()) {
            builder.add("@Suppress(\"UNCHECKED_CAST\") ", new Object[0]);
            builder.add("%1T(%2T::class.java as Class<%3T>, %4T())", className, KspUtilsKt.ignoreNullable(typeName), typeName, className2);
        } else {
            builder.add("%1T(%2T::class.java, %3T())", className, typeName, className2);
        }
    }
}
