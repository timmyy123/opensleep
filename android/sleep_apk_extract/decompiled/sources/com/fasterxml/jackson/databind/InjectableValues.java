package com.fasterxml.jackson.databind;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InjectableValues {

    public static abstract class Base extends InjectableValues implements Serializable {
        private static final long serialVersionUID = 1;

        public Object _handleMissingValue(DeserializationContext deserializationContext, String str, BeanProperty beanProperty, Object obj, Boolean bool, Boolean bool2) throws JsonMappingException {
            Boolean bool3 = Boolean.TRUE;
            boolean zEquals = bool3.equals(bool);
            boolean zEquals2 = bool3.equals(bool2);
            if (zEquals || !deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_INJECT_VALUE)) {
                return null;
            }
            if (!zEquals2 || obj == null) {
                throw deserializationContext.missingInjectableValueException(FileInsert$$ExternalSyntheticOutline0.m("No injectable value with id '", str, "' found (for property '", beanProperty.getName(), "')"), str, beanProperty, obj);
            }
            return null;
        }

        public String _validateKey(DeserializationContext deserializationContext, Object obj, BeanProperty beanProperty, Object obj2) throws JsonMappingException {
            if (obj instanceof String) {
                return (String) obj;
            }
            throw deserializationContext.missingInjectableValueException(FileInsert$$ExternalSyntheticOutline0.m("Unsupported injectable value id type (", ClassUtil.classNameOf(obj), "), expecting String"), obj, beanProperty, obj2);
        }
    }

    public static final class Empty extends Base implements Serializable {
        static final Empty INSTANCE = new Empty();
        private static final long serialVersionUID = 1;

        private Empty() {
        }

        @Override // com.fasterxml.jackson.databind.InjectableValues
        public Object findInjectableValue(DeserializationContext deserializationContext, Object obj, BeanProperty beanProperty, Object obj2, Boolean bool, Boolean bool2) {
            return _handleMissingValue(deserializationContext, _validateKey(deserializationContext, obj, beanProperty, obj2), beanProperty, obj2, bool, bool2);
        }
    }

    public static InjectableValues empty() {
        return Empty.INSTANCE;
    }

    public abstract Object findInjectableValue(DeserializationContext deserializationContext, Object obj, BeanProperty beanProperty, Object obj2, Boolean bool, Boolean bool2);
}
