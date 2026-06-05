package com.google.api.client.http;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.escape.CharEscapers;
import com.google.api.client.util.escape.Escaper;
import com.google.api.client.util.escape.PercentEscaper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class GenericUrl extends GenericData {
    private static final Escaper URI_FRAGMENT_ESCAPER = new PercentEscaper("=&-_.!~*'()@:$,;/?:");
    private String fragment;
    private String host;
    private List<String> pathParts;
    private int port;
    private String scheme;
    private String userInfo;
    private boolean verbatim;

    private GenericUrl(String str, String str2, int i, String str3, String str4, String str5, String str6, boolean z) {
        this.port = -1;
        this.scheme = str.toLowerCase(Locale.US);
        this.host = str2;
        this.port = i;
        this.pathParts = toPathParts(str3, z);
        this.verbatim = z;
        if (z) {
            this.fragment = str4;
            if (str5 != null) {
                UrlEncodedParser.parse(str5, (Object) this, false);
            }
            this.userInfo = str6;
            return;
        }
        this.fragment = str4 != null ? CharEscapers.decodeUri(str4) : null;
        if (str5 != null) {
            UrlEncodedParser.parse(str5, this);
        }
        this.userInfo = str6 != null ? CharEscapers.decodeUri(str6) : null;
    }

    public static void addQueryParams(Set<Map.Entry<String, Object>> set, StringBuilder sb, boolean z) {
        boolean zAppendParam = true;
        for (Map.Entry<String, Object> entry : set) {
            Object value = entry.getValue();
            if (value != null) {
                String key = z ? entry.getKey() : CharEscapers.escapeUriQuery(entry.getKey());
                if (value instanceof Collection) {
                    Iterator it = ((Collection) value).iterator();
                    while (it.hasNext()) {
                        zAppendParam = appendParam(zAppendParam, sb, key, it.next(), z);
                    }
                } else {
                    zAppendParam = appendParam(zAppendParam, sb, key, value, z);
                }
            }
        }
    }

    private static boolean appendParam(boolean z, StringBuilder sb, String str, Object obj, boolean z2) {
        if (z) {
            sb.append('?');
            z = false;
        } else {
            sb.append('&');
        }
        sb.append(str);
        String string = z2 ? obj.toString() : CharEscapers.escapeUriQuery(obj.toString());
        if (string.length() != 0) {
            sb.append('=');
            sb.append(string);
        }
        return z;
    }

    private void appendRawPathFromParts(StringBuilder sb) {
        int size = this.pathParts.size();
        for (int i = 0; i < size; i++) {
            String strEscapeUriPath = this.pathParts.get(i);
            if (i != 0) {
                sb.append('/');
            }
            if (strEscapeUriPath.length() != 0) {
                if (!this.verbatim) {
                    strEscapeUriPath = CharEscapers.escapeUriPath(strEscapeUriPath);
                }
                sb.append(strEscapeUriPath);
            }
        }
    }

    private static URL parseURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            OggIO$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public static List<String> toPathParts(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = true;
        while (z2) {
            int iIndexOf = str.indexOf(47, i);
            boolean z3 = iIndexOf != -1;
            String strSubstring = z3 ? str.substring(i, iIndexOf) : str.substring(i);
            if (!z) {
                strSubstring = CharEscapers.decodeUriPath(strSubstring);
            }
            arrayList.add(strSubstring);
            i = iIndexOf + 1;
            z2 = z3;
        }
        return arrayList;
    }

    public final String build() {
        return buildAuthority() + buildRelativeUrl();
    }

    public final String buildAuthority() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) Preconditions.checkNotNull(this.scheme));
        sb.append("://");
        String strEscapeUriUserInfo = this.userInfo;
        if (strEscapeUriUserInfo != null) {
            if (!this.verbatim) {
                strEscapeUriUserInfo = CharEscapers.escapeUriUserInfo(strEscapeUriUserInfo);
            }
            sb.append(strEscapeUriUserInfo);
            sb.append('@');
        }
        sb.append((String) Preconditions.checkNotNull(this.host));
        int i = this.port;
        if (i != -1) {
            sb.append(':');
            sb.append(i);
        }
        return sb.toString();
    }

    public final String buildRelativeUrl() {
        StringBuilder sb = new StringBuilder();
        if (this.pathParts != null) {
            appendRawPathFromParts(sb);
        }
        addQueryParams(entrySet(), sb, this.verbatim);
        String strEscape = this.fragment;
        if (strEscape != null) {
            sb.append('#');
            if (!this.verbatim) {
                strEscape = URI_FRAGMENT_ESCAPER.escape(strEscape);
            }
            sb.append(strEscape);
        }
        return sb.toString();
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public GenericUrl clone() {
        GenericUrl genericUrl = (GenericUrl) super.clone();
        if (this.pathParts != null) {
            genericUrl.pathParts = new ArrayList(this.pathParts);
        }
        return genericUrl;
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && (obj instanceof GenericUrl)) {
            return build().equals(((GenericUrl) obj).build());
        }
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public String getRawPath() {
        if (this.pathParts == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        appendRawPathFromParts(sb);
        return sb.toString();
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return build().hashCode();
    }

    @Override // com.google.api.client.util.GenericData
    public GenericUrl set(String str, Object obj) {
        return (GenericUrl) super.set(str, obj);
    }

    public void setRawPath(String str) {
        this.pathParts = toPathParts(str, this.verbatim);
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public String toString() {
        return build();
    }

    public final URL toURL(String str) {
        try {
            return new URL(toURL(), str);
        } catch (MalformedURLException e) {
            OggIO$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public final URL toURL() {
        return parseURL(build());
    }

    public GenericUrl(String str, boolean z) {
        this(parseURL(str), z);
    }

    public GenericUrl(URL url, boolean z) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo(), z);
    }

    public GenericUrl(String str) {
        this(str, false);
    }
}
