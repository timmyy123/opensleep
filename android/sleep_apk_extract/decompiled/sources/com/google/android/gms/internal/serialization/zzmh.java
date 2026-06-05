package com.google.android.gms.internal.serialization;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.StructDescriptor;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.automation.HasOutput;
import com.google.home.automation.Node;
import com.google.home.automation.Starter;
import com.google.home.automation.StateReader;
import com.google.home.automation.UnknownField;
import com.google.home.automation.UnknownTrait$UnknownTraitFactory;
import com.google.home.platform.traits.Expression;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001fB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/google/home/automation/serialization/ExpressionWithType;", "Lcom/google/home/automation/serialization/OperandWithType;", "Lcom/google/home/platform/traits/Expression;", "expressionProto", "", "operands", "<init>", "(Lcom/google/home/platform/traits/Expression;Ljava/util/List;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "index", "getOperand", "(I)Lcom/google/home/automation/serialization/OperandWithType;", "", "Lcom/google/home/automation/Node;", "convertedNodesMap", "referenceDeclarations", "", "determineReferenceTypes", "(Ljava/util/Map;Ljava/util/Map;)V", "inferTypes", "()V", "copyKnownType", "Lcom/google/home/platform/traits/Expression;", "getExpressionProto", "()Lcom/google/home/platform/traits/Expression;", "Ljava/util/List;", "getOperands", "()Ljava/util/List;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzmh extends OperandWithType {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final Expression expressionProto;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final List operands;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmh(Expression expression, List list) {
        super(null, null, null);
        expression.getClass();
        list.getClass();
        this.expressionProto = expression;
        this.operands = list;
    }

    @Override // com.google.android.gms.internal.serialization.OperandWithType
    public final String toString() {
        String string = super.toString();
        int length = string.length();
        Expression expression = this.expressionProto;
        int length2 = String.valueOf(expression).length();
        List list = this.operands;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 36, length2, 11, list.toString().length()) + 1);
        sb.append(string);
        sb.append(":ExpressionWithType(expressionProto=");
        sb.append(expression);
        sb.append(", operands=");
        sb.append(list);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final Expression getExpressionProto() {
        return this.expressionProto;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final List getOperands() {
        return this.operands;
    }

    @Override // com.google.android.gms.internal.serialization.OperandWithType
    public final void zzc(Map map, Map map2) {
        Object next;
        Object next2;
        TraitFactory<? extends Trait> unknownTrait$UnknownTraitFactory;
        Field unknownField;
        Field fieldMo449getAttributeByIdWZ4Q5Ns;
        TraitFactory<? extends Trait> trait;
        Field field;
        map.getClass();
        map2.getClass();
        Iterator it = this.operands.iterator();
        while (it.hasNext()) {
            ((OperandWithType) it.next()).zzc(map, map2);
        }
        Expression.Operator op = this.expressionProto.getOp();
        Expression.Operator operator = Expression.Operator.OP_UNSPECIFIED;
        switch (op.ordinal()) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                zzh(new zzmg());
                break;
            case 16:
                Iterator it2 = this.operands.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (((OperandWithType) next) instanceof zzmm) {
                        }
                    } else {
                        next = null;
                    }
                }
                next.getClass();
                zzmm zzmmVar = (zzmm) next;
                List list = this.operands;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!(((OperandWithType) obj) instanceof zzmm)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.size() != 0) {
                    Iterator it3 = map.values().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next2 = it3.next();
                            Object obj2 = (Node) next2;
                            if (!(obj2 instanceof HasOutput) || !Intrinsics.areEqual(((HasOutput) obj2).getOutput(), zzmmVar.getZza())) {
                            }
                        } else {
                            next2 = null;
                        }
                    }
                    Node node = (Node) next2;
                    OperandWithType operandWithType = (OperandWithType) arrayList.get(0);
                    if (node instanceof Starter) {
                        Starter starter = (Starter) node;
                        if (starter.getEvent() != null) {
                            trait = starter.getTrait();
                            fieldMo449getAttributeByIdWZ4Q5Ns = operandWithType instanceof zzmi ? starter.getEvent().m437getEventFieldByIdWZ4Q5Ns(((zzmi) operandWithType).getZza()) : operandWithType instanceof zzmj ? starter.getEvent().getEventFieldByName(((zzmj) operandWithType).getZza()) : null;
                            operandWithType.zzh(fieldMo449getAttributeByIdWZ4Q5Ns);
                            operandWithType.zzf(trait);
                        } else if (starter.getTrait() != null) {
                            trait = starter.getTrait();
                            fieldMo449getAttributeByIdWZ4Q5Ns = operandWithType instanceof zzmi ? starter.getTrait().mo449getAttributeByIdWZ4Q5Ns(((zzmi) operandWithType).getZza()) : operandWithType instanceof zzmj ? starter.getTrait().getAttributeByName(((zzmj) operandWithType).getZza()) : null;
                            operandWithType.zzh(fieldMo449getAttributeByIdWZ4Q5Ns);
                            operandWithType.zzf(trait);
                        }
                    } else if (node instanceof StateReader) {
                        StateReader stateReader = (StateReader) node;
                        trait = stateReader.getTrait();
                        fieldMo449getAttributeByIdWZ4Q5Ns = operandWithType instanceof zzmi ? stateReader.getTrait().mo449getAttributeByIdWZ4Q5Ns(((zzmi) operandWithType).getZza()) : operandWithType instanceof zzmj ? stateReader.getTrait().getAttributeByName(((zzmj) operandWithType).getZza()) : null;
                        operandWithType.zzh(fieldMo449getAttributeByIdWZ4Q5Ns);
                        operandWithType.zzf(trait);
                    } else if (node == null && map2.containsKey(zzmmVar.getZza())) {
                        OperandWithType operandWithType2 = (OperandWithType) map2.get(zzmmVar.getZza());
                        if (operandWithType2 == null || (unknownTrait$UnknownTraitFactory = operandWithType2.getTraitFactory()) == null) {
                            unknownTrait$UnknownTraitFactory = new UnknownTrait$UnknownTraitFactory("");
                        }
                        if (operandWithType instanceof zzmi) {
                            Descriptor descriptor = (operandWithType2 == null || (field = operandWithType2.getField()) == null) ? null : field.getDescriptor();
                            StructDescriptor structDescriptor = descriptor instanceof StructDescriptor ? (StructDescriptor) descriptor : null;
                            if (structDescriptor == null || (unknownField = structDescriptor.mo448getFieldByIdWZ4Q5Ns(((zzmi) operandWithType).getZza())) == null) {
                                unknownField = new UnknownField(((zzmi) operandWithType).getZza(), null);
                            }
                        } else {
                            unknownField = operandWithType instanceof zzmj ? new UnknownField(0, null) : null;
                        }
                        operandWithType.zzh(unknownField);
                        operandWithType.zzf(unknownTrait$UnknownTraitFactory);
                        TraitFactory<? extends Trait> traitFactory = unknownTrait$UnknownTraitFactory;
                        fieldMo449getAttributeByIdWZ4Q5Ns = unknownField;
                        trait = traitFactory;
                    }
                    for (OperandWithType operandWithType3 : arrayList.subList(1, arrayList.size())) {
                        Descriptor descriptor2 = fieldMo449getAttributeByIdWZ4Q5Ns != null ? fieldMo449getAttributeByIdWZ4Q5Ns.getDescriptor() : null;
                        if ((descriptor2 instanceof StructDescriptor) && (operandWithType3 instanceof zzmi)) {
                            fieldMo449getAttributeByIdWZ4Q5Ns = ((StructDescriptor) descriptor2).mo448getFieldByIdWZ4Q5Ns(((zzmi) operandWithType3).getZza());
                            operandWithType3.zzh(fieldMo449getAttributeByIdWZ4Q5Ns);
                            operandWithType3.zzf(trait);
                        }
                    }
                    zzf(trait);
                    zzh(fieldMo449getAttributeByIdWZ4Q5Ns);
                }
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                if (this.operands.size() == 3 && (this.operands.get(1) instanceof zzmm)) {
                    ((OperandWithType) this.operands.get(1)).zzh(((OperandWithType) this.operands.get(0)).getField());
                    ((OperandWithType) this.operands.get(1)).zzf(((OperandWithType) this.operands.get(0)).getTraitFactory());
                    Object obj3 = this.operands.get(1);
                    obj3.getClass();
                    zzmm zzmmVar2 = new zzmm(((zzmm) obj3).getZza());
                    OperandWithType operandWithType4 = (OperandWithType) this.operands.get(0);
                    operandWithType4.getClass();
                    Field field2 = operandWithType4.getField();
                    if (field2 == null) {
                        field2 = operandWithType4 instanceof zzmi ? new UnknownField(((zzmi) operandWithType4).getZza(), null) : new UnknownField(0, null);
                    }
                    zzmmVar2.zzh(field2);
                    zzmmVar2.zzf(((OperandWithType) this.operands.get(0)).getTraitFactory());
                    map2.put(zzmmVar2.getZza(), zzmmVar2);
                    ((OperandWithType) this.operands.get(2)).zzc(map, map2);
                    break;
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.serialization.OperandWithType
    public final void zzd() {
        Iterator it = this.operands.iterator();
        while (it.hasNext()) {
            ((OperandWithType) it.next()).zzd();
        }
        Expression.Operator op = this.expressionProto.getOp();
        Expression.Operator operator = Expression.Operator.OP_UNSPECIFIED;
        switch (op.ordinal()) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                if (this.operands.size() == 2) {
                    List list = this.operands;
                    OperandWithType operandWithType = (OperandWithType) list.get(0);
                    OperandWithType operandWithType2 = (OperandWithType) list.get(1);
                    if (operandWithType.getField() == null && operandWithType2.getField() != null) {
                        operandWithType.zzf(operandWithType2.getTraitFactory());
                        operandWithType.zzh(operandWithType2.getField());
                        break;
                    } else if (operandWithType.getField() != null && operandWithType2.getField() == null) {
                        operandWithType2.zzf(operandWithType.getTraitFactory());
                        operandWithType2.zzh(operandWithType.getField());
                        break;
                    }
                }
                break;
            case 11:
                if (this.operands.size() == 3) {
                    List list2 = this.operands;
                    OperandWithType operandWithType3 = (OperandWithType) list2.get(0);
                    OperandWithType operandWithType4 = (OperandWithType) list2.get(1);
                    OperandWithType operandWithType5 = (OperandWithType) list2.get(2);
                    if (operandWithType4.getField() == null) {
                        operandWithType4.zzf(operandWithType3.getTraitFactory());
                        operandWithType4.zzh(operandWithType3.getField());
                    }
                    if (operandWithType5.getField() == null) {
                        operandWithType5.zzf(operandWithType3.getTraitFactory());
                        operandWithType5.zzh(operandWithType3.getField());
                    }
                }
                break;
        }
    }
}
