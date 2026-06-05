package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class AclRule extends GenericJson {

    @Key
    private String etag;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private String role;

    @Key
    private Scope scope;

    public static final class Scope extends GenericJson {

        @Key
        private String type;

        @Key
        private String value;

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Scope clone() {
            return (Scope) super.clone();
        }

        public String getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Scope set(String str, Object obj) {
            return (Scope) super.set(str, obj);
        }

        public Scope setType(String str) {
            this.type = str;
            return this;
        }

        public Scope setValue(String str) {
            this.value = str;
            return this;
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AclRule clone() {
        return (AclRule) super.clone();
    }

    public String getEtag() {
        return this.etag;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getRole() {
        return this.role;
    }

    public Scope getScope() {
        return this.scope;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public AclRule set(String str, Object obj) {
        return (AclRule) super.set(str, obj);
    }

    public AclRule setEtag(String str) {
        this.etag = str;
        return this;
    }

    public AclRule setId(String str) {
        this.id = str;
        return this;
    }

    public AclRule setKind(String str) {
        this.kind = str;
        return this;
    }

    public AclRule setRole(String str) {
        this.role = str;
        return this;
    }

    public AclRule setScope(Scope scope) {
        this.scope = scope;
        return this;
    }
}
