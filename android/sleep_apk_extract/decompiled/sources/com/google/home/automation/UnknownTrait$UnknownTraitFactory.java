package com.google.home.automation;

import com.google.home.InternalTraitFactory;
import com.google.home.TraitFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/google/home/automation/UnknownTrait$UnknownTraitFactory", "Lcom/google/home/TraitFactory;", "", "", "id", "<init>", "(Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnknownTrait$UnknownTraitFactory extends TraitFactory<Object> {
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnknownTrait$UnknownTraitFactory(final String str) {
        super(new InternalTraitFactory<Object>(str) { // from class: com.google.home.automation.UnknownTrait$Factory
            private final String traitId;

            {
                str.getClass();
                this.traitId = str;
            }

            @Override // com.google.home.InternalTraitFactory
            public String getTraitId() {
                return this.traitId;
            }
        });
        str.getClass();
        this.id = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UnknownTrait$UnknownTraitFactory) {
            return Intrinsics.areEqual(this.id, ((UnknownTrait$UnknownTraitFactory) other).id);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }
}
