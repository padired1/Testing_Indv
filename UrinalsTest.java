package org.example;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UrinalsTest {
    Urinals u=new Urinals();

    @Test
    public void testString()
    {
        String res= "0101001";
        assertEquals(true,u.goodString(res));
        System.out.println("======PRATHYUSHA==TEST ONE EXECUTED========");
    }


}
