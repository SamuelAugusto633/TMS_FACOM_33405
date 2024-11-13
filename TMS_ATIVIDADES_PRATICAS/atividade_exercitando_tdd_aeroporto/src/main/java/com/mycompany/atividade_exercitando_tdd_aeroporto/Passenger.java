/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_exercitando_tdd_aeroporto;

/**
 *
 * @author Samuel
 */




public class Passenger {

    private String name;
    private boolean isVip;

    public Passenger(String name, boolean isVip) {
        this.name = name;
        this.isVip = isVip;
    }

    public String getName() {
        return name;
    }

    public boolean isVip() {
        return isVip;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passenger passenger = (Passenger) obj;
        return name.equals(passenger.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
