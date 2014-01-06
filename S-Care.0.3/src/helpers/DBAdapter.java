package helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controller.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter {

	private static final ArrayList<String> Skeleton0 = null;
	private static final ArrayList<String> DoctorActivity0 = null;
	private static final ArrayList<String> PatientActivity0 = null;
	private static final ArrayList<String> Gender0 = null;
	private static final ArrayList<String> QuestionContent0 = null;
	private static final ArrayList<ArrayList<String>> Questions0 = null;
	private static final ArrayList<ArrayList<String>> Answers0 = null;
	private static final ArrayList<ArrayList<String>> ListAntiInflammatory0 = null;
	private static final ArrayList<ArrayList<String>> AnalgesicList0 = null;
	private static final ArrayList<ArrayList<String>> BiotherapyList0 = null;
	private static final ArrayList<ArrayList<String>> DMARDList0 = null;
	private static final ArrayList<ArrayList<String>> OCList0 = null;
	private static final ArrayList<ArrayList<String>> DrugFreqOrDosesList0 = null;
	private static final ArrayList<ArrayList<String>> ListQuestion_M0 = null;
	private static final ArrayList<String> AnswerDrug0 = null;
	private static final ArrayList<ArrayList<String>> ListQuestionEvaluationYN0 = null;
	private static final ArrayList<ArrayList<String>> HAQQuestionsList0 = null;
	private static final ArrayList<ArrayList<String>> ListQuestionFatigue0 = null;
	DatabaseHelper DBHelper;
	Context context;
	SQLiteDatabase db;

	public DBAdapter(Context context) {
		this.context = context;
		DBHelper = new DatabaseHelper(context);
	}

	public class DatabaseHelper extends SQLiteOpenHelper {

		Context context;

		public DatabaseHelper(Context context) {
			super(context, "DatabaseICareXI21", null, 1);

			this.context = context;

		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(" PRAGMA foreign_keys = ON ");
			db.execSQL("create table Patient (_id integer primary key autoincrement,"
					+ "Login text not null,Password text not null" + ");");
			db.execSQL("create table Doctor (_idDoctor integer primary key autoincrement,"
					+ "Firstname text not null,Lastname text not null,"
					+ "Phone text not null,Mobile text not null,"
					+ "Occupation text not null, Mail text not null,"
					+ "_idPatient REFERENCES _id ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "date text not null,"
					+ "sendingState text not null"
					+ ");");
			db.execSQL("create table Language (_idLanguage integer primary key autoincrement,"
					+ "Code text not null" + ");");
			db.execSQL("create table AnswerContent_translate (_idAnswer integer primary key autoincrement,"
					+ "A1 text not null,A2 text not null,A3 text not null,A4 text not null,A5 text not null,A6 text not null,A7 text not null,A8 text not null"
					+ ");");
			// db.execSQL("create table Scores (_idScores integer primary key autoincrement,"
			// +
			// "Value text not null,Date text not null,_idScoreType REFERENCES _idScoreTypes ON DELETE CASCADE ON UPDATE CASCADE,_idPatient REFERENCES _id ON DELETE CASCADE ON UPDATE CASCADE"
			// + ");" ) ;

			db.execSQL("create table Scores (_idScores integer primary key autoincrement,"
					+ "Value text not null,Date text not null, sendingState text not null, refScoreType text not null,_idPatient REFERENCES _id ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");");

			db.execSQL("create table ScoreTypes (_idScoreTypes integer primary key autoincrement,"
					+ "Name text not null," + "Ref text not null" + ");");
			db.execSQL("create table QAContents (_idQAContents integer primary key autoincrement,"
					+ "Ref text not null,Category integer,Type integer,Position integer,_idQAFamiliesContent REFERENCES _idQAFamilies ON DELETE CASCADE ON UPDATE CASCADE,_idScoreTypesQA REFERENCES _idScoreTypes ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");");
			db.execSQL("create table QuestionContent_translate (_idQuestionContent_translate integer primary key autoincrement,"
					+ "Question text not null,_idQAContentsTranslate integer,_idLanguageTranslate REFERENCES _idLanguage ON DELETE CASCADE ON UPDATE CASCADE,_idAnswerTranslate REFERENCES _idAnswer ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");");
			db.execSQL("create table Countries (_idCountries integer primary key autoincrement,"
					+ "Code text not null" + ");");
			db.execSQL("create table Drug_Content (_idDrug_Content integer primary key autoincrement,"
					+ "Ref text not null,Type text not null,Name text not null,_idLanguageDrug REFERENCES _idLanguage ON DELETE CASCADE ON UPDATE CASCADE,_idCountriesDrug REFERENCES _idCountries ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");");
			db.execSQL("create table Answers (id integer primary key autoincrement,_idAnswers integer,"
					+ "Value text not null,refQAContent text not null,"
					+ "date text not null,"
					+ "sendingState text not null,"
					+ "_idPatientAnswers REFERENCES _id ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");");
			db.execSQL("create table Drugs (id integer primary key autoincrement,_idDrugs integer,"
					+ "RefDrugContent text not null,Frequency text not null,Dose text not null,"
					+ "_idPatientDrugs REFERENCES _id ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "Date text not null,"
					+ "sendingState text not null"
					+ ");");
			db.execSQL("create table QAFamilies (_idQAFamilies integer primary key autoincrement,"
					+ "Name text not null,Type integer" + ");");
			db.execSQL("create table DrugFreqOrDoses (_idDrugFreqOrDoses integer primary key autoincrement,"
					+ "Type integer,Val text not null,"
					+ "_idDrug_ContentFreqOrDoses REFERENCES _idDrug_Content ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");");
			db.execSQL("create table QuestionnairesConfigurations (_idQuestionnairesConfigurations integer primary key autoincrement,"
					+ "isActivated text not null,Date text not null,"
					+ "_idPatientQuestionnaires REFERENCES _id ON DELETE CASCADE ON UPDATE CASCADE,idScoreType REFERENCES _idScoreTypes ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");");
			db.execSQL("create table QuestionsConfigurations (_idQuestionsConfigurations integer primary key autoincrement,"
					+ "idQuestion integer,isActivated text not null,"
					+ "_idPatientQuestions REFERENCES _id ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "Date text not null" + ");");
			db.execSQL("create table SmartPhoneConfigurations (_idSmartPhoneConfigurations integer primary key autoincrement,"
					+ "isScoreType text not null,Date text not null,"
					+ "_idPatientSmartPhoneConfig REFERENCES _id ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");");
			db.execSQL("create table DrugType (_idDrugType integer primary key autoincrement,"
					+ "Name text not null," + "Type integer" + ");");
			db.execSQL("create table m_scales (ref_scale integer primary key autoincrement,"
					+ "name text not null,date_scale text not null" + ");");
			db.execSQL("create table m_test (idE integer primary  key autoincrement,"
					+ "id integer,dat_test text not null,"
					+ "scale text not null,test_decision text not null,"
					+ "score_anxiety integer, score_depression integer" + ");");
			db.execSQL("create table m_reponses (id integer primary key autoincrement,ref_response integer,"
					+ "reftest REFERENCES ref_test ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "response integer," + "score_resp integer" + ");");
			db.execSQL("create table m_questions (refquest integer primary key autoincrement,"
					+ "refscale REFERENCES ref_scale ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "question text not null," + "type text not null" + ");");
			db.execSQL("create table m_decision (ref_decision integer primary key autoincrement,"
					+ "refscale REFERENCES ref_scale ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "type text not null,"
					+ "inf_score integer,"
					+ "sup_score integer," + "decision text not null" + ");");
			db.execSQL("create table m_choices (ref_choices integer primary key autoincrement,"
					+ " refquestion integer,"
					+ "choice text not null,"
					+ "weight integer" + ");");

			// db.execSQL("create table SendingDataDetails (_id integer primary key autoincrement,"
			// +
			// "date text not null,Drugs text not null,DrugsQuestions text not null,Questionnaires text not null,InclusionForm text not null,Doctor text not null"
			// + ");" ) ;
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Toast.makeText(
					context,
					"Mise à jour de la base de données de la version"
							+ oldVersion + "vers la version" + newVersion,
							Toast.LENGTH_SHORT).show();
			db.execSQL("DROP TABLE IF EXISTS Patient");
			db.execSQL("DROP TABLE IF EXISTS Doctor");
			db.execSQL("DROP TABLE IF EXISTS Language");
			db.execSQL("DROP TABLE IF EXISTS AnswerContent_translate");
			db.execSQL("DROP TABLE IF EXISTS Scores");
			db.execSQL("DROP TABLE IF EXISTS ScoreTypes");
			db.execSQL("DROP TABLE IF EXISTS QAContents");
			db.execSQL("DROP TABLE IF EXISTS QuestionContent_translate");
			db.execSQL("DROP TABLE IF EXISTS Countries");
			db.execSQL("DROP TABLE IF EXISTS Drug_Content");
			db.execSQL("DROP TABLE IF EXISTS Answers");
			db.execSQL("DROP TABLE IF EXISTS Drugs");
			db.execSQL("DROP TABLE IF EXISTS QAFamilies");
			db.execSQL("DROP TABLE IF EXISTS DrugFreqOrDoses");
			db.execSQL("DROP TABLE IF EXISTS QuestionnairesConfigurations");
			db.execSQL("DROP TABLE IF EXISTS QuestionsConfigurations");
			db.execSQL("DROP TABLE IF EXISTS SmartPhoneConfigurations");
			db.execSQL("DROP TABLE IF EXISTS DrugType");
			db.execSQL("DROP TABLE IF EXISTS m_scales");
			db.execSQL("DROP TABLE IF EXISTS m_test");
			db.execSQL("DROP TABLE IF EXISTS m_reponses");
			db.execSQL("DROP TABLE IF EXISTS m_questions");
			db.execSQL("DROP TABLE IF EXISTS m_decision");
			db.execSQL("DROP TABLE IF EXISTS m_choices");
			onCreate(db);
		}
	}

	public DBAdapter open() {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
	}

	public void Truncate() {
		db.execSQL("DELETE FROM Patient");

	}

	public long insertPatient(String Login, String Password) {
		ContentValues values = new ContentValues();
		values.put("Login", Login);
		values.put("Password", Password);
		return db.insert("Patient", null, values);
	}

	public long InsertAnswer(int _idAnswers, String Value, String refQAContent,
			String date, int _idPatientAnswers) {

		ContentValues values = new ContentValues();
		values.put("_idAnswers", _idAnswers);
		values.put("Value", Value);
		values.put("refQAContent", refQAContent);
		values.put("Date", date);
		values.put("_idPatientAnswers", _idPatientAnswers);
		values.put("sendingState", "1");
		return db.insert("Answers", null, values);
	}

	public long InsertScore(float Value, String date, String _refScoreType,
			int _idPatient) {

		ContentValues values = new ContentValues();

		values.put("Value", Value);
		values.put("Date", date);
		values.put("refScoreType", _refScoreType);
		values.put("_idPatient", _idPatient);
		values.put("sendingState", "1");
		return db.insert("Scores", null, values);
	}

	public long InsertDoctor(String FirstName, String LastName, String Phone,
			String Mobile, String Occupation, String Mail, int _idPatient,
			String Date) {

		ContentValues values = new ContentValues();

		values.put("FirstName", FirstName);
		values.put("LastName", LastName);
		values.put("Phone", Phone);
		values.put("Mobile", Mobile);
		values.put("Occupation", Occupation);
		values.put("Mail", Mail);
		values.put("_idPatient", _idPatient);
		values.put("Date", Date);
		String un = "1";
		values.put("sendingState", un);

		return db.insert("Doctor", null, values);
	}

	public long InsertCountry(int _idCountries, String Code) {

		ContentValues values = new ContentValues();
		values.put("_idCountries", _idCountries);
		values.put("Code", Code);

		return db.insert("Countries", null, values);

	}

	public long InsertDrugFreqOrDoses(int _idDrugFreqOrDoses, int Type,
			String Val, int _idDrug_ContentFreqOrDoses) {

		ContentValues values = new ContentValues();
		values.put("_idDrugFreqOrDoses", _idDrugFreqOrDoses);
		values.put("Type", Type);
		values.put("Val", Val);
		values.put("_idDrug_ContentFreqOrDoses", _idDrug_ContentFreqOrDoses);

		return db.insert("DrugFreqOrDoses", null, values);

	}

	public long InsertDrug(int _idDrugs, String RefDrugContent,
			String Frequency, String Dose, int _idPatientDrugs, String Date) {

		ContentValues values = new ContentValues();
		values.put("_idDrugs", _idDrugs);
		values.put("RefDrugContent", RefDrugContent);
		values.put("Frequency", Frequency);
		values.put("Dose", Dose);
		values.put("_idPatientDrugs", _idPatientDrugs);
		values.put("Date", Date);
		values.put("sendingState", "1");

		return db.insert("Drugs", null, values);

	}

	public long InsertDrugType(int _idDrugType, String Name, int Type) {

		ContentValues values = new ContentValues();
		values.put("_idDrugType", _idDrugType);
		values.put("Name", Name);
		values.put("Type", Type);
		return db.insert("DrugType", null, values);

	}

	public long InsertDrug_Content(int _idDrug_Content, String Ref, int Type,
			String Name, int _idLanguageDrug, int _idCountriesDrug) {

		ContentValues values = new ContentValues();
		values.put("_idDrug_Content", _idDrug_Content);
		values.put("Ref", Ref);
		values.put("Type", Type);
		values.put("Name", Name);
		values.put("_idLanguageDrug", _idLanguageDrug);
		values.put("_idCountriesDrug", _idCountriesDrug);
		return db.insert("Drug_Content", null, values);

	}

	public long InsertLanguage(int _idLanguage, String Code) {

		ContentValues values = new ContentValues();
		values.put("_idLanguage", _idLanguage);
		values.put("Code", Code);

		return db.insert("Language", null, values);

	}

	public long InsertAnswerTable(int _idAnswer, String A1, String A2,
			String A3, String A4, String A5, String A6, String A7, String A8) {
		ContentValues values = new ContentValues();
		values.put("_idAnswer", _idAnswer);
		values.put("A1", A1);
		values.put("A2", A2);
		values.put("A3", A3);
		values.put("A4", A4);
		values.put("A5", A5);
		values.put("A6", A6);
		values.put("A7", A7);
		values.put("A8", A8);
		return db.insert("AnswerContent_translate", null, values);

	}

	public long InsertQuestionContent_translate(
			int _idQuestionContent_translate, String Question,
			int _idQAContentsTranslate, int _idLanguageTranslate,
			int _idAnswerTranslate) {
		ContentValues values = new ContentValues();
		values.put("_idQuestionContent_translate", _idQuestionContent_translate);
		values.put("Question", Question);
		values.put("_idQAContentsTranslate", _idQAContentsTranslate);
		values.put("_idLanguageTranslate", _idLanguageTranslate);
		values.put("_idAnswerTranslate", _idAnswerTranslate);

		return db.insert("QuestionContent_translate", null, values);

	}

	public long InsertQAContents(int _idQAContents, String Ref, int Category,
			int Type, int Position, int _idQAFamiliesContent,
			int _idScoreTypesQA) {

		ContentValues values = new ContentValues();
		values.put("_idQAContents", _idQAContents);
		values.put("Ref", Ref);
		values.put("Category", Category);
		values.put("Type", Type);
		values.put("Position", Position);
		values.put("_idQAFamiliesContent", _idQAFamiliesContent);
		values.put("_idScoreTypesQA", _idScoreTypesQA);

		return db.insert("QAContents", null, values);

	}

	public long InsertQAFamilies(int _idQAFamilies, String Name, int Type) {

		ContentValues values = new ContentValues();
		values.put("_idQAFamilies", _idQAFamilies);
		values.put("Name", Name);
		values.put("Type", Type);

		return db.insert("QAFamilies", null, values);

	}

	public long InsertScoreTypes(int _idScoreTypes, String Name, String Ref) {

		ContentValues values = new ContentValues();
		values.put("_idScoreTypes", _idScoreTypes);
		values.put("Name", Name);
		values.put("Ref", Ref);

		return db.insert("ScoreTypes", null, values);

	}

	public long insertChoice(int refchoices, int refques, String choice,
			int weight) {
		ContentValues values = new ContentValues();
		values.put("ref_choices", refchoices);
		values.put("refquestion", refques);
		values.put("choice", choice);
		values.put("weight", weight);
		return db.insert("m_choices", null, values);

	}

	public long insertDecision(int refdecision, int refscale, String type,
			int infscore, int supscore, String decision) {
		ContentValues values = new ContentValues();
		values.put("ref_decision", refdecision);
		values.put("refscale", refscale);
		values.put("type", type);
		values.put("inf_score", infscore);
		values.put("sup_score", supscore);
		values.put("decision", decision);
		return db.insert("m_decision", null, values);

	}

	public long insertQuestion(int refquest, int refscale, String question,
			String type) {
		ContentValues values = new ContentValues();
		values.put("refquest", refquest);
		values.put("refscale", refscale);
		values.put("question", question);
		values.put("type", type);
		return db.insert("m_questions", null, values);

	}

	public long insertScale(int refscale, String name, String date) {
		ContentValues values = new ContentValues();
		values.put("ref_scale", refscale);
		values.put("name", name);
		values.put("date", date);

		return db.insert("m_scales", null, values);

	}

	public long insertTest(int id, String date, String scale,
			String testdecision, int scoreAnxiety, int scoreDepression) {
		ContentValues values = new ContentValues();

		values.put("id", id);
		values.put("dat_test", date);
		values.put("scale", scale);
		values.put("test_decision", testdecision);
		values.put("score_anxiety", scoreAnxiety);
		values.put("score_depression", scoreDepression);

		return db.insert("m_test", null, values);

	}

	public boolean supprimerPatient(long id) {
		return db.delete("Patient", "_id=" + id, null) > 0;
	}

	public Cursor recupererListePatient() {
		return db.query("Patient", new String[] { "_id", "Login", "Password" },
				null, null, null, null, null);
	}

	public boolean Login(String username, String password) throws SQLException {
		Cursor mCursor = db.rawQuery("SELECT * FROM " + "Patient"
				+ " WHERE Login=? AND Password=?", new String[] { username,
				password });
		if (mCursor != null) {
			if (mCursor.getCount() > 0) {
				return true;
			}
		}
		return false;
	}

	public int GetValue(String username, String password) {
		Cursor mCursor = db.rawQuery("SELECT _id FROM " + "Patient"
				+ " WHERE Login=? AND Password=?", new String[] { username,
				password });

		if (mCursor.moveToFirst()) {
			int id = mCursor.getInt(mCursor.getColumnIndex("_id"));
			// Toast.makeText(context, id, Toast.LENGTH_LONG).show();
			return id;
		} else {
			return -1;
		}
	}

	public String GetInfo() {
		Cursor mCursor = db.rawQuery("SELECT A1,A2,A3 FROM "
				+ "AnswerContent_translate" + " WHERE _idAnswer=? ",
				new String[] { "13" });

		if (mCursor.moveToFirst()) {
			String id = mCursor.getString(mCursor.getColumnIndex("A1"));
			Toast.makeText(context, id, Toast.LENGTH_LONG).show();
			return id;
		} else {
			return null;
		}
	}

	public String GetInfoDoc() {
		Cursor mCursor = db.rawQuery("SELECT Firstname,Lastname,Phone FROM "
				+ "Doctor" + " WHERE _idDoctor=? ", new String[] { "1" });
		if (mCursor.moveToFirst()) {
			String id = mCursor.getString(mCursor.getColumnIndex("Firstname"));
			Toast.makeText(context, id, Toast.LENGTH_LONG).show();
			return id;
		} else {
			return null;
		}
	}

	public String GetInfoAnswer() {
		Cursor mCursor = db.rawQuery("SELECT id,_idAnswers,refQAContent FROM "
				+ "Answers" + " WHERE id=? ", new String[] { "1" });
		if (mCursor.moveToFirst()) {
			String id = mCursor.getString(mCursor.getColumnIndex("_idAnswers"));
			Toast.makeText(context, id, Toast.LENGTH_LONG).show();
			String id1 = mCursor.getString(mCursor
					.getColumnIndex("refQAContent"));
			Toast.makeText(context, id1, Toast.LENGTH_LONG).show();

			return id;
		} else {
			return null;
		}
	}

	public String GetInfoDrug() {
		Cursor mCursor = db.rawQuery("SELECT id,_idDrugs,RefDrugContent FROM "
				+ "Drugs" + " WHERE id=? ", new String[] { "2" });
		if (mCursor.moveToFirst()) {
			String id = mCursor.getString(mCursor.getColumnIndex("_idDrugs"));
			Toast.makeText(context, id, Toast.LENGTH_LONG).show();
			String id1 = mCursor.getString(mCursor
					.getColumnIndex("RefDrugContent"));
			Toast.makeText(context, id1, Toast.LENGTH_LONG).show();
			return id;
		} else {
			return null;
		}
	}

	public String GetInfoScore() {
		Cursor mCursor = db.rawQuery("SELECT _idScores,Value FROM " + "Scores"
				+ " WHERE _idScores=? ", new String[] { "10" });
		if (mCursor.moveToFirst()) {
			String id = mCursor.getString(mCursor.getColumnIndex("Value"));
			Toast.makeText(context, id, Toast.LENGTH_LONG).show();
			return id;
		} else {
			return null;
		}
	}

	public ArrayList<String> GetSkeletonSwollen() {
		Cursor dCursor = db.rawQuery("SELECT A1,A2,A3,A4 FROM "
				+ "AnswerContent_translate" + " WHERE _idAnswer=? ",
				new String[] { "3" });
		if (dCursor.moveToFirst()) {
			ArrayList<String> Skeleton = new ArrayList<String>();
			String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
			Skeleton.add(A1);
			String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
			Skeleton.add(A2);
			String A3 = dCursor.getString(dCursor.getColumnIndex("A3"));
			Skeleton.add(A3);
			String A4 = dCursor.getString(dCursor.getColumnIndex("A4"));
			Skeleton.add(A4);

			return Skeleton;
		} else
			return Skeleton0;
	}

	public ArrayList<String> GetHAQ() {
		Cursor dCursor = db.rawQuery("SELECT A1,A2,A3,A4 FROM "
				+ "AnswerContent_translate" + " WHERE _idAnswer=? ",
				new String[] { "2" });
		if (dCursor.moveToFirst()) {
			ArrayList<String> HAQ = new ArrayList<String>();
			String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
			HAQ.add(A1);
			String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
			HAQ.add(A2);
			String A3 = dCursor.getString(dCursor.getColumnIndex("A3"));
			HAQ.add(A3);
			String A4 = dCursor.getString(dCursor.getColumnIndex("A4"));
			HAQ.add(A4);
			return HAQ;
		} else
			return null;
	}

	public ArrayList<String> GetFatigue() {
		Cursor dCursor = db.rawQuery("SELECT A1,A2,A3,A4,A5 FROM "
				+ "AnswerContent_translate" + " WHERE _idAnswer=? ",
				new String[] { "1" });
		if (dCursor.moveToFirst()) {
			ArrayList<String> Fatigue = new ArrayList<String>();
			// Fatigue.add(Controller.NoAnswer);
			String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
			Fatigue.add(A1);
			String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
			Fatigue.add(A2);
			String A3 = dCursor.getString(dCursor.getColumnIndex("A3"));
			Fatigue.add(A3);
			String A4 = dCursor.getString(dCursor.getColumnIndex("A4"));
			Fatigue.add(A4);
			String A5 = dCursor.getString(dCursor.getColumnIndex("A5"));
			Fatigue.add(A5);
			return Fatigue;
		} else
			return null;
	}

	public ArrayList<String> GetYesNo() {
		Cursor dCursor = db.rawQuery("SELECT A1,A2 FROM "
				+ "AnswerContent_translate" + " WHERE _idAnswer=? ",
				new String[] { "4" });
		if (dCursor.moveToFirst()) {
			ArrayList<String> YesNo = new ArrayList<String>();
			String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
			YesNo.add(A1);
			String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
			YesNo.add(A2);
			return YesNo;
		} else
			return null;
	}

	public ArrayList<String> GetQuestionFicheInclusionDoctorActivity() {
		Cursor dCursor = db.rawQuery("SELECT A1,A2,A3,A4 FROM "
				+ "AnswerContent_translate" + " WHERE _idAnswer=? ",
				new String[] { "16" });
		if (dCursor.moveToFirst()) {
			ArrayList<String> DoctorActivity = new ArrayList<String>();
			String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
			DoctorActivity.add(A1);
			String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
			DoctorActivity.add(A2);
			String A3 = dCursor.getString(dCursor.getColumnIndex("A3"));
			DoctorActivity.add(A3);
			String A4 = dCursor.getString(dCursor.getColumnIndex("A4"));
			DoctorActivity.add(A4);
			return DoctorActivity;
		} else
			return DoctorActivity0;
	}

	public String GetRefQAContent(int id) {
		int refr = 0;
		String refer = null;
		String[] whereArguments = { String.valueOf(id) };
		String[] columns = { "_idQAContentsTranslate" };
		Cursor dCursor = db.query("QuestionContent_translate", columns,
				"_idQuestionContent_translate = ? ", whereArguments, null,
				null, null);

		if (dCursor.moveToFirst()) {

			refr = dCursor.getInt(dCursor
					.getColumnIndex("_idQAContentsTranslate"));
		}
		String[] Arguments = { String.valueOf(refr) };
		String[] column = { "Ref" };
		Cursor mCursor = db.query("QAContents", column, "_idQAContents = ? ",
				Arguments, null, null, null);

		if (mCursor.moveToFirst()) {

			refer = mCursor.getString(mCursor.getColumnIndex("Ref"));

		}
		// Cursor mCursor= db.rawQuery("SELECT Ref FROM " + "QAContents" +
		// " WHERE _idQAContents=? ", new String[]{String.valueOf(refr)});
		// String reference = null;
		// if(mCursor.moveToFirst()){
		// String reference = null;
		// String refer = mCursor.getString(dCursor.getColumnIndex("Ref"));
		// if (id == 1) {reference="HI7";}
		// if (id == 3) {reference="HI12";}
		// if (id == 4) {reference="An1";}
		// if (id == 5) {reference="An2";}
		// if (id == 7) {reference="An3";}
		// if (id == 9) {reference="An4";}
		// if (id == 10) {reference="An5";}
		// if (id == 11) {reference="An7";}
		// if (id == 12) {reference="An8";}
		// if (id == 13) {reference="An12";}
		// if (id == 14) {reference="An14";}
		// if (id == 15) {reference="An15";}
		// if (id == 16) {reference="An16";}
		// if (id == 17) {reference="RAP3_1_1";}
		// if (id == 18) {reference="RAP3_1_2";}
		// if (id == 19) {reference="RAP3_1_3";}
		// if (id == 20) {reference="RAP3_1_4";}
		// if (id == 21) {reference="RAP3_1_5";}
		// if (id == 22) {reference="RAP3_1_6";}
		// if (id == 23) {reference="RAP3_1_7";}
		// if (id == 24) {reference="RAP3_1_8";}
		// if (id == 25) {reference="RAP3_1_9";}
		// if (id == 26) {reference="RAP3_1_10";}
		// if (id == 27) {reference="RAP3_2";}
		// if (id == 28) {reference="RAP3_3";}
		// if (id == 29) {reference="JOINT_P_LF";}
		// if (id == 30) {reference="JOINT_P_RF";}
		// if (id == 32) {reference="JOINT_P_LW";}
		// if (id == 33) {reference="JOINT_P_RW";}
		// if (id == 34) {reference="JOINT_P_LE";}
		// if (id == 35) {reference="JOINT_P_RE";}
		// if (id == 36) {reference="JOINT_P_LSh";}
		// if (id == 37) {reference="JOINT_P_RSh";}
		// if (id == 38) {reference="JOINT_P_LT";}
		// if (id == 39) {reference="JOINT_P_RT";}
		// if (id == 40) {reference="JOINT_P_LA";}
		// if (id == 41) {reference="JOINT_P_RA";}
		// if (id == 42) {reference="JOINT_P_LK";}
		// if (id == 43) {reference="JOINT_P_RK";}
		// if (id == 49) {reference="JOINT_P_LH";}
		// if (id == 50) {reference="JOINT_P_RH";}
		// if (id == 53) {reference="RAP4_5";}
		// if (id == 54) {reference="RAD5_1";}
		// if (id == 55) {reference="RAD5_2";}
		// if (id == 56) {reference="RAD5_3";}
		// if (id == 57) {reference="RAD5_4";}
		// if (id == 58) {reference="RAD5_5";}
		// if (id == 59) {reference="HAQ1_1_RAP3";}
		// if (id == 60) {reference="HAQ1_2";}
		// if (id == 61) {reference="HAQ2_1";}
		// if (id == 62) {reference="HAQ2_2_RAP3";}
		// if (id == 63) {reference="HAQ3_1";}
		// if (id == 64) {reference="HAQ3_2_RAP3";}
		// if (id == 65) {reference="HAQ3_3";}
		// if (id == 66) {reference="HAQ4_1_RAP3";}
		// if (id == 67) {reference="HAQ4_2";}
		// if (id == 68) {reference="HAQ5_1_RAP3";}
		// if (id == 69) {reference="HAQ5_2";}
		// if (id == 70) {reference="HAQ5_3";}
		// if (id == 71) {reference="HAQ6_1";}
		// if (id == 72) {reference="HAQ6_2_RAP3";}
		// if (id == 73) {reference="HAQ7_2";}
		// if (id == 74) {reference="HAQ7_3_RAP3";}
		// if (id == 75) {reference="HAQ8_1";}
		// if (id == 76) {reference="HAQ8_2_RAP3";}
		// if (id == 77) {reference="HAQ8_3";}
		// if (id == 81) {reference="HAQ7_1";}
		// if (id == 82) {reference="BT1";}
		// if (id == 85) {reference="XRAY1";}
		// if (id == 86) {reference="PHT";}
		// if (id == 87) {reference="BT2";}
		// if (id == 88) {reference="XRAY2";}
		// if (id == 89) {reference="OC1";}
		// if (id == 90) {reference="OC2";}
		// if (id == 91) {reference="SE";}
		// if (id == 92) {reference="DAS28_VS";}
		// if (id == 93) {reference="DAS28_CRP";}
		// if (id == 94) {reference="DAS28_1";}
		// if (id == 95) {reference="JOINT_S_LF";}
		// if (id == 96) {reference="JOINT_S_RF";}
		// if (id == 97) {reference="JOINT_S_LW";}
		// if (id == 98) {reference="JOINT_S_RW";}
		// if (id == 99) {reference="JOINT_S_LE";}
		// if (id == 100) {reference="JOINT_S_RE";}
		// if (id == 101) {reference="JOINT_S_LSh";}
		// if (id == 102) {reference="JOINT_S_RSh";}
		// if (id == 103) {reference="JOINT_S_LT";}
		// if (id == 104) {reference="JOINT_S_RT";}
		// if (id == 105) {reference="JOINT_S_LA";}
		// if (id == 106) {reference="JOINT_S_RA";}
		// if (id == 107) {reference="JOINT_S_LK";}
		// if (id == 108) {reference="JOINT_S_RK";}
		// if (id == 109) {reference="JOINT_S_LH";}
		// if (id == 110) {reference="JOINT_S_RH";}
		// if (id == 111) {reference="HAQ1_1_C";}
		// if (id == 112) {reference="HAQ1_2_C";}
		// if (id == 114) {reference="HAQ1_3_C";}
		// if (id == 115) {reference="HAQ3_1_C";}
		// if (id == 117) {reference="IF_C";}
		// if (id == 118) {reference="IF_RF";}
		// if (id == 119) {reference="IF_AI";}
		// if (id == 122) {reference="IF_AF";}
		// if (id == 123) {reference="IF_DT";}
		// if (id == 124) {reference="IF_DT_D";}
		// if (id == 125) {reference="IF_G";}
		// if (id == 126) {reference="IF_G_D";}
		// if (id == 127) {reference="IF_PN";}
		// if (id == 128) {reference="IF_PN_D";}
		// if (id == 129) {reference="IF_DOC_P";}
		// if (id == 130) {reference="IF_DOC_AD";}
		// if (id == 131) {reference="IF_DOC_FN";}
		// if (id == 133) {reference="HAQ2_1_C";}
		// if (id == 134) {reference="HAQ4_1_C";}
		// if (id == 135) {reference="HAQ4_2_C";}
		// if (id == 137) {reference="HAQ4_3_C";}
		// if (id == 138) {reference="HAQ4_4_C";}
		// if (id == 139) {reference="HAQ4_5_C";}
		// if (id == 140) {reference="HAQ5_1_C";}
		// if (id == 141) {reference="HAQ5_2_C";}
		// if (id == 142) {reference="HAQ5_3_C";}
		// if (id == 143) {reference="HAQ5_4_C";}
		// if (id == 144) {reference="HAQ5_5_C";}
		// if (id == 145) {reference="HAQ6_1_C";}
		// if (id == 146) {reference="HAQ6_2_C";}
		// if (id == 147) {reference="HAQ7_1_C";}
		// if (id == 148) {reference="HAQ7_2_C";}
		// if (id == 149) {reference="HAQ8_1_C";}
		// if (id == 151) {reference="IF_DOC_LN";}
		// if (id == 152) {reference="IF_DOC_PH";}
		// if (id == 153) {reference="IF_DOC_MO";}
		// if (id == 154) {reference="IF_DOC_EM";}
		// if (id == 155) {reference="DAS28_CRP";}
		// if (id == 156) {reference="";}
		// if (id == 157) {reference="";}
		// if (id == 158) {reference="";}
		// if (id == 159) {reference="";}
		// if (id == 160) {reference="";}
		// if (id == 161) {reference="DAS28_1";}
		// if (id == 162) {reference="RAP3_3";}
		// if (id == 163) {reference="RAP3_2";}
		// if (id == 164) {reference="";}
		// if (id == 165) {reference="RAP4_5";}
		// if (id == 166) {reference="";}
		// if (id == 167) {reference="";}
		// if (id == 168) {reference="DAS28_VS";}
		// if (id == 169) {reference="DAS28_CRP";}
		// if (id == 170) {reference="HAQ1_1_C";}
		// if (id == 171) {reference="HAQ3_1_C";}
		// if (id == 172) {reference="HAQ5_3_C";}
		// if (id == 173) {reference="HAQ7_3_RAP3";}
		// if (id == 174) {reference="HAQ5_3";}
		// if (id == 175) {reference="O_Int";}

		return refer;

	}

	public ArrayList<String> GetQuestionFicheInclusionActivity() {
		Cursor dCursor = db.rawQuery("SELECT A1,A2,A3,A4,A5 FROM "
				+ "AnswerContent_translate" + " WHERE _idAnswer=? ",
				new String[] { "18" });
		if (dCursor.moveToFirst()) {
			ArrayList<String> PatientActivity = new ArrayList<String>();
			String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
			PatientActivity.add(A1);
			String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
			PatientActivity.add(A2);
			String A3 = dCursor.getString(dCursor.getColumnIndex("A3"));
			PatientActivity.add(A3);
			String A4 = dCursor.getString(dCursor.getColumnIndex("A4"));
			PatientActivity.add(A4);
			String A5 = dCursor.getString(dCursor.getColumnIndex("A5"));
			PatientActivity.add(A5);
			return PatientActivity;
		} else
			return PatientActivity0;
	}

	public String GetDrugRef(int id) {
		String DrugRef = null;

		String[] whereArguments = { String.valueOf(id) };
		String[] columns = { "Ref" };
		Cursor dCursor = db.query("Drug_Content", columns,
				"_idDrug_Content = ? ", whereArguments, null, null, null);

		if (dCursor.moveToFirst()) {

			DrugRef = dCursor.getString(dCursor.getColumnIndex("Ref"));
		}
		// if (id == 1) {DrugRef="ARA";}
		// if (id == 2) {DrugRef="COR";}
		// if (id == 3) {DrugRef="ME";}
		// if (id == 4) {DrugRef="PL";}
		// if (id == 5) {DrugRef="SA";}
		// if (id == 8) {DrugRef="CI";}
		// if (id == 9) {DrugRef="EN";}
		// if (id == 10) {DrugRef="HU";}
		// if (id == 11) {DrugRef="IM";}
		// if (id == 12) {DrugRef="KI";}
		// if (id == 13) {DrugRef="MA";}
		// if (id == 14) {DrugRef="OR";}
		// if (id == 15) {DrugRef="ROA";}
		// if (id == 16) {DrugRef="SY";}
		// if (id == 17) {DrugRef="RE";}
		// if (id == 18) {DrugRef="ANN";}
		// if (id == 20) {DrugRef="ARC";}
		// if (id == 21) {DrugRef="BK";}
		// if (id == 22) {DrugRef="CEB";}
		// if (id == 24) {DrugRef="CEL";}
		// if (id == 25) {DrugRef="FPBT";}
		// if (id == 26) {DrugRef="VD";}
		// if (id == 27) {DrugRef="IN";}
		// if (id == 28) {DrugRef="CH";}
		// if (id == 29) {DrugRef="PKc";}
		// if (id == 30) {DrugRef="PKg";}
		// if (id == 31) {DrugRef="MM";}
		// if (id == 32) {DrugRef="CA";}
		// if (id == 33) {DrugRef="AINS";}
		// if (id == 34) {DrugRef="GEP";}
		// if (id == 36) {DrugRef="GEF";}
		// if (id == 37) {DrugRef="ACT";}
		// if (id == 38) {DrugRef="EF";}
		// if (id == 39) {DrugRef="ACU";}
		// if (id == 40) {DrugRef="CTT";}
		// if (id == 41) {DrugRef="DC";}
		// if (id == 42) {DrugRef="DPE";}
		// if (id == 44) {DrugRef="ECKC";}
		// if (id == 45) {DrugRef="IX";}
		// if (id == 47) {DrugRef="LA";}
		// if (id == 52) {DrugRef="PKim";}

		return DrugRef;
	}

	public String GetScoreRef(int id) {
		String ScoreRef = null;

		String[] whereArguments = { String.valueOf(id) };
		String[] columns = { "Ref" };
		Cursor dCursor = db.query("ScoreTypes", columns, "_idScoreTypes = ? ",
				whereArguments, null, null, null);

		if (dCursor.moveToFirst()) {

			ScoreRef = dCursor.getString(dCursor.getColumnIndex("Ref"));
		}
		// if (id == 1) {DrugRef="ARA";}
		// if (id == 2) {DrugRef="COR";}
		// if (id == 3) {DrugRef="ME";}
		// if (id == 4) {DrugRef="PL";}
		// if (id == 5) {DrugRef="SA";}
		// if (id == 8) {DrugRef="CI";}
		// if (id == 9) {DrugRef="EN";}
		// if (id == 10) {DrugRef="HU";}
		// if (id == 11) {DrugRef="IM";}
		// if (id == 12) {DrugRef="KI";}
		// if (id == 13) {DrugRef="MA";}
		// if (id == 14) {DrugRef="OR";}
		// if (id == 15) {DrugRef="ROA";}
		// if (id == 16) {DrugRef="SY";}
		// if (id == 17) {DrugRef="RE";}
		// if (id == 18) {DrugRef="ANN";}
		// if (id == 20) {DrugRef="ARC";}
		// if (id == 21) {DrugRef="BK";}
		// if (id == 22) {DrugRef="CEB";}
		// if (id == 24) {DrugRef="CEL";}
		// if (id == 25) {DrugRef="FPBT";}
		// if (id == 26) {DrugRef="VD";}
		// if (id == 27) {DrugRef="IN";}
		// if (id == 28) {DrugRef="CH";}
		// if (id == 29) {DrugRef="PKc";}
		// if (id == 30) {DrugRef="PKg";}
		// if (id == 31) {DrugRef="MM";}
		// if (id == 32) {DrugRef="CA";}
		// if (id == 33) {DrugRef="AINS";}
		// if (id == 34) {DrugRef="GEP";}
		// if (id == 36) {DrugRef="GEF";}
		// if (id == 37) {DrugRef="ACT";}
		// if (id == 38) {DrugRef="EF";}
		// if (id == 39) {DrugRef="ACU";}
		// if (id == 40) {DrugRef="CTT";}
		// if (id == 41) {DrugRef="DC";}
		// if (id == 42) {DrugRef="DPE";}
		// if (id == 44) {DrugRef="ECKC";}
		// if (id == 45) {DrugRef="IX";}
		// if (id == 47) {DrugRef="LA";}
		// if (id == 52) {DrugRef="PKim";}

		return ScoreRef;
	}

	public ArrayList<String> GetGender() {
		Cursor dCursor = db.rawQuery("SELECT A1,A2 FROM "
				+ "AnswerContent_translate" + " WHERE _idAnswer=? ",
				new String[] { "17" });
		if (dCursor.moveToFirst()) {
			ArrayList<String> Gender = new ArrayList<String>();
			String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
			Gender.add(A1);
			String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
			Gender.add(A2);

			return Gender;
		} else
			return Gender0;
	}

	public ArrayList<ArrayList<String>> GetQuestionFI() {
		// Cursor dCursor= db.rawQuery("SELECT Question FROM " +
		// "QuestionContent_translate" +
		// " WHERE _idQuestionContent_translate in? ", new String[]{"117,118"});

		String[] whereArguments = { "117", "118", "119", "122", "123", "124",
				"125", "126", "127", "128", "156", "157", "158" };
		String[] columns = { "Question", "_idAnswerTranslate",
		"_idQuestionContent_translate" };
		Cursor dCursor = db
				.query("QuestionContent_translate",
						columns,
						"_idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?",
						whereArguments, null, null, null);
		// ,118,119,122,123,124,125,126,127,128

		// Cursor sCursor = db.query("QuestionContent_translate", "Question",
		// "_idQuestionContent_translate = ? OR _idQuestionContent_translate = ?",
		// whereArguments, null, null, null, null);
		ArrayList<ArrayList<String>> Questions = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> QuestionContent = new ArrayList<String>();
					// ArrayList<String> QuestionID = new ArrayList<String>();
					String Question = dCursor.getString(dCursor
							.getColumnIndex("Question"));
					QuestionContent.add(Question);
					int ID = dCursor.getInt(dCursor
							.getColumnIndex("_idAnswerTranslate"));
					QuestionContent.add(String.valueOf(ID));
					int IDD = dCursor.getInt(dCursor
							.getColumnIndex("_idQuestionContent_translate"));
					QuestionContent.add(String.valueOf(IDD));
					Questions.add(QuestionContent);
				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return Questions;

	}

	public ArrayList<String> GetQuestionDS() {
		// Cursor dCursor= db.rawQuery("SELECT Question FROM " +
		// "QuestionContent_translate" +
		// " WHERE _idQuestionContent_translate in? ", new String[]{"117,118"});

		String[] whereArguments = { "215" };
		String[] columns = { "Question", "_idAnswerTranslate",
		"_idQuestionContent_translate" };
		Cursor dCursor = db
				.query("QuestionContent_translate",
						columns,
						"_idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?",
						whereArguments, null, null, null);
		// ,118,119,122,123,124,125,126,127,128

		// Cursor sCursor = db.query("QuestionContent_translate", "Question",
		// "_idQuestionContent_translate = ? OR _idQuestionContent_translate = ?",
		// whereArguments, null, null, null, null);
		ArrayList<String> Questions = new ArrayList<String>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> QuestionContent = new ArrayList<String>();
					// ArrayList<String> QuestionID = new ArrayList<String>();
					String Question = dCursor.getString(dCursor
							.getColumnIndex("Question"));
					QuestionContent.add(Question);
					int ID = dCursor.getInt(dCursor
							.getColumnIndex("_idAnswerTranslate"));
					QuestionContent.add(String.valueOf(ID));
					int IDD = dCursor.getInt(dCursor
							.getColumnIndex("_idQuestionContent_translate"));
					QuestionContent.add(String.valueOf(IDD));
					Questions = QuestionContent;
				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		Log.d("thequestionFromDBAdapter", String.valueOf(Questions));

		return Questions;
	}

	public ArrayList<ArrayList<String>> GetAntiInflammatoryList() {

		String[] whereArguments = { "3" };
		String[] columns = { "_idDrug_Content", "Ref", "Type", "Name" };
		Cursor dCursor = db.query("Drug_Content", columns, " Type = ?",
				whereArguments, null, null, null);
		ArrayList<ArrayList<String>> ListAntiInflammatory = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> ListAntiInflammatoryContent = new ArrayList<String>();
					int IDDrug = dCursor.getInt(dCursor
							.getColumnIndex("_idDrug_Content"));
					ListAntiInflammatoryContent.add(String.valueOf(IDDrug));
					String Ref = dCursor.getString(dCursor
							.getColumnIndex("Ref"));
					ListAntiInflammatoryContent.add(Ref);
					int Type = dCursor.getInt(dCursor.getColumnIndex("Type"));
					ListAntiInflammatoryContent.add(String.valueOf(Type));
					String Name = dCursor.getString(dCursor
							.getColumnIndex("Name"));
					ListAntiInflammatoryContent.add(Name);
					ListAntiInflammatory.add(ListAntiInflammatoryContent);
				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return ListAntiInflammatory;

	}

	public ArrayList<ArrayList<String>> GetanalgesicList() {

		String[] whereArguments = { "5" };
		String[] columns = { "_idDrug_Content", "Ref", "Type", "Name" };
		Cursor dCursor = db.query("Drug_Content", columns, " Type = ?",
				whereArguments, null, null, null);

		ArrayList<ArrayList<String>> AnalgesicList = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> AnalgesicListContent = new ArrayList<String>();
					int IDDrug = dCursor.getInt(dCursor
							.getColumnIndex("_idDrug_Content"));
					AnalgesicListContent.add(String.valueOf(IDDrug));
					String Ref = dCursor.getString(dCursor
							.getColumnIndex("Ref"));
					AnalgesicListContent.add(Ref);
					int Type = dCursor.getInt(dCursor.getColumnIndex("Type"));
					AnalgesicListContent.add(String.valueOf(Type));
					String Name = dCursor.getString(dCursor
							.getColumnIndex("Name"));
					AnalgesicListContent.add(Name);
					AnalgesicList.add(AnalgesicListContent);
				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return AnalgesicList;

	}

	public ArrayList<ArrayList<String>> GetBiotherapyList() {

		String[] whereArguments = { "1" };
		String[] columns = { "_idDrug_Content", "Ref", "Type", "Name" };
		Cursor dCursor = db.query("Drug_Content", columns, " Type = ?",
				whereArguments, null, null, null);
		ArrayList<ArrayList<String>> BiotherapyList = new ArrayList<ArrayList<String>>();

		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> BiotherapyListContent = new ArrayList<String>();
					int IDDrug = dCursor.getInt(dCursor
							.getColumnIndex("_idDrug_Content"));
					BiotherapyListContent.add(String.valueOf(IDDrug));
					String Ref = dCursor.getString(dCursor
							.getColumnIndex("Ref"));
					BiotherapyListContent.add(Ref);
					int Type = dCursor.getInt(dCursor.getColumnIndex("Type"));
					BiotherapyListContent.add(String.valueOf(Type));
					String Name = dCursor.getString(dCursor
							.getColumnIndex("Name"));
					BiotherapyListContent.add(Name);
					BiotherapyList.add(BiotherapyListContent);

				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return BiotherapyList;

	}

	public ArrayList<ArrayList<String>> GetDMARDList() {

		String[] whereArguments = { "2" };
		String[] columns = { "_idDrug_Content", "Ref", "Type", "Name" };
		Cursor dCursor = db.query("Drug_Content", columns, " Type = ?",
				whereArguments, null, null, null);

		ArrayList<ArrayList<String>> DMARDList = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> DMARDListContent = new ArrayList<String>();
					int IDDrug = dCursor.getInt(dCursor
							.getColumnIndex("_idDrug_Content"));
					DMARDListContent.add(String.valueOf(IDDrug));
					String Ref = dCursor.getString(dCursor
							.getColumnIndex("Ref"));
					DMARDListContent.add(Ref);
					int Type = dCursor.getInt(dCursor.getColumnIndex("Type"));
					DMARDListContent.add(String.valueOf(Type));
					String Name = dCursor.getString(dCursor
							.getColumnIndex("Name"));
					DMARDListContent.add(Name);
					DMARDList.add(DMARDListContent);

				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return DMARDList;

	}

	public ArrayList<ArrayList<String>> GetOCList() {

		String[] whereArguments = { "4" };
		String[] columns = { "_idDrug_Content", "Ref", "Type", "Name" };
		Cursor dCursor = db.query("Drug_Content", columns, " Type = ?",
				whereArguments, null, null, null);
		ArrayList<ArrayList<String>> OCList = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> OCListContent = new ArrayList<String>();
					int IDDrug = dCursor.getInt(dCursor
							.getColumnIndex("_idDrug_Content"));
					OCListContent.add(String.valueOf(IDDrug));
					String Ref = dCursor.getString(dCursor
							.getColumnIndex("Ref"));
					OCListContent.add(Ref);
					int Type = dCursor.getInt(dCursor.getColumnIndex("Type"));
					OCListContent.add(String.valueOf(Type));
					String Name = dCursor.getString(dCursor
							.getColumnIndex("Name"));
					OCListContent.add(Name);
					OCList.add(OCListContent);

				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return OCList;

	}

	public ArrayList<ArrayList<String>> GetDrugFreqOrDosesList() {

		String[] whereArguments = { "0", "1" };
		String[] columns = { "_idDrugFreqOrDoses", "Type", "Val",
		"_idDrug_ContentFreqOrDoses" };
		Cursor dCursor = db.query("DrugFreqOrDoses", columns,
				" Type = ? OR Type = ?", whereArguments, null, null, null);

		ArrayList<ArrayList<String>> DrugFreqOrDosesList = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> DrugFreqOrDosesListContent = new ArrayList<String>();
					int IDDrug = dCursor.getInt(dCursor
							.getColumnIndex("_idDrugFreqOrDoses"));
					DrugFreqOrDosesListContent.add(String.valueOf(IDDrug));
					int Type = dCursor.getInt(dCursor.getColumnIndex("Type"));
					DrugFreqOrDosesListContent.add(String.valueOf(Type));
					String Val = dCursor.getString(dCursor
							.getColumnIndex("Val"));
					DrugFreqOrDosesListContent.add(Val);
					int IDDrugFreqOrDoses = dCursor.getInt(dCursor
							.getColumnIndex("_idDrug_ContentFreqOrDoses"));
					DrugFreqOrDosesListContent.add(String
							.valueOf(IDDrugFreqOrDoses));
					DrugFreqOrDosesList.add(DrugFreqOrDosesListContent);

				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return DrugFreqOrDosesList;
	}

	public ArrayList<ArrayList<String>> GetListQuestion_M() {

		String[] whereArguments = { "89", "90", "159", "160" };
		String[] columns = { "_idQuestionContent_translate", "Question",
		"_idAnswerTranslate" };
		Cursor dCursor = db
				.query("QuestionContent_translate",
						columns,
						"_idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? ",
						whereArguments, null, null, null);

		ArrayList<ArrayList<String>> ListQuestion_M = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> ListQuestion = new ArrayList<String>();
					int idQuestion = dCursor.getInt(dCursor
							.getColumnIndex("_idQuestionContent_translate"));
					ListQuestion.add(String.valueOf(idQuestion));
					String Question = dCursor.getString(dCursor
							.getColumnIndex("Question"));
					ListQuestion.add(Question);
					int idAnswer = dCursor.getInt(dCursor
							.getColumnIndex("_idAnswerTranslate"));
					ListQuestion.add(String.valueOf(idAnswer));
					ListQuestion_M.add(ListQuestion);

				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return ListQuestion_M;
	}

	public ArrayList<ArrayList<String>> GetListQuestionEvaluationYN() {

		String[] whereArguments = { "54", "55", "56", "57", "58", "161", "162",
				"163", "164", "165", "166", "167", "168", "169" };
		String[] columns = { "_idQuestionContent_translate", "Question",
				"_idAnswerTranslate", "_idQAContentsTranslate" };
		Cursor dCursor = db
				.query("QuestionContent_translate",
						columns,
						"_idQuestionContent_translate = ? OR _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? ",
						whereArguments, null, null, null);

		ArrayList<ArrayList<String>> ListQuestionEvaluationYN = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> ListQuestionYN = new ArrayList<String>();
					int idQuestionYN = dCursor.getInt(dCursor
							.getColumnIndex("_idQuestionContent_translate"));
					ListQuestionYN.add(String.valueOf(idQuestionYN));
					String QuestionYN = dCursor.getString(dCursor
							.getColumnIndex("Question"));
					ListQuestionYN.add(QuestionYN);
					int idAnswer = dCursor.getInt(dCursor
							.getColumnIndex("_idAnswerTranslate"));
					ListQuestionYN.add(String.valueOf(idAnswer));
					int _idQAContentsTranslate = dCursor.getInt(dCursor
							.getColumnIndex("_idQAContentsTranslate"));
					ListQuestionYN.add(String.valueOf(_idQAContentsTranslate));
					ListQuestionEvaluationYN.add(ListQuestionYN);

				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return ListQuestionEvaluationYN;
	}

	public ArrayList<ArrayList<String>> GetAnswer() {
		// Cursor dCursor= db.rawQuery("SELECT Question FROM " +
		// "QuestionContent_translate" +
		// " WHERE _idQuestionContent_translate in? ", new String[]{"117,118"});

		String[] whereArguments = { "13", "14", "15" };
		String[] columns = { "_idAnswer", "A1", "A2", "A3", "A4", "A5", "A6" };
		Cursor dCursor = db
				.query("AnswerContent_translate",
						columns,
						"_idAnswer = ? OR _idAnswer = ? OR _idAnswer = ? OR _idAnswer = ?",
						whereArguments, null, null, null);
		// Cursor dCursor =
		// db.rawQuery("SELECT _idAnswer, A1,A2,A3,A4,A5,A6 FROM AnswerContent_translate where _idAnswer IN ("+makePlaceholders(whereArguments.length)+")",
		// null);

		// Cursor sCursor = db.query("QuestionContent_translate", "Question",
		// "_idQuestionContent_translate = ? OR _idQuestionContent_translate = ?",
		// whereArguments, null, null, null, null);
		ArrayList<ArrayList<String>> Answers = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> Answer1 = new ArrayList<String>();
					int _idAnswer = dCursor.getInt(dCursor
							.getColumnIndex("_idAnswer"));

					Answer1.add(String.valueOf(_idAnswer));
					// Answer1.add(GetIDQuestionTranslate(_idAnswer));
					String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
					Answer1.add(A1);
					String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
					Answer1.add(A2);
					String A3 = dCursor.getString(dCursor.getColumnIndex("A3"));
					Answer1.add(A3);
					String A4 = dCursor.getString(dCursor.getColumnIndex("A4"));
					Answer1.add(A4);
					String A5 = dCursor.getString(dCursor.getColumnIndex("A5"));
					Answer1.add(A5);
					String A6 = dCursor.getString(dCursor.getColumnIndex("A6"));
					Answer1.add(A6);
					Answers.add(Answer1);

				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return Answers;
	}

	public ArrayList<String> GetAnswerDS() {

		String[] whereArguments = { "19" };
		String[] columns = { "_idAnswer", "A1", "A2", "A3", "A4", "A5", "A6" };
		Cursor dCursor = db
				.query("AnswerContent_translate",
						columns,
						"_idAnswer = ? OR _idAnswer = ? OR _idAnswer = ? OR _idAnswer = ?",
						whereArguments, null, null, null);
		ArrayList<String> Answers = new ArrayList<String>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> Answer1 = new ArrayList<String>();
					int _idAnswer = dCursor.getInt(dCursor
							.getColumnIndex("_idAnswer"));

					Answer1.add(String.valueOf(_idAnswer));
					// Answer1.add(GetIDQuestionTranslate(_idAnswer));
					String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
					Answer1.add(A1);
					String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
					Answer1.add(A2);
					String A3 = dCursor.getString(dCursor.getColumnIndex("A3"));
					Answer1.add(A3);
					String A4 = dCursor.getString(dCursor.getColumnIndex("A4"));
					Answer1.add(A4);
					String A5 = dCursor.getString(dCursor.getColumnIndex("A5"));
					Answer1.add(A5);
					String A6 = dCursor.getString(dCursor.getColumnIndex("A6"));
					Answer1.add(A6);
					Answers = Answer1;

				} while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return Answers;
	}

	public ArrayList<ArrayList<String>> GetHAQQuestions() {
		String[] whereArguments = { "59", "60", "170", "112", "63", "64", "65",
				"171", "66", "67", "25", "135", "137", "138", "139", "134",
				"21", "69", "70", "141", "142", "143", "144", "140", "71",
				"72", "146", "145", "61", "62", "172", "81", "73", "74", "148",
				"147", "75", "76", "26", "77", "149", "114", "173", "174" };
		String[] columns = { "_idQuestionContent_translate", "Question",
				"_idAnswerTranslate", "_idQAContentsTranslate" };
		Cursor dCursor = db
				.query("QuestionContent_translate",
						columns,
						"_idQuestionContent_translate = ? OR _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?",
						whereArguments, null, null, null);

		ArrayList<ArrayList<String>> HAQQuestionsList = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> HAQQuestion = new ArrayList<String>();
					int idHAQQuestion = dCursor.getInt(dCursor
							.getColumnIndex("_idQuestionContent_translate"));
					HAQQuestion.add(String.valueOf(idHAQQuestion));
					String HAQQ = dCursor.getString(dCursor
							.getColumnIndex("Question"));
					HAQQuestion.add(HAQQ);
					int idAnswer = dCursor.getInt(dCursor
							.getColumnIndex("_idAnswerTranslate"));
					HAQQuestion.add(String.valueOf(idAnswer));
					int _idQAContentsTranslate = dCursor.getInt(dCursor
							.getColumnIndex("_idQAContentsTranslate"));
					HAQQuestion.add(String.valueOf(_idQAContentsTranslate));
					HAQQuestionsList.add(HAQQuestion);

				} while (dCursor.moveToNext());

			}
		}

		dCursor.close();
		return HAQQuestionsList;
	}

	public ArrayList<ArrayList<String>> GetListQuestionFatigue() {

		String[] whereArguments = { "7", "9", "10", "11", "12", "13", "1", "3",
				"4", "5", "14", "15", "16" };
		String[] columns = { "_idQuestionContent_translate", "Question",
				"_idAnswerTranslate", "_idQAContentsTranslate" };
		Cursor dCursor = db
				.query("QuestionContent_translate",
						columns,
						" _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? ",
						whereArguments, null, null, null);
		ArrayList<ArrayList<String>> ListQuestionFatigue = new ArrayList<ArrayList<String>>();
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					ArrayList<String> ListFatigue = new ArrayList<String>();
					int idFatigue = dCursor.getInt(dCursor
							.getColumnIndex("_idQuestionContent_translate"));
					ListFatigue.add(String.valueOf(idFatigue));
					String QuestionFatigue = dCursor.getString(dCursor
							.getColumnIndex("Question"));
					ListFatigue.add(QuestionFatigue);
					int idAnswer = dCursor.getInt(dCursor
							.getColumnIndex("_idAnswerTranslate"));
					ListFatigue.add(String.valueOf(idAnswer));
					int _idQAContentsTranslate = dCursor.getInt(dCursor
							.getColumnIndex("_idQAContentsTranslate"));
					ListFatigue.add(String.valueOf(_idQAContentsTranslate));
					ListQuestionFatigue.add(ListFatigue);

				} while (dCursor.moveToNext());

			}
		}

		dCursor.close();
		return ListQuestionFatigue;
	}

	public ArrayList<String> GetAnswerDrug() {

		String[] whereArguments = { "8" };
		String[] columns = { "_idAnswer", "A1", "A2", "A3", "A4", "A5", "A6" };
		Cursor dCursor = db.query("AnswerContent_translate", columns,
				"_idAnswer = ?  ", whereArguments, null, null, null);

		if (dCursor.moveToFirst()) {

			ArrayList<String> AnswerDrug = new ArrayList<String>();
			int _idAnswer = dCursor.getInt(dCursor.getColumnIndex("_idAnswer"));
			AnswerDrug.add(String.valueOf(_idAnswer));
			String A1 = dCursor.getString(dCursor.getColumnIndex("A1"));
			AnswerDrug.add(A1);
			String A2 = dCursor.getString(dCursor.getColumnIndex("A2"));
			AnswerDrug.add(A2);
			String A3 = dCursor.getString(dCursor.getColumnIndex("A3"));
			AnswerDrug.add(A3);
			String A4 = dCursor.getString(dCursor.getColumnIndex("A4"));
			AnswerDrug.add(A4);
			String A5 = dCursor.getString(dCursor.getColumnIndex("A5"));
			AnswerDrug.add(A5);
			String A6 = dCursor.getString(dCursor.getColumnIndex("A6"));
			AnswerDrug.add(A6);

			return AnswerDrug;
		}
		return AnswerDrug0;

	}

	public String GetInfoTest() {
		Cursor mCursor = db.rawQuery("SELECT idE,test_decision FROM "
				+ "m_test" + " WHERE idE=? ", new String[] { "3" });

		if (mCursor.moveToFirst()) {
			String id = mCursor.getString(mCursor
					.getColumnIndex("test_decision"));
			Toast.makeText(context, id, Toast.LENGTH_LONG).show();
			return id;
		} else {
			return "";
		}
	}

	public ArrayList<String> GetQuestionPsy() {

		String[] whereArguments = { "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14" };
		String[] columns = { "refquest", "question", "type" };
		Cursor dCursor = db
				.query("m_questions",
						columns,
						"refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ? OR refquest = ?",
						whereArguments, null, null, null);
		ArrayList<String> QuestionContent = new ArrayList<String>();

		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					int ref = dCursor
							.getInt(dCursor.getColumnIndex("refquest"));
					QuestionContent.add(String.valueOf(ref));
					String Question = dCursor.getString(dCursor
							.getColumnIndex("question"));
					QuestionContent.add(Question);
					String type = dCursor.getString(dCursor
							.getColumnIndex("type"));
					QuestionContent.add(type);

				} while (dCursor.moveToNext());

			}
		}

		dCursor.close();
		return QuestionContent;
	}

	public ArrayList<String> GetChoice(String ref) {

		String[] whereArguments = { ref };
		String[] columns = { "ref_choices", "choice", "weight" };
		Cursor dCursor = db.query("m_choices", columns, "refquestion = ? ",
				whereArguments, null, null, null);
		ArrayList<String> choice = new ArrayList<String>();

		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {

					int refr = dCursor.getInt(dCursor
							.getColumnIndex("ref_choices"));
					choice.add(String.valueOf(refr));
					String choi = dCursor.getString(dCursor
							.getColumnIndex("choice"));
					choice.add(choi);
					int wei = dCursor.getInt(dCursor.getColumnIndex("weight"));
					choice.add(String.valueOf(wei));

				} while (dCursor.moveToNext());

			}
		}

		dCursor.close();
		return choice;
	}

	public boolean DeleteQuestion(int id) {
		return db.delete("QuestionContent_translate",
				"_idQuestionContent_translate = " + id, null) > 0;
	}

	public ArrayList<String> GetAllAnswers() {

		ArrayList<String> Answers = new ArrayList<String>();

		Cursor c = db
				.rawQuery(
						"SELECT refQAContent, Value,date,_idPatientAnswers FROM Answers ",
						null);

		if (c != null) {
			if (c.moveToFirst()) {
				do {
					String ref = c.getString(c.getColumnIndex("refQAContent"));
					String Ans = c.getString(c.getColumnIndex("Value"));
					String date = c.getString(c.getColumnIndex("date"));
					String id = c.getString(c
							.getColumnIndex("_idPatientAnswers"));

					Answers.add(ref);
					Answers.add(Ans);
					Answers.add(date);
					Answers.add(id);

				} while (c.moveToNext());
			}
		}
		c.close();

		return Answers;
	}

	public ArrayList<String> GetAllScores(String currentDateandTime) {

		ArrayList<String> Scores = new ArrayList<String>();
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());

		Cursor c = db
				.rawQuery(
						"SELECT _idScores, Value, Date,refScoreType,_idPatient FROM Scores WHERE Date=?",
						new String[] { currentDateandTime });
		int ID = Controller.ID;
		if (c != null) {
			if (c.moveToFirst()) {
				do {
					String id = c.getString(c.getColumnIndex("_idPatient"));

					if (id.trim().equals(String.valueOf(ID).trim())) {
						String val = c.getString(c.getColumnIndex("Value"));
						String date = c.getString(c.getColumnIndex("Date"));
						String Scoretype = c.getString(c
								.getColumnIndex("refScoreType"));
						String ScoreId = c.getString(c
								.getColumnIndex("_idScores"));

						Scores.add(val);
						Scores.add(date);
						Scores.add(Scoretype);
						Scores.add(id);
						Scores.add(ScoreId);
					}

				} while (c.moveToNext());
			}
		}
		c.close();
		return Scores;
	}

	public ArrayList<String> GetAllNonSentScores() {

		ArrayList<String> Scores = new ArrayList<String>();
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());

		Cursor c = db
				.rawQuery(
						"SELECT _idScores, Value, Date,refScoreType,_idPatient FROM Scores WHERE sendingState<>?",
						new String[] { "0" });
		int ID = Controller.ID;
		if (c != null) {
			if (c.moveToFirst()) {
				do {
					String id = c.getString(c.getColumnIndex("_idPatient"));

					if (id.trim().equals(String.valueOf(ID).trim())) {
						String val = c.getString(c.getColumnIndex("Value"));
						String date = c.getString(c.getColumnIndex("Date"));
						String Scoretype = c.getString(c
								.getColumnIndex("refScoreType"));
						String ScoreId = c.getString(c
								.getColumnIndex("_idScores"));

						Scores.add(val);
						Scores.add(date);
						Scores.add(Scoretype);
						Scores.add(id);
						Scores.add(ScoreId);
					}
				} while (c.moveToNext());
			}
		}
		c.close();
		return Scores;
	}

	public void setSendingState(ArrayList<String> IDs, String sendingState,
			String tableName, String rowName) {
		ContentValues values = new ContentValues();
		values.put("sendingState", sendingState);
		for (int i = 0; i < IDs.size(); i++) {
			db.update(tableName, values, rowName + "=" + IDs.get(i), null);
		}
	}

	public ArrayList<String> GetDoctor(String currentDateandTime) {

		ArrayList<String> Doctor = new ArrayList<String>();
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());
		int ID = Controller.ID;
		Cursor c = db
				.rawQuery(
						"SELECT _idDoctor, Firstname, Lastname,Phone,Mobile,Occupation,Mail, _idPatient, date  FROM Doctor WHERE date=?",
						new String[] { currentDateandTime });

		if (c != null) {
			if (c.moveToFirst()) {
				do {
					String id = c.getString(c.getColumnIndex("_idPatient"));
					if (id.trim().equals(String.valueOf(ID).trim())) {
						String firstname = c.getString(c
								.getColumnIndex("Firstname"));
						String lastname = c.getString(c
								.getColumnIndex("Lastname"));
						String phone = c.getString(c.getColumnIndex("Phone"));
						String mobile = c.getString(c.getColumnIndex("Mobile"));
						String Occupation = c.getString(c
								.getColumnIndex("Occupation"));
						String Mail = c.getString(c.getColumnIndex("Mail"));
						String date = c.getString(c.getColumnIndex("date"));
						String DoctorId = c.getString(c
								.getColumnIndex("_idDoctor"));

						Doctor.add(firstname);
						Doctor.add(lastname);
						Doctor.add(phone);
						Doctor.add(mobile);
						Doctor.add(Occupation);
						Doctor.add(Mail);
						Doctor.add(id);
						Doctor.add(date);
						Doctor.add(DoctorId);

					}
				} while (c.moveToNext());
			}
		}
		c.close();
		return Doctor;
	}

	public ArrayList<String> GetNonSentDoctor() {

		ArrayList<String> Doctor = new ArrayList<String>();
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());
		int ID = Controller.ID;
		Cursor c = db
				.rawQuery(
						"SELECT _idDoctor, Firstname, Lastname,Phone,Mobile,Occupation,Mail, _idPatient, date  FROM Doctor WHERE sendingState<>?",
						new String[] { "0" });

		if (c != null) {
			if (c.moveToFirst()) {
				do {
					String id = c.getString(c.getColumnIndex("_idPatient"));
					if (id.trim().equals(String.valueOf(ID).trim())) {
						String firstname = c.getString(c
								.getColumnIndex("Firstname"));
						String lastname = c.getString(c
								.getColumnIndex("Lastname"));
						String phone = c.getString(c.getColumnIndex("Phone"));
						String mobile = c.getString(c.getColumnIndex("Mobile"));
						String Occupation = c.getString(c
								.getColumnIndex("Occupation"));
						String Mail = c.getString(c.getColumnIndex("Mail"));
						String date = c.getString(c.getColumnIndex("date"));
						String DoctorId = c.getString(c
								.getColumnIndex("_idDoctor"));

						Doctor.add(firstname);
						Doctor.add(lastname);
						Doctor.add(phone);
						Doctor.add(mobile);
						Doctor.add(Occupation);
						Doctor.add(Mail);
						Doctor.add(id);
						Doctor.add(date);
						Doctor.add(DoctorId);

					}
				} while (c.moveToNext());
			}
		}
		c.close();
		return Doctor;
	}

	public ArrayList<String> GetAllDrugsAnswers(String currentDateandTime) {

		ArrayList<String> Drugs = new ArrayList<String>();
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());
		int ID = Controller.ID;
		Cursor c = db
				.rawQuery(
						"SELECT id, RefDrugContent, Frequency,Dose,_idPatientDrugs,Date FROM Drugs WHERE Date=?",
						new String[] { currentDateandTime });

		if (c != null) {
			if (c.moveToFirst()) {
				do {
					String id = c
							.getString(c.getColumnIndex("_idPatientDrugs"));
					if ((id.trim().equals(String.valueOf(ID).trim()))) {
						String val = c.getString(c
								.getColumnIndex("RefDrugContent"));
						String date = c
								.getString(c.getColumnIndex("Frequency"));
						String Scoretype = c
								.getString(c.getColumnIndex("Dose"));
						String Date = c.getString(c.getColumnIndex("Date"));
						String idDrug = c.getString(c.getColumnIndex("id"));

						Drugs.add(val);
						Drugs.add(date);
						Drugs.add(Scoretype);
						Drugs.add(id);
						Drugs.add(Date);
						Drugs.add(idDrug);

					}

				} while (c.moveToNext());
			}
		}
		c.close();

		return Drugs;
	}

	public ArrayList<String> GetAllNonSentDrugsAnswers() {

		ArrayList<String> Drugs = new ArrayList<String>();
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());
		int ID = Controller.ID;
		Cursor c = db
				.rawQuery(
						"SELECT id, RefDrugContent, Frequency,Dose,_idPatientDrugs,Date FROM Drugs WHERE sendingState<>?",
						new String[] { "0" });
		if (c != null) {
			if (c.moveToFirst()) {
				do {
					String id = c
							.getString(c.getColumnIndex("_idPatientDrugs"));
					if ((id.trim().equals(String.valueOf(ID).trim()))) {
						String val = c.getString(c
								.getColumnIndex("RefDrugContent"));
						String date = c
								.getString(c.getColumnIndex("Frequency"));
						String Scoretype = c
								.getString(c.getColumnIndex("Dose"));
						String Date = c.getString(c.getColumnIndex("Date"));
						String idDrug = c.getString(c.getColumnIndex("id"));

						Drugs.add(val);
						Drugs.add(date);
						Drugs.add(Scoretype);
						Drugs.add(id);
						Drugs.add(Date);
						Drugs.add(idDrug);

					}

				} while (c.moveToNext());
			}
		}
		c.close();

		return Drugs;
	}

	public ArrayList<String> GetAllAnswersFI(String currentDateandTime) {

		ArrayList<String> AnswersFI = new ArrayList<String>();
		ArrayList<String> RefList = new ArrayList<String>();
		RefList = Controller.AllQuestionFI;
		int RefListSize = RefList.size();
		String[] RefTable = new String[RefListSize];
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());
		// String [] TableDAte = new String[1];
		// TableDAte[1] = currentDateandTime;
		currentDateandTime.trim().replace("-", "");

		for (int i = 0; i < RefTable.length; i++) {
			RefTable[i] = RefList.get(i);
		}

		String query = "SELECT id, refQAContent, Value,date,_idPatientAnswers FROM Answers"
				+ " WHERE refQAContent IN ("
				+ makePlaceholders(RefTable.length) + ")"; // AND date
		// ="+currentDateandTime;
		// AND date =" + currentDateandTime
		Cursor dCursor = db.rawQuery(query, RefTable);

		int ID = Controller.ID;
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {
					String date = dCursor.getString(dCursor
							.getColumnIndex("date"));
					String id = dCursor.getString(dCursor
							.getColumnIndex("_idPatientAnswers"));

					if ((date.trim().equals(currentDateandTime.trim()))
							&& (id.trim().equals(String.valueOf(ID).trim()))) {
						String ref = dCursor.getString(dCursor
								.getColumnIndex("refQAContent"));
						String Ans = dCursor.getString(dCursor
								.getColumnIndex("Value"));
						String AnsId = dCursor.getString(dCursor
								.getColumnIndex("id"));

						AnswersFI.add(ref);
						AnswersFI.add(Ans);
						AnswersFI.add(date);
						AnswersFI.add(id);
						AnswersFI.add(AnsId);
					}

				} while (dCursor.moveToNext());
			}
		}
		dCursor.close();
		return AnswersFI;
	}

	String makePlaceholders(int len) {
		if (len < 1) {

			throw new RuntimeException("No placeholders");
		} else {
			StringBuilder sb = new StringBuilder(len * 2 - 1);
			sb.append("?");
			for (int i = 1; i < len; i++) {
				sb.append(",?");
			}
			return sb.toString();
		}
	}

	public ArrayList<String> GetAllAnswersDS(String currentDateandTime) {

		ArrayList<String> AnswersDS = new ArrayList<String>();
		ArrayList<String> RefList = new ArrayList<String>();
		RefList = Controller.AllQuestionDS;
		int RefListSize = RefList.size();
		String[] RefTable = new String[RefListSize];
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());

		int ID = Controller.ID;

		for (int i = 0; i < RefTable.length; i++) {
			RefTable[i] = RefList.get(i);
		}

		String query = "SELECT id, refQAContent, Value,date,_idPatientAnswers FROM Answers"
				+ " WHERE refQAContent IN ("
				+ makePlaceholders(RefTable.length) + ")";// AND date=" +
		// currentDateandTime;
		Cursor dCursor = db.rawQuery(query, RefTable);

		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {
					String date = dCursor.getString(dCursor
							.getColumnIndex("date"));
					String id = dCursor.getString(dCursor
							.getColumnIndex("_idPatientAnswers"));

					if ((date.trim().equals(currentDateandTime.trim()))
							&& (id.trim().equals(String.valueOf(ID).trim()))) {
						String ref = dCursor.getString(dCursor
								.getColumnIndex("refQAContent"));
						String Ans = dCursor.getString(dCursor
								.getColumnIndex("Value"));
						String AnsId = dCursor.getString(dCursor
								.getColumnIndex("id"));

						AnswersDS.add(ref);
						AnswersDS.add(Ans);
						AnswersDS.add(date);
						AnswersDS.add(id);
						AnswersDS.add(AnsId);

					}
				} while (dCursor.moveToNext());
			}
		}
		dCursor.close();

		return AnswersDS;
	}

	public ArrayList<String> GetAllNonSentAnswers() {

		ArrayList<String> AnswersDS = new ArrayList<String>();
		ArrayList<String> RefList = new ArrayList<String>();

		int ID = Controller.ID;

		// String query =
		// "SELECT id, refQAContent, Value,date,_idPatientAnswers FROM Answers"
		// + " WHERE refQAContent IN (" + makePlaceholders(RefTable.length) +
		// ")" ;// AND date=" + currentDateandTime;
		// Cursor dCursor = db.rawQuery(query, RefTable);

		Cursor dCursor = db
				.rawQuery(
						"SELECT id, refQAContent, Value,date,_idPatientAnswers FROM Answers WHERE sendingState<>?",
						new String[] { "0" });
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {
					String date = dCursor.getString(dCursor
							.getColumnIndex("date"));
					String id = dCursor.getString(dCursor
							.getColumnIndex("_idPatientAnswers"));

					if ((id.trim().equals(String.valueOf(ID).trim()))) {
						String ref = dCursor.getString(dCursor
								.getColumnIndex("refQAContent"));
						String Ans = dCursor.getString(dCursor
								.getColumnIndex("Value"));
						String AnsId = dCursor.getString(dCursor
								.getColumnIndex("id"));

						AnswersDS.add(ref);
						AnswersDS.add(Ans);
						AnswersDS.add(date);
						AnswersDS.add(id);
						AnswersDS.add(AnsId);

					}
				} while (dCursor.moveToNext());
			}
		}
		dCursor.close();

		return AnswersDS;
	}

	public ArrayList<String> GetAllAnswersTM(String currentDateandTime) {

		ArrayList<String> AnswersTM = new ArrayList<String>();
		ArrayList<String> RefList = new ArrayList<String>();
		RefList = Controller.AllQuestionTM;
		int RefListSize = RefList.size();
		String[] RefTable = new String[RefListSize];
		// SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		// String currentDateandTime = sdf.format(new Date());

		int ID = Controller.ID;

		for (int i = 0; i < RefTable.length; i++) {
			RefTable[i] = RefList.get(i);
		}

		String query = "SELECT id, refQAContent, Value,date,_idPatientAnswers FROM Answers"
				+ " WHERE refQAContent IN ("
				+ makePlaceholders(RefTable.length) + ") "; // AND date =" +
		// currentDateandTime;
		Cursor dCursor = db.rawQuery(query, RefTable);

		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {
					String date = dCursor.getString(dCursor
							.getColumnIndex("date"));
					String id = dCursor.getString(dCursor
							.getColumnIndex("_idPatientAnswers"));

					if ((date.trim().equals(currentDateandTime.trim()))
							&& (id.trim().equals(String.valueOf(ID).trim()))) {
						String ref = dCursor.getString(dCursor
								.getColumnIndex("refQAContent"));
						String Ans = dCursor.getString(dCursor
								.getColumnIndex("Value"));
						String Answerid = dCursor.getString(dCursor
								.getColumnIndex("id"));

						AnswersTM.add(ref);
						AnswersTM.add(Ans);
						AnswersTM.add(date);
						AnswersTM.add(id);
						AnswersTM.add(Answerid);

					}
				} while (dCursor.moveToNext());
			}
		}
		dCursor.close();

		return AnswersTM;
	}

	public String TestTest() {
		Cursor dCursor = db.rawQuery("SELECT Date FROM " + "Answers"
				+ " WHERE refQAContent=? ", new String[] { "An15" });
		String date = null;
		if (dCursor != null) {
			if (dCursor.moveToFirst()) {
				do {
					date = dCursor.getString(dCursor.getColumnIndex("date"));
				} while (dCursor.moveToNext());
			}
		}
		return date;
	}

	public boolean TestDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy HHmmss");
		String currentDateandTime = sdf.format(new Date());

		return currentDateandTime == TestTest();
	}

	public String GetIDQuestionTranslate(int id) {

		String idQuestion = null;

		String[] whereArguments = { String.valueOf(id) };
		String[] columns = { "_idQuestionContent_translate" };
		// Cursor c = db.query("QuestionContent_translate",columns ,
		// "_idAnswerTranslate = ? ", whereArguments, null, null, null);

		// Cursor c= db.rawQuery("SELECT _idAnswerTranslate FROM " +
		// "QuestionContent_translate" +
		// " WHERE _idQuestionContent_translate=? ", new
		// String[]{String.valueOf(id)});
		Cursor c = db.query("QuestionContent_translate", columns,
				"_idAnswerTranslate= ? ", whereArguments, null, null, null);
		if (c != null) {
			if (c.moveToFirst()) {

				int idQ = c.getInt(c.getColumnIndex("_idAnswerTranslate"));
				idQuestion = String.valueOf(idQ);
				Log.d("idQuestion", idQuestion);

			}
			// if (c != null ) {
			// if (c.moveToFirst()) {
			// do {
			//
			// int idQ =
			// c.getInt(c.getColumnIndex("_idQuestionContent_translate"));
			// idQuestion=String.valueOf(idQ);
			//
			//
			// }while (c.moveToNext());
			// }
			// }
			// c.close();
		}
		return idQuestion;
	}
	

	/** Get list question for BASDAI 
	 * 
	 * @Return ListQuestion_BASDAI, ArrayList of BASDAIQuestion
	 * 
	 * */

	public ArrayList<ArrayList<String>> GetListQuestion_BASDAI(){

		String[] whereArguments = { "300","301","302","303","304","305", };
		String[] columns = {"_idQuestionContent_translate","Question","_idAnswerTranslate","_idQAContentsTranslate"};
		Cursor dCursor = db.query("QuestionContent_translate",columns , "_idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? ", whereArguments, null, null, null);


		ArrayList<ArrayList<String>> listQuestion_BASDAI = new ArrayList<ArrayList<String>>();
		if (dCursor != null ) {
			if  (dCursor.moveToFirst()) {
				do {

					ArrayList<String> listQuestion = new ArrayList<String>();
					int idQuestion = dCursor.getInt(dCursor.getColumnIndex("_idQuestionContent_translate"));
					listQuestion.add(String.valueOf(idQuestion));
					String Question = dCursor.getString(dCursor.getColumnIndex("Question"));
					listQuestion.add(Question);
					int idAnswer = dCursor.getInt(dCursor.getColumnIndex("_idAnswerTranslate"));
					listQuestion.add(String.valueOf(idAnswer));
					int _idQAContentsTranslate = dCursor.getInt(dCursor.getColumnIndex("_idQAContentsTranslate"));
					listQuestion.add(String.valueOf(_idQAContentsTranslate));
					listQuestion_BASDAI.add(listQuestion);

				}while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return listQuestion_BASDAI;
	}
	

	/** Get list question for BASFI 
	 * 
	 *  @Return ListQuestion_BASFI, ArrayList of BASFIQuestion
	 *  
	 * */
	public ArrayList<ArrayList<String>> GetListQuestion_BASFI(){

		String[] whereArguments = { "310","311","312","313","314","315","316","317","318","319" };
		String[] columns = {"_idQuestionContent_translate","Question","_idAnswerTranslate","_idQAContentsTranslate"};
		Cursor dCursor = db.query("QuestionContent_translate",columns , "_idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ? OR _idQuestionContent_translate = ?  OR _idQuestionContent_translate = ? ", whereArguments, null, null, null);


		ArrayList<ArrayList<String>> listQuestion_BASFI = new ArrayList<ArrayList<String>>();
		if (dCursor != null ) {
			if  (dCursor.moveToFirst()) {
				do {

					ArrayList<String> listQuestion = new ArrayList<String>();
					int idQuestion = dCursor.getInt(dCursor.getColumnIndex("_idQuestionContent_translate"));
					listQuestion.add(String.valueOf(idQuestion));
					String Question = dCursor.getString(dCursor.getColumnIndex("Question"));
					listQuestion.add(Question);
					int idAnswer = dCursor.getInt(dCursor.getColumnIndex("_idAnswerTranslate"));
					listQuestion.add(String.valueOf(idAnswer));
					int _idQAContentsTranslate = dCursor.getInt(dCursor.getColumnIndex("_idQAContentsTranslate"));
					listQuestion.add(String.valueOf(_idQAContentsTranslate));
					listQuestion_BASFI.add(listQuestion);

				}while (dCursor.moveToNext());

			}
		}
		dCursor.close();
		return listQuestion_BASFI;
	}
}
