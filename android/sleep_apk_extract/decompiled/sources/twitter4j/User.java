package twitter4j;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public interface User extends Comparable<User>, Serializable {
    long getId();

    String getScreenName();
}
