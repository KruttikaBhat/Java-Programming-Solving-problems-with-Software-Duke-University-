import edu.duke.*;
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
            //System.out.println("IndexinWhileLoop: "+index);
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
    StorageResource GetAllGenes(String dna){
        int startIndex=0;
        StorageResource sr=new StorageResource();
        while(true){
            String currGene=findGene(dna,startIndex);
            if(currGene.isEmpty()){
                break;
            }
            else{
                sr.add(currGene);
                startIndex= dna.indexOf(currGene,startIndex)+currGene.length();
                dna=dna.substring(startIndex,dna.length());
            }
        }
        return sr; 
    }
    float cgRatio(String dna){
        float totalLength=dna.length();
        int count=0;
        int index1=dna.indexOf("C");
        int index2=dna.indexOf("G");
        
        while(index1!=-1 || index2!=-1){
            if(index1!=-1){
                count+=1;
                index1=dna.indexOf("C",index1+1);
            }
            
            if(index2!=-1){
                count+=1;
                index2=dna.indexOf("G",index2+1);
            }
        }
        return count/totalLength;
    }
    
    int countCTG(String dna){
        int count=0;
        int index=dna.indexOf("CTG");
        while(true){
            if(index==-1){
                break;
            }
            else{
                count+=1;
                index=dna.indexOf("CTG",index+3);
            }
        }
        return count;
    }
    void processGenes(StorageResource sr){
        int lengthCount=0;
        int ratioCount=0;
        int maxlength=0;
        String max;
        for(String s:sr.data()){
            System.out.println("Gene: "+s);
            if(s.length()>9){
                System.out.println("Longer than 9: "+ s);
                lengthCount+=1;
            }
            if(cgRatio(s)>0.35){
                System.out.println("cgRatio>0.35: "+s);
                ratioCount+=1;
            }
            if(s.length()>maxlength){
                maxlength=s.length();
                max=s;
            }
        }
        System.out.println("The number of strings longer than 9 are: "+lengthCount);
        System.out.println("The number of strings with ratio>0.35 are: "+ratioCount);
        System.out.println("The longest string is : "+maxlength);
        
    }
    void testProcessGenes(String dna){
        StorageResource sr=new StorageResource();
        sr=GetAllGenes(dna);
        System.out.println("Dna: "+dna);
        processGenes(sr);
    }
    void testFindStopCodon2(String dna){
        System.out.println("Dna strand: "+dna);
        /*
        StorageResource Genes=GetAllGenes(dna);
        for(String s : Genes.data()){
            System.out.println(s);
        }
        */
        System.out.println("CTG count "+countCTG(dna));
        System.out.println("CG ration "+cgRatio(dna));
    }
    void testFindStopCodon(){
        String dna="ATGTTTTTTCCCTAAAGGATGCGACGATGACCCCAGAGTGACCC";
        testProcessGenes(dna);
        dna="ATGTAACTCATGCCCTGAACG";
        testProcessGenes(dna);
        dna="TGAATGCCCTAGGTAATGCAATAA";
        testProcessGenes(dna);
        dna="ATGTTTAAATGACCCGGGATGAAACCTTAAGGGAGTTAG";
        testProcessGenes(dna);
        dna="";
        testProcessGenes(dna);
        FileResource fr = new FileResource("brca1line.fa");
        dna = fr.asString();
        dna=dna.toUpperCase();
        testProcessGenes(dna);
    }

}
