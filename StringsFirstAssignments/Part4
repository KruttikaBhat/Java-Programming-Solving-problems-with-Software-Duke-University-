import edu.duke.*;
import java.io.File;
/**
 * Checks to see if youtube.com is in each string and if it is then the url is printed
 */
public class Part4 {
    void URL(){
        URLResource file=new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for(String item:file.words()){
            String LowerItem=item;//.toLowerCase();
            int pos=LowerItem.indexOf("youtube.com");
            if(pos!=-1){
                int beg=item.lastIndexOf("\"",pos);
                int end=item.indexOf("\"",pos+1);
                System.out.println(item.substring(beg+1,end));
            }
        }
    }

}
