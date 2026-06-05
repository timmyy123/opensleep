package com.google.home.google;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzk {
    public static /* synthetic */ String zza(String str, String str2, List list, List list2, List list3, StringBuilder sb, Object obj, String str3) {
        sb.append(str3);
        sb.append(obj);
        sb.append(", generatedCommandList=");
        sb.append(list3);
        sb.append(", acceptedCommandList=");
        sb.append(list2);
        sb.append(", attributeList=");
        sb.append(list);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", featureMap=", str2, ", clusterRevision=", str);
        sb.append(")");
        return sb.toString();
    }
}
