package ru.elena.QuadraticEquation;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        solve(0f, 1f, 2f); // The equation is not quadratic.
        System.out.println();
        solve(5f, 1f, 3f); // The equation has no roots.
        System.out.println();
        solve(1f, -6f, 9f); // The equation has 1 root.
        System.out.println();
        solve(2f, 5f, 1f); // The equation has 2 roots.
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
                System.out.printf("The equation has 1 root: %.3f\n", root);
            }
            else {
                double sqrtD = Math.sqrt(D);
                double denom = 2 * a;
                double root1 = (-b + sqrtD) / denom;
                double root2 = (-b - sqrtD) / denom;
                System.out.printf("The equation has 2 roots.\nRoot 1: %.3f\nRoot 2: %.3f\n", root1, root2);
            }
        }
    }
}
