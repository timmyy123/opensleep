package com.urbandroid.sleep.domain.undo;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class EditDataUndoOperation extends BaseUndoOperation {
    private final SleepRecord newRecord;
    private final SleepRecord originalRecord;

    public EditDataUndoOperation(SleepRecord sleepRecord, SleepRecord sleepRecord2) {
        this.originalRecord = sleepRecord;
        this.newRecord = sleepRecord2;
    }

    @Override // com.urbandroid.sleep.domain.undo.UndoOperation
    public boolean undo() {
        SharedApplicationContext.getInstance().getSleepRecordRepository().recordDataUpdated(this.newRecord, this.originalRecord, new UndoOperationGroup("IGNORED", null));
        return true;
    }
}
