package Jobsheet4.src;

public class Buku {
    private String kodeBuku;
    private String judul;
    private int biayaSewa;

    public Buku(String kodeBuku, String judul, int biayaSewa) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.biayaSewa = biayaSewa;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public String getJudul() {
        return judul;
    }

    public int getBiayaSewa() {
        return biayaSewa;
    }

    public String info() {
        return "Kode Buku: " + kodeBuku
                + "\nJudul Buku: " + judul
                + "\nBiaya Sewa per Hari: Rp" + biayaSewa;
    }
}
