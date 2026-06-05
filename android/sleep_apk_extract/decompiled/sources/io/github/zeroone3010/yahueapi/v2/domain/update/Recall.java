package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Recall {

    @JsonProperty("action")
    private SceneAction action = SceneAction.ACTIVE;

    public SceneAction getAction() {
        return this.action;
    }
}
