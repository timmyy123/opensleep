package kotlinx.serialization.json.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0018J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0012H&¢\u0006\u0004\b\u000f\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u001a\u0010\u0019J!\u0010 \u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u0010J\u0017\u0010#\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\tH&¢\u0006\u0004\b%\u0010&J!\u0010*\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0006H&¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0004¢\u0006\u0004\b.\u0010\u0003J\u001f\u00101\u001a\u00020'2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020'H&¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020'¢\u0006\u0004\b5\u00104J'\u00105\u001a\u00020'2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0005¢\u0006\u0004\b5\u0010:J\r\u0010;\u001a\u00020'¢\u0006\u0004\b;\u00104J\r\u0010<\u001a\u00020'¢\u0006\u0004\b<\u00104J\u001f\u0010?\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0014¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0006¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020'H\u0016¢\u0006\u0004\bD\u00104J\u0015\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020'¢\u0006\u0004\bF\u0010GJ)\u0010 \u001a\u00020\u001d2\u0006\u0010H\u001a\u00020'2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010I\u001a\u00020'¢\u0006\u0004\b \u0010JJ\r\u0010L\u001a\u00020K¢\u0006\u0004\bL\u0010MJ\r\u0010N\u001a\u00020\u0006¢\u0006\u0004\bN\u0010\bJ\u001f\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010QJ\u001f\u0010S\u001a\u00020'2\u0006\u0010O\u001a\u00020\t2\u0006\u0010R\u001a\u00020\tH\u0002¢\u0006\u0004\bS\u00102J\u000f\u0010T\u001a\u00020'H\u0002¢\u0006\u0004\bT\u00104J\u000f\u0010U\u001a\u00020\u0006H\u0002¢\u0006\u0004\bU\u0010\bJ\u0017\u0010V\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0002¢\u0006\u0004\bV\u0010\fJ\u001f\u0010W\u001a\u00020\t2\u0006\u00107\u001a\u0002062\u0006\u0010/\u001a\u00020\tH\u0002¢\u0006\u0004\bW\u0010XJ\u001f\u0010Y\u001a\u00020\t2\u0006\u00107\u001a\u0002062\u0006\u0010R\u001a\u00020\tH\u0002¢\u0006\u0004\bY\u0010XJ\u0017\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\tH\u0003¢\u0006\u0004\b[\u0010\\J\u001f\u0010^\u001a\u00020\u00042\u0006\u0010]\u001a\u00020'2\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0004\b^\u0010_R\u0016\u0010R\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bR\u0010`R\u0014\u0010b\u001a\u00020a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR&\u0010h\u001a\u00060fj\u0002`g8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0014\u00107\u001a\u0002068$X¤\u0004¢\u0006\u0006\u001a\u0004\bn\u0010o¨\u0006p"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "<init>", "()V", "", "ensureHaveChars", "", "isNotEof", "()Z", "", "position", "prefetchOrEof", "(I)I", "canConsumeValue", "", "consumeNextToken", "()B", "tryConsumeComma", "", "c", "isValidValueStart", "(C)Z", "expectEof", "expected", "(B)B", "(C)V", "unexpectedToken", "expectedToken", "wasConsumed", "", "fail$kotlinx_serialization_json", "(BZ)Ljava/lang/Void;", "fail", "peekNextToken", "doConsume", "tryConsumeNull", "(Z)Z", "skipWhitespaces", "()I", "", "keyToMatch", "isLenient", "peekLeadingMatchingValue", "(Ljava/lang/String;Z)Ljava/lang/String;", "peekString", "(Z)Ljava/lang/String;", "discardPeeked", "startPos", "endPos", "substring", "(II)Ljava/lang/String;", "consumeKeyString", "()Ljava/lang/String;", "consumeString", "", ShareConstants.FEED_SOURCE_PARAM, "startPosition", "current", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "consumeStringLenientNotNull", "consumeStringLenient", "fromIndex", "toIndex", "appendRange", "(II)V", "allowLenientStrings", "skipElement", "(Z)V", InAppPurchaseConstants.METHOD_TO_STRING, SDKConstants.PARAM_KEY, "failOnUnknownKey", "(Ljava/lang/String;)V", "message", ViewHierarchyConstants.HINT_KEY, "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Void;", "", "consumeNumericLiteral", "()J", "consumeBooleanLenient", "lastPosition", "appendEscape", "(II)I", "currentPosition", "decodedString", "takePeeked", "wasUnquotedString", "appendEsc", "appendHex", "(Ljava/lang/CharSequence;I)I", "fromHexChar", "start", "consumeBoolean", "(I)Z", "literalSuffix", "consumeBooleanLiteral", "(Ljava/lang/String;I)V", "I", "Lkotlinx/serialization/json/internal/JsonPath;", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "peekedString", "Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "escapedString", "Ljava/lang/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "getSource", "()Ljava/lang/CharSequence;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractJsonLexer {
    public int currentPosition;
    private String peekedString;
    public final JsonPath path = new JsonPath();
    private StringBuilder escapedString = new StringBuilder();

    private final int appendEsc(int startPosition) {
        int iPrefetchOrEof = prefetchOrEof(startPosition);
        if (iPrefetchOrEof == -1) {
            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return 0;
        }
        int i = iPrefetchOrEof + 1;
        char cCharAt = getSource().charAt(iPrefetchOrEof);
        if (cCharAt == 'u') {
            return appendHex(getSource(), i);
        }
        char cEscapeToChar = AbstractJsonLexerKt.escapeToChar(cCharAt);
        if (cEscapeToChar != 0) {
            this.escapedString.append(cEscapeToChar);
            return i;
        }
        fail$default(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return 0;
    }

    private final int appendEscape(int lastPosition, int current) {
        appendRange(lastPosition, current);
        return appendEsc(current + 1);
    }

    private final int appendHex(CharSequence source, int startPos) {
        int i = startPos + 4;
        if (i < source.length()) {
            this.escapedString.append((char) ((fromHexChar(source, startPos) << 12) + (fromHexChar(source, startPos + 1) << 8) + (fromHexChar(source, startPos + 2) << 4) + fromHexChar(source, startPos + 3)));
            return i;
        }
        this.currentPosition = startPos;
        ensureHaveChars();
        if (this.currentPosition + 4 < source.length()) {
            return appendHex(source, this.currentPosition);
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return 0;
    }

    private final boolean consumeBoolean(int start) {
        int iPrefetchOrEof = prefetchOrEof(start);
        if (iPrefetchOrEof >= getSource().length() || iPrefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return false;
        }
        int i = iPrefetchOrEof + 1;
        int iCharAt = getSource().charAt(iPrefetchOrEof) | ' ';
        if (iCharAt == 102) {
            consumeBooleanLiteral("alse", i);
            return false;
        }
        if (iCharAt == 116) {
            consumeBooleanLiteral("rue", i);
            return true;
        }
        fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return false;
    }

    private final void consumeBooleanLiteral(String literalSuffix, int current) {
        if (getSource().length() - current < literalSuffix.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int length = literalSuffix.length();
        for (int i = 0; i < length; i++) {
            if (literalSuffix.charAt(i) != (getSource().charAt(current + i) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                Utf8$$ExternalSyntheticBUOutline0.m();
                return;
            }
        }
        this.currentPosition = literalSuffix.length() + current;
    }

    private static final double consumeNumericLiteral$calculateExponent(long j, boolean z) {
        if (!z) {
            return Math.pow(10.0d, -j);
        }
        if (z) {
            return Math.pow(10.0d, j);
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return 0.0d;
    }

    private final String decodedString(int lastPosition, int currentPosition) {
        appendRange(lastPosition, currentPosition);
        String string = this.escapedString.toString();
        this.escapedString.setLength(0);
        return string;
    }

    public static /* synthetic */ Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i, String str2, int i2, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: fail");
            return null;
        }
        if ((i2 & 2) != 0) {
            i = abstractJsonLexer.currentPosition;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        return abstractJsonLexer.fail(str, i, str2);
    }

    public static /* synthetic */ Void fail$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, byte b, boolean z, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: fail");
            return null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return abstractJsonLexer.fail$kotlinx_serialization_json(b, z);
    }

    private final int fromHexChar(CharSequence source, int currentPosition) {
        char cCharAt = source.charAt(currentPosition);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        fail$default(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return 0;
    }

    private final String takePeeked() {
        String str = this.peekedString;
        str.getClass();
        this.peekedString = null;
        return str;
    }

    public static /* synthetic */ boolean tryConsumeNull$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: tryConsumeNull");
            return false;
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return abstractJsonLexer.tryConsumeNull(z);
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    public void appendRange(int fromIndex, int toIndex) {
        this.escapedString.append(getSource(), fromIndex, toIndex);
    }

    public abstract boolean canConsumeValue();

    public final boolean consumeBooleanLenient() {
        boolean z;
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return false;
        }
        if (getSource().charAt(iSkipWhitespaces) == '\"') {
            iSkipWhitespaces++;
            z = true;
        } else {
            z = false;
        }
        boolean zConsumeBoolean = consumeBoolean(iSkipWhitespaces);
        if (!z) {
            return zConsumeBoolean;
        }
        if (this.currentPosition == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return false;
        }
        if (getSource().charAt(this.currentPosition) == '\"') {
            this.currentPosition++;
            return zConsumeBoolean;
        }
        fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return false;
    }

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public final byte consumeNextToken(byte expected) {
        byte bConsumeNextToken = consumeNextToken();
        if (bConsumeNextToken == expected) {
            return bConsumeNextToken;
        }
        fail$kotlinx_serialization_json$default(this, expected, false, 2, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return (byte) 0;
    }

    public abstract void consumeNextToken(char expected);

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01cc, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01cd, code lost:
    
        fail$default(r18, "Expected numeric literal", 0, null, 6, null);
        okio.Utf8$$ExternalSyntheticBUOutline0.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01db, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0108, code lost:
    
        fail$default(r18, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6, null);
        okio.Utf8$$ExternalSyntheticBUOutline0.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0127, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0128, code lost:
    
        if (r2 == r1) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012a, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012c, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012d, code lost:
    
        if (r1 == r2) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012f, code lost:
    
        if (r9 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0133, code lost:
    
        if (r1 == (r2 - 1)) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0135, code lost:
    
        if (r0 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0137, code lost:
    
        if (r4 == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0141, code lost:
    
        if (getSource().charAt(r2) != '\"') goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0143, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0148, code lost:
    
        fail$default(r18, "Expected closing quotation mark", 0, null, 6, null);
        okio.Utf8$$ExternalSyntheticBUOutline0.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0156, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0157, code lost:
    
        fail$default(r18, "EOF", 0, null, 6, null);
        okio.Utf8$$ExternalSyntheticBUOutline0.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0165, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0166, code lost:
    
        r18.currentPosition = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0168, code lost:
    
        if (r8 == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016a, code lost:
    
        r1 = r10 * consumeNumericLiteral$calculateExponent(r12, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0174, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x017a, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0182, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0184, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0186, code lost:
    
        fail$default(r18, "Can't convert " + r1 + " to Long", 0, null, 6, null);
        okio.Utf8$$ExternalSyntheticBUOutline0.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a3, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a4, code lost:
    
        fail$default(r18, "Numeric value overflow", 0, null, 6, null);
        okio.Utf8$$ExternalSyntheticBUOutline0.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01b2, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b3, code lost:
    
        if (r9 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b5, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ba, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01bd, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01be, code lost:
    
        fail$default(r18, "Numeric value overflow", 0, null, 6, null);
        okio.Utf8$$ExternalSyntheticBUOutline0.m();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long consumeNumericLiteral() {
        boolean z;
        int iPrefetchOrEof = prefetchOrEof(skipWhitespaces());
        if (iPrefetchOrEof < getSource().length() && iPrefetchOrEof != -1) {
            if (getSource().charAt(iPrefetchOrEof) == '\"') {
                iPrefetchOrEof++;
                if (iPrefetchOrEof == getSource().length()) {
                    fail$default(this, "EOF", 0, null, 6, null);
                    Utf8$$ExternalSyntheticBUOutline0.m();
                    return 0L;
                }
                z = true;
            } else {
                z = false;
            }
            int i = iPrefetchOrEof;
            long j = 0;
            long j2 = 0;
            boolean z2 = false;
            boolean z3 = false;
            loop0: while (true) {
                boolean z4 = false;
                while (i != getSource().length()) {
                    char cCharAt = getSource().charAt(i);
                    if ((cCharAt == 'e' || cCharAt == 'E') && !z2) {
                        if (i == iPrefetchOrEof) {
                            fail$default(this, "Unexpected symbol " + cCharAt + " in numeric literal", 0, null, 6, null);
                            Utf8$$ExternalSyntheticBUOutline0.m();
                            return 0L;
                        }
                        i++;
                        z2 = true;
                    } else if (cCharAt == '-' && z2) {
                        if (i == iPrefetchOrEof) {
                            fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                            Utf8$$ExternalSyntheticBUOutline0.m();
                            return 0L;
                        }
                        i++;
                    } else if (cCharAt != '+' || !z2) {
                        if (cCharAt != '-') {
                            if (AbstractJsonLexerKt.charToTokenClass(cCharAt) != 0) {
                                break loop0;
                            }
                            i++;
                            int i2 = cCharAt - '0';
                            if (i2 < 0 || i2 >= 10) {
                                break loop0;
                            }
                            if (z2) {
                                j2 = (j2 * 10) + ((long) i2);
                            } else {
                                j = (j * 10) - ((long) i2);
                                if (j > 0) {
                                    fail$default(this, "Numeric value overflow", 0, null, 6, null);
                                    Utf8$$ExternalSyntheticBUOutline0.m();
                                    return 0L;
                                }
                            }
                        } else {
                            if (i != iPrefetchOrEof) {
                                fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                                Utf8$$ExternalSyntheticBUOutline0.m();
                                return 0L;
                            }
                            i++;
                            z3 = true;
                        }
                    } else {
                        if (i == iPrefetchOrEof) {
                            fail$default(this, "Unexpected symbol '+' in numeric literal", 0, null, 6, null);
                            Utf8$$ExternalSyntheticBUOutline0.m();
                            return 0L;
                        }
                        i++;
                    }
                    z4 = true;
                }
                break loop0;
            }
        } else {
            fail$default(this, "EOF", 0, null, 6, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return 0L;
        }
    }

    public final String consumeString(CharSequence source, int startPosition, int current) {
        source.getClass();
        int iPrefetchOrEof = startPosition;
        boolean z = false;
        char cCharAt = source.charAt(current);
        int i = current;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                iPrefetchOrEof = prefetchOrEof(appendEscape(iPrefetchOrEof, i));
                if (iPrefetchOrEof == -1) {
                    fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4, null);
                    Utf8$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
            } else {
                i++;
                if (i >= source.length()) {
                    appendRange(iPrefetchOrEof, i);
                    iPrefetchOrEof = prefetchOrEof(i);
                    if (iPrefetchOrEof == -1) {
                        fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4, null);
                        Utf8$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                } else {
                    continue;
                    cCharAt = source.charAt(i);
                }
            }
            i = iPrefetchOrEof;
            z = true;
            cCharAt = source.charAt(i);
        }
        String strSubstring = !z ? substring(iPrefetchOrEof, i) : decodedString(iPrefetchOrEof, i);
        this.currentPosition = i + 1;
        return strSubstring;
    }

    public final String consumeStringLenient() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= getSource().length() || iSkipWhitespaces == -1) {
            fail$default(this, "EOF", iSkipWhitespaces, null, 4, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        byte bCharToTokenClass = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iSkipWhitespaces));
        if (bCharToTokenClass == 1) {
            return consumeString();
        }
        if (bCharToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(iSkipWhitespaces), 0, null, 6, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        boolean z = false;
        while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iSkipWhitespaces)) == 0) {
            iSkipWhitespaces++;
            if (iSkipWhitespaces >= getSource().length()) {
                appendRange(this.currentPosition, iSkipWhitespaces);
                int iPrefetchOrEof = prefetchOrEof(iSkipWhitespaces);
                if (iPrefetchOrEof == -1) {
                    this.currentPosition = iSkipWhitespaces;
                    return decodedString(0, 0);
                }
                iSkipWhitespaces = iPrefetchOrEof;
                z = true;
            }
        }
        int i = this.currentPosition;
        String strSubstring = !z ? substring(i, iSkipWhitespaces) : decodedString(i, iSkipWhitespaces);
        this.currentPosition = iSkipWhitespaces;
        return strSubstring;
    }

    public final String consumeStringLenientNotNull() {
        String strConsumeStringLenient = consumeStringLenient();
        if (!Intrinsics.areEqual(strConsumeStringLenient, "null") || !wasUnquotedString()) {
            return strConsumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final void discardPeeked() {
        this.peekedString = null;
    }

    public void ensureHaveChars() {
    }

    public final void expectEof() {
        if (consumeNextToken() == 10) {
            return;
        }
        fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
    }

    public final Void fail(String message, int position, String hint) {
        message.getClass();
        hint.getClass();
        String strM = hint.length() == 0 ? "" : FileInsert$$ExternalSyntheticOutline0.m("\n", hint);
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(message, " at path: ");
        sbM.append(this.path.getPath());
        sbM.append(strM);
        throw JsonExceptionsKt.JsonDecodingException(position, sbM.toString(), getSource());
    }

    public final Void fail$kotlinx_serialization_json(byte expectedToken, boolean wasConsumed) {
        String str = AbstractJsonLexerKt.tokenDescription(expectedToken);
        int i = this.currentPosition;
        if (wasConsumed) {
            i--;
        }
        int i2 = i;
        fail$default(this, FileInsert$$ExternalSyntheticOutline0.m("Expected ", str, ", but had '", (this.currentPosition == getSource().length() || i2 < 0) ? "EOF" : String.valueOf(getSource().charAt(i2)), "' instead"), i2, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final void failOnUnknownKey(String key) {
        key.getClass();
        fail(Fragment$$ExternalSyntheticOutline1.m('\'', "Encountered an unknown key '", key), StringsKt__StringsKt.lastIndexOf$default((CharSequence) substring(0, this.currentPosition), key, 0, false, 6, (Object) null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    public final StringBuilder getEscapedString() {
        return this.escapedString;
    }

    public abstract CharSequence getSource();

    public final boolean isNotEof() {
        return peekNextToken() != 10;
    }

    public final boolean isValidValueStart(char c) {
        return (c == ',' || c == ':' || c == ']' || c == '}') ? false : true;
    }

    public abstract String peekLeadingMatchingValue(String keyToMatch, boolean isLenient);

    public byte peekNextToken() {
        CharSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof == -1) {
                this.currentPosition = iPrefetchOrEof;
                return (byte) 10;
            }
            char cCharAt = source.charAt(iPrefetchOrEof);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.currentPosition = iPrefetchOrEof;
                return AbstractJsonLexerKt.charToTokenClass(cCharAt);
            }
            i = iPrefetchOrEof + 1;
        }
    }

    public final String peekString(boolean isLenient) {
        String strConsumeString;
        byte bPeekNextToken = peekNextToken();
        if (isLenient) {
            if (bPeekNextToken != 1 && bPeekNextToken != 0) {
                return null;
            }
            strConsumeString = consumeStringLenient();
        } else {
            if (bPeekNextToken != 1) {
                return null;
            }
            strConsumeString = consumeString();
        }
        this.peekedString = strConsumeString;
        return strConsumeString;
    }

    public abstract int prefetchOrEof(int position);

    public final void skipElement(boolean allowLenientStrings) {
        AbstractJsonLexer abstractJsonLexer;
        ArrayList arrayList = new ArrayList();
        byte bPeekNextToken = peekNextToken();
        if (bPeekNextToken != 8 && bPeekNextToken != 6) {
            consumeStringLenient();
            return;
        }
        while (true) {
            byte bPeekNextToken2 = this.peekNextToken();
            if (bPeekNextToken2 != 1) {
                if (bPeekNextToken2 == 8 || bPeekNextToken2 == 6) {
                    abstractJsonLexer = this;
                    arrayList.add(Byte.valueOf(bPeekNextToken2));
                } else {
                    if (bPeekNextToken2 == 9) {
                        if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 8) {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of } at path: " + this.path, this.getSource());
                        }
                        CollectionsKt.removeLast(arrayList);
                    } else if (bPeekNextToken2 == 7) {
                        if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 6) {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ] at path: " + this.path, this.getSource());
                        }
                        CollectionsKt.removeLast(arrayList);
                    } else if (bPeekNextToken2 == 10) {
                        fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                        Utf8$$ExternalSyntheticBUOutline0.m();
                        return;
                    }
                    abstractJsonLexer = this;
                }
                abstractJsonLexer.consumeNextToken();
                if (arrayList.size() == 0) {
                    return;
                } else {
                    this = abstractJsonLexer;
                }
            } else if (allowLenientStrings) {
                this.consumeStringLenient();
            } else {
                this.consumeKeyString();
            }
        }
    }

    public abstract int skipWhitespaces();

    public String substring(int startPos, int endPos) {
        return getSource().subSequence(startPos, endPos).toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JsonReader(source='");
        sb.append((Object) getSource());
        sb.append("', currentPosition=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.currentPosition, ')');
    }

    public final boolean tryConsumeComma() {
        int iSkipWhitespaces = skipWhitespaces();
        CharSequence source = getSource();
        if (iSkipWhitespaces >= source.length() || iSkipWhitespaces == -1 || source.charAt(iSkipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public final boolean tryConsumeNull(boolean doConsume) {
        int iPrefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - iPrefetchOrEof;
        if (length < 4 || iPrefetchOrEof == -1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if ("null".charAt(i) != getSource().charAt(iPrefetchOrEof + i)) {
                return false;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iPrefetchOrEof + 4)) == 0) {
            return false;
        }
        if (!doConsume) {
            return true;
        }
        this.currentPosition = iPrefetchOrEof + 4;
        return true;
    }

    public final void unexpectedToken(char expected) {
        int i = this.currentPosition;
        if (i > 0 && expected == '\"') {
            try {
                this.currentPosition = i - 1;
                String strConsumeStringLenient = consumeStringLenient();
                this.currentPosition = i;
                if (Intrinsics.areEqual(strConsumeStringLenient, "null")) {
                    fail("Expected string literal but 'null' literal was found", this.currentPosition - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.currentPosition = i;
                throw th;
            }
        }
        fail$kotlinx_serialization_json$default(this, AbstractJsonLexerKt.charToTokenClass(expected), false, 2, null);
        throw new KotlinNothingValueException();
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }
}
