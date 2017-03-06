package com.eprogrammerz.examples.general.inheritance;

/**
 * Created by 542596 on 3/3/2017.
 */
public class AccountCalculator {
    public static void main(String args[]) {
        System.out.println(new AccountCalculator().findTotalSaving(new int[]{30,40}, new int[]{10,20}) == 500);
    }

    public static int savings = 0;
    private static int findTotalSaving(int[] credits, int[] debits) {
        for(int i = 0; i < credits.length; i++) {
            savings += credits[i];
        }
        for (int i =0; i < debits.length; i++) {
            savings += debits[i];
        }
        return savings;
    }
}
