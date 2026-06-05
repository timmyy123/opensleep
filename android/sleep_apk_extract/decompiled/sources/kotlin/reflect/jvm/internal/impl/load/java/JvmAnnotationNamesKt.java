package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JvmAnnotationNamesKt {
    private static final Set<FqName> BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS;
    private static final Set<FqName> FORCE_FLEXIBILITY_ANNOTATIONS;
    private static final FqName JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_NONNULL_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_NULLABLE_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NON_NULL_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NULLABLE_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_OLD_NULLABLE_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_OLD_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME;
    private static final Set<FqName> MUTABLE_ANNOTATIONS;
    private static final Set<FqName> NOT_NULL_ANNOTATIONS;
    private static final Set<FqName> NULLABILITY_ANNOTATIONS;
    private static final Set<FqName> NULLABLE_ANNOTATIONS;
    private static final Set<FqName> READ_ONLY_ANNOTATIONS;
    private static final FqName UNDER_MIGRATION_ANNOTATION_FQ_NAME;
    private static final Map<FqName, FqName> javaToKotlinNameMap;

    static {
        FqName fqName = new FqName("org.jspecify.nullness.Nullable");
        JSPECIFY_OLD_NULLABLE_ANNOTATION_FQ_NAME = fqName;
        FqName fqName2 = new FqName("org.jspecify.nullness.NullMarked");
        JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME = fqName2;
        FqName fqName3 = new FqName("org.jspecify.nullness.NullnessUnspecified");
        JSPECIFY_OLD_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME = fqName3;
        FqName fqName4 = new FqName("org.jspecify.annotations.NonNull");
        JSPECIFY_NON_NULL_ANNOTATION_FQ_NAME = fqName4;
        FqName fqName5 = new FqName("org.jspecify.annotations.Nullable");
        JSPECIFY_NULLABLE_ANNOTATION_FQ_NAME = fqName5;
        FqName fqName6 = new FqName("org.jspecify.annotations.NullMarked");
        JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME = fqName6;
        FqName fqName7 = new FqName("org.jspecify.annotations.NullnessUnspecified");
        JSPECIFY_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME = fqName7;
        FqName fqName8 = new FqName("org.jspecify.annotations.NullUnmarked");
        JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME = fqName8;
        JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifier");
        JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifierNickname");
        JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifierDefault");
        FqName fqName9 = new FqName("javax.annotation.Nonnull");
        JAVAX_NONNULL_ANNOTATION_FQ_NAME = fqName9;
        FqName fqName10 = new FqName("javax.annotation.Nullable");
        JAVAX_NULLABLE_ANNOTATION_FQ_NAME = fqName10;
        FqName fqName11 = new FqName("javax.annotation.CheckForNull");
        JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME = fqName11;
        JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.ParametersAreNonnullByDefault");
        JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.ParametersAreNullableByDefault");
        BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{fqName9, fqName11});
        FqName fqName12 = JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION;
        fqName12.getClass();
        Set<FqName> of = SetsKt.setOf((Object[]) new FqName[]{fqName12, fqName4, new FqName("android.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.RecentlyNonNull"), new FqName("android.support.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("io.reactivex.annotations.NonNull"), new FqName("io.reactivex.rxjava3.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("lombok.NonNull"), new FqName("jakarta.annotation.Nonnull")});
        NOT_NULL_ANNOTATIONS = of;
        FqName fqName13 = JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION;
        fqName13.getClass();
        Set<FqName> of2 = SetsKt.setOf((Object[]) new FqName[]{fqName13, fqName, fqName5, fqName10, fqName11, new FqName("android.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.RecentlyNullable"), new FqName("android.support.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("io.reactivex.annotations.Nullable"), new FqName("io.reactivex.rxjava3.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("jakarta.annotation.Nullable"), new FqName("io.vertx.codegen.annotations.Nullable")});
        NULLABLE_ANNOTATIONS = of2;
        FORCE_FLEXIBILITY_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{fqName3, fqName7});
        NULLABILITY_ANNOTATIONS = SetsKt.plus((Set<? extends FqName>) SetsKt.plus((Set<? extends FqName>) SetsKt.plus((Set<? extends FqName>) SetsKt.plus((Set<? extends FqName>) SetsKt.plus(SetsKt.plus((Set) new LinkedHashSet(), (Iterable) of), (Iterable) of2), fqName9), fqName2), fqName6), fqName8);
        READ_ONLY_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION, JvmAnnotationNames.JETBRAINS_UNMODIFIABLE_ANNOTATION, JvmAnnotationNames.JETBRAINS_UNMODIFIABLE_VIEW_ANNOTATION});
        MUTABLE_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION});
        javaToKotlinNameMap = MapsKt.mapOf(TuplesKt.to(JvmAnnotationNames.TARGET_ANNOTATION, StandardNames.FqNames.target), TuplesKt.to(JvmAnnotationNames.RETENTION_ANNOTATION, StandardNames.FqNames.retention), TuplesKt.to(JvmAnnotationNames.DEPRECATED_ANNOTATION, StandardNames.FqNames.deprecated), TuplesKt.to(JvmAnnotationNames.DOCUMENTED_ANNOTATION, StandardNames.FqNames.mustBeDocumented));
        UNDER_MIGRATION_ANNOTATION_FQ_NAME = new FqName("kotlin.annotations.jvm.UnderMigration");
    }

    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS;
    }

    public static final Set<FqName> getFORCE_FLEXIBILITY_ANNOTATIONS() {
        return FORCE_FLEXIBILITY_ANNOTATIONS;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION_FQ_NAME() {
        return JAVAX_NONNULL_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME;
    }

    public static final Set<FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    public static final Set<FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    public static final Set<FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    public static final Set<FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }

    public static final FqName getUNDER_MIGRATION_ANNOTATION_FQ_NAME() {
        return UNDER_MIGRATION_ANNOTATION_FQ_NAME;
    }
}
