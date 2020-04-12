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
class PaperTest {

    @Mock
    private PaperPolicy paperPolicy;

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

    @Test
    void should_throw_invalid_quiz_id_exception_when_update_given_invalid_quiz_ids() {
        List<String> initBlankQuizIds = new ArrayList<>();
        initBlankQuizIds.add("blank quiz 1");
        Paper paper = new Paper(initBlankQuizIds);
        List<String> invalidQuizIds = new ArrayList<>();
        invalidQuizIds.add("invalid blank quiz 1");
        invalidQuizIds.add("invalid blank quiz 2");
        doThrow(new InvalidBlankQuizIdException()).when(paperPolicy).assertQuizIdsAreValid(invalidQuizIds);
        assertThatThrownBy(() -> paper.update(invalidQuizIds))
                .isInstanceOf(InvalidBlankQuizIdException.class);
    }

}
