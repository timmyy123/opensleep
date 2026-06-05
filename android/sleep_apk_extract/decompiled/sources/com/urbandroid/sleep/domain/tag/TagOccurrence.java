package com.urbandroid.sleep.domain.tag;

/* JADX INFO: loaded from: classes4.dex */
public class TagOccurrence implements Comparable<TagOccurrence> {
    private int occurrence;
    private String tagName;

    public TagOccurrence(String str, int i) {
        this.tagName = str;
        this.occurrence = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(TagOccurrence tagOccurrence) {
        return tagOccurrence.getOccurrence() - getOccurrence();
    }

    public int getOccurrence() {
        return this.occurrence;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void incOccurence() {
        this.occurrence++;
    }
}
