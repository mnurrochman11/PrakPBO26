package Jobsheet4.src;

public class Laptopp6 {
    private String merk;

    public Laptopp6(String merk) {
        this.merk = merk;
    }

    public void cetakDokumen(Printer printer, String namaFile) {
        System.out.println(merk + " mengirim dokumen ke printer...");
        printer.cetak(namaFile);
    }
}
