import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyBirths {
    public void totalBirths(FileResource fr){
        int totalBirths=0;
        int numBoys=0;
        int numGirls=0;
        int boyNames=0;
        int girlNames=0;
        int totalNames=0;
        for(CSVRecord record:fr.getCSVParser(false)){
            int numBorn=Integer.parseInt(record.get(2));
            totalBirths+=numBorn;
            totalNames+=1;
            if(record.get(1).equals("M")){
                numBoys+=numBorn;
                boyNames+=1;
            }
            else{
                numGirls+=numBorn;
                girlNames+=1;
            }
        }
        System.out.println("Number of Girls: "+numGirls+" number of girl names "+girlNames);
        System.out.println("Number of Boys: "+numBoys+" number of boy names "+boyNames);
        System.out.println("Number of Babies: "+totalBirths+" number of baby names "+totalNames);
    }
    public int getRank(int year, String name, String gender){
        int rank=1;
        int flag=0;
        FileResource fr=new FileResource("testing/yob"+year+"short.csv");
        for(CSVRecord rec:fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if(rec.get(0).equals(name)){
                    flag=1;
                    break;
                }
                else{
                    rank+=1;
                }
            }
        }
        if(flag==0){
             return -1;
        }
        else{
            return rank;
        }
        
    }
    public String getName(int year, int rank, String gender){
        String name=null;
        int pos=1;
        int flag=0;
        FileResource fr=new FileResource("testing/yob"+year+"short.csv");
        for(CSVRecord record:fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                if(pos==rank){
                    name=record.get(0);
                    flag=1;
                }
            pos+=1;
        }
        }
        if(flag==0){
            return "NO NAME";
        }
        else{
            return name;
        }
    }
    public void whatIsNameInYear(String name,int year,int newYear,String gender){
        int rank=getRank(year,name,gender);
        if(rank==-1){
            System.out.println("The name doesn't exist");
        }
        else{
            String newName=getName(newYear,rank,gender);
            if(gender.equals("F")){
                System.out.println(name+" born in "+year+" would be "+newName+" if she was born in "+newYear);
            }
            else{
                System.out.println(name+" born in "+year+" would be "+newName+" if he was born in "+newYear);
            }
            
        }
    }
    public int yearOfHighestRank(String name,String gender){
        int year=0;
        int flag=0;
        int maxRank=0;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            String fileName=f.getName();
            int currentYear=Integer.parseInt(fileName.substring(3,7));
            int currentRank=getRank(currentYear,name,gender);
            if(currentRank!=-1){
                flag=1;
                if(maxRank==0){
                    maxRank=currentRank;
                    year=currentYear;
                }
                else{
                    if(currentRank<maxRank){
                        maxRank=currentRank;
                        year=currentYear;
                    }
                }
            }
        }
        if(flag==0){
            return -1;
        }
        else{
            return year;
        }
    }
    public double getAverageRank(String name, String gender){
        int count=0;
        double sum=0;
        double avg;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            String fileName=f.getName();
            int currentYear=Integer.parseInt(fileName.substring(3,7));
            int currentRank=getRank(currentYear,name,gender);
            if(currentRank!=-1){
                count+=1;
                sum+=currentRank;
            }
        }
        if(count==0){
            return -1.0;
        }
        else{
            avg=sum/count;
            return avg;
        }
    }
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        int rank=getRank(year,name,gender);
        int sum=0;
        FileResource fr=new FileResource("testing/yob"+year+"short.csv");
        for(CSVRecord record:fr.getCSVParser(false)){
            int currentRank;
            if(record.get(1).equals(gender)){
                currentRank=getRank(year,record.get(0),gender);
                if(currentRank<rank && currentRank!=-1){
                    sum+=Integer.parseInt(record.get(2));
                }
            }
        }
        return sum;
    }
    public void testGetTotaBirthsRankedHigher(){
        int sum=getTotalBirthsRankedHigher(2012,"Ethan","M");
        System.out.println(sum);
    }
    public void testGetAverageRank(){
        double avg=getAverageRank("Jacob","M");
        System.out.println(avg);
    }
    public void testYearofHighestRank(){
        int year=yearOfHighestRank("Mason","M");
        System.out.println("Year of highest rank is "+year);
    }
    public void testWhatIsNameInYear(){
        whatIsNameInYear("Isabella",2012,2014,"F");
    }
    public void testGetName(){
        String name=getName(2012,6,"F");
        System.out.println(name);
    }
    public void testTotalBirths(){
        FileResource fr=new FileResource();
        totalBirths(fr);
    }
    public void testGetRank(){
        int rank=getRank(2012,"Emilia","M");
        System.out.println(rank);
    }
}
