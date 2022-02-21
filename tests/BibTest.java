import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BibTest {
    Bib bib;
    Boek boek;
    Tijdschrift tijdschrift;
    @Before
    public void setBefore()
    {
        bib = new Bib();
        boek = new Boek("eerste titel",2,2  );
        tijdschrift = new Tijdschrift("eerste titel", 3, LocalDate.of(2021,9,1));
    }
    @Test
    public void test_voegToe_met_2_geldige_objecten()
    {
        bib.voegToe(boek);
        bib.voegToe(tijdschrift);
        assertEquals(bib.getVoorraad(),2);
    }
    @Test
    public void test_verkoop_voorraad_daalt_met_1()
    {   test_voegToe_met_2_geldige_objecten();
        bib.verkoop(boek);
        assertEquals(bib.getVoorraad(),1);
    }
    @Test
    public void test_getVoorraad_met_objecttype_boek_berekent_aantal()
    {
        test_voegToe_met_2_geldige_objecten();
        bib.voegToe(boek);
        assertEquals(bib.getVoorraad("Boek"),2);
    }
    @Test
    public void test_getVoorraad_met_objecttype_tijdschrift_berekent_aantal()
    {
        test_voegToe_met_2_geldige_objecten();
        bib.voegToe(tijdschrift);
        assertEquals(bib.getVoorraad("Tijdschrift"),2);
    }
    //errorcases
    @Test(expected = IllegalArgumentException.class)
    public void voeg_toe_met_leeg_object_gooit_exception()
    {
        bib.voegToe(null);
    }
    @Test(expected = IllegalStateException.class)
    public void test_verkoop_met_onbestaand_object_gooit_exception()
    {
        bib.verkoop(new Boek("test",2,1));

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_verkoop_met_leeg_object_gooit_exception()
    {
        bib.verkoop(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_getVoorraad_met_leeg_object_gooit_exception()
    {
        bib.getVoorraad(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_getVoorraad_met_onbestaand_type_gooit_exception()
    {
        bib.getVoorraad("Boekjes");
    }
    @Test
    public void testWeergave()
    {   bib.voegToe(boek);
        bib.voegToe(tijdschrift);
        System.out.println(bib.format());
    }
}