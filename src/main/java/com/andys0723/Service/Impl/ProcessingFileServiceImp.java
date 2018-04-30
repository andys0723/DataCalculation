package com.andys0723.Service.Impl;

import com.andys0723.Model.Stock;
import com.andys0723.Service.CalculateDataService;
import com.andys0723.Service.ProcessingService;
import com.andys0723.Service.ReadFileService;
import com.andys0723.Service.WriteFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProcessingFileServiceImp implements ProcessingService{
    @Autowired
    private List<Stock> stocks;
    @Autowired
    ReadFileService readFileService;
    @Autowired
    CalculateDataService calculateDataService;
    @Autowired
    WriteFileService writeFileService;
    @Value("${file.dir}")
    private String dir;

    private List<String> fileNames;


    @Override
    public void processing() {
        for(String name: fileNames){
            stocks.clear();
            System.out.println("Processing File");
            readFileService.setFileName(dir+name);
            readFileService.readData();
            System.out.println(stocks.size());
            calculateDataService.calculate();
            writeFileService.setFileName(dir+name);
            writeFileService.writeData();
        }




    }

    @Autowired
    private void setFileNames(@Value("${file.name}") final String fileName) {
        this.fileNames = Arrays.asList(fileName.split(","));
    }

}
