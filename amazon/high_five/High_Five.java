package amazon.high_five;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class High_Five {

    class Record {
        int id, score;

        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here

        Map<Integer, Double> result = new HashMap<>();
        HashMap<Integer, PriorityQueue<Record>> map = new HashMap<>();

        int k = 5;
        for (Record r : results) {
            if (!map.containsKey(r.id)) {
                PriorityQueue<Record> pq = new PriorityQueue<Record>(k, new Comparator<Record>() {
                    public int compare(Record a, Record b) {
                        return a.score - b.score; // min-heap
                    }
                });
                map.put(r.id, pq);
            }
            //不用担心,因为PriorityQueue 会动态的resize大小
            map.get(r.id).add(r);
            if (map.get(r.id).size() > k) {
                map.get(r.id).poll();
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Record>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Record> pq = entry.getValue();
            double average = 0;
            int num = pq.size();
            while (!pq.isEmpty()) {
                average += pq.poll().score;
            }
            average /= num;
            result.put(id, average);
        }

        return result;
    }
}
