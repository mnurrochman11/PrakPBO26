# Laporan Praktikum PrakPBO

- **Nama:** Muhammad Nur Rochman
- **NIM:** 254107020121
- **Kelas:** TI-2G

---

## Percobaan 1: Single Inheritance dengan extends

### Implementasi Program

**Kelas ClassA**

![Kode ClassA](images/p1ClassA.png)

**Kelas ClassB**

![Kode ClassB](images/p1ClassB.png)

**Kelas MainPercobaan1**

![Kode MainPercobaan1](images/p1MainPercobaan1.png)

### Hasil Percobaan

![Hasil Percobaan 1](images/p1Hasil.png)

### Jawaban Percobaan 1

**1.**

Kompilasi gagal karena `ClassB` belum menggunakan `extends ClassA`, sehingga atribut `x` dan `y` tidak dikenali. Error yang muncul adalah `cannot find symbol` pada `ClassB.java`.


**2.**

Kode yang diubah adalah:

`public class ClassB extends ClassA`

Artinya `ClassB` mewarisi `ClassA`. `ClassA` menjadi superclass, sedangkan `ClassB` menjadi subclass.


**3.**

Dari `ClassA`, objek `hitung` dapat menggunakan `x`, `y`, dan `getNilai()`.

Dari `ClassB`, objek `hitung` dapat menggunakan `z`, `getNilaiZ()`, dan `getJumlah()`.


**4.**

Karena `ClassB` merupakan turunan dari `ClassA`, sehingga atribut `x` dan `y` yang ada di `ClassA` dapat digunakan oleh `ClassB`.


**5.**

Nilai atribut bisa diubah langsung dari class lain. Hal ini membuat data lebih sulit dikontrol dan bisa diubah dengan nilai yang tidak sesuai.


**6.**

Akan terjadi error karena Java tidak mendukung pewarisan langsung dari dua superclass. Satu class hanya dapat memiliki satu superclass.

---

## Percobaan 2: Hak Akses pada Pewarisan

### Implementasi Program

**Kelas ClassA**

![Kode ClassA](images/p2ClassA.png)

**Kelas ClassB**

![Kode ClassB](images/p2ClassB.png)

**Kelas MainPercobaan2**

![Kode MainPercobaan2](images/p2MainPercobaan2.png)

### Hasil Percobaan

![Hasil Percobaan 2](images/p2Hasil.png)

### Jawaban Percobaan 2

**1.**

Error muncul di `ClassB.java` karena `x` dan `y` memiliki akses `private`. Error tidak muncul di `MainPercobaan2` karena yang digunakan adalah method `public`.


**2.**

Atribut `x` dan `y` menggunakan `private`, sehingga hanya dapat diakses langsung dari `ClassA`. `ClassB` tidak dapat mengaksesnya secara langsung.


**3.**

Karena `setX()` merupakan method `public`, sehingga dapat dipanggil dari `MainPercobaan2`. Nilai yang diberikan tetap disimpan pada atribut `x` milik `ClassA`.


**4.**

`protected` membuat subclass dapat mengakses atribut secara langsung. Sedangkan `private + getter` membuat atribut tetap tersembunyi.

Saya lebih memilih `private + getter` karena akses terhadap data lebih terkontrol.


**5.**

`ClassB` masih dapat mengakses atribut `protected` walaupun berbeda package karena `ClassB` merupakan subclass dari `ClassA`.

Untuk atribut default, `ClassB` tidak dapat mengaksesnya jika berada di package yang berbeda.

---

## Percobaan 3: Kata Kunci this dan super

### Implementasi Program

**Kelas Bangun**

![Kode Bangun](images/p3Bangun.png)

**Kelas Tabung**

![Kode Tabung](images/p3Tabung.png)

**Kelas MainPercobaan3**

![Kode MainPercobaan3](images/p3MainPercobaan3.png)

### Hasil Percobaan

![Hasil Percobaan 3](images/p3Hasil.png)

### Jawaban Percobaan 3

**1.**

`super` digunakan untuk mengakses atribut milik superclass `Bangun`, yaitu `phi` dan `r`.


**2.**

`super.phi` dan `super.r` digunakan untuk mengambil atribut dari class `Bangun`, sedangkan `this.t` digunakan untuk mengambil atribut `t` dari class `Tabung`.


**3.**

Karena `phi` dan `r` menggunakan `protected`, sehingga dapat digunakan oleh subclass.

Jika diubah menjadi `private`, atribut tersebut tidak dapat diakses langsung oleh `Tabung`.


**4.**

Output tetap sama karena `phi` hanya terdapat pada `Bangun`, sehingga `this.phi` tetap mengarah ke atribut `phi` yang diwariskan.


**5.**

`Tabung` memiliki atribut `r` sendiri dengan nilai `5`, sedangkan `Bangun` memiliki `r` dengan nilai `10`.

`r` dan `this.r` mengarah ke `r` milik `Tabung`, sedangkan `super.r` mengarah ke `r` milik `Bangun`.

---

## Percobaan 4: Konstruktor dan Multilevel Inheritance

### Implementasi Program

**Kelas ClassA**

![Kode ClassA](images/p4classA.png)

**Kelas ClassB**

![Kode ClassB](images/p4classB.png)

**Kelas ClassC**

![Kode ClassC](images/p4classC.png)

**Kelas MainPercobaan4**

![Kode MainPercobaan4](images/p4MainPercobaan4.png)

### Hasil Percobaan

![Hasil Percobaan 4](images/p4Hasil.png)

### Jawaban Percobaan 4

**1.**

`ClassA` menjadi superclass dari `ClassB`.

