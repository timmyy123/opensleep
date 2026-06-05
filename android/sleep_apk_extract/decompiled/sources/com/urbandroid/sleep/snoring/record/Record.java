package com.urbandroid.sleep.snoring.record;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Record {
    private final List<String> featureNames = new ArrayList();
    private final List<Object> features = new ArrayList();
    private final Map<String, Object> properties = new HashMap();

    public void addFeature(String str, Object obj) {
        this.featureNames.add(str);
        this.features.add(obj);
    }

    public <T> T get(String str) {
        if (this.properties.containsKey(str)) {
            return (T) this.properties.get(str);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Property not found: ", str));
        return null;
    }

    public List<String> getFeatureNames() {
        return Collections.unmodifiableList(this.featureNames);
    }

    public <T> T getLastFeature() {
        return (T) FileInsert$$ExternalSyntheticOutline0.m(this.features, 1);
    }

    public Map<String, Object> getProperties() {
        return Collections.unmodifiableMap(this.properties);
    }

    public void set(String str, Object obj) {
        this.properties.put(str, obj);
    }
}
