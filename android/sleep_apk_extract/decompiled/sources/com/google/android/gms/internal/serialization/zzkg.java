package com.google.android.gms.internal.serialization;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.home.CommandDescriptor;
import com.google.home.Descriptor;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.EventFactory;
import com.google.home.FactoryRegistry;
import com.google.home.Field;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.HomeException;
import com.google.home.HomeManager;
import com.google.home.InternalTraitFactory;
import com.google.home.NoOpDescriptor;
import com.google.home.StructDescriptor;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.Type;
import com.google.home.automation.JoinSemanticType;
import com.google.home.automation.UnknownField;
import com.google.home.automation.UnknownValue;
import com.google.home.google.ExtendedModeSelectTrait;
import com.google.home.google.PlatformTraitFactory;
import com.google.home.google.TimeTrait$SolarTimeType;
import com.google.home.matter.MatterTraitFactory;
import com.google.home.matter.serialization.Bitmap;
import com.google.home.matter.standard.ModeSettingSerializer;
import com.google.home.platform.traits.MapValue;
import com.google.home.platform.traits.Parameter;
import com.google.home.platform.traits.SolarTime;
import com.google.home.platform.traits.Value;
import j$.time.DayOfWeek;
import j$.time.Duration;
import j$.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000à\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\r\u001a\u00020\u0003*\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0011\u001a\u00020\u0003*\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0015\u001a\u00020\u0003*\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u001a\u001a\u00020\u0017*\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010!\u001a\u00020\u0017*\u00020\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010%\u001a\u00020\u0017*\u00020\"H\u0000¢\u0006\u0004\b#\u0010$J\u0013\u0010)\u001a\u00020\u0017*\u00020&H\u0000¢\u0006\u0004\b'\u0010(J\u0013\u0010-\u001a\u00020\u0017*\u00020*H\u0000¢\u0006\u0004\b+\u0010,J\u0013\u00101\u001a\u00020\u0017*\u00020.H\u0000¢\u0006\u0004\b/\u00100J\u0013\u00105\u001a\u00020\u0017*\u000202H\u0000¢\u0006\u0004\b3\u00104J\u0013\u00109\u001a\u00020\u0017*\u000206H\u0000¢\u0006\u0004\b7\u00108J\u0013\u0010=\u001a\u00020\u0017*\u00020:H\u0000¢\u0006\u0004\b;\u0010<J\u0013\u0010A\u001a\u00020\u0017*\u00020>H\u0000¢\u0006\u0004\b?\u0010@J\u0013\u0010E\u001a\u00020\u0017*\u00020BH\u0000¢\u0006\u0004\bC\u0010DJ\u0013\u0010I\u001a\u00020\u0017*\u00020FH\u0000¢\u0006\u0004\bG\u0010HJ\u0013\u0010M\u001a\u00020\u0017*\u00020JH\u0000¢\u0006\u0004\bK\u0010LJ\u0013\u0010Q\u001a\u00020\u0017*\u00020NH\u0000¢\u0006\u0004\bO\u0010PJ\u0013\u0010U\u001a\u00020\u0017*\u00020RH\u0000¢\u0006\u0004\bS\u0010TJ\u0013\u0010Y\u001a\u00020\u0017*\u00020VH\u0000¢\u0006\u0004\bW\u0010XJ\u0013\u0010]\u001a\u00020\u0017*\u00020ZH\u0000¢\u0006\u0004\b[\u0010\\J\u0013\u0010a\u001a\u00020\u0017*\u00020^H\u0000¢\u0006\u0004\b_\u0010`J\u0013\u0010e\u001a\u00020\u0017*\u00020bH\u0000¢\u0006\u0004\bc\u0010dJ\u0013\u0010i\u001a\u00020\u0017*\u00020fH\u0000¢\u0006\u0004\bg\u0010hJ\u0013\u0010m\u001a\u00020\u0017*\u00020jH\u0000¢\u0006\u0004\bk\u0010lJ\u0013\u0010q\u001a\u00020\u0017*\u00020nH\u0000¢\u0006\u0004\bo\u0010pJ\u001f\u0010u\u001a\u00020\u0017*\u00020n2\n\u0010t\u001a\u00060rj\u0002`sH\u0002¢\u0006\u0004\bu\u0010vJ\u0013\u0010z\u001a\u00020\u0017*\u00020wH\u0000¢\u0006\u0004\bx\u0010yJ\u0013\u0010~\u001a\u00020\u0003*\u00020{H\u0000¢\u0006\u0004\b|\u0010}J\u0016\u0010\u0082\u0001\u001a\u00020\u0003*\u00020\u007fH\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001JV\u0010\u008f\u0001\u001a\u00030\u008c\u0001*\u00030\u0083\u00012\u0013\u0010\u0086\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0085\u0001\u0018\u00010\u0084\u00012\u0013\u0010\u0089\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0088\u0001\u0018\u00010\u0087\u00012\u0012\u0010\u008b\u0001\u001a\r\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u008a\u0001H\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J[\u0010\u0094\u0001\u001a\u00030\u008c\u00012\b\u0010\u0091\u0001\u001a\u00030\u0090\u00012\u0013\u0010\u0086\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0085\u0001\u0018\u00010\u0084\u00012\u0013\u0010\u0089\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0088\u0001\u0018\u00010\u0087\u00012\u0012\u0010\u008b\u0001\u001a\r\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u008a\u0001H\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J9\u0010\u0098\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u0088\u00010\u0087\u00012\b\u0010\u0086\u0001\u001a\u00030\u0095\u00012\u0011\u0010\u0089\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u0088\u00010\u0087\u0001H\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J9\u0010\u009a\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u0088\u00010\u0087\u00012\b\u0010\u0086\u0001\u001a\u00030\u0095\u00012\u0011\u0010\u0089\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u0088\u00010\u0087\u0001H\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u0097\u0001J\u0017\u0010\u009e\u0001\u001a\u00020\u0003*\u00030\u009b\u0001H\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0018\u0010¢\u0001\u001a\u00030\u009f\u0001*\u00030\u009b\u0001H\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0017\u0010¦\u0001\u001a\u00020\u0003*\u00030£\u0001H\u0000¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0017\u0010ª\u0001\u001a\u00020\u0003*\u00030§\u0001H\u0000¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001d\u0010°\u0001\u001a\u00030\u00ad\u00012\b\u0010¬\u0001\u001a\u00030«\u0001H\u0000¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u0017\u0010´\u0001\u001a\u00020\u0003*\u00030±\u0001H\u0000¢\u0006\u0006\b²\u0001\u0010³\u0001J\u0017\u0010¸\u0001\u001a\u00020\u0003*\u00030µ\u0001H\u0000¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u0018\u0010½\u0001\u001a\u00030º\u0001*\u00030¹\u0001H\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J&\u0010Â\u0001\u001a\u00030¿\u0001*\u0011\u0012\u0004\u0012\u00020f\u0012\u0006\u0012\u0004\u0018\u00010\u00010¾\u0001H\u0000¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0018\u0010Â\u0001\u001a\u00030¿\u0001*\u00030Ã\u0001H\u0000¢\u0006\u0006\bÀ\u0001\u0010Ä\u0001J\u0019\u0010È\u0001\u001a\u00030Å\u0001*\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J/\u0010Ï\u0001\u001a\u00020V*\u00030Å\u00012\b\u0010Ê\u0001\u001a\u00030É\u00012\f\b\u0002\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0000¢\u0006\u0006\bÍ\u0001\u0010Î\u0001JP\u0010Ô\u0001\u001a\u0011\u0012\u0004\u0012\u00020f\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ñ\u0001*\u00030¿\u00012\b\u0010Ê\u0001\u001a\u00030É\u00012\u0015\b\u0002\u0010\u0089\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0088\u0001\u0018\u00010\u0087\u00012\u0007\u0010Ð\u0001\u001a\u00020\u0001H\u0000¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001JC\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0001*\u00030Å\u00012\b\u0010Ê\u0001\u001a\u00030É\u00012\u0013\u0010Õ\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0088\u0001\u0018\u00010\u0087\u00012\t\u0010Ö\u0001\u001a\u0004\u0018\u00010fH\u0000¢\u0006\u0006\b×\u0001\u0010Ø\u0001J#\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0001*\u00030Å\u00012\b\u0010Ê\u0001\u001a\u00030É\u0001H\u0000¢\u0006\u0006\b×\u0001\u0010Ú\u0001J\u0018\u0010ß\u0001\u001a\u00030Ü\u0001*\u00030Û\u0001H\u0000¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001J\u0018\u0010â\u0001\u001a\u00030Û\u0001*\u00030Ü\u0001H\u0000¢\u0006\u0006\bà\u0001\u0010á\u0001R\u0018\u0010ã\u0001\u001a\u00030\u0095\u00018\u0002X\u0082T¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u0018\u0010æ\u0001\u001a\u00030å\u00018\u0002X\u0082T¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u0018\u0010è\u0001\u001a\u00030å\u00018\u0002X\u0082T¢\u0006\b\n\u0006\bè\u0001\u0010ç\u0001R\u0018\u0010ê\u0001\u001a\u00030é\u00018\u0002X\u0082T¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R\u0018\u0010ì\u0001\u001a\u00030\u0095\u00018\u0002X\u0082T¢\u0006\b\n\u0006\bì\u0001\u0010ä\u0001R\u0018\u0010í\u0001\u001a\u00030\u0095\u00018\u0002X\u0082T¢\u0006\b\n\u0006\bí\u0001\u0010ä\u0001R\u0018\u0010î\u0001\u001a\u00030\u0095\u00018\u0006X\u0086T¢\u0006\b\n\u0006\bî\u0001\u0010ä\u0001R\u0018\u0010ï\u0001\u001a\u00030\u0095\u00018\u0006X\u0086T¢\u0006\b\n\u0006\bï\u0001\u0010ä\u0001R\u0018\u0010ð\u0001\u001a\u00030\u0095\u00018\u0002X\u0082T¢\u0006\b\n\u0006\bð\u0001\u0010ä\u0001RG\u0010ó\u0001\u001a-\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u0095\u0001\u0012\u0005\u0012\u00030\u0095\u00010Ñ\u0001j\u0003`ò\u0001\u0012\u000e\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u0088\u00010\u0087\u00010ñ\u00018\u0006¢\u0006\u0010\n\u0006\bó\u0001\u0010ô\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001R$\u0010ø\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010÷\u00018\u0006¢\u0006\u0010\n\u0006\bø\u0001\u0010ù\u0001\u001a\u0006\bú\u0001\u0010û\u0001¨\u0006ü\u0001"}, d2 = {"Lcom/google/home/automation/serialization/AutomationConverter$Companion;", "", "Lcom/google/home/automation/Node;", "Lcom/google/home/platform/traits/Node;", "toNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Node;)Lcom/google/home/platform/traits/Node;", "toNodeProto", "node", "addNodeId", "(Lcom/google/home/platform/traits/Node;Lcom/google/home/automation/Node;)Lcom/google/home/platform/traits/Node;", "Lcom/google/home/automation/ManualStarter;", "toManualStarterNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ManualStarter;)Lcom/google/home/platform/traits/Node;", "toManualStarterNodeProto", "Lcom/google/home/automation/Starter;", "toStarterNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Starter;)Lcom/google/home/platform/traits/Node;", "toStarterNodeProto", "Lcom/google/home/automation/Condition;", "toConditionNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Condition;)Lcom/google/home/platform/traits/Node;", "toConditionNodeProto", "Lcom/google/home/automation/Expression;", "Lcom/google/home/platform/traits/Operand;", "toOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Expression;)Lcom/google/home/platform/traits/Operand;", "toOperandProto", "expression", "addExpressionId", "(Lcom/google/home/platform/traits/Operand;Lcom/google/home/automation/Expression;)Lcom/google/home/platform/traits/Operand;", "Lcom/google/home/automation/MapSize;", "toMapSizeOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/MapSize;)Lcom/google/home/platform/traits/Operand;", "toMapSizeOperandProto", "Lcom/google/home/automation/MapValues;", "toMapValuesOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/MapValues;)Lcom/google/home/platform/traits/Operand;", "toMapValuesOperandProto", "Lcom/google/home/automation/MapKeys;", "toMapKeysOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/MapKeys;)Lcom/google/home/platform/traits/Operand;", "toMapKeysOperandProto", "Lcom/google/home/automation/MapFilter;", "toMapFilterOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/MapFilter;)Lcom/google/home/platform/traits/Operand;", "toMapFilterOperandProto", "Lcom/google/home/automation/GetDevicesOfType;", "toGetDevicesOfTypeOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/GetDevicesOfType;)Lcom/google/home/platform/traits/Operand;", "toGetDevicesOfTypeOperandProto", "Lcom/google/home/automation/ListSize;", "toListSizeOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListSize;)Lcom/google/home/platform/traits/Operand;", "toListSizeOperandProto", "Lcom/google/home/automation/ListIn;", "toListInOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListIn;)Lcom/google/home/platform/traits/Operand;", "toListInOperandProto", "Lcom/google/home/automation/ListContains;", "toListContainsOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListContains;)Lcom/google/home/platform/traits/Operand;", "toListContainsOperandProto", "Lcom/google/home/automation/ListGet;", "toListGetOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListGet;)Lcom/google/home/platform/traits/Operand;", "toListGetOperandProto", "Lcom/google/home/automation/ListAnyMatch;", "toListAnyMatchOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListAnyMatch;)Lcom/google/home/platform/traits/Operand;", "toListAnyMatchOperandProto", "Lcom/google/home/automation/ListAllMatch;", "toListAllMatchOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListAllMatch;)Lcom/google/home/platform/traits/Operand;", "toListAllMatchOperandProto", "Lcom/google/home/automation/ListNoneMatch;", "toListNoneMatchOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListNoneMatch;)Lcom/google/home/platform/traits/Operand;", "toListNoneMatchOperandProto", "Lcom/google/home/automation/ListMap;", "toListMapOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListMap;)Lcom/google/home/platform/traits/Operand;", "toListMapOperandProto", "Lcom/google/home/automation/ListFilter;", "toListFilterOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ListFilter;)Lcom/google/home/platform/traits/Operand;", "toListFilterOperandProto", "Lcom/google/home/automation/Constant;", "toConstantOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Constant;)Lcom/google/home/platform/traits/Operand;", "toConstantOperandProto", "Lcom/google/home/automation/Reference;", "toReferenceOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Reference;)Lcom/google/home/platform/traits/Operand;", "toReferenceOperandProto", "Lcom/google/home/automation/ReferenceDeclaration;", "toReferenceDeclarationOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ReferenceDeclaration;)Lcom/google/home/platform/traits/Operand;", "toReferenceDeclarationOperandProto", "Lcom/google/home/automation/FieldSelect;", "toFieldSelectOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/FieldSelect;)Lcom/google/home/platform/traits/Operand;", "toFieldSelectOperandProto", "Lcom/google/home/Field;", "toFieldOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/Field;)Lcom/google/home/platform/traits/Operand;", "toFieldOperandProto", "Lcom/google/home/automation/UnaryExpression;", "toUnaryExpressionOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/UnaryExpression;)Lcom/google/home/platform/traits/Operand;", "toUnaryExpressionOperandProto", "Lcom/google/home/automation/BinaryExpression;", "toBinaryExpressionOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/BinaryExpression;)Lcom/google/home/platform/traits/Operand;", "toBinaryExpressionOperandProto", "Lcom/google/home/platform/traits/Expression$Operator;", "Lcom/google/home/automation/serialization/OperatorProto;", "op", "flattenToBinaryExpressionOperandProto", "(Lcom/google/home/automation/BinaryExpression;Lcom/google/home/platform/traits/Expression$Operator;)Lcom/google/home/platform/traits/Operand;", "Lcom/google/home/automation/TernaryExpression;", "toTernaryExpressionOperandProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/TernaryExpression;)Lcom/google/home/platform/traits/Operand;", "toTernaryExpressionOperandProto", "Lcom/google/home/automation/StateReader;", "toStateReaderNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/StateReader;)Lcom/google/home/platform/traits/Node;", "toStateReaderNodeProto", "Lcom/google/home/automation/Action;", "toActionNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Action;)Lcom/google/home/platform/traits/Node;", "toActionNodeProto", "Lcom/google/home/HasId;", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/DeviceType;", "deviceType", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "trait", "Lcom/google/home/EventFactory;", "event", "Lcom/google/home/platform/traits/Entity;", "toEntityProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/HasId;Lcom/google/home/DeviceTypeFactory;Lcom/google/home/TraitFactory;Lcom/google/home/EventFactory;)Lcom/google/home/platform/traits/Entity;", "toEntityProto", "Lcom/google/home/HomeDevice;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "convertDeviceToEntityProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/HomeDevice;Lcom/google/home/DeviceTypeFactory;Lcom/google/home/TraitFactory;Lcom/google/home/EventFactory;)Lcom/google/home/platform/traits/Entity;", "convertDeviceToEntityProto", "", "handleTraitMapping$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Ljava/lang/String;Lcom/google/home/TraitFactory;)Lcom/google/home/TraitFactory;", "handleTraitMapping", "handleSimplifiedOnOffTrait$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "handleSimplifiedOnOffTrait", "Lcom/google/home/automation/SequentialFlow;", "toSequentialFlowNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/SequentialFlow;)Lcom/google/home/platform/traits/Node;", "toSequentialFlowNodeProto", "Lcom/google/home/platform/traits/SequentialFlow;", "toSequentialFlowProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/SequentialFlow;)Lcom/google/home/platform/traits/SequentialFlow;", "toSequentialFlowProto", "Lcom/google/home/automation/ParallelFlow;", "toParallelFlowNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/ParallelFlow;)Lcom/google/home/platform/traits/Node;", "toParallelFlowNodeProto", "Lcom/google/home/automation/SelectFlow;", "toSelectFlowNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/SelectFlow;)Lcom/google/home/platform/traits/Node;", "toSelectFlowNodeProto", "Lcom/google/home/automation/JoinSemanticType;", "joinSemantic", "Lcom/google/home/platform/traits/ParallelFlow$JoinSemantic;", "toJoinedSemanticProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/JoinSemanticType;)Lcom/google/home/platform/traits/ParallelFlow$JoinSemantic;", "toJoinedSemanticProto", "Lcom/google/home/automation/Delay;", "toDelayNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Delay;)Lcom/google/home/platform/traits/Node;", "toDelayNodeProto", "Lcom/google/home/automation/Suppression;", "toSuppressionNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/Suppression;)Lcom/google/home/platform/traits/Node;", "toSuppressionNodeProto", "j$/time/DayOfWeek", "Lcom/google/type/DayOfWeek;", "toDayOfWeekProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lj$/time/DayOfWeek;)Lcom/google/type/DayOfWeek;", "toDayOfWeekProto", "", "Lcom/google/home/platform/traits/Parameter;", "toParameterProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Ljava/util/Map$Entry;)Lcom/google/home/platform/traits/Parameter;", "toParameterProto", "Lcom/google/home/automation/Parameter;", "(Lcom/google/home/automation/Parameter;)Lcom/google/home/platform/traits/Parameter;", "Lcom/google/home/platform/traits/Value;", "toValueProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Ljava/lang/Object;)Lcom/google/home/platform/traits/Value;", "toValueProto", "Lcom/google/home/HomeManager;", "homeManager", "Lcom/google/home/automation/serialization/ConstantWithType;", "constantWithType", "fromValueProtoToConstant$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/Value;Lcom/google/home/HomeManager;Lcom/google/home/automation/serialization/ConstantWithType;)Lcom/google/home/automation/Constant;", "fromValueProtoToConstant", "fieldFactory", "Lkotlin/Pair;", "fromParameterProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/Parameter;Lcom/google/home/HomeManager;Lcom/google/home/TraitFactory;Ljava/lang/Object;)Lkotlin/Pair;", "fromParameterProto", "traitFactory", "field", "fromValueProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/Value;Lcom/google/home/HomeManager;Lcom/google/home/TraitFactory;Lcom/google/home/Field;)Ljava/lang/Object;", "fromValueProto", "(Lcom/google/home/platform/traits/Value;Lcom/google/home/HomeManager;)Ljava/lang/Object;", "j$/time/Duration", "Lcom/google/protobuf/Duration;", "toNormalizedDurationProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lj$/time/Duration;)Lcom/google/protobuf/Duration;", "toNormalizedDurationProto", "toDuration$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/protobuf/Duration;)Lj$/time/Duration;", "toDuration", "DOT", "Ljava/lang/String;", "Lkotlin/UInt;", "THOUSAND", "I", "MILLION", "", "NANOS_PER_SECOND", "J", "PRESENCE_STATE_TYPE_ID", "ATTENDANCE_STATE_TYPE_ID", "BITMAP_VALUE_TYPE_ID_DELIMITER", "ENUM_VALUE_TYPE_ID_DELIMITER", "ROOT_NODE_ID", "", "Lcom/google/home/automation/serialization/DeviceTypeIdToTraitId;", "SYNTHETIC_TO_MATTER_MAPPING", "Ljava/util/Map;", "getSYNTHETIC_TO_MATTER_MAPPING", "()Ljava/util/Map;", "", "INVALID_DEVICE_TYPE_IDS_FOR_SIMPLIFIED_ON_OFF", "Ljava/util/Set;", "getINVALID_DEVICE_TYPE_IDS_FOR_SIMPLIFIED_ON_OFF", "()Ljava/util/Set;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzkg {
    public /* synthetic */ zzkg(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final Duration zzh(zzyl zzylVar) {
        zzylVar.getClass();
        Duration durationOfSeconds = Duration.ofSeconds(zzylVar.zza(), zzylVar.zzb());
        durationOfSeconds.getClass();
        return durationOfSeconds;
    }

    public static final Object zzr(Value value, HomeManager homeManager) throws HomeException {
        Object factory;
        value.getClass();
        homeManager.getClass();
        FactoryRegistry factoryRegistry = ((zzpu) homeManager).getZzb().getFactoryRegistry();
        Value.ValueCase valueCase = value.getValueCase();
        JoinSemanticType joinSemanticType = JoinSemanticType.JsWhenAllFinished;
        TimeTrait$SolarTimeType timeTrait$SolarTimeType = TimeTrait$SolarTimeType.Sunrise;
        Type type = Type.Dynamic;
        SolarTime.SolarTimeType solarTimeType = SolarTime.SolarTimeType.UNKNOWN;
        Value.ValueCase valueCase2 = Value.ValueCase.INT_VALUE;
        switch (valueCase) {
            case INT_VALUE:
                return Integer.valueOf(value.getIntValue());
            case LONG_VALUE:
                return Long.valueOf(value.getLongValue());
            case UINT_VALUE:
                return UInt.m2388boximpl(UInt.m2389constructorimpl(value.getUintValue()));
            case ULONG_VALUE:
                return ULong.m2410boximpl(ULong.m2411constructorimpl(value.getUlongValue()));
            case FLOAT_VALUE:
                return Float.valueOf(value.getFloatValue());
            case DOUBLE_VALUE:
                return Double.valueOf(value.getDoubleValue());
            case STRING_VALUE:
                return value.getStringValue();
            case BOOL_VALUE:
                return Boolean.valueOf(value.getBoolValue());
            case BYTES_VALUE:
                return value.getBytesValue().zzn();
            case ENUM_VALUE:
                String typeId = value.getEnumValue().getTypeId();
                typeId.getClass();
                if (zzku.zza(typeId)) {
                    String typeId2 = value.getEnumValue().getTypeId();
                    typeId2.getClass();
                    String strSubstringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(typeId2, ".enum.", (String) null, 2, (Object) null);
                    String typeId3 = value.getEnumValue().getTypeId();
                    typeId3.getClass();
                    String strSubstringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(typeId3, ".enum.", (String) null, 2, (Object) null);
                    TraitFactory<? extends Trait> traitOrNull = factoryRegistry.getTraitOrNull(strSubstringBeforeLast$default);
                    factory = traitOrNull != null ? traitOrNull.getFactory() : null;
                    if (factory instanceof MatterTraitFactory) {
                        return zzmp.zza((MatterTraitFactory) factory, strSubstringAfterLast$default).m557toRuntimeVKZWuLQ(ULong.m2411constructorimpl(value.getEnumValue().getId()));
                    }
                    byte[] byteArray = value.toByteArray();
                    byteArray.getClass();
                    return new UnknownValue(byteArray);
                }
                String typeId4 = value.getEnumValue().getTypeId();
                typeId4.getClass();
                String strSubstringBeforeLast$default2 = StringsKt__StringsKt.substringBeforeLast$default(typeId4, ".", (String) null, 2, (Object) null);
                String typeId5 = value.getEnumValue().getTypeId();
                typeId5.getClass();
                String strSubstringAfterLast$default2 = StringsKt__StringsKt.substringAfterLast$default(typeId5, ".", (String) null, 2, (Object) null);
                TraitFactory<? extends Trait> traitOrNull2 = factoryRegistry.getTraitOrNull(strSubstringBeforeLast$default2);
                Object factory2 = traitOrNull2 != null ? traitOrNull2.getFactory() : null;
                if (factory2 instanceof PlatformTraitFactory) {
                    zzmp.zzb((PlatformTraitFactory) factory2, strSubstringAfterLast$default2);
                    value.getEnumValue().getName().getClass();
                    throw null;
                }
                byte[] byteArray2 = value.toByteArray();
                byteArray2.getClass();
                return new UnknownValue(byteArray2);
            case LIST_VALUE:
                List<Value> elementsList = value.getListValue().getElementsList();
                elementsList.getClass();
                List<Value> list = elementsList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (Value value2 : list) {
                    zzkg zzkgVar = zzkt.zza;
                    value2.getClass();
                    arrayList.add(zzr(value2, homeManager));
                }
                return CollectionsKt.toList(arrayList);
            case MAP_VALUE:
                List<MapValue.Entry> entriesList = value.getMapValue().getEntriesList();
                entriesList.getClass();
                List<MapValue.Entry> list2 = entriesList;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (MapValue.Entry entry : list2) {
                    zzkg zzkgVar2 = zzkt.zza;
                    Value key = entry.getKey();
                    key.getClass();
                    Object objZzr = zzr(key, homeManager);
                    Value value3 = entry.getValue();
                    value3.getClass();
                    arrayList2.add(TuplesKt.to(objZzr, zzr(value3, homeManager)));
                }
                return MapsKt.toMap(arrayList2);
            case STRUCT_VALUE:
            case VALUE_NOT_SET:
                byte[] byteArray3 = value.toByteArray();
                byteArray3.getClass();
                return new UnknownValue(byteArray3);
            case BITMAP_VALUE:
                String typeId6 = value.getBitmapValue().getTypeId();
                typeId6.getClass();
                String strSubstringBeforeLast$default3 = StringsKt__StringsKt.substringBeforeLast$default(typeId6, ".bitmap.", (String) null, 2, (Object) null);
                String typeId7 = value.getBitmapValue().getTypeId();
                typeId7.getClass();
                String strSubstringAfterLast$default3 = StringsKt__StringsKt.substringAfterLast$default(typeId7, ".bitmap.", (String) null, 2, (Object) null);
                TraitFactory<? extends Trait> traitOrNull3 = factoryRegistry.getTraitOrNull(strSubstringBeforeLast$default3);
                factory = traitOrNull3 != null ? traitOrNull3.getFactory() : null;
                if (factory instanceof MatterTraitFactory) {
                    return zzmp.zzc((MatterTraitFactory) factory, strSubstringAfterLast$default3).toRuntime(Bitmap.INSTANCE.m528toRuntimeVKZWuLQ(ULong.m2411constructorimpl(value.getBitmapValue().getValue())));
                }
                byte[] byteArray4 = value.toByteArray();
                byteArray4.getClass();
                return new UnknownValue(byteArray4);
            case TIME_OF_DAY:
                return LocalTime.of(value.getTimeOfDay().zza(), value.getTimeOfDay().zzb(), value.getTimeOfDay().zzc(), value.getTimeOfDay().zzd());
            case DAY_OF_WEEK:
                if (value.getDayOfWeek().getNumber() <= 0) {
                    byte[] byteArray5 = value.toByteArray();
                    byteArray5.getClass();
                    return new UnknownValue(byteArray5);
                }
                value.getDayOfWeek().getNumber();
                DayOfWeek dayOfWeekOf = DayOfWeek.of(value.getDayOfWeek().getNumber());
                dayOfWeekOf.getClass();
                return dayOfWeekOf;
            case SOLAR_TIME:
                int iOrdinal = value.getSolarTime().getType().ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        final TimeTrait$SolarTimeType timeTrait$SolarTimeType2 = TimeTrait$SolarTimeType.Sunrise;
                        zzyl offset = value.getSolarTime().getOffset();
                        offset.getClass();
                        final Duration durationZzh = zzh(offset);
                        return new Object(timeTrait$SolarTimeType2, durationZzh) { // from class: com.google.home.google.TimeTrait$SolarTimeStruct

                            /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion(null);
                            private final Duration offset;
                            private final TimeTrait$SolarTimeType type;

                            /* JADX INFO: renamed from: com.google.home.google.TimeTrait$SolarTimeStruct$Adapter, reason: from kotlin metadata */
                            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/home/google/TimeTrait$SolarTimeStruct$Adapter;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "getFieldById", "Lcom/google/home/Field;", "tagId", "Lkotlin/UInt;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "java.com.google.home.whdm.src.com.google.home.google_time_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
                            public static final class Companion implements StructDescriptor {
                                private Companion() {
                                }

                                @Override // com.google.home.StructDescriptor
                                /* JADX INFO: renamed from: getFieldById-WZ4Q5Ns */
                                public Field mo448getFieldByIdWZ4Q5Ns(int tagId) {
                                    for (StructFields structFields : StructFields.values()) {
                                        if (structFields.getTag() == tagId) {
                                            return structFields;
                                        }
                                    }
                                    return null;
                                }

                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }
                            }

                            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
                            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
                            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/google/TimeTrait$SolarTimeStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "type", SpotifyService.OFFSET, "java.com.google.home.whdm.src.com.google.home.google_time_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
                            public static final class StructFields implements Field {
                                private static final /* synthetic */ EnumEntries $ENTRIES;
                                private static final /* synthetic */ StructFields[] $VALUES;
                                public static final StructFields offset;
                                public static final StructFields type;
                                private final Descriptor descriptor;
                                private final boolean isNullable;
                                private final int tag;
                                private final Type typeEnum;
                                private final String typeName;

                                private static final /* synthetic */ StructFields[] $values() {
                                    return new StructFields[]{type, offset};
                                }

                                static {
                                    Type type2 = Type.Dynamic;
                                    NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                                    type = new StructFields("type", 0, 1, "SolarTimeType", type2, noOpDescriptor, false);
                                    offset = new StructFields(SpotifyService.OFFSET, 1, 2, "Duration", type2, noOpDescriptor, false);
                                    StructFields[] structFieldsArr$values = $values();
                                    $VALUES = structFieldsArr$values;
                                    $ENTRIES = EnumEntriesKt.enumEntries(structFieldsArr$values);
                                }

                                private StructFields(String str, int i, int i2, String str2, Type type2, Descriptor descriptor, boolean z) {
                                    this.tag = i2;
                                    this.typeName = str2;
                                    this.typeEnum = type2;
                                    this.descriptor = descriptor;
                                    this.isNullable = z;
                                }

                                public static StructFields valueOf(String str) {
                                    return (StructFields) Enum.valueOf(StructFields.class, str);
                                }

                                public static StructFields[] values() {
                                    return (StructFields[]) $VALUES.clone();
                                }

                                @Override // com.google.home.Field
                                public Descriptor getDescriptor() {
                                    return this.descriptor;
                                }

                                /* JADX INFO: renamed from: getTag-pVg5ArA, reason: not valid java name and from getter */
                                public int getTag() {
                                    return this.tag;
                                }

                                @Override // com.google.home.Field
                                public Type getTypeEnum() {
                                    return this.typeEnum;
                                }

                                @Override // com.google.home.Field
                                public String getTypeName() {
                                    return this.typeName;
                                }
                            }

                            {
                                timeTrait$SolarTimeType2.getClass();
                                durationZzh.getClass();
                                this.type = timeTrait$SolarTimeType2;
                                this.offset = durationZzh;
                            }

                            public boolean equals(Object other) {
                                if (this == other) {
                                    return true;
                                }
                                if (!(other instanceof TimeTrait$SolarTimeStruct)) {
                                    return false;
                                }
                                TimeTrait$SolarTimeStruct timeTrait$SolarTimeStruct = (TimeTrait$SolarTimeStruct) other;
                                if (this.type != timeTrait$SolarTimeStruct.type) {
                                    return false;
                                }
                                return Intrinsics.areEqual(this.offset, timeTrait$SolarTimeStruct.offset);
                            }

                            public int hashCode() {
                                return this.offset.hashCode() + (this.type.hashCode() * 31);
                            }

                            public String toString() {
                                return zze.zza(this.offset, this.type, (byte) 1, (byte) 30, "SolarTimeStruct(type=", ", offset=", ")");
                            }
                        };
                    }
                    if (iOrdinal == 2) {
                        final TimeTrait$SolarTimeType timeTrait$SolarTimeType3 = TimeTrait$SolarTimeType.Sunset;
                        zzyl offset2 = value.getSolarTime().getOffset();
                        offset2.getClass();
                        final Duration durationZzh2 = zzh(offset2);
                        return new Object(timeTrait$SolarTimeType3, durationZzh2) { // from class: com.google.home.google.TimeTrait$SolarTimeStruct

                            /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion(null);
                            private final Duration offset;
                            private final TimeTrait$SolarTimeType type;

                            /* JADX INFO: renamed from: com.google.home.google.TimeTrait$SolarTimeStruct$Adapter, reason: from kotlin metadata */
                            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/home/google/TimeTrait$SolarTimeStruct$Adapter;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "getFieldById", "Lcom/google/home/Field;", "tagId", "Lkotlin/UInt;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "java.com.google.home.whdm.src.com.google.home.google_time_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
                            public static final class Companion implements StructDescriptor {
                                private Companion() {
                                }

                                @Override // com.google.home.StructDescriptor
                                /* JADX INFO: renamed from: getFieldById-WZ4Q5Ns */
                                public Field mo448getFieldByIdWZ4Q5Ns(int tagId) {
                                    for (StructFields structFields : StructFields.values()) {
                                        if (structFields.getTag() == tagId) {
                                            return structFields;
                                        }
                                    }
                                    return null;
                                }

                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }
                            }

                            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
                            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
                            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/google/TimeTrait$SolarTimeStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "type", SpotifyService.OFFSET, "java.com.google.home.whdm.src.com.google.home.google_time_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
                            public static final class StructFields implements Field {
                                private static final /* synthetic */ EnumEntries $ENTRIES;
                                private static final /* synthetic */ StructFields[] $VALUES;
                                public static final StructFields offset;
                                public static final StructFields type;
                                private final Descriptor descriptor;
                                private final boolean isNullable;
                                private final int tag;
                                private final Type typeEnum;
                                private final String typeName;

                                private static final /* synthetic */ StructFields[] $values() {
                                    return new StructFields[]{type, offset};
                                }

                                static {
                                    Type type2 = Type.Dynamic;
                                    NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                                    type = new StructFields("type", 0, 1, "SolarTimeType", type2, noOpDescriptor, false);
                                    offset = new StructFields(SpotifyService.OFFSET, 1, 2, "Duration", type2, noOpDescriptor, false);
                                    StructFields[] structFieldsArr$values = $values();
                                    $VALUES = structFieldsArr$values;
                                    $ENTRIES = EnumEntriesKt.enumEntries(structFieldsArr$values);
                                }

                                private StructFields(String str, int i, int i2, String str2, Type type2, Descriptor descriptor, boolean z) {
                                    this.tag = i2;
                                    this.typeName = str2;
                                    this.typeEnum = type2;
                                    this.descriptor = descriptor;
                                    this.isNullable = z;
                                }

                                public static StructFields valueOf(String str) {
                                    return (StructFields) Enum.valueOf(StructFields.class, str);
                                }

                                public static StructFields[] values() {
                                    return (StructFields[]) $VALUES.clone();
                                }

                                @Override // com.google.home.Field
                                public Descriptor getDescriptor() {
                                    return this.descriptor;
                                }

                                /* JADX INFO: renamed from: getTag-pVg5ArA, reason: not valid java name and from getter */
                                public int getTag() {
                                    return this.tag;
                                }

                                @Override // com.google.home.Field
                                public Type getTypeEnum() {
                                    return this.typeEnum;
                                }

                                @Override // com.google.home.Field
                                public String getTypeName() {
                                    return this.typeName;
                                }
                            }

                            {
                                timeTrait$SolarTimeType3.getClass();
                                durationZzh2.getClass();
                                this.type = timeTrait$SolarTimeType3;
                                this.offset = durationZzh2;
                            }

                            public boolean equals(Object other) {
                                if (this == other) {
                                    return true;
                                }
                                if (!(other instanceof TimeTrait$SolarTimeStruct)) {
                                    return false;
                                }
                                TimeTrait$SolarTimeStruct timeTrait$SolarTimeStruct = (TimeTrait$SolarTimeStruct) other;
                                if (this.type != timeTrait$SolarTimeStruct.type) {
                                    return false;
                                }
                                return Intrinsics.areEqual(this.offset, timeTrait$SolarTimeStruct.offset);
                            }

                            public int hashCode() {
                                return this.offset.hashCode() + (this.type.hashCode() * 31);
                            }

                            public String toString() {
                                return zze.zza(this.offset, this.type, (byte) 1, (byte) 30, "SolarTimeStruct(type=", ", offset=", ")");
                            }
                        };
                    }
                    if (iOrdinal != 3) {
                        Home$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                }
                byte[] byteArray6 = value.toByteArray();
                byteArray6.getClass();
                return new UnknownValue(byteArray6);
            case DURATION:
                return Duration.ofSeconds(value.getDuration().zza(), value.getDuration().zzb());
            case ENTITY:
                byte[] byteArray7 = value.toByteArray();
                byteArray7.getClass();
                return new UnknownValue(byteArray7);
            case ENTITY_TYPE_ID:
                String entityTypeId = value.getEntityTypeId();
                entityTypeId.getClass();
                DeviceTypeFactory<? extends DeviceType> typeOrNull = factoryRegistry.getTypeOrNull(entityTypeId);
                if (typeOrNull != null) {
                    return typeOrNull;
                }
                byte[] byteArray8 = value.toByteArray();
                byteArray8.getClass();
                return new UnknownValue(byteArray8);
            default:
                Home$$ExternalSyntheticBUOutline0.m();
            case NULL_VALUE:
                return null;
        }
    }

    public static final Object zzs(Value value, HomeManager homeManager, TraitFactory traitFactory, Field field) throws HomeException {
        InternalTraitFactory factory;
        value.getClass();
        homeManager.getClass();
        if (field == null) {
            return zzr(value, homeManager);
        }
        if (value.hasListValue()) {
            List<Value> elementsList = value.getListValue().getElementsList();
            elementsList.getClass();
            List<Value> list = elementsList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Value value2 : list) {
                zzkg zzkgVar = zzkt.zza;
                value2.getClass();
                arrayList.add(zzs(value2, homeManager, traitFactory, field));
            }
            return CollectionsKt.toList(arrayList);
        }
        if (value.hasNullValue()) {
            return null;
        }
        Type typeEnum = field.getTypeEnum();
        JoinSemanticType joinSemanticType = JoinSemanticType.JsWhenAllFinished;
        TimeTrait$SolarTimeType timeTrait$SolarTimeType = TimeTrait$SolarTimeType.Sunrise;
        Type type = Type.Dynamic;
        SolarTime.SolarTimeType solarTimeType = SolarTime.SolarTimeType.UNKNOWN;
        Value.ValueCase valueCase = Value.ValueCase.INT_VALUE;
        switch (typeEnum.ordinal()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return field.getTypeEnum().getValueSerializer().deserialize(value);
            case 14:
                InternalTraitFactory factory2 = traitFactory != null ? traitFactory.getFactory() : null;
                if (factory2 instanceof MatterTraitFactory) {
                    return zzmp.zza((MatterTraitFactory) factory2, field.getTypeName()).m557toRuntimeVKZWuLQ(ULong.m2411constructorimpl(value.getEnumValue().getId()));
                }
                if (!(factory2 instanceof PlatformTraitFactory)) {
                    return zzr(value, homeManager);
                }
                zzmp.zzb((PlatformTraitFactory) factory2, field.getTypeName());
                value.getEnumValue().getName().getClass();
                throw null;
            case 15:
                factory = traitFactory != null ? traitFactory.getFactory() : null;
                return factory instanceof MatterTraitFactory ? zzmp.zzc((MatterTraitFactory) factory, field.getTypeName()).toRuntime(Bitmap.INSTANCE.m528toRuntimeVKZWuLQ(ULong.m2411constructorimpl(value.getBitmapValue().getValue()))) : zzr(value, homeManager);
            case 16:
                if (traitFactory != null && (factory = traitFactory.getFactory()) != null) {
                    factory = factory.getTraitId();
                }
                return (Intrinsics.areEqual(factory, ExtendedModeSelectTrait.INSTANCE.getId().toString()) && Intrinsics.areEqual(field.getTypeName(), "ModeSetting")) ? ModeSettingSerializer.INSTANCE.deserialize(value) : zzr(value, homeManager);
            default:
                return zzr(value, homeManager);
        }
    }

    public final Pair zzg(Parameter parameter, HomeManager homeManager, TraitFactory traitFactory, Object obj) {
        Field commandRequestFieldByName;
        parameter.getClass();
        homeManager.getClass();
        obj.getClass();
        if (obj instanceof EventFactory) {
            if (parameter.hasId()) {
                commandRequestFieldByName = ((EventFactory) obj).m437getEventFieldByIdWZ4Q5Ns(UInt.m2389constructorimpl(parameter.getId()));
            } else {
                String name = parameter.getName();
                name.getClass();
                commandRequestFieldByName = ((EventFactory) obj).getEventFieldByName(name);
            }
        } else if (obj instanceof TraitFactory) {
            if (parameter.hasId()) {
                commandRequestFieldByName = ((TraitFactory) obj).mo449getAttributeByIdWZ4Q5Ns(UInt.m2389constructorimpl(parameter.getId()));
            } else {
                String name2 = parameter.getName();
                name2.getClass();
                commandRequestFieldByName = ((TraitFactory) obj).getAttributeByName(name2);
            }
        } else if (!(obj instanceof CommandDescriptor)) {
            commandRequestFieldByName = null;
        } else if (parameter.hasId()) {
            commandRequestFieldByName = ((CommandDescriptor) obj).mo436getCommandRequestFieldByIdWZ4Q5Ns(UInt.m2389constructorimpl(parameter.getId()));
        } else {
            String name3 = parameter.getName();
            name3.getClass();
            commandRequestFieldByName = ((CommandDescriptor) obj).getCommandRequestFieldByName(name3);
        }
        if (commandRequestFieldByName == null) {
            commandRequestFieldByName = new UnknownField(UInt.m2389constructorimpl(parameter.getId()), null);
        }
        Value constant = parameter.getConstant();
        constant.getClass();
        return TuplesKt.to(commandRequestFieldByName, zzs(constant, homeManager, traitFactory, commandRequestFieldByName));
    }
}
