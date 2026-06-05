package com.google.home.automation;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B!\b\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/google/home/automation/Reference;", "Lcom/google/home/automation/Expression;", "Lcom/google/home/automation/HasOutput;", "reference", "Lcom/google/home/automation/ReferenceDeclaration;", "referenceDeclaration", "<init>", "(Lcom/google/home/automation/HasOutput;Lcom/google/home/automation/ReferenceDeclaration;)V", "(Lcom/google/home/automation/HasOutput;)V", "(Lcom/google/home/automation/ReferenceDeclaration;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/HasOutput;", "getReference", "()Lcom/google/home/automation/HasOutput;", "Lcom/google/home/automation/ReferenceDeclaration;", "getReferenceDeclaration", "()Lcom/google/home/automation/ReferenceDeclaration;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Reference implements Expression {
    private final HasOutput reference;
    private final ReferenceDeclaration referenceDeclaration;

    private Reference(HasOutput hasOutput, ReferenceDeclaration referenceDeclaration) {
        this.reference = hasOutput;
        this.referenceDeclaration = referenceDeclaration;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Reference)) {
            return false;
        }
        Reference reference = (Reference) other;
        return Intrinsics.areEqual(this.reference, reference.reference) && Intrinsics.areEqual(this.referenceDeclaration, reference.referenceDeclaration);
    }

    public int hashCode() {
        HasOutput hasOutput = this.reference;
        int iHashCode = hasOutput != null ? hasOutput.hashCode() : 0;
        ReferenceDeclaration referenceDeclaration = this.referenceDeclaration;
        return (iHashCode * 31) + (referenceDeclaration != null ? referenceDeclaration.hashCode() : 0);
    }

    public String toString() {
        return zza.zza(this.referenceDeclaration, this.reference, (byte) 1, (byte) 43, "Reference(reference=", ", referenceDeclaration=", ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Reference(HasOutput hasOutput) {
        this(hasOutput, null);
        hasOutput.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Reference(ReferenceDeclaration referenceDeclaration) {
        this(null, referenceDeclaration);
        referenceDeclaration.getClass();
    }
}
