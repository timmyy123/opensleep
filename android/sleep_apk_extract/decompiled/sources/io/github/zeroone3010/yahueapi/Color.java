package io.github.zeroone3010.yahueapi;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class Color {
    private final float blue;
    private final float green;
    private final float red;

    public Color(float f, float f2, float f3) {
        if (Stream.of((Object[]) new Float[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}).anyMatch(new Color$$ExternalSyntheticLambda1(3))) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Color value out of range");
            throw null;
        }
        this.red = f;
        this.green = f2;
        this.blue = f3;
    }

    private static Optional<Method> findMethod(Object obj, final String str, final String str2) {
        return ((Stream) Arrays.stream(obj.getClass().getMethods()).sequential()).filter(new Predicate() { // from class: io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda6
            @Override // java.util.function.Predicate
            public final boolean test(Object obj2) {
                return Color.lambda$findMethod$6(str, str2, (Method) obj2);
            }
        }).findFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findMethod$6(String str, String str2, Method method) {
        return str.equals(method.getName()) || str2.equals(method.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Float f) {
        return !MathUtil.isInRange(f, 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$of$1(String str) {
        return str.replaceAll("[# ]", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$of$2(String str) {
        return str.length() == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$of$3(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str, 16));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Color lambda$of$4(Integer num) {
        return of(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalArgumentException lambda$of$5(String str) {
        return new IllegalArgumentException(FileInsert$$ExternalSyntheticOutline0.m("'", str, "' could not be parsed as a color"));
    }

    public static Color of(Object obj) {
        if (obj == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("null cannot be parsed as a color.");
            return null;
        }
        Optional<Method> optionalFindMethod = findMethod(obj, "red", "getRed");
        Optional<Method> optionalFindMethod2 = findMethod(obj, "green", "getGreen");
        Optional<Method> optionalFindMethod3 = findMethod(obj, "blue", "getBlue");
        if (!optionalFindMethod.isPresent() || !optionalFindMethod2.isPresent() || !optionalFindMethod3.isPresent()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The given object cannot be parsed as a color.");
            return null;
        }
        Class<?> returnType = optionalFindMethod.get().getReturnType();
        if (!returnType.equals(optionalFindMethod3.get().getReturnType()) || !returnType.equals(optionalFindMethod2.get().getReturnType())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The given object cannot be parsed as a color: mismatching getter method return types.");
            return null;
        }
        try {
            Number number = (Number) optionalFindMethod.get().invoke(obj, null);
            Number number2 = (Number) optionalFindMethod2.get().invoke(obj, null);
            Number number3 = (Number) optionalFindMethod3.get().invoke(obj, null);
            if (number instanceof Integer) {
                return of(number.intValue(), number2.intValue(), number3.intValue());
            }
            if (!(number instanceof Double) && !(number instanceof Float)) {
                return null;
            }
            return of(number.floatValue(), number2.floatValue(), number3.floatValue());
        } catch (Exception e) {
            throw new IllegalArgumentException("The given object cannot be parsed as a color.", e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Color.class == obj.getClass()) {
            Color color = (Color) obj;
            if (Float.compare(color.red, this.red) == 0 && Float.compare(color.green, this.green) == 0 && Float.compare(color.blue, this.blue) == 0) {
                return true;
            }
        }
        return false;
    }

    public float getBlue() {
        return this.blue;
    }

    public float getGreen() {
        return this.green;
    }

    public float getRed() {
        return this.red;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.red), Float.valueOf(this.green), Float.valueOf(this.blue));
    }

    public String toString() {
        return "Color{red=" + this.red + ", green=" + this.green + ", blue=" + this.blue + '}';
    }

    private Color(int i) {
        this(((16711680 & i) >> 16) / 255.0f, ((65280 & i) >> 8) / 255.0f, (i & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f);
    }

    public static Color of(int i, int i2, int i3) {
        return new Color(i / 255.0f, i2 / 255.0f, i3 / 255.0f);
    }

    public static Color of(int i) {
        return new Color(i & 16777215);
    }

    public static Color of(Integer num) {
        if (num != null) {
            return of(num.intValue() & 16777215);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Null is not an acceptable color value.");
        return null;
    }

    public static Color of(String str) {
        int i = 0;
        return (Color) Optional.ofNullable(str).map(new Color$$ExternalSyntheticLambda0(i)).filter(new Color$$ExternalSyntheticLambda1(i)).map(new Color$$ExternalSyntheticLambda0(6)).map(new Color$$ExternalSyntheticLambda0(7)).orElseThrow(new Color$$ExternalSyntheticLambda4(str, 0));
    }

    public static Color of(float f, float f2, float f3) {
        return new Color(f, f2, f3);
    }
}
