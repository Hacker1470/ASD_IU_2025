package solutions;

import java.util.*;

public class Task0
{
    /*
    Создать класс Student с полями:
        1. Long id
        2. String name

    В методе main:
        1. Создать ArrayList, который хранит объекты класса Student
        (ArrayList<Student>).
        2. Создать LinkedList, который хранит объекты класса Student
        (LinkedList <Student>).
        3. Создать Set, который хранит объекты класса Student (HashSet
        <Student>).
        4. Создать HashMap, который хранит объекты класса Student (HashMap
        <Long, Student>).
    В каждую структуру данных добавить 10 000 000 объектов.

    После этого для каждой структуры данных измерить время в нс:
        1. Добавление 1 несуществующего элемента в конец (id = 10 000 001).
        2. Добавление 1 несуществующего элемента в начало.
        3. Удаление последнего элемента
        4. Удаление первого элемента
        5. Взятие (Get) центрального элемента (id = 5 000 000)
        6. Взятие (Get) последнего элемента (id = 9 999 999).

    Помимо кода решение должно содержать цифры, полученные при
    тестах. При невозможности работать с 10 000 000 записей позволительно
    несколько сократить количество объектов.
    */
    public static void Start()
    {
        ArrayList<Student> arrayList = new ArrayList<>();
        LinkedList<Student> linkedList = new LinkedList<>();
        Set<Student> hashSet = new HashSet<>();
        HashMap<Long, Student> hashMap = new HashMap<>();

        Student tempStud;

        for(long i = 1; i <= 10_000_000L;i++)
        {
            tempStud = new Student(i, String.valueOf(i));
            arrayList.add(tempStud);
            linkedList.add(tempStud);
            hashSet.add(tempStud);
            hashMap.put(i, tempStud);
        }

        Student studId0 = new Student(0L, String.valueOf(0L));
        Student studId10M1 = new Student(10_000_001L, String.valueOf(10_000_001L));
        long after, before;

        // Испытание ArrayList
        System.out.println("| Arraylist |");

        before = System.nanoTime();
        arrayList.addLast(studId10M1);
        after = System.nanoTime();
        System.out.println("- Добавление в конец: " + (after - before));

        before = System.nanoTime();
        arrayList.addFirst(studId0);
        after = System.nanoTime();
        System.out.println("- Добавление в начало: " + (after - before));

        before = System.nanoTime();
        arrayList.removeLast();
        after = System.nanoTime();
        System.out.println("- Удаление последнего: " + (after - before));

        before = System.nanoTime();
        arrayList.removeFirst();
        after = System.nanoTime();
        System.out.println("- Удаление первого: " + (after - before));

        before = System.nanoTime();
        tempStud = arrayList.get(5000000);
        after = System.nanoTime();
        System.out.println("- Взятие центрального: " + (after - before));

        before = System.nanoTime();
        tempStud = arrayList.get(9999999);
        after = System.nanoTime();
        System.out.println("- Взятие последнего: " + (after - before));

        // Испытание LinkedList
        System.out.println("\n| LinkedList |");

        before = System.nanoTime();
        linkedList.addLast(studId10M1);
        after = System.nanoTime();
        System.out.println("- Добавление в конец: " + (after - before));

        before = System.nanoTime();
        linkedList.addFirst(studId0);
        after = System.nanoTime();
        System.out.println("- Добавление в начало: " + (after - before));

        before = System.nanoTime();
        linkedList.removeLast();
        after = System.nanoTime();
        System.out.println("- Удаление последнего: " + (after - before));

        before = System.nanoTime();
        linkedList.removeFirst();
        after = System.nanoTime();
        System.out.println("- Удаление первого: " + (after - before));

        before = System.nanoTime();
        tempStud = linkedList.get(5000000);
        after = System.nanoTime();
        System.out.println("- Взятие центрального: " + (after - before));

        before = System.nanoTime();
        tempStud = linkedList.get(9999999);
        after = System.nanoTime();
        System.out.println("- Взятие последнего: " + (after - before));


        boolean containsStudent;
        Student studIdMid = new Student(5_000_000L, String.valueOf(5_000_000L));
        Student studId9M9 = new Student(9_999_999L, String.valueOf(9_999_999L));

        // Испытание HashSet
        System.out.println("\n| HashSet |");

        before = System.nanoTime();
        hashSet.add(studId10M1);
        after = System.nanoTime();
        System.out.println("- Добавление в конец: " + (after - before));

        before = System.nanoTime();
        hashSet.add(studId0);
        after = System.nanoTime();
        System.out.println("- Добавление в начало: " + (after - before));

        before = System.nanoTime();
        hashSet.remove(studId10M1);
        after = System.nanoTime();
        System.out.println("- Удаление последнего: " + (after - before));

        before = System.nanoTime();
        hashSet.remove(studId0);
        after = System.nanoTime();
        System.out.println("- Удаление первого: " + (after - before));

        before = System.nanoTime();
        containsStudent = hashSet.contains(studIdMid);
        after = System.nanoTime();
        System.out.println("- Взятие центрального: " + (after - before));

        before = System.nanoTime();
        containsStudent = hashSet.contains(studId9M9);
        after = System.nanoTime();
        System.out.println("- Взятие последнего: " + (after - before));

        // Испытание HashMap
        System.out.println("\n| HashMap |");

        before = System.nanoTime();
        hashMap.put(studId10M1.getId(), studId10M1);
        after = System.nanoTime();
        System.out.println("- Добавление в конец: " + (after - before));

        before = System.nanoTime();
        hashMap.put(studId0.getId(), studId0);
        after = System.nanoTime();
        System.out.println("- Добавление в начало: " + (after - before));

        before = System.nanoTime();
        hashMap.remove(studId10M1.getId());
        after = System.nanoTime();
        System.out.println("- Удаление последнего: " + (after - before));

        before = System.nanoTime();
        hashMap.remove(studId0.getId());
        after = System.nanoTime();
        System.out.println("- Удаление первого: " + (after - before));

        before = System.nanoTime();
        tempStud = hashMap.get(studIdMid.getId());
        after = System.nanoTime();
        System.out.println("- Взятие центрального: " + (after - before));

        before = System.nanoTime();
        tempStud = hashMap.get(studId9M9.getId());
        after = System.nanoTime();
        System.out.println("- Взятие последнего: " + (after - before));
    }
}
/*
| Arraylist |
    - Добавление в конец: 4400
    - Добавление в начало: 3814100
    - Удаление последнего: 4000
    - Удаление первого: 3612700
    - Взятие центрального: 5300
    - Взятие последнего: 1000

| LinkedList |
    - Добавление в конец: 4400
    - Добавление в начало: 5200
    - Удаление последнего: 2500
    - Удаление первого: 1300
    - Взятие центрального: 31401700
    - Взятие последнего: 16600

| HashSet |
    - Добавление в конец: 12100
    - Добавление в начало: 500
    - Удаление последнего: 7800
    - Удаление первого: 1000
    - Взятие центрального: 3400
    - Взятие последнего: 800

| HashMap |
    - Добавление в конец: 8900
    - Добавление в начало: 10900
    - Удаление последнего: 5700
    - Удаление первого: 1100
    - Взятие центрального: 6200
    - Взятие последнего: 1000
 */