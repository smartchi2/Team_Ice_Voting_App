package org.voting_app.voting_app.data.services.implimentions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.voting_app.voting_app.data.repositories.CandidatesRepository;
import org.voting_app.voting_app.dtos.request.RegisterToAdminRequest;
import org.voting_app.voting_app.dtos.response.RegisterToAdminResponse;
import org.voting_app.voting_app.services.interfaces.CandidatesServiceInterface;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CandidatesServiceImplTest {
    @Autowired
    private CandidatesServiceInterface candidatesServiceInterface;
    @Autowired
    private CandidatesRepository CandidatesRepository;
    @Test
    public void testThatCandidateCanRegister() {
        RegisterToAdminRequest request = new RegisterToAdminRequest();
        request.setFirstName("Buhari");
        request.setLastName("Tinubu");
        request.setEmail("Tinubu.Buhari@gmail.com");
        request.setPassword("099888");
        request.setPhoneNumber("09056743212");
        RegisterToAdminResponse registerToAdminResponse = candidatesServiceInterface.registerToAdminResponse(request);
        assertThat(registerToAdminResponse.getMessage()).isEqualTo("Candidate registered Successfully");
    }
}