package Jobsheet4.src;

public class DetailPeminjaman {
    private Buku buku;
    private int lamaHari;

    public DetailPeminjaman(Buku buku, int lamaHari) {
        this.buku = buku;
        this.lamaHari = lamaHari;
    }

    public int hitungBiaya() {
        return buku.getBiayaSewa() * lamaHari;
    }

    public String info() {
        return buku.info()
                + "\nLama Peminjaman: " + lamaHari + " hari"
                + "\nTotal Biaya: Rp" + hitungBiaya();
    }
}
