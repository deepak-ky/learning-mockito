package org.kd4.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ CollaboratorWithStaticMethods.class})
public class CollaboratorWithStaticMethodsTest {

    @Test
    public void firstMethod() {
        mockStatic(CollaboratorWithStaticMethods.class);
        when(CollaboratorWithStaticMethods.firstMethod(anyString())).thenReturn("deepak");
        String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whoever");
        assertEquals("deepak", firstWelcome);
    }

    @Test
    public void secondMethod() {
    }

    @Test
    public void thirdMethod() {
    }
}