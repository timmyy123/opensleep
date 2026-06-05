package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Field;
import com.google.home.InternalTraitFactory;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/google/home/automation/Update;", "Lcom/google/home/automation/ActionBehavior;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "trait", "", "Lcom/google/home/Field;", "", "updatedAttributes", "<init>", "(Lcom/google/home/TraitFactory;Ljava/util/Map;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/TraitFactory;", "getTrait", "()Lcom/google/home/TraitFactory;", "Ljava/util/Map;", "getUpdatedAttributes", "()Ljava/util/Map;", "traitId", "Ljava/lang/String;", "getTraitId", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Update implements ActionBehavior {
    private final TraitFactory<? extends Trait> trait;
    private final String traitId;
    private final Map<Field, Object> updatedAttributes;

    public Update(TraitFactory<? extends Trait> traitFactory, Map<Field, ? extends Object> map) {
        traitFactory.getClass();
        map.getClass();
        this.trait = traitFactory;
        this.updatedAttributes = map;
        InternalTraitFactory<T> factory = traitFactory.getFactory();
        factory.getClass();
        this.traitId = factory.getTraitId();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Update)) {
            return false;
        }
        Update update = (Update) other;
        return Intrinsics.areEqual(this.trait, update.trait) && Intrinsics.areEqual(this.updatedAttributes, update.updatedAttributes);
    }

    public int hashCode() {
        int iHashCode = this.updatedAttributes.hashCode() + (this.trait.hashCode() * 31);
        return this.traitId.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        TraitFactory<? extends Trait> traitFactory = this.trait;
        int length = String.valueOf(traitFactory).length();
        Map<Field, Object> map = this.updatedAttributes;
        int length2 = String.valueOf(map).length();
        String str = this.traitId;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 33, length2, 11, String.valueOf(str).length()) + 2);
        sb.append("Update(trait=");
        sb.append(traitFactory);
        sb.append(", updatedAttributes=");
        sb.append(map);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", traitId='", str, "')");
    }
}
