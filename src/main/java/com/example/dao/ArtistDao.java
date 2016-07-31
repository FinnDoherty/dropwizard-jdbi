package com.example.dao;

import com.example.core.Artist;
import com.example.core.mapper.ArtistMapper;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ArtistMapper.class)
public interface ArtistDao {
    @SqlQuery("SELECT * FROM Artist a")
    List<Artist> getAll();

    @SqlQuery("SELECT * FROM Artist a "
            + "WHERE ArtistId = :id"
    )
    Artist getById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM Artist a "
            + "WHERE UPPER(a.Name) = UPPER(:artist)"
    )
    List<Artist> searchByFullName(@Bind("artist") String artist);

    @SqlQuery("SELECT * FROM Artist a "
            + "WHERE UPPER(a.Name) LIKE UPPER(:artist)"
    )
    List<Artist> searchByNameInitial(@Bind("artist") String artist);
}
