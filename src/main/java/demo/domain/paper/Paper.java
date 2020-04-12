package demo.domain.paper;

import java.util.List;

public class Paper {
    private List<String> blankQuizIds;

    Paper(List<String> blankQuizIds) {
        this.blankQuizIds = blankQuizIds;
    }

    public List<String> getBlankQuizIds() {
        return blankQuizIds;
    }
}
