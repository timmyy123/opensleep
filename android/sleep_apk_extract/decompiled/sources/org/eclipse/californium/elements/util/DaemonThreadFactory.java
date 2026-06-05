package org.eclipse.californium.elements.util;

/* JADX INFO: loaded from: classes5.dex */
public class DaemonThreadFactory extends NamedThreadFactory {
    public DaemonThreadFactory(String str) {
        super(str, null);
    }

    @Override // org.eclipse.californium.elements.util.NamedThreadFactory
    public boolean createDaemonThreads() {
        return true;
    }

    public DaemonThreadFactory(String str, ThreadGroup threadGroup) {
        super(str, threadGroup);
    }
}
