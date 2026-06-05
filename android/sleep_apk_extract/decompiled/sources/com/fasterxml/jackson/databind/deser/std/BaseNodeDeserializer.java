package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.JsonNodeFeature;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.RawValue;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> implements ContextualDeserializer {
    protected final boolean _mergeArrays;
    protected final boolean _mergeObjects;
    protected final Boolean _supportsUpdates;

    public static final class ContainerStack {
        private int _end;
        private ContainerNode[] _stack;
        private int _top;

        public ContainerNode popOrNull() {
            int i = this._top;
            if (i == 0) {
                return null;
            }
            ContainerNode[] containerNodeArr = this._stack;
            int i2 = i - 1;
            this._top = i2;
            return containerNodeArr[i2];
        }

        public void push(ContainerNode containerNode) {
            int i = this._top;
            int i2 = this._end;
            ContainerNode[] containerNodeArr = this._stack;
            if (i < i2) {
                this._top = i + 1;
                containerNodeArr[i] = containerNode;
                return;
            }
            if (containerNodeArr == null) {
                this._end = 10;
                this._stack = new ContainerNode[10];
            } else {
                int iMin = Math.min(4000, Math.max(20, i2 >> 1)) + i2;
                this._end = iMin;
                this._stack = (ContainerNode[]) Arrays.copyOf(this._stack, iMin);
            }
            ContainerNode[] containerNodeArr2 = this._stack;
            int i3 = this._top;
            this._top = i3 + 1;
            containerNodeArr2[i3] = containerNode;
        }
    }

    public BaseNodeDeserializer(BaseNodeDeserializer<?> baseNodeDeserializer, boolean z, boolean z2) {
        super(baseNodeDeserializer);
        this._supportsUpdates = baseNodeDeserializer._supportsUpdates;
        this._mergeArrays = z;
        this._mergeObjects = z2;
    }

    private static boolean _shouldMerge(Boolean bool, Boolean bool2) {
        if (bool != null) {
            return bool.booleanValue();
        }
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return true;
    }

    public abstract JsonDeserializer<?> _createWithMerge(boolean z, boolean z2);

    public final JsonNode _deserializeAnyScalar(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        int iCurrentTokenId = jsonParser.currentTokenId();
        if (iCurrentTokenId == 2) {
            return nodeFactory.objectNode();
        }
        switch (iCurrentTokenId) {
            case 6:
                return nodeFactory.textNode(jsonParser.getText());
            case 7:
                return _fromInt(jsonParser, deserializationContext, nodeFactory);
            case 8:
                return _fromFloat(jsonParser, deserializationContext, nodeFactory);
            case 9:
                return nodeFactory.booleanNode(true);
            case 10:
                return nodeFactory.booleanNode(false);
            case 11:
                return nodeFactory.nullNode();
            case 12:
                return _fromEmbedded(jsonParser, deserializationContext);
            default:
                return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ContainerNode<?> _deserializeContainerNoRecursion(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, ContainerStack containerStack, ContainerNode<?> containerNode) throws MismatchedInputException {
        JsonNode jsonNodeTextNode;
        JsonNode jsonNodeReplace;
        JsonNodeFactory jsonNodeFactory2 = jsonNodeFactory;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures() & StdDeserializer.F_MASK_INT_COERCIONS;
        ContainerNode containerNodeObjectNode = containerNode;
        do {
            if (!(containerNodeObjectNode instanceof ObjectNode)) {
                ArrayNode arrayNode = (ArrayNode) containerNodeObjectNode;
                while (true) {
                    JsonToken jsonTokenNextToken = jsonParser.nextToken();
                    if (jsonTokenNextToken == null) {
                        jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
                    }
                    switch (jsonTokenNextToken.id()) {
                        case 1:
                            containerStack.push(containerNodeObjectNode);
                            containerNodeObjectNode = jsonNodeFactory2.objectNode();
                            arrayNode.add(containerNodeObjectNode);
                            break;
                        case 2:
                        case 5:
                        default:
                            arrayNode.add(_deserializeRareScalar(jsonParser, deserializationContext));
                            break;
                        case 3:
                            containerStack.push(containerNodeObjectNode);
                            containerNodeObjectNode = jsonNodeFactory2.arrayNode();
                            arrayNode.add(containerNodeObjectNode);
                            break;
                        case 4:
                            break;
                        case 6:
                            arrayNode.add(jsonNodeFactory2.textNode(jsonParser.getText()));
                            break;
                        case 7:
                            arrayNode.add(_fromInt(jsonParser, deserializationFeatures, jsonNodeFactory2));
                            break;
                        case 8:
                            arrayNode.add(_fromFloat(jsonParser, deserializationContext, jsonNodeFactory));
                            break;
                        case 9:
                            arrayNode.add(jsonNodeFactory2.booleanNode(true));
                            break;
                        case 10:
                            arrayNode.add(jsonNodeFactory2.booleanNode(false));
                            break;
                        case 11:
                            arrayNode.add(jsonNodeFactory2.nullNode());
                            break;
                    }
                }
            } else {
                ContainerNode containerNode2 = containerNodeObjectNode;
                ObjectNode objectNode = (ObjectNode) containerNodeObjectNode;
                String strNextFieldName = jsonParser.nextFieldName();
                while (strNextFieldName != null) {
                    JsonToken jsonTokenNextToken2 = jsonParser.nextToken();
                    if (jsonTokenNextToken2 == null) {
                        jsonTokenNextToken2 = JsonToken.NOT_AVAILABLE;
                    }
                    int iId = jsonTokenNextToken2.id();
                    if (iId == 1) {
                        ObjectNode objectNode2 = jsonNodeFactory.objectNode();
                        JsonNode jsonNodeReplace2 = objectNode.replace(strNextFieldName, objectNode2);
                        if (jsonNodeReplace2 != null) {
                            jsonNodeFactory2 = jsonNodeFactory;
                            _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory2, strNextFieldName, objectNode, jsonNodeReplace2, objectNode2);
                        } else {
                            jsonNodeFactory2 = jsonNodeFactory;
                        }
                        containerStack.push(containerNode2);
                        objectNode = objectNode2;
                        containerNode2 = objectNode;
                    } else if (iId != 3) {
                        switch (iId) {
                            case 6:
                                jsonNodeTextNode = jsonNodeFactory2.textNode(jsonParser.getText());
                                JsonNode jsonNode = jsonNodeTextNode;
                                jsonNodeReplace = objectNode.replace(strNextFieldName, jsonNode);
                                if (jsonNodeReplace != null) {
                                    _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory2, strNextFieldName, objectNode, jsonNodeReplace, jsonNode);
                                }
                                break;
                            case 7:
                                jsonNodeTextNode = _fromInt(jsonParser, deserializationFeatures, jsonNodeFactory2);
                                JsonNode jsonNode2 = jsonNodeTextNode;
                                jsonNodeReplace = objectNode.replace(strNextFieldName, jsonNode2);
                                if (jsonNodeReplace != null) {
                                }
                                break;
                            case 8:
                                jsonNodeTextNode = _fromFloat(jsonParser, deserializationContext, jsonNodeFactory);
                                JsonNode jsonNode22 = jsonNodeTextNode;
                                jsonNodeReplace = objectNode.replace(strNextFieldName, jsonNode22);
                                if (jsonNodeReplace != null) {
                                }
                                break;
                            case 9:
                                jsonNodeTextNode = jsonNodeFactory2.booleanNode(true);
                                JsonNode jsonNode222 = jsonNodeTextNode;
                                jsonNodeReplace = objectNode.replace(strNextFieldName, jsonNode222);
                                if (jsonNodeReplace != null) {
                                }
                                break;
                            case 10:
                                jsonNodeTextNode = jsonNodeFactory2.booleanNode(false);
                                JsonNode jsonNode2222 = jsonNodeTextNode;
                                jsonNodeReplace = objectNode.replace(strNextFieldName, jsonNode2222);
                                if (jsonNodeReplace != null) {
                                }
                                break;
                            case 11:
                                if (deserializationContext.isEnabled(JsonNodeFeature.READ_NULL_PROPERTIES)) {
                                    jsonNodeTextNode = jsonNodeFactory2.nullNode();
                                    JsonNode jsonNode22222 = jsonNodeTextNode;
                                    jsonNodeReplace = objectNode.replace(strNextFieldName, jsonNode22222);
                                    if (jsonNodeReplace != null) {
                                    }
                                }
                                break;
                            default:
                                jsonNodeTextNode = _deserializeRareScalar(jsonParser, deserializationContext);
                                JsonNode jsonNode222222 = jsonNodeTextNode;
                                jsonNodeReplace = objectNode.replace(strNextFieldName, jsonNode222222);
                                if (jsonNodeReplace != null) {
                                }
                                break;
                        }
                        jsonNodeFactory2 = jsonNodeFactory;
                    } else {
                        ContainerNode containerNodeArrayNode = jsonNodeFactory.arrayNode();
                        JsonNode jsonNodeReplace3 = objectNode.replace(strNextFieldName, containerNodeArrayNode);
                        if (jsonNodeReplace3 != null) {
                            _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strNextFieldName, objectNode, jsonNodeReplace3, containerNodeArrayNode);
                        }
                        containerStack.push(containerNode2);
                        jsonNodeFactory2 = jsonNodeFactory;
                        containerNodeObjectNode = containerNodeArrayNode;
                    }
                    strNextFieldName = jsonParser.nextFieldName();
                }
                containerNodeObjectNode = containerStack.popOrNull();
            }
        } while (containerNodeObjectNode != null);
        return containerNode;
    }

    public final ObjectNode _deserializeObjectAtName(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, ContainerStack containerStack) throws MismatchedInputException {
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        String strCurrentName = jsonParser.currentName();
        while (strCurrentName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            if (jsonTokenNextToken == null) {
                jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
            }
            int iId = jsonTokenNextToken.id();
            JsonNode jsonNode_deserializeAnyScalar = iId != 1 ? iId != 3 ? _deserializeAnyScalar(jsonParser, deserializationContext) : _deserializeContainerNoRecursion(jsonParser, deserializationContext, jsonNodeFactory, containerStack, jsonNodeFactory.arrayNode()) : _deserializeContainerNoRecursion(jsonParser, deserializationContext, jsonNodeFactory, containerStack, jsonNodeFactory.objectNode());
            JsonNode jsonNodeReplace = objectNode.replace(strCurrentName, jsonNode_deserializeAnyScalar);
            if (jsonNodeReplace != null) {
                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strCurrentName, objectNode, jsonNodeReplace, jsonNode_deserializeAnyScalar);
            }
            strCurrentName = jsonParser.nextFieldName();
        }
        return objectNode;
    }

    public final JsonNode _deserializeRareScalar(JsonParser jsonParser, DeserializationContext deserializationContext) {
        int iCurrentTokenId = jsonParser.currentTokenId();
        return iCurrentTokenId != 2 ? iCurrentTokenId != 8 ? iCurrentTokenId != 12 ? (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser) : _fromEmbedded(jsonParser, deserializationContext) : _fromFloat(jsonParser, deserializationContext, deserializationContext.getNodeFactory()) : deserializationContext.getNodeFactory().objectNode();
    }

    public final JsonNode _fromBigDecimal(DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, BigDecimal bigDecimal) {
        DatatypeFeatures datatypeFeatures = deserializationContext.getDatatypeFeatures();
        JsonNodeFeature jsonNodeFeature = JsonNodeFeature.STRIP_TRAILING_BIGDECIMAL_ZEROES;
        if (datatypeFeatures.isExplicitlySet(jsonNodeFeature) ? datatypeFeatures.isEnabled(jsonNodeFeature) : jsonNodeFactory.willStripTrailingBigDecimalZeroes()) {
            try {
                bigDecimal = bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
            } catch (ArithmeticException unused) {
            }
        }
        return jsonNodeFactory.numberNode(bigDecimal);
    }

    public final JsonNode _fromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        Object embeddedObject = jsonParser.getEmbeddedObject();
        return embeddedObject == null ? nodeFactory.nullNode() : embeddedObject.getClass() == byte[].class ? nodeFactory.binaryNode((byte[]) embeddedObject) : embeddedObject instanceof RawValue ? nodeFactory.rawValueNode((RawValue) embeddedObject) : embeddedObject instanceof JsonNode ? (JsonNode) embeddedObject : nodeFactory.pojoNode(embeddedObject);
    }

    public final JsonNode _fromFloat(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) {
        JsonParser.NumberTypeFP numberTypeFP = jsonParser.getNumberTypeFP();
        if (numberTypeFP == JsonParser.NumberTypeFP.BIG_DECIMAL) {
            return _fromBigDecimal(deserializationContext, jsonNodeFactory, jsonParser.getDecimalValue());
        }
        Boolean explicitState = deserializationContext.getDatatypeFeatures().getExplicitState(JsonNodeFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        return explicitState == null ? deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) : explicitState.booleanValue() ? jsonParser.isNaN() ? deserializationContext.isEnabled(JsonNodeFeature.FAIL_ON_NAN_TO_BIG_DECIMAL_COERCION) ? (JsonNode) deserializationContext.handleWeirdNumberValue(handledType(), Double.valueOf(jsonParser.getDoubleValue()), "Cannot convert NaN into BigDecimal", new Object[0]) : jsonNodeFactory.numberNode(jsonParser.getDoubleValue()) : _fromBigDecimal(deserializationContext, jsonNodeFactory, jsonParser.getDecimalValue()) : numberTypeFP == JsonParser.NumberTypeFP.FLOAT32 ? jsonNodeFactory.numberNode(jsonParser.getFloatValue()) : jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
    }

    public final JsonNode _fromInt(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) {
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        JsonParser.NumberType numberType = (StdDeserializer.F_MASK_INT_COERCIONS & deserializationFeatures) != 0 ? DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures) ? JsonParser.NumberType.BIG_INTEGER : DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures) ? JsonParser.NumberType.LONG : jsonParser.getNumberType() : jsonParser.getNumberType();
        return numberType == JsonParser.NumberType.INT ? jsonNodeFactory.numberNode(jsonParser.getIntValue()) : numberType == JsonParser.NumberType.LONG ? jsonNodeFactory.numberNode(jsonParser.getLongValue()) : jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
    }

    public void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws MismatchedInputException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            deserializationContext.reportInputMismatch(JsonNode.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str);
        }
        if (deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)) {
            if (jsonNode.isArray()) {
                ((ArrayNode) jsonNode).add(jsonNode2);
                objectNode.replace(str, jsonNode);
            } else {
                ArrayNode arrayNode = jsonNodeFactory.arrayNode();
                arrayNode.add(jsonNode);
                arrayNode.add(jsonNode2);
                objectNode.replace(str, arrayNode);
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        DeserializationConfig config = deserializationContext.getConfig();
        Boolean defaultMergeable = config.getDefaultMergeable(ArrayNode.class);
        Boolean defaultMergeable2 = config.getDefaultMergeable(ObjectNode.class);
        Boolean defaultMergeable3 = config.getDefaultMergeable(JsonNode.class);
        boolean z_shouldMerge = _shouldMerge(defaultMergeable, defaultMergeable3);
        boolean z_shouldMerge2 = _shouldMerge(defaultMergeable2, defaultMergeable3);
        return (z_shouldMerge == this._mergeArrays && z_shouldMerge2 == this._mergeObjects) ? this : _createWithMerge(z_shouldMerge, z_shouldMerge2);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._supportsUpdates;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JsonNode updateObject(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectNode objectNode, ContainerStack containerStack) throws MismatchedInputException {
        String strCurrentName;
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        ContainerStack containerStack2;
        BaseNodeDeserializer<T> baseNodeDeserializer;
        JsonNode jsonNode_deserializeContainerNoRecursion;
        if (jsonParser.isExpectedStartObjectToken()) {
            strCurrentName = jsonParser.nextFieldName();
        } else {
            if (!jsonParser.hasToken(JsonToken.FIELD_NAME)) {
                return deserialize(jsonParser, deserializationContext);
            }
            strCurrentName = jsonParser.currentName();
        }
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        while (strCurrentName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            JsonNode jsonNode = objectNode.get(strCurrentName);
            if (jsonNode == null) {
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                containerStack2 = containerStack;
                if (jsonTokenNextToken == null) {
                    jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
                }
                int iId = jsonTokenNextToken.id();
                if (iId == 1) {
                    baseNodeDeserializer = this;
                    jsonNode_deserializeContainerNoRecursion = baseNodeDeserializer._deserializeContainerNoRecursion(jsonParser2, deserializationContext2, nodeFactory, containerStack2, nodeFactory.objectNode());
                } else if (iId != 3) {
                    if (iId == 6) {
                        jsonNode_deserializeContainerNoRecursion = nodeFactory.textNode(jsonParser2.getText());
                    } else if (iId != 7) {
                        switch (iId) {
                            case 9:
                                jsonNode_deserializeContainerNoRecursion = nodeFactory.booleanNode(true);
                                break;
                            case 10:
                                jsonNode_deserializeContainerNoRecursion = nodeFactory.booleanNode(false);
                                break;
                            case 11:
                                if (!deserializationContext2.isEnabled(JsonNodeFeature.READ_NULL_PROPERTIES)) {
                                    baseNodeDeserializer = this;
                                } else {
                                    jsonNode_deserializeContainerNoRecursion = nodeFactory.nullNode();
                                }
                                break;
                            default:
                                jsonNode_deserializeContainerNoRecursion = this._deserializeRareScalar(jsonParser2, deserializationContext2);
                                break;
                        }
                    } else {
                        jsonNode_deserializeContainerNoRecursion = this._fromInt(jsonParser2, deserializationContext2, nodeFactory);
                    }
                    baseNodeDeserializer = this;
                } else {
                    baseNodeDeserializer = this;
                    jsonNode_deserializeContainerNoRecursion = baseNodeDeserializer._deserializeContainerNoRecursion(jsonParser2, deserializationContext2, nodeFactory, containerStack2, nodeFactory.arrayNode());
                }
                objectNode.set(strCurrentName, jsonNode_deserializeContainerNoRecursion);
            } else if (jsonNode instanceof ObjectNode) {
                if (jsonTokenNextToken == JsonToken.START_OBJECT && this._mergeObjects) {
                    JsonNode jsonNodeUpdateObject = this.updateObject(jsonParser, deserializationContext, (ObjectNode) jsonNode, containerStack);
                    if (jsonNodeUpdateObject != jsonNode) {
                        objectNode.set(strCurrentName, jsonNodeUpdateObject);
                    }
                    baseNodeDeserializer = this;
                    jsonParser2 = jsonParser;
                    deserializationContext2 = deserializationContext;
                    containerStack2 = containerStack;
                }
            } else if ((jsonNode instanceof ArrayNode) && jsonTokenNextToken == JsonToken.START_ARRAY && this._mergeArrays) {
                ArrayNode arrayNode = (ArrayNode) jsonNode;
                baseNodeDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                containerStack2 = containerStack;
                baseNodeDeserializer._deserializeContainerNoRecursion(jsonParser2, deserializationContext2, nodeFactory, containerStack2, arrayNode);
            }
            strCurrentName = jsonParser2.nextFieldName();
            this = baseNodeDeserializer;
            jsonParser = jsonParser2;
            deserializationContext = deserializationContext2;
            containerStack = containerStack2;
        }
        return objectNode;
    }

    public BaseNodeDeserializer(Class<T> cls, Boolean bool) {
        super((Class<?>) cls);
        this._supportsUpdates = bool;
        this._mergeArrays = true;
        this._mergeObjects = true;
    }

    public final JsonNode _fromInt(JsonParser jsonParser, int i, JsonNodeFactory jsonNodeFactory) {
        if (i != 0) {
            if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(i)) {
                return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
            }
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
        JsonParser.NumberType numberType = jsonParser.getNumberType();
        if (numberType == JsonParser.NumberType.INT) {
            return jsonNodeFactory.numberNode(jsonParser.getIntValue());
        }
        if (numberType == JsonParser.NumberType.LONG) {
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
        return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
    }
}
