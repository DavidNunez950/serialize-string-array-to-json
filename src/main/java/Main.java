import java.util.Objects;

/**
 * The main class
 */
public class Main {

    /**
     * The main method
     * @param args The programs args
     */
    public static void main(String []args) {
        // It is passed as offset number "1", since the first argument is the name of the jar.
        System.out.println(serializeToJSONString(args, 1));
    }


    /**
     * This receives function transforms a flat array of strings into json by reading the values in pairs.
     * Additionally, in case the array is prime, an offset number can be passed that will be used as a starting
     * point to iterate through the array. Otherwise, the last key will be assigned an empty string to make up
     * for the missing value.
     *
     * @param pairs The array containing the streams to convert to JSON
     * @param offSet The offset
     * @return The array serialized to JSON
     */
    private static String serializeToJSONString(String []pairs, int offSet) {
        if(Objects.isNull(pairs)) pairs = new String[0];
        int keyPosition = offSet;
        int valuePosition = keyPosition + 1;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while(keyPosition < pairs.length) {
            String key   = pairs[keyPosition];
            String value = (valuePosition  < pairs.length) ? pairs[valuePosition] : "";
            sb.append( "\n    \""+key+"\": \""+value+"\"" );
            keyPosition   += 2;
            valuePosition += 2;
            sb.append(keyPosition < pairs.length ?  "," : "\n" );
        }
        sb.append("}");
        return sb.toString();
    }

}
