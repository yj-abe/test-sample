package jp.cloudace.unittest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class SampleTest {

    private Sample sample;
    private Injected injected = Mockito.mock(Injected.class);

    @Before
    public void before() {
        sample = new Sample(injected);
        Mockito.doNothing().when(injected).called(Mockito.anyInt());
    }

    @Test
    public void injectedShouldBeCalled() {
        sample.callInjected();
        Mockito.verify(injected).called(10);
    }

    @Test
    public void sampleReturns1IfItIsMocked() {
        Mockito.when(injected.isMocked()).thenReturn(true);
        int value = sample.getMockedAsInteger();
        assertThat(value, is(1));
    }

}
