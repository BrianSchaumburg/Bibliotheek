import javax.swing.plaf.ProgressBarUI;
import java.util.ArrayList;
import java.util.List;

public class Bib {
    private List<Product> assortiment;
    public Bib()
    {
        assortiment = new ArrayList<>();

    }
    public int getVoorraad()
    {
        return assortiment.size();
    }
    public void voegToe(Product e)
    {
        if(e == null)
        {
            throw new IllegalArgumentException();
        }
        assortiment.add(e);
    }
    public void verkoop(Product e)
    {   int lengte = assortiment.size();
        if(e == null)
            throw new IllegalArgumentException();
        String naam = e.getTitel();
        for(Product x: assortiment)
            if(x.getTitel() == naam) {
                assortiment.remove(x); break;
            }
        if(lengte == assortiment.size()) throw new IllegalStateException("Er is niets verwijderd");
    }
    public int getVoorraad(String object)

    {int count =0;
        if(object == null)
            throw new IllegalArgumentException();
        if(object.equals("Boek"))
        {
            for(Product e: assortiment)
            {
                if(e instanceof Boek) count++;
            }
        }
        else if(object.equals("Tijdschrift"))
        {
            for(Product e: assortiment)
            {
                if(e instanceof Tijdschrift)count++;
            }
        }
        else
            throw new IllegalArgumentException();
        return count;
    }
    public String format()
    {
        String res = "" ;
        for(Product e: assortiment)
        {
            res+=e.format() + "\n";
        }
        return res;
    }
}
