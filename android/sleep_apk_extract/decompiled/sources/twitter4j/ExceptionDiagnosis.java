package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
final class ExceptionDiagnosis implements Serializable {
    private static final long serialVersionUID = 8501009773274399369L;
    private String hexString = "";
    private int lineNumberHash;
    private int stackLineHash;

    public ExceptionDiagnosis(Throwable th, String[] strArr) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        this.stackLineHash = 0;
        this.lineNumberHash = 0;
        for (int length = stackTrace.length - 1; length >= 0; length--) {
            StackTraceElement stackTraceElement = stackTrace[length];
            int length2 = strArr.length;
            int i = 0;
            while (true) {
                if (i < length2) {
                    if (stackTraceElement.getClassName().startsWith(strArr[i])) {
                        this.stackLineHash = (this.stackLineHash * 31) + stackTraceElement.getMethodName().hashCode() + stackTraceElement.getClassName().hashCode();
                        this.lineNumberHash = stackTraceElement.getLineNumber() + (this.lineNumberHash * 31);
                        break;
                    }
                    i++;
                }
            }
        }
        this.hexString += toHexString(this.stackLineHash) + "-" + toHexString(this.lineNumberHash);
        if (th.getCause() != null) {
            this.hexString += " " + new ExceptionDiagnosis(th.getCause(), strArr).asHexString();
        }
    }

    private String toHexString(int i) {
        String str = "0000000" + Integer.toHexString(i);
        return str.substring(str.length() - 8, str.length());
    }

    public String asHexString() {
        return this.hexString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ExceptionDiagnosis.class != obj.getClass()) {
            return false;
        }
        ExceptionDiagnosis exceptionDiagnosis = (ExceptionDiagnosis) obj;
        return this.lineNumberHash == exceptionDiagnosis.lineNumberHash && this.stackLineHash == exceptionDiagnosis.stackLineHash;
    }

    public String getLineNumberHashAsHex() {
        return toHexString(this.lineNumberHash);
    }

    public String getStackLineHashAsHex() {
        return toHexString(this.stackLineHash);
    }

    public int hashCode() {
        return (this.stackLineHash * 31) + this.lineNumberHash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ExceptionDiagnosis{stackLineHash=");
        sb.append(this.stackLineHash);
        sb.append(", lineNumberHash=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.lineNumberHash, '}');
    }
}
