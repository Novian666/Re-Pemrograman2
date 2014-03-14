import org.junit.Test;
import static org.junit.Assert.*;
public class CalculatorTest {
@Test
public void testTambah() {
Integer x = 3;
Integer y = 4;
Integer seharusnya = 7;
Calculator c = new Calculator();
assertEquals(seharusnya, c.tambah(x, y));
}
}