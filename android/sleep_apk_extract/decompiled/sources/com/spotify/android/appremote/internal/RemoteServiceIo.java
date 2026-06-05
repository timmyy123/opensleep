package com.spotify.android.appremote.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.spotify.android.appremote.api.LocalConnector$1$$ExternalSyntheticLambda0;
import com.spotify.android.appremote.api.error.SpotifyConnectionTerminatedException;
import com.spotify.android.appremote.api.error.SpotifyDisconnectedException;
import com.spotify.android.appremote.api.error.SpotifyRemoteServiceException;
import com.spotify.protocol.client.AppProtocolIo;
import com.spotify.protocol.client.Debug;
import com.spotify.protocol.client.OnConnectionTerminatedListener;
import com.spotify.protocol.client.PendingResult;
import com.spotify.protocol.error.SpotifyAppRemoteException;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public class RemoteServiceIo implements RemoteService {
    private final Context mContext;
    private AppProtocolIo.DataInput mDataInput;
    private OnConnectionTerminatedListener mOnConnectionTerminatedListener;
    private Messenger mOutgoingMessenger;
    private PendingServiceConnectionResult mPendingServiceConnectionResult;
    private final String mSpotifyPackageName;
    private final Messenger mIncomingMessenger = new Messenger(new IncomingHandler(this));
    private State mState = State.DISCONNECTED;

    public static class IncomingHandler extends Handler {
        private final WeakReference<RemoteServiceIo> mContext;

        public IncomingHandler(RemoteServiceIo remoteServiceIo) {
            this.mContext = new WeakReference<>(remoteServiceIo);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RemoteServiceIo remoteServiceIo = this.mContext.get();
            if (remoteServiceIo != null) {
                remoteServiceIo.handleMessage(message);
            }
        }
    }

    public enum State {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        TERMINATED
    }

    public RemoteServiceIo(String str, Context context) {
        this.mSpotifyPackageName = str;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                Debug.e("Unknown message: %d", Integer.valueOf(i));
                return;
            }
            byte[] byteArray = message.getData().getByteArray("MESSAGE_BODY");
            Debug.d("Message from Spotify: %s", new String(byteArray, Charset.forName(OAuth.ENCODING)));
            this.mDataInput.onData(byteArray, byteArray.length);
            return;
        }
        Messenger messenger = message.replyTo;
        if (messenger == null) {
            this.mPendingServiceConnectionResult.deliverFailure(new SpotifyAppRemoteException("Can't connect to Spotify service"));
        } else {
            this.mOutgoingMessenger = messenger;
            this.mPendingServiceConnectionResult.deliverSuccess();
        }
    }

    @Override // com.spotify.protocol.client.AppProtocolIo
    public PendingResult<Void> connect() {
        Debug.d("Start remote client", new Object[0]);
        this.mPendingServiceConnectionResult = new PendingServiceConnectionResult();
        try {
            if (SpotifyServiceBinder.bindService(this.mContext, this, this.mSpotifyPackageName).booleanValue()) {
                Debug.d("Connecting to Spotify service", new Object[0]);
                this.mState = State.CONNECTING;
                return this.mPendingServiceConnectionResult;
            }
            throw new IllegalStateException("Can't connect to Spotify service with package " + this.mSpotifyPackageName);
        } catch (Exception e) {
            Debug.e("Can't connect to Spotify service", new Object[0]);
            this.mPendingServiceConnectionResult.deliverFailure(new SpotifyRemoteServiceException("Unable to connect to Spotify service", e));
            return this.mPendingServiceConnectionResult;
        }
    }

    @Override // com.spotify.protocol.client.AppProtocolIo
    public void disconnect() {
        Debug.d("Stop remote client", new Object[0]);
        try {
            this.mContext.getApplicationContext().unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.mState = State.TERMINATED;
        this.mOutgoingMessenger = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Debug.d("Spotify service connected", new Object[0]);
        Messenger messenger = new Messenger(iBinder);
        Message messageObtain = Message.obtain();
        messageObtain.replyTo = this.mIncomingMessenger;
        try {
            messenger.send(messageObtain);
        } catch (RemoteException unused) {
            Debug.e("Could not send message to Spotify", new Object[0]);
        }
        this.mState = State.CONNECTED;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Debug.e("Spotify service disconnected", new Object[0]);
        this.mOutgoingMessenger = null;
        this.mState = State.TERMINATED;
        OnConnectionTerminatedListener onConnectionTerminatedListener = this.mOnConnectionTerminatedListener;
        if (onConnectionTerminatedListener != null) {
            ((LocalConnector$1$$ExternalSyntheticLambda0) onConnectionTerminatedListener).onConnectionTerminated();
        }
    }

    @Override // com.spotify.protocol.client.AppProtocolIo
    public void setDataInput(AppProtocolIo.DataInput dataInput) {
        this.mDataInput = dataInput;
    }

    @Override // com.spotify.android.appremote.internal.RemoteService
    public void setOnConnectionTerminatedListener(OnConnectionTerminatedListener onConnectionTerminatedListener) {
        this.mOnConnectionTerminatedListener = onConnectionTerminatedListener;
    }

    @Override // com.spotify.protocol.client.AppProtocolIo
    public void writeData(byte[] bArr, int i) throws SpotifyConnectionTerminatedException, SpotifyDisconnectedException {
        State state = this.mState;
        if (state == State.TERMINATED) {
            throw new SpotifyConnectionTerminatedException();
        }
        if (state == State.DISCONNECTED) {
            throw new SpotifyDisconnectedException();
        }
        if (this.mOutgoingMessenger == null) {
            Debug.e("No outgoing messenger", new Object[0]);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray("MESSAGE_BODY", bArr);
        Message messageObtain = Message.obtain();
        messageObtain.setData(bundle);
        try {
            this.mOutgoingMessenger.send(messageObtain);
        } catch (RemoteException e) {
            Debug.e("Couldn't send message to Spotify App: %s", e.getMessage());
        }
    }
}
