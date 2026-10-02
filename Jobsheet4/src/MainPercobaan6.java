package Jobsheet4.src;

public class MainPercobaan6 {
    public static void main(String[] args) {
        Laptopp6 laptop = new Laptopp6("Thinkpad");
        Printer printer = new Printer("Epson L3110");
        laptop.cetakDokumen(printer, "Laporan.pdf");
    }
}
