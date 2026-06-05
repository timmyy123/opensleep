package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.Intent;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DaemonRequest {
    private Callback mCallback;
    private Context mContext;
    private SDKLogger mLogger;
    private JSONObject mParameters;
    private ConcurrentHashMap<String, CompletableFuture<GraphResponse>> mRequestStore;

    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    public DaemonRequest(Context context, JSONObject jSONObject, Callback callback) {
        this.mContext = context;
        this.mParameters = jSONObject;
        this.mCallback = callback;
        this.mRequestStore = DaemonReceiver.getInstance(context).getRequestStore();
        this.mLogger = SDKLogger.getInstance(context);
    }

    private CompletableFuture<GraphResponse> createRequest() {
        return CompletableFuture.supplyAsync(new Supplier<GraphResponse>() { // from class: com.facebook.gamingservices.cloudgaming.DaemonRequest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.function.Supplier
            public GraphResponse get() {
                String string = UUID.randomUUID().toString();
                try {
                    DaemonRequest.this.mParameters.put(SDKConstants.REQUEST_ID, string);
                    Intent intent = new Intent();
                    String string2 = DaemonRequest.this.mParameters.getString("type");
                    DaemonRequest.this.mLogger.logPreparingRequest(string2, string, DaemonRequest.this.mParameters);
                    if (!string2.equals(SDKMessageEnum.GET_ACCESS_TOKEN.toString()) && !string2.equals(SDKMessageEnum.IS_ENV_READY.toString())) {
                        String string3 = DaemonRequest.this.mContext.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).getString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, null);
                        if (string3 == null) {
                            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request with a secure connection"), string);
                        }
                        intent.setPackage(string3);
                    }
                    intent.setAction(SDKConstants.REQUEST_ACTION);
                    Iterator<String> itKeys = DaemonRequest.this.mParameters.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        intent.putExtra(next, DaemonRequest.this.mParameters.getString(next));
                    }
                    CompletableFuture completableFuture = new CompletableFuture();
                    DaemonRequest.this.mRequestStore.put(string, completableFuture);
                    DaemonRequest.this.mContext.sendBroadcast(intent);
                    DaemonRequest.this.mLogger.logSentRequest(string2, string, DaemonRequest.this.mParameters);
                    return (GraphResponse) completableFuture.get();
                } catch (InterruptedException | ExecutionException | JSONException unused) {
                    return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), string);
                }
            }
        });
    }

    public static GraphResponse executeAndWait(Context context, JSONObject jSONObject, SDKMessageEnum sDKMessageEnum) {
        try {
            return new DaemonRequest(context, jSONObject == null ? new JSONObject().put("type", sDKMessageEnum.toString()) : jSONObject.put("type", sDKMessageEnum.toString()), null).executeAndWait();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
        }
    }

    public static void executeAsync(Context context, JSONObject jSONObject, Callback callback, SDKMessageEnum sDKMessageEnum) {
        try {
            new DaemonRequest(context, jSONObject == null ? new JSONObject().put("type", sDKMessageEnum.toString()) : jSONObject.put("type", sDKMessageEnum.toString()), callback).executeAsync();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            if (callback != null) {
                callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
            }
        }
    }

    private GraphResponse executeAndWait(int i) {
        return createRequest().get(i, TimeUnit.SECONDS);
    }

    private GraphResponse executeAndWait() {
        return createRequest().get();
    }

    public static GraphResponse executeAndWait(Context context, JSONObject jSONObject, SDKMessageEnum sDKMessageEnum, int i) {
        try {
            return new DaemonRequest(context, jSONObject == null ? new JSONObject().put("type", sDKMessageEnum.toString()) : jSONObject.put("type", sDKMessageEnum.toString()), null).executeAndWait(i);
        } catch (InterruptedException | ExecutionException | TimeoutException | JSONException unused) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
        }
    }

    private void executeAsync() {
        createRequest().thenAccept((Consumer<? super GraphResponse>) new Consumer<GraphResponse>() { // from class: com.facebook.gamingservices.cloudgaming.DaemonRequest.1
            @Override // java.util.function.Consumer
            public void accept(GraphResponse graphResponse) {
                if (DaemonRequest.this.mCallback != null) {
                    DaemonRequest.this.mCallback.onCompleted(graphResponse);
                }
            }
        });
    }

    public static void executeAsync(Context context, JSONObject jSONObject, Callback callback, String str) {
        JSONObject jSONObjectPut;
        try {
            if (jSONObject == null) {
                jSONObjectPut = new JSONObject().put("type", str);
            } else {
                jSONObjectPut = jSONObject.put("type", str);
            }
            new DaemonRequest(context, jSONObjectPut, callback).executeAsync();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            if (callback != null) {
                callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
            }
        }
    }
}
