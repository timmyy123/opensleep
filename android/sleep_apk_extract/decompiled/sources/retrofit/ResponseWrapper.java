package retrofit;

import retrofit.client.Response;

/* JADX INFO: loaded from: classes5.dex */
final class ResponseWrapper {
    final Response response;
    final Object responseBody;

    public ResponseWrapper(Response response, Object obj) {
        this.response = response;
        this.responseBody = obj;
    }
}
