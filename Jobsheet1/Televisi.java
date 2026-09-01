package Jobsheet1;

public class Televisi {
    private String merek;
    private int ukuranLayar; 

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setUkuranLayar(int ukuran) {
        this.ukuranLayar = ukuran;
    }

    public void printInfo() {
        System.out.println("--- Info Televisi ---");
        System.out.println("Merek: " + merek);
        System.out.println("Ukuran Layar: " + ukuranLayar + " inch");
    }
}