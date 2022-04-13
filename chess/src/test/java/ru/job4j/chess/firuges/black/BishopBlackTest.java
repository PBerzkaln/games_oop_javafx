package ru.job4j.chess.firuges.black;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {

    @Test
    public void testPositionIsSuccessful() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position(), is(Cell.findBy(2, 0)));
    }

    @Test
    public void testCopyIsSuccessful() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.copy(Cell.F8).position(), is(Cell.findBy(5, 0)));
    }

    @Test (expected =  ImpossibleMoveException.class)
    public void wayGotImpossibleMoveException() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C5);
    }

    @Test
    public void wayIsSuccessful() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cell = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] rsl = bishopBlack.way(Cell.G5);
        assertThat(cell, is(rsl));
    }
}