package com.example.core.mapper;

import com.example.core.Album;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumTrackMapper implements ResultSetMapper<Album> {
    public Album map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new Album()
                .setId(resultSet.getInt("AlbumId"))
                .setTitle(resultSet.getString("Title"))
                .setArtist(resultSet.getString("Name"));
    }
}
