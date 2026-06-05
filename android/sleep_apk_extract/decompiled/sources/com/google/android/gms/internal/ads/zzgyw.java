package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgyw {
    public static zzgyv zza(Set set, Set set2) {
        zzgtj.zzk(set, "set1");
        zzgtj.zzk(set2, "set2");
        return new zzgyr(set, set2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Set zzb(Set set, zzgtk zzgtkVar) {
        if (set instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) set;
            if (!(sortedSet instanceof zzgys)) {
                return new zzgyt(sortedSet, zzgtkVar);
            }
            zzgys zzgysVar = (zzgys) sortedSet;
            return new zzgyt((SortedSet) zzgysVar.zza, zzgtn.zzb(zzgysVar.zzb, zzgtkVar));
        }
        if (!(set instanceof zzgys)) {
            set.getClass();
            return new zzgys(set, zzgtkVar);
        }
        zzgys zzgysVar2 = (zzgys) set;
        return new zzgys((Set) zzgysVar2.zza, zzgtn.zzb(zzgysVar2.zzb, zzgtkVar));
    }

    public static int zzc(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static boolean zzd(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean zze(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    public static boolean zzf(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzgyd) {
            collection = ((zzgyd) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zze(set, collection.iterator());
        }
        Iterator it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
