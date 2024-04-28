package org.kd4;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void testListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
    }


    @Test
    public void testListSizeMethod_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
        assertEquals(4,listMock.size());
    }

    @Test
    public void testListSizeGet(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("asdf");
        when(listMock.get(1)).thenReturn(1.34f);
        assertEquals("asdf",listMock.get(0));
        assertEquals(1.34f,listMock.get(1));
        assertEquals(null,listMock.get(2)); // NOT DEFINED
    }

    @Test
    public void testListSizeGet_ArguementMatcher(){
        List listMock = mock(List.class);
        // Argument Catcher - anyInt()
        when(listMock.get(anyInt())).thenReturn("asdf").thenReturn(1.34f);
        assertEquals("asdf",listMock.get(0));
        assertEquals(1.34f,listMock.get(1));
        assertEquals(1.34f,listMock.get(2));
    }

    @Test(expected = RuntimeException.class)
    public void testListSizeGet_throwRuntimeException(){
        List listMock = mock(List.class);
        // Argument Catcher - anyInt()
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("new deepak exception"));
        listMock.get(0);
    }

    @Test
    public void testListSizeGet_usingBDD(){
        // given
        List<String> listMock = mock(List.class);
        given(listMock.get(0)).willReturn("asdf");

        // when
        String firstElement = listMock.get(0);

        // then
        assertThat(firstElement, is("asdf"));
    }
}
