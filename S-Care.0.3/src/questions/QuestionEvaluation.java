
package questions;



public class QuestionEvaluation extends Question {
	
	
	int reponse;
	String type;
	
	public QuestionEvaluation(int id, String question, int position, String type)
	{
		super (id, question, position, null);
		this.type=type;
	}

	public void setReponse(int reponse)
	{
		this.reponse=reponse;
	}

	
	public int getReponse()
	{return reponse;}

	public String getType()
	{return type;}
	 
	public int getIDQuestionEvalutation(){
		return id;
	}
	
}
