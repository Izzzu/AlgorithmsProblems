package elementsOfProgramming;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static elementsOfProgramming.DutchNationalFlag.Color.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DutchNationalFlagTest {

    @Test
    public void shouldSortLastElement() {
        List<DutchNationalFlag.Color> colors = new LinkedList<>();
        colors.add(RED);
        colors.add(WHITE);
        colors.add(BLUE);
        colors.add(RED);
        DutchNationalFlag.dutchFlagPartition(2, colors);
        assertEquals(colors.get(3), BLUE);
    }

    @Test
    public void shouldReturnOneColor() {
        List<DutchNationalFlag.Color> colors = new LinkedList<>();
        colors.add(RED);
        colors.add(RED);
        colors.add(RED);
        colors.add(RED);
        DutchNationalFlag.dutchFlagPartition(2, colors);
        assertEquals(colors.get(0), RED);
        assertEquals(colors.get(1), RED);
        assertEquals(colors.get(2), RED);
        assertEquals(colors.get(3), RED);
    }

    @Test
    public void shouldGetWholeFlag() {
        List<DutchNationalFlag.Color> colors = new LinkedList<>();
        colors.add(WHITE);
        colors.add(DutchNationalFlag.Color.BLUE);
        colors.add(RED);
        colors.add(WHITE);
        colors.add(DutchNationalFlag.Color.BLUE);
        colors.add(RED);
        DutchNationalFlag.dutchFlagPartition(0, colors);
        assertEquals(colors.get(0), RED);
        assertEquals(colors.get(1), RED);
        assertEquals(colors.get(2), WHITE);
        assertEquals(colors.get(3), WHITE);
        assertEquals(colors.get(4), BLUE);
        assertEquals(colors.get(5), BLUE);
    }

}