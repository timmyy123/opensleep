package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadGroupDeserializer extends StdNodeBasedDeserializer<ThreadGroup> {
    private static final long serialVersionUID = 1;

    public ThreadGroupDeserializer() {
        super(ThreadGroup.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdNodeBasedDeserializer
    public ThreadGroup convert(JsonNode jsonNode, DeserializationContext deserializationContext) {
        String strAsText = jsonNode.path("name").asText();
        if (strAsText == null) {
            strAsText = "";
        }
        return new ThreadGroup(strAsText);
    }
}
