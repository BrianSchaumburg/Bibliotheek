public class Boek extends  Product {
    private int editie;
    public Boek(String naam, double prijs, int editie)
    {
    super(naam,prijs);
    setEditie(editie);
    }
    private void setEditie(int e)
    {
        if(e<0)
            throw new IllegalArgumentException();
        editie = e;
    }

    @Override
    public String format() {
        return super.format() +  " en editie"+editie;
    }
}
