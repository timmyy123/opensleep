package com.google.home.automation;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b2\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/google/home/automation/ValidationIssueType;", "", "<init>", "(Ljava/lang/String;I)V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "ConditionDurationOutOfRange", "DelayDurationOutOfRange", "DuplicateStarterNode", "InvalidArgumentCount", "InvalidCommand", "InvalidDuration", "InvalidEvent", "InvalidOperand", "InvalidParameter", "InvalidTrait", "InvalidValue", "MisplacedSelectFlow", "MisplacedStarterNode", "MissingRequiredFields", "MissingRequiredParameters", "MissingStarterNode", "MultipleManualStarters", "OutputNotAccessible", "OutputTypeMismatch", "OutputReinitialized", "ReadOnlyAttribute", "SuppressionDurationOutOfRange", "UnsubscribableAttribute", "UnsupportedActionBehavior", "UnsupportedNodeOutput", "UnsupportedOperator", "UnsupportedStarterBehavior", "UnsupportedStateReaderBehavior", "UnsupportedSubNodeType", "InvalidArgumentsForOperator", "InvalidConditionType", "InvalidField", "InvalidParameterType", "InvalidNullParameterValue", "InvalidReference", "InvalidEntity", "UnsupportedEntityCommand", "UnsupportedEntityEvent", "UnsupportedEntityParameter", "UnsupportedEntityParameterValue", "UnsupportedEntityTrait", "UnsupportedEntityType", "BlockedAction", "AutomationTooLarge", "TooManyNodes", "TooManyOperations", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ValidationIssueType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ValidationIssueType[] $VALUES;
    public static final ValidationIssueType Unknown = new ValidationIssueType(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 0);
    public static final ValidationIssueType ConditionDurationOutOfRange = new ValidationIssueType("ConditionDurationOutOfRange", 1);
    public static final ValidationIssueType DelayDurationOutOfRange = new ValidationIssueType("DelayDurationOutOfRange", 2);
    public static final ValidationIssueType DuplicateStarterNode = new ValidationIssueType("DuplicateStarterNode", 3);
    public static final ValidationIssueType InvalidArgumentCount = new ValidationIssueType("InvalidArgumentCount", 4);
    public static final ValidationIssueType InvalidCommand = new ValidationIssueType("InvalidCommand", 5);
    public static final ValidationIssueType InvalidDuration = new ValidationIssueType("InvalidDuration", 6);
    public static final ValidationIssueType InvalidEvent = new ValidationIssueType("InvalidEvent", 7);
    public static final ValidationIssueType InvalidOperand = new ValidationIssueType("InvalidOperand", 8);
    public static final ValidationIssueType InvalidParameter = new ValidationIssueType("InvalidParameter", 9);
    public static final ValidationIssueType InvalidTrait = new ValidationIssueType("InvalidTrait", 10);
    public static final ValidationIssueType InvalidValue = new ValidationIssueType("InvalidValue", 11);
    public static final ValidationIssueType MisplacedSelectFlow = new ValidationIssueType("MisplacedSelectFlow", 12);
    public static final ValidationIssueType MisplacedStarterNode = new ValidationIssueType("MisplacedStarterNode", 13);
    public static final ValidationIssueType MissingRequiredFields = new ValidationIssueType("MissingRequiredFields", 14);
    public static final ValidationIssueType MissingRequiredParameters = new ValidationIssueType("MissingRequiredParameters", 15);
    public static final ValidationIssueType MissingStarterNode = new ValidationIssueType("MissingStarterNode", 16);
    public static final ValidationIssueType MultipleManualStarters = new ValidationIssueType("MultipleManualStarters", 17);
    public static final ValidationIssueType OutputNotAccessible = new ValidationIssueType("OutputNotAccessible", 18);
    public static final ValidationIssueType OutputTypeMismatch = new ValidationIssueType("OutputTypeMismatch", 19);
    public static final ValidationIssueType OutputReinitialized = new ValidationIssueType("OutputReinitialized", 20);
    public static final ValidationIssueType ReadOnlyAttribute = new ValidationIssueType("ReadOnlyAttribute", 21);
    public static final ValidationIssueType SuppressionDurationOutOfRange = new ValidationIssueType("SuppressionDurationOutOfRange", 22);
    public static final ValidationIssueType UnsubscribableAttribute = new ValidationIssueType("UnsubscribableAttribute", 23);
    public static final ValidationIssueType UnsupportedActionBehavior = new ValidationIssueType("UnsupportedActionBehavior", 24);
    public static final ValidationIssueType UnsupportedNodeOutput = new ValidationIssueType("UnsupportedNodeOutput", 25);
    public static final ValidationIssueType UnsupportedOperator = new ValidationIssueType("UnsupportedOperator", 26);
    public static final ValidationIssueType UnsupportedStarterBehavior = new ValidationIssueType("UnsupportedStarterBehavior", 27);
    public static final ValidationIssueType UnsupportedStateReaderBehavior = new ValidationIssueType("UnsupportedStateReaderBehavior", 28);
    public static final ValidationIssueType UnsupportedSubNodeType = new ValidationIssueType("UnsupportedSubNodeType", 29);
    public static final ValidationIssueType InvalidArgumentsForOperator = new ValidationIssueType("InvalidArgumentsForOperator", 30);
    public static final ValidationIssueType InvalidConditionType = new ValidationIssueType("InvalidConditionType", 31);
    public static final ValidationIssueType InvalidField = new ValidationIssueType("InvalidField", 32);
    public static final ValidationIssueType InvalidParameterType = new ValidationIssueType("InvalidParameterType", 33);
    public static final ValidationIssueType InvalidNullParameterValue = new ValidationIssueType("InvalidNullParameterValue", 34);
    public static final ValidationIssueType InvalidReference = new ValidationIssueType("InvalidReference", 35);
    public static final ValidationIssueType InvalidEntity = new ValidationIssueType("InvalidEntity", 36);
    public static final ValidationIssueType UnsupportedEntityCommand = new ValidationIssueType("UnsupportedEntityCommand", 37);
    public static final ValidationIssueType UnsupportedEntityEvent = new ValidationIssueType("UnsupportedEntityEvent", 38);
    public static final ValidationIssueType UnsupportedEntityParameter = new ValidationIssueType("UnsupportedEntityParameter", 39);
    public static final ValidationIssueType UnsupportedEntityParameterValue = new ValidationIssueType("UnsupportedEntityParameterValue", 40);
    public static final ValidationIssueType UnsupportedEntityTrait = new ValidationIssueType("UnsupportedEntityTrait", 41);
    public static final ValidationIssueType UnsupportedEntityType = new ValidationIssueType("UnsupportedEntityType", 42);
    public static final ValidationIssueType BlockedAction = new ValidationIssueType("BlockedAction", 43);
    public static final ValidationIssueType AutomationTooLarge = new ValidationIssueType("AutomationTooLarge", 44);
    public static final ValidationIssueType TooManyNodes = new ValidationIssueType("TooManyNodes", 45);
    public static final ValidationIssueType TooManyOperations = new ValidationIssueType("TooManyOperations", 46);

    private static final /* synthetic */ ValidationIssueType[] $values() {
        return new ValidationIssueType[]{Unknown, ConditionDurationOutOfRange, DelayDurationOutOfRange, DuplicateStarterNode, InvalidArgumentCount, InvalidCommand, InvalidDuration, InvalidEvent, InvalidOperand, InvalidParameter, InvalidTrait, InvalidValue, MisplacedSelectFlow, MisplacedStarterNode, MissingRequiredFields, MissingRequiredParameters, MissingStarterNode, MultipleManualStarters, OutputNotAccessible, OutputTypeMismatch, OutputReinitialized, ReadOnlyAttribute, SuppressionDurationOutOfRange, UnsubscribableAttribute, UnsupportedActionBehavior, UnsupportedNodeOutput, UnsupportedOperator, UnsupportedStarterBehavior, UnsupportedStateReaderBehavior, UnsupportedSubNodeType, InvalidArgumentsForOperator, InvalidConditionType, InvalidField, InvalidParameterType, InvalidNullParameterValue, InvalidReference, InvalidEntity, UnsupportedEntityCommand, UnsupportedEntityEvent, UnsupportedEntityParameter, UnsupportedEntityParameterValue, UnsupportedEntityTrait, UnsupportedEntityType, BlockedAction, AutomationTooLarge, TooManyNodes, TooManyOperations};
    }

    static {
        ValidationIssueType[] validationIssueTypeArr$values = $values();
        $VALUES = validationIssueTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(validationIssueTypeArr$values);
    }

    private ValidationIssueType(String str, int i) {
    }

    public static ValidationIssueType valueOf(String str) {
        return (ValidationIssueType) Enum.valueOf(ValidationIssueType.class, str);
    }

    public static ValidationIssueType[] values() {
        return (ValidationIssueType[]) $VALUES.clone();
    }
}
