# Laporan Praktikum PrakPBO

- **Nama:** Muhammad Nur Rochman
- **NIM:** 254107020121
- **Kelas:** TI-2G

---

## Percobaan 1: Bentuk Dasar Polimorfisme

### Implementasi Program

**Kelas GambaranDasar**

```java
package id.ac.polinema.polimorfisme.gambaran;

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

**Kelas Employee**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

**Interface Payable**

```java
package id.ac.polinema.polimorfisme.pegawai;

public interface Payable {
    int getPaymentAmount();
}
```

**Kelas InternshipEmployee**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

**Kelas PermanentEmployee**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

**Kelas ElectricityBill**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

**Kelas MainPercobaan1**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

```text
a     menunjuk objek Deer
a2 menunjuk objek Lion
v     menunjuk objek Deer

e menunjuk objek PermanentEmployee
e menunjuk objek InternshipEmployee
p menunjuk objek PermanentEmployee
p menunjuk objek ElectricityBill
```

### Eksperimen

| Perubahan | Hasil |
|---|---|
| `Vegetarian v2 = l;` | Error: `incompatible types: Lion cannot be converted to Vegetarian` |
| `p = iEmp;` | Error: `incompatible types: InternshipEmployee cannot be converted to Payable` |
| `e = eBill;` | Error: `incompatible types: ElectricityBill cannot be converted to Employee` |

### Jawaban Singkat Percobaan 1

1. Class yang merupakan turunan dari `Employee` adalah `InternshipEmployee` dan `PermanentEmployee`.

2. Class yang meng-implements `Payable` adalah `PermanentEmployee` dan `ElectricityBill`.

3. `e` dapat diisi `pEmp` dan `iEmp` karena keduanya merupakan subclass dari `Employee`, sehingga keduanya merupakan bentuk dari `Employee`.

4. `p` dapat diisi `pEmp` dan `eBill` karena `PermanentEmployee` dan `ElectricityBill` sama-sama meng-implements `Payable`.

5. `p = iEmp` error karena `InternshipEmployee` tidak meng-implements `Payable`. `e = eBill` error karena `ElectricityBill` bukan turunan `Employee`. Hal yang sama terjadi pada `Vegetarian v2 = l` karena `Lion` tidak meng-implements `Vegetarian`.

6. Tipe referensi adalah tipe variabel yang digunakan compiler, sedangkan tipe objek adalah tipe objek sebenarnya yang dibuat saat program berjalan. Pada `Animal a = d`, tipe referensinya `Animal`, tetapi objeknya `Deer`, sehingga `getClass()` menampilkan `Deer`.

7. Polimorfisme memungkinkan satu referensi bertipe superclass atau interface menunjuk berbagai objek subclass atau implementor selama hubungan tersebut valid.

---

## Percobaan 2: Virtual Method Invocation

### Implementasi Program

**Kelas MainPercobaan2**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

```text
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

| Perubahan | Hasil |
|---|---|
| `System.out.println(e.getSalary());` setelah `e = iEmp;` | Error: `cannot find symbol ... method getSalary()` |

### Jawaban Singkat Percobaan 2

1. `e.getEmployeeInfo()` dan `pEmp.getEmployeeInfo()` menghasilkan hasil yang sama karena keduanya menunjuk objek `PermanentEmployee`, sehingga method `getEmployeeInfo()` yang dijalankan adalah milik `PermanentEmployee`.

2. `e.getEmployeeInfo()` disebut pemanggilan method virtual karena `e` bertipe `Employee`, tetapi method yang dijalankan ditentukan berdasarkan tipe objek sebenarnya saat runtime. `pEmp.getEmployeeInfo()` langsung menggunakan referensi `PermanentEmployee`.

3. Virtual method invocation adalah pemanggilan method hasil overriding melalui referensi polimorfik. Disebut virtual karena versi method yang dijalankan ditentukan saat program berjalan berdasarkan tipe objek.

4. Pada langkah 3, `e` awalnya menunjuk `PermanentEmployee`, kemudian menunjuk `InternshipEmployee`. Pernyataan `e.getEmployeeInfo()` tetap sama, tetapi hasil berbeda karena objek yang ditunjuk berbeda dan masing-masing melakukan overriding.

5. `e.getSalary()` ditolak compiler karena tipe referensi `e` adalah `Employee`, sedangkan `getSalary()` hanya dimiliki `PermanentEmployee`.

---

## Percobaan 3: Heterogeneous Collection

### Implementasi Program

**Kelas MainPercobaan3**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

```text
Name = Dedik
Registered as permanent employee with salary 500

Name = Sunarto
Registered as internship employee for 5 month/s

Total tagihan bulan ini = 1025
```

### Eksperimen

| Perubahan | Hasil |
|---|---|
| `Employee[] e2 = {pEmp, iEmp, eBill};` | Error: `incompatible types: ElectricityBill cannot be converted to Employee` |

### Jawaban Singkat Percobaan 3

1. Array `e` dapat berisi `pEmp` dan `iEmp` karena keduanya merupakan subclass dari `Employee`.

