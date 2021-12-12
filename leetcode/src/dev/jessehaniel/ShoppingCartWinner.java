package dev.jessehaniel;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartWinner {

    /*
     * Complete the 'foo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codeList
     *  2. STRING_ARRAY shoppingCart
     */

    public static int foo(List<String> codeList, List<String> shoppingCart) {
        // Write your code here
        String[][] codeMatrix = codeList.stream().map(s -> s.split("[ ,]"))
            .collect(Collectors.toList()).toArray(new String[0][0]);
        return freshPromotion(codeMatrix, shoppingCart.toArray(new String[0]));
    }

    private static int freshPromotion(String[][] codeList, String[] shoppingCart) {
//        Start at 0 index for both the code list and shopping cart.
        int cartIdx = 0;
        int codeIdx = 0;
        while (cartIdx < shoppingCart.length && codeIdx < codeList.length) {
            String cur = shoppingCart[cartIdx];
//            If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
            if((codeList[codeIdx][0].equals("anything") || codeList[codeIdx][0].equals(cur)) && hasOrder(shoppingCart, cartIdx, codeList[codeIdx])){
                cartIdx += codeList[codeIdx++].length;
            }else{
                cartIdx++;
            }
        }
//        If the all the codeList is present then return 1, else 0.
        return codeIdx == codeList.length ? 1 : 0;
    }

    private static boolean hasOrder(String[] shoppingCart, int idx, String[] order) {
//        Loop through the codeList to check if the fruits are in order.
        for (String s : order) {
            if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))){
                idx++;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> codeList = List.of("apple apple", "banana anything banana");
        List<String> shoppingCart = List.of("orange", "apple", "apple", "banana", "orange", "banana");
        System.out.println(ShoppingCartWinner.foo(codeList, shoppingCart));//1

        codeList = List.of("orange", "apple apple", "banana orange apple", "banana");
        shoppingCart = List.of("banana", "orange", "banana", "apple", "apple");
        System.out.println(ShoppingCartWinner.foo(codeList, shoppingCart));//0

        codeList = List.of("apple apple", "banana anything banana");
        shoppingCart = List.of("apple", "banana", "apple", "banana", "orange", "banana");
        System.out.println(ShoppingCartWinner.foo(codeList, shoppingCart));//0

        codeList = List.of("apple apple", "apple apple banana");
        shoppingCart = List.of("apple", "apple", "apple", "banana");
        System.out.println(ShoppingCartWinner.foo(codeList, shoppingCart));//0
    }
}
