import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class ShortPath {

    private static final int INF = Integer.MAX_VALUE/2;  // Conditional infinity
    private String[] city; //array of names
    private int vertexNumber;  //number of cities
    private int[][] matrix; //adjacency matrix
    private int numberPath; //number of search paths
    private int numberOfTest; // number of test
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) {
        ShortPath solution = new ShortPath();

        // Calling method solving the task
        try {
            solution.solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void input() throws IOException
    {
        //Reading data
        System.out.println("Enter number of Cities:");
        vertexNumber = Integer.parseInt(reader.readLine());
        while(vertexNumber  >10000)
        {
            System.out.println("Number of cities should be less 10000 ");
            System.out.println("Enter number of Cities:");
            vertexNumber = Integer.parseInt(reader.readLine());

        }

        matrix = new int[vertexNumber][vertexNumber]; //initialize matrix
        city = new String[vertexNumber];
        for(int in = 0; in < vertexNumber; in++) // Filling the matrix
        {
            for (int j = 0; j < vertexNumber; j++)
            {
                matrix[in][j] = INF;
            }
        }
        for(int a = 0; a < vertexNumber; a++) //Filling an array with city names
        {
            Pattern pattern = Pattern.compile("[A-Za-z]");
            System.out.println("Enter name City:");
            String name = reader.readLine();
            while (!pattern.matcher(name).find() || name.length()>10) { //Validation of name
                if (!pattern.matcher(name).find()) {
                    System.out.println("The name must contain characters a-z");
                    System.out.println("Enter name City:");
                    name = reader.readLine();
                }
                if (name.length() > 10) {
                    System.out.println("The name must be less 10 characters");
                    System.out.println("Enter name City:");
                    name = reader.readLine();
                }
            }

            city[a] = name;
            System.out.println("Enter number of neighbours:");
            int neighbours = Integer.parseInt(reader.readLine()); //number neighbours
            for (int i = 0; i < neighbours; i++) {
                System.out.println("Enter index neighbours:");
                int indexNeighbours = Integer.parseInt(reader.readLine())-1; //index neighbours
                System.out.println("Enter cost from "+ (a+1)+" to:" + (indexNeighbours +1) );
                int value = Integer.parseInt(reader.readLine());
                matrix[a][indexNeighbours] = value; //path value
            }

        }

    }

    public void solve()throws IOException {
        System.out.println("Enter number of test");
        if((numberOfTest= Integer.parseInt(reader.readLine()))>=10)  //Number of test
        {
            System.out.println("Number of test should be less 10");
            System.out.println("Enter number of test:");
            numberOfTest = Integer.parseInt(reader.readLine());

        }

        for(int num = 1; num <=numberOfTest; num++) {
            input(); //Calling method for input of data

            //The Floyd-Warshall algorithm
            for (int k = 0; k < vertexNumber; k++) {
                for (int i = 0; i < vertexNumber; i++) {
                    for (int j = 0; j < vertexNumber; j++) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }

            System.out.println("Enter count ShortPath:");
            numberPath = Integer.parseInt(reader.readLine()); //number of search paths
            print(numberPath); //calling method for show of path
        }

        //lose the input stream
        reader.close();

    }

    public void print(int count) throws IOException
    {
        int ver = 0;//index of first city
        int toVer = 0;//index of second city
        for(int a = 0; a < count; a++) {
            System.out.println("enter name vertexParent:");
            String nameParent = reader.readLine(); //name of first city
            System.out.println("enter name vertexTo:");
            String nameVertex = reader.readLine(); //name of second city

            for (int i = 0; i < city.length; i++) //search for city name index
            {
                if(city[i].equals(nameParent)) ver = i;
                else if(city[i].equals(nameVertex)) toVer = i;

            }
            System.out.println(matrix[ver][toVer]); // show of path
        }

    }



}