package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Id;
import com.google.home.automation.Automation;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzix, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002Bk\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\r\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001f¨\u0006 "}, d2 = {"Lcom/google/home/automation/internal/impl/AutomationImpl;", "Lcom/google/home/automation/Automation;", "", "Lcom/google/home/Id;", "id", "", "isValid", "isRunning", "manuallyExecutable", "compatibleWithSdk", "", "Lcom/google/home/automation/ValidationIssue;", "validationIssues", "structureId", "iqsAutomationId", "Lcom/google/home/automation/internal/impl/BaseAutomationImpl;", "base", "Lcom/google/home/automation/internal/impl/AutomationInteractionClient;", "automationInteractionClient", "<init>", "(Ljava/lang/String;ZZZZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/google/home/automation/internal/impl/BaseAutomationImpl;Lcom/google/home/automation/internal/impl/AutomationInteractionClient;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/String;", "getId-sJHuco4", "getStructureId-sJHuco4$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "getIqsAutomationId-sJHuco4$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "Lcom/google/home/automation/internal/impl/BaseAutomationImpl;", "getBase$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/automation/internal/impl/BaseAutomationImpl;", "Lcom/google/home/automation/internal/impl/AutomationInteractionClient;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutomationImpl implements Automation {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final String id;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final boolean isValid;
    private final boolean zzc;
    private final boolean zzd;

    /* JADX INFO: renamed from: zze, reason: from toString */
    private final boolean compatibleWithSdk;

    /* JADX INFO: renamed from: zzf, reason: from toString */
    private final List validationIssues;
    private final String zzg;
    private final String zzh;

    /* JADX INFO: renamed from: zzi, reason: from toString */
    private final BaseAutomationImpl base;

    /* JADX INFO: renamed from: zzj, reason: from toString */
    private final AutomationInteractionClient automationInteractionClient;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutomationImpl(String str, boolean z, boolean z2, boolean z3, boolean z4, List list, String str2, String str3, BaseAutomationImpl baseAutomationImpl, AutomationInteractionClient automationInteractionClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List listEmptyList = (i & 32) != 0 ? CollectionsKt.emptyList() : list;
        int i2 = i & 16;
        int i3 = i & 4;
        int i4 = i & 2;
        boolean z5 = (i & 8) == 0;
        boolean z6 = i3 == 0;
        this(str, (i4 == 0) & z, z6 & z2, z5 & z3, i2 != 0, listEmptyList, str2, str3, baseAutomationImpl, automationInteractionClient);
    }

    @Override // com.google.home.HasId
    /* JADX INFO: renamed from: getId-sJHuco4, reason: not valid java name and from getter */
    public final String getId() {
        return this.id;
    }

    public final String toString() {
        String strM445toStringimpl = Id.m445toStringimpl(this.id);
        int length = strM445toStringimpl.length();
        String strM445toStringimpl2 = Id.m445toStringimpl(this.zzg);
        String strM445toStringimpl3 = Id.m445toStringimpl(this.zzh);
        boolean z = this.isValid;
        int length2 = String.valueOf(z).length();
        boolean z2 = this.zzc;
        int length3 = String.valueOf(z2).length();
        boolean z3 = this.zzd;
        int length4 = String.valueOf(z3).length();
        boolean z4 = this.compatibleWithSdk;
        int length5 = String.valueOf(z4).length();
        List list = this.validationIssues;
        int length6 = String.valueOf(list).length();
        int length7 = strM445toStringimpl2.length();
        int length8 = strM445toStringimpl3.length();
        BaseAutomationImpl baseAutomationImpl = this.base;
        int length9 = baseAutomationImpl.toString().length();
        AutomationInteractionClient automationInteractionClient = this.automationInteractionClient;
        StringBuilder sb = new StringBuilder(length + 28 + length2 + 12 + length3 + 21 + length4 + 20 + length5 + 19 + length6 + 14 + length7 + 18 + length8 + 7 + length9 + 30 + String.valueOf(automationInteractionClient).length() + 1);
        sb.append("AutomationImpl(id=");
        sb.append(strM445toStringimpl);
        sb.append(", isValid=");
        sb.append(z);
        zza$$ExternalSyntheticOutline0.m(sb, ", isRunning=", z2, ", manuallyExecutable=", z3);
        sb.append(", compatibleWithSdk=");
        sb.append(z4);
        sb.append(", validationIssues=");
        sb.append(list);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", structureId=", strM445toStringimpl2, ", iqsAutomationId=", strM445toStringimpl3);
        sb.append(", base=");
        sb.append(baseAutomationImpl);
        sb.append(", automationInteractionClient=");
        sb.append(automationInteractionClient);
        sb.append(")");
        return sb.toString();
    }

    private AutomationImpl(String str, boolean z, boolean z2, boolean z3, boolean z4, List list, String str2, String str3, BaseAutomationImpl baseAutomationImpl, AutomationInteractionClient automationInteractionClient) {
        str.getClass();
        list.getClass();
        str2.getClass();
        str3.getClass();
        baseAutomationImpl.getClass();
        this.id = str;
        this.isValid = z;
        this.zzc = z2;
        this.zzd = z3;
        this.compatibleWithSdk = z4;
        this.validationIssues = list;
        this.zzg = str2;
        this.zzh = str3;
        this.base = baseAutomationImpl;
        this.automationInteractionClient = automationInteractionClient;
    }
}
