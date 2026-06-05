package twitter4j;

import java.io.Serializable;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public interface Trends extends Serializable, Comparable<Trends> {
    Date getAsOf();

    Date getTrendAt();

    Trend[] getTrends();
}
