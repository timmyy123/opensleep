package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes3.dex */
public final class ValidationIssue extends zzzg<ValidationIssue, Builder> implements zzaar {
    public static final int AUTOMATION_TOO_LARGE_FIELD_NUMBER = 402;
    public static final int BLOCKED_ACTION_FIELD_NUMBER = 301;
    public static final int CONDITION_DURATION_OUT_OF_RANGE_FIELD_NUMBER = 32;
    private static final ValidationIssue DEFAULT_INSTANCE;
    public static final int DELAY_DURATION_OUT_OF_RANGE_FIELD_NUMBER = 16;
    public static final int DUPLICATE_STARTER_NODE_FIELD_NUMBER = 23;
    public static final int INVALID_ARGUMENTS_FOR_OPERATOR_FIELD_NUMBER = 102;
    public static final int INVALID_ARGUMENT_COUNT_FIELD_NUMBER = 11;
    public static final int INVALID_COMMAND_FIELD_NUMBER = 14;
    public static final int INVALID_CONDITION_TYPE_FIELD_NUMBER = 106;
    public static final int INVALID_DURATION_FIELD_NUMBER = 26;
    public static final int INVALID_ENTITY_FIELD_NUMBER = 201;
    public static final int INVALID_EVENT_FIELD_NUMBER = 13;
    public static final int INVALID_FIELD_FIELD_NUMBER = 105;
    public static final int INVALID_NULL_PARAMETER_VALUE_FIELD_NUMBER = 107;
    public static final int INVALID_OPERAND_FIELD_NUMBER = 30;
    public static final int INVALID_PARAMETER_FIELD_NUMBER = 15;
    public static final int INVALID_PARAMETER_TYPE_FIELD_NUMBER = 104;
    public static final int INVALID_REFERENCE_FIELD_NUMBER = 103;
    public static final int INVALID_TRAIT_FIELD_NUMBER = 12;
    public static final int INVALID_VALUE_FIELD_NUMBER = 25;
    public static final int MISPLACED_SELECT_FLOW_FIELD_NUMBER = 22;
    public static final int MISPLACED_STARTER_NODE_FIELD_NUMBER = 20;
    public static final int MISSING_REQUIRED_FIELDS_FIELD_NUMBER = 1;
    public static final int MISSING_REQUIRED_PARAMETERS_FIELD_NUMBER = 18;
    public static final int MISSING_STARTER_NODE_FIELD_NUMBER = 2;
    public static final int MISSING_TRAILING_ACTION_NODE_FIELD_NUMBER = 4;
    public static final int MULTIPLE_MANUAL_STARTERS_FIELD_NUMBER = 24;
    public static final int MULTIPLE_SELECT_FLOWS_FIELD_NUMBER = 21;
    public static final int OUTPUT_NOT_ACCESSIBLE_FIELD_NUMBER = 29;
    public static final int OUTPUT_REINITIALIZED_FIELD_NUMBER = 33;
    public static final int OUTPUT_TYPE_MISMATCH_FIELD_NUMBER = 28;
    private static volatile zzaay<ValidationIssue> PARSER = null;
    public static final int READ_ONLY_ATTRIBUTE_FIELD_NUMBER = 17;
    public static final int SUPPRESSION_DURATION_OUT_OF_RANGE_FIELD_NUMBER = 27;
    public static final int TOO_MANY_NODES_FIELD_NUMBER = 401;
    public static final int TOO_MANY_OPERATIONS_FIELD_NUMBER = 403;
    public static final int UNSUBSCRIBABLE_ATTRIBUTE_FIELD_NUMBER = 19;
    public static final int UNSUPPORTED_ACTION_BEHAVIOR_FIELD_NUMBER = 8;
    public static final int UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER = 204;
    public static final int UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER = 203;
    public static final int UNSUPPORTED_ENTITY_PARAMETER_FIELD_NUMBER = 205;
    public static final int UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER = 206;
    public static final int UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER = 202;
    public static final int UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER = 207;
    public static final int UNSUPPORTED_NODE_OUTPUT_FIELD_NUMBER = 5;
    public static final int UNSUPPORTED_OPERATOR_FIELD_NUMBER = 10;
    public static final int UNSUPPORTED_STARTER_BEHAVIOR_FIELD_NUMBER = 6;
    public static final int UNSUPPORTED_STATE_READER_BEHAVIOR_FIELD_NUMBER = 7;
    public static final int UNSUPPORTED_SUB_NODE_TYPE_FIELD_NUMBER = 31;
    private int issueTypeCase_ = 0;
    private Object issueType_;

