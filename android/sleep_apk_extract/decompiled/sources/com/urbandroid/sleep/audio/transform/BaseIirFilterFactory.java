package com.urbandroid.sleep.audio.transform;

import biz.source_code.dsp.filter.FilterCharacteristicsType;
import biz.source_code.dsp.filter.FilterPassType;
import biz.source_code.dsp.filter.IirFilter;
import biz.source_code.dsp.filter.IirFilterDesignFisher;
import com.urbandroid.sleep.audio.transform.AudioTransformer;

/* JADX INFO: loaded from: classes4.dex */
public class BaseIirFilterFactory implements AudioTransformer.IirFilterFactory {
    @Override // com.urbandroid.sleep.audio.transform.AudioTransformer.IirFilterFactory
    public IirFilter create(FilterPassType filterPassType, int i, float f, int i2) {
        return new IirFilter(IirFilterDesignFisher.design(filterPassType, FilterCharacteristicsType.butterworth, i2, -1.0d, f / i, -1.0d));
    }
}
