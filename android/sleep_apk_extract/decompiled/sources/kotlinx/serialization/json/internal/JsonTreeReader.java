package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\t\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000bH\u0082@¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "lexer", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "Lkotlinx/serialization/json/JsonElement;", "readObject", "()Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readArray", "", "isString", "Lkotlinx/serialization/json/JsonPrimitive;", "readValue", "(Z)Lkotlinx/serialization/json/JsonPrimitive;", "readDeepRecursive", "read", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "isLenient", "Z", "trailingCommaAllowed", "", "stackDepth", "I", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JsonTreeReader {
    private final boolean isLenient;
    private final AbstractJsonLexer lexer;
    private int stackDepth;
    private final boolean trailingCommaAllowed;

    /* JADX INFO: renamed from: kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {115}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Unit unit, Continuation<? super JsonElement> continuation) {
            AnonymousClass1 anonymousClass1 = JsonTreeReader.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = deepRecursiveScope;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DeepRecursiveScope deepRecursiveScope = (DeepRecursiveScope) this.L$0;
                byte bPeekNextToken = JsonTreeReader.this.lexer.peekNextToken();
                if (bPeekNextToken == 1) {
                    return JsonTreeReader.this.readValue(true);
                }
                if (bPeekNextToken == 0) {
                    return JsonTreeReader.this.readValue(false);
                }
                if (bPeekNextToken != 6) {
                    JsonTreeReader jsonTreeReader = JsonTreeReader.this;
                    if (bPeekNextToken == 8) {
                        return jsonTreeReader.readArray();
                    }
                    AbstractJsonLexer.fail$default(jsonTreeReader.lexer, "Can't begin reading element, unexpected token", 0, null, 6, null);
                    Utf8$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                JsonTreeReader jsonTreeReader2 = JsonTreeReader.this;
                this.label = 1;
                obj = jsonTreeReader2.readObject(deepRecursiveScope, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return (JsonElement) obj;
        }
    }

    /* JADX INFO: renamed from: kotlinx.serialization.json.internal.JsonTreeReader$readObject$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {24}, m = "readObject")
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JsonTreeReader.this.readObject(null, this);
        }
    }

    public JsonTreeReader(JsonConfiguration jsonConfiguration, AbstractJsonLexer abstractJsonLexer) {
        jsonConfiguration.getClass();
        abstractJsonLexer.getClass();
        this.lexer = abstractJsonLexer;
        this.isLenient = jsonConfiguration.getIsLenient();
        this.trailingCommaAllowed = jsonConfiguration.getAllowTrailingComma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement readArray() {
        byte bConsumeNextToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            Utf8$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (this.lexer.canConsumeValue()) {
            arrayList.add(read());
            bConsumeNextToken = this.lexer.consumeNextToken();
            if (bConsumeNextToken != 4) {
                AbstractJsonLexer abstractJsonLexer = this.lexer;
                boolean z = bConsumeNextToken == 9;
                int i = abstractJsonLexer.currentPosition;
                if (!z) {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the array or comma", i, null, 4, null);
                    Utf8$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
            }
        }
        if (bConsumeNextToken == 8) {
            this.lexer.consumeNextToken((byte) 9);
        } else if (bConsumeNextToken == 4) {
            boolean z2 = this.trailingCommaAllowed;
            AbstractJsonLexer abstractJsonLexer2 = this.lexer;
            if (!z2) {
                JsonExceptionsKt.invalidTrailingComma(abstractJsonLexer2, "array");
                Utf8$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            abstractJsonLexer2.consumeNextToken((byte) 9);
        }
        return new JsonArray(arrayList);
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new AnonymousClass1(null)), Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0097 -> B:27:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readObject(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Continuation<? super JsonElement> continuation) {
        AnonymousClass2 anonymousClass2;
        LinkedHashMap linkedHashMap;
        AnonymousClass2 anonymousClass22;
        byte b;
        DeepRecursiveScope deepRecursiveScope2;
        JsonTreeReader jsonTreeReader = this;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = jsonTreeReader.new AnonymousClass2(continuation);
            }
        }
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byte bConsumeNextToken = jsonTreeReader.lexer.consumeNextToken((byte) 6);
            if (jsonTreeReader.lexer.peekNextToken() == 4) {
                AbstractJsonLexer.fail$default(jsonTreeReader.lexer, "Unexpected leading comma", 0, null, 6, null);
                Utf8$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            linkedHashMap = new LinkedHashMap();
            anonymousClass22 = anonymousClass2;
            b = bConsumeNextToken;
            deepRecursiveScope2 = deepRecursiveScope;
            if (jsonTreeReader.lexer.canConsumeValue()) {
            }
            if (b == 6) {
            }
            return new JsonObject(linkedHashMap);
        }
        if (i2 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        String str = (String) anonymousClass2.L$3;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) anonymousClass2.L$2;
        JsonTreeReader jsonTreeReader2 = (JsonTreeReader) anonymousClass2.L$1;
        DeepRecursiveScope deepRecursiveScope3 = (DeepRecursiveScope) anonymousClass2.L$0;
        ResultKt.throwOnFailure(obj);
        anonymousClass22 = anonymousClass2;
        LinkedHashMap linkedHashMap3 = linkedHashMap2;
        linkedHashMap3.put(str, (JsonElement) obj);
        byte bConsumeNextToken2 = jsonTreeReader2.lexer.consumeNextToken();
        if (bConsumeNextToken2 == 4) {
            if (bConsumeNextToken2 != 7) {
                AbstractJsonLexer.fail$default(jsonTreeReader2.lexer, "Expected end of the object or comma", 0, null, 6, null);
                Utf8$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            LinkedHashMap linkedHashMap4 = linkedHashMap3;
            b = bConsumeNextToken2;
            jsonTreeReader = jsonTreeReader2;
            linkedHashMap = linkedHashMap4;
            if (b == 6) {
                jsonTreeReader.lexer.consumeNextToken((byte) 7);
            } else if (b == 4) {
                boolean z = jsonTreeReader.trailingCommaAllowed;
                AbstractJsonLexer abstractJsonLexer = jsonTreeReader.lexer;
                if (!z) {
                    JsonExceptionsKt.invalidTrailingComma$default(abstractJsonLexer, null, 1, null);
                    Utf8$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                abstractJsonLexer.consumeNextToken((byte) 7);
            }
            return new JsonObject(linkedHashMap);
        }
        LinkedHashMap linkedHashMap5 = linkedHashMap3;
        b = bConsumeNextToken2;
        jsonTreeReader = jsonTreeReader2;
        linkedHashMap = linkedHashMap5;
        deepRecursiveScope2 = deepRecursiveScope3;
        if (jsonTreeReader.lexer.canConsumeValue()) {
            boolean z2 = jsonTreeReader.isLenient;
            AbstractJsonLexer abstractJsonLexer2 = jsonTreeReader.lexer;
            String strConsumeStringLenient = z2 ? abstractJsonLexer2.consumeStringLenient() : abstractJsonLexer2.consumeString();
            jsonTreeReader.lexer.consumeNextToken((byte) 5);
            Unit unit = Unit.INSTANCE;
            anonymousClass22.L$0 = deepRecursiveScope2;
            anonymousClass22.L$1 = jsonTreeReader;
            anonymousClass22.L$2 = linkedHashMap;
            anonymousClass22.L$3 = strConsumeStringLenient;
            anonymousClass22.label = 1;
            Object objCallRecursive = deepRecursiveScope2.callRecursive(unit, anonymousClass22);
            if (objCallRecursive == coroutine_suspended) {
                return coroutine_suspended;
            }
            LinkedHashMap linkedHashMap6 = linkedHashMap;
            jsonTreeReader2 = jsonTreeReader;
            str = strConsumeStringLenient;
            linkedHashMap3 = linkedHashMap6;
            deepRecursiveScope3 = deepRecursiveScope2;
            obj = objCallRecursive;
            linkedHashMap3.put(str, (JsonElement) obj);
            byte bConsumeNextToken22 = jsonTreeReader2.lexer.consumeNextToken();
            if (bConsumeNextToken22 == 4) {
            }
        }
        if (b == 6) {
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive readValue(boolean isString) {
        String strConsumeStringLenient = (this.isLenient || !isString) ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
        return (isString || !Intrinsics.areEqual(strConsumeStringLenient, "null")) ? new JsonLiteral(strConsumeStringLenient, isString, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        byte bPeekNextToken = this.lexer.peekNextToken();
        if (bPeekNextToken == 1) {
            return readValue(true);
        }
        if (bPeekNextToken == 0) {
            return readValue(false);
        }
        if (bPeekNextToken == 6) {
            int i = this.stackDepth + 1;
            this.stackDepth = i;
            this.stackDepth--;
            return i == 200 ? readDeepRecursive() : readObject();
        }
        if (bPeekNextToken == 8) {
            return readArray();
        }
        AbstractJsonLexer.fail$default(this.lexer, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.tokenDescription(bPeekNextToken), 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    private final JsonElement readObject() {
        byte bConsumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!this.lexer.canConsumeValue()) {
                    break;
                }
                boolean z = this.isLenient;
                AbstractJsonLexer abstractJsonLexer = this.lexer;
                String strConsumeStringLenient = z ? abstractJsonLexer.consumeStringLenient() : abstractJsonLexer.consumeString();
                this.lexer.consumeNextToken((byte) 5);
                linkedHashMap.put(strConsumeStringLenient, read());
                bConsumeNextToken = this.lexer.consumeNextToken();
                if (bConsumeNextToken != 4) {
                    if (bConsumeNextToken != 7) {
                        AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                        Utf8$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                }
            }
            if (bConsumeNextToken == 6) {
                this.lexer.consumeNextToken((byte) 7);
            } else if (bConsumeNextToken == 4) {
                boolean z2 = this.trailingCommaAllowed;
                AbstractJsonLexer abstractJsonLexer2 = this.lexer;
                if (z2) {
                    abstractJsonLexer2.consumeNextToken((byte) 7);
                } else {
                    JsonExceptionsKt.invalidTrailingComma$default(abstractJsonLexer2, null, 1, null);
                    Utf8$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
            }
            return new JsonObject(linkedHashMap);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
