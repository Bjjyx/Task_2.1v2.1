import java.util.Arrays;
import java.util.stream.IntStream;

//Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
//        Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
//        Пример:
//        Дан массив [1, 2, 3], и массив весов [1, 2, 10].
//        В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».
public class GeneratorNumbWithWeight {

    private final int[] numbsArray;
    private final int[] weightArray;
    private int[] sortedWeightArray;
    private int[] sortedNumbsArray;
    // Конструктор генератора с входящими массивами
    public GeneratorNumbWithWeight(int[] numbs, int[] weight){

        this.numbsArray = numbs;
        this.weightArray = weight;

    }
    // Проверяем одинакова ли длинна массивов
    private void isEqual(){

        if (numbsArray.length != weightArray.length){
            throw new IllegalArgumentException("Ошибканама, длины массивов не совпадают, иди правь");
        }

    }
    //Проверка на наличие отрицательного веса
    private void checkWeight(){

        for (int j : weightArray) {
            if (j < 0) {
                throw new IllegalArgumentException("Вес не может быть меньше нуля");
            }
        }

    }
    //Сортируем массив вероятносте по возрастанию вероятности и в соответствии сортируем массив чисел
    private void sortedArrays(){

        sortedNumbsArray = new int[weightArray.length];
        sortedWeightArray = Arrays.stream(weightArray).sorted().toArray();
        for (int i = 0; i < weightArray.length; i++ ){
            for(int j = 0; j < sortedWeightArray.length; j++){
                if (weightArray[i] == sortedWeightArray[j]){
                    sortedNumbsArray[j] = numbsArray[i];
                }
            }
        }
    }
    // Сам генератор, который вадает "случайное" значения numbs в зависимости от веса из массива weight
    public int generator(){

        isEqual();
        checkWeight();
        sortedArrays();

        int totalWeight = IntStream.of(weightArray).sum();

        int generatedNumb = 0;
        int weight = 0;
        int randomWeight = (int) (Math.random() * (double)totalWeight);

        for(int i = 0; i < sortedWeightArray.length; i++){

            weight = weight + sortedWeightArray[i];
            if (weight >= randomWeight){
                generatedNumb = sortedNumbsArray[i];
                break;
            }
        }

        return generatedNumb;

    }

}
