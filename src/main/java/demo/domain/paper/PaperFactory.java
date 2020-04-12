package demo.domain.paper;

import demo.domain.paper.excaption.InvalidBlankQuizIdException;
import demo.repository.QuizRepository;

import java.util.List;

public class PaperFactory {

    private QuizRepository quizRepository;

    public PaperFactory(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Paper create(List<String> blankQuizIds) {
        assertQuizIdsAreValid(blankQuizIds);
        return new Paper(blankQuizIds);
    }

    private void assertQuizIdsAreValid(List<String> blankQuizIds) {
        blankQuizIds.forEach(id -> {
            if (!quizRepository.exists(id)) {
                throw new InvalidBlankQuizIdException();
            }
        });
    }
}
