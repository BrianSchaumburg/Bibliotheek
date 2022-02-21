public class Product {
    private String titel;
    private double prijs;
    public Product(String titel, double prijs)
    {
        this.setTitel(titel);
        this.setPrijs(prijs);
    }
    private void setTitel(String titel)
        {
            if(titel.trim().isEmpty())
                throw new IllegalArgumentException();
            this.titel = titel;
        }
    private void setPrijs(double prijs)
    {
        if(prijs<0)
            throw new IllegalArgumentException();
        this.prijs = prijs;
    }

    public String getTitel() {
        return titel;
    }

    public double getPrijs() {
        return prijs;
    }
    public String format()
    {
        String result = ""  ;
        result+=titel + " heeft een prijs van:  " +prijs;
        return result;

    }
}
