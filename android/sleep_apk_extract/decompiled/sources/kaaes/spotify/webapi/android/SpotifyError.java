package kaaes.spotify.webapi.android;

import kaaes.spotify.webapi.android.models.ErrorDetails;
import kaaes.spotify.webapi.android.models.ErrorResponse;
import retrofit.RetrofitError;

/* JADX INFO: loaded from: classes5.dex */
public class SpotifyError extends Exception {
    private final ErrorDetails mErrorDetails;
    private final RetrofitError mRetrofitError;

    public SpotifyError(RetrofitError retrofitError) {
        super(retrofitError);
        this.mRetrofitError = retrofitError;
        this.mErrorDetails = null;
    }

    public static SpotifyError fromRetrofitError(RetrofitError retrofitError) {
        ErrorResponse errorResponse;
        try {
            errorResponse = (ErrorResponse) retrofitError.getBodyAs(ErrorResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            errorResponse = null;
        }
        if (errorResponse == null || errorResponse.error == null) {
            return new SpotifyError(retrofitError);
        }
        return new SpotifyError(retrofitError, errorResponse.error, errorResponse.error.status + " " + errorResponse.error.message);
    }

    public ErrorDetails getErrorDetails() {
        return this.mErrorDetails;
    }

    public RetrofitError getRetrofitError() {
        return this.mRetrofitError;
    }

    public boolean hasErrorDetails() {
        return this.mErrorDetails != null;
    }

    public SpotifyError(RetrofitError retrofitError, ErrorDetails errorDetails, String str) {
        super(str, retrofitError);
        this.mRetrofitError = retrofitError;
        this.mErrorDetails = errorDetails;
    }
}
