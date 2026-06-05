package twitter4j;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public interface Trend extends Serializable {
    String getName();

    String getQuery();

    int getTweetVolume();

    String getURL();
}
