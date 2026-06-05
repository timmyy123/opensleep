package kotlin.reflect.jvm.internal.impl.builtins.functions;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        storageManager.getClass();
        moduleDescriptor.getClass();
        this.storageManager = storageManager;
        this.module = moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        FqName packageFqName;
        FunctionTypeKindExtractor.KindWithArity functionalClassKindWithArity;
        classId.getClass();
        if (!classId.isLocal() && !classId.isNestedClass()) {
            String strAsString = classId.getRelativeClassName().asString();
            if (StringsKt.contains$default(strAsString, "Function") && (functionalClassKindWithArity = FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity((packageFqName = classId.getPackageFqName()), strAsString)) != null) {
                FunctionTypeKind functionTypeKindComponent1 = functionalClassKindWithArity.component1();
                int iComponent2 = functionalClassKindWithArity.component2();
                List<PackageFragmentDescriptor> fragments = this.module.getPackage(packageFqName).getFragments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fragments) {
                    if (obj instanceof BuiltInsPackageFragment) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                if (CollectionsKt.firstOrNull((List) arrayList2) == null) {
                    return new FunctionClassDescriptor(this.storageManager, (BuiltInsPackageFragment) CollectionsKt.first((List) arrayList), functionTypeKindComponent1, iComponent2);
                }
                Events$$ExternalSyntheticBUOutline0.m();
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        fqName.getClass();
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName fqName, Name name) {
        fqName.getClass();
        name.getClass();
        String strAsString = name.asString();
        strAsString.getClass();
        return (StringsKt.startsWith$default(strAsString, "Function") || StringsKt.startsWith$default(strAsString, "KFunction") || StringsKt.startsWith$default(strAsString, "SuspendFunction") || StringsKt.startsWith$default(strAsString, "KSuspendFunction")) && FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(fqName, strAsString) != null;
    }
}
