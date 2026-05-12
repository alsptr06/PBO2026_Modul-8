public class App {
    public static void main(String[] args) throws Exception {
        karyawan karyawan1 = new Programmer("Alice", 5000);
        karyawan karyawan2 = new Programmer("Bob", 3000);

        System.out.println("Gaji karyawan 1: "+ karyawan1.nama + ": " + karyawan1.hitungGaji());
        System.out.println("Gaji karyawan 2: " + karyawan2.nama + ": " + karyawan2.hitungGaji());
    }
}
