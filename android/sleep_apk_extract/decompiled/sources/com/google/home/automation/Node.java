package com.google.home.automation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0013\b\u0014\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u000b\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/google/home/automation/Node;", "", "", "nodeId", "<init>", "(Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getNodeId", "()Ljava/lang/String;", "Lcom/google/home/automation/Action;", "Lcom/google/home/automation/Condition;", "Lcom/google/home/automation/Delay;", "Lcom/google/home/automation/ManualStarter;", "Lcom/google/home/automation/ParallelFlow;", "Lcom/google/home/automation/SelectFlow;", "Lcom/google/home/automation/SequentialFlow;", "Lcom/google/home/automation/Starter;", "Lcom/google/home/automation/StateReader;", "Lcom/google/home/automation/Suppression;", "Lcom/google/home/automation/UnknownNode;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Node {
    private final String nodeId;

    private Node(String str) {
        this.nodeId = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Node) && Intrinsics.areEqual(this.nodeId, ((Node) other).nodeId);
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public int hashCode() {
        String str = this.nodeId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public /* synthetic */ Node(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
