public class Main {
    public static void main(String[] args) {

        String[][] arr = new String[][]{
                {"1", "2", "3","4"},
                {"2", "10", "4", "3"},
                {"1", "L", "2", "2"},
                {"2", "2", "2", "2"}
        };

        try {
            int result = method(arr);
            System.err.println(result);
        } catch (MyArraySizeException e) {
            System.err.println("Размер массива превышен!");
        }
        catch (MyArrayDataException e) {
            System.err.println("Неправильное значение массива!");
            System.err.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }

    }


    public static int method (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }
}
