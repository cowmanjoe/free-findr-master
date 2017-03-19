package com.example.jasonjinsooyoo.freefindr.Utilities;

/**
 * Created by Alec on 2017-03-19.
 */

public class Geometry {
    private static final int RADIUS = 6371000;   // radius of earth in metres

    public static double distance(double lat1, double lon1, double lat2, double lon2)  {
        double templat1 = lat1*Math.PI/180;
        double templat2 = lat2*Math.PI/180;
        double deltaLat = (lat2-lat1)*Math.PI/180;
        double deltaLon = (lon2-lon1)*Math.PI/180;

        double a = Math.sin(deltaLat / 2.0) * Math.sin(deltaLat / 2.0)
                + Math.cos(templat1) * Math.cos(templat2)
                * Math.sin(deltaLon / 2.0) * Math.sin(deltaLon / 2.0);
        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIUS*c;
    }
}
