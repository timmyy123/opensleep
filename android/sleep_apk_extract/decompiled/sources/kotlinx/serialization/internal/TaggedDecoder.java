package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00028\u0000*\u00020\u00072\u0006\u0010\t\u001a\u00020\bH$¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u0007H\u0014¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010*\u001a\u00020\u0007H\u0014¢\u0006\u0004\b+\u0010,J3\u00101\u001a\u00028\u0001\"\n\b\u0001\u0010-*\u0004\u0018\u00010\u00012\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010.2\b\u00100\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\r¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0010¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0013¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\b¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0018¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u001b¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\u001e¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020!¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020$¢\u0006\u0004\bI\u0010JJ\u0015\u0010K\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0007¢\u0006\u0004\bK\u0010LJ\u001d\u0010M\u001a\u00020\r2\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bM\u0010NJ\u001d\u0010O\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bO\u0010PJ\u001d\u0010Q\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bQ\u0010RJ\u001d\u0010S\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bS\u0010TJ\u001d\u0010U\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bU\u0010VJ\u001d\u0010W\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bW\u0010XJ\u001d\u0010Y\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bY\u0010ZJ\u001d\u0010[\u001a\u00020!2\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b[\u0010\\J\u001d\u0010]\u001a\u00020$2\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b]\u0010^J\u001d\u0010_\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b_\u0010`JA\u0010a\u001a\u00028\u0001\"\n\b\u0001\u0010-*\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010.2\b\u00100\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\ba\u0010bJC\u0010c\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010-*\u00020\u00012\u0006\u00103\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010.2\b\u00100\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\bc\u0010bJ\u0017\u0010f\u001a\u00020e2\u0006\u0010d\u001a\u00028\u0000H\u0004¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00028\u0000H\u0004¢\u0006\u0004\bh\u0010iJ+\u0010m\u001a\u00028\u0001\"\u0004\b\u0001\u0010j2\u0006\u0010\f\u001a\u00028\u00002\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00010kH\u0002¢\u0006\u0004\bm\u0010nR*\u0010q\u001a\u0012\u0012\u0004\u0012\u00028\u00000oj\b\u0012\u0004\u0012\u00028\u0000`p8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bw\u0010i¨\u0006y"}, d2 = {"Lkotlinx/serialization/internal/TaggedDecoder;", "", "Tag", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "tag", "", "decodeTaggedBoolean", "(Ljava/lang/Object;)Z", "", "decodeTaggedByte", "(Ljava/lang/Object;)B", "", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedInt", "(Ljava/lang/Object;)I", "", "decodeTaggedLong", "(Ljava/lang/Object;)J", "", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "", "decodeTaggedChar", "(Ljava/lang/Object;)C", "", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "enumDescriptor", "decodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "inlineDescriptor", "decodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "previousValue", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "descriptor", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "", "decodeNull", "()Ljava/lang/Void;", "decodeBoolean", "()Z", "decodeByte", "()B", "decodeShort", "()S", "decodeInt", "()I", "decodeLong", "()J", "decodeFloat", "()F", "decodeDouble", "()D", "decodeChar", "()C", "decodeString", "()Ljava/lang/String;", "decodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "decodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)B", "decodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)S", "decodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)I", "decodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)J", "decodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)F", "decodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)D", "decodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)C", "decodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "decodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "name", "", "pushTag", "(Ljava/lang/Object;)V", "popTag", "()Ljava/lang/Object;", "E", "Lkotlin/Function0;", "block", "tagBlock", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagStack", "Ljava/util/ArrayList;", "getTagStack$kotlinx_serialization_core", "()Ljava/util/ArrayList;", "flag", "Z", "getCurrentTagOrNull", "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {
    private boolean flag;
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object decodeNullableSerializableElement$lambda$3(TaggedDecoder taggedDecoder, DeserializationStrategy deserializationStrategy, Object obj) {
        return (deserializationStrategy.getDescriptor().isNullable() || taggedDecoder.decodeNotNullMark()) ? taggedDecoder.decodeSerializableValue(deserializationStrategy, obj) : taggedDecoder.decodeNull();
    }

    private final <E> E tagBlock(Tag tag, Function0<? extends E> block) {
        pushTag(tag);
        E eInvoke = block.invoke();
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return eInvoke;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedBoolean(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return decodeTaggedByte(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedByte(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return decodeTaggedChar(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedChar(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.decodeCollectionSize(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return decodeTaggedDouble(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedDouble(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        enumDescriptor.getClass();
        return decodeTaggedEnum(popTag(), enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return decodeTaggedFloat(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedFloat(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        descriptor.getClass();
        return decodeTaggedInline(popTag(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder decodeInlineElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedInline(getTag(descriptor, index), descriptor.getElementDescriptor(index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return decodeTaggedInt(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedInt(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return decodeTaggedLong(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedLong(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void decodeNull() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeNullableSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<? extends T> deserializer, T previousValue) {
        descriptor.getClass();
        deserializer.getClass();
        return (T) tagBlock(getTag(descriptor, index), new TaggedDecoder$$ExternalSyntheticLambda0(this, deserializer, previousValue, 1));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeSequentially() {
        return CompositeDecoder.DefaultImpls.decodeSequentially(this);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<? extends T> deserializer, T previousValue) {
        descriptor.getClass();
        deserializer.getClass();
        return (T) tagBlock(getTag(descriptor, index), new TaggedDecoder$$ExternalSyntheticLambda0(this, deserializer, previousValue, 0));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy);

    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer, T previousValue) {
        deserializer.getClass();
        return (T) decodeSerializableValue(deserializer);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return decodeTaggedShort(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedShort(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return decodeTaggedString(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String decodeStringElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        return decodeTaggedString(getTag(descriptor, index));
    }

    public abstract boolean decodeTaggedBoolean(Tag tag);

    public abstract byte decodeTaggedByte(Tag tag);

    public abstract char decodeTaggedChar(Tag tag);

    public abstract double decodeTaggedDouble(Tag tag);

    public abstract int decodeTaggedEnum(Tag tag, SerialDescriptor enumDescriptor);

    public abstract float decodeTaggedFloat(Tag tag);

    public Decoder decodeTaggedInline(Tag tag, SerialDescriptor inlineDescriptor) {
        inlineDescriptor.getClass();
        pushTag(tag);
        return this;
    }

    public abstract int decodeTaggedInt(Tag tag);

    public abstract long decodeTaggedLong(Tag tag);

    public abstract short decodeTaggedShort(Tag tag);

    public abstract String decodeTaggedString(Tag tag);

    public final Tag getCurrentTagOrNull() {
        return (Tag) CollectionsKt.lastOrNull((List) this.tagStack);
    }

    public abstract Tag getTag(SerialDescriptor serialDescriptor, int i);

    public final ArrayList<Tag> getTagStack$kotlinx_serialization_core() {
        return this.tagStack;
    }

    public final Tag popTag() {
        ArrayList<Tag> arrayList = this.tagStack;
        Tag tagRemove = arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        this.flag = true;
        return tagRemove;
    }

    public final void pushTag(Tag name) {
        this.tagStack.add(name);
    }
}
