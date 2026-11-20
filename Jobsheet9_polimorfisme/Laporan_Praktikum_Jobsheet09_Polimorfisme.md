# Laporan Praktikum PrakPBO

-   **Nama:** Muhammad Nur Rochman
-   **NIM:** 254107020121
-   **Kelas:** TI-2G

------------------------------------------------------------------------

## Percobaan 1: Bentuk Dasar Polimorfisme

### Implementasi Program

### Kelas GambaranDasar

File: `gambaran/GambaranDasar.java`

``` java
package Jobsheet9_polimorfisme.gambaran;

public class GambaranDasar {
    interface Vegetarian { }
    static class Animal { }
    static class Deer extends Animal implements Vegetarian { }
    static class Lion extends Animal { }

    public static void main(String[] args) {
        Deer d = new Deer();
        Lion l = new Lion();

        Animal a = d;
        Animal a2 = l;
        Vegetarian v = d;
        // Vegetarian v2 = l;

        System.out.println("a     menunjuk objek " + a.getClass().getSimpleName());
        System.out.println("a2 menunjuk objek " + a2.getClass().getSimpleName());
        System.out.println("v     menunjuk objek " + v.getClass().getSimpleName());
    }
}
```

### Kelas Employee

File: `pegawai/Employee.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getEmployeeInfo() {
        return "Name = " + name;
    }
}
```

### Interface Payable

File: `pegawai/Payable.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public interface Payable {
    int getPaymentAmount();
}
```

### Kelas InternshipEmployee

File: `pegawai/InternshipEmployee.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class InternshipEmployee extends Employee {
    private int length;

    public InternshipEmployee(String name, int length) {
        super(name);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String getEmployeeInfo() {
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as internship employee for " + length + " month/s\n";
        return info;
    }
}
```

### Kelas PermanentEmployee

File: `pegawai/PermanentEmployee.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class PermanentEmployee extends Employee implements Payable {
    private int salary;

    public PermanentEmployee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int getPaymentAmount() {
        return (int) (salary + 0.05 * salary);
    }

    @Override
    public String getEmployeeInfo() {
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as permanent employee with salary " + salary + "\n";
        return info;
    }
}
```

### Kelas ElectricityBill

File: `pegawai/ElectricityBill.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class ElectricityBill implements Payable {
    private int kwh;
    private String category;

    public ElectricityBill(int kwh, String category) {
        this.kwh = kwh;
        this.category = category;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int getPaymentAmount() {
        return kwh * getBasePrice();
    }

    public int getBasePrice() {
        return switch (category) {
            case "R-1" -> 100;
            case "R-2" -> 200;
            default -> 0;
        };
    }

    public String getBillInfo() {
        return "kWH = " + kwh + "\n"
                + "Category = " + category + " (" + getBasePrice() + " per kWH)\n";
    }
}
```

### Kelas MainPercobaan1

File: `pegawai/MainPercobaan1.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class MainPercobaan1 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "R-1");
        Employee e;
        Payable p;

        e = pEmp;
        System.out.println("e menunjuk objek " + e.getClass().getSimpleName());
        e = iEmp;
        System.out.println("e menunjuk objek " + e.getClass().getSimpleName());
        p = pEmp;
        System.out.println("p menunjuk objek " + p.getClass().getSimpleName());
        p = eBill;
        System.out.println("p menunjuk objek " + p.getClass().getSimpleName());
    }
}
```

### Hasil Percobaan

``` text
a     menunjuk objek PermanentEmployee
e menunjuk objek InternshipEmployee
p menunjuk objek PermanentEmployee
p menunjuk objek ElectricityBill
```

Output kode `MainPercobaan1.java` yang sesuai adalah:

``` text
e menunjuk objek PermanentEmployee
e menunjuk objek InternshipEmployee
p menunjuk objek PermanentEmployee
p menunjuk objek ElectricityBill
```

### Eksperimen

  -----------------------------------------------------------------------
  Perubahan                           Hasil
  ----------------------------------- -----------------------------------
  Mengaktifkan `Vegetarian v2 = l;`   Error kompilasi karena `Lion` tidak
                                      mengimplementasikan `Vegetarian`.

  Menambahkan `p = iEmp;`             Error kompilasi karena
                                      `InternshipEmployee` bukan
                                      `Payable`.

  Menambahkan `e = eBill;`            Error kompilasi karena
                                      `ElectricityBill` bukan turunan
                                      `Employee`.
  -----------------------------------------------------------------------

