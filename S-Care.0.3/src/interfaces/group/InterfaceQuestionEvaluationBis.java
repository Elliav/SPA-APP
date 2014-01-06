package interfaces.group;



import java.util.ArrayList;

import controller.Controller;

import questions.QuestionEvaluation;


public class InterfaceQuestionEvaluationBis{

	
	int k=1;
	int nbr=7;

	static boolean fini=false;
	public static int i = -1;
	
	static ArrayList <QuestionEvaluation> ListQuestion;

	public static void setListQuestion()
	{
	ListQuestion=new ArrayList<QuestionEvaluation>();
	ListQuestion=Controller.questionEvaluation;
	}
	
	
	public static QuestionEvaluation setQuestion()
	{
		i=i+1;
		return ListQuestion.get(i);				
	}
	

}
