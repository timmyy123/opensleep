package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        moduleDescriptor.getClass();
        classId.getClass();
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        moduleDescriptor.getClass();
        classId.getClass();
        ModuleDescriptor resolutionAnchorIfAny = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(classId.getPackageFqName());
            List<Name> listPathSegments = classId.getRelativeClassName().pathSegments();
            ClassifierDescriptor classifierDescriptorMo2512getContributedClassifier = packageViewDescriptor.getMemberScope().mo2512getContributedClassifier((Name) CollectionsKt.first((List) listPathSegments), NoLookupLocation.FROM_DESERIALIZATION);
            if (classifierDescriptorMo2512getContributedClassifier != null) {
                for (Name name : listPathSegments.subList(1, listPathSegments.size())) {
                    if (classifierDescriptorMo2512getContributedClassifier instanceof ClassDescriptor) {
                        ClassifierDescriptor classifierDescriptorMo2512getContributedClassifier2 = ((ClassDescriptor) classifierDescriptorMo2512getContributedClassifier).getUnsubstitutedInnerClassesScope().mo2512getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                        classifierDescriptorMo2512getContributedClassifier = classifierDescriptorMo2512getContributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2512getContributedClassifier2 : null;
                        if (classifierDescriptorMo2512getContributedClassifier != null) {
                        }
                    }
                }
                return classifierDescriptorMo2512getContributedClassifier;
            }
        } else {
            PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(classId.getPackageFqName());
            List<Name> listPathSegments2 = classId.getRelativeClassName().pathSegments();
            ClassifierDescriptor classifierDescriptorMo2512getContributedClassifier3 = packageViewDescriptor2.getMemberScope().mo2512getContributedClassifier((Name) CollectionsKt.first((List) listPathSegments2), NoLookupLocation.FROM_DESERIALIZATION);
            if (classifierDescriptorMo2512getContributedClassifier3 == null) {
                classifierDescriptorMo2512getContributedClassifier3 = null;
                if (classifierDescriptorMo2512getContributedClassifier3 == null) {
                    return classifierDescriptorMo2512getContributedClassifier3;
                }
                PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(classId.getPackageFqName());
                List<Name> listPathSegments3 = classId.getRelativeClassName().pathSegments();
                ClassifierDescriptor classifierDescriptorMo2512getContributedClassifier4 = packageViewDescriptor3.getMemberScope().mo2512getContributedClassifier((Name) CollectionsKt.first((List) listPathSegments3), NoLookupLocation.FROM_DESERIALIZATION);
                if (classifierDescriptorMo2512getContributedClassifier4 != null) {
                    for (Name name2 : listPathSegments3.subList(1, listPathSegments3.size())) {
                        if (classifierDescriptorMo2512getContributedClassifier4 instanceof ClassDescriptor) {
                            ClassifierDescriptor classifierDescriptorMo2512getContributedClassifier5 = ((ClassDescriptor) classifierDescriptorMo2512getContributedClassifier4).getUnsubstitutedInnerClassesScope().mo2512getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                            classifierDescriptorMo2512getContributedClassifier4 = classifierDescriptorMo2512getContributedClassifier5 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2512getContributedClassifier5 : null;
                            if (classifierDescriptorMo2512getContributedClassifier4 != null) {
                            }
                        }
                    }
                    return classifierDescriptorMo2512getContributedClassifier4;
                }
            } else {
                for (Name name3 : listPathSegments2.subList(1, listPathSegments2.size())) {
                    if (classifierDescriptorMo2512getContributedClassifier3 instanceof ClassDescriptor) {
                        ClassifierDescriptor classifierDescriptorMo2512getContributedClassifier6 = ((ClassDescriptor) classifierDescriptorMo2512getContributedClassifier3).getUnsubstitutedInnerClassesScope().mo2512getContributedClassifier(name3, NoLookupLocation.FROM_DESERIALIZATION);
                        classifierDescriptorMo2512getContributedClassifier3 = classifierDescriptorMo2512getContributedClassifier6 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2512getContributedClassifier6 : null;
                        if (classifierDescriptorMo2512getContributedClassifier3 != null) {
                        }
                    }
                    classifierDescriptorMo2512getContributedClassifier3 = null;
                }
                if (classifierDescriptorMo2512getContributedClassifier3 == null) {
                }
            }
        }
        return null;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        moduleDescriptor.getClass();
        classId.getClass();
        notFoundClasses.getClass();
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        return classDescriptorFindClassAcrossModuleDependencies != null ? classDescriptorFindClassAcrossModuleDependencies : notFoundClasses.getClass(classId, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ClassId) obj).getOuterClassId();
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return Integer.valueOf(FindClassInModuleKt.findNonGenericClassAcrossDependencies$lambda$0((ClassId) obj));
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findNonGenericClassAcrossDependencies$lambda$0(ClassId classId) {
        classId.getClass();
        return 0;
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        moduleDescriptor.getClass();
        classId.getClass();
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
