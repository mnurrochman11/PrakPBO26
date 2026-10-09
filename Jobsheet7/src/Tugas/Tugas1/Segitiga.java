package Tugas.Tugas1;

public class Segitiga {
    private int sudut;

    public int sisaSudut(int sudutA) {
        validasiSudut(sudutA);
        sudut = 180 - sudutA;
        return sudut;
    }

    public int sisaSudut(int sudutA, int sudutB) {
        int jumlah = sudutA + sudutB;
        validasiSudut(jumlah);
        sudut = 180 - jumlah;
        return sudut;
    }

    private void validasiSudut(int jumlah) {
        if (jumlah <= 0 || jumlah >= 180) {
            throw new IllegalArgumentException("Jumlah sudut harus lebih dari 0 dan kurang dari 180");
        }
    }

    public int getSudut() {
        return sudut;
    }

    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    public double keliling(int sisiA, int sisiB) {
        return sisiA + sisiB + Math.sqrt(sisiA * sisiA + sisiB * sisiB);
    }
}
