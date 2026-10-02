package Jobsheet4.src;

public class Mobilp5 {
    private String merek;
    private Mesin mesin;

    public Mobilp5(String merek) {
        this.merek = merek;
        this.mesin = new Mesin();
    }

    public void tampilkanInfo() {
        System.out.println("Mobil: " + merek);
        System.out.println("Mesin: " + mesin.getTipe());
    }
}
