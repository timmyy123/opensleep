package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/* JADX INFO: loaded from: classes5.dex */
@JsonTypeName("button")
public class ButtonResource extends Resource {

    @JsonProperty("button")
    private ButtonSpecifics button;

    @JsonProperty("metadata")
    private ButtonMetadata metadata;

    @JsonProperty("owner")
    private ResourceIdentifier owner;

    public ButtonSpecifics getButton() {
        return this.button;
    }

    public ButtonMetadata getMetadata() {
        return this.metadata;
    }
}
