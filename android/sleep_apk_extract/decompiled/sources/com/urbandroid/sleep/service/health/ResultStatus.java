package com.urbandroid.sleep.service.health;

/* JADX INFO: loaded from: classes5.dex */
public interface ResultStatus {
    public static final ResultStatus SUCCESS = new ResultStatus() { // from class: com.urbandroid.sleep.service.health.ResultStatus.1
        @Override // com.urbandroid.sleep.service.health.ResultStatus
        public boolean isSuccess() {
            return true;
        }

        public String toString() {
            return "SUCCESS";
        }
    };
    public static final ResultStatus NO_RECORDS = new ResultStatus() { // from class: com.urbandroid.sleep.service.health.ResultStatus.2
        @Override // com.urbandroid.sleep.service.health.ResultStatus
        public boolean isSuccess() {
            return true;
        }

        public String toString() {
            return "NO RECORDS";
        }
    };
    public static final ResultStatus ALREADY_STORED = new ResultStatus() { // from class: com.urbandroid.sleep.service.health.ResultStatus.3
        @Override // com.urbandroid.sleep.service.health.ResultStatus
        public boolean isSuccess() {
            return true;
        }

        public String toString() {
            return "ALREADY STORED";
        }
    };
    public static final ResultStatus FAILURE = new ResultStatus() { // from class: com.urbandroid.sleep.service.health.ResultStatus.4
        @Override // com.urbandroid.sleep.service.health.ResultStatus
        public boolean isSuccess() {
            return false;
        }

        public String toString() {
            return "FAILURE";
        }
    };

    boolean isSuccess();
}
