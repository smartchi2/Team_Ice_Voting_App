package org.voting_app.voting_app.dtos.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.voting_app.voting_app.data.model.Positions;
import org.voting_app.voting_app.data.model.PredictionSet;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PredictWinnerRequest {
    @Id
    private Long predictionSetId;
    private String  email;
    private String partyName;
    private String participantName;
    private Positions positions;
    private PredictionSet candidateTo;
}
