import java.util.Scanner;

public class HitungIP02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String namaMahasiswa, namaMataKuliah, nilai, konf="y";
        double IP=0.0, totalIPSKS = 0, indeksNilai = 0.0;
        int jumlahMataKuliah=0, sks, totalSKS = 0, jumlahRemidi = 0;

        System.out.print("Masukkan nama mahasiswa: ");
        namaMahasiswa = input.nextLine();
        do {

            // System.out.print("Masukkan jumlah mata kuliah: ");
            // jumlahMataKuliah = input.nextInt();

            // System.out.println("Mata Kuliah ke-" + i);
            // input.nextLine(); // Membersihkan buffer
            System.out.print("Nama Mata Kuliah: ");
            namaMataKuliah = input.nextLine();

            System.out.print("Nilai (A, B+, B, C+, C, D, E): ");
            nilai = input.nextLine();

            switch (nilai) {
                case "A":
                    indeksNilai = 4.0;
                    break;
                case "B+":
                    indeksNilai = 3.5;
                    break;
                case "B":
                    indeksNilai = 3.0;
                    break;
                case "C+":
                    indeksNilai = 2.5;
                    break;
                case "C":
                    indeksNilai = 2.0;
                    break;
                case "D":
                    indeksNilai = 1.0;
                    jumlahRemidi++;
                    break;
                case "E":
                    indeksNilai = 0.0;
                    jumlahRemidi++;
                    break;
                default:
                    System.out.println("Nilai tidak valid. Nilai diabaikan.");
                    continue; // Skip this iteration and move to the next
            }
            System.out.print("SKS: ");
            sks = input.nextInt();
            
            totalIPSKS += indeksNilai * sks;
            totalSKS += sks;
            jumlahMataKuliah++;

            input.nextLine();

            System.out.print("Apakah lanjut input nilai (Y/N): ");
            konf = input.nextLine().toUpperCase();
        }while (konf.equalsIgnoreCase("y"));
            
            // switch (konf) {
            //     case "n":
                    
            //         break;
            // }
        if (totalSKS>0) {
            IP = totalIPSKS / totalSKS;
        }

        System.out.println("===== Hasil Perhitungan IP =====");
        System.out.println("Nama Mahasiswa: " + namaMahasiswa);
        System.out.println("Indeks Prestasi (IP): " + IP);
        System.out.println("Total Mata Kuliah: " + jumlahMataKuliah);
        System.out.println("Total SKS: " + totalSKS);
        System.out.println("Jumlah Mata Kuliah yang harus perbaikan/remidi: " + jumlahRemidi);

        input.close();
    }
}