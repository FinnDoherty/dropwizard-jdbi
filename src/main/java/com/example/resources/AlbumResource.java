package com.example.resources;

import com.example.core.Album;
import com.example.dao.AlbumDao;

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

@Path("/albums")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class AlbumResource {
    private AlbumDao albumDao;

    public AlbumResource(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    @GET
    public List<Album> getAll() {
        return albumDao.getAll();
    }

    @GET
    @Path("/{id}")
    public Album get(@PathParam("id") Integer id) {
        return albumDao.getById(id);
    }

    @GET
    @Path("/search")
    public List<Album> get(
            @QueryParam("album") String album
    ) {
        // search by one or more
        if (isNullOrEmpty(album)) {
            throw new WebApplicationException("A search parameter should be provided", Response.Status.BAD_REQUEST);
        }

        final List<Album> albums;

        if (album.length() == 1) {
            albums = albumDao.searchByTitleInitial(album + "%");
        } else {
            albums = albumDao.searchByFullTitle(album);
        }

        return albums;
    }
}
