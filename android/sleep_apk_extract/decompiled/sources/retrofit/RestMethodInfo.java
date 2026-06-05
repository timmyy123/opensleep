package retrofit;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.EncodedPath;
import retrofit.http.EncodedQuery;
import retrofit.http.EncodedQueryMap;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit.http.RestMethod;
import retrofit.http.Streaming;
import rx.Observable;

/* JADX INFO: loaded from: classes5.dex */
final class RestMethodInfo {
    private static final Pattern PARAM_NAME_REGEX = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    String contentTypeHeader;
    List<Header> headers;
    final boolean isObservable;
    boolean isStreaming;
    final boolean isSynchronous;
    final Method method;
    boolean requestHasBody;
    String requestMethod;
    Annotation[] requestParamAnnotations;
    String requestQuery;
    String requestUrl;
    Set<String> requestUrlParamNames;
    Type responseObjectType;
    final ResponseType responseType;
    boolean loaded = false;
    RequestType requestType = RequestType.SIMPLE;

    public enum RequestType {
        SIMPLE,
        MULTIPART,
        FORM_URL_ENCODED
    }

    public enum ResponseType {
        VOID,
        OBSERVABLE,
        OBJECT
    }

    public static final class RxSupport {
        public static Type getObservableType(Type type, Class cls) {
            return Types.getSupertype(type, cls, Observable.class);
        }

        public static boolean isObservable(Class cls) {
            return cls == Observable.class;
        }
    }

    public RestMethodInfo(Method method) {
        this.method = method;
        ResponseType responseType = parseResponseType();
        this.responseType = responseType;
        this.isSynchronous = responseType == ResponseType.OBJECT;
        this.isObservable = responseType == ResponseType.OBSERVABLE;
    }

