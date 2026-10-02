package Jobsheet4.src;

public class Peminjaman {
    private Anggota anggota;
    private DetailPeminjaman detail;

    public Peminjaman(Anggota anggota, Buku buku, int lamaHari) {
        this.anggota = anggota;
        this.detail = new DetailPeminjaman(buku, lamaHari);
    }

    public String info() {
        return anggota.info()
                + "\n\n" + detail.info();
    }

    public void cetakBukti(PrinterBukti printer) {
        printer.cetak(info());
    }
}
