package com.urbandroid.common.error;

import android.content.Context;
import android.os.Handler;
import com.urbandroid.common.os.BoundedInMemoryStringCollector;
import com.urbandroid.common.os.NoResourceMonitoring;
import com.urbandroid.common.os.ResourceUsageMonitor;
import com.urbandroid.common.os.StringCollectingResourceUsageUpdatesListener;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DefaultConfigurationBuilder {

    public static class Builder {
        private IAdditionalDataProvider additionalDataProvider;
        private final Context context;
        private IErrorDispatcher errorDispatcher;
        private final Handler handler;
        private boolean lockupDetectionEnabled = true;
        private ResourceUsageMonitor usageMonitor;

        public Builder(Context context, Handler handler, String str, String[] strArr) {
            this.context = context;
            this.handler = handler;
            this.errorDispatcher = DefaultConfigurationBuilder.buildEmailIntentDispatcher(context, handler, str, strArr);
        }

        public ErrorReporterConfiguration build() {
            if (this.usageMonitor == null) {
                this.usageMonitor = new NoResourceMonitoring();
            }
            BoundedInMemoryStringCollector boundedInMemoryStringCollector = new BoundedInMemoryStringCollector();
            this.usageMonitor.addListener(new StringCollectingResourceUsageUpdatesListener(5, boundedInMemoryStringCollector));
            ErrorReporterConfiguration errorReporterConfiguration = new ErrorReporterConfiguration(new DefaultErrorReportGenerator(this.context, this.handler, this.additionalDataProvider, boundedInMemoryStringCollector), this.errorDispatcher);
            errorReporterConfiguration.setResourceUsageMonitor(this.usageMonitor);
            errorReporterConfiguration.setLockupDetectionEnabled(this.lockupDetectionEnabled);
            return errorReporterConfiguration;
        }

        public Builder withAdditionalDataProvider(IAdditionalDataProvider iAdditionalDataProvider) {
            this.additionalDataProvider = iAdditionalDataProvider;
            return this;
        }

        public Builder withLockupDatection(boolean z) {
            this.lockupDetectionEnabled = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EmailIntentErrorDispatcher buildEmailIntentDispatcher(Context context, Handler handler, String str, String[] strArr) {
        return new EmailIntentErrorDispatcher(context, handler, str, new EmailIntentDispatcherConfiguration(new DefaultErrorReportSerializer(), strArr));
    }
}
