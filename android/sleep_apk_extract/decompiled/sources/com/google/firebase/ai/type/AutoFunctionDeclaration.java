package com.google.firebase.ai.type;

import com.google.firebase.ai.type.FunctionDeclaration;
import com.google.firebase.ai.type.Schema;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001\u001bB]\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012$\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R1\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/google/firebase/ai/type/AutoFunctionDeclaration;", "I", "", "O", "name", "", "description", "inputSchema", "Lcom/google/firebase/ai/type/JsonSchema;", "outputSchema", "functionReference", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/JsonSchema;Lcom/google/firebase/ai/type/JsonSchema;Lkotlin/jvm/functions/Function2;)V", "getName", "()Ljava/lang/String;", "getDescription", "getInputSchema", "()Lcom/google/firebase/ai/type/JsonSchema;", "getOutputSchema", "getFunctionReference", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "toInternal", "Lcom/google/firebase/ai/type/FunctionDeclaration$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoFunctionDeclaration<I, O> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final Function2<I, Continuation<? super O>, Object> functionReference;
    private final JsonSchema<I> inputSchema;
    private final String name;
    private final JsonSchema<O> outputSchema;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u007f\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0001\"\b\b\u0003\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00070\f2&\b\u0002\u0010\u000e\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011Jg\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00120\u0005\"\b\b\u0002\u0010\u0006*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\f2&\b\u0002\u0010\u000e\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000f¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/ai/type/AutoFunctionDeclaration$Companion;", "", "<init>", "()V", "create", "Lcom/google/firebase/ai/type/AutoFunctionDeclaration;", "I", "O", "functionName", "", "description", "inputSchema", "Lcom/google/firebase/ai/type/JsonSchema;", "outputSchema", "functionReference", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/JsonSchema;Lcom/google/firebase/ai/type/JsonSchema;Lkotlin/jvm/functions/Function2;)Lcom/google/firebase/ai/type/AutoFunctionDeclaration;", "Lcom/google/firebase/ai/type/FunctionResponsePart;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/JsonSchema;Lkotlin/jvm/functions/Function2;)Lcom/google/firebase/ai/type/AutoFunctionDeclaration;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AutoFunctionDeclaration create$default(Companion companion, String str, String str2, JsonSchema jsonSchema, JsonSchema jsonSchema2, Function2 function2, int i, Object obj) {
            if ((i & 16) != 0) {
                function2 = null;
            }
            return companion.create(str, str2, jsonSchema, jsonSchema2, function2);
        }

        public final <I> AutoFunctionDeclaration<I, FunctionResponsePart> create(String functionName, String description, JsonSchema<I> inputSchema, Function2<? super I, ? super Continuation<? super FunctionResponsePart>, ? extends Object> functionReference) {
            functionName.getClass();
            description.getClass();
            inputSchema.getClass();
            return new AutoFunctionDeclaration<>(functionName, description, inputSchema, null, functionReference);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AutoFunctionDeclaration create$default(Companion companion, String str, String str2, JsonSchema jsonSchema, Function2 function2, int i, Object obj) {
            if ((i & 8) != 0) {
                function2 = null;
            }
            return companion.create(str, str2, jsonSchema, function2);
        }

        public final <I, O> AutoFunctionDeclaration<I, O> create(String functionName, String description, JsonSchema<I> inputSchema, JsonSchema<O> outputSchema, Function2<? super I, ? super Continuation<? super O>, ? extends Object> functionReference) {
            functionName.getClass();
            description.getClass();
            inputSchema.getClass();
            outputSchema.getClass();
            return new AutoFunctionDeclaration<>(functionName, description, inputSchema, outputSchema, functionReference);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutoFunctionDeclaration(String str, String str2, JsonSchema<I> jsonSchema, JsonSchema<O> jsonSchema2, Function2<? super I, ? super Continuation<? super O>, ? extends Object> function2) {
        str.getClass();
        str2.getClass();
        jsonSchema.getClass();
        this.name = str;
        this.description = str2;
        this.inputSchema = jsonSchema;
        this.outputSchema = jsonSchema2;
        this.functionReference = function2;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Function2<I, Continuation<? super O>, Object> getFunctionReference() {
        return this.functionReference;
    }

    public final JsonSchema<I> getInputSchema() {
        return this.inputSchema;
    }

    public final String getName() {
        return this.name;
    }

    public final JsonSchema<O> getOutputSchema() {
        return this.outputSchema;
    }

    public final FunctionDeclaration.Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        String str = this.name;
        String str2 = this.description;
        Schema.InternalJson internalJson$com_google_firebase_ai_logic_firebase_ai = this.inputSchema.toInternalJson$com_google_firebase_ai_logic_firebase_ai();
        JsonSchema<O> jsonSchema = this.outputSchema;
        return new FunctionDeclaration.Internal(str, str2, null, internalJson$com_google_firebase_ai_logic_firebase_ai, jsonSchema != null ? jsonSchema.toInternalJson$com_google_firebase_ai_logic_firebase_ai() : null);
    }
}
