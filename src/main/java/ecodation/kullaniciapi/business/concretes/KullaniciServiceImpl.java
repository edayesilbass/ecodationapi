package ecodation.kullaniciapi.business.concretes;

import ecodation.kullaniciapi.business.abstracts.KullaniciService;
import ecodation.kullaniciapi.dataAccess.abstracts.KullaniciDao;
import ecodation.kullaniciapi.entities.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciServiceImpl implements KullaniciService {

    private KullaniciDao kullaniciDao;

    @Autowired
    public KullaniciServiceImpl(KullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    @Override
    public List<Kullanici> tumKullanicilariGetir() {
        return kullaniciDao.tumKullanicilariGetir();
    }

    @Override
    public List<Kullanici> adaGoreKullanicilariGetir(String ad) {
        return kullaniciDao.adaGoreKullaniciGetir(ad);
    }

    @Override
    public List<Kullanici> soyadaGoreKullanicilariGetir(String soyad) {
        return kullaniciDao.soyadaGoreKullaniciGetir(soyad);
    }

    @Override
    public List<Kullanici> idyeGoreKullanicilariGetir(Long id) {
        return kullaniciDao.idyeGoreKullaniciGetir(id);
    }

    @Override
    public Kullanici kullaniciKaydet(Kullanici kullanici) {
        return kullaniciDao.kullaniciKaydet(kullanici);
    }
}
