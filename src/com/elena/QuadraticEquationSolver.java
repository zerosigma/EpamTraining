package com.elena;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        float a = 1f;
        float b = -6f;
        float c = 9f;

        solve(a, b, c);
    }

    private static void solve(float a, float b, float c) {
        if (a == 0) {
            System.out.println("The coefficient 'a' should not be zero.");
            return;
        }

        double part1 = Math.pow(b, 2.0);
        double part2 = 4 * a * c;
        if (part1 < part2)
            System.out.println("The equation does not have roots.");
        else {
            double D = part1 - part2;
            if (D == 0) {
                double root = -b / 2 * a;
                System.out.printf("The equation has 1 root: %.3f", root);
            }
            else {
                double sqrtD = Math.sqrt(D);
                double denom = 2 * a;
                double root1 = (-b + sqrtD) / denom;
                double root2 = (-b - sqrtD) / denom;
                System.out.printf("The equation has 2 roots.\nRoot 1: %.3f\nRoot 2: %.3f", root1, root2);
            }
        }
    }
}
