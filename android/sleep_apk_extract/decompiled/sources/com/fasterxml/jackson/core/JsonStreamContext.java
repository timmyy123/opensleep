package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharTypes;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonStreamContext {
    protected int _index;
    protected int _nestingDepth;
    protected int _type;

    public JsonStreamContext(JsonStreamContext jsonStreamContext) {
        this._type = jsonStreamContext._type;
        this._index = jsonStreamContext._index;
    }

    public final int getCurrentIndex() {
        int i = this._index;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public abstract String getCurrentName();

    public abstract Object getCurrentValue();

    public final int getEntryCount() {
        return this._index + 1;
    }

    public final int getNestingDepth() {
        return this._nestingDepth;
    }

    public abstract JsonStreamContext getParent();

    public boolean hasCurrentIndex() {
        return this._index >= 0;
    }

    public final boolean inArray() {
        return this._type == 1;
    }

    public final boolean inObject() {
        return this._type == 2;
    }

    public final boolean inRoot() {
        return this._type == 0;
    }

    public abstract void setCurrentValue(Object obj);

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this._type;
        if (i == 0) {
            sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        } else if (i != 1) {
            sb.append('{');
            String currentName = getCurrentName();
            if (currentName != null) {
                sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                CharTypes.appendQuoted(sb, currentName);
                sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else {
            sb.append('[');
            sb.append(getCurrentIndex());
            sb.append(']');
        }
        return sb.toString();
    }

    public String typeDesc() {
        int i = this._type;
        return i != 0 ? i != 1 ? i != 2 ? "?" : "Object" : "Array" : "root";
    }

    public JsonStreamContext() {
    }

    public JsonStreamContext(int i, int i2) {
        this._type = i;
        this._index = i2;
    }
}
