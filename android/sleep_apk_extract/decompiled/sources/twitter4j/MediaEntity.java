package twitter4j;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public interface MediaEntity extends URLEntity {

    public interface Size extends Serializable {
        public static final Integer THUMB = 0;
        public static final Integer SMALL = 1;
        public static final Integer MEDIUM = 2;
        public static final Integer LARGE = 3;
    }
}
