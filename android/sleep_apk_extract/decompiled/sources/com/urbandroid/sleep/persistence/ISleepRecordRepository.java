package com.urbandroid.sleep.persistence;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface ISleepRecordRepository {
    boolean addNewSleepRecord(SleepRecord sleepRecord);

    boolean deleteRecord(SleepRecord sleepRecord, UndoOperationGroup undoOperationGroup);

    List<SleepRecord> getSleepRecords(long j, long j2, boolean z);

    int getSleepRecordsCount();

    SleepRecord load(long j);

    SleepRecord loadFullRecord(long j);
}