### Jawaban Singkat Percobaan 1

1.  Class turunan `Employee` adalah `InternshipEmployee` dan
    `PermanentEmployee`.
2.  Class yang mengimplementasikan `Payable` adalah `PermanentEmployee`
    dan `ElectricityBill`.
3.  `e` dapat diisi `pEmp` dan `iEmp` karena keduanya merupakan turunan
    `Employee`.
4.  `p` dapat diisi `pEmp` dan `eBill` karena keduanya
    mengimplementasikan `Payable`.
5.  `p = iEmp` error karena `InternshipEmployee` tidak
    mengimplementasikan `Payable`. `e = eBill` error karena
    `ElectricityBill` tidak mewarisi `Employee`. Demikian pula
    `Vegetarian v2 = l` error karena `Lion` tidak mengimplementasikan
    `Vegetarian`.
6.  Tipe referensi adalah tipe variabel yang menentukan anggota yang
    dapat diakses saat kompilasi. Tipe objek adalah kelas objek
    sebenarnya saat program berjalan. Karena itu, referensi `Animal`
    dapat menunjuk objek `Deer`.
7.  Polimorfisme memungkinkan referensi superclass atau interface
    menunjuk objek dari subclass atau class yang mengimplementasikan
    interface tersebut.

------------------------------------------------------------------------

## Percobaan 2: Virtual Method Invocation

### Implementasi Program

### Kelas MainPercobaan2

File: `pegawai/MainPercobaan2.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class MainPercobaan2 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        Employee e;
        e = pEmp;
        System.out.println(e.getEmployeeInfo());
        System.out.println("------------------");
        System.out.println(pEmp.getEmployeeInfo());

        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        e = iEmp;
        System.out.println("------------------");
        System.out.println(e.getEmployeeInfo());
    }
}
```

### Hasil Percobaan

``` text
Name = Dedik
Registered as permanent employee with salary 500

------------------
Name = Dedik
Registered as permanent employee with salary 500

------------------
Name = Sunarto
Registered as internship employee for 5 month/s
```

### Eksperimen

  -----------------------------------------------------------------------
  Perubahan                           Hasil
  ----------------------------------- -----------------------------------
  Memanggil `e.getSalary()` saat `e`  Error kompilasi karena method
  bertipe `Employee`                  `getSalary()` tidak tersedia pada
                                      tipe referensi `Employee`.

  -----------------------------------------------------------------------

### Jawaban Singkat Percobaan 2

1.  Kedua pemanggilan menghasilkan hasil yang sama karena `e` dan `pEmp`
    menunjuk objek `PermanentEmployee` yang sama, sehingga method
    `getEmployeeInfo()` yang dijalankan adalah versi
    `PermanentEmployee`.
2.  `e.getEmployeeInfo()` merupakan pemanggilan melalui referensi
    superclass yang menunjuk objek subclass. `pEmp.getEmployeeInfo()`
    menggunakan referensi dengan tipe objek yang sama, yaitu
    `PermanentEmployee`.
3.  Virtual method invocation adalah pemilihan implementasi method
    overriding saat program berjalan berdasarkan tipe objek sebenarnya.
    Disebut virtual karena versi method yang dijalankan ditentukan saat
    runtime.
4.  Pada langkah 3, `e` menunjuk objek `InternshipEmployee`, sehingga
    versi `getEmployeeInfo()` milik `InternshipEmployee` yang
    dijalankan.
5.  Compiler menolak `e.getSalary()` karena tipe referensi `Employee`
    tidak memiliki method `getSalary()`, meskipun objek yang ditunjuk
    dapat berupa subclass.

------------------------------------------------------------------------

## Percobaan 3: Heterogeneous Collection

### Implementasi Program

### Kelas MainPercobaan3

File: `pegawai/MainPercobaan3.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class MainPercobaan3 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "R-1");

        Employee[] e = {pEmp, iEmp};
        Payable[] p = {pEmp, eBill};
        // Employee[] e2 = {pEmp, iEmp, eBill};

        for (Employee emp : e) {
            System.out.println(emp.getEmployeeInfo());
        }

        int total = 0;
        for (Payable tagihan : p) {
            total += tagihan.getPaymentAmount();
        }
        System.out.println("Total tagihan bulan ini = " + total);
    }
}
```

### Hasil Percobaan

``` text
Name = Dedik
Registered as permanent employee with salary 500

Name = Sunarto
Registered as internship employee for 5 month/s

Total tagihan bulan ini = 1025
```

