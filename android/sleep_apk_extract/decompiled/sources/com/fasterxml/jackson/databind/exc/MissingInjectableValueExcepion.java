package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: loaded from: classes3.dex */
public class MissingInjectableValueExcepion extends JsonMappingException {
    private static final long serialVersionUID = 1;
    protected final Object _beanInstance;
    protected final BeanProperty _forProperty;
    protected final Object _valueId;

    public MissingInjectableValueExcepion(JsonParser jsonParser, String str, Object obj, BeanProperty beanProperty, Object obj2) {
        super(jsonParser, str);
        this._valueId = obj;
        this._forProperty = beanProperty;
        this._beanInstance = obj2;
    }

    public static MissingInjectableValueExcepion from(JsonParser jsonParser, String str, Object obj, BeanProperty beanProperty, Object obj2) {
        return new MissingInjectableValueExcepion(jsonParser, str, obj, beanProperty, obj2);
    }
}
