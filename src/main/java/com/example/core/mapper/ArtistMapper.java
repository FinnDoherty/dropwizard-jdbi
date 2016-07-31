package com.example.core.mapper;

import com.example.core.Artist;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistMapper implements ResultSetMapper<Artist>
{
    public Artist map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new Artist()
                .setId(resultSet.getInt("ArtistId"))
                .setName(resultSet.getString("Name"));
    }
}
