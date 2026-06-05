package io.opencensus.trace;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.opencensus.trace.AttributeValue;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_AttributeValue_AttributeValueString extends AttributeValue.AttributeValueString {
    private final String stringValue;

    public AutoValue_AttributeValue_AttributeValueString(String str) {
        if (str != null) {
            this.stringValue = str;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Null stringValue");
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeValue.AttributeValueString) {
            return this.stringValue.equals(((AttributeValue.AttributeValueString) obj).getStringValue());
        }
        return false;
    }

    @Override // io.opencensus.trace.AttributeValue.AttributeValueString
    public String getStringValue() {
        return this.stringValue;
    }

    public int hashCode() {
        return this.stringValue.hashCode() ^ 1000003;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("AttributeValueString{stringValue="), this.stringValue, "}");
    }
}
