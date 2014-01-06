package questionnaires;

import java.util.ArrayList;

import questions.QuestionEvaluation;
import utils.MemoryManager;

public class QuestionnaireBASDAI extends Questionnaire{
	
	ArrayList<QuestionEvaluation> questionEvalBASDAI;
	
	
	public QuestionnaireBASDAI(int i, String string,
			ArrayList<QuestionEvaluation> questionEvalBASDAI) {

		this.questionEvalBASDAI = questionEvalBASDAI;
	}
	
	public ArrayList<QuestionEvaluation> getQuestionEvalBASDAI() {
		return questionEvalBASDAI;
	}


	public void setQuestionEvalBASDAI(
			ArrayList<QuestionEvaluation> questionEvalBASDAI) {
		this.questionEvalBASDAI = questionEvalBASDAI;
	}


	public float CalculScore(){
		
		float average1;
		float average2 = 0;
		average1 = (questionEvalBASDAI.get(4).getReponse() + questionEvalBASDAI.get(5).getReponse()) / 2;
		for(int i = 0 ; i < questionEvalBASDAI.size() ; i ++ )
		{	
			if( i != 4 ){				
				if(i != 5){
					average2 += questionEvalBASDAI.get(i).getReponse();
				}
			}
		}		
		this.score = (average2 + average1) / 5;
		MemoryManager.scoreBASDAI = score;

		return this.score ;
	}

}
