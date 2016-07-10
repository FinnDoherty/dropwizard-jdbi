package com.example.core.mapper;

import com.example.core.Track;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackMapper implements ResultSetMapper<Track>
{
    public Track map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new Track()
                .setId(resultSet.getInt("TRACKID"))
                .setName(resultSet.getString("NAME"))
                .setAlbum(resultSet.getString("TITLE"));
    }
}
