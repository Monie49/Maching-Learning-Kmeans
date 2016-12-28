



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;



public class Kmeans{
	public static void main(String[] args){
		if (args.length < 3){
		    System.out.println("Usage: Kmeans <input-image> <k> <output-image>");
		    return;
		}
		
		try{
		    BufferedImage originalImage = ImageIO.read((new File(args[0])));
		    int k=Integer.parseInt(args[1]);
		    BufferedImage kmeansJpg = kmeans_helper(originalImage,k);
		    ImageIO.write(kmeansJpg, "jpg", new File(args[2])); 
//		    System.out.println("The compression ratio is: ");
		    
		    
		}catch(IOException e){
		    System.out.println(e.getMessage());
		}	
	}
	    
	    private static BufferedImage kmeans_helper(BufferedImage originalImage, int k){
		int w=originalImage.getWidth();
		int h=originalImage.getHeight();
		BufferedImage kmeansImage = new BufferedImage(w,h,originalImage.getType());
		Graphics2D g = kmeansImage.createGraphics();
		g.drawImage(originalImage, 0, 0, w,h , null);
		// Read rgb values from the image
		int[] rgb=new int[w*h];
		int count=0;
		for(int i=0;i<w;i++){
		    for(int j=0;j<h;j++){
			rgb[count++]=kmeansImage.getRGB(i,j);
		    }
		}
		
		
		
		// Call kmeans algorithm: update the rgb values
		kmeans(rgb,k);

		// Write the new rgb values to the image
		count=0;
		for(int i=0;i<w;i++){
		    for(int j=0;j<h;j++){
			kmeansImage.setRGB(i,j,rgb[count++]);
		    }
		}
		return kmeansImage;
	    }

	    // Your k-means code goes here
	    // Update the array rgb by assigning each entry in the rgb array to its cluster center
	    private static void kmeans(int[] rgb, int k){
	    	    ArrayList<ClusterPoint> a1 = new ArrayList<ClusterPoint>();
	    	    Cluster[] c1 = new Cluster[k];
	    	   
	    	    boolean finish = false;
	    	    double distance = 0;
	    	    
	    	
	    	    
	    	    for(int i=0; i<k; i++){
    	    		ClusterPoint p2 = ClusterPoint.randomPoint(0, rgb.length-1, rgb);
    	    		c1[i] = new Cluster(i);
  	    	    	c1[i].setCenter(p2);
  	    	    }
	    	    
	    	    for(int i=0; i<rgb.length; i++){
 	    	    	 Color c = new Color(rgb[i]);
 	            	 int red = c.getRed();
 	            	 int green = c.getGreen();
 	            	 int blue = c.getBlue();
 	            	 int alpha = c.getAlpha();
 	            	 ClusterPoint p1 = new ClusterPoint(red,green,blue);
 	            	 a1.add(p1);
 	    	    }
 	    	    
	    	    
	    	    while(!finish){
	    	    	
	  	    	    distance = 0;
	  	    	    for(int i=0; i<a1.size(); i++){
	  	    	    	Cluster.assignPoints(a1.get(i),c1);
	  	    	    }
	  	    	    

	  	    	    
	  	    	    for(int i=0; i<c1.length; i++){
	  	    	
	  	    	    	ClusterPoint p1 = new ClusterPoint(c1[i].getCenter().getR(),c1[i].getCenter().getG(),c1[i].getCenter().getB());
	  	    	    	c1[i].calCenter();
	  	    	
	  	    	        distance = distance + ClusterPoint.Distance(p1, c1[i].getCenter());	
	  	    	    }
	  	    	    
                	  	if(distance == 0) finish = true;
	  	    	      
	    	    }
                 
	    	    for(int i=0; i<a1.size(); i++){
	    	    	ClusterPoint p1 = a1.get(i);
	    	    	
	    	    	for(int j=0; j<c1.length; j++){		
	    	    		if(p1.getCluster() == c1[j].getID())
	    	    		{
	    	    			p1.setR(c1[j].getCenter().getR());
	    	    			p1.setG(c1[j].getCenter().getG());
	    	    			p1.setB(c1[j].getCenter().getB());
	    	    	
	    	    		}
	    	    		
	    	    	}
	    	    }
	    	    
                for(int i=0; i<rgb.length; i++){
	    	          Color c = new Color(a1.get(i).getR(),a1.get(i).getG(),a1.get(i).getB(),255);
	    	          rgb[i] = c.getRGB();
	    	    }
	    	  
	    	   
	    	    
	    	    
	    } 
	    
	    
	    
	   
	    
	    
	    
	    
	    
	    
}

