package com.example.attestation;

import com.example.attestation.filters.*;

import com.example.attestation.model.Flight;
import com.example.attestation.model.FlightBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("All flights (" + flightList.size() + "):");
        flightList.forEach(System.out::println);
        System.out.println();


        FlightFilter filter1 = new FlightFilterUpToTheCurrentTime();
        List<Flight> flights1 = filter1.filter(flightList);
        System.out.println("Flights after the current time (" + flights1.size() + "):");
        flights1.forEach(System.out::println);
        System.out.println();

        FlightFilter filter2 = (FlightFilter) new FlightFilterArrivalDateBeforeDepartureDate();
        List<Flight> flights2 = filter2.filter(flightList);
        System.out.println("Flights with correct dates (" + flights2.size() + "):");
        flights2.forEach(System.out::println);
        System.out.println();

        FlightFilter filter3 = new FlightFilterTotalLandingTimeExceedsTwoHours();
        List<Flight> flights3 = filter3.filter(flightList);
        System.out.println("Flights with with more than two hours ground time (" + flights3.size() + "):");
        flights3.forEach(System.out::println);
        System.out.println();

        FlightFilterFabric filterFabric = new FlightFilterFabric(Arrays.asList(
                filter1,
                filter2,
                filter3
        ));

        filterFabric.doFilter(flightList).forEach(System.out::println);
    }
}
