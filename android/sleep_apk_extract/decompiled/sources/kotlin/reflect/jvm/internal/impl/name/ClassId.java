package kotlin.reflect.jvm.internal.impl.name;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
public final class ClassId {
    public static final Companion Companion = new Companion(null);
    private final boolean isLocal;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ClassId fromString$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.fromString(str, z);
        }

        public final ClassId fromString(String str, boolean z) {
            String strReplace$default;
            str.getClass();
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '`', 0, false, 6, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = str.length();
            }
            int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, MqttTopic.TOPIC_LEVEL_SEPARATOR, iIndexOf$default, false, 4, (Object) null);
            String str2 = "";
            if (iLastIndexOf$default == -1) {
                strReplace$default = StringsKt.replace$default(str, "`", "");
            } else {
                String strReplace$default2 = StringsKt__StringsJVMKt.replace$default(str.substring(0, iLastIndexOf$default), '/', '.', false, 4, (Object) null);
                strReplace$default = StringsKt.replace$default(str.substring(iLastIndexOf$default + 1), "`", "");
                str2 = strReplace$default2;
            }
            return new ClassId(new FqName(str2), new FqName(strReplace$default), z);
        }

        public final ClassId topLevel(FqName fqName) {
            fqName.getClass();
            return new ClassId(fqName.parent(), fqName.shortName());
        }

        private Companion() {
        }
    }

    public ClassId(FqName fqName, FqName fqName2, boolean z) {
        fqName.getClass();
        fqName2.getClass();
        this.packageFqName = fqName;
        this.relativeClassName = fqName2;
        this.isLocal = z;
        fqName2.isRoot();
    }

    private static final String asString$escapeSlashes(FqName fqName) {
        String strAsString = fqName.asString();
        return StringsKt__StringsKt.contains$default((CharSequence) strAsString, '/', false, 2, (Object) null) ? Fragment$$ExternalSyntheticOutline1.m('`', "`", strAsString) : strAsString;
    }

    public static final ClassId topLevel(FqName fqName) {
        return Companion.topLevel(fqName);
    }

    public final FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            return this.relativeClassName;
        }
        return new FqName(this.packageFqName.asString() + '.' + this.relativeClassName.asString());
    }

    public final String asString() {
        if (this.packageFqName.isRoot()) {
            return asString$escapeSlashes(this.relativeClassName);
        }
        return StringsKt__StringsJVMKt.replace$default(this.packageFqName.asString(), '.', '/', false, 4, (Object) null) + MqttTopic.TOPIC_LEVEL_SEPARATOR + asString$escapeSlashes(this.relativeClassName);
    }

    public final ClassId createNestedClassId(Name name) {
        name.getClass();
        return new ClassId(this.packageFqName, this.relativeClassName.child(name), this.isLocal);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassId)) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        return Intrinsics.areEqual(this.packageFqName, classId.packageFqName) && Intrinsics.areEqual(this.relativeClassName, classId.relativeClassName) && this.isLocal == classId.isLocal;
    }

    public final ClassId getOuterClassId() {
        FqName fqNameParent = this.relativeClassName.parent();
        if (fqNameParent.isRoot()) {
            return null;
        }
        return new ClassId(this.packageFqName, fqNameParent, this.isLocal);
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    public final Name getShortClassName() {
        return this.relativeClassName.shortName();
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLocal) + ((this.relativeClassName.hashCode() + (this.packageFqName.hashCode() * 31)) * 31);
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        return MqttTopic.TOPIC_LEVEL_SEPARATOR + asString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(FqName fqName, Name name) {
        this(fqName, FqName.Companion.topLevel(name), false);
        fqName.getClass();
        name.getClass();
    }
}
