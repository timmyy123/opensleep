package com.urbandroid.sleep.audio.transform;

import biz.source_code.dsp.filter.FilterPassType;
import biz.source_code.dsp.filter.IirFilter;
import com.urbandroid.sleep.audio.transform.AudioTransformer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class CachedIirFilterFactory implements AudioTransformer.IirFilterFactory {
    private final AudioTransformer.IirFilterFactory baseFactory = new BaseIirFilterFactory();
    private final Map<Key, IirFilter> cache = new HashMap();

    public class Key {
        final float frequency;
        final int order;
        final int sampleRate;
        final FilterPassType type;

        public Key(FilterPassType filterPassType, int i, float f, int i2) {
            this.type = filterPassType;
            this.sampleRate = i;
            this.frequency = f;
            this.order = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Key key = (Key) obj;
                if (this.sampleRate == key.sampleRate && Float.compare(key.frequency, this.frequency) == 0 && this.order == key.order && this.type == key.type) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + this.sampleRate) * 31;
            float f = this.frequency;
            return ((iHashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.order;
        }
    }

    @Override // com.urbandroid.sleep.audio.transform.AudioTransformer.IirFilterFactory
    public IirFilter create(FilterPassType filterPassType, int i, float f, int i2) {
        Key key = new Key(filterPassType, i, f, i2);
        IirFilter iirFilter = this.cache.get(key);
        if (iirFilter != null) {
            return iirFilter;
        }
        IirFilter iirFilterCreate = this.baseFactory.create(filterPassType, i, f, i2);
        this.cache.put(key, iirFilterCreate);
        return iirFilterCreate;
    }
}
