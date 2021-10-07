package ecodation.kullaniciapi.dataAccess.abstracts;

import ecodation.kullaniciapi.entities.Kullanici;

import java.util.List;

public interface KullaniciDao {

    List<Kullanici> adaGoreKullaniciGetir(String ad);

    List<Kullanici> soyadaGoreKullaniciGetir(String soyad);

    List<Kullanici> idyeGoreKullaniciGetir(Long id);

    List<Kullanici> tumKullanicilariGetir();

    Kullanici kullaniciKaydet(Kullanici kullanici);
}
