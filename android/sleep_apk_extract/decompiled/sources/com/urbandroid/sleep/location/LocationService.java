package com.urbandroid.sleep.location;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.location.geocell.BoundingBox;
import com.urbandroid.sleep.location.geocell.GeocellUtils;
import com.urbandroid.sleep.location.geocell.Point;
import com.urbandroid.sleep.service.Settings;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LocationService {
    public static int GEOCELL_MAX_RESOLUTION = 8;
    public static int GEOCELL_MIN_RESOLUTION = 7;

    public interface LocationCallback {
        void updateLocation(Location location);
    }

    public static String computeGeocell(Location location) {
        if (location == null) {
            return null;
        }
        return GeocellUtils.compute(new Point(location.getLat(), location.getLon()), GEOCELL_MAX_RESOLUTION);
    }

    public static Location computeLocation(String str) {
        BoundingBox boundingBoxComputeBox;
        if (str == null || (boundingBoxComputeBox = GeocellUtils.computeBox(str)) == null) {
            return null;
        }
        return new Location(boundingBoxComputeBox.getNorth(), boundingBoxComputeBox.getWest());
    }

    public static boolean getLastLocation(Context context, LocationCallback locationCallback) {
        return getLocation(context, locationCallback, true);
    }

    private static boolean getLocation(final Context context, final LocationCallback locationCallback, final boolean z) {
        try {
        } catch (Exception e) {
            Logger.logSevere("Location: ", e);
            return false;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            Logger.logWarning("Location: no permission");
            return false;
        }
        if (Environment.isGingerOrGreater() && GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
            try {
                LocationServices.getFusedLocationProviderClient(context).getLastLocation().addOnSuccessListener(new OnSuccessListener<android.location.Location>() { // from class: com.urbandroid.sleep.location.LocationService.1
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public void onSuccess(android.location.Location location) {
                        if (location != null) {
                            Logger.logWarning("Location: last known " + new Location(location.getLatitude(), location.getLongitude()));
                        }
                        if (location != null) {
                            Location location2 = new Location(location.getLatitude(), location.getLongitude());
                            locationCallback.updateLocation(location2);
                            new Settings(context).setLocation(location2);
                            Logger.logDebug("Location: last " + location2);
                            return;
                        }
                        Logger.logInfo("Location last location null");
                        Location location3 = new Settings(context).getLocation();
                        if (z && location3 != null) {
                            locationCallback.updateLocation(location3);
                            return;
                        }
                        LocationRequest locationRequestCreate = LocationRequest.create();
                        locationRequestCreate.setInterval(1000L);
                        locationRequestCreate.setFastestInterval(10L);
                        locationRequestCreate.setNumUpdates(1);
                        locationRequestCreate.setExpirationDuration(60000L);
                        locationRequestCreate.setPriority(102);
                        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                            Logger.logWarning("LocationClient no permission");
                        } else {
                            final FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
                            fusedLocationProviderClient.requestLocationUpdates(locationRequestCreate, new com.google.android.gms.location.LocationCallback() { // from class: com.urbandroid.sleep.location.LocationService.1.1
                                @Override // com.google.android.gms.location.LocationCallback
                                public void onLocationResult(LocationResult locationResult) {
                                    super.onLocationResult(locationResult);
                                    android.location.Location lastLocation = locationResult.getLastLocation();
                                    Logger.logDebug("Location update " + locationResult);
                                    try {
                                        if (lastLocation != null) {
                                            Logger.logDebug("Location update lat:" + lastLocation.getLatitude() + " lon:" + lastLocation.getLongitude());
                                            Location location4 = new Location(lastLocation.getLatitude(), lastLocation.getLongitude());
                                            locationCallback.updateLocation(location4);
                                            new Settings(context).setLocation(location4);
                                        } else {
                                            Logger.logDebug("Requested location null");
                                        }
                                        try {
                                            fusedLocationProviderClient.removeLocationUpdates(this);
                                        } catch (Exception e2) {
                                            Logger.logSevere(e2);
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            fusedLocationProviderClient.removeLocationUpdates(this);
                                        } catch (Exception e3) {
                                            Logger.logSevere(e3);
                                        }
                                        throw th;
                                    }
                                }
                            }, Looper.getMainLooper());
                        }
                    }
                }).addOnFailureListener(new Events$$ExternalSyntheticBUOutline0(9));
                return true;
            } catch (Exception e2) {
                Logger.logSevere("Location exception ", e2);
                return false;
            }
        }
        try {
            android.location.Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("network");
            if (lastKnownLocation != null) {
                locationCallback.updateLocation(new Location(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()));
                return true;
            }
        } catch (Exception e3) {
            Logger.logWarning("Location: failed", e3);
        }
        return false;
        Logger.logSevere("Location: ", e);
        return false;
    }

    public static boolean sameOrAdjacent(String str, String str2, int i) {
        int iMin = Math.min(str.length(), str2.length());
        if (i != -1) {
            iMin = Math.min(iMin, i);
        }
        String strSubstring = str.substring(0, iMin);
        String strSubstring2 = str2.substring(0, iMin);
        if (strSubstring.equals(strSubstring2)) {
            return true;
        }
        List<String> listAllAdjacents = GeocellUtils.allAdjacents(strSubstring);
        listAllAdjacents.retainAll(GeocellUtils.allAdjacents(strSubstring2));
        return listAllAdjacents.size() > 0;
    }

    public static boolean sameOrAdjacent(String str, String str2) {
        return sameOrAdjacent(str, str2, GEOCELL_MIN_RESOLUTION);
    }

    public static boolean getLocation(Context context, LocationCallback locationCallback) {
        return getLocation(context, locationCallback, false);
    }
}
