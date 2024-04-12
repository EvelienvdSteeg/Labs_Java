package lab2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    @Test
    void fib_nIs0_is0() {
        //given
        //when
        int correct = MyMath.fib(0);
        //then
        assertEquals(0, correct);
    }

    @Test
    void fib_nIs1_is1(){
        //given

        //when
        int correct = MyMath.fib(1);
        //then
        assertEquals(1,correct);
    }

    @Test
    void fib_nIs2_is1(){
        //given

        //when
        int correct = MyMath.fib(2);

        //then
        assertEquals(1, correct);
    }

    @Test
    void fib_nIs3_is2(){
        //given

        //when
        int correct = MyMath.fib(3);

        //then
        assertEquals(2, correct);
    }

    @Test
    void fib_nIs4_is3(){
        //given

        //when
        int correct = MyMath.fib(4);

        //then
        assertEquals(3, correct);
    }

    @Test
    void fib_nIs5_is5(){
        //when
        int correct = MyMath.fib(5);

        //then
        assertEquals(5, correct);
    }

    @Test
    void fib_nIs12_is144(){
        //when
        int correct = MyMath.fib(12);

        //then
        assertEquals(144, correct);
    }

    @Test
    void fib_nIsMin1_is0(){
        //when
        int correct = MyMath.fib(-1);

        //then
        assertEquals(0, correct);
    }



    @ParameterizedTest
    @ValueSource(ints = {1,2})
    public void testParameterized(int i) {
        assertEquals(1, MyMath.fib(i) );
    }


}