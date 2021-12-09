/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.service.booking;

import com.playup.dao.booking.BookingFactoryDao;
import com.playup.dao.booking.INearestVenueLocationDao;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class NearestVenueLocatorServiceImpl implements INearestVenueLocatorService {
    INearestVenueLocationDao nearestVenueLocationDao;

    @Override
    public String getNearestVenue(String currentVenueId) {
        nearestVenueLocationDao = BookingFactoryDao.instance().nearestLocationDao();
        String sport = getCurrentUserSport();
        HashMap<String, String[]> locationData = nearestVenueLocationDao.getLocationsOfAllVenues();
        String nearestVenueId = calculateShortestDistance(currentVenueId, locationData, sport);
        return nearestVenueId;
    }

    private String getCurrentUserSport() {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/application.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream("src/main/resources/application.properties");
            String sportArray = props.getProperty("loggedInUser");
            String[] testArray = sportArray.split("\\|");
            props.store(out, null);
            out.close();
            return testArray[1];

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String calculateShortestDistance(String currentVenueId,
                                             HashMap<String, String[]> locationData, String sport) {
        String[] currentVenueLocation = locationData.get(currentVenueId);
        double currentVenueLatitude = Double.parseDouble(currentVenueLocation[0]);
        double currentVenueLongitude = Double.parseDouble(currentVenueLocation[1]);
        Map<Double, String> distanceMap = new HashMap<Double, String>();
        for (Map.Entry<String, String[]> entry : locationData.entrySet()) {
            String venueId = entry.getKey();
            String[] latLongData = entry.getValue();
            double venueLatitude = Double.parseDouble(latLongData[0]);
            double venueLongitude = Double.parseDouble(latLongData[1]);
            double distance = getDistanceBetweenTwoVenues(currentVenueLatitude, currentVenueLongitude, venueLatitude, venueLongitude);
            distanceMap.put(distance, venueId);
        }
        String shortestPathVenueId = getNearestVenueWithSameSport(distanceMap, sport);
        return shortestPathVenueId;
    }

    private String getNearestVenueWithSameSport(Map<Double, String> distanceMap, String sport) {
        TreeMap<Double, String> sortedDistanceMap = new TreeMap<>();
        sortedDistanceMap.putAll(distanceMap);
        boolean isSportAvailable;
        for (Map.Entry<Double, String> entry : sortedDistanceMap.entrySet()) {
            if(entry.getKey() != 0.0) {
                isSportAvailable = nearestVenueLocationDao.getSportAvailabilityAtNearestVenue(entry.getValue(), sport);
                if(isSportAvailable) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public double getDistanceBetweenTwoVenues(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.609344;
            return (dist);
        }
    }

}
