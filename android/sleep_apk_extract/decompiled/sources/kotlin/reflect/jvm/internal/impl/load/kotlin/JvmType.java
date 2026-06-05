package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JvmType {
    public static final Companion Companion = new Companion(null);
    private static final Primitive BOOLEAN = new Primitive(JvmPrimitiveType.BOOLEAN);
    private static final Primitive CHAR = new Primitive(JvmPrimitiveType.CHAR);
    private static final Primitive BYTE = new Primitive(JvmPrimitiveType.BYTE);
    private static final Primitive SHORT = new Primitive(JvmPrimitiveType.SHORT);
    private static final Primitive INT = new Primitive(JvmPrimitiveType.INT);
    private static final Primitive FLOAT = new Primitive(JvmPrimitiveType.FLOAT);
    private static final Primitive LONG = new Primitive(JvmPrimitiveType.LONG);
    private static final Primitive DOUBLE = new Primitive(JvmPrimitiveType.DOUBLE);

    public static final class Array extends JvmType {
        private final JvmType elementType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Array(JvmType jvmType) {
            super(null);
            jvmType.getClass();
            this.elementType = jvmType;
        }

        public final JvmType getElementType() {
            return this.elementType;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Primitive getBOOLEAN$descriptors_jvm() {
            return JvmType.BOOLEAN;
        }

        public final Primitive getBYTE$descriptors_jvm() {
            return JvmType.BYTE;
        }

        public final Primitive getCHAR$descriptors_jvm() {
            return JvmType.CHAR;
        }

        public final Primitive getDOUBLE$descriptors_jvm() {
            return JvmType.DOUBLE;
        }

        public final Primitive getFLOAT$descriptors_jvm() {
            return JvmType.FLOAT;
        }

        public final Primitive getINT$descriptors_jvm() {
            return JvmType.INT;
        }

        public final Primitive getLONG$descriptors_jvm() {
            return JvmType.LONG;
        }

        public final Primitive getSHORT$descriptors_jvm() {
            return JvmType.SHORT;
        }

        private Companion() {
        }
    }

    public static final class Object extends JvmType {
        private final String internalName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Object(String str) {
            super(null);
            str.getClass();
            this.internalName = str;
        }

        public final String getInternalName() {
            return this.internalName;
        }
    }

    public static final class Primitive extends JvmType {
        private final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.jvmPrimitiveType = jvmPrimitiveType;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }

    public /* synthetic */ JvmType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }

    private JvmType() {
    }
}
