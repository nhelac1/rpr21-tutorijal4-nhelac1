package ba.unsa.etf.rpr.tutorijal5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {
    Racun r;

    @BeforeEach
    void setUp() {
        Korisnik k = new Korisnik("Mujo", "Suljić");
        r = new Racun(1L, k);
        k.dodajRacun(r);
    }

    @Test
    void izvrsiUplatu() {
        r.izvrsiUplatu(100.0);
        assertEquals(100.0, r.getStanjeRacuna());
        r.izvrsiUplatu(50.0);
        assertEquals(150.0, r.getStanjeRacuna());
    }

    @Test
    void izvrsiIsplatu() {
        assertFalse(r.izvrsiIsplatu(100.0));
        r.izvrsiUplatu(100.0);
        assertTrue(r.izvrsiIsplatu(50.0));
        assertEquals(50.0, r.getStanjeRacuna());
        assertTrue(r.izvrsiIsplatu(500.0)); //stanje racuna je 100, prekoracenje 100, test pada
    }

    @Test
    void odobriPrekoracenje() {
        r.odobriPrekoracenje(100.0);
        assertTrue(r.izvrsiIsplatu(100.0));
        assertEquals(-100.0, r.getStanjeRacuna());
    }

    @Test
    void provjeriOdobrenjePrekoracenja() {
        r.odobriPrekoracenje(100.0);
        assertTrue(r.provjeriOdobrenjePrekoracenja(50.0));
        assertTrue(r.provjeriOdobrenjePrekoracenja(100.0));
        assertTrue(r.provjeriOdobrenjePrekoracenja(101.0)); //test za veci unos od prekoracenja u tom slucaju pada
    }

}