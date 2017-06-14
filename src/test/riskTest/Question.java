package test.riskTest;

import java.util.List;

/**
 * Created by zuo on 2017/2/20.
 */
public class Question {
    private String question;
    private List<Answer> answerList;

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
