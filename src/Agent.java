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

    public void move_up()
    {
        temp_x += -1;
        temp_y += 0;
    }

    public void move_down()
    {
        temp_x += 1;
        temp_y += 0;
    }

    public void move_left()
    {
        temp_x += 0;
        temp_y += -1;
    }

    public void move_right()
    {
        temp_x += 0;
        temp_y += 1;
    }


    // Checks the validity of the move, and also calculates reward for hitting/not hitting the wall
    public int check_Move(BasementGrid Base)
    {
        int reward = 0;
        if(Base.basement[temp_x][temp_y] == 'X')
        {
            reward = -1;
            temp_x = x;
            temp_y = y;
        }
        else
        {
            if(Base.basement[x][y] != 'D')
            {
                Base.basement[x][y] = '\0';
            }

            // Move is legal so actually move tim now!
            x = temp_x;
            y = temp_y;
        }
        return reward;
    }

    // Checks tile falls using the current location of Tim
    public int check_traps(BasementGrid Base) {

        if((x == 1 && y == 3) || (x == 2 && y == 7) || (x == 3 && y == 4) || (x == 5 && y == 2) || (x == 6 && y == 5) || (x == 6 && y == 7) || (x == 7 && y == 2))
        {

            int Tile_Prob = r.nextInt(100);

            // Tim got crushed with the tile
            if(Tile_Prob < 50)
            {
                return 10;
            }
        }
        return 0;
    }

    public void update(BasementGrid Base, int Reward, int State, int New_State, int Action)
    {
        double Max_Action = qlearn.get_Max_Action_Value(qlearn.Q[New_State]);

        qlearn.Q[State][Action] += qlearn.Alpha * (Reward + qlearn.Discount_Factor * Max_Action - qlearn.Q[State][Action]);
    }
}
