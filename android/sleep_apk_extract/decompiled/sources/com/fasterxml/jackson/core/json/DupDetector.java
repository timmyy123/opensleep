package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class DupDetector {
    protected String _firstName;
    protected String _secondName;
    protected HashSet<String> _seen;
    protected final Object _source;

    private DupDetector(Object obj) {
        this._source = obj;
    }

    public static DupDetector rootDetector(JsonParser jsonParser) {
        return new DupDetector(jsonParser);
    }

    public DupDetector child() {
        return new DupDetector(this._source);
    }

    public Object getSource() {
        return this._source;
    }

    public boolean isDup(String str) {
        String str2 = this._firstName;
        if (str2 == null) {
            this._firstName = str;
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        String str3 = this._secondName;
        if (str3 == null) {
            this._secondName = str;
            return false;
        }
        if (str.equals(str3)) {
            return true;
        }
        if (this._seen == null) {
            HashSet<String> hashSet = new HashSet<>(16);
            this._seen = hashSet;
            hashSet.add(this._firstName);
            this._seen.add(this._secondName);
        }
        return !this._seen.add(str);
    }

    public void reset() {
        this._firstName = null;
        this._secondName = null;
        this._seen = null;
    }

    public static DupDetector rootDetector(JsonGenerator jsonGenerator) {
        return new DupDetector(jsonGenerator);
    }
}
