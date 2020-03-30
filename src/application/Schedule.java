package application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Schedule implements Cloneable,Comparable<Schedule> {

	ArrayList<String> ProjectNames = new ArrayList<String>();
	private Data data;
	private int numberOfConflicts = 0;
	private double Fitness = -1;
	private Discussion[][] chromosome = new Discussion[5][5];

	public Schedule(Data data) {
		this.data = data;
		// discussions = ArrayList<Discussion>();
	}

	private Data getData() {
		return data;
	}

	public Discussion[][] getChromosome() {
		return chromosome;
	}

	public Schedule initialize() {

		int randomProject, randomRoom, randomTime, first, i = 0;

		while (i < 5) {
			first = 0;
			while (first < 5) { // create a genes and insert it to chromosome at meeting 1
				randomProject = new Random().nextInt(data.getProjects().size());
				randomRoom = new Random().nextInt(data.getRooms().size());
				randomTime = new Random().nextInt(data.getDiscusission_times().size());
				Discussion tempGene = new Discussion(data.getProjects().get(randomProject),
						data.getRooms().get(randomRoom), data.getDiscusission_times().get(randomTime));
				if (tempGene.getDiscussion_Time().getTime()
						.compareTo(data.getDiscusission_times().get(i).getTime()) == 0) {
					chromosome[first][i] = tempGene;
					first++;

				}
			}
			i++;
		}

		for (int k = 0; k < chromosome.length; k++) {
			for (int j = 0; j < chromosome.length; j++) {
				ProjectNames.add(chromosome[k][j].getProject().getProjectName().trim()); // using it inside Calculate
																							// number of conflicts
			}
		}

		setNumberOfConflicts();
		setFitness();

		return this;
	}

	public void setNumberOfConflicts() {
		// calculate numberOfConflicts of The chromosome [row][column]
		numberOfConflicts = 0;
		///////////////////// if Same Project is repeated in Chromosme
		///////////////////// /////////////////////////////////
		for (int i = 0; i < ProjectNames.size(); i++) {
			for (int j = i + 1; j < ProjectNames.size(); j++) {
				if (ProjectNames.get(i).equals(ProjectNames.get(j))) {
					numberOfConflicts++;
				}
			}
		}
		/////////////////////////////////////////////

		for (int i = 0; i < chromosome.length; i++) {
			for (int j = 0; j < chromosome.length - 1; j++) {
				if (chromosome[j][i].getProject().getSupervisor()
						.compareTo(chromosome[j + 1][i].getProject().getSupervisor()) == 0)
					numberOfConflicts++; // if two project with same supervisor at same time is held -> conflicts++
				if (chromosome[j][i].getRoom().getNumber().compareTo(chromosome[j + 1][i].getRoom().getNumber()) == 0)
					numberOfConflicts++; // if two project with same room at same time is held -> conflicts++

				// ***************** if Same Examiners at same time for two Project
				// ********************//

				if (chromosome[j][i].getProject().getExaminers().get(0).getId() == chromosome[j + 1][i].getProject()
						.getExaminers().get(0).getId()
						|| chromosome[j][i].getProject().getExaminers().get(0).getId() == chromosome[j + 1][i]
								.getProject().getExaminers().get(1).getId()
						|| chromosome[j][i].getProject().getExaminers().get(1).getId() == chromosome[j + 1][i]
								.getProject().getExaminers().get(0).getId()
						|| chromosome[j][i].getProject().getExaminers().get(1).getId() == chromosome[j + 1][i]
								.getProject().getExaminers().get(1).getId()) {

					numberOfConflicts++;
				}

				// **************************conflict if any examiner have two consecutively
				// discussions ************************************//
				if (chromosome[i][j].getProject().getExaminers().get(0).getId() == chromosome[i][j + 1].getProject()
						.getExaminers().get(0).getId()
						|| chromosome[i][j].getProject().getExaminers().get(1).getId() == chromosome[i][j + 1]
								.getProject().getExaminers().get(0).getId()
						|| chromosome[i][j].getProject().getExaminers().get(0).getId() == chromosome[i][j + 1]
								.getProject().getExaminers().get(1).getId()
						|| chromosome[i][j].getProject().getExaminers().get(1).getId() == chromosome[i][j + 1]
								.getProject().getExaminers().get(1).getId()) {

					numberOfConflicts++;

				}

			}
		}
	}

	public int getNumberOfConflicts() {
		return numberOfConflicts;
	}

	public double getFitness() {
		return Fitness;
	}

	public void setFitness() {
		Fitness = 1 / (double) (numberOfConflicts + 1);
	}

	/*@Override
	public String toString() {
		return "Schedule [ Number Of Conflicts = " + getNumberOfConflicts() + ", Fitness = " + getFitness() + "]";
	}*/
	
	
	 public Object clone()throws CloneNotSupportedException{  
	        return (Schedule)super.clone();  
	    }
	     

	@Override
	public String toString() {
		return "Schedule [chromosome=" + Arrays.toString(chromosome) + "]";
	}

	@Override
	public int compareTo(Schedule o) {
		// TODO Auto-generated method stub
		if (this.Fitness > o.getFitness())
			return -1;
		else if (this.Fitness < o.getFitness()) // to sort chromosome inside population by fitness
			return +1; // higher fitness --> less num of conflicts

		return 0;
	}

}
