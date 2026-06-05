package com.philips.lighting.model;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeResource {
    private String identifier;
    private String name;

    public PHBridgeResource(String str, String str2) {
        this.name = str;
        this.identifier = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHBridgeResource pHBridgeResource = (PHBridgeResource) obj;
        String str = this.identifier;
        String str2 = pHBridgeResource.identifier;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.name;
        String str4 = pHBridgeResource.name;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        return true;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.name;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
