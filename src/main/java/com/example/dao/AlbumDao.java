package com.example.dao;

import com.example.core.Album;
import com.example.core.mapper.AlbumMapper;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(AlbumMapper.class)
public interface AlbumDao {
    @SqlQuery("SELECT * FROM Album a "
            + "INNER JOIN artist at on a.ArtistId = at.ArtistId"
    )
    List<Album> getAll();

    @SqlQuery("SELECT * FROM Album a "
            + "INNER JOIN artist at on a.ArtistId = at.ArtistId "
            + "WHERE AlbumId = :id"
    )
    Album getById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM Album a "
            + "INNER JOIN artist at on a.ArtistId = at.ArtistId "
            + "WHERE UPPER(a.Title) = UPPER(:album)"
    )
    List<Album> searchByFullTitle(@Bind("album") String album);

    @SqlQuery("SELECT * FROM Album a "
            + "INNER JOIN artist at on a.ArtistId = at.ArtistId "
            + "WHERE UPPER(a.Title) LIKE UPPER(:album)"
    )
    List<Album> searchByTitleInitial(@Bind("album") String album);
}
