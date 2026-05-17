package com.rpg.entitas; // untuk declair package entitas untuk bisa diakses oleh class lain

import com.rpg.arena.Karakter; // untuk mengimport class Karakter dari package arena agar bisa digunakan di class Monster

public class Monster extends Karakter {
    private String jenisMonster; // untuk menampung data jenisMonster   

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) { // constructor untuk class Monster dengan parameter nama, hp, baseDamage, dan jenisMonster
        super(nama, hp, baseDamage); // untuk memanggil constructor dari class Karakter dengan parameter nama, hp, dan baseDamage
        this.jenisMonster = jenisMonster; //menginisialisasi jenisMonster dengan parameter jenisMonster
    }

    // getter dan setter untuk jenisMonster
    public String getJenisMonster() {
        return jenisMonster;
    }
    public void setJenisMonster(String jenisMonster) {
        this.jenisMonster = jenisMonster;
    }

    //method yang di override dari class Karakter untuk implementasi aksi bertarung yang spesifik untuk Monster
    @Override
    public int serang() {
        return baseDamage; //mengembalikan nilai damage yang dihasilkan berdasarkan baseDamage monster
    }

    @Override
    public void Bertahan() {
        int heal = 10; //menginisialisasi heal dengan nilai 10
        hp += heal; //hp bertambah dengan nilai heal saat monster bertahan
        System.out.println(nama + " memulihkan diri! HP bertambah " + heal + "!"); //menampilkan pesan bahwa monster memulihkan diri dan hp bertambah dengan nilai heal
    }

    @Override
    public void gunakanItem() {
        System.out.println(nama + " tidak bisa menggunakan item!"); //menampilkan pesan bahwa monster tidak bisa menggunakan item
    }

    @Override
    public void tampilkanStatus() { 
        System.out.println("=== Status " + nama + " (" + jenisMonster + ") ===");//menampilkan status monster dengan nama monster, jenis monster, dan informasi hp serta baseDamage
        System.out.println("HP  : " + hp);
        System.out.println("Base Damage: " + baseDamage);
        System.out.println("========================");
    }
}