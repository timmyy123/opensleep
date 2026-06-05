package oauth.signpost.exception;

/* JADX INFO: loaded from: classes5.dex */
public class OAuthCommunicationException extends OAuthException {
    private String responseBody;

    public OAuthCommunicationException(Exception exc) {
        super("Communication with the service provider failed: " + exc.getLocalizedMessage(), exc);
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public OAuthCommunicationException(String str, String str2) {
        super(str);
        this.responseBody = str2;
    }
}
