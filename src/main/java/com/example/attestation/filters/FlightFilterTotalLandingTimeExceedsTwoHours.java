package com.example.attestation.filters;
import com.example.attestation.model.Flight;
import com.example.attestation.model.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class FlightFilterTotalLandingTimeExceedsTwoHours implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (checkTimeOnEarth(flight.getSegments())) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    private boolean checkTimeOnEarth(List<Segment> segments) {
        if (segments.size() == 1) {
            return true;
        }
        int allTimeOnEarth = 0;
        Segment prevSegment = null;
        for (Segment segment : segments) {
            if (prevSegment != null) {
                allTimeOnEarth += timeOnEarth(prevSegment.getArrivalDate(), segment.getDepartureDate());
            }
            prevSegment = segment;
        }
        int hoursOnEarth = 2;
        return allTimeOnEarth <= hoursOnEarth;
    }

    private int timeOnEarth(LocalDateTime arr, LocalDateTime dep) {
        return (int) ChronoUnit.HOURS.between(arr, dep);
    }
}