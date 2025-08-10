package com.tbasilio.comments.moderation.service;

import com.tbasilio.comments.moderation.service.api.model.ModerationOutput;
import com.tbasilio.comments.moderation.service.domain.service.ModerationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModerationServiceApplicationTests {

	private static ModerationService service;

	@BeforeAll
    static void setup(){
		service = new ModerationService();
	}



	@Test
	void validateModerateService() {
		ModerationOutput comment = service.moderate("comentário com ódio");

		Assertions.assertThat(comment.getApproved()).isFalse();
		Assertions.assertThat(comment.getReason())
				.isEqualTo("Palavras proibídas: [ódio]");
	}

}
