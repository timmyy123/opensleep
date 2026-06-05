package kotlinx.serialization.json.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonEncoder;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\t\u0010\n\u001aC\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"T", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "writer", "Lkotlinx/serialization/SerializationStrategy;", "serializer", SDKConstants.PARAM_VALUE, "", "encodeByWriter", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "reader", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "Lkotlinx/serialization/json/DecodeSequenceMode;", "format", "Lkotlin/sequences/Sequence;", "decodeToSequenceByReader", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/InternalJsonReader;Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/DecodeSequenceMode;)Lkotlin/sequences/Sequence;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class JsonStreamsKt {
    public static final <T> Sequence<T> decodeToSequenceByReader(Json json, InternalJsonReader internalJsonReader, DeserializationStrategy<? extends T> deserializationStrategy, DecodeSequenceMode decodeSequenceMode) {
        json.getClass();
        internalJsonReader.getClass();
        deserializationStrategy.getClass();
        decodeSequenceMode.getClass();
        final Iterator itJsonIterator = JsonIteratorKt.JsonIterator(decodeSequenceMode, json, ReaderJsonLexerKt.ReaderJsonLexer(json, internalJsonReader, new char[16384]), deserializationStrategy);
        return SequencesKt.constrainOnce(new Sequence<T>() { // from class: kotlinx.serialization.json.internal.JsonStreamsKt$decodeToSequenceByReader$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return itJsonIterator;
            }
        });
    }

    public static final <T> void encodeByWriter(Json json, InternalJsonWriter internalJsonWriter, SerializationStrategy<? super T> serializationStrategy, T t) {
        json.getClass();
        internalJsonWriter.getClass();
        serializationStrategy.getClass();
        new StreamingJsonEncoder(internalJsonWriter, json, WriteMode.OBJ, new JsonEncoder[WriteMode.getEntries().size()]).encodeSerializableValue(serializationStrategy, t);
    }
}
