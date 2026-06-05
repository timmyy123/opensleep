package org.mp4parser.tools;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Mp4Math {
    public static long gcd(long j, long j2) {
        while (true) {
            long j3 = j2;
            long j4 = j;
            j = j3;
            if (j <= 0) {
                return j4;
            }
            j2 = j4 % j;
        }
    }

    public static long lcm(long j, long j2) {
        return (j2 / gcd(j, j2)) * j;
    }
}
