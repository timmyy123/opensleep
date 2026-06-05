package com.google.android.datatransport;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class Encoding {
    private final String name;

    private Encoding(String str) {
        if (str != null) {
            this.name = str;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("name is null");
            throw null;
        }
    }

    public static Encoding of(String str) {
        return new Encoding(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Encoding) {
            return this.name.equals(((Encoding) obj).name);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Encoding{name=\""), this.name, "\"}");
    }
}
