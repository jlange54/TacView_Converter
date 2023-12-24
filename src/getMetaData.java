import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class getMetaData {

    public static MetaData fromFile(String directory) throws IOException {
        MetaData result = filterInputList(FileRW.read(directory));

        return result;
    }

    private static MetaData filterInputList (List<String> inputList) {
        MetaData result = new MetaData();
        Iterator<String> inputListIterator = inputList.iterator();

        while (hasAllMetaData(result) == false && inputListIterator.hasNext()) {
            String line = inputListIterator.next();

            if (Regex.match(line, Regex.regexForReferenceLongitude)) {
                result.setReferenceLongitude(Integer.parseInt(Regex.substitution(line, Regex.regexForReferenceLongitude, 1)));
            } else if (Regex.match(line, Regex.regexForReferenceLatitude)) {
                result.setReferenceLatitude(Integer.parseInt(Regex.substitution(line, Regex.regexForReferenceLatitude, 1)));
            } else if (Regex.match(line, Regex.regexForReferenceTime)) {
                result.setReferenceTime(LocalDateTime.parse(Regex.substitution(line, Regex.regexForReferenceTime, 1), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            } else if (Regex.match(line, Regex.regexForRecordingTime)) {
                result.setRecordingTime(LocalDateTime.parse(Regex.substitution(line, Regex.regexForRecordingTime, 1), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            } else if (Regex.match(line, Regex.regexForTitle)) {
                result.setTitle(Regex.substitution(line, Regex.regexForTitle, 1));
            } else if (Regex.match(line, Regex.regexForDataSource)) {
                result.setDataSource(Regex.substitution(line, Regex.regexForDataSource, 1));
            } else if (Regex.match(line, Regex.regexForAuthor)) {
                result.setAuthor(Regex.substitution(line, Regex.regexForAuthor, 1));
            }
        }

        return result;
    }

    private static boolean hasAllMetaData (MetaData metaData) {
       boolean hasAllMetaData = false;

       if (
               metaData.getReferenceLongitude() != -1000 &&
               metaData.getReferenceLatitude() != -1000 &&
               metaData.getReferenceTime() != null &&
               metaData.getRecordingTime() != null &&
               metaData.getTitle() != null &&
               metaData.getDataSource() != null &&
               metaData.getAuthor() != null
       ) {
           hasAllMetaData = true;
       }

       return hasAllMetaData;
    }
}
