package Jobsheet4.src;

public class Anggota {
    private String nomorAnggota;
    private String nama;

    public Anggota(String nomorAnggota, String nama) {
        this.nomorAnggota = nomorAnggota;
        this.nama = nama;
    }

    public String getNomorAnggota() {
        return nomorAnggota;
    }

    public String getNama() {
        return nama;
    }

    public String info() {
        return "Nomor Anggota: " + nomorAnggota
                + "\nNama Anggota: " + nama;
    }
}
