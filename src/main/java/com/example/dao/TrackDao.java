package com.example.dao;

import com.example.core.Track;
import com.example.core.mapper.TrackMapper;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TrackMapper.class)
public interface TrackDao {
    @SqlQuery("select * from TRACK t "
            + "inner join album a on t.ALBUMID = a.ALBUMID"
    )
    List<Track> getAll();

    @SqlQuery("select * from TRACK t "
            + "inner join album a on t.ALBUMID = a.ALBUMID "
            + "where TRACKID = :id"
    )
    Track getById(@Bind("id") int id);

    @SqlQuery("select * from TRACK t "
            + "inner join album a on t.ALBUMID = a.ALBUMID "
            + "where upper(a.TITLE) = upper(:album)"
    )
    List<Track> searchByAlbumFullName(@Bind("album") String album);

    @SqlQuery("select * from TRACK t "
            + "inner join album a on t.ALBUMID = a.ALBUMID "
            + "where upper(a.TITLE) like upper(:album)"
    )
    List<Track> searchByAlbumInitial(@Bind("album") String album);

}
