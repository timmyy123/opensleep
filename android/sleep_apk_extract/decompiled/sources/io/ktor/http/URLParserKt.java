package io.ktor.http;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.share.internal.ShareInternalUtility;
import io.ktor.util.CharsetKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a3\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u000f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u000e\u001a+\u0010\u0012\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000e\u001a'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0019\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0014\" \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/ktor/http/URLBuilder;", "", "urlString", "takeFrom", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "takeFromUnsafe", "", "startIndex", "endIndex", "slashCount", "", "parseFile", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;III)V", "parseMailto", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;II)V", "parseQuery", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;II)I", "parseFragment", "fillHost", "findScheme", "(Ljava/lang/String;II)I", "", "char", "count", "(Ljava/lang/String;IIC)I", "indexOfColonInHostPort", "", "ROOT_PATH", "Ljava/util/List;", "getROOT_PATH", "()Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class URLParserKt {
    private static final List<String> ROOT_PATH = CollectionsKt.listOf("");

    private static final int count(String str, int i, int i2, char c) {
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 >= i2 || str.charAt(i4) != c) {
                break;
            }
            i3++;
        }
        return i3;
    }

    private static final void fillHost(URLBuilder uRLBuilder, String str, int i, int i2) {
        Integer numValueOf = Integer.valueOf(indexOfColonInHostPort(str, i, i2));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : i2;
        uRLBuilder.setHost(str.substring(i, iIntValue));
        int i3 = iIntValue + 1;
        uRLBuilder.setPort(i3 < i2 ? Integer.parseInt(str.substring(i3, i2)) : 0);
    }

    private static final int findScheme(String str, int i, int i2) {
        int i3;
        int i4;
        char cCharAt = str.charAt(i);
        if (('a' > cCharAt || cCharAt >= '{') && ('A' > cCharAt || cCharAt >= '[')) {
            i3 = i;
            i4 = i3;
        } else {
            i3 = i;
            i4 = -1;
        }
        while (i3 < i2) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 == ':') {
                if (i4 == -1) {
                    return i3 - i;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i4, "Illegal character in scheme at position "));
                return 0;
            }
            if (cCharAt2 == '#' || cCharAt2 == '/' || cCharAt2 == '?') {
                break;
            }
            if (i4 == -1 && (('a' > cCharAt2 || cCharAt2 >= '{') && (('A' > cCharAt2 || cCharAt2 >= '[') && (('0' > cCharAt2 || cCharAt2 >= ':') && cCharAt2 != '.' && cCharAt2 != '+' && cCharAt2 != '-')))) {
                i4 = i3;
            }
            i3++;
        }
        return -1;
    }

    public static final List<String> getROOT_PATH() {
        return ROOT_PATH;
    }

    private static final int indexOfColonInHostPort(String str, int i, int i2) {
        boolean z = false;
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ':') {
                if (cCharAt == '[') {
                    z = true;
                } else if (cCharAt == ']') {
                    z = false;
                }
            } else if (!z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static final void parseFile(URLBuilder uRLBuilder, String str, int i, int i2, int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Invalid file url: ", str));
                return;
            } else {
                uRLBuilder.setHost("");
                URLBuilderKt.setEncodedPath(uRLBuilder, MqttTopic.TOPIC_LEVEL_SEPARATOR.concat(str.substring(i, i2)));
                return;
            }
        }
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', i, false, 4, (Object) null);
        if (iIndexOf$default == -1 || iIndexOf$default == i2) {
            uRLBuilder.setHost(str.substring(i, i2));
        } else {
            uRLBuilder.setHost(str.substring(i, iIndexOf$default));
            URLBuilderKt.setEncodedPath(uRLBuilder, str.substring(iIndexOf$default, i2));
        }
    }

    private static final void parseFragment(URLBuilder uRLBuilder, String str, int i, int i2) {
        if (i >= i2 || str.charAt(i) != '#') {
            return;
        }
        uRLBuilder.setEncodedFragment(str.substring(i + 1, i2));
    }

    private static final void parseMailto(URLBuilder uRLBuilder, String str, int i, int i2) {
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default(str, "@", i, false, 4, (Object) null);
        if (iIndexOf$default == -1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Invalid mailto url: ", str, ", it should contain '@'."));
        } else {
            uRLBuilder.setUser(CodecsKt.decodeURLPart$default(str.substring(i, iIndexOf$default), 0, 0, null, 7, null));
            uRLBuilder.setHost(str.substring(iIndexOf$default + 1, i2));
        }
    }

    private static final int parseQuery(URLBuilder uRLBuilder, String str, int i, int i2) {
        int i3 = i + 1;
        if (i3 == i2) {
            uRLBuilder.setTrailingQuery(true);
            return i2;
        }
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '#', i3, false, 4, (Object) null);
        Integer numValueOf = Integer.valueOf(iIndexOf$default);
        if (iIndexOf$default <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            i2 = numValueOf.intValue();
        }
        QueryKt.parseQueryString$default(str.substring(i3, i2), 0, 0, false, 6, null).forEach(new URLParserKt$$ExternalSyntheticLambda0(uRLBuilder, 0));
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit parseQuery$lambda$5(URLBuilder uRLBuilder, String str, List list) {
        str.getClass();
        list.getClass();
        uRLBuilder.getEncodedParameters().appendAll(str, list);
        return Unit.INSTANCE;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, String str) {
        uRLBuilder.getClass();
        str.getClass();
        if (StringsKt.isBlank(str)) {
            return uRLBuilder;
        }
        try {
            return takeFromUnsafe(uRLBuilder, str);
        } catch (Throwable th) {
            throw new URLParserException(str, th);
        }
    }

    public static final URLBuilder takeFromUnsafe(URLBuilder uRLBuilder, String str) {
        int iIntValue;
        uRLBuilder.getClass();
        str.getClass();
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!CharsKt.isWhitespace(str.charAt(i))) {
                break;
            }
            i++;
        }
        int length2 = str.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                if (!CharsKt.isWhitespace(str.charAt(length2))) {
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
            length2 = -1;
        } else {
            length2 = -1;
        }
        int i3 = length2 + 1;
        int iFindScheme = findScheme(str, i, i3);
        if (iFindScheme > 0) {
            uRLBuilder.setProtocol(URLProtocol.INSTANCE.createOrDefault(str.substring(i, i + iFindScheme)));
            i += iFindScheme + 1;
        }
        int iCount = count(str, i, i3, '/');
        int query = i + iCount;
        if (Intrinsics.areEqual(uRLBuilder.getProtocol().getName(), ShareInternalUtility.STAGING_PARAM)) {
            parseFile(uRLBuilder, str, query, i3, iCount);
            return uRLBuilder;
        }
        if (Intrinsics.areEqual(uRLBuilder.getProtocol().getName(), "mailto")) {
            if (iCount == 0) {
                parseMailto(uRLBuilder, str, query, i3);
                return uRLBuilder;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
            return null;
        }
        if (Intrinsics.areEqual(uRLBuilder.getProtocol().getName(), "about")) {
            if (iCount == 0) {
                uRLBuilder.setHost(str.substring(query, i3));
                return uRLBuilder;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
            return null;
        }
        if (iCount >= 2) {
            while (true) {
                int iIndexOfAny$default = StringsKt__StringsKt.indexOfAny$default(str, CharsetKt.toCharArray("@/\\?#"), query, false, 4, null);
                Integer numValueOf = Integer.valueOf(iIndexOfAny$default);
                if (iIndexOfAny$default <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : i3;
                if (iIntValue >= i3 || str.charAt(iIntValue) != '@') {
                    break;
                }
                int iIndexOfColonInHostPort = indexOfColonInHostPort(str, query, iIntValue);
                if (iIndexOfColonInHostPort != -1) {
                    uRLBuilder.setEncodedUser(str.substring(query, iIndexOfColonInHostPort));
                    uRLBuilder.setEncodedPassword(str.substring(iIndexOfColonInHostPort + 1, iIntValue));
                } else {
                    uRLBuilder.setEncodedUser(str.substring(query, iIntValue));
                }
                query = iIntValue + 1;
            }
            fillHost(uRLBuilder, str, query, iIntValue);
            query = iIntValue;
        }
        if (query >= i3) {
            uRLBuilder.setEncodedPathSegments(str.charAt(length2) == '/' ? ROOT_PATH : CollectionsKt.emptyList());
            return uRLBuilder;
        }
        uRLBuilder.setEncodedPathSegments(iCount == 0 ? CollectionsKt.dropLast(uRLBuilder.getEncodedPathSegments(), 1) : CollectionsKt.emptyList());
        int iIndexOfAny$default2 = StringsKt__StringsKt.indexOfAny$default(str, CharsetKt.toCharArray("?#"), query, false, 4, null);
        Integer numValueOf2 = iIndexOfAny$default2 > 0 ? Integer.valueOf(iIndexOfAny$default2) : null;
        int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : i3;
        if (iIntValue2 > query) {
            String strSubstring = str.substring(query, iIntValue2);
            uRLBuilder.setEncodedPathSegments(CollectionsKt.plus((Collection) ((uRLBuilder.getEncodedPathSegments().size() == 1 && ((CharSequence) CollectionsKt.first((List) uRLBuilder.getEncodedPathSegments())).length() == 0) ? CollectionsKt.emptyList() : uRLBuilder.getEncodedPathSegments()), (Iterable) CollectionsKt.plus((Collection) (iCount == 1 ? ROOT_PATH : CollectionsKt.emptyList()), (Iterable) (Intrinsics.areEqual(strSubstring, MqttTopic.TOPIC_LEVEL_SEPARATOR) ? ROOT_PATH : StringsKt__StringsKt.split$default(strSubstring, new char[]{'/'}, false, 0, 6, (Object) null)))));
            query = iIntValue2;
        }
        if (query < i3 && str.charAt(query) == '?') {
            query = parseQuery(uRLBuilder, str, query, i3);
        }
        parseFragment(uRLBuilder, str, query, i3);
        return uRLBuilder;
    }
}
