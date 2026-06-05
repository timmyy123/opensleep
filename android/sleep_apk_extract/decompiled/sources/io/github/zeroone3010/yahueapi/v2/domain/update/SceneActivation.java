package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class SceneActivation {

    @JsonProperty("recall")
    private Recall recall = new Recall();

    public Recall getRecall() {
        return this.recall;
    }
}
