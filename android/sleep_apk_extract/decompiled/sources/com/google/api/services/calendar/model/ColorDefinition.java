package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class ColorDefinition extends GenericJson {

    @Key
    private String background;

    @Key
    private String foreground;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ColorDefinition clone() {
        return (ColorDefinition) super.clone();
    }

    public String getBackground() {
        return this.background;
    }

    public String getForeground() {
        return this.foreground;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ColorDefinition set(String str, Object obj) {
        return (ColorDefinition) super.set(str, obj);
    }

    public ColorDefinition setBackground(String str) {
        this.background = str;
        return this;
    }

    public ColorDefinition setForeground(String str) {
        this.foreground = str;
        return this;
    }
}
