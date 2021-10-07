package ecodation.kullaniciapi.dataAccess.concretes;

import ecodation.kullaniciapi.dataAccess.abstracts.KullaniciDao;
import ecodation.kullaniciapi.entities.Kullanici;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class KullaniciDaoImpl implements KullaniciDao {

    private SessionFactory hibernateFactory;

    @Autowired
    public KullaniciDaoImpl(EntityManagerFactory factory) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("Factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kullanici> adaGoreKullaniciGetir(String ad) {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();
        Query<Kullanici> query = session.createNamedQuery("kullanici_findByAd", Kullanici.class);
        query.setParameter("ad", ad);
        List<Kullanici> kullaniciList = query.list();

        session.getTransaction().commit();
        session.close();
        return kullaniciList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kullanici> soyadaGoreKullaniciGetir(String soyad) {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();
        Query<Kullanici> query = session.createNamedQuery("kullanici_findBySoyad", Kullanici.class);
        query.setParameter("soyad", soyad);
        List<Kullanici> kullaniciList = query.list();

        session.getTransaction().commit();
        session.close();
        return kullaniciList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kullanici> idyeGoreKullaniciGetir(Long id) {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();
        Query<Kullanici> query = session.createNamedQuery("kullanici_findById", Kullanici.class);
        query.setParameter("id", id);
        List<Kullanici> kullaniciList = query.list();

        session.getTransaction().commit();
        session.close();
        return kullaniciList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kullanici> tumKullanicilariGetir() {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Kullanici.class);

        List<Kullanici> kullaniciList = criteria.list();

        session.getTransaction().commit();
        session.close();

        return kullaniciList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Kullanici kullaniciKaydet(Kullanici kullanici) {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(kullanici);

        session.getTransaction().commit();
        session.close();
        return kullanici;
    }

}
