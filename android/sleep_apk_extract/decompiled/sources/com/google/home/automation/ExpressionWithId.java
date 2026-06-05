package com.google.home.automation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0014¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u000f\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/google/home/automation/ExpressionWithId;", "Lcom/google/home/automation/Expression;", "<init>", "()V", "", "expressionId", "(Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getExpressionId$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android", "()Ljava/lang/String;", "Lcom/google/home/automation/BinaryExpression;", "Lcom/google/home/automation/Comprehension;", "Lcom/google/home/automation/FieldSelect;", "Lcom/google/home/automation/GetDevicesOfType;", "Lcom/google/home/automation/ListContains;", "Lcom/google/home/automation/ListGet;", "Lcom/google/home/automation/ListIn;", "Lcom/google/home/automation/ListSize;", "Lcom/google/home/automation/MapFilter;", "Lcom/google/home/automation/MapKeys;", "Lcom/google/home/automation/MapSize;", "Lcom/google/home/automation/MapValues;", "Lcom/google/home/automation/TernaryExpression;", "Lcom/google/home/automation/UnaryExpression;", "Lcom/google/home/automation/UnknownExpression;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExpressionWithId implements Expression {
    private final String expressionId;

    private ExpressionWithId() {
        this.expressionId = null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExpressionWithId) {
            return Intrinsics.areEqual(this.expressionId, ((ExpressionWithId) other).expressionId);
        }
        return false;
    }

    /* JADX INFO: renamed from: getExpressionId$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android, reason: from getter */
    public final String getExpressionId() {
        return this.expressionId;
    }

    public int hashCode() {
        String str = this.expressionId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    private ExpressionWithId(String str) {
        this.expressionId = str;
    }

    public /* synthetic */ ExpressionWithId(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ ExpressionWithId(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
