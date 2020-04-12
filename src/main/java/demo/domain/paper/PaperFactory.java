package demo.domain.paper;

import java.util.List;

public class PaperFactory {

    private PaperPolicy paperPolicy;

    public PaperFactory(PaperPolicy paperPolicy) {
        this.paperPolicy = paperPolicy;
    }

    public Paper create(List<String> blankQuizIds) {
        paperPolicy.assertQuizIdsAreValid(blankQuizIds);
        return new Paper(blankQuizIds);
    }
}
