package com.andys0723.Service.Impl;
/*
      This service is responsible for reading each row of data from file
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.andys0723.Model.Stock;
import com.andys0723.Service.ReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service("ReadDataFromCVS")
public class ReadDataFromCVS implements ReadFileService {
    private final static Logger LOGGER = Logger.getLogger(ReadDataFromCVS.class.getName());

    @Value("${file.tileDelimiter}")
    private String tileDelimiter;
    @Value("${file.bodyDelimiter}")
    private String bodyDelimiter;

    @Autowired
    private List<Stock> stocks;

    @Autowired
    private List<String> ZeroInterpretation;

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
                for(int i = 0; i < bodys.length; i++){

                    double val = 0.0;
                    if(!ZeroInterpretation.contains(bodys[i])){
                        val = Double.valueOf(bodys[i]);

                    }
//                    System.out.println(val);
                    stock.getPrices().add(val);

                }

                stocks.add(stock);
            }
        }catch(IOException ex){
            LOGGER.log(Level.WARNING, ex.toString(), ex);
        }catch(NumberFormatException ex){
            LOGGER.log(Level.WARNING, ex.toString(), ex);
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
