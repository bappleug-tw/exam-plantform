package demo.domain.paper;

import java.util.List;

public class PaperFactory {

    public static Paper create(List<String> blankQuizIds) {
        return new Paper(blankQuizIds);
    }
}
