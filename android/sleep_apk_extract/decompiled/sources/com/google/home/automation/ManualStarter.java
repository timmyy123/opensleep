package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/google/home/automation/ManualStarter;", "Lcom/google/home/automation/Node;", "", "nodeId", "<init>", "(Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ManualStarter extends Node {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualStarter(String str) {
        super(str, null);
        str.getClass();
    }

    @Override // com.google.home.automation.Node
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ManualStarter) && super.equals(other);
    }

    public String toString() {
        String nodeId = getNodeId();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(nodeId).length() + 24), "ManualStarter(nodeId='", nodeId, "')");
    }
}
