import java.util.Arrays;

class ShadesOfGrey {
    static String[] shadesOfGrey(int num) {
        // returns n shades of grey in an array
        if (num <= 0) {
            return new String[0];
        }
        if (num > 254) {
            num = 254;
        }

        String[] greys = new String[num];

        int i=0;
        while (i<num) {
            i++;
            String s = Integer.toHexString(i);
            if (s.length() == 1) {
                s = "0" + s;
            }
            greys[i-1] = "#" + s + s + s;
        }
        return greys;
    }

    public static void main(String[] args) {
        String[] shadesOfGrey = ShadesOfGrey.shadesOfGrey(10);
        System.out.println(Arrays.asList(shadesOfGrey));

        shadesOfGrey = ShadesOfGrey.shadesOfGrey(-1);
        System.out.println(Arrays.asList(shadesOfGrey));

        shadesOfGrey = ShadesOfGrey.shadesOfGrey(4);
        System.out.println(Arrays.asList(shadesOfGrey));

        shadesOfGrey = ShadesOfGrey.shadesOfGrey(1);
        System.out.println(Arrays.asList(shadesOfGrey));

        shadesOfGrey = ShadesOfGrey.shadesOfGrey(150);
        System.out.println(Arrays.asList(shadesOfGrey));

        shadesOfGrey = ShadesOfGrey.shadesOfGrey(300);
        System.out.println(Arrays.asList(shadesOfGrey));
    }
}
