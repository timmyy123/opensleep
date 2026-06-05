package com.google.home.matter.standard;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzk {
    public static /* synthetic */ String zza(String str, String str2, List list, List list2, List list3, StringBuilder sb, Object obj, Object obj2, String str3, String str4) {
        zza$$ExternalSyntheticOutline0.m(sb, str4, obj2, str3, obj);
        sb.append(", generatedCommandList=");
        sb.append(list3);
        sb.append(", acceptedCommandList=");
        sb.append(list2);
        sb.append(", attributeList=");
        sb.append(list);
        sb.append(", featureMap=");
        sb.append(str2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", clusterRevision=", str, ")");
    }
}
