package com.urbandroid.sleep.service.matter;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.IntentSenderRequest;
import com.google.android.gms.home.matter.Matter;
import com.google.android.gms.home.matter.commissioning.CommissioningClient;
import com.google.android.gms.home.matter.commissioning.CommissioningRequest;
import com.google.android.gms.home.matter.commissioning.CommissioningResult;
import com.google.android.gms.home.matter.discovery.DiscoveryClient;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import okhttp3.internal.Util$$ExternalSyntheticLambda2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/service/matter/MatterManager;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "settings", "Lcom/urbandroid/sleep/service/Settings;", "matterClient", "Lcom/google/android/gms/home/matter/discovery/DiscoveryClient;", "commissioningClient", "Lcom/google/android/gms/home/matter/commissioning/CommissioningClient;", "startCommissioning", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/IntentSenderRequest;", "handleCommissioningResult", "data", "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MatterManager {
    private final CommissioningClient commissioningClient;
    private final Context context;
    private final DiscoveryClient matterClient;
    private final Settings settings;

    public MatterManager(Context context) {
        context.getClass();
        this.context = context;
        this.settings = new Settings(context);
        DiscoveryClient discoveryClient = Matter.getDiscoveryClient(context);
        discoveryClient.getClass();
        this.matterClient = discoveryClient;
        CommissioningClient commissioningClient = Matter.getCommissioningClient(context);
        commissioningClient.getClass();
        this.commissioningClient = commissioningClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence handleCommissioningResult$lambda$0(String str) {
        return " ";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startCommissioning$lambda$0(ActivityResultLauncher activityResultLauncher, IntentSender intentSender) {
        intentSender.getClass();
        activityResultLauncher.launch(new IntentSenderRequest.Builder(intentSender).build());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startCommissioning$lambda$2(Exception exc) {
        exc.getClass();
        Logger.logSevere("Matter: Chyba inicializace párování: " + exc.getMessage());
    }

    public final void handleCommissioningResult(Intent data2) {
        if (data2 == null) {
            return;
        }
        try {
            CommissioningResult commissioningResultFromIntentSenderResult = CommissioningResult.fromIntentSenderResult(0, data2);
            commissioningResultFromIntentSenderResult.getClass();
            List<String> deviceIds = commissioningResultFromIntentSenderResult.getDeviceIds();
            this.settings.setMatterDevices(deviceIds);
            Logger.logInfo("Matter: Úspěšně spárováno! Device ID: " + (deviceIds != null ? CollectionsKt.joinToString$default(deviceIds, null, null, null, new URLUtilsKt$$ExternalSyntheticLambda0(1), 31) : null));
        } catch (Exception e) {
            Logger.logSevere("Matter: Chyba při extrakci Device ID: " + e.getMessage());
        }
    }

    public final void startCommissioning(ActivityResultLauncher<IntentSenderRequest> launcher) {
        launcher.getClass();
        CommissioningRequest commissioningRequestBuild = CommissioningRequest.builder().setDeviceNameHint("IKEA Dirigera").build();
        commissioningRequestBuild.getClass();
        this.commissioningClient.commissionDevice(commissioningRequestBuild).addOnSuccessListener(new Util$$ExternalSyntheticLambda2(new CodecsKt$$ExternalSyntheticLambda2(launcher, 16), 7)).addOnFailureListener(new Events$$ExternalSyntheticBUOutline0(11));
    }
}
