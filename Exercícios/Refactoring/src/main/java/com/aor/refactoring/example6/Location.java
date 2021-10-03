package com.aor.refactoring.example6;

public class Location {
    private String Latitude;
    private String Longitude;
    private String Name;


    public Location(String latitude, String longitude, String name) {
        Latitude = latitude;
        Longitude = longitude;
        Name = name;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getName() {
        return Name;
    }

    public String toString() {
        return Latitude + "," + Longitude + " (" + Name + ")";
    }
}
