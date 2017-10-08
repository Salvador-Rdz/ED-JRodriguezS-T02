/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jrodriguezs.t02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Salvador
 */
public class EDJRodriguezST02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Getting the input and menu set up
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a palindromos.inc");
        System.out.println("Ingrese una palabra o frase a comprobar: ");
        String in = sc.nextLine();
        //Splits the words and creates an array of string
        String[] words = in.split("\\s+");
        //Initializing 
        char letters[]={};
        ArrayList <Character> phrase = new ArrayList<>();
        Stack pal = new Stack();
        //Splits the words into letters and then adds them to the stack and a list (to compare later)
        for(int i = 0; i<words.length;i++)
        {
            words[i] = words[i].replaceAll("[^\\p{Alnum}]+", ""); //Deletes all non-alphanumeric characters
            letters = words[i].toCharArray();
            for(int j=0; j<letters.length;j++)
            {
                pal.push(letters[j]);
                phrase.add(letters[j]);
            }
        }
        //Initializing variables
        boolean flag = true;
        int i = 0;
        //While the letters correspond between the list and the stack (and it hasn't gonne throughout all the letters)
        while(flag == true && i < phrase.size())
        {
            char c = (Character) pal.pop(); //This is needed since the function pop returns an Object, not a primitive variable
            if(c!=phrase.get(i)) //If it isn't equal...
            {
                flag = false; //then it gets kicked out of the cycle
            }
            i++;
        }
        //And prints results depending on the outcome of the comprobation.
        if(flag == true)
        {
            System.out.println("Es un palindromo");
        }
        else
        {
            System.out.println("No es un palindromo");
        }
    }
    
}
