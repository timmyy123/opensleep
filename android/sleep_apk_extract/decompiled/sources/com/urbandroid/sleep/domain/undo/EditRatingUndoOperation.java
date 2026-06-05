package com.urbandroid.sleep.domain.undo;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class EditRatingUndoOperation extends BaseUndoOperation {
    private final SleepRecord newRecord;
    private final SleepRecord originalRecord;

    public EditRatingUndoOperation(SleepRecord sleepRecord, SleepRecord sleepRecord2) {
        this.originalRecord = sleepRecord;
        this.newRecord = sleepRecord2;
    }

    @Override // com.urbandroid.sleep.domain.undo.UndoOperation
    public boolean undo() {
        SharedApplicationContext.getInstance().getSleepRecordRepository().recordRatingUpdated(this.newRecord, this.originalRecord, new UndoOperationGroup("IGNORED", null));
        return true;
    }
}
