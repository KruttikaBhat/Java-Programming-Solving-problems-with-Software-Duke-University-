import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
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
        }
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        
        double max=-1111;
        for(Point p:s.getPoints()){
            if(p.getX()>max){
                max=p.getX();
            }
        }
        return max;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr= new FileResource(f);
            double totalPerim = 0.0;
            for(String line: fr.lines()){
            
            }
            
        }
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeterMultipleFiles(Shape s) {
        System.out.println("number of point: "+getNumPoints(s));
        System.out.println("average length: "+getAverageLength(s));
        System.out.println("largest side: "+getLargestSide(s));
        System.out.println("largest x: "+ getLargestX(s));
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
