import arrays.EncodeDecodeString;

import java.util.List;

public class MainDriver {

    public static void main(String[] args) {

        EncodeDecodeString eds = new EncodeDecodeString();

        String encoded = eds.encode(List.of(new String[]{"Jayesh","Thakur"}));

        System.out.println(eds.decode(encoded));

    }
}
