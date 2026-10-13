package mate.academy.hibernate.relations.dao.impl;

import java.util.Optional;
import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.lib.DataProcessingException;
import mate.academy.hibernate.relations.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CountryDaoImpl extends AbstractDao implements CountryDao {
    public CountryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Country add(Country country) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Long id = (Long) session.save(country);
            country.setId(id);
            transaction.commit();

            return country;

        } catch (Exception e) {
            transaction.rollback();
            throw new DataProcessingException("Can't add country " + country, e);
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Country> get(Long id) {
        Session session = factory.openSession();

        try {
            return Optional.ofNullable(session.get(Country.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get the country with id " + id, e);
        } finally {
            session.close();
        }
    }
}
