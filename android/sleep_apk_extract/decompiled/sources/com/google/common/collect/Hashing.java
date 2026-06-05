package com.google.common.collect;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
abstract class Hashing {
    public static int smear(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static int smearedHash(@CheckForNull Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
