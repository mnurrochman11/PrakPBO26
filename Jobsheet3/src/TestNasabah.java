public class TestNasabah {
    public static void main(String[] args) {
        // Nasabah anton = new Nasabah();

        // anton.setNomorRekening("1123123");
        // anton.setNama("Anton Kemang"); 
        // anton.setor(10000);

        // System.out.println("Saldo " + anton.getNama() + " saat ini: Rp. " + anton.getSaldo());

        // anton.tarik(5000);

        // System.out.println("Saldo " + anton.getNama() + " saat ini: Rp. " + anton.getSaldo());

        // Nasabah nas = new Nasabah();
        // System.out.println("Nomor Rekening: " + nas.getNomorRekening());
        // System.out.println("Nama: " + nas.getNama());
        // System.out.println("Saldo: " + nas.getSaldo()); 

        Nasabah nas = new Nasabah("11556677", "Nicola Tesla", 900000);
        System.out.println("Nomor Rekening: " + nas.getNomorRekening());
        System.out.println("Nama: " + nas.getNama());
        System.out.println("Saldo: " + nas.getSaldo());
    }
}
