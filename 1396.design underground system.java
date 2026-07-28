import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores customer check-in information
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stores total travel time and trip count
    class Trip {
        int totalTime;
        int count;

        Trip(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, Trip> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    // Customer checks in
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    // Customer checks out
    public void checkOut(int id, String stationName, int t) {
        CheckIn check = checkInMap.get(id);

        String route = check.station + "->" + stationName;
        int travelTime = t - check.time;

        Trip trip = travelMap.getOrDefault(route, new Trip(0, 0));
        trip.totalTime += travelTime;
        trip.count++;

        travelMap.put(route, trip);

        // Remove customer after checkout
        checkInMap.remove(id);
    }

    // Get average travel time
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Trip trip = travelMap.get(route);

        return (double) trip.totalTime / trip.count;
    }
}

public class Main {
    public static void main(String[] args) {

        UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);

        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // 14.0
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0

        undergroundSystem.checkIn(10, "Leyton", 24);

        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0

        undergroundSystem.checkOut(10, "Waterloo", 38);

        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 12.0
    }
}
