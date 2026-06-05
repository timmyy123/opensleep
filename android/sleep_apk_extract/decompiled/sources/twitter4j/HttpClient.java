package twitter4j;

import twitter4j.auth.Authorization;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpClient {
    HttpResponse delete(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener);

    HttpResponse get(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener);

    HttpResponse post(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener);
}
