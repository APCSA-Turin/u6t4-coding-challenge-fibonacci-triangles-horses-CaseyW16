package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestHorseBarn{
    @Test
    public void testHorseBarnConstructorAndGetStalls(){
        HorseBarn barn1 = new HorseBarn(5);
        Horse[] horses1 = barn1.getStalls();
        Horse[] expected = new Horse[5];
        assertArrayEquals(horses1,expected, "Did not initialize 5 empty stalls");


        Horse h1 = new Horse("Abe", 1100);
        Horse h2 = new Horse("Barb", 1200);
        Horse h3 = new Horse("Cathy", 1300);
        Horse[] horses = {h1, h2, null, h3};
        HorseBarn barn2 = new HorseBarn(horses);
        Horse[] horses2 = barn2.getStalls();
        assertArrayEquals(horses,horses2, "getStalls() did not return {abe,barb,null,cathy}");
    }


    public void testHorseBarnInfo(){
        HorseBarn barn1 = new HorseBarn(5);
        String expected =
        "Stall 0: empty\n"+
        "Stall 1: empty\n"+
        "Stall 2: empty\n"+
        "Stall 3: empty\n"+
        "Stall 4: empty\n";
        assertEquals(expected, barn1.horseBarnInfo());


       
        Horse h1 = new Horse("Abe", 1100);
        Horse h2 = new Horse("Barb", 1200);
        Horse h3 = new Horse("Cathy", 1300);
        Horse[] horses = {h1, h2, null, h3};
        HorseBarn barn2 = new HorseBarn(horses);
        expected =
        "Stall 0: name: Abe, weight: 1100\n"+
        "Stall 1: name: Barb, weight: 1200\n"+
        "Stall 2: empty\n"+
        "Stall 3: name: Cathy, weight: 1300\n";
        assertEquals(expected,barn2.horseBarnInfo());
    }


    @Test
    public void testPlaceHorseAndFindHorseStall(){
        HorseBarn barn1 = new HorseBarn(3);
        barn1.placeHorse(new Horse("Silver",1210), 2);
        barn1.placeHorse(new Horse("Trigger", 1340), 0);
        assertEquals(0,barn1.findHorseStall("Trigger"),"Trigger was not found at stall 0");
        assertEquals(2,barn1.findHorseStall("Silver"),"Silver was not found at stall 2");
        assertEquals(-1,barn1.findHorseStall("Lucy"),"Lucy horse was found in a stall but should not be present");  
    }


    @Test
    public void testConsolidate(){
        HorseBarn barn1 = new HorseBarn(6);
        Horse Trigger = new Horse("Trigger", 1340);
        Horse Silver = new Horse("Silver",1210) ;
        Horse Lucy = new Horse("Lucy",1500);
        Horse Cotton = new Horse("Cotton", 1555);
        barn1.placeHorse(Trigger, 0);
        barn1.placeHorse(Silver, 1);
        barn1.placeHorse(Lucy, 4);
        barn1.placeHorse(Cotton, 5);
        barn1.consolidate();
        Horse[] expected = new Horse[6];
        expected[0]= Trigger;
        expected[1] = Silver;
        expected[2] = Lucy;
        expected[3] = Cotton;
        assertArrayEquals(expected, barn1.getStalls());
    }


}
