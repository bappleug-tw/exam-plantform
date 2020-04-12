package demo.domain.paper;

import demo.domain.paper.excaption.InvalidBlankQuizIdException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaperFactoryTest {

    @Test
    void should_return_paper_when_create_given_valid_quiz_ids() {
        List<String> blankQuizIds = new ArrayList<>();
        blankQuizIds.add("blank quiz 1");
        blankQuizIds.add("blank quiz 2");
        Paper paper = PaperFactory.create(blankQuizIds);
        assertThat(paper).isNotNull();
        assertThat(paper.getBlankQuizIds()).isEqualTo(blankQuizIds);
    }

    @Test
    void should_return_paper_when_create_given_invalid_quiz_ids() {
        List<String> blankQuizIds = new ArrayList<>();
        blankQuizIds.add("invalid blank quiz 1");
        blankQuizIds.add("invalid blank quiz 2");
        assertThatThrownBy(() -> PaperFactory.create(blankQuizIds))
                .isInstanceOf(InvalidBlankQuizIdException.class);
    }
}
