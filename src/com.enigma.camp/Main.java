package com.enigma.camp;


import java.util.*;
import java.util.stream.*;

public class Main {
    static class Nasabah {
        String nama;
        int umur;
        double saldo;
        String statusKredit;

        Nasabah(String nama, int umur, double saldo, String statusKredit) {
            this.nama = nama;
            this.umur = umur;
            this.saldo = saldo;
            this.statusKredit = statusKredit;
        }

        @Override
        public String toString() {
            return nama + " (Umur: " + umur + ", Saldo: " + saldo + ", Status Kredit: " + statusKredit + ")";
        }
    }

    public static void main(String[] args) {
        List<Nasabah> nasabahList = List.of(
                new Nasabah("Alice Johnson", 34, 2400.50, "baik"),
                new Nasabah("Bob Smith", 22, 1500.00, "baik"),
                new Nasabah("Charlie Davis", 41, 5600.25, "netral"),
                new Nasabah("Diana Reed", 29, 2900.75, "buruk"),
                new Nasabah("Ethan Fox", 37, 4700.00, "baik"),
                new Nasabah("Fiona Green", 45, 3200.50, "netral"),
                new Nasabah("George White", 31, 1500.00, "buruk")
        );

        // 1. Jumlah nasabah
        long jumlahNasabah = nasabahList.size();
        System.out.println("Jumlah nasabah: " + jumlahNasabah);

        // 2. Jumlah total saldo tabungan
        double totalSaldo = nasabahList.stream()
                .mapToDouble(n -> n.saldo)
                .sum();
        System.out.println("Total saldo tabungan: " + totalSaldo);

        // 3. Rata-rata saldo nasabah dengan status kredit "baik"
        double rataRataBaik = nasabahList.stream()
                .filter(n -> n.statusKredit.equalsIgnoreCase("baik"))
                .mapToDouble(n -> n.saldo)
                .average()
                .orElse(0);
        System.out.println("Rata-rata saldo (kredit baik): " + rataRataBaik);

        // 4. Nasabah dengan saldo tabungan paling rendah
        Nasabah saldoTerkecil = nasabahList.stream()
                .min(Comparator.comparingDouble(n -> n.saldo))
                .orElse(null);
        System.out.println("Nasabah dengan saldo paling rendah: " + saldoTerkecil);

        // 5. Daftar nama nasabah dengan status kredit "buruk"
        List<String> kreditBuruk = nasabahList.stream()
                .filter(n -> n.statusKredit.equalsIgnoreCase("buruk"))
                .map(n -> n.nama)
                .collect(Collectors.toList());
        System.out.println("Nasabah dengan kredit buruk: " + kreditBuruk);

        // 6. Nasabah dengan umur paling tua
        Nasabah tertua = nasabahList.stream()
                .max(Comparator.comparingInt(n -> n.umur))
                .orElse(null);
        System.out.println("Nasabah tertua: " + tertua);
    }
}
