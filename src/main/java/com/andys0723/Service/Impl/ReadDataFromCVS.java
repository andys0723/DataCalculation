package com.andys0723.Service.Impl;

import com.andys0723.Model.Stock;
import com.andys0723.Service.ReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service("ReadDataFromCVS")
public class ReadDataFromCVS implements ReadFileService {

    @Value("${file.tileDelimiter}")
    private String tileDelimiter;
    @Value("${file.bodyDelimiter}")
    private String bodyDelimiter;

    @Autowired
    private List<Stock> stocks;

    @Autowired
    private List<String> exceptionList;

    private String fileName = null;

    @Override
    public void readData() {
        System.out.println("ReadDataFromCVS");
        BufferedReader br = null;
        if(fileName == null || fileName.isEmpty()){
            throw new RuntimeException();
        }
        File file = new File(fileName + ".txt");

        String st;
        try {

            br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null) {
//                System.out.println(st);

                String[] contents = st.split(tileDelimiter);
//                System.out.println(Arrays.toString(bodys));

                String[] titles = contents[0].split(bodyDelimiter);
//                System.out.println(titles[0]);
                Stock stock = new Stock();
                stock.setId(titles[0]);

                String[] bodys = contents[1].split(bodyDelimiter);
//                System.out.println(Arrays.toString(bodys));
                for(int i = 0; i < bodys.length; i++){

                    double val = 0.0;
                    if(!exceptionList.contains(bodys[i])){
                        val = Double.valueOf(bodys[i]);

                    }
//                    System.out.println(val);
                    stock.getPrices().add(val);

                }

                stocks.add(stock);
            }
        }catch(NumberFormatException NumEx){
            System.out.println("NumberFormateException");
        }finally {
            try {

                if (br != null)
                    br.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
