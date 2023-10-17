import java.util.Scanner;
    public class Toko02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("  Program Toko  ");
        System.out.println();
        System.out.print("Masukkan nama Anda: ");
        String namaPelanggan = sc.nextLine();

        boolean isMember = false;
        double totalHargaSebelumDiskon = 0;
        double totalDiskon = 0;
        int totalItemBarang = 0;

        while (true) {
            System.out.print("Apakah Anda member (y/n)? ");
            String memberStatus = sc.next();
            if (memberStatus.equalsIgnoreCase("y")) {
                isMember = true;
            }

            System.out.print("Masukkan nama produk yang Anda beli: ");
            String namaProduk = sc.next();
            System.out.print("Masukkan kuantitas produk yang Anda beli: ");
            int kuantitas = sc.nextInt();
            System.out.print("Masukkan harga satuan produk: ");
            double hargaSatuan = sc.nextDouble();
            System.out.print("Apakah ada diskon untuk produk ini (y/n)? ");
            String adaDiskon = sc.next();
            double diskon = 0;

            if (adaDiskon.equalsIgnoreCase("y")) {
                System.out.print("Masukkan persentase diskon: ");
                double persentaseDiskon = sc.nextDouble();
                diskon = hargaSatuan * persentaseDiskon / 100;
            }

            double totalHargaProduk = (hargaSatuan - diskon) * kuantitas;
            totalHargaSebelumDiskon += totalHargaProduk;
            totalDiskon += diskon;
            totalItemBarang += kuantitas;

            System.out.print("Apakah Anda ingin menambahkan produk lagi (y/n)? ");
            String tambahProduk = sc.next();
            if (!tambahProduk.equalsIgnoreCase("y")) {
                break;
            }
        }

        
        System.out.println("Total Pembelian");
        System.out.println();

        // Menghitung diskon tambahan berdasarkan status member
        if (isMember && totalHargaSebelumDiskon >= 200000) {
            totalDiskon += 0.1 * totalHargaSebelumDiskon;
        } else if (isMember) {
            totalDiskon += 0.05 * totalHargaSebelumDiskon;
        }

        // Menghitung total akhir
        double totalAkhir = totalHargaSebelumDiskon - totalDiskon;

        // Output informasi
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Tipe Pelanggan: " + (isMember ? "Member" : "Bukan Member"));
        System.out.println("Total Item Barang: " + totalItemBarang);
        System.out.println("Total Harga Sebelum Diskon: " + totalHargaSebelumDiskon);
        System.out.println("Total Diskon: " + totalDiskon);
        System.out.println("Total Akhir: " + totalAkhir);
    }
}