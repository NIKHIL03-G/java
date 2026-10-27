
import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private static class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class RouteInfo {
        int totalTime;
        int count;

        RouteInfo() {
            totalTime = 0;
            count = 0;
        }
    }

    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, RouteInfo> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);

        String route = info.station + "->" + stationName;
        int travelTime = t - info.time;

        RouteInfo routeInfo = routes.getOrDefault(route, new RouteInfo());
        routeInfo.totalTime += travelTime;
        routeInfo.count++;

        routes.put(route, routeInfo);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        RouteInfo info = routes.get(route);

        return (double) info.totalTime / info.count;
    }
}
