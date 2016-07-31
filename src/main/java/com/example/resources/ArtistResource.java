package com.example.resources;

import com.example.core.Artist;
import com.example.dao.ArtistDao;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.google.common.base.Strings.isNullOrEmpty;

@Path("/artists")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ArtistResource {
    private ArtistDao artistDao;

    public ArtistResource(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    @GET
    public List<Artist> getAll() {
        return artistDao.getAll();
    }

    @GET
    @Path("/{id}")
    public Artist get(@PathParam("id") Integer id) {
        return artistDao.getById(id);
    }

    @GET
    @Path("/search")
    public List<Artist> get(
            @QueryParam("artist") String artist
    ) {
        // search by one or more
        if (isNullOrEmpty(artist)) {
            throw new WebApplicationException("A search parameter should be provided", Response.Status.BAD_REQUEST);
        }

        final List<Artist> artists;

        if (artist.length() == 1) {
            artists = artistDao.searchByNameInitial(artist + "%");
        } else {
            artists = artistDao.searchByFullName(artist);
        }

        return artists;
    }
}
