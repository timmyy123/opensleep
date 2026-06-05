package kotlin.reflect.jvm.internal.impl.renderer;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RenderingUtilsKt {
    public static final String render(Name name, boolean z) {
        name.getClass();
        String strAsStringStripSpecialMarkers = z ? name.asStringStripSpecialMarkers() : name.asString();
        strAsStringStripSpecialMarkers.getClass();
        if ((z && name.isSpecial()) || !shouldBeEscaped(strAsStringStripSpecialMarkers)) {
            return strAsStringStripSpecialMarkers;
        }
        return ("`" + strAsStringStripSpecialMarkers).concat("`");
    }

    public static /* synthetic */ String render$default(Name name, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return render(name, z);
    }

    public static final String renderFlexibleMutabilityOrArrayElementVarianceType(String str, String str2, Function0<String> function0, Function0<String> function02, Function1<? super String, String> function1) {
        str.getClass();
        str2.getClass();
        function0.getClass();
        function02.getClass();
        function1.getClass();
        String strInvoke = function0.invoke();
        String strReplacePrefixesInTypeRepresentations = replacePrefixesInTypeRepresentations(str, FileInsert$$ExternalSyntheticOutline0.m$1(strInvoke, "Mutable"), str2, strInvoke, FileInsert$$ExternalSyntheticOutline0.m$1(strInvoke, "(Mutable)"));
        if (strReplacePrefixesInTypeRepresentations != null) {
            return strReplacePrefixesInTypeRepresentations;
        }
        String strReplacePrefixesInTypeRepresentations2 = replacePrefixesInTypeRepresentations(str, FileInsert$$ExternalSyntheticOutline0.m$1(strInvoke, "MutableMap.MutableEntry"), str2, FileInsert$$ExternalSyntheticOutline0.m$1(strInvoke, "Map.Entry"), FileInsert$$ExternalSyntheticOutline0.m$1(strInvoke, "(Mutable)Map.(Mutable)Entry"));
        if (strReplacePrefixesInTypeRepresentations2 != null) {
            return strReplacePrefixesInTypeRepresentations2;
        }
        String strInvoke2 = function02.invoke();
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(strInvoke2);
        sbM.append(function1.invoke("Array<"));
        String string = sbM.toString();
        StringBuilder sbM2 = FileInsert$$ExternalSyntheticOutline0.m(strInvoke2);
        sbM2.append(function1.invoke("Array<out "));
        String string2 = sbM2.toString();
        StringBuilder sbM3 = FileInsert$$ExternalSyntheticOutline0.m(strInvoke2);
        sbM3.append(function1.invoke("Array<(out) "));
        String strReplacePrefixesInTypeRepresentations3 = replacePrefixesInTypeRepresentations(str, string, str2, string2, sbM3.toString());
        if (strReplacePrefixesInTypeRepresentations3 != null) {
            return strReplacePrefixesInTypeRepresentations3;
        }
        return null;
    }

    public static /* synthetic */ String renderFlexibleMutabilityOrArrayElementVarianceType$default(String str, String str2, Function0 function0, Function0 function02, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj2) {
                    return RenderingUtilsKt.renderFlexibleMutabilityOrArrayElementVarianceType$lambda$0((String) obj2);
                }
            };
        }
        return renderFlexibleMutabilityOrArrayElementVarianceType(str, str2, function0, function02, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleMutabilityOrArrayElementVarianceType$lambda$0(String str) {
        str.getClass();
        return str;
    }

    public static final String renderFqName(List<Name> list) {
        list.getClass();
        StringBuilder sb = new StringBuilder();
        for (Name name : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render$default(name, false, 1, null));
        }
        return sb.toString();
    }

    public static final String replacePrefixesInTypeRepresentations(String str, String str2, String str3, String str4, String str5) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        if (!StringsKt.startsWith$default(str, str2) || !StringsKt.startsWith$default(str3, str4)) {
            return null;
        }
        String strSubstring = str.substring(str2.length());
        String strSubstring2 = str3.substring(str4.length());
        String strConcat = str5.concat(strSubstring);
        if (Intrinsics.areEqual(strSubstring, strSubstring2)) {
            return strConcat;
        }
        if (typeStringsDifferOnlyInNullability(strSubstring, strSubstring2)) {
            return strConcat.concat("!");
        }
        return null;
    }

    private static final boolean shouldBeEscaped(String str) {
        if (KeywordStringsGenerated.KEYWORDS.contains(str)) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                return true;
            }
        }
        return str.length() == 0 || !Character.isJavaIdentifierStart(str.codePointAt(0));
    }

    public static final boolean typeStringsDifferOnlyInNullability(String str, String str2) {
        str.getClass();
        str2.getClass();
        if (Intrinsics.areEqual(str, StringsKt.replace$default(str2, "?", ""))) {
            return true;
        }
        if (StringsKt__StringsJVMKt.endsWith$default(str2, "?", false, 2, null) && Intrinsics.areEqual(str.concat("?"), str2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(str);
        sb.append(")?");
        return Intrinsics.areEqual(sb.toString(), str2);
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        fqNameUnsafe.getClass();
        return renderFqName(fqNameUnsafe.pathSegments());
    }
}
