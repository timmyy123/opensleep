package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;

/* JADX INFO: loaded from: classes.dex */
public final class ReadConstrainedTextBuffer extends TextBuffer {
    private final StreamReadConstraints _streamReadConstraints;

    public ReadConstrainedTextBuffer(StreamReadConstraints streamReadConstraints, BufferRecycler bufferRecycler) {
        super(bufferRecycler);
        this._streamReadConstraints = streamReadConstraints;
    }

    @Override // com.fasterxml.jackson.core.util.TextBuffer
    public void validateStringLength(int i) throws StreamConstraintsException {
        this._streamReadConstraints.validateStringLength(i);
    }
}
