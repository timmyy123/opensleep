package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.SourceLocation;

/* JADX INFO: loaded from: classes5.dex */
class SourceLocationImpl implements SourceLocation {
    String fileName;
    int line;
    Class withinType;

    public SourceLocationImpl(Class cls, String str, int i) {
        this.withinType = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLine() {
        return this.line;
    }

    public String toString() {
        return getFileName() + ":" + getLine();
    }
}
