package com.urbandroid.sleep.smartwatch.wear;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.Wearable;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ConnectionTemplate {
    protected Context context;

    public ConnectionTemplate(Context context) {
        this.context = context;
    }

    public abstract void doExecute(String str);

    public void execute() {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.context);
        if (iIsGooglePlayServicesAvailable != 0) {
            if (GoogleApiAvailability.getInstance().isUserResolvableError(iIsGooglePlayServicesAvailable) && (this.context instanceof Activity)) {
                GoogleApiAvailability.getInstance().getErrorDialog((Activity) this.context, iIsGooglePlayServicesAvailable, 22).show();
            }
            zza$$ExternalSyntheticOutline0.m(iIsGooglePlayServicesAvailable, "WEAR no play services ");
            return;
        }
        try {
            Task<List<Node>> connectedNodes = Wearable.getNodeClient(this.context).getConnectedNodes();
            connectedNodes.addOnSuccessListener(new OnSuccessListener<List<Node>>() { // from class: com.urbandroid.sleep.smartwatch.wear.ConnectionTemplate.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(List<Node> list) {
                    if (list == null || list.isEmpty()) {
                        Logger.logInfo("WEAR No nodes.");
                        return;
                    }
                    Logger.logInfo("WEAR Got nodes ");
                    Iterator<Node> it = list.iterator();
                    while (it.hasNext()) {
                        ConnectionTemplate.this.doExecute(it.next().getId());
                    }
                }
            });
            connectedNodes.addOnFailureListener(new OnFailureListener() { // from class: com.urbandroid.sleep.smartwatch.wear.ConnectionTemplate.2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public void onFailure(Exception exc) {
                    Logger.logInfo("WEAR Cannot get nodes");
                }
            });
        } catch (Exception unused) {
            Logger.logInfo("WEAR Got nodes interrupted");
        }
    }
}
