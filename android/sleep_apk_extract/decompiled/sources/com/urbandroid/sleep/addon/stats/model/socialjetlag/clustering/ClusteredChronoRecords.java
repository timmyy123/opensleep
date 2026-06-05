package com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecords;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.CyclicDoubleKt;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.CyclicFloatKt;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.KMeansPlusPlusClusterer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.ml.clustering.CentroidCluster;

/* JADX INFO: loaded from: classes4.dex */
public class ClusteredChronoRecords {
    private static final double[] cycles = {24.0d, 1000.0d};
    private final double clusteringStrength;
    private final Map<ChronoRecord, SleepLabel> labels = new HashMap();

    public ClusteredChronoRecords(ChronoRecords chronoRecords) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (chronoRecords.size() < 30) {
            this.clusteringStrength = 0.0d;
        } else {
            CoreAndOutliers<ChronoRecord> coreAndOutliersFindOutliers = findOutliers(new ArrayList(chronoRecords.getRecords().values()));
            double averageSquareDistance = getAverageSquareDistance(cluster(coreAndOutliersFindOutliers.getCore(), 1));
            List<CentroidCluster<ChronoRecordClusterable>> listCluster = cluster(coreAndOutliersFindOutliers.getCore(), 2);
            this.clusteringStrength = averageSquareDistance / getAverageSquareDistance(listCluster);
            assignLabels(listCluster, coreAndOutliersFindOutliers.getOutliers());
        }
        Logger.logDebug("ClusteredChronoRecords elapsedTime: " + (System.currentTimeMillis() - jCurrentTimeMillis) + " strength: " + this.clusteringStrength);
    }

    private void assignLabels(List<CentroidCluster<ChronoRecordClusterable>> list, Collection<ChronoRecord> collection) {
        CentroidCluster<ChronoRecordClusterable> centroidCluster;
        CentroidCluster<ChronoRecordClusterable> centroidCluster2;
        if (list.get(0).getPoints().size() < list.get(1).getPoints().size()) {
            centroidCluster2 = list.get(0);
            centroidCluster = list.get(1);
        } else {
            CentroidCluster<ChronoRecordClusterable> centroidCluster3 = list.get(1);
            centroidCluster = list.get(0);
            centroidCluster2 = centroidCluster3;
        }
        Iterator<ChronoRecordClusterable> it = centroidCluster2.getPoints().iterator();
        while (it.hasNext()) {
            this.labels.put(it.next().getRecord(), SleepLabel.FREE_DAY);
        }
        Iterator<ChronoRecordClusterable> it2 = centroidCluster.getPoints().iterator();
        while (it2.hasNext()) {
            this.labels.put(it2.next().getRecord(), SleepLabel.BUSY_DAY);
        }
        Iterator<ChronoRecord> it3 = collection.iterator();
        while (it3.hasNext()) {
            this.labels.put(it3.next(), SleepLabel.OUTLIER);
        }
    }

    private List<CentroidCluster<ChronoRecordClusterable>> cluster(Collection<ChronoRecord> collection, int i) {
        KMeansPlusPlusClusterer kMeansPlusPlusClusterer = new KMeansPlusPlusClusterer(i, 300, cycles);
        ArrayList arrayList = new ArrayList();
        Iterator<ChronoRecord> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new ChronoRecordClusterable(it.next()));
        }
        return kMeansPlusPlusClusterer.cluster(arrayList);
    }

    private CoreAndOutliers<ChronoRecord> findOutliers(List<ChronoRecord> list) {
        return CoreAndOutliers.compoundQuantileDistance(list, 0.025d, 5.0d, new DoubleFunction<ChronoRecord>() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.ClusteredChronoRecords.1
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.DoubleFunction
            public double apply(ChronoRecord chronoRecord) {
                return chronoRecord.getLength();
            }
        }, new DoubleFunction<ChronoRecord>(list) { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.ClusteredChronoRecords.2
            final float meanToHour;
            final /* synthetic */ List val$records;

            {
                this.val$records = list;
                int size = list.size();
                float[] fArr = new float[size];
                for (int i = 0; i < size; i++) {
                    fArr[i] = getToHour((ChronoRecord) this.val$records.get(i));
                }
                this.meanToHour = CyclicFloatKt.center(fArr, 24.0f);
            }

            private float getToHour(ChronoRecord chronoRecord) {
                return chronoRecord.getToHour();
            }

            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.DoubleFunction
            public double apply(ChronoRecord chronoRecord) {
                return CyclicDoubleKt.signedDistance(getToHour(chronoRecord), this.meanToHour, 24.0d);
            }
        });
    }

    private double getAverageSquareDistance(List<CentroidCluster<ChronoRecordClusterable>> list) {
        KMeansPlusPlusClusterer.CyclicEuclideanDistance cyclicEuclideanDistance = new KMeansPlusPlusClusterer.CyclicEuclideanDistance(cycles);
        double d = 0.0d;
        int i = 0;
        for (CentroidCluster<ChronoRecordClusterable> centroidCluster : list) {
            Iterator<ChronoRecordClusterable> it = centroidCluster.getPoints().iterator();
            while (it.hasNext()) {
                double dCompute = cyclicEuclideanDistance.compute(centroidCluster.getCenter().getPoint(), it.next().getPoint());
                d += dCompute * dCompute;
                i++;
            }
        }
        return d / ((double) i);
    }

    public double getClusteringStrength() {
        return this.clusteringStrength;
    }

    public ChronoRecords getLabeledRecords(SleepLabel sleepLabel) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<ChronoRecord, SleepLabel> entry : this.labels.entrySet()) {
            if (entry.getValue() == sleepLabel) {
                hashSet.add(entry.getKey());
            }
        }
        return new ChronoRecords(hashSet);
    }
}
