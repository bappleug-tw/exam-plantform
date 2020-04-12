package demo.domain.paper;

import demo.domain.paper.excaption.InvalidBlankQuizIdException;
import demo.repository.QuizRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class PaperFactoryTest {

    @Mock
    private QuizRepository quizRepository;

    @Test
    void should_return_paper_when_create_given_valid_quiz_ids() {
        PaperFactory paperFactory = new PaperFactory(quizRepository);
        Mockito.when(quizRepository.exists(anyString())).thenReturn(true);

        List<String> blankQuizIds = new ArrayList<>();
        blankQuizIds.add("blank quiz 1");
        blankQuizIds.add("blank quiz 2");
        Paper paper = paperFactory.create(blankQuizIds);
        assertThat(paper).isNotNull();
        assertThat(paper.getBlankQuizIds()).isEqualTo(blankQuizIds);
    }

    @Test
    void should_return_paper_when_create_given_invalid_quiz_ids() {
        QuizRepository quizRepository = Mockito.mock(QuizRepository.class);
        PaperFactory paperFactory = new PaperFactory(quizRepository);
        doReturn(true).when(quizRepository).exists("invalid blank quiz 1");
        doReturn(false).when(quizRepository).exists("invalid blank quiz 2");

        List<String> blankQuizIds = new ArrayList<>();
        blankQuizIds.add("invalid blank quiz 1");
        blankQuizIds.add("invalid blank quiz 2");
        assertThatThrownBy(() -> paperFactory.create(blankQuizIds))
                .isInstanceOf(InvalidBlankQuizIdException.class);
    }
}
