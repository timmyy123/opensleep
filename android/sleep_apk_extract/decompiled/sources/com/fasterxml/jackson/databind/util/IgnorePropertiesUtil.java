package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IgnorePropertiesUtil {

    public static final class Checker implements Serializable {
        private static final long serialVersionUID = 1;
        private final Set<String> _toIgnore;
        private final Set<String> _toInclude;

        private Checker(Set<String> set, Set<String> set2) {
            this._toIgnore = set == null ? Collections.EMPTY_SET : set;
            this._toInclude = set2;
        }

        public static Checker construct(Set<String> set, Set<String> set2) {
            return new Checker(set, set2);
        }

        public boolean shouldIgnore(Object obj) {
            Set<String> set = this._toInclude;
            return !(set == null || set.contains(obj)) || this._toIgnore.contains(obj);
        }
    }

    public static Checker buildCheckerIfNeeded(Set<String> set, Set<String> set2) {
        if (set2 == null && (set == null || set.isEmpty())) {
            return null;
        }
        return Checker.construct(set, set2);
    }

    public static Set<String> combineNamesToInclude(Set<String> set, Set<String> set2) {
        if (set == null) {
            return set2;
        }
        if (set2 == null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        for (String str : set2) {
            if (set.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public static boolean shouldIgnore(Object obj, Collection<String> collection, Collection<String> collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        return collection2 == null ? collection.contains(obj) : collection == null ? !collection2.contains(obj) : !collection2.contains(obj) || collection.contains(obj);
    }
}
