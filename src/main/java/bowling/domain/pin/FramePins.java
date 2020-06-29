package bowling.domain.pin;

import java.util.Objects;

public class FramePins {
    public static final int MAX_PINS_PER_FRAME = 10;

    private final Pins firstPins;
    private final Pins secondPins;

    private FramePins(Pins firstPins) {
        this(firstPins, Pins.of(0));
    }

    public FramePins(Pins firstPins, Pins secondPins) {
        Objects.requireNonNull(firstPins, "첫 번째 투구가 유효하지 않습니다.");
        validateSum(firstPins, secondPins);
        this.firstPins = firstPins;
        this.secondPins = secondPins;
    }

    private void validateSum(Pins firstPins, Pins secondPins) {
        if (Pins.sum(firstPins, secondPins) > MAX_PINS_PER_FRAME) {
            throw new IllegalArgumentException("한 프레임 당 투구의 합은 " + MAX_PINS_PER_FRAME + "개를 초과할 수 없습니다.");
        }
    }

    public static FramePins of(Pins firstPins, Pins secondPins) {
        return new FramePins(firstPins, secondPins);
    }

    public static FramePins strike(Pins firstPins) {
        return new FramePins(firstPins);
    }
}
