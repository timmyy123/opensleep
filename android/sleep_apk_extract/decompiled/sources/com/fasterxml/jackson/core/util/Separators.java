package com.fasterxml.jackson.core.util;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Separators implements Serializable {
    private static final long serialVersionUID = 1;
    private final String arrayEmptySeparator;
    private final char arrayValueSeparator;
    private final Spacing arrayValueSpacing;
    private final String objectEmptySeparator;
    private final char objectEntrySeparator;
    private final Spacing objectEntrySpacing;
    private final char objectFieldValueSeparator;
    private final Spacing objectFieldValueSpacing;
    private final String rootSeparator;

    public enum Spacing {
        NONE("", ""),
        BEFORE(" ", ""),
        AFTER("", " "),
        BOTH(" ", " ");

        private final String spacesAfter;
        private final String spacesBefore;

        Spacing(String str, String str2) {
            this.spacesBefore = str;
            this.spacesAfter = str2;
        }

        public String apply(char c) {
            return this.spacesBefore + c + this.spacesAfter;
        }
    }

    public Separators(String str, char c, Spacing spacing, char c2, Spacing spacing2, String str2, char c3, Spacing spacing3, String str3) {
        this.rootSeparator = str;
        this.objectFieldValueSeparator = c;
        this.objectFieldValueSpacing = spacing;
        this.objectEntrySeparator = c2;
        this.objectEntrySpacing = spacing2;
        this.objectEmptySeparator = str2;
        this.arrayValueSeparator = c3;
        this.arrayValueSpacing = spacing3;
        this.arrayEmptySeparator = str3;
    }

    public static Separators createDefaultInstance() {
        return new Separators();
    }

    public String getArrayEmptySeparator() {
        return this.arrayEmptySeparator;
    }

    public char getArrayValueSeparator() {
        return this.arrayValueSeparator;
    }

    public Spacing getArrayValueSpacing() {
        return this.arrayValueSpacing;
    }

    public String getObjectEmptySeparator() {
        return this.objectEmptySeparator;
    }

    public char getObjectEntrySeparator() {
        return this.objectEntrySeparator;
    }

    public Spacing getObjectEntrySpacing() {
        return this.objectEntrySpacing;
    }

    public char getObjectFieldValueSeparator() {
        return this.objectFieldValueSeparator;
    }

    public Spacing getObjectFieldValueSpacing() {
        return this.objectFieldValueSpacing;
    }

    public String getRootSeparator() {
        return this.rootSeparator;
    }

    public Separators withObjectFieldValueSpacing(Spacing spacing) {
        return this.objectFieldValueSpacing == spacing ? this : new Separators(this.rootSeparator, this.objectFieldValueSeparator, spacing, this.objectEntrySeparator, this.objectEntrySpacing, this.objectEmptySeparator, this.arrayValueSeparator, this.arrayValueSpacing, this.arrayEmptySeparator);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Separators(char c, char c2, char c3) {
        Spacing spacing = Spacing.BOTH;
        Spacing spacing2 = Spacing.NONE;
        this(" ", c, spacing, c2, spacing2, " ", c3, spacing2, " ");
    }

    public Separators() {
        this(':', ',', ',');
    }
}
