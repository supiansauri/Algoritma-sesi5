import java.util.Scanner;

public class array1 {
  public static void main(String[] args){
    Scanner inputan = new Scanner(System.in);
    System.out.println();
    System.out.print("Masukan jumlah data: ");
    int n = inputan.nextInt();

    String[] namaMahasiswa = new String[n];
    int[] nilaiMahasiswa = new int[n];

    for (int i = 1; i < n + 1; i++){
      System.out.println("\n------------------------");
      System.out.println("Mahasiswa ke " + i);
      System.out.print("Nama: ");
      namaMahasiswa[i - 1] = inputan.next();
      System.out.print("Nilai: ");
      nilaiMahasiswa[i - 1] = inputan.nextInt();
    }

    System.out.println("\nDAFTAR NILAI MAHASIWA");
    System.out.println("=========================");
    System.out.println("No\tNama\tNilai\tStatus");
    for (int i = 1; i < namaMahasiswa.length + 1; i++){
      String nama = namaMahasiswa[i - 1];
      int nilai = nilaiMahasiswa[i - 1];
      String status = nilai >= 70 ? "Lulus" : "Tidak lulus";
      System.out.println(i+"\t"+nama+"\t"+nilai+"\t"+status);
    }
    System.out.println("=========================");
    float jumlah = 0;
    for (int i = 0; i < nilaiMahasiswa.length; i++){
      jumlah+= nilaiMahasiswa[i];
    }
    float rataRata = jumlah / nilaiMahasiswa.length;
    System.out.println("Jumlah: " + jumlah);
    System.out.println("Nilai Rata-rata: " + rataRata);

    inputan.close();
  }
}