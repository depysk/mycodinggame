package bdm2018;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Rocky13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> myNotes = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int friends = sc.nextInt();
        sc.nextLine();

        int bestFriends = sc.nextInt();
        sc.nextLine();

        List<Double> differences = new ArrayList<>();
        Map<Double, Double> friendsLastMovieNotePerDiff = new HashMap<>();

        for(int i = 0; i < friends; i++) {
            String[] rawFriendsNotes = sc.nextLine().split(" ");
            List<Integer> friendNotes = Arrays.stream(rawFriendsNotes)
                    .limit(5)
                    .map(Integer::parseInt)
                    .collect(toList());
            double difference = IntStream.range(0, 5).boxed()
                    .mapToDouble(index -> Math.abs(new Double(myNotes.get(index) - friendNotes.get(index))))
                    .reduce(0.0, Double::sum);
            differences.add(difference);
            friendsLastMovieNotePerDiff.put(difference, Double.parseDouble(rawFriendsNotes[5]));
        }

        double average = differences.stream()
                .sorted()
                .limit(bestFriends)
                .mapToDouble(friendsLastMovieNotePerDiff::get)
                .average().orElseThrow(() -> new IllegalStateException("Erreur"));

        System.out.println(new Double(Math.floor(average)).intValue());

    }
}
