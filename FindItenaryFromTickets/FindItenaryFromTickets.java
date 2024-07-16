package FindItenaryFromTickets;

import java.util.HashMap;

public class FindItenaryFromTickets {

//    start function for the journey
    public static String getStart(HashMap<String,String> tick){
        HashMap<String,String> reverseMap = new HashMap<>();

//        this loop will convert the actaul key value pair into reverse order
//        where I want to convert a value as a key to check the value is different from a key in an actual map

        for(String key : tick.keySet()){
            reverseMap.put(tick.get(key), key);
        }
//        this logic will find a start key,
//         if a key is not found in a reverse key as value then it will false and return a key that will be our start key and if not then return null

        for(String key : tick.keySet()){
            if(!reverseMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }

    public static void main ( String[] args ) {
        HashMap<String, String> tickets = new HashMap <>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        tickets.put("Bengaluru", "Ahmedabad");

        String start = getStart(tickets);

        while(tickets.containsKey(start)){
            System.out.println(start + " ->");
//            System.out.println("->");
            start = tickets.get(start);
        }
        System.out.println(start);
    }
}
