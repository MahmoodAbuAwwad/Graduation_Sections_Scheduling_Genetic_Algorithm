package application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * @author Nataly Ayyad
 */

//|-----------------------------------------------------|
// | This class will represent a population of  schedules |
//-----------------------------------------------------| 

public class Population {
    private ArrayList<Schedule> schedules;
    private int size ;
    private Data data ; 
    

    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Population(int size , Data data) {
        schedules = new ArrayList<Schedule>(size);
        this.data=data;
        this.size=size;
        IntStream.range(0, size).forEach(x -> schedules.add(new Schedule(data).initialize()));  //size usually 3 Chromosome
        sortByFitness();
    }

    public ArrayList<Schedule> getSchedules() {
        return this.schedules;
    }

    public Population sortByFitness() {
     Collections.sort(schedules);  //using Comparable Interface // CompareTo implemented inside Schedule Class
        return this;
    }
}
