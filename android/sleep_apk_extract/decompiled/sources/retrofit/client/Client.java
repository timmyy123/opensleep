package retrofit.client;

/* JADX INFO: loaded from: classes5.dex */
public interface Client {

    public interface Provider {
        Client get();
    }

    Response execute(Request request);
}
