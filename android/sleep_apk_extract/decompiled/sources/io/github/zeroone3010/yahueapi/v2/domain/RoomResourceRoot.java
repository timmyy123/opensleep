package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RoomResourceRoot {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    @JsonProperty("data")
    private List<RoomResource> f85data;

    @JsonProperty("errors")
    private List<Error> errors;

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
