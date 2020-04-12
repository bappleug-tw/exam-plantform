package demo.domain;

import java.util.List;

public class Paper {
    public List<String> blankQuizIds;

    private Paper(List<String> blankQuizIds) {
        this.blankQuizIds = blankQuizIds;
    }

    public static Paper create(List<String> blankQuizIds) {
        return new Paper(blankQuizIds);
    }

    public List<String> getBlankQuizIds() {
        return blankQuizIds;
    }
}
