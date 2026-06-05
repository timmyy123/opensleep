package com.google.android.gms.internal.serialization;

import com.google.home.CommandDescriptor;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.EventFactory;
import com.google.home.FactoryRegistry;
import com.google.home.Field;
import com.google.home.HasId;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.HomeDevice;
import com.google.home.HomeManager;
import com.google.home.HomeObjectsFlow;
import com.google.home.Id;
import com.google.home.InternalEventFactory;
import com.google.home.Structure;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.automation.Action;
import com.google.home.automation.ActionBehavior;
import com.google.home.automation.And;
import com.google.home.automation.Between;
import com.google.home.automation.BetweenTimes;
import com.google.home.automation.Command;
import com.google.home.automation.Constant;
import com.google.home.automation.Delay;
import com.google.home.automation.Divide;
import com.google.home.automation.Equals;
import com.google.home.automation.Expression;
import com.google.home.automation.ExpressionWithId;
import com.google.home.automation.FieldSelect;
import com.google.home.automation.GetDevicesOfType;
import com.google.home.automation.GreaterThan;
import com.google.home.automation.GreaterThanOrEquals;
import com.google.home.automation.HasOutput;
import com.google.home.automation.JoinSemanticType;
import com.google.home.automation.LessThan;
import com.google.home.automation.LessThanOrEquals;
import com.google.home.automation.ListAllMatch;
import com.google.home.automation.ListAnyMatch;
import com.google.home.automation.ListContains;
import com.google.home.automation.ListFilter;
import com.google.home.automation.ListGet;
import com.google.home.automation.ListIn;
import com.google.home.automation.ListMap;
import com.google.home.automation.ListNoneMatch;
import com.google.home.automation.ListSize;
import com.google.home.automation.ManualStarter;
import com.google.home.automation.MapFilter;
import com.google.home.automation.MapKeys;
import com.google.home.automation.MapSize;
import com.google.home.automation.MapValues;
import com.google.home.automation.Minus;
import com.google.home.automation.Multiply;
import com.google.home.automation.Not;
import com.google.home.automation.NotEquals;
import com.google.home.automation.Or;
import com.google.home.automation.Plus;
import com.google.home.automation.Reference;
import com.google.home.automation.ReferenceDeclaration;
import com.google.home.automation.SelectFlow;
import com.google.home.automation.SequentialFlow;
import com.google.home.automation.Starter;
import com.google.home.automation.StateReader;
import com.google.home.automation.Suppression;
import com.google.home.automation.UnknownCommand;
import com.google.home.automation.UnknownEntity;
import com.google.home.automation.UnknownExpression;
import com.google.home.automation.UnknownField;
import com.google.home.automation.UnknownNode;
import com.google.home.automation.UnknownTrait$UnknownTraitFactory;
import com.google.home.automation.Update;
import com.google.home.automation.ValidationIssue;
import com.google.home.google.AutomationEntityTrait$Attributes;
import com.google.home.google.AutomationExecutionTrait$Attributes;
import com.google.home.google.Brightness;
import com.google.home.google.ExtendedColorControl;
import com.google.home.google.SimplifiedThermostat;
import com.google.home.google.Volume;
import com.google.home.matter.standard.ColorControl;
import com.google.home.matter.standard.ColorTemperatureLightDevice;
import com.google.home.matter.standard.DimmableLightDevice;
import com.google.home.matter.standard.ExtendedColorLightDevice;
import com.google.home.matter.standard.LevelControl;
import com.google.home.matter.standard.SpeakerDevice;
import com.google.home.matter.standard.Thermostat;
import com.google.home.matter.standard.ThermostatDevice;
import com.google.home.platform.traits.AutomationGraph;
import com.google.home.platform.traits.Condition;
import com.google.home.platform.traits.ConditionKtKt;
import com.google.home.platform.traits.Entity;
import com.google.home.platform.traits.EntityBehavior;
import com.google.home.platform.traits.Expression;
import com.google.home.platform.traits.FirstPartyClientMetadata;
import com.google.home.platform.traits.Node;
import com.google.home.platform.traits.ParallelFlow;
import com.google.home.platform.traits.Parameter;
import com.google.home.platform.traits.ValidationResult;
import com.google.home.platform.traits.Value;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002¦\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u001b\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ0\u0010&\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\f\u001a\u00020#H\u0086@¢\u0006\u0004\b$\u0010%J\u0017\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b*\u0010+J \u0010-\u001a\u00020'2\u0006\u0010,\u001a\u00020)2\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b-\u0010.J \u00104\u001a\u0002012\u0006\u00100\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b2\u00103J \u00107\u001a\u0002012\u0006\u00105\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b6\u00103J \u0010:\u001a\u0002082\u0006\u00100\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b9\u00103J\u001f\u0010@\u001a\u00020=2\u0006\u0010<\u001a\u00020;2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b>\u0010?J*\u0010E\u001a\u00020=*\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010D\u001a\u00020C2\u0006\u0010\f\u001a\u00020\u000bH\u0082\u0002¢\u0006\u0004\bE\u0010FJ\u001f\u0010J\u001a\u00020=2\u0006\u0010G\u001a\u00020B2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\bH\u0010IJ%\u0010O\u001a\u00020N2\u0006\u0010L\u001a\u00020K2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020=0AH\u0002¢\u0006\u0004\bO\u0010PJ%\u0010Q\u001a\u00020N2\u0006\u0010L\u001a\u00020K2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020=0AH\u0002¢\u0006\u0004\bQ\u0010PJ\u0017\u0010W\u001a\u00020T2\u0006\u0010S\u001a\u00020RH\u0000¢\u0006\u0004\bU\u0010VJ\u0017\u0010[\u001a\u00020=2\u0006\u0010X\u001a\u00020\u0015H\u0000¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020=2\u0006\u0010X\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\\\u0010ZJ\u0017\u0010_\u001a\u00020=2\u0006\u0010X\u001a\u00020\u0015H\u0000¢\u0006\u0004\b^\u0010ZJ\u0017\u0010c\u001a\u00020`2\u0006\u0010G\u001a\u00020BH\u0000¢\u0006\u0004\ba\u0010bJ \u0010f\u001a\u0002012\u0006\u0010d\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\be\u00103J \u0010i\u001a\u0002012\u0006\u0010g\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\bh\u00103J \u0010l\u001a\u00020'2\u0006\u0010j\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\bk\u00103J\u0017\u0010r\u001a\u00020o2\u0006\u0010n\u001a\u00020mH\u0000¢\u0006\u0004\bp\u0010qJ \u0010v\u001a\u00020t2\u0006\u0010s\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\bu\u00103J \u0010z\u001a\u00020x2\u0006\u0010w\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\by\u00103J\u0017\u0010\u007f\u001a\u00020|2\u0006\u0010{\u001a\u00020/H\u0000¢\u0006\u0004\b}\u0010~J\u001c\u0010\u0084\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0080\u0001\u001a\u00020/H\u0000¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001b\u0010\u0088\u0001\u001a\u00030\u0085\u00012\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001d\u0010\u008e\u0001\u001a\u00030\u008b\u00012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J?\u0010\u0093\u0001\u001a\u001c\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0010\u0012\u000e\u0012\u0007\b\u0001\u0012\u00030\u0092\u0001\u0018\u00010\u0091\u00010\u008f\u00012\b\u0010\u008a\u0001\u001a\u00030\u0089\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J,\u0010\u0099\u0001\u001a\u00030\u0098\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0097\u0001\u001a\u00020'2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001R,\u0010\u009c\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002010\u009b\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010 \u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020T0\u009b\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b \u0001\u0010\u009d\u0001\u001a\u0006\b¡\u0001\u0010\u009f\u0001R,\u0010¢\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020N0\u009b\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¢\u0001\u0010\u009d\u0001\u001a\u0006\b£\u0001\u0010\u009f\u0001R\u0017\u0010¤\u0001\u001a\u00020\u00158\u0002X\u0082D¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001¨\u0006§\u0001"}, d2 = {"Lcom/google/home/automation/serialization/AutomationConverter;", "", "<init>", "()V", "automation", "Lcom/google/home/Id;", "automationStructureId", "toAutomationProto-CNLJzCo", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toAutomationProto", "automationProto", "Lcom/google/home/HomeManager;", "homeManager", "Lcom/google/home/automation/internal/impl/AutomationInteractionClient;", "automationInteractionClient", "automationId", "Lcom/google/home/automation/internal/impl/AutomationImpl;", "fromAutomationProto-6e_jJog", "(Ljava/lang/Object;Lcom/google/home/HomeManager;Lcom/google/home/automation/internal/impl/AutomationInteractionClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fromAutomationProto", "", "", "Lcom/google/protobuf/ByteString;", "clientMetadataMap", "Lcom/google/home/platform/traits/FirstPartyClientMetadata;", "parseFirstPartyClientMetadata", "(Ljava/util/Map;)Lcom/google/home/platform/traits/FirstPartyClientMetadata;", "firstPartyClientMetadata", "firstPartyMetadataToMap$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/FirstPartyClientMetadata;)Ljava/util/Map;", "firstPartyMetadataToMap", "Lcom/google/home/google/AutomationEntityTrait$Attributes;", "automationEntityTrait", "Lcom/google/home/google/AutomationExecutionTrait$Attributes;", "automationExecutionTrait", "Lcom/google/home/internal/impl/HomeManagerImpl;", "fromAutomationTraits-chsYqT4", "(Ljava/lang/String;Lcom/google/home/google/AutomationEntityTrait$Attributes;Lcom/google/home/google/AutomationExecutionTrait$Attributes;Lcom/google/home/internal/impl/HomeManagerImpl;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fromAutomationTraits", "Lcom/google/home/automation/SequentialFlow;", "automationGraph", "Lcom/google/home/platform/traits/AutomationGraph;", "toAutomationGraphProto", "(Lcom/google/home/automation/SequentialFlow;)Lcom/google/home/platform/traits/AutomationGraph;", "automationGraphProto", "fromAutomationGraphProto", "(Lcom/google/home/platform/traits/AutomationGraph;Lcom/google/home/HomeManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/home/platform/traits/Node;", "nodeProto", "Lcom/google/home/automation/Node;", "fromNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/Node;Lcom/google/home/HomeManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fromNodeProto", "starterNodeProto", "fromStarterNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromStarterNodeProto", "Lcom/google/home/automation/Condition;", "fromConditionNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromConditionNodeProto", "Lcom/google/home/automation/serialization/ExpressionWithType;", "expressionWithType", "Lcom/google/home/automation/Expression;", "fromExpressionWithType$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/serialization/ExpressionWithType;Lcom/google/home/HomeManager;)Lcom/google/home/automation/Expression;", "fromExpressionWithType", "", "Lcom/google/home/automation/serialization/OperandWithType;", "", "index", "invoke", "(Ljava/util/List;ILcom/google/home/HomeManager;)Lcom/google/home/automation/Expression;", "operandWithType", "fromOperandWithType$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/serialization/OperandWithType;Lcom/google/home/HomeManager;)Lcom/google/home/automation/Expression;", "fromOperandWithType", "Lcom/google/home/platform/traits/Expression;", "expressionProto", "operands", "Lcom/google/home/automation/ExpressionWithId;", "andExpressionExpansion", "(Lcom/google/home/platform/traits/Expression;Ljava/util/List;)Lcom/google/home/automation/ExpressionWithId;", "orExpressionExpansion", "Lcom/google/home/automation/serialization/ReferenceWithType;", "referenceWithType", "Lcom/google/home/automation/ReferenceDeclaration;", "fromReferenceDeclarationWithType$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/serialization/ReferenceWithType;)Lcom/google/home/automation/ReferenceDeclaration;", "fromReferenceDeclarationWithType", "referenceProto", "fromReferenceProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Ljava/lang/String;)Lcom/google/home/automation/Expression;", "fromReferenceProto", "fromReferenceProtoNew$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromReferenceProtoNew", "fromReferenceProtoLegacy$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromReferenceProtoLegacy", "Lcom/google/home/Field;", "fromFieldWithType$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/automation/serialization/OperandWithType;)Lcom/google/home/Field;", "fromFieldWithType", "stateReaderNodeProto", "fromStateReaderNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromStateReaderNodeProto", "actionNodeProto", "fromActionNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromActionNodeProto", "sequentialNodeProto", "fromSequentialFlowNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromSequentialFlowNodeProto", "Lcom/google/home/platform/traits/ParallelFlow$JoinSemantic;", "joinSemanticProto", "Lcom/google/home/automation/JoinSemanticType;", "fromJoinSemanticProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/ParallelFlow$JoinSemantic;)Lcom/google/home/automation/JoinSemanticType;", "fromJoinSemanticProto", "parallelNodeProto", "Lcom/google/home/automation/ParallelFlow;", "fromParallelFlowNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromParallelFlowNodeProto", "selectNodeProto", "Lcom/google/home/automation/SelectFlow;", "fromSelectFlowNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "fromSelectFlowNodeProto", "delayNodeProto", "Lcom/google/home/automation/Delay;", "fromDelayNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/Node;)Lcom/google/home/automation/Delay;", "fromDelayNodeProto", "suppressionNodeProto", "Lcom/google/home/automation/Suppression;", "fromSuppressionNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/Node;)Lcom/google/home/automation/Suppression;", "fromSuppressionNodeProto", "Lcom/google/home/automation/UnknownNode;", "fromUnknownNodeProto$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/Node;)Lcom/google/home/automation/UnknownNode;", "fromUnknownNodeProto", "Lcom/google/home/platform/traits/Entity;", "entityProto", "", "isStructure$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/platform/traits/Entity;)Z", "isStructure", "Lkotlin/Pair;", "Lcom/google/home/HasId;", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/DeviceType;", "fromEntityProto", "(Lcom/google/home/platform/traits/Entity;Lcom/google/home/HomeManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/home/platform/traits/ValidationResult;", "validationResultProto", "root", "Lcom/google/home/automation/ValidationIssue;", "fromValidationResultProto", "(Lcom/google/home/platform/traits/ValidationResult;Lcom/google/home/automation/SequentialFlow;Lcom/google/home/HomeManager;)Lcom/google/home/automation/ValidationIssue;", "", "convertedNodesMap", "Ljava/util/Map;", "getConvertedNodesMap$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Ljava/util/Map;", "convertedReferenceDeclarationMap", "getConvertedReferenceDeclarationMap$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "convertedExpressionsMap", "getConvertedExpressionsMap$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "FIRST_PARTY_CLIENT_METADATA_KEY", "Ljava/lang/String;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzkt {
    public static final zzkg zza = new zzkg(null);
    private static final Map zzf;
    private static final Set zzg;
    private final Map zzb = new LinkedHashMap();
    private final Map zzc = new LinkedHashMap();
    private final Map zzd = new LinkedHashMap();
    private final String zze = "first_party_client_metadata";

    static {
        Pair pair = TuplesKt.to(DimmableLightDevice.INSTANCE.getFactory().getTypeId(), Brightness.INSTANCE.getFactory().getTraitId());
        LevelControl.Companion companion = LevelControl.INSTANCE;
        Pair pair2 = TuplesKt.to(pair, companion);
        String typeId = ColorTemperatureLightDevice.INSTANCE.getFactory().getTypeId();
        ExtendedColorControl.Companion companion2 = ExtendedColorControl.INSTANCE;
        Pair pair3 = TuplesKt.to(typeId, companion2.getFactory().getTraitId());
        ColorControl.Companion companion3 = ColorControl.INSTANCE;
        Pair pair4 = TuplesKt.to(pair3, companion3);
        Pair pair5 = TuplesKt.to(TuplesKt.to(ExtendedColorLightDevice.INSTANCE.getFactory().getTypeId(), companion2.getFactory().getTraitId()), companion3);
        Pair pair6 = TuplesKt.to(TuplesKt.to(ThermostatDevice.INSTANCE.getFactory().getTypeId(), SimplifiedThermostat.INSTANCE.getFactory().getTraitId()), Thermostat.INSTANCE);
        SpeakerDevice.Companion companion4 = SpeakerDevice.INSTANCE;
        zzf = MapsKt.mapOf(pair2, pair4, pair5, pair6, TuplesKt.to(TuplesKt.to(companion4.getFactory().getTypeId(), Volume.INSTANCE.getFactory().getTraitId()), companion));
        zzg = SetsKt.setOf(companion4.getFactory().getTypeId());
    }

    private final Expression zzA(List list, int i, HomeManager homeManager) {
        list.getClass();
        return zzj((OperandWithType) list.get(i), homeManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzB(Entity entity, HomeManager homeManager, Continuation continuation) {
        zzkl zzklVar;
        HomeManager homeManager2;
        boolean z;
        Entity entity2;
        boolean z2;
        Object unknownEntity;
        if (continuation instanceof zzkl) {
            zzklVar = (zzkl) continuation;
            int i = zzklVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzklVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzklVar = new zzkl(this, continuation);
            }
        }
        Object obj = zzklVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzklVar.zze;
        DeviceTypeFactory<? extends DeviceType> typeOrNull = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            boolean zZzx = zzx(entity);
            if (zZzx) {
                HomeObjectsFlow<Structure> homeObjectsFlowStructures = homeManager.structures();
                String entityObjectId = entity.getEntityObjectId();
                entityObjectId.getClass();
                Id.m441constructorimpl(entityObjectId);
                zzklVar.zzf = entity;
                zzklVar.zza = homeManager;
                zzklVar.zzb = true;
                zzklVar.zze = 1;
                Object objM438get4rhpr1w = homeObjectsFlowStructures.m438get4rhpr1w(entityObjectId, zzklVar);
                if (objM438get4rhpr1w != coroutine_suspended) {
                    entity2 = entity;
                    z2 = zZzx;
                    obj = objM438get4rhpr1w;
                    unknownEntity = (Structure) obj;
                    if (unknownEntity == null) {
                    }
                }
            } else {
                HomeObjectsFlow<HomeDevice> homeObjectsFlowDevices = homeManager.devices();
                String entityObjectId2 = entity.getEntityObjectId();
                entityObjectId2.getClass();
                Id.m441constructorimpl(entityObjectId2);
                zzklVar.zzf = entity;
                zzklVar.zza = homeManager;
                zzklVar.zzb = false;
                zzklVar.zze = 2;
                Object objM438get4rhpr1w2 = homeObjectsFlowDevices.m438get4rhpr1w(entityObjectId2, zzklVar);
                if (objM438get4rhpr1w2 != coroutine_suspended) {
                    homeManager2 = homeManager;
                    z = zZzx;
                    obj = objM438get4rhpr1w2;
                    unknownEntity = (HomeDevice) obj;
                    if (unknownEntity == null) {
                    }
                    HomeManager homeManager3 = homeManager2;
                    entity2 = entity;
                    z2 = z;
                    homeManager = homeManager3;
                }
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            z2 = zzklVar.zzb;
            homeManager = (HomeManager) zzklVar.zza;
            entity2 = zzklVar.zzf;
            ResultKt.throwOnFailure(obj);
            unknownEntity = (Structure) obj;
            if (unknownEntity == null) {
                String entityObjectId3 = entity2.getEntityObjectId();
                entityObjectId3.getClass();
                Id.m441constructorimpl(entityObjectId3);
                String name = entity2.getName();
                name.getClass();
                unknownEntity = new UnknownEntity(entityObjectId3, name, null);
            }
        } else {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            boolean z3 = zzklVar.zzb;
            HomeManager homeManager4 = (HomeManager) zzklVar.zza;
            Entity entity3 = zzklVar.zzf;
            ResultKt.throwOnFailure(obj);
            z = z3;
            entity = entity3;
            homeManager2 = homeManager4;
            unknownEntity = (HomeDevice) obj;
            if (unknownEntity == null) {
                String entityObjectId4 = entity.getEntityObjectId();
                entityObjectId4.getClass();
                Id.m441constructorimpl(entityObjectId4);
                String name2 = entity.getName();
                name2.getClass();
                unknownEntity = new UnknownEntity(entityObjectId4, name2, null);
            }
            HomeManager homeManager32 = homeManager2;
            entity2 = entity;
            z2 = z;
            homeManager = homeManager32;
        }
        homeManager.getClass();
        FactoryRegistry factoryRegistry = ((zzpu) homeManager).getZzb().getFactoryRegistry();
        if (!z2) {
            String type = entity2.getType();
            type.getClass();
            typeOrNull = factoryRegistry.getTypeOrNull(type);
            if (typeOrNull == null) {
                final String type2 = entity2.getType();
                type2.getClass();
                typeOrNull = new DeviceTypeFactory<Object>(type2) { // from class: com.google.home.automation.UnknownDeviceType$UnknownDeviceTypeFactory
                    private final String id;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(new UnknownDeviceType$Factory(type2, null, 2, null));
                        type2.getClass();
                        Id.m441constructorimpl(type2);
                        this.id = type2;
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (other instanceof UnknownDeviceType$UnknownDeviceTypeFactory) {
                            return Intrinsics.areEqual(this.id, ((UnknownDeviceType$UnknownDeviceTypeFactory) other).id);
                        }
                        return false;
                    }
                };
            }
        }
        return new Pair(unknownEntity, typeOrNull);
    }

    private static final ExpressionWithId zzC(com.google.home.platform.traits.Expression expression, List list) {
        if (list.size() < 2) {
            byte[] byteArray = expression.toByteArray();
            byteArray.getClass();
            String expressionId = expression.getExpressionId();
            expressionId.getClass();
            return new UnknownExpression(byteArray, expressionId);
        }
        if (list.size() == 2) {
            Expression expression2 = (Expression) list.get(0);
            Expression expression3 = (Expression) list.get(1);
            String expressionId2 = expression.getExpressionId();
            expressionId2.getClass();
            return new And(expression2, expression3, expressionId2);
        }
        Expression expression4 = (Expression) list.get(0);
        List listDrop = CollectionsKt.drop(list, 1);
        ListIterator listIterator = listDrop.listIterator(listDrop.size());
        if (!listIterator.hasPrevious()) {
            Utf8$$ExternalSyntheticBUOutline0.m("Empty list can't be reduced.");
            return null;
        }
        Object objPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            Expression expression5 = (Expression) listIterator.previous();
            String expressionId3 = expression.getExpressionId();
            expressionId3.getClass();
            objPrevious = new And(expression5, (Expression) objPrevious, expressionId3);
        }
        String expressionId4 = expression.getExpressionId();
        expressionId4.getClass();
        return new And(expression4, (Expression) objPrevious, expressionId4);
    }

    private static final ExpressionWithId zzD(com.google.home.platform.traits.Expression expression, List list) {
        if (list.size() < 2) {
            byte[] byteArray = expression.toByteArray();
            byteArray.getClass();
            String expressionId = expression.getExpressionId();
            expressionId.getClass();
            return new UnknownExpression(byteArray, expressionId);
        }
        if (list.size() == 2) {
            Expression expression2 = (Expression) list.get(0);
            Expression expression3 = (Expression) list.get(1);
            String expressionId2 = expression.getExpressionId();
            expressionId2.getClass();
            return new Or(expression2, expression3, expressionId2);
        }
        Expression expression4 = (Expression) list.get(0);
        List listDrop = CollectionsKt.drop(list, 1);
        ListIterator listIterator = listDrop.listIterator(listDrop.size());
        if (!listIterator.hasPrevious()) {
            Utf8$$ExternalSyntheticBUOutline0.m("Empty list can't be reduced.");
            return null;
        }
        Object objPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            Expression expression5 = (Expression) listIterator.previous();
            String expressionId3 = expression.getExpressionId();
            expressionId3.getClass();
            objPrevious = new Or(expression5, (Expression) objPrevious, expressionId3);
        }
        String expressionId4 = expression.getExpressionId();
        expressionId4.getClass();
        return new Or(expression4, (Expression) objPrevious, expressionId4);
    }

    public static final Field zzw(OperandWithType operandWithType) {
        operandWithType.getClass();
        Field field = operandWithType.getField();
        return field == null ? operandWithType instanceof zzmi ? new UnknownField(((zzmi) operandWithType).getZza(), null) : new UnknownField(0, null) : field;
    }

    public static final boolean zzx(Entity entity) {
        entity.getClass();
        String entityObjectId = entity.getEntityObjectId();
        entityObjectId.getClass();
        return StringsKt.startsWith$default(entityObjectId, "structure") || entity.getType().equals("home.internal.types.Structure");
    }

    private final FirstPartyClientMetadata zzz(Map map) {
        zzwr zzwrVar = (zzwr) map.get(this.zze);
        if (zzwrVar != null) {
            try {
                return FirstPartyClientMetadata.parseFrom(zzwrVar);
            } catch (zzzv unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zze(String str, AutomationEntityTrait$Attributes automationEntityTrait$Attributes, AutomationExecutionTrait$Attributes automationExecutionTrait$Attributes, zzpu zzpuVar, Continuation continuation) {
        zzkk zzkkVar;
        Object obj;
        String str2;
        zzpu zzpuVar2;
        AutomationEntityTrait$Attributes automationEntityTrait$Attributes2;
        AutomationExecutionTrait$Attributes automationExecutionTrait$Attributes2;
        zzkt zzktVar = this;
        if (continuation instanceof zzkk) {
            zzkkVar = (zzkk) continuation;
            int i = zzkkVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzkkVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzkkVar = new zzkk(zzktVar, continuation);
            }
        }
        Object obj2 = zzkkVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzkkVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            AutomationGraph from = AutomationGraph.parseFrom(automationEntityTrait$Attributes.getAutomationGraph());
            from.getClass();
            zzkkVar.zzf = zzktVar;
            zzkkVar.zzg = str;
            zzkkVar.zza = automationEntityTrait$Attributes;
            zzkkVar.zzb = automationExecutionTrait$Attributes;
            zzkkVar.zzh = zzpuVar;
            zzkkVar.zze = 1;
            Object objZzf = zzktVar.zzf(from, zzpuVar, zzkkVar);
            if (objZzf == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objZzf;
            str2 = str;
            zzpuVar2 = zzpuVar;
            automationEntityTrait$Attributes2 = automationEntityTrait$Attributes;
            automationExecutionTrait$Attributes2 = automationExecutionTrait$Attributes;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            zzpu zzpuVar3 = zzkkVar.zzh;
            automationExecutionTrait$Attributes2 = (AutomationExecutionTrait$Attributes) zzkkVar.zzb;
            automationEntityTrait$Attributes2 = (AutomationEntityTrait$Attributes) zzkkVar.zza;
            String str3 = zzkkVar.zzg;
            zzkt zzktVar2 = zzkkVar.zzf;
            ResultKt.throwOnFailure(obj2);
            zzpuVar2 = zzpuVar3;
            zzktVar = zzktVar2;
            obj = obj2;
            str2 = str3;
        }
        SequentialFlow sequentialFlow = (SequentialFlow) obj;
        boolean valid = automationEntityTrait$Attributes2.getValid();
        Boolean running = automationExecutionTrait$Attributes2.getRunning();
        boolean zBooleanValue = running != null ? running.booleanValue() : false;
        boolean manuallyExecutable = automationEntityTrait$Attributes2.getManuallyExecutable();
        List<byte[]> validationResults = automationEntityTrait$Attributes2.getValidationResults();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(validationResults, 10));
        Iterator<T> it = validationResults.iterator();
        while (it.hasNext()) {
            ValidationResult from2 = ValidationResult.parseFrom((byte[]) it.next());
            from2.getClass();
            arrayList.add(zzktVar.zzs(from2, sequentialFlow, zzpuVar2));
        }
        String structureObjectId = automationEntityTrait$Attributes2.getStructureObjectId();
        Id.m441constructorimpl(structureObjectId);
        String iqsAutomationId = automationEntityTrait$Attributes2.getIqsAutomationId();
        Id.m441constructorimpl(iqsAutomationId);
        return new AutomationImpl(str2, valid, zBooleanValue, manuallyExecutable, false, arrayList, structureObjectId, iqsAutomationId, new BaseAutomationImpl(automationEntityTrait$Attributes2.getName(), automationEntityTrait$Attributes2.getDescription(), automationEntityTrait$Attributes2.getActive(), sequentialFlow, zzktVar.zzz(automationEntityTrait$Attributes2.getClientMetadata()), automationEntityTrait$Attributes2.getClientFeatureGroup()), zzpuVar2.zzi(), 16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x008d -> B:20:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzf(AutomationGraph automationGraph, HomeManager homeManager, Continuation continuation) {
        zzki zzkiVar;
        zzkt zzktVar;
        Collection collection;
        HomeManager homeManager2;
        Iterator it;
        if (continuation instanceof zzki) {
            zzkiVar = (zzki) continuation;
            int i = zzkiVar.zzg;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzkiVar.zzg = i - Integer.MIN_VALUE;
            } else {
                zzkiVar = new zzki(this, continuation);
            }
        }
        Object obj = zzkiVar.zze;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzkiVar.zzg;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<Node> nodesList = automationGraph.getSequential().getNodesList();
            nodesList.getClass();
            List<Node> list = nodesList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            zzktVar = this;
            collection = arrayList;
            homeManager2 = homeManager;
            it = it2;
            if (it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            collection = (Collection) zzkiVar.zzd;
            Iterator it3 = (Iterator) zzkiVar.zzc;
            Collection collection2 = (Collection) zzkiVar.zzb;
            HomeManager homeManager3 = (HomeManager) zzkiVar.zza;
            zzkt zzktVar2 = zzkiVar.zzh;
            ResultKt.throwOnFailure(obj);
            Iterator it4 = it3;
            zzktVar = zzktVar2;
            zzki zzkiVar2 = zzkiVar;
            HomeManager homeManager4 = homeManager3;
            Object objZzg = obj;
            collection.add((com.google.home.automation.Node) objZzg);
            collection = collection2;
            it = it4;
            homeManager2 = homeManager4;
            zzkiVar = zzkiVar2;
            if (it.hasNext()) {
                Node node = (Node) it.next();
                node.getClass();
                zzkiVar.zzh = zzktVar;
                zzkiVar.zza = homeManager2;
                zzkiVar.zzb = collection;
                zzkiVar.zzc = it;
                zzkiVar.zzd = collection;
                zzkiVar.zzg = 1;
                objZzg = zzktVar.zzg(node, homeManager2, zzkiVar);
                if (objZzg == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzkiVar2 = zzkiVar;
                homeManager4 = homeManager2;
                it4 = it;
                collection2 = collection;
                collection.add((com.google.home.automation.Node) objZzg);
                collection = collection2;
                it = it4;
                homeManager2 = homeManager4;
                zzkiVar = zzkiVar2;
                if (it.hasNext()) {
                    SequentialFlow sequentialFlow = new SequentialFlow((List) collection, "");
                    zzktVar.zzb.put("", sequentialFlow);
                    return sequentialFlow;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00da, code lost:
    
        if (r8 != r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0145, code lost:
    
        if (r8 != r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0156, code lost:
    
        if (r8 != r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0166, code lost:
    
        if (r8 != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0184, code lost:
    
        if (r8 != r1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0195, code lost:
    
        if (r8 != r1) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a6, code lost:
    
        if (r8 != r1) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzg(Node node, HomeManager homeManager, Continuation continuation) {
        zzkm zzkmVar;
        Object manualStarter;
        Expression expressionZzi;
        if (continuation instanceof zzkm) {
            zzkmVar = (zzkm) continuation;
            int i = zzkmVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzkmVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzkmVar = new zzkm(this, continuation);
            }
        }
        Object objZzp = zzkmVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (zzkmVar.zzc) {
            case 0:
                ResultKt.throwOnFailure(objZzp);
                Node.NodeCase nodeCase = node.getNodeCase();
                Node.NodeCase nodeCase2 = Node.NodeCase.SEQUENTIAL;
                EntityBehavior.TargetTypeCase targetTypeCase = EntityBehavior.TargetTypeCase.ENTITY;
                Condition.ExpressionTypeCase expressionTypeCase = Condition.ExpressionTypeCase.EXPRESSION;
                Expression.Operator operator = Expression.Operator.OP_UNSPECIFIED;
                EntityBehavior.BehaviorTypeCase behaviorTypeCase = EntityBehavior.BehaviorTypeCase.TRAIT_ID;
                ParallelFlow.JoinSemantic joinSemantic = ParallelFlow.JoinSemantic.JS_UNSPECIFIED;
                switch (nodeCase.ordinal()) {
                    case 0:
                        zzkmVar.zzd = this;
                        zzkmVar.zze = node;
                        zzkmVar.zzc = 5;
                        objZzp = zzp(node, homeManager, zzkmVar);
                        break;
                    case 1:
                        zzkmVar.zzd = this;
                        zzkmVar.zze = node;
                        zzkmVar.zzc = 6;
                        objZzp = zzq(node, homeManager, zzkmVar);
                        break;
                    case 2:
                        zzkmVar.zzd = this;
                        zzkmVar.zze = node;
                        zzkmVar.zzc = 7;
                        objZzp = zzr(node, homeManager, zzkmVar);
                        break;
                    case 3:
                        String nodeId = node.getNodeId();
                        nodeId.getClass();
                        manualStarter = new ManualStarter(nodeId);
                        Map map = this.zzb;
                        String nodeId2 = node.getNodeId();
                        nodeId2.getClass();
                        map.put(nodeId2, manualStarter);
                        break;
                    case 4:
                        zzkmVar.zzd = this;
                        zzkmVar.zze = node;
                        zzkmVar.zzc = 1;
                        objZzp = zzh(node, homeManager, zzkmVar);
                        break;
                    case 5:
                        zzkmVar.zzd = this;
                        zzkmVar.zze = node;
                        zzkmVar.zzc = 3;
                        objZzp = zzn(node, homeManager, zzkmVar);
                        break;
                    case 6:
                        zzkmVar.zzd = this;
                        zzkmVar.zze = node;
                        zzkmVar.zzc = 2;
                        Condition condition = node.getCondition();
                        condition.getClass();
                        int iOrdinal = condition.getExpressionTypeCase().ordinal();
                        if (iOrdinal == 0) {
                            com.google.home.platform.traits.Expression expression = condition.getExpression();
                            expression.getClass();
                            zzmh zzmhVarZza = zzmf.zza(expression);
                            zzmhVarZza.zzc(this.zzb, new LinkedHashMap());
                            zzmhVarZza.zzd();
                            expressionZzi = zzi(zzmhVarZza, homeManager);
                        } else if (iOrdinal == 1) {
                            String reference = condition.getReference();
                            reference.getClass();
                            expressionZzi = zzl(reference);
                        } else if (iOrdinal != 2) {
                            Home$$ExternalSyntheticBUOutline0.m();
                        } else {
                            expressionZzi = new UnknownExpression();
                        }
                        zzyl forDurationOrNull = ConditionKtKt.getForDurationOrNull(condition);
                        Duration durationZzh = forDurationOrNull != null ? zzkg.zzh(forDurationOrNull) : null;
                        String nodeId3 = node.getNodeId();
                        nodeId3.getClass();
                        objZzp = new com.google.home.automation.Condition(expressionZzi, durationZzh, nodeId3);
                        break;
                    case 7:
                        zzkmVar.zzd = this;
                        zzkmVar.zze = node;
                        zzkmVar.zzc = 4;
                        objZzp = zzo(node, homeManager, zzkmVar);
                        break;
                    case 8:
                        zzyl delay = node.getDelay();
                        delay.getClass();
                        Duration durationZzh2 = zzkg.zzh(delay);
                        String nodeId4 = node.getNodeId();
                        nodeId4.getClass();
                        manualStarter = new Delay(durationZzh2, nodeId4);
                        Map map2 = this.zzb;
                        String nodeId22 = node.getNodeId();
                        nodeId22.getClass();
                        map2.put(nodeId22, manualStarter);
                        break;
                    case 9:
                        zzyl suppression = node.getSuppression();
                        suppression.getClass();
                        Duration durationZzh3 = zzkg.zzh(suppression);
                        String nodeId5 = node.getNodeId();
                        nodeId5.getClass();
                        manualStarter = new Suppression(durationZzh3, nodeId5);
                        Map map22 = this.zzb;
                        String nodeId222 = node.getNodeId();
                        nodeId222.getClass();
                        map22.put(nodeId222, manualStarter);
                        break;
                    case 10:
                        byte[] byteArray = node.toByteArray();
                        byteArray.getClass();
                        String nodeId6 = node.getNodeId();
                        nodeId6.getClass();
                        manualStarter = new UnknownNode(byteArray, nodeId6);
                        Map map222 = this.zzb;
                        String nodeId2222 = node.getNodeId();
                        nodeId2222.getClass();
                        map222.put(nodeId2222, manualStarter);
                        break;
                    default:
                        Home$$ExternalSyntheticBUOutline0.m();
                        break;
                }
                break;
            case 1:
                node = zzkmVar.zze;
                this = zzkmVar.zzd;
                ResultKt.throwOnFailure(objZzp);
                manualStarter = (com.google.home.automation.Node) objZzp;
                Map map2222 = this.zzb;
                String nodeId22222 = node.getNodeId();
                nodeId22222.getClass();
                map2222.put(nodeId22222, manualStarter);
                break;
            case 2:
                node = zzkmVar.zze;
                this = zzkmVar.zzd;
                ResultKt.throwOnFailure(objZzp);
                manualStarter = (com.google.home.automation.Node) objZzp;
                Map map22222 = this.zzb;
                String nodeId222222 = node.getNodeId();
                nodeId222222.getClass();
                map22222.put(nodeId222222, manualStarter);
                break;
            case 3:
                node = zzkmVar.zze;
                this = zzkmVar.zzd;
                ResultKt.throwOnFailure(objZzp);
                manualStarter = (com.google.home.automation.Node) objZzp;
                Map map222222 = this.zzb;
                String nodeId2222222 = node.getNodeId();
                nodeId2222222.getClass();
                map222222.put(nodeId2222222, manualStarter);
                break;
            case 4:
                node = zzkmVar.zze;
                this = zzkmVar.zzd;
                ResultKt.throwOnFailure(objZzp);
                manualStarter = (com.google.home.automation.Node) objZzp;
                Map map2222222 = this.zzb;
                String nodeId22222222 = node.getNodeId();
                nodeId22222222.getClass();
                map2222222.put(nodeId22222222, manualStarter);
                break;
            case 5:
                node = zzkmVar.zze;
                this = zzkmVar.zzd;
                ResultKt.throwOnFailure(objZzp);
                manualStarter = (com.google.home.automation.Node) objZzp;
                Map map22222222 = this.zzb;
                String nodeId222222222 = node.getNodeId();
                nodeId222222222.getClass();
                map22222222.put(nodeId222222222, manualStarter);
                break;
            case 6:
                node = zzkmVar.zze;
                this = zzkmVar.zzd;
                ResultKt.throwOnFailure(objZzp);
                manualStarter = (com.google.home.automation.Node) objZzp;
                Map map222222222 = this.zzb;
                String nodeId2222222222 = node.getNodeId();
                nodeId2222222222.getClass();
                map222222222.put(nodeId2222222222, manualStarter);
                break;
            case 7:
                node = zzkmVar.zze;
                this = zzkmVar.zzd;
                ResultKt.throwOnFailure(objZzp);
                manualStarter = (com.google.home.automation.Node) objZzp;
                Map map2222222222 = this.zzb;
                String nodeId22222222222 = node.getNodeId();
                nodeId22222222222.getClass();
                map2222222222.put(nodeId22222222222, manualStarter);
                break;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                break;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0099, code lost:
    
        if (r12 != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
    
        if (r12 != r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
    
        if (r12 != r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        if (r12 != r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzh(Node node, HomeManager homeManager, Continuation continuation) {
        zzkq zzkqVar;
        Pair pair;
        EventFactory<Object> eventFactory;
        if (continuation instanceof zzkq) {
            zzkqVar = (zzkq) continuation;
            int i = zzkqVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzkqVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzkqVar = new zzkq(this, continuation);
            }
        }
        Object objZzB = zzkqVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzkqVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZzB);
            Entity entity = node.getStarter().getEntity();
            entity.getClass();
            EntityBehavior.TargetTypeCase targetTypeCase = node.getStarter().getTargetTypeCase();
            Node.NodeCase nodeCase = Node.NodeCase.SEQUENTIAL;
            EntityBehavior.TargetTypeCase targetTypeCase2 = EntityBehavior.TargetTypeCase.ENTITY;
            Condition.ExpressionTypeCase expressionTypeCase = Condition.ExpressionTypeCase.EXPRESSION;
            Expression.Operator operator = Expression.Operator.OP_UNSPECIFIED;
            EntityBehavior.BehaviorTypeCase behaviorTypeCase = EntityBehavior.BehaviorTypeCase.TRAIT_ID;
            ParallelFlow.JoinSemantic joinSemantic = ParallelFlow.JoinSemantic.JS_UNSPECIFIED;
            int iOrdinal = targetTypeCase.ordinal();
            if (iOrdinal == 0) {
                zzkqVar.zze = node;
                zzkqVar.zza = homeManager;
                zzkqVar.zzd = 1;
                objZzB = zzB(entity, homeManager, zzkqVar);
            } else if (iOrdinal == 1) {
                zzkqVar.zze = node;
                zzkqVar.zza = homeManager;
                zzkqVar.zzd = 2;
                objZzB = zzB(entity, homeManager, zzkqVar);
            } else if (iOrdinal == 2) {
                zzkqVar.zze = node;
                zzkqVar.zza = homeManager;
                zzkqVar.zzd = 3;
                objZzB = zzB(entity, homeManager, zzkqVar);
            } else {
                if (iOrdinal != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                zzkqVar.zze = node;
                zzkqVar.zza = homeManager;
                zzkqVar.zzd = 4;
                objZzB = zzB(entity, homeManager, zzkqVar);
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            homeManager = (HomeManager) zzkqVar.zza;
            node = zzkqVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else if (i2 == 2) {
            homeManager = (HomeManager) zzkqVar.zza;
            node = zzkqVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else if (i2 == 3) {
            homeManager = (HomeManager) zzkqVar.zza;
            node = zzkqVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else {
            if (i2 != 4) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            homeManager = (HomeManager) zzkqVar.zza;
            node = zzkqVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        }
        HasId hasId = (HasId) pair.component1();
        DeviceTypeFactory deviceTypeFactory = (DeviceTypeFactory) pair.component2();
        homeManager.getClass();
        FactoryRegistry factoryRegistry = ((zzpu) homeManager).getZzb().getFactoryRegistry();
        String traitId = node.getStarter().getTraitId();
        traitId.getClass();
        if (traitId.length() > 0) {
            String traitId2 = node.getStarter().getTraitId();
            traitId2.getClass();
            TraitFactory<? extends Trait> traitOrNull = factoryRegistry.getTraitOrNull(traitId2);
            if (traitOrNull == null) {
                String traitId3 = node.getStarter().getTraitId();
                traitId3.getClass();
                traitOrNull = new UnknownTrait$UnknownTraitFactory(traitId3);
            }
            String output = node.getOutput();
            output.getClass();
            return new Starter(hasId, deviceTypeFactory, traitOrNull, output, node.getNodeId());
        }
        String eventId = node.getStarter().getEventId();
        eventId.getClass();
        if (eventId.length() <= 0) {
            String traitId4 = node.getStarter().getTraitId();
            traitId4.getClass();
            UnknownTrait$UnknownTraitFactory unknownTrait$UnknownTraitFactory = new UnknownTrait$UnknownTraitFactory(traitId4);
            String output2 = node.getOutput();
            output2.getClass();
            return new Starter(hasId, deviceTypeFactory, unknownTrait$UnknownTraitFactory, output2, node.getNodeId());
        }
        final String eventId2 = node.getStarter().getEventId();
        eventId2.getClass();
        TraitFactory<? extends Trait> traitOrNull2 = factoryRegistry.getTraitOrNull(StringsKt__StringsKt.substringBeforeLast$default(eventId2, '.', (String) null, 2, (Object) null));
        if (traitOrNull2 != null) {
            Object obj = zzop.zza(traitOrNull2.getFactory()).get(eventId2);
            obj.getClass();
            eventFactory = (EventFactory) obj;
        } else {
            eventFactory = new EventFactory<Object>(eventId2) { // from class: com.google.home.automation.UnknownEvent$UnknownEventFactory
                private final String id;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(new InternalEventFactory<Object>(eventId2) { // from class: com.google.home.automation.UnknownEvent$Factory
                        private final String eventId;

                        {
                            eventId2.getClass();
                            this.eventId = eventId2;
                        }
                    });
                    eventId2.getClass();
                    this.id = eventId2;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (other instanceof UnknownEvent$UnknownEventFactory) {
                        return Intrinsics.areEqual(this.id, ((UnknownEvent$UnknownEventFactory) other).id);
                    }
                    return false;
                }

                public int hashCode() {
                    return this.id.hashCode();
                }
            };
        }
        List<Parameter> parametersList = node.getStarter().getParametersList();
        parametersList.getClass();
        List<Parameter> list = parametersList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Parameter parameter : list) {
            zzkg zzkgVar = zza;
            parameter.getClass();
            arrayList.add(new com.google.home.automation.Parameter(zzkgVar.zzg(parameter, homeManager, traitOrNull2, eventFactory)));
        }
        List list2 = CollectionsKt.toList(arrayList);
        String output3 = node.getOutput();
        output3.getClass();
        return new Starter(hasId, deviceTypeFactory, eventFactory, list2, output3, node.getNodeId());
    }

    public final com.google.home.automation.Expression zzi(zzmh zzmhVar, HomeManager homeManager) {
        com.google.home.automation.Expression plus;
        zzmhVar.getClass();
        homeManager.getClass();
        List listZzb = zzmhVar.getOperands();
        com.google.home.platform.traits.Expression expressionZza = zzmhVar.getExpressionProto();
        String expressionId = expressionZza.getExpressionId();
        expressionId.getClass();
        Expression.Operator op = expressionZza.getOp();
        Node.NodeCase nodeCase = Node.NodeCase.SEQUENTIAL;
        EntityBehavior.TargetTypeCase targetTypeCase = EntityBehavior.TargetTypeCase.ENTITY;
        Condition.ExpressionTypeCase expressionTypeCase = Condition.ExpressionTypeCase.EXPRESSION;
        Expression.Operator operator = Expression.Operator.OP_UNSPECIFIED;
        EntityBehavior.BehaviorTypeCase behaviorTypeCase = EntityBehavior.BehaviorTypeCase.TRAIT_ID;
        ParallelFlow.JoinSemantic joinSemantic = ParallelFlow.JoinSemantic.JS_UNSPECIFIED;
        switch (op.ordinal()) {
            case 0:
            case 31:
                byte[] byteArray = expressionZza.toByteArray();
                byteArray.getClass();
                return new UnknownExpression(byteArray, expressionId);
            case 1:
                plus = new Plus(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 2:
                plus = new Minus(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 3:
                plus = new Multiply(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 4:
                plus = new Divide(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 5:
                plus = new Equals(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 6:
                plus = new NotEquals(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 7:
                plus = new GreaterThan(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 8:
                plus = new LessThan(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 9:
                plus = new GreaterThanOrEquals(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 10:
                plus = new LessThanOrEquals(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
                break;
            case 11:
                plus = new Between(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), zzA(listZzb, 2, homeManager), expressionId);
                break;
            case 12:
                plus = new BetweenTimes(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), zzA(listZzb, 2, homeManager), expressionId);
                break;
            case 13:
                List list = listZzb;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(zzj((OperandWithType) it.next(), homeManager));
                }
                plus = zzC(expressionZza, arrayList);
                break;
            case 14:
                List list2 = listZzb;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(zzj((OperandWithType) it2.next(), homeManager));
                }
                plus = zzD(expressionZza, arrayList2);
                break;
            case 15:
                plus = new Not(zzA(listZzb, 0, homeManager), expressionId);
                break;
            case 16:
                com.google.home.automation.Expression expressionZzA = zzA(listZzb, 0, homeManager);
                if (!(expressionZzA instanceof FieldSelect)) {
                    List listDrop = CollectionsKt.drop(listZzb, 1);
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listDrop, 10));
                    Iterator it3 = listDrop.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(zzw((OperandWithType) it3.next()));
                    }
                    return new FieldSelect(expressionZzA, CollectionsKt.toList(arrayList3), expressionId);
                }
                List listDrop2 = CollectionsKt.drop(listZzb, 2);
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listDrop2, 10));
                Iterator it4 = listDrop2.iterator();
                while (it4.hasNext()) {
                    arrayList4.add(zzw((OperandWithType) it4.next()));
                }
                FieldSelect fieldSelect = (FieldSelect) expressionZzA;
                return FieldSelect.copy$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android$default(fieldSelect, null, CollectionsKt.plus((Collection) fieldSelect.getSelected(), (Iterable) CollectionsKt.toList(arrayList4)), 1, null);
            case 17:
                return new ListSize(zzA(listZzb, 0, homeManager), expressionId);
            case 18:
                return new ListIn(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
            case 19:
                return new ListContains(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
            case 20:
                return new ListGet(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
            case 21:
                com.google.home.automation.Expression expressionZzA2 = zzA(listZzb, 0, homeManager);
                Object obj = listZzb.get(1);
                obj.getClass();
                return new ListAllMatch(expressionZzA2, zzk((zzmm) obj), zzA(listZzb, 2, homeManager), expressionId);
            case 22:
                com.google.home.automation.Expression expressionZzA3 = zzA(listZzb, 0, homeManager);
                Object obj2 = listZzb.get(1);
                obj2.getClass();
                return new ListAnyMatch(expressionZzA3, zzk((zzmm) obj2), zzA(listZzb, 2, homeManager), expressionId);
            case 23:
                com.google.home.automation.Expression expressionZzA4 = zzA(listZzb, 0, homeManager);
                Object obj3 = listZzb.get(1);
                obj3.getClass();
                return new ListNoneMatch(expressionZzA4, zzk((zzmm) obj3), zzA(listZzb, 2, homeManager), expressionId);
            case 24:
                com.google.home.automation.Expression expressionZzA5 = zzA(listZzb, 0, homeManager);
                Object obj4 = listZzb.get(1);
                obj4.getClass();
                return new ListMap(expressionZzA5, zzk((zzmm) obj4), zzA(listZzb, 2, homeManager), expressionId);
            case 25:
                com.google.home.automation.Expression expressionZzA6 = zzA(listZzb, 0, homeManager);
                Object obj5 = listZzb.get(1);
                obj5.getClass();
                return new ListFilter(expressionZzA6, zzk((zzmm) obj5), zzA(listZzb, 2, homeManager), expressionId);
            case 26:
                return new MapKeys(zzA(listZzb, 0, homeManager), expressionId);
            case 27:
                return new MapValues(zzA(listZzb, 0, homeManager), expressionId);
            case 28:
                return new MapSize(zzA(listZzb, 0, homeManager), expressionId);
            case 29:
                com.google.home.automation.Expression expressionZzA7 = zzA(listZzb, 0, homeManager);
                Object obj6 = listZzb.get(1);
                obj6.getClass();
                ReferenceDeclaration referenceDeclarationZzk = zzk((zzmm) obj6);
                Object obj7 = listZzb.get(2);
                obj7.getClass();
                return new MapFilter(expressionZzA7, referenceDeclarationZzk, zzk((zzmm) obj7), zzA(listZzb, 3, homeManager), expressionId);
            case 30:
                return new GetDevicesOfType(zzA(listZzb, 0, homeManager), zzA(listZzb, 1, homeManager), expressionId);
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
        }
        this.zzd.put(expressionId, plus);
        return plus;
    }

    public final com.google.home.automation.Expression zzj(OperandWithType operandWithType, HomeManager homeManager) {
        operandWithType.getClass();
        homeManager.getClass();
        if (operandWithType instanceof zzme) {
            zzme zzmeVar = (zzme) operandWithType;
            Value constant = zzmeVar.getConstant();
            constant.getClass();
            homeManager.getClass();
            return new Constant(zzkg.zzs(constant, homeManager, zzmeVar.getTraitFactory(), zzmeVar.getField()));
        }
        if (operandWithType instanceof zzmh) {
            return zzi((zzmh) operandWithType, homeManager);
        }
        if (operandWithType instanceof zzmm) {
            return zzl(((zzmm) operandWithType).getZza());
        }
        if (operandWithType instanceof zzmn) {
            return new UnknownExpression(((zzmn) operandWithType).getZza());
        }
        if ((operandWithType instanceof zzmi) || (operandWithType instanceof zzmj)) {
            return new UnknownExpression();
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final ReferenceDeclaration zzk(zzmm zzmmVar) {
        zzmmVar.getClass();
        ReferenceDeclaration referenceDeclaration = new ReferenceDeclaration(zzmmVar.getZza());
        this.zzc.put(zzmmVar.getZza(), referenceDeclaration);
        return referenceDeclaration;
    }

    public final com.google.home.automation.Expression zzl(String str) {
        Object obj;
        Object next;
        str.getClass();
        if (StringsKt.contains$default(str, ".")) {
            return zzm(str);
        }
        Collection collectionValues = this.zzb.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : collectionValues) {
            if (obj2 instanceof HasOutput) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((HasOutput) next).getOutput(), str)) {
                break;
            }
        }
        HasOutput hasOutput = (HasOutput) next;
        if (hasOutput != null) {
            return new Reference(hasOutput);
        }
        Iterator it2 = this.zzc.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(((ReferenceDeclaration) next2).getVariable(), str)) {
                obj = next2;
                break;
            }
        }
        ReferenceDeclaration referenceDeclaration = (ReferenceDeclaration) obj;
        return referenceDeclaration != null ? new Reference(referenceDeclaration) : new UnknownExpression();
    }

    public final com.google.home.automation.Expression zzm(String str) {
        str.getClass();
        List list = CollectionsKt.toList(StringsKt.split$default(str, new String[]{"."}, 0, 6));
        if (list.size() != 2) {
            return new UnknownExpression();
        }
        String str2 = (String) list.get(0);
        String str3 = (String) list.get(1);
        Collection collectionValues = this.zzb.values();
        ArrayList<Object> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Object obj2 = (com.google.home.automation.Node) obj;
            if ((obj2 instanceof HasOutput) && Intrinsics.areEqual(((HasOutput) obj2).getOutput(), str2)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (Object obj3 : arrayList) {
            obj3.getClass();
            arrayList2.add((HasOutput) obj3);
        }
        HasOutput hasOutput = (HasOutput) CollectionsKt.firstOrNull((List) arrayList2);
        if (hasOutput == null) {
            return new UnknownExpression();
        }
        try {
            int uInt = UStringsKt.toUInt(str3, 16);
            if (!(hasOutput instanceof Starter)) {
                if (!(hasOutput instanceof StateReader)) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                Object objMo449getAttributeByIdWZ4Q5Ns = ((StateReader) hasOutput).getTrait().mo449getAttributeByIdWZ4Q5Ns(uInt);
                if (objMo449getAttributeByIdWZ4Q5Ns == null) {
                    objMo449getAttributeByIdWZ4Q5Ns = new UnknownField(uInt, null);
                }
                return new FieldSelect(new Reference(hasOutput), CollectionsKt.listOf(objMo449getAttributeByIdWZ4Q5Ns));
            }
            Starter starter = (Starter) hasOutput;
            if (starter.getTrait() != null) {
                Object objMo449getAttributeByIdWZ4Q5Ns2 = starter.getTrait().mo449getAttributeByIdWZ4Q5Ns(uInt);
                if (objMo449getAttributeByIdWZ4Q5Ns2 == null) {
                    objMo449getAttributeByIdWZ4Q5Ns2 = new UnknownField(uInt, null);
                }
                return new FieldSelect(new Reference(hasOutput), CollectionsKt.listOf(objMo449getAttributeByIdWZ4Q5Ns2));
            }
            if (starter.getEvent() != null) {
                Object objM437getEventFieldByIdWZ4Q5Ns = starter.getEvent().m437getEventFieldByIdWZ4Q5Ns(uInt);
                if (objM437getEventFieldByIdWZ4Q5Ns == null) {
                    objM437getEventFieldByIdWZ4Q5Ns = new UnknownField(uInt, null);
                }
                return new FieldSelect(new Reference(hasOutput), CollectionsKt.listOf(objM437getEventFieldByIdWZ4Q5Ns));
            }
            zzrt zzrtVarZzc = AutomationSdkLogger.zza().zzc();
            new StringBuilder(hasOutput.toString().length() + 68);
            hasOutput.toString();
            zzrtVarZzc.zza("AutomationConverter fromReferenceProtoLegacy empty trait and event: ".concat(hasOutput.toString()), new Object[0]);
            return new Constant(0);
        } catch (NumberFormatException unused) {
            int i = AutomationSdkLogger.$r8$clinit;
            AutomationSdkLogger.zza().zza().zza("AutomationConverter createFieldSelect invalid UInt for fieldIdentifier: ".concat(String.valueOf(str3)), new Object[0]);
            return new FieldSelect(new Reference(hasOutput), CollectionsKt.listOf(new UnknownField(0, null)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0099, code lost:
    
        if (r12 != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
    
        if (r12 != r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
    
        if (r12 != r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        if (r12 != r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzn(Node node, HomeManager homeManager, Continuation continuation) {
        zzkr zzkrVar;
        Pair pair;
        if (continuation instanceof zzkr) {
            zzkrVar = (zzkr) continuation;
            int i = zzkrVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzkrVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzkrVar = new zzkr(this, continuation);
            }
        }
        Object objZzB = zzkrVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzkrVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZzB);
            Entity entity = node.getStateReader().getEntity();
            entity.getClass();
            EntityBehavior.TargetTypeCase targetTypeCase = node.getStateReader().getTargetTypeCase();
            Node.NodeCase nodeCase = Node.NodeCase.SEQUENTIAL;
            EntityBehavior.TargetTypeCase targetTypeCase2 = EntityBehavior.TargetTypeCase.ENTITY;
            Condition.ExpressionTypeCase expressionTypeCase = Condition.ExpressionTypeCase.EXPRESSION;
            Expression.Operator operator = Expression.Operator.OP_UNSPECIFIED;
            EntityBehavior.BehaviorTypeCase behaviorTypeCase = EntityBehavior.BehaviorTypeCase.TRAIT_ID;
            ParallelFlow.JoinSemantic joinSemantic = ParallelFlow.JoinSemantic.JS_UNSPECIFIED;
            int iOrdinal = targetTypeCase.ordinal();
            if (iOrdinal == 0) {
                zzkrVar.zze = node;
                zzkrVar.zza = homeManager;
                zzkrVar.zzd = 1;
                objZzB = zzB(entity, homeManager, zzkrVar);
            } else if (iOrdinal == 1) {
                zzkrVar.zze = node;
                zzkrVar.zza = homeManager;
                zzkrVar.zzd = 2;
                objZzB = zzB(entity, homeManager, zzkrVar);
            } else if (iOrdinal == 2) {
                zzkrVar.zze = node;
                zzkrVar.zza = homeManager;
                zzkrVar.zzd = 3;
                objZzB = zzB(entity, homeManager, zzkrVar);
            } else {
                if (iOrdinal != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                zzkrVar.zze = node;
                zzkrVar.zza = homeManager;
                zzkrVar.zzd = 4;
                objZzB = zzB(entity, homeManager, zzkrVar);
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            homeManager = (HomeManager) zzkrVar.zza;
            node = zzkrVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else if (i2 == 2) {
            homeManager = (HomeManager) zzkrVar.zza;
            node = zzkrVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else if (i2 == 3) {
            homeManager = (HomeManager) zzkrVar.zza;
            node = zzkrVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else {
            if (i2 != 4) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            homeManager = (HomeManager) zzkrVar.zza;
            node = zzkrVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        }
        HasId hasId = (HasId) pair.component1();
        DeviceTypeFactory deviceTypeFactory = (DeviceTypeFactory) pair.component2();
        homeManager.getClass();
        FactoryRegistry factoryRegistry = ((zzpu) homeManager).getZzb().getFactoryRegistry();
        String traitId = node.getStateReader().getTraitId();
        traitId.getClass();
        TraitFactory<? extends Trait> traitOrNull = factoryRegistry.getTraitOrNull(traitId);
        if (traitOrNull == null) {
            String traitId2 = node.getStateReader().getTraitId();
            traitId2.getClass();
            traitOrNull = new UnknownTrait$UnknownTraitFactory(traitId2);
        }
        String output = node.getOutput();
        output.getClass();
        return new StateReader(hasId, deviceTypeFactory, traitOrNull, output, node.getNodeId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0099, code lost:
    
        if (r12 != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
    
        if (r12 != r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
    
        if (r12 != r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        if (r12 != r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzo(Node node, HomeManager homeManager, Continuation continuation) {
        zzkh zzkhVar;
        Pair pair;
        ActionBehavior update;
        Map mapEmptyMap;
        if (continuation instanceof zzkh) {
            zzkhVar = (zzkh) continuation;
            int i = zzkhVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzkhVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzkhVar = new zzkh(this, continuation);
            }
        }
        Object objZzB = zzkhVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzkhVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZzB);
            Entity entity = node.getAction().getEntity();
            entity.getClass();
            EntityBehavior.TargetTypeCase targetTypeCase = node.getAction().getTargetTypeCase();
            Node.NodeCase nodeCase = Node.NodeCase.SEQUENTIAL;
            EntityBehavior.TargetTypeCase targetTypeCase2 = EntityBehavior.TargetTypeCase.ENTITY;
            Condition.ExpressionTypeCase expressionTypeCase = Condition.ExpressionTypeCase.EXPRESSION;
            Expression.Operator operator = Expression.Operator.OP_UNSPECIFIED;
            EntityBehavior.BehaviorTypeCase behaviorTypeCase = EntityBehavior.BehaviorTypeCase.TRAIT_ID;
            ParallelFlow.JoinSemantic joinSemantic = ParallelFlow.JoinSemantic.JS_UNSPECIFIED;
            int iOrdinal = targetTypeCase.ordinal();
            if (iOrdinal == 0) {
                zzkhVar.zze = node;
                zzkhVar.zza = homeManager;
                zzkhVar.zzd = 1;
                objZzB = zzB(entity, homeManager, zzkhVar);
            } else if (iOrdinal == 1) {
                zzkhVar.zze = node;
                zzkhVar.zza = homeManager;
                zzkhVar.zzd = 2;
                objZzB = zzB(entity, homeManager, zzkhVar);
            } else if (iOrdinal == 2) {
                zzkhVar.zze = node;
                zzkhVar.zza = homeManager;
                zzkhVar.zzd = 3;
                objZzB = zzB(entity, homeManager, zzkhVar);
            } else {
                if (iOrdinal != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                zzkhVar.zze = node;
                zzkhVar.zza = homeManager;
                zzkhVar.zzd = 4;
                objZzB = zzB(entity, homeManager, zzkhVar);
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            homeManager = (HomeManager) zzkhVar.zza;
            node = zzkhVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else if (i2 == 2) {
            homeManager = (HomeManager) zzkhVar.zza;
            node = zzkhVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else if (i2 == 3) {
            homeManager = (HomeManager) zzkhVar.zza;
            node = zzkhVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        } else {
            if (i2 != 4) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            homeManager = (HomeManager) zzkhVar.zza;
            node = zzkhVar.zze;
            ResultKt.throwOnFailure(objZzB);
            pair = (Pair) objZzB;
        }
        HasId hasId = (HasId) pair.component1();
        DeviceTypeFactory deviceTypeFactory = (DeviceTypeFactory) pair.component2();
        homeManager.getClass();
        FactoryRegistry factoryRegistry = ((zzpu) homeManager).getZzb().getFactoryRegistry();
        EntityBehavior.BehaviorTypeCase behaviorTypeCase2 = node.getAction().getBehaviorTypeCase();
        Node.NodeCase nodeCase2 = Node.NodeCase.SEQUENTIAL;
        EntityBehavior.TargetTypeCase targetTypeCase3 = EntityBehavior.TargetTypeCase.ENTITY;
        Condition.ExpressionTypeCase expressionTypeCase2 = Condition.ExpressionTypeCase.EXPRESSION;
        Expression.Operator operator2 = Expression.Operator.OP_UNSPECIFIED;
        EntityBehavior.BehaviorTypeCase behaviorTypeCase3 = EntityBehavior.BehaviorTypeCase.TRAIT_ID;
        ParallelFlow.JoinSemantic joinSemantic2 = ParallelFlow.JoinSemantic.JS_UNSPECIFIED;
        int iOrdinal2 = behaviorTypeCase2.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 != 1) {
                if (iOrdinal2 == 2) {
                    String commandId = node.getAction().getCommandId();
                    commandId.getClass();
                    TraitFactory<? extends Trait> traitOrNull = factoryRegistry.getTraitOrNull(commandId);
                    if (traitOrNull == null) {
                        String commandId2 = node.getAction().getCommandId();
                        commandId2.getClass();
                        update = new UnknownCommand(commandId2);
                    } else {
                        String commandId3 = node.getAction().getCommandId();
                        commandId3.getClass();
                        CommandDescriptor commandDescriptor = (CommandDescriptor) zzop.zzb(traitOrNull.getFactory()).get(commandId3);
                        if (commandDescriptor != null) {
                            List<Parameter> parametersList = node.getAction().getParametersList();
                            parametersList.getClass();
                            List<Parameter> list = parametersList;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            for (Parameter parameter : list) {
                                zzkg zzkgVar = zza;
                                parameter.getClass();
                                arrayList.add(zzkgVar.zzg(parameter, homeManager, traitOrNull, commandDescriptor));
                            }
                            mapEmptyMap = MapsKt.toMap(arrayList);
                        } else {
                            mapEmptyMap = MapsKt.emptyMap();
                        }
                        update = new Command(traitOrNull, commandId3, mapEmptyMap);
                    }
                } else if (iOrdinal2 != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
            }
            byte[] byteArray = node.toByteArray();
            byteArray.getClass();
            String nodeId = node.getNodeId();
            nodeId.getClass();
            return new UnknownNode(byteArray, nodeId);
        }
        String traitId = node.getAction().getTraitId();
        traitId.getClass();
        TraitFactory<? extends Trait> traitOrNull2 = factoryRegistry.getTraitOrNull(traitId);
        if (traitOrNull2 == null) {
            String traitId2 = node.getAction().getTraitId();
            traitId2.getClass();
            traitOrNull2 = new UnknownTrait$UnknownTraitFactory(traitId2);
        }
        List<Parameter> parametersList2 = node.getAction().getParametersList();
        parametersList2.getClass();
        List<Parameter> list2 = parametersList2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Parameter parameter2 : list2) {
            zzkg zzkgVar2 = zza;
            parameter2.getClass();
            arrayList2.add(zzkgVar2.zzg(parameter2, homeManager, traitOrNull2, traitOrNull2));
        }
        update = new Update(traitOrNull2, MapsKt.toMap(arrayList2));
        String nodeId2 = node.getNodeId();
        nodeId2.getClass();
        return new Action(hasId, deviceTypeFactory, update, nodeId2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0090 -> B:20:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzp(Node node, HomeManager homeManager, Continuation continuation) {
        zzkp zzkpVar;
        Iterator it;
        zzkt zzktVar;
        Collection collection;
        zzkp zzkpVar2;
        HomeManager homeManager2;
        Node node2;
        if (continuation instanceof zzkp) {
            zzkpVar = (zzkp) continuation;
            int i = zzkpVar.zzg;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzkpVar.zzg = i - Integer.MIN_VALUE;
            } else {
                zzkpVar = new zzkp(this, continuation);
            }
        }
        Object obj = zzkpVar.zze;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzkpVar.zzg;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<Node> nodesList = node.getSequential().getNodesList();
            nodesList.getClass();
            List<Node> list = nodesList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            it = list.iterator();
            zzktVar = this;
            collection = arrayList;
            zzkpVar2 = zzkpVar;
            homeManager2 = homeManager;
            node2 = node;
            if (it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            collection = (Collection) zzkpVar.zzd;
            Iterator it2 = (Iterator) zzkpVar.zzc;
            Collection collection2 = (Collection) zzkpVar.zzb;
            HomeManager homeManager3 = (HomeManager) zzkpVar.zza;
            Node node3 = zzkpVar.zzi;
            zzkt zzktVar2 = zzkpVar.zzh;
            ResultKt.throwOnFailure(obj);
            zzkp zzkpVar3 = zzkpVar;
            Iterator it3 = it2;
            zzktVar = zzktVar2;
            zzkp zzkpVar4 = zzkpVar3;
            collection.add((com.google.home.automation.Node) obj);
            collection = collection2;
            it = it3;
            homeManager2 = homeManager3;
            node2 = node3;
            zzkpVar2 = zzkpVar4;
            if (it.hasNext()) {
                Node node4 = (Node) it.next();
                node4.getClass();
                zzkpVar2.zzh = zzktVar;
                zzkpVar2.zzi = node2;
                zzkpVar2.zza = homeManager2;
                zzkpVar2.zzb = collection;
                zzkpVar2.zzc = it;
                zzkpVar2.zzd = collection;
                zzkpVar2.zzg = 1;
                Object objZzg = zzktVar.zzg(node4, homeManager2, zzkpVar2);
                if (objZzg == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzkpVar4 = zzkpVar2;
                homeManager3 = homeManager2;
                it3 = it;
                obj = objZzg;
                node3 = node2;
                collection2 = collection;
                collection.add((com.google.home.automation.Node) obj);
                collection = collection2;
                it = it3;
                homeManager2 = homeManager3;
                node2 = node3;
                zzkpVar2 = zzkpVar4;
                if (it.hasNext()) {
                    String nodeId = node2.getNodeId();
                    nodeId.getClass();
                    return new SequentialFlow((List) collection, nodeId);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0090 -> B:20:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzq(Node node, HomeManager homeManager, Continuation continuation) {
        zzkn zzknVar;
        Iterator it;
        zzkt zzktVar;
        Collection collection;
        zzkn zzknVar2;
        HomeManager homeManager2;
        Node node2;
        if (continuation instanceof zzkn) {
            zzknVar = (zzkn) continuation;
            int i = zzknVar.zzg;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzknVar.zzg = i - Integer.MIN_VALUE;
            } else {
                zzknVar = new zzkn(this, continuation);
            }
        }
        Object obj = zzknVar.zze;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzknVar.zzg;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<Node> nodesList = node.getParallel().getNodesList();
            nodesList.getClass();
            List<Node> list = nodesList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            it = list.iterator();
            zzktVar = this;
            collection = arrayList;
            zzknVar2 = zzknVar;
            homeManager2 = homeManager;
            node2 = node;
            if (it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            collection = (Collection) zzknVar.zzd;
            Iterator it2 = (Iterator) zzknVar.zzc;
            Collection collection2 = (Collection) zzknVar.zzb;
            HomeManager homeManager3 = (HomeManager) zzknVar.zza;
            Node node3 = zzknVar.zzi;
            zzkt zzktVar2 = zzknVar.zzh;
            ResultKt.throwOnFailure(obj);
            zzkn zzknVar3 = zzknVar;
            Iterator it3 = it2;
            zzktVar = zzktVar2;
            zzkn zzknVar4 = zzknVar3;
            collection.add((com.google.home.automation.Node) obj);
            collection = collection2;
            it = it3;
            homeManager2 = homeManager3;
            node2 = node3;
            zzknVar2 = zzknVar4;
            if (it.hasNext()) {
                Node node4 = (Node) it.next();
                node4.getClass();
                zzknVar2.zzh = zzktVar;
                zzknVar2.zzi = node2;
                zzknVar2.zza = homeManager2;
                zzknVar2.zzb = collection;
                zzknVar2.zzc = it;
                zzknVar2.zzd = collection;
                zzknVar2.zzg = 1;
                Object objZzg = zzktVar.zzg(node4, homeManager2, zzknVar2);
                if (objZzg == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzknVar4 = zzknVar2;
                homeManager3 = homeManager2;
                it3 = it;
                obj = objZzg;
                node3 = node2;
                collection2 = collection;
                collection.add((com.google.home.automation.Node) obj);
                collection = collection2;
                it = it3;
                homeManager2 = homeManager3;
                node2 = node3;
                zzknVar2 = zzknVar4;
                if (it.hasNext()) {
                    List list2 = (List) collection;
                    ParallelFlow.JoinSemantic joinSemantic = node2.getParallel().getJoinSemantic();
                    joinSemantic.getClass();
                    Node.NodeCase nodeCase = Node.NodeCase.SEQUENTIAL;
                    EntityBehavior.TargetTypeCase targetTypeCase = EntityBehavior.TargetTypeCase.ENTITY;
                    Condition.ExpressionTypeCase expressionTypeCase = Condition.ExpressionTypeCase.EXPRESSION;
                    Expression.Operator operator = Expression.Operator.OP_UNSPECIFIED;
                    EntityBehavior.BehaviorTypeCase behaviorTypeCase = EntityBehavior.BehaviorTypeCase.TRAIT_ID;
                    ParallelFlow.JoinSemantic joinSemantic2 = ParallelFlow.JoinSemantic.JS_UNSPECIFIED;
                    JoinSemanticType joinSemanticType = joinSemantic.ordinal() != 1 ? JoinSemanticType.JsUnspecified : JoinSemanticType.JsWhenAllFinished;
                    String nodeId = node2.getNodeId();
                    nodeId.getClass();
                    return new com.google.home.automation.ParallelFlow(list2, joinSemanticType, nodeId);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0090 -> B:20:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzr(Node node, HomeManager homeManager, Continuation continuation) {
        zzko zzkoVar;
        Iterator it;
        zzkt zzktVar;
        Collection collection;
        zzko zzkoVar2;
        HomeManager homeManager2;
        Node node2;
        if (continuation instanceof zzko) {
            zzkoVar = (zzko) continuation;
            int i = zzkoVar.zzg;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzkoVar.zzg = i - Integer.MIN_VALUE;
            } else {
                zzkoVar = new zzko(this, continuation);
            }
        }
        Object obj = zzkoVar.zze;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzkoVar.zzg;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<Node> nodesList = node.getSelect().getNodesList();
            nodesList.getClass();
            List<Node> list = nodesList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            it = list.iterator();
            zzktVar = this;
            collection = arrayList;
            zzkoVar2 = zzkoVar;
            homeManager2 = homeManager;
            node2 = node;
            if (it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            collection = (Collection) zzkoVar.zzd;
            Iterator it2 = (Iterator) zzkoVar.zzc;
            Collection collection2 = (Collection) zzkoVar.zzb;
            HomeManager homeManager3 = (HomeManager) zzkoVar.zza;
            Node node3 = zzkoVar.zzi;
            zzkt zzktVar2 = zzkoVar.zzh;
            ResultKt.throwOnFailure(obj);
            zzko zzkoVar3 = zzkoVar;
            Iterator it3 = it2;
            zzktVar = zzktVar2;
            zzko zzkoVar4 = zzkoVar3;
            collection.add((com.google.home.automation.Node) obj);
            collection = collection2;
            it = it3;
            homeManager2 = homeManager3;
            node2 = node3;
            zzkoVar2 = zzkoVar4;
            if (it.hasNext()) {
                Node node4 = (Node) it.next();
                node4.getClass();
                zzkoVar2.zzh = zzktVar;
                zzkoVar2.zzi = node2;
                zzkoVar2.zza = homeManager2;
                zzkoVar2.zzb = collection;
                zzkoVar2.zzc = it;
                zzkoVar2.zzd = collection;
                zzkoVar2.zzg = 1;
                Object objZzg = zzktVar.zzg(node4, homeManager2, zzkoVar2);
                if (objZzg == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzkoVar4 = zzkoVar2;
                homeManager3 = homeManager2;
                it3 = it;
                obj = objZzg;
                node3 = node2;
                collection2 = collection;
                collection.add((com.google.home.automation.Node) obj);
                collection = collection2;
                it = it3;
                homeManager2 = homeManager3;
                node2 = node3;
                zzkoVar2 = zzkoVar4;
                if (it.hasNext()) {
                    String nodeId = node2.getNodeId();
                    nodeId.getClass();
                    return new SelectFlow((List) collection, nodeId);
                }
            }
        }
    }

    public final ValidationIssue zzs(ValidationResult validationResult, SequentialFlow sequentialFlow, HomeManager homeManager) {
        validationResult.getClass();
        sequentialFlow.getClass();
        homeManager.getClass();
        return zzmo.zza(validationResult, MapsKt.withDefault(MapsKt.toMap(this.zzb), new zzks(sequentialFlow)), MapsKt.toMap(this.zzd), homeManager);
    }
}
