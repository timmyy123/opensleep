package com.urbandroid.sleep.addon.stats.model.collector;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.IMeasure;
import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.addon.stats.model.extractor.DurationExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes4.dex */
public class TagMapStatCollector implements IStatCollector {
    private final IValueExtractor extractor;
    private final IValueExtractor lengthExtractor;
    private final IMeasure measure;
    private final String title;
    private TreeMap<String, Average> tagMap = new TreeMap<>();
    private final TreeMap<String, Average> complementTagMap = new TreeMap<>();

    public TagMapStatCollector(Context context, IMeasure iMeasure, String str) {
        this.title = str;
        this.measure = iMeasure;
        this.extractor = iMeasure.getExtractor(context);
        this.lengthExtractor = new DurationExtractor(context);
        this.tagMap.put(" AVERAGE", iMeasure.isWeighted() ? new WeightedAverage() : new Average());
    }

    public static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        TreeSet treeSet = new TreeSet(new Comparator<Map.Entry<K, V>>() { // from class: com.urbandroid.sleep.addon.stats.model.collector.TagMapStatCollector.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<K, V> entry, Map.Entry<K, V> entry2) {
                int iCompareTo = ((Comparable) entry.getValue()).compareTo(entry2.getValue());
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                return 1;
            }
        });
        treeSet.addAll(map.entrySet());
        return treeSet;
    }

    public TreeMap<String, Average> getComplementTagMap() {
        return this.complementTagMap;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public List<String> getLabels() {
        SortedSet sortedSetEntriesSortedByValues = entriesSortedByValues(this.tagMap);
        ArrayList arrayList = new ArrayList();
        Iterator it = sortedSetEntriesSortedByValues.iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            if (this.tagMap.get(str) != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public String getMeasureTitle() {
        return this.extractor.getMeasureName();
    }

    public TreeMap<String, Average> getTagMap() {
        return this.tagMap;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public String getTitle() {
        return this.title;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public List<Double> getValues() {
        List<String> labels = getLabels();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = labels.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(this.tagMap.get(it.next()).getMeasure()));
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.ICollector
    public void put(IStatRecord iStatRecord) {
        Set<String> tags = iStatRecord.getTags();
        double value = this.extractor.getValue(iStatRecord);
        if (value < 0.0d) {
            return;
        }
        IMeasure iMeasure = this.measure;
        if ((iMeasure == Measure.RATING || iMeasure == Measure.NOISE_LEVEL) && value == 0.0d) {
            return;
        }
        double value2 = this.lengthExtractor.getValue(iStatRecord);
        int count = iStatRecord.getCount();
        this.tagMap.get(" AVERAGE").addValue(value, value2, count);
        if (tags.isEmpty()) {
            return;
        }
        for (String str : tags) {
            Average weightedAverage = this.tagMap.get(str);
            if (weightedAverage == null) {
                weightedAverage = this.measure.isWeighted() ? new WeightedAverage() : new Average();
                this.tagMap.put(str, weightedAverage);
            }
            weightedAverage.addValue(value, value2, count);
        }
    }
}
