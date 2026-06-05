package com.launchdarkly.eventsource;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class CommentEvent implements StreamEvent {
    private final String text;

    public CommentEvent(String str) {
        this.text = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentEvent.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.text, ((CommentEvent) obj).text);
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        return Objects.hash(this.text);
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("CommentEvent("), this.text, ")");
    }
}
