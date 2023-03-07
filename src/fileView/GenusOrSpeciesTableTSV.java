package fileView;

import data.InfoList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenusOrSpeciesTableTSV {
    Scanner scanner;

    public GenusOrSpeciesTableTSV(File file) throws IOException, InvalidFormatException {
        scanner = new Scanner(file);
    }

    public void getClose() throws IOException {
        scanner.close();
    }

    public void getTable(InfoList infoList){
        scanner.nextLine();
        int counter = 0;
        for(int k = 0;scanner.hasNextLine();k++){
            String line;
            line = scanner.nextLine();
            String[] elements = line.split("\t");
            if (elements[3].split(";").length >= 5 && elements[3].split(";").length <= 6){
                infoList.allBacteria.add(new ArrayList<>());
                for (int i = 0; i < elements[3].split(";").length; i++){
                    if(elements[3].split(";")[i].length()>0) {
                        infoList.allBacteria.get(counter).add(elements[3].split(";")[i]);
                    }
                }
                infoList.allBacteria.get(counter).add(elements[4]);
                counter++;
            }
        }
    }
}