package org.eclipse.californium.scandium.config;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.AppFunctionException;
import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.Utility;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.net.InetSocketAddress;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Asn1DerDecoder;
import org.eclipse.californium.elements.util.CertPathUtil;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.ConnectionListener;
import org.eclipse.californium.scandium.DtlsHealth;
import org.eclipse.californium.scandium.auth.ApplicationLevelInfoSupplier;
import org.eclipse.californium.scandium.dtls.CertificateType;
import org.eclipse.californium.scandium.dtls.ConnectionIdGenerator;
import org.eclipse.californium.scandium.dtls.ProtocolVersion;
import org.eclipse.californium.scandium.dtls.SignatureAndHashAlgorithm;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuiteSelector;
import org.eclipse.californium.scandium.dtls.cipher.DefaultCipherSuiteSelector;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;
import org.eclipse.californium.scandium.dtls.pskstore.AdvancedInMemoryPskStore;
import org.eclipse.californium.scandium.dtls.pskstore.AdvancedPskStore;
import org.eclipse.californium.scandium.dtls.pskstore.PskStore;
import org.eclipse.californium.scandium.dtls.rpkstore.TrustedRpkStore;
import org.eclipse.californium.scandium.dtls.x509.BridgeCertificateVerifier;
import org.eclipse.californium.scandium.dtls.x509.CertificateVerifier;
import org.eclipse.californium.scandium.dtls.x509.NewAdvancedCertificateVerifier;
import org.eclipse.californium.scandium.util.ListUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class DtlsConnectorConfig {
    private static final int DEFAULT_EXECUTOR_THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 6;
    private static final int DEFAULT_RECEIVER_THREADS = (Runtime.getRuntime().availableProcessors() + 1) / 2;
    private InetSocketAddress address;
    private NewAdvancedCertificateVerifier advancedCertificateVerifier;
    private AdvancedPskStore advancedPskStore;
    private Long autoResumptionTimeoutMillis;
    private Integer backOffRetransmission;
    private List<X509Certificate> certChain;

    @Deprecated
    private CertificateVerifier certificateVerifier;
    private CipherSuiteSelector cipherSuiteSelector;
    private Boolean clientAuthenticationRequired;
    private Boolean clientAuthenticationWanted;
    private Boolean clientOnly;
    private ConnectionIdGenerator connectionIdGenerator;
    private Integer connectionThreadCount;
    private String defaultHandshakeMode;
    private Boolean earlyStopRetransmission;
    private Boolean enableMultiHandshakeMessageRecords;
    private Boolean enableMultiRecordMessages;
    private Boolean enableReuseAddress;
    private DtlsHealth healthHandler;
    private Integer healthStatusInterval;
    private List<CertificateType> identityCertificateTypes;
    private String loggingTag;
    private Integer maxConnections;
    private Integer maxDeferredProcessedIncomingRecordsSize;
    private Integer maxDeferredProcessedOutgoingApplicationDataMessages;
    private Integer maxFragmentLengthCode;
    private Integer maxFragmentedHandshakeMessageLength;
    private Integer maxRetransmissions;
    private Integer maxTransmissionUnit;
    private Integer maxTransmissionUnitLimit;
    private Integer outboundMessageBufferSize;
    private List<CipherSuite> preselectedCipherSuites;
    private PrivateKey privateKey;
    private ProtocolVersion protocolVersionForHelloVerifyRequests;

    @Deprecated
    private PskStore pskStore;
    private PublicKey publicKey;
    private Integer receiverThreadCount;
    private Boolean recommendedCipherSuitesOnly;
    private Boolean recommendedSupportedGroupsOnly;
    private Integer recordSizeLimit;
    private Integer retransmissionTimeout;
    private Boolean serverOnly;
    private Boolean sniEnabled;
    private Integer socketReceiveBufferSize;
    private Integer socketSendBufferSize;
    private Long staleConnectionThreshold;
    private List<CipherSuite> supportedCipherSuites;
    private List<XECDHECryptography.SupportedGroup> supportedGroups;
    private List<SignatureAndHashAlgorithm> supportedSignatureAlgorithms;
    private List<CertificateType> trustCertificateTypes;

    @Deprecated
    private X509Certificate[] trustStore;
    private Boolean useAntiReplayFilter;
    private Boolean useCidUpdateAddressOnNewerRecordFilter;
    private Integer useExtendedWindowFilter;
    private Boolean useHandshakeStateValidation;
    private Boolean useKeyUsageVerification;
    private Boolean useNoServerSessionId;
    private Boolean useTruncatedCertificatePathForClientsCertificateMessage;
    private Boolean useTruncatedCertificatePathForValidation;
    private Integer verifyPeersOnResumptionThreshold;

    public static /* synthetic */ TrustedRpkStore access$4300(DtlsConnectorConfig dtlsConnectorConfig) {
        dtlsConnectorConfig.getClass();
        return null;
    }

    public Object clone() {
        DtlsConnectorConfig dtlsConnectorConfig = new DtlsConnectorConfig();
        dtlsConnectorConfig.address = this.address;
        dtlsConnectorConfig.trustStore = this.trustStore;
        dtlsConnectorConfig.certificateVerifier = this.certificateVerifier;
        dtlsConnectorConfig.advancedCertificateVerifier = this.advancedCertificateVerifier;
        dtlsConnectorConfig.earlyStopRetransmission = this.earlyStopRetransmission;
        dtlsConnectorConfig.enableReuseAddress = this.enableReuseAddress;
        dtlsConnectorConfig.recordSizeLimit = this.recordSizeLimit;
        dtlsConnectorConfig.maxFragmentLengthCode = this.maxFragmentLengthCode;
        dtlsConnectorConfig.maxFragmentedHandshakeMessageLength = this.maxFragmentedHandshakeMessageLength;
        dtlsConnectorConfig.enableMultiRecordMessages = this.enableMultiRecordMessages;
        dtlsConnectorConfig.enableMultiHandshakeMessageRecords = this.enableMultiHandshakeMessageRecords;
        dtlsConnectorConfig.protocolVersionForHelloVerifyRequests = this.protocolVersionForHelloVerifyRequests;
        dtlsConnectorConfig.retransmissionTimeout = this.retransmissionTimeout;
        dtlsConnectorConfig.maxRetransmissions = this.maxRetransmissions;
        dtlsConnectorConfig.backOffRetransmission = this.backOffRetransmission;
        dtlsConnectorConfig.maxTransmissionUnit = this.maxTransmissionUnit;
        dtlsConnectorConfig.maxTransmissionUnitLimit = this.maxTransmissionUnitLimit;
        dtlsConnectorConfig.clientAuthenticationRequired = this.clientAuthenticationRequired;
        dtlsConnectorConfig.clientAuthenticationWanted = this.clientAuthenticationWanted;
        dtlsConnectorConfig.serverOnly = this.serverOnly;
        dtlsConnectorConfig.defaultHandshakeMode = this.defaultHandshakeMode;
        dtlsConnectorConfig.identityCertificateTypes = this.identityCertificateTypes;
        dtlsConnectorConfig.trustCertificateTypes = this.trustCertificateTypes;
        dtlsConnectorConfig.pskStore = this.pskStore;
        dtlsConnectorConfig.advancedPskStore = this.advancedPskStore;
        dtlsConnectorConfig.privateKey = this.privateKey;
        dtlsConnectorConfig.publicKey = this.publicKey;
        dtlsConnectorConfig.certChain = this.certChain;
        dtlsConnectorConfig.cipherSuiteSelector = this.cipherSuiteSelector;
        dtlsConnectorConfig.preselectedCipherSuites = this.preselectedCipherSuites;
        dtlsConnectorConfig.supportedCipherSuites = this.supportedCipherSuites;
        dtlsConnectorConfig.supportedSignatureAlgorithms = this.supportedSignatureAlgorithms;
        dtlsConnectorConfig.supportedGroups = this.supportedGroups;
        dtlsConnectorConfig.outboundMessageBufferSize = this.outboundMessageBufferSize;
        dtlsConnectorConfig.maxDeferredProcessedOutgoingApplicationDataMessages = this.maxDeferredProcessedOutgoingApplicationDataMessages;
        dtlsConnectorConfig.maxDeferredProcessedIncomingRecordsSize = this.maxDeferredProcessedIncomingRecordsSize;
        dtlsConnectorConfig.maxConnections = this.maxConnections;
        dtlsConnectorConfig.staleConnectionThreshold = this.staleConnectionThreshold;
        dtlsConnectorConfig.connectionThreadCount = this.connectionThreadCount;
        dtlsConnectorConfig.receiverThreadCount = this.receiverThreadCount;
        dtlsConnectorConfig.socketReceiveBufferSize = this.socketReceiveBufferSize;
        dtlsConnectorConfig.socketSendBufferSize = this.socketSendBufferSize;
        dtlsConnectorConfig.healthStatusInterval = this.healthStatusInterval;
        dtlsConnectorConfig.autoResumptionTimeoutMillis = this.autoResumptionTimeoutMillis;
        dtlsConnectorConfig.sniEnabled = this.sniEnabled;
        dtlsConnectorConfig.verifyPeersOnResumptionThreshold = this.verifyPeersOnResumptionThreshold;
        dtlsConnectorConfig.useNoServerSessionId = this.useNoServerSessionId;
        dtlsConnectorConfig.loggingTag = this.loggingTag;
        dtlsConnectorConfig.useAntiReplayFilter = this.useAntiReplayFilter;
        dtlsConnectorConfig.useExtendedWindowFilter = this.useExtendedWindowFilter;
        dtlsConnectorConfig.useCidUpdateAddressOnNewerRecordFilter = this.useCidUpdateAddressOnNewerRecordFilter;
        dtlsConnectorConfig.connectionIdGenerator = this.connectionIdGenerator;
        dtlsConnectorConfig.useHandshakeStateValidation = this.useHandshakeStateValidation;
        dtlsConnectorConfig.useTruncatedCertificatePathForClientsCertificateMessage = this.useTruncatedCertificatePathForClientsCertificateMessage;
        dtlsConnectorConfig.useTruncatedCertificatePathForValidation = this.useTruncatedCertificatePathForValidation;
        dtlsConnectorConfig.useKeyUsageVerification = this.useKeyUsageVerification;
        dtlsConnectorConfig.healthHandler = this.healthHandler;
        dtlsConnectorConfig.clientOnly = this.clientOnly;
        dtlsConnectorConfig.recommendedCipherSuitesOnly = this.recommendedCipherSuitesOnly;
        dtlsConnectorConfig.recommendedSupportedGroupsOnly = this.recommendedSupportedGroupsOnly;
        return dtlsConnectorConfig;
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    public NewAdvancedCertificateVerifier getAdvancedCertificateVerifier() {
        return this.advancedCertificateVerifier;
    }

    public AdvancedPskStore getAdvancedPskStore() {
        return this.advancedPskStore;
    }

    public ApplicationLevelInfoSupplier getApplicationLevelInfoSupplier() {
        return null;
    }

    public Long getAutoResumptionTimeoutMillis() {
        return this.autoResumptionTimeoutMillis;
    }

    public Integer getBackOffRetransmission() {
        return this.backOffRetransmission;
    }

    public List<X509Certificate> getCertificateChain() {
        return this.certChain;
    }

    public CipherSuiteSelector getCipherSuiteSelector() {
        return this.cipherSuiteSelector;
    }

    public ConnectionIdGenerator getConnectionIdGenerator() {
        return this.connectionIdGenerator;
    }

    public ConnectionListener getConnectionListener() {
        return null;
    }

    public Integer getConnectionThreadCount() {
        return this.connectionThreadCount;
    }

    public String getDefaultHandshakeMode() {
        return this.defaultHandshakeMode;
    }

    public DtlsHealth getHealthHandler() {
        return this.healthHandler;
    }

    public Integer getHealthStatusInterval() {
        return this.healthStatusInterval;
    }

    public List<CertificateType> getIdentityCertificateTypes() {
        return this.identityCertificateTypes;
    }

    public String getLoggingTag() {
        return this.loggingTag;
    }

    public Integer getMaxConnections() {
        return this.maxConnections;
    }

    public Integer getMaxDeferredProcessedIncomingRecordsSize() {
        return this.maxDeferredProcessedIncomingRecordsSize;
    }

    public Integer getMaxDeferredProcessedOutgoingApplicationDataMessages() {
        return this.maxDeferredProcessedOutgoingApplicationDataMessages;
    }

    public Integer getMaxFragmentLengthCode() {
        return this.maxFragmentLengthCode;
    }

    public Integer getMaxFragmentedHandshakeMessageLength() {
        return this.maxFragmentedHandshakeMessageLength;
    }

    public Integer getMaxRetransmissions() {
        return this.maxRetransmissions;
    }

    public Integer getMaxTransmissionUnit() {
        return this.maxTransmissionUnit;
    }

    public Integer getMaxTransmissionUnitLimit() {
        return this.maxTransmissionUnitLimit;
    }

    public Integer getOutboundMessageBufferSize() {
        return this.outboundMessageBufferSize;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public ProtocolVersion getProtocolVersionForHelloVerifyRequests() {
        return this.protocolVersionForHelloVerifyRequests;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public Integer getReceiverThreadCount() {
        return this.receiverThreadCount;
    }

    public Integer getRecordSizeLimit() {
        return this.recordSizeLimit;
    }

    public Integer getRetransmissionTimeout() {
        return this.retransmissionTimeout;
    }

    public Integer getSocketReceiveBufferSize() {
        return this.socketReceiveBufferSize;
    }

    public Integer getSocketSendBufferSize() {
        return this.socketSendBufferSize;
    }

    public Long getStaleConnectionThreshold() {
        return this.staleConnectionThreshold;
    }

    public List<CipherSuite> getSupportedCipherSuites() {
        return this.supportedCipherSuites;
    }

    public List<XECDHECryptography.SupportedGroup> getSupportedGroups() {
        return this.supportedGroups;
    }

    public List<SignatureAndHashAlgorithm> getSupportedSignatureAlgorithms() {
        return this.supportedSignatureAlgorithms;
    }

    public List<CertificateType> getTrustCertificateTypes() {
        return this.trustCertificateTypes;
    }

    public Integer getVerifyPeersOnResumptionThreshold() {
        return this.verifyPeersOnResumptionThreshold;
    }

    public Boolean isAddressReuseEnabled() {
        return this.enableReuseAddress;
    }

    public Boolean isClientAuthenticationRequired() {
        return this.clientAuthenticationRequired;
    }

    public Boolean isClientAuthenticationWanted() {
        return this.clientAuthenticationWanted;
    }

    public Boolean isEarlyStopRetransmission() {
        return this.earlyStopRetransmission;
    }

    public Boolean isServerOnly() {
        return this.serverOnly;
    }

    public Boolean isSniEnabled() {
        return this.sniEnabled;
    }

    public Boolean useAntiReplayFilter() {
        return this.useAntiReplayFilter;
    }

    public Boolean useCidUpdateAddressOnNewerRecordFilter() {
        return this.useCidUpdateAddressOnNewerRecordFilter;
    }

    public Integer useExtendedWindowFilter() {
        return this.useExtendedWindowFilter;
    }

    public Boolean useHandshakeStateValidation() {
        return this.useHandshakeStateValidation;
    }

    public Boolean useKeyUsageVerification() {
        return this.useKeyUsageVerification;
    }

    public Boolean useMultiHandshakeMessageRecords() {
        return this.enableMultiHandshakeMessageRecords;
    }

    public Boolean useMultiRecordMessages() {
        return this.enableMultiRecordMessages;
    }

    public Boolean useNoServerSessionId() {
        return this.useNoServerSessionId;
    }

    public Boolean useTruncatedCertificatePathForClientsCertificateMessage() {
        return this.useTruncatedCertificatePathForClientsCertificateMessage;
    }

    public Boolean useTruncatedCertificatePathForValidation() {
        return this.useTruncatedCertificatePathForValidation;
    }

    private DtlsConnectorConfig() {
    }

    public static final class Builder {
        private DtlsConnectorConfig config = new DtlsConnectorConfig();

        private void addSupportedGroups(List<XECDHECryptography.SupportedGroup> list, PublicKey publicKey) {
            XECDHECryptography.SupportedGroup supportedGroupFromPublicKey;
            if (publicKey == null || (supportedGroupFromPublicKey = XECDHECryptography.SupportedGroup.fromPublicKey(publicKey)) == null || !supportedGroupFromPublicKey.isUsable() || list.contains(supportedGroupFromPublicKey)) {
                return;
            }
            if (!this.config.recommendedSupportedGroupsOnly.booleanValue() || supportedGroupFromPublicKey.isRecommended()) {
                list.add(supportedGroupFromPublicKey);
            }
        }

        private void determineCipherSuitesFromConfig() {
            ArrayList arrayList = new ArrayList();
            if (isConfiguredWithKeyPair() || this.config.trustCertificateTypes != null) {
                arrayList.addAll(CipherSuite.getEcdsaCipherSuites(this.config.recommendedCipherSuitesOnly.booleanValue()));
            }
            if (this.config.advancedPskStore != null) {
                if (this.config.advancedPskStore.hasEcdhePskSupported()) {
                    arrayList.addAll(CipherSuite.getCipherSuitesByKeyExchangeAlgorithm(this.config.recommendedCipherSuitesOnly.booleanValue(), CipherSuite.KeyExchangeAlgorithm.ECDHE_PSK));
                }
                arrayList.addAll(CipherSuite.getCipherSuitesByKeyExchangeAlgorithm(this.config.recommendedCipherSuitesOnly.booleanValue(), CipherSuite.KeyExchangeAlgorithm.PSK));
            }
            if (this.config.preselectedCipherSuites != null) {
                ArrayList arrayList2 = new ArrayList();
                for (CipherSuite cipherSuite : this.config.preselectedCipherSuites) {
                    if (arrayList.contains(cipherSuite)) {
                        arrayList2.add(cipherSuite);
                    }
                }
                arrayList = arrayList2;
            }
            this.config.supportedCipherSuites = arrayList;
        }

        private List<XECDHECryptography.SupportedGroup> getDefaultSupportedGroups() {
            ArrayList arrayList = new ArrayList(XECDHECryptography.SupportedGroup.getPreferredGroups());
            List list = this.config.certChain;
            DtlsConnectorConfig dtlsConnectorConfig = this.config;
            if (list == null) {
                addSupportedGroups(arrayList, dtlsConnectorConfig.publicKey);
                return arrayList;
            }
            Iterator it = dtlsConnectorConfig.certChain.iterator();
            while (it.hasNext()) {
                addSupportedGroups(arrayList, ((X509Certificate) it.next()).getPublicKey());
            }
            return arrayList;
        }

        private boolean isConfiguredWithKeyPair() {
            return (this.config.privateKey == null || this.config.publicKey == null) ? false : true;
        }

        private void verifyCertificateBasedCipherConfig(CipherSuite cipherSuite) {
            if (this.config.privateKey != null && this.config.publicKey != null) {
                String strName = cipherSuite.getCertificateKeyAlgorithm().name();
                if ((!strName.equals(this.config.privateKey.getAlgorithm()) || !strName.equals(this.config.publicKey.getAlgorithm())) && (!strName.equals("EC") || !Asn1DerDecoder.isSupported(this.config.privateKey.getAlgorithm()) || !Asn1DerDecoder.isSupported(this.config.publicKey.getAlgorithm()))) {
                    FacebookSdk$$ExternalSyntheticLambda1.m(FileInsert$$ExternalSyntheticOutline0.m5m("Keys must be ", strName, " capable for configured "), (Object) cipherSuite.name());
                    return;
                }
            } else if (!this.config.clientOnly.booleanValue()) {
                Home$$ExternalSyntheticBUOutline0.m("Identity must be set for configured ", (Object) cipherSuite.name());
                return;
            }
            if ((this.config.clientOnly.booleanValue() || this.config.clientAuthenticationRequired.booleanValue() || this.config.clientAuthenticationWanted.booleanValue()) && this.config.trustCertificateTypes == null) {
                Home$$ExternalSyntheticBUOutline0.m("trust must be set for configured ", (Object) cipherSuite.name());
            }
        }

        private void verifyPskBasedCipherConfig(CipherSuite cipherSuite) {
            if (this.config.advancedPskStore == null) {
                Home$$ExternalSyntheticBUOutline0.m("PSK store must be set for configured ", (Object) cipherSuite.name());
            } else {
                if (this.config.advancedPskStore.hasEcdhePskSupported() || !cipherSuite.isEccBased()) {
                    return;
                }
                Home$$ExternalSyntheticBUOutline0.m("PSK store doesn't support ECDHE! ", (Object) cipherSuite.name());
            }
        }

        private void verifySignatureAndHashAlgorithms(List<SignatureAndHashAlgorithm> list) {
            if (this.config.publicKey != null) {
                if (SignatureAndHashAlgorithm.getSupportedSignatureAlgorithm(list, this.config.publicKey) == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("supported signature and hash algorithms doesn't match the public key!");
                } else {
                    if (this.config.certChain == null || SignatureAndHashAlgorithm.isSignedWithSupportedAlgorithms(list, this.config.certChain)) {
                        return;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("supported signature and hash algorithms doesn't match the certificate chain!");
                }
            }
        }

        private void verifySupportedGroups(List<XECDHECryptography.SupportedGroup> list, PublicKey publicKey) {
            if (publicKey != null) {
                XECDHECryptography.SupportedGroup supportedGroupFromPublicKey = XECDHECryptography.SupportedGroup.fromPublicKey(publicKey);
                if (supportedGroupFromPublicKey == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("public key used with unknown group (curve)!");
                    return;
                }
                if (!supportedGroupFromPublicKey.isUsable()) {
                    Fragment$$ExternalSyntheticBUOutline0.m$1("public key used with unsupported group (curve) ", supportedGroupFromPublicKey.name(), "!");
                    return;
                }
                if (!list.contains(supportedGroupFromPublicKey)) {
                    Fragment$$ExternalSyntheticBUOutline0.m$1("public key used with not configured group (curve) ", supportedGroupFromPublicKey.name(), "!");
                } else {
                    if (!this.config.recommendedSupportedGroupsOnly.booleanValue() || supportedGroupFromPublicKey.isRecommended()) {
                        return;
                    }
                    Fragment$$ExternalSyntheticBUOutline0.m$1("public key used with unrecommended group (curve) ", supportedGroupFromPublicKey.name(), "!");
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x028a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DtlsConnectorConfig build() {
            Integer numValueOf = Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            DtlsConnectorConfig dtlsConnectorConfig = this.config;
            dtlsConnectorConfig.loggingTag = StringUtil.normalizeLoggingTag(dtlsConnectorConfig.loggingTag);
            if (this.config.address == null) {
                this.config.address = new InetSocketAddress(0);
            }
            if (this.config.enableReuseAddress == null) {
                this.config.enableReuseAddress = Boolean.FALSE;
            }
            if (this.config.useHandshakeStateValidation == null) {
                this.config.useHandshakeStateValidation = Boolean.TRUE;
            }
            if (this.config.useTruncatedCertificatePathForClientsCertificateMessage == null) {
                this.config.useTruncatedCertificatePathForClientsCertificateMessage = Boolean.TRUE;
            }
            if (this.config.useTruncatedCertificatePathForValidation == null) {
                this.config.useTruncatedCertificatePathForValidation = Boolean.TRUE;
            }
            if (this.config.useKeyUsageVerification == null) {
                this.config.useKeyUsageVerification = Boolean.TRUE;
            }
            if (this.config.earlyStopRetransmission == null) {
                this.config.earlyStopRetransmission = Boolean.TRUE;
            }
            if (this.config.retransmissionTimeout == null) {
                this.config.retransmissionTimeout = 1000;
            }
            if (this.config.maxRetransmissions == null) {
                this.config.maxRetransmissions = 4;
            }
            if (this.config.backOffRetransmission == null) {
                DtlsConnectorConfig dtlsConnectorConfig2 = this.config;
                dtlsConnectorConfig2.backOffRetransmission = Integer.valueOf(dtlsConnectorConfig2.maxRetransmissions.intValue() / 2);
            }
            if (this.config.maxFragmentedHandshakeMessageLength == null) {
                this.config.maxFragmentedHandshakeMessageLength = numValueOf;
            }
            if (this.config.clientAuthenticationWanted == null) {
                this.config.clientAuthenticationWanted = Boolean.FALSE;
            }
            if (this.config.clientOnly == null) {
                this.config.clientOnly = Boolean.FALSE;
            }
            if (this.config.recommendedCipherSuitesOnly == null) {
                this.config.recommendedCipherSuitesOnly = Boolean.TRUE;
            }
            if (this.config.recommendedSupportedGroupsOnly == null) {
                this.config.recommendedSupportedGroupsOnly = Boolean.TRUE;
            }
            if (this.config.clientAuthenticationRequired == null) {
                boolean zBooleanValue = this.config.clientOnly.booleanValue();
                DtlsConnectorConfig dtlsConnectorConfig3 = this.config;
                if (zBooleanValue) {
                    dtlsConnectorConfig3.clientAuthenticationRequired = Boolean.FALSE;
                } else {
                    dtlsConnectorConfig3.clientAuthenticationRequired = Boolean.valueOf(!dtlsConnectorConfig3.clientAuthenticationWanted.booleanValue());
                }
            }
            if (this.config.serverOnly == null) {
                this.config.serverOnly = Boolean.FALSE;
            }
            if (this.config.defaultHandshakeMode == null) {
                boolean zBooleanValue2 = this.config.serverOnly.booleanValue();
                DtlsConnectorConfig dtlsConnectorConfig4 = this.config;
                if (zBooleanValue2) {
                    dtlsConnectorConfig4.defaultHandshakeMode = IntegrityManager.INTEGRITY_TYPE_NONE;
                } else {
                    dtlsConnectorConfig4.defaultHandshakeMode = "auto";
                }
            }
            if (this.config.useNoServerSessionId == null) {
                this.config.useNoServerSessionId = Boolean.FALSE;
            }
            if (this.config.outboundMessageBufferSize == null) {
                this.config.outboundMessageBufferSize = 100000;
            }
            if (this.config.maxDeferredProcessedOutgoingApplicationDataMessages == null) {
                this.config.maxDeferredProcessedOutgoingApplicationDataMessages = 10;
            }
            if (this.config.maxDeferredProcessedIncomingRecordsSize == null) {
                this.config.maxDeferredProcessedIncomingRecordsSize = numValueOf;
            }
            if (this.config.maxConnections == null) {
                this.config.maxConnections = 150000;
            }
            if (this.config.connectionThreadCount == null) {
                this.config.connectionThreadCount = Integer.valueOf(DtlsConnectorConfig.DEFAULT_EXECUTOR_THREAD_POOL_SIZE);
            }
            if (this.config.receiverThreadCount == null) {
                this.config.receiverThreadCount = Integer.valueOf(DtlsConnectorConfig.DEFAULT_RECEIVER_THREADS);
            }
            if (this.config.staleConnectionThreshold == null) {
                this.config.staleConnectionThreshold = 1800L;
            }
            if (this.config.maxTransmissionUnitLimit == null) {
                this.config.maxTransmissionUnitLimit = Integer.valueOf(AppFunctionException.ERROR_RESOURCE_NOT_FOUND);
            }
            if (this.config.sniEnabled == null) {
                this.config.sniEnabled = Boolean.FALSE;
            }
            if (this.config.useExtendedWindowFilter == null) {
                this.config.useExtendedWindowFilter = 0;
            }
            if (this.config.useAntiReplayFilter == null) {
                DtlsConnectorConfig dtlsConnectorConfig5 = this.config;
                dtlsConnectorConfig5.useAntiReplayFilter = Boolean.valueOf(dtlsConnectorConfig5.useExtendedWindowFilter.intValue() == 0);
            }
            if (this.config.useCidUpdateAddressOnNewerRecordFilter == null) {
                this.config.useCidUpdateAddressOnNewerRecordFilter = Boolean.TRUE;
            }
            if (this.config.verifyPeersOnResumptionThreshold == null) {
                this.config.verifyPeersOnResumptionThreshold = 30;
            }
            if (this.config.advancedCertificateVerifier == null) {
                if (this.config.trustStore == null) {
                    DtlsConnectorConfig.access$4300(this.config);
                    if (this.config.certificateVerifier != null) {
                        BridgeCertificateVerifier.Builder builder = BridgeCertificateVerifier.builder();
                        X509Certificate[] x509CertificateArr = this.config.trustStore;
                        DtlsConnectorConfig dtlsConnectorConfig6 = this.config;
                        if (x509CertificateArr != null) {
                            builder.setTrustedCertificates(dtlsConnectorConfig6.trustStore);
                        } else if (dtlsConnectorConfig6.certificateVerifier != null) {
                            builder.setCertificateVerifier(this.config.certificateVerifier);
                        }
                        DtlsConnectorConfig.access$4300(this.config);
                        this.config.advancedCertificateVerifier = builder.build();
                    }
                }
            }
            if (this.config.trustCertificateTypes == null && this.config.advancedCertificateVerifier != null) {
                DtlsConnectorConfig dtlsConnectorConfig7 = this.config;
                dtlsConnectorConfig7.trustCertificateTypes = dtlsConnectorConfig7.advancedCertificateVerifier.getSupportedCertificateType();
            }
            if (this.config.serverOnly.booleanValue() && !this.config.clientAuthenticationRequired.booleanValue() && !this.config.clientAuthenticationWanted.booleanValue() && this.config.trustCertificateTypes != null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("configured trusted certificates or certificate verifier are not used for disabled client authentication!");
                return null;
            }
            if (this.config.supportedCipherSuites == null || this.config.supportedCipherSuites.isEmpty()) {
                determineCipherSuitesFromConfig();
            }
            if (this.config.supportedGroups == null) {
                this.config.supportedGroups = Collections.EMPTY_LIST;
            }
            if (this.config.supportedSignatureAlgorithms == null) {
                this.config.supportedSignatureAlgorithms = Collections.EMPTY_LIST;
            }
            if (this.config.cipherSuiteSelector == null && !this.config.clientOnly.booleanValue()) {
                this.config.cipherSuiteSelector = new DefaultCipherSuiteSelector();
            }
            if (this.config.supportedCipherSuites == null || this.config.supportedCipherSuites.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Supported cipher suites must be set either explicitly or implicitly by means of setting the identity or PSK store");
                return null;
            }
            for (CipherSuite cipherSuite : this.config.supportedCipherSuites) {
                if (!cipherSuite.isSupported()) {
                    Fragment$$ExternalSyntheticBUOutline0.m("cipher-suites ", cipherSuite, " is not supported by JVM!");
                    return null;
                }
            }
            if (this.config.trustCertificateTypes != null) {
                if (this.config.advancedCertificateVerifier == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("trusted certificates, trusted rpks, or certificate verifier must be set for trust certificates");
                    return null;
                }
                List<CertificateType> supportedCertificateType = this.config.advancedCertificateVerifier.getSupportedCertificateType();
                for (CertificateType certificateType : this.config.trustCertificateTypes) {
                    if (!supportedCertificateType.contains(certificateType)) {
                        throw new IllegalStateException(certificateType + " is not supported by certificate verifier");
                    }
                }
            }
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (CipherSuite cipherSuite2 : this.config.supportedCipherSuites) {
                if (cipherSuite2.isPskBased()) {
                    verifyPskBasedCipherConfig(cipherSuite2);
                    z = true;
                } else if (cipherSuite2.requiresServerCertificateMessage()) {
                    verifyCertificateBasedCipherConfig(cipherSuite2);
                    z3 = true;
                }
                if (cipherSuite2.isEccBased()) {
                    z2 = true;
                }
            }
            if (!z && this.config.pskStore != null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("PSK store set, but no PSK cipher suite!");
                return null;
            }
            if (!z && this.config.advancedPskStore != null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Advanced PSK store set, but no PSK cipher suite!");
                return null;
            }
            DtlsConnectorConfig dtlsConnectorConfig8 = this.config;
            if (z2) {
                if (dtlsConnectorConfig8.supportedSignatureAlgorithms.isEmpty()) {
                    if (this.config.certChain != null || this.config.publicKey == null) {
                        DtlsConnectorConfig dtlsConnectorConfig9 = this.config;
                        dtlsConnectorConfig9.supportedSignatureAlgorithms = SignatureAndHashAlgorithm.getDefaultSignatureAlgorithms((List<X509Certificate>) dtlsConnectorConfig9.certChain);
                    } else {
                        DtlsConnectorConfig dtlsConnectorConfig10 = this.config;
                        dtlsConnectorConfig10.supportedSignatureAlgorithms = SignatureAndHashAlgorithm.getDefaultSignatureAlgorithms(dtlsConnectorConfig10.publicKey);
                    }
                }
                if (this.config.supportedGroups.isEmpty()) {
                    this.config.supportedGroups = getDefaultSupportedGroups();
                }
            } else {
                if (!dtlsConnectorConfig8.supportedSignatureAlgorithms.isEmpty()) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("supported signature and hash algorithms set, but no ecdhe based cipher suite!");
                    return null;
                }
                if (!this.config.supportedGroups.isEmpty()) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("supported groups set, but no ecdhe based cipher suite!");
                    return null;
                }
            }
            if (!z3) {
                if (this.config.privateKey != null || this.config.publicKey != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Identity set, but no certificate based cipher suite!");
                    return null;
                }
                if (this.config.advancedCertificateVerifier != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("certificate trust set, but no certificate based cipher suite!");
                    return null;
                }
            }
            if (this.config.certChain != null) {
                X509Certificate x509Certificate = (X509Certificate) this.config.certChain.get(0);
                if (this.config.clientOnly.booleanValue()) {
                    if (!CertPathUtil.canBeUsedForAuthentication(x509Certificate, true)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("certificate has no proper key usage for clients!");
                        return null;
                    }
                } else if (!this.config.serverOnly.booleanValue()) {
                    if (!CertPathUtil.canBeUsedForAuthentication(x509Certificate, true)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("certificate has no proper key usage as clients!");
                        return null;
                    }
                    if (!CertPathUtil.canBeUsedForAuthentication(x509Certificate, false)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("certificate has no proper key usage as servers!");
                        return null;
                    }
                } else if (!CertPathUtil.canBeUsedForAuthentication(x509Certificate, false)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("certificate has no proper key usage for servers!");
                    return null;
                }
            }
            verifySignatureAndHashAlgorithms(this.config.supportedSignatureAlgorithms);
            verifySupportedGroups(this.config.supportedGroups);
            DtlsConnectorConfig dtlsConnectorConfig11 = this.config;
            dtlsConnectorConfig11.trustCertificateTypes = ListUtils.init(dtlsConnectorConfig11.trustCertificateTypes);
            DtlsConnectorConfig dtlsConnectorConfig12 = this.config;
            dtlsConnectorConfig12.identityCertificateTypes = ListUtils.init(dtlsConnectorConfig12.identityCertificateTypes);
            DtlsConnectorConfig dtlsConnectorConfig13 = this.config;
            dtlsConnectorConfig13.supportedCipherSuites = ListUtils.init(dtlsConnectorConfig13.supportedCipherSuites);
            DtlsConnectorConfig dtlsConnectorConfig14 = this.config;
            dtlsConnectorConfig14.supportedGroups = ListUtils.init(dtlsConnectorConfig14.supportedGroups);
            DtlsConnectorConfig dtlsConnectorConfig15 = this.config;
            dtlsConnectorConfig15.certChain = ListUtils.init(dtlsConnectorConfig15.certChain);
            DtlsConnectorConfig dtlsConnectorConfig16 = this.config;
            dtlsConnectorConfig16.supportedSignatureAlgorithms = ListUtils.init(dtlsConnectorConfig16.supportedSignatureAlgorithms);
            return this.config;
        }

        @Deprecated
        public Builder setPskStore(PskStore pskStore) {
            this.config.advancedPskStore = pskStore == null ? null : new AdvancedInMemoryPskStore(pskStore);
            this.config.pskStore = pskStore;
            return this;
        }

        public Builder setRetransmissionTimeout(int i) {
            if (i < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Retransmission timeout must not be negative");
                return null;
            }
            this.config.retransmissionTimeout = Integer.valueOf(i);
            return this;
        }

        private void verifySupportedGroups(List<XECDHECryptography.SupportedGroup> list) {
            List list2 = this.config.certChain;
            DtlsConnectorConfig dtlsConnectorConfig = this.config;
            if (list2 != null) {
                Iterator it = dtlsConnectorConfig.certChain.iterator();
                while (it.hasNext()) {
                    PublicKey publicKey = ((X509Certificate) it.next()).getPublicKey();
                    if (XECDHECryptography.SupportedGroup.isEcPublicKey(publicKey)) {
                        verifySupportedGroups(list, publicKey);
                    }
                }
                return;
            }
            verifySupportedGroups(list, dtlsConnectorConfig.publicKey);
        }
    }
}
