package be.vdab.hfdstk6.domain;

import javax.persistence.CollectionTable;
import javax.persistence.Embeddable;

@Embeddable
public class Trackies {
    private String track;

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}

