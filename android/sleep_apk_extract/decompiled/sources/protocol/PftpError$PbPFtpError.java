package protocol;

import com.google.home.platform.traits.ValidationIssue;
import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum PftpError$PbPFtpError implements Internal.EnumLite {
    OPERATION_SUCCEEDED(0),
    REBOOTING(1),
    TRY_AGAIN(2),
    UNIDENTIFIED_HOST_ERROR(100),
    INVALID_COMMAND(101),
    INVALID_PARAMETER(102),
    NO_SUCH_FILE_OR_DIRECTORY(103),
    DIRECTORY_EXISTS(104),
    FILE_EXISTS(105),
    OPERATION_NOT_PERMITTED(106),
    NO_SUCH_USER(107),
    TIMEOUT(108),
    UNIDENTIFIED_DEVICE_ERROR(200),
    NOT_IMPLEMENTED(ValidationIssue.INVALID_ENTITY_FIELD_NUMBER),
    SYSTEM_BUSY(ValidationIssue.UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER),
    INVALID_CONTENT(ValidationIssue.UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER),
    CHECKSUM_FAILURE(ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER),
    DISK_FULL(ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_FIELD_NUMBER),
    PREREQUISITE_NOT_MET(ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER),
    INSUFFICIENT_BUFFER(ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER),
    WAIT_FOR_IDLING(208),
    BATTERY_TOO_LOW(209);

    private static final Internal.EnumLiteMap<PftpError$PbPFtpError> internalValueMap = new Internal.EnumLiteMap<PftpError$PbPFtpError>() { // from class: protocol.PftpError$PbPFtpError.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public PftpError$PbPFtpError findValueByNumber(int i) {
            return PftpError$PbPFtpError.forNumber(i);
        }
    };
    private final int value;

    PftpError$PbPFtpError(int i) {
        this.value = i;
    }

    public static PftpError$PbPFtpError forNumber(int i) {
        if (i == 0) {
            return OPERATION_SUCCEEDED;
        }
        if (i == 1) {
            return REBOOTING;
        }
        if (i == 2) {
            return TRY_AGAIN;
        }
        switch (i) {
            case 100:
                return UNIDENTIFIED_HOST_ERROR;
            case 101:
                return INVALID_COMMAND;
            case 102:
                return INVALID_PARAMETER;
            case 103:
                return NO_SUCH_FILE_OR_DIRECTORY;
            case 104:
                return DIRECTORY_EXISTS;
            case 105:
                return FILE_EXISTS;
            case 106:
                return OPERATION_NOT_PERMITTED;
            case 107:
                return NO_SUCH_USER;
            case 108:
                return TIMEOUT;
            default:
                switch (i) {
                    case 200:
                        return UNIDENTIFIED_DEVICE_ERROR;
                    case ValidationIssue.INVALID_ENTITY_FIELD_NUMBER /* 201 */:
                        return NOT_IMPLEMENTED;
                    case ValidationIssue.UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER /* 202 */:
                        return SYSTEM_BUSY;
                    case ValidationIssue.UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER /* 203 */:
                        return INVALID_CONTENT;
                    case ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER /* 204 */:
                        return CHECKSUM_FAILURE;
                    case ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_FIELD_NUMBER /* 205 */:
                        return DISK_FULL;
                    case ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER /* 206 */:
                        return PREREQUISITE_NOT_MET;
                    case ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER /* 207 */:
                        return INSUFFICIENT_BUFFER;
                    case 208:
                        return WAIT_FOR_IDLING;
                    case 209:
                        return BATTERY_TOO_LOW;
                    default:
                        return null;
                }
        }
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
