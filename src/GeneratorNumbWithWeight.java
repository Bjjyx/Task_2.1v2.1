//Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
//        Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
//        Пример:
//        Дан массив [1, 2, 3], и массив весов [1, 2, 10].
//        В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».
public class GeneratorNumbWithWeight {

    private int[] numbs;
    private int[] weight;

    public GeneratorNumbWithWeight(int[] numbs, int[] weight){

        this.numbs = numbs;
        this.weight = weight;

    }

    public int generator(){

        int generateNumb = 0;

        if (numbs.length != weight.length){
            System.out.println("Ошибка: не совпадение входящих массивов");
            System.exit(1);
        }

        int totalWeight = 0;

        for (int j : weight) {
            totalWeight = totalWeight + j;
        }
        int randomWeight = (int) (Math.random() * ++totalWeight);

        for(int i = 0; i < weight.length; i++){
            if((randomWeight - weight[i]) < 0){
                generateNumb = numbs[i];
            }
        }

//        Тут получается слишком рандомная генерация, по идеи формула не правильная, оставил когд чисто для себя
//        int generateNumb = 0;
//        boolean numbGenerate = false;
//
//        if (numbs.length != weight.length){
//            System.out.println("Ошибка: не совпадение входящих массивов");
//            System.exit(1);
//        }
//
//        while (!numbGenerate){
//            int i = (int) (Math.random()*10);
//            for (int j = 0; j < weight[j]; j++){
//                if (Math.random() > 0.5){
//                    generateNumb = numbs[i];
//                    numbGenerate = true;
//                }
//            }
//        }

        return generateNumb;

    }

}
