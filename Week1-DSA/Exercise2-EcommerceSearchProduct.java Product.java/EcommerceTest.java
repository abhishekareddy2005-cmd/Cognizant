public class EcommerceTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(203, "Shoes", "Footwear"),
            new Product(305, "Phone", "Electronics"),
            new Product(412, "Shirt", "Clothing"),
            new Product(550, "Watch", "Accessories")
        };
        int target = 305;
        int result = SearchAlgorithms.linearSearch(products, target);
        if(result != -1)
            System.out.println("Linear Search: Found " + products[result].productName + " at index " + result);
        else
            System.out.println("Linear Search: Product not found");
        int result2 = SearchAlgorithms.binarySearch(products, target);
        if(result2 != -1)
            System.out.println("Binary Search: Found " + products[result2].productName + " at index " + result2);
        else
            System.out.println("Binary Search: Product not found");
        System.out.println("\n--- Time Complexity Analysis ---");
        System.out.println("Linear Search: O(n) - checks every element in worst case");
        System.out.println("Binary Search: O(log n) - eliminates half elements each step");
        System.out.println("For large product catalogs, Binary Search is much faster");
        System.out.println("But Binary Search needs sorted data, Linear Search doesn't");
    }
}
