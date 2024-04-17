// BV Ue4 SS2023 Vorgabe
//
// Copyright (C) 2023 by Klaus Jung
// All rights reserved.
// Date: 2023-03-23
 		   	  	  		

package bv_ss23;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Histogram {
    private static final int grayLevels = 256;

    private GraphicsContext gc;
    private int maxHeight;

    private int[] histogram = new int[grayLevels];

    public Histogram(GraphicsContext gc, int maxHeight) {
        this.gc = gc;
        this.maxHeight = maxHeight;
    }

    public int[] getValues() {
        return histogram;
    }

    public void setImageRegion(RasterImage image, int regionStartX, int regionStartY, int regionWidth, int regionHeight) {
        // Reset the histogram array
    		for (int i = 0; i < grayLevels; i++) {
            histogram[i]=0;
       }

        // Iterate over the region defined by the parameters
        for (int y = regionStartY; y < regionStartY + regionHeight; y++) {
            for (int x = regionStartX; x < regionStartX + regionWidth; x++) {
                // Get the pixel index in the argb array, same process as in previous exercises
                int pixelIndex = y * image.width + x;

                // Get the grayscale value of the pixel
                int pixel = image.argb[pixelIndex]; //get color information of the pixel
                int grayValue = (pixel >> 16) & 0xFF;

                // Increment the histogram count for the corresponding gray value
                histogram[grayValue]++;
            }
        }
    }
    
	
	public Integer getMinimum() {
		// Will be used in Exercise 5.
		return null;
	}
 		   	  	  		
	public Integer getMaximum() {
		// Will be used in Exercise 5.
		return null;
	}
 		   	  	  		
	public Double getMean() {
		// Will be used in Exercise 5.
		return null;
	}
 		   	  	  		
	public Integer getMedian() {
		// Will be used in Exercise 5.
		return null;
	}
 		   	  	  		
	public Double getVariance() {
		// Will be used in Exercise 5.
		return null;
	}
 		   	  	  		
	public Double getEntropy() {
		// Will be used in Exercise 5.
		return null;
	}
 		   	  	  		
	public void draw(Color lineColor) {
	  //same process as in ToneCurve class
	    gc.clearRect(0, 0, grayLevels, maxHeight);
	    gc.setStroke(lineColor);
	    gc.setLineWidth(1);

	    // Find the maximum frequency to scale the bars, stores max height of bars
	    int maxFrequency = 0;
	    for (int i = 0; i < grayLevels; i++) {
	        maxFrequency = Math.max(maxFrequency, histogram[i]); //updates maxFrequency if a higher frequency is found
	    }

	    // Calculate the scaling factor for the bars
	  double scaleFactor = (double) (maxHeight) / maxFrequency;

	    // Draw the histogram bars
	    double barWidth = (double) grayLevels / histogram.length;
	    for (int i = 0; i < histogram.length; i++) {
	        double barHeight = histogram[i] * scaleFactor;//equal width for each bar
	        double x = i * barWidth + 0.5;
	        double y = maxHeight - barHeight + 0.5;
	        gc.strokeLine(x, maxHeight - 0.5, x, y);
	    }
	}


 		   	  	  		
}
	  	  		






