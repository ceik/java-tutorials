class BreakWithLabelDemo {
    public static void main(String[] args) {
        int[][] arrayOfInts = {
            {32, 38, 944, 333},
            {12, 394, 94, 92},
            {84, 33, 11, 7775}
        };
        int searchFor = 12;
        int i;
        int j = 0;
        boolean foundIt = false;

    search:
        for (i = 0; i < arrayOfInts.length; i++) {
            for (j = 0; j < arrayOfInts[i].length; j++) {
                if (arrayOfInts[i][j] == searchFor) {
                    foundIt = true;
                    break search;
                }
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchFor + " at " + i + ", " + j);
        } else {
            System.out.println(searchFor + " not in the array");
        }
    }
}