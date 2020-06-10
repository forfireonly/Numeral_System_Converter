package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

interface ConversionInDecimal {
    double convertInDecimal (String number, int radix);
}

interface ConversionInGivenRadix {
    String convertInGivenRadix(int number, int radix);
}

class WholeNumber implements ConversionInDecimal, ConversionInGivenRadix{

    @Override
    public double convertInDecimal(String number, int radix) {
        return Integer.parseInt(number, radix);
    }

    @Override
    public String convertInGivenRadix(int number, int radix) {
        return Integer.toString((int) number, radix);
    }
}

class FractionalNumber implements ConversionInDecimal, ConversionInGivenRadix {

    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public double convertInDecimal(String number, int radix) {
        double decimalValue = 0.0;
        int power = 1;
        for (char each: number.toCharArray()) {
            if (alphabet.contains(String.valueOf(each).toLowerCase())) {
                decimalValue += (alphabet.indexOf(each) + 10) / Math.pow(radix, power);
            } else {
                decimalValue += Double.parseDouble(String.valueOf(each)) / Math.pow(radix, power);
            }
            power++;
        }
        return decimalValue;
    }

    @Override
    public String convertInGivenRadix(int number, int radix) {
        int sizeOfNumber = String.valueOf(number).length();
        //StringBuilder numberString = new StringBuilder();
        double numberFaction = number / Math.pow(10, sizeOfNumber);
        StringBuilder numberString = new StringBuilder();

        for (int i = 1; i <= 5; i++) {
            int whole = (int) (numberFaction * radix);
            //System.out.print(whole);
            if (whole < 10) {
                numberString.append(whole);
            } else {
                numberString.append(alphabet.charAt(whole - 10));
            }
            numberFaction = numberFaction * radix - whole;

        }
        return "." + numberString;

    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        String sourceRadixString = scn.nextLine();
        
       if (Character.isAlphabetic(sourceRadixString.charAt(0))) {
            System.out.print("Error");
            System.exit(0);
        }
        int sourceRadix = Integer.parseInt(sourceRadixString);
        if (sourceRadix < 1 || sourceRadix > 36) {
            System.out.print("Error");
            System.exit(0);
        }
        String sourceNumber = scn.nextLine();

        String radixString ="";

        if (!scn.hasNext()) {
            System.out.print("Error");
            System.exit(0);

        } else {
            radixString = scn.nextLine();
            if (Character.isAlphabetic(radixString.charAt(0))) {
                System.out.print("Error");
                System.exit(0);
            }
        }


        int radix = Integer.parseInt(radixString);
        if (radix < 1 || radix > 36) {
            System.out.print("Error");
            System.exit(0);
        }

        String[] splitNumber = sourceNumber.split("\\.");

        WholeNumber wholeNumber = new WholeNumber();
        FractionalNumber fractionalNumber = new FractionalNumber();

       if (radix == 1) {
           int wholePart = (int) wholeNumber.convertInDecimal(splitNumber[0], sourceRadix);
           StringBuilder wholePartToPrint = new StringBuilder();
           while (wholePart > 0) {
               wholePartToPrint.append(1);
               wholePart--;
           }
           if (splitNumber.length == 2) {
               int fractionalPart = (int) fractionalNumber.convertInDecimal(splitNumber[1], sourceRadix);

               wholePartToPrint.append(".");
               int i = 0;
               while (i < 5 && fractionalPart > 0) {
                   wholePartToPrint.append(1);
                   i++;
                   fractionalPart--;
               }
           }
           System.out.print(wholePartToPrint);

       } else {
           switch (sourceRadix) {
               case 1:
                   int wholeLength = String.valueOf(splitNumber[0]).length();
                   int number = 0;
                   while(wholeLength > 0) {
                       number++;
                       wholeLength--;
                   }
                   if (radix == 10) {
                       System.out.print(number);
                   } else {
                       System.out.print(Integer.toString(number, radix));
                   }
                   break;
               case 10:
                   if (splitNumber.length == 1) {
                       System.out.print(wholeNumber.convertInGivenRadix(Integer.parseInt(splitNumber[0]), radix));
                   } else {
                       System.out.print(wholeNumber.convertInGivenRadix(Integer.parseInt(splitNumber[0]), radix) +
                               fractionalNumber.convertInGivenRadix(Integer.parseInt(splitNumber[1]), radix));
                   }

                   break;
               default:
                   int wholePart = (int) wholeNumber.convertInDecimal(splitNumber[0], sourceRadix);
                   String wholePartRadix = wholeNumber.convertInGivenRadix(wholePart, radix);
                   String fractionalPartRadix;
                   if (splitNumber.length == 1) {
                       fractionalPartRadix = "";
                   }else {
                   double fractionalPart =  fractionalNumber.convertInDecimal(splitNumber[1], sourceRadix);
                   int fractionalPartInt = (int) Math.round(fractionalPart * 10000000);
                   fractionalPartRadix = fractionalNumber.convertInGivenRadix(fractionalPartInt, radix);}
                   System.out.print(wholePartRadix + fractionalPartRadix);

           }
       }


    }

        }


