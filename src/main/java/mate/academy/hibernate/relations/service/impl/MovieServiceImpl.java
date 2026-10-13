package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.MovieDao;
import mate.academy.hibernate.relations.dao.impl.MovieDaoImpl;
import mate.academy.hibernate.relations.model.Movie;
import mate.academy.hibernate.relations.service.MovieService;
import org.hibernate.SessionFactory;

public class MovieServiceImpl implements MovieService {
    private final MovieDao dao;

    public MovieServiceImpl(SessionFactory sf) {
        this.dao = new MovieDaoImpl(sf);
    }

    @Override
    public Movie add(Movie movie) {
        return dao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return dao.get(id).orElseThrow(() -> new RuntimeException(
                "Can't find the movie with id " + id));
    }
}
