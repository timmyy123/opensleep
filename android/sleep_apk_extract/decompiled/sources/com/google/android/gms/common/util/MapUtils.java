package com.google.android.gms.common.util;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MapUtils {
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> map) {
        sb.append("{");
        boolean z = true;
        for (String str : map.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str2 = map.get(str);
            Fragment$$ExternalSyntheticOutline1.m67m(sb, "\"", str, "\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                Fragment$$ExternalSyntheticOutline1.m67m(sb, "\"", str2, "\"");
            }
            z = false;
        }
        sb.append("}");
    }
}
