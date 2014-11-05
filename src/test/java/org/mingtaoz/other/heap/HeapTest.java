package org.mingtaoz.other.heap;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

    private Heap sut;

    @Before
    public void setup() {
        sut = new Heap();
    }

    @Test
    public void testHeapify2() {
        int[] i = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        sut.heapify(i);
        ASSERT.that(i).is(new int[] { 7, 5, 6, 4, 2, 1, 3 });
    }

    @Test
    public void testHeapify1() {
        int[] i = new int[] { 1, 2, 3 };
        sut.heapify(i);
        ASSERT.that(i).is(new int[] { 3, 2, 1 });
    }

}
