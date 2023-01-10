package com.example.chatbotproject;

import com.github.jfasttext.JFastText;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component//빈을 주입할 거면 빈을 등록 해야한다..?
@RequiredArgsConstructor
public class JFastTexts {
    public final TokenizeDataSet tokenizeDataSet;

    public void jfasttextPizza(String question){
        JFastText jft = new JFastText();
        ///////////////////Word embedding learning 토큰화
        jft.runCmd(new String[] {//항상 텍스트 형태로 줘야만 하나?
                "skipgram",
                "-input", "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/data/unlabeled_data.txt",//todo 입력 데이터
                "-output", "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/models/skipgram.model",
                "-bucket", "100",
                "-minCount", "1"
        });
        //////////////////////Text classification
        System.out.println("text classification");
        jft.runCmd(new String[] {
                "supervised",
                "-input", "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/data/labeled_data.txt",
                "-output", "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/models/supervised.model"
        });

// Load model from file
        jft.loadModel("C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/models/supervised.model.bin");

// Do label prediction
        JFastText.ProbLabel probLabel = jft.predictProba(question);
        System.out.printf("\nThe label of '%s' is '%s' with probability %f\n",
                question, probLabel.label, Math.exp(probLabel.logProb));

        //상위 n개의 확률 가져오기(마이너스에 결과라도 확률이 나오면 반환해줌!
        System.out.println("predictProba: " + jft.predictProba(question, 5));
    }

    public String getIntent(String question) {
        JFastText jft = new JFastText();
        jft.loadModel("C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/models/supervised.model.bin");

        // do label prediction
        JFastText.ProbLabel probLabel = jft.predictProba(question);
        System.out.printf("\nThe label of '%s' is '%s' with probability %f\n",
                question, probLabel.label, Math.exp(probLabel.logProb));

        return probLabel.label;
    }

}