### Eksperimen

  ----------------------------------------------------------------------------
  Perubahan                                Hasil
  ---------------------------------------- -----------------------------------
  Mengaktifkan                             Error kompilasi karena
  `Employee[] e2 = {pEmp, iEmp, eBill};`   `ElectricityBill` tidak dapat
                                           dikonversi menjadi `Employee`.

  ----------------------------------------------------------------------------

### Jawaban Singkat Percobaan 3

1.  Array `e` dapat berisi `PermanentEmployee` dan `InternshipEmployee`
    karena keduanya merupakan turunan `Employee`.
2.  Array `p` dapat berisi `PermanentEmployee` dan `ElectricityBill`
    karena keduanya mengimplementasikan `Payable`.
3.  Error terjadi karena `ElectricityBill` bukan turunan `Employee`,
    sehingga tidak dapat dimasukkan ke array bertipe `Employee`.
4.  Pemanggilan method yang sama menghasilkan teks berbeda karena setiap
    objek menjalankan implementasi `getEmployeeInfo()` sesuai kelas
    objeknya. Hal ini merupakan virtual method invocation seperti pada
    Percobaan 2.

------------------------------------------------------------------------

## Percobaan 4: Polymorphic Argument, instanceof, dan Casting Objek

### Implementasi Program

### Kelas Owner

File: `pegawai/Owner.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class Owner {
    public void pay(Payable p) {
        System.out.println("Total payment = " + p.getPaymentAmount());
        if (p instanceof ElectricityBill) {
            ElectricityBill eb = (ElectricityBill) p;
            System.out.println(eb.getBillInfo());
        } else if (p instanceof PermanentEmployee) {
            PermanentEmployee pe = (PermanentEmployee) p;
            System.out.println(pe.getEmployeeInfo());
        }
    }

    public void showMyEmployee(Employee e) {
        System.out.println(e.getEmployeeInfo());
        if (e instanceof PermanentEmployee) {
            System.out.println("You have to pay her/him monthly!!!");
        } else {
            System.out.println("No need to pay him/her :)");
        }
    }
}
```

### Kelas MainPercobaan4

File: `pegawai/MainPercobaan4.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class MainPercobaan4 {
    public static void main(String[] args) {
        Owner ow = new Owner();

        ElectricityBill eBill = new ElectricityBill(5, "R-1");
        ow.pay(eBill);
        System.out.println("------------------------------");

        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        ow.pay(pEmp);
        System.out.println("------------------------------");

        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ow.showMyEmployee(pEmp);
        System.out.println("------------------------------");
        ow.showMyEmployee(iEmp);
    }
}
```

### Kelas Eksperimen4

File: `pegawai/Eksperimen4.java`

``` java
package Jobsheet9_polimorfisme.pegawai;

public class Eksperimen4 {
    public static void main(String[] args) {
        Employee e = new InternshipEmployee("Sunarto", 5);
        System.out.println("Sebelum casting");
        PermanentEmployee pe = (PermanentEmployee) e;
        System.out.println("Sesudah casting: " + pe.getSalary());
    }
}
```

### Hasil Percobaan

``` text
Total payment = 500
kWH = 5
Category = R-1 (100 per kWH)

------------------------------
Total payment = 525
Name = Dedik
Registered as permanent employee with salary 500

------------------------------
Name = Dedik
Registered as permanent employee with salary 500

You have to pay her/him monthly!!!
------------------------------
Name = Sunarto
Registered as internship employee for 5 month/s

No need to pay him/her :)
```

### Eksperimen

  -----------------------------------------------------------------------
  Perubahan                           Hasil
  ----------------------------------- -----------------------------------
  Menambahkan `ow.pay(iEmp);`         Error kompilasi karena
                                      `InternshipEmployee` tidak
                                      mengimplementasikan `Payable`.

  Menjalankan `Eksperimen4`           Program lolos kompilasi, tetapi
                                      mengalami `ClassCastException` saat
                                      objek `InternshipEmployee` di-cast
                                      menjadi `PermanentEmployee`.
  -----------------------------------------------------------------------

### Jawaban Singkat Percobaan 4

1.  `ow.pay(eBill)` dan `ow.pay(pEmp)` dapat dilakukan karena
    `ElectricityBill` dan `PermanentEmployee` mengimplementasikan
    `Payable`.
