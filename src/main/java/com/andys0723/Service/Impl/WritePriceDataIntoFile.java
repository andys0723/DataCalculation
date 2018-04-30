package com.andys0723.Service.Impl;
/*
      This service is responsible for writing min, max and average stock data into file.
 */
import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.andys0723.Model.Stock;
import com.andys0723.Service.WriteFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WritePriceDataIntoFile")
public class WritePriceDataIntoFile implements WriteFileService {
    private final static Logger LOGGER = Logger.getLogger(WritePriceDataIntoFile.class.getName());

    @Autowired
    List<Stock> stocks;

    private String fileName;

    @Override
    public void writeData() {
        File file = new File(fileName +"output.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            System.out.println("Write stock price into file");

            for(Stock stock: stocks){
//                System.out.println(stock.getId());
                BigDecimal avgDec = new BigDecimal(stock.getAveragePrice());
                bw.write(stock.getId() + ": Average: " + avgDec.setScale(1, BigDecimal.ROUND_UP) + " Max: " + stock.getMaxPrice() + " Min: " + stock.getMinPrice() + "\n");
            }
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, ex.toString(), ex);
        }finally {
            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                LOGGER.log(Level.WARNING, ex.toString(), ex);
            }

        }

    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
