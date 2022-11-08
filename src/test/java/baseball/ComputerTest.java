package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {
    @Test
    public void three_strike() {
        // given
        Computer computer = new Computer();
        List<Integer> targetNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> guessNumber = new ArrayList<>(Arrays.asList(1, 2, 3));

        // when
        computer.setTargetNumber(targetNumber);

        // then
        assertEquals(3, computer.guessTargetNumber(guessNumber));
    }

    @Test
    public void nothing() {
        // given
        Computer computer = new Computer();
        List<Integer> targetNumber = new ArrayList<>(Arrays.asList(2, 4, 7));
        List<Integer> guessNumber = new ArrayList<>(Arrays.asList(1, 3, 6));

        // when
        computer.setTargetNumber(targetNumber);

        // then
        assertEquals(0, computer.guessTargetNumber(guessNumber));
    }
}
