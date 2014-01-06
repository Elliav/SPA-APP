/*
 * package utils;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Helpers.DBAdapter;
import Helpers.HelperAuthentification;
import Helpers.HelperSendAnswersDS;
import Helpers.HelperSendAnswersFI;
import Helpers.HelperSendAnswersTM;
import Helpers.HelperSendAuthentication;
import Helpers.HelperSendDoctor;
import Helpers.HelperSendDrugs;
import Helpers.HelperSendScores;
import Objets.CapteurDeForce;
import Objets.MedecinTraitant;
import Objets.Medicament;
import Objets.PatientPR;
import Questionnaires.DAS28;
import Questionnaires.Fatigue;
import Questionnaires.HAQ;
import Questionnaires.RADAI5;
import Questionnaires.RAPID3;
import Questionnaires.RAPID4;
import Questionnaires.ThemeHAQ;
import Questions.QuestionChoixMultiples;
import Questions.QuestionChoixUnique;
import Questions.QuestionChoixUniqueScore1;
import Questions.QuestionChoixUniqueScore2;
import Questions.QuestionEvaluation;
import Questions.QuestionLibre;
import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

//import Helpers.HelperAuthentification;


public class ControllerOld extends Activity{

	public static String NoAnswer = "No Answer";
	static DBAdapter dba;
	Context Context ; 
	//static HelperAuthentification helper1= new HelperAuthentification();
	public PatientPR patient1;
	static String Sexe;	
	static int i=0;

	public static int ID;
	static QuestionEvaluation DAS28Question;

	public static String AdresseIp;

	static String scoreCalcul�;; 
	static CapteurDeForce Capteur;

	static ArrayList<QuestionEvaluation> QuestionEvalRAPID3;
	static ArrayList<QuestionEvaluation> QuestionEvalRADAI5;

	static ArrayList <Medicament> listToutMedicamentChoisi;

	static ArrayList<Medicament> ListMedAntalgique;
	static ArrayList<Medicament> ListMedAntiInflammatoire;
	static ArrayList<Medicament> ListMedBiotherapie;
	static ArrayList<Medicament> ListMedTraitementDeFond;
	static ArrayList<Medicament> ListMedSansPrescription;

	static ArrayList <QuestionChoixUnique> ListMedQuestionYN;
	static ArrayList <QuestionChoixMultiples> ListMedQuestionChoixMultiples;

	static ArrayList<Medicament> ListMedAntalgique_D;
	static ArrayList<Medicament> ListMedAntiInflammatoire_D;
	static ArrayList<Medicament> ListMedBiotherapie_D;
	static ArrayList<Medicament> ListMedTraitementDeFond_D;
	static ArrayList<Medicament> ListMedSansPrescription_D;

	static ArrayList <Medicament> ListAntiInflammatoireChoisi_D;
	static ArrayList <Medicament> ListAntiInflammatoireChoisi;

	static ArrayList <Medicament> ListAntalgiqueChoisi_D;
	static ArrayList <Medicament> ListAntalgiqueChoisi;

	static ArrayList <Medicament> ListBiotherapieChoisi_D;
	static ArrayList <Medicament> ListBiotherapieChoisi;

	static ArrayList <Medicament> ListTraitementDeFondChoisi_D;
	static ArrayList <Medicament> ListTraitementDeFondChoisi;

	static ArrayList <Medicament> ListMedSansPrescriptionChoisi;

	static ArrayList <String> YesNo;
	static String AnswersMutipleChoice="";

	static ArrayList<String> Squelette; 
	static ArrayList<String> HAQ;
	public static ArrayList<String> Fatigue;
	public static ArrayList<String> AllQuestionFI;
	public static ArrayList<String> AllQuestionDS;
	public static ArrayList<String> AllQuestionTM;

	static ArrayList<QuestionChoixUniqueScore1> DouleurSquelette; 

	static ArrayList<QuestionChoixUnique> GonflementSquelette;

	static PatientPR patient;

	static ArrayList <QuestionEvaluation> QuestionEvaluation;
	static ArrayList <QuestionChoixUniqueScore2> QuestionFatigue;

	static Fatigue QuestionnaireFatigue;
	static HAQ QuestionnaireHAQ;
	static RADAI5 QuestionnaireRADAI5;
	static RAPID3 QuestionnaireRAPID3;
	static RAPID4 QuestionnaireRAPID4;
	static DAS28 Das28;

	static ArrayList <QuestionChoixUniqueScore1> TabRAPID3;
	static QuestionChoixMultiples QuestionChoixMultipleDS;
	static ArrayList <QuestionChoixUniqueScore1> theme1;
	static ArrayList <QuestionChoixUniqueScore1> theme2;
	static ArrayList <QuestionChoixUniqueScore1> theme3;
	static ArrayList <QuestionChoixUniqueScore1> theme4;
	static ArrayList <QuestionChoixUniqueScore1> theme5;
	static ArrayList <QuestionChoixUniqueScore1> theme6;
	static ArrayList <QuestionChoixUniqueScore1> theme7;
	static ArrayList <QuestionChoixUniqueScore1> theme8;

	static String nomTheme1;
	static String nomTheme2;
	static String nomTheme3;
	static String nomTheme4;
	static String nomTheme5;
	static String nomTheme6;
	static String nomTheme7;
	static String nomTheme8;

	static ThemeHAQ ThemeHAQ1;
	static ThemeHAQ ThemeHAQ2;
	static ThemeHAQ ThemeHAQ3;
	static ThemeHAQ ThemeHAQ4;
	static ThemeHAQ ThemeHAQ5;
	static ThemeHAQ ThemeHAQ6;
	static ThemeHAQ ThemeHAQ7;
	static ThemeHAQ ThemeHAQ8;

	static ArrayList <QuestionChoixUniqueScore1> theme11;
	static ArrayList <QuestionChoixUniqueScore1> theme22;
	static ArrayList <QuestionChoixUniqueScore1> theme33;
	static ArrayList <QuestionChoixUniqueScore1> theme44;
	static ArrayList <QuestionChoixUniqueScore1> theme55;
	static ArrayList <QuestionChoixUniqueScore1> theme66;
	static ArrayList <QuestionChoixUniqueScore1> theme77;
	static ArrayList <QuestionChoixUniqueScore1> theme88;

	static ArrayList <QuestionChoixUnique> C_theme1;
	static ArrayList <QuestionChoixUnique> C_theme2;
	static ArrayList <QuestionChoixUnique> C_theme3;
	static ArrayList <QuestionChoixUnique> C_theme4;
	static ArrayList <QuestionChoixUnique> C_theme5;
	static ArrayList <QuestionChoixUnique> C_theme6;
	static ArrayList <QuestionChoixUnique> C_theme7;
	static ArrayList <QuestionChoixUnique> C_theme8;

	static ArrayList<QuestionChoixUnique> QuestionChoixUniqueFI;
	static ArrayList <String> Gender;
	static ArrayList <String> Activity;
	static ArrayList <String> DoctorActivity;


	static ArrayList<QuestionChoixUnique> QuestionYN_FI;
	static ArrayList<QuestionChoixMultiples> QuestionChoixMultiplesFI;
	static ArrayList<QuestionLibre>  QuestionLibreFI;
	static ArrayList<ArrayList<String>> Question;

	//static QuestionLibre ageMenopause=new QuestionLibre(1);

	static QuestionLibre RappelDTPolio;

	static QuestionLibre RappelGrippe;	

	static QuestionLibre RappelPneumonie;	

	public static MedecinTraitant medecin;

	static QuestionChoixUniqueScore1 DoigtsGauches1;
	static QuestionChoixUniqueScore1 DoigtsDroits1;
	static QuestionChoixUniqueScore1 EpauleGauche1;
	static QuestionChoixUniqueScore1 EpauleDroit1;
	static QuestionChoixUniqueScore1 CoudeGauche1;
	static QuestionChoixUniqueScore1 CoudeDroit1;
	static QuestionChoixUniqueScore1 OrteilsGauches1;
	static QuestionChoixUniqueScore1 OrteilsDroits1;
	static QuestionChoixUniqueScore1 GenouGauche1;
	static QuestionChoixUniqueScore1 GenouDroit1;
	static QuestionChoixUniqueScore1 HancheGauche1;
	static QuestionChoixUniqueScore1 HancheDroit1;
	static QuestionChoixUniqueScore1 PoignetGauche1;
	static QuestionChoixUniqueScore1 PoignetDroit1;
	static QuestionChoixUniqueScore1 ChevilleGauche1;
	static QuestionChoixUniqueScore1 ChevilleDroit1;
	static QuestionChoixUniqueScore1 DoigtDroitD1_1;
	static QuestionChoixUniqueScore1 DoigtDroitD1_2;
	static QuestionChoixUniqueScore1 DoigtDroitD2_1;
	static QuestionChoixUniqueScore1 DoigtDroitD2_2;
	static QuestionChoixUniqueScore1 DoigtDroitD3_1;
	static QuestionChoixUniqueScore1 DoigtDroitD3_2;
	static QuestionChoixUniqueScore1 DoigtDroitD4_1;
	static QuestionChoixUniqueScore1 DoigtDroitD4_2;
	static QuestionChoixUniqueScore1 DoigtDroitD5_1;
	static QuestionChoixUniqueScore1 DoigtDroitD5_2;
	static QuestionChoixUniqueScore1 DoigtGaucheD1_1;
	static QuestionChoixUniqueScore1 DoigtGaucheD1_2;
	static QuestionChoixUniqueScore1 DoigtGaucheD2_1;
	static QuestionChoixUniqueScore1 DoigtGaucheD2_2;
	static QuestionChoixUniqueScore1 DoigtGaucheD3_1;
	static QuestionChoixUniqueScore1 DoigtGaucheD3_2;
	static QuestionChoixUniqueScore1 DoigtGaucheD4_1;
	static QuestionChoixUniqueScore1 DoigtGaucheD4_2;
	static QuestionChoixUniqueScore1 DoigtGaucheD5_1;
	static QuestionChoixUniqueScore1 DoigtGaucheD5_2;


	static QuestionChoixUnique DoigtsGauches2;
	static QuestionChoixUnique DoigtsDroits2;
	static QuestionChoixUnique EpauleGauche2;
	static QuestionChoixUnique EpauleDroit2;
	static QuestionChoixUnique CoudeGauche2;
	static QuestionChoixUnique CoudeDroit2;
	static QuestionChoixUnique OrteilsGauches2;
	static QuestionChoixUnique OrteilsDroits2;
	static QuestionChoixUnique GenouGauche2;
	static QuestionChoixUnique GenouDroit2;
	static QuestionChoixUnique HancheGauche2;
	static QuestionChoixUnique HancheDroit2;
	static QuestionChoixUnique PoignetGauche2;
	static QuestionChoixUnique PoignetDroit2;
	static QuestionChoixUnique ChevilleGauche2;
	static QuestionChoixUnique ChevilleDroit2;
	static QuestionChoixUnique DoigtDroitG1_1;
	static QuestionChoixUnique DoigtDroitG1_2;
	static QuestionChoixUnique DoigtDroitG2_1;
	static QuestionChoixUnique DoigtDroitG2_2;
	static QuestionChoixUnique DoigtDroitG3_1;
	static QuestionChoixUnique DoigtDroitG3_2;
	static QuestionChoixUnique DoigtDroitG4_1;
	static QuestionChoixUnique DoigtDroitG4_2;
	static QuestionChoixUnique DoigtDroitG5_1;
	static QuestionChoixUnique DoigtDroitG5_2;
	static QuestionChoixUnique DoigtGaucheG1_1;
	static QuestionChoixUnique DoigtGaucheG1_2;
	static QuestionChoixUnique DoigtGaucheG2_1;
	static QuestionChoixUnique DoigtGaucheG2_2;
	static QuestionChoixUnique DoigtGaucheG3_1;
	static QuestionChoixUnique DoigtGaucheG3_2;
	static QuestionChoixUnique DoigtGaucheG4_1;
	static QuestionChoixUnique DoigtGaucheG4_2;
	static QuestionChoixUnique DoigtGaucheG5_1;
	static QuestionChoixUnique DoigtGaucheG5_2;
	static ArrayList<String> nomTheme;	

	static ArrayList<ThemeHAQ> ListThemeHAQ;
	static ArrayList<ArrayList<String>> ListQuestionEvaluationYN;

	static ArrayList <QuestionChoixUnique> QuestionGenerale;
	static ArrayList <QuestionChoixUnique> QuestionYN_DAS28;
	static ArrayList <QuestionLibre> QuestionVS_CRP;
	static QuestionEvaluation QuestionEvaluationDas28;

	static boolean QuestionEvaluationFait=false;
	static boolean YNQuestionFait=false;
	static boolean QuestionLibreFait=false;

	static QuestionChoixUniqueScore1 Q = null;
	static QuestionChoixUnique C_Q=null;
	private SQLiteDatabase db;	
	static ArrayList<ArrayList<String>> Questions;


	private static Context mContext;
	static String ref;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
	}

	public static Context getContext(){
		return mContext;
	}
	
	
	
	public static void ActionGetQuestionChoixMultipleDonneDeSuivi (Context mContext) throws JSONException
	{

		DBAdapter dba = new DBAdapter(mContext);
		dba.open();
		ArrayList <String> Answers=new ArrayList<String>();
		ArrayList <String> Question=new ArrayList<String>();
		Question = dba.GetQuestionDS();
		Answers = dba.GetAnswerDS();
		
		if (Question.get(1).equals("19"))
			{
				QuestionChoixMultiples Q2=new QuestionChoixMultiples(Integer.parseInt(Question.get(2)), Question.get(0),Integer.parseInt(Question.get(1)));
				QuestionChoixMultipleDS = Q2;
			}
		
		for (int i = 1; i < Answers.size(); i++) {
			if (Answers.get(i)!=null)
			{QuestionChoixMultipleDS.setReponsePossible(Answers.get(i));}
			}
		}
		
	
public static void ActionGetQuestionFicheInclusion(Context mContext) throws JSONException
	{


		QuestionChoixUniqueFI=new ArrayList <QuestionChoixUnique>();

		QuestionChoixMultiplesFI=new ArrayList <QuestionChoixMultiples>();

		QuestionLibreFI=new ArrayList <QuestionLibre>();

		QuestionYN_FI=new ArrayList<QuestionChoixUnique>();

		Gender=new ArrayList <String>();
		Activity=new ArrayList <String>();
		DoctorActivity=new ArrayList <String>();

		ArrayList <ArrayList<String>> Reponses= new ArrayList<ArrayList<String>>();

		Questions= new ArrayList<ArrayList<String>>();


		DBAdapter dba = new DBAdapter(mContext);
		dba.open();

		
		Gender = dba.GetGender();
		
		Activity=dba.GetQuestionFicheInclusionActivity();
		
		DoctorActivity=dba.GetQuestionFicheInclusionDoctorActivity();
		
		Reponses = new ArrayList<ArrayList<String>>();
		Reponses = dba.GetAnswer();

		Question= new ArrayList<ArrayList<String>>();
		
		Questions=dba.GetQuestionFI();

		QuestionChoixUnique Q1;
		QuestionChoixMultiples Q2;
		QuestionLibre Q3;
		

		ArrayList <String> reponsePossible=new ArrayList<String>();

		for (int i=0; i<Questions.size(); i++)

		{	ArrayList <String> question=new ArrayList<String>();

		question=Questions.get(i);

		
		if (question.get(1).equals("4"))
		{
			
			Q1=new QuestionChoixUnique(Integer.parseInt(question.get(2)), question.get(0), YesNo);
			Q1.setReponse(NoAnswer);
			QuestionYN_FI.add(Q1);

			
		}

		
		else if (question.get(1).equals("1"))
		{	Q1=new QuestionChoixUnique(Integer.parseInt(question.get(1)), question.get(0), reponsePossible);
		Q1.setReponse(NoAnswer);
		QuestionChoixUniqueFI.add(Q1);

		}


		
		else if (question.get(1).equals("13"))
		{

			
			Q2=new QuestionChoixMultiples(Integer.parseInt(question.get(2)), question.get(0),Integer.parseInt(question.get(1)));
			QuestionChoixMultiplesFI.add(Q2);
			//Toast.makeText(mContext, String.valueOf(Q2.getID()), Toast.LENGTH_LONG).show();

		}
		else if (question.get(1).equals("14"))
		{
			Q2=new QuestionChoixMultiples(Integer.parseInt(question.get(2)), question.get(0),Integer.parseInt(question.get(1)));
			QuestionChoixMultiplesFI.add(Q2);


		}
		else if (question.get(1).equals("15"))
		{
			Q2=new QuestionChoixMultiples(Integer.parseInt(question.get(2)), question.get(0),Integer.parseInt(question.get(1)));
			QuestionChoixMultiplesFI.add(Q2);

		}


		else if (question.get(1).equals("10"))
		{
			Q3=new QuestionLibre(Integer.parseInt(question.get(2)), question.get(0));
			Q3.setReponse(NoAnswer);
			QuestionLibreFI.add(Q3);
		}

		}
		ArrayList <String> reponse=new ArrayList<String>();	


		for (int i=0; i<Reponses.size(); i++)

		{	

			reponse=Reponses.get(i);

			int j=0;
			boolean fait=false;

			while ((j<QuestionChoixMultiplesFI.size()) & (fait==false))

			{
				String id=String.valueOf(QuestionChoixMultiplesFI.get(j).getIdAnswer());


				if (reponse.get(0).toString().equals(id.toString()))
				
				{
					if ( id.toString().equals("14") || id.toString().equals("15")){
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(1));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(2));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(3));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(4));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(5));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(6));

						fait=true;

					}
					else 
					{
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(1));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(2));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(3));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(4));
						QuestionChoixMultiplesFI.get(j).setReponsePossible(reponse.get(5));

						fait=true;
					}
				}

				j=j+1;

			}



		}		

		for (int i=0; i<Reponses.size(); i++)

		{		
			reponse=Reponses.get(i);

			int j=0;
			boolean fait=false;

			while ((j<QuestionChoixUniqueFI.size()) & (fait==false))

			{
				String id=String.valueOf(QuestionChoixUniqueFI.get(j).getID());

				if (reponse.get(0).toString().equals(id.toString()))

				{
					QuestionChoixUniqueFI.get(j).setReponsePossible(reponse.get(1));
					fait=true;
				}

				j=j+1;

			}

		}		

	}




	public static void ActionSetReponseDonneeSuivi(Context mContext)

	{	

		DBAdapter dba = new DBAdapter(mContext);
		dba.open();

		Squelette=new ArrayList<String>(); 
		Squelette= dba.GetSkeletonSwollen();
		HAQ=new ArrayList<String>();
		HAQ = dba.GetHAQ();
		Fatigue=new ArrayList<String>();
		Fatigue = dba.GetFatigue();
		YesNo=new ArrayList<String>();
		YesNo= dba.GetYesNo();
	}

	public static void ActionCalculScoreHAQ()
	{
		float scoreHAQ=0;

		ActionCalculScoreThemeHAQ(ThemeHAQ1);
		ActionCalculScoreThemeHAQ(ThemeHAQ2);
		ActionCalculScoreThemeHAQ(ThemeHAQ3);
		ActionCalculScoreThemeHAQ(ThemeHAQ4);
		ActionCalculScoreThemeHAQ(ThemeHAQ5);
		ActionCalculScoreThemeHAQ(ThemeHAQ6);
		ActionCalculScoreThemeHAQ(ThemeHAQ7);
		ActionCalculScoreThemeHAQ(ThemeHAQ8);

		ListThemeHAQ=new ArrayList <ThemeHAQ>();

		ListThemeHAQ.add(ThemeHAQ1);
		ListThemeHAQ.add(ThemeHAQ2);
		ListThemeHAQ.add(ThemeHAQ3);
		ListThemeHAQ.add(ThemeHAQ4);
		ListThemeHAQ.add(ThemeHAQ5);
		ListThemeHAQ.add(ThemeHAQ6);
		ListThemeHAQ.add(ThemeHAQ7);
		ListThemeHAQ.add(ThemeHAQ8);

		QuestionnaireHAQ=new HAQ(1,"HAQ",ListThemeHAQ);

		scoreHAQ=QuestionnaireHAQ.CalculScore();
		QuestionnaireHAQ.setScore(scoreHAQ);

	}

	public static void ActionCalculScoreThemeHAQ(ThemeHAQ theme)

	{

		for (int i=0; i<theme.getListQuestion().size();i++)

		{
			int score=theme.getListQuestion().get(i).CalculScore();
			theme.getListQuestion().get(i).setScore(score);
		}

		int scoreInitialTheme= theme.CalculScoreInitial();
		int scoreFinalTheme=theme.CalculScore(scoreInitialTheme);
		theme.setScore(scoreFinalTheme);

	}

	public static void ActionCalculScoreRAPID3()
	{
		QuestionnaireRAPID3=new RAPID3(1,"RAPID3",TabRAPID3, QuestionEvalRAPID3);
		float score=QuestionnaireRAPID3.CalculScore();
		QuestionnaireRAPID3.setScore(score);
	}


	public static void ActionCalculScoreRAPID4()
	{

		QuestionnaireRAPID4=new RAPID4(1,"RAPID4",TabRAPID3, QuestionEvalRAPID3, DouleurSquelette);
		float score=QuestionnaireRAPID4.CalculScore();
		QuestionnaireRAPID4.setScore(score);

	}


	public static void ActionCalculScoreRADAI5()
	{		
		QuestionnaireRADAI5=new RADAI5(1,"RADAI5", QuestionEvalRADAI5);		
		float score=QuestionnaireRADAI5.CalculScore();	
		QuestionnaireRADAI5.setScore(score);			
	}

	public static void ActionCalculScoreFatigue()
	{
		float score=0;


		for (int i=0; i<QuestionFatigue.size();i++)

		{	
			if (Fatigue.contains(QuestionFatigue.get(i).getReponse())) //.equals(NoAnswer))
			{
				int scoreInitial=QuestionFatigue.get(i).CalculScoreInitial();
				int scoreFinal=QuestionFatigue.get(i).CalculScore(scoreInitial);
				QuestionFatigue.get(i).setScore(scoreFinal);
			}

		}

		QuestionnaireFatigue=new Fatigue(1,"Fatigue",QuestionFatigue);

		score=QuestionnaireFatigue.CalculScore();

		QuestionnaireFatigue.setScore(score);

	}



	public static void ActionCalculDas28()
	{
		float das28_VS=0;
		float das28_CRP=0;


		Das28=new DAS28(2,"das28",InterfaceSquelette2.nbr_gonflement_total, InterfaceSquelette1.nbr_douleur_total,QuestionEvaluationDas28,QuestionVS_CRP.get(0), QuestionVS_CRP.get(1));

		Log.d("vs", QuestionVS_CRP.get(0).getReponse());
		Log.d("crp", QuestionVS_CRP.get(1).getReponse());
		
//		Toast.makeText(mContext, "VS" + , Toast.LENGTH_LONG).show();
//		Toast.makeText(mContext, "CRP" + , Toast.LENGTH_LONG).show();
//		
//		Toast.makeText(getContext(), "sql2" + String.valueOf(InterfaceSquelette2.nbr_gonflement_total), Toast.LENGTH_LONG).show();
//		Toast.makeText(getContext(), "sql1" + String.valueOf(InterfaceSquelette1.nbr_douleur_total), Toast.LENGTH_LONG).show();
//		Toast.makeText(getContext(), "evaldas28" + String.valueOf(QuestionEvaluationDas28.getReponse()), Toast.LENGTH_LONG).show();
//		
		if (!QuestionVS_CRP.get(0).getReponse().equals(NoAnswer))
		{
			das28_VS=DAS28.CalculScore_VS();
			Das28.setScore1(das28_VS);
		}
		else 
		{
			Das28.setScore1(-1);
		}

		if (!QuestionVS_CRP.get(1).getReponse().equals(NoAnswer))
		{
			das28_CRP=DAS28.CalculScore_CRP();
			Das28.setScore2(das28_CRP);	
		}

		else 
		{
			Das28.setScore2(-1);
		}


	}

	

	
	public static ArrayList<QuestionChoixUniqueScore2> ActionGetQuestionnaireFatigue(Context mContext)

	{	
		String code = null;
		ArrayList<ArrayList<String>> ListQuestionFatigue=new ArrayList<ArrayList<String>>();

		QuestionChoixUniqueScore2 Q = null;

		QuestionFatigue= new ArrayList<QuestionChoixUniqueScore2>();
;
		DBAdapter dba = new DBAdapter(mContext);
		dba.open();
		ListQuestionFatigue= dba.GetListQuestionFatigue();

		for (int i=0; i<ListQuestionFatigue.size();i++)
		{
			ArrayList<String> question=new ArrayList<String>();

			question=ListQuestionFatigue.get(i);
			if (question.get(0).equals("1"))
			{
				code ="HI7";
			}
			if (question.get(0).equals("3"))
			{
				code ="HI12";
			}
			if (question.get(0).equals("4"))
			{
				code ="An1";
			}
			if (question.get(0).equals("5"))
			{
				code ="An2";
			}
			if (question.get(0).equals("7"))
			{
				code ="An3";
			}
			if (question.get(0).equals("9"))
			{
				code ="An4";
			}
			if (question.get(0).equals("10"))
			{
				code ="An5";
			}
			if (question.get(0).equals("11"))
			{
				code ="An7";
			}
			if (question.get(0).equals("12"))
			{
				code ="An8";
			}
			if (question.get(0).equals("13"))
			{
				code ="An12";
			}
			if (question.get(0).equals("14"))
			{
				code ="An14";
			}
			if (question.get(0).equals("15"))
			{
				code ="An15";
			}
			if (question.get(0).equals("16"))
			{
				code ="An16";
			}
			Q = new QuestionChoixUniqueScore2(Integer.parseInt(question.get(0)), question.get(1),code,Fatigue);

			Q.setReponse("Sans r�ponse");
			QuestionFatigue.add(Q);

		}

		return QuestionFatigue;

	}




	public static void ActionGetQuestionnaireHAQ(Context mContext)

	{	

		ArrayList<ArrayList<String>> ListQuestionHAQ=new ArrayList<ArrayList<String>>();

		DBAdapter dba = new DBAdapter(mContext);
		dba.open();
		ListQuestionHAQ=dba.GetHAQQuestions();

		C_theme1=new ArrayList <QuestionChoixUnique>();
		C_theme2=new ArrayList <QuestionChoixUnique>();
		C_theme3=new ArrayList <QuestionChoixUnique>();
		C_theme4=new ArrayList <QuestionChoixUnique>();
		C_theme5=new ArrayList <QuestionChoixUnique>();
		C_theme6=new ArrayList <QuestionChoixUnique>();
		C_theme7=new ArrayList <QuestionChoixUnique>();
		C_theme8=new ArrayList <QuestionChoixUnique>();

		theme11=new ArrayList <QuestionChoixUniqueScore1>();
		theme22=new ArrayList <QuestionChoixUniqueScore1>();
		theme33=new ArrayList <QuestionChoixUniqueScore1>();
		theme44=new ArrayList <QuestionChoixUniqueScore1>();
		theme55=new ArrayList <QuestionChoixUniqueScore1>();
		theme66=new ArrayList <QuestionChoixUniqueScore1>();
		theme77=new ArrayList <QuestionChoixUniqueScore1>();
		theme88=new ArrayList <QuestionChoixUniqueScore1>();

		theme1=new ArrayList <QuestionChoixUniqueScore1>();
		theme2=new ArrayList <QuestionChoixUniqueScore1>();
		theme3=new ArrayList <QuestionChoixUniqueScore1>();
		theme4=new ArrayList <QuestionChoixUniqueScore1>();
		theme5=new ArrayList <QuestionChoixUniqueScore1>();
		theme6=new ArrayList <QuestionChoixUniqueScore1>();
		theme7=new ArrayList <QuestionChoixUniqueScore1>();
		theme8=new ArrayList <QuestionChoixUniqueScore1>();

		TabRAPID3= new ArrayList<QuestionChoixUniqueScore1>();

		for (int i=0; i<ListQuestionHAQ.size();i++)
		{

			ArrayList<String> question=new ArrayList<String>();	

			question=ListQuestionHAQ.get(i);

			if((question.get(0).equals("59"))||(question.get(0).equals("60"))||(question.get(0).equals("170")) ||(question.get(0).equals("112")) ||(question.get(0).equals("114")))
			{
				nomTheme1="S'habiller et se pr�parer";
				CreatTheme (question, theme1,theme11, C_theme1);
			}


			else if ((question.get(0).equals ("63")) || (question.get(0).equals ("64")) || (question.get(0).equals ("65")) || (question.get(0).equals ("171")))
			{
				nomTheme2="Manger";
				CreatTheme (question,  theme2, theme22,C_theme2);
			}

	
			else if((question.get(0).equals ("66")) || ((question.get(0).equals ("67"))) || ((question.get(0).equals ("25"))) || ((question.get(0).equals ("135"))) || ((question.get(0).equals ("137"))) || ((question.get(0).equals ("138"))) || ((question.get(0).equals ("139")))|| ((question.get(0).equals ("134"))))
			{
				nomTheme3="Marcher";
				CreatTheme (question, theme3, theme33,C_theme3);
			}

		
			else if ((question.get(0).equals ("21")) || (question.get(0).equals ("69")) || (question.get(0).equals ("174")) || (question.get(0).equals ("141")) || (question.get(0).equals ("142")) || (question.get(0).equals ("143")) || (question.get(0).equals ("144")) || (question.get(0).equals ("140")))
			{
				nomTheme4="Hygi�ne";
				CreatTheme (question, theme4, theme44,C_theme4);
			}

	
			else if ((question.get(0).equals ("71")) || ((question.get(0).equals ("72"))) || ((question.get(0).equals ("146"))) || ((question.get(0).equals ("145"))))
			{
				nomTheme5="Atteindre et attraper un objet";
				CreatTheme (question,theme5, theme55,C_theme5);
			}

			else if ((question.get(0).equals ("61")) || (question.get(0).equals ("62")) || (question.get(0).equals ("172")))
			{
				nomTheme6="Se lever";
				CreatTheme (question, theme6, theme66,C_theme6);
			}


			else if ((question.get(0).equals ("81")) || (question.get(0).equals ("73")) || (question.get(0).equals ("74")) || (question.get(0).equals ("148")) || (question.get(0).equals ("147")))
			{
				nomTheme7="Pr�hension";

				CreatTheme (question,theme7, theme77,C_theme7);
			}

			else if ((question.get(0).equals ("75")) || (question.get(0).equals ("76")) || (question.get(0).equals ("26")) || (question.get(0).equals ("77")) || (question.get(0).equals ("149")))

			{
				nomTheme8="Courses et t�ches m�nag�res ";
				CreatTheme (question,theme8, theme88,C_theme8);
			}

		}


		ThemeHAQ1=new ThemeHAQ (nomTheme1,theme1,C_theme1);
		ThemeHAQ2=new ThemeHAQ (nomTheme2,theme2,C_theme2);
		ThemeHAQ3=new ThemeHAQ (nomTheme3,theme3,C_theme3);
		ThemeHAQ4=new ThemeHAQ (nomTheme4,theme4,C_theme4);
		ThemeHAQ5=new ThemeHAQ (nomTheme5,theme5,C_theme5);
		ThemeHAQ6=new ThemeHAQ (nomTheme6,theme6,C_theme6);
		ThemeHAQ7=new ThemeHAQ (nomTheme7,theme7,C_theme7);
		ThemeHAQ8=new ThemeHAQ (nomTheme8,theme8,C_theme8);

		nomTheme=new ArrayList<String>();

		nomTheme.add(nomTheme1);
		nomTheme.add(nomTheme2);
		nomTheme.add(nomTheme3);
		nomTheme.add(nomTheme4);
		nomTheme.add(nomTheme5);
		nomTheme.add(nomTheme6);
		nomTheme.add(nomTheme7);
		nomTheme.add(nomTheme8);


	}


	public static void CreatTheme (ArrayList <String> question, ArrayList <QuestionChoixUniqueScore1> theme, ArrayList <QuestionChoixUniqueScore1> themeBis, ArrayList <QuestionChoixUnique> C_theme)

	{		

		if((question.get(0).equals("59")) || (question.get(0).equals("60")) || (question.get(0).equals("63")) || (question.get(0).equals("64")) || (question.get(0).equals("65")) || (question.get(0).equals("66")) || (question.get(0).equals("67"))  || (question.get(0).equals("21")) || (question.get(0).equals("69")) || (question.get(0).equals("174")) || (question.get(0).equals("71")) || (question.get(0).equals("72")) || (question.get(0).equals("61")) || (question.get(0).equals("62")) || (question.get(0).equals("81")) || (question.get(0).equals("73")) || (question.get(0).equals("23")) || (question.get(0).equals("75")) || (question.get(0).equals("76")) || (question.get(0).equals("77")) || (question.get(0).equals("74")))
		{
			Q = new QuestionChoixUniqueScore1(Integer.parseInt(question.get(0)), question.get(1),HAQ);
			Q.setReponse(HAQ.get(0));
			int score=Q.CalculScore();
			Q.setScore(score);

			theme.add(Q);
			themeBis.add(Q);

			if ((question.get(0).equals("59")) || (question.get(0).equals("64")) || (question.get(0).equals("66")) || (question.get(0).equals("21")) || (question.get(0).equals("72")) || (question.get(0).equals("62")) || (question.get(0).equals("74")) || (question.get(0).equals("76")))
			{

				TabRAPID3.add(Q);
			}

		}

		else if ((question.get(0).equals("25")) || (question.get(0).equals("26")))
		{
			Q = new QuestionChoixUniqueScore1(Integer.parseInt(question.get(0)), question.get(1),HAQ);
			Q.setReponse(HAQ.get(0));
			int score=Q.CalculScore();
			Q.setScore(score);

			TabRAPID3.add(Q);	
			themeBis.add(Q);

		}

		else if ((question.get(0).equals("170")) || (question.get(0).equals("112")) || (question.get(0).equals("171")) || (question.get(0).equals("135")) || (question.get(0).equals("137")) || (question.get(0).equals("138")) || (question.get(0).equals("139")) || (question.get(0).equals("134")) || (question.get(0).equals("141")) || (question.get(0).equals("142")) || (question.get(0).equals("143")) || (question.get(0).equals("144")) || (question.get(0).equals("140")) || (question.get(0).equals("145")) || (question.get(0).equals("146")) || (question.get(0).equals("172")) || (question.get(0).equals("148")) || (question.get(0).equals("147")) || (question.get(0).equals("149")) || (question.get(0).equals("114")))
		{
			C_Q=new QuestionChoixUnique(Integer.parseInt(question.get(0)),question.get(1),YesNo);
			C_Q.setReponse(YesNo.get(1));
			C_theme.add(C_Q);
		}

	}






	public static void ActionSetReponseFatigue(QuestionChoixUniqueScore2 question, String Reponse)

	{	
		int i=0;

		while (i<QuestionFatigue.size())
		{
			if (QuestionFatigue.get(i).getID()==question.getID())
			{
				QuestionFatigue.get(i).setReponse(Reponse);
			}

			i=i+1;
		}
	}


	public static void ActionSetReponseHAQ(String theme, QuestionChoixUniqueScore1 question, String Reponse)

	{	
		int i=0;

		if (theme=="1")
		{
			while (i<theme11.size())
			{
				if (theme11.get(i).getID()==question.getID())
				{
					theme11.get(i).setReponse(Reponse);
				}

				i=i+1;
			}


		}

		else if (theme=="2")
		{
			while (i<theme22.size())
			{
				if (theme22.get(i).getID()==question.getID())
				{
					theme22.get(i).setReponse(Reponse);
				}

				i=i+1;
			}


		}



		else if (theme=="3")
		{
			while (i<theme33.size())
			{
				if (theme33.get(i).getID()==question.getID())
				{
					theme33.get(i).setReponse(Reponse);
				}

				i=i+1;
			}


		}


		else if (theme=="4")
		{
			while (i<theme44.size())
			{
				if (theme44.get(i).getID()==question.getID())
				{
					theme44.get(i).setReponse(Reponse);
				}

				i=i+1;
			}


		}

		else if (theme=="5")
		{
			while (i<theme55.size())
			{
				if (theme55.get(i).getID()==question.getID())
				{
					theme55.get(i).setReponse(Reponse);
				}

				i=i+1;
			}


		}

		else if (theme=="6")
		{
			while (i<theme66.size())
			{
				if (theme66.get(i).getID()==question.getID())
				{
					theme66.get(i).setReponse(Reponse);
				}

				i=i+1;
			}


		}

		else if (theme=="7")
		{
			while (i<theme77.size())
			{
				if (theme77.get(i).getID()==question.getID())
				{
					theme77.get(i).setReponse(Reponse);
				}

				i=i+1;
			}


		}

		else if (theme=="8")
		{
			while (i<theme88.size())
			{
				if (theme88.get(i).getID()==question.getID())
				{
					theme88.get(i).setReponse(Reponse);
				}

				i=i+1;
			}


		}

	}

	
	public static String ActionAuthentification(String Identifiant, String MotDePasse) throws JSONException
	{
		
		HelperSendAuthentication authentication = new HelperSendAuthentication();
		String ServerResponse = authentication.SendAuthentication(mContext, Identifiant, MotDePasse);
		
		return ServerResponse;
	}
	
	
	
	public boolean Login(String username, String password) throws SQLException 
	{
		Cursor mCursor = db.rawQuery("SELECT * FROM " + "Patient" + " WHERE Login=? AND Password=?", new String[]{username,password});
		if (mCursor != null) {           
			if(mCursor.getCount() > 0)
			{
				return true;
			}
		}
		return false;
	}



	public static void ActionQuestionEvaluationYN(Context mContext)

	{	

		QuestionEvaluation Q = null;
		QuestionChoixUnique Q1=null;
		QuestionLibre Q2=null;

		QuestionYN_DAS28=new ArrayList <QuestionChoixUnique>();

		QuestionGenerale=new ArrayList <QuestionChoixUnique>();

		QuestionEvaluation=new ArrayList <QuestionEvaluation>();

		ListQuestionEvaluationYN=new ArrayList<ArrayList<String>>();

		QuestionVS_CRP=new ArrayList <QuestionLibre>();;

		DBAdapter dba = new DBAdapter(mContext);
		dba.open();
		ListQuestionEvaluationYN=dba.GetListQuestionEvaluationYN();
		for (int i=0; i<ListQuestionEvaluationYN.size();i++)
		{
			ArrayList<String> question=new ArrayList<String>();	

			question=ListQuestionEvaluationYN.get(i);

			if(question.get(0).equals("166") || question.get(0).equals("167"))
			{
				Q1 = new QuestionChoixUnique (Integer.parseInt(question.get(0)), question.get(1), YesNo);
				Q1.setReponse(YesNo.get(1));
				QuestionYN_DAS28.add(Q1);
			}

			else if(question.get(0).equals("164") || question.get(0).equals("165"))
			{
				Q1 = new QuestionChoixUnique (Integer.parseInt(question.get(0)), question.get(1), YesNo);
				Q1.setReponse(YesNo.get(1));
				QuestionGenerale.add(Q1);
			}

			else if(question.get(0).equals("168") || question.get(0).equals("169"))
			{
				Q2 = new QuestionLibre (Integer.parseInt(question.get(0)), question.get(1));
				Q2.setReponse(NoAnswer);
				QuestionVS_CRP.add(Q2);
			}
			else if (question.get(0).equals("161"))
			{
				Q = new QuestionEvaluation (Integer.parseInt(question.get(0)), question.get(1), Integer.parseInt(question.get(2)), question.get(3).toString());
				Q.setReponse(0);
				QuestionEvaluationDas28=Q;
			}

			else
			{
				Q = new QuestionEvaluation (Integer.parseInt(question.get(0)), question.get(1), Integer.parseInt(question.get(2)), question.get(3).toString());
				Q.setReponse(0);
				QuestionEvaluation.add(Q);
			}

		}


		QuestionEvaluation.add(QuestionEvaluationDas28);		

		QuestionVS_CRP.get(0).conditionnalQuestion = QuestionYN_DAS28.get(0);		

		QuestionVS_CRP.get(1).conditionnalQuestion = QuestionYN_DAS28.get(1);



	}






	public static void ActionReponseQuestionEvaluation(QuestionEvaluation question, int Reponse)

	{

		question.setReponse(Reponse);

	}

	public static void ActionReponseQuestionLibre(QuestionLibre question, String Reponse)

	{		
		question.setReponse(Reponse);	
	}



	public static void ActionReponseYNQuestion(QuestionChoixUnique question, String Reponse)

	{		
		question.setReponse(Reponse);	
	}


	public static void ActionReponseQuestionChoixMultiples(QuestionChoixMultiples question, ArrayList <String> Reponse)

	{
		question.setReponse(Reponse);

	}



	public static void ActionClassementQuestionEvaluation()

	{
		int i=0;

		QuestionEvalRAPID3=new ArrayList <QuestionEvaluation>();

		QuestionEvalRADAI5=new ArrayList <QuestionEvaluation>();

		while (i<QuestionEvaluation.size())
		{
		

			if ((QuestionEvaluation.get(i).getIDQuestionEvalutation()==54)||(QuestionEvaluation.get(i).getIDQuestionEvalutation()==55)||(QuestionEvaluation.get(i).getIDQuestionEvalutation()==56)||(QuestionEvaluation.get(i).getIDQuestionEvalutation()==57)||(QuestionEvaluation.get(i).getIDQuestionEvalutation()==58))
			{QuestionEvalRADAI5.add(QuestionEvaluation.get(i));}

			if ((QuestionEvaluation.get(i).getIDQuestionEvalutation()==162)||(QuestionEvaluation.get(i).getIDQuestionEvalutation()==163))
			{QuestionEvalRAPID3.add(QuestionEvaluation.get(i));}

			i=i+1;
		}

	}




	public static void ActionAntiInflammatoireChoisi (ArrayList<String> AntiInflammatoireChoisi)

	{	
		int k;		
		boolean exist;		

		int j;		
		boolean exist1;	

		for (int i=0; i<AntiInflammatoireChoisi.size();i++)	
		{
			exist=false;
			k=0;

			j=0;
			exist1=false;

			if (ListMedAntiInflammatoire_D.size()!=0)
			{
				while ((k<ListMedAntiInflammatoire_D.size()) & (exist==false))				


				{
					String nomMedicament=ListMedAntiInflammatoire_D.get(k).getNom().toString();

					if (nomMedicament.equals(AntiInflammatoireChoisi.get(i).toString()))
					{
						exist=true;

						ListAntiInflammatoireChoisi_D.add(ListMedAntiInflammatoire_D.get(k));
					}	
					k=k+1;
				}
			}

			if (ListMedAntiInflammatoire.size()!=0)
			{

				while ((j<ListMedAntiInflammatoire.size()) & (exist1==false))				
				{
					String nomMedicament=ListMedAntiInflammatoire.get(j).getNom().toString();

					if (nomMedicament.equals(AntiInflammatoireChoisi.get(i).toString()))
					{
						exist1=true;

						ListAntiInflammatoireChoisi.add(ListMedAntiInflammatoire.get(j));
					}	
					j=j+1;
				}
			}
		}


	}


	public static void ActionAntalgiqueChoisi (ArrayList<String> AntalgiqueChoisi)

	{	
		int k;		
		boolean exist;		

		int j;		
		boolean exist1;	


		for (int i=0; i<AntalgiqueChoisi.size();i++)	
		{
			exist=false;
			k=0;

			j=0;
			exist1=false;

			if (ListMedAntalgique_D.size()!=0)
			{while ((k<ListMedAntalgique_D.size()) & (exist==false))				
			{
				String nomMedicament=ListMedAntalgique_D.get(k).getNom().toString();

				if (nomMedicament.equals(AntalgiqueChoisi.get(i).toString()))
				{
					exist=true;

					ListAntalgiqueChoisi_D.add(ListMedAntalgique_D.get(k));
				}	
				k=k+1;
			}
			}

			if (ListMedAntalgique.size()!=0)

			{

				while ((j<ListMedAntalgique.size()) & (exist1==false))				
				{
					String nomMedicament=ListMedAntalgique.get(j).getNom().toString();

					if (nomMedicament.equals(AntalgiqueChoisi.get(i).toString()))
					{
						exist1=true;
						ListAntalgiqueChoisi.add(ListMedAntalgique.get(j));
					}	
					j=j+1;
				}
			}
		}


	}



	public static void ActionBiotherapieChoisi (ArrayList<String> BiotherapieChoisi)	
	{	

		int k;		
		boolean exist;		

		int j;		
		boolean exist1;	


		for (int i=0; i<BiotherapieChoisi.size();i++)	
		{
			exist=false;
			k=0;

			if (ListMedBiotherapie_D.size()!=0)
			{
				while ((k<ListMedBiotherapie_D.size()) & (exist==false))				
				{
					String nomMedicament=ListMedBiotherapie_D.get(k).getNom().toString();

					if (nomMedicament.equals(BiotherapieChoisi.get(i).toString()))
					{
						exist=true;

						ListBiotherapieChoisi_D.add(ListMedBiotherapie_D.get(k));
					}	
					k=k+1;
				}
			}


			j=0;
			exist1=false;

			if (ListMedBiotherapie.size()!=0)
			{

				while ((j<ListMedBiotherapie.size()) & (exist1==false))				
				{
					String nomMedicament=ListMedBiotherapie.get(j).getNom().toString();

					if (nomMedicament.equals(BiotherapieChoisi.get(i).toString()))
					{
						exist1=true;

						ListBiotherapieChoisi.add(ListMedBiotherapie.get(j));
					}	
					j=j+1;
				}

			}
		}


	}







	public static void ActionTraitementDeFondChoisi (ArrayList<String> TraitementDeFondChoisi)

	{	
		int k;		
		boolean exist;		

		int j;		
		boolean exist1;	


		for (int i=0; i<TraitementDeFondChoisi.size();i++)	
		{
			exist=false;
			k=0;

			j=0;
			exist1=false;

			if (ListMedTraitementDeFond_D.size()!=0)
			{while ((k<ListMedTraitementDeFond_D.size()) & (exist==false))				
			{
				String nomMedicament=ListMedTraitementDeFond_D.get(k).getNom().toString();

				if (nomMedicament.equals(TraitementDeFondChoisi.get(i).toString()))
				{
					exist=true;

					ListTraitementDeFondChoisi_D.add(ListMedTraitementDeFond_D.get(k));
				}	
				k=k+1;
			}}

			if (ListMedTraitementDeFond.size()!=0)

			{while ((j<ListMedTraitementDeFond.size()) & (exist1==false))				
			{
				String nomMedicament=ListMedTraitementDeFond.get(j).getNom().toString();

				if (nomMedicament.equals(TraitementDeFondChoisi.get(i).toString()))
				{
					exist1=true;

					ListTraitementDeFondChoisi.add(ListMedTraitementDeFond.get(j));
				}	
				j=j+1;
			}
			}
		}

	}




	public static void ActionMedSansPrescriptionChoisi (ArrayList<String> MedSansPrescriptionChoisi)

	{		

		int j;		
		boolean exist1;	

		ListMedSansPrescriptionChoisi = new ArrayList <Medicament>();

		for (int i=0; i<MedSansPrescriptionChoisi.size();i++)	
		{

			j=0;
			exist1=false;

			if (ListMedSansPrescription.size()!=0)
			{while ((j<ListMedSansPrescription.size()) || (exist1==false))				
			{
				String nomMedicament=ListMedSansPrescription.get(j).getNom().toString();

				if (nomMedicament.equals(MedSansPrescriptionChoisi.get(i).toString()))
				{
					exist1=true;

					ListMedSansPrescriptionChoisi.add(ListMedSansPrescription.get(j));
				}	
				j=j+1;
			}
			}

		}

	}

	public static void setDoseFrequenceMedChoisi (Medicament med, String reponseDose, String reponseFrequence)
	{
		med.setReponseDose(reponseDose);
		med.setReponseFrequence(reponseFrequence);
	}


	public static Medicament GetMedicamentChoisi (String nom_medicament, String type_medicament)

	{
		Medicament medicament=null;

		if (type_medicament.toString().equals("TDF"))
		{
			int i=0;
			boolean exist=false;

			while ((i<ListTraitementDeFondChoisi_D.size()) & (exist==false))
			{

				if (nom_medicament.equals(ListTraitementDeFondChoisi_D.get(i).getNom().toString()))
				{
					medicament=ListTraitementDeFondChoisi_D.get(i);
					exist=true;
				}
				i=i+1;
			}

			int j=0;
			boolean exist1=false;

			while ((j<ListTraitementDeFondChoisi.size()) & (exist1==false))
			{

				if (nom_medicament.equals(ListTraitementDeFondChoisi.get(j).getNom().toString()))
				{
					medicament=ListTraitementDeFondChoisi.get(j);
					exist=true;
				}
				j=j+1;
			}


		}

		else if (type_medicament.toString().equals("ANTAL"))
		{

			int i=0;
			boolean exist=false;

			while ((i<ListAntalgiqueChoisi_D.size()) & (exist==false))
			{

				if (nom_medicament.equals(ListAntalgiqueChoisi_D.get(i).getNom().toString()))
				{
					medicament=ListAntalgiqueChoisi_D.get(i);
					exist=true;
				}
				i=i+1;
			}

			int j=0;
			boolean exist1=false;

			while ((j<ListAntalgiqueChoisi.size()) & (exist1==false))
			{

				if (nom_medicament.equals(ListAntalgiqueChoisi.get(j).getNom().toString()))
				{
					medicament=ListAntalgiqueChoisi.get(j);
					exist=true;
				}
				j=j+1;
			}
		}

		else if (type_medicament.toString().equals("ANTI"))
		{


			int i=0;
			boolean exist=false;

			while ((i<ListAntiInflammatoireChoisi_D.size()) & (exist==false))
			{

				if (nom_medicament.equals(ListAntiInflammatoireChoisi_D.get(i).getNom().toString()))
				{
					medicament=ListAntiInflammatoireChoisi_D.get(i);
					exist=true;
				}
				i=i+1;
			}

			int j=0;
			boolean exist1=false;

			while ((j<ListAntiInflammatoireChoisi.size()) & (exist1==false))
			{

				if (nom_medicament.equals(ListAntiInflammatoireChoisi.get(j).getNom().toString()))
				{
					medicament=ListAntiInflammatoireChoisi.get(j);
					exist=true;
				}
				j=j+1;
			}
		}
		else if (type_medicament.toString().equals("BIO"))
		{
			int i=0;
			boolean exist=false;

			while ((i<ListBiotherapieChoisi_D.size()) & (exist==false))
			{

				if (nom_medicament.equals(ListBiotherapieChoisi_D.get(i).getNom().toString()))
				{
					medicament=ListBiotherapieChoisi_D.get(i);
					exist=true;
				}
				i=i+1;
			}

			int j=0;
			boolean exist1=false;

			while ((j<ListBiotherapieChoisi.size()) & (exist1==false))
			{

				if (nom_medicament.equals(ListBiotherapieChoisi.get(j).getNom().toString()))
				{
					medicament=ListBiotherapieChoisi.get(j);
					exist=true;
				}
				j=j+1;
			}
		}


		return medicament;
	}



	public static ArrayList<QuestionChoixUniqueScore2> ActionFatigue ()

	{	ArrayList <QuestionChoixUniqueScore2> listquestionFatigue = new ArrayList <QuestionChoixUniqueScore2>();

	return listquestionFatigue;

	}


	public static void ActionGetListMedicament(Context mContext)
	{
		DBAdapter dba = new DBAdapter(mContext);
		dba.open();

		ArrayList <ArrayList<String>> List_Freq_Dose=new ArrayList <ArrayList<String>>();
		ArrayList <ArrayList<String>> ListAntalgique=new ArrayList <ArrayList<String>>();
		ArrayList <ArrayList<String>> ListAntiInflammatoire=new ArrayList <ArrayList<String>>();
		ArrayList <ArrayList<String>> ListBiotherapie=new ArrayList <ArrayList<String>>();
		ArrayList <ArrayList<String>> ListTraitementDeFond=new ArrayList <ArrayList<String>>();	
		ArrayList <ArrayList<String>> ListSansPrescription=new ArrayList <ArrayList<String>>();
		ArrayList <ArrayList<String>> ListQuestion_M=new ArrayList <ArrayList<String>>();
		ArrayList <ArrayList<String>> ListQuestionEvaluationYN=new ArrayList <ArrayList<String>>();
		ListQuestionEvaluationYN= dba.GetListQuestionEvaluationYN();
		ArrayList <ArrayList<String>> HAQQuestions=new ArrayList <ArrayList<String>>();
		HAQQuestions=dba.GetHAQQuestions();

		ListAntiInflammatoire=dba.GetAntiInflammatoryList();

		ListAntalgique=dba.GetanalgesicList();

		ListBiotherapie=dba.GetBiotherapyList();

		ListTraitementDeFond=dba.GetDMARDList();

		ListSansPrescription=dba.GetOCList();

		List_Freq_Dose=dba.GetDrugFreqOrDosesList();

		ListQuestion_M=dba.GetListQuestion_M();

		ListMedAntiInflammatoire_D=new ArrayList<Medicament>();
		ListMedAntiInflammatoire=new ArrayList<Medicament>();

		ListMedAntalgique=new ArrayList<Medicament>();
		ListMedAntalgique_D=new ArrayList<Medicament>();

		ListMedBiotherapie_D=new ArrayList<Medicament>();
		ListMedBiotherapie=new ArrayList<Medicament>();

		ListMedTraitementDeFond=new ArrayList<Medicament>();
		ListMedTraitementDeFond_D=new ArrayList<Medicament>();

		ListMedSansPrescription_D=new ArrayList<Medicament>();
		ListMedSansPrescription=new ArrayList<Medicament>();

		ListMedQuestionYN=new ArrayList<QuestionChoixUnique>();
		ListMedQuestionChoixMultiples=new ArrayList<QuestionChoixMultiples>();

		Medicament med;

		ArrayList<String> medicament;
		ArrayList<String> question;

		QuestionChoixUnique questionYN;
		QuestionChoixMultiples questionChoixMultiples;

		for (int i=0; i<ListSansPrescription.size(); i++)

		{	
			medicament=ListSansPrescription.get(i);

			

			med=new Medicament(Integer.parseInt(medicament.get(0).toString()), medicament.get(3).toString(),String.valueOf(medicament.get(2)));
			ListMedSansPrescription.add(med);

		}

		for (int i=0; i<ListAntiInflammatoire.size(); i++)

		{	
			ArrayList <String> DosePossible=new ArrayList<String>();
			ArrayList <String> FrequencePossible=new ArrayList<String>();

			medicament=ListAntiInflammatoire.get(i);

			med=new Medicament(Integer.parseInt(medicament.get(0).toString()), medicament.get(3).toString(), String.valueOf(medicament.get(2)), DosePossible, FrequencePossible);
			//med.setReponseFrequence(Fatigue.get(0).toString());
			med.setReponseFrequence(NoAnswer);
			//med.setReponseDose(Fatigue.get(0).toString());
			med.setReponseDose(NoAnswer);
			ListMedAntiInflammatoire_D.add(med);

		

		}

		for (int i=0; i<ListAntalgique.size(); i++)

		{	
			medicament=ListAntalgique.get(i);
			ArrayList <String> DosePossible=new ArrayList<String>();
			ArrayList <String> FrequencePossible=new ArrayList<String>();

			med=new Medicament(Integer.parseInt(medicament.get(0).toString()), medicament.get(3).toString(), String.valueOf(medicament.get(2)), DosePossible, FrequencePossible);
			//med.setReponseFrequence(Fatigue.get(0).toString());
			med.setReponseFrequence(NoAnswer);
			//med.setReponseDose(Fatigue.get(0).toString());
			med.setReponseDose(NoAnswer);
			ListMedAntalgique_D.add(med);
		

		}



		for (int i=0; i<ListQuestion_M.size(); i++)
		{
			question=ListQuestion_M.get(i);

		
			if ((question.get(0).equals("159")) || (question.get(0).equals("89")))
			{
				
				questionYN=new QuestionChoixUnique (Integer.parseInt(question.get(0).toString()), question.get(1).toString(), YesNo);
				ListMedQuestionYN.add(questionYN);
			}

		
			if (Integer.parseInt(question.get(0).toString())==90)
			{
				ArrayList <String> Reponse=new ArrayList <String>();

				for (int j=0; j<ListMedSansPrescription.size();j++)
				{
					Reponse.add(ListMedSansPrescription.get(j).getNom().toString());
				}

			
				questionChoixMultiples=new QuestionChoixMultiples (Integer.parseInt(question.get(0).toString()), question.get(1).toString(), Reponse);
				ListMedQuestionChoixMultiples.add(questionChoixMultiples);

			}

			
			if (Integer.parseInt(question.get(0).toString())==160)
			{	

				
				questionChoixMultiples=new QuestionChoixMultiples (Integer.parseInt(question.get(0).toString()), question.get(1).toString(),dba.GetAnswerDrug());
				ListMedQuestionChoixMultiples.add(questionChoixMultiples);
			}}



		for (int i=0; i<ListBiotherapie.size(); i++)
		{	
			medicament=ListBiotherapie.get(i);

			ArrayList <String> DosePossible=new ArrayList<String>();
			ArrayList <String> FrequencePossible=new ArrayList<String>();


			
			if ((Integer.parseInt(medicament.get(0).toString()) == 13 )||(Integer.parseInt(medicament.get(0).toString())==17))

			{
				med=new Medicament(Integer.parseInt(medicament.get(0).toString()), medicament.get(3).toString(), medicament.get(2).toString(), DosePossible, FrequencePossible);
//				med.setReponseFrequence(Fatigue.get(0).toString());
//				med.setReponseDose(Fatigue.get(0).toString());
				med.setReponseFrequence(NoAnswer);
				med.setReponseDose(NoAnswer);
				ListMedBiotherapie.add(med);
			}
				
			else 
			{		
				med=new Medicament(Integer.parseInt(medicament.get(0).toString()), medicament.get(3).toString(), medicament.get(2).toString(), DosePossible, FrequencePossible);
//				med.setReponseFrequence(Fatigue.get(0).toString());
//				med.setReponseDose(Fatigue.get(0).toString());
				
				med.setReponseFrequence(NoAnswer);
				med.setReponseDose(NoAnswer);
				
				ListMedBiotherapie_D.add(med);
			}

		}



		for (int i=0; i<ListTraitementDeFond.size(); i++)

		{	
			medicament=ListTraitementDeFond.get(i);
			ArrayList <String> DosePossible=new ArrayList<String>();
			ArrayList <String> FrequencePossible=new ArrayList<String>();
			med=new Medicament(Integer.parseInt(medicament.get(0).toString()), medicament.get(3).toString(), medicament.get(2).toString(), DosePossible, FrequencePossible);
//			med.setReponseFrequence(Fatigue.get(0).toString());
//			med.setReponseDose(Fatigue.get(0).toString());			
			med.setReponseFrequence(NoAnswer);
			med.setReponseDose(NoAnswer);
			ListMedTraitementDeFond_D.add(med);

			
		}


		int j=0;
		boolean fait=false;
		
		while ((j<ListMedAntiInflammatoire_D.size()) && (!fait))
			
		{
			String id=String.valueOf(ListMedAntiInflammatoire_D.get(j).getID()).toString();

			ArrayList<String> freq_dose;

			for (int i=0; i<List_Freq_Dose.size(); i++)
			{
				freq_dose=List_Freq_Dose.get(i);
				
				String id1=freq_dose.get(3).toString();

				if (id1.equals(id))
				{

					
					if(freq_dose.get(1).toString().equals("1"))
					{
						
						ListMedAntiInflammatoire_D.get(j).setFrequencePossible(freq_dose.get(2));
					

					}


					
					else  
					{	
						ListMedAntiInflammatoire_D.get(j).setDosePossible(freq_dose.get(2));
					}
				}	

			}
			
			j=j+1;
			
		}


		int k=0;
		boolean test=false;
	
		while ((k<ListMedAntalgique_D.size()) && (!test))

		{
			String id=String.valueOf(ListMedAntalgique_D.get(k).getID()).toString();
			ArrayList<String> freq_dose;

			for (int i=0; i<List_Freq_Dose.size(); i++)
			{
				freq_dose=List_Freq_Dose.get(i);
				
				String id1=freq_dose.get(3).toString();

				if (id1.equals(id))
				{

					
					if(freq_dose.get(1).toString().equals("1"))
					{

						ListMedAntalgique_D.get(k).setFrequencePossible(freq_dose.get(2));
					
					}


					
					else  
					{

						ListMedAntalgique_D.get(k).setDosePossible(freq_dose.get(2));
					}
				}	

			}
			ListMedAntalgique_D.get(k).getfreq();
			ListMedAntalgique_D.get(k).getdose();
			k=k+1;
		
		}
		int l=0;
		boolean test1=false;
		
		while ((l<ListMedBiotherapie_D.size()) && (!test1))

		{
			String id=String.valueOf(ListMedBiotherapie_D.get(l).getID()).toString();

			ArrayList<String> freq_dose;

			for (int i=0; i<List_Freq_Dose.size(); i++)
			{
				freq_dose=List_Freq_Dose.get(i);
			
				String id1=freq_dose.get(3).toString();

				if (id1.equals(id))
				{
					if(freq_dose.get(1).toString().equals("1"))
					{

						ListMedBiotherapie_D.get(l).setFrequencePossible(freq_dose.get(2));
						

					}

					else  
					{


						ListMedBiotherapie_D.get(l).setDosePossible(freq_dose.get(2));
					}
				}	

			}
			ListMedBiotherapie_D.get(l).getfreq();
			ListMedBiotherapie_D.get(l).getdose();
			l=l+1;
			//}



		}
		int m=0;
		boolean test2=false;
		//int k = 0;
		while ((m<ListMedTraitementDeFond_D.size()) && (!test2))

		{
			String id=String.valueOf(ListMedTraitementDeFond_D.get(m).getID()).toString();

			ArrayList<String> freq_dose;

			for (int i=0; i<List_Freq_Dose.size(); i++)
			{
				freq_dose=List_Freq_Dose.get(i);
				
				String id1=freq_dose.get(3).toString();


				if (id1.equals(id))
				{

					if(freq_dose.get(1).toString().equals("1"))
					{

						ListMedTraitementDeFond_D.get(m).setFrequencePossible(freq_dose.get(2));
						

					}


					
					else  
					{

						ListMedTraitementDeFond_D.get(m).setDosePossible(freq_dose.get(2));
					}
				}	

			}
			ListMedTraitementDeFond_D.get(m).getfreq();
			ListMedTraitementDeFond_D.get(m).getdose();
			m=m+1;
			//}



		}
	}



	public static void ActionFicheInclusion(String nom,String prenom, String sexe, String anneeDeNaissance, String poids, String activite, String telephoneMobile)

	{	

		patient.setNom(nom);
		patient.setPrenom(prenom);
		patient.setActivite(activite);
		patient.setAnneeDeNaissance(anneeDeNaissance);
		patient.setPoids(poids);
		patient.setTelephoneMobile(telephoneMobile);	
		patient.setSexe(sexe);



	}	



	public static void ActionSquelette1()

	{		

		DouleurSquelette=new ArrayList<QuestionChoixUniqueScore1>();

		
		DoigtsGauches1=new QuestionChoixUniqueScore1 (29,"DoigtsGauches1",Squelette);
		DoigtsGauches1.setReponse(Squelette.get(0));
		DoigtsGauches1.setScore(DoigtsGauches1.CalculScore());
		DouleurSquelette.add(DoigtsGauches1);


		DoigtsDroits1=new QuestionChoixUniqueScore1 (30,"DoigtsDroits1",Squelette);
		DoigtsDroits1.setReponse(Squelette.get(0));
		DoigtsDroits1.setScore(DoigtsDroits1.CalculScore());
		DouleurSquelette.add(DoigtsDroits1);

		
		EpauleGauche1=new QuestionChoixUniqueScore1 (36,"EpauleGauche1",Squelette);
		EpauleGauche1.setReponse(Squelette.get(0));
		EpauleGauche1.setScore(EpauleGauche1.CalculScore());
		DouleurSquelette.add(EpauleGauche1);

		
		EpauleDroit1=new QuestionChoixUniqueScore1 (37,"EpauleDroit1",Squelette);
		EpauleDroit1.setReponse(Squelette.get(0)); 
		EpauleDroit1.setScore(EpauleDroit1.CalculScore());
		DouleurSquelette.add(EpauleDroit1);

		
		CoudeGauche1=new QuestionChoixUniqueScore1 (34,"CoudeGauche1",Squelette);
		CoudeGauche1.setReponse(Squelette.get(0)); 
		CoudeGauche1.setScore(CoudeGauche1.CalculScore());
		DouleurSquelette.add(CoudeGauche1);

		
		CoudeDroit1=new QuestionChoixUniqueScore1 (35,"CoudeDroit1",Squelette);
		CoudeDroit1.setReponse(Squelette.get(0)); 
		CoudeDroit1.setScore(CoudeDroit1.CalculScore());
		DouleurSquelette.add(CoudeDroit1);

		
		OrteilsGauches1=new QuestionChoixUniqueScore1 (38,"OrteilsGauches1",Squelette);
		OrteilsGauches1.setReponse(Squelette.get(0)); 
		OrteilsGauches1.setScore(OrteilsGauches1.CalculScore());
		DouleurSquelette.add(OrteilsGauches1);

		
		OrteilsDroits1=new QuestionChoixUniqueScore1 (39,"OrteilsDroits1",Squelette);
		OrteilsDroits1.setReponse(Squelette.get(0)); 
		OrteilsDroits1.setScore(OrteilsDroits1.CalculScore());
		DouleurSquelette.add(OrteilsDroits1);

		
		GenouGauche1=new QuestionChoixUniqueScore1 (42,"GenouGauche1",Squelette);
		GenouGauche1.setReponse(Squelette.get(0)); 
		GenouGauche1.setScore(GenouGauche1.CalculScore());
		DouleurSquelette.add(GenouGauche1);

		
		GenouDroit1=new QuestionChoixUniqueScore1 (43,"GenouDroit1",Squelette);
		GenouDroit1.setReponse(Squelette.get(0)); 
		GenouDroit1.setScore(GenouDroit1.CalculScore());
		DouleurSquelette.add(GenouDroit1);

		
		HancheGauche1=new QuestionChoixUniqueScore1 (49,"HancheGauche1",Squelette);
		HancheGauche1.setReponse(Squelette.get(0)); 
		HancheGauche1.setScore(HancheGauche1.CalculScore());
		DouleurSquelette.add(HancheGauche1);

		
		HancheDroit1=new QuestionChoixUniqueScore1 (50,"HancheDroit1",Squelette);
		HancheDroit1.setReponse(Squelette.get(0)); 
		HancheDroit1.setScore(HancheDroit1.CalculScore());
		DouleurSquelette.add(HancheDroit1);

		
		PoignetGauche1=new QuestionChoixUniqueScore1 (32,"PoignetGauche1",Squelette);
		PoignetGauche1.setReponse(Squelette.get(0));
		PoignetGauche1.setScore(PoignetGauche1.CalculScore());
		DouleurSquelette.add(PoignetGauche1);

		
		PoignetDroit1=new QuestionChoixUniqueScore1 (33,"PoignetDroit1",Squelette);
		PoignetDroit1.setReponse(Squelette.get(0)); 
		PoignetDroit1.setScore(PoignetDroit1.CalculScore());
		DouleurSquelette.add(PoignetDroit1);

		
		ChevilleGauche1=new QuestionChoixUniqueScore1(40,"ChevilleGauche1",Squelette);
		ChevilleGauche1.setReponse(Squelette.get(0));
		ChevilleGauche1.setScore(ChevilleGauche1.CalculScore());
		DouleurSquelette.add(ChevilleGauche1);

		
		ChevilleDroit1=new QuestionChoixUniqueScore1 (41,"ChevilleDroit1",Squelette);
		ChevilleDroit1.setReponse(Squelette.get(0));
		ChevilleDroit1.setScore(ChevilleDroit1.CalculScore());
		DouleurSquelette.add(ChevilleDroit1);


		DoigtDroitD1_1=new QuestionChoixUniqueScore1 (175,"DoigtDroitD1_1",Squelette);
		DoigtDroitD1_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD1_1);

		DoigtDroitD1_2=new QuestionChoixUniqueScore1 (176,"DoigtDroitD1_2",Squelette);
		DoigtDroitD1_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD1_2);

		DoigtDroitD2_1=new QuestionChoixUniqueScore1 (177,"DoigtDroitD2_1",Squelette);
		DoigtDroitD2_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD2_1);

		DoigtDroitD2_2=new QuestionChoixUniqueScore1 (178,"DoigtDroitD2_2",Squelette);
		DoigtDroitD2_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD2_2);

		DoigtDroitD3_1=new QuestionChoixUniqueScore1 (179,"DoigtDroitD3_1",Squelette);
		DoigtDroitD3_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD3_1);

		DoigtDroitD3_2=new QuestionChoixUniqueScore1 (180,"DoigtDroitD3_2",Squelette);
		DoigtDroitD3_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD3_2);

		DoigtDroitD4_1=new QuestionChoixUniqueScore1 (181,"DoigtDroitD4_2",Squelette);
		DoigtDroitD4_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD4_1);

		DoigtDroitD4_2=new QuestionChoixUniqueScore1 (182,"DoigtDroitD4_2",Squelette);
		DoigtDroitD4_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD4_2);

		DoigtDroitD5_1=new QuestionChoixUniqueScore1 (183,"DoigtDroitD5_1",Squelette);
		DoigtDroitD5_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD5_1);

		DoigtDroitD5_2=new QuestionChoixUniqueScore1 (184,"DoigtDroitD5_2",Squelette);
		DoigtDroitD5_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtDroitD5_2);

		DoigtGaucheD1_1=new QuestionChoixUniqueScore1 (185,"DoigtGaucheD1_1",Squelette);
		DoigtGaucheD1_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD1_1);

		DoigtGaucheD1_2=new QuestionChoixUniqueScore1 (186,"DoigtGaucheD1_2",Squelette);
		DoigtGaucheD1_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD1_2);

		DoigtGaucheD2_1=new QuestionChoixUniqueScore1 (187,"DoigtGaucheD2_1",Squelette);
		DoigtGaucheD2_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD2_1);

		DoigtGaucheD2_2=new QuestionChoixUniqueScore1 (188,"DoigtGaucheD2_2",Squelette);
		DoigtGaucheD2_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD2_2);

		DoigtGaucheD3_1=new QuestionChoixUniqueScore1 (189,"DoigtGaucheD3_1",Squelette);
		DoigtGaucheD3_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD3_1);

		DoigtGaucheD3_2=new QuestionChoixUniqueScore1 (190,"DoigtGaucheD3_2",Squelette);
		DoigtGaucheD3_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD3_2);

		DoigtGaucheD4_1=new QuestionChoixUniqueScore1 (191,"DoigtGaucheD4_1",Squelette);
		DoigtGaucheD4_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD4_1);

		DoigtGaucheD4_2=new QuestionChoixUniqueScore1 (192,"DoigtGaucheD4_2",Squelette);
		DoigtGaucheD4_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD4_2);

		DoigtGaucheD5_1=new QuestionChoixUniqueScore1 (193,"DoigtGaucheD5_1",Squelette);
		DoigtGaucheD5_1.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD5_1);

		DoigtGaucheD5_2=new QuestionChoixUniqueScore1 (194,"DoigtGaucheD5_2",Squelette);
		DoigtGaucheD5_2.setReponse(Squelette.get(0));
		DouleurSquelette.add(DoigtGaucheD5_2);
	}	



	public static void ActionSquelette2()

	{

		GonflementSquelette=new ArrayList<QuestionChoixUnique>();


		DoigtsGauches2=new QuestionChoixUnique (95,"DoigtsGauches2",YesNo);
		DoigtsGauches2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtsGauches2);


		DoigtsDroits2=new QuestionChoixUnique (96,"DoigtsDroits2",YesNo);
		DoigtsDroits2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtsDroits2);

		EpauleGauche2=new QuestionChoixUnique (101,"EpauleGauche2",YesNo);
		EpauleGauche2.setReponse(YesNo.get(1));
		GonflementSquelette.add(EpauleGauche2);

		
		EpauleDroit2=new QuestionChoixUnique (102,"EpauleDroit2",YesNo);
		EpauleDroit2.setReponse(YesNo.get(1));
		GonflementSquelette.add(EpauleDroit2);

		
		CoudeGauche2=new QuestionChoixUnique (99,"CoudeGauche2",YesNo);
		CoudeGauche2.setReponse(YesNo.get(1));
		GonflementSquelette.add(CoudeGauche2);

		
		CoudeDroit2=new QuestionChoixUnique (100,"CoudeDroit2",YesNo);
		CoudeDroit2.setReponse(YesNo.get(1));
		GonflementSquelette.add(CoudeDroit2);

		
		GenouGauche2=new QuestionChoixUnique (107,"GenouGauche2",YesNo);
		GenouGauche2.setReponse(YesNo.get(1));
		GonflementSquelette.add(GenouGauche2);

		
		GenouDroit2=new QuestionChoixUnique (108,"GenouDroit2",YesNo);
		GenouDroit2.setReponse(YesNo.get(1));
		GonflementSquelette.add(GenouDroit2);

		
		PoignetGauche2=new QuestionChoixUnique (97,"PoignetGauche2",YesNo);
		PoignetGauche2.setReponse(YesNo.get(1));
		GonflementSquelette.add(PoignetGauche2);

		
		PoignetDroit2=new QuestionChoixUnique (98,"PoignetDroit2",YesNo);
		PoignetDroit2.setReponse(YesNo.get(1));
		GonflementSquelette.add(PoignetDroit2);

		DoigtDroitG1_1=new QuestionChoixUnique (195,"DoigtDroitG1_1",YesNo);
		DoigtDroitG1_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG1_1);

		DoigtDroitG1_2=new QuestionChoixUnique (196,"DoigtDroitG1_2",YesNo);
		DoigtDroitG1_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG1_2);

		DoigtDroitG2_1=new QuestionChoixUnique (197,"DoigtDroitG2_1",YesNo);
		DoigtDroitG2_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG2_1);

		DoigtDroitG2_2=new QuestionChoixUnique (198,"DoigtDroitG2_2",YesNo);
		DoigtDroitG2_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG2_2);

		DoigtDroitG3_1=new QuestionChoixUnique (199,"DoigtDroitG3_1",YesNo);
		DoigtDroitG3_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG3_1);

		DoigtDroitG3_2=new QuestionChoixUnique (200,"DoigtDroitG3_2",YesNo);
		DoigtDroitG3_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG3_2);

		DoigtDroitG4_1=new QuestionChoixUnique (201,"DoigtDroitG4_1",YesNo);
		DoigtDroitG4_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG4_1);

		DoigtDroitG4_2=new QuestionChoixUnique (202,"DoigtDroitG4_2",YesNo);
		DoigtDroitG4_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG4_2);

		DoigtDroitG5_1=new QuestionChoixUnique (203,"DoigtDroitG5_1",YesNo);
		DoigtDroitG5_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG5_1);

		DoigtDroitG5_2=new QuestionChoixUnique (204,"DoigtDroitG5_2",YesNo);
		DoigtDroitG5_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtDroitG5_2);

		DoigtGaucheG1_1=new QuestionChoixUnique (205,"DoigtGaucheG1_1",YesNo);
		DoigtGaucheG1_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG1_1);

		DoigtGaucheG1_2=new QuestionChoixUnique (206,"DoigtGaucheG1_2",YesNo);
		DoigtGaucheG1_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG1_2);

		DoigtGaucheG2_1=new QuestionChoixUnique (207,"DoigtGaucheG2_1",YesNo);
		DoigtGaucheG2_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG2_1);

		DoigtGaucheG2_2=new QuestionChoixUnique (208,"DoigtGaucheG2_2",YesNo);
		DoigtGaucheG2_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG2_2);

		DoigtGaucheG3_1=new QuestionChoixUnique (209,"DoigtGaucheG3_1",YesNo);
		DoigtGaucheG3_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG3_1);

		DoigtGaucheG3_2=new QuestionChoixUnique (210,"DoigtGaucheG3_2",YesNo);
		DoigtGaucheG3_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG3_2);

		DoigtGaucheG4_1=new QuestionChoixUnique (211,"DoigtGaucheG4_1",YesNo);
		DoigtGaucheG4_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG4_1);

		DoigtGaucheG4_2=new QuestionChoixUnique (212,"DoigtGaucheG4_2",YesNo);
		DoigtGaucheG4_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG4_2);

		DoigtGaucheG5_1=new QuestionChoixUnique (213,"DoigtGaucheG5_1",YesNo);
		DoigtGaucheG5_1.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG5_1);

		DoigtGaucheG5_2=new QuestionChoixUnique (214,"DoigtGaucheG5_2",YesNo);
		DoigtGaucheG5_2.setReponse(YesNo.get(1));
		GonflementSquelette.add(DoigtGaucheG5_2);


	}	


	public static void ActionReponseSquelette1(String partie, String reponse)

	{
		if (partie.equals("DoigtsGauches"))
		{DoigtsGauches1.setReponse(reponse);
		DoigtsGauches1.setScore(DoigtsGauches1.CalculScore());}		

		else if (partie.equals("DoigtsDroits"))
		{DoigtsDroits1.setReponse(reponse);
		DoigtsDroits1.setScore(DoigtsDroits1.CalculScore());}		

		else if (partie.equals("EpauleGauche"))
		{EpauleGauche1.setReponse(reponse);
		EpauleGauche1.setScore(EpauleGauche1.CalculScore());}	

		else if (partie.equals("EpauleDroit"))
		{EpauleDroit1.setReponse(reponse);
		EpauleDroit1.setScore(EpauleDroit1.CalculScore());}

		else if (partie.equals("HancheDroit"))
		{HancheDroit1.setReponse(reponse);
		HancheDroit1.setScore(HancheDroit1.CalculScore());}		

		else if (partie.equals("HancheGauche"))
		{HancheGauche1.setReponse(reponse);
		HancheGauche1.setScore(HancheGauche1.CalculScore());}

		else if (partie.equals("GenouDroit"))
		{GenouDroit1.setReponse(reponse);
		GenouDroit1.setScore(HancheGauche1.CalculScore());}		

		else if (partie.equals("GenouGauche"))
		{GenouGauche1.setReponse(reponse);
		GenouGauche1.setScore(GenouGauche1.CalculScore());}

		else if (partie.equals("OrteilsDroits"))
		{OrteilsDroits1.setReponse(reponse);
		OrteilsDroits1.setScore(OrteilsDroits1.CalculScore());}	
		
		else if (partie.equals("OrteilsGauches"))
		{OrteilsGauches1.setReponse(reponse);
		OrteilsGauches1.setScore(OrteilsGauches1.CalculScore());}

		else if (partie.equals("ChevilleDroit"))
		{ChevilleDroit1.setReponse(reponse);
		ChevilleDroit1.setScore(ChevilleDroit1.CalculScore());}		

		else if (partie.equals("ChevilleGauche"))
		{ChevilleGauche1.setReponse(reponse);
		ChevilleGauche1.setScore(ChevilleGauche1.CalculScore());}

		else if (partie.equals("CoudeDroit"))
		{CoudeDroit1.setReponse(reponse);
		CoudeDroit1.setScore(CoudeDroit1.CalculScore());}		


		else if (partie.equals("CoudeGauche"))
		{CoudeGauche1.setReponse(reponse);
		CoudeGauche1.setScore(CoudeGauche1.CalculScore());}

		else if (partie.equals("PoignetDroit"))
		{PoignetDroit1.setReponse(reponse);
		PoignetDroit1.setScore(PoignetDroit1.CalculScore());}		

		else if (partie.equals("PoignetGauche"))
		{PoignetGauche1.setReponse(reponse);
		PoignetGauche1.setScore(PoignetGauche1.CalculScore());}

		else if (partie.equals("DoigtDroitD1_1"))
		{
			DoigtDroitD1_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD1_2"))
		{
			DoigtDroitD1_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD2_1"))
		{
			DoigtDroitD2_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD2_2"))
		{
			DoigtDroitD2_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD3_1"))
		{
			DoigtDroitD3_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD3_2"))
		{
			DoigtDroitD3_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD4_1"))
		{
			DoigtDroitD4_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD4_2"))
		{
			DoigtDroitD4_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD5_1"))
		{
			DoigtDroitD5_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitD5_2"))
		{
			DoigtDroitD5_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD1_1"))
		{
			DoigtGaucheD1_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD1_2"))
		{
			DoigtGaucheD1_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD2_1"))
		{
			DoigtGaucheD2_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD2_2"))
		{
			DoigtGaucheD2_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD3_1"))
		{
			DoigtGaucheD3_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD3_2"))
		{
			DoigtGaucheD3_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD4_1"))
		{
			DoigtGaucheD4_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD4_2"))
		{
			DoigtGaucheD4_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD5_1"))
		{
			DoigtGaucheD5_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheD5_2"))
		{
			DoigtGaucheD5_2.setReponse(reponse);
		}
	}


	public static void ActionReponseSquelette2(String partie, String reponse)

	{
		if (partie=="DoigtsGauches")
		{DoigtsGauches2.setReponse(reponse);
		}		
		else if (partie=="DoigtsDroits")
		{DoigtsDroits2.setReponse(reponse);
		}		

		else if (partie=="EpauleGauche")
		{EpauleGauche2.setReponse(reponse);
		}	
		else if (partie=="EpauleDroit")
		{EpauleDroit2.setReponse(reponse);
		}

		else if (partie=="HancheDroit")
		{HancheDroit2.setReponse(reponse);
		}		
		else if (partie=="HancheGauche")
		{HancheGauche2.setReponse(reponse);
		}

		else if (partie=="GenouDroit")
		{GenouDroit2.setReponse(reponse);
		}		
		else if (partie=="GenouGauche")
		{GenouGauche2.setReponse(reponse);
		}

		else if (partie=="OrteilDroits")
		{OrteilsDroits2.setReponse(reponse);
		}		
		else if (partie=="OrteilsGauches")
		{OrteilsGauches2.setReponse(reponse);
		}

		else if (partie=="ChevilleDroit")
		{ChevilleDroit2.setReponse(reponse);
		}		
		else if (partie=="ChevilleGauche")
		{ChevilleGauche2.setReponse(reponse);
		}

		else if (partie=="CoudeDroit")
		{CoudeDroit2.setReponse(reponse);
		}		
		else if (partie=="CoudeGauche")
		{CoudeGauche2.setReponse(reponse);
		}

		else if (partie=="PoignetDroit")
		{PoignetDroit2.setReponse(reponse);
		}		
		else if (partie=="PoignetGauche")
		{PoignetGauche2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG1_1"))
		{
			DoigtDroitG1_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG1_2"))
		{
			DoigtDroitG1_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG2_1"))
		{
			DoigtDroitG2_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG2_2"))
		{
			DoigtDroitG2_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG3_1"))
		{
			DoigtDroitG3_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG3_2"))
		{
			DoigtDroitG3_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG4_1"))
		{
			DoigtDroitG4_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG4_2"))
		{
			DoigtDroitG4_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG5_1"))
		{
			DoigtDroitG5_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtDroitG5_2"))
		{
			DoigtDroitG5_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG1_1"))
		{
			DoigtGaucheG1_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG1_2"))
		{
			DoigtGaucheG1_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG2_1"))
		{
			DoigtGaucheG2_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG2_2"))
		{
			DoigtGaucheG2_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG3_1"))
		{
			DoigtGaucheG3_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG3_2"))
		{
			DoigtGaucheG3_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG4_1"))
		{
			DoigtGaucheG4_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG4_2"))
		{
			DoigtGaucheG4_2.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG5_1"))
		{
			DoigtGaucheG5_1.setReponse(reponse);
		}

		else if (partie.equals("DoigtGaucheG5_2"))
		{
			DoigtGaucheG5_2.setReponse(reponse);
		}
	}



	public static String ActionFicheInclusion1(String telephoneFixe,String adresseEmail, String adresse)

	{	
		patient.setAdresse(adresse);
		patient.setTelephoneFixe(telephoneFixe);
		patient.setAdresseEmail(adresseEmail);		

		
		return "Homme";
	}

	public static String ActionRetourneSexe()
	{
		if ((patient.getSexe().equals(Gender.get(0))))
		{
			return "Femme";
		}

		else

		{return "Homme";}


	}



	public static void ActionFicheInclusion2(QuestionChoixUnique Q, String reponseMenopause, QuestionLibre Q1, String AgeMenopause, QuestionChoixMultiples Q2,  ArrayList <String> reponseContraception)

	{		
		Q.setReponse(reponseMenopause);
		Q1.setReponse(AgeMenopause);
		Q2.setReponse(reponseContraception);		
	}


	public static void ActionFicheInclusion3(QuestionChoixUnique Q, String reponseFracture,QuestionChoixMultiples Q1, ArrayList <String> reponseFacteurRisque)

	{			
		Q.setReponse(reponseFracture);
		Q1.setReponse(reponseFacteurRisque);

	}

	public static void ActionFicheInclusion4(QuestionChoixMultiples Q2, ArrayList <String> reponseInfection)

	{				
		Q2.setReponse(reponseInfection);		
	}


	public static void ActionFicheInclusion5(QuestionChoixUnique Q, String reponseDTPolio, String reponseRappelDTPolio)

	{			

		Q.setReponse(reponseDTPolio);	
		RappelDTPolio=new QuestionLibre(7);	
		RappelDTPolio.setReponse(reponseRappelDTPolio);			

	}


	public static void ActionFicheInclusion6(QuestionChoixUnique Q, String reponseGrippe, String reponseRappelGrippe)

	{			

		Q.setReponse(reponseGrippe);
		RappelGrippe=new QuestionLibre(7);
		RappelGrippe.setReponse(reponseRappelGrippe);			

	}

	public static void ActionFicheInclusion7(QuestionChoixUnique Q, String reponsePneumonie, String reponseRappelPneumonie)

	{			

		Q.setReponse(reponsePneumonie);
		RappelPneumonie=new QuestionLibre(7);
		RappelPneumonie.setReponse(reponseRappelPneumonie);			

	}

	public static void ActionMedecin(String Nom, String Prenom, String telephoneFixe, String telephoneMobile, String adresseEmail, String Profession, Context mContext) throws ClientProtocolException, IOException 

	{							
		medecin=new MedecinTraitant();

		medecin.setNom(Nom);
		medecin.setPrenom(Prenom);
		medecin.setProfession(Profession);
		medecin.setTelephoneFixe(telephoneFixe);
		medecin.setTelephoneMobile(telephoneMobile);
		medecin.setAdresseEmail(adresseEmail);	

		DBAdapter dba = new DBAdapter(mContext);
		dba.open();

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		String currentDateandTime = sdf.format(new Date());
		SharedPreferences IdUser = mContext.getSharedPreferences("IdUser", MODE_PRIVATE);
		int id = IdUser.getInt("IDPatient", 0);

		dba.InsertDoctor(medecin.getPrenom(), medecin.getNom(), medecin.getTelephoneFixe(), medecin.getTelephoneMobile(), medecin.getProfession(), medecin.getAdresseEmail(), id, currentDateandTime);
		dba.close();
		
		
		HelperSendDoctor helper = new HelperSendDoctor();
		try {
			helper.SendDoctor(mContext, currentDateandTime);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	// ENVOI DES DONNEES


	public static void ActionEnvoiFicheInclusion(Context mContext) throws ClientProtocolException, IOException 

	{
		dba = new DBAdapter(mContext);
		dba.open();
		SharedPreferences IdUser = mContext.getSharedPreferences("IdUser", MODE_PRIVATE);
		int id = IdUser.getInt("IDPatient", 0);
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		String currentDateandTime = sdf.format(new Date());

		
		AllQuestionFI = new ArrayList<String>();
		ArrayList<String> AllquestionIDD  = new ArrayList<String>(); 
		
		for (int i=0; i< QuestionYN_FI.size(); i++)	
		{	
			int ll =0;
			String refTest = dba.GetRefQAContent(QuestionYN_FI.get(i).getID());
			dba.InsertAnswer(QuestionYN_FI.get(i).getID(), QuestionYN_FI.get(i).getReponse(),refTest, currentDateandTime.trim(), id);

			AllQuestionFI.add(refTest);
			AllquestionIDD.add(String.valueOf(QuestionYN_FI.get(i).getID()));
			
			
		}


		for (int i=0; i< QuestionLibreFI.size(); i++)	
		{

			String ref = dba.GetRefQAContent(QuestionLibreFI.get(i).getID());
			dba.InsertAnswer(QuestionLibreFI.get(i).getID(), QuestionLibreFI.get(i).getReponse(), ref, currentDateandTime, id);

			AllQuestionFI.add(ref);
			AllquestionIDD.add(String.valueOf(QuestionLibreFI.get(i).getID()));

		}
		


		for (int i=0; i< QuestionChoixMultiplesFI.size()-1; i++)	
		{	
			AnswersMutipleChoice="";
		
			for (int j=0; j<QuestionChoixMultiplesFI.get(i).getReponse().size(); j++)
			{
				
				if (j == QuestionChoixMultiplesFI.get(i).getReponse().size() -1)
				{AnswersMutipleChoice=AnswersMutipleChoice+QuestionChoixMultiplesFI.get(i).getReponse().get(j);}
				else
				{AnswersMutipleChoice=AnswersMutipleChoice+QuestionChoixMultiplesFI.get(i).getReponse().get(j)+",";}
		
			}
			
			AllquestionIDD.add(String.valueOf(QuestionChoixMultiplesFI.get(i).getID()));
			
			String ref = dba.GetRefQAContent(QuestionChoixMultiplesFI.get(i).getID());
			AllQuestionFI.add(ref);
			dba.InsertAnswer(QuestionChoixMultiplesFI.get(i).getID(), AnswersMutipleChoice.toString(), ref, currentDateandTime, id);
			
		}

		//Une fois les r�ponses ont �t� inser�es dans la base, on fait appel � la classe HelperSendAnswersFI qui parcours la base de donn�es et envoi les donn�es via les web services. La m�me proc�dure est utilis�e dans l'envoi des donn�es de suivi et des traitements m�dicamenteux.
		
		HelperSendAnswersFI helper = new HelperSendAnswersFI();
		try {
			helper.Send(mContext, currentDateandTime);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

	}


	public static void ActionEnvoiDonneeDeSuivi(Context mContext ) throws ClientProtocolException, IOException{

		dba = new DBAdapter(mContext);
		dba.open();
		SharedPreferences IdUser = mContext.getSharedPreferences("IdUser", MODE_PRIVATE);
		int id = IdUser.getInt("IDPatient", 0);
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		String currentDateandTime = sdf.format(new Date());
		AllQuestionDS = new ArrayList<String>();
		
		ArrayList <QuestionChoixUnique> toutQuestionYN=new ArrayList <QuestionChoixUnique>();
		
		toutQuestionYN.addAll(QuestionGenerale);
		toutQuestionYN.addAll(QuestionYN_DAS28);
		toutQuestionYN.addAll(GonflementSquelette);
		toutQuestionYN.addAll(C_theme1);
		toutQuestionYN.addAll(C_theme2);
		toutQuestionYN.addAll(C_theme3);
		toutQuestionYN.addAll(C_theme4);
		toutQuestionYN.addAll(C_theme5);
		toutQuestionYN.addAll(C_theme6);
		toutQuestionYN.addAll(C_theme7);
		toutQuestionYN.addAll(C_theme8);

		ArrayList <QuestionChoixUniqueScore1> toutQuestionScore1=new ArrayList <QuestionChoixUniqueScore1>();

		toutQuestionScore1.addAll(DouleurSquelette);
		toutQuestionScore1.addAll(theme11);
		toutQuestionScore1.addAll(theme22);
		toutQuestionScore1.addAll(theme33);
		toutQuestionScore1.addAll(theme44);
		toutQuestionScore1.addAll(theme55);
		toutQuestionScore1.addAll(theme66);
		toutQuestionScore1.addAll(theme77);
		toutQuestionScore1.addAll(theme88);	

		

		
int k = 0;
		for (int i=0; i< QuestionEvaluation.size(); i++)	
		{	

			String ref = dba.GetRefQAContent(QuestionEvaluation.get(i).getID());
			
			if (!AllQuestionDS.contains(ref)) 
			{
				AllQuestionDS.add(ref);
				k=k+1;
				dba.InsertAnswer(QuestionEvaluation.get(i).getID(), String.valueOf(QuestionEvaluation.get(i).getReponse()), ref, currentDateandTime, id);
			}
			
			Log.d("RefIns�r�e"+k,ref);
		}
		
		for (int i=0; i< QuestionFatigue.size(); i++)	
		{	
			String ref = dba.GetRefQAContent(QuestionFatigue.get(i).getID());
			if (!AllQuestionDS.contains(ref)) 
			{
				
			AllQuestionDS.add(ref);
			String r�ponse = QuestionFatigue.get(i).getReponse();
			
			if (!Fatigue.contains(QuestionFatigue.get(i).getReponse()))
			{
				QuestionFatigue.get(i).setReponse(NoAnswer);
			}
			
			dba.InsertAnswer(QuestionFatigue.get(i).getID(), String.valueOf(QuestionFatigue.get(i).getReponse()), ref, currentDateandTime, id);
			k=k+1;
			Log.d("RefIns�r�e"+k,ref);
			}
		
		}
		
		for (int i=0; i< toutQuestionYN.size(); i++)	
		{	
			String ref = dba.GetRefQAContent(toutQuestionYN.get(i).getID());
			if (!AllQuestionDS.contains(ref)) 
			{
			AllQuestionDS.add(ref);
			dba.InsertAnswer(toutQuestionYN.get(i).getID(), toutQuestionYN.get(i).getReponse().toString(), ref, currentDateandTime, id);
			k=k+1;
			Log.d("RefIns�r�e"+k,ref);
			}
		}
		
		for (int i=0; i< toutQuestionScore1.size(); i++)	
		{	

			String ref = dba.GetRefQAContent(toutQuestionScore1.get(i).getID());
			if (!AllQuestionDS.contains(ref)) 
			{
			AllQuestionDS.add(ref);
			dba.InsertAnswer(toutQuestionScore1.get(i).getID(), toutQuestionScore1.get(i).getReponse().toString(), ref, currentDateandTime, id);
			k=k+1;
			Log.d("RefIns�r�e"+k,ref);
			}
		}
		
		for (int i=0; i<QuestionVS_CRP.size(); i++)	
		{	

			String ref = dba.GetRefQAContent(QuestionVS_CRP.get(i).getID());
			if (!AllQuestionDS.contains(ref)) 
			{
			AllQuestionDS.add(ref);
			dba.InsertAnswer(QuestionVS_CRP.get(i).getID(), QuestionVS_CRP.get(i).getReponse().toString(), ref, currentDateandTime, id);
			k=k+1;
			Log.d("RefIns�r�e"+k,ref);
			}
		}
		
		
		String Responses="";
		for (int i=0; i< QuestionChoixMultipleDS.getReponse().size(); i++)	 
		{
			if (i == QuestionChoixMultipleDS.getReponse().size() -1)
			{Responses=Responses+QuestionChoixMultipleDS.getReponse().get(i);}
			else
			{Responses=Responses+QuestionChoixMultipleDS.getReponse().get(i)+",";}
		}
		
		String REF = dba.GetRefQAContent(QuestionChoixMultipleDS.getID());
		if (!AllQuestionDS.contains(REF)) 
		{
		AllQuestionDS.add(REF);
		dba.InsertAnswer(QuestionChoixMultipleDS.getID(), Responses, REF, currentDateandTime, id);
		Log.d("RefIns�r�e"+(k+1),REF);
		}


		
		
		dba.InsertScore(QuestionnaireFatigue.getScore(), currentDateandTime, "FACIT", id);
		dba.InsertScore(QuestionnaireHAQ.getScore(), currentDateandTime, "HAQ", id);
		dba.InsertScore(QuestionnaireRAPID3.getScore(), currentDateandTime, "RAPID3", id);
		dba.InsertScore(QuestionnaireRADAI5.getScore(), currentDateandTime, "RADAI5", id);
		dba.InsertScore(QuestionnaireRAPID4.getScore(), currentDateandTime, "RAPID4", id);
		dba.InsertScore(Das28.getScore1(), currentDateandTime, "DAS28-VS", id);
		dba.InsertScore(Das28.getScore2(), currentDateandTime, "DAS28-CRP", id);
		

		HelperSendScores helper1 = new HelperSendScores();
		try {
			helper1.SendScore(mContext, currentDateandTime);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.d("RefSizeFromController",String.valueOf(AllQuestionDS.size()));

		
		HelperSendAnswersDS helper2 = new HelperSendAnswersDS();
		try {
			helper2.Send(mContext, currentDateandTime);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ActionEnvoiTraitementMedicamenteux(Context mContext) throws ClientProtocolException, IOException 
	{		
		dba = new DBAdapter(mContext);
		dba.open();
		AllQuestionTM = new ArrayList<String>();

		listToutMedicamentChoisi = new ArrayList <Medicament>();

		if (ListTraitementDeFondChoisi_D.size()!=0)
		{listToutMedicamentChoisi.addAll(ListTraitementDeFondChoisi_D);}

		if (ListTraitementDeFondChoisi.size()!=0)
		{listToutMedicamentChoisi.addAll(ListTraitementDeFondChoisi);}

		if (ListAntalgiqueChoisi_D.size()!=0)
		{listToutMedicamentChoisi.addAll(ListAntalgiqueChoisi_D);}

		if (ListAntalgiqueChoisi.size()!=0)
		{listToutMedicamentChoisi.addAll(ListAntalgiqueChoisi);}

		if (ListBiotherapieChoisi_D.size()!=0)
		{listToutMedicamentChoisi.addAll(ListBiotherapieChoisi_D);}

		if (ListBiotherapieChoisi.size()!=0)
		{listToutMedicamentChoisi.addAll(ListBiotherapieChoisi);}

		if (ListAntiInflammatoireChoisi_D.size()!=0)
		{listToutMedicamentChoisi.addAll(ListAntiInflammatoireChoisi_D);}

		if (ListAntiInflammatoireChoisi.size()!=0)
		{listToutMedicamentChoisi.addAll(ListAntiInflammatoireChoisi);}

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		String currentDateandTime = sdf.format(new Date());
		SharedPreferences IdUser = mContext.getSharedPreferences("IdUser", MODE_PRIVATE);
		int id = IdUser.getInt("IDPatient", 0);
		for (int i=0; i< listToutMedicamentChoisi.size(); i++)	
		{
			String DrugRef = dba.GetDrugRef(listToutMedicamentChoisi.get(i).getID());
			dba.InsertDrug(listToutMedicamentChoisi.get(i).getID(), DrugRef, listToutMedicamentChoisi.get(i).getReponseFrequence().toString(), listToutMedicamentChoisi.get(i).getReponseDose().toString(), id,currentDateandTime);
			//Toast.makeText(mContext,DrugRef + String.valueOf(i), Toast.LENGTH_LONG).show();
		}

			for (int i=0; i< ListMedQuestionYN.size(); i++)	
		{
			String ref=dba.GetRefQAContent(ListMedQuestionYN.get(i).getID());
			AllQuestionTM.add(ref);
			dba.InsertAnswer(ListMedQuestionYN.get(i).getID(), ListMedQuestionYN.get(i).getReponse().toString(), ref, currentDateandTime,id);
		}
		
		for (int i=0; i< ListMedQuestionChoixMultiples.size(); i++)	
		{	
			String Responses ="";
			for (int j=0; j<ListMedQuestionChoixMultiples.get(i).getReponse().size(); j++)
			{	
				String Response = ListMedQuestionChoixMultiples.get(i).getReponse().get(j);
				if (j == ListMedQuestionChoixMultiples.get(i).getReponse().size() -1)
				{Responses = Responses+Response;}
				else
				{Responses = Responses+Response+",";}
			}

			String ref= dba.GetRefQAContent(ListMedQuestionChoixMultiples.get(i).getID());
			dba.InsertAnswer(ListMedQuestionChoixMultiples.get(i).getID(), Responses, ref, currentDateandTime,id);
			AllQuestionTM.add(ref);	
		}
		
		HelperSendDrugs helper�Drug = new HelperSendDrugs();
		try {
			helper�Drug.SendDrug(mContext, currentDateandTime);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HelperSendAnswersTM helperAnswer = new HelperSendAnswersTM();
		try {
			helperAnswer.Send(mContext, currentDateandTime);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void ActionClaculDeForce(ArrayList <Integer> mesures)
	{

		Capteur=new CapteurDeForce(mesures);

		if (mesures.size()!=0)
		{	
			float resultat=Capteur.ClaculForce();
			Capteur.setMesureForce(resultat);
		}

		else 
		{
			Capteur.setMesureForce(-1);
		}

	}


}
*/
