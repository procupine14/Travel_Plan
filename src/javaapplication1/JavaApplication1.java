/*
 * Packing for a trip program.
 * Just a little application to play around with the basics of Java
 */
package javaapplication1;

/**
 *
 * @author Justin
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStream;








public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //initializing an array to be used for spreadsheet fun later.
        int[] plansArray;
        //initialize a keyboard input vaible with Scanner
        Scanner tripStuff = new Scanner(System.in);
        //initialize a laundry times variable to zero;
        int laundryTimes = 0;
        //prompt user for numer of people going on this trip (expect int)
        System.out.println("How many people going on trip?");
        //assign the value from user to numPeople
        int numPeople = tripStuff.nextInt();
        //print response to make sure everything works and make user feel warm and fuzzy inside
        System.out.println("Awesome, " + numPeople + " people are going on this trip!");
        //prompt user for number of days for trip (also expecting an int)
        System.out.println("How many days is this trip for?");
        //assign the value from user to numdays
        int numDays = tripStuff.nextInt();
        //print another warm fuzzy response for the user
        System.out.println("Great, " + numDays + " days.");
        if(numDays >= 9)
        {
            System.out.println("Well, that's a long time!  How many times are"
                    + " you going to do laundry?");
            laundryTimes = tripStuff.nextInt();
        }
        //do some function calls here for calculating the amount of stuff to bring on the trip
        System.out.println("I'm going to calculate a whole bunch of stuff for "
                + "your trip now.");
        //calls calcClothes function which returns an int
        int indivPants = calcClothes(numDays, laundryTimes);
        //take the value we got from calcClothes and use it to get the total number of pants
        int totalPants = indivPants * numPeople;
        System.out.println("Looks like you're going to need " + indivPants + " "
                + "pairs of pants\n"
        + "per person.  That's " + totalPants + " pants in total."  );
        int indivShirts = calcClothes(numDays, laundryTimes);
        //take the value we got from calcClothes and use it to get the total number of shirts
        System.out.println(indivShirts + " shirts per person \n" + indivShirts * numPeople 
                + " shirts in total");
        int indivSocks = calcClothes(numDays, laundryTimes);
        //take the value we got from calcClothes and use it to get the total number of pairs of socks
        System.out.println(indivSocks + " pairs of socks per person \n" + indivSocks * numPeople 
                + " pairs of socks in total");
        int indivUndies = calcClothes(numDays, laundryTimes);
        //take the value we got from calcClothes and use it to get the total number of underwear
        System.out.println(indivUndies + " underwear per person \n" + indivUndies * numPeople 
                + " underwear in total");
        int toothpasteVol = calcPaste(numDays, numPeople);
        //call calcPaste function which does some very unscientiffically founded math
        //that determines the approximate amount of toothpaste used per person per day
        System.out.println("To avoid halitosis, you probably want to pack at least\n" + toothpasteVol
        + " oz of toothpaste");
        System.out.println("Don't forget the floss!");
        
        System.out.println("Would you like a printable checklist? (yes/no)");
        //function only accepts yes or no and makes a function call to the excel
        //creator API
        String decision;
        Scanner question = new Scanner (System.in);
        boolean yn, check;
        check = false;
        while(!check){
            
            decision = question.nextLine();
            
            switch(decision){
                case "yes":
                    yn = true;
                    check = true;
                    break;
                case "no":
                    yn = false;
                    check = true;
                    break;
                default:
                    System.out.println("Please answer 'yes' or 'no'");
                    break;                  
            }
        }
        System.out.println("I made it out!");
        
    }
    /*function for calculating number of pants for the trip (assuming user changes 
    pants every day and an extra pair for accidents).*/
    public static int calcClothes(int days, int laundry) {
        //probably don't need a function for this but here it is anyway!
        int items = days + 1;
        /*if they are planning on doing laundry this function reduces the total
        amount of clothes required for the trip (also assumes you are washing 
        everything*/
        if(laundry > 0){
            if(items > 1){
            
                switch (laundry){
                    case 1:
                        items = items/2;
                    default:
                        items = items/laundry;
                }
            }
        }
                
        
        
        return items;
    
    }
    public static int calcPaste(int days, int people) {
        //being liberal and saying that each person uses about 1mL (.0338 fl oz) 
        //of toothpaste per day (some may use more or less).
        
        double pasteConst = 0.0338;//daily toothpaste constant
        double totalPaste = (people * pasteConst)* days;
       
        
        if (totalPaste >= 3.0)
        {
            int oz = (int) Math.ceil(totalPaste);
            return oz;
        }else return 3;
        
    }
    
}
