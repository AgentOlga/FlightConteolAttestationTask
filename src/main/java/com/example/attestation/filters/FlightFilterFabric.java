package com.example.attestation.filters;
import com.example.attestation.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterFabric {
    private final List<FlightFilter> filters;

    public FlightFilterFabric(List<FlightFilter> filters) {
        this.filters = filters;
    }

    public List<Flight> doFilter(List<Flight> flights) {
        List<Flight> filterList = new ArrayList<>(flights);

        for(FlightFilter filter : filters){
            filterList = filter.filter(filterList);
        }

        return filterList;
    }

}
