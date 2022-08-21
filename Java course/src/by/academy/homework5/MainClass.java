package by.academy.homework5;

import java.time.LocalTime;
import java.util.*;

public class MainClass {

    private static Random random = new Random();

    public static void main(String[] args){

//        Task 1

        Collection<Integer> array = new ArrayList<>(){{
            int i = 0;
            while (++i <= 20){
                add(random.nextInt(10));
            }
        }};
        System.out.println(array);
        array = getUniqueArray(array);
        System.out.println(array);

//        Task 2

        List<Integer> linkedList = new LinkedList<>();
        addItems(linkedList);
        System.out.println("LinkedList start time = " + LocalTime.now());
        getItem(linkedList);
        LocalTime llEndTime = LocalTime.now();
        System.out.println("LinkedList end time = " + llEndTime);

        List<Integer> arrayList = new ArrayList<>();
        addItems(arrayList);
        System.out.println("ArrayList start time = " + LocalTime.now());
        getItem(arrayList);
        LocalTime alEndTime = LocalTime.now();
        System.out.println("ArrayList end time = " + alEndTime);

//        Task 3

        Integer [][] arr = {{1,2,3,4},{5,6,7,8,9,0}};
        String [][] arr1 = {{"q", "a", "z"}, {"w", "s", "x"}};
        NewIterator<?> iterator = new NewIterator<>(arr);
        NewIterator<?> iterator1 = new NewIterator<>(arr1);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

//        Task 4

        List <Integer> classMarks = new ArrayList<>(){{

            int classCount = 25;
            while (classCount-- > 0){
                add(random.nextInt(10));
            }
        }};
        System.out.println("All class marks: " + classMarks);
        System.out.println("The highest mark: " + getHighestMark(classMarks));

//        Task 5

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        scanner.close();
        Collection <Character> list = new ArrayList<>();

        for (Character c :text.toCharArray()){
            list.add(c);
        }
        Collection <Character> key = getUniqueArray(list);
        List <Integer> value = new ArrayList<>(key.size());

        Integer number = 0;
        for (Character c: key){
            for (Character e: list){
                if(c.equals(e)){
                    number++;
                }
            }
            value.add(number);
            number = 0;
        }

        Map<Character, Integer> dictionary = new HashMap<>();
        for (Character c: key){
            dictionary.put(c, value.get(number));
            System.out.println("Key = " + c + ", Value = " + value.get(number++));
        }

//        Task 6

        int [] exceptionArray = new int[8];

        try{
            exceptionCheck(exceptionArray);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array is too small, expand the array");
        }


    }

    public static Collection getUniqueArray(Collection <?> arrayT){
        return  new HashSet(arrayT);
    }

    public static void addItems(List <Integer> arrayToAdd){
        int i = 0;
        while (++i <= 1000000){
            arrayToAdd.add(i);
        }
    }

    public static void getItem (List arrayToGet){
        int i = 0;
        while (++i <= 100000){
            arrayToGet.get(random.nextInt(10));
        }
    }

    public static Integer getHighestMark(List classMarks){

        Iterator<Integer> iterator2 = classMarks.iterator();
        Integer highestMark = (Integer) classMarks.get(0);

        while (iterator2.hasNext()){
            if (highestMark < iterator2.next()){
                highestMark = iterator2.next();
            }
        }
        return highestMark;
    }

    public static void exceptionCheck(int [] array) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < 11; i++) {
            array[i] = random.nextInt(10);
        }
    }
}
