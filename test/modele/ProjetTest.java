/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
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
         String strDate = "2011-12-31 00:00:00";
       
                /*
                 * To convert String to java.sql.Date, use
                 * Date (long date) constructor.
                 *
                 * It creates java.sql.Date object from the milliseconds provided.
                 */
       
                //first convert string to java.util.Date object using SimpleDateFormat
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                java.util.Date date = sdf.parse(strDate);
                java.util.Date date2 = sdf.parse("2017-03-06 00:00:00");
                java.sql.Date date_creation = new Date(date.getTime());
                java.sql.Date date_limite = new Date(date2.getTime());
        
        System.out.println("insert");
        Projet instance;
        instance = new Projet(4,2,9,"lol","blalba",date_creation, date_limite);
        instance.insert();
        assertEquals(4, instance.getId());
       // Projet expected = Projet.getById(4);
       // assertEquals(expected, instance);
    }

  /*  @Test
    public void testGetById() throws ParseException {
        System.out.println("getById");
        Projet expected = new Projet(1,2,9,"lol","blalba",new SimpleDateFormat("yyyy-MM-dd").parse("2007-03-06"),new SimpleDateFormat("yyyy-MM-dd").parse("20-03-06"));// avec les valeurs du 1
        Projet result = Projet.getById(1);
        assertEquals(expected, result);
    }*/
    
}
