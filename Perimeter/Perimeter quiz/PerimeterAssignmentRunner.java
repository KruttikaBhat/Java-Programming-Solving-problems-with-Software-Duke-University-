import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    public void testPerimeter () {
        
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        /*
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        */
       int numPoints=getNumPoints(s);
       double avg=getAverageLength(s);
       double largestSide=getLargestSide(s);
       double largestX=getLargestX(s);
       System.out.println("number of points: "+numPoints);
       System.out.println("Average length: "+avg);
       System.out.println("Largest side: "+largestSide);
       System.out.println("Largest x coordinate: "+largestX);
    }
    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for(Point p:s.getPoints()){
            count+=1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double peri=getPerimeter(s);
        int count=getNumPoints(s);
        double avg=peri/count;
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double max=0.0;
        Point prevPt=s.getLastPoint();
        for(Point currPt:s.getPoints()){
            double currDist=prevPt.distance(currPt);
            if(currDist>max){
                max=currDist;
            }
            prevPt=currPt;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double max=0;
        int flag=0;
        for(Point p:s.getPoints()){
            double currX=p.getX();
            if(flag==0){
                max=currX;
                flag=1;
            }
            if(currX>max){
                max=currX;
            }
        }
        return max;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double maxPer=0.0;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr= new FileResource(f);
            Shape s=new Shape(fr);
            double currPer=getPerimeter(s);
            if(currPer>maxPer){
                maxPer=currPer;
            }
            
        }
        return maxPer;
    }

    public File getFileWithLargestPerimeter() {
        // Put code here
        double maxPer=0;
        File max=null;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr= new FileResource(f);
            Shape s=new Shape(fr);
            double currPer=getPerimeter(s);
            if(currPer>maxPer){
                maxPer=currPer;
                max=f;
            }
            
        }
            // replace this code
        return max;
    }

    public void testPerimeterMultipleFiles() {
        //double max=getLargestPerimeterMultipleFiles();
        File maxFile=getFileWithLargestPerimeter();
        FileResource fr= new FileResource(maxFile);
        Shape s=new Shape(fr);
        double max=getPerimeter(s);
        System.out.println("File with largest perimeter is: "+maxFile.getName()+" with perimeter ");
        
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
    
    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
