package com.urbandroid.sleep.domain.undo;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseUndoOperation implements UndoOperation {
    private final long timestamp = System.currentTimeMillis();

    @Override // com.urbandroid.sleep.domain.undo.UndoOperation
    public long timestamp() {
        return this.timestamp;
    }
}
