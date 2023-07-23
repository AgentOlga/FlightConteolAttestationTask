package com.example.attestation.filters;
import com.example.attestation.model.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filter(List<Flight> flights);

}
