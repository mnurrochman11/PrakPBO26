# LAPORAN PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK

## JOBSHEET 9: ABSTRACT CLASS DAN INTERFACE

**Nama** : Muhammad Nur Rochman  
**Kelas** : TI-2G  
**NIM** : 254107020121 
**Jurusan** : Teknologi Informasi - Politeknik Negeri Malang  

---

## 1. Percobaan 1 - Abstract Class

### 1.1 Penjelasan Kode Program
Pada percobaan pertama dibuat package `abstractclass` yang berisi abstract class `Hewan`, dua subclass konkret yaitu `Kucing` dan `Ikan`, class `Orang` yang memiliki relasi asosiasi dengan `Hewan`, serta class utama `Program`. Class `Hewan` mendefinisikan method abstrak `bergerak()` tanpa implementasi tubuh method sehingga setiap class turunannya wajib mendefinisikan cara bergeraknya masing-masing.

### 1.2 Capture Kode & Output Program
*(Tempelkan screenshot kode `Hewan.java`, `Kucing.java`, `Ikan.java`, `Orang.java`, `Program.java`, serta hasil output terminal di sini)*

### 1.3 Jawaban Pertanyaan Percobaan 1

1. **Jelaskan jalannya program di atas. Mengapa pemanggilan `this.hewanPeliharaan.bergerak()` di class `Orang` menghasilkan output yang berbeda untuk Ani dan Budi?**  
   Program membuat objek `Kucing` (`kucingKampung`) dan `Ikan` (`lumbaLumba`), lalu mengaitkannya ke objek `Orang` melalui method `peliharaHewan(Hewan hewan)`. Pemanggilan `this.hewanPeliharaan.bergerak()` menghasilkan output berbeda karena menerapkan mekanisme *dynamic polymorphism* (late binding). Pada objek `ani`, atribut `hewanPeliharaan` merujuk pada instance `Kucing` sehingga method `bergerak()` milik `Kucing` yang dieksekusi, sedangkan pada `budi` atribut tersebut merujuk pada instance `Ikan` sehingga method `bergerak()` milik `Ikan` yang dieksekusi.

2. **Tambahkan baris `Hewan hewan = new Hewan();` pada method `main()`. Tunjukkan hasil kompilasinya dan jelaskan secara singkat.**  
   Hasil kompilasi memunculkan error:
   ```text
   Hewan is abstract; cannot be instantiated
   ```
   Hal ini terjadi karena `Hewan` dideklarasikan sebagai `abstract class`. Sesuai aturan PBO di Java, abstract class bersifat belum lengkap (abstrak) sehingga tidak dapat dibuat objeknya secara langsung menggunakan keyword `new`.

3. **Bolehkah sebuah class yang meng-extend abstract class tidak mengimplementasikan abstract method induknya? Buktikan dengan menghapus method `bergerak()` dari class `Ikan`, lalu tunjukkan hasil kompilasinya dan jelaskan.**  
   Tidak boleh, kecuali class turunan tersebut juga dideklarasikan sebagai `abstract`. Ketika method `bergerak()` dihapus dari `Ikan`, muncul pesan error kompilasi:
   ```text
   Ikan is not abstract and does not override abstract method bergerak() in Hewan
   ```
   Karena `Ikan` adalah class konkret (bukan abstract), `Ikan` wajib meng-override dan mengimplementasikan seluruh abstract method yang diwariskan dari superclass `Hewan`.

4. **Tambahkan abstract method `public abstract void bernapas();` di dalam class `Ikan` tanpa mengubah deklarasi class `Ikan`. Tunjukkan hasil kompilasinya dan jelaskan aturan yang dilanggar.**  
   Hasil kompilasi memunculkan pesan error:
   ```text
   Ikan is not abstract and does not override abstract method bernapas() in Ikan
   ```
   Aturan yang dilanggar adalah sebuah class yang memiliki minimal satu `abstract method` wajib dideklarasikan sebagai `abstract class`. Class konkret tidak diperbolehkan memiliki method tanpa body.

---

## 2. Percobaan 2 - Interface

