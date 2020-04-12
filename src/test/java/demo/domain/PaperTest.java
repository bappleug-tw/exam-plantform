package demo.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PaperTest {

    @Test
    void should_return_paper_when_create_given_valid_quiz_ids() {
        List<String> blankQuizIds = new ArrayList<>();
        blankQuizIds.add("blank quiz 1");
        blankQuizIds.add("blank quiz 2");
        Paper paper = Paper.create(blankQuizIds);
        assertThat(paper).isNotNull();
        assertThat(paper.getBlankQuizIds()).isEqualTo(blankQuizIds);
    }
}
