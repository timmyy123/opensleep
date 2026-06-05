package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
final class UntypedObjectDeserializerNR extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final boolean _nonMerging;
    protected static final Object[] NO_OBJECTS = new Object[0];
    public static final UntypedObjectDeserializerNR std = new UntypedObjectDeserializerNR();

    public UntypedObjectDeserializerNR(boolean z) {
        super((Class<?>) Object.class);
        this._nonMerging = z;
    }

    private Object _deserializeAnyScalar(JsonParser jsonParser, DeserializationContext deserializationContext, int i) {
        switch (i) {
            case 6:
                return jsonParser.getText();
            case 7:
                return deserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS) ? jsonParser.getBigIntegerValue() : jsonParser.getNumberValue();
            case 8:
                return _deserializeFP(jsonParser, deserializationContext);
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return jsonParser.getEmbeddedObject();
            default:
                return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
        }
    }

    private Object _deserializeNR(JsonParser jsonParser, DeserializationContext deserializationContext, Scope scope) {
        Object text;
        Object text2;
        boolean zHasSomeOfFeatures = deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS);
        boolean zIsEnabled = deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY);
        Scope scopeFinishBranchObject = scope;
        while (true) {
            if (scopeFinishBranchObject.isObject()) {
                String strNextFieldName = jsonParser.nextFieldName();
                while (true) {
                    if (strNextFieldName != null) {
                        JsonToken jsonTokenNextToken = jsonParser.nextToken();
                        if (jsonTokenNextToken == null) {
                            jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
                        }
                        int iId = jsonTokenNextToken.id();
                        if (iId == 1) {
                            scopeFinishBranchObject = scopeFinishBranchObject.childObject(strNextFieldName);
                        } else if (iId != 3) {
                            switch (iId) {
                                case 6:
                                    text = jsonParser.getText();
                                    break;
                                case 7:
                                    text = !zHasSomeOfFeatures ? jsonParser.getNumberValue() : _coerceIntegral(jsonParser, deserializationContext);
                                    break;
                                case 8:
                                    text = _deserializeFP(jsonParser, deserializationContext);
                                    break;
                                case 9:
                                    text = Boolean.TRUE;
                                    break;
                                case 10:
                                    text = Boolean.FALSE;
                                    break;
                                case 11:
                                    text = null;
                                    break;
                                case 12:
                                    text = jsonParser.getEmbeddedObject();
                                    break;
                                default:
                                    return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                            }
                            scopeFinishBranchObject.putValue(strNextFieldName, text);
                        } else {
                            scopeFinishBranchObject = scopeFinishBranchObject.childArray(strNextFieldName);
                        }
                        strNextFieldName = jsonParser.nextFieldName();
                    } else {
                        if (scopeFinishBranchObject == scope) {
                            return scopeFinishBranchObject.finishRootObject();
                        }
                        scopeFinishBranchObject = scopeFinishBranchObject.finishBranchObject();
                    }
                }
            } else {
                while (true) {
                    JsonToken jsonTokenNextToken2 = jsonParser.nextToken();
                    if (jsonTokenNextToken2 == null) {
                        jsonTokenNextToken2 = JsonToken.NOT_AVAILABLE;
                    }
                    switch (jsonTokenNextToken2.id()) {
                        case 1:
                            scopeFinishBranchObject = scopeFinishBranchObject.childObject();
                            continue;
                        case 2:
                        case 5:
                        default:
                            return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                        case 3:
                            scopeFinishBranchObject = scopeFinishBranchObject.childArray();
                            continue;
                        case 4:
                            if (scopeFinishBranchObject == scope) {
                                return scopeFinishBranchObject.finishRootArray(zIsEnabled);
                            }
                            scopeFinishBranchObject = scopeFinishBranchObject.finishBranchArray(zIsEnabled);
                            continue;
                            break;
                        case 6:
                            text2 = jsonParser.getText();
                            break;
                        case 7:
                            text2 = !zHasSomeOfFeatures ? jsonParser.getNumberValue() : _coerceIntegral(jsonParser, deserializationContext);
                            break;
                        case 8:
                            text2 = _deserializeFP(jsonParser, deserializationContext);
                            break;
                        case 9:
                            text2 = Boolean.TRUE;
                            break;
                        case 10:
                            text2 = Boolean.FALSE;
                            break;
                        case 11:
                            text2 = null;
                            break;
                        case 12:
                            text2 = jsonParser.getEmbeddedObject();
                            break;
                    }
                    scopeFinishBranchObject.addValue(text2);
                }
            }
        }
    }

    private Object _deserializeObjectAtName(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Object obj_deserializeNR;
        Scope scopeRootObjectScope = Scope.rootObjectScope(deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES));
        String strCurrentName = jsonParser.currentName();
        while (strCurrentName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            if (jsonTokenNextToken == null) {
                jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
            }
            int iId = jsonTokenNextToken.id();
            if (iId == 1) {
                obj_deserializeNR = _deserializeNR(jsonParser, deserializationContext, scopeRootObjectScope.childObject());
            } else {
                if (iId == 2) {
                    return scopeRootObjectScope.finishRootObject();
                }
                obj_deserializeNR = iId != 3 ? _deserializeAnyScalar(jsonParser, deserializationContext, jsonTokenNextToken.id()) : _deserializeNR(jsonParser, deserializationContext, scopeRootObjectScope.childArray());
            }
            scopeRootObjectScope.putValue(strCurrentName, obj_deserializeNR);
            strCurrentName = jsonParser.nextFieldName();
        }
        return scopeRootObjectScope.finishRootObject();
    }

    public static UntypedObjectDeserializerNR instance(boolean z) {
        return z ? new UntypedObjectDeserializerNR(true) : std;
    }

    public Object _deserializeFP(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonParser.NumberTypeFP numberTypeFP = jsonParser.getNumberTypeFP();
        return numberTypeFP == JsonParser.NumberTypeFP.BIG_DECIMAL ? jsonParser.getDecimalValue() : (jsonParser.isNaN() || !deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) ? numberTypeFP == JsonParser.NumberTypeFP.FLOAT32 ? Float.valueOf(jsonParser.getFloatValue()) : Double.valueOf(jsonParser.getDoubleValue()) : jsonParser.getDecimalValue();
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        switch (jsonParser.currentTokenId()) {
            case 1:
                return _deserializeNR(jsonParser, deserializationContext, Scope.rootObjectScope(deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)));
            case 2:
                return Scope.emptyMap();
            case 3:
                return _deserializeNR(jsonParser, deserializationContext, Scope.rootArrayScope());
            case 4:
            default:
                return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
            case 5:
                return _deserializeObjectAtName(jsonParser, deserializationContext);
            case 6:
                return jsonParser.getText();
            case 7:
                return deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(jsonParser, deserializationContext) : jsonParser.getNumberValue();
            case 8:
                return _deserializeFP(jsonParser, deserializationContext);
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return jsonParser.getEmbeddedObject();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        int iCurrentTokenId = jsonParser.currentTokenId();
        return (iCurrentTokenId == 1 || iCurrentTokenId == 3 || iCurrentTokenId == 5) ? typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext) : _deserializeAnyScalar(jsonParser, deserializationContext, jsonParser.currentTokenId());
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        if (this._nonMerging) {
            return Boolean.FALSE;
        }
        return null;
    }

    public UntypedObjectDeserializerNR() {
        this(false);
    }

    public static final class Scope {
        private Scope _child;
        private String _deferredKey;
        private boolean _isObject;
        private List<Object> _list;
        private Map<String, Object> _map;
        private final Scope _parent;
        private boolean _squashDups;

        private Scope(Scope scope) {
            this._parent = scope;
            this._isObject = false;
            this._squashDups = false;
        }

        private void _putValueHandleDups(String str, Object obj) {
            Map<String, Object> map = this._map;
            if (map == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                this._map = linkedHashMap;
                linkedHashMap.put(str, obj);
                return;
            }
            Object objPut = map.put(str, obj);
            if (objPut != null) {
                if (objPut instanceof List) {
                    ((List) objPut).add(obj);
                    this._map.put(str, objPut);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(objPut);
                    arrayList.add(obj);
                    this._map.put(str, arrayList);
                }
            }
        }

        public static List<Object> emptyList() {
            return new ArrayList(2);
        }

        public static Map<String, Object> emptyMap() {
            return new LinkedHashMap(2);
        }

        private Scope resetAsArray() {
            this._isObject = false;
            return this;
        }

        private Scope resetAsObject(boolean z) {
            this._isObject = true;
            this._squashDups = z;
            return this;
        }

        public static Scope rootArrayScope() {
            return new Scope(null);
        }

        public static Scope rootObjectScope(boolean z) {
            return new Scope(null, true, z);
        }

        public void addValue(Object obj) {
            if (this._list == null) {
                this._list = new ArrayList();
            }
            this._list.add(obj);
        }

        public Scope childArray(String str) {
            this._deferredKey = str;
            Scope scope = this._child;
            return scope == null ? new Scope(this) : scope.resetAsArray();
        }

        public Scope childObject(String str) {
            this._deferredKey = str;
            Scope scope = this._child;
            boolean z = this._squashDups;
            return scope == null ? new Scope(this, true, z) : scope.resetAsObject(z);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public Scope finishBranchArray(boolean z) {
            Object objEmptyList;
            List<Object> list = this._list;
            Object array = list;
            if (list == null) {
                objEmptyList = z ? UntypedObjectDeserializerNR.NO_OBJECTS : emptyList();
            } else {
                if (z) {
                    array = list.toArray(UntypedObjectDeserializerNR.NO_OBJECTS);
                }
                this._list = null;
                objEmptyList = array;
            }
            boolean zIsObject = this._parent.isObject();
            Scope scope = this._parent;
            if (zIsObject) {
                return scope.putDeferredValue(objEmptyList);
            }
            scope.addValue(objEmptyList);
            return this._parent;
        }

        public Scope finishBranchObject() {
            Object linkedHashMap = this._map;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            } else {
                this._map = null;
            }
            boolean zIsObject = this._parent.isObject();
            Scope scope = this._parent;
            if (zIsObject) {
                return scope.putDeferredValue(linkedHashMap);
            }
            scope.addValue(linkedHashMap);
            return this._parent;
        }

        public Object finishRootArray(boolean z) {
            List<Object> list = this._list;
            return list == null ? z ? UntypedObjectDeserializerNR.NO_OBJECTS : emptyList() : z ? list.toArray(UntypedObjectDeserializerNR.NO_OBJECTS) : list;
        }

        public Object finishRootObject() {
            Map<String, Object> map = this._map;
            return map == null ? emptyMap() : map;
        }

        public boolean isObject() {
            return this._isObject;
        }

        public Scope putDeferredValue(Object obj) {
            String str = this._deferredKey;
            Objects.requireNonNull(str);
            this._deferredKey = null;
            if (this._squashDups) {
                _putValueHandleDups(str, obj);
                return this;
            }
            if (this._map == null) {
                this._map = new LinkedHashMap();
            }
            this._map.put(str, obj);
            return this;
        }

        public void putValue(String str, Object obj) {
            if (this._squashDups) {
                _putValueHandleDups(str, obj);
                return;
            }
            if (this._map == null) {
                this._map = new LinkedHashMap();
            }
            this._map.put(str, obj);
        }

        private Scope(Scope scope, boolean z, boolean z2) {
            this._parent = scope;
            this._isObject = z;
            this._squashDups = z2;
        }

        public Scope childArray() {
            Scope scope = this._child;
            if (scope == null) {
                return new Scope(this);
            }
            return scope.resetAsArray();
        }

        public Scope childObject() {
            Scope scope = this._child;
            boolean z = this._squashDups;
            if (scope == null) {
                return new Scope(this, true, z);
            }
            return scope.resetAsObject(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if (r5.nextToken() == com.fasterxml.jackson.core.JsonToken.END_OBJECT) goto L28;
     */
    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        Object objDeserialize;
        if (this._nonMerging) {
            return deserialize(jsonParser, deserializationContext);
        }
        int iCurrentTokenId = jsonParser.currentTokenId();
        if (iCurrentTokenId != 1) {
            if (iCurrentTokenId != 2) {
                if (iCurrentTokenId != 3) {
                    if (iCurrentTokenId != 4) {
                        if (iCurrentTokenId == 5) {
                            if (obj instanceof Map) {
                                Map map = (Map) obj;
                                String strCurrentName = jsonParser.currentName();
                                do {
                                    jsonParser.nextToken();
                                    Object obj2 = map.get(strCurrentName);
                                    if (obj2 != null) {
                                        objDeserialize = deserialize(jsonParser, deserializationContext, obj2);
                                    } else {
                                        objDeserialize = deserialize(jsonParser, deserializationContext);
                                    }
                                    if (objDeserialize != obj2) {
                                        map.put(strCurrentName, objDeserialize);
                                    }
                                    strCurrentName = jsonParser.nextFieldName();
                                } while (strCurrentName != null);
                                return obj;
                            }
                        }
                    }
                } else if (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    if (obj instanceof Collection) {
                        Collection collection = (Collection) obj;
                        do {
                            collection.add(deserialize(jsonParser, deserializationContext));
                        } while (jsonParser.nextToken() != JsonToken.END_ARRAY);
                        return obj;
                    }
                }
            }
            return obj;
        }
        return deserialize(jsonParser, deserializationContext);
    }
}
