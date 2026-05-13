public class KartuKredit extends Pembayaran {
    private String nomorKartuKredit;

    public KartuKredit(String namaPembayaran, double nominalPembayaran, String nomorKartuKredit) {
        super(namaPembayaran, nominalPembayaran);
        this.nomorKartuKredit = nomorKartuKredit;
    }
    @Override
    public void prosesPembayaran() {
        System.out.println("Memproses pembayaran dengan kartu kredit...");
        System.out.println("Nomor Kartu Kredit: " + nomorKartuKredit);
        System.out.println("Nominal Pembayaran: " + nominalPembayaran);
        System.out.println("biaya tambahan 2% dari nominal pembayaran: " + (nominalPembayaran * 0.02));
    }

    @Override
    public boolean verifikasiKeamanan() {
        return true;
    }
    
}
