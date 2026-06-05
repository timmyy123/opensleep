package androidx.appfunctions.compiler.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\u001a\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"PARAM_TAG_REGEX_PATTERN", "", "RESPONSE_TAG_REGEX_PATTERN", "ANY_TAG_REGEX_PATTERN", "KOTLIN_SUPPORTED_TAGS_PATTERN", "PARAM_TAG_REGEX", "Lkotlin/text/Regex;", "RESPONSE_TAG_REGEX", "ANY_TAG_REGEX", "KOTLIN_SUPPORTED_TAGS", "getParamDescriptionsFromKDoc", "", "docString", "getResponseDescriptionFromKDoc", "sanitizeKDoc", "appfunctions-compiler"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DocstringUtilsKt {
    private static final String PARAM_TAG_REGEX_PATTERN = "^@param\\s+(\\w+)\\s*(.*)";
    private static final Regex PARAM_TAG_REGEX = new Regex(PARAM_TAG_REGEX_PATTERN);
    private static final String RESPONSE_TAG_REGEX_PATTERN = "^@return\\s+(.*)";
    private static final Regex RESPONSE_TAG_REGEX = new Regex(RESPONSE_TAG_REGEX_PATTERN);
    private static final String ANY_TAG_REGEX_PATTERN = "^@\\w+.*";
    private static final Regex ANY_TAG_REGEX = new Regex(ANY_TAG_REGEX_PATTERN);
    private static final String KOTLIN_SUPPORTED_TAGS_PATTERN = "^@(param|return|constructor|receiver|property|throws|exception|sample|see|author|since|suppress)\\b.*";
    private static final Regex KOTLIN_SUPPORTED_TAGS = new Regex(KOTLIN_SUPPORTED_TAGS_PATTERN);

    public static final Map<String, String> getParamDescriptionsFromKDoc(String str) {
        str.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        StringBuilder sb = new StringBuilder();
        Iterator it = StringsKt__StringsKt.lines(str).iterator();
        while (true) {
            String str2 = null;
            while (it.hasNext()) {
                String string = StringsKt.trim((String) it.next()).toString();
                MatchResult matchResultFind$default = Regex.find$default(PARAM_TAG_REGEX, string, 0, 2, null);
                if (matchResultFind$default != null) {
                    if (str2 != null) {
                        linkedHashMap.put(str2, StringsKt.trim(sb.toString()).toString());
                        StringsKt__StringBuilderJVMKt.clear(sb);
                    }
                    String str3 = matchResultFind$default.getGroupValues().get(1);
                    if (str3 == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    str2 = str3;
                    String str4 = matchResultFind$default.getGroupValues().get(2);
                    if (str4 == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    sb.append(str4);
                } else if (ANY_TAG_REGEX.matches(string)) {
                    if (str2 != null) {
                        break;
                    }
                } else if (str2 != null && !StringsKt.isBlank(string)) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(string);
                }
            }
            if (str2 != null) {
                linkedHashMap.put(str2, StringsKt.trim(sb.toString()).toString());
            }
            return linkedHashMap;
            linkedHashMap.put(str2, StringsKt.trim(sb.toString()).toString());
            StringsKt__StringBuilderJVMKt.clear(sb);
        }
    }

    public static final String getResponseDescriptionFromKDoc(String str) {
        str.getClass();
        StringBuilder sb = new StringBuilder();
        Iterator it = StringsKt__StringsKt.lines(str).iterator();
        while (it.hasNext()) {
            String string = StringsKt.trim((String) it.next()).toString();
            MatchResult matchResultFind$default = Regex.find$default(RESPONSE_TAG_REGEX, string, 0, 2, null);
            if (matchResultFind$default != null) {
                String str2 = matchResultFind$default.getGroupValues().get(1);
                if (str2 == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                    return null;
                }
                sb.append(str2);
            } else if (sb.length() <= 0) {
                continue;
            } else {
                if (ANY_TAG_REGEX.matches(string)) {
                    return sb.toString();
                }
                sb.append(" " + string);
            }
        }
        return StringsKt.trim(sb.toString()).toString();
    }

    public static final String sanitizeKDoc(String str) {
        str.getClass();
        ArrayList arrayList = new ArrayList();
        while (true) {
            boolean z = false;
            for (String str2 : StringsKt__StringsKt.lines(str)) {
                String string = StringsKt.trim(str2).toString();
                Regex regex = KOTLIN_SUPPORTED_TAGS;
                if (regex.matches(string)) {
                    z = true;
                } else if (!z || !ANY_TAG_REGEX.matches(string) || regex.matches(string)) {
                    if (!z) {
                        arrayList.add(str2);
                    }
                }
            }
            return StringsKt.trim(CollectionsKt.joinToString$default(arrayList, "\n", null, null, null, 62)).toString();
            arrayList.add(str2);
        }
    }
}
