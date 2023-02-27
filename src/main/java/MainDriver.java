import arrays.ProductExceptSelf;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {

        ProductExceptSelf productExceptSelf = new ProductExceptSelf();

        int[] nums = {1, 2, 3, 0};

        int[] res = productExceptSelf.productExceptSelf(nums);

        Arrays.stream(res).forEach(System.out::println);

    }
}
