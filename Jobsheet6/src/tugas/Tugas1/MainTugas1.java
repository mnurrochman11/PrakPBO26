package tugas.Tugas1;

public class MainTugas1 {
    public static void main(String[] args) {
        Pegawai p = new Pegawai("P001", "Budi", "Malang");

        Dosen d = new Dosen("D001", "Siti", "Surabaya");
        d.setSKS(12);

        DaftarGaji daftar = new DaftarGaji(10);

        daftar.addPegawai(p);
        daftar.addPegawai(d);

        daftar.printSemuaGaji();
    }   
}
