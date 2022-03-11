package laborator2;

import java.util.Arrays;

public class Solution {
    private Room[] assignment;

    public Solution() {
    }

    public Solution(Room... assignment) {
        this.assignment = assignment;
    }

    public Room[] getAssignment() {
        return assignment;
    }

    public void setAssignment(Room... assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "assignment=" + Arrays.toString(assignment) +
                '}';
    }

    public int computeUsedRooms() {
        int nr = 0;
        for (int i = 0; i < assignment.length - 1; i++)
            for (int j = i + 1; j < assignment.length; j++)
                if (assignment[i] == assignment[j])
                    nr++;
        return assignment.length - 1;


    }
}
