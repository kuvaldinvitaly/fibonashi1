package org.example;

 public class FibCalc {
    public long calc(long i) {
        if (i == 0 || i == 1) {
            return i;
        }
        if (i == -1) {
            return 1;
        }
        if (i < 0) {
            int f = i % 2 == 0 ? -1 : 1;
            return f * calc(-i);
        } else {
            return calc(i - 1) + calc(i - 2);
        }
    }
}
