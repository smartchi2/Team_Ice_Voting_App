package org.voting_app.voting_app.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.voting_app.voting_app.data.model.Positions;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PredictWinnerResponse {
    private String predictorName;
    private String candidateName;
    private String partyName;
    private Positions positions;
    private String message;
    private LocalDateTime predictedTime = LocalDateTime.now();
}
