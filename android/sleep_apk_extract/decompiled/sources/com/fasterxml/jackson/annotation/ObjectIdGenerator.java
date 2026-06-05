package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ObjectIdGenerator<T> implements Serializable {

    public static final class IdKey implements Serializable {
        private static final long serialVersionUID = 1;
        private final int hashCode;
        public final Object key;
        public final Class<?> scope;
        public final Class<?> type;

        public IdKey(Class<?> cls, Class<?> cls2, Object obj) {
            Objects.requireNonNull(cls, "Type must not be null");
            this.type = cls;
            this.scope = cls2;
            Objects.requireNonNull(obj, "Key must not be null");
            this.key = obj;
            this.hashCode = (cls.getName().hashCode() + obj.hashCode()) ^ Objects.hashCode(cls2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != IdKey.class) {
                return false;
            }
            IdKey idKey = (IdKey) obj;
            return idKey.key.equals(this.key) && idKey.type == this.type && idKey.scope == this.scope;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public String toString() {
            Object obj = this.key;
            String name = this.type.getName();
            Class<?> cls = this.scope;
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", obj, name, cls == null ? "NONE" : cls.getName());
        }
    }

    public abstract boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> forScope(Class<?> cls);

    public abstract T generateId(Object obj);

    public abstract Class<?> getScope();

    public boolean isValidReferencePropertyName(String str, Object obj) {
        return false;
    }

    public abstract IdKey key(Object obj);

    public boolean maySerializeAsObject() {
        return false;
    }

    public abstract ObjectIdGenerator<T> newForSerialization(Object obj);
}
