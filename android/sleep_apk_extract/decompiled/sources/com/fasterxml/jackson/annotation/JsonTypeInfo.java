package com.fasterxml.jackson.annotation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonTypeInfo {

    public enum As {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY,
        EXISTING_PROPERTY,
        NOTHING
    }

    public enum Id {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        SIMPLE_NAME("@type"),
        DEDUCTION(null),
        CUSTOM(null);

        private final String _defaultPropertyName;

        Id(String str) {
            this._defaultPropertyName = str;
        }

        public String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }

    @Deprecated
    public static abstract class None {
    }

    public static class Value implements Serializable {
        protected static final Value EMPTY = new Value(Id.NONE, As.NOTHING, null, null, false, null);
        private static final long serialVersionUID = 1;
        protected final Class<?> _defaultImpl;
        protected final Id _idType;
        protected final boolean _idVisible;
        protected final As _inclusionType;
        protected final String _propertyName;
        protected final Boolean _requireTypeIdForSubtypes;

        public Value(Id id, As as, String str, Class<?> cls, boolean z, Boolean bool) {
            this._defaultImpl = cls;
            this._idType = id;
            this._inclusionType = as;
            this._propertyName = str;
            this._idVisible = z;
            this._requireTypeIdForSubtypes = bool;
        }

        private static boolean _equals(Value value, Value value2) {
            return value._idType == value2._idType && value._inclusionType == value2._inclusionType && value._defaultImpl == value2._defaultImpl && value._idVisible == value2._idVisible && Objects.equals(value._propertyName, value2._propertyName) && Objects.equals(value._requireTypeIdForSubtypes, value2._requireTypeIdForSubtypes);
        }

        public static Value construct(Id id, As as, String str, Class<?> cls, boolean z, Boolean bool) {
            if (str == null || str.isEmpty()) {
                str = id != null ? id.getDefaultPropertyName() : "";
            }
            String str2 = str;
            if (cls == null || cls.isAnnotation()) {
                cls = null;
            }
            return new Value(id, as, str2, cls, z, bool);
        }

        public static Value from(JsonTypeInfo jsonTypeInfo) {
            if (jsonTypeInfo == null) {
                return null;
            }
            return construct(jsonTypeInfo.use(), jsonTypeInfo.include(), jsonTypeInfo.property(), jsonTypeInfo.defaultImpl(), jsonTypeInfo.visible(), jsonTypeInfo.requireTypeIdForSubtypes().asBoolean());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return obj != null && obj.getClass() == getClass() && _equals(this, (Value) obj);
        }

        public Class<?> getDefaultImpl() {
            return this._defaultImpl;
        }

        public Id getIdType() {
            return this._idType;
        }

        public boolean getIdVisible() {
            return this._idVisible;
        }

        public As getInclusionType() {
            return this._inclusionType;
        }

        public String getPropertyName() {
            return this._propertyName;
        }

        public Boolean getRequireTypeIdForSubtypes() {
            return this._requireTypeIdForSubtypes;
        }

        public int hashCode() {
            Id id = this._idType;
            int iHashCode = ((id != null ? id.hashCode() : 0) + 31) * 31;
            As as = this._inclusionType;
            int iHashCode2 = (iHashCode + (as != null ? as.hashCode() : 0)) * 31;
            String str = this._propertyName;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            Class<?> cls = this._defaultImpl;
            return ((((iHashCode3 + (cls != null ? cls.hashCode() : 0)) * 31) + (this._requireTypeIdForSubtypes.booleanValue() ? 11 : -17)) * 31) + (this._idVisible ? 11 : -17);
        }

        public String toString() {
            Id id = this._idType;
            As as = this._inclusionType;
            String str = this._propertyName;
            Class<?> cls = this._defaultImpl;
            String name = cls == null ? "NULL" : cls.getName();
            boolean z = this._idVisible;
            Boolean bool = this._requireTypeIdForSubtypes;
            StringBuilder sb = new StringBuilder("JsonTypeInfo.Value(idType=");
            sb.append(id);
            sb.append(",includeAs=");
            sb.append(as);
            sb.append(",propertyName=");
            FileInsert$$ExternalSyntheticOutline0.m(sb, str, ",defaultImpl=", name, ",idVisible=");
            sb.append(z);
            sb.append(",requireTypeIdForSubtypes=");
            sb.append(bool);
            sb.append(")");
            return sb.toString();
        }

        public Value withDefaultImpl(Class<?> cls) {
            return cls == this._defaultImpl ? this : new Value(this._idType, this._inclusionType, this._propertyName, cls, this._idVisible, this._requireTypeIdForSubtypes);
        }

        public Value withInclusionType(As as) {
            return as == this._inclusionType ? this : new Value(this._idType, as, this._propertyName, this._defaultImpl, this._idVisible, this._requireTypeIdForSubtypes);
        }
    }

    Class<?> defaultImpl() default JsonTypeInfo.class;

    As include() default As.PROPERTY;

    String property() default "";

    OptBoolean requireTypeIdForSubtypes() default OptBoolean.DEFAULT;

    Id use();

    boolean visible() default false;
}
