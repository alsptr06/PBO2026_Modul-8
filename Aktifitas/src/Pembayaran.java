public abstract class Pembayaran {
    protected String namaPembayaran;
    protected double nominalPembayaran;
    public Pembayaran(String namaPembayaran, double nominalPembayaran) {
        this.namaPembayaran = namaPembayaran;
        this.nominalPembayaran = nominalPembayaran;
    }
    public void tampilkanInfoPembayaran() {
        System.out.println("Nama Pembayaran: " + namaPembayaran);
        System.out.println("Nominal Pembayaran: " + nominalPembayaran);
    }

    public abstract void prosesPembayaran();

    interface keamanan {
        boolean verifikasiKeamanan();

    }
}
