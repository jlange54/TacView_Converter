import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Runtime.start();

        System.out.println(getMetaData.fromFile("./testFiles/Tacview-20231224-123223-DCS-refuelTrainingF18.zip.txt.acmi"));


        System.out.println("Program completed in " + Runtime.end(Runtime.timeUnit.ms) + " ms");
    }
}