    /* JADX INFO: loaded from: classes4.dex */
    public enum IssueTypeCase {
        CONDITION_DURATION_OUT_OF_RANGE(32),
        DELAY_DURATION_OUT_OF_RANGE(16),
        DUPLICATE_STARTER_NODE(23),
        INVALID_ARGUMENT_COUNT(11),
        INVALID_COMMAND(14),
        INVALID_DURATION(26),
        INVALID_EVENT(13),
        INVALID_OPERAND(30),
        INVALID_PARAMETER(15),
        INVALID_TRAIT(12),
        INVALID_VALUE(25),
        MISPLACED_SELECT_FLOW(22),
        MISPLACED_STARTER_NODE(20),
        MISSING_REQUIRED_FIELDS(1),
        MISSING_REQUIRED_PARAMETERS(18),
        MISSING_STARTER_NODE(2),
        MISSING_TRAILING_ACTION_NODE(4),
        MULTIPLE_MANUAL_STARTERS(24),
        MULTIPLE_SELECT_FLOWS(21),
        OUTPUT_NOT_ACCESSIBLE(29),
        OUTPUT_REINITIALIZED(33),
        OUTPUT_TYPE_MISMATCH(28),
        READ_ONLY_ATTRIBUTE(17),
        SUPPRESSION_DURATION_OUT_OF_RANGE(27),
        UNSUBSCRIBABLE_ATTRIBUTE(19),
        UNSUPPORTED_ACTION_BEHAVIOR(8),
        UNSUPPORTED_NODE_OUTPUT(5),
        UNSUPPORTED_OPERATOR(10),
        UNSUPPORTED_STARTER_BEHAVIOR(6),
        UNSUPPORTED_STATE_READER_BEHAVIOR(7),
        UNSUPPORTED_SUB_NODE_TYPE(31),
        INVALID_ARGUMENTS_FOR_OPERATOR(102),
        INVALID_CONDITION_TYPE(106),
        INVALID_FIELD(105),
        INVALID_NULL_PARAMETER_VALUE(107),
        INVALID_PARAMETER_TYPE(104),
        INVALID_REFERENCE(103),
        INVALID_ENTITY(ValidationIssue.INVALID_ENTITY_FIELD_NUMBER),
        UNSUPPORTED_ENTITY_COMMAND(ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER),
        UNSUPPORTED_ENTITY_EVENT(ValidationIssue.UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER),
        UNSUPPORTED_ENTITY_PARAMETER(ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_FIELD_NUMBER),
        UNSUPPORTED_ENTITY_PARAMETER_VALUE(ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER),
        UNSUPPORTED_ENTITY_TRAIT(ValidationIssue.UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER),
        UNSUPPORTED_ENTITY_TYPE(ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER),
        BLOCKED_ACTION(ValidationIssue.BLOCKED_ACTION_FIELD_NUMBER),
        AUTOMATION_TOO_LARGE(ValidationIssue.AUTOMATION_TOO_LARGE_FIELD_NUMBER),
        TOO_MANY_NODES(ValidationIssue.TOO_MANY_NODES_FIELD_NUMBER),
        TOO_MANY_OPERATIONS(ValidationIssue.TOO_MANY_OPERATIONS_FIELD_NUMBER),
        ISSUETYPE_NOT_SET(0);

        private final int value;

        IssueTypeCase(int i) {
            this.value = i;
        }

