package ru.geekbrains.JavaCoreForAndroid;


import java.util.Arrays;

/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 14
 * Created 19.02.2021
 * v 1.0
 */
public class Lesson14 {
    public static void main(String[] args) {

    }

    public static int[] cutFor(int[] arr) throws RuntimeException {
        // модуль поиска (удовлетворения основного условия - найти в массиве 4)
        if(arr.length==0){
            throw new RuntimeException("Пустой массив!");
        } else {
            for(int i = arr.length-1; i>=0; i--){
                if(arr[i]==4){
                    int[] resArr = new int[arr.length-i-1];
                    for(int j=0; j<arr.length-i-1;j++){
                        resArr[j] = arr[i+j+1];
                    }
                    return resArr;
                }
            }
        }
        throw new RuntimeException("Массив не содержит 4!");
    }

    public static boolean containsThreeOrFour(int[] arr) throws RuntimeException {
        // модуль поиска (проверить наличие в массиве 4 и 1 и только их)
        if(arr.length==0) throw new RuntimeException("Пустой массив!");
        int elemIsFound = 0;
        for (int j : arr) {
            if (j != 4 && j != 1) return false;
            if (elemIsFound == 0) elemIsFound = j;
            if (elemIsFound != j) return true;
        }
        return false;
    }
}
