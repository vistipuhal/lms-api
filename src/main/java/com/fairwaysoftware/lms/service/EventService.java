package com.fairwaysoftware.lms.service;

import com.fairwaysoftware.lms.repository.EventRepository;
import com.fairwaysoftware.lms.service.domain.Event;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class EventService {

    private EventRepository repository;
    private ModelMapper modelMapper;

    public List<Event> findByLeagueIdAndSeasonId(@NonNull Integer leagueId, @NonNull Integer seasonId) {
        return repository.findByLeagueIdAndSeasonId(leagueId, seasonId).stream()
                .map(e -> modelMapper.map(e, Event.class))
                .collect(Collectors.toList());
    }

}
