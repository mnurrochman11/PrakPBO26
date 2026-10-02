package Jobsheet4.src;

public class MainPercobaan4 {
    public static void main(String[] args) {
        Penumpang p = new Penumpang("12345", "Mr. Krab");
        Gerbong gerbong = new Gerbong("A", 10);
        gerbong.setPenumpang(p, 1);
        
        // Pengujian penimpaan penumpang (Pertanyaan Percobaan 4 No. 4 & 5)
        Penumpang budi = new Penumpang("67890", "Budi");
        gerbong.setPenumpang(budi, 1);

        System.out.println(gerbong.info());
    }
}