### 2.1 Penjelasan Kode Program
Pada percobaan kedua dibuat package `interfacelatihan` yang berisi interface `ICumlaude` sebagai kontrak kelulusan predikat cumlaude (`lulus()` dan `meraihIPKTinggi()`). Class `Mahasiswa` bertindak sebagai superclass, sedangkan `Sarjana` dan `Pascasarjana` mewarisi `Mahasiswa` sekaligus mengimplementasikan `ICumlaude`. Class `Rektor` memiliki method `beriSertifikatCumlaude(ICumlaude mahasiswaCumlaude)` yang menerima parameter bertipe interface.

### 2.2 Capture Kode & Output Program
*(Tempelkan screenshot kode `ICumlaude.java`, `Mahasiswa.java`, `Sarjana.java`, `Pascasarjana.java`, `Rektor.java`, `Program.java`, serta output program)*

### 2.3 Jawaban Pertanyaan Percobaan 2

1. **Mengapa pada langkah 7 terjadi error? Tuliskan pesan error-nya dan jelaskan bagaimana Anda memperbaikinya.**  
   Error terjadi pada baris `pakRektor.beriSertifikatCumlaude(mhsBiasa);` dengan pesan:
   ```text
   incompatible types: Mahasiswa cannot be converted to ICumlaude
   ```
   Penyebabnya adalah parameter `beriSertifikatCumlaude()` membutuhkan tipe `ICumlaude`, sedangkan `mhsBiasa` bertipe `Mahasiswa` yang tidak mengimplementasikan interface `ICumlaude`. Perbaikannya dilakukan dengan menghapus atau mengomentari instansiasi `mhsBiasa` serta pemanggilan `pakRektor.beriSertifikatCumlaude(mhsBiasa);` pada `Program.java`.

2. **Dapatkah method `kuliahDiKampus()` dipanggil dari objek `sarjanaCumlaude` di class `Program`? Mengapa demikian?**  
   Dapat dipanggil (`sarjanaCumlaude.kuliahDiKampus();`). Hal ini karena variabel `sarjanaCumlaude` dideklarasikan dengan tipe referensi `Sarjana`, dan class `Sarjana` mewarisi (`extends`) method `public void kuliahDiKampus()` dari superclass `Mahasiswa`.

3. **Dapatkah method `kuliahDiKampus()` dipanggil dari parameter `mahasiswaCumlaude` di method `beriSertifikatCumlaude()` pada class `Rektor`? Mengapa demikian?**  
   Tidak dapat dipanggil secara langsung (`mahasiswaCumlaude.kuliahDiKampus()` akan menyebabkan error `cannot find symbol`). Parameter `mahasiswaCumlaude` menggunakan tipe referensi interface `ICumlaude`, sehingga compiler hanya mengenali method yang dideklarasikan di dalam kontrak `ICumlaude` saja (`lulus()` dan `meraihIPKTinggi()`), bukan method milik class `Mahasiswa`.

4. **Hapus kata kunci `public` pada method `lulus()` di class `Sarjana`. Tunjukkan hasil kompilasinya dan jelaskan, lalu kembalikan seperti semula.**  
   Muncul pesan error kompilasi:
   ```text
   lulus() in Sarjana cannot implement lulus() in ICumlaude
   attempting to assign weaker access privileges; was public
   ```
   Seluruh method di dalam interface secara implisit memiliki hak akses `public abstract`. Saat diimplementasikan pada class, access modifier-nya tidak boleh dipersempit menjadi default (package-private), sehingga wajib tetap `public`.

---

## 3. Percobaan 3 - Multiple Interface

### 3.1 Penjelasan Kode Program
Percobaan ketiga menambahkan interface `IBerprestasi` untuk mendemonstrasikan kemampuan sebuah class mengimplementasikan lebih dari satu interface (*multiple interface*). Pada awalnya `Pascasarjana` mengimplementasikan `ICumlaude, IBerprestasi`, kemudian pada tahap modifikasi tugas percobaan, `Sarjana` juga mengimplementasikan kedua interface tersebut dengan pencapaian kompetisi dan jurnal tingkat nasional.

### 3.2 Capture Kode & Output Program
*(Tempelkan screenshot kode `IBerprestasi.java`, perubahan pada `Sarjana.java`, `Pascasarjana.java`, `Rektor.java`, `Program.java`, serta hasil output)*

### 3.3 Jawaban Pertanyaan Percobaan 3

