package retrofit;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.RxSupport;
import retrofit.Utils;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/* JADX INFO: loaded from: classes5.dex */
public class RestAdapter {
    final Executor callbackExecutor;
    private final Client.Provider clientProvider;
    final Converter converter;
    final ErrorHandler errorHandler;
    final Executor httpExecutor;
    final Log log;
    volatile LogLevel logLevel;
    final RequestInterceptor requestInterceptor;
    private RxSupport rxSupport;
    final Endpoint server;
    private final Map<Class<?>, Map<Method, RestMethodInfo>> serviceMethodInfoCache;

    public static class Builder {
        private Executor callbackExecutor;
        private Client.Provider clientProvider;
        private Converter converter;
        private Endpoint endpoint;
        private ErrorHandler errorHandler;
        private Executor httpExecutor;
        private Log log;
        private LogLevel logLevel = LogLevel.NONE;
        private RequestInterceptor requestInterceptor;

        private void ensureSaneDefaults() {
            if (this.converter == null) {
                this.converter = Platform.get().defaultConverter();
            }
            if (this.clientProvider == null) {
                this.clientProvider = Platform.get().defaultClient();
            }
            if (this.httpExecutor == null) {
                this.httpExecutor = Platform.get().defaultHttpExecutor();
            }
            if (this.callbackExecutor == null) {
                this.callbackExecutor = Platform.get().defaultCallbackExecutor();
            }
            if (this.errorHandler == null) {
                this.errorHandler = ErrorHandler.DEFAULT;
            }
            if (this.log == null) {
                this.log = Platform.get().defaultLog();
            }
            if (this.requestInterceptor == null) {
                this.requestInterceptor = RequestInterceptor.NONE;
            }
        }

        public RestAdapter build() {
            if (this.endpoint == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Endpoint may not be null.");
                return null;
            }
            ensureSaneDefaults();
            return new RestAdapter(this.endpoint, this.clientProvider, this.httpExecutor, this.callbackExecutor, this.requestInterceptor, this.converter, null, this.errorHandler, this.log, this.logLevel);
        }

        public Builder setEndpoint(String str) {
            if (str == null || str.trim().length() == 0) {
                Types$$ExternalSyntheticBUOutline0.m$1("Endpoint may not be blank.");
                return null;
            }
            this.endpoint = Endpoints.newFixedEndpoint(str);
            return this;
        }

        public Builder setExecutors(Executor executor, Executor executor2) {
            if (executor == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("HTTP executor may not be null.");
                return null;
            }
            if (executor2 == null) {
                executor2 = new Utils.SynchronousExecutor();
            }
            this.httpExecutor = executor;
            this.callbackExecutor = executor2;
            return this;
        }

        public Builder setLogLevel(LogLevel logLevel) {
            if (logLevel != null) {
                this.logLevel = logLevel;
                return this;
            }
            Types$$ExternalSyntheticBUOutline0.m$1("Log level may not be null.");
            return null;
        }

        public Builder setRequestInterceptor(RequestInterceptor requestInterceptor) {
            if (requestInterceptor != null) {
                this.requestInterceptor = requestInterceptor;
                return this;
            }
            Types$$ExternalSyntheticBUOutline0.m$1("Request interceptor may not be null.");
            return null;
        }
    }

    public interface Log {
        void log(String str);
    }

    public enum LogLevel {
        NONE,
        BASIC,
        HEADERS,
        HEADERS_AND_ARGS,
        FULL;

        public boolean log() {
            return this != NONE;
        }
    }

    public class RestHandler implements InvocationHandler {
        private final Map<Method, RestMethodInfo> methodDetailsCache;

