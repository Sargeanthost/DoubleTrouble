public class Helper {
    public static void printHelper(int[] catAmountArr) {
        switch (catAmountArr[0]) {
            case 0 -> {
                System.out.println("Taking " + catAmountArr[1] + " stones from category Green!");
            }
            case 1 -> {
                System.out.println("Taking " + catAmountArr[1] + " stones from category Orange!");
            }
            case 2 -> {
                System.out.println("Taking " + catAmountArr[1] + " stones from category Yellow!");
            }
        }
    }
}
