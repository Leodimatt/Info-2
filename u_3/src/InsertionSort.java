
public class InsertionSort{

        public static void main(String[] args) {
            Person[] people = {
                    new Person("Alice", 30, "alice@example.com"),
                    new Person("Leonardo", 20, "leonardo@example.com"),
                    new Person("Yasmin", 20, "yasmin@example.com"),
                    new Person("Marie", 20, "marie@example.org"),
                    new Person("Emma", 22, "emma@website.com")
            };
            insertionSort(people);

            for (Person person : people) {
                System.out.println(person);
                System.out.println();
            }

//            String[] array = { "Foo", "Bar", "Baz", "foo", "42", "Foobar"};
//            insertionSort(array);
//            System.out.print("Sorted array: " + array[0]);
//            for (int i = 1; i < array.length; i++)
//                System.out.print(", " + array[i]);
//            System.out.println();

        }

        public static <T extends Comparable<T>> void insertionSort(T[] to_sort){
            int i, j;
            T key;
            for (j = 1; j < to_sort.length; j++) {
                key = to_sort[j];
                i = j - 1;
                while (i >= 0 && to_sort[i].compareTo(key) > 0) {
                    to_sort[i + 1] = to_sort[i];
                    i = i - 1;
                }
                to_sort[i + 1] = key;
            }
        }
    }

    //foo, Foobar, Foo, Baz, Bar, 42