2. Array `p` dapat berisi `pEmp` dan `eBill` karena keduanya meng-implements `Payable`.

3. `Employee[] e2` error karena `ElectricityBill` bukan turunan `Employee`.

4. Setiap elemen menghasilkan teks berbeda karena method `getEmployeeInfo()` di-override oleh subclass. Pemanggilan method sama, tetapi versi method mengikuti tipe objek yang sedang ditunjuk.

---

## Percobaan 4: Polymorphic Argument, instanceof, dan Casting Objek

### Implementasi Program

**Kelas Owner**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

**Kelas MainPercobaan4**

```java
package id.ac.polinema.polimorfisme.pegawai;

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

### Hasil Percobaan

```text
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
No need to pay him/her :).
```

### Eksperimen

| Perubahan | Hasil |
|---|---|
| `ow.pay(iEmp);` | Error: `InternshipEmployee cannot be converted to Payable` |
| `(PermanentEmployee) e` ketika `e` menunjuk `InternshipEmployee` | Lolos kompilasi, tetapi saat dijalankan menghasilkan `ClassCastException` |

### Jawaban Singkat Percobaan 4

1. `ow.pay(eBill)` dan `ow.pay(pEmp)` dapat dilakukan karena parameter `pay()` bertipe `Payable`, sedangkan `ElectricityBill` dan `PermanentEmployee` sama-sama meng-implements `Payable`.

2. Parameter `Payable` membuat satu method `pay()` dapat menerima beberapa jenis objek yang memiliki kemampuan pembayaran, tanpa perlu membuat method `pay()` terpisah untuk setiap class.

3. `ow.pay(iEmp)` menyebabkan error karena `InternshipEmployee` hanya merupakan `Employee` dan tidak meng-implements `Payable`.

4. `instanceof ElectricityBill` digunakan untuk memeriksa apakah objek yang ditunjuk referensi `p` benar-benar merupakan `ElectricityBill` sebelum dilakukan casting.

5. Casting `(ElectricityBill) p` diperlukan agar referensi dapat menggunakan method yang khusus dimiliki `ElectricityBill`, seperti `getBillInfo()`. Tipe `Payable` hanya mengenal method yang didefinisikan pada interface tersebut, yaitu `getPaymentAmount()`.

6. Kode downcasting pada eksperimen lolos kompilasi karena hubungan tipe referensinya memungkinkan casting. Namun saat runtime objek sebenarnya adalah `InternshipEmployee`, bukan `PermanentEmployee`, sehingga terjadi `ClassCastException`. Pemeriksaan `instanceof` dapat mencegahnya dengan memastikan tipe objek sebelum casting.

---

## Tugas Mandiri 1: Permainan Zombie, Barrier, dan Plant

### Implementasi Program

**Interface Destroyable**

```java
package id.ac.polinema.polimorfisme.zombie;

public interface Destroyable {
    void destroyed();
}
```

**Kelas Zombie**

```java
package id.ac.polinema.polimorfisme.zombie;

public abstract class Zombie implements Destroyable {
    protected int health;
    protected int level;

    public Zombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    public void heal() {
        if (level == 1) {
            health = Math.min(100, health + health * 10 / 100);
        } else if (level == 2) {
            health = Math.min(100, health + health * 30 / 100);
        } else if (level == 3) {
            health = Math.min(100, health + health * 40 / 100);
        }
    }

    public String getZombieInfo() {
        return "Health = " + health + "\n"
                + "Level = " + level + "\n";
    }
}
```

**Kelas WalkingZombie**

```java
package id.ac.polinema.polimorfisme.zombie;

