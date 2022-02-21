import java.time.LocalDate;

public class Tijdschrift  extends Product{
    private LocalDate datum;
    public Tijdschrift(String naam, double prijs, LocalDate datum)
    {super(naam, prijs);
        if(datum == null || datum.isAfter(LocalDate.now()))
            throw new IllegalArgumentException();
        this.datum = datum ;
    }

    @Override
    public String format() {
        return super.format() + " en datum "+datum.toString();
    }
}
