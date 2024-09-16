package com.csc;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class GroceryCounter
{
    public static ArrayList<Integer> counter;
    public static int spillover_total;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        counter = new ArrayList<>(Collections.nCopies(4,0));
        spillover_total=0;
        while (true)
        {
            try
            {
            System.out.print("\n Please enter 'T' for tens, 'O' for ones, 'Th' for tenths, 'H' for hundreths, 'Total' to see total, 'Overflow' to see number of overflows, and 'Clear' to clear counter: ");
            String entry = in.next();
            
            try {
                if (entry.equals("Clear"))
                {
                    clear();
                    break;
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            if (entry.length() > 0)
            {
                switch (entry)
                {
                    case "T":
                        tens();
                        break;
                    case "O":
                        ones();
                        break;
                    case "Th":
                        tenths();
                        break;
                    case "H":
                        hundreths();
                        break;
                    case "Total":
                        total();
                        break;
                    case "Overflow":
                        number_of_overflows();
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                }
                
            }   //if
          } //try
          catch (Exception ex)
          {

          }
        }
        in.close();
    }

    
    public static void hundreths()
    {
        if (counter.get(3) < 10)
        {
            counter.set(3,counter.get(3)+1);
        }
        else if (counter.get(3) == 10)
        {
            counter.set(2,counter.get(2) +1);
            counter.set(3,0);
        }
    }

    public static void tenths()
    {
        if (counter.get(2) < 10)
        {
            counter.set(2,counter.get(2)+1);
        }
        else if (counter.get(2) == 10)
        {
            counter.set(1,counter.get(1) +1);
            counter.set(2,0);
        }
    }

    public static void ones()
    {
        if (counter.get(1) < 10)
        {
            counter.set(1,counter.get(1)+1);
        }
        else if (counter.get(1) == 10)
        {
            counter.set(0,counter.get(0) +1);
            counter.set(1,0);
        }
    }

    public static void tens()
    {
        if (counter.get(0) < 10)
        {
            counter.set(0,counter.get(0)+1);
        }
        else if (counter.get(0) == 10)
        {
            spillover_total += 1;
            counter.set(0,0);
        }
    }
    
    public static void number_of_overflows()
    {
        System.out.printf("%nTotal Spillovers: %d", spillover_total);
    }


    public static void total()
    {
        float tens_final = counter.get(0) * 10;
        float ones_final = counter.get(1);
        float tenths_final = (float) (counter.get(2) * 0.1);
        float hundreths_final = (float) (counter.get(3) * 0.01);
        float spillover_final = spillover_total *100;

        float total_amount = spillover_final + hundreths_final + tenths_final + ones_final + tens_final;
        System.out.println("Your Total is " + total_amount);
    }

    public static void clear()
    {
      counter = new ArrayList<>(Collections.nCopies(4,0));
      spillover_total = 0;
    }
    
}



