package com.launchdarkly.eventsource;

/* JADX INFO: loaded from: classes4.dex */
public interface ResponseHeaders {

    public static final class Header {
        private final String name;
        private final String value;

        public Header(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            return this.name + ": " + this.value;
        }
    }
}
