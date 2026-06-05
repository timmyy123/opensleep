package com.google.android.gms.internal.serialization;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.platform.traits.Expression;
import com.google.home.platform.traits.Operand;
import com.google.home.platform.traits.Value;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/automation/serialization/OperandWithType$Companion;", "", "<init>", "()V", "create", "Lcom/google/home/automation/serialization/OperandWithType;", "operandProto", "Lcom/google/home/platform/traits/Operand;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class zzmk {
    public static final OperandWithType zza(Operand operand) {
        operand.getClass();
        Operand.TypeCase typeCase = operand.getTypeCase();
        Operand.TypeCase typeCase2 = Operand.TypeCase.CONSTANT;
        switch (typeCase) {
            case CONSTANT:
                Value constant = operand.getConstant();
                constant.getClass();
                return new zzme(constant);
            case REFERENCE:
                String reference = operand.getReference();
                reference.getClass();
                return new zzmm(reference);
            case EXPRESSION:
                Expression expression = operand.getExpression();
                expression.getClass();
                List<Operand> operandsList = operand.getExpression().getOperandsList();
                operandsList.getClass();
                List<Operand> list = operandsList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (Operand operand2 : list) {
                    operand2.getClass();
                    arrayList.add(zza(operand2));
                }
                return new zzmh(expression, arrayList);
            case FIELD_ID:
                return new zzmi(UInt.m2389constructorimpl(operand.getFieldId()), null);
            case FIELD_NAME:
                String fieldName = operand.getFieldName();
                fieldName.getClass();
                return new zzmj(fieldName);
            case REFERENCE_DECLARATION:
                String referenceDeclaration = operand.getReferenceDeclaration();
                referenceDeclaration.getClass();
                return new zzmm(referenceDeclaration);
            case TYPE_NOT_SET:
                byte[] byteArray = operand.toByteArray();
                byteArray.getClass();
                return new zzmn(byteArray);
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
        }
    }
}
