package com.rpg.arena; // untuk declair package arena untuk bisa diakses oleh class lain

public abstract class Karakter implements AksiBertarung { // untuk membuat abstract class dengan nama Karakter dengan implements interface AksiBertarung
    protected String nama; // untuk menampung data nama
    protected int hp; //untuk menampung data hp
    protected int baseDamage; // untuk menampung data baseDamage
    protected boolean isDefending; // untung menampung data isDefending

    public Karakter(String nama, int hp, int baseDamage) { //costructor untuk class Karakter dengan parameter nama, hp, dan baseDamage
        this.nama = nama; // menginisialisasi nama dengan parameter nama
        this.hp = hp; // menginisialisasi hp dengan parameter hp
        this.baseDamage = baseDamage; // menginisialisasi baseDamage dengan parameter baseDamage
        this.isDefending = false; // menginisialisasi isDefending dengan nilai false
    }

    // getter dan setter untuk nama, hp, dan baseDamage, serta isDefending
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public boolean isDefending() {
        return isDefending;
    }
    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }

    public void terimaDamage(int damage) { //method untuk mengurangi hp karakter
        if (isDefending) { // jika karakter sedang bertahan, maka damage yang diterima akan dibagi 2
            damage = damage / 2;  // damage akan dibagi 2 jika karakter sedang bertahan
            isDefending = false; //setelah terima damage, karakter tidak lagi bertahan, sehingga isDefending di set ke false
        }
        hp -= damage; // hp dikurangi dengan damage yang diterima
        if (hp < 0) { //jika hp mines
            hp = 0; //hp di set ke 0 
        }
    }

    public abstract void tampilkanStatus(); //abstract method untuk menampilkan status karakter, akan diimplementasikan di class turunannya
}
