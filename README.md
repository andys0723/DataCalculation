
This project is created based on the idea to calculate the min, max and average prices of stock.
In the input file, the row is described as below.
n10,1366829460,1366831260,60|37.0,65.0,87.0,41.0,100.0,76.0,83.0,82.0,50.0,54.0,46.0,28.0,68.0,69.0,94.0,90.0,57.0,47.0,94.0,83.0,79.0,85.0,99.0,77.0,85.0,70.0,91.0,88.0,64.0,89.0

The info before the pipe represents the basic info of the stock.
n10 is the stock id.
1366829460 and 1366831260 could be described as timestamp.
60 could be described other info.
Since it seems like those info is not using for calculation, only n10 will be saved into stock object during the calculation.

The info after the pipe could be described as a list of prices
Therefore, the project will use those values to calculate the min, max, and average prices.
Note that "Nono" is shown in input row. Since the project is calculating the prices, we assume that those strings are interpreted as 0.0.

To finish the whole process, this project is divided into three parts.
First part is the part of reading data from files. Second part is the part of calculating read data. Third part is the part of writing calculated data back into new file.
First part is done by ReadDataFromCVS class. Second part is done by CalculatePricesImp class. Third part is done by WritePriceDataIntoFile class.

In above way, it provides flexibility that if input could read from db instead of file. User wants to implements different algorithm to calculate the data.
Output could be write to db instead of file.

To guide the whole process, ProcessingFileServiceImp is the class to co-ordinate the whole process.
