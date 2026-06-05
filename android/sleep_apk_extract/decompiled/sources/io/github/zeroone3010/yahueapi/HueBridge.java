package io.github.zeroone3010.yahueapi;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class HueBridge {
    private final String ip;
    private final String mac;
    private final String name;

    public HueBridge(String str, String str2, String str3) {
        this.ip = str;
        this.name = str2;
        this.mac = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(getIp(), ((HueBridge) obj).getIp());
    }

    public String getIp() {
        return this.ip;
    }

    public String getMac() {
        return this.mac;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hash(getIp());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HueBridge{name='");
        sb.append(this.name);
        sb.append("', ip='");
        sb.append(this.ip);
        sb.append("', mac='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.mac, "'}");
    }

    public HueBridge(String str) {
        this(str, str, null);
    }
}
