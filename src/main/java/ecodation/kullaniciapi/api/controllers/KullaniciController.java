package ecodation.kullaniciapi.api.controllers;

import ecodation.kullaniciapi.business.abstracts.KullaniciService;
import ecodation.kullaniciapi.core.utilities.results.Result;
import ecodation.kullaniciapi.entities.Kullanici;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// swagger url : http://localhost:8080/swagger-ui.html#/

@RestController
@RequestMapping("kullanici")
public class KullaniciController {

    private KullaniciService kullaniciService;

    @Autowired
    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @GetMapping("/tumKullanicilariGetir")
    public List<Kullanici> tumKullanicilariGetir() {
        return kullaniciService.tumKullanicilariGetir();
    }

    @PostMapping("/kullaniciKaydet")
    public Result kullaniciKaydet(@RequestBody Kullanici kullanici) {
        try {
            String email = kullanici.getEposta();
            boolean valid = EmailValidator.getInstance().isValid(email);
            if (valid) {
                kullaniciService.kullaniciKaydet(kullanici);
                return new Result(true, "Kullanıcı eklendi....    ");
            } else {
                return new Result(false, "Kullanıcı eposta adresi geçerli değil....    ");
            }


        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Kullanıcı eklenirken hata oluştu....    ");
        }
    }

    @GetMapping("/adaGoreKullaniciGetir/{ad}")
    public List<Kullanici> adaGoreKullaniciGetir(@PathVariable("ad") String ad) {
        return kullaniciService.adaGoreKullanicilariGetir(ad);
    }

    @GetMapping("/soyadaGoreKullaniciGetir/{soyad}")
    public List<Kullanici> soyadaGoreKullaniciGetir(@PathVariable("soyad") String soyad) {
        return kullaniciService.soyadaGoreKullanicilariGetir(soyad);
    }

    @GetMapping("/idyeGoreKullaniciGetir/{id}")
    public List<Kullanici> idyeGoreKullaniciGetir(@PathVariable("id") String id) {
        try {
            long l = Long.parseLong(id);
            return kullaniciService.idyeGoreKullanicilariGetir(l);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
