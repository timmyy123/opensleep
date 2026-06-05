package retrofit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/* JADX INFO: loaded from: classes5.dex */
abstract class Utils {

    public static class SynchronousExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Request readBodyToBytesIfNecessary(Request request) {
        TypedOutput body = request.getBody();
        if (body == null || (body instanceof TypedByteArray)) {
            return request;
        }
        String strMimeType = body.mimeType();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        body.writeTo(byteArrayOutputStream);
        return new Request(request.getMethod(), request.getUrl(), request.getHeaders(), new TypedByteArray(strMimeType, byteArrayOutputStream.toByteArray()));
    }

    public static Response replaceResponseBody(Response response, TypedInput typedInput) {
        return new Response(response.getUrl(), response.getStatus(), response.getReason(), response.getHeaders(), typedInput);
    }

    public static byte[] streamToBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (inputStream != null) {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static <T> void validateServiceClass(Class<T> cls) {
        if (!cls.isInterface()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Only interface endpoint definitions are supported.");
        } else {
            if (cls.getInterfaces().length <= 0) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Interface definitions must not extend other interfaces.");
        }
    }

    public static Response readBodyToBytesIfNecessary(Response response) {
        TypedInput body = response.getBody();
        if (body == null || (body instanceof TypedByteArray)) {
            return response;
        }
        String strMimeType = body.mimeType();
        InputStream inputStreamIn = body.in();
        try {
            Response responseReplaceResponseBody = replaceResponseBody(response, new TypedByteArray(strMimeType, streamToBytes(inputStreamIn)));
            if (inputStreamIn != null) {
                try {
                    inputStreamIn.close();
                } catch (IOException unused) {
                }
            }
            return responseReplaceResponseBody;
        } catch (Throwable th) {
            if (inputStreamIn != null) {
                try {
                    inputStreamIn.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
