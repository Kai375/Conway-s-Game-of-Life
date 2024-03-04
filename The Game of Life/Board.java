import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import java.util.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;

/**
 * This is the Board, from here the matrix object will be called using getMatrix() and will be painted accordingly. 
 */
public class Board 
{    
    @FXML
    private Canvas canvas;
    private final int rectSize = 25;
    final private int width = 10;
    final private int height = 10;
    private static Matrix mat;       

    @FXML
    void NextGenButtonPressed(ActionEvent event)
    {
        GraphicsContext gc =  canvas.getGraphicsContext2D(); // Get graphics assets.
        
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Get canvas dimensions.
               
        mat = new Matrix(width, height); // Call Matrix1 contractor with given width and height.

        int x = 0;
        int y = 0;

        int[][] matrix = mat.getMatrix(); // Get the Matrix1 object.
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                if(matrix[i][j] == 1)
                {
                    gc.fillRect(x, y, rectSize, rectSize);
                }
                else
                {
                    gc.strokeRect(x, y, rectSize, rectSize);
                }
                x += rectSize;
            }
            y += rectSize;
            x = 0;
        }        
    }
}





