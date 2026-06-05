package org.eclipse.californium.core.network.config;

import com.facebook.internal.Utility;
import com.urbandroid.smartlight.ikea.tradfri.TradfriKt;
import org.achartengine.chart.TimeChart;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NetworkConfigDefaults {
    public static void setDefaults(NetworkConfig networkConfig) {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        boolean zStartsWith = System.getProperty("os.name").startsWith("Windows");
        networkConfig.setInt("MAX_ACTIVE_PEERS", 150000);
        networkConfig.setLong("MAX_PEER_INACTIVITY_PERIOD", 600L);
        networkConfig.setInt("COAP_PORT", 5683);
        networkConfig.setInt("COAP_SECURE_PORT", TradfriKt.COAPS_PORT);
        networkConfig.setInt("ACK_TIMEOUT", 2000);
        networkConfig.setFloat("ACK_RANDOM_FACTOR", 1.5f);
        networkConfig.setFloat("ACK_TIMEOUT_SCALE", 2.0f);
        networkConfig.setInt("MAX_RETRANSMIT", 4);
        networkConfig.setLong("EXCHANGE_LIFETIME", 247000L);
        networkConfig.setLong("NON_LIFETIME", 145000L);
        networkConfig.setLong("MAX_TRANSMIT_WAIT", 93000L);
        networkConfig.setInt("NSTART", 1);
        networkConfig.setInt("LEISURE", DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT);
        networkConfig.setFloat("PROBING_RATE", 1.0f);
        networkConfig.setBoolean("USE_MESSAGE_OFFLOADING", false);
        networkConfig.setInt("MAX_LATENCY", 100000);
        networkConfig.setInt("MAX_SERVER_RESPONSE_DELAY", 250000);
        networkConfig.setBoolean("USE_RANDOM_MID_START", true);
        networkConfig.setString("MID_TACKER", "GROUPED");
        networkConfig.setInt("MID_TRACKER_GROUPS", 16);
        networkConfig.setInt("TOKEN_SIZE_LIMIT", 8);
        networkConfig.setInt("PREFERRED_BLOCK_SIZE", 512);
        networkConfig.setInt("MAX_MESSAGE_SIZE", 1024);
        networkConfig.setInt("MAX_RESOURCE_BODY_SIZE", Utility.DEFAULT_STREAM_BUFFER_SIZE);
        networkConfig.setInt("BLOCKWISE_STATUS_LIFETIME", 300000);
        networkConfig.setBoolean("BLOCKWISE_STRICT_BLOCK2_OPTION", false);
        networkConfig.setBoolean("BLOCKWISE_ENTITY_TOO_LARGE_AUTO_FAILOVER", true);
        networkConfig.setLong("NOTIFICATION_CHECK_INTERVAL", TimeChart.DAY);
        networkConfig.setInt("NOTIFICATION_CHECK_INTERVAL_COUNT", 100);
        networkConfig.setLong("NOTIFICATION_REREGISTRATION_BACKOFF", 2000L);
        networkConfig.setBoolean("USE_CONGESTION_CONTROL", false);
        networkConfig.setString("CONGESTION_CONTROL_ALGORITHM", "Cocoa");
        networkConfig.setInt("PROTOCOL_STAGE_THREAD_COUNT", iAvailableProcessors);
        networkConfig.setInt("NETWORK_STAGE_RECEIVER_THREAD_COUNT", zStartsWith ? iAvailableProcessors : 1);
        if (!zStartsWith) {
            iAvailableProcessors = 1;
        }
        networkConfig.setInt("NETWORK_STAGE_SENDER_THREAD_COUNT", iAvailableProcessors);
        networkConfig.setInt("UDP_CONNECTOR_DATAGRAM_SIZE", 2048);
        networkConfig.setInt("UDP_CONNECTOR_RECEIVE_BUFFER", 0);
        networkConfig.setInt("UDP_CONNECTOR_SEND_BUFFER", 0);
        networkConfig.setInt("UDP_CONNECTOR_OUT_CAPACITY", Integer.MAX_VALUE);
        networkConfig.setString("DEDUPLICATOR", "DEDUPLICATOR_MARK_AND_SWEEP");
        networkConfig.setLong("MARK_AND_SWEEP_INTERVAL", 10000L);
        networkConfig.setInt("PEERS_MARK_AND_SWEEP_MESSAGES", 64);
        networkConfig.setInt("CROP_ROTATION_PERIOD", 247000);
        networkConfig.setBoolean("DEDUPLICATOR_AUTO_REPLACE", true);
        networkConfig.setString("RESPONSE_MATCHING", "STRICT");
        networkConfig.setInt("HTTP_PORT", 8080);
        networkConfig.setInt("HTTP_SERVER_SOCKET_TIMEOUT", 100000);
        networkConfig.setInt("HTTP_SERVER_SOCKET_BUFFER_SIZE", Utility.DEFAULT_STREAM_BUFFER_SIZE);
        networkConfig.setInt("HTTP_CACHE_RESPONSE_MAX_AGE", 86400);
        networkConfig.setInt("HTTP_CACHE_SIZE", 32);
        networkConfig.setInt("HEALTH_STATUS_INTERVAL", 0);
        networkConfig.setInt("TCP_CONNECTION_IDLE_TIMEOUT", 10);
        networkConfig.setInt("TCP_WORKER_THREADS", 1);
        networkConfig.setInt("TCP_CONNECT_TIMEOUT", 10000);
        networkConfig.setInt("TLS_HANDSHAKE_TIMEOUT", 10000);
        networkConfig.setLong("SECURE_SESSION_TIMEOUT", 86400L);
        networkConfig.setLong("DTLS_AUTO_RESUME_TIMEOUT", 30000L);
        networkConfig.setString("DTLS_CONNECTION_ID_LENGTH", "");
        networkConfig.setString("DTLS_CONNECTION_ID_NODE_ID", "");
        networkConfig.setInt("MULTICAST_BASE_MID", 65000);
    }
}
