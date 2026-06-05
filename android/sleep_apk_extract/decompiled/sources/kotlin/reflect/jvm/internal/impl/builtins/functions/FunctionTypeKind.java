package kotlin.reflect.jvm.internal.impl.builtins.functions;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FunctionTypeKind {
    public static final Companion Companion = new Companion(null);
    private final ClassId annotationOnInvokeClassId;
    private final String classNamePrefix;
    private final boolean isInlineable;
    private final boolean isReflectType;
    private final int maxArity;
    private final FqName packageFqName;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Function extends FunctionTypeKind {
        public static final Function INSTANCE = new Function();

        private Function() {
            super(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, null, true, 0, 32, null);
        }
    }

    public static final class KFunction extends FunctionTypeKind {
        public static final KFunction INSTANCE = new KFunction();

        private KFunction() {
            super(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KFunction", true, null, false, Function.INSTANCE.getMaxArity());
        }
    }

    public static final class KSuspendFunction extends FunctionTypeKind {
        public static final KSuspendFunction INSTANCE = new KSuspendFunction();

        private KSuspendFunction() {
            super(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KSuspendFunction", true, null, false, SuspendFunction.INSTANCE.getMaxArity());
        }
    }

    public static final class SuspendFunction extends FunctionTypeKind {
        public static final SuspendFunction INSTANCE = new SuspendFunction();

        private SuspendFunction() {
            super(StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", false, null, true, Function.INSTANCE.getMaxArity() - 1);
        }
    }

    public FunctionTypeKind(FqName fqName, String str, boolean z, ClassId classId, boolean z2, int i) {
        fqName.getClass();
        str.getClass();
        this.packageFqName = fqName;
        this.classNamePrefix = str;
        this.isReflectType = z;
        this.annotationOnInvokeClassId = classId;
        this.isInlineable = z2;
        this.maxArity = i;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final int getMaxArity() {
        return this.maxArity;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final ClassId numberedClassId(int i) {
        return new ClassId(this.packageFqName, numberedClassName(i));
    }

    public final Name numberedClassName(int i) {
        Name nameIdentifier = Name.identifier(this.classNamePrefix + i);
        nameIdentifier.getClass();
        return nameIdentifier;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.packageFqName);
        sb.append('.');
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.classNamePrefix, 'N');
    }

    public /* synthetic */ FunctionTypeKind(FqName fqName, String str, boolean z, ClassId classId, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, str, z, classId, z2, (i2 & 32) != 0 ? 254 : i);
    }
}
