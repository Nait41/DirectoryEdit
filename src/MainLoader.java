import data.InfoList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainLoader extends JFrame {
    Workbook workbook;
    public MainLoader(File file) throws IOException, InvalidFormatException {
        String filePath = file.getPath();
        workbook = new XSSFWorkbook(new FileInputStream(filePath));
    }

    public void getClose() throws IOException {
        workbook.close();
    }

    public void setSystematicsGenus(InfoList infoList){
        for(int i = 0; i < workbook.getSheetAt(0).getPhysicalNumberOfRows(); i++){
            System.out.println(i + "  " + workbook.getSheetAt(0).getPhysicalNumberOfRows());
            for(int k = 0; k < infoList.allBacteria.size(); k++){
                if(infoList.allBacteria.get(k).size() >= 6) {
                    if (workbook.getSheetAt(0).getRow(i).getCell(3).getStringCellValue()
                            .equals(infoList.allBacteria.get(k).get(5).replace(" ", "_"))) {
                        workbook.getSheetAt(0).getRow(i).createCell(0).setCellValue(infoList.allBacteria.get(k).get(1));
                        workbook.getSheetAt(0).getRow(i).createCell(1).setCellValue(infoList.allBacteria.get(k).get(2));
                        workbook.getSheetAt(0).getRow(i).createCell(2).setCellValue(infoList.allBacteria.get(k).get(4));
                        break;
                    }
                }
            }
        }
    }

    public void setSystematicsSpecies(InfoList infoList){
        for(int i = 0; i < workbook.getSheetAt(1).getPhysicalNumberOfRows(); i++){
            System.out.println(i + "  " + workbook.getSheetAt(1).getPhysicalNumberOfRows());
            for(int k = 0; k < infoList.allBacteria.size(); k++){
                if(infoList.allBacteria.get(k).size() >= 7) {
                    if (workbook.getSheetAt(1).getRow(i).getCell(4).getStringCellValue()
                            .contains(infoList.allBacteria.get(k).get(6).replace(" ", "_"))) {
                        workbook.getSheetAt(1).getRow(i).createCell(0).setCellValue(infoList.allBacteria.get(k).get(1));
                        workbook.getSheetAt(1).getRow(i).createCell(1).setCellValue(infoList.allBacteria.get(k).get(2));
                        workbook.getSheetAt(1).getRow(i).createCell(2).setCellValue(infoList.allBacteria.get(k).get(4));
                        workbook.getSheetAt(1).getRow(i).createCell(3).setCellValue(infoList.allBacteria.get(k).get(5));
                        break;
                    }
                }
            }
        }
    }

    public void saveFile(File saveSample) throws IOException {
        workbook.write(new FileOutputStream(new File(saveSample.getPath() + "\\test.xlsx")));
        workbook.close();
    }
}

