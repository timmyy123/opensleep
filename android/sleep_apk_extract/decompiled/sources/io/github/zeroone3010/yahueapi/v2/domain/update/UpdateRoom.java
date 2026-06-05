package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class UpdateRoom {

    @JsonProperty("children")
    private List<ResourceIdentifier> children;

    public List<ResourceIdentifier> getChildren() {
        return this.children;
    }

    public void setChildren(List<ResourceIdentifier> list) {
        this.children = list;
    }
}
