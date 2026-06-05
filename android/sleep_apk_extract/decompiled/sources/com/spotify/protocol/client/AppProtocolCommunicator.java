package com.spotify.protocol.client;

import com.spotify.protocol.AppProtocol;
import com.spotify.protocol.WampClient$Receiver;
import com.spotify.protocol.WampClient$Router;
import com.spotify.protocol.WampMessage;
import com.spotify.protocol.client.AppProtocolIo;
import com.spotify.protocol.error.SpotifyAppRemoteException;
import com.spotify.protocol.mappers.JsonMapper;
import com.spotify.protocol.mappers.JsonMappingException;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.HelloDetails;
import com.spotify.protocol.types.Info;
import com.spotify.protocol.types.Message;
import com.spotify.protocol.types.Roles;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public class AppProtocolCommunicator implements AppProtocolIo.DataInput {
    private final HelloDetails mHelloDetails;
    private final JsonMapper mJsonMapper;
    private final AppProtocolIo mProtocolIo;
    private final WampClient$Router mRouter = new WampRouterImpl();

    public AppProtocolCommunicator(ConnectionDetails connectionDetails, JsonMapper jsonMapper, AppProtocolIo appProtocolIo) {
        this.mJsonMapper = jsonMapper;
        this.mProtocolIo = appProtocolIo;
        this.mHelloDetails = new HelloDetails(new Roles(null, null, new Empty(), new Empty()), new Info(1, connectionDetails.getRequiredFeatures(), connectionDetails.getId(), connectionDetails.getName(), connectionDetails.getModel(), connectionDetails.getCategory(), connectionDetails.getVersion(), null, connectionDetails.getImageWidth(), connectionDetails.getImageHeight(), connectionDetails.getThumbnailImageHeight(), connectionDetails.getThumbnailImageHeight()), connectionDetails.getAuthMethods(), connectionDetails.getAuthId(), connectionDetails.getExtras());
        appProtocolIo.setDataInput(this);
    }

    private void sendWamp(Object[] objArr) throws SpotifyAppRemoteException {
        try {
            byte[] bytes = this.mJsonMapper.toJson(Arrays.asList(objArr)).getBytes(Charset.forName(OAuth.ENCODING));
            this.mProtocolIo.writeData(bytes, bytes.length);
        } catch (JsonMappingException e) {
            throw new SpotifyAppRemoteException(e);
        }
    }

    @Override // com.spotify.protocol.client.AppProtocolIo.DataInput
    public void onData(byte[] bArr, int i) {
        try {
            this.mRouter.route(new WampMessage(this.mJsonMapper.toJsonArray(new String(bArr, Charset.forName(OAuth.ENCODING)))));
        } catch (JsonMappingException e) {
            Debug.e(e, "Message is not parsed.", new Object[0]);
        }
    }

    public void sendCall(int i, Object obj, String str, List<Object> list, Object obj2) throws SpotifyAppRemoteException {
        sendWamp(new Object[]{48, Integer.valueOf(i), AppProtocol.EMPTY, str, list, obj2});
    }

    public void sendGoodbye() throws SpotifyAppRemoteException {
        sendWamp(new Object[]{6, new Message("The client is shutting down"), "wamp.client_request.system_shutdown"});
    }

    public void sendHello() throws SpotifyAppRemoteException {
        sendWamp(new Object[]{1, "spotify", this.mHelloDetails});
    }

    public void sendSubscribe(int i, Object obj, String str) throws SpotifyAppRemoteException {
        sendWamp(new Object[]{32, Integer.valueOf(i), obj, str});
    }

    public void sendUnsubscribe(int i, int i2) throws SpotifyAppRemoteException {
        sendWamp(new Object[]{34, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public void setMessageReceiver(WampClient$Receiver wampClient$Receiver) {
        this.mRouter.addReceiver(wampClient$Receiver);
    }
}
