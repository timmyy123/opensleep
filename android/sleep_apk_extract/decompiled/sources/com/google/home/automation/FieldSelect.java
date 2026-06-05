package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB'\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/automation/FieldSelect;", "Lcom/google/home/automation/ExpressionWithId;", "Lcom/google/home/automation/Expression;", "from", "", "Lcom/google/home/Field;", "selected", "<init>", "(Lcom/google/home/automation/Expression;Ljava/util/List;)V", "", "expressionId", "(Lcom/google/home/automation/Expression;Ljava/util/List;Ljava/lang/String;)V", "copy$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android", "(Lcom/google/home/automation/Expression;Ljava/util/List;)Lcom/google/home/automation/FieldSelect;", "copy", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Expression;", "getFrom", "()Lcom/google/home/automation/Expression;", "Ljava/util/List;", "getSelected", "()Ljava/util/List;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FieldSelect extends ExpressionWithId {
    private final Expression from;
    private final List<Field> selected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FieldSelect(Expression expression, List<? extends Field> list, String str) {
        super(str, null);
        expression.getClass();
        list.getClass();
        str.getClass();
        this.from = expression;
        this.selected = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FieldSelect copy$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android$default(FieldSelect fieldSelect, Expression expression, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = fieldSelect.from;
        }
        if ((i & 2) != 0) {
            list = fieldSelect.selected;
        }
        return fieldSelect.copy$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(expression, list);
    }

    public final FieldSelect copy$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(Expression from, List<? extends Field> selected) {
        from.getClass();
        selected.getClass();
        return new FieldSelect(from, selected);
    }

    @Override // com.google.home.automation.ExpressionWithId
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FieldSelect)) {
            return false;
        }
        FieldSelect fieldSelect = (FieldSelect) other;
        return Intrinsics.areEqual(this.from, fieldSelect.from) && Intrinsics.areEqual(this.selected, fieldSelect.selected);
    }

    public final List<Field> getSelected() {
        return this.selected;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public int hashCode() {
        return this.selected.hashCode() + (this.from.hashCode() * 31);
    }

    public String toString() {
        String expressionId = getExpressionId();
        Expression expression = this.from;
        int length = String.valueOf(expression).length();
        List<Field> list = this.selected;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 28, String.valueOf(list).length(), 15, String.valueOf(expressionId).length()) + 1);
        sb.append("FieldSelect(from=");
        sb.append(expression);
        sb.append(", selected=");
        sb.append(list);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", expressionId=", expressionId, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FieldSelect(Expression expression, List<? extends Field> list) {
        super((DefaultConstructorMarker) null);
        expression.getClass();
        list.getClass();
        this.from = expression;
        this.selected = list;
    }
}
