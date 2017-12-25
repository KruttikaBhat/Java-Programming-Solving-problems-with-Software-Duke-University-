
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    /*
     * This method returns true if stringa appears at least twice in stringb, 
     * otherwise it returns false. 
     */
    String twoOccurences(String stringa, String stringb){
        int index=-1;
        int count=0;
        while(index>=-1){
            index=stringb.indexOf(stringa,index+1);
            if(index>=0){
                count+=1;
            }
            else if(index==-1){
                break;
            }
        }
        if(count>=2){
            return "True";
        }
        else{
            return "False";
        }
    }
    /*
     * This method finds the first occurrence of stringa in stringb, 
     * and returns the part of stringb that follows stringa. 
     * If stringa does not occur in stringb, then return stringb.
     */
    String lastPart(String stringa,String stringb){
        int index=stringb.indexOf(stringa);
        if(index==-1){
            return stringb;
        }
        else{
            return stringb.substring(index+stringa.length(),stringb.length());
        }
        
    }
    void Testing(){
        System.out.println("stringa: 'by' and stringb: 'A story by Abby Long'");
        System.out.println(twoOccurences("by","A story by Abby Long"));
        System.out.println("stringa: 'a' and stringb: 'banana'");
        System.out.println(twoOccurences("a","banana"));
        System.out.println("stringa: 'atg' and stringb: 'ctatgtaa'");
        System.out.println(twoOccurences("atg","ctatgtaa"));
        System.out.println("stringa: 'an' and stringb: 'banana'");
        System.out.println(lastPart("an","banana"));
        System.out.println("stringa: 'zoo' and stringb: 'forest'");
        System.out.println(lastPart("zoo","forest"));
    }

}
