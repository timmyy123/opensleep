package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class JSONStringer {
    private final String indent;
    final StringBuilder out;
    private final List<Scope> stack;

    public enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public JSONStringer(int i) {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        this.indent = new String(cArr);
    }

    private void beforeKey() {
        Scope scopePeek = peek();
        if (scopePeek == Scope.NONEMPTY_OBJECT) {
            this.out.append(',');
        } else if (scopePeek != Scope.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        newline();
        replaceTop(Scope.DANGLING_KEY);
    }

    private void beforeValue() {
        if (this.stack.isEmpty()) {
            return;
        }
        Scope scopePeek = peek();
        if (scopePeek == Scope.EMPTY_ARRAY) {
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
        } else if (scopePeek == Scope.NONEMPTY_ARRAY) {
            this.out.append(',');
            newline();
        } else if (scopePeek == Scope.DANGLING_KEY) {
            this.out.append(this.indent == null ? ":" : ": ");
            replaceTop(Scope.NONEMPTY_OBJECT);
        } else if (scopePeek != Scope.NULL) {
            throw new JSONException("Nesting problem");
        }
    }

    private void newline() {
        if (this.indent == null) {
            return;
        }
        this.out.append("\n");
        for (int i = 0; i < this.stack.size(); i++) {
            this.out.append(this.indent);
        }
    }

    private Scope peek() {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        return (Scope) FileInsert$$ExternalSyntheticOutline0.m(this.stack, 1);
    }

    private void replaceTop(Scope scope) {
        this.stack.set(r1.size() - 1, scope);
    }

    private void string(String str) {
        this.out.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                this.out.append("\\f");
            } else if (cCharAt == '\r') {
                this.out.append("\\r");
            } else if (cCharAt != '\"' && cCharAt != '/' && cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        this.out.append("\\b");
                        break;
                    case '\t':
                        this.out.append("\\t");
                        break;
                    case '\n':
                        this.out.append("\\n");
                        break;
                    default:
                        StringBuilder sb = this.out;
                        if (cCharAt <= 31) {
                            sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            } else {
                StringBuilder sb2 = this.out;
                sb2.append('\\');
                sb2.append(cCharAt);
            }
        }
        this.out.append("\"");
    }

    public JSONStringer array() {
        return open(Scope.EMPTY_ARRAY, "[");
    }

    public JSONStringer close(Scope scope, Scope scope2, String str) {
        Scope scopePeek = peek();
        if (scopePeek != scope2 && scopePeek != scope) {
            throw new JSONException("Nesting problem");
        }
        this.stack.remove(r3.size() - 1);
        if (scopePeek == scope2) {
            newline();
        }
        this.out.append(str);
        return this;
    }

    public JSONStringer endArray() {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    public JSONStringer endObject() {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    public JSONStringer key(String str) {
        if (str == null) {
            throw new JSONException("Names must be non-null");
        }
        beforeKey();
        string(str);
        return this;
    }

    public JSONStringer object() {
        return open(Scope.EMPTY_OBJECT, "{");
    }

    public JSONStringer open(Scope scope, String str) {
        if (this.stack.isEmpty() && this.out.length() > 0) {
            throw new JSONException("Nesting problem: multiple top-level roots");
        }
        beforeValue();
        this.stack.add(scope);
        this.out.append(str);
        return this;
    }

    public String toString() {
        if (this.out.length() == 0) {
            return null;
        }
        return this.out.toString();
    }

    public JSONStringer value(Object obj) {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        if (obj instanceof JSONArray) {
            ((JSONArray) obj).writeTo(this);
            return this;
        }
        if (obj instanceof JSONObject) {
            ((JSONObject) obj).writeTo(this);
            return this;
        }
        beforeValue();
        if (obj == null || (obj instanceof Boolean) || obj == JSONObject.NULL) {
            this.out.append(obj);
            return this;
        }
        if (obj instanceof Number) {
            this.out.append(JSONObject.numberToString((Number) obj));
            return this;
        }
        string(obj.toString());
        return this;
    }

    public JSONStringer() {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        this.indent = null;
    }
}
