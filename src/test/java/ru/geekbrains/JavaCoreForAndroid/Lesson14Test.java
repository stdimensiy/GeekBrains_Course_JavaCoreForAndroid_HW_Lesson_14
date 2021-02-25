package ru.geekbrains.JavaCoreForAndroid;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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
public class Lesson14Test {
    Lesson14 lesson14 = new Lesson14();

    // выполнение дискретных тестов для методлв класса lesson14
    @Test
    public void containsOneOrFourTest() {
        Assert.assertTrue(lesson14.containsOneOrFour(new int[]{1, 1, 4, 4, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest1() {
        Assert.assertFalse(lesson14.containsOneOrFour(new int[]{1, 1, 4, 3, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest2() {
        Assert.assertFalse(lesson14.containsOneOrFour(new int[]{1, 0, 1, 1, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest3() {
        Assert.assertFalse(lesson14.containsOneOrFour(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest4() {
        Assert.assertFalse(lesson14.containsOneOrFour(new int[]{4, 4, 4, 4, 4, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void containsOneOrFourTest5() {
        Assert.assertFalse(lesson14.containsOneOrFour(new int[]{}));
    }

    @Test
    public void cutForTest() {
        Assert.assertArrayEquals(new int[]{5, 6}, lesson14.cutFor(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void cutForTest1() {
        Assert.assertArrayEquals(new int[]{5, 6, 7}, lesson14.cutFor(new int[]{1, 2, 4, 4, 5, 6, 7}));
    }

    @Test
    public void cutForTest2() {
        Assert.assertArrayEquals(new int[]{}, lesson14.cutFor(new int[]{1, 2, 3, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void cutForTest4() {
        Assert.assertArrayEquals(new int[]{}, lesson14.cutFor(new int[]{1, 2, 3, 10, 5, 3}));
    }

    @Test(expected = RuntimeException.class)
    public void cutForTest5() {
        Assert.assertArrayEquals(new int[]{}, lesson14.cutFor(new int[]{}));
    }

    //Использование параметризации

    @RunWith(Parameterized.class)
    public static class Parametrizedtest {
        @Parameterized.Parameters
        public static Collection<Object> params() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}},
                    {new int[]{1, 2, 3, 4, 7, 8, 9}, new int[]{7, 8, 9}},
                    {new int[]{1, 2, 3, 4, 5}, new int[]{5}},
                    {new int[]{1, 2, 3, 4}, new int[]{}},
            });
        }
        private int[] in1, res;
        private Lesson14 lesson14 = new Lesson14();

        public Parametrizedtest(int[] in1, int[] res) {
            this.in1 = in1;
            this.res = res;
        }

        @Test
        public void cutForTest1() {
            Assert.assertArrayEquals(res, lesson14.cutFor(in1));
        }
    }
}
