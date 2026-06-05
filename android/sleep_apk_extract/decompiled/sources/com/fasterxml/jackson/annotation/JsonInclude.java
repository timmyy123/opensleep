package com.fasterxml.jackson.annotation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonInclude {

    public enum Include {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        CUSTOM,
        USE_DEFAULTS
    }

    Include content() default Include.ALWAYS;

    Class<?> contentFilter() default Void.class;

    Include value() default Include.ALWAYS;

    Class<?> valueFilter() default Void.class;

    public static class Value implements Serializable {
        public static final Value ALL_ALWAYS;
        public static final Value ALL_NON_ABSENT;
        public static final Value ALL_NON_DEFAULT;
        public static final Value ALL_NON_EMPTY;
        public static final Value ALL_NON_NULL;
        protected static final Value EMPTY;
        private static final long serialVersionUID = 1;
        protected final Class<?> _contentFilter;
        protected final Include _contentInclusion;
        protected final Class<?> _valueFilter;
        protected final Include _valueInclusion;

        static {
            Include include = Include.ALWAYS;
            ALL_ALWAYS = construct(include, include);
            Include include2 = Include.NON_NULL;
            ALL_NON_NULL = construct(include2, include2);
            Include include3 = Include.NON_ABSENT;
            ALL_NON_ABSENT = construct(include3, include3);
            Include include4 = Include.NON_EMPTY;
            ALL_NON_EMPTY = construct(include4, include4);
            Include include5 = Include.NON_DEFAULT;
            ALL_NON_DEFAULT = construct(include5, include5);
            Include include6 = Include.USE_DEFAULTS;
            EMPTY = new Value(include6, include6, null, null);
        }

        public Value(Include include, Include include2, Class<?> cls, Class<?> cls2) {
            this._valueInclusion = include == null ? Include.USE_DEFAULTS : include;
            this._contentInclusion = include2 == null ? Include.USE_DEFAULTS : include2;
            this._valueFilter = cls == Void.class ? null : cls;
            this._contentFilter = cls2 == Void.class ? null : cls2;
        }

        public static Value construct(Include include, Include include2, Class<?> cls, Class<?> cls2) {
            if (cls == Void.class) {
                cls = null;
            }
            if (cls2 == Void.class) {
                cls2 = null;
            }
            Include include3 = Include.USE_DEFAULTS;
            return ((include == include3 || include == null) && (include2 == include3 || include2 == null) && cls == null && cls2 == null) ? EMPTY : new Value(include, include2, cls, cls2);
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value from(JsonInclude jsonInclude) {
            if (jsonInclude == null) {
                return EMPTY;
            }
            Include includeValue = jsonInclude.value();
            Include includeContent = jsonInclude.content();
            Include include = Include.USE_DEFAULTS;
            if (includeValue == include && includeContent == include) {
                return EMPTY;
            }
            Class<?> clsValueFilter = jsonInclude.valueFilter();
            if (clsValueFilter == Void.class) {
                clsValueFilter = null;
            }
            Class<?> clsContentFilter = jsonInclude.contentFilter();
            return new Value(includeValue, includeContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
        }

        public static Value merge(Value value, Value value2) {
            return value == null ? value2 : value.withOverrides(value2);
        }

        public static Value mergeAll(Value... valueArr) {
            Value value = null;
            for (Value valueWithOverrides : valueArr) {
                if (valueWithOverrides != null) {
                    if (value != null) {
                        valueWithOverrides = value.withOverrides(valueWithOverrides);
                    }
                    value = valueWithOverrides;
                }
            }
            return value;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            return value._valueInclusion == this._valueInclusion && value._contentInclusion == this._contentInclusion && value._valueFilter == this._valueFilter && value._contentFilter == this._contentFilter;
        }

        public Class<?> getContentFilter() {
            return this._contentFilter;
        }

        public Include getContentInclusion() {
            return this._contentInclusion;
        }

        public Class<?> getValueFilter() {
            return this._valueFilter;
        }

        public Include getValueInclusion() {
            return this._valueInclusion;
        }

        public int hashCode() {
            return this._contentInclusion.hashCode() + (this._valueInclusion.hashCode() << 2);
        }

        public Object readResolve() {
            Include include = this._valueInclusion;
            Include include2 = Include.USE_DEFAULTS;
            return (include == include2 && this._contentInclusion == include2 && this._valueFilter == null && this._contentFilter == null) ? EMPTY : this;
        }

        public String toString() {
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(80, "JsonInclude.Value(value=");
            sbM.append(this._valueInclusion);
            sbM.append(",content=");
            sbM.append(this._contentInclusion);
            if (this._valueFilter != null) {
                sbM.append(",valueFilter=");
                Fragment$$ExternalSyntheticOutline1.m(this._valueFilter, sbM, ".class");
            }
            if (this._contentFilter != null) {
                sbM.append(",contentFilter=");
                Fragment$$ExternalSyntheticOutline1.m(this._contentFilter, sbM, ".class");
            }
            sbM.append(')');
            return sbM.toString();
        }

        public Value withContentFilter(Class<?> cls) {
            Include include;
            if (cls == null || cls == Void.class) {
                include = Include.USE_DEFAULTS;
                cls = null;
            } else {
                include = Include.CUSTOM;
            }
            return construct(this._valueInclusion, include, this._valueFilter, cls);
        }

        public Value withContentInclusion(Include include) {
            return include == this._contentInclusion ? this : new Value(this._valueInclusion, include, this._valueFilter, this._contentFilter);
        }

        public Value withOverrides(Value value) {
            if (value == null || value == EMPTY) {
                return this;
            }
            Include include = value._valueInclusion;
            Include include2 = value._contentInclusion;
            Class<?> cls = value._valueFilter;
            Class<?> cls2 = value._contentFilter;
            Include include3 = this._valueInclusion;
            boolean z = (include == include3 || include == Include.USE_DEFAULTS) ? false : true;
            Include include4 = this._contentInclusion;
            boolean z2 = (include2 == include4 || include2 == Include.USE_DEFAULTS) ? false : true;
            Class<?> cls3 = this._valueFilter;
            return z ? z2 ? new Value(include, include2, cls, cls2) : new Value(include, include4, cls, cls2) : z2 ? new Value(include3, include2, cls, cls2) : (cls == cls3 && cls2 == cls3) ? false : true ? new Value(include3, include4, cls, cls2) : this;
        }

        public Value withValueInclusion(Include include) {
            return include == this._valueInclusion ? this : new Value(include, this._contentInclusion, this._valueFilter, this._contentFilter);
        }

        public static Value construct(Include include, Include include2) {
            Include include3 = Include.USE_DEFAULTS;
            if ((include != include3 && include != null) || (include2 != include3 && include2 != null)) {
                return new Value(include, include2, null, null);
            }
            return EMPTY;
        }
    }
}