        public RestHandler(Map<Method, RestMethodInfo> map) {
            this.methodDetailsCache = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object invokeRequest(RequestInterceptor requestInterceptor, RestMethodInfo restMethodInfo, Object[] objArr) {
            ResponseWrapper responseWrapper;
            String str = null;
            try {
                try {
                    try {
                        restMethodInfo.init();
                        String url = RestAdapter.this.server.getUrl();
                        RequestBuilder requestBuilder = new RequestBuilder(url, restMethodInfo, RestAdapter.this.converter);
                        requestBuilder.setArguments(objArr);
                        requestInterceptor.intercept(requestBuilder);
                        Request requestBuild = requestBuilder.build();
                        String url2 = requestBuild.getUrl();
                        try {
                            if (!restMethodInfo.isSynchronous) {
                                int iIndexOf = url2.indexOf("?", url.length());
                                if (iIndexOf == -1) {
                                    iIndexOf = url2.length();
                                }
                                Thread.currentThread().setName("Retrofit-".concat(url2.substring(url.length(), iIndexOf)));
                            }
                            if (RestAdapter.this.logLevel.log()) {
                                requestBuild = RestAdapter.this.logAndReplaceRequest("HTTP", requestBuild, objArr);
                            }
                            RestAdapter.access$200(RestAdapter.this);
                            long jNanoTime = System.nanoTime();
                            Response responseExecute = RestAdapter.this.clientProvider.get().execute(requestBuild);
                            long jNanoTime2 = (System.nanoTime() - jNanoTime) / 1000000;
                            int status = responseExecute.getStatus();
                            RestAdapter.access$200(RestAdapter.this);
                            if (RestAdapter.this.logLevel.log()) {
                                responseExecute = RestAdapter.this.logAndReplaceResponse(url2, responseExecute, jNanoTime2);
                            }
                            Type type = restMethodInfo.responseObjectType;
                            if (status < 200 || status >= 300) {
                                throw RetrofitError.httpError(url2, Utils.readBodyToBytesIfNecessary(responseExecute), RestAdapter.this.converter, type);
                            }
                            if (type.equals(Response.class)) {
                                if (!restMethodInfo.isStreaming) {
                                    responseExecute = Utils.readBodyToBytesIfNecessary(responseExecute);
                                }
                                boolean z = restMethodInfo.isSynchronous;
                                if (z) {
                                    if (!z) {
                                        Thread.currentThread().setName("Retrofit-Idle");
                                    }
                                    return responseExecute;
                                }
                                responseWrapper = new ResponseWrapper(responseExecute, responseExecute);
                                if (!restMethodInfo.isSynchronous) {
                                }
                                return responseWrapper;
                            }
                            TypedInput body = responseExecute.getBody();
                            if (body == null) {
                                boolean z2 = restMethodInfo.isSynchronous;
                                if (z2) {
                                    if (!z2) {
                                        Thread.currentThread().setName("Retrofit-Idle");
                                    }
                                    return null;
                                }
                                responseWrapper = new ResponseWrapper(responseExecute, null);
                                if (restMethodInfo.isSynchronous) {
                                    return responseWrapper;
                                }
                            } else {
                                ExceptionCatchingTypedInput exceptionCatchingTypedInput = new ExceptionCatchingTypedInput(body);
                                try {
                                    Object objFromBody = RestAdapter.this.converter.fromBody(exceptionCatchingTypedInput, type);
                                    RestAdapter.this.logResponseBody(body, objFromBody);
                                    boolean z3 = restMethodInfo.isSynchronous;
                                    if (z3) {
                                        if (!z3) {
                                            Thread.currentThread().setName("Retrofit-Idle");
                                        }
                                        return objFromBody;
                                    }
                                    responseWrapper = new ResponseWrapper(responseExecute, objFromBody);
                                    if (restMethodInfo.isSynchronous) {
                                        return responseWrapper;
                                    }
                                } catch (ConversionException e) {
                                    if (exceptionCatchingTypedInput.threwException()) {
                                        throw exceptionCatchingTypedInput.getThrownException();
                                    }
                                    throw RetrofitError.conversionError(url2, Utils.replaceResponseBody(responseExecute, null), RestAdapter.this.converter, type, e);
                                }
                            }
                            Thread.currentThread().setName("Retrofit-Idle");
                            return responseWrapper;
                        } catch (IOException e2) {
                            e = e2;
                            str = url2;
                            if (RestAdapter.this.logLevel.log()) {
                                RestAdapter.this.logException(e, str);
                            }
                            throw RetrofitError.networkError(str, e);
                        } catch (Throwable th) {
                            th = th;
                            str = url2;
                            if (RestAdapter.this.logLevel.log()) {
                                RestAdapter.this.logException(th, str);
                            }
                            throw RetrofitError.unexpectedError(str, th);
                        }
                    } catch (Throwable th2) {
                        if (!restMethodInfo.isSynchronous) {
                            Thread.currentThread().setName("Retrofit-Idle");
                        }
                        throw th2;
                    }
                } catch (RetrofitError e3) {
                    throw e3;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, final Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            final RestMethodInfo methodInfo = RestAdapter.getMethodInfo(this.methodDetailsCache, method);
            boolean z = methodInfo.isSynchronous;
            RestAdapter restAdapter = RestAdapter.this;
            if (z) {
                try {
                    return invokeRequest(restAdapter.requestInterceptor, methodInfo, objArr);
                } catch (RetrofitError e) {
                    Throwable thHandleError = RestAdapter.this.errorHandler.handleError(e);
                    if (thHandleError != null) {
                        throw thHandleError;
                    }
                    Types$$ExternalSyntheticBUOutline0.m("Error handler returned null for wrapped exception.", e);
                    return null;
                }
            }
            if (restAdapter.httpExecutor == null || restAdapter.callbackExecutor == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Asynchronous invocation requires calling setExecutors.");
                return null;
            }
            if (!methodInfo.isObservable) {
                final RequestInterceptorTape requestInterceptorTape = new RequestInterceptorTape();
                RestAdapter.this.requestInterceptor.intercept(requestInterceptorTape);
                Callback callback = (Callback) objArr[objArr.length - 1];
                RestAdapter restAdapter2 = RestAdapter.this;
                restAdapter2.httpExecutor.execute(new CallbackRunnable(callback, restAdapter2.callbackExecutor, restAdapter2.errorHandler) { // from class: retrofit.RestAdapter.RestHandler.2
                    @Override // retrofit.CallbackRunnable
                    public ResponseWrapper obtainResponse() {
                        return (ResponseWrapper) RestHandler.this.invokeRequest(requestInterceptorTape, methodInfo, objArr);
                    }
                });
                return null;
            }
            if (restAdapter.rxSupport == null) {
                if (!Platform.HAS_RX_JAVA) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Observable method found but no RxJava on classpath.");
                    return null;
                }
                RestAdapter restAdapter3 = RestAdapter.this;
                restAdapter3.rxSupport = new RxSupport(restAdapter3.httpExecutor, restAdapter3.errorHandler, restAdapter3.requestInterceptor);
            }
            return RestAdapter.this.rxSupport.createRequestObservable(new RxSupport.Invoker() { // from class: retrofit.RestAdapter.RestHandler.1
            });
        }
    }

    private RestAdapter(Endpoint endpoint, Client.Provider provider, Executor executor, Executor executor2, RequestInterceptor requestInterceptor, Converter converter, Profiler profiler, ErrorHandler errorHandler, Log log, LogLevel logLevel) {
        this.serviceMethodInfoCache = new LinkedHashMap();
        this.server = endpoint;
        this.clientProvider = provider;
        this.httpExecutor = executor;
        this.callbackExecutor = executor2;
        this.requestInterceptor = requestInterceptor;
        this.converter = converter;
        this.errorHandler = errorHandler;
        this.log = log;
        this.logLevel = logLevel;
    }

    public static /* synthetic */ Profiler access$200(RestAdapter restAdapter) {
        restAdapter.getClass();
        return null;
    }

    public static RestMethodInfo getMethodInfo(Map<Method, RestMethodInfo> map, Method method) {
        RestMethodInfo restMethodInfo;
        synchronized (map) {
            try {
                restMethodInfo = map.get(method);
                if (restMethodInfo == null) {
                    restMethodInfo = new RestMethodInfo(method);
                    map.put(method, restMethodInfo);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return restMethodInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response logAndReplaceResponse(String str, Response response, long j) {
        long length;
        this.log.log("<--- HTTP " + response.getStatus() + " " + str + " (" + j + "ms)");
        if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal()) {
            Iterator<Header> it = response.getHeaders().iterator();
            while (it.hasNext()) {
                this.log.log(it.next().toString());
            }
            TypedInput body = response.getBody();
            if (body != null) {
                length = body.length();
                if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal()) {
                    if (!response.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    if (!(body instanceof TypedByteArray)) {
                        response = Utils.readBodyToBytesIfNecessary(response);
                        body = response.getBody();
                    }
                    byte[] bytes = ((TypedByteArray) body).getBytes();
                    long length2 = bytes.length;
                    this.log.log(new String(bytes, MimeUtil.parseCharset(body.mimeType(), OAuth.ENCODING)));
                    length = length2;
                }
            } else {
                length = 0;
            }
            this.log.log("<--- END HTTP (" + length + "-byte body)");
        }
        return response;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logResponseBody(TypedInput typedInput, Object obj) {
        if (this.logLevel.ordinal() == LogLevel.HEADERS_AND_ARGS.ordinal()) {
            this.log.log("<--- BODY:");
            this.log.log(obj.toString());
        }
    }

    public <T> T create(Class<T> cls) {
        Utils.validateServiceClass(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RestHandler(getMethodInfoCache(cls)));
    }

    public Map<Method, RestMethodInfo> getMethodInfoCache(Class<?> cls) {
        Map<Method, RestMethodInfo> linkedHashMap;
        synchronized (this.serviceMethodInfoCache) {
            try {
                linkedHashMap = this.serviceMethodInfoCache.get(cls);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                    this.serviceMethodInfoCache.put(cls, linkedHashMap);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedHashMap;
    }

    public Request logAndReplaceRequest(String str, Request request, Object[] objArr) {
        String str2;
        Log log = this.log;
        String method = request.getMethod();
        String url = request.getUrl();
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("---> ", str, " ", method, " ");
        sbM6m.append(url);
        log.log(sbM6m.toString());
        if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal()) {
            Iterator<Header> it = request.getHeaders().iterator();
            while (it.hasNext()) {
                this.log.log(it.next().toString());
            }
            TypedOutput body = request.getBody();
            if (body != null) {
                String strMimeType = body.mimeType();
                if (strMimeType != null) {
                    this.log.log("Content-Type: ".concat(strMimeType));
                }
                long length = body.length();
                str2 = length + "-byte";
                if (length != -1) {
                    this.log.log("Content-Length: " + length);
                }
                if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal()) {
                    if (!request.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    if (!(body instanceof TypedByteArray)) {
                        request = Utils.readBodyToBytesIfNecessary(request);
                        body = request.getBody();
                    }
                    this.log.log(new String(((TypedByteArray) body).getBytes(), MimeUtil.parseCharset(body.mimeType(), OAuth.ENCODING)));
                } else if (this.logLevel.ordinal() >= LogLevel.HEADERS_AND_ARGS.ordinal()) {
                    if (!request.getHeaders().isEmpty()) {
                        this.log.log("---> REQUEST:");
                    }
                    for (int i = 0; i < objArr.length; i++) {
                        Log log2 = this.log;
                        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "#", ": ");
                        sbM65m.append(objArr[i]);
                        log2.log(sbM65m.toString());
                    }
                }
            } else {
                str2 = "no";
            }
            this.log.log(FileInsert$$ExternalSyntheticOutline0.m("---> END ", str, " (", str2, " body)"));
        }
        return request;
    }

    public void logException(Throwable th, String str) {
        Log log = this.log;
        if (str == null) {
            str = "";
        }
        log.log("---- ERROR ".concat(str));
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        this.log.log(stringWriter.toString());
        this.log.log("---- END ERROR");
    }
}
