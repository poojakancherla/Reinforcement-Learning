public class Main
{
    public static void main(String args[])
    {
        BasementGrid Base = new BasementGrid(); // Creating the object for the base
        Agent Tim = new Agent(Base); // Creating Tinny Tim

        int i = 1; // Used to count number of iteration
        int c = 0;
        while (true)
        {
            Base.drop_donut(); // Drops donut into the base

            Tim.move(Base); // Simulates movement of Tim in the base based on the policy

            if(i % 100000000 == 0)
            {

                System.out.println("\n");
                System.out.println(c * 100 + " Million iterations:");
                System.out.println("______________________");
                System.out.println();
                c++;

                Tim.qlearn.print_Expected_Reward();
                System.out.println();
                System.out.println();
                System.out.println("Policy Map: ");
                System.out.println("___________");
                System.out.println();
                Tim.print_Policy(Base);
                System.out.println("_________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
                if (c == 6)
                {
                    break;
                }

            }
            i++;

        }
    }
}
