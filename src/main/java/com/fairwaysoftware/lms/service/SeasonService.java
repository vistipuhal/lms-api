package com.fairwaysoftware.lms.service;

import com.fairwaysoftware.lms.repository.SeasonRepository;
import com.fairwaysoftware.lms.service.domain.Season;
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
public class SeasonService {

    private SeasonRepository repository;
    private ModelMapper modelMapper;

    public List<Season> findByLeagueId(@NonNull Integer leagueId) {
        return repository.findByLeagueId(leagueId).stream()
                .map(e -> modelMapper.map(e, Season.class))
                .collect(Collectors.toList());
    }

}
