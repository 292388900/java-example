package name.guke.commons.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Guke on 2016/11/3.
 */
public class PoiTest {
    static String[] headers = new String[]{"学号","姓名","年龄","生日"};
    static Collection<Student> students = new ArrayList<Student>(1);
    static {
        students.add(new Student("2016001","张三", 20, new Date()));
        students.add(new Student("2016002","李四", 25, null));
        students.add(new Student("2016003","王五", -1, new Date()));
        students.add(new Student("2016003",null, 21, new Date()));
    }

    public static void main(String[] args) throws IOException {

        FileOutputStream outputStream = new FileOutputStream("test.xls");
        ExcelUtil.exportExcel(headers, students, outputStream, "yyyy-MM-dd");
        outputStream.close();



        //createSxssf();

        //createHssf();
    }

    static class Student implements Serializable{
        @ExcelCell(index = 1)
        private String code;
        @ExcelCell(index = 2)
        private String name;
        @ExcelCell(index = 3)
        private int age;
        @ExcelCell(index = 4)
        private Date birthDate;

        public Student(String code, String name, int age, Date birthDate) {
            this.code = code;
            this.name = name;
            this.age = age;
            this.birthDate = birthDate;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }
    }

    private static void createHssf() throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("hssf.xls");
        wb.write(fileOut);
        fileOut.close();
    }

    private static void createSxssf() throws IOException {
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sh = wb.createSheet();
        Row row1 = sh.createRow(0);
        for(int cellnum = 0; cellnum < 10; cellnum++){
            Cell cell = row1.createCell(cellnum);
            String address = new CellReference(cell).formatAsString();
            cell.setCellValue(address);
        }
        for(int rownum = 1; rownum < 100000; rownum++){
            Row row = sh.createRow(rownum);
            for(int cellnum = 0; cellnum < 10; cellnum++){
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }

        }

        // Rows with rownum < 900 are flushed and not accessible
  /*      for(int rownum = 0; rownum < 900; rownum++){
            System.err.println("0:"+sh.getRow(rownum));
        }
*/
        // ther last 100 rows are still in memory
/*        for(int rownum = 900; rownum < 1000; rownum++){
            System.err.println("9:"+sh.getRow(rownum));
        }*/
        File file = new File("sxssf.xlsx");
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();
    }
}
