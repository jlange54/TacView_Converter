import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static String regexForReferenceLongitude = "0,ReferenceLongitude=(.*)";
    public static String regexForReferenceLatitude = "0,ReferenceLatitude=(.*)";
    public static String regexForReferenceTime = "0,ReferenceTime=(.*)Z";
    public static String regexForRecordingTime = "0,RecordingTime=(.*)Z";
    public static String regexForTitle = "0,Title=(.*)";
    public static String regexForDataSource = "0,DataSource=(.*)";
    public static String regexForAuthor = "0,Author=(.*)";
    public static String substitution(String line, String regex, int returnGroup) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()){
            return matcher.group(returnGroup);
        }
        return null;
    }

    public static boolean match (String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
