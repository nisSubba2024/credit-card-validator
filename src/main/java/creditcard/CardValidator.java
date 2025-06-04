package creditcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardValidator {
    private long cardNumber;
    private List<Integer> numberArray;

    public CardValidator(long cardNumber) {
        this.cardNumber = cardNumber;
        this.numberArray = new ArrayList<>();
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Integer> getNumberArray() {
        return numberArray;
    }

    public void setNumberArray(List<Integer> numberArray) {
        this.numberArray = numberArray;
    }

    public void creditCardNumbers() {
        String creditCardNumber = String.valueOf(cardNumber);

        for (char c : creditCardNumber.toCharArray()) {
            numberArray.add(Integer.parseInt(String.valueOf(c)));
        }

    }

    public String network() {
        Map<Integer, String> networkGroup = new HashMap<>();
        networkGroup.put(1, "Air travel, financial services");
        networkGroup.put(2, "Air travel, financial services");
        networkGroup.put(3, "American Express");
        networkGroup.put(4, "Visa");
        networkGroup.put(5, "Mastercard");
        networkGroup.put(6, "Discover");
        networkGroup.put(7, "Petroleum");
        networkGroup.put(8, "Healthcare and telecommunications");
        networkGroup.put(9, "Government and “other”");

        return networkGroup.getOrDefault(numberArray.getFirst(), "Unknown");
    }

    public void displayNumber() {
        String isValid = lahnCheck() ? "VALID" : "INVALID";
        System.out.println("**********************************************************");
        System.out.println("\t\t\t\tCredit Card Validator");
        System.out.println("Credit Card Number: " + cardNumber);
        System.out.println("Valid or Invalid: " + isValid);
        System.out.println("Card Network: " + network());
        System.out.println("**********************************************************");

    }

    public boolean lahnCheck() {
        List<Integer> copyArray = new ArrayList<>(numberArray);
        for (int i = copyArray.size() - 2; i >= 0; i -= 2) {
            int numDoubled = copyArray.get(i) * 2;
            if (numDoubled > 9) {
                String numStr = String.valueOf(numDoubled);
                int total = 0;
                for (char chr : numStr.toCharArray()) {
                    total += Integer.parseInt(String.valueOf(chr));
                }
                numDoubled = total;
            }
            copyArray.set(i, numDoubled);
        }

        int total = 0;
        for (Integer num : copyArray) {
            total += num;
        }
        return total % 10 == 0;
    }

    public static void main(String[] args) {
        long cardNumber = 79927398713L;
        CardValidator cardValidator = new CardValidator(cardNumber);
        cardValidator.creditCardNumbers();
        cardValidator.displayNumber();
    }
}
