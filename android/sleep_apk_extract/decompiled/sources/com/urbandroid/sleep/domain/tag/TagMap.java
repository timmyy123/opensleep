package com.urbandroid.sleep.domain.tag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class TagMap {
    private HashMap<String, TagOccurrence> map = new HashMap<>();

    public List<String> getSorted() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.map.values());
        ArrayList arrayList2 = new ArrayList();
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((TagOccurrence) it.next()).getTagName());
        }
        return arrayList2;
    }

    public List<String> getSortedWithBuildIn() {
        List<String> sorted = getSorted();
        for (Tag tag : Tag.values()) {
            if (!sorted.contains(tag.getTagName())) {
                sorted.add(tag.getTagName());
            }
        }
        return sorted;
    }

    public void putTags(Set<String> set) {
        for (String str : set) {
            TagOccurrence tagOccurrence = this.map.get(str);
            if (tagOccurrence == null) {
                tagOccurrence = new TagOccurrence(str, 0);
                this.map.put(str, tagOccurrence);
            }
            tagOccurrence.incOccurence();
        }
    }
}