    private static Type getParameterUpperBound(ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type type = actualTypeArguments[i];
            if (type instanceof WildcardType) {
                actualTypeArguments[i] = ((WildcardType) type).getUpperBounds()[0];
            }
        }
        return actualTypeArguments[0];
    }

    private RuntimeException methodError(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return new IllegalArgumentException(this.method.getDeclaringClass().getSimpleName() + "." + this.method.getName() + ": " + str);
    }

    private RuntimeException parameterError(int i, String str, Object... objArr) {
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str, " (parameter #");
        sbM.append(i + 1);
        sbM.append(")");
        return methodError(sbM.toString(), objArr);
    }

    private void parseMethodAnnotations() {
        RestMethod restMethod;
        for (Annotation annotation : this.method.getAnnotations()) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Annotation[] annotations = clsAnnotationType.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    restMethod = null;
                    break;
                }
                Annotation annotation2 = annotations[i];
                if (RestMethod.class == annotation2.annotationType()) {
                    restMethod = (RestMethod) annotation2;
                    break;
                }
                i++;
            }
            if (restMethod != null) {
                String str = this.requestMethod;
                if (str != null) {
                    throw methodError("Only one HTTP method is allowed. Found: %s and %s.", str, restMethod.value());
                }
                try {
                    parsePath((String) clsAnnotationType.getMethod(SDKConstants.PARAM_VALUE, null).invoke(annotation, null));
                    this.requestMethod = restMethod.value();
                    this.requestHasBody = restMethod.hasBody();
                } catch (Exception unused) {
                    throw methodError("Failed to extract String 'value' from @%s annotation.", clsAnnotationType.getSimpleName());
                }
            } else if (clsAnnotationType == Headers.class) {
                String[] strArrValue = ((Headers) annotation).value();
                if (strArrValue.length == 0) {
                    throw methodError("@Headers annotation is empty.", new Object[0]);
                }
                this.headers = parseHeaders(strArrValue);
            } else if (clsAnnotationType == Multipart.class) {
                if (this.requestType != RequestType.SIMPLE) {
                    throw methodError("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.requestType = RequestType.MULTIPART;
            } else if (clsAnnotationType == FormUrlEncoded.class) {
                if (this.requestType != RequestType.SIMPLE) {
                    throw methodError("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.requestType = RequestType.FORM_URL_ENCODED;
            } else if (clsAnnotationType != Streaming.class) {
                continue;
            } else {
                if (this.responseObjectType != Response.class) {
                    throw methodError("Only methods having %s as data type are allowed to have @%s annotation.", "Response", "Streaming");
                }
                this.isStreaming = true;
            }
        }
        if (this.requestMethod == null) {
            throw methodError("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
        if (this.requestHasBody) {
            return;
        }
        RequestType requestType = this.requestType;
        if (requestType == RequestType.MULTIPART) {
            throw methodError("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        }
        if (requestType == RequestType.FORM_URL_ENCODED) {
            throw methodError("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseParameters() {
        Class<?>[] clsArr;
        Annotation annotation;
        Class<?>[] parameterTypes = this.method.getParameterTypes();
        Annotation[][] parameterAnnotations = this.method.getParameterAnnotations();
        int length = parameterAnnotations.length;
        if (!this.isSynchronous && !this.isObservable) {
            length--;
        }
        Annotation[] annotationArr = new Annotation[length];
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            Annotation[] annotationArr2 = parameterAnnotations[i];
            if (annotationArr2 != null) {
                int length2 = annotationArr2.length;
                int i2 = 0;
                while (i2 < length2) {
                    Annotation annotation2 = annotationArr2[i2];
                    Class<? extends Annotation> clsAnnotationType = annotation2.annotationType();
                    if (clsAnnotationType == Path.class) {
                        validatePathName(i, ((Path) annotation2).value());
                    } else if (clsAnnotationType == EncodedPath.class) {
                        validatePathName(i, ((EncodedPath) annotation2).value());
                    } else {
                        if (clsAnnotationType != Query.class && clsAnnotationType != EncodedQuery.class) {
                            clsArr = parameterTypes;
                            if (clsAnnotationType == QueryMap.class) {
                                if (!Map.class.isAssignableFrom(cls)) {
                                    throw parameterError(i, "@QueryMap parameter type must be Map.", new Object[0]);
                                }
                            } else if (clsAnnotationType != EncodedQueryMap.class) {
                                if (clsAnnotationType != retrofit.http.Header.class) {
                                    if (clsAnnotationType == Field.class) {
                                        if (this.requestType != RequestType.FORM_URL_ENCODED) {
                                            throw parameterError(i, "@Field parameters can only be used with form encoding.", new Object[0]);
                                        }
                                    } else if (clsAnnotationType != FieldMap.class) {
                                        if (clsAnnotationType == Part.class) {
                                            if (this.requestType != RequestType.MULTIPART) {
                                                throw parameterError(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                                            }
                                        } else if (clsAnnotationType == PartMap.class) {
                                            if (this.requestType != RequestType.MULTIPART) {
                                                throw parameterError(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                                            }
                                            if (!Map.class.isAssignableFrom(cls)) {
                                                throw parameterError(i, "@PartMap parameter type must be Map.", new Object[0]);
                                            }
                                        } else if (clsAnnotationType != Body.class) {
                                            continue;
                                        } else {
                                            if (this.requestType != RequestType.SIMPLE) {
                                                throw parameterError(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                                            }
                                            if (z) {
                                                throw methodError("Multiple @Body method annotations found.", new Object[0]);
                                            }
                                            z = true;
                                        }
                                        z3 = true;
                                    } else {
                                        if (this.requestType != RequestType.FORM_URL_ENCODED) {
                                            throw parameterError(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                                        }
                                        if (!Map.class.isAssignableFrom(cls)) {
                                            throw parameterError(i, "@FieldMap parameter type must be Map.", new Object[0]);
                                        }
                                    }
                                    z2 = true;
                                }
                                i2++;
                                parameterTypes = clsArr;
                            } else if (!Map.class.isAssignableFrom(cls)) {
                                throw parameterError(i, "@EncodedQueryMap parameter type must be Map.", new Object[0]);
                            }
                        }
                        annotation = annotationArr[i];
                        if (annotation == null) {
                            throw parameterError(i, "Multiple Retrofit annotations found, only one allowed: @%s, @%s.", annotation.annotationType().getSimpleName(), clsAnnotationType.getSimpleName());
                        }
                        annotationArr[i] = annotation2;
                        i2++;
                        parameterTypes = clsArr;
                    }
                    clsArr = parameterTypes;
                    annotation = annotationArr[i];
                    if (annotation == null) {
                    }
                }
            }
            Class<?>[] clsArr2 = parameterTypes;
            if (annotationArr[i] == null) {
                throw parameterError(i, "No Retrofit annotation found.", new Object[0]);
            }
            i++;
            parameterTypes = clsArr2;
        }
        RequestType requestType = this.requestType;
        if (requestType == RequestType.SIMPLE && !this.requestHasBody && z) {
            throw methodError("Non-body HTTP method cannot contain @Body or @TypedOutput.", new Object[0]);
        }
        if (requestType == RequestType.FORM_URL_ENCODED && !z2) {
            throw methodError("Form-encoded method must contain at least one @Field.", new Object[0]);
        }
        if (requestType == RequestType.MULTIPART && !z3) {
            throw methodError("Multipart method must contain at least one @Part.", new Object[0]);
        }
        this.requestParamAnnotations = annotationArr;
    }

    private void parsePath(String str) {
        String strSubstring;
        String strSubstring2;
        if (str == null || str.length() == 0 || str.charAt(0) != '/') {
            throw methodError("URL path \"%s\" must start with '/'.", str);
        }
        int iIndexOf = str.indexOf(63);
        if (iIndexOf == -1 || iIndexOf >= str.length() - 1) {
            strSubstring = null;
            strSubstring2 = str;
        } else {
            strSubstring2 = str.substring(0, iIndexOf);
            strSubstring = str.substring(iIndexOf + 1);
            if (PARAM_URL_REGEX.matcher(strSubstring).find()) {
                throw methodError("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
            }
        }
        Set<String> pathParameters = parsePathParameters(str);
        this.requestUrl = strSubstring2;
        this.requestUrlParamNames = pathParameters;
        this.requestQuery = strSubstring;
    }

    public static Set<String> parsePathParameters(String str) {
        Matcher matcher = PARAM_URL_REGEX.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    private ResponseType parseResponseType() {
        Type type;
        Type genericReturnType = this.method.getGenericReturnType();
        Type[] genericParameterTypes = this.method.getGenericParameterTypes();
        Class cls = null;
        if (genericParameterTypes.length > 0) {
            type = genericParameterTypes[genericParameterTypes.length - 1];
            Type rawType = type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : type;
            if (rawType instanceof Class) {
                cls = (Class) rawType;
            }
        } else {
            type = null;
        }
        boolean z = genericReturnType != Void.TYPE;
        boolean z2 = cls != null && Callback.class.isAssignableFrom(cls);
        if (z && z2) {
            throw methodError("Must have return type or Callback as last argument, not both.", new Object[0]);
        }
        if (!z && !z2) {
            throw methodError("Must have either a return type or Callback as last argument.", new Object[0]);
        }
        if (!z) {
            Type supertype = Types.getSupertype(type, Types.getRawType(type), Callback.class);
            if (!(supertype instanceof ParameterizedType)) {
                throw methodError("Last parameter must be of type Callback<X> or Callback<? super X>.", new Object[0]);
            }
            this.responseObjectType = getParameterUpperBound((ParameterizedType) supertype);
            return ResponseType.VOID;
        }
        if (Platform.HAS_RX_JAVA) {
            Class<?> rawType2 = Types.getRawType(genericReturnType);
            if (RxSupport.isObservable(rawType2)) {
                this.responseObjectType = getParameterUpperBound((ParameterizedType) RxSupport.getObservableType(genericReturnType, rawType2));
                return ResponseType.OBSERVABLE;
            }
        }
        this.responseObjectType = genericReturnType;
        return ResponseType.OBJECT;
    }

    private void validatePathName(int i, String str) {
        if (!PARAM_NAME_REGEX.matcher(str).matches()) {
            throw parameterError(i, "@Path parameter name must match %s. Found: %s", PARAM_URL_REGEX.pattern(), str);
        }
        if (!this.requestUrlParamNames.contains(str)) {
            throw parameterError(i, "URL \"%s\" does not contain \"{%s}\".", this.requestUrl, str);
        }
    }

    public synchronized void init() {
        if (this.loaded) {
            return;
        }
        parseMethodAnnotations();
        parseParameters();
        this.loaded = true;
    }

    public List<Header> parseHeaders(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                throw methodError("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
            }
            String strSubstring = str.substring(0, iIndexOf);
            String strTrim = str.substring(iIndexOf + 1).trim();
            if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                this.contentTypeHeader = strTrim;
            } else {
                arrayList.add(new Header(strSubstring, strTrim));
            }
        }
        return arrayList;
    }
}
