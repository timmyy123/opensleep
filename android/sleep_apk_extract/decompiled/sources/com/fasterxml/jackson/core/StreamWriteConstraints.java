package com.fasterxml.jackson.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class StreamWriteConstraints implements Serializable {
    private static StreamWriteConstraints DEFAULT = new StreamWriteConstraints(1000);
    private static final long serialVersionUID = 1;
    protected final int _maxNestingDepth;

    public StreamWriteConstraints(int i) {
        this._maxNestingDepth = i;
    }

    public static StreamWriteConstraints defaults() {
        return DEFAULT;
    }

    public String _constrainRef(String str) {
        return FileInsert$$ExternalSyntheticOutline0.m("`StreamWriteConstraints.", str, "()`");
    }

    public StreamConstraintsException _constructException(String str, Object... objArr) throws StreamConstraintsException {
        throw new StreamConstraintsException(String.format(str, objArr));
    }

    public void validateNestingDepth(int i) throws StreamConstraintsException {
        if (i > this._maxNestingDepth) {
            throw _constructException("Document nesting depth (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNestingDepth), _constrainRef("getMaxNestingDepth"));
        }
    }
}
