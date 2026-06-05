package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CoercionConfigs implements Serializable {
    private static final int TARGET_TYPE_COUNT = LogicalType.values().length;
    private static final long serialVersionUID = 1;
    protected CoercionAction _defaultAction;
    protected final MutableCoercionConfig _defaultCoercions;
    protected Map<Class<?>, MutableCoercionConfig> _perClassCoercions;
    protected MutableCoercionConfig[] _perTypeCoercions;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.cfg.CoercionConfigs$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionInputShape;

        static {
            int[] iArr = new int[CoercionInputShape.values().length];
            $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionInputShape = iArr;
            try {
                iArr[CoercionInputShape.EmptyArray.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionInputShape[CoercionInputShape.Float.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionInputShape[CoercionInputShape.Integer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CoercionConfigs() {
        this(CoercionAction.TryConvert, new MutableCoercionConfig(), null, null);
    }

    public boolean _isScalarType(LogicalType logicalType) {
        return logicalType == LogicalType.Float || logicalType == LogicalType.Integer || logicalType == LogicalType.Boolean || logicalType == LogicalType.DateTime;
    }

    public CoercionAction findCoercion(DeserializationConfig deserializationConfig, LogicalType logicalType, Class<?> cls, CoercionInputShape coercionInputShape) {
        MutableCoercionConfig mutableCoercionConfig;
        CoercionAction coercionActionFindAction;
        MutableCoercionConfig mutableCoercionConfig2;
        CoercionAction coercionActionFindAction2;
        Map<Class<?>, MutableCoercionConfig> map = this._perClassCoercions;
        if (map != null && cls != null && (mutableCoercionConfig2 = map.get(cls)) != null && (coercionActionFindAction2 = mutableCoercionConfig2.findAction(coercionInputShape)) != null) {
            return coercionActionFindAction2;
        }
        MutableCoercionConfig[] mutableCoercionConfigArr = this._perTypeCoercions;
        if (mutableCoercionConfigArr != null && logicalType != null && (mutableCoercionConfig = mutableCoercionConfigArr[logicalType.ordinal()]) != null && (coercionActionFindAction = mutableCoercionConfig.findAction(coercionInputShape)) != null) {
            return coercionActionFindAction;
        }
        CoercionAction coercionActionFindAction3 = this._defaultCoercions.findAction(coercionInputShape);
        if (coercionActionFindAction3 != null) {
            return coercionActionFindAction3;
        }
        int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionInputShape[coercionInputShape.ordinal()];
        if (i == 1) {
            return deserializationConfig.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT) ? CoercionAction.AsNull : CoercionAction.Fail;
        }
        if (i != 2) {
            if (i == 3 && logicalType == LogicalType.Enum && deserializationConfig.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                return CoercionAction.Fail;
            }
        } else if (logicalType == LogicalType.Integer) {
            return deserializationConfig.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT) ? CoercionAction.TryConvert : CoercionAction.Fail;
        }
        boolean z_isScalarType = _isScalarType(logicalType);
        return (!z_isScalarType || deserializationConfig.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS) || (logicalType == LogicalType.Float && coercionInputShape == CoercionInputShape.Integer)) ? coercionInputShape == CoercionInputShape.EmptyString ? logicalType == LogicalType.OtherScalar ? CoercionAction.TryConvert : (z_isScalarType || deserializationConfig.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) ? CoercionAction.AsNull : CoercionAction.Fail : this._defaultAction : CoercionAction.Fail;
    }

    public CoercionAction findCoercionFromBlankString(DeserializationConfig deserializationConfig, LogicalType logicalType, Class<?> cls, CoercionAction coercionAction) {
        Boolean acceptBlankAsEmpty;
        CoercionAction coercionActionFindAction;
        MutableCoercionConfig mutableCoercionConfig;
        MutableCoercionConfig mutableCoercionConfig2;
        Map<Class<?>, MutableCoercionConfig> map = this._perClassCoercions;
        if (map == null || cls == null || (mutableCoercionConfig2 = map.get(cls)) == null) {
            acceptBlankAsEmpty = null;
            coercionActionFindAction = null;
        } else {
            acceptBlankAsEmpty = mutableCoercionConfig2.getAcceptBlankAsEmpty();
            coercionActionFindAction = mutableCoercionConfig2.findAction(CoercionInputShape.EmptyString);
        }
        MutableCoercionConfig[] mutableCoercionConfigArr = this._perTypeCoercions;
        if (mutableCoercionConfigArr != null && logicalType != null && (mutableCoercionConfig = mutableCoercionConfigArr[logicalType.ordinal()]) != null) {
            if (acceptBlankAsEmpty == null) {
                acceptBlankAsEmpty = mutableCoercionConfig.getAcceptBlankAsEmpty();
            }
            if (coercionActionFindAction == null) {
                coercionActionFindAction = mutableCoercionConfig.findAction(CoercionInputShape.EmptyString);
            }
        }
        if (acceptBlankAsEmpty == null) {
            acceptBlankAsEmpty = this._defaultCoercions.getAcceptBlankAsEmpty();
        }
        if (coercionActionFindAction == null) {
            coercionActionFindAction = this._defaultCoercions.findAction(CoercionInputShape.EmptyString);
        }
        if (!Boolean.FALSE.equals(acceptBlankAsEmpty)) {
            if (coercionActionFindAction != null) {
                return coercionActionFindAction;
            }
            if (_isScalarType(logicalType)) {
                return CoercionAction.AsNull;
            }
            if (deserializationConfig.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
                return CoercionAction.AsNull;
            }
        }
        return coercionAction;
    }

    public CoercionConfigs(CoercionAction coercionAction, MutableCoercionConfig mutableCoercionConfig, MutableCoercionConfig[] mutableCoercionConfigArr, Map<Class<?>, MutableCoercionConfig> map) {
        this._defaultCoercions = mutableCoercionConfig;
        this._defaultAction = coercionAction;
        this._perTypeCoercions = mutableCoercionConfigArr;
        this._perClassCoercions = map;
    }
}
