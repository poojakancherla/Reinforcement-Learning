//Our agent here is Tinny Tim
import java.util.Random;

public class Agent
{
    Random r = new Random();
    private int x, y, temp_x, temp_y;

    // Initializes the Q Martix with default values		
    QLearning qlearn;

    public Agent(BasementGrid Base)
    {
        qlearn = new QLearning();
        x = 4; // Initial X of Tim
        y = 4; // Initial Y of Tim

        temp_x = 4;
        temp_y = 4;


        Base.basement[x][y] = 'T';
    }
}