        public static IssueTypeCase forNumber(int i) {
            if (i == 0) {
                return ISSUETYPE_NOT_SET;
            }
            if (i == 1) {
                return MISSING_REQUIRED_FIELDS;
            }
            if (i == 2) {
                return MISSING_STARTER_NODE;
            }
            if (i == 301) {
                return BLOCKED_ACTION;
            }
            switch (i) {
                case 4:
                    return MISSING_TRAILING_ACTION_NODE;
                case 5:
                    return UNSUPPORTED_NODE_OUTPUT;
                case 6:
                    return UNSUPPORTED_STARTER_BEHAVIOR;
                case 7:
                    return UNSUPPORTED_STATE_READER_BEHAVIOR;
                case 8:
                    return UNSUPPORTED_ACTION_BEHAVIOR;
                default:
                    switch (i) {
                        case 10:
                            return UNSUPPORTED_OPERATOR;
                        case 11:
                            return INVALID_ARGUMENT_COUNT;
                        case 12:
                            return INVALID_TRAIT;
                        case 13:
                            return INVALID_EVENT;
                        case 14:
                            return INVALID_COMMAND;
                        case 15:
                            return INVALID_PARAMETER;
                        case 16:
                            return DELAY_DURATION_OUT_OF_RANGE;
                        case 17:
                            return READ_ONLY_ATTRIBUTE;
                        case 18:
                            return MISSING_REQUIRED_PARAMETERS;
                        case 19:
                            return UNSUBSCRIBABLE_ATTRIBUTE;
                        case 20:
                            return MISPLACED_STARTER_NODE;
                        case 21:
                            return MULTIPLE_SELECT_FLOWS;
                        case 22:
                            return MISPLACED_SELECT_FLOW;
                        case 23:
                            return DUPLICATE_STARTER_NODE;
                        case 24:
                            return MULTIPLE_MANUAL_STARTERS;
                        case 25:
                            return INVALID_VALUE;
                        case 26:
                            return INVALID_DURATION;
                        case 27:
                            return SUPPRESSION_DURATION_OUT_OF_RANGE;
                        case 28:
                            return OUTPUT_TYPE_MISMATCH;
                        case 29:
                            return OUTPUT_NOT_ACCESSIBLE;
                        case 30:
                            return INVALID_OPERAND;
                        case 31:
                            return UNSUPPORTED_SUB_NODE_TYPE;
                        case 32:
                            return CONDITION_DURATION_OUT_OF_RANGE;
                        case 33:
                            return OUTPUT_REINITIALIZED;
                        default:
                            switch (i) {
                                case 102:
                                    return INVALID_ARGUMENTS_FOR_OPERATOR;
                                case 103:
                                    return INVALID_REFERENCE;
                                case 104:
                                    return INVALID_PARAMETER_TYPE;
                                case 105:
                                    return INVALID_FIELD;
                                case 106:
                                    return INVALID_CONDITION_TYPE;
                                case 107:
                                    return INVALID_NULL_PARAMETER_VALUE;
                                default:
                                    switch (i) {
                                        case ValidationIssue.INVALID_ENTITY_FIELD_NUMBER /* 201 */:
                                            return INVALID_ENTITY;
                                        case ValidationIssue.UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER /* 202 */:
                                            return UNSUPPORTED_ENTITY_TRAIT;
                                        case ValidationIssue.UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER /* 203 */:
                                            return UNSUPPORTED_ENTITY_EVENT;
                                        case ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER /* 204 */:
                                            return UNSUPPORTED_ENTITY_COMMAND;
                                        case ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_FIELD_NUMBER /* 205 */:
                                            return UNSUPPORTED_ENTITY_PARAMETER;
                                        case ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER /* 206 */:
                                            return UNSUPPORTED_ENTITY_PARAMETER_VALUE;
                                        case ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER /* 207 */:
                                            return UNSUPPORTED_ENTITY_TYPE;
                                        default:
                                            switch (i) {
                                                case ValidationIssue.TOO_MANY_NODES_FIELD_NUMBER /* 401 */:
                                                    return TOO_MANY_NODES;
                                                case ValidationIssue.AUTOMATION_TOO_LARGE_FIELD_NUMBER /* 402 */:
                                                    return AUTOMATION_TOO_LARGE;
                                                case ValidationIssue.TOO_MANY_OPERATIONS_FIELD_NUMBER /* 403 */:
                                                    return TOO_MANY_OPERATIONS;
                                                default:
                                                    return null;
                                            }
                                    }
                            }
                    }
            }
        }
    }

    static {
        ValidationIssue validationIssue = new ValidationIssue();
        DEFAULT_INSTANCE = validationIssue;
        zzzg.registerDefaultInstance(ValidationIssue.class, validationIssue);
    }

    private ValidationIssue() {
    }

