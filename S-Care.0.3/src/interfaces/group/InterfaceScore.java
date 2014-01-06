package interfaces.group;



import com.example.s_care.R;
import controller.Controller;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import questions.QuestionEvaluation;
import utils.Constants;
import utils.MemoryManager;


public class InterfaceScore extends Activity {

	TextView scoreLabel;
	TextView scoreValueLabel;
	int k=1;
	int nbr=7;
	Button buttonContinue;
	int progress_value;
	int progress_value_rest;
	boolean repondu=false;
	static QuestionEvaluation Question;
	int Id;
	//final Context x = this.getBaseContext();

	@Override

	public void onCreate(Bundle savedInstanceState) 
	{


		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_score);  

		TextView scoreLabel=(TextView) findViewById(R.id.scoreLabel);
		TextView scoreValueLabel=(TextView) findViewById(R.id.scoreValueLabel);


		if(MemoryManager.currentQuestionnaire == Constants.QuestionnaireType.BASDAI_TYPE)
		{
			scoreLabel.setText(R.string.score_label_BASDAI);
			scoreValueLabel.setText(String.valueOf(MemoryManager.scoreBASDAI));
		}
		
		else if(MemoryManager.currentQuestionnaire == Constants.QuestionnaireType.BASFI_TYPE)
		{
			scoreLabel.setText(R.string.score_label_BASFI);
			scoreValueLabel.setText(String.valueOf(MemoryManager.scoreBASFI));
		}
			
		buttonContinue = (Button)findViewById(R.id.button_continue);
		
		
		buttonContinue.setOnClickListener(new Button.OnClickListener()
		{
			
			public void onClick(View view) 
			{
	
				if (MemoryManager.currentQuestionnaire == Constants.QuestionnaireType.BASDAI_TYPE)
				{
//					Controller.fillQuestionEvaluationListForBASFI(x);
//			        InterfaceQuestionEvaluationBis.setListQuestion(); 
//					InterfaceQuestionEvaluationBis.i = -1;
					MemoryManager.currentQuestionnaire = Constants.QuestionnaireType.BASFI_TYPE;
					Controller.StartQuestionnaire(getBaseContext());

					Intent intent = new Intent(InterfaceScore.this, InterfaceQuestionEvaluation.class);		            
					startActivity(intent);
					
				}
				
				else if (MemoryManager.currentQuestionnaire == Constants.QuestionnaireType.BASFI_TYPE)
				{				
						Toast.makeText(getBaseContext(), "c'est fini" ,Toast.LENGTH_LONG).show();
						Toast.makeText(getBaseContext(), "Vous allez revenir au BASDAI" ,Toast.LENGTH_LONG).show();
						

						
						MemoryManager.currentQuestionnaire = Constants.QuestionnaireType.BASDAI_TYPE;
						Controller.StartQuestionnaire(getBaseContext());
				
						
						
						Intent intent = new Intent(InterfaceScore.this, InterfaceQuestionEvaluation.class);		            
						startActivity(intent);
				}



//					Controller_SPA.ActionClassementQuestionEvaluation();
					//Toast.makeText(getBaseContext(), "classement fait" ,Toast.LENGTH_LONG).show();

//					Controller_SPA.ActionCalculScoreRADAI5();

					//Toast.makeText(getBaseContext(), "scoreRADAI5 fait" ,Toast.LENGTH_LONG).show();

				else 
				{
					Controller.ActionReponseQuestionEvaluation(Question, progress_value);

					//Toast.makeText(getBaseContext(), "pas fini" ,Toast.LENGTH_LONG).show();

					Intent intent = new Intent(InterfaceScore.this, InterfaceScore.class);		            
					startActivity(intent);	

//					int j=0;
//					while (j<InterfaceQuestionEvaluationBis.ListQuestion.size())
//
//					{
//						if (InterfaceQuestionEvaluationBis.ListQuestion.get(j).getQuestion().equals(text))
//						{InterfaceQuestionEvaluationBis.i=InterfaceQuestionEvaluationBis.ListQuestion.indexOf(InterfaceQuestionEvaluationBis.ListQuestion.get(j));
//						}
//						j=j+1;
//					}             		
				}



			}});

	}
}
