package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    private Date plantedAt;
    private Location location;
    private List<Date> appraisalDates;

    public Tree(Date plantedAt, String locationLatitude, String locationLongitude, String locationName){
        this.plantedAt = plantedAt;
        this.location = new Location(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new ArrayList<>();
    }

    public Date getPlantedAt() {
        return plantedAt;
    }

    public String getLocationLatitude() {
        return location.getLatitude();
    }

    public String getLocationLongitude() {
        return location.getLongitude();
    }

    public String getLocationName() {
        return location.getName();
    }

    public void setLocation(String latitude, String longitude, String name) {
        location = new Location(latitude, longitude, name);
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + location.toString();
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    public Date getNextAppraisalDate(Date latestAppraisalDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        return calendar.getTime();
    }

    public Date getLatestAppraisalDate(Date today) {
        Date latestAppraisalDate = appraisalDates.size() > 0 ? appraisalDates.get(0) : today;

        for (Date appraisalDate : appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate))
                latestAppraisalDate = appraisalDate;
        }

        return latestAppraisalDate;
    }

    public boolean isNextAppraisalOverdue(){
        Date today = new Date();
        Date latestAppraisalDate = getLatestAppraisalDate(today);
        Date nextAppraisalDate = getNextAppraisalDate(latestAppraisalDate);
        return nextAppraisalDate.before(today);
    }
}
