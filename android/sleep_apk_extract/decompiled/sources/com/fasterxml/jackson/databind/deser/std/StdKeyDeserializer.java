package com.fasterxml.jackson.databind.deser.std;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.cfg.EnumFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class StdKeyDeserializer extends KeyDeserializer implements Serializable {
    private static final long serialVersionUID = 1;
    protected final FromStringDeserializer<?> _deser;
    protected final Class<?> _keyClass;
    protected final int _kind;

    public static final class DelegatingKD extends KeyDeserializer implements Serializable {
        private static final long serialVersionUID = 1;
        protected final JsonDeserializer<?> _delegate;
        protected final Class<?> _keyClass;

        public DelegatingKD(Class<?> cls, JsonDeserializer<?> jsonDeserializer) {
            this._keyClass = cls;
            this._delegate = jsonDeserializer;
        }

        @Override // com.fasterxml.jackson.databind.KeyDeserializer
        public final Object deserializeKey(String str, DeserializationContext deserializationContext) {
            if (str == null) {
                return null;
            }
            TokenBuffer tokenBufferBufferForInputBuffering = deserializationContext.bufferForInputBuffering();
            tokenBufferBufferForInputBuffering.writeString(str);
            try {
                JsonParser jsonParserAsParser = tokenBufferBufferForInputBuffering.asParser();
                jsonParserAsParser.nextToken();
                Object objDeserialize = this._delegate.deserialize(jsonParserAsParser, deserializationContext);
                return objDeserialize != null ? objDeserialize : deserializationContext.handleWeirdKey(this._keyClass, str, "not a valid representation", new Object[0]);
            } catch (Exception e) {
                return deserializationContext.handleWeirdKey(this._keyClass, str, "not a valid representation: %s", e.getMessage());
            }
        }
    }

    @JacksonStdImpl
    public static final class EnumKD extends StdKeyDeserializer {
        private static final long serialVersionUID = 1;
        protected final EnumResolver _byEnumNamingResolver;
        protected volatile EnumResolver _byIndexResolver;
        protected final EnumResolver _byNameResolver;
        protected volatile EnumResolver _byToStringResolver;
        protected final Enum<?> _enumDefaultValue;
        protected final AnnotatedMethod _factory;

        public EnumKD(EnumResolver enumResolver, AnnotatedMethod annotatedMethod, EnumResolver enumResolver2, EnumResolver enumResolver3, EnumResolver enumResolver4) {
            super(-1, enumResolver.getEnumClass());
            this._byNameResolver = enumResolver;
            this._factory = annotatedMethod;
            this._enumDefaultValue = enumResolver.getDefaultValue();
            this._byEnumNamingResolver = enumResolver2;
            this._byToStringResolver = enumResolver3;
            this._byIndexResolver = enumResolver4;
        }

        @Deprecated
        private EnumResolver _getIndexResolver(DeserializationContext deserializationContext) {
            EnumResolver enumResolver;
            EnumResolver enumResolver2 = this._byIndexResolver;
            if (enumResolver2 != null) {
                return enumResolver2;
            }
            synchronized (this) {
                try {
                    enumResolver = this._byIndexResolver;
                    if (enumResolver == null) {
                        DeserializationConfig config = deserializationContext.getConfig();
                        this._byIndexResolver = EnumResolver.constructUsingIndex(config, config.introspectClassAnnotations(this._byNameResolver.getEnumClass()).getClassInfo());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return enumResolver;
        }

        @Deprecated
        private EnumResolver _getToStringResolver(DeserializationContext deserializationContext) {
            EnumResolver enumResolver;
            EnumResolver enumResolver2 = this._byToStringResolver;
            if (enumResolver2 != null) {
                return enumResolver2;
            }
            synchronized (this) {
                try {
                    enumResolver = this._byToStringResolver;
                    if (enumResolver == null) {
                        DeserializationConfig config = deserializationContext.getConfig();
                        this._byToStringResolver = EnumResolver.constructUsingToString(config, config.introspectClassAnnotations(this._byNameResolver.getEnumClass()).getClassInfo());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return enumResolver;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer
        public Object _parse(String str, DeserializationContext deserializationContext) {
            AnnotatedMethod annotatedMethod = this._factory;
            if (annotatedMethod != null) {
                try {
                    return annotatedMethod.call1(str);
                } catch (Exception e) {
                    ClassUtil.unwrapAndThrowAsIAE(e);
                }
            }
            EnumResolver enumResolver_resolveCurrentResolver = this._resolveCurrentResolver(deserializationContext);
            Enum<?> enumFindEnum = enumResolver_resolveCurrentResolver.findEnum(str);
            if (enumFindEnum == null && deserializationContext.isEnabled(EnumFeature.READ_ENUM_KEYS_USING_INDEX)) {
                enumResolver_resolveCurrentResolver = this._getIndexResolver(deserializationContext);
                enumFindEnum = enumResolver_resolveCurrentResolver.findEnum(str);
            }
            return enumFindEnum == null ? (this._enumDefaultValue == null || !deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) ? !deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL) ? deserializationContext.handleWeirdKey(this._keyClass, str, "not one of the values accepted for Enum class: %s", enumResolver_resolveCurrentResolver.getEnumIds()) : enumFindEnum : this._enumDefaultValue : enumFindEnum;
        }

        public EnumResolver _resolveCurrentResolver(DeserializationContext deserializationContext) {
            EnumResolver enumResolver = this._byEnumNamingResolver;
            return enumResolver != null ? enumResolver : (this._byNameResolver.hasAsValueAnnotation() || !deserializationContext.isEnabled(DeserializationFeature.READ_ENUMS_USING_TO_STRING)) ? this._byNameResolver : _getToStringResolver(deserializationContext);
        }
    }

    public static final class StringCtorKeyDeserializer extends StdKeyDeserializer {
        private static final long serialVersionUID = 1;
        protected final Constructor<?> _ctor;

        public StringCtorKeyDeserializer(Constructor<?> constructor) {
            super(-1, constructor.getDeclaringClass());
            this._ctor = constructor;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer
        public Object _parse(String str, DeserializationContext deserializationContext) {
            return this._ctor.newInstance(str);
        }
    }

    public static final class StringFactoryKeyDeserializer extends StdKeyDeserializer {
        private static final long serialVersionUID = 1;
        final Method _factoryMethod;

        public StringFactoryKeyDeserializer(Method method) {
            super(-1, method.getDeclaringClass());
            this._factoryMethod = method;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer
        public Object _parse(String str, DeserializationContext deserializationContext) {
            return this._factoryMethod.invoke(null, str);
        }
    }

    @JacksonStdImpl
    public static final class StringKD extends StdKeyDeserializer {
        private static final long serialVersionUID = 1;
        private static final StringKD sString = new StringKD(String.class);
        private static final StringKD sObject = new StringKD(Object.class);

        private StringKD(Class<?> cls) {
            super(-1, cls);
        }

        public static StringKD forType(Class<?> cls) {
            return cls == String.class ? sString : cls == Object.class ? sObject : new StringKD(cls);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer, com.fasterxml.jackson.databind.KeyDeserializer
        public Object deserializeKey(String str, DeserializationContext deserializationContext) {
            return str;
        }
    }

    public StdKeyDeserializer(int i, Class<?> cls, FromStringDeserializer<?> fromStringDeserializer) {
        this._kind = i;
        this._keyClass = cls;
        this._deser = fromStringDeserializer;
    }

    public static StdKeyDeserializer forType(Class<?> cls) {
        int i;
        if (cls == String.class || cls == Object.class || cls == CharSequence.class || cls == Serializable.class) {
            return StringKD.forType(cls);
        }
        if (cls == UUID.class) {
            i = 12;
        } else if (cls == Integer.class) {
            i = 5;
        } else if (cls == Long.class) {
            i = 6;
        } else if (cls == Date.class) {
            i = 10;
        } else if (cls == Calendar.class) {
            i = 11;
        } else if (cls == Boolean.class) {
            i = 1;
        } else if (cls == Byte.class) {
            i = 2;
        } else if (cls == Character.class) {
            i = 4;
        } else if (cls == Short.class) {
            i = 3;
        } else if (cls == Float.class) {
            i = 7;
        } else if (cls == Double.class) {
            i = 8;
        } else if (cls == URI.class) {
            i = 13;
        } else if (cls == URL.class) {
            i = 14;
        } else if (cls == Class.class) {
            i = 15;
        } else {
            if (cls == Locale.class) {
                return new StdKeyDeserializer(9, cls, FromStringDeserializer.findDeserializer(Locale.class));
            }
            if (cls == Currency.class) {
                return new StdKeyDeserializer(16, cls, FromStringDeserializer.findDeserializer(Currency.class));
            }
            if (cls != byte[].class) {
                return null;
            }
            i = 17;
        }
        return new StdKeyDeserializer(i, cls);
    }

    public Object _parse(String str, DeserializationContext deserializationContext) {
        switch (this._kind) {
            case 1:
                return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str) ? Boolean.TRUE : "false".equals(str) ? Boolean.FALSE : deserializationContext.handleWeirdKey(this._keyClass, str, "value not 'true' or 'false'", new Object[0]);
            case 2:
                int i_parseInt = _parseInt(str);
                return (i_parseInt < -128 || i_parseInt > 255) ? deserializationContext.handleWeirdKey(this._keyClass, str, "overflow, value cannot be represented as 8-bit value", new Object[0]) : Byte.valueOf((byte) i_parseInt);
            case 3:
                int i_parseInt2 = _parseInt(str);
                return (i_parseInt2 < -32768 || i_parseInt2 > 32767) ? deserializationContext.handleWeirdKey(this._keyClass, str, "overflow, value cannot be represented as 16-bit value", new Object[0]) : Short.valueOf((short) i_parseInt2);
            case 4:
                return str.length() == 1 ? Character.valueOf(str.charAt(0)) : deserializationContext.handleWeirdKey(this._keyClass, str, "can only convert 1-character Strings", new Object[0]);
            case 5:
                return Integer.valueOf(_parseInt(str));
            case 6:
                return Long.valueOf(_parseLong(str));
            case 7:
                return Float.valueOf((float) _parseDouble(str));
            case 8:
                return Double.valueOf(_parseDouble(str));
            case 9:
            case 16:
                try {
                    return this._deser._deserialize(str, deserializationContext);
                } catch (IllegalArgumentException e) {
                    return this._weirdKey(deserializationContext, str, e);
                }
            case 10:
                return deserializationContext.parseDate(str);
            case 11:
                return deserializationContext.constructCalendar(deserializationContext.parseDate(str));
            case 12:
                try {
                    return UUID.fromString(str);
                } catch (Exception e2) {
                    return this._weirdKey(deserializationContext, str, e2);
                }
            case 13:
                try {
                    return URI.create(str);
                } catch (Exception e3) {
                    return this._weirdKey(deserializationContext, str, e3);
                }
            case 14:
                try {
                    return new URL(str);
                } catch (MalformedURLException e4) {
                    return _weirdKey(deserializationContext, str, e4);
                }
            case 15:
                try {
                    return deserializationContext.findClass(str);
                } catch (Exception unused) {
                    return deserializationContext.handleWeirdKey(this._keyClass, str, "unable to parse key as Class", new Object[0]);
                }
            case 17:
                try {
                    return deserializationContext.getConfig().getBase64Variant().decode(str);
                } catch (IllegalArgumentException e5) {
                    return this._weirdKey(deserializationContext, str, e5);
                }
            default:
                Home$$ExternalSyntheticBUOutline0.m("Internal error: unknown key type ", (Object) this._keyClass);
                return null;
        }
    }

    public double _parseDouble(String str) {
        return NumberInput.parseDouble(str, false);
    }

    public int _parseInt(String str) {
        return NumberInput.parseInt(str);
    }

    public long _parseLong(String str) {
        return NumberInput.parseLong(str);
    }

    public Object _weirdKey(DeserializationContext deserializationContext, String str, Exception exc) {
        return deserializationContext.handleWeirdKey(this._keyClass, str, "problem: %s", ClassUtil.exceptionMessage(exc));
    }

    @Override // com.fasterxml.jackson.databind.KeyDeserializer
    public Object deserializeKey(String str, DeserializationContext deserializationContext) {
        if (str == null) {
            return null;
        }
        try {
            Object obj_parse = _parse(str, deserializationContext);
            if (obj_parse != null) {
                return obj_parse;
            }
            if (ClassUtil.isEnumType(this._keyClass) && deserializationContext.getConfig().isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            return deserializationContext.handleWeirdKey(this._keyClass, str, "not a valid representation", new Object[0]);
        } catch (Exception e) {
            return deserializationContext.handleWeirdKey(this._keyClass, str, "not a valid representation, problem: (%s) %s", e.getClass().getName(), ClassUtil.exceptionMessage(e));
        }
    }

    public StdKeyDeserializer(int i, Class<?> cls) {
        this(i, cls, null);
    }
}
