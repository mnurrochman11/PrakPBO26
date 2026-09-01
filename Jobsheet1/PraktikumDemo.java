package Jobsheet1;

public class PraktikumDemo {
    public static void main(String[] args) {
        MesinCuci mesinCuciku = new MesinCuci();
        Televisi tvKu = new Televisi();
        Jam jamUmum = new Jam();
        JamDinding jamDindingKamar = new JamDinding();
        JamTangan jamTanganKu = new JamTangan();

        mesinCuciku.setMerek("Samsung");
        mesinCuciku.setKapasitas(9);
        mesinCuciku.printInfo();
        System.out.println();

        tvKu.setMerek("Polytron");
        tvKu.setUkuranLayar(32);
        tvKu.printInfo();
        System.out.println();

        System.out.println("--- Info Jam (Parent) ---");
        jamUmum.setMerek("Alba");
        jamUmum.setJenis("Analog");
        jamUmum.printInfo();
        System.out.println();

        System.out.println("--- Info Jam Dinding ---");
        jamDindingKamar.setMerek("Seiko");
        jamDindingKamar.setJenis("Analog");
        jamDindingKamar.setBentukBingkai("Bulat");
        jamDindingKamar.setDiameter(30);
        jamDindingKamar.printInfo();
        System.out.println();

        System.out.println("--- Info Jam Tangan ---");
        jamTanganKu.setMerek("Casio");
        jamTanganKu.setJenis("Digital");
        jamTanganKu.setBahanTali("Karet / Rubber");
        jamTanganKu.setTahanAir(true);
        jamTanganKu.printInfo();
    }
}