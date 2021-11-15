package ba.unsa.etf.rpr.tutorijal5.util;
import ba.unsa.etf.rpr.tutorijal5.Korisnik;
import java.util.List;
import java.util.stream.Stream;

public class Kredit {
    public Double dajKreditnuSposobnost(KreditnaSposobnost ks, Korisnik k) {
        return ks.provjeri(k.getRacun());
    }

    public void bezPrekoracenja(List<Korisnik> korisnici) {
        Stream<Korisnik> stream = korisnici.stream();
        stream.filter(k -> k.getRacun().getStanjeRacuna() >= 0).forEach(System.out::println);
    }

    public void odobriPrekoracenje(List<Korisnik> korisnici) {
        Korisnik k = new Korisnik();
        if (k.getRacun().getStanjeRacuna() >= 10000) {

        }
    }
}
