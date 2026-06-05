package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.automation.SequentialFlow;
import com.google.home.platform.traits.FirstPartyClientMetadata;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzjs, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/google/home/automation/internal/impl/BaseAutomationImpl;", "", "", "name", "description", "", "isActive", "Lcom/google/home/automation/SequentialFlow;", "automationGraph", "Lcom/google/home/platform/traits/FirstPartyClientMetadata;", "firstPartyClientMetadata", "clientFeatureGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/google/home/automation/SequentialFlow;Lcom/google/home/platform/traits/FirstPartyClientMetadata;Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BaseAutomationImpl {
    private final String zza;
    private final String zzb;
    private final boolean zzc;

    /* JADX INFO: renamed from: zzd, reason: from toString */
    private final SequentialFlow automationGraph;

    /* JADX INFO: renamed from: zze, reason: from toString */
    private final FirstPartyClientMetadata firstPartyClientMetadata;

    /* JADX INFO: renamed from: zzf, reason: from toString */
    private final String clientFeatureGroup;

    public BaseAutomationImpl(String str, String str2, boolean z, SequentialFlow sequentialFlow, FirstPartyClientMetadata firstPartyClientMetadata, String str3) {
        str.getClass();
        str2.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.automationGraph = sequentialFlow;
        this.firstPartyClientMetadata = firstPartyClientMetadata;
        this.clientFeatureGroup = str3;
    }

    public final String toString() {
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        int length2 = String.valueOf(str2).length();
        boolean z = this.zzc;
        int length3 = String.valueOf(z).length();
        SequentialFlow sequentialFlow = this.automationGraph;
        int length4 = String.valueOf(sequentialFlow).length();
        FirstPartyClientMetadata firstPartyClientMetadata = this.firstPartyClientMetadata;
        int length5 = String.valueOf(firstPartyClientMetadata).length();
        String str3 = this.clientFeatureGroup;
        StringBuilder sb = new StringBuilder(length + 34 + length2 + 11 + length3 + 18 + length4 + 27 + length5 + 21 + String.valueOf(str3).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "AutomationImpl(name=", str, ", description=", str2);
        sb.append(", isActive=");
        sb.append(z);
        sb.append(", automationGraph=");
        sb.append(sequentialFlow);
        sb.append(", firstPartyClientMetadata=");
        sb.append(firstPartyClientMetadata);
        sb.append(", clientFeatureGroup=");
        sb.append(str3);
        sb.append(")");
        return sb.toString();
    }
}
