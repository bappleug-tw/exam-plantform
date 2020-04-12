package demo.domain.paper;

import demo.domain.paper.excaption.InvalidBlankQuizIdException;
import demo.repository.QuizRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;

class PaperTest {

    @Test
    void should_success_when_update_given_valid_quiz_ids() {
        List<String> initBlankQuizIds = new ArrayList<>();
        initBlankQuizIds.add("blank quiz 1");
        Paper paper = new Paper(initBlankQuizIds);

        List<String> updatedBlankQuizIds = new ArrayList<>();
        updatedBlankQuizIds.add("blank quiz 2");
        updatedBlankQuizIds.add("blank quiz 3");
        paper.update(updatedBlankQuizIds);
        assertThat(paper.getBlankQuizIds()).isEqualTo(updatedBlankQuizIds);
    }

}
