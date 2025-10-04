package org.example;

public class KisiselBilgiler {
    private String adSoyad;
    private String email;
    private String telefon;
    private String adres;

    // Yapıcı Metot (Constructor)
    public KisiselBilgiler(String adSoyad, String email, String telefon, String adres) {
        this.adSoyad = adSoyad;
        this.email = email;
        this.telefon = telefon;
        this.adres = adres;
    }

    // Değişkenlere erişmek için kullanılan metotlar (Getters)
    public String adSoyadiAl() { return adSoyad; }
    public String emailAdresiniAl() { return email; }
    public String telefonNumarasiniAl() { return telefon; }
    public String adresiAl() { return adres; }
}