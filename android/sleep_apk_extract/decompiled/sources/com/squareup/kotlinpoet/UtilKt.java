package com.squareup.kotlinpoet;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.work.Data$$ExternalSyntheticLambda0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareInternalUtility;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.squareup.kotlinpoet.CodeBlock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a7\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a1\u0010\u0012\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\rH\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a1\u0010\u0015\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\rH\u0000¢\u0006\u0004\b\u0015\u0010\u0013\u001aY\u0010\u001d\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0005*\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a3\u0010 \u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\"\u00028\u0000H\u0000¢\u0006\u0004\b \u0010!\u001a\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b%\u0010&\u001a\u0017\u0010(\u001a\u00020$2\u0006\u0010'\u001a\u00020$H\u0000¢\u0006\u0004\b(\u0010)\u001a+\u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020$2\b\b\u0002\u0010+\u001a\u00020\u001c2\b\b\u0002\u0010,\u001a\u00020\u001cH\u0000¢\u0006\u0004\b-\u0010.\u001a\u0013\u00100\u001a\u00020/*\u00020/H\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u00103\u001a\u00020/*\u00020/2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b3\u00104\u001a\u0013\u00105\u001a\u00020\u0011*\u00020$H\u0002¢\u0006\u0004\b5\u00106\u001a\u001d\u00108\u001a\u00020$*\u00020$2\b\b\u0002\u00107\u001a\u00020\u001cH\u0000¢\u0006\u0004\b8\u00109\u001a\u001d\u0010:\u001a\u00020$*\u00020$2\b\b\u0002\u00107\u001a\u00020\u001cH\u0000¢\u0006\u0004\b:\u00109\u001a\u0013\u0010;\u001a\u00020\u001c*\u00020$H\u0002¢\u0006\u0004\b;\u0010<\u001a\u0013\u0010=\u001a\u00020$*\u00020$H\u0002¢\u0006\u0004\b=\u0010)\u001a\u0013\u0010>\u001a\u00020$*\u00020$H\u0002¢\u0006\u0004\b>\u0010)\u001a\u0013\u0010?\u001a\u00020$*\u00020$H\u0002¢\u0006\u0004\b?\u0010)\u001a\u0013\u0010@\u001a\u00020$*\u00020$H\u0002¢\u0006\u0004\b@\u0010)\u001a\u001d\u0010B\u001a\u00020$*\u00020$2\b\b\u0002\u0010A\u001a\u00020\"H\u0000¢\u0006\u0004\bB\u0010C\"\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F\" \u0010G\u001a\b\u0012\u0004\u0012\u00020$0\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\"0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010H\"\u0018\u0010L\u001a\u00020\u001c*\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M\"\u0018\u0010N\u001a\u00020\u001c*\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010<\"\u0018\u0010O\u001a\u00020\u001c*\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010<\"\u0018\u0010Q\u001a\u00020\u001c*\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bP\u0010<\"\u0018\u0010S\u001a\u00020\u001c*\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bR\u0010<¨\u0006T"}, d2 = {"K", "V", "", "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "T", "", "", "toImmutableList", "(Ljava/util/Collection;)Ljava/util/List;", "", "toImmutableSet", "(Ljava/util/Collection;)Ljava/util/Set;", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "", "mutuallyExclusive", "", "requireNoneOrOneOf", "(Ljava/util/Set;[Lcom/squareup/kotlinpoet/KModifier;)V", "forbidden", "requireNoneOf", "t1", "t2", "t3", "t4", "t5", "t6", "", "isOneOf", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "t", "containsAnyOf", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "c", "", "characterLiteralWithoutSingleQuotes", "(C)Ljava/lang/String;", "s", "escapeCharacterLiterals", "(Ljava/lang/String;)Ljava/lang/String;", SDKConstants.PARAM_VALUE, "isInsideRawString", "isConstantContext", "stringLiteralWithQuotes", "(Ljava/lang/String;ZZ)Ljava/lang/String;", "Lcom/squareup/kotlinpoet/CodeBlock;", "ensureEndsWithNewLine", "(Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/CodeBlock;", "replaceWith", "trimTrailingNewLine", "(Lcom/squareup/kotlinpoet/CodeBlock;Ljava/lang/Character;)Lcom/squareup/kotlinpoet/CodeBlock;", "failIfEscapeInvalid", "(Ljava/lang/String;)V", "validate", "escapeIfNecessary", "(Ljava/lang/String;Z)Ljava/lang/String;", "escapeAsAlias", "alreadyEscaped", "(Ljava/lang/String;)Z", "escapeIfKeyword", "escapeIfHasAllowedCharacters", "escapeIfAllCharactersAreUnderscore", "escapeIfNotJavaIdentifier", "delimiter", "escapeSegmentsIfNecessary", "(Ljava/lang/String;C)Ljava/lang/String;", "Lkotlin/text/Regex;", "IDENTIFIER_REGEX", "Lkotlin/text/Regex;", "KEYWORDS", "Ljava/util/Set;", "getKEYWORDS", "()Ljava/util/Set;", "ILLEGAL_CHARACTERS_TO_ESCAPE", "isIsoControl", "(C)Z", "isIdentifier", "isKeyword", "getHasAllowedCharacters", "hasAllowedCharacters", "getAllCharactersAreUnderscore", "allCharactersAreUnderscore", "kotlinpoet"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class UtilKt {
    private static final Regex IDENTIFIER_REGEX = new Regex("((\\p{gc=Lu}+|\\p{gc=Ll}+|\\p{gc=Lt}+|\\p{gc=Lm}+|\\p{gc=Lo}+|\\p{gc=Nl}+)+\\d*\\p{gc=Lu}*\\p{gc=Ll}*\\p{gc=Lt}*\\p{gc=Lm}*\\p{gc=Lo}*\\p{gc=Nl}*)|(`[^\n\r`]+`)");
    private static final Set<String> KEYWORDS = SetsKt.setOf((Object[]) new String[]{"as", "break", "class", "continue", "do", "else", "false", "for", "fun", "if", "in", "interface", "is", "null", "object", "package", "return", "super", "this", "throw", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, "try", "typealias", "typeof", "val", "var", "when", "while", "by", "catch", "constructor", "delegate", "dynamic", "field", ShareInternalUtility.STAGING_PARAM, "finally", "get", "import", "init", "param", "property", "receiver", "set", "setparam", "where", "actual", "abstract", "annotation", "companion", "const", "crossinline", "data", "enum", "expect", "external", "final", "infix", "inline", "inner", "internal", "lateinit", "noinline", "open", "operator", "out", "override", "private", "protected", "public", "reified", "sealed", "suspend", "tailrec", SDKConstants.PARAM_VALUE, "vararg", "header", "impl", "yield"});
    private static final Set<Character> ILLEGAL_CHARACTERS_TO_ESCAPE = SetsKt.setOf((Object[]) new Character[]{'.', ';', '[', ']', '/', '<', '>', ':', '\\'});

    private static final boolean alreadyEscaped(String str) {
        return StringsKt.startsWith$default(str, "`") && StringsKt__StringsJVMKt.endsWith$default(str, "`", false, 2, null);
    }

    public static final String characterLiteralWithoutSingleQuotes(char c) {
        if (c == '\b') {
            return "\\b";
        }
        if (c == '\t') {
            return "\\t";
        }
        if (c == '\n') {
            return "\\n";
        }
        if (c == '\r') {
            return "\\r";
        }
        if (c == '\"') {
            return "\"";
        }
        if (c == '\'') {
            return "\\'";
        }
        if (c == '\\') {
            return "\\\\";
        }
        if (!isIsoControl(c)) {
            return String.valueOf(c);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(c)}, 1));
    }

    public static final <T> boolean containsAnyOf(Collection<? extends T> collection, T... tArr) {
        collection.getClass();
        tArr.getClass();
        for (T t : tArr) {
            if (collection.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public static final CodeBlock ensureEndsWithNewLine(CodeBlock codeBlock) {
        codeBlock.getClass();
        return trimTrailingNewLine(codeBlock, '\n');
    }

    public static final String escapeAsAlias(String str, boolean z) {
        str.getClass();
        if (getAllCharactersAreUnderscore(str)) {
            return str.concat(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (isKeyword(str)) {
            return "__".concat(str);
        }
        StringBuilder sb = new StringBuilder("");
        if (!Character.isJavaIdentifierStart(StringsKt.first(str))) {
            sb.append('_');
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '$') {
                sb.append("__");
            } else if (Character.isJavaIdentifierPart(cCharAt)) {
                sb.append(cCharAt);
            } else {
                sb.append("_U");
                String hexString = Integer.toHexString(cCharAt);
                hexString.getClass();
                sb.append(StringsKt__StringsKt.padStart(hexString, 4, '0'));
            }
        }
        String string = sb.toString();
        if (z) {
            failIfEscapeInvalid(string);
        }
        return string;
    }

    public static /* synthetic */ String escapeAsAlias$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return escapeAsAlias(str, z);
    }

    public static final String escapeCharacterLiterals(String str) {
        str.getClass();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            sb.append(characterLiteralWithoutSingleQuotes(str.charAt(i)));
        }
        return sb.toString();
    }

    private static final String escapeIfAllCharactersAreUnderscore(String str) {
        return (!getAllCharactersAreUnderscore(str) || alreadyEscaped(str)) ? str : Fragment$$ExternalSyntheticOutline1.m('`', "`", str);
    }

    private static final String escapeIfHasAllowedCharacters(String str) {
        return (!getHasAllowedCharacters(str) || alreadyEscaped(str)) ? str : Fragment$$ExternalSyntheticOutline1.m('`', "`", str);
    }

    private static final String escapeIfKeyword(String str) {
        return (!isKeyword(str) || alreadyEscaped(str)) ? str : Fragment$$ExternalSyntheticOutline1.m('`', "`", str);
    }

    public static final String escapeIfNecessary(String str, boolean z) {
        str.getClass();
        String strEscapeIfAllCharactersAreUnderscore = escapeIfAllCharactersAreUnderscore(escapeIfHasAllowedCharacters(escapeIfKeyword(escapeIfNotJavaIdentifier(str))));
        if (z) {
            failIfEscapeInvalid(strEscapeIfAllCharactersAreUnderscore);
        }
        return strEscapeIfAllCharactersAreUnderscore;
    }

    public static /* synthetic */ String escapeIfNecessary$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return escapeIfNecessary(str, z);
    }

    private static final String escapeIfNotJavaIdentifier(String str) {
        if (Character.isJavaIdentifierStart(StringsKt.first(str))) {
            String strDrop = StringsKt___StringsKt.drop(str, 1);
            for (int i = 0; i < strDrop.length(); i++) {
                if (Character.isJavaIdentifierPart(strDrop.charAt(i))) {
                }
            }
            return str;
        }
        return !alreadyEscaped(str) ? Fragment$$ExternalSyntheticOutline1.m('`', "`", str) : str;
    }

    public static final String escapeSegmentsIfNecessary(String str, char c) {
        str.getClass();
        List listSplit$default = StringsKt__StringsKt.split$default(str, new char[]{c}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, String.valueOf(c), null, null, new Data$$ExternalSyntheticLambda0(26), 30);
    }

    public static /* synthetic */ String escapeSegmentsIfNecessary$default(String str, char c, int i, Object obj) {
        if ((i & 1) != 0) {
            c = '.';
        }
        return escapeSegmentsIfNecessary(str, c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence escapeSegmentsIfNecessary$lambda$15(String str) {
        str.getClass();
        return escapeIfNecessary$default(str, false, 1, null);
    }

    private static final void failIfEscapeInvalid(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            Set<Character> set = ILLEGAL_CHARACTERS_TO_ESCAPE;
            if (set.contains(Character.valueOf(cCharAt))) {
                Utf8$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m5m("Can't escape identifier ", str, " because it contains illegal characters: "), CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.intersect(set, StringsKt___StringsKt.toSet(str)), "", null, null, null, 62));
                return;
            }
        }
    }

    public static final boolean getAllCharactersAreUnderscore(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '_') {
                return false;
            }
        }
        return true;
    }

    public static final boolean getHasAllowedCharacters(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '$') {
                return true;
            }
        }
        return false;
    }

    public static final boolean isIdentifier(String str) {
        str.getClass();
        return IDENTIFIER_REGEX.matches(str);
    }

    private static final boolean isIsoControl(char c) {
        if (c < 0 || c >= ' ') {
            return 127 <= c && c < 160;
        }
        return true;
    }

    public static final boolean isKeyword(String str) {
        str.getClass();
        return KEYWORDS.contains(str);
    }

    public static final <T> boolean isOneOf(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return Intrinsics.areEqual(t, t2) || Intrinsics.areEqual(t, t3) || Intrinsics.areEqual(t, t4) || Intrinsics.areEqual(t, t5) || Intrinsics.areEqual(t, t6) || Intrinsics.areEqual(t, t7);
    }

    public static /* synthetic */ boolean isOneOf$default(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, int i, Object obj8) {
        if ((i & 4) != 0) {
            obj4 = null;
        }
        if ((i & 8) != 0) {
            obj5 = null;
        }
        if ((i & 16) != 0) {
            obj6 = null;
        }
        if ((i & 32) != 0) {
            obj7 = null;
        }
        return isOneOf(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static final void requireNoneOf(Set<? extends KModifier> set, KModifier... kModifierArr) {
        set.getClass();
        kModifierArr.getClass();
        for (KModifier kModifier : kModifierArr) {
            if (set.contains(kModifier)) {
                StringBuilder sb = new StringBuilder("modifiers ");
                sb.append(set);
                String string = Arrays.toString(kModifierArr);
                string.getClass();
                Home$$ExternalSyntheticBUOutline0.m$1(sb, " must contain none of ", string);
                return;
            }
        }
    }

    public static final void requireNoneOrOneOf(Set<? extends KModifier> set, KModifier... kModifierArr) {
        set.getClass();
        kModifierArr.getClass();
        int i = 0;
        for (KModifier kModifier : kModifierArr) {
            if (set.contains(kModifier)) {
                i++;
            }
        }
        if (i <= 1) {
            return;
        }
        StringBuilder sb = new StringBuilder("modifiers ");
        sb.append(set);
        String string = Arrays.toString(kModifierArr);
        string.getClass();
        Home$$ExternalSyntheticBUOutline0.m$1(sb, " must contain none or only one of ", string);
    }

    public static final String stringLiteralWithQuotes(String str, boolean z, boolean z2) {
        str.getClass();
        int i = 0;
        if (!z2 && StringsKt__StringsKt.contains$default((CharSequence) str, '\n', false, 2, (Object) null)) {
            StringBuilder sb = new StringBuilder(str.length() + 32);
            sb.append("\"\"\"\n|");
            while (i < str.length()) {
                char cCharAt = str.charAt(i);
                if (StringsKt__StringsJVMKt.regionMatches$default(str, i, "\"\"\"", 0, 3, false, 16, null)) {
                    sb.append("\"\"${'\"'}");
                    i += 2;
                } else if (cCharAt == '\n') {
                    sb.append("\n|");
                } else if (cCharAt != '$' || z) {
                    sb.append(cCharAt);
                } else {
                    sb.append("${'$'}");
                }
                i++;
            }
            if (!StringsKt__StringsJVMKt.endsWith$default(str, "\n", false, 2, null)) {
                sb.append("\n");
            }
            sb.append("\"\"\".trimMargin()");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 32);
        if (z) {
            sb2.append("\"\"\"");
        } else {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        int length = str.length();
        while (i < length) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 == '\'') {
                sb2.append("'");
            } else if (cCharAt2 == '\"' && !z) {
                sb2.append("\\\"");
            } else if (cCharAt2 != '$' || z) {
                sb2.append(z ? Character.valueOf(cCharAt2) : characterLiteralWithoutSingleQuotes(cCharAt2));
            } else {
                sb2.append("${'$'}");
            }
            i++;
        }
        if (z) {
            sb2.append("\"\"\"");
        } else {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb2.toString();
    }

    public static final <T> List<T> toImmutableList(Collection<? extends T> collection) {
        collection.getClass();
        List<T> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(collection));
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        map.getClass();
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    public static final <T> Set<T> toImmutableSet(Collection<? extends T> collection) {
        collection.getClass();
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(new LinkedHashSet(collection));
        setUnmodifiableSet.getClass();
        return setUnmodifiableSet;
    }

    public static final CodeBlock trimTrailingNewLine(CodeBlock codeBlock, Character ch) {
        codeBlock.getClass();
        if (codeBlock.isEmpty()) {
            return codeBlock;
        }
        CodeBlock.Builder builder = codeBlock.toBuilder();
        String str = (String) CollectionsKt.last((List) codeBlock.trim$kotlinpoet().getFormatParts$kotlinpoet());
        if (!CodeBlock.Companion.isPlaceholder$kotlinpoet(str) || builder.getArgs$kotlinpoet().isEmpty()) {
            builder.getFormatParts$kotlinpoet().set(builder.getFormatParts$kotlinpoet().lastIndexOf(str), StringsKt.trimEnd(str, '\n'));
            if (ch != null) {
                builder.getFormatParts$kotlinpoet().add(String.valueOf(ch));
            }
        } else {
            Object objLast = CollectionsKt.last((List<? extends Object>) builder.getArgs$kotlinpoet());
            if (objLast instanceof String) {
                String strTrimEnd = StringsKt.trimEnd((String) objLast, '\n');
                List<Object> args$kotlinpoet = builder.getArgs$kotlinpoet();
                int size = builder.getArgs$kotlinpoet().size() - 1;
                if (ch != null) {
                    strTrimEnd = strTrimEnd + ch;
                }
                args$kotlinpoet.set(size, strTrimEnd);
            }
        }
        return builder.build();
    }

    public static /* synthetic */ CodeBlock trimTrailingNewLine$default(CodeBlock codeBlock, Character ch, int i, Object obj) {
        if ((i & 1) != 0) {
            ch = null;
        }
        return trimTrailingNewLine(codeBlock, ch);
    }
}
