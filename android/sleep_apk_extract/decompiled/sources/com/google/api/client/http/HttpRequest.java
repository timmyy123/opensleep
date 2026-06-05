package com.google.api.client.http;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.LoggingStreamingContent;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.api.client.util.StreamingContent;
import com.google.api.client.util.StringUtils;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpRequest {
    public static final String USER_AGENT_SUFFIX;
    public static final String VERSION;
    private HttpContent content;
    private HttpEncoding encoding;
    private HttpExecuteInterceptor executeInterceptor;
    private ObjectParser objectParser;
    private String requestMethod;
    private HttpResponseInterceptor responseInterceptor;
    private boolean suppressUserAgentSuffix;
    private final HttpTransport transport;
    private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
    private GenericUrl url;
    private HttpHeaders headers = new HttpHeaders();
    private HttpHeaders responseHeaders = new HttpHeaders();
    private int numRetries = 10;
    private int contentLoggingLimit = 16384;
    private boolean loggingEnabled = true;
    private boolean curlLoggingEnabled = true;
    private int connectTimeout = 20000;
    private int readTimeout = 20000;
    private int writeTimeout = 0;
    private boolean followRedirects = true;
    private boolean useRawRedirectUrls = false;
    private boolean throwExceptionOnExecuteError = true;

    @Deprecated
    private boolean retryOnExecuteIOException = false;
    private Sleeper sleeper = Sleeper.DEFAULT;
    private final Tracer tracer = OpenCensusUtils.getTracer();
    private boolean responseReturnRawInputStream = false;

    static {
        String version = getVersion();
        VERSION = version;
        USER_AGENT_SUFFIX = FileInsert$$ExternalSyntheticOutline0.m("Google-HTTP-Java-Client/", version, " (gzip)");
    }

    public HttpRequest(HttpTransport httpTransport, String str) {
        this.transport = httpTransport;
        setRequestMethod(str);
    }

    private static void addSpanAttribute(Span span, String str, String str2) {
        if (str2 != null) {
            span.putAttribute(str, AttributeValue.stringAttributeValue(str2));
        }
    }

    private static String getVersion() {
        String property = "unknown-version";
        try {
            InputStream resourceAsStream = HttpRequest.class.getResourceAsStream("/com/google/api/client/http/google-http-client.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    property = properties.getProperty("google-http-client.version");
                } finally {
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        return property;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:7|(1:9)|10|(1:12)|13|(1:18)(1:17)|(22:20|(2:22|(1:24))|27|(2:29|(1:31)(1:32))|33|(1:35)|36|(1:42)(1:41)|43|(8:45|(1:47)(1:48)|49|(1:51)(1:52)|53|(5:55|(2:57|(1:59))(1:60)|(2:62|(1:64))|65|(1:67))(1:68)|(1:70)|71)(1:72)|(2:74|(3:76|(1:78)|79))|(1:83)(1:82)|84|157|85|(1:87)|160|93|94|(3:155|106|(5:108|(1:110)(1:113)|(1:117)|118|(1:120))(2:(1:125)(1:126)|127))(0)|128|(4:165|(1:131)(1:132)|133|(4:135|(1:137)|138|(1:148)(3:158|143|144))(1:149))(1:150))(1:26)|25|27|(0)|33|(0)|36|(2:38|42)(0)|43|(0)(0)|(0)|(1:83)(0)|84|157|85|(0)|160|93|94|(0)(0)|128|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0276, code lost:
    
        if (r24.retryOnExecuteIOException != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0278, code lost:
    
        if (r18 != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x027a, code lost:
    
        r8.log(java.util.logging.Level.WARNING, "exception thrown while executing request", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0281, code lost:
    
        r3.close();
        r3 = r16;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0303, code lost:
    
        r4.end(com.google.api.client.http.OpenCensusUtils.getEndSpanOptions(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x025b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0300 A[LOOP:0: B:7:0x002e->B:150:0x0300, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0242 A[Catch: all -> 0x0258, IOException -> 0x025b, TRY_LEAVE, TryCatch #4 {IOException -> 0x025b, blocks: (B:85:0x023c, B:87:0x0242, B:96:0x026a, B:98:0x0270, B:99:0x0273), top: B:157:0x023c, outer: #1 }] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.google.api.client.http.HttpResponseInterceptor] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.api.client.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.api.client.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.api.client.http.HttpUnsuccessfulResponseHandler] */
    /* JADX WARN: Type inference failed for: r7v9, types: [com.google.api.client.http.LowLevelHttpRequest] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpResponse execute() {
        StringBuilder sbM;
        StringBuilder sb;
        HttpContent httpContent;
        int i;
        boolean z;
        boolean z2;
        Integer num;
        StreamingContent streamingContent;
        Scope scopeWithSpan;
        ?? r3;
        boolean z3;
        LowLevelHttpResponse lowLevelHttpResponseExecute;
        StreamingContent loggingStreamingContent;
        StreamingContent httpEncodingStreamingContent;
        int i2;
        long length;
        ?? r2;
        Preconditions.checkArgument(this.numRetries >= 0);
        int i3 = this.numRetries;
        Preconditions.checkNotNull(this.requestMethod);
        Preconditions.checkNotNull(this.url);
        Span spanStartSpan = this.tracer.spanBuilder(OpenCensusUtils.SPAN_NAME_HTTP_REQUEST_EXECUTE).setRecordEvents(OpenCensusUtils.isRecordEvent()).startSpan();
        int i4 = i3;
        ?? r0 = 0;
        while (true) {
            spanStartSpan.addAnnotation("retry #" + (this.numRetries - i4));
            if (r0 != 0) {
                r0.ignore();
            }
            HttpExecuteInterceptor httpExecuteInterceptor = this.executeInterceptor;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(this);
            }
            String strBuild = this.url.build();
            addSpanAttribute(spanStartSpan, "http.method", this.requestMethod);
            addSpanAttribute(spanStartSpan, "http.host", this.url.getHost());
            addSpanAttribute(spanStartSpan, "http.path", this.url.getRawPath());
            addSpanAttribute(spanStartSpan, "http.url", strBuild);
            ?? BuildRequest = this.transport.buildRequest(this.requestMethod, strBuild);
            Logger logger = HttpTransport.LOGGER;
            boolean z4 = this.loggingEnabled && logger.isLoggable(Level.CONFIG);
            try {
                try {
                    if (z4) {
                        sbM = FileInsert$$ExternalSyntheticOutline0.m("-------------- REQUEST  --------------");
                        String str = StringUtils.LINE_SEPARATOR;
                        sbM.append(str);
                        sbM.append(this.requestMethod);
                        sbM.append(' ');
                        sbM.append(strBuild);
                        sbM.append(str);
                        if (this.curlLoggingEnabled) {
                            sb = new StringBuilder("curl -v --compressed");
                            if (!this.requestMethod.equals("GET")) {
                                sb.append(" -X ");
                                sb.append(this.requestMethod);
                            }
                        }
                        String userAgent = this.headers.getUserAgent();
                        if (!this.suppressUserAgentSuffix) {
                            if (userAgent == null) {
                                HttpHeaders httpHeaders = this.headers;
                                String str2 = USER_AGENT_SUFFIX;
                                httpHeaders.setUserAgent(str2);
                                addSpanAttribute(spanStartSpan, "http.user_agent", str2);
                            } else {
                                StringBuilder sbM2 = Fragment$$ExternalSyntheticOutline1.m(userAgent, " ");
                                sbM2.append(USER_AGENT_SUFFIX);
                                String string = sbM2.toString();
                                this.headers.setUserAgent(string);
                                addSpanAttribute(spanStartSpan, "http.user_agent", string);
                            }
                        }
                        OpenCensusUtils.propagateTracingContext(spanStartSpan, this.headers);
                        HttpHeaders.serializeHeaders(this.headers, sbM, sb, logger, BuildRequest);
                        if (!this.suppressUserAgentSuffix) {
                            this.headers.setUserAgent(userAgent);
                        }
                        httpContent = this.content;
                        boolean z5 = httpContent != null || httpContent.retrySupported();
                        if (httpContent == null) {
                            String type = this.content.getType();
                            if (z4) {
                                num = null;
                                loggingStreamingContent = new LoggingStreamingContent(httpContent, logger, Level.CONFIG, this.contentLoggingLimit);
                            } else {
                                num = null;
                                loggingStreamingContent = httpContent;
                            }
                            HttpEncoding httpEncoding = this.encoding;
                            if (httpEncoding == null) {
                                i2 = i4;
                                length = this.content.getLength();
                                r2 = num;
                                httpEncodingStreamingContent = loggingStreamingContent;
                            } else {
                                String name = httpEncoding.getName();
                                httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, this.encoding);
                                i2 = i4;
                                length = -1;
                                r2 = name;
                            }
                            i = i2;
                            if (z4) {
                                z = z4;
                                if (type != null) {
                                    String strConcat = "Content-Type: ".concat(type);
                                    sbM.append(strConcat);
                                    z2 = z5;
                                    sbM.append(StringUtils.LINE_SEPARATOR);
                                    if (sb != null) {
                                        sb.append(" -H '" + strConcat + "'");
                                    }
                                } else {
                                    z2 = z5;
                                }
                                if (r2 != 0) {
                                    String strConcat2 = "Content-Encoding: ".concat(r2);
                                    sbM.append(strConcat2);
                                    sbM.append(StringUtils.LINE_SEPARATOR);
                                    if (sb != null) {
                                        sb.append(" -H '" + strConcat2 + "'");
                                    }
                                }
                                if (length >= 0) {
                                    sbM.append("Content-Length: " + length);
                                    sbM.append(StringUtils.LINE_SEPARATOR);
                                }
                            } else {
                                z = z4;
                                z2 = z5;
                            }
                            if (sb != null) {
                                sb.append(" -d '@-'");
                            }
                            BuildRequest.setContentType(type);
                            BuildRequest.setContentEncoding(r2);
                            BuildRequest.setContentLength(length);
                            BuildRequest.setStreamingContent(httpEncodingStreamingContent);
                            streamingContent = httpEncodingStreamingContent;
                        } else {
                            i = i4;
                            z = z4;
                            z2 = z5;
                            num = null;
                            streamingContent = httpContent;
                        }
                        if (z) {
                            logger.config(sbM.toString());
                            if (sb != null) {
                                sb.append(" -- '");
                                sb.append(strBuild.replaceAll("'", "'\"'\"'"));
                                sb.append("'");
                                if (streamingContent != null) {
                                    sb.append(" << $$$");
                                }
                                logger.config(sb.toString());
                            }
                        }
                        boolean z6 = !z2 && i > 0;
                        BuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
                        BuildRequest.setWriteTimeout(this.writeTimeout);
                        scopeWithSpan = this.tracer.withSpan(spanStartSpan);
                        OpenCensusUtils.recordSentMessageEvent(spanStartSpan, BuildRequest.getContentLength());
                        lowLevelHttpResponseExecute = BuildRequest.execute();
                        if (lowLevelHttpResponseExecute != null) {
                            OpenCensusUtils.recordReceivedMessageEvent(spanStartSpan, lowLevelHttpResponseExecute.getContentLength());
                            spanStartSpan.putAttribute("http.status_code", AttributeValue.longAttributeValue(lowLevelHttpResponseExecute.getStatusCode()));
                        }
                        HttpResponse httpResponse = new HttpResponse(this, lowLevelHttpResponseExecute);
                        scopeWithSpan.close();
                        r3 = httpResponse;
                        ?? r02 = num;
                        if (r3 == 0) {
                            try {
                                if (r3.isSuccessStatusCode()) {
                                    z3 = z6 & (r3 == 0);
                                } else {
                                    ?? r5 = this.unsuccessfulResponseHandler;
                                    boolean zHandleResponse = r5 != 0 ? r5.handleResponse(this, r3, z6) : false;
                                    if (!zHandleResponse && handleRedirect(r3.getStatusCode(), r3.getHeaders())) {
                                        zHandleResponse = true;
                                    }
                                    z3 = z6 & zHandleResponse;
                                    if (z3) {
                                        r3.ignore();
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        i4 = i - 1;
                        if (z3) {
                            spanStartSpan.end(OpenCensusUtils.getEndSpanOptions(r3 == 0 ? num : Integer.valueOf(r3.getStatusCode())));
                            if (r3 == 0) {
                                throw r02;
                            }
                            ?? r03 = this.responseInterceptor;
                            if (r03 != 0) {
                                r03.interceptResponse(r3);
                            }
                            if (!this.throwExceptionOnExecuteError || r3.isSuccessStatusCode()) {
                                return r3;
                            }
                            try {
                                throw new HttpResponseException.Builder(r3).setAttemptCount(this.numRetries - i4).build();
                            } finally {
                                r3.disconnect();
                            }
                        }
                        r0 = r3;
                    } else {
                        sbM = null;
                    }
                    HttpResponse httpResponse2 = new HttpResponse(this, lowLevelHttpResponseExecute);
                    scopeWithSpan.close();
                    r3 = httpResponse2;
                    ?? r022 = num;
                    if (r3 == 0) {
                    }
                    i4 = i - 1;
                    if (z3) {
                    }
                } catch (Throwable th2) {
                    InputStream content = lowLevelHttpResponseExecute.getContent();
                    if (content != null) {
                        content.close();
                    }
                    throw th2;
                }
                lowLevelHttpResponseExecute = BuildRequest.execute();
                if (lowLevelHttpResponseExecute != null) {
                }
            } catch (Throwable th3) {
                scopeWithSpan.close();
                throw th3;
            }
            sb = null;
            String userAgent2 = this.headers.getUserAgent();
            if (!this.suppressUserAgentSuffix) {
            }
            OpenCensusUtils.propagateTracingContext(spanStartSpan, this.headers);
            HttpHeaders.serializeHeaders(this.headers, sbM, sb, logger, BuildRequest);
            if (!this.suppressUserAgentSuffix) {
            }
            httpContent = this.content;
            if (httpContent != null) {
            }
            if (httpContent == null) {
            }
            if (z) {
            }
            if (z2) {
            }
            BuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
            BuildRequest.setWriteTimeout(this.writeTimeout);
            scopeWithSpan = this.tracer.withSpan(spanStartSpan);
            OpenCensusUtils.recordSentMessageEvent(spanStartSpan, BuildRequest.getContentLength());
        }
    }

    public HttpContent getContent() {
        return this.content;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public final ObjectParser getParser() {
        return this.objectParser;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.responseInterceptor;
    }

    public boolean getResponseReturnRawInputStream() {
        return this.responseReturnRawInputStream;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.throwExceptionOnExecuteError;
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public GenericUrl getUrl() {
        return this.url;
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.url.toURL(location), this.useRawRedirectUrls));
        if (i == 303) {
            setRequestMethod("GET");
            setContent(null);
        }
        this.headers.setAuthorization((String) null);
        this.headers.setIfMatch(null);
        this.headers.setIfNoneMatch(null);
        this.headers.setIfModifiedSince(null);
        this.headers.setIfUnmodifiedSince(null);
        this.headers.setIfRange(null);
        return true;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.encoding = httpEncoding;
        return this;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.executeInterceptor = httpExecuteInterceptor;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.objectParser = objectParser;
        return this;
    }

    public HttpRequest setRequestMethod(String str) {
        Preconditions.checkArgument(str == null || HttpMediaType.matchesToken(str));
        this.requestMethod = str;
        return this;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptor = httpResponseInterceptor;
        return this;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.unsuccessfulResponseHandler = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.url = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }
}
