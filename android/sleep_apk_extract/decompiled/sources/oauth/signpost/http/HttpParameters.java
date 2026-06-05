package oauth.signpost.http;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes5.dex */
public class HttpParameters implements Map<String, SortedSet<String>>, Serializable {
    private TreeMap<String, SortedSet<String>> wrappedMap = new TreeMap<>();

    @Override // java.util.Map
    public void clear() {
        this.wrappedMap.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.wrappedMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Iterator<SortedSet<String>> it = this.wrappedMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, SortedSet<String>>> entrySet() {
        return this.wrappedMap.entrySet();
    }

    @Override // java.util.Map
    public SortedSet<String> get(Object obj) {
        return this.wrappedMap.get(obj);
    }

    public String getAsHeaderElement(String str) {
        String first = getFirst(str);
        if (first == null) {
            return null;
        }
        return FileInsert$$ExternalSyntheticOutline0.m(str, "=\"", first, "\"");
    }

    public String getAsQueryString(Object obj) {
        StringBuilder sb = new StringBuilder();
        String strPercentEncode = OAuth.percentEncode((String) obj);
        SortedSet<String> sortedSet = this.wrappedMap.get(strPercentEncode);
        if (sortedSet == null) {
            return ((Object) strPercentEncode) + "=";
        }
        Iterator<String> it = sortedSet.iterator();
        while (it.hasNext()) {
            sb.append(((Object) strPercentEncode) + "=" + it.next());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public String getFirst(Object obj, boolean z) {
        SortedSet<String> sortedSet = this.wrappedMap.get(obj);
        if (sortedSet == null || sortedSet.isEmpty()) {
            return null;
        }
        String strFirst = sortedSet.first();
        return z ? OAuth.percentDecode(strFirst) : strFirst;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.wrappedMap.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.wrappedMap.keySet();
    }

    public SortedSet<String> put(String str, SortedSet<String> sortedSet, boolean z) {
        if (!z) {
            return this.wrappedMap.put(str, sortedSet);
        }
        remove((Object) str);
        Iterator<String> it = sortedSet.iterator();
        while (it.hasNext()) {
            put(str, it.next(), true);
        }
        return get((Object) str);
    }

    public void putAll(Map<? extends String, ? extends SortedSet<String>> map, boolean z) {
        if (!z) {
            this.wrappedMap.putAll(map);
            return;
        }
        for (String str : map.keySet()) {
            put(str, map.get(str), true);
        }
    }

    public void putMap(Map<String, List<String>> map) {
        for (String str : map.keySet()) {
            SortedSet<String> treeSet = get((Object) str);
            if (treeSet == null) {
                treeSet = new TreeSet<>();
                put(str, treeSet);
            }
            treeSet.addAll(map.get(str));
        }
    }

    public String putNull(String str, String str2) {
        return put(str, str2);
    }

    @Override // java.util.Map
    public SortedSet<String> remove(Object obj) {
        return this.wrappedMap.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        Iterator<String> it = this.wrappedMap.keySet().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += this.wrappedMap.get(it.next()).size();
        }
        return size;
    }

    @Override // java.util.Map
    public Collection<SortedSet<String>> values() {
        return this.wrappedMap.values();
    }

    public String getFirst(Object obj) {
        return getFirst(obj, false);
    }

    @Override // java.util.Map
    public SortedSet<String> put(String str, SortedSet<String> sortedSet) {
        return this.wrappedMap.put(str, sortedSet);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends SortedSet<String>> map) {
        this.wrappedMap.putAll(map);
    }

    public void putAll(String[] strArr, boolean z) {
        for (int i = 0; i < strArr.length - 1; i += 2) {
            put(strArr[i], strArr[i + 1], z);
        }
    }

    public String put(String str, String str2) {
        return put(str, str2, false);
    }

    public String put(String str, String str2, boolean z) {
        SortedSet<String> treeSet = this.wrappedMap.get(str);
        if (treeSet == null) {
            treeSet = new TreeSet<>();
            TreeMap<String, SortedSet<String>> treeMap = this.wrappedMap;
            if (z) {
                str = OAuth.percentEncode(str);
            }
            treeMap.put(str, treeSet);
        }
        if (str2 != null) {
            if (z) {
                str2 = OAuth.percentEncode(str2);
            }
            treeSet.add(str2);
        }
        return str2;
    }
}
