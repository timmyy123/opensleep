package com.urbandroid.sleep.addon.stats.model.regression;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.collector.ICollector;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.CoreAndOutliers;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.DoubleFunction;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.optimization.fitting.PolynomialFitter;
import org.apache.commons.math3.optimization.general.LevenbergMarquardtOptimizer;

/* JADX INFO: loaded from: classes4.dex */
public class RegressionCollector implements ICollector, PointSeries {
    private final List<Point> allPoints = new ArrayList();
    private double localMax = -1.0d;
    private final MinMaxFinder minMaxFinder = new MinMaxFinder();
    private final List<Point> modelPoints = new ArrayList();
    private final List<Point> outliersPoints = new ArrayList();
    private final IValueExtractor xExtractor;
    private final IValueExtractor yExtractor;

    public RegressionCollector(IValueExtractor iValueExtractor, IValueExtractor iValueExtractor2) {
        this.xExtractor = iValueExtractor;
        this.yExtractor = iValueExtractor2;
    }

    private void computeRegression() {
        CoreAndOutliers<Point> coreAndOutliersFindOutliers = findOutliers(this.allPoints);
        this.modelPoints.addAll(coreAndOutliersFindOutliers.getCore());
        this.outliersPoints.addAll(coreAndOutliersFindOutliers.getOutliers());
        if (this.modelPoints.size() < 6) {
            return;
        }
        for (Point point : this.modelPoints) {
            this.minMaxFinder.addValueX(point.getX());
            this.minMaxFinder.addValue(point.getY());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 1;
        LevenbergMarquardtOptimizer levenbergMarquardtOptimizer = null;
        while (i <= 3) {
            try {
                LevenbergMarquardtOptimizer levenbergMarquardtOptimizer2 = new LevenbergMarquardtOptimizer();
                PolynomialFitter polynomialFitter = new PolynomialFitter(i, levenbergMarquardtOptimizer2);
                for (Point point2 : this.modelPoints) {
                    polynomialFitter.addObservedPoint(point2.getX(), point2.getY());
                }
                PolynomialFunction polynomialFunction = new PolynomialFunction(polynomialFitter.fit());
                arrayList.clear();
                double minValueX = this.minMaxFinder.getMinValueX();
                Boolean bool = null;
                double d = -1.0d;
                double d2 = -1.0d;
                Boolean bool2 = null;
                double d3 = -1.0d;
                double d4 = -1.0d;
                while (minValueX < this.minMaxFinder.getMaxValueX()) {
                    double dValue = polynomialFunction.value(minValueX);
                    if (d2 > -1.0d) {
                        if (bool != null && !bool2.booleanValue() && bool.booleanValue() && d3 < dValue) {
                            d3 = d2;
                            d = d4;
                        }
                        bool = bool2;
                        bool2 = d2 < dValue ? Boolean.TRUE : Boolean.FALSE;
                    }
                    arrayList.add(new Point(minValueX, dValue));
                    d4 = minValueX;
                    minValueX += 0.1d;
                    d2 = dValue;
                }
                if (d <= this.minMaxFinder.getMinValueX() + 0.1d || d >= this.minMaxFinder.getMaxValueX() - 0.1d || d3 <= this.minMaxFinder.getMinValue() || d3 >= this.minMaxFinder.getMaxValue()) {
                    d = -1.0d;
                }
                Logger.logInfo("Regression " + this.xExtractor.getMeasureName() + " vs." + this.yExtractor.getMeasureName() + " degree " + i + " RMS " + levenbergMarquardtOptimizer2.getRMS() + " max " + this.localMax);
                if (levenbergMarquardtOptimizer != null) {
                    if (levenbergMarquardtOptimizer2.getRMS() * ((this.localMax != -1.0d || d <= 0.0d) ? 1.2d : 0.95d) > levenbergMarquardtOptimizer.getRMS()) {
                        Logger.logInfo("Regression: prev model better RETURN ");
                        this.modelPoints.addAll(arrayList2);
                        return;
                    } else {
                        if (i == 3) {
                            Logger.logInfo("Regression: last model best RETURN LAST, max: " + d);
                            this.modelPoints.addAll(arrayList);
                            this.localMax = d;
                            return;
                        }
                        Logger.logInfo("Regression: got better model CONTINUE ");
                    }
                }
                arrayList2.clear();
                arrayList2.addAll(arrayList);
                this.localMax = d;
                i++;
                levenbergMarquardtOptimizer = levenbergMarquardtOptimizer2;
            } catch (Exception e) {
                Logger.logSevere(e);
                return;
            }
        }
        this.modelPoints.addAll(arrayList);
    }

    private CoreAndOutliers<Point> findOutliers(List<Point> list) {
        return list.size() < 20 ? new CoreAndOutliers<>(list) : CoreAndOutliers.compoundQuantileDistanceXY(list, 0.03d, 6.0d, new DoubleFunction<Point>() { // from class: com.urbandroid.sleep.addon.stats.model.regression.RegressionCollector.1
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.DoubleFunction
            public double apply(Point point) {
                return point.getX();
            }
        }, 0.12d, 5.0d, new DoubleFunction<Point>() { // from class: com.urbandroid.sleep.addon.stats.model.regression.RegressionCollector.2
            @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.DoubleFunction
            public double apply(Point point) {
                return point.getY();
            }
        });
    }

    @Override // com.urbandroid.sleep.addon.stats.model.regression.PointSeries
    public Collection<Point> getCorePoints() {
        return this.modelPoints;
    }

    public double getLocalMax() {
        return this.localMax;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.regression.PointSeries
    public MinMaxFinder getMinMaxFinder() {
        return this.minMaxFinder;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.regression.PointSeries
    public String getXName() {
        return this.xExtractor.getMeasureName();
    }

    @Override // com.urbandroid.sleep.addon.stats.model.regression.PointSeries
    public String getYName() {
        return this.yExtractor.getMeasureName();
    }

    public void init() {
        computeRegression();
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.ICollector
    public void put(IStatRecord iStatRecord) {
        double value = this.xExtractor.getValue(iStatRecord);
        double value2 = this.yExtractor.getValue(iStatRecord);
        if (value <= 0.0d || value2 <= 0.01d) {
            return;
        }
        this.allPoints.add(new Point(value, value2));
    }
}
