package ie.tudublin;

import processing.data.TableRow;

public class Task {

    private String Task;
    private String Start;
    private String End;

    public Task(String Task, String Start, String End)
    {
        this.Task = Task;
        this.Start = Start;
        this.End = End;
    }

    public Task(TableRow tr)
    {
        this(tr.getString(arg0))
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    @Override
    public String toString() {
        return "Task [End=" + End + ", Start=" + Start + ", Task=" + Task + "]";
    }

    

    




}