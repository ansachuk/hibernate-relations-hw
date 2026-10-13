package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.ActorDao;
import mate.academy.hibernate.relations.dao.impl.ActorDaoImpl;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.service.ActorService;
import org.hibernate.SessionFactory;

public class ActorServiceImpl implements ActorService {
    private final ActorDao dao;

    public ActorServiceImpl(SessionFactory sf) {
        dao = new ActorDaoImpl(sf);
    }

    @Override
    public Actor add(Actor actor) {
        return dao.add(actor);
    }

    @Override
    public Actor get(Long id) {
        return dao.get(id).orElseThrow(() -> new RuntimeException(
                "Can't find the actor with id " + id));
    }
}
