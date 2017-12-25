
/**
 * Finds a gene in a dna sample and printd the first found gene or else an empty string
 * Run in BlueJ
 * @author Kruttika 
 * @version 18/12/12017
 */
public class Part1 {
    String findSimpleGene(String dna){
        String result="";
        int start=dna.indexOf("ATG");
        int end=dna.indexOf("TAA",start+3);
        if((start==-1)||(end==-1)){
            return "";
        }
        if((end-start)%3==0){
            result=dna.substring(start,end+3);
        }
        return result;
        
    }
    
    void testSimpleGene(){
        String NoATG="GTCAAGCTATAAGC";
        String NoTAA="GTACATGACTGAGCTA";
        String Not="ACGTGACTGATCAG";
        String Perfect="GCATGAGTCGATGCTAA";
        String NotPerfect="GCTATGCGTACGTTAA";
        System.out.println(NoATG);
        System.out.println("Gene is "+findSimpleGene(NoATG));
        System.out.println(NoTAA);
        System.out.println("Gene is "+findSimpleGene(NoTAA));
        System.out.println(Not);
        System.out.println("Gene is "+findSimpleGene(Not));
        System.out.println(Perfect);
        System.out.println("Gene is "+findSimpleGene(Perfect));
        System.out.println(NotPerfect);
        System.out.println("Gene is "+findSimpleGene(NotPerfect));
    }

}
