package org.eclipse.paho.client.mqttv3;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class DisconnectedBufferOptions {
    public static final boolean DELETE_OLDEST_MESSAGES_DEFAULT = false;
    public static final boolean DISCONNECTED_BUFFER_ENABLED_DEFAULT = false;
    public static final int DISCONNECTED_BUFFER_SIZE_DEFAULT = 5000;
    public static final boolean PERSIST_DISCONNECTED_BUFFER_DEFAULT = false;
    private int bufferSize = DISCONNECTED_BUFFER_SIZE_DEFAULT;
    private boolean bufferEnabled = false;
    private boolean persistBuffer = false;
    private boolean deleteOldestMessages = false;

    public int getBufferSize() {
        return this.bufferSize;
    }

    public boolean isBufferEnabled() {
        return this.bufferEnabled;
    }

    public boolean isDeleteOldestMessages() {
        return this.deleteOldestMessages;
    }

    public boolean isPersistBuffer() {
        return this.persistBuffer;
    }

    public void setBufferEnabled(boolean z) {
        this.bufferEnabled = z;
    }

    public void setBufferSize(int i) {
        if (i >= 1) {
            this.bufferSize = i;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
        }
    }

    public void setDeleteOldestMessages(boolean z) {
        this.deleteOldestMessages = z;
    }

    public void setPersistBuffer(boolean z) {
        this.persistBuffer = z;
    }
}
