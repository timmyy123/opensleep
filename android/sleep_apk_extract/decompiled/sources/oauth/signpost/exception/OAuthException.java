package oauth.signpost.exception;

/* JADX INFO: loaded from: classes5.dex */
public abstract class OAuthException extends Exception {
    public OAuthException(String str) {
        super(str);
    }

    public OAuthException(Throwable th) {
        super(th);
    }

    public OAuthException(String str, Throwable th) {
        super(str, th);
    }
}
