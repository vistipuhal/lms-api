package com.fairwaysoftware.lms.service;

import com.fairwaysoftware.lms.repository.LeagueRepository;
import com.fairwaysoftware.lms.repository.entity.LeagueEntity;
import com.fairwaysoftware.lms.service.domain.League;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class LeagueService {

    private LeagueRepository repository;
    private ModelMapper modelMapper;

    public List<League> findAll() {
        return repository.findAll().stream()
                .map(e -> modelMapper.map(e, League.class))
                .collect(Collectors.toList());
    }

    public Optional<League> findById(Integer id) {
        return repository.findById(id)
                .map(e -> modelMapper.map(e, League.class));
    }

    @Transactional
    public League save(@Valid League domain) {
        LeagueEntity entity = modelMapper.map(domain, LeagueEntity.class);
        entity = repository.save(entity);
        return modelMapper.map(entity, League.class);
    }

}