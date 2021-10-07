package ecodation.kullaniciapi.business.abstracts;

import ecodation.kullaniciapi.entities.Kullanici;

import java.util.List;

public interface KullaniciService {

    List<Kullanici> tumKullanicilariGetir();

    List<Kullanici> adaGoreKullanicilariGetir(String ad);

    List<Kullanici> soyadaGoreKullanicilariGetir(String soyad);

    List<Kullanici> idyeGoreKullanicilariGetir(Long id);

    Kullanici kullaniciKaydet(Kullanici kullanici);

}
