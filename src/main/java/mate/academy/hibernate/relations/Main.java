package mate.academy.hibernate.relations;

import java.util.List;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.model.Movie;
import mate.academy.hibernate.relations.service.ActorService;
import mate.academy.hibernate.relations.service.CountryService;
import mate.academy.hibernate.relations.service.MovieService;
import mate.academy.hibernate.relations.service.impl.ActorServiceImpl;
import mate.academy.hibernate.relations.service.impl.CountryServiceImpl;
import mate.academy.hibernate.relations.service.impl.MovieServiceImpl;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getInstance();

        Country usa = new Country("USA");
        CountryService countryService = new CountryServiceImpl(sf);
        countryService.add(usa);

        ActorService actorService = new ActorServiceImpl(sf);

        Actor vinDiesel = new Actor("Vin Diesel");
        vinDiesel.setCountry(usa);
        actorService.add(vinDiesel);

        Actor rock = new Actor("The Rock");
        rock.setCountry(usa);
        actorService.add(rock);

        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setActors(List.of(vinDiesel, rock));
        MovieService movieService = new MovieServiceImpl(sf);
        movieService.add(fastAndFurious);

        System.out.println(movieService.get(fastAndFurious.getId()));
    }
}
