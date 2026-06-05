package retrofit;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit.RequestInterceptor;
import retrofit.RestMethodInfo;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.converter.Converter;
import retrofit.http.Body;
import retrofit.http.EncodedPath;
import retrofit.http.EncodedQuery;
import retrofit.http.EncodedQueryMap;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit.mime.FormUrlEncodedTypedOutput;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedOutput;
import retrofit.mime.TypedString;

/* JADX INFO: loaded from: classes5.dex */
final class RequestBuilder implements RequestInterceptor.RequestFacade {
    private final String apiUrl;
    private TypedOutput body;
    private String contentTypeHeader;
    private final Converter converter;
    private final FormUrlEncodedTypedOutput formBody;
    private List<Header> headers;
    private final boolean isObservable;
    private final boolean isSynchronous;
    private final MultipartTypedOutput multipartBody;
    private final Annotation[] paramAnnotations;
    private StringBuilder queryParams;
    private String relativeUrl;
    private final String requestMethod;

    /* JADX INFO: renamed from: retrofit.RequestBuilder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$retrofit$RestMethodInfo$RequestType;

        static {
            int[] iArr = new int[RestMethodInfo.RequestType.values().length];
            $SwitchMap$retrofit$RestMethodInfo$RequestType = iArr;
            try {
                iArr[RestMethodInfo.RequestType.FORM_URL_ENCODED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$retrofit$RestMethodInfo$RequestType[RestMethodInfo.RequestType.MULTIPART.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$retrofit$RestMethodInfo$RequestType[RestMethodInfo.RequestType.SIMPLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class MimeOverridingTypedOutput implements TypedOutput {
        private final TypedOutput delegate;
        private final String mimeType;

        public MimeOverridingTypedOutput(TypedOutput typedOutput, String str) {
            this.delegate = typedOutput;
            this.mimeType = str;
        }

        @Override // retrofit.mime.TypedOutput
        public String fileName() {
            return this.delegate.fileName();
        }

        @Override // retrofit.mime.TypedOutput
        public long length() {
            return this.delegate.length();
        }

        @Override // retrofit.mime.TypedOutput
        public String mimeType() {
            return this.mimeType;
        }

        @Override // retrofit.mime.TypedOutput
        public void writeTo(OutputStream outputStream) {
            this.delegate.writeTo(outputStream);
        }
    }

    public RequestBuilder(String str, RestMethodInfo restMethodInfo, Converter converter) {
        this.apiUrl = str;
        this.converter = converter;
        this.paramAnnotations = restMethodInfo.requestParamAnnotations;
        this.requestMethod = restMethodInfo.requestMethod;
        this.isSynchronous = restMethodInfo.isSynchronous;
        this.isObservable = restMethodInfo.isObservable;
        if (restMethodInfo.headers != null) {
            this.headers = new ArrayList(restMethodInfo.headers);
        }
        this.contentTypeHeader = restMethodInfo.contentTypeHeader;
        this.relativeUrl = restMethodInfo.requestUrl;
        String str2 = restMethodInfo.requestQuery;
        if (str2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append('?');
            sb.append(str2);
            this.queryParams = sb;
        }
        int i = AnonymousClass1.$SwitchMap$retrofit$RestMethodInfo$RequestType[restMethodInfo.requestType.ordinal()];
        if (i == 1) {
            FormUrlEncodedTypedOutput formUrlEncodedTypedOutput = new FormUrlEncodedTypedOutput();
            this.formBody = formUrlEncodedTypedOutput;
            this.multipartBody = null;
            this.body = formUrlEncodedTypedOutput;
            return;
        }
        if (i == 2) {
            this.formBody = null;
            MultipartTypedOutput multipartTypedOutput = new MultipartTypedOutput();
            this.multipartBody = multipartTypedOutput;
            this.body = multipartTypedOutput;
            return;
        }
        if (i != 3) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown request type: ", restMethodInfo.requestType);
            throw null;
        }
        this.formBody = null;
        this.multipartBody = null;
    }

    private void addPathParam(String str, String str2, boolean z) {
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Path replacement name must not be null.");
            return;
        }
        if (str2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Path replacement \"", str, "\" value must not be null."));
            return;
        }
        try {
            if (!z) {
                this.relativeUrl = this.relativeUrl.replace("{" + str + "}", str2);
                return;
            }
            String strReplace = URLEncoder.encode(str2, OAuth.ENCODING).replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "%20");
            this.relativeUrl = this.relativeUrl.replace("{" + str + "}", strReplace);
        } catch (UnsupportedEncodingException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(Fragment$$ExternalSyntheticOutline1.m("Unable to convert path parameter \"", str, "\" value to UTF-8:", str2), (Throwable) e);
        }
    }

    private void addQueryParam(String str, String str2, boolean z, boolean z2) {
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Query param name must not be null.");
            return;
        }
        if (str2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Query param \"", str, "\" value must not be null."));
            return;
        }
        try {
            StringBuilder sb = this.queryParams;
            if (sb == null) {
                sb = new StringBuilder();
                this.queryParams = sb;
            }
            sb.append(sb.length() > 0 ? '&' : '?');
            if (z) {
                str = URLEncoder.encode(str, OAuth.ENCODING);
            }
            if (z2) {
                str2 = URLEncoder.encode(str2, OAuth.ENCODING);
            }
            sb.append(str);
            sb.append('=');
            sb.append(str2);
        } catch (UnsupportedEncodingException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(Fragment$$ExternalSyntheticOutline1.m("Unable to convert query parameter \"", str, "\" value to UTF-8: ", str2), (Throwable) e);
        }
    }

    private void addQueryParamMap(int i, Map<?, ?> map, boolean z, boolean z2) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                Types$$ExternalSyntheticBUOutline0.m(i + 1, " query map contained null key.", "Parameter #");
                return;
            } else {
                Object value = entry.getValue();
                if (value != null) {
                    addQueryParam(key.toString(), value.toString(), z, z2);
                }
            }
        }
    }

    @Override // retrofit.RequestInterceptor.RequestFacade
    public void addEncodedPathParam(String str, String str2) {
        addPathParam(str, str2, false);
    }

    @Override // retrofit.RequestInterceptor.RequestFacade
    public void addEncodedQueryParam(String str, String str2) {
        addQueryParam(str, str2, false, false);
    }

    @Override // retrofit.RequestInterceptor.RequestFacade
    public void addHeader(String str, String str2) {
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Header name must not be null.");
            return;
        }
        if ("Content-Type".equalsIgnoreCase(str)) {
            this.contentTypeHeader = str2;
            return;
        }
        List arrayList = this.headers;
        if (arrayList == null) {
            arrayList = new ArrayList(2);
            this.headers = arrayList;
        }
        arrayList.add(new Header(str, str2));
    }

    public Request build() {
        MultipartTypedOutput multipartTypedOutput = this.multipartBody;
        if (multipartTypedOutput != null && multipartTypedOutput.getPartCount() == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Multipart requests must contain at least one part.");
            return null;
        }
        String str = this.apiUrl;
        StringBuilder sb = new StringBuilder(str);
        if (str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(this.relativeUrl);
        StringBuilder sb2 = this.queryParams;
        if (sb2 != null) {
            sb.append((CharSequence) sb2);
        }
        TypedOutput mimeOverridingTypedOutput = this.body;
        List<Header> listSingletonList = this.headers;
        String str2 = this.contentTypeHeader;
        if (str2 != null) {
            if (mimeOverridingTypedOutput != null) {
                mimeOverridingTypedOutput = new MimeOverridingTypedOutput(mimeOverridingTypedOutput, str2);
            } else {
                Header header = new Header("Content-Type", str2);
                if (listSingletonList == null) {
                    listSingletonList = Collections.singletonList(header);
                } else {
                    listSingletonList.add(header);
                }
            }
        }
        return new Request(this.requestMethod, sb.toString(), listSingletonList, mimeOverridingTypedOutput);
    }

    public void setArguments(Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        if (!this.isSynchronous && !this.isObservable) {
            length--;
        }
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            Annotation annotation = this.paramAnnotations[i];
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            if (clsAnnotationType == Path.class) {
                Path path = (Path) annotation;
                String strValue = path.value();
                if (obj == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Path parameter \"", strValue, "\" value must not be null."));
                    return;
                }
                addPathParam(strValue, obj.toString(), path.encode());
            } else if (clsAnnotationType == EncodedPath.class) {
                String strValue2 = ((EncodedPath) annotation).value();
                if (obj == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Path parameter \"", strValue2, "\" value must not be null."));
                    return;
                }
                addPathParam(strValue2, obj.toString(), false);
            } else if (clsAnnotationType == Query.class) {
                if (obj != null) {
                    Query query = (Query) annotation;
                    addQueryParam(query.value(), obj, query.encodeName(), query.encodeValue());
                }
            } else if (clsAnnotationType == EncodedQuery.class) {
                if (obj != null) {
                    addQueryParam(((EncodedQuery) annotation).value(), obj, false, false);
                }
            } else if (clsAnnotationType == QueryMap.class) {
                if (obj != null) {
                    QueryMap queryMap = (QueryMap) annotation;
                    addQueryParamMap(i, (Map) obj, queryMap.encodeNames(), queryMap.encodeValues());
                }
            } else if (clsAnnotationType == EncodedQueryMap.class) {
                if (obj != null) {
                    addQueryParamMap(i, (Map) obj, false, false);
                }
            } else if (clsAnnotationType == retrofit.http.Header.class) {
                if (obj != null) {
                    String strValue3 = ((retrofit.http.Header) annotation).value();
                    if (obj instanceof Iterable) {
                        for (Object obj2 : (Iterable) obj) {
                            if (obj2 != null) {
                                addHeader(strValue3, obj2.toString());
                            }
                        }
                    } else if (obj.getClass().isArray()) {
                        int length2 = Array.getLength(obj);
                        for (int i2 = 0; i2 < length2; i2++) {
                            Object obj3 = Array.get(obj, i2);
                            if (obj3 != null) {
                                addHeader(strValue3, obj3.toString());
                            }
                        }
                    } else {
                        addHeader(strValue3, obj.toString());
                    }
                }
            } else if (clsAnnotationType == Field.class) {
                if (obj != null) {
                    Field field = (Field) annotation;
                    String strValue4 = field.value();
                    boolean zEncodeName = field.encodeName();
                    boolean zEncodeValue = field.encodeValue();
                    if (obj instanceof Iterable) {
                        for (Object obj4 : (Iterable) obj) {
                            if (obj4 != null) {
                                this.formBody.addField(strValue4, zEncodeName, obj4.toString(), zEncodeValue);
                            }
                        }
                    } else if (obj.getClass().isArray()) {
                        int length3 = Array.getLength(obj);
                        for (int i3 = 0; i3 < length3; i3++) {
                            Object obj5 = Array.get(obj, i3);
                            if (obj5 != null) {
                                this.formBody.addField(strValue4, zEncodeName, obj5.toString(), zEncodeValue);
                            }
                        }
                    } else {
                        this.formBody.addField(strValue4, zEncodeName, obj.toString(), zEncodeValue);
                    }
                }
            } else if (clsAnnotationType == FieldMap.class) {
                if (obj != null) {
                    FieldMap fieldMap = (FieldMap) annotation;
                    boolean zEncodeNames = fieldMap.encodeNames();
                    boolean zEncodeValues = fieldMap.encodeValues();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        Object key = entry.getKey();
                        if (key == null) {
                            Types$$ExternalSyntheticBUOutline0.m(i + 1, " field map contained null key.", "Parameter #");
                            return;
                        } else {
                            Object value = entry.getValue();
                            if (value != null) {
                                this.formBody.addField(key.toString(), zEncodeNames, value.toString(), zEncodeValues);
                            }
                        }
                    }
                } else {
                    continue;
                }
            } else if (clsAnnotationType == Part.class) {
                if (obj != null) {
                    Part part = (Part) annotation;
                    String strValue5 = part.value();
                    String strEncoding = part.encoding();
                    if (obj instanceof TypedOutput) {
                        this.multipartBody.addPart(strValue5, strEncoding, (TypedOutput) obj);
                    } else {
                        boolean z = obj instanceof String;
                        MultipartTypedOutput multipartTypedOutput = this.multipartBody;
                        if (z) {
                            multipartTypedOutput.addPart(strValue5, strEncoding, new TypedString((String) obj));
                        } else {
                            multipartTypedOutput.addPart(strValue5, strEncoding, this.converter.toBody(obj));
                        }
                    }
                }
            } else if (clsAnnotationType == PartMap.class) {
                if (obj != null) {
                    String strEncoding2 = ((PartMap) annotation).encoding();
                    for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                        Object key2 = entry2.getKey();
                        if (key2 == null) {
                            Types$$ExternalSyntheticBUOutline0.m(i + 1, " part map contained null key.", "Parameter #");
                            return;
                        }
                        String string = key2.toString();
                        Object value2 = entry2.getValue();
                        if (value2 != null) {
                            if (value2 instanceof TypedOutput) {
                                this.multipartBody.addPart(string, strEncoding2, (TypedOutput) value2);
                            } else {
                                boolean z2 = value2 instanceof String;
                                MultipartTypedOutput multipartTypedOutput2 = this.multipartBody;
                                if (z2) {
                                    multipartTypedOutput2.addPart(string, strEncoding2, new TypedString((String) value2));
                                } else {
                                    multipartTypedOutput2.addPart(string, strEncoding2, this.converter.toBody(value2));
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } else if (clsAnnotationType != Body.class) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown annotation: ", clsAnnotationType.getCanonicalName());
                return;
            } else if (obj == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Body parameter value must not be null.");
                return;
            } else if (obj instanceof TypedOutput) {
                this.body = (TypedOutput) obj;
            } else {
                this.body = this.converter.toBody(obj);
            }
        }
    }

    private void addQueryParam(String str, Object obj, boolean z, boolean z2) {
        if (obj instanceof Iterable) {
            for (Object obj2 : (Iterable) obj) {
                if (obj2 != null) {
                    addQueryParam(str, obj2.toString(), z, z2);
                }
            }
            return;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object obj3 = Array.get(obj, i);
                if (obj3 != null) {
                    addQueryParam(str, obj3.toString(), z, z2);
                }
            }
            return;
        }
        addQueryParam(str, obj.toString(), z, z2);
    }

    @Override // retrofit.RequestInterceptor.RequestFacade
    public void addQueryParam(String str, String str2) {
        addQueryParam(str, str2, false, true);
    }

    @Override // retrofit.RequestInterceptor.RequestFacade
    public void addPathParam(String str, String str2) {
        addPathParam(str, str2, true);
    }
}
