package com.google.android.gms.internal.serialization;

import com.google.home.platform.traits.Expression;
import com.google.home.platform.traits.Operand;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\n\u0010\b\u001a\u00020\t*\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/google/home/automation/serialization/ExpressionWithType$Companion;", "", "<init>", "()V", "create", "Lcom/google/home/automation/serialization/ExpressionWithType;", "expressionProto", "Lcom/google/home/platform/traits/Expression;", "getField", "Lcom/google/home/Field;", "Lcom/google/home/automation/serialization/OperandWithType;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class zzmf {
    public static final zzmh zza(Expression expression) {
        expression.getClass();
        List<Operand> operandsList = expression.getOperandsList();
        operandsList.getClass();
        List<Operand> list = operandsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Operand operand : list) {
            operand.getClass();
            arrayList.add(zzmk.zza(operand));
        }
        return new zzmh(expression, arrayList);
    }
}
