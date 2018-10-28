class ArrayDemo {
    public static void main(String[] args) {
        // // declare an array of integers
        // int[] anArray;

        // // allocate memory for 5 integers
        // anArray = new int[5];

        // // initialize first element
        // anArray[0] = 100;
        // // second
        // anArray[1] = 200;
        // // etc
        // anArray[2] = 300;
        // anArray[3] = 400;
        // anArray[4] = 500;

        // alternative way of creating the array:
        int[] anArray = {
          100, 200, 300, 400, 500
        };

        System.out.println("Element at index 0: "
                           + anArray[0]);
        System.out.println("Element at index 1: "
                           + anArray[1]);
        System.out.println("Element at index 2: "
                           + anArray[2]);
        System.out.println("Element at index 3: "
                           + anArray[3]);
        System.out.println("Element at index 4: "
                           + anArray[4]);
    }
}