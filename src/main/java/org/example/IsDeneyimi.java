package org.example;

public class IsDeneyimi {
    private String pozisyon;
    private String sirket;
    private String tarihler;
    private String aciklama;

    // Yapıcı Metot (Constructor)
    public IsDeneyimi(String pozisyon, String sirket, String tarihler, String aciklama) {
        this.pozisyon = pozisyon;
        this.sirket = sirket;
        this.tarihler = tarihler;
        this.aciklama = aciklama;
    }

    // Değişkenlere erişmek için kullanılan metotlar (Getters)
    public String pozisyonuAl() { return pozisyon; }
    public String sirketiAl() { return sirket; }
    public String tarihleriAl() { return tarihler; }
    public String aciklamayiAl() { return aciklama; }
}