package org.example.competition;

public class RunningTrack implements Obstacle {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.run(length);
    }
}

