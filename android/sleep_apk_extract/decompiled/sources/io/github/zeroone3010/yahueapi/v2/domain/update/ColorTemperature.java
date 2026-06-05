package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColorTemperature {

    @JsonProperty("mirek")
    private Integer mirek;

    public Integer getMirek() {
        return this.mirek;
    }

    public ColorTemperature setMirek(Integer num) {
        this.mirek = num;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
