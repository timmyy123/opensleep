package adamb.vorbis;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CommentField implements Serializable {
    public String name;
    public String value;

    public CommentField(String str) {
        int iIndexOf = str.indexOf(61);
        if (iIndexOf < 1) {
            this.name = "";
        } else {
            this.name = str.substring(0, iIndexOf);
        }
        int i = iIndexOf + 1;
        if (i < str.length()) {
            this.value = str.substring(i);
        } else {
            this.value = "";
        }
    }

    public String toString() {
        return this.name + "=" + this.value;
    }

    public CommentField(String str, String str2) {
        this.name = str;
        this.value = str2;
    }
}
