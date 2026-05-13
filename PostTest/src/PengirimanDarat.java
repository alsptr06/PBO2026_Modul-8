class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    private String jenisTruk;
    private String statusSaatIni;

    public PengirimanDarat(String noResi, double beratBarang, double jarakTempuh, String jenisTruk) {
        super(noResi, beratBarang, jarakTempuh);
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir";
    }

    @Override
    public double hitungOngkosKirim() {
        double biaya = (beratBarang * 5000) + (jarakTempuh * 2000);
        if (jenisTruk.equalsIgnoreCase("Tronton")) {
            biaya += 150000;
        }
        return biaya;
    }

    @Override
    public void updateStatus(String status) {
        statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }
}