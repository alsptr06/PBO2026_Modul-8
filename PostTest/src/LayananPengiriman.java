abstract class LayananPengiriman {
    protected String noResi;
    protected double beratBarang;
    protected double jarakTempuh;

    public LayananPengiriman(String noResi, double beratBarang, double jarakTempuh) {
        this.noResi = noResi;
        this.beratBarang = beratBarang;
        this.jarakTempuh = jarakTempuh;
    }

    public void cetakResi() {
        System.out.println("Nomor Resi: " + noResi);
        System.out.println("Berat Barang: " + beratBarang + " kg");
        System.out.println("Jarak Tempuh: " + jarakTempuh + " km");
    }

    public abstract double hitungOngkosKirim();
}

interface LacakKargo {
    void updateStatus(String status);

    String cekLokasiTerakhir();
}

interface Asuransi {
    double hitungPremi(double nilaiBarang);

    default void cetakPolis() {
        System.out.println(
                "Polis Asuransi aktif. Menanggung kehilangan dan kerusakan fisik sebesar 100% dari nilai barang.");
    }
}
