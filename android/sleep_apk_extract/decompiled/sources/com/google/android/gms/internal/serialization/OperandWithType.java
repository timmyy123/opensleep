package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Field;
import com.google.home.TraitFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzml, reason: from toString */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u001eB%\b\u0004\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ9\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00000\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u0082\u0001\u0006\u001f !\"#$¨\u0006%"}, d2 = {"Lcom/google/home/automation/serialization/OperandWithType;", "", "Lcom/google/home/TraitFactory;", "traitFactory", "Lcom/google/home/Field;", "field", "<init>", "(Lcom/google/home/TraitFactory;Lcom/google/home/Field;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "Lcom/google/home/automation/Node;", "convertedNodesMap", "referenceDeclarations", "", "determineReferenceTypes", "(Ljava/util/Map;Ljava/util/Map;)V", "inferTypes", "()V", "Lcom/google/home/TraitFactory;", "getTraitFactory", "()Lcom/google/home/TraitFactory;", "setTraitFactory", "(Lcom/google/home/TraitFactory;)V", "Lcom/google/home/Field;", "getField", "()Lcom/google/home/Field;", "setField", "(Lcom/google/home/Field;)V", "Companion", "Lcom/google/home/automation/serialization/ConstantWithType;", "Lcom/google/home/automation/serialization/ExpressionWithType;", "Lcom/google/home/automation/serialization/FieldIdWithType;", "Lcom/google/home/automation/serialization/FieldNameWithType;", "Lcom/google/home/automation/serialization/ReferenceWithType;", "Lcom/google/home/automation/serialization/UnknownOperand;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class OperandWithType {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private TraitFactory traitFactory = null;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private Field field = null;

    public /* synthetic */ OperandWithType(TraitFactory traitFactory, Field field, DefaultConstructorMarker defaultConstructorMarker) {
    }

    public String toString() {
        TraitFactory traitFactory = this.traitFactory;
        Field field = this.field;
        StringBuilder sb = new StringBuilder(String.valueOf(traitFactory).length() + 37 + String.valueOf(field).length() + 1);
        sb.append("OperandWithType(traitFactory=");
        sb.append(traitFactory);
        sb.append(", field=");
        sb.append(field);
        sb.append(")");
        return sb.toString();
    }

    public void zzc(Map map, Map map2) {
        map.getClass();
        map2.getClass();
    }

    public void zzd() {
    }

    /* JADX INFO: renamed from: zze, reason: from getter */
    public final TraitFactory getTraitFactory() {
        return this.traitFactory;
    }

    public final void zzf(TraitFactory traitFactory) {
        this.traitFactory = traitFactory;
    }

    /* JADX INFO: renamed from: zzg, reason: from getter */
    public final Field getField() {
        return this.field;
    }

    public final void zzh(Field field) {
        this.field = field;
    }
}
