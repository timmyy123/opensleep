package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DatatypeFeatures implements Serializable {
    private static final long serialVersionUID = 1;
    private final int _enabledFor1;
    private final int _enabledFor2;
    private final int _explicitFor1;
    private final int _explicitFor2;

    public static class DefaultHolder {
        private static final DatatypeFeatures DEFAULT_FEATURES = new DatatypeFeatures(collectDefaults(EnumFeature.values()), 0, collectDefaults(JsonNodeFeature.values()), 0);

        /* JADX WARN: Incorrect types in method signature: <F:Ljava/lang/Enum<TF;>;:Lcom/fasterxml/jackson/core/util/JacksonFeature;>([TF;)I */
        /* JADX WARN: Multi-variable type inference failed */
        private static int collectDefaults(Enum[] enumArr) {
            int mask = 0;
            for (JsonNodeFeature jsonNodeFeature : enumArr) {
                if (jsonNodeFeature.enabledByDefault()) {
                    mask |= jsonNodeFeature.getMask();
                }
            }
            return mask;
        }

        public static DatatypeFeatures getDefault() {
            return DEFAULT_FEATURES;
        }
    }

    public DatatypeFeatures(int i, int i2, int i3, int i4) {
        this._enabledFor1 = i;
        this._explicitFor1 = i2;
        this._enabledFor2 = i3;
        this._explicitFor2 = i4;
    }

    public static DatatypeFeatures defaultFeatures() {
        return DefaultHolder.getDefault();
    }

    public Boolean getExplicitState(DatatypeFeature datatypeFeature) {
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            if (datatypeFeature.enabledIn(this._explicitFor1)) {
                return Boolean.valueOf(datatypeFeature.enabledIn(this._enabledFor1));
            }
            return null;
        }
        if (iFeatureIndex != 1) {
            VersionUtil.throwInternal();
            return null;
        }
        if (datatypeFeature.enabledIn(this._explicitFor2)) {
            return Boolean.valueOf(datatypeFeature.enabledIn(this._enabledFor2));
        }
        return null;
    }

    public boolean isEnabled(DatatypeFeature datatypeFeature) {
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            return datatypeFeature.enabledIn(this._enabledFor1);
        }
        if (iFeatureIndex == 1) {
            return datatypeFeature.enabledIn(this._enabledFor2);
        }
        VersionUtil.throwInternal();
        return false;
    }

    public boolean isExplicitlySet(DatatypeFeature datatypeFeature) {
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            return datatypeFeature.enabledIn(this._explicitFor1);
        }
        if (iFeatureIndex == 1) {
            return datatypeFeature.enabledIn(this._explicitFor2);
        }
        VersionUtil.throwInternal();
        return false;
    }
}
