

import java.util.List;
import java.util.ArrayList;

public class Cluster {
	          
	         private ClusterPoint center;
	         private int id;
	         private ArrayList<ClusterPoint> list;
	         
             public Cluster(int id){
            	 center = null ;
                 this.id = id;
                 list = new ArrayList<ClusterPoint>();
             }
             
             public ClusterPoint getCenter(){
                 return center;	 
             }
             
             public ArrayList<ClusterPoint> getPoints(){
            	 return list;
             }
             
             public int getID(){
                 return id;	 
             }
             
             public void addPoint(ClusterPoint p1){
            	 list.add(p1);
             }
             
             public void setCenter(ClusterPoint p1){
            	 center = new ClusterPoint(p1.getR(),p1.getG(),p1.getB());
             }
             
             public void setID(int id){
            	 this.id = id;
             }
             
             public void calCenter(){
            	 int num = 0;
            	 double sumofR = 0;
        		 double sumofG = 0;
        		 double sumofB = 0;
        	
            	 for(int i=0; i<list.size(); i++){
            		 ClusterPoint p1 = list.get(i);
            		 if(list.get(i).getCluster() == id){ 
            			 sumofR = sumofR + p1.getR();
            			 sumofG = sumofG + p1.getG();
            			 sumofB = sumofB + p1.getB();
            			
            			 num ++;
            		 }
            	 }
            	 
            	 if( num!=0 ){
            		 
            		 center.setB((int)sumofR/num);
            		 center.setG((int)sumofG/num);
            		 center.setB((int)sumofB/num);
            	
            		
            	 }
            	
        		
             }
             
             public static void assignPoints(ClusterPoint p1,Cluster[] c1){
            	    int index = 0;
            	    double min_dis = ClusterPoint.Distance(p1, c1[0].getCenter());
            	    
            	    for(int i=1; i<c1.length; i++){
            	    	if(min_dis >= ClusterPoint.Distance(p1, c1[i].getCenter())){
            	    		 index = i;
            	    		 min_dis = ClusterPoint.Distance(p1, c1[i].getCenter());
            	    	}
            	    	          
            	    }
            	    
            	    c1[index].addPoint(p1);
            	    p1.setCluster_num(c1[index].getID());
             }
             
             
}

