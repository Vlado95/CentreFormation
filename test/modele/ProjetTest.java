/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Okito
 */
public class ProjetTest {
    
    public ProjetTest() {
    }

    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Projet instance;
        instance = new Projet(1,2,9,"lol","blalba",new SimpleDateFormat("yyyy-MM-dd").parse("2007-03-06"),new SimpleDateFormat("yyyy-MM-dd").parse("20-03-06"));
        instance.insert();
        assertEquals(4, instance.getId());
        Projet expected = Projet.getById(4);
        assertEquals(expected, instance);
    }

  /*  @Test
    public void testGetById() throws ParseException {
        System.out.println("getById");
        Projet expected = new Projet(1,2,9,"lol","blalba",new SimpleDateFormat("yyyy-MM-dd").parse("2007-03-06"),new SimpleDateFormat("yyyy-MM-dd").parse("20-03-06"));// avec les valeurs du 1
        Projet result = Projet.getById(1);
        assertEquals(expected, result);
    }*/
    
}
