package com.urbandroid.sleep.domain.undo;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class DeleteUndoOperation extends BaseUndoOperation {
    private final SleepRecord deletedRecord;

    public DeleteUndoOperation(SleepRecord sleepRecord) {
        this.deletedRecord = sleepRecord;
    }

    @Override // com.urbandroid.sleep.domain.undo.UndoOperation
    public boolean undo() {
        return SharedApplicationContext.getInstance().getSleepRecordRepository().addNewSleepRecord(this.deletedRecord, new UndoOperationGroup("IGNORED", null));
    }
}
