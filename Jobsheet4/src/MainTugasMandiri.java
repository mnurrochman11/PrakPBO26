package Jobsheet4.src;

public class MainTugasMandiri {
    public static void main(String[] args) {
        Anggota anggota = new Anggota("A001", "Muhammad Nur Rochman");

        Buku buku = new Buku(
                "B001",
                "Pemrograman Berorientasi Objek",
                5000
        );

        Peminjaman peminjaman = new Peminjaman(anggota, buku, 3);

        PrinterBukti printer = new PrinterBukti();

        peminjaman.cetakBukti(printer);
    }
}
