package questionnaires;

import java.util.ArrayList;

import questions.QuestionEvaluation;
import utils.MemoryManager;

public class QuestionnaireBASFI extends Questionnaire{

	ArrayList<QuestionEvaluation> questionEvalBASFI;
	
	
	public QuestionnaireBASFI(int i, String string,
			ArrayList<QuestionEvaluation> questionEvalBASFI) {

		this.questionEvalBASFI = questionEvalBASFI;
	}
	
	public ArrayList<QuestionEvaluation> getQuestionEvalBASFI() {
		return questionEvalBASFI;
	}


	public void setQuestionEvalBASDAI(
			ArrayList<QuestionEvaluation> questionEvalBASFI) {
		this.questionEvalBASFI = questionEvalBASFI;
	}


	public float CalculScore(){
		
		float average = 0;
		for(int i = 0 ; i < questionEvalBASFI.size() ; i ++ )
		{	
				average += questionEvalBASFI.get(i).getReponse();
		}		
		this.score = average / questionEvalBASFI.size();
		MemoryManager.scoreBASFI = score;
		return this.score ;
	}

}
