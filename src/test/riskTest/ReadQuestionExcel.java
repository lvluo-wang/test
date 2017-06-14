package test.riskTest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import test.JsonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuo on 2017/2/20.
 */
public class ReadQuestionExcel {


    public static void main(String args[]){
        List<Question> questionArrayList = readExcel();
        System.out.print(questionArrayList.size());
        //questionArrayList.forEach(question -> System.out.print(question.getQuestion()));
        dealForSql(questionArrayList);
    }

    private static void dealForSql(List<Question> questionArrayList) {
        questionArrayList.forEach(question -> {
            String json = JsonUtils.objectToJsonString(question.getAnswerList());
            System.out.println("INSERT INTO T_RISK_TEST_QUESTION (QUESTION_ID,QUESTION,OPTION_CONTENT,IS_DELETE,CREATE_TIME,LAST_UPDATE_TIME)" +
                    "VALUES (SEQ_RISK_QUESTION_ID.NEXTVAL,'"+question.getQuestion()+"','"+json+"','N',SYSDATE,SYSDATE);");
        });
    }

    /**
     * 读取Excel测试，兼容 Excel 2003/2007/2010
     */
    public static List<Question> readExcel() {
        List<Question> questionArrayList = new ArrayList<Question>(50);

        try {
            //同时支持Excel 2003、2007
            File excelFile = new File("/Users/zuo/test2.xlsx"); //创建文件对象
            FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量
            Question question = null;
            List<Answer> answerList = null;
            //遍历每个Sheet
            for (int s = 0; s < 1; s++) {
                Sheet sheet = workbook.getSheetAt(s);
                int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数
                //遍历每一行
                for (int r = 0; r < rowCount; r++) {
                    question = new Question();
                    Row row = sheet.getRow(r);
                    int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
                    //遍历每一列
                    int c;
                    answerList = new ArrayList<Answer>(4);
                    Answer answer = null;
                    for (c = 0; c < cellCount; c++) {
                        Cell cell = row.getCell(c);
                        int cellType = cell.getCellType();
                        String cellValue = null;
                        switch (cellType) {
                            case Cell.CELL_TYPE_STRING: //文本
                                cellValue = cell.getStringCellValue();
                                break;
                            default:
                                cellValue = "错误";
                        }
                        System.out.print(cellValue + "    ");
                        answer = new Answer();
                        if(c == 0){
                            question.setQuestion(cellValue);
                        }
                        if(c ==1){
                            answer.setOption("A");
                            answer.setContent(cellValue);
                            answer.setWeight("W1");
                            answerList.add(answer);
                        }
                        if(c ==2){
                            answer.setOption("B");
                            answer.setContent(cellValue);
                            answer.setWeight("W2");
                            answerList.add(answer);
                        }
                        if(c ==3){
                            answer.setOption("C");
                            answer.setContent(cellValue);
                            answer.setWeight("W3");
                            answerList.add(answer);
                        }
                        if(c ==4){
                            answer.setOption("D");
                            answer.setContent(cellValue);
                            answer.setWeight("W4");
                            answerList.add(answer);
                        }
                        if(c ==5){
                            answer.setOption("E");
                            answer.setContent(cellValue);
                            answer.setWeight("W5");
                            answerList.add(answer);
                        }



                    }

                    question.setAnswerList(answerList);
                    questionArrayList.add(question);
                }
            }
            return questionArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questionArrayList;
    }

}
