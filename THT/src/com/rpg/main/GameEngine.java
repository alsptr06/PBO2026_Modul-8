package com.rpg.main; // package utama untuk menjalankan game RPG

import java.util.Scanner; // import Scanner untuk membaca input dari user
import com.rpg.entitas.Pahlawan; // import class Pahlawan dari package com.rpg.entitas
import com.rpg.entitas.Monster; // import class Monster dari package com.rpg.entitas

public class GameEngine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // membuat objek Scanner untuk membaca input dari user

        System.out.println("=== DUNGEON SURVIVAL RPG ===");
        System.out.print("Masukkan nama Pahlawan: ");
        String namaPahlawan = scanner.nextLine(); // membaca input dari user untuk nama pahlawan

        Pahlawan pahlawan = new Pahlawan(namaPahlawan, 100, 10, 50, 2); // membuat objek Pahlawan dengan nama, hp, attack, mp, dan jumlah item yang dimiliki

        Monster[] monsters = new Monster[3]; // membuat array untuk menyimpan monster yang akan dilawan oleh pahlawan
        monsters[0] = new Monster("Goblin", 50, 8, "Goblin"); // membuat objek Monster dengan nama, hp, attack, dan jenis monster
        monsters[1] = new Monster("Orc", 80, 12, "Orc"); // membuat objek Monster dengan nama, hp, attack, dan jenis monster
        monsters[2] = new Monster("Dragon", 120, 20, "Dragon"); // membuat objek Monster dengan nama, hp, attack, dan jenis monster

        System.out.println("\nSelamat datang, " + namaPahlawan + "!");
        System.out.println("Kamu harus mengalahkan " + monsters.length + " monster untuk menamatkan Dungeon!\n");

        
        for (int i = 0; i < monsters.length; i++) { // loop untuk melawan setiap monster yang ada di array monsters
            Monster monsterSaatIni = monsters[i]; // membuat objek Monster dengan nama, hp, attack, dan jenis monster yang akan dilawan oleh pahlawan saat ini
            System.out.println("\n>>> MUSUH KE-" + (i + 1) + ": " + monsterSaatIni.getNama() + " <<<");

            
            while (pahlawan.getHp() > 0 && monsterSaatIni.getHp() > 0) { // loop untuk melawan monster saat ini selama hp pahlawan dan hp monster masih di atas 0
                System.out.println("\n--- Giliran Kamu ---");
                pahlawan.tampilkanStatus(); // menampilkan status pahlawan
                monsterSaatIni.tampilkanStatus(); // menampilkan status monster saat ini

                System.out.println("\nPilih aksi:");
                System.out.println("1. Serang");
                System.out.println("2. Skill");
                System.out.println("3. Bertahan / Heal (Item)");
                System.out.print("Pilihan: ");
                int pilihan = scanner.nextInt();

                switch (pilihan) { // switch case untuk memilih aksi
                    case 1:
                        int damageKeMonster = pahlawan.serang(); // pahlawan menyerang monster, dan damage yang diterima monster disimpan di variabel damageKeMonster
                        monsterSaatIni.terimaDamage(damageKeMonster); // monster menerima damage dari pahlawan, dan hp monster berkurang sesuai dengan damage yang diterima
                        System.out.println(pahlawan.getNama() + " menyerang! Damage: " + damageKeMonster);
                        break; // jika pilihan 1, maka pahlawan menyerang monster dengan attack biasa
                    case 2:
                        int damageSkill = pahlawan.serang("Fireball", 15); // pahlawan menyerang monster dengan skill "Fireball" yang memiliki damage tambahan sebesar 15, dan damage yang diterima monster disimpan di variabel damageSkill
                        monsterSaatIni.terimaDamage(damageSkill); // monster menerima damage dari pahlawan, dan hp monster berkurang sesuai dengan damage yang diterima
                        if (damageSkill > 0) { // jika damage skill lebih besar dari 0, maka skill berhasil digunakan
                            System.out.println("Skill berhasil! Damage: " + damageSkill); 
                        }
                        break; // jika pilihan 2, maka pahlawan menyerang monster dengan skill "Fireball" yang memiliki damage tambahan sebesar 15
                    case 3:
                        pahlawan.Bertahan(); // pahlawan bertahan untuk mengurangi damage yang diterima pada giliran monster berikutnya
                        pahlawan.gunakanItem();// pahlawan menggunakan item untuk menyembuhkan diri sendiri, dan hp pahlawan bertambah sesuai dengan jumlah item yang dimiliki
                        break; // jika pilihan 3, maka pahlawan bertahan untuk mengurangi damage yang diterima pada giliran monster berikutnya, dan menggunakan item untuk menyembuhkan diri sendiri
                    default:// jika pilihan tidak valid, maka tampilkan pesan error
                        System.out.println("Pilihan tidak valid!");
                }

                
                if (monsterSaatIni.getHp() > 0) { // jika hp monster masih di atas 0, maka monster menyerang balik
                    System.out.println("\n--- Giliran " + monsterSaatIni.getNama() + " ---");
                    int damageKePahlawan = monsterSaatIni.serang(); // monster menyerang pahlawan, dan damage yang diterima pahlawan disimpan di variabel damageKePahlawan
                    pahlawan.terimaDamage(damageKePahlawan); // pahlawan menerima damage dari monster, dan hp pahlawan berkurang sesuai dengan damage yang diterima
                    System.out.println(monsterSaatIni.getNama() + " menyerang balik! Damage: " + damageKePahlawan);
                }
            }

            
            if (pahlawan.getHp() <= 0) { //jika hp pahlawan lebih kecil atau sama dengan 0, maka pahlawan gugur dan game over
                System.out.println("\n" + pahlawan.getNama() + " telah gugur...");
                break;
            } else { // selain itu, monster saat ini dikalahkan dan lanjut ke monster berikutnya
                System.out.println("\n" + monsterSaatIni.getNama() + " telah dikalahkan!");
            }
        }

        
        if (pahlawan.getHp() > 0) { // ji pahlawan masih hidup setelah melawan semua monster, maka victory
            System.out.println("\n========================================");
            System.out.println("  SELAMAT! " + pahlawan.getNama() + " BERHASIL MENAMATKAN DUNGEON!");
            System.out.println("========================================");
        } else { // selain itu, game over
            System.out.println("\n========================================");
            System.out.println("           GAME OVER");
            System.out.println("========================================");
        }

        scanner.close(); // menutup objek Scanner untuk mencegah memory leak
    }
}