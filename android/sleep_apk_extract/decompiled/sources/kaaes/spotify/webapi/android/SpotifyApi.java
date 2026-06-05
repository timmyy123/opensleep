package kaaes.spotify.webapi.android;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import oauth.signpost.OAuth;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;

/* JADX INFO: loaded from: classes5.dex */
public class SpotifyApi {
    public static final String SPOTIFY_WEB_API_ENDPOINT = "https://api.spotify.com/v1";
    private String mAccessToken;
    private final SpotifyService mSpotifyService;

    public class WebApiAuthenticator implements RequestInterceptor {
        private WebApiAuthenticator() {
        }

        @Override // retrofit.RequestInterceptor
        public void intercept(RequestInterceptor.RequestFacade requestFacade) {
            if (SpotifyApi.this.mAccessToken != null) {
                requestFacade.addHeader(OAuth.HTTP_AUTHORIZATION_HEADER, "Bearer " + SpotifyApi.this.mAccessToken);
            }
        }
    }

    public SpotifyApi() {
        this.mSpotifyService = init(Executors.newSingleThreadExecutor(), new MainThreadExecutor());
    }

    private SpotifyService init(Executor executor, Executor executor2) {
        return (SpotifyService) new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.BASIC).setExecutors(executor, executor2).setEndpoint(SPOTIFY_WEB_API_ENDPOINT).setRequestInterceptor(new WebApiAuthenticator()).build().create(SpotifyService.class);
    }

    public SpotifyService getService() {
        return this.mSpotifyService;
    }

    public SpotifyApi setAccessToken(String str) {
        this.mAccessToken = str;
        return this;
    }

    public SpotifyApi(Executor executor, Executor executor2) {
        this.mSpotifyService = init(executor, executor2);
    }
}
