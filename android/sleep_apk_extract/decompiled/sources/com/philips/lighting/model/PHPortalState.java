package com.philips.lighting.model;

/* JADX INFO: loaded from: classes4.dex */
public class PHPortalState {
    private PHPortalCommunicationState communication;
    private Boolean incoming;
    private Boolean outgoing;
    private Boolean signedOn;

    public enum PHPortalCommunicationState {
        CONNECTING,
        CONNECTED,
        DISCONNECTED;

        public static PHPortalCommunicationState getCommunicationState(String str) {
            if (str != null && !str.isEmpty()) {
                if (str.equalsIgnoreCase("connected")) {
                    return CONNECTED;
                }
                if (str.equalsIgnoreCase("disconnected")) {
                    return DISCONNECTED;
                }
                if (str.equalsIgnoreCase("connecting")) {
                    return CONNECTING;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHPortalCommunicationState[] valuesCustom() {
            PHPortalCommunicationState[] pHPortalCommunicationStateArrValuesCustom = values();
            int length = pHPortalCommunicationStateArrValuesCustom.length;
            PHPortalCommunicationState[] pHPortalCommunicationStateArr = new PHPortalCommunicationState[length];
            System.arraycopy(pHPortalCommunicationStateArrValuesCustom, 0, pHPortalCommunicationStateArr, 0, length);
            return pHPortalCommunicationStateArr;
        }
    }

    public PHPortalState(Boolean bool, Boolean bool2, Boolean bool3, PHPortalCommunicationState pHPortalCommunicationState) {
        this.signedOn = bool;
        this.incoming = bool2;
        this.outgoing = bool3;
        this.communication = pHPortalCommunicationState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHPortalState pHPortalState = (PHPortalState) obj;
        if (this.communication != pHPortalState.communication) {
            return false;
        }
        Boolean bool = this.incoming;
        Boolean bool2 = pHPortalState.incoming;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        Boolean bool3 = this.outgoing;
        Boolean bool4 = pHPortalState.outgoing;
        if (bool3 == null) {
            if (bool4 != null) {
                return false;
            }
        } else if (!bool3.equals(bool4)) {
            return false;
        }
        Boolean bool5 = this.signedOn;
        Boolean bool6 = pHPortalState.signedOn;
        if (bool5 == null) {
            if (bool6 != null) {
                return false;
            }
        } else if (!bool5.equals(bool6)) {
            return false;
        }
        return true;
    }

    public PHPortalCommunicationState getCommunication() {
        return this.communication;
    }

    public Boolean getIncoming() {
        return this.incoming;
    }

    public Boolean getOutgoing() {
        return this.outgoing;
    }

    public Boolean getSignedOn() {
        return this.signedOn;
    }

    public int hashCode() {
        PHPortalCommunicationState pHPortalCommunicationState = this.communication;
        int iHashCode = ((pHPortalCommunicationState == null ? 0 : pHPortalCommunicationState.hashCode()) + 31) * 31;
        Boolean bool = this.incoming;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.outgoing;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.signedOn;
        return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public void setCommunication(PHPortalCommunicationState pHPortalCommunicationState) {
        this.communication = pHPortalCommunicationState;
    }

    public void setIncoming(Boolean bool) {
        this.incoming = bool;
    }

    public void setOutgoing(Boolean bool) {
        this.outgoing = bool;
    }

    public void setSignedOn(Boolean bool) {
        this.signedOn = bool;
    }

    public PHPortalState() {
    }
}
