
/**
 * Similar to part1 but here if dna is in lower case then gene should also be printed in lower case.
 *Also, to parameters startCodon and topCodon are added 
 *  
 *
 */
public class Part2 {
    String findSimpleGene(String dna, String startCodon, String stopCodon){
        String result="";
        int flag=0;
        if(dna!=dna.toUpperCase()){
            dna=dna.toUpperCase();
            flag=1;
        }
        int start=dna.indexOf(startCodon);
        int end=dna.indexOf(stopCodon,start+3);
        if((start==-1)||(end==-1)){
            return "";
        }
        if((end-start)%3==0){
            result=dna.substring(start,end+3);
        }
        if(flag==1){
            result=result.toLowerCase();    
        }
        return result;
        
    }
    
    void testSimpleGene(){
        String NoATG="GTCAAGCTATAAGC";
        String NoTAA="gtacatgactgagcta";
        String Not="ACGTGACTGATCAG";
        String Perfect="gcatgagtcgatgctaa";
        String NotPerfect="gctatgcgtacgttaa";
        System.out.println(NoATG);
        System.out.println("Gene is "+findSimpleGene(NoATG,"ATG","TAA"));
        System.out.println(NoTAA);
        System.out.println("Gene is "+findSimpleGene(NoTAA,"ATG","TAA"));
        System.out.println(Not);
        System.out.println("Gene is "+findSimpleGene(Not,"ATG","TAA"));
        System.out.println(Perfect);
        System.out.println("Gene is "+findSimpleGene(Perfect,"ATG","TAA"));
        System.out.println(NotPerfect);
        System.out.println("Gene is "+findSimpleGene(NotPerfect,"ATG","TAA"));
    }

}
