package demo.domain.paper;

import demo.domain.paper.excaption.InvalidBlankQuizIdException;
import demo.repository.QuizRepository;

import java.util.List;

public class PaperPolicy {
    private QuizRepository quizRepository;

    public PaperPolicy(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    void assertQuizIdsAreValid(List<String> blankQuizIds) {
        blankQuizIds.forEach(id -> {
            if (!quizRepository.exists(id)) {
                throw new InvalidBlankQuizIdException();
            }
        });
    }
}
