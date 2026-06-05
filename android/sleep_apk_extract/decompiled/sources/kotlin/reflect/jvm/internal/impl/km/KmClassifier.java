package kotlin.reflect.jvm.internal.impl.km;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KmClassifier {

    public static final class Class extends KmClassifier {
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Class(String str) {
            super(null);
            str.getClass();
            this.name = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Class) && Intrinsics.areEqual(this.name, ((Class) obj).name);
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Class(name="), this.name, ')');
        }
    }

    public static final class TypeAlias extends KmClassifier {
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypeAlias(String str) {
            super(null);
            str.getClass();
            this.name = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TypeAlias) && Intrinsics.areEqual(this.name, ((TypeAlias) obj).name);
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("TypeAlias(name="), this.name, ')');
        }
    }

    public static final class TypeParameter extends KmClassifier {
        private final int id;

        public TypeParameter(int i) {
            super(null);
            this.id = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TypeParameter) && this.id == ((TypeParameter) obj).id;
        }

        public final int getId() {
            return this.id;
        }

        public int hashCode() {
            return Integer.hashCode(this.id);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("TypeParameter(id="), this.id, ')');
        }
    }

    public /* synthetic */ KmClassifier(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private KmClassifier() {
    }
}
