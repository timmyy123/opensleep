package com.google.api.services.calendar;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.Key;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CalendarRequest<T> extends AbstractGoogleJsonClientRequest<T> {

    @Key
    private String alt;

    @Key
    private String fields;

    @Key
    private String key;

    @Key(OAuth.OAUTH_TOKEN)
    private String oauthToken;

    @Key
    private Boolean prettyPrint;

    @Key
    private String quotaUser;

    @Key
    private String userIp;

    public CalendarRequest(Calendar calendar, String str, String str2, Object obj, Class<T> cls) {
        super(calendar, str, str2, obj, cls);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public final Calendar getAbstractGoogleClient() {
        return (Calendar) super.getAbstractGoogleClient();
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public CalendarRequest<T> set(String str, Object obj) {
        return (CalendarRequest) super.set(str, obj);
    }

    /* JADX INFO: renamed from: setKey */
    public CalendarRequest<T> setKey2(String str) {
        this.key = str;
        return this;
    }

    /* JADX INFO: renamed from: setOauthToken */
    public CalendarRequest<T> setOauthToken2(String str) {
        this.oauthToken = str;
        return this;
    }
}
