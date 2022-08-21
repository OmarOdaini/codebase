import java.util.Arrays;

class MeetingRoomsII {
    public static void main(String[] args){
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(MeetingRoomsArray(intervals));
        
    }

    // Array method
    public static int MeetingRoomsArray(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int requiredRooms = 0;
        int i = 0, j = 0;
        while (i < startTimes.length && j < endTimes.length) {

            // If there is a meeting that has ended by the time this meeting is to start
            if (startTimes[i] >= endTimes[j]) {
                requiredRooms--;
                j++;
            }

            requiredRooms++;
            i++;
        }

        return requiredRooms;
    }
}