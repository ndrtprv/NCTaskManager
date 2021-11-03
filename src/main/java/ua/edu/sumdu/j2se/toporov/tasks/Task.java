package ua.edu.sumdu.j2se.toporov.tasks;

public class Task {
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        this.active = false;
    }
    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.active = false;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle (String title) {
        this.title = title;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive (boolean active) {
        this.active = active;
    }
    public int getTime () {
        if (interval != 0) {
            return start;
        } else {
            return time;
        }
    }
    public void setTime (int time) {
        this.time = time;
        if (this.interval != 0) {
            this.interval = 0;
        }
    }
    public int getStartTime() {
        if (this.interval == 0) {
            return time;
        } else {
            return start;
        }
    }
    public int getEndTime() {
        if (this.interval == 0) {
            return time;
        } else {
            return end;
        }
    }
    public int getRepeatInterval() {
        if (this.interval == 0) {
            return 0;
        } else {
            return interval;
        }
    }
    public void setTime(int start, int end, int interval) {
        this.start = start;
        this.end = end;
        if (this.interval == 0) {
            this.interval = interval;
        }
    }
    public boolean isRepeated() {
        return this.interval != 0;
    }
    public int nextTimeAfter(int current) {
        if (!active) {
            return -1;
        }
        if (current < time) {
            return time;
        } else if (current < start) {
            return start;
        } else if (current < end - interval) {
            int temp1 = start, temp2 = end;
            do {
                temp1 += interval;
                temp2 -= interval;
            } while (current >= temp1 && current < temp2 - interval);
            if (current < temp1) {
                return temp1;
            } else if (current >= temp2) {
                return temp2;
            }
        }
        return -1;
    }
}