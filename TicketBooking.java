package ticketBookingPkg;
import java.util.Scanner;
import utilityPkg.MyDao;
import utilityPkg.ArrayUpdate;
import java.sql.*;
import java.util.Arrays;
public class TicketBooking {
    public int seats[][] = new int[8][8];
    char ch = 'A';
    int sch_id = 0;
    
    ////////////////////////////////////
    MyDao mydaoObj = MyDao.getInstance();
    String user = "aamirnaved";
    String password = "1109";
    String url = "jdbc:mysql://localhost:3306/movietickets?allowPublicKeyRetrieval=true&useSSL=false";
    
    
    
    String fetchMultiplexName = "select * from multiplex_info";
    //String fetchAllMovies = "select a.movie_id,a.movie_name, b.certificate_name,c.genre_name,d.language from movie_info as a inner join movie_certificate as b on(a.certificate_id = b.certificate_id) inner join movie_genre as c on (a.genre_id = c.genre_id) inner join movie_language as d on(a.language_id = d.language_id)";
    String fetchAllMovies = "select b.sch_id, a.movie_name, b.show_timing, c.language from movie_info as a inner join movie_schedule as b on(a.movie_id=b.movie_id) inner join movie_language as c on(a.language_id = c.language_id)";
    
    
    ///////////////////////////////////
    
    
    Scanner sc = null;
    public TicketBooking(){
        sc = new Scanner(System.in);
    }
    public int welcome(){
        System.out.println("\nWelcome to ticket booking:\nChoose an option..");
        System.out.println("1. Show Multiplex");
        System.out.println("2. Show Movies");
        System.out.println("10. To exit!");
        int option = sc.nextInt();
        return option;
    }
    public int movies(){
            //movies ke saath uski timing bhi show karni hai.
            //
        try{
            //creating connection with database;
            Statement st1 = mydaoObj.getConnection(url,user,password);
            ResultSet res = mydaoObj.fetchData(st1,fetchAllMovies);
            int cc1 = res.getMetaData().getColumnCount();
            while(res.next()){
            for(int i = 1; i<=cc1; i++){
                System.out.print(res.getString(i) + " ");
            }   
                System.out.println("");
            }
            System.out.println("");
            System.out.println("\n");
            System.out.println("Press 5 for previous screen");
            System.out.println("Press 6 to cancel");
            System.out.println("Choose your movie!");
            System.out.println("");
            return sc.nextInt();
            
            
            
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
        return 0;
    }
    public int multiplexes(Scanner sc){
        try{
            //creating connection with database;
            Statement st = mydaoObj.getConnection(url,user,password);
            
            //Fetching data from database;
            ResultSet res = mydaoObj.fetchData(st, fetchMultiplexName);
            int cc = res.getMetaData().getColumnCount();
            while(res.next()){
            for(int i = 1; i<=cc; i++){
                System.out.print(res.getString(i) + " ");
            }
                System.out.println("");
            }
                System.out.println();
            System.out.println("Press 5 for previous screen");
            System.out.println("Press 6 to cancel");
            System.out.println("Choose your multiplex!");
            return sc.nextInt();
          
        
          
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
        
        return 0;
    }
    public int multiplex(int multiplexId){
        
        return 0;
    }
    
    public String movieTickets(int multiplexId, int schId){
       
        sch_id = schId;
        // fetch multiplex name and show it own top
        try{
            //creating connection with database;
            Statement st = mydaoObj.getConnection(url,user,password);
            
            //Fetching data from database;
            ResultSet res = mydaoObj.fetchData(st, "select multiplex_name,multiplex_address from multiplex_info");
            int cc = res.getMetaData().getColumnCount();
            
            while(res.next()){
                System.out.print("Multiplex & Address ->: ");
                for(int i = 1; i<=cc; i++){
                    System.out.print(res.getString(i) + " ");
                 }
                System.out.println("");
            }
  
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
 
        // fetch movie name using movieId
        //String m = "select movie_name from movie_info where(movie_id = " + movieId+")";
        // ye query change karni hai.
        String sch = "select movie_name, show_timing, language from sch_mov_time where(sch_id = " + schId+")";
        //String sch = "select a.movie_name,b.show_timing from movie_info as a inner join movie_schedule as b on(a.movie_id = b.movie_id)where(a.movie_id = " + schId+")";
         try{
            //creating connection with database;
            Statement st1 = mydaoObj.getConnection(url,user,password);
            ResultSet res = mydaoObj.fetchData(st1,sch);
            int cc1 = res.getMetaData().getColumnCount();
             
            while(res.next()){
                System.out.print("Movie name & Show timing -> : ");
                for(int i = 1; i<=cc1; i++){
                    System.out.print(" | ");
                   System.out.print(res.getString(i) + " ");
                }   
                System.out.println("");
            }
    
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
        //////////////////////////////////////
        //why nextLine(); for avoiding buffer 
        sc.nextLine();
        System.out.println("\nShowing available seats:");
        
       // int c = 1;
        
        ch = 'A';
        System.out.println("");
        for(int[] a: seats){
            System.out.println(ch +" " +Arrays.toString(a) +" "+ ch++);
        }
        System.out.println("\n'-1' = Booked");
        System.out.println("Price: (Rows) A,B,C,D = 300 || E,F= 220 || G,H = 180");
        System.out.println("Press 5 for previous screen");
        System.out.println("Press 6 to cancel");
        System.out.println("Book your seat!");
        String s = sc.nextLine();
        return s;
        
        //seat no. return kar rahe.

    }
    public void ticketBooked(String tickets){
        //isko seat no do, phir ye array update ko call karege, woh row and col return karega int me, phir apna 2D array update kar do.
        ArrayUpdate arup = new ArrayUpdate();
        
        int[] row_col = arup.updateTickets(tickets.toUpperCase());
        int row = row_col[0];
        int col = row_col[1];
        seats[row][col] = -1;
        System.out.println("Showing updated seats: ");
        ch = 'A';
        for(int[] a: seats){
            System.out.println(ch +" " +Arrays.toString(a) +" "+ ch++);
        }
        // yahan code likhenge jisse database me jaake ticket booking ki entry ho jaaye.
        // movie book karte waqt table se fetch karna hai ki jo movie book hui hai woh kis multiplex me laga tha,
        // audi no. kya hai,
        // H row ke baad Screen hai,
        // movie_scheule table me audi_id hai, movie_id hai,
        
        String show = "select a.movie_name, b.audi_id, b.show_timing from movie_info as a inner join movie_schedule as b on(a.movie_id = b.movie_id) where (sch_id = " + sch_id+")";
         System.out.println("\n1 Ticket Booked:");
         try{
            //creating connection with database;
            Statement st1 = mydaoObj.getConnection(url,user,password);
            ResultSet res = mydaoObj.fetchData(st1,show);
            int cc1 = res.getMetaData().getColumnCount();
             
            while(res.next()){
                System.out.println("\nMovie name, Audi & Show timing:");
                for(int i = 1; i<=cc1; i++){
                    System.out.print(" | ");
                   System.out.print(res.getString(i) + " ");
                }   
                System.out.println("");
            }
    
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
        
        
       
        System.out.println("");
       
        
        
        
    }
    
    public int movieInMultiplex(int movieId){
        
        return 0;
    }
    
    
}
