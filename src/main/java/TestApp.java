import java.util.ArrayList;

import org.citizeninn.Opinion;
import org.citizeninn.OpinionPoll;

public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OpinionPoll opinionPoll = new OpinionPoll();
		opinionPoll.setName("What do you think about this new law?");
		opinionPoll.setDescription("This is first pool of opinions for citizen inn");

		Opinion opinion1 = new Opinion();
		opinion1.setName("It is fine");
		opinionPoll.addOpinion(opinion1);
		
		Opinion opinion2 = new Opinion();
		opinion2.setName("Needs to be changed");
		opinionPoll.addOpinion(opinion2);
		
		showOpinionPool(opinionPoll);
		
		
		
	}

	static void showOpinionPool(OpinionPoll pool) {
		System.out.println("SPool name:       " + pool.getName());
		System.out.println("Pool description: " + pool.getDescription());
		
		ArrayList<Opinion> options = pool.getOpinions();
		int opinionCounter = 1;
		for (Opinion opinion : options) {
			System.out.println("Option " + opinionCounter + ": " + opinion.getName());
			opinionCounter++;
		}

	}

}