public class WalkingZombie extends Zombie {
    public WalkingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        if (level == 1) {
            health = Math.min(100, health + health * 10 / 100);
        } else if (level == 2) {
            health = Math.min(100, health + health * 30 / 100);
        } else if (level == 3) {
            health = Math.min(100, health + health * 40 / 100);
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

**Kelas JumpingZombie**

```java
package id.ac.polinema.polimorfisme.zombie;

public class JumpingZombie extends Zombie {
    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        if (level == 1) {
            health = Math.min(100, health + health * 30 / 100);
        } else if (level == 2) {
            health = Math.min(100, health + health * 40 / 100);
        } else if (level == 3) {
            health = Math.min(100, health + health * 50 / 100);
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

**Kelas Barrier**

```java
package id.ac.polinema.polimorfisme.zombie;

public class Barrier implements Destroyable {
    private int strength;

    public Barrier(int strength) {
        this.strength = strength;
    }

    @Override
    public void destroyed() {
        strength = strength * 9 / 10;
    }

    public String getBarrierInfo() {
        return "Barrier Strength = " + strength + "\n";
    }
}
```

**Kelas Plant**

```java
package id.ac.polinema.polimorfisme.zombie;

public class Plant {
    public void doDestroy(Destroyable d) {
        d.destroyed();
    }
}
```

**Kelas MainTugas1**

```java
package id.ac.polinema.polimorfisme.zombie;

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

```text
Sebelum penghancuran:
Walking Zombie Health = 100, Level = 1
Jumping Zombie Health = 100, Level = 2
Barrier Strength = 100

Setelah 4 kali penghancuran:
Walking Zombie Health = 42
Jumping Zombie Health = 66
Barrier Strength = 64
```

### Jawaban Analisis

1. `Plant.doDestroy()` dapat menerima `WalkingZombie`, `JumpingZombie`, dan `Barrier` karena parameter method bertipe `Destroyable`. Ketiganya meng-implements `Destroyable`, meskipun tidak berada dalam satu hierarki class yang sama.

2. Pada `d.destroyed()`, tipe referensinya adalah `Destroyable`, sedangkan tipe objeknya dapat berupa `WalkingZombie`, `JumpingZombie`, atau `Barrier`. Method `destroyed()` yang dijalankan mengikuti tipe objek sebenarnya melalui polymorphism dan overriding.

3. `new Zombie(100, 1)` menghasilkan error karena `Zombie` adalah abstract class sehingga tidak dapat diinstansiasi secara langsung.

---

## Tugas Mandiri 2: Heterogeneous Collection, instanceof, dan Casting

### Implementasi Program

**Kelas MainTugas2**

```java
package id.ac.polinema.polimorfisme.zombie;

public class MainTugas2 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        Destroyable[] objects = {wz, jz, b};

        for (int i = 0; i < 4; i++) {
            for (Destroyable d : objects) {
                p.doDestroy(d);
            }
        }

        for (Destroyable d : objects) {
            if (d instanceof Zombie) {
                Zombie z = (Zombie) d;
                z.heal();
                System.out.println(z.getZombieInfo());
            } else if (d instanceof Barrier) {
                Barrier barrier = (Barrier) d;
                System.out.println(barrier.getBarrierInfo());
            }
        }
    }
}
```

### Hasil Program

```text
Walking Zombie dengan Health = 46
Jumping Zombie dengan Health = 92
Barrier Strength = 64
```

### Jawaban Analisis

1. Array harus bertipe `Destroyable` karena array harus dapat menampung `WalkingZombie`, `JumpingZombie`, dan `Barrier`. Ketiganya meng-implements `Destroyable`.

2. Casting ke `Zombie` diperlukan sebelum memanggil `heal()` karena method `heal()` hanya dikenal oleh tipe `Zombie`, bukan oleh interface `Destroyable`.

3. Jika pemeriksaan `instanceof` dihilangkan dan objek `Barrier` langsung di-cast ke `Zombie`, program akan gagal saat runtime dengan `ClassCastException` karena objek sebenarnya adalah `Barrier`.

---

## Tugas Mandiri 3: Prediksi Hasil Kompilasi

| Pernyataan | Prediksi | Alasan |
|---|---|---|
| `Zombie z = new WalkingZombie(100, 1);` | OK | `WalkingZombie` merupakan subclass dari `Zombie`, sehingga upcasting dapat dilakukan otomatis. |
| `Destroyable d = z;` | OK | `Zombie` meng-implements `Destroyable`, sehingga referensi `Zombie` dapat diarahkan ke `Destroyable`. |
| `Zombie z2 = d;` | Error kompilasi | `Destroyable` bukan superclass dari `Zombie` dan compiler tidak dapat melakukan downcasting otomatis. |
| `Zombie z3 = (Zombie) d;` | OK | Casting eksplisit dari `Destroyable` ke `Zombie` diperbolehkan dan objek sebenarnya adalah `WalkingZombie`, yang merupakan `Zombie`. |
| `Zombie z4 = new Zombie(100, 1);` | Error kompilasi | `Zombie` adalah abstract class sehingga tidak dapat dibuat dengan `new`. |
| `Destroyable d2 = new Plant();` | Error kompilasi | `Plant` tidak meng-implements `Destroyable`. |
| `Zombie z5 = new JumpingZombie(100, 2);` | OK | `JumpingZombie` merupakan subclass dari `Zombie`. |
| `WalkingZombie w = (WalkingZombie) z5;` | Error saat dijalankan | Casting dapat dikompilasi, tetapi objek sebenarnya adalah `JumpingZombie`, bukan `WalkingZombie`, sehingga terjadi `ClassCastException`. |

---

## Kesimpulan

Polimorfisme memungkinkan sebuah referensi bertipe superclass atau interface menunjuk objek dari subclass atau class yang meng-implements interface tersebut. Pada jobsheet ini, konsep tersebut diterapkan melalui assignment, virtual method invocation, heterogeneous collection, polymorphic argument, `instanceof`, upcasting, dan downcasting.

Tipe referensi menentukan method yang dapat dipanggil oleh compiler, sedangkan tipe objek menentukan implementasi method yang dijalankan saat runtime. Karena itu, satu pemanggilan method dapat menghasilkan perilaku berbeda ketika referensi menunjuk objek subclass yang berbeda.

Penggunaan `instanceof` sebelum downcasting membantu memastikan tipe objek sebenarnya sehingga dapat menghindari `ClassCastException`. Interface `Destroyable` juga menunjukkan bahwa objek dari class yang tidak berada dalam satu hierarki pewarisan tetap dapat diperlakukan secara polimorfik jika memiliki kontrak interface yang sama.
