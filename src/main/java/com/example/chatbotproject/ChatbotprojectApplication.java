package com.example.chatbotproject;

import com.example.chatbotproject.entity.Chatbot;
import com.github.jfasttext.JFastText;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class ChatbotprojectApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ChatbotprojectApplication.class, args);

		/*
        Komoran으로 형태소 분석
        * */

		// FULL 모델을 갖는 Komoran 객체를 선언
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

		// 텍스트 파일 받기
		File file = new File("src/chatbot_training_data.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));

		String strToAnalyze;
		KomoranResult analyzeResultList;
		while ((strToAnalyze = reader.readLine()) != null) {

			// 형태소분석할 문장
			System.out.println("형태소 분석할 문장 : " + strToAnalyze);

			// Komoran 객체의 analyze()메소드의 인자로 분석할 문장을 전달
			// 이 결과를 KomoranResult 객체로 저장
			analyzeResultList = komoran.analyze(strToAnalyze);

			// 형태소 분석 결과 중 명사류를 List<String> 형태로 반환
			System.out.println("==========print 'getNouns()'==========");
			System.out.println(analyzeResultList.getNouns());
			System.out.println();
		}

		// JFastText 자연어 처리
		JFastText jft = new JFastText();


		// Word embedding learning
		jft.runCmd(new String[] {
				"skipgram",
				"-input", "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/data/unlabeled_data.txt",
				"-output", "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/models/skipgram.model",
				"-bucket", "100",
				"-minCount", "1"
		});

		// Train supervised model
		jft.runCmd(new String[] {
				"supervised",
				"-input", "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/data/labeled_data.txt",
				"-output", "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/models/supervised.model"
		});


		// Load model from file
		jft.loadModel("C:/Users/PERSONA SYSTEM/Desktop/HEESOO/Chatbot/src/main/resources/models/supervised.model.bin");

		// Do label prediction
		String text = "가격은 ?";
		JFastText.ProbLabel probLabel = jft.predictProba(text);
		System.out.printf("\nThe label of '%s' is '%s' with probability %f\n",
				text, probLabel.label, Math.exp(probLabel.logProb));
		System.out.println();
		System.out.println("라벨 예측 순서는 " + jft.predict(text, 2).get(0) + ", " + jft.predict(text, 2).get(1) + "입니다.");

        /*
        System.out.println("getLabel: " + jft.getLabels());
        System.out.println("getNLabels: " + jft.getNLabels());
        System.out.println("getWordNgrams: " + jft.getWordNgrams());
        System.out.println("getWords: " + jft.getWords());
        System.out.println("getModelName: " + jft.getModelName());
        System.out.println("getMaxn: " + jft.getMaxn());
        System.out.println("getMinn: " + jft.getMinn());
        System.out.println("predictProba: " + jft.predictProba(text, 2));
        */

		Chatbot chatbot = new Chatbot(1L,"배달", "배달하시겠어요?");
		System.out.println(chatbot.getChatbot_intent() + " : " + chatbot.getChatbot_answer());

	}

}
