package org.kd4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest_revisit {

    @Test
    public void issuesWithUsingMock(){
        List arrayListMock = mock(ArrayList.class);
        // If you don't mock a method, it would return default value
        arrayListMock.add("deepak");
        when(arrayListMock.size()).thenReturn(5);

        assertEquals(5, arrayListMock.size());
        assertEquals("deepak", arrayListMock.get(0));

        /*
        * java.lang.AssertionError:
            Expected :deepak
            Actual   :null
        * this is because arrayListMock.get(0) was not mocked, and because the expectation was not set it returned the default value
        * */
    }

    @Test
    public void howSpyHelps(){
        List arrayListMock = spy(ArrayList.class);
        // If you don't mock a method, it would behave in the actual way
        arrayListMock.add("deepak");
        when(arrayListMock.size()).thenReturn(5);

        assertEquals(5, arrayListMock.size());
        assertEquals("deepak", arrayListMock.get(0));
    }
}
