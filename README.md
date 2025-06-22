# Proyek Data Nasabah

Proyek ini adalah program Java sederhana yang mengelola daftar data nasabah. Program ini melakukan beberapa operasi pada data nasabah, seperti menghitung total saldo, mencari nasabah berdasarkan kriteria tertentu (status kredit, usia), dan menampilkan informasi relevan.

## Fitur

*   Menampilkan jumlah total nasabah.
*   Menghitung dan menampilkan total saldo dari semua nasabah.
*   Menghitung dan menampilkan rata-rata saldo nasabah dengan status kredit "baik".
*   Menemukan dan menampilkan nasabah dengan saldo tabungan terkecil.
*   Mencantumkan nama-nama nasabah dengan status kredit "buruk".
*   Menemukan dan menampilkan nasabah tertua.

## Cara Menjalankan Proyek

Proyek ini menggunakan Maven. Untuk mengompilasi dan menjalankan proyek, ikuti langkah-langkah berikut:

1.  **Pastikan Anda memiliki Java Development Kit (JDK) dan Maven terinstal.**
    *   Proyek ini dikonfigurasi untuk menggunakan Java 17.

2.  **Kompilasi Proyek:**
    Buka terminal atau command prompt, navigasikan ke direktori root proyek (tempat `pom.xml` berada), dan jalankan perintah berikut:
    ```bash
    mvn compile
    ```

3.  **Jalankan Proyek:**
    Setelah kompilasi berhasil, jalankan kelas utama dengan perintah berikut:
    ```bash
    mvn exec:java -Dexec.mainClass="com.enigma.camp.data_nasabah.Main"
    ```

## Contoh Output

Berikut adalah contoh output yang akan ditampilkan ketika program dijalankan:

```
Jumlah nasabah: 7
Total saldo tabungan: 22001.5
Rata-rata saldo (kredit baik): 3033.5
Nasabah dengan saldo paling rendah:
Nasabah{nama='Bob Smith', umur=22, saldo=1500.0, statusKredit='baik'}
Nasabah{nama='George White', umur=31, saldo=1500.0, statusKredit='buruk'}
Nasabah dengan kredit buruk: [Diana Reed, George White]
Nasabah tertua: Nasabah{nama='Fiona Green', umur=45, saldo=3200.5, statusKredit='netral'}
```

## Struktur Proyek

*   `pom.xml`: File konfigurasi Maven untuk proyek.
*   `src/com/enigma/camp/data_nasabah/`: Direktori utama untuk kode sumber Java.
    *   `Main.java`: Kelas utama yang berisi logika program.
    *   `Nasabah.java`: Kelas yang merepresentasikan entitas nasabah.
    *   `FilterNasabah.java`: Interface fungsional untuk memfilter nasabah.
    *   `GetAge.java`: Interface fungsional untuk mendapatkan usia nasabah.
    *   `GetName.java`: Interface fungsional untuk mendapatkan nama nasabah.
    *   `GetSaldo.java`: Interface fungsional untuk mendapatkan saldo nasabah.
```
