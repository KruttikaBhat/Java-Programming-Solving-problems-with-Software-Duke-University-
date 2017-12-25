import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSVMax {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord ColdestRecord=null;
        for(CSVRecord record:parser){
            if(ColdestRecord==null){
                ColdestRecord=record;
            }
            else{
                double currentTemp=Double.parseDouble(record.get("TemperatureF"));
                double coldestTemp=Double.parseDouble(ColdestRecord.get("TemperatureF"));
                if((currentTemp<coldestTemp) && (currentTemp!=-9999)){
                    ColdestRecord=record;
                }
            }
        }
        return ColdestRecord;
    }
    public File fileWithColdestTemperature(){
        DirectoryResource dr=new DirectoryResource();
        File lowest=null;
        for(File f:dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            CSVRecord current=coldestHourInFile(fr.getCSVParser());
            
            if(lowest==null){
                lowest=f;
            }
            else{
                double currentTemp=Double.parseDouble(current.get("TemperatureF"));
                FileResource lowestfr=new FileResource(lowest);
                CSVRecord lowestTempRecord=coldestHourInFile(lowestfr.getCSVParser());
                double coldestTemp=Double.parseDouble(lowestTempRecord.get("TemperatureF"));
                if((currentTemp<coldestTemp) && (currentTemp!=-9999)){
                     lowest=f;
                }
            }
        }
        return lowest;
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowest=null;
        for(CSVRecord record:parser){
            if(lowest==null){
                lowest=record;
            }
            else{
                if(!(record.get("Humidity").equals("N/A")) && !(lowest.get("Humidity").equals("N/A"))){
                double currentHumidity=Double.parseDouble(record.get("Humidity"));
                double lowestHumidity=Double.parseDouble(lowest.get("Humidity"));
                if(currentHumidity<lowestHumidity){
                    lowest=record;
                }
                }
                
            }
        }
        return lowest;
    }
    public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr=new DirectoryResource();
        CSVRecord lowest=null;
        for(File f:dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            CSVRecord current=lowestHumidityInFile(fr.getCSVParser());
            if(lowest==null){
                lowest=current;
            }
            else{
                if(!(current.get("Humidity").equals("N/A")) && !(lowest.get("Humidity").equals("N/A"))){
                double currentHumidity=Double.parseDouble(current.get("Humidity"));
                double lowestHumidity=Double.parseDouble(lowest.get("Humidity"));
                if(currentHumidity<lowestHumidity){
                    lowest=current;
                }
                }
            }
        }
        return lowest;
    }
    public Double averageTemperatureInFile(CSVParser parser){
        int count=0;
        double sum=0;
        for(CSVRecord record:parser){
            Double value=Double.parseDouble(record.get("TemperatureF"));
            if(value!=-9999){
                count+=1;
                sum+=value;
            }
        }
        return (sum/count);
    }
    public Double averageTemperatureWithHighHumidityInFile(CSVParser parser, double value){
        int count=0;
        double sum=0;
        for(CSVRecord record:parser){
            double temp=Double.parseDouble(record.get("TemperatureF"));
            double humidity=Double.parseDouble(record.get("Humidity"));
            if((temp!=-9999) && (humidity>=value)){
                count+=1;
                sum+=temp;
            }
        }
        if(count==0){
            return 0.0;
        }
         System.out.println(sum/count);
        return (sum/count);
    }    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr=new FileResource();
        double avg=averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
        if(avg==0){
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average temperature when high humidity is "+avg);
        }
    }
    public void testAverageTemperatureInFile(){
        FileResource fr=new FileResource();
        Double avg=averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is "+avg);
    }
    public void testLowestHumidityInManyFiles(){
        CSVRecord lowest=lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+lowest.get("Humidity")+" at "+lowest.get("DateUTC"));
    }
    public void testFileWithColdestTemp(){
        File fileColdest=fileWithColdestTemperature();
        FileResource fr=new FileResource(fileColdest);
        double coldestTemp=Double.parseDouble(coldestHourInFile(fr.getCSVParser()).get("TemperatureF"));
        System.out.println("The coldest day was in the file "+ fileColdest.getName());
        System.out.println("The coldest temperature on that day was "+ coldestTemp);
        System.out.println("All the temperatures on that day was: ");
        for(CSVRecord record: fr.getCSVParser()){
            System.out.println(fileColdest.getName()+" "+record.get("TimeEST")+" "+record.get("TemperatureF"));
        }
    }
    public void tester(){
        FileResource fr=new FileResource();
        //CSVRecord lowest=coldestHourInFile(fr.getCSVParser());
        //System.out.println("The lowest temperature was "+lowest.get("TemperatureF")+" at "+lowest.get("TimeEST"));
        CSVRecord lowest=lowestHumidityInFile(fr.getCSVParser());
        System.out.println("Lowest humidity was "+lowest.get("Humidity")+" at "+lowest.get("DateUTC"));
    }

}
