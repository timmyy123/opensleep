package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class GoogleJsonResponseException extends HttpResponseException {
    private static final long serialVersionUID = 409811126989994864L;
    private final transient GoogleJsonError details;

    public GoogleJsonResponseException(HttpResponseException.Builder builder, GoogleJsonError googleJsonError) {
        super(builder);
        this.details = googleJsonError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ab A[Catch: IOException -> 0x0096, TryCatch #5 {IOException -> 0x0096, blocks: (B:51:0x00a7, B:53:0x00ae, B:52:0x00ab, B:42:0x0092, B:46:0x009c), top: B:66:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2 A[Catch: IOException -> 0x00af, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x00af, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0027, B:56:0x00b2), top: B:69:0x0015 }] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.api.client.googleapis.json.GoogleJsonError] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GoogleJsonResponseException from(JsonFactory jsonFactory, HttpResponse httpResponse) throws Throwable {
        String asString;
        JsonParser jsonParserCreateJsonParser;
        GoogleJsonError googleJsonError;
        HttpResponseException.Builder builder = new HttpResponseException.Builder(httpResponse.getStatusCode(), httpResponse.getStatusMessage(), httpResponse.getHeaders());
        Preconditions.checkNotNull(jsonFactory);
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
            if (!httpResponse.isSuccessStatusCode()) {
                String contentType = httpResponse.getContentType();
                if (HttpMediaType.equalsIgnoreParameters("application/json; charset=UTF-8", contentType)) {
                    try {
                        if (httpResponse.getContent() != null) {
                            try {
                                jsonParserCreateJsonParser = jsonFactory.createJsonParser(httpResponse.getContent());
                                try {
                                    JsonToken currentToken = jsonParserCreateJsonParser.getCurrentToken();
                                    if (currentToken == null) {
                                        currentToken = jsonParserCreateJsonParser.nextToken();
                                    }
                                    if (currentToken != null) {
                                        jsonParserCreateJsonParser.skipToKey("error");
                                        if (jsonParserCreateJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                                            asString = jsonParserCreateJsonParser.getText();
                                        } else if (jsonParserCreateJsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                                            GoogleJsonError googleJsonError2 = (GoogleJsonError) jsonParserCreateJsonParser.parseAndClose(GoogleJsonError.class);
                                            try {
                                                asString = googleJsonError2.toPrettyString();
                                                r1 = googleJsonError2;
                                            } catch (IOException e) {
                                                googleJsonError = googleJsonError2;
                                                e = e;
                                                try {
                                                    e.printStackTrace();
                                                    if (jsonParserCreateJsonParser == null) {
                                                        httpResponse.ignore();
                                                    } else if (googleJsonError == null) {
                                                        jsonParserCreateJsonParser.close();
                                                    }
                                                    asString = null;
                                                    r1 = googleJsonError;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (jsonParserCreateJsonParser != null) {
                                                        httpResponse.ignore();
                                                    } else if (googleJsonError == null) {
                                                        jsonParserCreateJsonParser.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                googleJsonError = googleJsonError2;
                                                th = th2;
                                                if (jsonParserCreateJsonParser != null) {
                                                }
                                                throw th;
                                            }
                                        } else {
                                            asString = null;
                                        }
                                        if (r1 == 0) {
                                            try {
                                                jsonParserCreateJsonParser.close();
                                            } catch (IOException e2) {
                                                e = e2;
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    googleJsonError = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    googleJsonError = null;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                jsonParserCreateJsonParser = null;
                                googleJsonError = null;
                            } catch (Throwable th4) {
                                th = th4;
                                jsonParserCreateJsonParser = null;
                                googleJsonError = null;
                            }
                        } else {
                            asString = httpResponse.parseAsString();
                        }
                    } catch (IOException e5) {
                        e = e5;
                        asString = null;
                        r1 = contentType;
                    }
                }
            }
        } catch (IOException e6) {
            e = e6;
            asString = null;
        }
        StringBuilder sbComputeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
        if (!Strings.isNullOrEmpty(asString)) {
            sbComputeMessageBuffer.append(StringUtils.LINE_SEPARATOR);
            sbComputeMessageBuffer.append(asString);
            builder.setContent(asString);
        }
        builder.setMessage(sbComputeMessageBuffer.toString());
        return new GoogleJsonResponseException(builder, r1);
    }
}
