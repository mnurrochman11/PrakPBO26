package Jobsheet1;

public class Jam {
    private String merek;
    private String jenis;

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void printInfo() {
        System.out.println("Merek Jam: " + merek);
        System.out.println("Jenis Jam: " + jenis);
    }
}