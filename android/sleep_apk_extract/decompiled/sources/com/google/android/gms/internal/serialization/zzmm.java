package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.automation.HasOutput;
import com.google.home.automation.Node;
import com.google.home.automation.Starter;
import com.google.home.automation.StateReader;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/google/home/automation/serialization/ReferenceWithType;", "Lcom/google/home/automation/serialization/OperandWithType;", "reference", "", "<init>", "(Ljava/lang/String;)V", "getReference", "()Ljava/lang/String;", "determineReferenceTypes", "", "convertedNodesMap", "", "Lcom/google/home/automation/Node;", "referenceDeclarations", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzmm extends OperandWithType {
    private final String zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmm(String str) {
        super(null, null, null);
        str.getClass();
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.serialization.OperandWithType
    public final String toString() {
        String string = super.toString();
        int length = string.length();
        String str = this.zza;
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(length + 29 + String.valueOf(str).length() + 1), string, ":ReferenceWithType(reference=", str, ")");
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final String getZza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.serialization.OperandWithType
    public final void zzc(Map map, Map map2) {
        Object next;
        map.getClass();
        map2.getClass();
        if (StringsKt.contains$default(this.zza, ".")) {
            String strSubstringBefore$default = StringsKt__StringsKt.substringBefore$default(this.zza, ".", (String) null, 2, (Object) null);
            Iterator it = map.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Object obj = (Node) next;
                if ((obj instanceof HasOutput) && Intrinsics.areEqual(((HasOutput) obj).getOutput(), strSubstringBefore$default)) {
                    break;
                }
            }
            Node node = (Node) next;
            String strSubstringAfter$default = StringsKt__StringsKt.substringAfter$default(this.zza, ".", (String) null, 2, (Object) null);
            UInt uIntOrNull = UStringsKt.toUIntOrNull(strSubstringAfter$default, 16);
            if (!(node instanceof Starter)) {
                if (node instanceof StateReader) {
                    StateReader stateReader = (StateReader) node;
                    zzf(stateReader.getTrait());
                    zzh(uIntOrNull == null ? stateReader.getTrait().getAttributeByName(strSubstringAfter$default) : stateReader.getTrait().mo449getAttributeByIdWZ4Q5Ns(uIntOrNull.getData()));
                    return;
                }
                return;
            }
            Starter starter = (Starter) node;
            if (starter.getEvent() != null) {
                zzh(uIntOrNull == null ? starter.getEvent().getEventFieldByName(strSubstringAfter$default) : starter.getEvent().m437getEventFieldByIdWZ4Q5Ns(uIntOrNull.getData()));
            } else if (starter.getTrait() != null) {
                zzf(starter.getTrait());
                zzh(uIntOrNull == null ? starter.getTrait().getAttributeByName(strSubstringAfter$default) : starter.getTrait().mo449getAttributeByIdWZ4Q5Ns(uIntOrNull.getData()));
            }
        }
    }
}
