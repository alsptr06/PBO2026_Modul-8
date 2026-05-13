public class App {
    public static void main(String[] args) throws Exception {
        Pembayaran[] daftarTransaksi = new Pembayaran[2];

        
        daftarTransaksi[0] = new KartuKredit("Budi Santoso", 500000, "1234-5678-9012-3456");
        daftarTransaksi[1] = new EWallet("Ani Wijaya", 250000, "081234567890");

        
        System.out.println("========== SISTEM PEMBAYARAN DIGITAL ==========\n");

        for (Pembayaran transaksi : daftarTransaksi) {
            transaksi.tampilkanDetail();

            
            if (transaksi instanceof Keamanan) {
                Keamanan keamanan = (Keamanan) transaksi;

                
                if (keamanan.autentikasi()) {
                    transaksi.prosesPembayaran();
                } else {
                    System.out.println("Autentikasi gagal! Pembayaran dibatalkan.");
                }
            }
            System.out.println();
        }
    }
}