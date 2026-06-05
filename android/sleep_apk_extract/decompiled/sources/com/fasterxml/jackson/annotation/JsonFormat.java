package com.fasterxml.jackson.annotation;

import j$.util.DesugarTimeZone;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormat {

    public enum Feature {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        ACCEPT_CASE_INSENSITIVE_PROPERTIES,
        READ_UNKNOWN_ENUM_VALUES_AS_NULL,
        READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE,
        READ_DATE_TIMESTAMPS_AS_NANOSECONDS,
        ACCEPT_CASE_INSENSITIVE_VALUES,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES,
        ADJUST_DATES_TO_CONTEXT_TIME_ZONE
    }

    public enum Shape {
        BINARY,
        BOOLEAN,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        SCALAR,
        ARRAY,
        OBJECT,
        ANY,
        NATURAL,
        POJO;

        public boolean isNumeric() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }
    }

    OptBoolean lenient() default OptBoolean.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    int radix() default -1;

    Shape shape() default Shape.ANY;

    String timezone() default "##default";

    Feature[] with() default {};

    Feature[] without() default {};

    public static class Features implements Serializable {
        private static final Features EMPTY = new Features(0, 0);
        private static final long serialVersionUID = 1;
        private final int _disabled;
        private final int _enabled;

        private Features(int i, int i2) {
            this._enabled = i;
            this._disabled = i2;
        }

        public static Features construct(Feature[] featureArr, Feature[] featureArr2) {
            int iOrdinal = 0;
            for (Feature feature : featureArr) {
                iOrdinal |= 1 << feature.ordinal();
            }
            int iOrdinal2 = 0;
            for (Feature feature2 : featureArr2) {
                iOrdinal2 |= 1 << feature2.ordinal();
            }
            return new Features(iOrdinal, iOrdinal2);
        }

        public static Features empty() {
            return EMPTY;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Features features = (Features) obj;
            return features._enabled == this._enabled && features._disabled == this._disabled;
        }

        public Boolean get(Feature feature) {
            int iOrdinal = 1 << feature.ordinal();
            if ((this._disabled & iOrdinal) != 0) {
                return Boolean.FALSE;
            }
            if ((this._enabled & iOrdinal) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        public int hashCode() {
            return this._disabled + this._enabled;
        }

        public String toString() {
            return this == EMPTY ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this._enabled), Integer.valueOf(this._disabled));
        }

        public Features withOverrides(Features features) {
            if (features != null) {
                int i = features._disabled;
                int i2 = features._enabled;
                if (i != 0 || i2 != 0) {
                    int i3 = this._enabled;
                    if (i3 == 0 && this._disabled == 0) {
                        return features;
                    }
                    int i4 = ((~i) & i3) | i2;
                    int i5 = this._disabled;
                    int i6 = i | ((~i2) & i5);
                    if (i4 != i3 || i6 != i5) {
                        return new Features(i4, i6);
                    }
                }
            }
            return this;
        }

        public static Features construct(JsonFormat jsonFormat) {
            return construct(jsonFormat.with(), jsonFormat.without());
        }
    }

    public static class Value implements Serializable {
        private static final Value EMPTY = new Value();
        private static final long serialVersionUID = 1;
        private final Features _features;
        private final Boolean _lenient;
        private final Locale _locale;
        private final String _pattern;
        private final int _radix;
        private final Shape _shape;
        private transient TimeZone _timezone;
        private final String _timezoneStr;

        public Value(String str, Shape shape, String str2, String str3, Features features, Boolean bool, int i) {
            this(str, shape, (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2), (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3, null, features, bool, i);
        }

        public static final Value empty() {
            return EMPTY;
        }

        public static Value forLeniency(boolean z) {
            return new Value("", null, null, null, null, Features.empty(), Boolean.valueOf(z), -1);
        }

        public static final Value from(JsonFormat jsonFormat) {
            return jsonFormat == null ? EMPTY : new Value(jsonFormat);
        }

        public static Value merge(Value value, Value value2) {
            return value == null ? value2 : value.withOverrides(value2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            return this._shape == value._shape && this._features.equals(value._features) && Objects.equals(this._lenient, value._lenient) && Objects.equals(this._timezoneStr, value._timezoneStr) && Objects.equals(this._pattern, value._pattern) && Objects.equals(this._timezone, value._timezone) && Objects.equals(this._locale, value._locale) && Integer.valueOf(this._radix).equals(Integer.valueOf(value._radix));
        }

        public Boolean getFeature(Feature feature) {
            return this._features.get(feature);
        }

        public Boolean getLenient() {
            return this._lenient;
        }

        public Locale getLocale() {
            return this._locale;
        }

        public String getPattern() {
            return this._pattern;
        }

        public Shape getShape() {
            return this._shape;
        }

        public TimeZone getTimeZone() {
            TimeZone timeZone = this._timezone;
            if (timeZone != null) {
                return timeZone;
            }
            String str = this._timezoneStr;
            if (str == null) {
                return null;
            }
            TimeZone timeZone2 = DesugarTimeZone.getTimeZone(str);
            this._timezone = timeZone2;
            return timeZone2;
        }

        public boolean hasLenient() {
            return this._lenient != null;
        }

        public boolean hasLocale() {
            return this._locale != null;
        }

        public boolean hasPattern() {
            String str = this._pattern;
            return str != null && str.length() > 0;
        }

        public boolean hasShape() {
            return this._shape != Shape.ANY;
        }

        public boolean hasTimeZone() {
            if (this._timezone != null) {
                return true;
            }
            String str = this._timezoneStr;
            return (str == null || str.isEmpty()) ? false : true;
        }

        public int hashCode() {
            String str = this._timezoneStr;
            int iHashCode = str == null ? 1 : str.hashCode();
            String str2 = this._pattern;
            if (str2 != null) {
                iHashCode ^= str2.hashCode();
            }
            int iHashCode2 = this._shape.hashCode() + iHashCode;
            Boolean bool = this._lenient;
            if (bool != null) {
                iHashCode2 ^= bool.hashCode();
            }
            Locale locale = this._locale;
            if (locale != null) {
                iHashCode2 += locale.hashCode();
            }
            return this._features.hashCode() ^ iHashCode2;
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s,radix=%s)", this._pattern, this._shape, this._lenient, this._locale, this._timezoneStr, this._features, Integer.valueOf(this._radix));
        }

        public Value withLenient(Boolean bool) {
            return bool == this._lenient ? this : new Value(this._pattern, this._shape, this._locale, this._timezoneStr, this._timezone, this._features, bool, this._radix);
        }

        public final Value withOverrides(Value value) {
            Value value2;
            if (value == null || value == (value2 = EMPTY) || value == this) {
                return this;
            }
            if (this == value2) {
                return value;
            }
            String str = value._pattern;
            if (str == null || str.isEmpty()) {
                str = this._pattern;
            }
            String str2 = str;
            Shape shape = value._shape;
            if (shape == Shape.ANY) {
                shape = this._shape;
            }
            Shape shape2 = shape;
            Locale locale = value._locale;
            if (locale == null) {
                locale = this._locale;
            }
            Locale locale2 = locale;
            Features features = this._features;
            Features featuresWithOverrides = value._features;
            if (features != null) {
                featuresWithOverrides = features.withOverrides(featuresWithOverrides);
            }
            Features features2 = featuresWithOverrides;
            Boolean bool = value._lenient;
            if (bool == null) {
                bool = this._lenient;
            }
            Boolean bool2 = bool;
            int i = value._radix;
            if (i == -1) {
                i = this._radix;
            }
            int i2 = i;
            String str3 = value._timezoneStr;
            if (str3 == null || str3.isEmpty()) {
                str3 = this._timezoneStr;
            } else {
                this = value;
            }
            return new Value(str2, shape2, locale2, str3, this._timezone, features2, bool2, i2);
        }

        public Value(JsonFormat jsonFormat) {
            this(jsonFormat.pattern(), jsonFormat.shape(), jsonFormat.locale(), jsonFormat.timezone(), Features.construct(jsonFormat), jsonFormat.lenient().asBoolean(), jsonFormat.radix());
        }

        public Value() {
            this("", Shape.ANY, "", "", Features.empty(), null, -1);
        }

        public Value(String str, Shape shape, Locale locale, String str2, TimeZone timeZone, Features features, Boolean bool, int i) {
            this._pattern = str == null ? "" : str;
            this._shape = shape == null ? Shape.ANY : shape;
            this._locale = locale;
            this._timezone = timeZone;
            this._timezoneStr = str2;
            this._features = features == null ? Features.empty() : features;
            this._lenient = bool;
            this._radix = i;
        }
    }
}
