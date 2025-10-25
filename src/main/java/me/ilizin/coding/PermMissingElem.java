package me.ilizin.coding;

public class PermMissingElem {

    public int findMissingElement(int[] values) {
        int[] readValues = new int[values.length + 1];
        for (int value: values) {
            readValues[value - 1] = 1;
        }
        int i = 0;
        boolean found = false;
        while (!found) {
            if (readValues[i] == 0) {
                found = true;
            } else {
                i++;
            }
        }
        return i + 1;
    }
}
