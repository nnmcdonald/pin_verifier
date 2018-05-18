////////////////////////////////////////////////////////////////////////////
//
// Nathaniel McDonald
// March, 10 2016
//
////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//  DESCRIPTION: This program displays the numbers 0 through 9 on one line and on the next prints a series of random
//               numbers coresponding to each digit. Using this as a key the user is propmpted to enter the random 
//               values that correspond to a 5 digit pin number.
//               for example, if the pin is :12345
//                              and the key : 0 1 2 3 4 5 6 7 8 9
//                                            2 0 0 1 5 6 5 2 1 7
//                 then the user would enter:   0 0 1 5 6
// 
// INPUTS:  5 digit pin number
//    
//
// OUTPUTS:  A message stating wether it is the correct or incorrect pin.
//   
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

public class PinNumber
{
  private static int[] key = {0,1,2,3,4,5,6,7,8,9};
  private int[] pin = new int[5];
  private String secretPin;
  private String setPin;
  
  //Stores a pin number as an array
  //Inputs: pin number
  public PinNumber(String newPin)
  {
    for (int i = newPin.length()-1; i >= 0; i--)
     pin[i] = newPin.charAt(i);
  }
  
  //Converts the values stored in the key array into a string.
  //Inputs: key array values
  //Outputs: key array values as a String
  public String keyToString(int[] array)
  {
    return (""+(array[0])+(array[1])+(array[2])+(array[3])+(array[4])
           +(array[5])+(array[6])+(array[7])+(array[8])+(array[9]));
  }
  
  //Converts the pin number to a String 
   public String pinToString(int[] array)
  {
    return (""+(array[0])+(array[1])+(array[2])+(array[3])+(array[4]));
  }
  
  //Randomizes the key array
  public static int[] randomize(int[] array)
  {
    Random random = new Random();
    for (int i = 9; i >= 0; i--)
    {
      int randomValue = random.nextInt(i+1);
      array[i] = randomValue;
    }
    return array;
  }
  
  public void readInput()
  {
    Scanner keyboard = new Scanner(System.in);
    //Displays the original key values 0 through 9 as a string, then randommizes the values and displays them below.
    System.out.println(keyToString(key));
    key = randomize(key);
    System.out.println(keyToString(key));
    //Sets pin number to the corresponding random value and converts it to a string. 
    for (int i = 4; i >= 0; i--)
      pin[i] = key[pin[i]-48];
    setPin = pinToString(pin);
    System.out.println("Please enter corresponding pin number");
    secretPin = keyboard.next();
  }
  
  //Checks if the randomized pin and user input are equal and displays a message of "correct pin" if they are
  // and "incorrect pin" if not.
  public void writeOutput()
  {
    if (setPin.equals(secretPin))
      System.out.println("correct pin");
    else
      System.out.println("incorrect pin");
  }
  
  //Sets a pin number readInput and writeOutput to verify the program.
   public static void main(String[] args)
  {
    PinNumber newPin = new PinNumber("55425");
    newPin.readInput();
    newPin.writeOutput();
  }
}
