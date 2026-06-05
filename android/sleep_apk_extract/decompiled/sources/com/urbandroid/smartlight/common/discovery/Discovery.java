package com.urbandroid.smartlight.common.discovery;

import com.facebook.GraphResponse;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Gateway;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002\r\u000eJ\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&J#\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/smartlight/common/discovery/Discovery;", "G", "Lcom/urbandroid/smartlight/common/model/Gateway;", "", "discover", "", "listener", "Lcom/urbandroid/smartlight/common/discovery/Discovery$Listener;", "authenticate", "gateway", "Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;", "(Lcom/urbandroid/smartlight/common/model/Gateway;Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;)V", "close", "Listener", "AuthListener", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Discovery<G extends Gateway> {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;", "G", "", "authRequired", "", "gateway", "(Ljava/lang/Object;)V", "failed", GraphResponse.SUCCESS_KEY, "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface AuthListener<G> {
        void authRequired(G gateway);

        void failed(G gateway);

        void success(AuthenticatedGateway gateway);
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <G extends Gateway> void close(Discovery<G> discovery) {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00028\u0001H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/urbandroid/smartlight/common/discovery/Discovery$Listener;", "G", "", "onStart", "", "onStop", "found", "gateway", "(Ljava/lang/Object;)V", "failed", "message", "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Listener<G> {
        void failed(String message);

        void found(G gateway);

        void onStart();

        void onStop();
    }

    void authenticate(G gateway, AuthListener<G> listener);

    void close();

    void discover(Listener<G> listener);
}
