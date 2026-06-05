package com.urbandroid.sleep.domain.undo;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class AddUndoOperation extends BaseUndoOperation {
    private final SleepRecord addedRecord;

    public AddUndoOperation(SleepRecord sleepRecord) {
        this.addedRecord = sleepRecord;
    }

    @Override // com.urbandroid.sleep.domain.undo.UndoOperation
    public boolean undo() {
        return SharedApplicationContext.getInstance().getSleepRecordRepository().deleteRecord(this.addedRecord, new UndoOperationGroup("IGNORED", null));
    }
}