1. **Pada interface `IBerprestasi`, ganti modifier `public` pada method `menjuaraiKompetisi()` menjadi `protected` dan pada method `membuatPublikasiIlmiah()` menjadi `private`. Apa yang terjadi? Jelaskan alasannya.**  
   Program gagal dikompilasi dan memunculkan pesan error:
   ```text
   modifier protected not allowed here
   modifier private not allowed here
   ```
   Alasannya karena interface berfungsi sebagai kontrak publik antar-class. Oleh karena itu, Java melarang penggunaan modifier `protected` maupun `private` pada deklarasi method di dalam interface; semua method kontrak hanya diizinkan bersifat `public`.

2. **Tambahkan baris `IBerprestasi prestasi = new IBerprestasi();` pada method `main()`. Mengapa baris tersebut error?**  
   Baris tersebut menghasilkan error `IBerprestasi is abstract; cannot be instantiated`. Sama seperti abstract class, interface tidak memiliki constructor maupun implementasi method konkret sehingga tidak dapat diinstansiasi secara langsung menjadi objek menggunakan operator `new`.

3. **Modifikasi class terkait agar `pakRektor` dapat memberikan sertifikat mawapres kepada `sarjanaCumlaude` (tingkat NASIONAL) dan `masterCumlaude` (tingkat INTERNASIONAL).**  
   Class `Sarjana` dimodifikasi menjadi `public class Sarjana extends Mahasiswa implements ICumlaude, IBerprestasi` serta meng-override method `menjuaraiKompetisi()` dan `membuatPublikasiIlmiah()` dengan output `NASIONAL`.

---

## 4. Tugas Praktikum

### 4.1 UML Class Diagram Sistem
```text
                   +------------------------------------------+
                   |              <<abstract>>                |
                   |                Binatang                  |
                   +------------------------------------------+
                   | # nama: String                           |
                   | # jmlKaki: int                           |
                   +------------------------------------------+
                   | + Binatang(nama: String, jmlKaki: int)   |
                   | + setNama(nama: String): void            |
                   | + getNama(): String                      |
                   | + setKaki(jmlKaki: int): void            |
                   | + getKaki(): int                         |
                   | + displayBinatang(): void                |
                   +------------------------------------------+
                                        ^
               +------------------------+------------------------+
               |                        |                        |
+-----------------------------+ +-----------------------------+ +-----------------------------+
|            Singa            | |           Gorilla           | |           Keledai           |
+-----------------------------+ +-----------------------------+ +-----------------------------+
| - suara: String             | | - suara: String             | | - suara: String             |
| - warnaBulu: String         | | - warnaBulu: String         | | - warnaBulu: String         |
+-----------------------------+ +-----------------------------+ +-----------------------------+
| + Singa(...)                | | + Gorilla(...)              | | + Keledai(...)              |
| + displayMakan(): void      | | + displayMakan(): void      | | + displayMakan(): void      |
| + displayBinatang(): void   | | + displayBinatang(): void   | | + displayBinatang(): void   |
| + displayData(): void       | | + displayData(): void       | | + displayData(): void       |
+-----------------------------+ +-----------------------------+ +-----------------------------+
       |                               |               |                               |
       | <<implements>>                | <<implements>>| <<implements>>                | <<implements>>
       v                               v               v                               v
+-----------------------------+                        +-----------------------------+
|        <<interface>>        |                        +        <<interface>>        |
|         IKarnivora          |                        |         IHerbivora          |
+-----------------------------+                        +-----------------------------+
| + displayMakan(): void      |                        | + displayMakan(): void      |
+-----------------------------+                        +-----------------------------+
```

### 4.2 Penjelasan Implementasi Tugas
Pada package `tugas`, dibuat abstract class `Binatang` sebagai induk yang menyimpan atribut umum `nama` dan `jmlKaki` serta deklarasi `displayBinatang()`. Dua interface `IKarnivora` dan `IHerbivora` masing-masing mendeklarasikan kontrak `displayMakan()`. Class `Singa` mewarisi `Binatang` dan mengimplementasikan `IKarnivora`, class `Keledai` mewarisi `Binatang` dan mengimplementasikan `IHerbivora`, sedangkan `Gorilla` mewarisi `Binatang` dan mengimplementasikan kedua interface (`IKarnivora, IHerbivora`) sekaligus karena bersifat omnivora.

### 4.3 Capture Kode & Output Tugas
*(Tempelkan screenshot seluruh file pada package `tugas` beserta output hasil eksekusi `ProgramTugas.java` di sini)*
