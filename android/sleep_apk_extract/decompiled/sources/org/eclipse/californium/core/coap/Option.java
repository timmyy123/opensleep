package org.eclipse.californium.core.coap;

import java.util.Arrays;
import org.eclipse.californium.core.coap.OptionNumberRegistry;
import org.eclipse.californium.elements.util.Bytes;

/* JADX INFO: loaded from: classes5.dex */
public class Option implements Comparable<Option> {
    private int number;
    private byte[] value;

    /* JADX INFO: renamed from: org.eclipse.californium.core.coap.Option$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$core$coap$OptionNumberRegistry$optionFormats;

        static {
            int[] iArr = new int[OptionNumberRegistry.optionFormats.values().length];
            $SwitchMap$org$eclipse$californium$core$coap$OptionNumberRegistry$optionFormats = iArr;
            try {
                iArr[OptionNumberRegistry.optionFormats.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$core$coap$OptionNumberRegistry$optionFormats[OptionNumberRegistry.optionFormats.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Option(int i) {
        this.number = i;
        this.value = Bytes.EMPTY;
    }

    private String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("0x");
        for (byte b : bArr) {
            sb.append(String.format("%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Option)) {
            return false;
        }
        Option option = (Option) obj;
        return this.number == option.number && Arrays.equals(this.value, option.value);
    }

    public int getIntegerValue() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.value;
            if (i >= bArr.length) {
                return i2;
            }
            i2 += (bArr[(bArr.length - i) - 1] & 255) << (i * 8);
            i++;
        }
    }

    public long getLongValue() {
        long j = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.value;
            if (i >= bArr.length) {
                return j;
            }
            j += ((long) (bArr[(bArr.length - i) - 1] & 255)) << (i * 8);
            i++;
        }
    }

    public int getNumber() {
        return this.number;
    }

    public String getStringValue() {
        return new String(this.value, CoAP.UTF8_CHARSET);
    }

    public byte[] getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + (this.number * 31);
    }

    public void setIntegerValue(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4 && (i >= (1 << (i3 * 8)) || i < 0); i3++) {
            i2++;
        }
        this.value = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            this.value[(i2 - i4) - 1] = (byte) (i >> (i4 * 8));
        }
    }

    public void setLongValue(long j) {
        int i = 0;
        for (int i2 = 0; i2 < 8 && (j >= (1 << (i2 * 8)) || j < 0); i2++) {
            i++;
        }
        this.value = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            this.value[(i - i3) - 1] = (byte) (j >> (i3 * 8));
        }
    }

    public void setStringValue(String str) {
        str.getClass();
        this.value = str.getBytes(CoAP.UTF8_CHARSET);
    }

    public void setValue(byte[] bArr) {
        bArr.getClass();
        this.value = bArr;
    }

    public String toString() {
        return OptionNumberRegistry.toString(this.number) + ": " + toValueString();
    }

    public String toValueString() {
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$core$coap$OptionNumberRegistry$optionFormats[OptionNumberRegistry.getFormatByNr(this.number).ordinal()];
        if (i != 1) {
            if (i != 2) {
                return toHexString(getValue());
            }
            return "\"" + getStringValue() + "\"";
        }
        int i2 = this.number;
        if (i2 == 17 || i2 == 12) {
            return "\"" + MediaTypeRegistry.toString(getIntegerValue()) + "\"";
        }
        if (i2 != 27 && i2 != 23) {
            return Integer.toString(getIntegerValue());
        }
        return "\"" + new BlockOption(this.value) + "\"";
    }

    @Override // java.lang.Comparable
    public int compareTo(Option option) {
        return this.number - option.number;
    }

    public Option(int i, String str) {
        this.number = i;
        setStringValue(str);
    }

    public Option(int i, int i2) {
        this.number = i;
        setIntegerValue(i2);
    }

    public Option(int i, long j) {
        this.number = i;
        setLongValue(j);
    }

    public Option(int i, byte[] bArr) {
        this.number = i;
        setValue(bArr);
    }
}
