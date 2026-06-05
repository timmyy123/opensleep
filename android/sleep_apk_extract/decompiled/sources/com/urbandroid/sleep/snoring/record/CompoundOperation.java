package com.urbandroid.sleep.snoring.record;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CompoundOperation implements Function {
    private final List<Function<Record, Record>> steps;

    public CompoundOperation(Function<Record, Record>... functionArr) {
        this.steps = Arrays.asList(functionArr);
    }

    @Override // com.urbandroid.sleep.snoring.record.Function
    public Record apply(Record record) {
        Iterator<Function<Record, Record>> it = this.steps.iterator();
        while (it.hasNext()) {
            record = it.next().apply(record);
        }
        return record;
    }
}
