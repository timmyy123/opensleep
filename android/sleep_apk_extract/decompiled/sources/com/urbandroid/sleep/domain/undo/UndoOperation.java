package com.urbandroid.sleep.domain.undo;

/* JADX INFO: loaded from: classes4.dex */
public interface UndoOperation {
    long timestamp();

    boolean undo();
}
