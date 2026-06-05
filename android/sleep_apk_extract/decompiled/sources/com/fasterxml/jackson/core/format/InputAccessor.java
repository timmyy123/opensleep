package com.fasterxml.jackson.core.format;

/* JADX INFO: loaded from: classes.dex */
public interface InputAccessor {
    boolean hasMoreBytes();

    byte nextByte();
}
