package com.urbandroid.sleep.domain.undo;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public class UndoBuffer {
    private LinkedList<UndoOperationGroup> operations = new LinkedList<>();

    public void addUndoableOperation(UndoOperationGroup undoOperationGroup) {
        Logger.logInfo("Adding undoable operation: " + undoOperationGroup.getName());
        this.operations.addLast(undoOperationGroup);
        while (this.operations.size() > 5) {
            this.operations.removeFirst();
        }
    }

    public UndoOperationGroup getCurrentUndoOperation() {
        if (this.operations.isEmpty()) {
            return null;
        }
        return this.operations.getLast();
    }

    public SleepRecord performUndo() {
        if (this.operations.isEmpty()) {
            Logger.logWarning("Trying to UNDO with an empty buffer.");
            return null;
        }
        UndoOperationGroup undoOperationGroupRemoveLast = this.operations.removeLast();
        if (undoOperationGroupRemoveLast.undo()) {
            return undoOperationGroupRemoveLast.getOriginalRecord();
        }
        reset();
        return null;
    }

    public void reset() {
    }
}
