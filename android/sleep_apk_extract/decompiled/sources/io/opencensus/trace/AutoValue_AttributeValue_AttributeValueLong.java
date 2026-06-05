package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_AttributeValue_AttributeValueLong extends AttributeValue.AttributeValueLong {
    private final Long longValue;

    public AutoValue_AttributeValue_AttributeValueLong(Long l) {
        if (l != null) {
            this.longValue = l;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Null longValue");
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeValue.AttributeValueLong) {
            return this.longValue.equals(((AttributeValue.AttributeValueLong) obj).getLongValue());
        }
        return false;
    }

    @Override // io.opencensus.trace.AttributeValue.AttributeValueLong
    public Long getLongValue() {
        return this.longValue;
    }

    public int hashCode() {
        return this.longValue.hashCode() ^ 1000003;
    }

    public String toString() {
        return "AttributeValueLong{longValue=" + this.longValue + "}";
    }
}
