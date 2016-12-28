
import java.util.Random;
import java.awt.Color;
public class ClusterPoint {
	  
             private int r;
             private int g;
             private int b;
             private int cluster_num;
             
             public ClusterPoint(int x,int y,int z){
            	 r = x;
            	 g = y;
            	 b = z;
           
             }
             
             public void setCluster_num(int n){
            	 cluster_num = n;
             }
             
             public  int getR()  {
                 return this.r;
             }
             
             public int getG()  {
                 return this.g;
             }
             
             public int getB()  {
                 return this.b;
             }
             
             
             
             public void setB(int b)  {
                 this.b = b;
             }
             
             public void setR(int r)  {
                 this.r = r;
             }
             
             public void setG(int g)  {
                 this.g = g;
             }
             
      
             public int getCluster() {
                 return this.cluster_num;
             }
             
             public static ClusterPoint randomPoint(int min,int max,int[] rgb){
            	 
            	 int x = (int)(Math.random()*(max-min));
            	 Color c = new Color(rgb[x]);
            	 int red = c.getRed();
            	 int green = c.getGreen();
            	 int blue = c.getBlue();
            
            	 ClusterPoint p = new ClusterPoint(red,green,blue);
            	 return p;
             }
             
             public static double Distance(ClusterPoint p1,ClusterPoint p2){
            	     return (Math.pow((p1.getR()-p2.getR()),2)+Math.pow((p1.getG()-p2.getG()),2)+Math.pow((p1.getB()-p2.getB()),2));
             }
            
}