2.  Parameter bertipe `Payable` membuat satu method `pay()` dapat
    menerima berbagai objek yang memenuhi kontrak interface tersebut.
3.  `ow.pay(iEmp)` error karena `InternshipEmployee` tidak
    mengimplementasikan `Payable`.
4.  `instanceof ElectricityBill` memeriksa apakah objek yang diterima
    benar-benar merupakan objek `ElectricityBill` sebelum casting
    dilakukan.
5.  Casting `(ElectricityBill) p` diperlukan agar objek yang
    direferensikan oleh `Payable` dapat diakses melalui tipe
    `ElectricityBill`, termasuk method `getBillInfo()` yang tidak
    tersedia pada interface `Payable`.
6.  Program lolos kompilasi karena casting tersebut diperbolehkan secara
    sintaksis, tetapi gagal saat dijalankan karena objek sebenarnya
    adalah `InternshipEmployee`. Pemeriksaan `instanceof` dapat
    mencegahnya dengan memastikan tipe objek sebelum casting.

------------------------------------------------------------------------

## Tugas Mandiri 1: Permainan Zombie, Barrier, dan Plant

### Implementasi Program

### Interface Destroyable

File: `zombie/Destroyable.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public interface Destroyable {
    void destroyed();
}
```

### Kelas Zombie

File: `zombie/Zombie.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public abstract class Zombie implements Destroyable {
    protected int health;
    protected int level;

    public Zombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    public abstract void heal();

    @Override
    public abstract void destroyed();

    public String getZombieInfo() {
        return "Health = " + health + "\nLevel = " + level + "\n";
    }
}
```

### Kelas WalkingZombie

File: `zombie/WalkingZombie.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public class WalkingZombie extends Zombie {
    public WalkingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1 -> health = Math.min(100, health + health * 10 / 100);
            case 2 -> health = Math.min(100, health + health * 30 / 100);
            case 3 -> health = Math.min(100, health + health * 40 / 100);
        }
    }

    @Override
    public void destroyed() {
        health -= health * 20 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data = " + super.getZombieInfo();
    }
}
```

### Kelas JumpingZombie

File: `zombie/JumpingZombie.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public class JumpingZombie extends Zombie {
    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1 -> health = Math.min(100, health + health * 30 / 100);
            case 2 -> health = Math.min(100, health + health * 40 / 100);
            case 3 -> health = Math.min(100, health + health * 50 / 100);
        }
    }

    @Override
    public void destroyed() {
        health -= health * 10 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Jumping Zombie Data = " + super.getZombieInfo();
    }
}
```

### Kelas Barrier

File: `zombie/Barrier.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public class Barrier implements Destroyable {
    private int strength;

    public Barrier(int strength) {
        this.strength = strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void destroyed() {
        strength = strength * 9 / 10;
    }

    public String getBarrierInfo() {
        return "Barrier Strength = " + strength;
    }
}
```

### Kelas Plant

File: `zombie/Plant.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public class Plant {
    public void doDestroy(Destroyable d) {
        d.destroyed();
    }
}
```

### Kelas MainTugas1

File: `zombie/MainTugas1.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public class MainTugas1 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
        System.out.println("----------------------");

        for (int i = 0; i < 4; i++) {
            p.doDestroy(wz);
            p.doDestroy(jz);
            p.doDestroy(b);
        }

        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
    }
}
```

### Hasil Program

``` text
Walking Zombie Data = Health = 100
Level = 1

Jumping Zombie Data = Health = 100
Level = 2

Barrier Strength = 100
----------------------
Walking Zombie Data = Health = 42
Level = 1

Jumping Zombie Data = Health = 66
Level = 2

Barrier Strength = 64
```

### Jawaban Analisis

1.  `Plant.doDestroy()` dapat menerima `WalkingZombie`, `JumpingZombie`,
    dan `Barrier` karena ketiganya mengimplementasikan interface
    `Destroyable`. Method tersebut menerima parameter bertipe interface,
    sehingga tidak harus berada dalam satu hierarki class.
2.  Pada `d.destroyed()`, tipe referensi adalah `Destroyable`, sedangkan
    tipe objek mengikuti objek yang diberikan. JVM menjalankan
    `destroyed()` milik `WalkingZombie`, `JumpingZombie`, atau `Barrier`
    sesuai objek sebenarnya.
3.  `new Zombie(100, 1)` menghasilkan error kompilasi karena `Zombie`
    merupakan class abstract dan tidak dapat diinstansiasi secara
    langsung.

