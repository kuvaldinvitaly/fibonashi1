package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestFib {
    private Logger log = LogManager.getLogger();
    private FibCalc fibCalc;

    @BeforeClass
    public void setUp() {
        fibCalc = new FibCalc();
        log.info("Запуск теста чисел Фибоначчи");
    }

    @DataProvider(parallel = true)
    public static Object[][] data() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {10, 55},
                {50, 12586269025L},
                {-3, 2},
                {-10, -55},
                {-7, 13}
        };
    }

    @Test(dataProvider = "data")
    public void testFib(long n, long exp) {
        long calculation = fibCalc.calc(n);
        log.info("Получено число {}", calculation);
        Assert.assertEquals(calculation, exp, "Неправильный ответ");
    }


    @AfterClass
    public void afterClass() {
        log.info("Завершение теста чисел Фибоначчи");
        System.out.println();
    }

}
