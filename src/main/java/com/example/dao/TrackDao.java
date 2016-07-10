package com.example.dao;

import com.example.core.Track;
import com.example.core.mapper.TrackMapper;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TrackMapper.class)
public interface TrackDao {
    @SqlQuery("select * from TRACK")
    List<Track> getAll();

    @SqlQuery("select * from TRACK where TRACKID = :id")
    Track getById(@Bind("id") int id);
}
