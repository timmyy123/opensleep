package com.google.android.gms.internal.nearby;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArraySet;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzch extends GmsClient {
    public static final /* synthetic */ int $r8$clinit = 0;
    private long zzf;
    private final Set zzg;
    private final Set zzh;
    private final Set zzi;
    private final Set zzj;
    private final Set zzk;
    private final Set zzl;
    private zzhc zzm;

    public zzch(Context context, Looper looper, ClientSettings clientSettings, ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        this.zzg = new ArraySet();
        this.zzh = new ArraySet();
        this.zzi = new ArraySet();
        this.zzj = new ArraySet();
        this.zzk = new ArraySet();
        this.zzl = new ArraySet();
        zzhm.zzc(context.getCacheDir());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zzG(int i) {
        return new Status(i, ConnectionsStatusCodes.getStatusCodeString(i));
    }

    private final void zzH() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            ((zzbp) it.next()).zze();
        }
        Iterator it2 = this.zzh.iterator();
        if (it2.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m(it2);
        }
        Iterator it3 = this.zzi.iterator();
        while (it3.hasNext()) {
            ((zzbt) it3.next()).zzf();
        }
        Iterator it4 = this.zzj.iterator();
        while (it4.hasNext()) {
            ((zzbt) it4.next()).zzf();
        }
        Iterator it5 = this.zzk.iterator();
        while (it5.hasNext()) {
            ((zzbt) it5.next()).zzf();
        }
        Iterator it6 = this.zzl.iterator();
        while (it6.hasNext()) {
            ((zzbt) it6.next()).zzf();
        }
        this.zzg.clear();
        this.zzh.clear();
        this.zzi.clear();
        this.zzj.clear();
        this.zzk.clear();
        this.zzl.clear();
        zzhc zzhcVar = this.zzm;
        if (zzhcVar != null) {
            zzhcVar.zzd();
            this.zzm = null;
        }
    }

    public static zzch zzq(Context context, Looper looper, ClientSettings clientSettings, ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzch zzchVar = new zzch(context, looper, clientSettings, connectionsOptions, connectionCallbacks, onConnectionFailedListener);
        zzchVar.zzf = zzchVar.hashCode();
        return zzchVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        return iInterfaceQueryLocalInterface instanceof zzfm ? (zzfm) iInterfaceQueryLocalInterface : new zzfm(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzfm) getService()).zzf(new zzax());
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        zzH();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{com.google.android.gms.nearby.zza.zzf, com.google.android.gms.nearby.zza.zzx, com.google.android.gms.nearby.zza.zzB, com.google.android.gms.nearby.zza.zzz, com.google.android.gms.nearby.zza.zzC, com.google.android.gms.nearby.zza.zzy, com.google.android.gms.nearby.zza.zzg, com.google.android.gms.nearby.zza.zzA, com.google.android.gms.nearby.zza.zzh, com.google.android.gms.nearby.zza.zzD};
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.zzf);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* bridge */ /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        super.onConnectedLocked((zzfm) iInterface);
        this.zzm = new zzhc();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i) {
        if (i == 1) {
            zzH();
            i = 1;
        }
        super.onConnectionSuspended(i);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzA(BaseImplementation$ResultHolder baseImplementation$ResultHolder, String str, String str2, ListenerHolder listenerHolder, AdvertisingOptions advertisingOptions) {
        zzbf zzbfVar = new zzbf(listenerHolder);
        this.zzk.add(zzbfVar);
        zzfm zzfmVar = (zzfm) getService();
        zzhz zzhzVar = new zzhz();
        zzhzVar.zzg(new zzcg(baseImplementation$ResultHolder));
        zzhzVar.zze(str);
        zzhzVar.zzh(str2);
        zzhzVar.zzf(advertisingOptions);
        zzhzVar.zzb(zzbfVar);
        zzfmVar.zzk(zzhzVar.zzi());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC(BaseImplementation$ResultHolder baseImplementation$ResultHolder, String str, ListenerHolder listenerHolder, DiscoveryOptions discoveryOptions) {
        zzbp zzbpVar = new zzbp(listenerHolder);
        this.zzg.add(zzbpVar);
        zzfm zzfmVar = (zzfm) getService();
        zzid zzidVar = new zzid();
        zzidVar.zzd(new zzce(baseImplementation$ResultHolder));
        zzidVar.zze(str);
        zzidVar.zzc(discoveryOptions);
        zzidVar.zza(zzbpVar);
        zzfmVar.zzl(zzidVar.zzf());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzD() {
        ((zzfm) getService()).zzm(new zzih());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzE() {
        ((zzfm) getService()).zzn(new zzij());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzF() {
        ((zzfm) getService()).zzo(new zzil());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzr(BaseImplementation$ResultHolder baseImplementation$ResultHolder, String str, ListenerHolder listenerHolder) {
        zzcd zzcdVar = new zzcd(getContext(), listenerHolder, this.zzm);
        this.zzi.add(zzcdVar);
        zzfm zzfmVar = (zzfm) getService();
        zzap zzapVar = new zzap();
        zzapVar.zze(new zzce(baseImplementation$ResultHolder));
        zzapVar.zzd(str);
        zzapVar.zzc(zzcdVar);
        zzfmVar.zzd(zzapVar.zzf());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzu(BaseImplementation$ResultHolder baseImplementation$ResultHolder, String str) {
        zzfm zzfmVar = (zzfm) getService();
        zzhn zzhnVar = new zzhn();
        zzhnVar.zzb(new zzce(baseImplementation$ResultHolder));
        zzhnVar.zza(str);
        zzfmVar.zzh(zzhnVar.zzc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzv(BaseImplementation$ResultHolder baseImplementation$ResultHolder, String str, String str2, ListenerHolder listenerHolder) {
        zzbf zzbfVar = new zzbf(listenerHolder);
        this.zzk.add(zzbfVar);
        zzfm zzfmVar = (zzfm) getService();
        zzhr zzhrVar = new zzhr();
        zzhrVar.zzi(new zzce(baseImplementation$ResultHolder));
        zzhrVar.zzf(str);
        zzhrVar.zzh(str2);
        zzhrVar.zzb(zzbfVar);
        zzfmVar.zzi(zzhrVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzz(BaseImplementation$ResultHolder baseImplementation$ResultHolder, String[] strArr, Payload payload, boolean z) throws Throwable {
        Pair pairCreate;
        try {
            int type = payload.getType();
            if (type == 1) {
                zzhi zzhiVar = new zzhi();
                zzhiVar.zzd(payload.getId());
                zzhiVar.zzm(payload.getType());
                byte[] bArrAsBytes = payload.asBytes();
                if (bArrAsBytes == null || bArrAsBytes.length <= 32768) {
                    zzhiVar.zza(bArrAsBytes);
                } else {
                    zzhe zzheVar = new zzhe();
                    zzheVar.zza(bArrAsBytes);
                    zzhiVar.zzk(zzheVar.zzb());
                    zzhiVar.zza(Arrays.copyOf(bArrAsBytes, 32768));
                }
                pairCreate = Pair.create(zzhiVar.zzo(), zzpl.zzc());
            } else if (type == 2) {
                Payload.File fileAsFile = payload.asFile();
                zzpm.zzc(fileAsFile, "File cannot be null for Payload.Type.FILE");
                File fileAsJavaFile = fileAsFile.asJavaFile();
                String absolutePath = fileAsJavaFile == null ? null : fileAsJavaFile.getAbsolutePath();
                Uri uriAsUri = fileAsFile.asUri();
                zzhi zzhiVar2 = new zzhi();
                zzhiVar2.zzd(payload.getId());
                zzhiVar2.zzm(payload.getType());
                zzhiVar2.zzb(fileAsFile.zza());
                zzhiVar2.zzn(uriAsUri);
                zzhiVar2.zzf(absolutePath);
                zzhiVar2.zzg(fileAsFile.getSize());
                zzhiVar2.zzh(payload.getOffset());
                zzhiVar2.zze(payload.zzh());
                zzhiVar2.zzj(payload.zza());
                zzhiVar2.zzc(payload.zzf());
                zzhiVar2.zzi(payload.zzg());
                pairCreate = Pair.create(zzhiVar2.zzo(), zzpl.zzc());
            } else {
                if (type != 3) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())));
                    Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException);
                    throw illegalArgumentException;
                }
                try {
                    ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                    ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe2 = ParcelFileDescriptor.createPipe();
                    zzhi zzhiVar3 = new zzhi();
                    zzhiVar3.zzd(payload.getId());
                    zzhiVar3.zzm(payload.getType());
                    zzhiVar3.zzb(parcelFileDescriptorArrCreatePipe[0]);
                    zzhiVar3.zzl(parcelFileDescriptorArrCreatePipe2[0]);
                    zzhiVar3.zzh(payload.getOffset());
                    zzhiVar3.zzj(payload.zza());
                    pairCreate = Pair.create(zzhiVar3.zzo(), zzpl.zzd(Pair.create(parcelFileDescriptorArrCreatePipe[1], parcelFileDescriptorArrCreatePipe2[1])));
                } catch (IOException e) {
                    Log.e("NearbyConnections", String.format("Unable to create PFD pipe for streaming payload %d from client to service.", Long.valueOf(payload.getId())), e);
                    throw e;
                }
            }
            zzfm zzfmVar = (zzfm) getService();
            zzhv zzhvVar = new zzhv();
            zzhvVar.zzc(new zzce(baseImplementation$ResultHolder));
            zzhvVar.zzb(strArr);
            zzhvVar.zza((zzhk) pairCreate.first);
            zzfmVar.zzj(zzhvVar.zzd());
            if (((zzpl) pairCreate.second).zzb()) {
                Object objZza = ((zzpl) pairCreate.second).zza();
                zzhc zzhcVar = this.zzm;
                if (zzhcVar != null) {
                    Pair pair = (Pair) objZza;
                    zzhcVar.zzc(((Payload.Stream) Preconditions.checkNotNull(payload.asStream())).asInputStream(), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.first), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.second), (zzhk) pairCreate.first, payload.getId());
                }
            }
        } catch (IOException e2) {
            Log.w("NearbyConnectionsClient", "Failed to create a Parcelable Payload.", e2);
            baseImplementation$ResultHolder.setResult(zzG(8013));
        }
    }
}
