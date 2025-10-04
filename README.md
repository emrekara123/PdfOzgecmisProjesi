# Java ile PDF Özgeçmiş Oluşturucu

Bu proje, Java programlama dili ve Apache PDFBox kütüphanesi kullanılarak geliştirilmiş, komut satırından çalışan basit bir uygulamadır. Uygulama, önceden tanımlanmış kişisel bilgileri ve iş deneyimlerini kullanarak bir PDF özgeçmiş dosyası oluşturur.

## Projenin Amacı

Bu projenin temel amacı, Nesneye Yönelik Programlama (OOP) prensiplerini kullanarak yapılandırılmış verilerden (kişisel bilgiler, iş deneyimleri) bir PDF belgesi üretmektir. Proje, Java'nın temel yeteneklerini ve harici kütüphane kullanımını göstermek için tasarlanmıştır.

## Özellikler

- Dinamik olarak PDF dosyası oluşturma.
- Özgeçmişe profil fotoğrafı ekleme.
- Kişisel bilgileri ve iletişim detaylarını içerme.
- Birden fazla iş deneyimini liste halinde ekleme.
- Türkçe karakterleri destekleyen font (Arial) kullanımı.

## Kullanılan Teknolojiler

- **Java**: Ana programlama dili.
- **Apache PDFBox**: PDF dokümanları oluşturmak ve işlemek için kullanılan açık kaynaklı Java kütüphanesi.
- **Maven**: Proje bağımlılıklarını yönetmek için kullanılmıştır.

## Kurulum ve Çalıştırma

1.  **Projeyi Klonlama:**
    ```bash
    git clone [https://github.com/](https://github.com/)emrekara123/PdfOzgecmisProjesi.git
    ```

2.  **Bağımlılıkları Yükleme:**
    Proje bir Maven projesidir. Proje kök dizinindeyken bir terminalde aşağıdaki komutu çalıştırarak gerekli olan Apache PDFBox kütüphanesini indirebilirsiniz.
    ```bash
    mvn clean install
    ```

3.  **Çalıştırma:**
    - Proje kök klasörüne `profil-fotografi.jpg` adında bir resim dosyası eklediğinizden emin olun.
    - `src/main/java/org/example/OzgecmisOlusturucu.java` dosyasındaki `main` metodunu bir IDE (IntelliJ IDEA, Eclipse vb.) üzerinden çalıştırın.
    - İşlem tamamlandığında proje kök dizininde `Ozgecmis.pdf` adlı dosya oluşturulacaktır.
