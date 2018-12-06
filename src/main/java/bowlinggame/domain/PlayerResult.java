package bowlinggame.domain;

import bowlinggame.domain.frame.FrameResult;
import bowlinggame.domain.frame.Score;
import java.util.List;

public class PlayerResult {

	private String name;
	private List<FrameResult> frameResults;

	public PlayerResult(String name, List<FrameResult> frameResults) {
		this.name = name;
		this.frameResults = frameResults;
	}

	public String getName() {
		return name;
	}

	public String getRollResult(int index) {
		if (!isFinished(index)) {
			return "";
		}
		return frameResults.get(index).getRollResults();
	}

	public String getScore(int index) {
		if (!isFinished(index)) {
			return Score.EMPTY_SCORE_CHARACTER;
		}
		return frameResults.get(index).getScore();
	}

	private boolean isFinished(int index) {
		return index < frameResults.size();
	}
}
