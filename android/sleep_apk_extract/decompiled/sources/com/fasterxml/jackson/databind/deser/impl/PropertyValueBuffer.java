package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyValue;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
public class PropertyValueBuffer {
    protected PropertyValue _anyParamBuffered;
    protected final SettableAnyProperty _anyParamSetter;
    protected PropertyValue _buffered;
    protected final DeserializationContext _context;
    protected final Object[] _creatorParameters;
    protected Object _idValue;
    protected final BitSet _injectablePropIndexes;
    protected final ObjectIdReader _objectIdReader;
    protected int _paramsNeeded;
    protected int _paramsSeen;
    protected final BitSet _paramsSeenBig;
    protected final JsonParser _parser;

    public PropertyValueBuffer(JsonParser jsonParser, DeserializationContext deserializationContext, int i, ObjectIdReader objectIdReader, SettableAnyProperty settableAnyProperty, BitSet bitSet) {
        this._parser = jsonParser;
        this._context = deserializationContext;
        this._paramsNeeded = i;
        this._objectIdReader = objectIdReader;
        this._creatorParameters = new Object[i];
        if (i < 32) {
            this._paramsSeenBig = null;
        } else {
            this._paramsSeenBig = new BitSet();
        }
        if (settableAnyProperty == null || settableAnyProperty.getParameterIndex() < 0) {
            this._anyParamSetter = null;
        } else {
            this._anyParamSetter = settableAnyProperty;
        }
        this._injectablePropIndexes = bitSet != null ? (BitSet) bitSet.clone() : null;
    }

    private Object _createAndSetAnySetterValue() throws JsonMappingException {
        Object objCreateParameterObject = this._anyParamSetter.createParameterObject();
        for (PropertyValue propertyValue = this._anyParamBuffered; propertyValue != null; propertyValue = propertyValue.next) {
            try {
                propertyValue.setValue(objCreateParameterObject);
            } catch (JsonMappingException e) {
                throw e;
            } catch (IOException e2) {
                throw JsonMappingException.fromUnexpectedIOE(e2);
            }
        }
        return objCreateParameterObject;
    }

    private void _inject(SettableBeanProperty settableBeanProperty) {
        Object objFindInjectableValue;
        JacksonInject.Value injectionDefinition = settableBeanProperty.getInjectionDefinition();
        if (injectionDefinition != null) {
            Boolean useInput = injectionDefinition.getUseInput();
            if (Boolean.TRUE.equals(useInput) || (objFindInjectableValue = this._context.findInjectableValue(injectionDefinition.getId(), settableBeanProperty, settableBeanProperty.getMember(), injectionDefinition.getOptional(), useInput)) == null) {
                return;
            }
            this._creatorParameters[settableBeanProperty.getCreatorIndex()] = objFindInjectableValue;
        }
    }

