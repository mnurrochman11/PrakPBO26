package tugas.Tugas2;

public class TelevisiModern extends Televisi {
    private String modeTampilan;
    private String dvd;

    public TelevisiModern(String merk, int jumlahChannel) {
        super(merk, jumlahChannel);
        this.modeTampilan = "";
        this.dvd = "";
    }

    public void gantiModusTampilan(String mode) {
        this.modeTampilan = mode;
    }

    public void masukkanDVD(String judul) {
        this.dvd = judul;
    }

    public void mainkanDVD() {
        if (dvd.equals("")) {
            System.out.println("Sedang memainkan DVD: kosong");
        } else {
            System.out.println("Sedang memainkan DVD: " + dvd);
        }
    }
}
