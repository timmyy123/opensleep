package twitter4j;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: loaded from: classes5.dex */
public class JSONTokener {
    private final String in;
    private int pos;

    public JSONTokener(String str) {
        if (str != null && str.startsWith("\ufeff")) {
            str = str.substring(1);
        }
        this.in = str;
    }

    private int nextCleanInternal() {
        while (this.pos < this.in.length()) {
            String str = this.in;
            int i = this.pos;
            this.pos = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                if (cCharAt != '#') {
                    if (cCharAt == '/' && this.pos != this.in.length()) {
                        char cCharAt2 = this.in.charAt(this.pos);
                        if (cCharAt2 == '*') {
                            int i2 = this.pos + 1;
                            this.pos = i2;
                            int iIndexOf = this.in.indexOf("*/", i2);
                            if (iIndexOf == -1) {
                                throw syntaxError("Unterminated comment");
                            }
                            this.pos = iIndexOf + 2;
                        } else if (cCharAt2 == '/') {
                            this.pos++;
                            skipToEndOfLine();
                        }
                    }
                    return cCharAt;
                }
                skipToEndOfLine();
            }
        }
        return -1;
    }

    private String nextToInternal(String str) {
        int i = this.pos;
        while (true) {
            int i2 = this.pos;
            int length = this.in.length();
            String str2 = this.in;
            if (i2 >= length) {
                return str2.substring(i);
            }
            char cCharAt = str2.charAt(this.pos);
            if (cCharAt == '\r' || cCharAt == '\n' || str.indexOf(cCharAt) != -1) {
                break;
            }
            this.pos++;
        }
        return this.in.substring(i, this.pos);
    }

    private JSONArray readArray() {
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        while (true) {
            int iNextCleanInternal = nextCleanInternal();
            if (iNextCleanInternal == -1) {
                throw syntaxError("Unterminated array");
            }
            if (iNextCleanInternal == 44 || iNextCleanInternal == 59) {
                jSONArray.put(null);
            } else if (iNextCleanInternal != 93) {
                this.pos--;
                jSONArray.put(nextValue());
                int iNextCleanInternal2 = nextCleanInternal();
                if (iNextCleanInternal2 != 44 && iNextCleanInternal2 != 59) {
                    if (iNextCleanInternal2 != 93) {
                        throw syntaxError("Unterminated array");
                    }
                }
            } else if (z) {
                jSONArray.put(null);
            }
            z = true;
        }
        return jSONArray;
    }

    private char readEscapeCharacter() {
        String str = this.in;
        int i = this.pos;
        this.pos = i + 1;
        char cCharAt = str.charAt(i);
        if (cCharAt == 'b') {
            return '\b';
        }
        if (cCharAt == 'f') {
            return '\f';
        }
        if (cCharAt == 'n') {
            return '\n';
        }
        if (cCharAt == 'r') {
            return '\r';
        }
        if (cCharAt == 't') {
            return '\t';
        }
        if (cCharAt != 'u') {
            return cCharAt;
        }
        if (this.pos + 4 > this.in.length()) {
            throw syntaxError("Unterminated escape sequence");
        }
        String str2 = this.in;
        int i2 = this.pos;
        String strSubstring = str2.substring(i2, i2 + 4);
        this.pos += 4;
        try {
            return (char) Integer.parseInt(strSubstring, 16);
        } catch (NumberFormatException unused) {
            throw this.syntaxError("Invalid escape sequence: ".concat(strSubstring));
        }
    }

    private Object readLiteral() {
        String strSubstring;
        int i;
        String strNextToInternal = nextToInternal("{}[]/\\:,=;# \t\f");
        if (strNextToInternal.length() == 0) {
            throw syntaxError("Expected literal value");
        }
        if ("null".equalsIgnoreCase(strNextToInternal)) {
            return JSONObject.NULL;
        }
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(strNextToInternal)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(strNextToInternal)) {
            return Boolean.FALSE;
        }
        if (strNextToInternal.indexOf(46) == -1) {
            if (strNextToInternal.startsWith("0x") || strNextToInternal.startsWith("0X")) {
                strSubstring = strNextToInternal.substring(2);
                i = 16;
            } else if (!strNextToInternal.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO) || strNextToInternal.length() <= 1) {
                i = 10;
                strSubstring = strNextToInternal;
            } else {
                strSubstring = strNextToInternal.substring(1);
                i = 8;
            }
            try {
                long j = Long.parseLong(strSubstring, i);
                return (j > 2147483647L || j < -2147483648L) ? Long.valueOf(j) : Integer.valueOf((int) j);
            } catch (NumberFormatException unused) {
            }
        }
        try {
            return Double.valueOf(strNextToInternal);
        } catch (NumberFormatException unused2) {
            return new String(strNextToInternal);
        }
    }

    private JSONObject readObject() {
        JSONObject jSONObject = new JSONObject();
        int iNextCleanInternal = nextCleanInternal();
        if (iNextCleanInternal != 125) {
            if (iNextCleanInternal != -1) {
                this.pos--;
            }
            while (true) {
                Object objNextValue = nextValue();
                if (!(objNextValue instanceof String)) {
                    if (objNextValue == null) {
                        throw syntaxError("Names cannot be null");
                    }
                    throw syntaxError("Names must be strings, but " + objNextValue + " is of type " + objNextValue.getClass().getName());
                }
                int iNextCleanInternal2 = nextCleanInternal();
                if (iNextCleanInternal2 != 58 && iNextCleanInternal2 != 61) {
                    throw syntaxError("Expected ':' after " + objNextValue);
                }
                if (this.pos < this.in.length() && this.in.charAt(this.pos) == '>') {
                    this.pos++;
                }
                jSONObject.put((String) objNextValue, nextValue());
                int iNextCleanInternal3 = nextCleanInternal();
                if (iNextCleanInternal3 != 44 && iNextCleanInternal3 != 59) {
                    if (iNextCleanInternal3 != 125) {
                        throw syntaxError("Unterminated object");
                    }
                }
            }
        }
        return jSONObject;
    }

    private void skipToEndOfLine() {
        while (this.pos < this.in.length()) {
            char cCharAt = this.in.charAt(this.pos);
            if (cCharAt == '\r' || cCharAt == '\n') {
                this.pos++;
                return;
            }
            this.pos++;
        }
    }

    public String nextString(char c) {
        int i = this.pos;
        StringBuilder sb = null;
        while (this.pos < this.in.length()) {
            String str = this.in;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt == c) {
                String str2 = this.in;
                if (sb == null) {
                    return new String(str2.substring(i, this.pos - 1));
                }
                sb.append((CharSequence) str2, i, this.pos - 1);
                return sb.toString();
            }
            if (cCharAt == '\\') {
                if (this.pos == this.in.length()) {
                    throw syntaxError("Unterminated escape sequence");
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.in, i, this.pos - 1);
                sb.append(readEscapeCharacter());
                i = this.pos;
            }
        }
        throw syntaxError("Unterminated string");
    }

    public Object nextValue() {
        int iNextCleanInternal = nextCleanInternal();
        if (iNextCleanInternal == -1) {
            throw syntaxError("End of input");
        }
        if (iNextCleanInternal == 34 || iNextCleanInternal == 39) {
            return nextString((char) iNextCleanInternal);
        }
        if (iNextCleanInternal == 91) {
            return readArray();
        }
        if (iNextCleanInternal == 123) {
            return readObject();
        }
        this.pos--;
        return readLiteral();
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + this);
    }

    public String toString() {
        return " at character " + this.pos + " of " + this.in;
    }
}
