package com.fasterxml.jackson.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class StreamReadConstraints implements Serializable {
    private static StreamReadConstraints DEFAULT = new StreamReadConstraints(1000, -1, 1000, 20000000, 50000, -1);
    private static final long serialVersionUID = 1;
    protected final long _maxDocLen;
    protected final int _maxNameLen;
    protected final int _maxNestingDepth;
    protected final int _maxNumLen;
    protected final int _maxStringLen;
    protected final long _maxTokenCount;

    public StreamReadConstraints(int i, long j, int i2, int i3, int i4, long j2) {
        this._maxNestingDepth = i;
        this._maxDocLen = j;
        this._maxNumLen = i2;
        this._maxStringLen = i3;
        this._maxNameLen = i4;
        this._maxTokenCount = j2;
    }

    public static StreamReadConstraints defaults() {
        return DEFAULT;
    }

    public String _constrainRef(String str) {
        return FileInsert$$ExternalSyntheticOutline0.m("`StreamReadConstraints.", str, "()`");
    }

    public StreamConstraintsException _constructException(String str, Object... objArr) throws StreamConstraintsException {
        throw new StreamConstraintsException(String.format(str, objArr));
    }

    public int getMaxNameLength() {
        return this._maxNameLen;
    }

    public boolean hasMaxDocumentLength() {
        return this._maxDocLen > 0;
    }

    public boolean hasMaxTokenCount() {
        return this._maxTokenCount > 0;
    }

    public void validateBigIntegerScale(int i) throws StreamConstraintsException {
        if (Math.abs(i) > 100000) {
            throw _constructException("BigDecimal scale (%d) magnitude exceeds the maximum allowed (%d)", Integer.valueOf(i), 100000);
        }
    }

    public void validateDocumentLength(long j) throws StreamConstraintsException {
        long j2 = this._maxDocLen;
        if (j > j2 && j2 > 0) {
            throw _constructException("Document length (%d) exceeds the maximum allowed (%d, from %s)", Long.valueOf(j), Long.valueOf(this._maxDocLen), _constrainRef("getMaxDocumentLength"));
        }
    }

    public void validateFPLength(int i) throws StreamConstraintsException {
        if (i > this._maxNumLen) {
            throw _constructException("Number value length (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNumLen), _constrainRef("getMaxNumberLength"));
        }
    }

    public void validateIntegerLength(int i) throws StreamConstraintsException {
        if (i > this._maxNumLen) {
            throw _constructException("Number value length (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNumLen), _constrainRef("getMaxNumberLength"));
        }
    }

    public void validateNameLength(int i) throws StreamConstraintsException {
        if (i > this._maxNameLen) {
            throw _constructException("Name length (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNameLen), _constrainRef("getMaxNameLength"));
        }
    }

    public void validateNestingDepth(int i) throws StreamConstraintsException {
        if (i > this._maxNestingDepth) {
            throw _constructException("Document nesting depth (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNestingDepth), _constrainRef("getMaxNestingDepth"));
        }
    }

    public void validateStringLength(int i) throws StreamConstraintsException {
        if (i > this._maxStringLen) {
            throw _constructException("String value length (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxStringLen), _constrainRef("getMaxStringLength"));
        }
    }

    public void validateTokenCount(long j) throws StreamConstraintsException {
        if (j > this._maxTokenCount) {
            throw _constructException("Token count (%d) exceeds the maximum allowed (%d, from %s)", Long.valueOf(j), Long.valueOf(this._maxTokenCount), _constrainRef("getMaxTokenCount"));
        }
    }
}
