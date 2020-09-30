package be.vdab.hfdstk6.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long albumId;
    private String title;
    private String author;
    @ElementCollection
    @CollectionTable(name = "TRACKS")
    private List<String> tracks = new ArrayList<>();

    public Album() {
    }

    public Album(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
