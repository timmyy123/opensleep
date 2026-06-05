package kaaes.spotify.webapi.android;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SpotifyCallback<T> implements Callback<T> {
    public abstract void failure(SpotifyError spotifyError);

    @Override // retrofit.Callback
    public void failure(RetrofitError retrofitError) {
        failure(SpotifyError.fromRetrofitError(retrofitError));
    }

    @Override // retrofit.Callback
    public abstract /* synthetic */ void success(Object obj, Response response);
}
