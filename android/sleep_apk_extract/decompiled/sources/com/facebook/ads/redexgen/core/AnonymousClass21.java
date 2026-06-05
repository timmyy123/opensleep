package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.21, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass21 {
    public static String[] A02 = {"ldLt7Twnv3B7KUI0Ilt0EdHHn77Qhign", "kd1rakMki2zmKhQ", "HVn8QFF1K6iTD0hJ0RaSWmMMLwU9Qt3O", "lH7qRM6AdNX9", "AM83Z8btvw3SuqGtiKSkY6vTX", "2HQ9THQlxaSsRJLEMXyqG3P4roslQgZv", "TC2I2mgRjWVcD4ZdWmeiP13Fm", "xcO"};
    public final float A00;
    public final int A01;

    public AnonymousClass21(int i, float f) {
        this.A01 = i;
        this.A00 = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (A02[5].charAt(5) == 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "I06pAxPjKvEkBpORKzCyZVvNnfHT6Ife";
        strArr[0] = "4aBlntKTp4ZZaeZTKwlwh44AwX56wdFL";
        AnonymousClass21 anonymousClass21 = (AnonymousClass21) obj;
        if (this.A01 == anonymousClass21.A01 && Float.compare(anonymousClass21.A00, this.A00) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A01;
        return (((17 * 31) + result) * 31) + Float.floatToIntBits(this.A00);
    }
}
