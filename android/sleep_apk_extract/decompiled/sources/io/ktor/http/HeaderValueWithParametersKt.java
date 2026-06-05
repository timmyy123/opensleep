package io.ktor.http;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\n*\u00020\u00002\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "", "needQuotes", "(Ljava/lang/String;)Z", "isQuoted", ShareConstants.WEB_DIALOG_PARAM_QUOTE, "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "", "quoteTo", "(Ljava/lang/String;Ljava/lang/StringBuilder;)V", "", "", "HeaderFieldValueSeparators", "Ljava/util/Set;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class HeaderValueWithParametersKt {
    private static final Set<Character> HeaderFieldValueSeparators = SetsKt.setOf((Object[]) new Character[]{'(', ')', '<', '>', '@', ',', ';', ':', '\\', Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR), '/', '[', ']', '?', '=', '{', '}', ' ', '\t', '\n', '\r'});

    private static final boolean isQuoted(String str) {
        if (str.length() >= 2 && StringsKt.first(str) == '\"' && StringsKt.last(str) == '\"') {
            int i = 1;
            do {
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default(str, JsonFactory.DEFAULT_QUOTE_CHAR, i, false, 4, (Object) null);
                if (iIndexOf$default == StringsKt.getLastIndex(str)) {
                    break;
                }
                int i2 = 0;
                for (int i3 = iIndexOf$default - 1; str.charAt(i3) == '\\'; i3--) {
                    i2++;
                }
                if (i2 % 2 != 0) {
                    i = iIndexOf$default + 1;
                }
            } while (i < str.length());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean needQuotes(String str) {
        if (str.length() == 0) {
            return true;
        }
        if (isQuoted(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (HeaderFieldValueSeparators.contains(Character.valueOf(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public static final String quote(String str) {
        str.getClass();
        StringBuilder sb = new StringBuilder();
        quoteTo(str, sb);
        return sb.toString();
    }

    private static final void quoteTo(String str, StringBuilder sb) {
        sb.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt != '\\') {
                sb.append(cCharAt);
            } else {
                sb.append("\\\\");
            }
        }
        sb.append("\"");
    }
}
