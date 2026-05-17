package com.rpg.entitas; // untuk declair package entitas untuk bisa diakses oleh class lain
import com.rpg.arena.Karakter; // untuk mengimport class Karakter dari package arena agar bisa digunakan di class Pahlawan

public class Pahlawan extends Karakter { // untuk membuat class Pahlawan yang merupakan turunan dari class Karakter
    private int mana; // untuk menampung data mana
    private int level; // untuk menampung data level

    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) { // constructor untuk class Pahlawan dengan parameter nama, hp, baseDamage, mana, dan level
        super(nama, hp, baseDamage); // untuk memanggil constructor dari class Karakter dengan parameter nama, hp, dan baseDamage
        this.mana = mana; // menginisialisasi mana dengan parameter mana
        this.level = level; // menginisialisasi level dengan parameter level
    }

    // getter dan setter untuk mana dan level
    public int getMana() { 
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    // method yang di override dari class Karakter untuk implementasi aksi bertarung yang spesifik untuk Pahlawan
    @Override
    public int serang() {
        return baseDamage * level; // mengembalikannilai damage yang dihasilkan berdasarkan baseDamage dan level pahlawan
    }

    @Override
    public void Bertahan() {
        isDefending = true; //set isDefending ke true untuk menandakan bahwa pahlawan sedang bertahan
        System.out.println(nama + " bersiaga dan siap bertahan!"); // menampilkan pesan bahwa pahlawan sedang bertahan
    }

    @Override
    public void gunakanItem() { 
        hp += 30; //hp bertambah 30 saat menggunakan item
        System.out.println(nama + " menggunakan item! HP bertambah 30!"); // menampilkan pesan bahwa pahlawan menggunakan item dan hp bertambah
    }

    @Override
    public void tampilkanStatus() {
        System.out.println("=== Status " + nama + " ==="); //menampilkan status pahlawan dengan nama pahlawan, dan informasi hp, mana, dan level
        System.out.println("HP  : " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Level: " + level);
        System.out.println("========================");
    }

    // Method Overloading dengan parameter tambahan untuk serang
    public int serang(String namaSkill, int manaCost) {
        if (mana >= manaCost) { //jika mana lebih dari atau sama dengan manaCost, maka pahlawan dapat menggunakan skill
            mana -= manaCost; // mana akan dikurangi dengan manaCost saat menggunakan skill
            System.out.println(nama + " menggunakan skill " + namaSkill + "!"); // menampilkan pesan bahwa pahlawan menggunakan skill dengan nama skill yang digunakan
            return baseDamage * level * 2; // mengembalikan nilai damage yang dihasilkan oleh skill, yang lebih besar dari serangan biasa
        } else { // jika tidak 
            System.out.println("Mana tidak cukup untuk menggunakan " + namaSkill + "!"); // menampilkan pesan bahwa mana tidak cukup untuk menggunakan skill
            return 0; // mengembalikan 0 jika mana tidak cukup untuk menggunakan skill
        }
    }
}