    public Object _findMissing(SettableBeanProperty settableBeanProperty) throws DatabindException {
        if (this._anyParamSetter != null && settableBeanProperty.getCreatorIndex() == this._anyParamSetter.getParameterIndex() && this._anyParamBuffered != null) {
            return null;
        }
        JacksonInject.Value injectionDefinition = settableBeanProperty.getInjectionDefinition();
        if (injectionDefinition != null) {
            this._injectablePropIndexes.clear(settableBeanProperty.getCreatorIndex());
            return this._context.findInjectableValue(settableBeanProperty.getInjectableValueId(), settableBeanProperty, null, injectionDefinition.getOptional(), injectionDefinition.getUseInput());
        }
        if (settableBeanProperty.isRequired()) {
            this._context.reportInputMismatch(settableBeanProperty, "Missing required creator property '%s' (index %d)", settableBeanProperty.getName(), Integer.valueOf(settableBeanProperty.getCreatorIndex()));
        }
        if (this._context.isEnabled(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
            this._context.reportInputMismatch(settableBeanProperty, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", settableBeanProperty.getName(), Integer.valueOf(settableBeanProperty.getCreatorIndex()));
        }
        try {
            Object absentValue = settableBeanProperty.getNullValueProvider().getAbsentValue(this._context);
            return absentValue != null ? absentValue : settableBeanProperty.getValueDeserializer().getAbsentValue(this._context);
        } catch (DatabindException e) {
            AnnotatedMember member = settableBeanProperty.getMember();
            if (member == null) {
                throw e;
            }
            e.prependPath(member.getDeclaringClass(), settableBeanProperty.getName());
            throw e;
        }
    }

    public boolean assignParameter(SettableBeanProperty settableBeanProperty, Object obj) {
        int creatorIndex = settableBeanProperty.getCreatorIndex();
        this._creatorParameters[creatorIndex] = obj;
        BitSet bitSet = this._paramsSeenBig;
        if (bitSet == null) {
            int i = this._paramsSeen;
            int i2 = (1 << creatorIndex) | i;
            if (i != i2) {
                this._paramsSeen = i2;
                int i3 = this._paramsNeeded - 1;
                this._paramsNeeded = i3;
                if (i3 <= 0) {
                    return this._objectIdReader == null || this._idValue != null;
                }
            }
        } else if (!bitSet.get(creatorIndex)) {
            this._paramsSeenBig.set(creatorIndex);
            int i4 = this._paramsNeeded - 1;
            this._paramsNeeded = i4;
            if (i4 <= 0) {
                return this._objectIdReader == null || this._idValue != null;
            }
        }
        return false;
    }

    public void bufferAnyParameterProperty(SettableAnyProperty settableAnyProperty, String str, Object obj) {
        this._anyParamBuffered = new PropertyValue.AnyParameter(this._anyParamBuffered, obj, settableAnyProperty, str);
    }

    public void bufferAnyProperty(SettableAnyProperty settableAnyProperty, String str, Object obj) {
        this._buffered = new PropertyValue.Any(this._buffered, obj, settableAnyProperty, str);
    }

    public void bufferMapProperty(Object obj, Object obj2) {
        this._buffered = new PropertyValue.Map(this._buffered, obj2, obj);
    }

    public void bufferMergingProperty(SettableBeanProperty settableBeanProperty, TokenBuffer tokenBuffer) {
        this._buffered = new PropertyValue.Merging(this._buffered, tokenBuffer, settableBeanProperty);
    }

    public void bufferProperty(SettableBeanProperty settableBeanProperty, Object obj) {
        this._buffered = new PropertyValue.Regular(this._buffered, obj, settableBeanProperty);
    }

    public PropertyValue buffered() {
        return this._buffered;
    }

    public Object[] getParameters(SettableBeanProperty[] settableBeanPropertyArr) throws MismatchedInputException {
        if (this._paramsNeeded > 0) {
            if (this._paramsSeenBig != null) {
                int length = this._creatorParameters.length;
                int i = 0;
                while (true) {
                    int iNextClearBit = this._paramsSeenBig.nextClearBit(i);
                    if (iNextClearBit >= length) {
                        break;
                    }
                    this._creatorParameters[iNextClearBit] = _findMissing(settableBeanPropertyArr[iNextClearBit]);
                    i = iNextClearBit + 1;
                }
            } else {
                int i2 = this._paramsSeen;
                int length2 = this._creatorParameters.length;
                int i3 = 0;
                while (i3 < length2) {
                    if ((i2 & 1) == 0) {
                        this._creatorParameters[i3] = _findMissing(settableBeanPropertyArr[i3]);
                    }
                    i3++;
                    i2 >>= 1;
                }
            }
        }
        SettableAnyProperty settableAnyProperty = this._anyParamSetter;
        if (settableAnyProperty != null) {
            this._creatorParameters[settableAnyProperty.getParameterIndex()] = _createAndSetAnySetterValue();
        }
        BitSet bitSet = this._injectablePropIndexes;
        if (bitSet != null) {
            int iNextSetBit = bitSet.nextSetBit(0);
            while (iNextSetBit >= 0) {
                _inject(settableBeanPropertyArr[iNextSetBit]);
                iNextSetBit = this._injectablePropIndexes.nextSetBit(iNextSetBit + 1);
            }
        }
        if (this._context.isEnabled(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES)) {
            int length3 = this._creatorParameters.length;
            for (int i4 = 0; i4 < length3; i4++) {
                if (this._creatorParameters[i4] == null) {
                    SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i4];
                    this._context.reportInputMismatch(settableBeanProperty, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", settableBeanProperty.getName(), Integer.valueOf(settableBeanPropertyArr[i4].getCreatorIndex()));
                }
            }
        }
        return this._creatorParameters;
    }

    public Object handleIdValue(DeserializationContext deserializationContext, Object obj) {
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader != null) {
            Object obj2 = this._idValue;
            if (obj2 != null) {
                ObjectIdGenerator<?> objectIdGenerator = objectIdReader.generator;
                objectIdReader.getClass();
                deserializationContext.findObjectId(obj2, objectIdGenerator, null).bindItem(obj);
                SettableBeanProperty settableBeanProperty = this._objectIdReader.idProperty;
                if (settableBeanProperty != null && !(settableBeanProperty instanceof CreatorProperty)) {
                    return settableBeanProperty.setAndReturn(obj, this._idValue);
                }
            } else {
                deserializationContext.reportUnresolvedObjectId(objectIdReader, obj);
            }
        }
        return obj;
    }

    public boolean readIdProperty(String str) {
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader == null || !str.equals(objectIdReader.propertyName.getSimpleName())) {
            return false;
        }
        this._idValue = this._objectIdReader.readObjectReference(this._parser, this._context);
        return true;
    }
}
