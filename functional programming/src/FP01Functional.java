import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FP01Functional {

    static List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

//    private static void print(Integer integer) {
//        System.out.println(integer);
//    }

    public static void main(String[] args) {
        printAllNumbersInListStructured(numbers);
        System.out.println("-----");
        printEvenNumbersInListStructured(numbers);
        System.out.println("-----");
        printSquareOfEvenNumbersInListStructured(numbers);
        System.out.println("-----");
        printSquareOfOddNumbersInListStructured(numbers);

    }

//    private static boolean isEven(Integer integer) {
//        return integer % 2 == 0;
//    }

    private static void printAllNumbersInListStructured(@org.jetbrains.annotations.NotNull List<Integer> numbers) {
        // What to do?
        numbers.forEach(System.out::println);
        // How to loop the numbers?
//        for (int number : numbers) {
//            System.out.println(number);
//        }
    }

    private static void printEvenNumbersInListStructured(@NotNull List<Integer> numbers) {
        // What to do?
        numbers.stream()
//                .filter(FP01Functional::isEven)
                .filter(number -> number % 2 == 0).forEach(System.out::println);
        // How to loop the numbers?
//        for (int number : numbers) {
//            System.out.println(number);
//        }
    }

    private static void printSquareOfEvenNumbersInListStructured(@NotNull List<Integer> numbers) {
        // What to do?
        numbers.stream().filter(number -> number % 2 == 0).map(number -> number * number).forEach(System.out::println);
        // How to loop the numbers?
//        for (int number : numbers) {
//            System.out.println(number);
//        }
    }

    private static void printSquareOfOddNumbersInListStructured(@NotNull List<Integer> numbers) {
        // What to do?
        numbers.stream().filter(number -> number % 2 != 0).map(number -> number * number).forEach(System.out::println);
        // How to loop the numbers?
    }

}
