package demo.domain.paper;

import java.util.List;

public class Paper {
    private List<String> blankQuizIds;
    private PaperPolicy paperPolicy;

    Paper(List<String> blankQuizIds, PaperPolicy paperPolicy) {
        this.blankQuizIds = blankQuizIds;
        this.paperPolicy = paperPolicy;
    }

    public List<String> getBlankQuizIds() {
        return blankQuizIds;
    }

    public void update(List<String> updatedBlankQuizIds) {
        paperPolicy.assertQuizIdsAreValid(updatedBlankQuizIds);
        blankQuizIds = updatedBlankQuizIds;
    }
}
