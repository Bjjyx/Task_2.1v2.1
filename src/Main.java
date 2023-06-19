import java.util.Scanner;

//Генерация случайного элемента с весом
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        int[] numbs = {1, 2, 3};
        int[] weight = {500, 1, 1000};
        GeneratorNumbWithWeight generator = new GeneratorNumbWithWeight(numbs, weight);

        System.out.println("Для генерации введите 1\nДля окончания введите любое другое число\n");
        // Подобие главного меню
        for(;;){

            answer = scanner.nextInt();

            if(answer == 1) {
                System.out.println("Сгенерировано число " + generator.generator());
            } else {
                System.out.println("Выход из программы");
                break;
            }
        }

    }
}