package org.apache.commons.math3.stat;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class Frequency implements Serializable {
    private static final long serialVersionUID = -3845586908418844111L;
    private final TreeMap<Comparable<?>, Long> freqTable = new TreeMap<>();

    public void addValue(Comparable<?> comparable) {
        incrementValue(comparable, 1L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Frequency)) {
            return false;
        }
        TreeMap<Comparable<?>, Long> treeMap = this.freqTable;
        TreeMap<Comparable<?>, Long> treeMap2 = ((Frequency) obj).freqTable;
        if (treeMap == null) {
            if (treeMap2 != null) {
                return false;
            }
        } else if (!treeMap.equals(treeMap2)) {
            return false;
        }
        return true;
    }

    public long getCount(Comparable<?> comparable) {
        if (comparable instanceof Integer) {
            return getCount(((Integer) comparable).longValue());
        }
        try {
            Long l = this.freqTable.get(comparable);
            if (l != null) {
                return l.longValue();
            }
            return 0L;
        } catch (ClassCastException unused) {
            return 0L;
        }
    }

    public long getCumFreq(Comparable<?> comparable) {
        if (getSumFreq() == 0) {
            return 0L;
        }
        if (comparable instanceof Integer) {
            return getCumFreq(((Integer) comparable).longValue());
        }
        Comparator<? super Comparable<?>> comparator = this.freqTable.comparator();
        if (comparator == null) {
            comparator = new NaturalComparator<>();
        }
        try {
            Long l = this.freqTable.get(comparable);
            long jLongValue = l != null ? l.longValue() : 0L;
            if (comparator.compare(comparable, this.freqTable.firstKey()) < 0) {
                return 0L;
            }
            if (comparator.compare(comparable, this.freqTable.lastKey()) >= 0) {
                return getSumFreq();
            }
            Iterator<Comparable<?>> itValuesIterator = valuesIterator();
            while (itValuesIterator.hasNext()) {
                Comparable<?> next = itValuesIterator.next();
                if (comparator.compare(comparable, next) <= 0) {
                    break;
                }
                jLongValue += getCount(next);
            }
            return jLongValue;
        } catch (ClassCastException unused) {
            return 0L;
        }
    }

    public double getCumPct(Comparable<?> comparable) {
        long sumFreq = getSumFreq();
        if (sumFreq == 0) {
            return Double.NaN;
        }
        return getCumFreq(comparable) / sumFreq;
    }

    public List<Comparable<?>> getMode() {
        Iterator<Long> it = this.freqTable.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (jLongValue > j) {
                j = jLongValue;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Comparable<?>, Long> entry : this.freqTable.entrySet()) {
            if (entry.getValue().longValue() == j) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public double getPct(Comparable<?> comparable) {
        long sumFreq = getSumFreq();
        if (sumFreq == 0) {
            return Double.NaN;
        }
        return getCount(comparable) / sumFreq;
    }

    public long getSumFreq() {
        Iterator<Long> it = this.freqTable.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public int hashCode() {
        TreeMap<Comparable<?>, Long> treeMap = this.freqTable;
        return 31 + (treeMap == null ? 0 : treeMap.hashCode());
    }

    public void incrementValue(Comparable<?> comparable, long j) {
        Comparable<?> comparableValueOf = comparable instanceof Integer ? Long.valueOf(((Integer) comparable).longValue()) : comparable;
        try {
            Long l = this.freqTable.get(comparableValueOf);
            TreeMap<Comparable<?>, Long> treeMap = this.freqTable;
            if (l == null) {
                treeMap.put(comparableValueOf, Long.valueOf(j));
            } else {
                treeMap.put(comparableValueOf, Long.valueOf(l.longValue() + j));
            }
        } catch (ClassCastException unused) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSTANCES_NOT_COMPARABLE_TO_EXISTING_VALUES, comparable.getClass().getName());
        }
    }

    public String toString() {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        StringBuilder sb = new StringBuilder("Value \t Freq. \t Pct. \t Cum Pct. \n");
        for (Comparable<?> comparable : this.freqTable.keySet()) {
            sb.append(comparable);
            sb.append('\t');
            sb.append(getCount(comparable));
            sb.append('\t');
            sb.append(percentInstance.format(getPct(comparable)));
            sb.append('\t');
            sb.append(percentInstance.format(getCumPct(comparable)));
            sb.append('\n');
        }
        return sb.toString();
    }

    public Iterator<Comparable<?>> valuesIterator() {
        return this.freqTable.keySet().iterator();
    }

    public static class NaturalComparator<T extends Comparable<T>> implements Comparator<Comparable<T>>, Serializable {
        private static final long serialVersionUID = -3852193713161395148L;

        private NaturalComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Comparable<T> comparable, Comparable<T> comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public long getCount(long j) {
        return getCount(Long.valueOf(j));
    }

    public long getCumFreq(long j) {
        return getCumFreq(Long.valueOf(j));
    }
}
