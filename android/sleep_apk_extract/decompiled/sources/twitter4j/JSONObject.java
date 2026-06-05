package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class JSONObject {
    private static final Double NEGATIVE_ZERO = Double.valueOf(-0.0d);
    public static final Object NULL = new Object() { // from class: twitter4j.JSONObject.1
        public boolean equals(Object obj) {
            return obj == this || obj == null;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "null";
        }
    };
    private final LinkedHashMap<String, Object> nameValuePairs;

    public JSONObject(JSONTokener jSONTokener) {
        Object objNextValue = jSONTokener.nextValue();
        if (!(objNextValue instanceof JSONObject)) {
            throw JSON.typeMismatch(objNextValue, "JSONObject");
        }
        this.nameValuePairs = ((JSONObject) objNextValue).nameValuePairs;
    }

    public static String numberToString(Number number) {
        if (number == null) {
            throw new JSONException("Number must be non-null");
        }
        double dDoubleValue = number.doubleValue();
        JSON.checkDouble(dDoubleValue);
        if (number.equals(NEGATIVE_ZERO)) {
            return "-0";
        }
        long jLongValue = number.longValue();
        return dDoubleValue == ((double) jLongValue) ? Long.toString(jLongValue) : number.toString();
    }

    public String checkName(String str) {
        if (str != null) {
            return str;
        }
        throw new JSONException("Names must be non-null");
    }

    public Object get(String str) {
        Object obj = this.nameValuePairs.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException(FileInsert$$ExternalSyntheticOutline0.m("No value for ", str));
    }

    public int getInt(String str) {
        Object obj = get(str);
        Integer integer = JSON.toInteger(obj);
        if (integer != null) {
            return integer.intValue();
        }
        throw JSON.typeMismatch(str, obj, "int");
    }

    public JSONArray getJSONArray(String str) {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(str, obj, "JSONArray");
    }

    public JSONObject getJSONObject(String str) {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(str, obj, "JSONObject");
    }

    public long getLong(String str) {
        Object obj = get(str);
        Long l = JSON.toLong(obj);
        if (l != null) {
            return l.longValue();
        }
        throw JSON.typeMismatch(str, obj, "long");
    }

    public String getString(String str) {
        Object obj = get(str);
        String string = JSON.toString(obj);
        if (string != null) {
            return string;
        }
        throw JSON.typeMismatch(str, obj, "String");
    }

    public boolean has(String str) {
        return this.nameValuePairs.containsKey(str);
    }

    public boolean isNull(String str) {
        Object obj = this.nameValuePairs.get(str);
        return obj == null || obj == NULL;
    }

    public Iterator<String> keys() {
        return this.nameValuePairs.keySet().iterator();
    }

    public JSONObject put(String str, Object obj) {
        if (obj == null) {
            this.nameValuePairs.remove(str);
            return this;
        }
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        this.nameValuePairs.put(checkName(str), obj);
        return this;
    }

    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            writeTo(jSONStringer);
            return jSONStringer.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public void writeTo(JSONStringer jSONStringer) {
        jSONStringer.object();
        for (Map.Entry<String, Object> entry : this.nameValuePairs.entrySet()) {
            jSONStringer.key(entry.getKey()).value(entry.getValue());
        }
        jSONStringer.endObject();
    }

    public String toString(int i) {
        JSONStringer jSONStringer = new JSONStringer(i);
        writeTo(jSONStringer);
        return jSONStringer.toString();
    }

    public JSONObject() {
        this.nameValuePairs = new LinkedHashMap<>();
    }

    public JSONObject(String str) {
        this(new JSONTokener(str));
    }

    public JSONObject put(String str, long j) {
        this.nameValuePairs.put(checkName(str), Long.valueOf(j));
        return this;
    }

    public JSONObject put(String str, boolean z) {
        this.nameValuePairs.put(checkName(str), Boolean.valueOf(z));
        return this;
    }
}
