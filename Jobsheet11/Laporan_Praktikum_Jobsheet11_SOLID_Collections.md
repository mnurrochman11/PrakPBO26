# Laporan Praktikum PrakPBO

-   **Nama:** Muhammad Nur Rochman
-   **NIM:** 254107020121
-   **Kelas:** TI-2G

------------------------------------------------------------------------

## Langkah 1 - 3: Baseline Bank Mini (Array)

### Implementasi Program

Seluruh kelas ditempatkan dalam package `Jobsheet11` di dalam direktori `Jobsheet11/`:

-   `Customer.java` — menyimpan identitas nasabah (`name` dan `phone`).
-   `InsufficientBalanceException.java` — checked exception yang dilempar saat validasi penarikan gagal.
-   `Account.java` — kelas induk abstrak dengan method overloading `deposit()`, template method `withdraw()` yang memanggil `canWithdraw()`, serta method abstrak `monthlyFee()`.
-   `InterestBearing.java` — interface khusus rekening yang memiliki perhitungan bunga (`applyInterest()`).
-   `SavingsAccount.java` — turunan `Account` yang mengimplementasikan `InterestBearing`, menahan saldo minimum Rp 50.000, tanpa biaya bulanan.
-   `CheckingAccount.java` — turunan `Account` tanpa bunga, mengizinkan penarikan hingga batas `overdraftLimit`, dengan biaya bulanan Rp 15.000.
-   `Bank.java` (versi awal) — menyimpan daftar `Account[]` dalam array berkapasitas tetap.

### Hasil Output Langkah 3

``` text
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
```

------------------------------------------------------------------------

## Langkah 4 - 6: Collections, SRP, dan DIP

### Perubahan Arsitektur

1.  **Collections (`LinkedHashMap`):** Penyimpanan array `Account[]` pada `Bank` diganti menggunakan `Map<String, Account> accounts = new LinkedHashMap<>()` agar kapasitas dinamis, urutan penambahan terjaga, dan pencarian nomor rekening berjalan langsung lewat kunci (`get()`).
2.  **Single Responsibility Principle (`Transaction` & `TransactionType`):** Representasi data transaksi dipisahkan ke enum `TransactionType` (`DEPOSIT`, `WITHDRAW`) dan kelas `Transaction`. `Account` menyimpan `List<Transaction> history` yang dicatat setiap kali `deposit()` atau `withdraw()` berhasil.
3.  **Dependency Inversion Principle (`AccountRepository`):** Tanggung jawab penyimpanan dipisahkan dari `Bank` ke interface `AccountRepository` dengan implementasi konkret `InMemoryAccountRepository`.

### Hasil Output Langkah 6

``` text
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
A003 WITHDRAW 30000.0
A003 DEPOSIT 1400.0
```

------------------------------------------------------------------------

## Tugas Mandiri

### 1. Implementasi Kelas BusinessAccount

File: `BusinessAccount.java`

``` java
package Jobsheet11;

public class BusinessAccount extends Account {
    private static final double MINIMUM_BALANCE = 1000000;

    public BusinessAccount(String accountNumber, Customer owner, double balance) {
        super(accountNumber, owner, balance);
    }

    @Override
    protected boolean canWithdraw(double amount) {
        return amount > 0 && (getBalance() - amount) >= MINIMUM_BALANCE;
    }

    @Override
    public double monthlyFee() {
        return 0;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Account type: Business");
    }
}
```

### Kelas Main (Akhir)

File: `Main.java`

``` java
package Jobsheet11;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Nadia", "0812-0000-0001");
        SavingsAccount acc1 = new SavingsAccount("A001", customer1, 500000, 0.01);

        Customer customer2 = new Customer("Sari", "0812-0000-0002");
        CheckingAccount acc2 = new CheckingAccount("A002", customer2, 200000, 50000);

        Customer customer3 = new Customer("Rian", "0812-0000-0003");
        SavingsAccount savings = new SavingsAccount("A003", customer3, 100000, 0.02);

        try {
            savings.withdraw(70000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        try {
            savings.withdraw(30000);
            System.out.println("Withdrawal succeeded, new balance: " + savings.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        Customer customer4 = new Customer("Budi", "0812-0000-0004");
        BusinessAccount business = new BusinessAccount("A004", customer4, 2000000);

        Bank bank = new Bank(new InMemoryAccountRepository());
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(savings);
        bank.addAccount(business);
        bank.processMonthEnd();
        bank.printAllAccounts();
        bank.printHistory("A003");
    }
}
```

### Hasil Output Tugas Mandiri

``` text
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
A004 monthly fee: 0.0
A001 - Nadia - balance: 505000.0
Account type: Savings, interest rate: 0.01
A002 - Sari - balance: 200000.0
Account type: Checking, overdraft limit: 50000.0
A003 - Rian - balance: 71400.0
Account type: Savings, interest rate: 0.02
A004 - Budi - balance: 2000000.0
Account type: Business
A003 WITHDRAW 30000.0
A003 DEPOSIT 1400.0
```

### 2. Jawaban Pertanyaan Analisis

1.  **(a) Prinsip SOLID yang dibuktikan:** Fakta bahwa `Account.java` dan `Bank.java` tidak diubah sama sekali saat `BusinessAccount` ditambahkan membuktikan **Open/Closed Principle (OCP)** sekaligus **Liskov Substitution Principle (LSP)**. Kelas `Account` dan `Bank` terbuka untuk perluasan perilaku melalui subclass baru (`extends Account`), namun tertutup terhadap modifikasi kode yang sudah ada karena seluruh operasi dipanggil secara polimorfik melalui kontrak superclass `Account`.
2.  **(b) Pengecekan `instanceof InterestBearing`:** Dengan memeriksa kemampuan melalui interface `InterestBearing` (menerapkan **Interface Segregation Principle**), `Bank.processMonthEnd()` tidak terikat pada kelas konkret tertentu seperti `SavingsAccount`. Karena `BusinessAccount` tidak mengimplementasikan `InterestBearing`, kondisi `acc instanceof InterestBearing` otomatis bernilai `false` sehingga rekening bisnis dilewati dari perhitungan bunga tanpa `Bank.java` perlu mengetahui keberadaan kelas `BusinessAccount`.
3.  **(c) Penggantian `InMemoryAccountRepository` dengan repository database:** `Bank.java` tidak perlu diubah satu baris pun karena bergantung pada abstraksi interface `AccountRepository`, bukan pada implementasi konkret `InMemoryAccountRepository`. Hal ini dimungkinkan oleh **Dependency Inversion Principle (DIP)**, di mana modul tingkat tinggi (`Bank`) dan modul tingkat rendah (implementasi penyimpanan) sama-sama bergantung pada kontrak interface `AccountRepository` yang disuntikkan melalui constructor.

------------------------------------------------------------------------
