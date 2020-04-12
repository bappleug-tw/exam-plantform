package demo.domain.paper;

import demo.domain.paper.excaption.InvalidBlankQuizIdException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class PaperFactoryTest {

    @Mock
    private PaperPolicy paperPolicy;

    @Test
    void should_return_paper_when_create_given_valid_quiz_ids() {
        PaperFactory paperFactory = new PaperFactory(paperPolicy);
        List<String> blankQuizIds = new ArrayList<>();
        blankQuizIds.add("blank quiz 1");
        blankQuizIds.add("blank quiz 2");
        Paper paper = paperFactory.create(blankQuizIds);
        assertThat(paper).isNotNull();
        assertThat(paper.getBlankQuizIds()).isEqualTo(blankQuizIds);
    }

    @Test
    void should_throw_invalid_quiz_id_exception_when_create_given_invalid_quiz_ids() {
        List<String> blankQuizIds = new ArrayList<>();
        blankQuizIds.add("invalid blank quiz 1");
        blankQuizIds.add("invalid blank quiz 2");
        PaperFactory paperFactory = new PaperFactory(paperPolicy);
        doThrow(new InvalidBlankQuizIdException()).when(paperPolicy).assertQuizIdsAreValid(blankQuizIds);

        assertThatThrownBy(() -> paperFactory.create(blankQuizIds))
                .isInstanceOf(InvalidBlankQuizIdException.class);
    }
}
