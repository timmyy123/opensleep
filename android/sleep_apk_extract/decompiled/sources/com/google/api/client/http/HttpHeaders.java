package com.google.api.client.http;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public class HttpHeaders extends GenericData {

    @Key("Accept")
    private List<String> accept;

    @Key("Accept-Encoding")
    private List<String> acceptEncoding;

    @Key("Age")
    private List<Long> age;

    @Key("WWW-Authenticate")
    private List<String> authenticate;

    @Key(OAuth.HTTP_AUTHORIZATION_HEADER)
    private List<String> authorization;

    @Key("Cache-Control")
    private List<String> cacheControl;

    @Key("Content-Encoding")
    private List<String> contentEncoding;

    @Key("Content-Length")
    private List<Long> contentLength;

    @Key("Content-MD5")
    private List<String> contentMD5;

    @Key("Content-Range")
    private List<String> contentRange;

    @Key("Content-Type")
    private List<String> contentType;

    @Key("Cookie")
    private List<String> cookie;

    @Key("Date")
    private List<String> date;

    @Key("ETag")
    private List<String> etag;

    @Key("Expires")
    private List<String> expires;

    @Key("If-Match")
    private List<String> ifMatch;

    @Key("If-Modified-Since")
    private List<String> ifModifiedSince;

    @Key("If-None-Match")
    private List<String> ifNoneMatch;

    @Key("If-Range")
    private List<String> ifRange;

    @Key("If-Unmodified-Since")
    private List<String> ifUnmodifiedSince;

    @Key("Last-Modified")
    private List<String> lastModified;

    @Key("Location")
    private List<String> location;

    @Key("MIME-Version")
    private List<String> mimeVersion;

    @Key("Range")
    private List<String> range;

    @Key("Retry-After")
    private List<String> retryAfter;

    @Key("User-Agent")
    private List<String> userAgent;

    @Key("Warning")
    private List<String> warning;

    public static final class ParseHeaderState {
        final ArrayValueMap arrayValueMap;
        final ClassInfo classInfo;
        final List<Type> context;
        final StringBuilder logger;

        public ParseHeaderState(HttpHeaders httpHeaders, StringBuilder sb) {
            Class<?> cls = httpHeaders.getClass();
            this.context = Arrays.asList(cls);
            this.classInfo = ClassInfo.of(cls, true);
            this.logger = sb;
            this.arrayValueMap = new ArrayValueMap(httpHeaders);
        }

        public void finish() {
            this.arrayValueMap.setValues();
        }
    }

    public HttpHeaders() {
        super(EnumSet.of(GenericData.Flags.IGNORE_CASE));
        this.acceptEncoding = new ArrayList(Collections.singleton("gzip"));
    }

    private static void addHeader(Logger logger, StringBuilder sb, StringBuilder sb2, LowLevelHttpRequest lowLevelHttpRequest, String str, Object obj, Writer writer) throws IOException {
        if (obj == null || Data.isNull(obj)) {
            return;
        }
        String stringValue = toStringValue(obj);
        String str2 = ((OAuth.HTTP_AUTHORIZATION_HEADER.equalsIgnoreCase(str) || "Cookie".equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) ? "<Not Logged>" : stringValue;
        if (sb != null) {
            Fragment$$ExternalSyntheticOutline1.m67m(sb, str, ": ", str2);
            sb.append(StringUtils.LINE_SEPARATOR);
        }
        if (sb2 != null) {
            FileInsert$$ExternalSyntheticOutline0.m(sb2, " -H '", str, ": ", str2);
            sb2.append("'");
        }
        if (lowLevelHttpRequest != null) {
            lowLevelHttpRequest.addHeader(str, stringValue);
        }
        if (writer != null) {
            writer.write(str);
            writer.write(": ");
            writer.write(stringValue);
            writer.write("\r\n");
        }
    }

    private <T> List<T> getAsList(T t) {
        if (t == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    private <T> T getFirstHeaderValue(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    private static Object parseValue(Type type, List<Type> list, String str) {
        return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(list, type), str);
    }

    public static void serializeHeaders(HttpHeaders httpHeaders, StringBuilder sb, StringBuilder sb2, Logger logger, LowLevelHttpRequest lowLevelHttpRequest, Writer writer) throws IOException {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, Object> entry : httpHeaders.entrySet()) {
            String key = entry.getKey();
            Preconditions.checkArgument(hashSet.add(key), "multiple headers of the same name (headers are case insensitive): %s", key);
            Object value = entry.getValue();
            if (value != null) {
                FieldInfo fieldInfo = httpHeaders.getClassInfo().getFieldInfo(key);
                if (fieldInfo != null) {
                    key = fieldInfo.getName();
                }
                String str = key;
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    Iterator it = Types.iterableOf(value).iterator();
                    while (it.hasNext()) {
                        addHeader(logger, sb, sb2, lowLevelHttpRequest, str, it.next(), writer);
                    }
                } else {
                    addHeader(logger, sb, sb2, lowLevelHttpRequest, str, value, writer);
                }
            }
        }
        if (writer != null) {
            writer.flush();
        }
    }

    private static String toStringValue(Object obj) {
        return obj instanceof Enum ? FieldInfo.of((Enum<?>) obj).getName() : obj.toString();
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public HttpHeaders clone() {
        return (HttpHeaders) super.clone();
    }

    public final void fromHttpResponse(LowLevelHttpResponse lowLevelHttpResponse, StringBuilder sb) {
        clear();
        ParseHeaderState parseHeaderState = new ParseHeaderState(this, sb);
        int headerCount = lowLevelHttpResponse.getHeaderCount();
        for (int i = 0; i < headerCount; i++) {
            parseHeader(lowLevelHttpResponse.getHeaderName(i), lowLevelHttpResponse.getHeaderValue(i), parseHeaderState);
        }
        parseHeaderState.finish();
    }

    public final String getContentType() {
        return (String) getFirstHeaderValue(this.contentType);
    }

    public final String getLocation() {
        return (String) getFirstHeaderValue(this.location);
    }

    public final String getUserAgent() {
        return (String) getFirstHeaderValue(this.userAgent);
    }

    public void parseHeader(String str, String str2, ParseHeaderState parseHeaderState) {
        List<Type> list = parseHeaderState.context;
        ClassInfo classInfo = parseHeaderState.classInfo;
        ArrayValueMap arrayValueMap = parseHeaderState.arrayValueMap;
        StringBuilder sb = parseHeaderState.logger;
        if (sb != null) {
            sb.append(str + ": " + str2);
            sb.append(StringUtils.LINE_SEPARATOR);
        }
        FieldInfo fieldInfo = classInfo.getFieldInfo(str);
        if (fieldInfo == null) {
            ArrayList arrayList = (ArrayList) get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                set(str, (Object) arrayList);
            }
            arrayList.add(str2);
            return;
        }
        Type typeResolveWildcardTypeOrTypeVariable = Data.resolveWildcardTypeOrTypeVariable(list, fieldInfo.getGenericType());
        if (Types.isArray(typeResolveWildcardTypeOrTypeVariable)) {
            Class<?> rawArrayComponentType = Types.getRawArrayComponentType(list, Types.getArrayComponentType(typeResolveWildcardTypeOrTypeVariable));
            arrayValueMap.put(fieldInfo.getField(), rawArrayComponentType, parseValue(rawArrayComponentType, list, str2));
        } else {
            if (!Types.isAssignableToOrFrom(Types.getRawArrayComponentType(list, typeResolveWildcardTypeOrTypeVariable), Iterable.class)) {
                fieldInfo.setValue(this, parseValue(typeResolveWildcardTypeOrTypeVariable, list, str2));
                return;
            }
            Collection<Object> collectionNewCollectionInstance = (Collection) fieldInfo.getValue(this);
            if (collectionNewCollectionInstance == null) {
                collectionNewCollectionInstance = Data.newCollectionInstance(typeResolveWildcardTypeOrTypeVariable);
                fieldInfo.setValue(this, collectionNewCollectionInstance);
            }
            collectionNewCollectionInstance.add(parseValue(typeResolveWildcardTypeOrTypeVariable == Object.class ? null : Types.getIterableParameter(typeResolveWildcardTypeOrTypeVariable), list, str2));
        }
    }

    @Override // com.google.api.client.util.GenericData
    public HttpHeaders set(String str, Object obj) {
        return (HttpHeaders) super.set(str, obj);
    }

    public HttpHeaders setAuthorization(String str) {
        return setAuthorization(getAsList(str));
    }

    public HttpHeaders setIfMatch(String str) {
        this.ifMatch = getAsList(str);
        return this;
    }

    public HttpHeaders setIfModifiedSince(String str) {
        this.ifModifiedSince = getAsList(str);
        return this;
    }

    public HttpHeaders setIfNoneMatch(String str) {
        this.ifNoneMatch = getAsList(str);
        return this;
    }

    public HttpHeaders setIfRange(String str) {
        this.ifRange = getAsList(str);
        return this;
    }

    public HttpHeaders setIfUnmodifiedSince(String str) {
        this.ifUnmodifiedSince = getAsList(str);
        return this;
    }

    public HttpHeaders setUserAgent(String str) {
        this.userAgent = getAsList(str);
        return this;
    }

    public HttpHeaders setAuthorization(List<String> list) {
        this.authorization = list;
        return this;
    }

    public static void serializeHeaders(HttpHeaders httpHeaders, StringBuilder sb, StringBuilder sb2, Logger logger, LowLevelHttpRequest lowLevelHttpRequest) {
        serializeHeaders(httpHeaders, sb, sb2, logger, lowLevelHttpRequest, null);
    }
}
