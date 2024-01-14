
package com.mycompany.investmentportfolio;
import java.util.Scanner;

public class InvestmentPortfolio {
    static Scanner input = new Scanner (System.in);
    
    static String [] clientNames = new String [5];
    static String [] clientIDs = new String [5];
    static int [] aaplShare = new int [5];
    static int [] msftShare = new int [5];
    static int [] googlShare = new int [5];
    static String [] stockSymbolList = {"AAPL","MSFT","GOOGL"};
    static String [] stockNameList = {"Apple Inc","Microsoft","Alphabet Inc"};
    static float [] previousClosingPrice = {0.40f,25.99f,148.00f};
    static float [] currentPrice = {141.52f,257.22f,95.00f};
    static int serviceID;
    
    public static void main(String[] args) {
        
        getClientsInfo(clientNames,clientIDs,aaplShare,msftShare,googlShare);
        System.out.print("Welcome to Max Profit Stock Exchange");
        do { 
            System.out.println();
            System.out.print("To show equity summary, Please enter 1." +"\n" +"\b"+ "To show stock portfilo, Please enter 2." +"\n"+"\b" + "To exit the program, Please enter 0 \n");
            serviceID = input.nextInt();
            switch(serviceID){
              case 0:
                System.out.println("Message: Program ended"); 
                System.exit(0);
                break;
              case 1:
                System.out.println("Clients Portfilo Summary: "+"\n" + "-----------------------------------"); 
                displayEquitySummary(stockSymbolList,currentPrice);
                break;
              case 2:
                System.out.println("\nStock Status in details: " + "\n" + "-----------------------------------");
                displayStockStatus(stockSymbolList,stockNameList,previousClosingPrice,currentPrice);
                break;
              default:
                System.out.print("Error: Invalid entry");
            }
        } while(serviceID>=0); 
    }
    
    private static void displayStockStatus(String stockSymbolList[],String stockNameList[],float previousClosingPrice[],float currentPrice[]){   //display the status of the stocks
        System.out.println("Stock name \t" + "Stock symbol \t" + "Previous Closing Price"+"     "+ "Current Price \t" + "Change Percent");
          int i;
          
        for (i=0; i<stockNameList.length;i++){
           System.out.printf("%-19s %-20s %-19.2f %-18.2f %5.2f \n",stockNameList[i] ,stockSymbolList[i],previousClosingPrice[i], currentPrice[i], getChangePercent(currentPrice[i],previousClosingPrice[i])); 
        }
        System.out.println("------------------------------------------------");
    }
    
    private static void displayEquitySummary(String stockSymbolList [],float currentPrice []){   //display the value of share equity of the stocks owned by each client
        System.out.println("Name \t\t" + "ID \t\t" + "AAPL \t\t" + "MSFT \t\t" + "GOOGL \t\t");
        for(int i=0;i<5;i++){
        float AAPL=aaplShare[i]*currentPrice[0];
        float MSFT=msftShare[i]*currentPrice[1];
        float GOOGL=googlShare[i]*currentPrice[2];
        if(clientNames[i].length()>6)
            System.out.printf(clientNames[i] + " \t" +clientIDs [i] + "\t\t%.2f \t%.2f \t%.2f \n",(AAPL),(MSFT),(GOOGL));
           else
            System.out.printf(clientNames[i] + " \t\t" +clientIDs [i]+"\t\t%.2f \t%.2f \t%.2f \n",(AAPL),(MSFT),(GOOGL));
        }    
    System.out.println("------------------------------------------------------");
    }
    
    public static void getClientsInfo(String clientNames[],String clientIDs[],int aaplShare[],int msftShare[],int googlShare[]) { //fills the required arrays
        System.out.println("For each client, Please enter the last name of the client followed by the ID(5 digits), the share of AAPL, MSFT, and GOOGL: ");
        for (int i = 0; i<=4; i++){
           clientNames [i] = input.next();
           clientIDs [i] = input.next();
           aaplShare [i] = input.nextInt();
           msftShare [i] = input.nextInt();
           googlShare[i] = input.nextInt();
        }
    }
    
    public static float getChangePercent(float currentPrice,float previousClosingPrice ){ //calculates and returns the percentage changed from previousClosingPrice to currentPrice
        float  ChangePercent ;
        ChangePercent = ((currentPrice - previousClosingPrice) / (previousClosingPrice)) *100;
        return ChangePercent;
    }  
}