------------------------------------------------------------------------

## Tugas Mandiri 2: Heterogeneous Collection, instanceof, dan Casting

### Implementasi Program

### Kelas MainTugas2

File: `zombie/MainTugas2.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public class MainTugas2 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        Destroyable[] d = {wz, jz, b};

        for (int i = 0; i < 4; i++) {
            for (Destroyable destroyable : d) {
                p.doDestroy(destroyable);
            }
        }

        for (Destroyable destroyable : d) {
            if (destroyable instanceof Zombie) {
                Zombie z = (Zombie) destroyable;
                z.heal();
                System.out.println(z.getZombieInfo());
            } else if (destroyable instanceof Barrier) {
                Barrier barrier = (Barrier) destroyable;
                System.out.println(barrier.getBarrierInfo());
            }
        }
    }
}
```

### Hasil Program

``` text
Walking Zombie Data = Health = 46
Level = 1

Jumping Zombie Data = Health = 92
Level = 2

Barrier Strength = 64
```

### Jawaban Analisis

1.  Array harus bertipe `Destroyable` karena berisi `WalkingZombie`,
    `JumpingZombie`, dan `Barrier`. Ketiganya mengimplementasikan
    `Destroyable`, tetapi `Barrier` bukan turunan `Zombie`.
2.  Casting ke `Zombie` diperlukan karena method `heal()` hanya tersedia
    pada class `Zombie`, bukan pada interface `Destroyable`.
3.  Jika pemeriksaan `instanceof` dihilangkan dan objek `Barrier`
    di-cast menjadi `Zombie`, program akan mengalami
    `ClassCastException` saat dijalankan.

------------------------------------------------------------------------

## Tugas Mandiri 3: Prediksi Hasil Kompilasi

### Implementasi Program

### Kelas MainTugas3

File: `zombie/MainTugas3.java`

``` java
package Jobsheet9_polimorfisme.zombie;

public class MainTugas3 {
    public static void main(String[] args) {
        Zombie z = new WalkingZombie(100, 1);
        Destroyable d = z;
        // Zombie z2 = d;
        Zombie z3 = (Zombie) d;
        // Zombie z4 = new Zombie(100, 1);
        // Destroyable d2 = new Plant();
        Zombie z5 = new JumpingZombie(100, 2);
        WalkingZombie w = (WalkingZombie) z5;
    }
}
```

### Jawaban Analisis

  ------------------------------------------------------------------------------------------
  Pernyataan                                 Prediksi                Alasan
  ------------------------------------------ ----------------------- -----------------------
  `Zombie z = new WalkingZombie(100, 1);`    OK                      `WalkingZombie`
                                                                     merupakan subclass
                                                                     konkret dari `Zombie`.

  `Destroyable d = z;`                       OK                      `Zombie`
                                                                     mengimplementasikan
                                                                     `Destroyable`, sehingga
                                                                     referensinya dapat
                                                                     di-upcast ke interface
                                                                     tersebut.

  `Zombie z2 = d;`                           Error kompilasi         Referensi `Destroyable`
                                                                     tidak dapat langsung
                                                                     diberikan ke variabel
                                                                     `Zombie` tanpa casting.

  `Zombie z3 = (Zombie) d;`                  OK                      Objek yang ditunjuk `d`
                                                                     sebenarnya adalah
                                                                     `WalkingZombie`, yang
                                                                     merupakan subclass
                                                                     `Zombie`.

  `Zombie z4 = new Zombie(100, 1);`          Error kompilasi         `Zombie` adalah class
                                                                     abstract dan tidak
                                                                     dapat dibuat objek
                                                                     secara langsung.

  `Destroyable d2 = new Plant();`            Error kompilasi         `Plant` tidak
                                                                     mengimplementasikan
                                                                     interface
                                                                     `Destroyable`.

  `Zombie z5 = new JumpingZombie(100, 2);`   OK                      `JumpingZombie`
                                                                     merupakan subclass
                                                                     konkret dari `Zombie`.

  `WalkingZombie w = (WalkingZombie) z5;`    Error saat dijalankan   Casting lolos
                                                                     kompilasi, tetapi objek
                                                                     sebenarnya adalah
                                                                     `JumpingZombie`, bukan
                                                                     `WalkingZombie`,
                                                                     sehingga terjadi
                                                                     `ClassCastException`.
  ------------------------------------------------------------------------------------------

------------------------------------------------------------------------
