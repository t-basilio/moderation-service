package com.tbasilio.comments.moderation.service.domain.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbasilio.comments.moderation.service.api.model.ModerationOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class ModerationService {
    
    private final List<String> badWordList;

    public ModerationService(){
        try {
            File file = new File("src/main/resources/static/bad-words.json");
            badWordList = new ObjectMapper().readValue(file, new TypeReference<>() {});
        } catch(IOException e) {
            log.error("Fail to load json file which contains bad words");
            throw new LoadFileBadWordsException(e.getMessage());
        }
    }

    public ModerationOutput moderate(String text) {
        List<String> matches = findBadWords(text);

        String reason = matches.isEmpty() ?
                "O comentário está em conformidade com as politicas da plataforma"
                : "Palavras proibídas: " + matches;

        return ModerationOutput.builder()
                .approved(matches.isEmpty())
                .reason(reason)
                .build();
    }
    
    private List<String> findBadWords(String text) {
        String lowerText = text.toLowerCase();
        return badWordList.stream().
                filter(bw -> lowerText.contains(bw.toLowerCase()))
                .toList();
    }
}
