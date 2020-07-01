package bowling.domain.game;

public interface Frame {
    public Frame next(int countOfPins);

    public boolean hasNext();

    FrameNumber getFrameNumber();
}
