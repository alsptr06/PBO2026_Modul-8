import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        PengirimanDarat darat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        PengirimanUdara udara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);

        darat.updateStatus("Sedang di jalan tol Cipali");
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");

        List<LayananPengiriman> daftarPengiriman = new ArrayList<>();
        daftarPengiriman.add(darat);
        daftarPengiriman.add(udara);

        for (LayananPengiriman lp : daftarPengiriman) {
            System.out.println("================================");
            lp.cetakResi();

            if (lp instanceof LacakKargo) {
                LacakKargo lk = (LacakKargo) lp;
                System.out.println("Lokasi Terakhir: " + lk.cekLokasiTerakhir());
            }

            double ongkos = lp.hitungOngkosKirim();

            if (lp instanceof Asuransi) {
                Asuransi a = (Asuransi) lp;
                a.cetakPolis();
                double premi = a.hitungPremi(((PengirimanUdara) lp).getNilaiBarang());
                System.out.println("Premi Asuransi: Rp " + premi);
                ongkos += premi;
            }

            System.out.println("Total Tagihan: Rp " + ongkos);
            System.out.println("================================");
            System.out.println();
        }
    }
}