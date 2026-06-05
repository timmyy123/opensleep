package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.AppFunctionCompiler;
import androidx.appfunctions.compiler.core.AppFunctionComponentRegistryGenerator;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.Utility;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Dependencies;
import com.google.devtools.ksp.symbol.KSFile;
import com.squareup.kotlinpoet.AnnotationSpec;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.TypeSpec;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionComponentRegistryGenerator;", "", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;)V", "generateRegistry", "", "moduleName", "", IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, "components", "", "Landroidx/appfunctions/compiler/core/AppFunctionComponentRegistryGenerator$AppFunctionComponent;", "getRegistryClassName", IntrospectionHelper.AppFunctionComponentRegistryAnnotation.PROPERTY_COMPONENT_CATEGORY, "AppFunctionComponent", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionComponentRegistryGenerator {
    private final CodeGenerator codeGenerator;

    public AppFunctionComponentRegistryGenerator(CodeGenerator codeGenerator) {
        codeGenerator.getClass();
    }

    private final String getRegistryClassName(String moduleName, String componentCategory) {
        return FileInsert$$ExternalSyntheticOutline0.m("$", StringUtilsKt.toPascalCase(moduleName), "_", StringUtilsKt.toPascalCase(componentCategory), "ComponentRegistry");
    }

    public final void generateRegistry(String moduleName, String category, List<AppFunctionComponent> components) {
        moduleName.getClass();
        category.getClass();
        components.getClass();
        List<AppFunctionComponent> list = components;
        List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: androidx.appfunctions.compiler.core.AppFunctionComponentRegistryGenerator$generateRegistry$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((AppFunctionComponentRegistryGenerator.AppFunctionComponent) t).getQualifiedName(), ((AppFunctionComponentRegistryGenerator.AppFunctionComponent) t2).getQualifiedName());
            }
        });
        String registryClassName = getRegistryClassName(moduleName, category);
        AnnotationSpec.Builder builderAddMember = AnnotationSpec.INSTANCE.builder(IntrospectionHelper.AppFunctionComponentRegistryAnnotation.INSTANCE.getCLASS_NAME()).addMember("componentCategory = %S", category);
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        builder.addStatement("componentNames = [", new Object[0]);
        builder.indent();
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            builder.addStatement("%S,", ((AppFunctionComponent) it.next()).getQualifiedName());
        }
        builder.unindent();
        builder.add("]", new Object[0]);
        AnnotationSpec.Builder builderAddMember2 = builderAddMember.addMember(builder.build());
        if (Intrinsics.areEqual(category, "FUNCTION") || Intrinsics.areEqual(category, "SERIALIZABLE")) {
            CodeBlock.Builder builder2 = CodeBlock.INSTANCE.builder();
            builder2.addStatement("componentDocStrings = [", new Object[0]);
            builder2.indent();
            Iterator it2 = listSortedWith.iterator();
            while (it2.hasNext()) {
                builder2.addStatement("%S,", ((AppFunctionComponent) it2.next()).getDocString());
            }
            builder2.unindent();
            builder2.add("]", new Object[0]);
            builderAddMember2.addMember(builder2.build());
        }
        TypeSpec.Builder builderClassBuilder = TypeSpec.INSTANCE.classBuilder(registryClassName);
        builderClassBuilder.addAnnotation(builderAddMember2.build());
        builderClassBuilder.addAnnotation(AppFunctionCompiler.INSTANCE.getGENERATED_ANNOTATION$appfunctions_compiler());
        FileSpec fileSpecBuild = FileSpec.INSTANCE.builder(IntrospectionHelper.APP_FUNCTIONS_AGGREGATED_DEPS_PACKAGE_NAME, registryClassName).addType(builderClassBuilder.build()).build();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((AppFunctionComponent) it3.next()).getSourceFiles());
        }
        KSFile[] kSFileArr = (KSFile[]) CollectionsKt.toSet(arrayList).toArray(new KSFile[0]);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(CodeGenerator.createNewFile$default(null, new Dependencies(true, (KSFile[]) Arrays.copyOf(kSFileArr, kSFileArr.length)), IntrospectionHelper.APP_FUNCTIONS_AGGREGATED_DEPS_PACKAGE_NAME, registryClassName, null, 8, null), Charsets.UTF_8), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        try {
            fileSpecBuild.writeTo(bufferedWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
        } finally {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionComponentRegistryGenerator$AppFunctionComponent;", "", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "sourceFiles", "", "Lcom/google/devtools/ksp/symbol/KSFile;", "docString", "<init>", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V", "getQualifiedName", "()Ljava/lang/String;", "getSourceFiles", "()Ljava/util/Set;", "getDocString", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionComponent {
        private final String docString;
        private final String qualifiedName;
        private final Set<KSFile> sourceFiles;

        /* JADX WARN: Multi-variable type inference failed */
        public AppFunctionComponent(String str, Set<? extends KSFile> set, String str2) {
            str.getClass();
            set.getClass();
            str2.getClass();
            this.qualifiedName = str;
            this.sourceFiles = set;
            this.docString = str2;
        }

        public final String getDocString() {
            return this.docString;
        }

        public final String getQualifiedName() {
            return this.qualifiedName;
        }

        public final Set<KSFile> getSourceFiles() {
            return this.sourceFiles;
        }

        public /* synthetic */ AppFunctionComponent(String str, Set set, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? "" : str2);
        }
    }
}
