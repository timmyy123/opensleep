package com.google.firebase.ai.type;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.google.firebase.ai.type.CodeExecutionResultPart;
import com.google.firebase.ai.type.ExecutableCodePart;
import com.google.firebase.ai.type.FileDataPart;
import com.google.firebase.ai.type.FunctionCallPart;
import com.google.firebase.ai.type.FunctionResponsePart;
import com.google.firebase.ai.type.InlineData;
import com.google.firebase.ai.type.InlineDataPart;
import com.google.firebase.ai.type.TextPart;
import com.google.firebase.ai.type.UnknownPart;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002\u001a\u0016\u0010\f\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0004H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0002*\u00020\rH\u0000\u001a\u001d\u0010\u0013\u001a\n \u0014*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0011\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016\"\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000*\f\b\u0000\u0010\t\"\u00020\u00012\u00020\u0001¨\u0006\u0017"}, d2 = {"asTextOrNull", "", "Lcom/google/firebase/ai/type/Part;", "asImageOrNull", "Landroid/graphics/Bitmap;", "asInlineDataPartOrNull", "Lcom/google/firebase/ai/type/InlineDataPart;", "asFileDataOrNull", "Lcom/google/firebase/ai/type/FileDataPart;", "Base64", "BASE_64_FLAGS", "", "toInternal", "Lcom/google/firebase/ai/type/InternalPart;", "ignoreThoughtFlag", "", "encodeBitmapToBase64Jpeg", "input", "toPublic", "decodeBitmapFromImage", "kotlin.jvm.PlatformType", "", "([B)Landroid/graphics/Bitmap;", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PartKt {
    public static final int BASE_64_FLAGS = 2;

    public static final FileDataPart asFileDataOrNull(Part part) {
        part.getClass();
        if (part instanceof FileDataPart) {
            return (FileDataPart) part;
        }
        return null;
    }

    public static final Bitmap asImageOrNull(Part part) {
        part.getClass();
        ImagePart imagePart = part instanceof ImagePart ? (ImagePart) part : null;
        if (imagePart != null) {
            return imagePart.getImage();
        }
        return null;
    }

    public static final InlineDataPart asInlineDataPartOrNull(Part part) {
        part.getClass();
        if (part instanceof InlineDataPart) {
            return (InlineDataPart) part;
        }
        return null;
    }

    public static final String asTextOrNull(Part part) {
        part.getClass();
        TextPart textPart = part instanceof TextPart ? (TextPart) part : null;
        if (textPart != null) {
            return textPart.getText();
        }
        return null;
    }

    private static final Bitmap decodeBitmapFromImage(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodeBitmapToBase64Jpeg(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        strEncodeToString.getClass();
        return strEncodeToString;
    }

    public static final InternalPart toInternal(Part part, boolean z) {
        part.getClass();
        Boolean boolValueOf = z ? null : Boolean.valueOf(part.getIsThought());
        if (part instanceof TextPart) {
            TextPart textPart = (TextPart) part;
            return new TextPart.Internal(textPart.getText(), boolValueOf, textPart.getThoughtSignature());
        }
        if (part instanceof ImagePart) {
            ImagePart imagePart = (ImagePart) part;
            return new InlineDataPart.Internal(new InlineData.Internal("image/jpeg", encodeBitmapToBase64Jpeg(imagePart.getImage()), imagePart.getDisplayName()), boolValueOf, imagePart.getThoughtSignature());
        }
        if (part instanceof InlineDataPart) {
            InlineDataPart inlineDataPart = (InlineDataPart) part;
            String mimeType = inlineDataPart.getMimeType();
            String strEncodeToString = Base64.encodeToString(inlineDataPart.getInlineData(), 2);
            strEncodeToString.getClass();
            return new InlineDataPart.Internal(new InlineData.Internal(mimeType, strEncodeToString, inlineDataPart.getDisplayName()), boolValueOf, inlineDataPart.getThoughtSignature());
        }
        if (part instanceof FunctionCallPart) {
            FunctionCallPart functionCallPart = (FunctionCallPart) part;
            return new FunctionCallPart.Internal(new FunctionCallPart.Internal.FunctionCall(functionCallPart.getName(), functionCallPart.getArgs(), functionCallPart.getId()), boolValueOf, functionCallPart.getThoughtSignature());
        }
        if (part instanceof FunctionResponsePart) {
            FunctionResponsePart functionResponsePart = (FunctionResponsePart) part;
            String name = functionResponsePart.getName();
            JsonObject response = functionResponsePart.getResponse();
            String id = functionResponsePart.getId();
            List<Part> parts = functionResponsePart.getParts();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parts, 10));
            Iterator<T> it = parts.iterator();
            while (it.hasNext()) {
                arrayList.add(toInternal((Part) it.next(), true));
            }
            return new FunctionResponsePart.Internal(new FunctionResponsePart.Internal.FunctionResponse(name, response, id, arrayList), boolValueOf, functionResponsePart.getThoughtSignature());
        }
        if (part instanceof FileDataPart) {
            FileDataPart fileDataPart = (FileDataPart) part;
            return new FileDataPart.Internal(new FileDataPart.Internal.FileData(fileDataPart.getMimeType(), fileDataPart.getUri()), boolValueOf, fileDataPart.getThoughtSignature());
        }
        if (part instanceof ExecutableCodePart) {
            ExecutableCodePart executableCodePart = (ExecutableCodePart) part;
            return new ExecutableCodePart.Internal(new ExecutableCodePart.Internal.ExecutableCode(executableCodePart.getLanguage(), executableCodePart.getCode()), boolValueOf, executableCodePart.getThoughtSignature());
        }
        if (part instanceof CodeExecutionResultPart) {
            CodeExecutionResultPart codeExecutionResultPart = (CodeExecutionResultPart) part;
            return new CodeExecutionResultPart.Internal(new CodeExecutionResultPart.Internal.CodeExecutionResult(codeExecutionResultPart.getOutcome(), codeExecutionResultPart.getOutput()), boolValueOf, codeExecutionResultPart.getThoughtSignature());
        }
        throw new SerializationException("The given subclass of Part (" + part.getClass().getSimpleName() + ") is not supported in the serialization yet.", null, 2, null);
    }

    public static /* synthetic */ InternalPart toInternal$default(Part part, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toInternal(part, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    public static final Part toPublic(InternalPart internalPart) {
        ?? EmptyList;
        internalPart.getClass();
        if (internalPart instanceof TextPart.Internal) {
            TextPart.Internal internal = (TextPart.Internal) internalPart;
            String text = internal.getText();
            Boolean thought = internal.getThought();
            return new TextPart(text, thought != null ? thought.booleanValue() : false, internal.getThoughtSignature());
        }
        if (internalPart instanceof InlineDataPart.Internal) {
            InlineDataPart.Internal internal2 = (InlineDataPart.Internal) internalPart;
            byte[] bArrDecode = Base64.decode(internal2.getInlineData().getData(), 2);
            if (!StringsKt.contains$default(internal2.getInlineData().getMimeType(), "image")) {
                bArrDecode.getClass();
                String mimeType = internal2.getInlineData().getMimeType();
                String displayName = internal2.getInlineData().getDisplayName();
                Boolean thought2 = internal2.getThought();
                return new InlineDataPart(bArrDecode, mimeType, displayName, thought2 != null ? thought2.booleanValue() : false, internal2.getThoughtSignature());
            }
            bArrDecode.getClass();
            Bitmap bitmapDecodeBitmapFromImage = decodeBitmapFromImage(bArrDecode);
            bitmapDecodeBitmapFromImage.getClass();
            String displayName2 = internal2.getInlineData().getDisplayName();
            Boolean thought3 = internal2.getThought();
            return new ImagePart(bitmapDecodeBitmapFromImage, displayName2, thought3 != null ? thought3.booleanValue() : false, internal2.getThoughtSignature());
        }
        if (internalPart instanceof FunctionCallPart.Internal) {
            FunctionCallPart.Internal internal3 = (FunctionCallPart.Internal) internalPart;
            String name = internal3.getFunctionCall().getName();
            Map<String, JsonElement> args = internal3.getFunctionCall().getArgs();
            if (args == null) {
                args = MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(args.size()));
            Iterator it = args.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Object obj = (JsonElement) entry.getValue();
                if (obj == null) {
                    obj = JsonNull.INSTANCE;
                }
                linkedHashMap.put(key, obj);
            }
            String id = internal3.getFunctionCall().getId();
            Boolean thought4 = internal3.getThought();
            return new FunctionCallPart(name, linkedHashMap, id, thought4 != null ? thought4.booleanValue() : false, internal3.getThoughtSignature());
        }
        if (internalPart instanceof FunctionResponsePart.Internal) {
            FunctionResponsePart.Internal internal4 = (FunctionResponsePart.Internal) internalPart;
            String name2 = internal4.getFunctionResponse().getName();
            JsonObject response = internal4.getFunctionResponse().getResponse();
            String id2 = internal4.getFunctionResponse().getId();
            List<InternalPart> parts = internal4.getFunctionResponse().getParts();
            if (parts != null) {
                List<InternalPart> list = parts;
                EmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    EmptyList.add(toPublic((InternalPart) it2.next()));
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            ?? r6 = EmptyList;
            Boolean thought5 = internal4.getThought();
            return new FunctionResponsePart(name2, response, id2, (List<? extends Part>) r6, thought5 != null ? thought5.booleanValue() : false, internal4.getThoughtSignature());
        }
        if (internalPart instanceof FileDataPart.Internal) {
            FileDataPart.Internal internal5 = (FileDataPart.Internal) internalPart;
            String mimeType2 = internal5.getFileData().getMimeType();
            String fileUri = internal5.getFileData().getFileUri();
            Boolean thought6 = internal5.getThought();
            return new FileDataPart(mimeType2, fileUri, thought6 != null ? thought6.booleanValue() : false, internal5.getThoughtSignature());
        }
        if (internalPart instanceof ExecutableCodePart.Internal) {
            ExecutableCodePart.Internal internal6 = (ExecutableCodePart.Internal) internalPart;
            String language = internal6.getExecutableCode().getLanguage();
            String code = internal6.getExecutableCode().getCode();
            Boolean thought7 = internal6.getThought();
            return new ExecutableCodePart(language, code, thought7 != null ? thought7.booleanValue() : false, internal6.getThoughtSignature());
        }
        if (internalPart instanceof CodeExecutionResultPart.Internal) {
            CodeExecutionResultPart.Internal internal7 = (CodeExecutionResultPart.Internal) internalPart;
            String outcome = internal7.getCodeExecutionResult().getOutcome();
            String output = internal7.getCodeExecutionResult().getOutput();
            Boolean thought8 = internal7.getThought();
            return new CodeExecutionResultPart(outcome, output, thought8 != null ? thought8.booleanValue() : false, internal7.getThoughtSignature());
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (internalPart instanceof UnknownPart.Internal) {
            return new UnknownPart(z, 1, defaultConstructorMarker);
        }
        throw new SerializationException("Unsupported part type \"" + internalPart.getClass().getSimpleName() + "\" provided. This model may not be supported by this SDK.", null, 2, null);
    }
}
