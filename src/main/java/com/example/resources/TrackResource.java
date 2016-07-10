package com.example.resources;

import com.example.core.Track;
import com.example.dao.TrackDao;

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

@Path("/tracks")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TrackResource {
    private TrackDao trackDao;

    public TrackResource(TrackDao trackDao) {
        this.trackDao = trackDao;
    }

    @GET
    public List<Track> getAll() {
        return trackDao.getAll();
    }

    @GET
    @Path("/{id}")
    public Track get(@PathParam("id") Integer id) {
        return trackDao.getById(id);
    }

    @GET
    @Path("/search")
    public List<Track> get(
            @QueryParam("album") String album
    ) {
        // search by one or more
        if (isNullOrEmpty(album)) {
            throw new WebApplicationException("A search parameter should be provided", Response.Status.BAD_REQUEST);
        }

        final List<Track> tracks;

        if (album.length() == 1) {
            tracks = trackDao.searchByAlbumInitial(album + "%");
        } else {
            tracks = trackDao.searchByAlbumFullName(album);
        }

        return tracks;
    }
}
