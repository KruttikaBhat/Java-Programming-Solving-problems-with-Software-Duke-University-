
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    int findStopCodon(String dna, int startIndex, String stopCodon){
        int index=dna.indexOf(stopCodon,startIndex+3);
        while(index!=-1){            
            if((index-startIndex)%3==0){
                return index;
            }
            else{
                index=dna.indexOf(stopCodon,index+3);
            }
            System.out.println("IndexinWhileLoop: "+index);
        }
        return dna.length();
        
        
    }
    String findGene(String dna, int startIndex){
        startIndex=dna.indexOf("ATG");
        if(startIndex==-1){
            return "";
        }
        int stopTAA=findStopCodon(dna,startIndex,"TAA");
        int stopTGA=findStopCodon(dna,startIndex,"TGA");
        int stopTAG=findStopCodon(dna,startIndex,"TAG");
        int minIndex=0;
        if((stopTAA==-1) || ((stopTGA!=-1) && (stopTGA<stopTAA))){
            minIndex=stopTGA;
        }
        else{
            minIndex=stopTAA;
        }
        if(minIndex==-1 || stopTAG!=-1 && stopTAG<minIndex){
            minIndex=stopTAG;
        }
        if(minIndex==dna.length()){
            return "";
        }
        
        return dna.substring(startIndex,minIndex+3);
    }
    void PrintAllGenes(String dna){
        int startIndex=0;
        while(true){
            String currGene=findGene(dna,startIndex);
            if(currGene.isEmpty()){
                break;
            }
            else{
                System.out.println(currGene);
                startIndex= dna.indexOf(currGene,startIndex)+currGene.length();
                dna=dna.substring(startIndex,dna.length());
            }
        }
    }
    void testFindStopCodon2(String dna){
        System.out.println("Dna strand: "+dna);
        PrintAllGenes(dna);
    }
    void testFindStopCodon(){
        String dna="TCC";
        testFindStopCodon2(dna);
        dna="ATGTCAAGCTGACCAG";
        testFindStopCodon2(dna);
        dna="ACTGATGCCCCTTTGATATGAACTGACC";
        testFindStopCodon2(dna);
        dna="CCCATGACG";
        testFindStopCodon2(dna);
        dna="";
        testFindStopCodon2(dna);
    }

}