`ClassB` menjadi subclass dari `ClassA` sekaligus superclass dari `ClassC`.

`ClassC` menjadi subclass dari `ClassB`.


**2.**

Karena sebelum konstruktor `ClassC` dijalankan, konstruktor superclass harus dijalankan terlebih dahulu.

Urutannya adalah `ClassA`, kemudian `ClassB`, lalu `ClassC`.


**3.**

Output tetap sama karena Java otomatis memanggil `super()` jika tidak ditulis secara langsung.


**4.**

`super()` harus berada di baris pertama konstruktor. Jika ditulis setelah perintah lain, program akan mengalami error.


**5.**

Urutan prosesnya adalah:

1. Membuat objek `ClassC`.
2. Menjalankan konstruktor `ClassA`.
3. Menjalankan konstruktor `ClassB`.
4. Menjalankan konstruktor `ClassC`.
5. Menampilkan hasil dari ketiga konstruktor.

---

## Percobaan 5: Konstruktor Berparameter dan Overriding

### Implementasi Program

**Kelas Komputer**

![Kode Komputer](images/p5Komputer.png)

**Kelas Desktop**

![Kode Desktop](images/p5Desktop.png)

**Kelas Laptop**

![Kode Laptop](images/p5Laptop.png)

**Kelas MainPercobaan5**

![Kode MainPercobaan5](images/p5MainPercobaan5.png)

### Hasil Percobaan

![Hasil Percobaan 5](images/p5Hasil.png)

### Jawaban Percobaan 5

**1.**

`super(merk, memory, cpu)` digunakan untuk memanggil konstruktor `Komputer` dan mengisi atribut `merk`, `kapasitasMemory`, dan `kecepatanCPU`.

Sedangkan `this.printer = printer` digunakan untuk mengisi atribut `printer` milik `Desktop`.


**2.**

Pada Percobaan 4, superclass memiliki konstruktor tanpa parameter sehingga Java dapat memanggil `super()` secara otomatis.

Sedangkan `Komputer` memiliki konstruktor berparameter, sehingga `Desktop` harus memanggil `super(merk, memory, cpu)`.


**3.**

Kondisi tersebut disebut **overriding**.

Jika `super.showInfo()` dihapus, informasi dari `Komputer` seperti merk, memory, dan CPU tidak akan ditampilkan. Yang tampil hanya informasi dari `Desktop`.


**4.**

Dengan `@Override`, compiler dapat mengecek apakah method benar-benar melakukan overriding.

Tanpa `@Override`, jika nama method salah, program tetap dapat dikompilasi karena dianggap sebagai method baru.


**5.**

Jika dibuat class `Workstation` sebagai turunan `Desktop`, urutan konstruktor yang dijalankan adalah:

1. `Komputer`
2. `Desktop`
3. `Workstation`

Jadi konstruktor superclass dijalankan terlebih dahulu sebelum konstruktor subclass.

---

# Tugas Mandiri

## Tugas 1: Pegawai, Dosen, dan DaftarGaji

### Implementasi Program

**Kelas Pegawai**

![Kode Pegawai](images/t1Pegawai.png)

**Kelas Dosen**

![Kode Dosen](images/t1Dosen.png)

**Kelas DaftarGaji**

![Kode DaftarGaji](images/t1DaftarGaji.png)

**Kelas MainTugas1**

![Kode MainTugas1](images/t1MainTugas1.png)

### Hasil Tugas

![Hasil Tugas 1](images/t1Hasil.png)

---

## Tugas 2: Televisi dan TelevisiModern

### Implementasi Program

**Kelas Televisi**

![Kode Televisi](images/t2Televisi.png)

**Kelas TelevisiModern**

![Kode TelevisiModern](images/t2TelevisiModern.png)

**Kelas MainTugas2**

![Kode MainTugas2](images/t2MainTugas2.png)

### Hasil Tugas

![Hasil Tugas 2](images/t2Hasil.png)

---

## Tugas 3: Character, Angel, Human, dan Wizard

### Implementasi Program

**Kelas Character**

![Kode Character](images/t3Character.png)

**Kelas Angel**

![Kode Angel](images/t3Angel.png)

**Kelas Human**

![Kode Human](images/t3Human.png)

**Kelas Wizard**

![Kode Wizard](images/t3Wizard.png)

**Kelas MainTugas3**

![Kode MainTugas3](images/t3mainTugas3.png)

### Hasil Tugas

![Hasil Tugas 3](images/t3Hasil.png)

---

## Tugas 4: Jawab Singkat

### Jawaban

**1.**

Hubungan **is-a (inheritance)** adalah hubungan ketika suatu class merupakan turunan dari class lain. Contohnya pada jobsheet adalah `Dosen extends Pegawai`, sehingga `Dosen` merupakan turunan dari `Pegawai`.

Sedangkan hubungan **has-a (aggregation/composition)** adalah hubungan ketika suatu class memiliki atau menggunakan objek dari class lain. Contohnya pada jobsheet adalah `DaftarGaji` yang memiliki kumpulan objek `Pegawai`.


**2.**

Member `private` hanya dapat diakses langsung dari class yang mendeklarasikannya, sehingga subclass tidak dapat mengaksesnya secara langsung. Member `protected` dapat diakses oleh class itu sendiri dan subclass yang mewarisinya. Konstruktor tidak diwariskan oleh subclass, tetapi konstruktor superclass akan dijalankan terlebih dahulu saat objek subclass dibuat. Jika superclass hanya memiliki konstruktor berparameter, subclass harus memanggilnya menggunakan `super(...)`.

---
