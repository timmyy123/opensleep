package com.urbandroid.sleep.graph;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/graph/GraphLegendType;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_LEVEL_CHART", "ACTIGRAPH", "HYPNOGRAM", "NOISE_GRAPH", "SENSOR_GRAPH", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GraphLegendType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GraphLegendType[] $VALUES;
    public static final GraphLegendType TOP_LEVEL_CHART = new GraphLegendType("TOP_LEVEL_CHART", 0);
    public static final GraphLegendType ACTIGRAPH = new GraphLegendType("ACTIGRAPH", 1);
    public static final GraphLegendType HYPNOGRAM = new GraphLegendType("HYPNOGRAM", 2);
    public static final GraphLegendType NOISE_GRAPH = new GraphLegendType("NOISE_GRAPH", 3);
    public static final GraphLegendType SENSOR_GRAPH = new GraphLegendType("SENSOR_GRAPH", 4);

    private static final /* synthetic */ GraphLegendType[] $values() {
        return new GraphLegendType[]{TOP_LEVEL_CHART, ACTIGRAPH, HYPNOGRAM, NOISE_GRAPH, SENSOR_GRAPH};
    }

    static {
        GraphLegendType[] graphLegendTypeArr$values = $values();
        $VALUES = graphLegendTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(graphLegendTypeArr$values);
    }

    private GraphLegendType(String str, int i) {
    }

    public static GraphLegendType valueOf(String str) {
        return (GraphLegendType) Enum.valueOf(GraphLegendType.class, str);
    }

    public static GraphLegendType[] values() {
        return (GraphLegendType[]) $VALUES.clone();
    }
}
