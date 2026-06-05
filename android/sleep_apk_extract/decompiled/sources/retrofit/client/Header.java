package retrofit.client;

/* JADX INFO: loaded from: classes5.dex */
public final class Header {
    private final String name;
    private final String value;

    public Header(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Header.class != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        String str = this.name;
        String str2 = header.name;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.value;
        String str4 = header.value;
        return str3 == null ? str4 == null : str3.equals(str4);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.name;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(": ");
        String str2 = this.value;
        sb.append(str2 != null ? str2 : "");
        return sb.toString();
    }
}