    public static ValidationIssue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u00040\u0001\u0000\u0001Ɠ0\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000\u0011<\u0000\u0012<\u0000\u0013<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000\u0017<\u0000\u0018<\u0000\u0019<\u0000\u001a<\u0000\u001b<\u0000\u001c<\u0000\u001d<\u0000\u001e<\u0000\u001f<\u0000 <\u0000!<\u0000f<\u0000g<\u0000h<\u0000i<\u0000j<\u0000k<\u0000É<\u0000Ê<\u0000Ë<\u0000Ì<\u0000Í<\u0000Î<\u0000Ï<\u0000ĭ<\u0000Ƒ<\u0000ƒ<\u0000Ɠ<\u0000", new Object[]{"issueType_", "issueTypeCase_", MissingRequiredFields.class, MissingStarterNode.class, MissingTrailingActionNode.class, UnsupportedNodeOutput.class, UnsupportedStarterBehavior.class, UnsupportedStateReaderBehavior.class, UnsupportedActionBehavior.class, UnsupportedOperator.class, InvalidArgumentCount.class, InvalidTrait.class, InvalidEvent.class, InvalidCommand.class, InvalidParameter.class, DelayDurationOutOfRange.class, ReadOnlyAttribute.class, MissingRequiredParameters.class, UnsubscribableAttribute.class, MisplacedStarterNode.class, MultipleSelectFlows.class, MisplacedSelectFlow.class, DuplicateStarterNode.class, MultipleManualStarters.class, InvalidValue.class, InvalidDuration.class, SuppressionDurationOutOfRange.class, OutputTypeMismatch.class, OutputNotAccessible.class, InvalidOperand.class, UnsupportedSubNodeType.class, ConditionDurationOutOfRange.class, OutputReinitialized.class, InvalidArgumentsForOperator.class, InvalidReference.class, InvalidParameterType.class, InvalidField.class, InvalidConditionType.class, InvalidNullParameterValue.class, InvalidEntity.class, UnsupportedEntityTrait.class, UnsupportedEntityEvent.class, UnsupportedEntityCommand.class, UnsupportedEntityParameter.class, UnsupportedEntityParameterValue.class, UnsupportedEntityType.class, BlockedAction.class, TooManyNodes.class, AutomationTooLarge.class, TooManyOperations.class});
        }
        if (iOrdinal == 3) {
            return new ValidationIssue();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new Builder(bArr);
        }
        if (iOrdinal == 5) {
            return DEFAULT_INSTANCE;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay<ValidationIssue> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ValidationIssue.class) {
            try {
                zzyzVar = PARSER;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(DEFAULT_INSTANCE);
                    PARSER = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public AutomationTooLarge getAutomationTooLarge() {
        return this.issueTypeCase_ == 402 ? (AutomationTooLarge) this.issueType_ : AutomationTooLarge.getDefaultInstance();
    }

    public BlockedAction getBlockedAction() {
        return this.issueTypeCase_ == 301 ? (BlockedAction) this.issueType_ : BlockedAction.getDefaultInstance();
    }

    public ConditionDurationOutOfRange getConditionDurationOutOfRange() {
        return this.issueTypeCase_ == 32 ? (ConditionDurationOutOfRange) this.issueType_ : ConditionDurationOutOfRange.getDefaultInstance();
    }

    public DelayDurationOutOfRange getDelayDurationOutOfRange() {
        return this.issueTypeCase_ == 16 ? (DelayDurationOutOfRange) this.issueType_ : DelayDurationOutOfRange.getDefaultInstance();
    }

    public DuplicateStarterNode getDuplicateStarterNode() {
        return this.issueTypeCase_ == 23 ? (DuplicateStarterNode) this.issueType_ : DuplicateStarterNode.getDefaultInstance();
    }

    public InvalidArgumentCount getInvalidArgumentCount() {
        return this.issueTypeCase_ == 11 ? (InvalidArgumentCount) this.issueType_ : InvalidArgumentCount.getDefaultInstance();
    }

    public InvalidArgumentsForOperator getInvalidArgumentsForOperator() {
        return this.issueTypeCase_ == 102 ? (InvalidArgumentsForOperator) this.issueType_ : InvalidArgumentsForOperator.getDefaultInstance();
    }

    public InvalidCommand getInvalidCommand() {
        return this.issueTypeCase_ == 14 ? (InvalidCommand) this.issueType_ : InvalidCommand.getDefaultInstance();
    }

    public InvalidConditionType getInvalidConditionType() {
        return this.issueTypeCase_ == 106 ? (InvalidConditionType) this.issueType_ : InvalidConditionType.getDefaultInstance();
    }

    public InvalidDuration getInvalidDuration() {
        return this.issueTypeCase_ == 26 ? (InvalidDuration) this.issueType_ : InvalidDuration.getDefaultInstance();
    }

    public InvalidEntity getInvalidEntity() {
        return this.issueTypeCase_ == 201 ? (InvalidEntity) this.issueType_ : InvalidEntity.getDefaultInstance();
    }

    public InvalidEvent getInvalidEvent() {
        return this.issueTypeCase_ == 13 ? (InvalidEvent) this.issueType_ : InvalidEvent.getDefaultInstance();
    }

    public InvalidField getInvalidField() {
        return this.issueTypeCase_ == 105 ? (InvalidField) this.issueType_ : InvalidField.getDefaultInstance();
    }

    public InvalidNullParameterValue getInvalidNullParameterValue() {
        return this.issueTypeCase_ == 107 ? (InvalidNullParameterValue) this.issueType_ : InvalidNullParameterValue.getDefaultInstance();
    }

    public InvalidOperand getInvalidOperand() {
        return this.issueTypeCase_ == 30 ? (InvalidOperand) this.issueType_ : InvalidOperand.getDefaultInstance();
    }

    public InvalidParameter getInvalidParameter() {
        return this.issueTypeCase_ == 15 ? (InvalidParameter) this.issueType_ : InvalidParameter.getDefaultInstance();
    }

    public InvalidParameterType getInvalidParameterType() {
        return this.issueTypeCase_ == 104 ? (InvalidParameterType) this.issueType_ : InvalidParameterType.getDefaultInstance();
    }

    public InvalidReference getInvalidReference() {
        return this.issueTypeCase_ == 103 ? (InvalidReference) this.issueType_ : InvalidReference.getDefaultInstance();
    }

    public InvalidTrait getInvalidTrait() {
        return this.issueTypeCase_ == 12 ? (InvalidTrait) this.issueType_ : InvalidTrait.getDefaultInstance();
    }

    public InvalidValue getInvalidValue() {
        return this.issueTypeCase_ == 25 ? (InvalidValue) this.issueType_ : InvalidValue.getDefaultInstance();
    }

    public IssueTypeCase getIssueTypeCase() {
        return IssueTypeCase.forNumber(this.issueTypeCase_);
    }

    public MisplacedSelectFlow getMisplacedSelectFlow() {
        return this.issueTypeCase_ == 22 ? (MisplacedSelectFlow) this.issueType_ : MisplacedSelectFlow.getDefaultInstance();
    }

    public MisplacedStarterNode getMisplacedStarterNode() {
        return this.issueTypeCase_ == 20 ? (MisplacedStarterNode) this.issueType_ : MisplacedStarterNode.getDefaultInstance();
    }

    public MissingRequiredFields getMissingRequiredFields() {
        return this.issueTypeCase_ == 1 ? (MissingRequiredFields) this.issueType_ : MissingRequiredFields.getDefaultInstance();
    }

    public MissingRequiredParameters getMissingRequiredParameters() {
        return this.issueTypeCase_ == 18 ? (MissingRequiredParameters) this.issueType_ : MissingRequiredParameters.getDefaultInstance();
    }

    public MissingStarterNode getMissingStarterNode() {
        return this.issueTypeCase_ == 2 ? (MissingStarterNode) this.issueType_ : MissingStarterNode.getDefaultInstance();
    }

    public MultipleManualStarters getMultipleManualStarters() {
        return this.issueTypeCase_ == 24 ? (MultipleManualStarters) this.issueType_ : MultipleManualStarters.getDefaultInstance();
    }

    public OutputNotAccessible getOutputNotAccessible() {
        return this.issueTypeCase_ == 29 ? (OutputNotAccessible) this.issueType_ : OutputNotAccessible.getDefaultInstance();
    }

    public OutputReinitialized getOutputReinitialized() {
        return this.issueTypeCase_ == 33 ? (OutputReinitialized) this.issueType_ : OutputReinitialized.getDefaultInstance();
    }

    public OutputTypeMismatch getOutputTypeMismatch() {
        return this.issueTypeCase_ == 28 ? (OutputTypeMismatch) this.issueType_ : OutputTypeMismatch.getDefaultInstance();
    }

    public ReadOnlyAttribute getReadOnlyAttribute() {
        return this.issueTypeCase_ == 17 ? (ReadOnlyAttribute) this.issueType_ : ReadOnlyAttribute.getDefaultInstance();
    }

    public SuppressionDurationOutOfRange getSuppressionDurationOutOfRange() {
        return this.issueTypeCase_ == 27 ? (SuppressionDurationOutOfRange) this.issueType_ : SuppressionDurationOutOfRange.getDefaultInstance();
    }

    public TooManyNodes getTooManyNodes() {
        return this.issueTypeCase_ == 401 ? (TooManyNodes) this.issueType_ : TooManyNodes.getDefaultInstance();
    }

    public TooManyOperations getTooManyOperations() {
        return this.issueTypeCase_ == 403 ? (TooManyOperations) this.issueType_ : TooManyOperations.getDefaultInstance();
    }

    public UnsubscribableAttribute getUnsubscribableAttribute() {
        return this.issueTypeCase_ == 19 ? (UnsubscribableAttribute) this.issueType_ : UnsubscribableAttribute.getDefaultInstance();
    }

    public UnsupportedActionBehavior getUnsupportedActionBehavior() {
        return this.issueTypeCase_ == 8 ? (UnsupportedActionBehavior) this.issueType_ : UnsupportedActionBehavior.getDefaultInstance();
    }

    public UnsupportedEntityCommand getUnsupportedEntityCommand() {
        return this.issueTypeCase_ == 204 ? (UnsupportedEntityCommand) this.issueType_ : UnsupportedEntityCommand.getDefaultInstance();
    }

    public UnsupportedEntityEvent getUnsupportedEntityEvent() {
        return this.issueTypeCase_ == 203 ? (UnsupportedEntityEvent) this.issueType_ : UnsupportedEntityEvent.getDefaultInstance();
    }

    public UnsupportedEntityParameter getUnsupportedEntityParameter() {
        return this.issueTypeCase_ == 205 ? (UnsupportedEntityParameter) this.issueType_ : UnsupportedEntityParameter.getDefaultInstance();
    }

    public UnsupportedEntityParameterValue getUnsupportedEntityParameterValue() {
        return this.issueTypeCase_ == 206 ? (UnsupportedEntityParameterValue) this.issueType_ : UnsupportedEntityParameterValue.getDefaultInstance();
    }

    public UnsupportedEntityTrait getUnsupportedEntityTrait() {
        return this.issueTypeCase_ == 202 ? (UnsupportedEntityTrait) this.issueType_ : UnsupportedEntityTrait.getDefaultInstance();
    }

    public UnsupportedEntityType getUnsupportedEntityType() {
        return this.issueTypeCase_ == 207 ? (UnsupportedEntityType) this.issueType_ : UnsupportedEntityType.getDefaultInstance();
    }

    public UnsupportedNodeOutput getUnsupportedNodeOutput() {
        return this.issueTypeCase_ == 5 ? (UnsupportedNodeOutput) this.issueType_ : UnsupportedNodeOutput.getDefaultInstance();
    }

    public UnsupportedOperator getUnsupportedOperator() {
        return this.issueTypeCase_ == 10 ? (UnsupportedOperator) this.issueType_ : UnsupportedOperator.getDefaultInstance();
    }

    public UnsupportedStarterBehavior getUnsupportedStarterBehavior() {
        return this.issueTypeCase_ == 6 ? (UnsupportedStarterBehavior) this.issueType_ : UnsupportedStarterBehavior.getDefaultInstance();
    }

    public UnsupportedStateReaderBehavior getUnsupportedStateReaderBehavior() {
        return this.issueTypeCase_ == 7 ? (UnsupportedStateReaderBehavior) this.issueType_ : UnsupportedStateReaderBehavior.getDefaultInstance();
    }

    public UnsupportedSubNodeType getUnsupportedSubNodeType() {
        return this.issueTypeCase_ == 31 ? (UnsupportedSubNodeType) this.issueType_ : UnsupportedSubNodeType.getDefaultInstance();
    }

    public static final class Builder extends zzyy<ValidationIssue, Builder> implements zzaar {
        private Builder() {
            super(ValidationIssue.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
