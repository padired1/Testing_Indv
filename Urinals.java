package org.example;
/*Author
  Prathyusha Adireddi
*/
public class Urinals{
    String input;
    public String getInput()
    {
        return input;
    }
    public boolean goodString(String str){
        if(str.matches("[01][01]+"))
        {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {

    }
}