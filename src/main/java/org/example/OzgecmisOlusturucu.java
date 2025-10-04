package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font; // Bu satır değişti
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File; // Bu satır eklendi
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OzgecmisOlusturucu {
    public static void main(String[] args) {
        try {
            PDDocument dokuman = new PDDocument();

            // --- YENİ KISIM: TÜRKÇE DESTEKLİ FONT'LARI YÜKLEME ---
            // Bu kod Windows'taki standart Arial fontlarını kullanır.
            PDType0Font arialNormal = PDType0Font.load(dokuman, new File("C:/Windows/Fonts/arial.ttf"));
            PDType0Font arialBold = PDType0Font.load(dokuman, new File("C:/Windows/Fonts/arialbd.ttf"));
            PDType0Font arialItalic = PDType0Font.load(dokuman, new File("C:/Windows/Fonts/ariali.ttf"));
            // --- YENİ KISIM BİTTİ ---

            KisiselBilgiler kisi = new KisiselBilgiler(
                    "Ahmet Yılmaz", "ahmet.yilmaz@email.com", "+90 555 123 45 67", "İstanbul, Türkiye");

            List<IsDeneyimi> deneyimler = new ArrayList<>();
            deneyimler.add(new IsDeneyimi("Yazılım Geliştirici", "Teknoloji A.Ş.", "Ocak 2022 - Günümüz", "- Java ve Spring Boot kullanarak web servisleri geliştirdim.\n- Proje geliştirme süreçlerinde aktif rol aldım."));
            deneyimler.add(new IsDeneyimi("Stajyer Yazılım Mühendisi", "Bilişim Çözümleri Ltd. Şti.", "Haziran 2021 - Ağustos 2021", "- Mevcut bir projenin test süreçlerine destek oldum.\n- Yazılım dokümantasyonu hazırladım."));
            deneyimler.add(new IsDeneyimi("Junior Developer", "Kodlama Akademisi", "Ocak 2020 - Aralık 2020", "- Veritabanı yönetimi ve SQL sorguları yazdım.\n- Basit arayüz tasarımlarına yardımcı oldum."));

            PDPage sayfa = new PDPage();
            dokuman.addPage(sayfa);

            PDPageContentStream icerikAkisi = new PDPageContentStream(dokuman, sayfa);

            PDImageXObject profilFoto = PDImageXObject.createFromFile("profil-fotografi.jpg", dokuman);
            icerikAkisi.drawImage(profilFoto, 450, 650, 100, 120);

            icerikAkisi.beginText();
            icerikAkisi.setFont(arialBold, 24); // Font değişti
            icerikAkisi.newLineAtOffset(50, 750);
            icerikAkisi.showText(kisi.adSoyadiAl());
            icerikAkisi.endText();

            icerikAkisi.beginText();
            icerikAkisi.setFont(arialNormal, 12); // Font değişti
            icerikAkisi.newLineAtOffset(50, 720);
            icerikAkisi.showText("Email: " + kisi.emailAdresiniAl());
            icerikAkisi.newLineAtOffset(0, -20);
            icerikAkisi.showText("Telefon: " + kisi.telefonNumarasiniAl());
            icerikAkisi.newLineAtOffset(0, -20);
            icerikAkisi.showText("Adres: " + kisi.adresiAl());
            icerikAkisi.endText();

            icerikAkisi.beginText();
            icerikAkisi.setFont(arialBold, 18); // Font değişti
            icerikAkisi.newLineAtOffset(50, 650);
            icerikAkisi.showText("İş Deneyimi");
            icerikAkisi.endText();

            int yPozisyonu = 620;
            for (IsDeneyimi deneyim : deneyimler) {
                icerikAkisi.beginText();
                icerikAkisi.setFont(arialBold, 14); // Font değişti
                icerikAkisi.newLineAtOffset(60, yPozisyonu);
                icerikAkisi.showText(deneyim.pozisyonuAl() + " - " + deneyim.sirketiAl());
                icerikAkisi.endText();

                yPozisyonu -= 20;

                icerikAkisi.beginText();
                icerikAkisi.setFont(arialItalic, 12); // Font değişti
                icerikAkisi.newLineAtOffset(60, yPozisyonu);
                icerikAkisi.showText(deneyim.tarihleriAl());
                icerikAkisi.endText();

                yPozisyonu -= 20;

                icerikAkisi.beginText();
                icerikAkisi.setFont(arialNormal, 11); // Font değişti
                icerikAkisi.newLineAtOffset(70, yPozisyonu);
                for (String satir : deneyim.aciklamayiAl().split("\n")) {
                    icerikAkisi.showText(satir);
                    icerikAkisi.newLineAtOffset(0, -15);
                    yPozisyonu -=15;
                }
                icerikAkisi.endText();
                yPozisyonu -= 20;
            }

            icerikAkisi.close();
            dokuman.save("Ozgecmis.pdf");
            dokuman.close();

            System.out.println("Özgeçmiş PDF'i başarıyla oluşturuldu: Ozgecmis.pdf");

        } catch (IOException hata) {
            System.err.println("PDF oluşturulurken bir hata oluştu: " + hata.getMessage());
            hata.printStackTrace();
        }
    }
}