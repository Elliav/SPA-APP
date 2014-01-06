package questionnaires;

public class Questionnaire {
	 
	String Nom;
	float score=0;
	String Reference;  

	//ArrayList <Question> listQuestion=new ArrayList<Question>();
	
	Questionnaire()
	{}
	
	Questionnaire(int id,String Nom)
	{
	this.Nom=Nom;

	}

	public float getScore()
	
	{return score;}

	public void setScore(float score)
	
	{
		this.score=score;
	}
	
	public void setReference(String Ref){
		this.Reference=Ref;
	}

}
	