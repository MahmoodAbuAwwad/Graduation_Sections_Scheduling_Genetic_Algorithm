package application;
import java.io.IOException;

public class Driver {
	public static final int NumofEliteSchedules = 1;
	public static final double CrossoverRate = 0.9;
	public static final double MutationRate = 0.1;
	//private Data data;

	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		//Driver driver = new Driver();
		//driver.data = new Data();

		////////////////////////////////
		Data dat = new Data();
		/*
		 * Schedule sch1 = new Schedule(dat).initialize();
		 * 
		 * for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++)
		 * System.out.println(sch1.getChromosome()[i][j].toString());
		 * 
		 * 
		 * 
		 * System.out.println(sch1.toString()); System.out.println("\n\n\n\n"); for (int
		 * i = 0; i < 5; i++) for (int j = 0; j < 5; j++)
		 * System.out.println(sch1.getChromosome()[i][j].getProject().toString());
		 */

		Population pop = new Population(3, dat);
		
		 for (int i = 0; i < pop.getSchedules().size(); i++) {
			 for(int k=0; k<pop.getSchedules().get(i).getChromosome().length ; k++) {
				 for(int l=0; l< pop.getSchedules().get(i).getChromosome().length;l++) {
					 
					
				 }
				
			 }
			
		 }
		 System.out.println(pop.getSchedules().get(0).getChromosome()[0][0].toString());
		/* System.out.println(pop.getSchedules().get(0).getChromosome()[1][0]);
		 System.out.println(pop.getSchedules().get(0).getChromosome()[2][0]);
		 System.out.println(pop.getSchedules().get(0).getChromosome()[3][0]);
		 System.out.println(pop.getSchedules().get(0).getChromosome()[4][0]);
		 System.out.println(pop.getSchedules().get(0).getFitness());
		 System.out.println(pop.getSchedules().get(0).getNumberOfConflicts());
		 System.out.println("*********************************************************************************************");
		 
		 
		GeneticAlgorithm asd = new GeneticAlgorithm(dat, 1);

		pop = asd.Crossover(pop);
		
		asd.get
		System.out.println(pop.getSchedules().get(0).getChromosome()[0][0]);
		 System.out.println(pop.getSchedules().get(0).getChromosome()[1][0]);
		 System.out.println(pop.getSchedules().get(0).getChromosome()[2][0]);
		 System.out.println(pop.getSchedules().get(0).getChromosome()[3][0]);
		 System.out.println(pop.getSchedules().get(0).getChromosome()[4][0]);
		 System.out.println(pop.getSchedules().get(0).getFitness());
		 System.out.println(pop.getSchedules().get(0).getNumberOfConflicts());
		 System.out.println("*********************************************************************************************");
		 
	//	 pop = asd.mutateSchedule(pop);
		 
		
/*
		for (int j = 0; j < pop.getSchedules().size(); j++) {
			System.out.println(pop.getSchedules().get(j).toString());
		}
		System.out.println("\n\n\n");
		pop = asd.Crossover(pop);

		for (int j = 0; j < pop.getSchedules().size(); j++) {
			System.out.println(pop.getSchedules().toString());
			
		}
		System.out.println("\n\n\n");
		*/
	}
}
