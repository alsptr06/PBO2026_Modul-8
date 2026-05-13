public class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

    public PengirimanUdara(String noResi, double beratBarang, double jarakTempuh, String nomorPenerbangan,
            double nilaiBarang) {
        super(noResi, beratBarang, jarakTempuh);
        this.nomorPenerbangan = nomorPenerbangan;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
        this.nilaiBarang = nilaiBarang;
    }

    @Override
    public double hitungOngkosKirim() {
        return (beratBarang * 25000) + (jarakTempuh * 5000);
    }

    @Override
    public void updateStatus(String status) {
        statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }

    @Override
    public double hitungPremi(double nilaiBarang) {
        return nilaiBarang * 0.03;
    }

    public double getNilaiBarang() {
        return nilaiBarang;
    }
}