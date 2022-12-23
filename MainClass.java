package mainPkg;

import ticketBookingPkg.TicketBooking;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        int c = -1;
        int multiplexId = 0;
        // ClearScreen cls = new ClearScreen();
        // MyDao obj = MyDao.getInstance();
        TicketBooking tb = new TicketBooking();
        for (int[] a : tb.seats) {
            for (int i = 0; i < a.length; i++) {
                a[i] = i + 1;
            }
        }

        int option;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        startAgain:
        while (flag) {
            // cls.clearScreen();
            option = tb.welcome();

            switch (option) {
                case 1:
                    System.out.println("\nShowing Multiplexes...\n");

                    multiplexId = tb.multiplexes(sc);
                    System.out.println();
                    switch (multiplexId) {
                        case 5:
                            continue startAgain;
                        case 6:
                            continue startAgain;
                        case 1:
                            // 1 option means show all movies in cinema;
                            // call movies(sc)

                            boolean movieLoop = true;
                            movieLoopLab:
                            while (movieLoop) {

                                System.out.println("\nShowing all movies...");
                                // movieChoice me sch_id aa rahi hai.
                                int movieChoice = tb.movies();
                                switch (movieChoice) {
                                    case 1:
                                        // when user select a movie, show available tickets for that movie;
                                        // call movieTickets(multiPlexId, movieId)
                                        // movieChoice is movie_id
                                        // multiplexId is multiplex_id
                                        String movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                        // ab yahan pe A1, B2, or F9 aise kuch karke aa raha,

                                        boolean f = true;

                                        while (f) {
                                            switch (movieTicketOption) {
                                                case "5":
                                                    continue movieLoopLab;
                                                case "6":
                                                    continue startAgain;
                                                default:
                                                    tb.ticketBooked(movieTicketOption);
                                                    System.out.println("Press 0 to book more tickets and 9 to exit");
                                                    c = sc.nextInt();

                                            }

                                            if (c == 0) {
                                                movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                            }
                                            else if (c == 9) {
                                                continue startAgain;
                                            }
                                        }
                                        break;
                                    case 2:
                             
                                        movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                        

                                        f = true;

                                        while (f) {
                                            switch (movieTicketOption) {
                                                case "5":
                                                    continue movieLoopLab;
                                                case "6":
                                                    continue startAgain;
                                                default:
                                                    tb.ticketBooked(movieTicketOption);
                                                    System.out.println("Press 0 to book more tickets and 9 to exit");
                                                    c = sc.nextInt();

                                            }

                                            if (c == 0) {
                                                movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                            }
                                            else if (c == 9) {
                                                continue startAgain;
                                            }
                                        }
                                        break;
                                    case 3:
                             
                                        movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                        

                                        f = true;

                                        while (f) {
                                            switch (movieTicketOption) {
                                                case "5":
                                                    continue movieLoopLab;
                                                case "6":
                                                    continue startAgain;
                                                default:
                                                    tb.ticketBooked(movieTicketOption);
                                                    System.out.println("Press 0 to book more tickets and 9 to exit");
                                                    c = sc.nextInt();

                                            }

                                            if (c == 0) {
                                                movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                            }
                                            else if (c == 9) {
                                                continue startAgain;
                                            }
                                        }
                                        break;
                                    case 4:
                             
                                        movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                        

                                        f = true;

                                        while (f) {
                                            switch (movieTicketOption) {
                                                case "5":
                                                    continue movieLoopLab;
                                                case "6":
                                                    continue startAgain;
                                                default:
                                                    tb.ticketBooked(movieTicketOption);
                                                    System.out.println("Press 0 to book more tickets and 9 to exit");
                                                    c = sc.nextInt();

                                            }

                                            if (c == 0) {
                                                movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                            }
                                            else if (c == 9) {
                                                continue startAgain;
                                            }
                                        }
                                        break;
                                    case 5:
                             
                                        movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                        

                                        f = true;

                                        while (f) {
                                            switch (movieTicketOption) {
                                                case "5":
                                                    continue movieLoopLab;
                                                case "6":
                                                    continue startAgain;
                                                default:
                                                    tb.ticketBooked(movieTicketOption);
                                                    System.out.println("Press 0 to book more tickets and 9 to exit");
                                                    c = sc.nextInt();

                                            }

                                            if (c == 0) {
                                                movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                            }
                                             else if (c == 9) {
                                                continue startAgain;
                                            }
                                        }
                                        break;
                                    case 6:
                             
                                        movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                        

                                        f = true;

                                        while (f) {
                                            switch (movieTicketOption) {
                                                case "5":
                                                    continue movieLoopLab;
                                                case "6":
                                                    continue startAgain;
                                                default:
                                                    tb.ticketBooked(movieTicketOption);
                                                    System.out.println("Press 0 to book more tickets and 9 to exit");
                                                    c = sc.nextInt();

                                            }

                                            if (c == 0) {
                                                movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                            }
                                             else if (c == 9) {
                                                continue startAgain;
                                            }
                                        }
                                        break;
                                    case 7:
                             
                                        movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                        

                                        f = true;

                                        while (f) {
                                            switch (movieTicketOption) {
                                                case "5":
                                                    continue movieLoopLab;
                                                case "6":
                                                    continue startAgain;
                                                default:
                                                    tb.ticketBooked(movieTicketOption);
                                                    System.out.println("Press 0 to book more tickets and 9 to exit");
                                                    c = sc.nextInt();

                                            }

                                            if (c == 0) {
                                                movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                                            }
                                            else if (c == 9) {
                                                continue startAgain;
                                            }
                                        }
                                        break;
                                    case 0:
                                        multiplexId = tb.multiplexes(sc);
                                        break;
                                    case 9:
                                        continue startAgain;

                                }

                            }
                    }
                    break;
                case 2:
                    System.out.println("\n**Calling movies function!**");
                    System.out.println("Showing all movies...");
                    int movieChoice = tb.movies();
                    switch (movieChoice) {
                        case 1:
                            // when user select a movie, show available tickets for that movie;
                            // call movieTickets(multiPlexId, movieId)
                            // movieChoice is movie_id
                            // multiplexId is multiplex_id
                            String movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                            // ab yahan pe A1, B2, or F9 aise kuch karke aa raha,

                            switch (movieTicketOption) {
                                case "5":
                                    movieChoice = tb.movies();
                                    break;
                                case "6":
                                    continue startAgain;
                            }
                            break;
                        case 2:
                            // when user select a movie, show available tickets for that movie;
                            // call movieTickets(multiPlexId, movieId)
                            // movieChoice is movie_id
                            // multiplexId is multiplex_id
                            movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                            // ab yahan pe A1, B2, or F9 aise kuch karke aa raha,

                            switch (movieTicketOption) {
                                case "5":
                                    movieChoice = tb.movies();
                                    break;
                                case "6":
                                    continue startAgain;
                            }
                            break;
                        case 3:
                            // when user select a movie, show available tickets for that movie;
                            // call movieTickets(multiPlexId, movieId)
                            // movieChoice is movie_id
                            // multiplexId is multiplex_id
                            movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                            // ab yahan pe A1, B2, or F9 aise kuch karke aa raha,

                            switch (movieTicketOption) {
                                case "5":
                                    movieChoice = tb.movies();
                                    break;
                                case "6":
                                    continue startAgain;
                            }
                            break;
                        case 4:
                            // when user select a movie, show available tickets for that movie;
                            // call movieTickets(multiPlexId, movieId)
                            // movieChoice is movie_id
                            // multiplexId is multiplex_id
                            movieTicketOption = tb.movieTickets(multiplexId, movieChoice);
                            // ab yahan pe A1, B2, or F9 aise kuch karke aa raha,

                            switch (movieTicketOption) {
                                case "5":
                                    movieChoice = tb.movies();
                                    break;
                                case "6":
                                    continue startAgain;
                            }
                            break;

                        case 5:
                            multiplexId = tb.multiplexes(sc);
                        case 6:
                            continue startAgain;
                    }
                    break;
                case 10:
                    System.out.println("\n**Exiting...**");
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong option!");

            }

        }

    }
}
