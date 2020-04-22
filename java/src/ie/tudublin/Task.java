package ie.tudublin;

import processing.data.TableRow;

public class Task {

    private String Task;
    private Float Start;
    private Float End;

    public Task(String Task, Float Start, Float End)
    {
        this.Task = Task;
        this.Start = Start;
        this.End = End;
    }

    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getFloat("Start"), tr.getFloat("End"));
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public Float getStart() {
        return Start;
    }

    public void setStart(Float start) {
        Start = start;
    }

    public Float getEnd() {
        return End;
    }

    public void setEnd(Float end) {
        End = end;
    }

    @Override
    public String toString() {
        return "Task [End=" + End + ", Start=" + Start + ", Task=" + Task + "]";
    }

    

    




}