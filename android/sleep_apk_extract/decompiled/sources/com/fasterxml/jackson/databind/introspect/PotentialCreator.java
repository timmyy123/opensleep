package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PotentialCreator {
    private static final PropertyName[] NO_NAMES = new PropertyName[0];
    private final AnnotatedWithParams _creator;
    private JsonCreator.Mode _creatorMode;
    private PropertyName[] _explicitParamNames;
    private PropertyName[] _implicitParamNames;
    private final boolean _isAnnotated;
    private List<BeanPropertyDefinition> _propertyDefs;

    public PotentialCreator(AnnotatedWithParams annotatedWithParams, JsonCreator.Mode mode) {
        this._creator = annotatedWithParams;
        this._isAnnotated = mode != null;
        this._creatorMode = mode == null ? JsonCreator.Mode.DEFAULT : mode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void assignPropertyDefs(List<? extends BeanPropertyDefinition> list) {
        this._propertyDefs = list;
    }

    public AnnotatedWithParams creator() {
        return this._creator;
    }

    public JsonCreator.Mode creatorMode() {
        return this._creatorMode;
    }

    public JsonCreator.Mode creatorModeOrDefault() {
        JsonCreator.Mode mode = this._creatorMode;
        return mode == null ? JsonCreator.Mode.DEFAULT : mode;
    }

    public PropertyName explicitName(int i) {
        return this._explicitParamNames[i];
    }

    public boolean hasExplicitNames() {
        int length = this._explicitParamNames.length;
        for (int i = 0; i < length; i++) {
            if (this._explicitParamNames[i] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasNameFor(int i) {
        return (this._explicitParamNames[i] == null && this._implicitParamNames[i] == null) ? false : true;
    }

    public boolean hasNameOrInjectForAllParams(MapperConfig<?> mapperConfig) {
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        int length = this._implicitParamNames.length;
        for (int i = 0; i < length; i++) {
            if (!hasNameFor(i) && (annotationIntrospector == null || annotationIntrospector.findInjectableValue(this._creator.getParameter(i)) == null)) {
                return false;
            }
        }
        return true;
    }

    public PropertyName implicitName(int i) {
        return this._implicitParamNames[i];
    }

    public String implicitNameSimple(int i) {
        PropertyName propertyName = this._implicitParamNames[i];
        if (propertyName == null) {
            return null;
        }
        return propertyName.getSimpleName();
    }

    public PotentialCreator introspectParamNames(MapperConfig<?> mapperConfig) {
        if (this._implicitParamNames == null) {
            int parameterCount = this._creator.getParameterCount();
            if (parameterCount == 0) {
                PropertyName[] propertyNameArr = NO_NAMES;
                this._explicitParamNames = propertyNameArr;
                this._implicitParamNames = propertyNameArr;
                return this;
            }
            this._explicitParamNames = new PropertyName[parameterCount];
            this._implicitParamNames = new PropertyName[parameterCount];
            AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
            for (int i = 0; i < parameterCount; i++) {
                AnnotatedParameter parameter = this._creator.getParameter(i);
                String strFindImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(parameter);
                if (strFindImplicitPropertyName != null && !strFindImplicitPropertyName.isEmpty()) {
                    this._implicitParamNames[i] = PropertyName.construct(strFindImplicitPropertyName);
                }
                PropertyName propertyNameFindNameForDeserialization = annotationIntrospector.findNameForDeserialization(parameter);
                if (propertyNameFindNameForDeserialization != null && !propertyNameFindNameForDeserialization.isEmpty()) {
                    this._explicitParamNames[i] = propertyNameFindNameForDeserialization;
                }
            }
        }
        return this;
    }

    public boolean isAnnotated() {
        return this._isAnnotated;
    }

    public AnnotatedParameter param(int i) {
        return this._creator.getParameter(i);
    }

    public int paramCount() {
        return this._creator.getParameterCount();
    }

    public BeanPropertyDefinition[] propertyDefs() {
        List<BeanPropertyDefinition> list = this._propertyDefs;
        if (list == null || list.isEmpty()) {
            return new BeanPropertyDefinition[0];
        }
        List<BeanPropertyDefinition> list2 = this._propertyDefs;
        return (BeanPropertyDefinition[]) list2.toArray(new BeanPropertyDefinition[list2.size()]);
    }

    public String toString() {
        return "(mode=" + this._creatorMode + ")" + this._creator;
    }

    public PotentialCreator introspectParamNames(MapperConfig<?> mapperConfig, PropertyName[] propertyNameArr) {
        if (this._implicitParamNames == null) {
            int parameterCount = this._creator.getParameterCount();
            if (parameterCount == 0) {
                PropertyName[] propertyNameArr2 = NO_NAMES;
                this._explicitParamNames = propertyNameArr2;
                this._implicitParamNames = propertyNameArr2;
                return this;
            }
            this._explicitParamNames = new PropertyName[parameterCount];
            this._implicitParamNames = propertyNameArr;
            AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
            for (int i = 0; i < parameterCount; i++) {
                PropertyName propertyNameFindNameForDeserialization = annotationIntrospector.findNameForDeserialization(this._creator.getParameter(i));
                if (propertyNameFindNameForDeserialization != null && !propertyNameFindNameForDeserialization.isEmpty()) {
                    this._explicitParamNames[i] = propertyNameFindNameForDeserialization;
                }
            }
        }
        return this;
    }
}
