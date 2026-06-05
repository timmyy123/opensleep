package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0003"}, d2 = {"fromCamelCaseToScreamingSnakeCase", "", "toPascalCase", "appfunctions-compiler"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class StringUtilsKt {
    public static final String fromCamelCaseToScreamingSnakeCase(String str) {
        str.getClass();
        if (fromCamelCaseToScreamingSnakeCase$isFullyCapitalized(str)) {
            return str;
        }
        String upperCase = new Regex("(?<=[a-zA-Z])[A-Z]").replace(str, new StringUtilsKt$$ExternalSyntheticLambda0(0)).toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return upperCase;
    }

    private static final boolean fromCamelCaseToScreamingSnakeCase$isFullyCapitalized(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return Intrinsics.areEqual(str, upperCase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence fromCamelCaseToScreamingSnakeCase$lambda$0(MatchResult matchResult) {
        matchResult.getClass();
        return FileInsert$$ExternalSyntheticOutline0.m("_", matchResult.getValue());
    }

    public static final String toPascalCase(String str) {
        str.getClass();
        if (str.length() == 0) {
            return "";
        }
        List<String> listSplit = new Regex("[._/-]+|\\s+").split(str, 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, "", null, null, new StringUtilsKt$$ExternalSyntheticLambda0(20), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toPascalCase$lambda$1(String str) {
        str.getClass();
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        if (lowerCase.length() <= 0) {
            return lowerCase;
        }
        StringBuilder sb = new StringBuilder();
        String strValueOf = String.valueOf(lowerCase.charAt(0));
        strValueOf.getClass();
        String upperCase = strValueOf.toUpperCase(locale);
        upperCase.getClass();
        sb.append((Object) upperCase);
        sb.append(lowerCase.substring(1));
        return sb.toString();
    }
}
