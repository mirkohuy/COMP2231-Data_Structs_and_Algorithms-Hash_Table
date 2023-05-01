// COMP 2231_SW3.1 - Data Structures and Algorithms (Summer 2022 Rahman)
// T00705586 Huy Mirko
// Assignment 5, Question 3

import java.util.Hashtable;


// Class to define a hash function
class Hash 
{
  // Method to hash a given key
  public static int hash(int key)
  {
    // Extract the last 3 digits of the key
    int last3 = (int)(key % 1000);

    // Use the division method on the last 3 digits
    int hashcode = Math.abs(last3) % 12;

    return hashcode;
  }
}

class Main 
{
  public static void main(String[] args) 
  {
    // Create two hashtables with a size of 11 and a load factor of 0.7
    Hashtable<Integer, Integer> ht1 = new Hashtable(11, .7f);
    Hashtable<Integer, Integer> ht2 = new Hashtable(11, .7f);
    int[] arr = { 92643, 81735, 73528, 64529, 50493, 39482, 29473, 20491, 11872, 13871, 34125 };      

    // Add elements to the hash table in forward order
    System.out.println("Adding elements to table in forward order...");

    for (int i = 0; i < arr.length; i++)
      {
        if (!ht1.containsKey(Hash.hash(arr[i]))) 
        {
          ht1.put(Hash.hash(arr[i]), arr[i]);
        } 
        else // Collision detected.
        {
          for (int j = 1; j < ht1.size(); j++) 
          {
            int probe = (Hash.hash(arr[i]) + j) % ht1.size();
    
            if (!ht1.containsKey(probe)) 
            {
              ht1.put(probe, arr[i]);
              break;
            }
          }
        }
      }
    // Print out the contents of the hashtable
    System.out.println(ht1.toString() + "\n");
    
    // Add elements to hash table in reverse order
    System.out.println("Adding elements to table in reverse order...");
    
    for (int m = arr.length - 1; m >= 0; m--)
    {
      if (!ht2.containsKey(Hash.hash(arr[m]))) 
      {
        ht2.put(Hash.hash(arr[m]), arr[m]);
      } 
      else // Collision detected.
      {
        for (int n = 1; n < ht2.size(); n++) 
        {
          int probe = (Hash.hash(arr[m]) + n) % ht2.size();
    
          if (!ht2.containsKey(probe)) 
          {
            ht2.put(probe, arr[n]);
            break;
          }
        }
      }
    }
    // Print out the contents of the hashtable
    System.out.println(ht2.toString() + "\n");

    // finding and removing elements from the second hash table
    System.out.println(ht2.get(7));
    System.out.println(ht2.remove(11));
    System.out.println(ht2.toString() + "\n");
  }
}