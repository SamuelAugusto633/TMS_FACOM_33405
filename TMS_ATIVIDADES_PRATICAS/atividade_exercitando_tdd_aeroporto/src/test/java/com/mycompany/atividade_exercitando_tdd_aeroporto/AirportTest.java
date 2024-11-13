/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_exercitando_tdd_aeroporto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;



public class AirportTest {

    private Airport airport;
    private Flight economyFlight;
    private Passenger mike;
    private Passenger james;

    @BeforeEach
    void setUp() {
        airport = new Airport();
        economyFlight = new EconomyFlight("1", 2);  // Limite de 2 passageiros
        mike = new Passenger("Mike", false);
        james = new Passenger("James", false);
    }

    @Test
    void testPassengerLimit() {
        // Adiciona dois passageiros, deve funcionar
        assertTrue(economyFlight.addPassenger(mike), "Mike deve ser adicionado ao voo");
        assertTrue(economyFlight.addPassenger(james), "James deve ser adicionado ao voo");

        // Tenta adicionar o terceiro passageiro, deve falhar
        Passenger sarah = new Passenger("Sarah", false);
        assertFalse(economyFlight.addPassenger(sarah), "Sarah não deve ser adicionada, limite de passageiros atingido");

        // Verifica que a lista de passageiros contém apenas Mike e James
        assertEquals(2, economyFlight.getPassengersList().size(), "Deve haver 2 passageiros no voo");
    }
}
