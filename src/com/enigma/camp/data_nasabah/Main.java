package com.enigma.camp.data_nasabah;

import java.util.*;
import java.util.stream.*;

public class Main {
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

        System.out.println("Jumlah nasabah: " + nasabahList.size());

        GetSaldo debit = n -> n.saldo;

        double totalSavings = nasabahList.stream()
                .mapToDouble(debit::methodGetSaldo)
                .sum();
        System.out.println("Total saldo tabungan: " + totalSavings);

        FilterNasabah goodCredit = n -> n.statusKredit.equalsIgnoreCase("baik");
        double avgGoodCredit = nasabahList.stream()
                .filter(goodCredit::nasabahFilter)
                .mapToDouble(debit::methodGetSaldo)
                .average()
                .orElse(0);
        System.out.println("Rata-rata saldo (kredit baik): " + avgGoodCredit);

        
        double smallestSavings = nasabahList.stream()
                 .mapToDouble(debit::methodGetSaldo)
                 .min()
                 .orElse(0);

         List<Nasabah> nasabahDenganSaldoTerkecil = nasabahList.stream()
                 .filter(n -> n.saldo == smallestSavings)
                 .collect(Collectors.toList());

         System.out.println("Nasabah dengan saldo paling rendah:");
         nasabahDenganSaldoTerkecil.forEach(System.out::println);


        FilterNasabah badCredits = n -> n.statusKredit.equalsIgnoreCase("buruk");
        List<String> listOfBadCredits = nasabahList.stream()
                .filter(badCredits::nasabahFilter)
                .map(n -> n.nama)
                .collect(Collectors.toList());
        System.out.println("Nasabah dengan kredit buruk: " + listOfBadCredits);

        GetAge ageOfNasabah = n -> n.umur;
        Nasabah older = nasabahList.stream()
                .max(Comparator.comparingInt(ageOfNasabah::ambil))
                .orElse(null);
        System.out.println("Nasabah tertua: " + older);
    }
}
