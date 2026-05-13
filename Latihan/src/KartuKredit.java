class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;

    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    @Override
    public void prosesPembayaran() {
        double biayaAdmin = nominal * 0.02;
        double totalTagihan = nominal + biayaAdmin;
        System.out.println("Metode: Kartu Kredit");
        System.out.println("Nomor Kartu: " + nomorKartu);
        System.out.println("Biaya Admin (2%): Rp" + biayaAdmin);
        System.out.println("Total Tagihan: Rp" + totalTagihan);
        System.out.println("----------------------------------------");
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi Kartu Kredit berhasil!");
        return true;
    }
}
