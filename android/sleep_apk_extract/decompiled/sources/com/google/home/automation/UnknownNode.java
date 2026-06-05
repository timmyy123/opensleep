package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.serialization.zzvo;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/google/home/automation/UnknownNode;", "Lcom/google/home/automation/Node;", "", "byteArray", "", "nodeId", "<init>", "([BLjava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "[B", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnknownNode extends Node {
    private final byte[] byteArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnknownNode(byte[] bArr, String str) {
        super(str, null);
        bArr.getClass();
        str.getClass();
        this.byteArray = bArr;
    }

    @Override // com.google.home.automation.Node
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof UnknownNode) && super.equals(other)) {
            return Arrays.equals(this.byteArray, ((UnknownNode) other).byteArray);
        }
        return false;
    }

    @Override // com.google.home.automation.Node
    public int hashCode() {
        return Arrays.hashCode(this.byteArray) + (super.hashCode() * 31);
    }

    public String toString() {
        String strZzb = zzvo.zzb(this.byteArray);
        String nodeId = getNodeId();
        StringBuilder sb = new StringBuilder(String.valueOf(nodeId).length() + 31 + String.valueOf(strZzb).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "UnknownNode(nodeId=", nodeId, ", byteArray=", strZzb);
        sb.append(")");
        return sb.toString();
    }
}
