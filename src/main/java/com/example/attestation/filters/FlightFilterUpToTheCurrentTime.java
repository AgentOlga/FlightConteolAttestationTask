package com.example.attestation.filters;

import com.example.attestation.model.Flight;
import com.example.attestation.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class FlightFilterUpToTheCurrentTime implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<Flight>();
        for (Flight flight : flights) {
            if (isUpToTheCurrentTime(flight.getSegments()))
                result.add(flight);
        }
        return result;
    }

    private boolean isUpToTheCurrentTime(List<Segment> segments){
        LocalDateTime now = LocalDateTime.now();
        for (Segment segment : segments) {
            if (segment.getDepartureDate().isBefore(now))
                return false;
        }
        return true;
    }
}
