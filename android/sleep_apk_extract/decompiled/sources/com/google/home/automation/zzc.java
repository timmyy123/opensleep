package com.google.home.automation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzc {
    public static /* synthetic */ String zza(Object obj, Node node, byte b, String str) {
        String nodeId = node.getNodeId();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + b + String.valueOf(nodeId).length() + 1);
        sb.append(str);
        sb.append(obj);
        sb.append(", nodeId=");
        sb.append(nodeId);
        sb.append(")");
        return sb.toString();
    }
}
