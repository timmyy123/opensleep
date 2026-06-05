package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.EventFactory;
import com.google.home.FactoryRegistry;
import com.google.home.Field;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.HomeException;
import com.google.home.HomeManager;
import com.google.home.Id;
import com.google.home.InternalTraitFactory;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.automation.Constraint;
import com.google.home.automation.Expression;
import com.google.home.automation.Node;
import com.google.home.automation.UnknownEntity;
import com.google.home.automation.UnknownIssue;
import com.google.home.automation.ValidationIssue;
import com.google.home.automation.ValidationIssueSeverity;
import com.google.home.automation.ValidationIssueType;
import com.google.home.platform.traits.AutomationTooLarge;
import com.google.home.platform.traits.BlockedAction;
import com.google.home.platform.traits.ConditionDurationOutOfRange;
import com.google.home.platform.traits.DelayDurationOutOfRange;
import com.google.home.platform.traits.DuplicateStarterNode;
import com.google.home.platform.traits.InvalidArgumentCount;
import com.google.home.platform.traits.InvalidArgumentsForOperator;
import com.google.home.platform.traits.InvalidCommand;
import com.google.home.platform.traits.InvalidConditionType;
import com.google.home.platform.traits.InvalidDuration;
import com.google.home.platform.traits.InvalidEntity;
import com.google.home.platform.traits.InvalidEvent;
import com.google.home.platform.traits.InvalidField;
import com.google.home.platform.traits.InvalidNullParameterValue;
import com.google.home.platform.traits.InvalidOperand;
import com.google.home.platform.traits.InvalidParameter;
import com.google.home.platform.traits.InvalidParameterType;
import com.google.home.platform.traits.InvalidReference;
import com.google.home.platform.traits.InvalidTrait;
import com.google.home.platform.traits.InvalidValue;
import com.google.home.platform.traits.MisplacedSelectFlow;
import com.google.home.platform.traits.MisplacedStarterNode;
import com.google.home.platform.traits.MissingRequiredFields;
import com.google.home.platform.traits.MissingRequiredParameters;
import com.google.home.platform.traits.MissingStarterNode;
import com.google.home.platform.traits.MultipleManualStarters;
import com.google.home.platform.traits.OutputNotAccessible;
import com.google.home.platform.traits.OutputReinitialized;
import com.google.home.platform.traits.OutputTypeMismatch;
import com.google.home.platform.traits.ReadOnlyAttribute;
import com.google.home.platform.traits.SuppressionDurationOutOfRange;
import com.google.home.platform.traits.TooManyNodes;
import com.google.home.platform.traits.TooManyOperations;
import com.google.home.platform.traits.UnsubscribableAttribute;
import com.google.home.platform.traits.UnsupportedActionBehavior;
import com.google.home.platform.traits.UnsupportedCandidateReason;
import com.google.home.platform.traits.UnsupportedEntityCommand;
import com.google.home.platform.traits.UnsupportedEntityEvent;
import com.google.home.platform.traits.UnsupportedEntityParameter;
import com.google.home.platform.traits.UnsupportedEntityParameterValue;
import com.google.home.platform.traits.UnsupportedEntityTrait;
import com.google.home.platform.traits.UnsupportedEntityType;
import com.google.home.platform.traits.UnsupportedNodeOutput;
import com.google.home.platform.traits.UnsupportedOperator;
import com.google.home.platform.traits.UnsupportedStarterBehavior;
import com.google.home.platform.traits.UnsupportedStateReaderBehavior;
import com.google.home.platform.traits.UnsupportedSubNodeType;
import com.google.home.platform.traits.ValidationIssue;
import com.google.home.platform.traits.ValidationResult;
import com.google.home.platform.traits.Value;
import com.google.home.platform.traits.ValueType;
import com.google.home.platform.traits.ValueTypeConstraint;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\n\u001a\u00020\t*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0015\u001a\u00020\r*\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0019\u001a\u00020\u0018*\u00020\u00172\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a#\u0010\u001d\u001a\u00020\u001c*\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a7\u0010!\u001a\u00020 *\u00020\u001f2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¢\u0006\u0004\b!\u0010\"\u001a-\u0010&\u001a\u00020%*\u00020#2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b&\u0010'\u001a#\u0010*\u001a\u00020)*\u00020(2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b*\u0010+\u001a#\u0010.\u001a\u00020-*\u00020,2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b.\u0010/\u001a#\u00102\u001a\u000201*\u0002002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b2\u00103\u001a-\u00106\u001a\u000205*\u0002042\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b6\u00107\u001a#\u0010:\u001a\u000209*\u0002082\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b:\u0010;\u001a#\u0010>\u001a\u00020=*\u00020<2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b>\u0010?\u001a5\u0010B\u001a\u00020A*\u00020@2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\bB\u0010C\u001a#\u0010F\u001a\u00020E*\u00020D2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bF\u0010G\u001a#\u0010J\u001a\u00020I*\u00020H2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bJ\u0010K\u001a#\u0010N\u001a\u00020M*\u00020L2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bN\u0010O\u001a\u0013\u0010R\u001a\u00020Q*\u00020PH\u0000¢\u0006\u0004\bR\u0010S\u001a#\u0010V\u001a\u00020U*\u00020T2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bV\u0010W\u001a#\u0010Z\u001a\u00020Y*\u00020X2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bZ\u0010[\u001a#\u0010^\u001a\u00020]*\u00020\\2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b^\u0010_\u001a#\u0010b\u001a\u00020a*\u00020`2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bb\u0010c\u001a7\u0010f\u001a\u00020e*\u00020d2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¢\u0006\u0004\bf\u0010g\u001a7\u0010j\u001a\u00020i*\u00020h2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¢\u0006\u0004\bj\u0010k\u001a#\u0010n\u001a\u00020m*\u00020l2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bn\u0010o\u001a#\u0010r\u001a\u00020q*\u00020p2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\br\u0010s\u001a#\u0010v\u001a\u00020u*\u00020t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bv\u0010w\u001a#\u0010z\u001a\u00020y*\u00020x2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bz\u0010{\u001a#\u0010~\u001a\u00020}*\u00020|2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b~\u0010\u007f\u001a(\u0010\u0082\u0001\u001a\u00030\u0081\u0001*\u00030\u0080\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a(\u0010\u0086\u0001\u001a\u00030\u0085\u0001*\u00030\u0084\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a(\u0010\u008a\u0001\u001a\u00030\u0089\u0001*\u00030\u0088\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a(\u0010\u008e\u0001\u001a\u00030\u008d\u0001*\u00030\u008c\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a2\u0010\u0092\u0001\u001a\u00030\u0091\u0001*\u00030\u0090\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a2\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00030\u0094\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a2\u0010\u009a\u0001\u001a\u00030\u0099\u0001*\u00030\u0098\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a(\u0010\u009e\u0001\u001a\u00030\u009d\u0001*\u00030\u009c\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a(\u0010¢\u0001\u001a\u00030¡\u0001*\u00030 \u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b¢\u0001\u0010£\u0001\u001a2\u0010¦\u0001\u001a\u00030¥\u0001*\u00030¤\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001\u001a(\u0010ª\u0001\u001a\u00030©\u0001*\u00030¨\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001\u001a(\u0010®\u0001\u001a\u00030\u00ad\u0001*\u00030¬\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b®\u0001\u0010¯\u0001\u001a(\u0010²\u0001\u001a\u00030±\u0001*\u00030°\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b²\u0001\u0010³\u0001\u001a(\u0010¶\u0001\u001a\u00030µ\u0001*\u00030´\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\b¶\u0001\u0010·\u0001\u001a(\u0010º\u0001\u001a\u00030¹\u0001*\u00030¸\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\bº\u0001\u0010»\u0001\u001a0\u0010¾\u0001\u001a\u00030½\u0001*\u00030¼\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0006\b¾\u0001\u0010¿\u0001\u001a\"\u0010Á\u0001\u001a\u0005\u0018\u00010À\u0001*\u00030¼\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0006\bÁ\u0001\u0010Â\u0001\u001a(\u0010Å\u0001\u001a\u00030Ä\u0001*\u00030Ã\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001\u001a(\u0010É\u0001\u001a\u00030È\u0001*\u00030Ç\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001\u001a(\u0010Í\u0001\u001a\u00030Ì\u0001*\u00030Ë\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\bÍ\u0001\u0010Î\u0001\u001a(\u0010Ñ\u0001\u001a\u00030Ð\u0001*\u00030Ï\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001\u001a(\u0010Õ\u0001\u001a\u00030Ô\u0001*\u00030Ó\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001\u001a\u0017\u0010Ø\u0001\u001a\u00020\u0002*\u00030×\u0001H\u0000¢\u0006\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0017\u0010Û\u0001\u001a\u00020\u0002*\u00030Ú\u0001H\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0017\u0010Û\u0001\u001a\u00020\u0002*\u00030Ý\u0001H\u0000¢\u0006\u0006\bÛ\u0001\u0010Þ\u0001¨\u0006ß\u0001"}, d2 = {"Lcom/google/home/platform/traits/ValidationResult;", "", "", "Lcom/google/home/automation/Node;", "convertedNodesMap", "Lcom/google/home/automation/Expression;", "convertedExpressionsMap", "Lcom/google/home/HomeManager;", "homeManager", "Lcom/google/home/automation/ValidationIssue;", "fromValidationResultProtoToValidationIssue", "(Lcom/google/home/platform/traits/ValidationResult;Ljava/util/Map;Ljava/util/Map;Lcom/google/home/HomeManager;)Lcom/google/home/automation/ValidationIssue;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/home/automation/ValidationIssueType;", "issueType", "Lcom/google/home/automation/UnknownIssue;", "createUnknownValidationIssue", "(Lcom/google/home/platform/traits/ValidationResult;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/ValidationIssueType;)Lcom/google/home/automation/UnknownIssue;", "Lcom/google/home/platform/traits/ValidationResult$Severity;", "fromSeverityProto", "(Lcom/google/home/platform/traits/ValidationResult$Severity;)Lcom/google/home/automation/ValidationIssueSeverity;", "Lcom/google/home/platform/traits/ConditionDurationOutOfRange;", "Lcom/google/home/automation/ConditionDurationOutOfRange;", "fromConditionDurationOutOfRangeProto", "(Lcom/google/home/platform/traits/ConditionDurationOutOfRange;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/ConditionDurationOutOfRange;", "Lcom/google/home/platform/traits/DelayDurationOutOfRange;", "Lcom/google/home/automation/DelayDurationOutOfRange;", "fromDelayDurationOutOfRangeProto", "(Lcom/google/home/platform/traits/DelayDurationOutOfRange;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/DelayDurationOutOfRange;", "Lcom/google/home/platform/traits/DuplicateStarterNode;", "Lcom/google/home/automation/DuplicateStarterNode;", "fromDuplicateStarterNodeProto", "(Lcom/google/home/platform/traits/DuplicateStarterNode;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Ljava/util/Map;)Lcom/google/home/automation/DuplicateStarterNode;", "Lcom/google/home/platform/traits/InvalidArgumentCount;", "expression", "Lcom/google/home/automation/InvalidArgumentCount;", "fromInvalidArgumentCountProto", "(Lcom/google/home/platform/traits/InvalidArgumentCount;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;)Lcom/google/home/automation/InvalidArgumentCount;", "Lcom/google/home/platform/traits/InvalidCommand;", "Lcom/google/home/automation/InvalidCommand;", "fromInvalidCommandProto", "(Lcom/google/home/platform/traits/InvalidCommand;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/InvalidCommand;", "Lcom/google/home/platform/traits/InvalidDuration;", "Lcom/google/home/automation/InvalidDuration;", "fromInvalidDurationProto", "(Lcom/google/home/platform/traits/InvalidDuration;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/InvalidDuration;", "Lcom/google/home/platform/traits/InvalidEvent;", "Lcom/google/home/automation/InvalidEvent;", "fromInvalidEventProto", "(Lcom/google/home/platform/traits/InvalidEvent;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/InvalidEvent;", "Lcom/google/home/platform/traits/InvalidOperand;", "Lcom/google/home/automation/InvalidOperand;", "fromInvalidOperandProto", "(Lcom/google/home/platform/traits/InvalidOperand;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;)Lcom/google/home/automation/InvalidOperand;", "Lcom/google/home/platform/traits/InvalidParameter;", "Lcom/google/home/automation/InvalidParameter;", "fromInvalidParameterProto", "(Lcom/google/home/platform/traits/InvalidParameter;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/InvalidParameter;", "Lcom/google/home/platform/traits/InvalidTrait;", "Lcom/google/home/automation/InvalidTrait;", "fromInvalidTraitProto", "(Lcom/google/home/platform/traits/InvalidTrait;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/InvalidTrait;", "Lcom/google/home/platform/traits/InvalidValue;", "Lcom/google/home/automation/InvalidValue;", "fromInvalidValueProto", "(Lcom/google/home/platform/traits/InvalidValue;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;Lcom/google/home/HomeManager;)Lcom/google/home/automation/InvalidValue;", "Lcom/google/home/platform/traits/MisplacedSelectFlow;", "Lcom/google/home/automation/MisplacedSelectFlow;", "fromMisplacedSelectFlowProto", "(Lcom/google/home/platform/traits/MisplacedSelectFlow;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/MisplacedSelectFlow;", "Lcom/google/home/platform/traits/MisplacedStarterNode;", "Lcom/google/home/automation/MisplacedStarterNode;", "fromMisplacedStarterNodeProto", "(Lcom/google/home/platform/traits/MisplacedStarterNode;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/MisplacedStarterNode;", "Lcom/google/home/platform/traits/MissingRequiredFields;", "Lcom/google/home/automation/MissingRequiredFields;", "fromMissingRequiredFieldsProto", "(Lcom/google/home/platform/traits/MissingRequiredFields;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/MissingRequiredFields;", "Lcom/google/protobuf/Duration;", "j$/time/Duration", "toDuration", "(Lcom/google/protobuf/Duration;)Lj$/time/Duration;", "Lcom/google/home/platform/traits/MissingRequiredParameters;", "Lcom/google/home/automation/MissingRequiredParameters;", "fromMissingRequiredParametersProto", "(Lcom/google/home/platform/traits/MissingRequiredParameters;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/MissingRequiredParameters;", "Lcom/google/home/platform/traits/MissingStarterNode;", "Lcom/google/home/automation/MissingStarterNode;", "fromMissingStarterNodeProto", "(Lcom/google/home/platform/traits/MissingStarterNode;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/MissingStarterNode;", "Lcom/google/home/platform/traits/MultipleManualStarters;", "Lcom/google/home/automation/MultipleManualStarters;", "fromMultipleManualStartersProto", "(Lcom/google/home/platform/traits/MultipleManualStarters;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/MultipleManualStarters;", "Lcom/google/home/platform/traits/OutputNotAccessible;", "Lcom/google/home/automation/OutputNotAccessible;", "fromOutputNotAccessibleProto", "(Lcom/google/home/platform/traits/OutputNotAccessible;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/OutputNotAccessible;", "Lcom/google/home/platform/traits/OutputTypeMismatch;", "Lcom/google/home/automation/OutputTypeMismatch;", "fromOutputTypeMismatchProto", "(Lcom/google/home/platform/traits/OutputTypeMismatch;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Ljava/util/Map;)Lcom/google/home/automation/OutputTypeMismatch;", "Lcom/google/home/platform/traits/OutputReinitialized;", "Lcom/google/home/automation/OutputReinitialized;", "fromOutputReinitializedProto", "(Lcom/google/home/platform/traits/OutputReinitialized;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Ljava/util/Map;)Lcom/google/home/automation/OutputReinitialized;", "Lcom/google/home/platform/traits/ReadOnlyAttribute;", "Lcom/google/home/automation/ReadOnlyAttribute;", "fromReadOnlyAttributeProto", "(Lcom/google/home/platform/traits/ReadOnlyAttribute;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/ReadOnlyAttribute;", "Lcom/google/home/platform/traits/SuppressionDurationOutOfRange;", "Lcom/google/home/automation/SuppressionDurationOutOfRange;", "fromSuppressionDurationOutOfRangeProto", "(Lcom/google/home/platform/traits/SuppressionDurationOutOfRange;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/SuppressionDurationOutOfRange;", "Lcom/google/home/platform/traits/UnsubscribableAttribute;", "Lcom/google/home/automation/UnsubscribableAttribute;", "fromUnsubscribableAttributeProto", "(Lcom/google/home/platform/traits/UnsubscribableAttribute;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsubscribableAttribute;", "Lcom/google/home/platform/traits/UnsupportedActionBehavior;", "Lcom/google/home/automation/UnsupportedActionBehavior;", "fromUnsupportedActionBehaviorProto", "(Lcom/google/home/platform/traits/UnsupportedActionBehavior;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedActionBehavior;", "Lcom/google/home/platform/traits/UnsupportedNodeOutput;", "Lcom/google/home/automation/UnsupportedNodeOutput;", "fromUnsupportedNodeOutputProto", "(Lcom/google/home/platform/traits/UnsupportedNodeOutput;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedNodeOutput;", "Lcom/google/home/platform/traits/UnsupportedOperator;", "Lcom/google/home/automation/UnsupportedOperator;", "fromUnsupportedOperatorProto", "(Lcom/google/home/platform/traits/UnsupportedOperator;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedOperator;", "Lcom/google/home/platform/traits/UnsupportedStarterBehavior;", "Lcom/google/home/automation/UnsupportedStarterBehavior;", "fromUnsupportedStarterBehaviorProto", "(Lcom/google/home/platform/traits/UnsupportedStarterBehavior;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedStarterBehavior;", "Lcom/google/home/platform/traits/UnsupportedStateReaderBehavior;", "Lcom/google/home/automation/UnsupportedStateReaderBehavior;", "fromUnsupportedStateReaderBehaviorProto", "(Lcom/google/home/platform/traits/UnsupportedStateReaderBehavior;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedStateReaderBehavior;", "Lcom/google/home/platform/traits/UnsupportedSubNodeType;", "Lcom/google/home/automation/UnsupportedSubNodeType;", "fromUnsupportedSubNodeTypeProto", "(Lcom/google/home/platform/traits/UnsupportedSubNodeType;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedSubNodeType;", "Lcom/google/home/platform/traits/InvalidArgumentsForOperator;", "Lcom/google/home/automation/InvalidArgumentsForOperator;", "fromInvalidArgumentsForOperatorProto", "(Lcom/google/home/platform/traits/InvalidArgumentsForOperator;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;)Lcom/google/home/automation/InvalidArgumentsForOperator;", "Lcom/google/home/platform/traits/InvalidConditionType;", "Lcom/google/home/automation/InvalidConditionType;", "fromInvalidConditionTypeProto", "(Lcom/google/home/platform/traits/InvalidConditionType;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;)Lcom/google/home/automation/InvalidConditionType;", "Lcom/google/home/platform/traits/InvalidField;", "Lcom/google/home/automation/InvalidField;", "fromInvalidFieldProto", "(Lcom/google/home/platform/traits/InvalidField;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;)Lcom/google/home/automation/InvalidField;", "Lcom/google/home/platform/traits/InvalidParameterType;", "Lcom/google/home/automation/InvalidParameterType;", "fromInvalidParameterTypeProto", "(Lcom/google/home/platform/traits/InvalidParameterType;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/InvalidParameterType;", "Lcom/google/home/platform/traits/InvalidNullParameterValue;", "Lcom/google/home/automation/InvalidNullParameterValue;", "fromInvalidNullParameterValueProto", "(Lcom/google/home/platform/traits/InvalidNullParameterValue;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/InvalidNullParameterValue;", "Lcom/google/home/platform/traits/InvalidReference;", "Lcom/google/home/automation/InvalidReference;", "fromInvalidReferenceProto", "(Lcom/google/home/platform/traits/InvalidReference;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;)Lcom/google/home/automation/InvalidReference;", "Lcom/google/home/platform/traits/InvalidEntity;", "Lcom/google/home/automation/InvalidEntity;", "fromInvalidEntityProto", "(Lcom/google/home/platform/traits/InvalidEntity;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/InvalidEntity;", "Lcom/google/home/platform/traits/BlockedAction;", "Lcom/google/home/automation/BlockedAction;", "fromBlockedActionProto", "(Lcom/google/home/platform/traits/BlockedAction;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/BlockedAction;", "Lcom/google/home/platform/traits/UnsupportedEntityCommand;", "Lcom/google/home/automation/UnsupportedEntityCommand;", "fromUnsupportedEntityCommandProto", "(Lcom/google/home/platform/traits/UnsupportedEntityCommand;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedEntityCommand;", "Lcom/google/home/platform/traits/UnsupportedEntityEvent;", "Lcom/google/home/automation/UnsupportedEntityEvent;", "fromUnsupportedEntityEventProto", "(Lcom/google/home/platform/traits/UnsupportedEntityEvent;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedEntityEvent;", "Lcom/google/home/platform/traits/UnsupportedEntityParameter;", "Lcom/google/home/automation/UnsupportedEntityParameter;", "fromUnsupportedEntityParameterProto", "(Lcom/google/home/platform/traits/UnsupportedEntityParameter;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedEntityParameter;", "Lcom/google/home/platform/traits/UnsupportedEntityParameterValue;", "Lcom/google/home/automation/UnsupportedEntityParameterValue;", "fromUnsupportedEntityParameterValueProto", "(Lcom/google/home/platform/traits/UnsupportedEntityParameterValue;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/HomeManager;)Lcom/google/home/automation/UnsupportedEntityParameterValue;", "Lcom/google/home/automation/Constraint;", "buildConstraint", "(Lcom/google/home/platform/traits/UnsupportedEntityParameterValue;Lcom/google/home/HomeManager;)Lcom/google/home/automation/Constraint;", "Lcom/google/home/platform/traits/UnsupportedEntityTrait;", "Lcom/google/home/automation/UnsupportedEntityTrait;", "fromUnsupportedEntityTraitProto", "(Lcom/google/home/platform/traits/UnsupportedEntityTrait;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedEntityTrait;", "Lcom/google/home/platform/traits/UnsupportedEntityType;", "Lcom/google/home/automation/UnsupportedEntityType;", "fromUnsupportedEntityTypeProto", "(Lcom/google/home/platform/traits/UnsupportedEntityType;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/UnsupportedEntityType;", "Lcom/google/home/platform/traits/AutomationTooLarge;", "Lcom/google/home/automation/AutomationTooLarge;", "fromAutomationTooLargeProto", "(Lcom/google/home/platform/traits/AutomationTooLarge;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/AutomationTooLarge;", "Lcom/google/home/platform/traits/TooManyNodes;", "Lcom/google/home/automation/TooManyNodes;", "fromTooManyNodesProto", "(Lcom/google/home/platform/traits/TooManyNodes;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/TooManyNodes;", "Lcom/google/home/platform/traits/TooManyOperations;", "Lcom/google/home/automation/TooManyOperations;", "fromTooManyOperationsProto", "(Lcom/google/home/platform/traits/TooManyOperations;Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)Lcom/google/home/automation/TooManyOperations;", "Lcom/google/home/platform/traits/ValueType;", "fromValueTypeProto", "(Lcom/google/home/platform/traits/ValueType;)Ljava/lang/String;", "Lcom/google/home/platform/traits/ValueType$PrimitiveType;", "toTypeString", "(Lcom/google/home/platform/traits/ValueType$PrimitiveType;)Ljava/lang/String;", "Lcom/google/home/platform/traits/ValueType$DefinitionType;", "(Lcom/google/home/platform/traits/ValueType$DefinitionType;)Ljava/lang/String;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzmo {
    /* JADX WARN: Removed duplicated region for block: B:53:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ValidationIssue zza(ValidationResult validationResult, Map map, Map map2, HomeManager homeManager) throws HomeException {
        ValidationIssueSeverity validationIssueSeverity;
        Field fieldMo449getAttributeByIdWZ4Q5Ns;
        Constraint constraintZza;
        InternalTraitFactory<T> factory;
        Map mapZza;
        EventFactory eventFactory;
        InternalTraitFactory<T> factory2;
        Map mapZzb;
        CommandDescriptor commandDescriptor;
        validationResult.getClass();
        map.getClass();
        map2.getClass();
        homeManager.getClass();
        Node node = (Node) MapsKt.getValue(map, validationResult.getNodeId());
        Expression expression = (Expression) map2.get(validationResult.getExpressionId());
        ValidationResult.Severity severity = validationResult.getSeverity();
        severity.getClass();
        severity.getClass();
        ValidationIssue.IssueTypeCase issueTypeCase = ValidationIssue.IssueTypeCase.CONDITION_DURATION_OUT_OF_RANGE;
        ValidationResult.Severity severity2 = ValidationResult.Severity.SEVERITY_UNKNOWN;
        InvalidParameter.BehaviorTypeCase behaviorTypeCase = InvalidParameter.BehaviorTypeCase.TRAIT_ID;
        MissingRequiredParameters.BehaviorTypeCase behaviorTypeCase2 = MissingRequiredParameters.BehaviorTypeCase.TRAIT_ID;
        InvalidField.FieldCase fieldCase = InvalidField.FieldCase.ID;
        InvalidParameterType.FieldCase fieldCase2 = InvalidParameterType.FieldCase.ID;
        InvalidNullParameterValue.FieldCase fieldCase3 = InvalidNullParameterValue.FieldCase.ID;
        UnsupportedEntityParameterValue.BehaviorTypeCase behaviorTypeCase3 = UnsupportedEntityParameterValue.BehaviorTypeCase.TRAIT_ID;
        ValueType.TypeCase typeCase = ValueType.TypeCase.PRIMITIVE_TYPE;
        ValueType.PrimitiveType primitiveType = ValueType.PrimitiveType.PT_UNSPECIFIED;
        ValueType.DefinitionType definitionType = ValueType.DefinitionType.DT_UNSPECIFIED;
        int iOrdinal = severity.ordinal();
        if (iOrdinal == 0) {
            validationIssueSeverity = ValidationIssueSeverity.UNKNOWN;
        } else if (iOrdinal == 1) {
            validationIssueSeverity = ValidationIssueSeverity.ERROR;
        } else if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            validationIssueSeverity = ValidationIssueSeverity.UNKNOWN;
        } else {
            validationIssueSeverity = ValidationIssueSeverity.WARNING;
        }
        switch (validationResult.getIssue().getIssueTypeCase()) {
            case CONDITION_DURATION_OUT_OF_RANGE:
                ValidationIssueSeverity validationIssueSeverity2 = validationIssueSeverity;
                ConditionDurationOutOfRange conditionDurationOutOfRange = validationResult.getIssue().getConditionDurationOutOfRange();
                conditionDurationOutOfRange.getClass();
                conditionDurationOutOfRange.getClass();
                node.getClass();
                validationIssueSeverity2.getClass();
                zzyl duration = conditionDurationOutOfRange.getDuration();
                duration.getClass();
                break;
            case DELAY_DURATION_OUT_OF_RANGE:
                ValidationIssueSeverity validationIssueSeverity3 = validationIssueSeverity;
                DelayDurationOutOfRange delayDurationOutOfRange = validationResult.getIssue().getDelayDurationOutOfRange();
                delayDurationOutOfRange.getClass();
                delayDurationOutOfRange.getClass();
                node.getClass();
                validationIssueSeverity3.getClass();
                zzyl duration2 = delayDurationOutOfRange.getDuration();
                duration2.getClass();
                break;
            case DUPLICATE_STARTER_NODE:
                DuplicateStarterNode duplicateStarterNode = validationResult.getIssue().getDuplicateStarterNode();
                duplicateStarterNode.getClass();
                break;
            case INVALID_ARGUMENT_COUNT:
                ValidationIssueSeverity validationIssueSeverity4 = validationIssueSeverity;
                InvalidArgumentCount invalidArgumentCount = validationResult.getIssue().getInvalidArgumentCount();
                invalidArgumentCount.getClass();
                invalidArgumentCount.getClass();
                node.getClass();
                validationIssueSeverity4.getClass();
                String operator = invalidArgumentCount.getOperator();
                operator.getClass();
                break;
            case INVALID_COMMAND:
                ValidationIssueSeverity validationIssueSeverity5 = validationIssueSeverity;
                InvalidCommand invalidCommand = validationResult.getIssue().getInvalidCommand();
                invalidCommand.getClass();
                invalidCommand.getClass();
                node.getClass();
                validationIssueSeverity5.getClass();
                String commandId = invalidCommand.getCommandId();
                commandId.getClass();
                String expectedBehaviorType = invalidCommand.getExpectedBehaviorType();
                expectedBehaviorType.getClass();
                break;
            case INVALID_DURATION:
                ValidationIssueSeverity validationIssueSeverity6 = validationIssueSeverity;
                InvalidDuration invalidDuration = validationResult.getIssue().getInvalidDuration();
                invalidDuration.getClass();
                invalidDuration.getClass();
                node.getClass();
                validationIssueSeverity6.getClass();
                zzyl duration3 = invalidDuration.getDuration();
                duration3.getClass();
                break;
            case INVALID_EVENT:
                ValidationIssueSeverity validationIssueSeverity7 = validationIssueSeverity;
                InvalidEvent invalidEvent = validationResult.getIssue().getInvalidEvent();
                invalidEvent.getClass();
                invalidEvent.getClass();
                node.getClass();
                validationIssueSeverity7.getClass();
                String eventId = invalidEvent.getEventId();
                eventId.getClass();
                String expectedBehaviorType2 = invalidEvent.getExpectedBehaviorType();
                expectedBehaviorType2.getClass();
                break;
            case INVALID_OPERAND:
                ValidationIssueSeverity validationIssueSeverity8 = validationIssueSeverity;
                InvalidOperand invalidOperand = validationResult.getIssue().getInvalidOperand();
                invalidOperand.getClass();
                invalidOperand.getClass();
                node.getClass();
                validationIssueSeverity8.getClass();
                String operator2 = invalidOperand.getOperator();
                operator2.getClass();
                int operandIndex = invalidOperand.getOperandIndex();
                String operandType = invalidOperand.getOperandType();
                operandType.getClass();
                List<String> validOperandTypesList = invalidOperand.getValidOperandTypesList();
                validOperandTypesList.getClass();
                break;
            case INVALID_PARAMETER:
                InvalidParameter invalidParameter = validationResult.getIssue().getInvalidParameter();
                invalidParameter.getClass();
                invalidParameter.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                int iOrdinal2 = invalidParameter.getBehaviorTypeCase().ordinal();
                if (iOrdinal2 == 0) {
                    String parameterName = invalidParameter.getParameterName();
                    parameterName.getClass();
                } else if (iOrdinal2 == 1) {
                    String parameterName2 = invalidParameter.getParameterName();
                    parameterName2.getClass();
                } else if (iOrdinal2 == 2) {
                    String parameterName3 = invalidParameter.getParameterName();
                    parameterName3.getClass();
                } else if (iOrdinal2 == 3) {
                    String parameterName4 = invalidParameter.getParameterName();
                    parameterName4.getClass();
                } else {
                    Home$$ExternalSyntheticBUOutline0.m();
                }
                break;
            case INVALID_TRAIT:
                InvalidTrait invalidTrait = validationResult.getIssue().getInvalidTrait();
                invalidTrait.getClass();
                invalidTrait.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String traitId = invalidTrait.getTraitId();
                traitId.getClass();
                String expectedBehaviorType3 = invalidTrait.getExpectedBehaviorType();
                expectedBehaviorType3.getClass();
                break;
            case INVALID_VALUE:
                InvalidValue invalidValue = validationResult.getIssue().getInvalidValue();
                invalidValue.getClass();
                invalidValue.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                homeManager.getClass();
                zzkg zzkgVar = zzkt.zza;
                Value value = invalidValue.getValue();
                value.getClass();
                break;
            case MISPLACED_SELECT_FLOW:
                MisplacedSelectFlow misplacedSelectFlow = validationResult.getIssue().getMisplacedSelectFlow();
                misplacedSelectFlow.getClass();
                misplacedSelectFlow.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                break;
            case MISPLACED_STARTER_NODE:
                MisplacedStarterNode misplacedStarterNode = validationResult.getIssue().getMisplacedStarterNode();
                misplacedStarterNode.getClass();
                misplacedStarterNode.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                break;
            case MISSING_REQUIRED_FIELDS:
                MissingRequiredFields missingRequiredFields = validationResult.getIssue().getMissingRequiredFields();
                missingRequiredFields.getClass();
                missingRequiredFields.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                List<String> fieldNamesList = missingRequiredFields.getFieldNamesList();
                fieldNamesList.getClass();
                break;
            case MISSING_REQUIRED_PARAMETERS:
                MissingRequiredParameters missingRequiredParameters = validationResult.getIssue().getMissingRequiredParameters();
                missingRequiredParameters.getClass();
                missingRequiredParameters.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                int iOrdinal3 = missingRequiredParameters.getBehaviorTypeCase().ordinal();
                if (iOrdinal3 == 0) {
                    List<String> parameterNamesList = missingRequiredParameters.getParameterNamesList();
                    parameterNamesList.getClass();
                } else if (iOrdinal3 == 1) {
                    List<String> parameterNamesList2 = missingRequiredParameters.getParameterNamesList();
                    parameterNamesList2.getClass();
                } else if (iOrdinal3 == 2) {
                    List<String> parameterNamesList3 = missingRequiredParameters.getParameterNamesList();
                    parameterNamesList3.getClass();
                } else if (iOrdinal3 == 3) {
                    List<String> parameterNamesList4 = missingRequiredParameters.getParameterNamesList();
                    parameterNamesList4.getClass();
                } else {
                    Home$$ExternalSyntheticBUOutline0.m();
                }
                break;
            case MISSING_STARTER_NODE:
                MissingStarterNode missingStarterNode = validationResult.getIssue().getMissingStarterNode();
                missingStarterNode.getClass();
                missingStarterNode.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                break;
            case MISSING_TRAILING_ACTION_NODE:
                break;
            case MULTIPLE_MANUAL_STARTERS:
                MultipleManualStarters multipleManualStarters = validationResult.getIssue().getMultipleManualStarters();
                multipleManualStarters.getClass();
                multipleManualStarters.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                break;
            case MULTIPLE_SELECT_FLOWS:
                break;
            case OUTPUT_NOT_ACCESSIBLE:
                OutputNotAccessible outputNotAccessible = validationResult.getIssue().getOutputNotAccessible();
                outputNotAccessible.getClass();
                outputNotAccessible.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String output = outputNotAccessible.getOutput();
                output.getClass();
                break;
            case OUTPUT_REINITIALIZED:
                OutputReinitialized outputReinitialized = validationResult.getIssue().getOutputReinitialized();
                outputReinitialized.getClass();
                break;
            case OUTPUT_TYPE_MISMATCH:
                OutputTypeMismatch outputTypeMismatch = validationResult.getIssue().getOutputTypeMismatch();
                outputTypeMismatch.getClass();
                break;
            case READ_ONLY_ATTRIBUTE:
                ReadOnlyAttribute readOnlyAttribute = validationResult.getIssue().getReadOnlyAttribute();
                readOnlyAttribute.getClass();
                readOnlyAttribute.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String traitId2 = readOnlyAttribute.getTraitId();
                traitId2.getClass();
                String attributeName = readOnlyAttribute.getAttributeName();
                attributeName.getClass();
                break;
            case SUPPRESSION_DURATION_OUT_OF_RANGE:
                SuppressionDurationOutOfRange suppressionDurationOutOfRange = validationResult.getIssue().getSuppressionDurationOutOfRange();
                suppressionDurationOutOfRange.getClass();
                suppressionDurationOutOfRange.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                zzyl duration4 = suppressionDurationOutOfRange.getDuration();
                duration4.getClass();
                break;
            case UNSUBSCRIBABLE_ATTRIBUTE:
                UnsubscribableAttribute unsubscribableAttribute = validationResult.getIssue().getUnsubscribableAttribute();
                unsubscribableAttribute.getClass();
                unsubscribableAttribute.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String traitId3 = unsubscribableAttribute.getTraitId();
                traitId3.getClass();
                String attributeName2 = unsubscribableAttribute.getAttributeName();
                attributeName2.getClass();
                break;
            case UNSUPPORTED_ACTION_BEHAVIOR:
                UnsupportedActionBehavior unsupportedActionBehavior = validationResult.getIssue().getUnsupportedActionBehavior();
                unsupportedActionBehavior.getClass();
                unsupportedActionBehavior.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String behaviorType = unsupportedActionBehavior.getBehaviorType();
                behaviorType.getClass();
                break;
            case UNSUPPORTED_NODE_OUTPUT:
                UnsupportedNodeOutput unsupportedNodeOutput = validationResult.getIssue().getUnsupportedNodeOutput();
                unsupportedNodeOutput.getClass();
                unsupportedNodeOutput.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String nodeType = unsupportedNodeOutput.getNodeType();
                nodeType.getClass();
                break;
            case UNSUPPORTED_OPERATOR:
                UnsupportedOperator unsupportedOperator = validationResult.getIssue().getUnsupportedOperator();
                unsupportedOperator.getClass();
                unsupportedOperator.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                break;
            case UNSUPPORTED_STARTER_BEHAVIOR:
                UnsupportedStarterBehavior unsupportedStarterBehavior = validationResult.getIssue().getUnsupportedStarterBehavior();
                unsupportedStarterBehavior.getClass();
                unsupportedStarterBehavior.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String behaviorType2 = unsupportedStarterBehavior.getBehaviorType();
                behaviorType2.getClass();
                break;
            case UNSUPPORTED_STATE_READER_BEHAVIOR:
                UnsupportedStateReaderBehavior unsupportedStateReaderBehavior = validationResult.getIssue().getUnsupportedStateReaderBehavior();
                unsupportedStateReaderBehavior.getClass();
                unsupportedStateReaderBehavior.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String behaviorType3 = unsupportedStateReaderBehavior.getBehaviorType();
                behaviorType3.getClass();
                break;
            case UNSUPPORTED_SUB_NODE_TYPE:
                UnsupportedSubNodeType unsupportedSubNodeType = validationResult.getIssue().getUnsupportedSubNodeType();
                unsupportedSubNodeType.getClass();
                unsupportedSubNodeType.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String parentNodeType = unsupportedSubNodeType.getParentNodeType();
                parentNodeType.getClass();
                String subNodeType = unsupportedSubNodeType.getSubNodeType();
                subNodeType.getClass();
                break;
            case INVALID_ARGUMENTS_FOR_OPERATOR:
                InvalidArgumentsForOperator invalidArgumentsForOperator = validationResult.getIssue().getInvalidArgumentsForOperator();
                invalidArgumentsForOperator.getClass();
                break;
            case INVALID_CONDITION_TYPE:
                ValidationIssueSeverity validationIssueSeverity9 = validationIssueSeverity;
                InvalidConditionType invalidConditionType = validationResult.getIssue().getInvalidConditionType();
                invalidConditionType.getClass();
                invalidConditionType.getClass();
                node.getClass();
                validationIssueSeverity9.getClass();
                ValueType expected = invalidConditionType.getExpected();
                expected.getClass();
                String strZzh = zzh(expected);
                ValueType actual = invalidConditionType.getActual();
                actual.getClass();
                break;
            case INVALID_FIELD:
                InvalidField invalidField = validationResult.getIssue().getInvalidField();
                invalidField.getClass();
                invalidField.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                int iOrdinal4 = invalidField.getFieldCase().ordinal();
                if (iOrdinal4 != 0) {
                    if (iOrdinal4 != 1) {
                        if (iOrdinal4 != 2) {
                            Home$$ExternalSyntheticBUOutline0.m();
                        }
                    }
                }
                break;
            case INVALID_NULL_PARAMETER_VALUE:
                InvalidNullParameterValue invalidNullParameterValue = validationResult.getIssue().getInvalidNullParameterValue();
                invalidNullParameterValue.getClass();
                invalidNullParameterValue.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                int iOrdinal5 = invalidNullParameterValue.getFieldCase().ordinal();
                if (iOrdinal5 == 0) {
                    Integer numValueOf = Integer.valueOf(invalidNullParameterValue.getId());
                    ValueType expected2 = invalidNullParameterValue.getExpected();
                    expected2.getClass();
                } else if (iOrdinal5 == 1) {
                    String name = invalidNullParameterValue.getName();
                    ValueType expected3 = invalidNullParameterValue.getExpected();
                    expected3.getClass();
                } else if (iOrdinal5 == 2) {
                    ValueType expected4 = invalidNullParameterValue.getExpected();
                    expected4.getClass();
                } else {
                    Home$$ExternalSyntheticBUOutline0.m();
                }
                break;
            case INVALID_PARAMETER_TYPE:
                InvalidParameterType invalidParameterType = validationResult.getIssue().getInvalidParameterType();
                invalidParameterType.getClass();
                invalidParameterType.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                int iOrdinal6 = invalidParameterType.getFieldCase().ordinal();
                if (iOrdinal6 == 0) {
                    Integer numValueOf2 = Integer.valueOf(invalidParameterType.getId());
                    ValueType expected5 = invalidParameterType.getExpected();
                    expected5.getClass();
                    String strZzh2 = zzh(expected5);
                    ValueType actual2 = invalidParameterType.getActual();
                    actual2.getClass();
                } else if (iOrdinal6 == 1) {
                    String name2 = invalidParameterType.getName();
                    ValueType expected6 = invalidParameterType.getExpected();
                    expected6.getClass();
                    String strZzh3 = zzh(expected6);
                    ValueType actual3 = invalidParameterType.getActual();
                    actual3.getClass();
                } else if (iOrdinal6 == 2) {
                    ValueType expected7 = invalidParameterType.getExpected();
                    expected7.getClass();
                    String strZzh4 = zzh(expected7);
                    ValueType actual4 = invalidParameterType.getActual();
                    actual4.getClass();
                } else {
                    Home$$ExternalSyntheticBUOutline0.m();
                }
                break;
            case INVALID_REFERENCE:
                InvalidReference invalidReference = validationResult.getIssue().getInvalidReference();
                invalidReference.getClass();
                invalidReference.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String reference = invalidReference.getReference();
                reference.getClass();
                break;
            case INVALID_ENTITY:
                InvalidEntity invalidEntity = validationResult.getIssue().getInvalidEntity();
                invalidEntity.getClass();
                invalidEntity.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                String entityObjectId = invalidEntity.getEntityObjectId();
                entityObjectId.getClass();
                Id.m441constructorimpl(entityObjectId);
                UnknownEntity unknownEntity = new UnknownEntity(entityObjectId, null, 2, null);
                String entityType = invalidEntity.getEntityType();
                entityType.getClass();
                break;
            case UNSUPPORTED_ENTITY_COMMAND:
                ValidationIssueSeverity validationIssueSeverity10 = validationIssueSeverity;
                UnsupportedEntityCommand unsupportedEntityCommand = validationResult.getIssue().getUnsupportedEntityCommand();
                unsupportedEntityCommand.getClass();
                unsupportedEntityCommand.getClass();
                node.getClass();
                validationIssueSeverity10.getClass();
                String commandId2 = unsupportedEntityCommand.getCommandId();
                commandId2.getClass();
                String entityObjectId2 = unsupportedEntityCommand.getEntityObjectId();
                entityObjectId2.getClass();
                String entityType2 = unsupportedEntityCommand.getEntityType();
                entityType2.getClass();
                List<UnsupportedCandidateReason> unsupportedReasonsList = unsupportedEntityCommand.getUnsupportedReasonsList();
                unsupportedReasonsList.getClass();
                ArrayList arrayList = new ArrayList();
                for (UnsupportedCandidateReason unsupportedCandidateReason : unsupportedReasonsList) {
                    unsupportedCandidateReason.getClass();
                    com.google.home.automation.UnsupportedCandidateReason unsupportedCandidateReasonZzb = zzkd.zzb(unsupportedCandidateReason);
                    if (unsupportedCandidateReasonZzb != null) {
                        arrayList.add(unsupportedCandidateReasonZzb);
                    }
                }
                break;
            case UNSUPPORTED_ENTITY_EVENT:
                ValidationIssueSeverity validationIssueSeverity11 = validationIssueSeverity;
                UnsupportedEntityEvent unsupportedEntityEvent = validationResult.getIssue().getUnsupportedEntityEvent();
                unsupportedEntityEvent.getClass();
                unsupportedEntityEvent.getClass();
                node.getClass();
                validationIssueSeverity11.getClass();
                String eventId2 = unsupportedEntityEvent.getEventId();
                eventId2.getClass();
                String entityObjectId3 = unsupportedEntityEvent.getEntityObjectId();
                entityObjectId3.getClass();
                String entityType3 = unsupportedEntityEvent.getEntityType();
                entityType3.getClass();
                List<UnsupportedCandidateReason> unsupportedReasonsList2 = unsupportedEntityEvent.getUnsupportedReasonsList();
                unsupportedReasonsList2.getClass();
                ArrayList arrayList2 = new ArrayList();
                for (UnsupportedCandidateReason unsupportedCandidateReason2 : unsupportedReasonsList2) {
                    unsupportedCandidateReason2.getClass();
                    com.google.home.automation.UnsupportedCandidateReason unsupportedCandidateReasonZzb2 = zzkd.zzb(unsupportedCandidateReason2);
                    if (unsupportedCandidateReasonZzb2 != null) {
                        arrayList2.add(unsupportedCandidateReasonZzb2);
                    }
                }
                break;
            case UNSUPPORTED_ENTITY_PARAMETER:
                ValidationIssueSeverity validationIssueSeverity12 = validationIssueSeverity;
                UnsupportedEntityParameter unsupportedEntityParameter = validationResult.getIssue().getUnsupportedEntityParameter();
                unsupportedEntityParameter.getClass();
                unsupportedEntityParameter.getClass();
                node.getClass();
                validationIssueSeverity12.getClass();
                String parameterName5 = unsupportedEntityParameter.getParameterName();
                parameterName5.getClass();
                int fieldId = unsupportedEntityParameter.getFieldId();
                String commandId3 = unsupportedEntityParameter.getCommandId();
                String str = commandId3.length() == 0 ? null : commandId3;
                String eventId3 = unsupportedEntityParameter.getEventId();
                String str2 = eventId3.length() == 0 ? null : eventId3;
                String traitId4 = unsupportedEntityParameter.getTraitId();
                String str3 = traitId4.length() == 0 ? null : traitId4;
                String entityObjectId4 = unsupportedEntityParameter.getEntityObjectId();
                entityObjectId4.getClass();
                String entityType4 = unsupportedEntityParameter.getEntityType();
                entityType4.getClass();
                break;
            case UNSUPPORTED_ENTITY_PARAMETER_VALUE:
                UnsupportedEntityParameterValue unsupportedEntityParameterValue = validationResult.getIssue().getUnsupportedEntityParameterValue();
                unsupportedEntityParameterValue.getClass();
                unsupportedEntityParameterValue.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                homeManager.getClass();
                String parameterName6 = unsupportedEntityParameterValue.getParameterName();
                parameterName6.getClass();
                int fieldId2 = unsupportedEntityParameterValue.getFieldId();
                String commandId4 = unsupportedEntityParameterValue.getCommandId();
                if (commandId4.length() == 0) {
                    commandId4 = null;
                }
                String eventId4 = unsupportedEntityParameterValue.getEventId();
                if (eventId4.length() == 0) {
                    eventId4 = null;
                }
                String traitId5 = unsupportedEntityParameterValue.getTraitId();
                if (traitId5.length() == 0) {
                    traitId5 = null;
                }
                String entityObjectId5 = unsupportedEntityParameterValue.getEntityObjectId();
                entityObjectId5.getClass();
                String entityType5 = unsupportedEntityParameterValue.getEntityType();
                if (entityType5.length() == 0) {
                    entityType5 = null;
                }
                zzkg zzkgVar2 = zzkt.zza;
                Value value2 = unsupportedEntityParameterValue.getValue();
                value2.getClass();
                Object objZzr = zzkg.zzr(value2, homeManager);
                homeManager.getClass();
                FactoryRegistry factoryRegistry = ((zzpu) homeManager).getZzb().getFactoryRegistry();
                int iOrdinal7 = unsupportedEntityParameterValue.getBehaviorTypeCase().ordinal();
                if (iOrdinal7 == 0) {
                    String traitId6 = unsupportedEntityParameterValue.getTraitId();
                    traitId6.getClass();
                    TraitFactory<? extends Trait> traitOrNull = factoryRegistry.getTraitOrNull(traitId6);
                    if (traitOrNull != null) {
                        fieldMo449getAttributeByIdWZ4Q5Ns = traitOrNull.mo449getAttributeByIdWZ4Q5Ns(UInt.m2389constructorimpl(unsupportedEntityParameterValue.getFieldId()));
                    }
                } else if (iOrdinal7 == 1) {
                    String eventId5 = unsupportedEntityParameterValue.getEventId();
                    eventId5.getClass();
                    TraitFactory<? extends Trait> traitOrNull2 = factoryRegistry.getTraitOrNull(eventId5);
                    if (traitOrNull2 != null && (factory = traitOrNull2.getFactory()) != 0 && (mapZza = zzop.zza(factory)) != null && (eventFactory = (EventFactory) mapZza.get(unsupportedEntityParameterValue.getEventId())) != null) {
                        fieldMo449getAttributeByIdWZ4Q5Ns = eventFactory.m437getEventFieldByIdWZ4Q5Ns(UInt.m2389constructorimpl(unsupportedEntityParameterValue.getFieldId()));
                    }
                } else if (iOrdinal7 != 2) {
                    fieldMo449getAttributeByIdWZ4Q5Ns = null;
                } else {
                    String commandId5 = unsupportedEntityParameterValue.getCommandId();
                    commandId5.getClass();
                    TraitFactory<? extends Trait> traitOrNull3 = factoryRegistry.getTraitOrNull(commandId5);
                    if (traitOrNull3 != null && (factory2 = traitOrNull3.getFactory()) != 0 && (mapZzb = zzop.zzb(factory2)) != null && (commandDescriptor = (CommandDescriptor) mapZzb.get(unsupportedEntityParameterValue.getCommandId())) != null) {
                        fieldMo449getAttributeByIdWZ4Q5Ns = commandDescriptor.mo436getCommandRequestFieldByIdWZ4Q5Ns(UInt.m2389constructorimpl(unsupportedEntityParameterValue.getFieldId()));
                    }
                }
                if (fieldMo449getAttributeByIdWZ4Q5Ns == null) {
                    constraintZza = null;
                } else {
                    zzkd zzkdVar = zzkf.zza;
                    ValueTypeConstraint valueConstraint = unsupportedEntityParameterValue.getValueConstraint();
                    valueConstraint.getClass();
                    constraintZza = zzkdVar.zza(valueConstraint, homeManager, fieldMo449getAttributeByIdWZ4Q5Ns);
                }
                break;
            case UNSUPPORTED_ENTITY_TRAIT:
                ValidationIssueSeverity validationIssueSeverity13 = validationIssueSeverity;
                UnsupportedEntityTrait unsupportedEntityTrait = validationResult.getIssue().getUnsupportedEntityTrait();
                unsupportedEntityTrait.getClass();
                unsupportedEntityTrait.getClass();
                node.getClass();
                validationIssueSeverity13.getClass();
                String traitId7 = unsupportedEntityTrait.getTraitId();
                traitId7.getClass();
                String entityObjectId6 = unsupportedEntityTrait.getEntityObjectId();
                entityObjectId6.getClass();
                String entityType6 = unsupportedEntityTrait.getEntityType();
                entityType6.getClass();
                List<UnsupportedCandidateReason> unsupportedReasonsList3 = unsupportedEntityTrait.getUnsupportedReasonsList();
                unsupportedReasonsList3.getClass();
                ArrayList arrayList3 = new ArrayList();
                for (UnsupportedCandidateReason unsupportedCandidateReason3 : unsupportedReasonsList3) {
                    unsupportedCandidateReason3.getClass();
                    com.google.home.automation.UnsupportedCandidateReason unsupportedCandidateReasonZzb3 = zzkd.zzb(unsupportedCandidateReason3);
                    if (unsupportedCandidateReasonZzb3 != null) {
                        arrayList3.add(unsupportedCandidateReasonZzb3);
                    }
                }
                break;
            case UNSUPPORTED_ENTITY_TYPE:
                ValidationIssueSeverity validationIssueSeverity14 = validationIssueSeverity;
                UnsupportedEntityType unsupportedEntityType = validationResult.getIssue().getUnsupportedEntityType();
                unsupportedEntityType.getClass();
                unsupportedEntityType.getClass();
                node.getClass();
                validationIssueSeverity14.getClass();
                String entityType7 = unsupportedEntityType.getEntityType();
                entityType7.getClass();
                String entityObjectId7 = unsupportedEntityType.getEntityObjectId();
                entityObjectId7.getClass();
                List<String> supportedTypesList = unsupportedEntityType.getSupportedTypesList();
                supportedTypesList.getClass();
                break;
            case BLOCKED_ACTION:
                ValidationIssueSeverity validationIssueSeverity15 = validationIssueSeverity;
                BlockedAction blockedAction = validationResult.getIssue().getBlockedAction();
                blockedAction.getClass();
                blockedAction.getClass();
                node.getClass();
                validationIssueSeverity15.getClass();
                String entityType8 = blockedAction.getEntityType();
                entityType8.getClass();
                String actionType = blockedAction.getActionType();
                actionType.getClass();
                break;
            case AUTOMATION_TOO_LARGE:
                AutomationTooLarge automationTooLarge = validationResult.getIssue().getAutomationTooLarge();
                automationTooLarge.getClass();
                automationTooLarge.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                break;
            case TOO_MANY_NODES:
                TooManyNodes tooManyNodes = validationResult.getIssue().getTooManyNodes();
                tooManyNodes.getClass();
                tooManyNodes.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                break;
            case TOO_MANY_OPERATIONS:
                TooManyOperations tooManyOperations = validationResult.getIssue().getTooManyOperations();
                tooManyOperations.getClass();
                tooManyOperations.getClass();
                node.getClass();
                validationIssueSeverity.getClass();
                break;
            case ISSUETYPE_NOT_SET:
                break;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                break;
        }
        return null;
    }

    public static final UnknownIssue zzb(ValidationResult validationResult, Node node, ValidationIssueSeverity validationIssueSeverity, ValidationIssueType validationIssueType) {
        String issueType;
        validationResult.getClass();
        node.getClass();
        validationIssueSeverity.getClass();
        validationIssueType.getClass();
        ValidationIssue.IssueTypeCase issueTypeCase = validationResult.getIssue().getIssueTypeCase();
        ValidationIssue.IssueTypeCase issueTypeCase2 = ValidationIssue.IssueTypeCase.CONDITION_DURATION_OUT_OF_RANGE;
        ValidationResult.Severity severity = ValidationResult.Severity.SEVERITY_UNKNOWN;
        InvalidParameter.BehaviorTypeCase behaviorTypeCase = InvalidParameter.BehaviorTypeCase.TRAIT_ID;
        MissingRequiredParameters.BehaviorTypeCase behaviorTypeCase2 = MissingRequiredParameters.BehaviorTypeCase.TRAIT_ID;
        InvalidField.FieldCase fieldCase = InvalidField.FieldCase.ID;
        InvalidParameterType.FieldCase fieldCase2 = InvalidParameterType.FieldCase.ID;
        InvalidNullParameterValue.FieldCase fieldCase3 = InvalidNullParameterValue.FieldCase.ID;
        UnsupportedEntityParameterValue.BehaviorTypeCase behaviorTypeCase3 = UnsupportedEntityParameterValue.BehaviorTypeCase.TRAIT_ID;
        ValueType.TypeCase typeCase = ValueType.TypeCase.PRIMITIVE_TYPE;
        ValueType.PrimitiveType primitiveType = ValueType.PrimitiveType.PT_UNSPECIFIED;
        ValueType.DefinitionType definitionType = ValueType.DefinitionType.DT_UNSPECIFIED;
        if (issueTypeCase.ordinal() != 48) {
            String string = validationResult.getIssue().toString();
            string.getClass();
            issueType = StringsKt.replace$default(string, "\n", " ");
        } else {
            issueType = validationResult.getIssueType();
        }
        issueType.getClass();
        return new UnknownIssue(node, validationIssueSeverity, validationIssueType, issueType);
    }

    public static final com.google.home.automation.DuplicateStarterNode zzc(DuplicateStarterNode duplicateStarterNode, Node node, ValidationIssueSeverity validationIssueSeverity, Map map) {
        duplicateStarterNode.getClass();
        node.getClass();
        validationIssueSeverity.getClass();
        map.getClass();
        List<String> existingStarterNodeIdsList = duplicateStarterNode.getExistingStarterNodeIdsList();
        existingStarterNodeIdsList.getClass();
        List<String> list = existingStarterNodeIdsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = map.get((String) it.next());
            obj.getClass();
            arrayList.add((Node) obj);
        }
        return new com.google.home.automation.DuplicateStarterNode(node, validationIssueSeverity, arrayList);
    }

    public static final Duration zzd(zzyl zzylVar) {
        zzylVar.getClass();
        Duration durationOfSeconds = Duration.ofSeconds(zzylVar.zza(), zzylVar.zzb());
        durationOfSeconds.getClass();
        return durationOfSeconds;
    }

    public static final com.google.home.automation.OutputTypeMismatch zze(OutputTypeMismatch outputTypeMismatch, Node node, ValidationIssueSeverity validationIssueSeverity, Map map) {
        outputTypeMismatch.getClass();
        node.getClass();
        validationIssueSeverity.getClass();
        map.getClass();
        String output = outputTypeMismatch.getOutput();
        output.getClass();
        List<String> otherNodeIdsList = outputTypeMismatch.getOtherNodeIdsList();
        otherNodeIdsList.getClass();
        List<String> list = otherNodeIdsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = map.get((String) it.next());
            obj.getClass();
            arrayList.add((Node) obj);
        }
        return new com.google.home.automation.OutputTypeMismatch(node, validationIssueSeverity, output, arrayList);
    }

    public static final com.google.home.automation.OutputReinitialized zzf(OutputReinitialized outputReinitialized, Node node, ValidationIssueSeverity validationIssueSeverity, Map map) {
        outputReinitialized.getClass();
        node.getClass();
        validationIssueSeverity.getClass();
        map.getClass();
        String output = outputReinitialized.getOutput();
        output.getClass();
        List<String> otherNodeIdsList = outputReinitialized.getOtherNodeIdsList();
        otherNodeIdsList.getClass();
        List<String> list = otherNodeIdsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = map.get((String) it.next());
            obj.getClass();
            arrayList.add((Node) obj);
        }
        return new com.google.home.automation.OutputReinitialized(node, validationIssueSeverity, output, arrayList);
    }

    public static final com.google.home.automation.InvalidArgumentsForOperator zzg(InvalidArgumentsForOperator invalidArgumentsForOperator, Node node, ValidationIssueSeverity validationIssueSeverity, Expression expression) {
        invalidArgumentsForOperator.getClass();
        node.getClass();
        validationIssueSeverity.getClass();
        String op = invalidArgumentsForOperator.getOp();
        op.getClass();
        List<ValueType> parametersList = invalidArgumentsForOperator.getActual().getParametersList();
        parametersList.getClass();
        List<ValueType> list = parametersList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ValueType valueType : list) {
            valueType.getClass();
            arrayList.add(zzh(valueType));
        }
        List<InvalidArgumentsForOperator.ArgumentTypes> candidatesList = invalidArgumentsForOperator.getCandidatesList();
        candidatesList.getClass();
        List<InvalidArgumentsForOperator.ArgumentTypes> list2 = candidatesList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            List<ValueType> parametersList2 = ((InvalidArgumentsForOperator.ArgumentTypes) it.next()).getParametersList();
            parametersList2.getClass();
            List<ValueType> list3 = parametersList2;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (ValueType valueType2 : list3) {
                valueType2.getClass();
                arrayList3.add(zzh(valueType2));
            }
            arrayList2.add(arrayList3);
        }
        return new com.google.home.automation.InvalidArgumentsForOperator(node, validationIssueSeverity, expression, op, arrayList, arrayList2);
    }

    public static final String zzh(ValueType valueType) {
        valueType.getClass();
        ValueType.TypeCase typeCase = valueType.getTypeCase();
        ValidationIssue.IssueTypeCase issueTypeCase = ValidationIssue.IssueTypeCase.CONDITION_DURATION_OUT_OF_RANGE;
        ValidationResult.Severity severity = ValidationResult.Severity.SEVERITY_UNKNOWN;
        InvalidParameter.BehaviorTypeCase behaviorTypeCase = InvalidParameter.BehaviorTypeCase.TRAIT_ID;
        MissingRequiredParameters.BehaviorTypeCase behaviorTypeCase2 = MissingRequiredParameters.BehaviorTypeCase.TRAIT_ID;
        InvalidField.FieldCase fieldCase = InvalidField.FieldCase.ID;
        InvalidParameterType.FieldCase fieldCase2 = InvalidParameterType.FieldCase.ID;
        InvalidNullParameterValue.FieldCase fieldCase3 = InvalidNullParameterValue.FieldCase.ID;
        UnsupportedEntityParameterValue.BehaviorTypeCase behaviorTypeCase3 = UnsupportedEntityParameterValue.BehaviorTypeCase.TRAIT_ID;
        ValueType.TypeCase typeCase2 = ValueType.TypeCase.PRIMITIVE_TYPE;
        ValueType.PrimitiveType primitiveType = ValueType.PrimitiveType.PT_UNSPECIFIED;
        ValueType.DefinitionType definitionType = ValueType.DefinitionType.DT_UNSPECIFIED;
        switch (typeCase) {
            case PRIMITIVE_TYPE:
                ValueType.PrimitiveType primitiveType2 = valueType.getPrimitiveType();
                primitiveType2.getClass();
                primitiveType2.getClass();
                switch (primitiveType2) {
                    case PT_UNSPECIFIED:
                    case UNRECOGNIZED:
                        return "UnknownType";
                    case PT_INT:
                        return "Int";
                    case PT_UINT:
                        return "UInt";
                    case PT_DOUBLE:
                        return "Double";
                    case PT_STRING:
                        return "String";
                    case PT_BOOL:
                        return "Boolean";
                    case PT_BYTES:
                        return "ByteArray";
                    default:
                        Home$$ExternalSyntheticBUOutline0.m();
                        return null;
                }
            case DEFINITION_TYPE:
                ValueType.DefinitionType definitionType2 = valueType.getDefinitionType();
                definitionType2.getClass();
                definitionType2.getClass();
                int iOrdinal = definitionType2.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        return "DeviceTypeFactory<*>";
                    }
                    if (iOrdinal != 2) {
                        Home$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                }
                return "UnknownType";
            case STRUCT_TYPE:
                String structType = valueType.getStructType();
                return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(structType).length() + 8), "Struct<", structType, ">");
            case ENUM_TYPE:
                String enumType = valueType.getEnumType();
                StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(6, enumType));
                sb.append("Enum<");
                sb.append(enumType);
                sb.append(">");
                return sb.toString();
            case LIST_TYPE:
                ValueType elementType = valueType.getListType().getElementType();
                elementType.getClass();
                String strZzh = zzh(elementType);
                StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(6, strZzh));
                sb2.append("List<");
                sb2.append(strZzh);
                sb2.append(">");
                return sb2.toString();
            case MAP_TYPE:
                ValueType keyType = valueType.getMapType().getKeyType();
                keyType.getClass();
                String strZzh2 = zzh(keyType);
                ValueType valueType2 = valueType.getMapType().getValueType();
                valueType2.getClass();
                String strZzh3 = zzh(valueType2);
                StringBuilder sb3 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(6, strZzh2), strZzh3) + 1);
                FileInsert$$ExternalSyntheticOutline0.m(sb3, "Map<", strZzh2, ", ", strZzh3);
                sb3.append(">");
                return sb3.toString();
            case ENTITY_TYPE:
                String entityType = valueType.getEntityType();
                entityType.getClass();
                return entityType;
            case WILDCARD_TYPE:
                String wildcardType = valueType.getWildcardType();
                wildcardType.getClass();
                return wildcardType;
            case TYPE_NOT_SET:
                return "UnknownType";
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
        }
    }
}
