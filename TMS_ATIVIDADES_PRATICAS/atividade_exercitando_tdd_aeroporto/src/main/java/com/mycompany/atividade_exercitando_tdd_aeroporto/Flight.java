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



import java.util.ArrayList;
import java.util.List;

public abstract class Flight {

    private String id;
    private int passengerLimit;  // Limite de passageiros
    private List<Passenger> passengersList;

    public Flight(String id, int passengerLimit) {
        this.id = id;
        this.passengerLimit = passengerLimit;
        this.passengersList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Passenger> getPassengersList() {
        return passengersList;
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengersList.size() < passengerLimit && !passengersList.contains(passenger)) {
            passengersList.add(passenger);
            return true;
        }
        return false;
    }

    public boolean removePassenger(Passenger passenger) {
        return passengersList.remove(passenger);
    }
}
