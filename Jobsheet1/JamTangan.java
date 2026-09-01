package Jobsheet1;

public class JamTangan extends Jam {
    private String bahanTali;
    private boolean tahanAir;

    public void setBahanTali(String bahan) {
        this.bahanTali = bahan;
    }

    public void setTahanAir(boolean statusAir) {
        this.tahanAir = statusAir;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Bahan Tali: " + bahanTali);
        System.out.println("Tahan Air: " + (tahanAir ? "Ya" : "Tidak"));
    }
}