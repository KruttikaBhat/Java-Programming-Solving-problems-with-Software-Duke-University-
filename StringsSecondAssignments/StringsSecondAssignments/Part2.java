
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    int howMany(String stringa,String stringb){
        int count=0;
        int index=stringb.indexOf(stringa);
        while(index!=-1){
            count+=1;
            stringb=stringb.substring(index+3,stringb.length());
            index=stringb.indexOf(stringa);
            //System.out.println(index);
        }
        return count;
    }
    void Test(){
        System.out.println("stringa:'GAA' stringb:'ATGAACCGAATGACGAACTG' ");
        System.out.println(howMany("GAA","ATGAACCGAATGACGAACTG"));
        System.out.println("stringa:'GAA' stringb:'AACTG' ");
        System.out.println(howMany("GAA","AACTG"));
    }

}
