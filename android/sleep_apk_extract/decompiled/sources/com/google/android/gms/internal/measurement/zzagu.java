package com.google.android.gms.internal.measurement;

import com.facebook.AuthenticationTokenClaims;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
public final class zzagu implements zzagt {
    private static final zzpo zza = new zzpo(zzagr.zzc(), 81);

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzA() {
        return ((Long) zza.zzb(27, "measurement.alarm_manager.minimum_interval", 60000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzB() {
        return ((Long) zza.zzb(28, "measurement.upload.minimum_delay", 500L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzC() {
        return ((Long) zza.zzb(29, "measurement.monitoring.sample_period_millis", TimeChart.DAY).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzD() {
        return ((Long) zza.zzb(30, "measurement.rb.attribution.notify_app_delay_millis", 3000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final boolean zzE() {
        return ((Boolean) zza.zza(31, "measurement.config.notify_trigger_uris_on_backgrounded", true).get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzF() {
        return (String) zza.zzd(32, "measurement.rb.attribution.app_allowlist", "").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzG() {
        return ((Long) zza.zzb(33, "measurement.upload.realtime_upload_interval", 10000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzH() {
        return ((Long) zza.zzb(34, "measurement.upload.refresh_blacklisted_config_interval", 604800000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzI() {
        return ((Long) zza.zzb(36, "measurement.service_client.idle_disconnect_millis", 5000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzJ() {
        return ((Long) zza.zzb(38, "measurement.service_client.reconnect_millis", 1000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzK() {
        return ((Long) zza.zzb(40, "measurement.sgtm.batch.long_queuing_threshold", 240000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzL() {
        return ((Long) zza.zzb(41, "measurement.sgtm.batch.retry_interval", 1800000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzM() {
        return ((Long) zza.zzb(42, "measurement.sgtm.batch.retry_max_count", 10L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzN() {
        return ((Long) zza.zzb(43, "measurement.sgtm.batch.retry_max_wait", 21600000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzO() {
        return (String) zza.zzd(44, "measurement.sgtm.service_upload_apps_list", "").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzP() {
        return (String) zza.zzd(45, "measurement.sgtm.upload.backoff_http_codes", "404,429,503,504").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzQ() {
        return ((Long) zza.zzb(46, "measurement.sgtm.upload.batches_retrieval_limit", 5L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzR() {
        return ((Long) zza.zzb(47, "measurement.sgtm.upload.max_queued_batches", 5000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzS() {
        return ((Long) zza.zzb(48, "measurement.sgtm.upload.min_delay_after_background", AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzT() {
        return ((Long) zza.zzb(49, "measurement.sgtm.upload.min_delay_after_broadcast", 1000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzU() {
        return ((Long) zza.zzb(50, "measurement.sgtm.upload.min_delay_after_startup", 5000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzV() {
        return ((Long) zza.zzb(51, "measurement.sgtm.upload.retry_interval", AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzW() {
        return ((Long) zza.zzb(52, "measurement.sgtm.upload.retry_max_wait", 21600000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzX() {
        return ((Long) zza.zzb(53, "measurement.upload.stale_data_deletion_interval", TimeChart.DAY).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzY() {
        return ((Long) zza.zzb(54, "measurement.rb.attribution.max_retry_delay_seconds", 16L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzZ() {
        return ((Long) zza.zzb(55, "measurement.rb.attribution.client.min_time_after_boot_seconds", 90L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zza() {
        return ((Long) zza.zzb(0, "measurement.ad_id_cache_time", 10000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzaa() {
        return (String) zza.zzd(56, "measurement.rb.attribution.uri_authority", "google-analytics.com").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzab() {
        return ((Long) zza.zzb(57, "measurement.rb.attribution.max_queue_time", 864000000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzac() {
        return (String) zza.zzd(58, "measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzad() {
        return (String) zza.zzd(59, "measurement.rb.attribution.query_parameters_to_remove", "").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzae() {
        return (String) zza.zzd(60, "measurement.rb.attribution.uri_scheme", TournamentShareDialogURIBuilder.scheme).get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzaf() {
        return ((Long) zza.zzb(61, "measurement.sdk.attribution.cache.ttl", 604800000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzag() {
        return ((Long) zza.zzb(62, "measurement.redaction.app_instance_id.ttl", 7200000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzah() {
        return ((Long) zza.zzb(63, "measurement.upload.backoff_period", 43200000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzai() {
        return ((Long) zza.zzb(64, "measurement.upload.initial_upload_delay_time", 15000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzaj() {
        return ((Long) zza.zzb(65, "measurement.upload.interval", 3600000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzak() {
        return ((Long) zza.zzb(66, "measurement.upload.max_bundle_size", 65536L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzal() {
        return ((Long) zza.zzb(67, "measurement.upload.max_bundles", 100L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzam() {
        return ((Long) zza.zzb(68, "measurement.upload.max_conversions_per_day", 10000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzan() {
        return ((Long) zza.zzb(69, "measurement.upload.max_error_events_per_day", 1000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzao() {
        return ((Long) zza.zzb(70, "measurement.upload.max_events_per_bundle", 1000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzap() {
        return ((Long) zza.zzb(71, "measurement.upload.max_events_per_day", 100000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzaq() {
        return ((Long) zza.zzb(72, "measurement.upload.max_public_events_per_day", 50000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzar() {
        return ((Long) zza.zzb(73, "measurement.upload.max_queue_time", 518400000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzas() {
        return ((Long) zza.zzb(74, "measurement.upload.max_realtime_events_per_day", 10L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzat() {
        return ((Long) zza.zzb(75, "measurement.upload.max_batch_size", 65536L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzau() {
        return ((Long) zza.zzb(76, "measurement.upload.retry_count", 6L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzav() {
        return ((Long) zza.zzb(77, "measurement.upload.retry_time", 1800000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzaw() {
        return (String) zza.zzd(78, "measurement.upload.url", "https://app-measurement.com/a").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzax() {
        return ((Long) zza.zzb(79, "measurement.upload.window_interval", 3600000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzay() {
        return (String) zza.zzd(80, "measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzb() {
        return ((Long) zza.zzb(1, "measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final boolean zzc() {
        return ((Boolean) zza.zza(2, "measurement.config.bundle_for_all_apps_on_backgrounded", true).get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzd() {
        return ((Long) zza.zzb(3, "measurement.max_bundles_per_iteration", 100L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zze() {
        return (String) zza.zzd(4, "measurement.gbraid_campaign.campaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzf() {
        return ((Long) zza.zzb(5, "measurement.config.cache_time", TimeChart.DAY).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzg() {
        return (String) zza.zzd(7, "measurement.config.url_authority", "app-measurement.com").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzh() {
        return (String) zza.zzd(8, "measurement.config.url_scheme", TournamentShareDialogURIBuilder.scheme).get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzi() {
        return ((Long) zza.zzb(9, "measurement.upload.debug_upload_interval", 1000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final boolean zzj() {
        return ((Boolean) zza.zza(10, "measurement.config.default_flag_values", true).get()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzk() {
        return ((Long) zza.zzb(11, "45769094", 3600000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzl() {
        return ((Long) zza.zzb(12, "measurement.session.engagement_interval", 3600000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzm() {
        return (String) zza.zzd(13, "measurement.rb.attribution.event_params", "value|currency").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzn() {
        return (String) zza.zzd(14, "measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzo() {
        return ((Long) zza.zzb(15, "measurement.upload.google_signal_max_queue_time", 605000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final String zzp() {
        return (String) zza.zzd(16, "measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d").get();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzq() {
        return ((Long) zza.zzb(17, "measurement.lifetimevalue.max_currency_tracked", 4L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzr() {
        return ((Long) zza.zzb(18, "measurement.dma_consent.max_daily_dcu_realtime_events", 1L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzs() {
        return ((Long) zza.zzb(19, "measurement.upload.max_event_parameter_value_length", 500L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzt() {
        return ((Long) zza.zzb(20, "measurement.store.max_stored_events_per_app", 100000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzu() {
        return ((Long) zza.zzb(21, "measurement.experiment.max_ids", 50L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzv() {
        return ((Long) zza.zzb(22, "measurement.audience.filter_result_max_count", 200L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzw() {
        return ((Long) zza.zzb(23, "measurement.upload.max_item_scoped_custom_parameters", 27L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzx() {
        return ((Long) zza.zzb(24, "measurement.rb.max_trigger_registrations_per_day", 1000L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzy() {
        return ((Long) zza.zzb(25, "measurement.rb.attribution.max_trigger_uris_queried_at_once", 0L).get()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzagt
    public final long zzz() {
        return ((Long) zza.zzb(26, "measurement.rb.attribution.client.min_ad_services_version", 7L).get()).longValue();
    }
}
