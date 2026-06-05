package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1932pU {
    public static String[] A00 = {"WYbfQWuNAjMhMignGLPBKOO7t37dd6pm", "aU7tMP21nVkp4lxoHIMaaJjXF", "KfRhaqKZcjkewaNyxSPNTetlEHftSMTF", "LloEdWhimr4Sj9kwGGxmGk8", "ZUp1YfD37WiDDWuGnJxBVJeZNuRjo", "b9uampRf3yYNP3BKa", "TYkujE9wMI8l0e1bGcChqn19YW9nXTi", "MiH9fLUFy6MgEc5RrTOKVqlzeB7MpQo7"};

    public static int A00(@CheckForNull List<?> list, Object element) {
        if (list instanceof RandomAccess) {
            return A02(list, element);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (CB.A01(element, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int A01(@CheckForNull List<?> list, Object element) {
        if (list instanceof RandomAccess) {
            return A03(list, element);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (CB.A01(element, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int A02(@CheckForNull List<?> list, Object element) {
        int size = list.size();
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) == null) {
                    return i;
                }
            }
            return -1;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (element.equals(list.get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public static int A03(@CheckForNull List<?> list, Object element) {
        if (element == null) {
            int size = list.size();
            if (A00[2].charAt(2) == 'd') {
                throw new RuntimeException();
            }
            A00[6] = "sSXsk6OcN1QGC";
            for (int i = size - 1; i >= 0; i--) {
                if (list.get(i) == null) {
                    return i;
                }
            }
            return -1;
        }
        int i2 = list.size();
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (element.equals(list.get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> A04() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> A05(Iterator<? extends E> elements) {
        ArrayList<E> list = A04();
        AbstractC1911p9.A0A(list, elements);
        return list;
    }

    public static boolean A06(@CheckForNull List<?> thisList, Object other) {
        if (other == AbstractC1651ki.A04(thisList)) {
            return true;
        }
        if (!(other instanceof List)) {
            return false;
        }
        List list = (List) other;
        int size = thisList.size();
        if (size != list.size()) {
            return false;
        }
        boolean z = thisList instanceof RandomAccess;
        if (A00[7].charAt(4) == 'F') {
            throw new RuntimeException();
        }
        A00[0] = "rcHl15RocZyTXvjAlguJbKcz1P7sPU36";
        if (z && (list instanceof RandomAccess)) {
            for (int i = 0; i < size; i++) {
                if (!CB.A01(thisList.get(i), list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return AbstractC1911p9.A0F(thisList.iterator(), list.iterator());
    }
}
