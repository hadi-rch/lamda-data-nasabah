package com.enigma.camp.data_nasabah;

public class Nasabah {
    public String nama;
    public int umur;
    public double saldo;
    public String statusKredit;

    public Nasabah(String nama, int umur, double saldo, String statusKredit) {
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
