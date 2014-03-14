import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

public class Calculator2Test {
@BeforeClass
public static void setUpClass() throws Exception {
System.out.println("Before class");
}
@AfterClass
public static void tearDownClass() throws Exception {
System.out.println("After class");
}
@Before
public void setUp() { 
System.out.println("Start");
}
@After
public void tearDown() {
System.out.println("End");
}
@Test
public void testTambah() {
Integer x = 3;
Integer y = 4;
Integer seharusnya = 7;
Calculator c = new Calculator();
assertEquals(seharusnya, c.tambah(x, y));
}
@Test
public void testKurang() {
Integer x = 3;
Integer y = 4;
Integer seharusnya = 1;
Calculator c = new Calculator();
assertEquals(seharusnya, c.kurang(y, x));
}
}