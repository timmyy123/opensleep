package io.github.zeroone3010.yahueapi.v2.domain;

/* JADX INFO: loaded from: classes5.dex */
public class ApiInitializationError {
    private String address;
    private String description;
    private int type;

    public String getAddress() {
        return this.address;
    }

    public String getDescription() {
        return this.description;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
