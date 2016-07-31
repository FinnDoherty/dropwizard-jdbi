package com.example.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Album {
    @NotNull
    @JsonProperty
    private Integer id;

    @NotNull
    @JsonProperty
    private String title;

    @JsonProperty
    private String artist;

    public Integer getId() {
        return id;
    }

    public Album setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Album setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public Album setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Album album = (Album) o;

        if (id != null ? !id.equals(album.id) : album.id != null) {
            return false;
        }
        if (title != null ? !title.equals(album.title) : album.title != null) {
            return false;
        }
        return artist != null ? artist.equals(album.artist) : album.artist == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        return result;
    }
}
