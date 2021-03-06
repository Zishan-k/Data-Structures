import java.util.*;

public class Ignite139 {

    private static Map<Integer, Integer> getFalseAttendanceInfoFrom(ArrayList<Integer> attendance) {
        Map<Integer, Integer> attendanceVsCount = new HashMap<>();
        Map<Integer, Integer> studentVsProxy = new HashMap<>();
        ArrayList<Integer> studentsWhoMarkedProxy = new ArrayList<>();

        int totalAbsent = 0;
        for (int i : attendance) {
            attendanceVsCount.put(i, (attendanceVsCount.containsKey(i)) ?
                    (attendanceVsCount.get(i) + 1) :
                    1);
        }
        for (int j :
                attendanceVsCount.keySet()) {
            int temp = attendanceVsCount.get(j);
            if (attendanceVsCount.get(j) > 1) {
                studentsWhoMarkedProxy.add(j);
                studentVsProxy.put(j, temp - 1);
                totalAbsent++;
            }
        }
        System.out.println("------------For Attendance: " + attendance + " ---------------------------");
        System.out.println("Actual present students: " + attendanceVsCount.keySet());
        System.out.println("Actual absent students:" + getActualAbsentStudents(attendance));
        System.out.println("Total present students: " + attendanceVsCount.size());
        System.out.println("Total absent students: " + totalAbsent);
        System.out.println("Students who marked proxies of others: " + studentsWhoMarkedProxy + "\n");
        return studentVsProxy;
    }

    private static ArrayList<Integer> getActualAbsentStudents(ArrayList<Integer> attendance) {
        ArrayList<Integer> resultList = new ArrayList<>();
        boolean[] isPresent = new boolean[getMax(attendance) + 1];

        for (int j : attendance) {
            isPresent[j] = true;
        }
        for (int i = 0; i < isPresent.length; i++) {
            if (!isPresent[i] && i != 0)
                resultList.add(i);
        }
        return resultList;
    }

    private static int getMax(ArrayList<Integer> attendance) {
        int max = 0;
        for (int i :
                attendance) {
            if (i > max) max = i;
        }
        return max;
    }

    private static void analyzeAttendanceFor(ArrayList<ArrayList<Integer>> groupedAttendance) {
        Map<Integer, Integer> studentVsProxyCount = new HashMap<>();
        for (ArrayList<Integer> i : groupedAttendance) {
            for (Map.Entry<Integer, Integer> entry : getFalseAttendanceInfoFrom(i).entrySet()) {
                int temp = entry.getKey();
                studentVsProxyCount.put(temp,
                        studentVsProxyCount.get(temp) == null ? entry.getValue() : (studentVsProxyCount.get(temp) + entry.getValue()));
            }
        }

        System.out.println("\n" + "__________________________STUDENTS WHO FILLED MOST PROXY FOR OTHERS________________________________");
        System.out.println("\n" + "(StudentID) : (No. of time they filled proxy attendance(excluding their own attendance))");
        int[] max = new int[2];
        for (Map.Entry<Integer, Integer> entry : studentVsProxyCount.entrySet()) {
            if(entry.getValue() > max[1]){
                max[0] = entry.getKey();
                max[1] = entry.getValue();
            }
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Student with maximum proxies is: " + max[0] + " with " +max[1] + " proxies");
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> groupedAttendance = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(4, 2, 3, 4, 5, 9, 2, 8, 9, 10)),
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 9, 2, 8, 2, 10)),
                        new ArrayList<>(Arrays.asList(3, 2, 3, 4, 10, 9, 2, 8, 9, 10)),
                        new ArrayList<>(Arrays.asList(4, 2, 4, 4, 5, 9, 2, 8, 9, 10)),
                        new ArrayList<>(Arrays.asList(4, 2, 3, 4, 5, 2, 2, 8, 9, 10)),
                        new ArrayList<>(Arrays.asList(4, 2, 3, 4, 5, 2, 2, 4, 9, 4)),
                        new ArrayList<>(Arrays.asList(4, 2, 3, 4, 2, 9, 2, 8, 9, 10)),
                        new ArrayList<>(Arrays.asList(4, 2, 3, 4, 5, 9, 2, 8, 9, 10))
                )
        );
        analyzeAttendanceFor(groupedAttendance);
        //getFalseAttendanceInfoFrom(new ArrayList<>(Arrays.asList(4, 2, 3, 4, 5, 9, 2, 8, 9, 10)));
    }
}
