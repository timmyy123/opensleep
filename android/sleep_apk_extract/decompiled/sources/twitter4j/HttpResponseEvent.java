package twitter4j;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpResponseEvent {
    private final HttpRequest request;
    private final HttpResponse response;
    private final TwitterException twitterException;

    public HttpResponseEvent(HttpRequest httpRequest, HttpResponse httpResponse, TwitterException twitterException) {
        this.request = httpRequest;
        this.response = httpResponse;
        this.twitterException = twitterException;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HttpResponseEvent.class != obj.getClass()) {
            return false;
        }
        HttpResponseEvent httpResponseEvent = (HttpResponseEvent) obj;
        HttpRequest httpRequest = this.request;
        HttpRequest httpRequest2 = httpResponseEvent.request;
        if (httpRequest == null ? httpRequest2 != null : !httpRequest.equals(httpRequest2)) {
            return false;
        }
        HttpResponse httpResponse = this.response;
        HttpResponse httpResponse2 = httpResponseEvent.response;
        return httpResponse == null ? httpResponse2 == null : httpResponse.equals(httpResponse2);
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public TwitterException getTwitterException() {
        return this.twitterException;
    }

    public int hashCode() {
        HttpRequest httpRequest = this.request;
        int iHashCode = (httpRequest != null ? httpRequest.hashCode() : 0) * 31;
        HttpResponse httpResponse = this.response;
        return iHashCode + (httpResponse != null ? httpResponse.hashCode() : 0);
    }

    public boolean isAuthenticated() {
        return this.request.getAuthorization().isEnabled();
    }

    public String toString() {
        return "HttpResponseEvent{request=" + this.request + ", response=" + this.response + '}';
    }
}
