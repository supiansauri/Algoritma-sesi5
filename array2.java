import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class array2 {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    String[][] Buah = {
      {"apel", "35000"},
      {"jeruk", "50000"},
      {"mangga", "25000"},
      {"duku", "15000"},
      {"semangka", "20000"},
    };
    ArrayList<String[]> keranjangBuah = new ArrayList<String[]>();

    int pilihan;

    while (true){
      System.out.println("Menu:");
      System.out.println("1. Beli buah");
      System.out.println("2. Struk belanja");
      System.out.println("3. Keluar");

      System.out.print("Masukan pilihan: ");
      pilihan = scanner.nextInt();

      if (pilihan == 3){
        break;
      }

      if (pilihan == 1){

        printTable(new String[] {"Buah", "Harga"}, Buah);
        System.out.print("Pilih buah (0-4): ");
        int indexBuah = scanner.nextInt();
        System.out.print("Masukan jumlah: ");
        int jumlah = scanner.nextInt();

        try {
          String[] buah = Buah[indexBuah];

          for (int i = 0; i < jumlah; i++){
            keranjangBuah.add(buah);
          }
        } catch (Exception e) {
          System.out.println("Buah tidak tersedia");
        }
      }

      if (pilihan == 2){
        HashMap<String[], String[]> daftarBelanjaan = new HashMap<>();

        for (int i = 0; i < keranjangBuah.size(); i++){
          String[] belanjaan = daftarBelanjaan.get(keranjangBuah.get(i));
          if (belanjaan == null){
            belanjaan = new String[] {
              keranjangBuah.get(i)[0],
              "0",
              keranjangBuah.get(i)[1],
              "0"
            };
          }

          belanjaan[1] = Integer.toString(Integer.parseInt(belanjaan[1]) + 1);
          belanjaan[3] = Integer.toString(Integer.parseInt(belanjaan[1]) * Integer.parseInt(belanjaan[2]));
          daftarBelanjaan.put(keranjangBuah.get(i), belanjaan);
        }

        printTable(new String[] {"Nama buah", "Jumlah", "Harga", "Subtotal"}, daftarBelanjaan.values().toArray(new String[daftarBelanjaan.size()][4]));
      }
    }
    scanner.close();
  }

  static void printTable(String[] kolom, String[][] data){

    System.out.println("\n================================================================================");
    System.out.print("No.\t");
    for (int i = 0; i < kolom.length; i++){
      System.out.print(kolom[i]);
      if (kolom[i].length() >= 8){
        System.out.print("\t");
      }else{
        System.out.print("\t\t");
      }
    }

    System.out.println();
    for (int i = 0; i < data.length; i++){
      System.out.print(i + 1 + "\t");
      for (int j = 0; j < kolom.length; j++){
        System.out.print(data[i][j]);
        if (data[i][j].length() >= 8){
          System.out.print("\t");
        }else{
          System.out.print("\t\t");
        }
      }
      if (i == data.length - 1){
        System.out.println("\n================================================================================");
      }else{
        System.out.println();
      }
    }
  }
}