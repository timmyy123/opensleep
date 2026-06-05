package io.opencensus.trace;

import io.opencensus.internal.Utils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AttributeValue {

    public static abstract class AttributeValueLong extends AttributeValue {
        public static AttributeValue create(Long l) {
            return new AutoValue_AttributeValue_AttributeValueLong((Long) Utils.checkNotNull(l, "longValue"));
        }

        public abstract Long getLongValue();
    }

    public static abstract class AttributeValueString extends AttributeValue {
        public static AttributeValue create(String str) {
            return new AutoValue_AttributeValue_AttributeValueString((String) Utils.checkNotNull(str, "stringValue"));
        }

        public abstract String getStringValue();
    }

    public static AttributeValue longAttributeValue(long j) {
        return AttributeValueLong.create(Long.valueOf(j));
    }

    public static AttributeValue stringAttributeValue(String str) {
        return AttributeValueString.create(str);
    }
}
