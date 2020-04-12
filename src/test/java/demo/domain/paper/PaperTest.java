package demo.domain.paper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
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
