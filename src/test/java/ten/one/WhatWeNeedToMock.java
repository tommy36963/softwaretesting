package ten.one;


import one.Calculator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class WhatWeNeedToMock {

    //If we want a class run with mockito, we need to use
    //@Runwith annotation

    @Mock
    Calculator calculator;
    // this is how we mock the object

    Calculator firstway = mock(Calculator.class);

    Calculator secondway = Mockito.mock(Calculator.class);

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    //Alternative way to enabling RunWith or Mock annotations
}
