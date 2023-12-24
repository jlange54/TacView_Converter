import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class getMetaInfo {

    public static MetaInfo fromFile(String directory) throws IOException {
        MetaInfo result = filterInputList(FileRW.read(directory));

        return result;
    }

    private static MetaInfo filterInputList (List<String> inputList) {
        MetaInfo result = new MetaInfo();
        Iterator<String> inputListIterator = inputList.iterator();

        while (hasAllMetaInfo(result) == false && inputListIterator.hasNext()) {
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

    private static boolean hasAllMetaInfo (MetaInfo metaInfo) {
       boolean hasAllMetaInfo = false;

       if (
               metaInfo.getReferenceLongitude() != -1000 &&
               metaInfo.getReferenceLatitude() != -1000 &&
               metaInfo.getReferenceTime() != null &&
               metaInfo.getRecordingTime() != null &&
               metaInfo.getTitle() != null &&
               metaInfo.getDataSource() != null &&
               metaInfo.getAuthor() != null
       ) {
           hasAllMetaInfo = true;
       }

       return hasAllMetaInfo;
    }
}
