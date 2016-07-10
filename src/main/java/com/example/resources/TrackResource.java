package com.example.resources;

import com.example.core.Track;
import com.example.dao.TrackDao;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
