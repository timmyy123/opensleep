package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;

/* JADX INFO: loaded from: classes4.dex */
final class NullLogging implements LDLogAdapter {
    static NullLogging INSTANCE = new NullLogging();

    public static final class ChannelImpl implements LDLogAdapter.Channel {
        static ChannelImpl INSTANCE = new ChannelImpl();

        private ChannelImpl() {
        }

        @Override // com.launchdarkly.logging.LDLogAdapter.Channel
        public void log(LDLogLevel lDLogLevel, Object obj) {
        }

        @Override // com.launchdarkly.logging.LDLogAdapter.Channel
        public void log(LDLogLevel lDLogLevel, String str, Object obj) {
        }
    }

    private NullLogging() {
    }

    @Override // com.launchdarkly.logging.LDLogAdapter
    public LDLogAdapter.Channel newChannel(String str) {
        return ChannelImpl.INSTANCE;
    }
}
