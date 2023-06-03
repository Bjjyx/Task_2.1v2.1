import java.util.Scanner;

//Генерация случайного элемента с весом
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        int[] numbs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] weight = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        GeneratorNumbWithWeight generator = new GeneratorNumbWithWeight(numbs, weight);

        System.out.println("Для генерации нажмите 1\nДля окончания нажмите 2\n");
        // Подобие главного меню
        for(;;){

            answer = scanner.nextInt();

            if(answer == 1) {
                System.out.println("Сгенерировано число " + generator.generator());
            } else if (answer == 2) {
                System.out.println("Окончание программы");
                break;
            } else {
                System.out.println("Выход из программы");
                System.exit(0);
            }
        }

    }
}