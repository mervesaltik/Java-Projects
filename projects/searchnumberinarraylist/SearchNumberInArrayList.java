package searchnumberinarraylist;
import java.util.*;

public class SearchNumberInArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number that you want to search in ArrayList : ");
        int searchNumber = scanner.nextInt();
        scanner.close();

        ArrayList<Integer> arrayList = createRandomNumbersInArrayList();

        System.out.println("ArrayList with 100 random integer numbers between 1-100 : ");
        System.out.println("ArrayList : ");
        System.out.println(arrayList);

        Collections.sort(arrayList);
        System.out.println("Sorted ArrayList:");
        System.out.println(arrayList);

        int occurrences = countOccurrences(arrayList, searchNumber);
        System.out.printf("The number (%d) occurred %d times in your ArrayList.\n", searchNumber, occurrences);

        int numberOfOdd = countOddNumbers(arrayList);
        int numberOfEven = countEvenNumbers(arrayList);
        System.out.printf("The odd numbers occurred %d times in your ArrayList.\n", numberOfOdd);
        System.out.printf("The even numbers occurred %d times in your ArrayList.\n", numberOfEven);

        System.out.println("Odd Numbers:");
        printOddNumbers(arrayList);

        System.out.println("Even Numbers:");
        printEvenNumbers(arrayList);
    }

    private static ArrayList<Integer> createRandomNumbersInArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(100) + 1;
            arrayList.add(randomNumber);
        }
        return arrayList;
    }

    private static int countOccurrences(ArrayList<Integer> arrayList, int searchNumber) {
        int count = 0;
        for (int number : arrayList) {
            if (number == searchNumber) {
                count++;
            }
        }
        return count;
    }

    private static int countOddNumbers(ArrayList<Integer> arrayList) {
        int count = 0;
        for (int number : arrayList) {
            if (number % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    private static int countEvenNumbers(ArrayList<Integer> arrayList) {
        int count = 0;
        for (int number : arrayList) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static void printOddNumbers(ArrayList<Integer> arrayList) {
        for (int number : arrayList) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void printEvenNumbers(ArrayList<Integer> arrayList) {
        for (int number : arrayList) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}

