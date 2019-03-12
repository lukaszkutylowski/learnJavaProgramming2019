import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LukCharListTest {

    private LukCharList lukCharList;

    @Before
    public void initialize() {
        lukCharList = new LukCharList();
    }

    @Test
    public void should_check_save_char() {
        //given
        final int expectedIntPosition0 = 0;
        final int expectedIntPosition1 = 1;
        final int expectedIntPosition2 = 2;
        //when
        final int actualIntPosition0 = lukCharList.save('a');
        final int actualIntPosition1 = lukCharList.save('b');
        final int actualIntPosition2 = lukCharList.save('a');
        //then
        assertEquals(actualIntPosition0,expectedIntPosition0);
        assertEquals(actualIntPosition1,expectedIntPosition1);
        assertEquals(actualIntPosition2,expectedIntPosition2);
    }

    @Test
    public void should_check_index_value() {
        //given
        lukCharList.save('a');
        final char expectedChar = 'a';
        //when
        final char actualChar = lukCharList.getByIndex(0);
        //then
        assertEquals(actualChar, expectedChar);
    }

    @Test
    public void should_check_all_array() {
        //given
        lukCharList.save('1');
        lukCharList.save('2');
        final char[] expectedCharArray = {'1','2'};
        //when
        final char[] actualCharArray = lukCharList.getAll();
        //then
        assertArrayEquals(expectedCharArray, actualCharArray);
    }

    @Test
    public void should_check_all_array_when_is_empty() {
        //given
        final char[] expectedCharArray = {};
        //when
        final char[] actualCharArray = lukCharList.getAll();
        //then
        assertArrayEquals(expectedCharArray, actualCharArray);
    }

    @Test
    public void should_check_deleted_char() {
        //given
        lukCharList.save('a');
        lukCharList.save('b');
        lukCharList.save('c');
        final char[] expectedCharArray1 = {'b','c'};
        final char[] expectedCharArray2 = {'c'};
        final char[] expectedCharArray3 = {};
        //when
        lukCharList.delete(0);
        final char[] actualCharArray1 = lukCharList.getAll();
        lukCharList.delete(0);
        final char[] actualCharArray2 = lukCharList.getAll();
        lukCharList.delete(0);
        final char[] actualCharArray3 = lukCharList.getAll();
        //then
        assertArrayEquals(expectedCharArray1, actualCharArray1);
        assertArrayEquals(expectedCharArray2, actualCharArray2);
        assertArrayEquals(expectedCharArray3, actualCharArray3);
    }

    @Test
    public void should_check_deleted_char_in_many_places() {
        //given
        lukCharList.save('a');
        lukCharList.save('b');
        lukCharList.save('c');
        lukCharList.save('d');
        lukCharList.save('e');
        lukCharList.save('f');
        lukCharList.save('g');
        lukCharList.save('h');
        lukCharList.save('i');
        lukCharList.save('j');
        final char[] expectedCharArray1 = {'a','b','c','d','e','f','g','h','i'};
        final char[] expectedCharArray2 = {'a','b','d','e','f','g','h','i'};
        final char[] expectedCharArray3 = {'b','d','e','f','g','h','i'};
        final char[] expectedCharArray4 = {'e','f','g','h','i'};
        final char[] expectedCharArray5 = {'e','g'};
        final char[] expectedCharArray6 = {};
        //when
        lukCharList.delete(9);
        final char[] actualCharArray1 = lukCharList.getAll();
        lukCharList.delete(2);
        final char[] actualCharArray2 = lukCharList.getAll();
        lukCharList.delete(0);
        final char[] actualCharArray3 = lukCharList.getAll();
        lukCharList.delete(0);
        lukCharList.delete(0);
        final char[] actualCharArray4 = lukCharList.getAll();
        lukCharList.delete(lukCharList.length() - 1);
        lukCharList.delete(lukCharList.length() - 1);
        lukCharList.delete(1);
        final char[] actualCharArray5 = lukCharList.getAll();
        lukCharList.delete(lukCharList.length() - 1);
        lukCharList.delete(lukCharList.length() - 1);
        final char[] actualCharArray6 = lukCharList.getAll();

        //then
        assertArrayEquals(expectedCharArray1, actualCharArray1);
        assertArrayEquals(expectedCharArray2, actualCharArray2);
        assertArrayEquals(expectedCharArray3, actualCharArray3);
        assertArrayEquals(expectedCharArray4, actualCharArray4);
        assertArrayEquals(expectedCharArray5, actualCharArray5);
        assertArrayEquals(expectedCharArray6, actualCharArray6);
    }

    @Test
    public void should_check_array_length() {
        //given
        final int expectedInt = 1;
        lukCharList.save('5');
        //when
        final int actualInt = lukCharList.length();
        //then
        assertEquals(expectedInt, actualInt);
    }

    @Test
    public void should_check_array_length_when_is_empty() {
        //given
        final int expectedInt = 0;
        //when
        final int actualInt = lukCharList.length();
        //then
        assertEquals(expectedInt, actualInt);
    }

    @Test
    public void should_check_counting_chars_in_array() {
        //given
        final int expectedNumber1 = 2;
        final int expectedNumber2 = 0;
        lukCharList.save('!');
        lukCharList.save('?');
        lukCharList.save('!');
        lukCharList.save('?');
        //when
        final int actualNumber1 = lukCharList.countChar('!');
        final int actualNumber2 = lukCharList.countChar('$');
        //then
        assertEquals(expectedNumber1, actualNumber1);
        assertEquals(expectedNumber2, actualNumber2);
    }

    @Test
    public void should_check_first_index_of_given_char() {
        //given
        final int expectedIndex1 = 0;
        final int expectedIndex2 = -1;
        final int expectedIndex3 = 0;
        lukCharList.save('a');
        lukCharList.save('b');
        lukCharList.save('c');
        lukCharList.save('d');
        lukCharList.save('a');
        //when
        final int actualIndex1 = lukCharList.findFirst('a');
        final int actualIndex2 = lukCharList.findFirst('e');
        final int actualIndex3 = lukCharList.findFirst('a');
        //then
        assertEquals(expectedIndex1, actualIndex1);
        assertEquals(expectedIndex2, actualIndex2);
        assertEquals(expectedIndex3, actualIndex3);
    }

    @Test
    public void should_find_all_indexes_for_given_char() {
        //given
        final int[] expectedIndexes = {0,2};
        lukCharList.save('a');
        lukCharList.save('b');
        lukCharList.save('a');
        lukCharList.save('b');
        //when
        final int[] actualIndexes = lukCharList.findAllIndex('a');
        //then
        assertArrayEquals(expectedIndexes, actualIndexes);
    }

    @Test
    public void should_delete_all_given_char() {
        //given
        final int[] expectedIndexes = {0,2};
        lukCharList.save('a');
        lukCharList.save('b');
        lukCharList.save('a');
        lukCharList.save('b');
        //when
        final int[] actualIndexes = lukCharList.deleteKindOfChar('a');
        //then
        assertArrayEquals(expectedIndexes, actualIndexes);
    }

    @Test
    public void arrayToString() {
        //given
        final String expectedString = "[abcd]";
        lukCharList.save('a');
        lukCharList.save('b');
        lukCharList.save('c');
        lukCharList.save('d');
        //when
        final String actualString = lukCharList.toString();
        //then
        assertEquals(expectedString, actualString);
    }
}