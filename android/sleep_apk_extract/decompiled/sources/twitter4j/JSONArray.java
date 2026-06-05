package twitter4j;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class JSONArray {
    private final List<Object> values;

    public JSONArray(JSONTokener jSONTokener) {
        Object objNextValue = jSONTokener.nextValue();
        if (!(objNextValue instanceof JSONArray)) {
            throw JSON.typeMismatch(objNextValue, "JSONArray");
        }
        this.values = ((JSONArray) objNextValue).values;
    }

    public boolean equals(Object obj) {
        return (obj instanceof JSONArray) && ((JSONArray) obj).values.equals(this.values);
    }

    public Object get(int i) {
        try {
            Object obj = this.values.get(i);
            if (obj != null) {
                return obj;
            }
            throw new JSONException("Value at " + i + " is null.");
        } catch (IndexOutOfBoundsException unused) {
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Index ", " out of range [0..");
            sbM65m.append(this.values.size());
            sbM65m.append(")");
            throw new JSONException(sbM65m.toString());
        }
    }

    public double getDouble(int i) {
        Object obj = get(i);
        Double d = JSON.toDouble(obj);
        if (d != null) {
            return d.doubleValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "double");
    }

    public int getInt(int i) {
        Object obj = get(i);
        Integer integer = JSON.toInteger(obj);
        if (integer != null) {
            return integer.intValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "int");
    }

    public JSONArray getJSONArray(int i) {
        Object obj = get(i);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "JSONArray");
    }

    public JSONObject getJSONObject(int i) {
        Object obj = get(i);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "JSONObject");
    }

    public String getString(int i) {
        Object obj = get(i);
        String string = JSON.toString(obj);
        if (string != null) {
            return string;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "String");
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public int length() {
        return this.values.size();
    }

    public JSONArray put(Object obj) {
        this.values.add(obj);
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
        jSONStringer.array();
        Iterator<Object> it = this.values.iterator();
        while (it.hasNext()) {
            jSONStringer.value(it.next());
        }
        jSONStringer.endArray();
    }

    public String toString(int i) {
        JSONStringer jSONStringer = new JSONStringer(i);
        writeTo(jSONStringer);
        return jSONStringer.toString();
    }

    public JSONArray() {
        this.values = new ArrayList();
    }

    public JSONArray(String str) {
        this(new JSONTokener(str));
    }
}
