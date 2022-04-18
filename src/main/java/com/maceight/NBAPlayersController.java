package com.maceight;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/")
public class NBAPlayersController {


    @RequestMapping(value = "/{heightParam}", method = RequestMethod.GET)
    public ResponseEntity npaPlayers(@PathVariable("heightParam") String heightParam) throws JsonProcessingException {
        Double inchesParam = Double.parseDouble(heightParam);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> json = restTemplate.getForEntity("https://mach-eight.uc.r.appspot.com/", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(json.getBody(), Response.class);
        List<PlayerPair> playerPairs = new ArrayList<>();

        Arrays.stream(response.getValues()).parallel().forEach(firstPlayer -> {
            playerPairs.addAll(Arrays.stream(response.getValues()).parallel().filter(secondPlayer -> secondPlayer.getInches() + firstPlayer.getInches() == inchesParam)
                    .map(secondPlayer -> new PlayerPair(firstPlayer, secondPlayer)).collect(Collectors.toList()));
        });
        playerPairs.parallelStream().distinct().forEach((pair) -> {System.out.println(new StringBuilder("- ").append(pair.getPlayer1().toString()).append(" ").append(pair.getPlayer2().toString()));});
        return new ResponseEntity(playerPairs.parallelStream().distinct().collect(Collectors.toList()), HttpStatus.OK);


    }
}

