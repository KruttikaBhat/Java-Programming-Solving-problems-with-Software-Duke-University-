import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String countryInfo(CSVParser parser,String country){
        for(CSVRecord record:parser){
            String Country=record.get("Country");
            String Exports=record.get("Exports");
            String Value=record.get("Value (dollars)");
            if(Country.equals(country)){
                String output=Country +":"+Exports+":"+Value;
                return output;
                //System.out.println(Country+":"+Exports+":"+Value);
            }
        }
        return"NOT FOUND";
        //System.out.println("NOT FOUND");
    }
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        for(CSVRecord record:parser){
            String export=record.get("Exports");
            if((export.contains(exportItem1)) && (export.contains(exportItem2)) ){
                System.out.println(record.get("Country"));
            }
        }
    }
    public int numberOfExporters(CSVParser parser,String exportItem){
        int count=0;
        for(CSVRecord record:parser){
            String export=record.get("Exports");
            if(export.contains(exportItem) ){
                count+=1;
            }
        }
        return count;
    }
    public void BigExporters(CSVParser parser,String amount){
        for(CSVRecord record:parser){
            String value=record.get("Value (dollars)");
            if(value.length()>amount.length()){
                System.out.println(record.get("Country")+" "+value);
            }
        }
    }
    public void tester(){
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Nauru"));
        //parser=fr.getCSVParser();
        //listExportersTwoProducts(parser,"diamonds","gold");
        //parser=fr.getCSVParser();
        //System.out.println(numberOfExporters(parser,"sugar"));
        //parser=fr.getCSVParser();
        BigExporters(parser,"$999,999,999,999");
    }

}
