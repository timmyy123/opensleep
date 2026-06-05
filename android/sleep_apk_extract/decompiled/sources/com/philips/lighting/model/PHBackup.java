package com.philips.lighting.model;

/* JADX INFO: loaded from: classes4.dex */
public class PHBackup {
    private Integer errorCode;
    private PHBackupStatus status;

    public enum PHBackupStatus {
        IDLE,
        STARTMIGRATION,
        FILEREADY_DISABLED,
        PREPARE_RESTORE,
        RESTORING;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHBackupStatus[] valuesCustom() {
            PHBackupStatus[] pHBackupStatusArrValuesCustom = values();
            int length = pHBackupStatusArrValuesCustom.length;
            PHBackupStatus[] pHBackupStatusArr = new PHBackupStatus[length];
            System.arraycopy(pHBackupStatusArrValuesCustom, 0, pHBackupStatusArr, 0, length);
            return pHBackupStatusArr;
        }
    }

    public static PHBackupStatus getBackupStatus(String str) {
        if (str != null && !str.isEmpty()) {
            if (str.equalsIgnoreCase("idle")) {
                return PHBackupStatus.IDLE;
            }
            if (str.equalsIgnoreCase("startmigration")) {
                return PHBackupStatus.STARTMIGRATION;
            }
            if (str.equalsIgnoreCase("fileready_disabled")) {
                return PHBackupStatus.FILEREADY_DISABLED;
            }
            if (str.equalsIgnoreCase("prepare_restore")) {
                return PHBackupStatus.PREPARE_RESTORE;
            }
            if (str.equalsIgnoreCase("restoring")) {
                return PHBackupStatus.RESTORING;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHBackup pHBackup = (PHBackup) obj;
        Integer num = this.errorCode;
        Integer num2 = pHBackup.errorCode;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        return this.status == pHBackup.status;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public PHBackupStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        Integer num = this.errorCode;
        int iHashCode = ((num == null ? 0 : num.hashCode()) + 31) * 31;
        PHBackupStatus pHBackupStatus = this.status;
        return iHashCode + (pHBackupStatus != null ? pHBackupStatus.hashCode() : 0);
    }

    public void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public void setStatus(PHBackupStatus pHBackupStatus) {
        this.status = pHBackupStatus;
    }
}
