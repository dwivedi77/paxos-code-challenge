package abhi.coding.ch2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Abhishek on 3/25/2019.
 */
public class BestGift {
    public static void main(String[] args) {

        String fileName = "inventory.txt";
//        String fileName = args[0];
        if (fileName == null || "".equals(fileName.trim())){
            System.out.println("File name not provided.");
            return;
        }
//        int giftPrice = -1;
//        try {
//            giftPrice = Integer.parseInt(args[1]);
//        } catch (NumberFormatException e) {
//            System.out.println("The gift card value is not an integer");
//            return;
//        }

        int giftPrice = 2200;
        Scanner scanner = null;
        InputStream io = BestGift.class.getClassLoader().getResourceAsStream(fileName);
        if (io == null){
            System.out.println("The file could not be loaded");
            return;
        }
        scanner = new Scanner(io);
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            items.add(tokenizer.nextToken().trim());
            prices.add(Integer.parseInt(tokenizer.nextToken().trim()));
        }

//        splitInToTwo(prices, items, giftPrice);
        splitInToThree(prices, items, giftPrice);

    }

    private static void splitInToThree(ArrayList<Integer> prices, ArrayList<String> items, int giftPrice) {
        int i=0, j=prices.size()-1;
        int prevBestTotal = 0;
        int[] prevBest = new int[3];
        while (i<j){
            int twoTotal = prices.get(i)+prices.get(j);
            if (twoTotal >= giftPrice){
                j--;
            }else{
                for (int k = i+1; k < j; k++) {
                    int threeTotal = twoTotal + prices.get(k);
                    if (threeTotal < giftPrice){
                        if (threeTotal > prevBestTotal){
                            prevBestTotal = threeTotal;
                            prevBest[0]=i;prevBest[1]=k;prevBest[2]=j;
                        }
                        continue;
                    }else if (threeTotal == giftPrice){
                        System.out.println(i+", "+k+", "+j);
                        System.out.println(items.get(i)+" "+prices.get(i)+", "+items.get(k)+" "+prices.get(k)+", "+items.get(j)+" "+prices.get(j));
                        return;
                    }else {//// threeTotal > giftPrice
                        if (prevBestTotal == 0){
                            System.out.println("Not possible");
                            return;
                        }else{
                            ///do nothing
                        }
                    }

                }
                i++;
            }
        }
        System.out.println(prevBest[0]+", "+prevBest[1]+", "+prevBest[2]);
        System.out.println(items.get(prevBest[0])+" "+prices.get(prevBest[0])+", "+items.get(prevBest[1])+" "+prices.get(prevBest[1])+", "+items.get(prevBest[2])+" "+prices.get(prevBest[2]));
    }

    private static void splitInToTwo(ArrayList<Integer> prices, ArrayList<String> items, int giftPrice) {
        int i=0, j=prices.size()-1;
        int idx1=-1,idx2=-1;

        int prevTotal=-1;
        while (i < j) {
            int total = prices.get(i) + prices.get(j);
            if (total > giftPrice) {
                j--;continue;
            }else if (total == giftPrice) {
                //this is the answer;
                idx1=i;idx2=j;
                break;
            }else{
                if (prevTotal > total){
                    break;
                }
                idx1=i;idx2=j;
                prevTotal = total;
                i++;continue;
            }
        }
        if (idx1==-1 || idx2 ==-1){
            System.out.println("Not possible");
        }else{
            System.out.println(items.get(idx1)+" "+prices.get(idx1)+", "+items.get(idx2)+" "+prices.get(idx2));
        }
    }

    private static void findBestGiftCombo(){

    }
}
