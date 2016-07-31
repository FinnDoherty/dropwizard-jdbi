package com.example;

import com.example.dao.AlbumDao;
import com.example.dao.ArtistDao;
import com.example.dao.TrackDao;
import com.example.resources.AlbumResource;
import com.example.resources.ArtistResource;
import com.example.resources.TrackResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

public class ExampleApplication extends Application<ExampleConfiguration> {
    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-jdbi";
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
    }

    @Override
    public void run(ExampleConfiguration configuration, Environment environment) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        final TrackDao trackDao = jdbi.onDemand(TrackDao.class);
        final TrackResource trackResource = new TrackResource(trackDao);

        final AlbumDao albumDao = jdbi.onDemand(AlbumDao.class);
        final AlbumResource albumResource = new AlbumResource(albumDao);

        final ArtistDao artistDao = jdbi.onDemand(ArtistDao.class);
        final ArtistResource artistResource = new ArtistResource(artistDao);

        environment.jersey().register(trackResource);
        environment.jersey().register(albumResource);
        environment.jersey().register(artistResource);
    }
}
