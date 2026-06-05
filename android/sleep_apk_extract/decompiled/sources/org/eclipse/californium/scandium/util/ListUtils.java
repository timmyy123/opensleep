package org.eclipse.californium.scandium.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ListUtils {
    public static <T> List<T> init(List<T> list) {
        if (list == null) {
            return null;
        }
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                T t = list.get(i);
                for (int i2 = 0; i2 < i; i2++) {
                    if (list.get(i2).equals(t)) {
                        StringBuilder sb = new StringBuilder("Item ");
                        sb.append(t);
                        sb.append("[");
                        sb.append(i);
                        sb.append("] is already contained at index [");
                        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i2, "]!", sb));
                        return null;
                    }
                }
            }
        }
        return Collections.unmodifiableList(new ArrayList(list));
    }
}
