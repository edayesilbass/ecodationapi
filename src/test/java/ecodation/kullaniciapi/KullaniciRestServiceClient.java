package ecodation.kullaniciapi;

import ecodation.kullaniciapi.entities.Kullanici;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class KullaniciRestServiceClient {

    public static final String URL = "http://localhost:8080/kullanici/kullaniciKaydet";

    public static boolean kullaniciKaydet(Kullanici kullanici) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Kullanici> request = new HttpEntity<>(kullanici);
            restTemplate.postForObject(URL, request, Kullanici.class);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
