package com.urbandroid.sleep.domain.undo;

import com.urbandroid.sleep.domain.SleepRecord;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes4.dex */
public class UndoOperationGroup implements UndoOperation {
    private final String name;
    private LinkedList<UndoOperation> operations = new LinkedList<>();
    private final SleepRecord originalRecord;

    public UndoOperationGroup(String str, SleepRecord sleepRecord) {
        this.name = str;
        this.originalRecord = sleepRecord;
    }

    public void addOperation(UndoOperation undoOperation) {
        this.operations.add(undoOperation);
    }

    public String getName() {
        return this.name;
    }

    public SleepRecord getOriginalRecord() {
        return this.originalRecord;
    }

    @Override // com.urbandroid.sleep.domain.undo.UndoOperation
    public long timestamp() {
        if (this.operations.isEmpty()) {
            return 0L;
        }
        return this.operations.getLast().timestamp();
    }

    @Override // com.urbandroid.sleep.domain.undo.UndoOperation
    public boolean undo() {
        LinkedList<UndoOperation> linkedList = this.operations;
        ListIterator<UndoOperation> listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            if (!listIterator.previous().undo()) {
                return false;
            }
        }
        return true;
    }
}
