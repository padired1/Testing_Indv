package org.example;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UrinalsTest {
    Urinals uri = new Urinals();
    @Test
    public void testgoodString()
    {
        assertEquals(true,uri.goodString("00100"));
        System.out.println("=======Prathyusha==Test one executed========");
    }
    @Test
    public void testCountUrinals()
    {
        assertEquals(1,uri.countUrinals("10001"));
        assertEquals(0,uri.countUrinals("1001"));
        assertEquals(3,uri.countUrinals("00000"));
        assertEquals(2,uri.countUrinals("0000"));
        assertEquals(1,uri.countUrinals("01000"));
        assertEquals(-1,uri.countUrinals("011"));
        System.out.println("=======Prathyusha==Test two executed========");
    }
    @Test
    public void testOpenFile(){
        assertEquals(1,uri.open_File("src/urinal.dat"));
        System.out.println("=======Prathyusha==Test three executed========");
    }

    @Test
    public void testWriteToFile(){
        String optFile="src/rule.txt";
        assertEquals(1,uri.write_To_File(optFile,3));
        System.out.println("=======Prathyusha==Test four executed========");
    }

}
