package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JacksonInject {

    public static class Value implements Serializable {
        protected static final Value EMPTY = new Value(null, null, null);
        private static final long serialVersionUID = 1;
        protected final Object _id;
        protected final Boolean _optional;
        protected final Boolean _useInput;

        public Value(Object obj, Boolean bool, Boolean bool2) {
            this._id = obj;
            this._useInput = bool;
            this._optional = bool2;
        }

        private static boolean _empty(Object obj, Boolean bool, Boolean bool2) {
            return obj == null && bool == null && bool2 == null;
        }

        public static Value construct(Object obj, Boolean bool, Boolean bool2) {
            if ("".equals(obj)) {
                obj = null;
            }
            return _empty(obj, bool, bool2) ? EMPTY : new Value(obj, bool, bool2);
        }

        public static Value forId(Object obj) {
            return construct(obj, null, null);
        }

        public static Value from(JacksonInject jacksonInject) {
            return jacksonInject == null ? EMPTY : construct(jacksonInject.value(), jacksonInject.useInput().asBoolean(), jacksonInject.optional().asBoolean());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                Value value = (Value) obj;
                if (Objects.equals(this._id, value._id) && Objects.equals(this._useInput, value._useInput) && Objects.equals(this._optional, value._optional)) {
                    return true;
                }
            }
            return false;
        }

        public Object getId() {
            return this._id;
        }

        public Boolean getOptional() {
            return this._optional;
        }

        public Boolean getUseInput() {
            return this._useInput;
        }

        public boolean hasId() {
            return this._id != null;
        }

        public int hashCode() {
            Object obj = this._id;
            int iHashCode = obj != null ? 1 + obj.hashCode() : 1;
            Boolean bool = this._useInput;
            if (bool != null) {
                iHashCode += bool.hashCode();
            }
            Boolean bool2 = this._optional;
            return bool2 != null ? bool2.hashCode() + iHashCode : iHashCode;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s,optional=%s)", this._id, this._useInput, this._optional);
        }

        public boolean willUseInput(boolean z) {
            Boolean bool = this._useInput;
            return bool == null ? z : bool.booleanValue();
        }

        public Value withId(Object obj) {
            Object obj2 = this._id;
            return (obj != null ? !obj.equals(obj2) : obj2 != null) ? new Value(obj, this._useInput, this._optional) : this;
        }
    }

    OptBoolean optional() default OptBoolean.DEFAULT;

    OptBoolean useInput() default OptBoolean.DEFAULT;

    String value() default "";
}
