package de.ddm.actors;


import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

public class TaskArray {

    public static class Task {
        String x;
        String y;
        boolean started = false;
        boolean checked = false;
        boolean containsDependency = false;

        public Task(String x, String y) {
            this.x = x;
            this.y = y;
        }

        public void setStarted(boolean value) {
            this.started = value;
        }

        public void setChecked(boolean value) {
            this.checked = value;
        }

        public void setContainsDependency(boolean value) {
            this.containsDependency = value;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ", " + started + ", " + checked + ", " + containsDependency + ")";
        }
    }

    public static Task[] generateTaskArray(Map<String, TreeSet<String>> map) {
        int n = map.keySet().size();
        int arraySize = n * (n - 1); // n * (n - 1) for both orders
        Task[] tasks = new Task[arraySize];

        ArrayList<String> keys = new ArrayList<>(map.keySet());
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < keys.size(); j++) {
                if (i != j) {
                    tasks[index++] = new Task(keys.get(i), keys.get(j));
                }
            }
        }

        return tasks;
    }
}

