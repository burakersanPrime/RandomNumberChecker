import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Islemler {
    public void yazıcı(){

        String dosya = "sayilar.txt";
        int altsinir = 100;
        int ustsinir = 200;
        int adet = 50;
        try {
            FileWriter dosyaYazici = new FileWriter(dosya);
            PrintWriter printYazici = new PrintWriter(dosyaYazici);

            Random random = new Random();
            for (int i = 0; i < adet; i++) {
                int sayi = random.nextInt((ustsinir - altsinir) + 1) + altsinir;
                printYazici.println(sayi);
            }

            dosyaYazici.close();
            System.out.println("\n");
            System.out.println("Random Sayılar " + dosya + " Dosyasına Kaydedildi.");
            System.out.println("\n");
        } catch (IOException e) {
            System.out.println("Dosya Yazılamadı: " + e.getMessage());
        }
    }
    public void kontrol(){
        String dosyayolu = "sayilar.txt";
        try {
            int toplam = 0;
            BufferedReader br = new BufferedReader(new FileReader(dosyayolu));
            String satir;
            while ((satir = br.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                toplam += sayi;
            }
            br.close();
            if (toplam < 7000 || toplam > 8000) {
                File dosya = new File(dosyayolu);
                dosya.delete();

                FileWriter fw = new FileWriter(dosyayolu);
                fw.write("yeni_veri_1\n");
                fw.write("yeni_veri_2\n");
                fw.close();
                System.out.println("7000 Ve 8000 Aralığı Şartını Sağlamadığı İçin Dosya Silindi Ve Yeniden Oluşturuldu.");
                System.out.println("\n");
            } else {
                System.out.println("Dosya Kontrol Edildi 7000 , 8000 Aralığı Değerleri Sağlandı. Toplam: " + toplam);
                System.out.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void büyükkücükkontrol(){
        String dosyayolu = "sayilar.txt";
        try {
            ArrayList<Integer> sayilar = new ArrayList<>();
            int toplam = 0;
            BufferedReader br = new BufferedReader(new FileReader(dosyayolu));
            String satir;
            while ((satir = br.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                sayilar.add(sayi);
                toplam += sayi;
            }
            br.close();
            if (toplam < 7500) {
                Collections.sort(sayilar);

                FileWriter fw = new FileWriter(dosyayolu);
                for (int sayi : sayilar) {
                    fw.write(sayi + "\n");
                }
                fw.close();

                System.out.println("7500 Sınırının Altında Kaldığı İçin Sayılar Küçükten Büyüğe Yazıldı.");
                System.out.println("\n");
            }
            else {
                Collections.sort(sayilar, Collections.reverseOrder());

                FileWriter fw = new FileWriter(dosyayolu);
                for (int sayi : sayilar) {
                    fw.write(sayi + "\n");
                }
                fw.close();

                System.out.println("7500 Sınırının Üzerinde Kaldığı İçin Sayılar Büyükten Küçüğe Yazıldı.");
                System.out.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ekranayazdırma(){
        String dosyayolu = "sayilar.txt";
        System.out.println("Son Durumu : ");

        try {
            BufferedReader br = new BufferedReader(new FileReader(dosyayolu));
            String satir;
            while ((satir = br.readLine()) != null) {
                System.out.println(satir);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





