package com.example.attestation.filters;
import com.example.attestation.model.Flight;
import com.example.attestation.model.Segment;

import java.util.ArrayList;
import java.util.List;
public class FlightFilterArrivalDateBeforeDepartureDate implements FlightFilter {
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<Flight>();
        for (Flight flight : flights) {
            if (isDatesCorrect(flight.getSegments()))
                result.add(flight);
        }
        return result;
    }

    private boolean isDatesCorrect(List<Segment> segments){
        for (Segment segment : segments) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                return false;
        }
        return true;
    }
}