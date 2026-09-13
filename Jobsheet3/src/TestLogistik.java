import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        // Kontainer kontainerAlfa = new Kontainer("REQ-9988", "PT. Maju Bersama", 5000);

        // System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
        // System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal() + " kg");

        // System.out.println("\nMemasukkan muatan baru seberat 6.000 kg...");
        // kontainerAlfa.tambahMuatan(6000);
        // System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        // System.out.println("\nMemasukkan muatan baru seberat 4.000 kg...");
        // kontainerAlfa.tambahMuatan(4000);
        // System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        // System.out.println("\nMembongkar muat/menurunkan barang seberat 500 kg...");
        // kontainerAlfa.turunkanMuatan(500);
        // System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        // System.out.println("\nMembongkar muat/menurunkan barang seberat 1.500 kg...");
        // kontainerAlfa.turunkanMuatan(1500);
        // System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        Scanner sc = new Scanner(System.in);

        Kontainer kontainerAlfa = new Kontainer("REQ-9988", "PT. Maju Bersama", 5000);

        System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal() + " kg");

        System.out.print("\nMasukkan muatan baru (kg): ");
        double muatanMasuk = sc.nextDouble();
        kontainerAlfa.tambahMuatan(muatanMasuk);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        System.out.print("\nMasukkan berat barang yang akan diturunkan (kg): ");
        double muatanKeluar = sc.nextDouble();
        kontainerAlfa.turunkanMuatan(muatanKeluar);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        sc.close();
    }
}