class EWallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    public EWallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Metode: E-Wallet");
        System.out.println("Nomor HP: " + nomorHP);
        System.out.println("Total Tagihan: Rp" + nominal + " (tanpa biaya admin)");
        System.out.println("----------------------------------------");
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi E-Wallet berhasil!");
        return true;
    }
}