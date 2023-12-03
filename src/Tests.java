
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test(expected = NullPointerException.class)
    public void test_null() {
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void test_empty() {
        Integer.decode("");
    }

    @Test (expected = NumberFormatException.class)
    public void test_wrong_format() {
        Integer.decode("4ever");
    }

    @Test
    public void test_negative() {
        assertEquals(-128, Integer.decode("-128"));
    }

    @Test
    public void test_positive() {
        assertEquals(128, Integer.decode("+128"));
    }

    @Test
    public void test_hexadecimal() {
        assertEquals(Integer.valueOf(666), Integer.decode("0x29A"));
        assertEquals(Integer.valueOf(-666), Integer.decode("-0x29A"));
    }

    @Test
    public void test_hexadecimal_with_big_X() {
        assertEquals(Integer.valueOf(666), Integer.decode("0X29A"));
        assertEquals(Integer.valueOf(-666), Integer.decode("-0X29A"));
    }

    @Test
    public void test_hexadecimal_with_sharp() {
        assertEquals(Integer.valueOf(666), Integer.decode("#29A"));
        assertEquals(Integer.valueOf(-666), Integer.decode("-#29A"));
    }

    @Test
    public void test_octal() {
        assertEquals(Integer.valueOf(0456), Integer.decode("302"));
        assertEquals(Integer.valueOf(-0456), Integer.decode("-302"));
    }

    @Test (expected = NumberFormatException.class)
    public void test_sign_wrong_position() {
        Integer.decode("++111");
        Integer.decode("1+11");
        Integer.decode("11+1");
        Integer.decode("111++");
    }

    @Test (expected = NumberFormatException.class)
    public void test_space() {
        Integer.decode(" 501");
        Integer.decode("501 ");
        Integer.decode("   5 01   ");
    }

    @Test
    public void test_integer_min_max() {
        assertEquals(Integer.MIN_VALUE, Integer.decode(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MAX_VALUE, Integer.decode(String.valueOf(Integer.MAX_VALUE)));
    }
}
