package twitter4j;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class TwitterException extends Exception implements Serializable {
    private static final String[] FILTER = {"twitter4j"};
    private static final long serialVersionUID = 6006561839051121336L;
    private int errorCode;
    private String errorMessage;
    private ExceptionDiagnosis exceptionDiagnosis;
    private boolean nested;
    private HttpResponse response;
    private int statusCode;

    public TwitterException(String str, Throwable th) {
        super(str, th);
        this.statusCode = -1;
        this.errorCode = -1;
        this.exceptionDiagnosis = null;
        this.errorMessage = null;
        this.nested = false;
        decode(str);
    }

    private void decode(String str) {
        if (str == null || !str.startsWith("{")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("errors")) {
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONArray("errors").getJSONObject(0);
            this.errorMessage = jSONObject2.getString("message");
            this.errorCode = ParseUtil.getInt("code", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    private static String getCause(int i) {
        String str;
        if (i == 304) {
            str = "There was no new data to return.";
        } else if (i == 406) {
            str = "Returned by the Search API when an invalid format is specified in the request.\nReturned by the Streaming API when one or more of the parameters are not suitable for the resource. The track parameter, for example, would throw this error if:\n The track keyword is too long or too short.\n The bounding box specified is invalid.\n No predicates defined for filtered resource, for example, neither track nor follow parameter defined.\n Follow userid cannot be read.";
        } else if (i == 420) {
            str = "Returned by the Search and Trends API when you are being rate limited (https://dev.twitter.com/docs/rate-limiting).\nReturned by the Streaming API:\n Too many login attempts in a short period of time.\n Running too many copies of the same application authenticating with the same account name.";
        } else if (i == 422) {
            str = "Returned when an image uploaded to POST account/update_profile_banner(https://dev.twitter.com/docs/api/1/post/account/update_profile_banner) is unable to be processed.";
        } else if (i == 429) {
            str = "Returned in API v1.1 when a request cannot be served due to the application's rate limit having been exhausted for the resource. See Rate Limiting in API v1.1.(https://dev.twitter.com/docs/rate-limiting/1.1)";
        } else if (i == 500) {
            str = "Something is broken. Please post to the group (https://dev.twitter.com/docs/support) so the Twitter team can investigate.";
        } else if (i == 400) {
            str = "The request was invalid. An accompanying error message will explain why. This is the status code will be returned during version 1.0 rate limiting(https://dev.twitter.com/pages/rate-limiting). In API v1.1, a request without authentication is considered invalid and you will get this response.";
        } else if (i == 401) {
            str = "Authentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect. Ensure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync.";
        } else if (i == 403) {
            str = "The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following).";
        } else if (i != 404) {
            switch (i) {
                case 502:
                    str = "Twitter is down or being upgraded.";
                    break;
                case 503:
                    str = "The Twitter servers are up, but overloaded with requests. Try again later.";
                    break;
                case 504:
                    str = "The Twitter servers are up, but the request couldn't be serviced due to some failure within our stack. Try again later.";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method.";
        }
        return i + ":" + str;
    }

    private ExceptionDiagnosis getExceptionDiagnosis() {
        if (this.exceptionDiagnosis == null) {
            this.exceptionDiagnosis = new ExceptionDiagnosis(this, FILTER);
        }
        return this.exceptionDiagnosis;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TwitterException twitterException = (TwitterException) obj;
        if (this.errorCode != twitterException.errorCode || this.nested != twitterException.nested || this.statusCode != twitterException.statusCode) {
            return false;
        }
        String str = this.errorMessage;
        String str2 = twitterException.errorMessage;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        ExceptionDiagnosis exceptionDiagnosis = this.exceptionDiagnosis;
        ExceptionDiagnosis exceptionDiagnosis2 = twitterException.exceptionDiagnosis;
        if (exceptionDiagnosis == null ? exceptionDiagnosis2 != null : !exceptionDiagnosis.equals(exceptionDiagnosis2)) {
            return false;
        }
        HttpResponse httpResponse = this.response;
        HttpResponse httpResponse2 = twitterException.response;
        return httpResponse == null ? httpResponse2 == null : httpResponse.equals(httpResponse2);
    }

    public String getExceptionCode() {
        return getExceptionDiagnosis().asHexString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (this.errorMessage == null || this.errorCode == -1) {
            sb.append(super.getMessage());
        } else {
            sb.append("message - ");
            sb.append(this.errorMessage);
            sb.append("\ncode - ");
            sb.append(this.errorCode);
            sb.append("\n");
        }
        if (this.statusCode == -1) {
            return sb.toString();
        }
        return getCause(this.statusCode) + "\n" + sb.toString();
    }

    public RateLimitStatus getRateLimitStatus() {
        HttpResponse httpResponse = this.response;
        if (httpResponse == null) {
            return null;
        }
        return JSONImplFactory.createRateLimitStatusFromResponseHeader(httpResponse);
    }

    public int getRetryAfter() {
        int i = this.statusCode;
        if (i == 400) {
            RateLimitStatus rateLimitStatus = getRateLimitStatus();
            if (rateLimitStatus != null) {
                return rateLimitStatus.getSecondsUntilReset();
            }
            return -1;
        }
        if (i != 420) {
            return -1;
        }
        try {
            String responseHeader = this.response.getResponseHeader("Retry-After");
            if (responseHeader != null) {
                return Integer.valueOf(responseHeader).intValue();
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        int i = ((this.statusCode * 31) + this.errorCode) * 31;
        ExceptionDiagnosis exceptionDiagnosis = this.exceptionDiagnosis;
        int iHashCode = (i + (exceptionDiagnosis != null ? exceptionDiagnosis.hashCode() : 0)) * 31;
        HttpResponse httpResponse = this.response;
        int iHashCode2 = (iHashCode + (httpResponse != null ? httpResponse.hashCode() : 0)) * 31;
        String str = this.errorMessage;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + (this.nested ? 1 : 0);
    }

    public void setNested() {
        this.nested = true;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getMessage());
        String str2 = "";
        if (this.nested) {
            str = "";
        } else {
            str = "\nRelevant discussions can be found on the Internet at:\n\thttp://www.google.co.jp/search?q=" + getExceptionDiagnosis().getStackLineHashAsHex() + " or\n\thttp://www.google.co.jp/search?q=" + getExceptionDiagnosis().getLineNumberHashAsHex();
        }
        sb.append(str);
        sb.append("\nTwitterException{");
        if (!this.nested) {
            str2 = "exceptionCode=[" + getExceptionCode() + "], ";
        }
        sb.append(str2);
        sb.append("statusCode=");
        sb.append(this.statusCode);
        sb.append(", message=");
        sb.append(this.errorMessage);
        sb.append(", code=");
        sb.append(this.errorCode);
        sb.append(", retryAfter=");
        sb.append(getRetryAfter());
        sb.append(", rateLimitStatus=");
        sb.append(getRateLimitStatus());
        sb.append(", version=");
        sb.append(Version.getVersion());
        sb.append('}');
        return sb.toString();
    }

    public TwitterException(String str) {
        this(str, (Throwable) null);
    }

    public TwitterException(Exception exc) {
        this(exc.getMessage(), exc);
        if (exc instanceof TwitterException) {
            ((TwitterException) exc).setNested();
        }
    }

    public TwitterException(String str, HttpResponse httpResponse) {
        this(str);
        this.response = httpResponse;
        this.statusCode = httpResponse.getStatusCode();
    }

    public TwitterException(String str, Exception exc, int i) {
        this(str, exc);
        this.statusCode = i;
    }
}
