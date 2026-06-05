package com.google.android.gms.home.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.serialization.InteractionOptions;
import com.google.android.gms.internal.serialization.zzg;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010\"J\u0019\u0010&\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b&\u0010'R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010(¨\u0006*"}, d2 = {"Lcom/google/android/gms/home/internal/InteractionClientImpl;", "Lcom/google/android/gms/common/internal/GmsClient;", "Lcom/google/android/gms/home/interaction/internal/IInteractionService;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/os/Looper;", "looper", "Lcom/google/android/gms/common/internal/ClientSettings;", "clientSettings", "Lcom/google/android/gms/common/api/internal/ConnectionCallbacks;", "connectionCallbacks", "Lcom/google/android/gms/common/api/internal/OnConnectionFailedListener;", "connectionFailedListener", "Lcom/google/android/gms/home/interaction/InteractionOptions;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "<init>", "(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/ClientSettings;Lcom/google/android/gms/common/api/internal/ConnectionCallbacks;Lcom/google/android/gms/common/api/internal/OnConnectionFailedListener;Lcom/google/android/gms/home/interaction/InteractionOptions;)V", "Landroid/os/Bundle;", "getGetServiceRequestExtraArgs", "()Landroid/os/Bundle;", "", "getStartServiceAction", "()Ljava/lang/String;", "getServiceDescriptor", "", "Lcom/google/android/gms/common/Feature;", "kotlin.jvm.PlatformType", "getApiFeatures", "()[Lcom/google/android/gms/common/Feature;", "", "getMinApkVersion", "()I", "", "getUseDynamicLookup", "()Z", "usesClientTelemetry", "Landroid/os/IBinder;", "iBinder", "createServiceInterface", "(Landroid/os/IBinder;)Lcom/google/android/gms/home/interaction/internal/IInteractionService;", "Lcom/google/android/gms/home/interaction/InteractionOptions;", "Companion", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InteractionClientImpl extends GmsClient<com.google.android.gms.internal.serialization.zzba> {
    private final InteractionOptions zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionClientImpl(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, InteractionOptions interactionOptions) {
        super(context, looper, 336, clientSettings, connectionCallbacks, onConnectionFailedListener);
        context.getClass();
        looper.getClass();
        clientSettings.getClass();
        connectionCallbacks.getClass();
        onConnectionFailedListener.getClass();
        interactionOptions.getClass();
        this.zze = interactionOptions;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        iBinder.getClass();
        return com.google.android.gms.internal.serialization.zzaz.zza(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{zzg.zzn, zzg.zzq};
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("INTERACTION_OPTIONS", SafeParcelableSerializer.serializeToBytes(this.zze));
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 17895000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.home.interaction.internal.IInteractionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.home.interaction.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean getUseDynamicLookup() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }
}
