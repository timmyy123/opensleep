package com.urbandroid.sleep.snoring;

/* JADX INFO: loaded from: classes4.dex */
public enum SoundClass {
    OTHER(0, ' '),
    SNORE(1, 'w'),
    TALK(2, 'o'),
    COUGH(3, 'x'),
    BABY(4, '='),
    LAUGH(5, '^');

    private final char charLabel;
    private final int intLabel;

    SoundClass(int i, char c) {
        this.intLabel = i;
        this.charLabel = c;
    }
}
