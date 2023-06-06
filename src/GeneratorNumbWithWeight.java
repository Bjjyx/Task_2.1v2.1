import java.util.stream.IntStream;

//Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
//        Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
//        Пример:
//        Дан массив [1, 2, 3], и массив весов [1, 2, 10].
//        В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».
public class GeneratorNumbWithWeight {

    private final int[] numbs;
    private final int[] weight;
    // Конструктор генератора с входящими массивами
    public GeneratorNumbWithWeight(int[] numbs, int[] weight){

        this.numbs = numbs;
        this.weight = weight;

    }
    // Проверяем одинакова ли длинна массивов
    private void isEqual(){

        if (numbs.length != weight.length){
            throw new IllegalArgumentException("Ошибканама, длины массивов не совпадают, иди правь");
        }

    }
    // Сам генератор, который вадает "случайное" значения numbs в зависимости от веса из массива weight
    public int generator(){

        isEqual();

        int totalWeight = IntStream.of(weight).sum();

        int generatedNumb = 0;
        int randomWeight = (int) (Math.random() * (double)totalWeight);

        for(int idx = 0; idx < (numbs.length - 1);  ++idx){
            randomWeight -= weight[idx];
            if (randomWeight <= 0){
                generatedNumb = numbs[idx];
                break;
            }
        }

        return generatedNumb;

    }

}
