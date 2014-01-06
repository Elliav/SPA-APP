package interfaces.group;



import com.example.s_care.R;

import controller.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import questions.QuestionEvaluation;
import utils.Constants;
import utils.MemoryManager;


public class InterfaceQuestionEvaluation extends Activity {

	TextView textView2;
	TextView textView3;
	int k=1;
	int nbr=7;
	Button button1;
	int progress_value;
	int progress_value_rest;
	boolean repondu=false;
	static QuestionEvaluation Question;
	int Id;

	@Override

	public void onCreate(Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);
		setContentView(R.layout.question_evaluation);  
		progress_value=0;
		progress_value_rest=100;

		TextView textViewI=(TextView) findViewById(R.id.textView5);
		TextView textViewII=(TextView) findViewById(R.id.textView6);
				
		Question=InterfaceQuestionEvaluationBis.setQuestion();
		Id=Question.getID();

		//if (Id==26)
//		if(Id==163)
//		{
//			textViewI.setText(R.string.Eval1I);
//			textViewII.setText(R.string.Eval1II);
//		}
//
//		//else if (Id==25)
//		else if (Id==162)
//		{
//
//			textViewI.setText(R.string.Eval2I);
//			textViewII.setText(R.string.Eval2II);
//		}
//
//		// else if (Id==22)
//		else if (Id==54)
//		{
//
//			textViewI.setText(R.string.Eval3I);
//			textViewII.setText(R.string.Eval3II);
//		}
//
//		//else if (Id==24)
//		else if (Id==55)
//		{
//
//			textViewI.setText(R.string.Eval3I);
//			textViewII.setText(R.string.Eval3II);
//		}
//
//		// else if (Id==27)
//		else if (Id==56)
//		{
//
//			textViewI.setText(R.string.Eval1I);
//			textViewII.setText(R.string.Eval1II);
//		}
//
//		//else if (Id==21)
//		else if (Id==57)
//		{
//
//			textViewI.setText(R.string.Eval4I);
//			textViewII.setText(R.string.Eval4II);
//		}
//
//		//else if (Id==28)
//		else if(Id==58)
//		
//		{
//
//			textViewI.setText(R.string.Eval5I);
//			textViewII.setText(R.string.Eval5II);
//		}
//
//		//else if (Id==23)
//		else if(Id==161)
//		{
//
//			textViewI.setText(R.string.Eval3I);
//			textViewII.setText(R.string.Eval3II);
//		}
//
//		else 
//		{


//		}


		//Toast.makeText(InterfaceQuestionEvaluation.this,  String.valueOf(InterfaceQuestionEvaluationBis.i),Toast.LENGTH_SHORT).show();

		textViewI.setText("0");
		textViewII.setText("100");
		textView3=(TextView) findViewById(R.id.textView3); 
		final SeekBar seekbar1=(SeekBar) findViewById(R.id.seekBar1); 
		final ImageView imageView1=(ImageView) findViewById(R.id.imageView1);

		textView2=(TextView) findViewById(R.id.textView2);
		textView2.setText(Question.getQuestion());
		textView3.setTextSize(18);
		textView3.setText("0");

		/*  if (Question.getID()==25)
        {
        textView3.setTextSize(10);
		textView3.setText("Tr�s bien\n" + "     " + String.valueOf(progress_value_rest));	}

        else{
        textView3.setTextSize(18);
        textView3.setText("0");}

		 */ 

		seekbar1.setMax(100);
		seekbar1.setProgress(0);
		imageView1.setBackgroundResource(R.drawable.aucune1);	

		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
		{

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				if (progress<=33)
				{
					imageView1.setBackgroundResource(R.drawable.aucune1);	
				}
				else if (33<progress & progress<66)
				{
					imageView1.setBackgroundResource(R.drawable.moderee1);	
				}
				else 
				{
					imageView1.setBackgroundResource(R.drawable.forte1);	
				}

				textView3.setTextSize(18);
				textView3.setText(String.valueOf(progress));
				progress_value=progress;

			}


			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

		});

		button1 = (Button)findViewById(R.id.button1);
		final Context x = this.getBaseContext();//??
		button1.setOnClickListener(new Button.OnClickListener()

		{ 	
			public void onClick(View view) {

				//String text;
				//text=textView2.getText().toString(); 	

				if (InterfaceQuestionEvaluationBis.i == InterfaceQuestionEvaluationBis.ListQuestion.size() - 1 )
				{	
					//Toast.makeText(getBaseContext(), "c'est fini" ,Toast.LENGTH_LONG).show();
					Controller.ActionReponseQuestionEvaluation(Question, progress_value);
					InterfaceQuestionEvaluationBis.ListQuestion.get(0);
					
					if(MemoryManager.currentQuestionnaire == Constants.QuestionnaireType.BASDAI_TYPE)
					{
						
						Controller.ActionCalculScoreBASDAI(x);
						Intent intent = new Intent(InterfaceQuestionEvaluation.this, InterfaceScore.class);		            
						startActivity(intent);

					}
					
					else if (MemoryManager.currentQuestionnaire == Constants.QuestionnaireType.BASFI_TYPE)
					{		
						Controller.ActionCalculScoreBASFI(x);
						Intent intent = new Intent(InterfaceQuestionEvaluation.this, InterfaceScore.class);		            
						startActivity(intent);
					}


//					Controller_SPA.ActionClassementQuestionEvaluation();
					//Toast.makeText(getBaseContext(), "classement fait" ,Toast.LENGTH_LONG).show();

//					Controller_SPA.ActionCalculScoreRADAI5();

					//Toast.makeText(getBaseContext(), "scoreRADAI5 fait" ,Toast.LENGTH_LONG).show();

				}

				else 
				{
					Controller.ActionReponseQuestionEvaluation(Question, progress_value);

					//Toast.makeText(getBaseContext(), "pas fini" ,Toast.LENGTH_LONG).show();

					Intent intent = new Intent(InterfaceQuestionEvaluation.this, InterfaceQuestionEvaluation.class);		            
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
