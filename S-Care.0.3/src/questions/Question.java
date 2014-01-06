package questions;



public class Question {
	 
	int id;
	public String question;
	int position;
	String reponse;
	String code=null;	
	public QuestionChoixUnique conditionnalQuestion = null;
	public String Reference;
	
	Question()
	{}
	
	Question(int id)
	{
	this.id=id;}
	
	Question(int id, String question)
	{
	this.id=id;
	this.question=question;}
	
	Question(int id, String question, int position, String code)
	{
		this.code=code;
		this.id=id;
		this.question=question;
		this.position=position;
	}
		
	
	public void setReponseQuestion(String reponse)
	{this.reponse=reponse;}

	
	public String getQuestion()
	{return question;}
	
	
	public int getID()
	{return id;}

	public void setReference (String ref)
	{
		this.Reference = ref;
	}

	public String getReference ()
	{
		return Reference;
	}
}
