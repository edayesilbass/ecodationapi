package ecodation.kullaniciapi;

import ecodation.kullaniciapi.entities.Kullanici;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcodationApplicationTests {

    @Test
    void kullaniciKaydet1() {
        Kullanici kullanici = new Kullanici();
        kullanici.setAd("Test Ad");
        kullanici.setSoyad("Test Soyad");
        kullanici.setSifre("123456");
        kullanici.setEposta("kullanici@test.com");
        KullaniciRestServiceClient.kullaniciKaydet(kullanici);
    }

    @Test
    void kullaniciKaydet2() {
        Kullanici kullanici = new Kullanici();
        kullanici.setAd("Test Ad");
        kullanici.setSoyad("Test Soyad");
        kullanici.setSifre("123456");
        kullanici.setEposta("kullanici");
        KullaniciRestServiceClient.kullaniciKaydet(kullanici);
    }

}
