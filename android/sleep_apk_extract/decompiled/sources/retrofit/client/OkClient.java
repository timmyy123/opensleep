package retrofit.client;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/* JADX INFO: loaded from: classes5.dex */
public class OkClient implements Client {
    private final OkHttpClient client;

    public OkClient(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            this.client = okHttpClient;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("client == null");
            throw null;
        }
    }

    private static List<Header> createHeaders(Headers headers) {
        int size = headers.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new Header(headers.name(i), headers.value(i)));
        }
        return arrayList;
    }

    public static com.squareup.okhttp.Request createRequest(Request request) {
        Request.Builder builderMethod = new Request.Builder().url(request.getUrl()).method(request.getMethod(), createRequestBody(request.getBody()));
        List<Header> headers = request.getHeaders();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            Header header = headers.get(i);
            String value = header.getValue();
            if (value == null) {
                value = "";
            }
            builderMethod.addHeader(header.getName(), value);
        }
        return builderMethod.build();
    }

    private static RequestBody createRequestBody(final TypedOutput typedOutput) {
        if (typedOutput == null) {
            return null;
        }
        final MediaType mediaType = MediaType.parse(typedOutput.mimeType());
        return new RequestBody() { // from class: retrofit.client.OkClient.1
        };
    }

    private static TypedInput createResponseBody(final ResponseBody responseBody) {
        if (responseBody.contentLength() == 0) {
            return null;
        }
        return new TypedInput() { // from class: retrofit.client.OkClient.2
            @Override // retrofit.mime.TypedInput
            public InputStream in() {
                return responseBody.byteStream();
            }

            @Override // retrofit.mime.TypedInput
            public long length() {
                return responseBody.contentLength();
            }

            @Override // retrofit.mime.TypedInput
            public String mimeType() {
                MediaType mediaTypeContentType = responseBody.contentType();
                if (mediaTypeContentType == null) {
                    return null;
                }
                return mediaTypeContentType.toString();
            }
        };
    }

    private static OkHttpClient generateDefaultOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClient.setConnectTimeout(15000L, timeUnit);
        okHttpClient.setReadTimeout(20000L, timeUnit);
        return okHttpClient;
    }

    public static Response parseResponse(com.squareup.okhttp.Response response) {
        return new Response(response.request().urlString(), response.code(), response.message(), createHeaders(response.headers()), createResponseBody(response.body()));
    }

    @Override // retrofit.client.Client
    public Response execute(Request request) {
        return parseResponse(this.client.newCall(createRequest(request)).execute());
    }

    public OkClient() {
        this(generateDefaultOkHttp());
    }
}
