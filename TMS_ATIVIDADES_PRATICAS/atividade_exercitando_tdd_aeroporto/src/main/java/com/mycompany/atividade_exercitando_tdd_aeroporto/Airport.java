/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_exercitando_tdd_aeroporto;

/**
 *
 * @author Samuel
 */


import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Flight> flights;

    public Airport() {
        this.flights = new ArrayList<>();
    }


    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }

   
    public List<Flight> getAllFlights() {
        return flights;
    }

 
    public Flight getFlightById(String id) {
        return flights.stream()
                .filter(flight -> flight.getId().equals(id))
                .findFirst()
                .orElse(null);  // null se não encontrar o voo
    }
}
