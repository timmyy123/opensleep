package kotlin.text;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"kotlin/text/StringsKt__AppendableKt", "kotlin/text/StringsKt__IndentKt", "kotlin/text/StringsKt__RegexExtensionsJVMKt", "kotlin/text/StringsKt__RegexExtensionsKt", "kotlin/text/StringsKt__StringBuilderJVMKt", "kotlin/text/StringsKt__StringBuilderKt", "kotlin/text/StringsKt__StringNumberConversionsJVMKt", "kotlin/text/StringsKt__StringNumberConversionsKt", "kotlin/text/StringsKt__StringsJVMKt", "kotlin/text/StringsKt__StringsKt", "kotlin/text/StringsKt___StringsJvmKt", "kotlin/text/StringsKt___StringsKt"}, k = 4, mv = {2, 3, 0}, xi = 49)
public abstract class StringsKt extends StringsKt___StringsKt {
    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence charSequence, String str) {
        return StringsKt__StringsKt.contains$default(charSequence, (CharSequence) str, false, 2, (Object) null);
    }

    public static /* bridge */ /* synthetic */ String replace$default(String str, String str2, String str3) {
        return StringsKt__StringsJVMKt.replace$default(str, str2, str3, false, 4, (Object) null);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, int i, int i2) {
        return StringsKt__StringsKt.split$default(charSequence, strArr, false, i, i2, (Object) null);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(String str, String str2) {
        return StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null);
    }
}
