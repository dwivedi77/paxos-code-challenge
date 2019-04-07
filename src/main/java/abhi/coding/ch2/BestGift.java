package abhi.coding.ch2;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Abhishek on 3/25/2019.
 */
@Component(value = "bestGift")
public class BestGift {
    public static void main(String[] args) {
        String fileName = args[0];
        if (fileName == null || "".equals(fileName.trim())){
            System.out.println("File name not provided.");
            return;
        }
        int giftPrice = -1;
        try {
            giftPrice = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("The gift card value is not an integer");
            return;
        }

        Scanner scanner = null;
        InputStream io = BestGift.class.getClassLoader().getResourceAsStream(fileName);
        if (io == null){
            System.out.println("The file could not be loaded");
            return;
        }
        scanner = new Scanner(io);
        List<String> items = new ArrayList<String>();
        List<Integer> prices = new ArrayList<Integer>();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            items.add(tokenizer.nextToken().trim());
            prices.add(Integer.parseInt(tokenizer.nextToken().trim()));
        }
        BestGift bg = new BestGift();
        String flag = args[2];
        if ("Y".equalsIgnoreCase(flag)){
            bg.splitInToThree((Integer[])prices.toArray(), (String[])items.toArray(), giftPrice);
        }else {
            bg.splitInToTwo((Integer[]) prices.toArray(), (String[])items.toArray(), giftPrice);
        }

    }

    public GiftInfo splitInToTwo(Integer[] prices, String[] items, int giftPrice) {
        int i=0, j=prices.length-1;
        int idx1=-1,idx2=-1;

        int prevTotal=-1;
        while (i < j) {
            int total = prices[i] + prices[j];
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
            return null;
        }else{
            System.out.println(items[idx1]+" "+prices[idx1]+", "+items[idx2]+" "+prices[idx2]);
            String[] output = new String[2];
            output[0]=items[idx1]+" "+prices[idx1];
            output[1]=items[idx2]+" "+prices[idx2];
            GiftInfo info = new GiftInfo(output);
            return info;
        }
    }

    public static GiftInfo splitInToThree(Integer[] prices, String[] items, int giftPrice) {
        int i=0, j=prices.length-1;
        int prevBestTotal = 0;
        int[] prevBest = new int[3];
        while (i<j){
            int twoTotal = prices[i]+prices[j];
            if (twoTotal >= giftPrice){
                j--;
            }else{
                for (int k = i+1; k < j; k++) {
                    int threeTotal = twoTotal + prices[k];
                    if (threeTotal < giftPrice){
                        if (threeTotal > prevBestTotal){
                            prevBestTotal = threeTotal;
                            prevBest[0]=i;prevBest[1]=k;prevBest[2]=j;
                        }
                        continue;
                    }else if (threeTotal == giftPrice){
                        System.out.println(i+", "+k+", "+j);
                        System.out.println(items[i]+" "+prices[i]+", "+items[k]+" "+prices[k]+", "+items[j]+" "+prices[j]);

                        String[] output = new String[3];
                        output[0]=items[i]+" "+prices[i];
                        output[1]=items[k]+" "+prices[k];
                        output[2]=items[j]+" "+prices[j];
                        GiftInfo info = new GiftInfo(output);
                        return info;
                    }else {//// threeTotal > giftPrice
                        if (prevBestTotal == 0){
                            System.out.println("Not possible");
                            return null;
                        }else{
                            ///do nothing
                        }
                    }

                }
                i++;
            }
        }
        System.out.println(prevBest[0]+", "+prevBest[1]+", "+prevBest[2]);
        System.out.println(items[prevBest[0]]+" "+prices[prevBest[0]]+", "+items[prevBest[1]]+" "+prices[prevBest[1]]+", "+items[prevBest[2]]+" "+prices[prevBest[2]]);
        String[] output = new String[3];
        output[0]=items[prevBest[0]]+" "+prices[prevBest[0]];
        output[1]=items[prevBest[1]]+" "+prices[prevBest[1]];
        output[2]=items[prevBest[2]]+" "+prices[prevBest[2]];
        GiftInfo info = new GiftInfo(output);
        return info;
    }

}
