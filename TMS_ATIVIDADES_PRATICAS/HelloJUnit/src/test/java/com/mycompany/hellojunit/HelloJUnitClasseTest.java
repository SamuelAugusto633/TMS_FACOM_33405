/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.hellojunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
public class HelloJUnitClasseTest {
    
    public HelloJUnitClasseTest() {
    }

    @Test
    public void testSomeMethod() {
        
        HelloJUnitClasse hello = new HelloJUnitClasse();
        assertEquals("Hello, World of Tests!", hello.sayHello());
    
    }
    
}

