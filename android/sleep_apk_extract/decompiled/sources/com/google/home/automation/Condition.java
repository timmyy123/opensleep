package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/google/home/automation/Condition;", "Lcom/google/home/automation/Node;", "Lcom/google/home/automation/Expression;", "expression", "j$/time/Duration", "forDuration", "", "nodeId", "<init>", "(Lcom/google/home/automation/Expression;Lj$/time/Duration;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Expression;", "getExpression", "()Lcom/google/home/automation/Expression;", "Lj$/time/Duration;", "getForDuration", "()Lj$/time/Duration;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Condition extends Node {
    private final Expression expression;
    private final Duration forDuration;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Condition(Expression expression, Duration duration, String str) {
        super(str, null);
        expression.getClass();
        str.getClass();
        this.expression = expression;
        this.forDuration = duration;
    }

    @Override // com.google.home.automation.Node
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Condition) || !super.equals(other)) {
            return false;
        }
        Condition condition = (Condition) other;
        return Intrinsics.areEqual(this.expression, condition.expression) && Intrinsics.areEqual(this.forDuration, condition.forDuration);
    }

    @Override // com.google.home.automation.Node
    public int hashCode() {
        int iHashCode = this.expression.hashCode() + (super.hashCode() * 31);
        Duration duration = this.forDuration;
        if (duration == null) {
            return iHashCode;
        }
        return duration.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        String nodeId = getNodeId();
        Expression expression = this.expression;
        int length = String.valueOf(expression).length();
        Duration duration = this.forDuration;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 35, String.valueOf(duration).length(), 9, String.valueOf(nodeId).length()) + 1);
        sb.append("Condition(expression=");
        sb.append(expression);
        sb.append(", forDuration=");
        sb.append(duration);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", nodeId=", nodeId, ")");
    }
}
