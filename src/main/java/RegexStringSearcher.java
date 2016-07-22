import java.io.Console;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gvozd on 22.07.2016.
 */
public class RegexStringSearcher {
    private static String searchable;
    private static String dataToParse;
    private static Console console = System.console();

    public static Console getConsole() {
        return console;
    }

    public static void setConsole(Console console) {
        RegexStringSearcher.console = console;
    }

    public static String getSearchable() {
        return searchable;
    }

    public static String getDataToParse() {
        return dataToParse;
    }

    public static void setDataToParse(String dataToParse) {
        RegexStringSearcher.dataToParse = dataToParse;
    }

    public static void setSearchable(String searchable) {
        RegexStringSearcher.searchable = searchable;
    }

    private static boolean fieldIsValid(Object object){
        Field field = (Field) object;
        if (object==null){
            System.out.println("The field "+field.getName()+" is null.");
            throw new NullPointerException();
        }
        return true;
    }

    private static void checkFields(){
        Field[] fields = RegexStringSearcher.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            fieldIsValid(field);
        }
    }

    public static void getMatch(){
       checkFields();

        Pattern pattern = Pattern.compile(dataToParse);
        Matcher matcher = pattern.matcher(searchable);

        boolean found = false;
        while (matcher.find()) {
            console.format("I found the text" +
                            " \"%s\" starting at " +
                            "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if(!found){
            console.format("No match found.%n");
        }

    }
}
