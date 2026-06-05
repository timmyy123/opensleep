package com.urbandroid.common.os;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.BoundedLinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class BoundedInMemoryStringCollector implements IStringCollector {
    private BoundedLinkedList<String> strings = new BoundedLinkedList<>(100);

    public Collection<String> getStrings() {
        return Collections.unmodifiableCollection(this.strings);
    }

    @Override // com.urbandroid.common.os.IStringCollector
    public void newString(String str) {
        this.strings.add(Logger.getDateFormat().format(new Date()) + ": " + str);
    }
}
