/**
 * Created by Gvozd on 22.07.2016.
 */
public class App {
    public static void main(String[] args) {
        RegexStringSearcher.setDataToParse("Раздватричетырепятьвышелзайчикпогулять");
        RegexStringSearcher.setSearchable("пять");
        RegexStringSearcher.setConsole(System.console());
        RegexStringSearcher.getMatch();
    }
}
