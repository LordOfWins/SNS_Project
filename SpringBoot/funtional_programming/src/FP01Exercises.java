import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        printCoursesWith4Letters(courses);
        System.out.println("-----");
        printOddNumbersInListStructured(numbers);
        System.out.println("-----");
        printCourses(courses);
        System.out.println("-----");
        printCoursesWithSpring(courses);
        System.out.println("-----");
        printCubeOfOddNumbersInListStructured(numbers);
        System.out.println("-----");
        printCubeOfOddNumbersInListFunctional(numbers);
        System.out.println("-----");
        printNumberofCharactersInCourses(courses);
    }


    private static void printOddNumbersInListStructured(@NotNull List<Integer> numbers) {
        // What to do?
        numbers.stream()
//                .filter(FP01Functional::isEven)
                .filter(number -> number % 2 != 0).forEach(System.out::println);
    }

    private static void printCourses(List<String> courses) {
        // What to do?
        courses.forEach(System.out::println);
    }

    private static void printCoursesWithSpring(List<String> courses) {
        // What to do?
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    private static void printCoursesWith4Letters(List<String> courses) {
        // What to do?
        courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
    }

    private static void printCubeOfOddNumbersInListStructured(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                System.out.println(number * number * number);
            }
        }
    }

    private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {
        // What to do?
        numbers.stream().filter(number -> number % 2 != 0).map(number -> number * number * number).forEach(System.out::println);
    }

    private static void printNumberofCharactersInCourses(List<String> courses) {
        // What to do?
        courses.stream().map(course -> course + ": " + course.length()).forEach(System.out::println);
    }

}
