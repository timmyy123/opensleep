package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0010\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/google/home/automation/ParallelFlow;", "Lcom/google/home/automation/Node;", "", "nodes", "Lcom/google/home/automation/JoinSemanticType;", "joinSemantic", "", "nodeId", "<init>", "(Ljava/util/List;Lcom/google/home/automation/JoinSemanticType;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/List;", "getNodes", "()Ljava/util/List;", "Lcom/google/home/automation/JoinSemanticType;", "getJoinSemantic", "()Lcom/google/home/automation/JoinSemanticType;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParallelFlow extends Node {
    private final JoinSemanticType joinSemantic;
    private final List<Node> nodes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ParallelFlow(List<? extends Node> list, JoinSemanticType joinSemanticType, String str) {
        super(str, null);
        list.getClass();
        joinSemanticType.getClass();
        str.getClass();
        this.nodes = list;
        this.joinSemantic = joinSemanticType;
    }

    @Override // com.google.home.automation.Node
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParallelFlow) || !super.equals(other)) {
            return false;
        }
        ParallelFlow parallelFlow = (ParallelFlow) other;
        return Intrinsics.areEqual(this.nodes, parallelFlow.nodes) && this.joinSemantic == parallelFlow.joinSemantic;
    }

    @Override // com.google.home.automation.Node
    public int hashCode() {
        int iHashCode = this.nodes.hashCode() + (super.hashCode() * 31);
        return this.joinSemantic.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        String nodeId = getNodeId();
        List<Node> list = this.nodes;
        int length = String.valueOf(list).length();
        JoinSemanticType joinSemanticType = this.joinSemantic;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 34, String.valueOf(joinSemanticType).length(), 9, String.valueOf(nodeId).length()) + 1);
        sb.append("ParallelFlow(nodes=");
        sb.append(list);
        sb.append(", joinSemantic=");
        sb.append(joinSemanticType);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", nodeId=", nodeId, ")");
    }
}
