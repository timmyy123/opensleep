package com.google.home.automation;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.home.Field;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u0015R%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/home/automation/Command;", "Lcom/google/home/automation/ActionBehavior;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "trait", "", "command", "", "Lcom/google/home/Field;", "", NativeProtocol.WEB_DIALOG_PARAMS, "<init>", "(Lcom/google/home/TraitFactory;Ljava/lang/String;Ljava/util/Map;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/TraitFactory;", "getTrait", "()Lcom/google/home/TraitFactory;", "Ljava/lang/String;", "getCommand", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Command implements ActionBehavior {
    private final String command;
    private final Map<Field, Object> params;
    private final TraitFactory<? extends Trait> trait;

    public Command(TraitFactory<? extends Trait> traitFactory, String str, Map<Field, ? extends Object> map) {
        traitFactory.getClass();
        str.getClass();
        map.getClass();
        this.trait = traitFactory;
        this.command = str;
        this.params = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Command)) {
            return false;
        }
        Command command = (Command) other;
        return Intrinsics.areEqual(this.trait, command.trait) && Intrinsics.areEqual(this.command, command.command) && Intrinsics.areEqual(this.params, command.params);
    }

    public int hashCode() {
        int iHashCode = this.command.hashCode() + (this.trait.hashCode() * 31);
        return this.params.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        TraitFactory<? extends Trait> traitFactory = this.trait;
        int length = String.valueOf(traitFactory).length();
        String str = this.command;
        int length2 = String.valueOf(str).length();
        Map<Field, Object> map = this.params;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 24, length2, 9, String.valueOf(map).length()) + 1);
        sb.append("Command(trait=");
        sb.append(traitFactory);
        sb.append(", command=");
        sb.append(str);
        sb.append(", params=");
        sb.append(map);
        sb.append(")");
        return sb.toString();
    }
}
