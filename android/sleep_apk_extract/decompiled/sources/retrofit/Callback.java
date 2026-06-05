package retrofit;

import retrofit.client.Response;

/* JADX INFO: loaded from: classes5.dex */
public interface Callback<T> {
    void failure(RetrofitError retrofitError);

    void success(T t, Response response);
}
