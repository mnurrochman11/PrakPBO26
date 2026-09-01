package Jobsheet1;

public class MesinCuci {
    private String merek;
    private int kapasitasKg;

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitasKg = kapasitas;
    }

    public void printInfo() {
        System.out.println("--- Info Mesin Cuci ---");
        System.out.println("Merek: " + merek);
        System.out.println("Kapasitas: " + kapasitasKg + " Kg");
    }
}