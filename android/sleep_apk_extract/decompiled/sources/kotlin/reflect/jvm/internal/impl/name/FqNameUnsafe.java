package kotlin.reflect.jvm.internal.impl.name;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class FqNameUnsafe {
    public static final Companion Companion = new Companion(null);
    private static final Name ROOT_NAME;
    private static final Pattern SPLIT_BY_DOTS;
    private final String fqName;
    private transient FqNameUnsafe parent;
    private transient FqName safe;
    private transient Name shortName;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FqNameUnsafe topLevel(Name name) {
            name.getClass();
            String strAsString = name.asString();
            strAsString.getClass();
            return new FqNameUnsafe(strAsString, FqName.ROOT.toUnsafe(), name, null);
        }

        private Companion() {
        }
    }

    static {
        Name nameSpecial = Name.special("<root>");
        nameSpecial.getClass();
        ROOT_NAME = nameSpecial;
        Pattern patternCompile = Pattern.compile("\\.");
        patternCompile.getClass();
        SPLIT_BY_DOTS = patternCompile;
    }

    public FqNameUnsafe(String str, FqName fqName) {
        str.getClass();
        fqName.getClass();
        this.fqName = str;
        this.safe = fqName;
    }

    private final void compute() {
        int iIndexOfLastDotWithBackticksSupport = indexOfLastDotWithBackticksSupport(this.fqName);
        String str = this.fqName;
        if (iIndexOfLastDotWithBackticksSupport >= 0) {
            this.shortName = Name.guessByFirstCharacter(str.substring(iIndexOfLastDotWithBackticksSupport + 1));
            this.parent = new FqNameUnsafe(this.fqName.substring(0, iIndexOfLastDotWithBackticksSupport));
        } else {
            this.shortName = Name.guessByFirstCharacter(str);
            this.parent = FqName.ROOT.toUnsafe();
        }
    }

    private final int indexOfLastDotWithBackticksSupport(String str) {
        int length = str.length() - 1;
        boolean z = false;
        while (length >= 0) {
            char cCharAt = str.charAt(length);
            if (cCharAt == '.' && !z) {
                return length;
            }
            if (cCharAt == '`') {
                z = !z;
            } else if (cCharAt == '\\') {
                length--;
            }
            length--;
        }
        return -1;
    }

    private static final List<Name> pathSegments$collectSegmentsOf(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe.isRoot()) {
            return new ArrayList();
        }
        List<Name> listPathSegments$collectSegmentsOf = pathSegments$collectSegmentsOf(fqNameUnsafe.parent());
        listPathSegments$collectSegmentsOf.add(fqNameUnsafe.shortName());
        return listPathSegments$collectSegmentsOf;
    }

    public final String asString() {
        return this.fqName;
    }

    public final FqNameUnsafe child(Name name) {
        String strAsString;
        name.getClass();
        if (isRoot()) {
            strAsString = name.asString();
        } else {
            strAsString = this.fqName + '.' + name.asString();
        }
        strAsString.getClass();
        return new FqNameUnsafe(strAsString, this, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqNameUnsafe) && Intrinsics.areEqual(this.fqName, ((FqNameUnsafe) obj).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public final boolean isRoot() {
        return this.fqName.length() == 0;
    }

    public final boolean isSafe() {
        return this.safe != null || StringsKt__StringsKt.indexOf$default((CharSequence) asString(), '<', 0, false, 6, (Object) null) < 0;
    }

    public final FqNameUnsafe parent() {
        FqNameUnsafe fqNameUnsafe = this.parent;
        if (fqNameUnsafe != null) {
            return fqNameUnsafe;
        }
        if (isRoot()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("root");
            return null;
        }
        compute();
        FqNameUnsafe fqNameUnsafe2 = this.parent;
        fqNameUnsafe2.getClass();
        return fqNameUnsafe2;
    }

    public final List<Name> pathSegments() {
        return pathSegments$collectSegmentsOf(this);
    }

    public final Name shortName() {
        Name name = this.shortName;
        if (name != null) {
            return name;
        }
        if (isRoot()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("root");
            return null;
        }
        compute();
        Name name2 = this.shortName;
        name2.getClass();
        return name2;
    }

    public final Name shortNameOrSpecial() {
        return isRoot() ? ROOT_NAME : shortName();
    }

    public final boolean startsWith(Name name) {
        name.getClass();
        if (!isRoot()) {
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.fqName, '.', 0, false, 6, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = this.fqName.length();
            }
            String strAsString = name.asString();
            strAsString.getClass();
            if (iIndexOf$default == strAsString.length() && StringsKt__StringsJVMKt.regionMatches$default(this.fqName, 0, strAsString, 0, iIndexOf$default, false, 16, null)) {
                return true;
            }
        }
        return false;
    }

    public final FqName toSafe() {
        FqName fqName = this.safe;
        if (fqName != null) {
            return fqName;
        }
        FqName fqName2 = new FqName(this);
        this.safe = fqName2;
        return fqName2;
    }

    public String toString() {
        if (!isRoot()) {
            return this.fqName;
        }
        String strAsString = ROOT_NAME.asString();
        strAsString.getClass();
        return strAsString;
    }

    public /* synthetic */ FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fqNameUnsafe, name);
    }

    public FqNameUnsafe(String str) {
        str.getClass();
        this.fqName = str;
    }

    private FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name) {
        this.fqName = str;
        this.parent = fqNameUnsafe;
        this.shortName = name;
    }
}
