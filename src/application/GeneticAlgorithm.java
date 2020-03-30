package application;
import java.util.ArrayList;


/*|-----------------------------------------------------|
  | This class will evolve the population from one      |
  | generation to the next, using crossing and mutation |
  |-----------------------------------------------------| 
*/
public class GeneticAlgorithm {
	private Data data;
	private ArrayList<Schedule> GeneratedSchedules= new ArrayList<Schedule>();

	public GeneticAlgorithm(Data data) { // create ArrayList that contains Populations of each
																	// generation
		this.data = data;
		
	}

	public Population Crossover(Population population) throws CloneNotSupportedException { // this method will crossover
																							// the Chromosomes inside
																							// the
		// population ,,,,,
		population=population.sortByFitness();
		GeneratedSchedules.add(population.getSchedules().get(0)); // get the Best Fitness , insert it and save it ----
																	// will be printed on GUI

		Schedule cross1 = population.getSchedules().get(0);
		Schedule cross2 = population.getSchedules().get(1); // get the two fittest Chromosomes and CrossOver them
		Schedule newChild = new Schedule(data).initialize();

		// *************************************************************************//
		// The Crossover the 2 and 3 Column from the first and 1,4,5 from the Second in
		// order
		// to build the Schedule of New Child
		/************************
		 * Generate new Child From the 2 fittest Chromosomes - CrossoverOperation
		 ******************/
		for (int i = 0; i < 5; i++) {
			newChild.getChromosome()[i][0] = cross2.getChromosome()[i][0]; // copy first column to new child
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 3; j++) {

				newChild.getChromosome()[i][j] = cross1.getChromosome()[i][j]; // copy 4th and 5th column to new child

			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 3; j < 5; j++) {
				newChild.getChromosome()[i][j] = cross2.getChromosome()[i][j]; // copy 4th and 5th column to new child

			}
		}
		// *************************************************************************//

		newChild.setNumberOfConflicts(); // re-calculate number of Conflicts
		newChild.setFitness(); // re-calculate the fitness

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Schedule Temp = (Schedule) newChild.clone();
		double Diff = mutateSchedule(Temp).getFitness(); // if mutated Schedule have more fitness than itself without
															// mutation -> then take it

		if (newChild.getFitness() < Diff)
			newChild = mutateSchedule(newChild);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (newChild.getFitness() > population.getSchedules().get(2).getFitness()) {

			population.getSchedules().remove(population.getSchedules().get(2)); // remove the worst fitness
			population.getSchedules().add(newChild); // add the new Child
		}
		population = population.sortByFitness(); // sort the new population based on fitness

		return population;
	}

	public ArrayList<Schedule> getGeneratedSchedules() {
		return GeneratedSchedules;
	}

	public Schedule mutateSchedule(Schedule Child) {
		double prevFitness = Child.getFitness(); // saving the Child Fitness


		Discussion[] temp = new Discussion[5];
		temp = Child.getChromosome()[0];
		Child.getChromosome()[0] = Child.getChromosome()[3];
		Child.getChromosome()[3] = temp;

		Discussion tempo;

		for (int i = 0; i < 5; i++) {
			tempo = Child.getChromosome()[i][1];
			Child.getChromosome()[i][1] = Child.getChromosome()[i][4];
			Child.getChromosome()[i][4] = tempo;

			Child.getChromosome()[i][1].setDiscussion_Time(data.getDiscusission_times().get(1));
			Child.getChromosome()[i][4].setDiscussion_Time(data.getDiscusission_times().get(4));

		}

		Child.setNumberOfConflicts();
		Child.setFitness();
		return Child;
	}
}
