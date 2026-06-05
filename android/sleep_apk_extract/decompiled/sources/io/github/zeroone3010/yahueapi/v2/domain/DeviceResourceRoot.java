package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceResourceRoot {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    @JsonProperty("data")
    private List<DeviceResource> f79data;

    @JsonProperty("errors")
    private List<Error> errors;

    public List<DeviceResource> getData() {
        return this.f79data;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
