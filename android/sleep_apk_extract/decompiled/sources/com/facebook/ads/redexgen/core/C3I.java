package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C3I {
    public static String[] A02 = {"jcH3QedMT4AOuWF0dI0CUNmRbWatFwqc", "BukjA5q92pLRFUvfe5dIWww2QfAyf027", "2uAc", "VCNYtziwo5GFVqBfG9UtgC4", "uqwM7jU8RkmJgjVhRwxT6hUUHIdkl0iL", "Q65tZvOlW8keeJKkiK5GhNEs1Q8ndQa2", "6cXZOFD424WlVLtANVdUhxfL6A7UpvYs", "6V4zSnW4jXU8inGpzvmCFDVdVI7aZE3z"};
    public final int A00;
    public final int A01;

    public C3I(int i, int i2) {
        this.A01 = i;
        this.A00 = i2;
    }

    public final int A00() {
        switch (this.A00) {
            case 2:
                return 10;
            case 5:
                return 11;
            case 22:
                return 1073741824;
            case 23:
                if (A02[1].charAt(3) != 'j') {
                    throw new RuntimeException();
                }
                A02[2] = "G1vh";
                return 15;
            case 29:
                return 12;
            case 42:
                return 16;
            default:
                return 0;
        }
    }
}
