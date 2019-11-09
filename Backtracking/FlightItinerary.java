package Backtracking;

import java.util.HashSet;
import java.util.Stack;

/**
 * given a few flights and a starting point - print if you can connect them all together into a journey
 * <p>
 * a Flight is just an object that has a Starting point and an Ending point
 */

/**
 * Dynamic programming tips:
 *
 * Can I construct a mini problem with a solution
 * can I verify if that solution is valid or not
 * Can I say when the full problem is solved
 */

//  in this case:
//  mini problem is just using less flights
//  is_valid would check if I am at an airport that I can't fly off from and there are more flights I have yet to board
//  full problem is solved when I have used all flights
public class FlightItinerary {


    public static void addFlights(String startPoint, HashSet<Flight> flights, Stack<Flight> itinerary) {
        if (flights.isEmpty()) {
            //yey we have made a journey with everything
            return;
        }

        HashSet<Flight> expensiveSolution = new HashSet<>(flights);

        for (Flight i : flights) {
            if (startPoint.equals(i.start)) {
                itinerary.push(i);
                expensiveSolution.remove(i);

                //if valid so far try adding the next flight
                if (isValid(i.end, expensiveSolution)) {
                    addFlights(i.end, expensiveSolution, itinerary);
                } else {

                    itinerary.pop();
                    expensiveSolution.add(i);
                }
            }
        }
    }

    public static boolean isValid(String startPoint, HashSet<Flight> flights) {
        if (flights.isEmpty())
            return true;
        for (Flight i : flights) {
            if (startPoint.equals(i.start)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Flight f1 = new Flight("HNL", "AKL");
        Flight f2 = new Flight("YUL", "ORD");
        Flight f3 = new Flight("ORD", "SFO");
        Flight f4 = new Flight("SFO", "HNL");


        Flight f5 = new Flight("AKL", "ORD");
        Flight f6 = new Flight("ORD", "YUL");

        String startingAirport = "YUL";

        HashSet<Flight> flights = new HashSet<>();
        Stack<Flight> itinerary = new Stack<>();

        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);


        flights.add(f5);
        flights.add(f6);

        addFlights("YUL", flights, itinerary);

        itinerary.stream().forEach(e -> System.out.print(e.start + " -> " + e.end + " "));
    }

    private static class Flight {
        String start;
        String end;

        public Flight(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
