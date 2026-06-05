package com.spotify.android.appremote.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.internal.ServerProtocol;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.protocol.client.AppProtocolCommunicator;
import com.spotify.protocol.client.Coding;
import com.spotify.protocol.client.ConnectionDetails;
import com.spotify.protocol.client.OnConnectionTerminatedListener;
import com.spotify.protocol.client.RemoteClientConnector;
import com.spotify.protocol.client.RemoteWampClient;
import com.spotify.protocol.client.Result;
import com.spotify.protocol.client.ResultUtils;
import com.spotify.protocol.client.WampCallsOrchestrator;
import com.spotify.protocol.mappers.JsonMapper;
import com.spotify.protocol.types.WelcomeDetails;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class SdkRemoteClientConnector implements RemoteClientConnector {
    private ConnectionTask mConnectionTask;
    private final Context mContext;
    private final ConnectionParams mParams;
    private RemoteService mRemoteService;
    private RemoteWampClient mRemoteWampClient;
    private final String mSpotifyPackagename;

    public static final class ConnectionTask extends AsyncTask<Void, Void, Result<WelcomeDetails>> {
        private final RemoteClientConnector.ConnectionCallback mConnectionCallback;
        private final ConnectionDetails mConnectionDetails;
        private final JsonMapper mJsonMapper;
        private final SdkRemoteClientConnector mOuter;

        private ConnectionTask(SdkRemoteClientConnector sdkRemoteClientConnector, ConnectionParams connectionParams, RemoteClientConnector.ConnectionCallback connectionCallback) {
            this.mOuter = sdkRemoteClientConnector;
            this.mConnectionCallback = connectionCallback;
            this.mJsonMapper = connectionParams.getJsonMapper();
            ConnectionDetails.Builder requiredFeatures = new ConnectionDetails.Builder(connectionParams.getClientId()).setName(sdkRemoteClientConnector.mContext.getPackageName()).setCategory("app").setVersion("0.8.0").setRequiredFeatures(connectionParams.getRequiredFeatures());
            if (connectionParams.getAuthMethod() == ConnectionParams.AuthMethod.APP_ID) {
                HashMap map = new HashMap(5);
                map.put(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, connectionParams.getRedirectUri());
                map.put("show_auth_view", String.valueOf(connectionParams.shouldShowAuthView()));
                map.put("scopes", "app-remote-control");
                requiredFeatures.setAuthMethods(new String[]{"appid"});
                requiredFeatures.setAuthId(connectionParams.getClientId());
                requiredFeatures.setExtras(map);
            }
            this.mConnectionDetails = requiredFeatures.build();
        }

        @Override // android.os.AsyncTask
        public Result<WelcomeDetails> doInBackground(Void... voidArr) {
            Result<Void> resultAwait = this.mOuter.mRemoteService.connect().await(30L, TimeUnit.SECONDS);
            return resultAwait.isSuccessful() ? this.mOuter.mRemoteWampClient.hello(WelcomeDetails.class).await(1L, TimeUnit.HOURS) : ResultUtils.createErrorResult(resultAwait.getError());
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Result<WelcomeDetails> result) {
            boolean zIsSuccessful = result.isSuccessful();
            RemoteClientConnector.ConnectionCallback connectionCallback = this.mConnectionCallback;
            if (zIsSuccessful) {
                connectionCallback.onConnected(this.mOuter.mRemoteWampClient);
            } else {
                connectionCallback.onConnectionFailed(result.getError());
            }
            this.mOuter.mConnectionTask = null;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            SdkRemoteClientConnector sdkRemoteClientConnector = this.mOuter;
            sdkRemoteClientConnector.mRemoteService = new RemoteServiceIo(sdkRemoteClientConnector.mSpotifyPackagename, this.mOuter.mContext);
            AppProtocolCommunicator appProtocolCommunicator = new AppProtocolCommunicator(this.mConnectionDetails, this.mJsonMapper, this.mOuter.mRemoteService);
            this.mOuter.mRemoteWampClient = new RemoteWampClient(appProtocolCommunicator, new WampCallsOrchestrator());
        }
    }

    private SdkRemoteClientConnector(@Nonnull Context context, @Nonnull ConnectionParams connectionParams, @Nonnull String str) {
        this.mContext = context;
        this.mParams = connectionParams;
        this.mSpotifyPackagename = str;
    }

    @Nonnull
    public static SdkRemoteClientConnector create(@Nonnull Context context, @Nonnull ConnectionParams connectionParams, @Nonnull String str) {
        Coding.checkNotNull(context);
        Coding.checkNotNull(connectionParams);
        Coding.checkNotNull(str);
        return new SdkRemoteClientConnector(context, connectionParams, str);
    }

    public void connect(@Nonnull RemoteClientConnector.ConnectionCallback connectionCallback) {
        ConnectionTask connectionTask = new ConnectionTask(this.mParams, connectionCallback);
        this.mConnectionTask = connectionTask;
        connectionTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.spotify.protocol.client.RemoteClientConnector
    public void disconnect() {
        RemoteService remoteService = this.mRemoteService;
        if (remoteService != null) {
            remoteService.disconnect();
        }
    }

    public void setConnectionTerminatedListener(@Nonnull OnConnectionTerminatedListener onConnectionTerminatedListener) {
        this.mRemoteWampClient.setOnConnectionTerminatedListener(onConnectionTerminatedListener);
        this.mRemoteService.setOnConnectionTerminatedListener(onConnectionTerminatedListener);
    }
}
