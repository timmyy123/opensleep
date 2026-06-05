package io.github.zeroone3010.yahueapi.v2.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class HueEvent {

    @JsonProperty("creationtime")
    private String creationTime;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    @JsonProperty("data")
    private List<HueEventData> f81data;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("type")
    private String type;

    public String getCreationTime() {
        return this.creationTime;
    }

    public List<HueEventData> getData() {
        return this.f81data;
    }

    public UUID getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HueEvent{creationTime='");
        sb.append(this.creationTime);
        sb.append("', data=");
        sb.append(this.f81data);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", type='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.type, "'}");
    }
}
