package lab1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ReadonlyListTest {

    @Test
    public void length_emptyList_is0() {
        //given
        var sut = ReadonlyList.empty();

        //when
        var actual = sut.length();

        //then
        assertEquals(0, actual);

    }
    @Test
    public void length_listLength1_is1(){
        //given
        ReadonlyList<Integer> sut = ReadonlyList.empty().add(23);


        //when
        var actual = sut.length();

        //then
        assertEquals(1,actual);

    }

    @Test
    public void length_listLength3_is3(){
        //given
        ReadonlyList<Integer> lijst1 = ReadonlyList.empty();
        ReadonlyList<Integer> lijst2 = lijst1.add(23);
        ReadonlyList<Integer> lijst3 = lijst2.add(45);
        ReadonlyList<Integer> sut = lijst3.add(45);

        //when
        int actualLength = sut.length();
        //then
        assertEquals(3, actualLength);
    }

    @Test
    public void length_listLengthString1_is1(){
        //given
        ReadonlyList<String> lijst1 = ReadonlyList.empty();
        ReadonlyList<String> lijst2 = lijst1.add("Hello");

        //when
        int actualLength = lijst2.length();

        //then
        assertEquals(1, actualLength);

    }

//    @Test
//    public void testAssertAll(){
//        //given
//        ReadonlyList<String> lijst1 = ReadonlyList.empty();
//        ReadonlyList<String> lijst2 = lijst1.add("Hello");
//
//        //when
//        int actualLength = lijst2.length();
//
//        //then
//        assertAll("niet aan alle assumpties voldaan",
//                () -> assertEquals(1, actualLength),
//                () -> assertEquals("Hello", lijst2())
//
//                );
//
//    }






}