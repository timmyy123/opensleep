package com.urbandroid.sleep.addon.stats.model;

import com.urbandroid.sleep.addon.stats.model.collector.SemanticCollector;
import com.urbandroid.sleep.addon.stats.model.collector.WeekdayCollector;

/* JADX INFO: loaded from: classes4.dex */
public interface IStatRepo {
    SemanticCollector getEfficiencyCollector();

    SemanticCollector getHrCollector();

    SemanticCollector getHrvCollector();

    SemanticCollector getHrvGainCollector();

    SemanticCollector getLengthCollector();

    SemanticCollector getMinHrCollector();

    SemanticCollector getQualityCollector();

    SemanticCollector getRatingCollector();

    SemanticCollector getRdiCollector();

    WeekdayCollector getRegularityIndexCollector();

    SemanticCollector getSnoringCollector();
}
