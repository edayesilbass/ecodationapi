package ecodation.kullaniciapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "kullanici")
@org.hibernate.annotations.NamedQuery(name = "kullanici_findByAd",
        query = "from Kullanici where ad like CONCAT(:ad,'%')")
@org.hibernate.annotations.NamedQuery(name = "kullanici_findBySoyad",
        query = "from Kullanici where soyad like CONCAT(:soyad,'%')")
@org.hibernate.annotations.NamedQuery(name = "kullanici_findById",
        query = "from Kullanici where id = :id")
public class Kullanici {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @Column(name = "eposta")
    private String eposta;

    @Column(name = "sifre")
    private String sifre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
