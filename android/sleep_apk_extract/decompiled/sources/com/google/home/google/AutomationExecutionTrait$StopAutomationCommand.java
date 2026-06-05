package com.google.home.google;

import com.google.home.CommandDescriptor;
import com.google.home.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/google/home/google/AutomationExecutionTrait$StopAutomationCommand", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.automation_automation_execution_trait_kmp_library-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutomationExecutionTrait$StopAutomationCommand implements CommandDescriptor {
    public static final AutomationExecutionTrait$StopAutomationCommand INSTANCE = new AutomationExecutionTrait$StopAutomationCommand();
    private static final String commandId = "home.platform.traits.automation.AutomationExecutionTrait.StopAutomationCommand";

    private AutomationExecutionTrait$StopAutomationCommand() {
    }

    public String getCommandId() {
        return commandId;
    }

    @Override // com.google.home.CommandDescriptor
    /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
    public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
        AutomationExecutionTrait$StopAutomationCommand$StopAutomationCommandRequest$CommandFields[] automationExecutionTrait$StopAutomationCommand$StopAutomationCommandRequest$CommandFieldsArrValues = AutomationExecutionTrait$StopAutomationCommand$StopAutomationCommandRequest$CommandFields.values();
        if (automationExecutionTrait$StopAutomationCommand$StopAutomationCommandRequest$CommandFieldsArrValues.length <= 0) {
            return null;
        }
        AutomationExecutionTrait$StopAutomationCommand$StopAutomationCommandRequest$CommandFields automationExecutionTrait$StopAutomationCommand$StopAutomationCommandRequest$CommandFields = automationExecutionTrait$StopAutomationCommand$StopAutomationCommandRequest$CommandFieldsArrValues[0];
        throw null;
    }
}
