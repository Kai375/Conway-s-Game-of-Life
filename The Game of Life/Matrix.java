import java.util.*;
import java.security.SecureRandom;
/**
 * This is the Matrix Class, here we will create a Matrix object.
 */
public class Matrix
{
    private int width;
    private int height;
    private int[][] mat;
        
    /**
     * Constructor for objects of class Matrix
     * @param int width
     * @param int height
     */
    public Matrix(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.mat = new int[width][height]; // Created the Matrix.
        
        fillMatrix();
    }

    /**
     * The fillMatrix method will... fill given matrix with random 0s and 1s.
     */
    private void fillMatrix()
    {
        SecureRandom random = new SecureRandom(); 
        
        for(int y = 0; y < mat.length; y++)
        {
            for(int x = 0; x < mat.length; x++)
            {                 
                int num = random.nextInt(2);
                mat[x][y] = num;
            }         
        }
    }
    
    private void setAlive(int x, int y) // Define 'alive' cell.
    {
        this.mat[x][y] = 1;
    }
    
    private void setDead(int x, int y) // Define 'dead' cell.
    {
        this.mat[x][y] = 0;
    }
    
    /**
     * The countAliveNeighbours method will count how many neighbours a specific (valid) spot in the matrix got.
     * 
     * @param int x
     * @param int y
     */
    private int countAliveNeighbours(int x, int y)
    {   
        int count = 0;
        
        count += getState(x-1, y-1);
        count += getState(x, y-1);
        count += getState(x+1, y-1);
        
        count += getState(x-1, y);
        count += getState(x+1, y);
        
        count += getState(x-1, y+1);
        count += getState(x,y+1);
        count += getState(x+1, y+1);
        
        return count;
    }
    
    /**
     * The getState method will check for each set of (x,y) coordinates that they represent a valid spot (or not) in the matrix, and report it to countAliveNeighbours method.
     * 
     * @param int x
     * @param int y
     */
    private int getState(int x, int y)
    {
        if(x < 0 || width <= x) // Check if given x coordinate is valid.
        {
            return 0;
        }
        
        if(y <= 0 || height <= y) // Check if given y coordinate is valid.
        {
            return 0;
        }
        
        return this.mat[x][y]; 
    }
    
    public int[][] getMatrix()
    {
        return mat;
    }
        
    /**
     * The nextGeneration method tasked with matching the number of live neighbours with one of the CONWAY rules.
     */
    private void nextGeneration() 
    {
       int[][] newMat = new int[width][height]; // Use a new Matrix object for each use of this method in order to exhibit movement on the canvas.
       
       for(int y = 0; y < mat.length; y++)
       {            
           for(int x = 0; x < mat.length; x++)
           {                               
              int aliveNeighbours = countAliveNeighbours(x,y); // Call the countAliveNeighbours method so that the next generation method will match the count with a rule.
              
              if(getState(x, y) == 1)
              {
                  if(aliveNeighbours < 2) // Death in the next generation duo to loneliness.
                  {
                      newMat[x][y] = 0;
                  }
                  else if(aliveNeighbours == 2 || aliveNeighbours == 3) // Existence in the next generation.
                  {
                      newMat[x][y] = 1;
                  }
                  else if(aliveNeighbours > 3) // Death from over population in the next generation.
                  {
                      newMat[x][y] = 0;
                  }
              }
              else
              {
                  if(aliveNeighbours == 3) // Birth in the next generation.
                  {
                      newMat[x][y] = 1;
                  }
              }   
              
           }                
       } 
       this.mat = newMat;
    }          
}